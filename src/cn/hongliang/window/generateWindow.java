package cn.hongliang.window;
import cn.hongliang.data.DataCenter;
import cn.hongliang.generator.DefaultCasesData;
import cn.hongliang.generator.Generator;
import cn.hongliang.generator.MyTestCasesGenerator;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.wm.ToolWindow;
import org.jetbrains.annotations.SystemIndependent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public JPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * 初始化数据
     */
    private void init(){
        tab_content.setModel(DataCenter.TABLEMODEL);
        tab_content.setEnabled(true);
    }

    public generateWindow(Project project, ToolWindow toolWindow) {
        init();
        /**
         * 生成测试脚本
         */
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
                    String testFilePath = DataCenter.FILEDATA.getTestFilePath();

                    Generator generator = new MyTestCasesGenerator();
                    generator.process(new DefaultCasesData(DataCenter.CASE_LIST));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                // 通知
                NotificationGroup notificationGroup = new NotificationGroup("testScriptGenerate", NotificationDisplayType.BALLOON, true);
                Notification notification = notificationGroup.createNotification("生成脚本成功：" + DataCenter.FILEDATA.getTestFilePath(), MessageType.INFO);
                Notifications.Bus.notify(notification);

//
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
    }
}
