package sinexcel.works.service;

import java.util.List;
import sinexcel.works.domain.CuxFinWorkMonthsEndList;

/**
 * 月结工单批量操行Service接口
 * 
 * @author Zhang Kai
 * @date 2021-05-07
 */
public interface ICuxFinWorkMonthsEndListService 
{

    /**
     * 查询月结工单批量操行列表
     * 
     * @param cuxFinWorkMonthsEndList 月结工单批量操行
     * @return 月结工单批量操行集合
     */
    public List<CuxFinWorkMonthsEndList> selectCuxFinWorkMonthsEndListList(CuxFinWorkMonthsEndList cuxFinWorkMonthsEndList);

    public String importData(List<CuxFinWorkMonthsEndList> lineLists, Long lotNum,String operName);

    public int getHandleWieErp(Long lotNum);
}
