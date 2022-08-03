package sinexcel.daysPlan.service.impl;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.daysPlan.domain.PesWieWorkProcessing;
import sinexcel.daysPlan.mapper.PesWieWorkProcessingMapper;
import sinexcel.daysPlan.service.IPesWieWorkProcessingService;

/**
 * WMS工单执行情况数据Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-09-08
 */
@Service
public class PesWieWorkProcessingServiceImpl implements IPesWieWorkProcessingService
{
    @Autowired
    private PesWieWorkProcessingMapper pesWieWorkProcessingMapper;

    /**
     * 查询WMS工单执行情况数据
     * 
     * @param workOrderId WMS工单执行情况数据ID
     * @return WMS工单执行情况数据
     */
    @Override
    public PesWieWorkProcessing selectPesWieWorkProcessingById(Long workOrderId)
    {
        return pesWieWorkProcessingMapper.selectPesWieWorkProcessingById(workOrderId);
    }

    /**
     * 查询WMS工单执行情况数据列表
     * 
     * @param pesWieWorkProcessing WMS工单执行情况数据
     * @return WMS工单执行情况数据
     */
    @Override
    public List<PesWieWorkProcessing> selectPesWieWorkProcessingList(PesWieWorkProcessing pesWieWorkProcessing)
    {
        return pesWieWorkProcessingMapper.selectPesWieWorkProcessingList(pesWieWorkProcessing);
    }

    /**
     * 新增WMS工单执行情况数据
     * 
     * @param pesWieWorkProcessing WMS工单执行情况数据
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int insertPesWieWorkProcessing(PesWieWorkProcessing pesWieWorkProcessing)
    {
        return pesWieWorkProcessingMapper.insertPesWieWorkProcessing(pesWieWorkProcessing);
    }

    /**
     * 修改WMS工单执行情况数据
     * 
     * @param pesWieWorkProcessing WMS工单执行情况数据
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int updatePesWieWorkProcessing(PesWieWorkProcessing pesWieWorkProcessing)
    {
        return pesWieWorkProcessingMapper.updatePesWieWorkProcessing(pesWieWorkProcessing);
    }

    /**
     * 批量删除WMS工单执行情况数据
     * 
     * @param workOrderIds 需要删除的WMS工单执行情况数据ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int deletePesWieWorkProcessingByIds(Long[] workOrderIds)
    {
        return pesWieWorkProcessingMapper.deletePesWieWorkProcessingByIds(workOrderIds);
    }

    /**
     * 删除WMS工单执行情况数据信息
     * 
     * @param workOrderId WMS工单执行情况数据ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int deletePesWieWorkProcessingById(Long workOrderId)
    {
        return pesWieWorkProcessingMapper.deletePesWieWorkProcessingById(workOrderId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int sumQuantity(Long workOrderId, Long organizationId, BigDecimal qty, String type) {
        return pesWieWorkProcessingMapper.sumQuantity(workOrderId,organizationId,qty,type);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public void insertInit(Long pId,String isWw) {
        pesWieWorkProcessingMapper.insertInit(pId,SecurityUtils.getUsername(),isWw);
    }
}
