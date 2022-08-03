package sinexcel.quartz.service;

import sinexcel.quartz.domain.MesPoReturnVendorAllEO;

import java.util.List;

/**
 * 采购退货Service接口
 * 
 * @author Zhang Kai
 * @date 2022-04-12
 */
public interface IMesPoReturnVendorAllService 
{
    /**
     * 查询采购退货
     * 
     * @param returnVendorId 采购退货ID
     * @return 采购退货
     */
    public MesPoReturnVendorAllEO selectMesPoReturnVendorAllById(Long returnVendorId);

    /**
     * 查询采购退货列表
     * 
     * @param mesPoReturnVendorAll 采购退货
     * @return 采购退货集合
     */
    public List<MesPoReturnVendorAllEO> selectMesPoReturnVendorAllList(MesPoReturnVendorAllEO mesPoReturnVendorAll);

}
