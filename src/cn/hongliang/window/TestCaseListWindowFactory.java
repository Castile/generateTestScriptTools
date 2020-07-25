package cn.hongliang.window;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import static com.intellij.ui.content.ContentFactory.SERVICE.getInstance;

/**
 * @author Hongliang Zhu
 * @create 2020-07-24 21:55
 */
public class TestCaseListWindowFactory implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {

        // 创建generateWindow对象
        generateWindow casesWindow = new generateWindow(project, toolWindow);

        // 获取内容工厂的实例
        ContentFactory contentFactory = getInstance();
        // 获取用于ToolWindow显示的内容
        Content content = contentFactory.createContent(casesWindow.getMainPanel(), "", false);
        //给toolWindow设置内容
        toolWindow.getContentManager().addContent(content);

    }
}
