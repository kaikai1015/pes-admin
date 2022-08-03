package sinexcel.por.service;

import java.util.List;
import sinexcel.por.domain.CuxPorRequisitionHeaderAll;

/**
 * 管理请购单Service接口
 * 
 * @author Zhang Kai
 * @date 2020-12-30
 */
public interface ICuxPorRequisitionHeaderAllService 
{

    /**
     * 查询管理请购单列表
     * 
     * @param cuxPorRequisitionHeaderAll 管理请购单
     * @return 管理请购单集合
     */
    public List<CuxPorRequisitionHeaderAll> selectCuxPorRequisitionHeaderAllList(CuxPorRequisitionHeaderAll cuxPorRequisitionHeaderAll);

    /**
     * 新增管理请购单
     * 
     * @param cuxPorRequisitionHeaderAll 管理请购单
     * @return 结果
     */
    public int insertCuxPorRequisitionHeaderAll(CuxPorRequisitionHeaderAll cuxPorRequisitionHeaderAll);

    /**
     * 查询管理请购单
     *
     * @param requisitioningId 管理请购单ID
     * @return 管理请购单
     */
    public CuxPorRequisitionHeaderAll selectCuxPorRequisitionHeaderAllById(Long requisitioningId);

    /**
     * 修改管理请购单
     *
     * @param cuxPorRequisitionHeaderAll 管理请购单
     * @return 结果
     */
    public int updateCuxPorRequisitionHeaderAll(CuxPorRequisitionHeaderAll cuxPorRequisitionHeaderAll);

}
