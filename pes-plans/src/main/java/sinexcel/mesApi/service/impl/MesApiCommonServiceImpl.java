package sinexcel.mesApi.service.impl;

import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.annotation.DataSource;
import sinexcel.common.enums.DataSourceType;
import sinexcel.daysPlan.domain.MesTransferHeaderAll;
import sinexcel.daysPlan.service.MesTransferHeaderAllService;
import sinexcel.mesApi.domain.MesWarehouseInoutVo;
import sinexcel.mesApi.mapper.MesApiCommonMapper;
import sinexcel.mesApi.mapper.WmsItemTestMapper;
import sinexcel.mesApi.service.IMesApiCommonService;
import sinexcel.works.domain.PesWieWorkOrdersBErp;

import java.util.Date;
import java.util.List;


/**
 * 调用mes 接口
 *
 * @author 1
 * @date
 */
@Service
public class MesApiCommonServiceImpl implements IMesApiCommonService
{
    @Autowired
    MesApiCommonMapper apiCommonMapper;

    @Autowired
    MesTransferHeaderAllService mesTransferHeaderAllService;


    @Autowired
    WmsItemTestMapper wmsItemTestMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    @DataSource(DataSourceType.MES)
    public synchronized int pushTransferOrder(List<MesTransferHeaderAll> list) {
        int flag;
        String dataJson = JSONUtil.toJsonStr(list);
        //获取需要推送的
        flag = apiCommonMapper.pushTransferOrder(dataJson);
        return flag;
    }

//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    @DataSource(DataSourceType.SLAVE)
//    public List<MesWarehouseInoutVo> getMesWarehouseInoutList() {
//        return apiCommonMapper.getMesWarehouseInoutList();
//    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @DataSource(DataSourceType.SLAVE)
    public int getMesWarehouseInoutList(Long inventoryItemId) {
        System.out.println(apiCommonMapper.getMesWarehouseInoutList(inventoryItemId));
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @DataSource(DataSourceType.SLAVE)
    public synchronized int pushTransferOrderTest(PesWieWorkOrdersBErp pesWieWorkOrdersBErp) {
        wmsItemTestMapper.batchSyncInvOnhandQuantityNewCodeTempEO(pesWieWorkOrdersBErp.getInventoryItemId());
        System.out.println(pesWieWorkOrdersBErp.getInventoryItemId());
        return 1;
    }
}
