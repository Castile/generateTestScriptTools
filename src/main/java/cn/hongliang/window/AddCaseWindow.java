package cn.hongliang.window;

import cn.hongliang.data.DataCenter;
import cn.hongliang.data.DataConvert;
import cn.hongliang.data.FileData;
import cn.hongliang.data.TestCase;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageDialogBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Hongliang Zhu
 * @create 2020-07-24 18:10
 */
public class AddCaseWindow {
    private JPanel addPanel;
    private JButton btn_addCase;
    private JTextField caseNamme;
    private JTextField caseDescription;
    private JTextField expectedResult;
    private JTextField given;
    private JTextField when;
    private JTextField then;
    private JPanel southPanel;
    private JPanel centerPanel;

    private FileData fileData;
    private JPanel northPanel;
    private Project project;

    public void setProject(Project project) {
        this.project = project;
    }
    public FileData getFileData() {
        return fileData;
    }
    public void setFileData(FileData fileData) {
        this.fileData = fileData;
    }
    public JPanel getNorthPanel() {
        return northPanel;
    }
    public JPanel getSouthPanel() {
        return southPanel;
    }
    public JPanel getCenterPanel() {
        return centerPanel;
    }

    public AddCaseWindow() {
        btn_addCase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTestCase();
                MessageDialogBuilder.YesNo yesNo = MessageDialogBuilder.yesNo("操作结果", "添加成功");
                yesNo.show();
            }
        });
    }


    /**
     * 添加一条测试用例并加入到DataCenter
     */
    private void addTestCase() {
        String caseNameText = caseNamme.getText();
        String caseDescriptionText = caseDescription.getText();
        String expectedResultText = expectedResult.getText();
        String givenText = given.getText();
        String whenText = when.getText();
        String thenText = then.getText();
        // 创建一个测试案例类
        TestCase testCase = new TestCase(caseNameText, caseDescriptionText, expectedResultText, givenText, whenText, thenText);
        // 放入数据中心
        DataCenter.CASE_LIST.add(testCase);
        DataCenter.TABLEMODEL.addRow(DataConvert.convert(testCase));
        if(DataCenter.FILEDATA == null){
            DataCenter.FILEDATA = fileData;
        }
    }




}
