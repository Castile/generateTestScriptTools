package cn.hongliang.actions;
import cn.hongliang.data.DataCenter;
import cn.hongliang.data.FileData;
import cn.hongliang.dialog.addTestCaseDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.ui.Messages;
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
        // 首先获取编辑器对象
        // 獲取文件的名稱
        String fileName = e.getRequiredData(CommonDataKeys.PSI_FILE).getVirtualFile().getName();
        if(DataCenter.FILEDATA != null && !fileName.equals(DataCenter.FILEDATA.getFileName()) ){
            // 如果当前文件不是指定的测试类，不能添加测试用例
            Messages.showMessageDialog(e.getProject(), "已有测试类:"+DataCenter.FILEDATA.getFileName(), "错误",  Messages.getErrorIcon());
            return;
        }
        String dir = e.getRequiredData(CommonDataKeys.PSI_FILE).getVirtualFile().getPath();
        FileData fileData = new FileData(fileName, dir);
        addTestCaseDialog dialog = new addTestCaseDialog(e.getProject(), fileData);
        dialog.show();
    }
}
