package sinexcel.plans.mapper;

import java.util.List;
import sinexcel.plans.domain.CuxPoLeadTimeList;

/**
 * 采购提前期全表Mapper接口
 * 
 * @author Zhang Kai
 * @date 2020-11-27
 */
public interface CuxPoLeadTimeListMapper 
{

    /**
     * 查询采购提前期全表列表
     * 
     * @param cuxPoLeadTimeList 采购提前期全表
     * @return 采购提前期全表集合
     */
    public List<CuxPoLeadTimeList> selectCuxPoLeadTimeListList(CuxPoLeadTimeList cuxPoLeadTimeList);

    public List<CuxPoLeadTimeList> selectCuxPoLeadTimeListAll();

    /**
     * 新增采购提前期全表
     *
     * @param cuxPoLeadTimeList 采购提前期全表
     * @return 结果
     */
    public int insertCuxPoLeadTimeList(CuxPoLeadTimeList cuxPoLeadTimeList);

    public CuxPoLeadTimeList getItemDescriptions(CuxPoLeadTimeList cuxWieLeadTimeList);


}
