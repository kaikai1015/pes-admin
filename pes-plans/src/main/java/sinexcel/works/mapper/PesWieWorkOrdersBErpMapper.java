package sinexcel.works.mapper;

import java.util.List;
import sinexcel.works.domain.PesWieWorkOrdersBErp;

/**
 * PES工单管理Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-11-24
 */
public interface PesWieWorkOrdersBErpMapper 
{
    /**
     * 查询PES工单管理
     * 
     * @param pesWorkOrderId PES工单管理ID
     * @return PES工单管理
     */
    public PesWieWorkOrdersBErp selectPesWieWorkOrdersBErpById(Long pesWorkOrderId);

    /**
     * 查询PES工单管理列表
     * 
     * @param pesWieWorkOrdersBErp PES工单管理
     * @return PES工单管理集合
     */
    public List<PesWieWorkOrdersBErp> selectPesWieWorkOrdersBErpList(PesWieWorkOrdersBErp pesWieWorkOrdersBErp);

    /**
     * 修改PES工单管理
     * 
     * @param pesWieWorkOrdersBErp PES工单管理
     * @return 结果
     */
    public int insertPesWieWorkOrdersBErpByWorkOrderMaterialId(PesWieWorkOrdersBErp pesWieWorkOrdersBErp);

    public int updatePesWieWorkOrdersBErp(PesWieWorkOrdersBErp pesWieWorkOrdersBErp);

    /**
     * 删除PES工单管理
     * 
     * @param pesWorkOrderId PES工单管理ID
     * @return 结果
     */
    public List<PesWieWorkOrdersBErp> handleSubmitErpPesWieWorkOrdersBErpByIdsJob();

    public List<PesWieWorkOrdersBErp> updateSubmitErpPesWieWorkOrdersBErpByIdsJob();

    /**
     * 批量删除PES工单管理
     * 
     * @param pesWorkOrderIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePesWieWorkOrdersBErpByIds(PesWieWorkOrdersBErp pesWieWorkOrdersBErp);

    public int insertPesWieWorkOrdersBErp(PesWieWorkOrdersBErp pesWieWorkOrdersBErp);

    public int updatePesWieWorkOrdersBErpByLineNums(Long[] sourceLineNum);


    public int updatePesWieWorkOrdersBErpByWorkOrderId(PesWieWorkOrdersBErp pesWieWorkOrdersBErp);

    public int insertPesWieWorkOrdersBErpByWorkOrderId(PesWieWorkOrdersBErp pesWieWorkOrdersBErp);

    public int insertAddPesWieWorkOrdersBErp(PesWieWorkOrdersBErp pesWieWorkOrdersBErp);

    public PesWieWorkOrdersBErp selectPitemNumberDescriptionByItemOrgIds(PesWieWorkOrdersBErp pesWieWorkOrdersBErp);

    public int updateSubmitDatePesWieWorkOrdersBErp(PesWieWorkOrdersBErp pesWieWorkOrdersBErp);

    public PesWieWorkOrdersBErp selectSourceLinesData(Long sourceLineNum);

    int deletPesWieWorkMaterialByIds(Long pesWorkOrderId);

    PesWieWorkOrdersBErp selectWieWorkCenterId(PesWieWorkOrdersBErp pesWieWorkOrdersBErp);

    PesWieWorkOrdersBErp selectSupplySubinventoryById(PesWieWorkOrdersBErp pesWieWorkOrdersBErp);

    int updatePesWieWorkOrdersBMaterialErpByWorkOrderId(PesWieWorkOrdersBErp pesWieWorkOrdersBErp);

    PesWieWorkOrdersBErp getPitemNumLotControlCodeByIds(PesWieWorkOrdersBErp pesWieWorkOrdersBErp);

    int allowRetormWorksQuantitys(PesWieWorkOrdersBErp pesWieWorkOrdersBErp);

    int updatePesWieWorkMaterialByIds(PesWieWorkOrdersBErp pesWieWorkOrdersBErp);

    int selectCountUpdateOperation(Long pesWorkOrderIds);

    List<PesWieWorkOrdersBErp> selectHandle(PesWieWorkOrdersBErp pesWieWorkOrdersBErp);
}
