package sinexcel.items.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.items.mapper.CuxWieDemandMaterialSumQuantityAllMapper;
import sinexcel.items.domain.CuxWieDemandMaterialSumQuantityAll;
import sinexcel.items.service.ICuxWieDemandMaterialSumQuantityAllService;

/**
 * 工单发料数据汇总Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2022-05-07
 */
@Service
public class CuxWieDemandMaterialSumQuantityAllServiceImpl implements ICuxWieDemandMaterialSumQuantityAllService 
{
    @Autowired
    private CuxWieDemandMaterialSumQuantityAllMapper cuxWieDemandMaterialSumQuantityAllMapper;

    /**
     * 查询工单发料数据汇总列表
     * 
     * @param cuxWieDemandMaterialSumQuantityAll 工单发料数据汇总
     * @return 工单发料数据汇总
     */
    @Override
    public List<CuxWieDemandMaterialSumQuantityAll> selectCuxWieDemandMaterialSumQuantityAllList(CuxWieDemandMaterialSumQuantityAll cuxWieDemandMaterialSumQuantityAll)
    {
        return cuxWieDemandMaterialSumQuantityAllMapper.selectCuxWieDemandMaterialSumQuantityAllList(cuxWieDemandMaterialSumQuantityAll);
    }
}
