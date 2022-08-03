package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.MesRmaOrderDeliverAllEO;

import java.util.List;

public interface MesRmaOrderDeliverAllMapper {

    public List<MesRmaOrderDeliverAllEO> getRmaOrderDeliverLists(MesRmaOrderDeliverAllEO mesRmaOrderDeliverAll);

    public MesRmaOrderDeliverAllEO getReceiptAdviceID(MesRmaOrderDeliverAllEO mesRmaOrderDeliverAll);

    public int updateErpFlag(MesRmaOrderDeliverAllEO mesRmaOrderDeliverAll);
}
