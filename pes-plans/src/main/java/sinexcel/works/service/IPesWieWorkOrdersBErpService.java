package sinexcel.works.service;

import java.util.List;
import sinexcel.works.domain.PesWieWorkOrdersBErp;

/**
 * PES工单管理Service接口
 * 
 * @author Zhang Kai
 * @date 2021-11-24
 */
public interface IPesWieWorkOrdersBErpService 
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
    public int updatePesWieWorkOrdersBErp(PesWieWorkOrdersBErp pesWieWorkOrdersBErp);

    /**
     * 批量删除PES工单管理
     * 
     * @param pesWorkOrderIds 需要删除的PES工单管理ID
     * @return 结果
     */
    public int deletePesWieWorkOrdersBErpByIds(Long[] pesWorkOrderIds);

    /**
     * 删除PES工单管理信息
     * 
     * @param pesWorkOrderId PES工单管理ID
     * @return 结果
     */
    public int handleSubmitErpPesWieWorkOrdersBErpByIds(Long[] pesWorkOrderId);

    public int insertPesWieWorkOrdersBErp(Long[] lineNums);

    public int updateErpPesWieWorkOrdersBErpByIds(Long pesWorkOrderIds,String endName);

    public int handleSubmitErpPesWieWorkOrdersBErpByIdsJob(String endName);

    public int updateSubmitErpPesWieWorkOrdersBErpByIdsJob(String endName);

    public int insertAddPesWieWorkOrdersBErp(PesWieWorkOrdersBErp pesWieWorkOrdersBErp);

    public int copyErpPesWieWorkOrdersBErpByIds(Long pesWorkOrderId);

    int releasedWieWorkOrdersBErpByIds(Long[] pesWorkOrderIds);

    List<PesWieWorkOrdersBErp> selectHandle(PesWieWorkOrdersBErp pesWieWorkOrdersBErp);
}
