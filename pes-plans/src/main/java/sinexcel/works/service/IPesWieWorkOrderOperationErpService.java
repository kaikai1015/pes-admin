package sinexcel.works.service;

import java.util.List;
import sinexcel.works.domain.PesWieWorkOrderOperationErp;

/**
 * pes自定义工单工序数据Service接口
 * 
 * @author Zhang Kai
 * @date 2021-11-26
 */
public interface IPesWieWorkOrderOperationErpService 
{

    /**
     * 查询pes自定义工单工序数据列表
     * 
     * @param pesWieWorkOrderOperationErp pes自定义工单工序数据
     * @return pes自定义工单工序数据集合
     */
    public List<PesWieWorkOrderOperationErp> selectPesWieWorkOrderOperationErpList(PesWieWorkOrderOperationErp pesWieWorkOrderOperationErp);

    /**
     * 新增pes自定义工单工序数据
     * 
     * @param pesWorkOrderId pes自定义工单工序数据
     * @return 结果
     */
    public int insertPesWieWorkOrderOperationErp(Long pesWorkOrderId,String lotNumFlag);


    public int handleSubmitErpPesOperationByIds(Long pesWorkOrderId,String endName);

    boolean selectPesWieWorkOrdersOperationErpListById(Long pesWorkOrderId);

    int updateSubmitErpPesWieWorkOrdersOperationBErpByIdsJob(String endName);

    PesWieWorkOrderOperationErp selectPesWieWorkOrderOperationOspErpById(Long pesWorkOrderOperationId);

    int handleSubmitErpPesWieWorkOrdersBErpByIdsJob(String endName);
}
