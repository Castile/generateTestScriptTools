package cn.hongliang.data;

/**
 * @author Hongliang Zhu
 * @create 2020-7-24 21:52:11
 */
public class DataConvert {

    public static String[] convert( TestCase testCase){
        String[] row = new String[6];
        row[0] = testCase.getCaseName();
        row[1] = testCase.getCaseDescription();
        row[2] = testCase.getExpectedResult();
        row[3] = testCase.getGIVEN();
        row[4] = testCase.getWHEN();
        row[5] = testCase.getTHEN();

        return row;
    }

}
