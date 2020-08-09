package cn.hongliang.utils;
import cn.hongliang.data.DataCenter;
import cn.hongliang.data.DataConvert;
import cn.hongliang.data.TestCase;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Hongliang Zhu
 * @create 2020-08-04 11:48

 */

public class CaseDataListener extends AnalysisEventListener<TestCase> {
    private static final Logger LOGGER =  LoggerFactory.getLogger(CaseDataListener.class);


    //    List<TestCase> list = new ArrayList<>();
    public CaseDataListener() {
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context 分析上下文
     */
    @Override
    public void invoke(TestCase data, AnalysisContext context) {
//        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(data));
//        System.out.println("解析到一条数据:" + JSON.toJSONString(data));
        DataCenter.CASE_LIST.add(data);
        DataCenter.TABLEMODEL.addRow(DataConvert.convert(data));

        System.out.println(data);

    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        System.out.println("所有数据解析完成");
    }
    /**
     * 加上存储数据库
     */
    private void saveData() {
        System.out.println(DataCenter.CASE_LIST.size()+ "条数据，开始存储数据库");
//        demoDAO.save(list);

        System.out.println("存储数据库成功！");
    }




}
