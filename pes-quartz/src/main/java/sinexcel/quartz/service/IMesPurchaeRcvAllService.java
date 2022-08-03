package sinexcel.quartz.service;

import sinexcel.quartz.domain.MesRcvPurchaseEO;

import java.util.List;

public interface IMesPurchaeRcvAllService {

    /**
     * 查询采购入库接口列表
     *
     * @param mesPurchaeRcvAll 采购入库接口
     * @return 采购入库接口集合
     */
    public List<MesRcvPurchaseEO> selectMesPurchaeRcvAllList(MesRcvPurchaseEO mesPurchaeRcvAll);
}
