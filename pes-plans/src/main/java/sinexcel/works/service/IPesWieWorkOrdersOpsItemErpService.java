package sinexcel.works.service;

import java.util.List;
import sinexcel.works.domain.PesWieWorkOrdersOpsItemErp;

/**
 * 工单外协物料对照Service接口
 * 
 * @author Zhang Kai
 * @date 2021-12-13
 */
public interface IPesWieWorkOrdersOpsItemErpService 
{
    /**
     * 查询工单外协物料对照列表
     *
     * @param pesWieWorkOrdersOpsItemErp 工单外协物料对照
     * @return 工单外协物料对照集合
     */
    public List<PesWieWorkOrdersOpsItemErp> selectPesWieWorkOrdersOpsItemErpList(Long pesWorkOrderId);

    public int addPesWieWorkOrdersOpsItemErpById(Long wieOpsItemId,Long pesWorkOrderId);

    List<PesWieWorkOrdersOpsItemErp> getSelectPesWieWorkOrdersOpsItemErpList(PesWieWorkOrdersOpsItemErp pesWieWorkOrdersOpsItemErp);

    /**
     * 查询工单外协物料对照
     *
     * @param wieOpsItemId 工单外协物料对照ID
     * @return 工单外协物料对照
     */
    public PesWieWorkOrdersOpsItemErp selectPesWieWorkOrdersOpsItemErpById(Long wieOpsItemId);

    int updatePesWieWorkOrdersOpsItemErp(PesWieWorkOrdersOpsItemErp pesWieWorkOrdersOpsItemErp);

    int insertPesWieWorkOrdersOpsItemErp(PesWieWorkOrdersOpsItemErp pesWieWorkOrdersOpsItemErp);

    int deletePesWieWorkOrdersOpsItemErpById(Long wieOpsItemIds);

    List<PesWieWorkOrdersOpsItemErp> selectPesWieWorkOrdersOpsItemErpListExport();
}
