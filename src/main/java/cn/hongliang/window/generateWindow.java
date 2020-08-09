package cn.hongliang.window;

import cn.hongliang.data.DataCenter;
import cn.hongliang.data.FileData;
import cn.hongliang.data.TestCase;
import cn.hongliang.generator.DefaultCasesData;
import cn.hongliang.generator.Generator;
import cn.hongliang.generator.MyTestCasesGenerator;
import cn.hongliang.utils.AppendTestCases;
import cn.hongliang.utils.POIUTils;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.util.Consumer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @author Hongliang Zhu
 * @create 2020-07-24 14:38
 */
public class generateWindow {

    private JPanel mainPanel;
    private JTable tab_content;
    private JButton btn_generate;
    private JButton btn_close;
    private JButton importExcel;
    private JButton btn_clear;

//    private ExcelReader excelReader;  // 读取excel

    String excelFileName;



    public JPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * 初始化数据
     */
    private void init(){
        tab_content.setModel(DataCenter.TABLEMODEL);
//        excelReader = new ExcelReader();
        tab_content.setEnabled(true);
    }

    public generateWindow(Project project, ToolWindow toolWindow) {
        init();

        btn_generate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(DataCenter.CASE_LIST.size() == 0){
                        // 没有数据
                        MessageDialogBuilder.YesNo yesNo = MessageDialogBuilder.yesNo("操作结果", "请添加测试用例");
                        yesNo.show();
                        return;
                    }
                    /**
                     * 处理文件导入对应类的绑定
                     */
                    if(DataCenter.FILEDATA == null){
                        // 文件选择器
                        FileChooserDescriptor fileChooserDescriptor = getFileChooserDescriptor(project, "请选择本次测试所对应的类");
                        setClassName(fileChooserDescriptor, project);
                    }
                    // 生成脚本文件
                    generateTestScripts();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btn_close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolWindow.hide(null);

            }
        });
        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataCenter.reset();
            }
        });
        importExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    VirtualFile virtualFile = FileChooser.chooseFile(FileChooserDescriptorFactory.createSingleFileDescriptor(), project, project.getBaseDir());
                    ReadExcelFileOfTestCases(virtualFile);
                }catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        });
    }

    private void generateTestScripts() throws Exception {
        String testFilePath = DataCenter.FILEDATA.getTestFilePath();
        //判断文件夹是否存在
        File file = new File(testFilePath);
        if(!file.exists()){
            Generator generator = new MyTestCasesGenerator();
            generator.process(new DefaultCasesData(DataCenter.CASE_LIST));

        }else{
            // 文件存在--> 追加即可
            AppendTestCases.append(testFilePath, new DefaultCasesData(DataCenter.CASE_LIST));
        }
        // 将里面的测试案例设为true
        for(TestCase testCases: DataCenter.CASE_LIST){
            testCases.setFlag(true);
        }
        gererateNotification("生成测试脚本", "生成脚本成功：" + DataCenter.FILEDATA.getTestFilePath());
    }


    /**
     * 设置为哪个类生成测试脚本
     * @param fileChooserDescriptor
     * @param project
     */
    private void setClassName(FileChooserDescriptor fileChooserDescriptor, Project project) {
        FileChooser.chooseFile(fileChooserDescriptor, project, null, new Consumer<VirtualFile>() {
            @Override
            public void consume(VirtualFile virtualFile) {
//                                Messages.showMessageDialog(project, project.getProjectFilePath(), "Path", Messages.getInformationIcon());

                String name = virtualFile.getName();
                System.out.println(name);
                DataCenter.FILEDATA = new FileData(name, virtualFile.getPath());
            }
        });
    }



    /**
     * 从Excel文件中读取测试案例
     * @param virtualFile
     * @throws Exception
     */
    private void ReadExcelFileOfTestCases(VirtualFile virtualFile) throws Exception {
        if(virtualFile != null){
            String name = virtualFile.getPath();
            System.out.println(name);
//                        EasyExcel.read(name, TestCase.class, new CaseDataListener()).sheet().doRead();
            POIUTils.readExcel(name);
            // 通知
            gererateNotification("导入Excel文件", "导入成功：" + name);
        }
    }

    /**
     * 生成通知
     * @param displayId
     * @param content 通知内容
     */
    private void gererateNotification(String displayId, String content) {
        // 通知
        NotificationGroup notificationGroup = new NotificationGroup(displayId, NotificationDisplayType.BALLOON, true);
        Notification notification = notificationGroup.createNotification(content, MessageType.INFO);
        Notifications.Bus.notify(notification);
    }


    /**
     * 文件选择器
     * @param project
     * @param descriptionPerformed
     * @return 文件选择描述器
     */
    private FileChooserDescriptor getFileChooserDescriptor(Project project, String descriptionPerformed) {
        // 文件选择器
        FileChooserDescriptor fileChooserDescriptor =
                new FileChooserDescriptor(
                        true,
                        false,
                        false,
                        false,
                        false,
                        false
                );
        fileChooserDescriptor.setTitle("请选择文件");
        fileChooserDescriptor.setDescription(descriptionPerformed);
        return fileChooserDescriptor;

    }
}
