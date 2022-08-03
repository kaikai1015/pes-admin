package sinexcel.weeks.mapper;

import java.util.List;
import sinexcel.weeks.domain.CuxWorkOrdersBCheckW;

/**
 * 周计划导入Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-03-11
 */
public interface CuxWorkOrdersBCheckWMapper 
{

    /**
     * 查询周计划导入列表
     * 
     * @param cuxWorkOrdersBCheckW 周计划导入
     * @return 周计划导入集合
     */
    public List<CuxWorkOrdersBCheckW> selectCuxWorkOrdersBCheckWList(CuxWorkOrdersBCheckW cuxWorkOrdersBCheckW);

    /**
     *是否存在这条数据
     * @return 用户对象信息
     */
    public CuxWorkOrdersBCheckW selectCount(CuxWorkOrdersBCheckW weeksList);

    /**
     * 新增周计划导入
     *
     * @param list 周计划导入
     * @return 结果
     */
    public int insertCuxWorkOrdersBCheckW(List<CuxWorkOrdersBCheckW> list);

}
