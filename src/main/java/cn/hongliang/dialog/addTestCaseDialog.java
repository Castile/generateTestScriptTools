package cn.hongliang.dialog;
import cn.hongliang.data.DataCenter;
import cn.hongliang.data.FileData;
import cn.hongliang.window.AddCaseWindow;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author Hongliang Zhu
 * @create 2020-07-24 16:34
 */
public class addTestCaseDialog extends DialogWrapper {
    private AddCaseWindow addCaseWindow = new AddCaseWindow();

    public addTestCaseDialog(Project project, FileData fileData) {
        super(true);
        setTitle("新增测试用例");
        addCaseWindow.setProject(project);
        addCaseWindow.setFileData(fileData);
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
       return addCaseWindow.getCenterPanel();
    }
    @Override
    protected JComponent createSouthPanel() {
        return addCaseWindow.getSouthPanel();
    }

}
