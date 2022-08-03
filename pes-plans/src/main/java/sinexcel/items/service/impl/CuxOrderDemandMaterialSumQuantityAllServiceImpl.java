package sinexcel.items.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.items.mapper.CuxOrderDemandMaterialSumQuantityAllMapper;
import sinexcel.items.domain.CuxOrderDemandMaterialSumQuantityAll;
import sinexcel.items.service.ICuxOrderDemandMaterialSumQuantityAllService;

/**
 * 工单已发料数据汇总Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2022-05-07
 */
@Service
public class CuxOrderDemandMaterialSumQuantityAllServiceImpl implements ICuxOrderDemandMaterialSumQuantityAllService 
{
    @Autowired
    private CuxOrderDemandMaterialSumQuantityAllMapper cuxOrderDemandMaterialSumQuantityAllMapper;

    /**
     * 查询工单已发料数据汇总列表
     * 
     * @param cuxOrderDemandMaterialSumQuantityAll 工单已发料数据汇总
     * @return 工单已发料数据汇总
     */
    @Override
    public List<CuxOrderDemandMaterialSumQuantityAll> selectCuxOrderDemandMaterialSumQuantityAllList(CuxOrderDemandMaterialSumQuantityAll cuxOrderDemandMaterialSumQuantityAll)
    {
        return cuxOrderDemandMaterialSumQuantityAllMapper.selectCuxOrderDemandMaterialSumQuantityAllList(cuxOrderDemandMaterialSumQuantityAll);
    }
}
