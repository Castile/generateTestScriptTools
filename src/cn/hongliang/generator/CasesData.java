package cn.hongliang.generator;


import cn.hongliang.data.TestCase;

import java.util.List;

/**
 * @author Hongliang Zhu
 * @create 2020-07-24 22:41
 */
public interface CasesData {

    /**
     * 获取测试文件名
     * @return
     */
//    String getTestFileName();

    /**
     * 获取测试用例
     * @return
     */
    List<TestCase> getTestCases();

}
