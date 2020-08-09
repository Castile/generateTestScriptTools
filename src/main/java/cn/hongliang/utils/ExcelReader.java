package cn.hongliang.utils;
import cn.hongliang.data.TestCase;
import com.alibaba.excel.EasyExcel;


/**
 * @author Hongliang Zhu
 * @create 2020-08-04 13:10
 *
 * 读取Excel的工具类
 */
public class ExcelReader{

    public ExcelReader(){}

    /**
     * 读取的结果
     */
//    private TestCase testCase;
//    public ExcelReader(TestCase testCase){
//        this.testCase = testCase;
//    }

    /**
     * 最简单的读
     * <p>1. 创建excel对应的实体对象 参照{@link TestCase}
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link CaseDataListener}
     * <p>3. 直接读即可
     */
    public void simpleRead(String fileName) {

        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, TestCase.class, new CaseDataListener()).sheet().doRead();
    }

    /**
     * 读多个或者全部sheet,这里注意一个sheet不能读取多次，多次读取需要重新读取文件
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link TestCase}
     * <p>
     * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link CaseDataListener}
     * <p>
     * 3. 直接读即可
     */

    public void repeatedRead(String fileName) {
        // 读取全部sheet
        // 这里需要注意 DemoDataListener的doAfterAllAnalysed 会在每个sheet读取完毕后调用一次。然后所有sheet都会往同一个DemoDataListener里面写
        EasyExcel.read(fileName, TestCase.class, new CaseDataListener()).doReadAll();
    }





}
