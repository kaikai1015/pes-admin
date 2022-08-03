package sinexcel.quartz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.quartz.domain.MesPoReturnVendorAllEO;
import sinexcel.quartz.mapper.MesPoReturnVendorAllMapper;
import sinexcel.quartz.service.IMesPoReturnVendorAllService;

/**
 * 采购退货Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2022-04-12
 */
@Service
public class MesPoReturnVendorAllServiceImpl implements IMesPoReturnVendorAllService 
{
    @Autowired
    private MesPoReturnVendorAllMapper mesPoReturnVendorAllMapper;

    /**
     * 查询采购退货
     * 
     * @param returnVendorId 采购退货ID
     * @return 采购退货
     */
    @Override
    public MesPoReturnVendorAllEO selectMesPoReturnVendorAllById(Long returnVendorId)
    {
        return mesPoReturnVendorAllMapper.selectMesPoReturnVendorAllById(returnVendorId);
    }

    /**
     * 查询采购退货列表
     * 
     * @param mesPoReturnVendorAll 采购退货
     * @return 采购退货
     */
    @Override
    public List<MesPoReturnVendorAllEO> selectMesPoReturnVendorAllList(MesPoReturnVendorAllEO mesPoReturnVendorAll)
    {
        return mesPoReturnVendorAllMapper.selectMesPoReturnVendorAllList(mesPoReturnVendorAll);
    }

}
