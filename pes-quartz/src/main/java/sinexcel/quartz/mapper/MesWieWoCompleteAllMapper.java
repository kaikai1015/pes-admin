package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.MesWieWoCompleteAllEO;

import java.util.List;

/**
 * 工单报工完工Mapper接口
 *
 * @author Zhang Kai
 * @date 2021-02-24
 */
public interface MesWieWoCompleteAllMapper {

    public List<MesWieWoCompleteAllEO> getWieWoCompleteList();

    public int updateErpFlag(MesWieWoCompleteAllEO mesWieWoCompleteAll);

    public MesWieWoCompleteAllEO selectOrgnazationCode(Long organizationId);

    public List<MesWieWoCompleteAllEO> selectOperSequenceNumber(MesWieWoCompleteAllEO wieWoCompleteList);
}
