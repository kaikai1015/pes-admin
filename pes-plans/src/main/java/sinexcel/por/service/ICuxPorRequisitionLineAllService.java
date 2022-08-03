package sinexcel.por.service;

import java.util.List;
import sinexcel.por.domain.CuxPorRequisitionLineAll;

/**
 * 管理请购行信息Service接口
 * 
 * @author Zhang Kai
 * @date 2021-01-15
 */
public interface ICuxPorRequisitionLineAllService 
{

    /**
     * 查询管理请购行信息列表
     * 
     * @param cuxPorRequisitionLineAll 管理请购行信息
     * @return 管理请购行信息集合
     */
    public List<CuxPorRequisitionLineAll> selectCuxPorRequisitionLineAllList(CuxPorRequisitionLineAll cuxPorRequisitionLineAll);

    /**
     * 批量删除管理请购行信息
     * 
     * @param requisitioningLineIds 需要删除的管理请购行信息ID
     * @return 结果
     */
    public int deleteCuxPorRequisitionLineAllByIds(Long[] requisitioningLineIds);

}
