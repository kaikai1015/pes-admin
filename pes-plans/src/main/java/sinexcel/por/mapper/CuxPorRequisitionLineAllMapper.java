package sinexcel.por.mapper;

import java.util.List;
import sinexcel.por.domain.CuxPorRequisitionLineAll;

/**
 * 管理请购行信息Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-01-15
 */
public interface CuxPorRequisitionLineAllMapper 
{
    /**
     * 查询管理请购行信息列表
     * 
     * @param cuxPorRequisitionLineAll 管理请购行信息
     * @return 管理请购行信息集合
     */
    public List<CuxPorRequisitionLineAll> selectCuxPorRequisitionLineAllList(CuxPorRequisitionLineAll cuxPorRequisitionLineAll);

    /**
     * 新增管理请购行信息
     * 
     * @param cuxPorRequisitionLineAll 管理请购行信息
     * @return 结果
     */
    public int insertCuxPorRequisitionLineAll(CuxPorRequisitionLineAll cuxPorRequisitionLineAll);


    /**
     * 批量删除管理请购行信息
     * 
     * @param requisitioningLineIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCuxPorRequisitionLineAllByIds(Long[] requisitioningLineIds);

    /**
     * 查询维护采购计划
     *
     * @param lineNum 维护采购计划ID
     * @return 维护采购计划
     */
    public CuxPorRequisitionLineAll selectCuxPorRequisitionLineAllById(Long lineNum);

    public CuxPorRequisitionLineAll selectMaxLine(Long requisitioningId);

    public int delCuxPorRequisitionLineAll(Long lineNum);

}
