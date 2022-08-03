package sinexcel.items.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.items.domain.CuxInvSupplyDemandMaterialSumQuantityAllEO;
import sinexcel.items.mapper.CuxInvSupplyDemandMaterialSumQuantityAllMapper;
import sinexcel.items.service.ICuxInvSupplyDemandMaterialSumQuantityAllService;

import java.util.List;

@Service
public class CuxInvSupplyDemandMaterialSumQuantityAllServiceImpl implements ICuxInvSupplyDemandMaterialSumQuantityAllService {
    @Autowired
    private CuxInvSupplyDemandMaterialSumQuantityAllMapper cuxInvSupplyDemandMaterialSumQuantityAllMapper;


    @Override
    public List<CuxInvSupplyDemandMaterialSumQuantityAllEO> selectCuxInvSupplyDemandMaterialSumQuantityAllList(CuxInvSupplyDemandMaterialSumQuantityAllEO cuxInvSupplyDemandMaterialSumQuantityAllEO)
    {
        return cuxInvSupplyDemandMaterialSumQuantityAllMapper.selectCuxInvSupplyDemandMaterialSumQuantityAllList(cuxInvSupplyDemandMaterialSumQuantityAllEO);
    }
}
