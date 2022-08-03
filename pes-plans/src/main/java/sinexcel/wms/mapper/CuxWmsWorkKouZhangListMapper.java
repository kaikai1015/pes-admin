package sinexcel.wms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import sinexcel.daysPlan.domain.PesInvMaterialTxns;
import sinexcel.wms.domain.CuxWmsWorkKouZhangList;

/**
 * WMS工单扣账逻辑Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-09-13
 */
public interface CuxWmsWorkKouZhangListMapper 
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

    public int deleteCuxWmsWorkKouZhangListByLotNum(@Param("lotNumber") Long lotNumber,@Param("isWwFlag") String isWwFlag);


    /**
     * 批量删除WMS工单扣账逻辑
     * 
     * @param kouZhangIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCuxWmsWorkKouZhangListByIds(Long[] kouZhangIds);

    public List<CuxWmsWorkKouZhangList> selectCuxWmsWorkKouZhangDetailsListList(CuxWmsWorkKouZhangList cuxWmsWorkKouZhangList);


    public List<CuxWmsWorkKouZhangList> erpCuxWmsWorkKouZhangListByIds(@Param("kouZhangId") Long[] kouZhangId,
                                                                       @Param("isWwFlag")  String isWwFlag);


    public int insertTrancsationList(Long kouZhangId);

    List<PesInvMaterialTxns> getInsertTrancsationList(@Param("lineId") Long lineId,@Param("kouZhangId") Long kouZhangId,
                                                      @Param("kouZhangType") String kouZhangType, @Param("isWwFlag")  String isWwFlag);

    List<CuxWmsWorkKouZhangList> autoErpCuxWmsWorkKouZhangListByIds( @Param("isWwFlag")  String isWwFlag);
}
