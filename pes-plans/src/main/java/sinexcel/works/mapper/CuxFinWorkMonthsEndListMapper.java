package sinexcel.works.mapper;

import java.util.List;
import sinexcel.works.domain.CuxFinWorkMonthsEndList;

/**
 * 月结工单批量操行Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-05-07
 */
public interface CuxFinWorkMonthsEndListMapper 
{
    /**
     * 查询月结工单批量操行列表
     * 
     * @param cuxFinWorkMonthsEndList 月结工单批量操行
     * @return 月结工单批量操行集合
     */
    public List<CuxFinWorkMonthsEndList> selectCuxFinWorkMonthsEndListList(CuxFinWorkMonthsEndList cuxFinWorkMonthsEndList);

    public CuxFinWorkMonthsEndList getWorkDatas(CuxFinWorkMonthsEndList lineList);


    public CuxFinWorkMonthsEndList selectCount(CuxFinWorkMonthsEndList lineList);

    public int insertCuxFinWorkMonthsEndList(List<CuxFinWorkMonthsEndList> list);

    public CuxFinWorkMonthsEndList getMonthsFlag(Long lotNum);

    public int updateErpFlag(CuxFinWorkMonthsEndList lineList);

    int updateErpFlagFalse(CuxFinWorkMonthsEndList lineList);
}
