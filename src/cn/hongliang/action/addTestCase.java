package cn.hongliang.action;

import cn.hongliang.data.DataCenter;
import cn.hongliang.data.FileData;
import cn.hongliang.dialog.addTestCaseDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;

/**
 * @author Hongliang Zhu
 * @create 2020-07-24 15:33
 *
 * 为当前类生成测试脚本，添加一条测试用例
 *
 */
public class addTestCase extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here

        // 首先获取编辑器对象
//        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        // 獲取文件的名稱
        String fileName = e.getRequiredData(CommonDataKeys.PSI_FILE).getVirtualFile().getName();
//        DataCenter.FILE_NAME = fileName;
        String dir = e.getRequiredData(CommonDataKeys.PSI_FILE).getVirtualFile().getPath();
        // 路径：F:/java/tdd/cleancode-master/cleancode-master/src/test/java/zhangyi/framework/mockito/RosterTest.java

        FileData fileData = new FileData(fileName, dir);
        DataCenter.FILEDATA = fileData;

        addTestCaseDialog dialog = new addTestCaseDialog(e.getProject(), fileData);
        dialog.show();
    }
}
