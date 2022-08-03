package sinexcel.mesApi.mapper;

import org.apache.ibatis.annotations.Param;
import sinexcel.common.annotation.DataSource;
import sinexcel.common.enums.DataSourceType;
import sinexcel.mesApi.domain.MesWarehouseInoutVo;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 生产日计划调拨明细单 Mapper 接口
 * </p>
 *
 * @author mingshen.wang
 * @since 2021-08-27
 */
public interface MesApiCommonMapper {


    int pushTransferOrder(@Param("dataJson") String dataJson);
    /**
     * @Author mingshen.wang
     * @Description 根据时间段获取出入库记录
     * @Date 17:32 2021/9/6
     * @Param [sTime, eTime]
     * @return java.util.List<sinexcel.mesApi.domain.MesWarehouseInoutVo>
     **/
    int getMesWarehouseInoutList(Long inventoryItemId);
}
