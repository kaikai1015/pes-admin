package sinexcel.daysPlan.service;

import java.util.List;
import sinexcel.daysPlan.domain.PesProdLineDaysHeaderAllWW;

/**
 * 日计划Service接口
 *
 * @author Zhang Kai
 * @date 2021-06-07
 */
public interface IPesProdLineDaysHeaderAllWWService
{
    /**
     * 查询日计划
     *
     * @param prodLineFlag 日计划ID
     * @return 日计划
     */
    public PesProdLineDaysHeaderAllWW selectPesProdLineDaysHeaderAllById(Long id);
    /**
     * 查询日计划列表
     *
     * @param pesProdLineDaysHeaderAll 日计划
     * @return 日计划集合
     */
    public List<PesProdLineDaysHeaderAllWW> selectPesProdLineDaysHeaderAllList(PesProdLineDaysHeaderAllWW pesProdLineDaysHeaderAll);

    /**
     * 新增日计划
     *
     * @param pesProdLineDaysHeaderAll 日计划
     * @return 结果
     */
    public int insertPesProdLineDaysHeaderAll(PesProdLineDaysHeaderAllWW pesProdLineDaysHeaderAll);


    /**
     * 批量删除日计划
     *
     * @param id 需要删除的日计划ID
     * @return 结果
     */
    public int deletePesProdLineDaysHeaderAllById(Long id);

}
