package sinexcel.daysPlan.mapper;

import java.util.List;
import sinexcel.daysPlan.domain.PesProdLineDaysHeaderAllWW;

/**
 * 日计划Mapper接口
 *
 * @author Zhang Kai
 * @date 2021-06-07
 */
public interface PesProdLineDaysHeaderAllWWMapper
{
    /**
     * 查询日计划
     *
     * @param id 日计划ID
     * @return 日计划
     */
    public PesProdLineDaysHeaderAllWW selectPesProdLineDaysHeaderAllById(Long id);
    /**
     * 查询日计划列表
     *
     * @param pesProdLineDaysHeaderAll 日计划
     * @return 日计划集合
     */
    public List<PesProdLineDaysHeaderAllWW> selectPesProdLineDaysHeaderAllList(PesProdLineDaysHeaderAllWW pesProdLineDaysHeaderAll);

    /**
     * 新增日计划
     *
     * @param pesProdLineDaysHeaderAll 日计划
     * @return 结果
     */
    public int insertPesProdLineDaysHeaderAll(PesProdLineDaysHeaderAllWW pesProdLineDaysHeaderAll);


    /**
     * 删除日计划
     *
     * @param id 日计划ID
     * @return 结果
     */
    public int deletePesProdLineDaysHeaderAllById(Long id);

    public int checkDeleteAllowed(Long id);

}
