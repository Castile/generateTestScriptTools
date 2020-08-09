package cn.hongliang.data;
import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @author Hongliang Zhu
 * @create 2020-07-24 15:35
 */

//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class TestCase {

    /**
     * 是否已经生成了测试脚本，主要是为后面追加使用
     */
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * 案例名称 :
     */
    @ExcelProperty("案例名称")
    private String caseName;
    /**
     * 案例描述（GIVEN、WHEN）
     */
    @ExcelProperty("案例描述")
    private String caseDescription;
    /**
     * 预期结果 （THEN）
     */
    @ExcelProperty("预期结果")
    private String expectedResult;

    public TestCase() {
        this.flag = false;
    }

    /**
     * 表达式
     */
    @ExcelProperty("GIVEN")
    private String GIVEN;
    @ExcelProperty("WHEN")
    private String WHEN;
    @ExcelProperty("THEN")
    private String THEN;

    public TestCase(String caseName, String caseDescription, String expectedResult, String GIVEN, String WHEN, String THEN) {
        this.caseName = caseName;
        this.caseDescription = caseDescription;
        this.expectedResult = expectedResult;
        this.GIVEN = GIVEN;
        this.WHEN = WHEN;
        this.THEN = THEN;
    }

    //    public TestCase(String caseNameText, String caseDescriptionText, String expectedResultText, String givenText, String whenText, String thenText) {
//
//    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getCaseDescription() {
        return caseDescription;
    }

    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public String getGIVEN() {
        return GIVEN;
    }

    public void setGIVEN(String GIVEN) {
        this.GIVEN = GIVEN;
    }

    public String getWHEN() {
        return WHEN;
    }

    public void setWHEN(String WHEN) {
        this.WHEN = WHEN;
    }

    public String getTHEN() {
        return THEN;
    }

    public void setTHEN(String THEN) {
        this.THEN = THEN;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "caseName='" + caseName + '\'' +
                ", caseDescription='" + caseDescription + '\'' +
                ", expectedResult='" + expectedResult + '\'' +
                ", GIVEN='" + GIVEN + '\'' +
                ", WHEN='" + WHEN + '\'' +
                ", THEN='" + THEN + '\'' +
                '}';
    }
}
