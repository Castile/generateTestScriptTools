package cn.hongliang.generator;
import cn.hongliang.data.DataCenter;
import cn.hongliang.utils.FileUtils;
import com.intellij.ide.fileTemplates.impl.UrlUtil;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hongliang Zhu
 * @create 2020-07-24 22:44
 */
public class MyTestCasesGenerator extends AbstractFreeMarkerGenerator{

    @Override
    protected Object getModel(CasesData casesData) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String createTime = dateTimeFormatter.format(now);

        Map<String, Object> model = new HashMap<>();
        model.put("packageName", DataCenter.FILEDATA.getPackageName());
        model.put("testCases", casesData.getTestCases());
        model.put("fileName", DataCenter.FILEDATA.getTestFileName().replace(".java", ""));
        model.put("createDateTime",  createTime);

        return model;
    }

    @Override
    protected Template getTemplate() throws Exception {

        // 创建模板配置
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);

        // 加载模板字符串
        String templateContent = UrlUtil.loadText(MyTestCasesGenerator.class.getResource("/template/t1.ftl"));
        // 创建字符串模板导入器
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        // 导入字符串模板
        stringTemplateLoader.putTemplate("Testemplate", templateContent);
        configuration.setTemplateLoader(stringTemplateLoader);

        // 获取模板
        return configuration.getTemplate("Testemplate");
    }

    @Override
    protected Writer getWriter(CasesData casesData) throws Exception {
        String testFilePath = DataCenter.FILEDATA.getTestFilePath();
        File testScripts = FileUtils.mkdir(testFilePath);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(testScripts), "utf-8"));
        return bufferedWriter;

//        PrintWriter printWriter = new PrintWriter(System.out);
//        return printWriter;

    }
}
