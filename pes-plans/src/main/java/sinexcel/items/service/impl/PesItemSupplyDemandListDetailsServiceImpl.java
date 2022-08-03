package sinexcel.items.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.items.mapper.PesItemSupplyDemandListDetailsMapper;
import sinexcel.items.domain.PesItemSupplyDemandListDetails;
import sinexcel.items.service.IPesItemSupplyDemandListDetailsService;

/**
 * 复核项供应和需求明细Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-05-07
 */
@Service
public class PesItemSupplyDemandListDetailsServiceImpl implements IPesItemSupplyDemandListDetailsService 
{
    @Autowired
    private PesItemSupplyDemandListDetailsMapper pesItemSupplyDemandListDetailsMapper;

    /**
     * 查询复核项供应和需求明细列表
     * 
     * @param pesItemSupplyDemandListDetails 复核项供应和需求明细
     * @return 复核项供应和需求明细
     */
    @Override
    public List<PesItemSupplyDemandListDetails> selectPesItemSupplyDemandListDetailsList(PesItemSupplyDemandListDetails pesItemSupplyDemandListDetails)
    {
        return pesItemSupplyDemandListDetailsMapper.selectPesItemSupplyDemandListDetailsList(pesItemSupplyDemandListDetails);
    }
}
