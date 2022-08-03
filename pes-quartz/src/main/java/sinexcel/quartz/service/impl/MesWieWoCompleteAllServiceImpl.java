package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.quartz.domain.MesWieWoCompleteAllDKEO;
import sinexcel.quartz.mapper.MesWieWoCompleteAllDKMapper;
import sinexcel.quartz.service.IMesWieWoCompleteAllService;

import java.util.List;

@Service
public class MesWieWoCompleteAllServiceImpl implements IMesWieWoCompleteAllService {

    @Autowired
    private MesWieWoCompleteAllDKMapper mesWieWoCompleteAllMapper;

    /**
     * 查询MES工单完工入库回写ERP列表
     *
     * @param mesWieWoCompleteAll MES工单完工入库回写ERP
     * @return MES工单完工入库回写ERP
     */
    @Override
    public List<MesWieWoCompleteAllDKEO> selectMesWieWoCompleteAllList(MesWieWoCompleteAllDKEO mesWieWoCompleteAll)
    {
        return mesWieWoCompleteAllMapper.selectMesWieWoCompleteAllList(mesWieWoCompleteAll);
    }
}
