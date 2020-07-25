package cn.hongliang.data;
/**
 * @author Hongliang Zhu
 * @create 2020-07-24 15:35
 */
public class TestCase {

    public FileData getFileData() {
        return fileData;
    }

    public void setFileData(FileData fileData) {
        this.fileData = fileData;
    }

    /**
     * 封账了生成测试脚本的文件名和路径
     */
    private FileData fileData;

    /**
     * 案例名称 :
     */
    private String caseName;
    /**
     * 案例描述（GIVEN、WHEN）
     */
    private String caseDescription;
    /**
     * 预期结果 （THEN）
     */
    private String expectedResult;


    /**
     * 表达式
     */
    private String GIVEN;
    private String WHEN;
    private String THEN;

    public void setGIVEN(String GIVEN) {
        this.GIVEN = GIVEN;
    }

    public void setWHEN(String WHEN) {
        this.WHEN = WHEN;
    }

    public void setTHEN(String THEN) {
        this.THEN = THEN;
    }

    public TestCase(String caseName, String caseDescription, String expectedResult, String GIVEN, String WHEN, String THEN) {
        this.caseName = caseName;
        this.caseDescription = caseDescription;
        this.expectedResult = expectedResult;
        this.GIVEN = GIVEN;
        this.WHEN = WHEN;
        this.THEN = THEN;
    }

    /**
     * 生成GIVEN、WHEN、THEN 表达式
     */
//    public void generateExpress(){
//
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

    public String getWHEN() {
        return WHEN;
    }

    public String getTHEN() {
        return THEN;
    }
}
