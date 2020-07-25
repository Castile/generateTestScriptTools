package cn.hongliang.generator;
import cn.hongliang.data.TestCase;
import java.util.List;

/**
 * @author Hongliang Zhu
 * @create 2020-07-24 23:28
 */
public class DefaultCasesData implements CasesData {

//    private String fileName;
    private List<TestCase> testCases;

//    @Override
//    public String getTestFileName() {
//        return null;
//    }


    public DefaultCasesData(List<TestCase> testCases) {
        this.testCases = testCases;
    }

    @Override
    public List<TestCase> getTestCases() {
        return testCases;
    }
}
