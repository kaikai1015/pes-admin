package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.MesWieWoCompleteAllDKEO;

import java.util.List;

public interface MesWieWoCompleteAllDKMapper {
    public List<MesWieWoCompleteAllDKEO> getWieWoCompleteList(MesWieWoCompleteAllDKEO mesWieWoCompleteAllDk);

    public List<MesWieWoCompleteAllDKEO> getWorkDemandLists(MesWieWoCompleteAllDKEO wieWoCompleteDkList);

    public int updateLineErpFlag(MesWieWoCompleteAllDKEO mesWieWoCompleteAllDk);

    public int updateErpFlag(MesWieWoCompleteAllDKEO mesWieWoCompleteAllDk);

    public MesWieWoCompleteAllDKEO selectOrgnazationCode(Long organizationId);

    public List<MesWieWoCompleteAllDKEO> selectOperSequenceNumber(Long workOrderId);

    //根据工单ID，组织ID，Remark再次判断是否还有未扣料的明细，如果有，不能完工入库
    public int getAllErpFlag(MesWieWoCompleteAllDKEO wieWoCompleteDkList);

    public int getIsDetails(MesWieWoCompleteAllDKEO wieWoCompleteDkList);

    public MesWieWoCompleteAllDKEO getTranQuantity(MesWieWoCompleteAllDKEO getWorkDemandList);


    /**
     * 查询MES工单完工入库回写ERP列表
     *
     * @param mesWieWoCompleteAll MES工单完工入库回写ERP
     * @return MES工单完工入库回写ERP集合
     */
    public List<MesWieWoCompleteAllDKEO> selectMesWieWoCompleteAllList(MesWieWoCompleteAllDKEO mesWieWoCompleteAll);
}
