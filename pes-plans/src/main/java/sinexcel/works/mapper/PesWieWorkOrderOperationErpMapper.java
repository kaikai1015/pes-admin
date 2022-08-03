package sinexcel.works.mapper;

import java.util.List;
import sinexcel.works.domain.PesWieWorkOrderOperationErp;

/**
 * pes自定义工单工序数据Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-11-26
 */
public interface PesWieWorkOrderOperationErpMapper 
{
    /**
     * 查询pes自定义工单工序数据
     * 
     * @param pesWorkOrderId pes自定义工单工序数据ID
     * @return pes自定义工单工序数据
     */
    public List<PesWieWorkOrderOperationErp> selectPesWieWorkOrderOperationErpById(Long pesWorkOrderId);

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
     * @param pesWieWorkOrderOperationErp pes自定义工单工序数据
     * @return 结果
     */
    public int insertPesWieWorkOrderOperationErp(PesWieWorkOrderOperationErp pesWieWorkOrderOperationErp);


    public int updatePesWieWorkOrdersBErpByWorkOrderId(PesWieWorkOrderOperationErp pesWieWorkOrderOperationErp);

    public int insertPesWieWorkOrdersBErpByWorkOrderId(PesWieWorkOrderOperationErp pesWieWorkOrderOperationErp);

    public int updatePesWieWorkOrdersBErpByWorkOrderOperationId(PesWieWorkOrderOperationErp pesWieWorkOrderOperationErp);

    public PesWieWorkOrderOperationErp selectPesWieWorkOrderOperationErp(Long pesWorkOrderId);

    int updatePesWieWorkOrderOperationErp(PesWieWorkOrderOperationErp pesWieWorkOrderOperationErp);

    PesWieWorkOrderOperationErp selectPesWieWorkOrdersOperationErpListById(Long pesWorkOrderId);

    List<PesWieWorkOrderOperationErp> selectUpdatePesWieWorkOrdersOperationErpList();

    int insertResourcePesWieWorkOrderOperationErpByOperationId(Long pesWorkOrderOperationId);

    PesWieWorkOrderOperationErp selectPesWieWorkOrderOperationOspErpById(Long pesWorkOrderOperationId);

    List<PesWieWorkOrderOperationErp> handleSubmitErpPesWieWorkOrdersBErpByIdsJob();
}
