package sinexcel.plans.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.plans.mapper.PesPlanHeaderListMapper;
import sinexcel.plans.domain.PesPlanHeaderList;
import sinexcel.plans.mapper.PesPoPlanHeaderListMapper;
import sinexcel.plans.mapper.PesWiePlanHeaderListMapper;
import sinexcel.plans.service.IPesPlanHeaderListService;

/**
 * 主计划头Service业务层处理
 *
 * @author Zhang Kai
 * @date 2020-11-23
 */
@Service
public class PesPlanHeaderListServiceImpl implements IPesPlanHeaderListService
{
    @Autowired
    private PesPlanHeaderListMapper pesPlanHeaderListMapper;

    @Autowired
    private PesWiePlanHeaderListMapper pesWiePlanHeaderListMapper;

    @Autowired
    private PesPoPlanHeaderListMapper pesPoPlanHeaderListMapper;

    /**
     * 查询主计划头
     *
     * @param id 主计划头ID
     * @return 主计划头
     */
    @Override
    public PesPlanHeaderList selectPesPlanHeaderListById(Integer id)
    {
        return pesPlanHeaderListMapper.selectPesPlanHeaderListById(id);
    }

    /**
     * 查询主计划头列表
     *
     * @param pesPlanHeaderList 主计划头
     * @return 主计划头
     */
    @Override
    public List<PesPlanHeaderList> selectPesPlanHeaderListList(PesPlanHeaderList pesPlanHeaderList)
    {
        return pesPlanHeaderListMapper.selectPesPlanHeaderListList(pesPlanHeaderList);
    }

    /**
     * 新增主计划头
     *
     * @param pesPlanHeaderList 主计划头
     * @return 结果
     */
    @Override
    @Transactional
    public int insertPesPlanHeaderList(PesPlanHeaderList pesPlanHeaderList)
    {
        checkAddAllowed(pesPlanHeaderList);
        int suc= 0,x;
        x = pesPlanHeaderListMapper.insertPesPlanHeaderList(pesPlanHeaderList);
        if(x>0){
            pesWiePlanHeaderListMapper.insertPesWiePlanHeaderList(pesPlanHeaderList);
            pesPoPlanHeaderListMapper.insertPesPoPlanHeaderList(pesPlanHeaderList);
            suc++;
        }
        return suc;
    }

    //判断批次是否唯一
    public void checkAddAllowed(PesPlanHeaderList pesPlanHeaderList)
    {
        if (pesPlanHeaderListMapper.checkAddActiveAllowed(pesPlanHeaderList) > 0 ? true : false)
        {
            throw new CustomException("当前BU存在有效的批次号，请失效有效批次后在创建！");
        }else {
            if (pesPlanHeaderListMapper.checkAddAllowed(pesPlanHeaderList) > 0 ? true : false)
            {
                throw new CustomException("批次号具有唯一性！");
            }
        }
    }

    /**
     * 修改主计划头
     *
     * @param pesPlanHeaderList 主计划头
     * @return 结果
     */
    @Override
    @Transactional
    public int updatePesPlanHeaderList(PesPlanHeaderList pesPlanHeaderList)
    {
        return pesPlanHeaderListMapper.updatePesPlanHeaderList(pesPlanHeaderList);

    }

    /**
     * 批量删除主计划头
     *
     * @param ids 需要删除的主计划头ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deletePesPlanHeaderListByIds(Integer[] ids)
    {
        int suc = 0;
        for (Integer id : ids)
        {
            checkDeleteAllowed(id);

        }
        suc = pesPlanHeaderListMapper.deletePesPlanHeaderListByIds(ids);
        if(suc > 0){
            pesWiePlanHeaderListMapper.deletePesWiePlanHeaderListByIds(ids);
            pesPoPlanHeaderListMapper.deletePesPoPlanHeaderListByIds(ids);
        }
        return suc;
    }

    /**
     * 校验是否允许删除
     *
     * @param id 信息
     */
    public void checkDeleteAllowed(Integer id)
    {
        if (pesPlanHeaderListMapper.checkDeleteAllowed(id) > 0 ? true : false)
        {
            throw new CustomException("已经产生MPS和MRP数据，不允许删除此批次号，你可以选择失效批次号");
        }
    }

}
