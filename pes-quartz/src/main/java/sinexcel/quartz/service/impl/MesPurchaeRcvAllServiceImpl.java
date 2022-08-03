package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.quartz.domain.MesRcvPurchaseEO;
import sinexcel.quartz.mapper.MesRcvPurchaseMapper;
import sinexcel.quartz.service.IMesPurchaeRcvAllService;

import java.util.List;

/**
 * 采购入库接口Service业务层处理
 *
 * @author Zhang Kai
 * @date 2021-07-22
 */
@Service
public class MesPurchaeRcvAllServiceImpl implements IMesPurchaeRcvAllService {
    @Autowired
    private MesRcvPurchaseMapper mesPurchaeRcvAllMapper;

    /**
     * 查询采购入库接口列表
     *
     * @param mesPurchaeRcvAll 采购入库接口
     * @return 采购入库接口
     */
    @Override
    public List<MesRcvPurchaseEO> selectMesPurchaeRcvAllList(MesRcvPurchaseEO mesPurchaeRcvAll)
    {
        return mesPurchaeRcvAllMapper.selectMesPurchaeRcvAllList(mesPurchaeRcvAll);
    }
}
