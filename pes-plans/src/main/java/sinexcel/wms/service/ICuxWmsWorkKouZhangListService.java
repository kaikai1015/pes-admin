package sinexcel.wms.service;

import java.util.List;
import sinexcel.wms.domain.CuxWmsWorkKouZhangList;

/**
 * WMS工单扣账逻辑Service接口
 * 
 * @author Zhang Kai
 * @date 2021-09-13
 */
public interface ICuxWmsWorkKouZhangListService 
{

    /**
     * 查询WMS工单扣账逻辑列表
     * 
     * @param cuxWmsWorkKouZhangList WMS工单扣账逻辑
     * @return WMS工单扣账逻辑集合
     */
    public List<CuxWmsWorkKouZhangList> selectCuxWmsWorkKouZhangListList(CuxWmsWorkKouZhangList cuxWmsWorkKouZhangList);

    /**
     * 新增WMS工单扣账逻辑
     * 
     * @param cuxWmsWorkKouZhangList WMS工单扣账逻辑
     * @return 结果
     */
    public int insertCuxWmsWorkKouZhangList(CuxWmsWorkKouZhangList cuxWmsWorkKouZhangList);

    /**
     * 批量删除WMS工单扣账逻辑
     * 
     * @param kouZhangIds 需要删除的WMS工单扣账逻辑ID
     * @return 结果
     */
    public int deleteCuxWmsWorkKouZhangListByIds(Long[] kouZhangIds);

    public List<CuxWmsWorkKouZhangList> selectCuxWmsWorkKouZhangDetailsListList(CuxWmsWorkKouZhangList cuxWmsWorkKouZhangList);

    public int erpCuxWmsWorkKouZhangListByIds(String kouZhangType,Long[] kouZhangIds,String isWwFlag);

    public int autoErpCuxWmsWorkKouZhangListByIds(String kouZhangType,String isWwFlag);

    void insertTrancsationList(Long zhangId, Long kouZhangId,String kouZhangType,String isWwFlag);
}
