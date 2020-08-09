package cn.hongliang.data;
import lombok.Data;

/**
 * @author Hongliang Zhu
 * @create 2020-07-24 21:08
 */
@Data
public class FileData {
    private String fileName;
    private String absFilePath;
    private String PackageName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getAbsFilePath() {
        return absFilePath;
    }

    public void setAbsFilePath(String absFilePath) {
        this.absFilePath = absFilePath;
    }

    public String getPackageName() {
        return PackageName;
    }

    public void setPackageName(String packageName) {
        PackageName = packageName;
    }

    public String getTestFilePath() {
        return testFilePath;
    }

    public void setTestFilePath(String testFilePath) {
        this.testFilePath = testFilePath;
    }

    public String getTestFileName() {
        return testFileName;
    }

    public void setTestFileName(String testFileName) {
        this.testFileName = testFileName;
    }

    private String testFilePath;
    private String testFileName;


    public FileData(String fileName, String absFilePath ) {

        this.fileName = fileName;
        this.absFilePath = absFilePath;
//        this.testFilePath = absFilePath.substring(absFilePath.indexOf("src") + 3).replace("main", "test").replace(".java", "Test.java");
        this.testFilePath = absFilePath.replace("main", "test").replace(".java", "Test.java");

        String packagePath = testFilePath.substring(testFilePath.indexOf("src") + 3, testFilePath.lastIndexOf("/"));
        String pkgname = packagePath.substring(packagePath.indexOf("java") + 5);

        this.PackageName =  pkgname.replace("/",".");
        this.testFileName = fileName.replace(".java","Test.java");


    }

}
