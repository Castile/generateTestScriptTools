package cn.hongliang.generator;

/**
 * @author Hongliang Zhu
 * @create 2020-07-24 22:39
 */
public interface Generator {
    void process(CasesData casesData) throws Exception;
}
