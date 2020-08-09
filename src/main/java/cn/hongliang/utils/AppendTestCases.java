package cn.hongliang.utils;

import cn.hongliang.data.TestCase;
import cn.hongliang.generator.CasesData;

import java.util.List;

/**
 * @author Hongliang Zhu
 * @create 2020-08-09 16:27
 */
public class AppendTestCases {

    public static final String enter = "\n";
    public static final String enter2 = "\n \n";

    public static final String tab = "\t";
    public static final String space4 = "\t\t";
    public static final String space8 = "\t\t\t";
    public static final String space12 = "\t\t\t\t";

    /**
     * 继续追加测试方法
     * @param fileName test脚本文件路径
     * @param casesData
     */
    public static void append(String fileName, CasesData casesData){
        //设置新测试用例的格式

        StringBuilder sb = new StringBuilder();
        List<TestCase> testCases = casesData.getTestCases();
        for(TestCase testCase : testCases){
            if(!testCase.isFlag()){
                String anno = tab +"/**\n" +
                        tab+"*<em> "+ testCase.getCaseDescription()+"</em>\n" +
                        tab+"* @GIVEN "+ testCase.getGIVEN()+"\n" +
                        tab+"* @WHEN  "+ testCase.getWHEN()+"\n" +
                        tab+"* @THEN "+testCase.getTHEN()+"\n" +
                        tab+"*/"+enter;
                sb.append(anno);
                sb.append(tab+"@Test"+enter);
                sb.append(tab);
                sb.append("public void should_"+ testCase.getTHEN() +"_given_"+testCase.getGIVEN()+"()");
                sb.append("{");
                sb.append(enter2);
                sb.append(tab);
                sb.append("}");
                sb.append(enter);

            }
        }

        // 插入源文件指定位置
        InsertContent ic = new InsertContent(fileName, sb.toString());
        ic.insertCon();
    }

}
