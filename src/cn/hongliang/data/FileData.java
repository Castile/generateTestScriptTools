package cn.hongliang.data;

/**
 * @author Hongliang Zhu
 * @create 2020-07-24 21:08
 */
public class FileData {
    private String fileName;
    private String absFilePath;

    public String getPackageName() {
        return PackageName;
    }

    private String PackageName;

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


    public String getTestFilePath() {
        return testFilePath;
    }

    public String getTestFileName() {
        return testFileName;
    }




}
