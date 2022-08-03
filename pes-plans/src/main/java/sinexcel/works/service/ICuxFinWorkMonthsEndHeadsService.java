package sinexcel.works.service;

import java.util.List;
import sinexcel.works.domain.CuxFinWorkMonthsEndHeads;

/**
 * 月结工单操作Service接口
 * 
 * @author Zhang Kai
 * @date 2021-05-07
 */
public interface ICuxFinWorkMonthsEndHeadsService 
{
    /**
     * 查询月结工单操作列表
     * 
     * @param cuxFinWorkMonthsEndHeads 月结工单操作
     * @return 月结工单操作集合
     */
    public List<CuxFinWorkMonthsEndHeads> selectCuxFinWorkMonthsEndHeadsList(CuxFinWorkMonthsEndHeads cuxFinWorkMonthsEndHeads);

    /**
     * 新增月结工单操作
     * 
     * @param cuxFinWorkMonthsEndHeads 月结工单操作
     * @return 结果
     */
    public int insertCuxFinWorkMonthsEndHeads(CuxFinWorkMonthsEndHeads cuxFinWorkMonthsEndHeads);

    public void checkAddAllowed(Long lotNum);

    /**
     * 批量删除月结工单操作
     * 
     * @param lotNums 需要删除的月结工单操作ID
     * @return 结果
     */
    public int deleteCuxFinWorkMonthsEndHeadsByIds(Long lotNums);

    public void checkDeletellowed(Long lotNum);
}
