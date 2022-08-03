package sinexcel.mesApi.service;

import sinexcel.daysPlan.domain.MesTransferHeaderAll;
import sinexcel.mesApi.domain.MesWarehouseInoutVo;
import sinexcel.works.domain.PesWieWorkOrdersBErp;

import java.util.Date;
import java.util.List;

/**
 * 调用mes 接口
 * 
 * @author 1
 * @date
 */
public interface IMesApiCommonService {

    /**
     * @Author mingshen.wang
     * @Description 把中间表数据推送到wms
     * @Date 14:44 2021/9/3
     * @Param [ids]
     * @return boolean
     **/
    int pushTransferOrder(List<MesTransferHeaderAll> ids);

    int pushTransferOrderTest(PesWieWorkOrdersBErp ids);

    int getMesWarehouseInoutList(Long inventoryItemId);
    /**
     * @Author mingshen.wang
     * @Description 根据时间段获取出入库记录
     * @Date 17:32 2021/9/6
     * @Param [sTime, eTime]
     * @return java.util.List<sinexcel.mesApi.domain.MesWarehouseInoutVo>
     **/
//    List<MesWarehouseInoutVo> getMesWarehouseInoutList();
}
