package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.MesUpdateReceiptRoutingAllEO;

import java.util.List;

public interface MesUpdateReceiptRoutingAllMapper {

    public List<MesUpdateReceiptRoutingAllEO> getUpdateReceiptRoutingList(MesUpdateReceiptRoutingAllEO mesUpdateReceiptRoutingAll);

    public List<MesUpdateReceiptRoutingAllEO> getLinesList(MesUpdateReceiptRoutingAllEO mesUpdateReceiptRoutingAll);

    public int updateErpFlag(MesUpdateReceiptRoutingAllEO mesUpdateReceiptRoutingAll);
}
