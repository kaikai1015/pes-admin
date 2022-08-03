package sinexcel.items.service;

import java.util.List;
import sinexcel.items.domain.CuxWieLeadTimeList;

/**
 * 生产提前期Service接口
 * 
 * @author Zhang Kai
 * @date 2020-11-30
 */
public interface ICuxWieLeadTimeListService 
{

    /**
     * 查询生产提前期列表
     * 
     * @param cuxWieLeadTimeList 生产提前期
     * @return 生产提前期集合
     */
    public List<CuxWieLeadTimeList> selectCuxWieLeadTimeListList(CuxWieLeadTimeList cuxWieLeadTimeList);

    /**
     * 新增生产提前期
     *
     * @param cuxWieLeadTimeList 生产提前期
     * @return 结果
     */
    public int insertCuxWieLeadTimeList(CuxWieLeadTimeList cuxWieLeadTimeList);
}
