package sinexcel.quartz.service;

import sinexcel.quartz.domain.MesWieWoCompleteAllDKEO;

import java.util.List;

public interface IMesWieWoCompleteAllService {

    /**
     * 查询MES工单完工入库回写ERP列表
     *
     * @param mesWieWoCompleteAll MES工单完工入库回写ERP
     * @return MES工单完工入库回写ERP集合
     */
    public List<MesWieWoCompleteAllDKEO> selectMesWieWoCompleteAllList(MesWieWoCompleteAllDKEO mesWieWoCompleteAll);
}
