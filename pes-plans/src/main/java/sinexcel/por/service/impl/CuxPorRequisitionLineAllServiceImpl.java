package sinexcel.por.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.por.mapper.CuxPorRequisitionLineAllMapper;
import sinexcel.por.domain.CuxPorRequisitionLineAll;
import sinexcel.por.service.ICuxPorRequisitionLineAllService;

/**
 * 管理请购行信息Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-01-15
 */
@Service
public class CuxPorRequisitionLineAllServiceImpl implements ICuxPorRequisitionLineAllService 
{
    @Autowired
    private CuxPorRequisitionLineAllMapper cuxPorRequisitionLineAllMapper;

    /**
     * 查询管理请购行信息列表
     * 
     * @param cuxPorRequisitionLineAll 管理请购行信息
     * @return 管理请购行信息
     */
    @Override
    public List<CuxPorRequisitionLineAll> selectCuxPorRequisitionLineAllList(CuxPorRequisitionLineAll cuxPorRequisitionLineAll)
    {
        return cuxPorRequisitionLineAllMapper.selectCuxPorRequisitionLineAllList(cuxPorRequisitionLineAll);
    }

    /**
     * 批量删除管理请购行信息
     * 
     * @param requisitioningLineIds 需要删除的管理请购行信息ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteCuxPorRequisitionLineAllByIds(Long[] requisitioningLineIds)
    {
        return cuxPorRequisitionLineAllMapper.deleteCuxPorRequisitionLineAllByIds(requisitioningLineIds);
    }

}
