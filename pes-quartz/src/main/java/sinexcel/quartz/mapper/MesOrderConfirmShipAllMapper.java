package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.MesOrderConfirmShipAllEO;

import java.util.List;

/**
 * MES销售发运回写ERPMapper接口
 *
 * @author Zhang Kai
 * @date 2021-03-04
 */
public interface MesOrderConfirmShipAllMapper {

    public List<MesOrderConfirmShipAllEO> getOrderConfirmShipAllList(MesOrderConfirmShipAllEO mesOrderConfirmShipAll);

    public int updateErpFlag(MesOrderConfirmShipAllEO mesOrderConfirmShipAll);

}
