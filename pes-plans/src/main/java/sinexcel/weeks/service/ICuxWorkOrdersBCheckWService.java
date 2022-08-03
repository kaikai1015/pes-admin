package sinexcel.weeks.service;

import java.util.List;
import sinexcel.weeks.domain.CuxWorkOrdersBCheckW;

/**
 * 周计划导入Service接口
 * 
 * @author Zhang Kai
 * @date 2021-03-11
 */
public interface ICuxWorkOrdersBCheckWService 
{

    /**
     * 查询周计划导入列表
     * 
     * @param cuxWorkOrdersBCheckW 周计划导入
     * @return 周计划导入集合
     */
    public List<CuxWorkOrdersBCheckW> selectCuxWorkOrdersBCheckWList(CuxWorkOrdersBCheckW cuxWorkOrdersBCheckW);

    /**
     * 导入数据
     *
     * @param weeksLists 用户数据列表
     * @param operName 操作用户
     * @return 结果
     */
    public String importData(List<CuxWorkOrdersBCheckW> weeksLists, String operName);
}
