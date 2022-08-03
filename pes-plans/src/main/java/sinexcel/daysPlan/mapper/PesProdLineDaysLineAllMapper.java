package sinexcel.daysPlan.mapper;

import java.util.List;
import sinexcel.daysPlan.domain.PesProdLineDaysLineAll;

/**
 * 产品线日计划明细Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-06-07
 */
public interface PesProdLineDaysLineAllMapper 
{
    /**
     * 查询产品线日计划明细
     * 
     * @param lineId 产品线日计划明细ID
     * @return 产品线日计划明细
     */
    public PesProdLineDaysLineAll selectPesProdLineDaysLineAllById(Long lineId);

    /**
     * 查询产品线日计划明细列表
     * 
     * @param pesProdLineDaysLineAll 产品线日计划明细
     * @return 产品线日计划明细集合
     */
    public List<PesProdLineDaysLineAll> selectPesProdLineDaysLineAllList(PesProdLineDaysLineAll pesProdLineDaysLineAll);

    /**
     * 新增产品线日计划明细
     * 
     * @param pesProdLineDaysLineAll 产品线日计划明细
     * @return 结果
     */
    public PesProdLineDaysLineAll getOrderInfor(PesProdLineDaysLineAll pesProdLineDaysLineAll);

    public PesProdLineDaysLineAll getWorksInfor(PesProdLineDaysLineAll pesProdLineDaysLineAll);

    public int insertPesProdLineDaysLineAll(PesProdLineDaysLineAll pesProdLineDaysLineAll);

    /**
     * 修改产品线日计划明细
     * 
     * @param pesProdLineDaysLineAll 产品线日计划明细
     * @return 结果
     */
    public int updatePesProdLineDaysLineAll(PesProdLineDaysLineAll pesProdLineDaysLineAll);

    /**
     * 批量删除产品线日计划明细
     * 
     * @param lineIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePesProdLineDaysLineAllByIds(Long lineIds);

    public PesProdLineDaysLineAll selectXianbieflag(String xianBieFlagName);

    public int updatedaysProdLines(Long id);

    public PesProdLineDaysLineAll getOrgCode(String organizationCode);
}
