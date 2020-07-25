package cn.hongliang.generator;

import freemarker.template.Template;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;

/**
 * 使用freemaker模板引擎生成测试脚本代码
 * @author Hongliang Zhu
 * @create 2020-07-24 22:45
 */
public abstract class AbstractFreeMarkerGenerator implements Generator{


    /**
     * 生成test脚本的处理流程
     * @return
     */
    protected abstract Object getModel(CasesData casesData); // 获取数据

    protected abstract Template getTemplate() throws IOException, Exception;  // 获取模板

    protected abstract Writer getWriter(CasesData casesData) throws FileNotFoundException, Exception; // 写到哪里


    /**
     * 模板方法
     * @param casesData
     * @throws Exception
     */
    @Override
    public void process(CasesData casesData) throws Exception {
        Template template = getTemplate();
        Object model = getModel(casesData);
        Writer writer = getWriter(casesData);
        template.process(model, writer);
    }
}
