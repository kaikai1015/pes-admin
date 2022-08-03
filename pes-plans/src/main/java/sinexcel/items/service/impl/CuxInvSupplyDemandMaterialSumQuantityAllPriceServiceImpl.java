package sinexcel.items.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.items.domain.CuxInvSupplyDemandMaterialSumQuantityAllPriceEO;
import sinexcel.items.mapper.CuxInvSupplyDemandMaterialSumQuantityAllPriceMapper;
import sinexcel.items.service.ICuxInvSupplyDemandMaterialSumQuantityAllPriceService;

import java.util.List;

@Service
public class CuxInvSupplyDemandMaterialSumQuantityAllPriceServiceImpl implements ICuxInvSupplyDemandMaterialSumQuantityAllPriceService {
    @Autowired
    private CuxInvSupplyDemandMaterialSumQuantityAllPriceMapper cuxInvSupplyDemandMaterialSumQuantityAllPriceMapper;


    @Override
    public List<CuxInvSupplyDemandMaterialSumQuantityAllPriceEO> selectCuxInvSupplyDemandMaterialSumQuantityAllPriceList(CuxInvSupplyDemandMaterialSumQuantityAllPriceEO cuxInvSupplyDemandMaterialSumQuantityAllPriceEO)
    {
        return cuxInvSupplyDemandMaterialSumQuantityAllPriceMapper.selectCuxInvSupplyDemandMaterialSumQuantityAllPriceList(cuxInvSupplyDemandMaterialSumQuantityAllPriceEO);
    }
}
