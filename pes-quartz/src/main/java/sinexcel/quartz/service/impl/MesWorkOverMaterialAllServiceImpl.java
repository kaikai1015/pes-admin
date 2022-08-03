package sinexcel.quartz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.quartz.mapper.MesWorkOverMaterialAllMapper;
import sinexcel.quartz.domain.MesWorkOverMaterialAll;
import sinexcel.quartz.service.IMesWorkOverMaterialAllService;

/**
 * mes回传工单超耗Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2022-04-12
 */
@Service
public class MesWorkOverMaterialAllServiceImpl implements IMesWorkOverMaterialAllService 
{
    @Autowired
    private MesWorkOverMaterialAllMapper mesWorkOverMaterialAllMapper;

    /**
     * 查询mes回传工单超耗
     * 
     * @param materialId mes回传工单超耗ID
     * @return mes回传工单超耗
     */
    @Override
    public MesWorkOverMaterialAll selectMesWorkOverMaterialAllById(Long materialId)
    {
        return mesWorkOverMaterialAllMapper.selectMesWorkOverMaterialAllById(materialId);
    }

    /**
     * 查询mes回传工单超耗列表
     * 
     * @param mesWorkOverMaterialAll mes回传工单超耗
     * @return mes回传工单超耗
     */
    @Override
    public List<MesWorkOverMaterialAll> selectMesWorkOverMaterialAllList(MesWorkOverMaterialAll mesWorkOverMaterialAll)
    {
        return mesWorkOverMaterialAllMapper.selectMesWorkOverMaterialAllList(mesWorkOverMaterialAll);
    }
}
