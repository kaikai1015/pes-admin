package sinexcel.daysPlan.mapper;

import java.util.List;
import sinexcel.daysPlan.domain.PesProdLineDaysLineAllWW;

/**
 * 产品线日计划明细Mapper接口
 *
 * @author Zhang Kai
 * @date 2021-06-07
 */
public interface PesProdLineDaysLineAllWWMapper
{
    /**
     * 查询产品线日计划明细
     *
     * @param lineId 产品线日计划明细ID
     * @return 产品线日计划明细
     */
    public PesProdLineDaysLineAllWW selectPesProdLineDaysLineAllById(Long lineId);

    /**
     * 查询产品线日计划明细列表
     *
     * @param pesProdLineDaysLineAll 产品线日计划明细
     * @return 产品线日计划明细集合
     */
    public List<PesProdLineDaysLineAllWW> selectPesProdLineDaysLineAllList(PesProdLineDaysLineAllWW pesProdLineDaysLineAll);

    /**
     * 新增产品线日计划明细
     *
     * @param pesProdLineDaysLineAll 产品线日计划明细
     * @return 结果
     */
    public PesProdLineDaysLineAllWW getOrderInfor(PesProdLineDaysLineAllWW pesProdLineDaysLineAll);

    public PesProdLineDaysLineAllWW getWorksInfor(PesProdLineDaysLineAllWW pesProdLineDaysLineAll);

    public int insertPesProdLineDaysLineAll(PesProdLineDaysLineAllWW pesProdLineDaysLineAll);

    /**
     * 修改产品线日计划明细
     *
     * @param pesProdLineDaysLineAll 产品线日计划明细
     * @return 结果
     */
    public int updatePesProdLineDaysLineAll(PesProdLineDaysLineAllWW pesProdLineDaysLineAll);

    /**
     * 批量删除产品线日计划明细
     *
     * @param lineIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePesProdLineDaysLineAllByIds(Long lineIds);

    public PesProdLineDaysLineAllWW selectXianbieflagId(Long id);

    public int updatedaysProdLinesww(Long id);

    public PesProdLineDaysLineAllWW getOrgCode(String organizationCode);
}
