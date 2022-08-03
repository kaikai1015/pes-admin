package sinexcel.quartz.service;

import java.util.List;
import sinexcel.quartz.domain.MesWorkOverMaterialAll;

/**
 * mes回传工单超耗Service接口
 * 
 * @author Zhang Kai
 * @date 2022-04-12
 */
public interface IMesWorkOverMaterialAllService 
{
    /**
     * 查询mes回传工单超耗
     * 
     * @param materialId mes回传工单超耗ID
     * @return mes回传工单超耗
     */
    public MesWorkOverMaterialAll selectMesWorkOverMaterialAllById(Long materialId);

    /**
     * 查询mes回传工单超耗列表
     * 
     * @param mesWorkOverMaterialAll mes回传工单超耗
     * @return mes回传工单超耗集合
     */
    public List<MesWorkOverMaterialAll> selectMesWorkOverMaterialAllList(MesWorkOverMaterialAll mesWorkOverMaterialAll);

}
