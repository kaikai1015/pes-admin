package sinexcel.items.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.items.mapper.CuxWieSupplyMaterialSumQuantityAllMapper;
import sinexcel.items.domain.CuxWieSupplyMaterialSumQuantityAll;
import sinexcel.items.service.ICuxWieSupplyMaterialSumQuantityAllService;

/**
 * 工单入库数据汇总Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2022-05-07
 */
@Service
public class CuxWieSupplyMaterialSumQuantityAllServiceImpl implements ICuxWieSupplyMaterialSumQuantityAllService 
{
    @Autowired
    private CuxWieSupplyMaterialSumQuantityAllMapper cuxWieSupplyMaterialSumQuantityAllMapper;

    /**
     * 查询工单入库数据汇总列表
     * 
     * @param cuxWieSupplyMaterialSumQuantityAll 工单入库数据汇总
     * @return 工单入库数据汇总
     */
    @Override
    public List<CuxWieSupplyMaterialSumQuantityAll> selectCuxWieSupplyMaterialSumQuantityAllList(CuxWieSupplyMaterialSumQuantityAll cuxWieSupplyMaterialSumQuantityAll)
    {
        return cuxWieSupplyMaterialSumQuantityAllMapper.selectCuxWieSupplyMaterialSumQuantityAllList(cuxWieSupplyMaterialSumQuantityAll);
    }

}
