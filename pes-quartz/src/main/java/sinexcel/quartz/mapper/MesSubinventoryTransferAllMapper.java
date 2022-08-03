package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.MesSubinventoryTransferAllEO;

import java.util.List;

public interface MesSubinventoryTransferAllMapper {

    /**
     * 调拨子库存转移信息列表
     *
     * @param subinventoryTransferAll 入库信息
     * @return 调拨子库存转移集合
     */
    public List<MesSubinventoryTransferAllEO> getSubinvTranferList(MesSubinventoryTransferAllEO subinventoryTransferAll);

    public int updateErpFlag(MesSubinventoryTransferAllEO subinventoryTransferAll);

    /**
     * 查询调拨子库存转移列表
     *
     * @param mesSubinventoryTransferAll 调拨子库存转移
     * @return 调拨子库存转移集合
     */
    public List<MesSubinventoryTransferAllEO> selectMesSubinventoryTransferAllList(MesSubinventoryTransferAllEO mesSubinventoryTransferAll);

    int updateWieItemMaterialsTransferQuantityByIds(MesSubinventoryTransferAllEO subTrnList);

    int getCount(MesSubinventoryTransferAllEO subTrnList);

    MesSubinventoryTransferAllEO selectTransferedQuantity(MesSubinventoryTransferAllEO subTrnList);

    int updateWieItemMaterialsIssuedQuantityByIds(MesSubinventoryTransferAllEO subTrnList);

    int updateWieItemReturnMaterialsTransferQuantityByIds(MesSubinventoryTransferAllEO subTrnList);

    int updateWieItemReturnMaterialsIssuedQuantityByIds(MesSubinventoryTransferAllEO subTrnList);
}
