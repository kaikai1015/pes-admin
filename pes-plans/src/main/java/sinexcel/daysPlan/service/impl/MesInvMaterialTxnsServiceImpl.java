package sinexcel.daysPlan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.daysPlan.domain.MesInvMaterialTxns;
import sinexcel.daysPlan.mapper.MesInvMaterialTxnsMapper;
import sinexcel.daysPlan.service.IMesInvMaterialTxnsService;

import java.util.List;

/**
 * 库存出入库明细-中间Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-08-28
 */
@Service
public class MesInvMaterialTxnsServiceImpl implements IMesInvMaterialTxnsService
{
    @Autowired
    private MesInvMaterialTxnsMapper mesInvMaterialTxnsMapper;

    /**
     * 查询库存出入库明细-中间
     * 
     * @param id 库存出入库明细-中间ID
     * @return 库存出入库明细-中间
     */
    @Override
    public MesInvMaterialTxns selectMesInvMaterialTxnsById(Long id)
    {
        return mesInvMaterialTxnsMapper.selectMesInvMaterialTxnsById(id);
    }

    /**
     * 查询库存出入库明细-中间列表
     * 
     * @param mesInvMaterialTxns 库存出入库明细-中间
     * @return 库存出入库明细-中间
     */
    @Override
    public List<MesInvMaterialTxns> selectMesInvMaterialTxnsList(MesInvMaterialTxns mesInvMaterialTxns)
    {
        return mesInvMaterialTxnsMapper.selectMesInvMaterialTxnsList(mesInvMaterialTxns);
    }

    /**
     * 新增库存出入库明细-中间
     * 
     * @param mesInvMaterialTxns 库存出入库明细-中间
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int insertMesInvMaterialTxns(MesInvMaterialTxns mesInvMaterialTxns)
    {
        return mesInvMaterialTxnsMapper.insertMesInvMaterialTxns(mesInvMaterialTxns);
    }

    /**
     * 修改库存出入库明细-中间
     * 
     * @param mesInvMaterialTxns 库存出入库明细-中间
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int updateMesInvMaterialTxns(MesInvMaterialTxns mesInvMaterialTxns)
    {
        return mesInvMaterialTxnsMapper.updateMesInvMaterialTxns(mesInvMaterialTxns);
    }

    /**
     * 批量删除库存出入库明细-中间
     * 
     * @param ids 需要删除的库存出入库明细-中间ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int deleteMesInvMaterialTxnsByIds(Long[] ids)
    {
        return mesInvMaterialTxnsMapper.deleteMesInvMaterialTxnsByIds(ids);
    }

    /**
     * 删除库存出入库明细-中间信息
     * 
     * @param id 库存出入库明细-中间ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int deleteMesInvMaterialTxnsById(Long id)
    {
        return mesInvMaterialTxnsMapper.deleteMesInvMaterialTxnsById(id);
    }

    @Override
    public List<MesInvMaterialTxns> getSynData() {

        return mesInvMaterialTxnsMapper.getSynData();
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public void updateState(long[] cfIds, String state) {
        mesInvMaterialTxnsMapper.updateStates(cfIds,state);

    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public void insertSynData(List<Long> inserIdList) {
        mesInvMaterialTxnsMapper.insertSynData(inserIdList);
    }


}
