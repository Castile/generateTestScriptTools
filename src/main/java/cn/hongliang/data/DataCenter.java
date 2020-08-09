package cn.hongliang.data;

import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Hongliang Zhu
 * @create 2020-07-22 20:13
 */
public class DataCenter {

    public static List<TestCase> CASE_LIST = new LinkedList<>();
    public static FileData FILEDATA;

    public static String[] TABLE_HEADER = {"案例名称", "案例描述", "预期结果", "GIVEN", "WHEN", "THEN"};
    public static DefaultTableModel TABLEMODEL = new DefaultTableModel(null, TABLE_HEADER);

    /***
     * 清空数据
     */
    public static void reset(){
        CASE_LIST.clear();
        FILEDATA = null;
        TABLEMODEL.setDataVector(null, TABLE_HEADER);
    }


}

