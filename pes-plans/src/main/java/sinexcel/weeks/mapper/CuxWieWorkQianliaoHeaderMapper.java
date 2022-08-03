package sinexcel.weeks.mapper;

import java.util.List;
import sinexcel.weeks.domain.CuxWieWorkQianliaoHeader;

/**
 * 排程欠料头信息Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-11-05
 */
public interface CuxWieWorkQianliaoHeaderMapper 
{

    /**
     * 查询排程欠料头信息列表
     * 
     * @param cuxWieWorkQianliaoHeader 排程欠料头信息
     * @return 排程欠料头信息集合
     */
    public List<CuxWieWorkQianliaoHeader> selectCuxWieWorkQianliaoHeaderList(CuxWieWorkQianliaoHeader cuxWieWorkQianliaoHeader);

    /**
     * 新增排程欠料头信息
     * 
     * @param cuxWieWorkQianliaoHeader 排程欠料头信息
     * @return 结果
     */
    public int insertCuxWieWorkQianliaoHeader(CuxWieWorkQianliaoHeader cuxWieWorkQianliaoHeader);

    public int deleteCuxWieWorkQianliaoHeaderById(Long lotNumber);

    int insertCuxWieWorkQianliaoHeaderById(Long lotNumber);
}
