package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.MesRcvPurchaseEO;

import java.util.List;

public interface MesRcvPurchaseMapper {

    /**
     * 查询入库信息列表
     *
     * @param rcvPurchaseEO 入库信息
     * @return 入库信息集合
     */
    public List<MesRcvPurchaseEO> getRcvPurchaseList(MesRcvPurchaseEO rcvPurchaseEO);

    public int updateErpFlag(MesRcvPurchaseEO rcvPurchaseEO);

    /**
     * 查询采购入库接口列表
     *
     * @param mesPurchaeRcvAll 采购入库接口
     * @return 采购入库接口集合
     */
    public List<MesRcvPurchaseEO> selectMesPurchaeRcvAllList(MesRcvPurchaseEO mesPurchaeRcvAll);
}
