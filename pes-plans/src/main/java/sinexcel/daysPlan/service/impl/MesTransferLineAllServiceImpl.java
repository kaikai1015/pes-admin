package sinexcel.daysPlan.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.daysPlan.domain.MesTransferLineAll;
import sinexcel.daysPlan.mapper.MesTransferLineAllMapper;
import sinexcel.daysPlan.service.MesTransferLineAllService;

import java.util.List;

/**
 * <p>
 * 生产日计划调拨明细单 服务实现类
 * </p>
 *
 * @author mingshen.wang
 * @since 2021-08-27
 */
@Service
public class MesTransferLineAllServiceImpl implements MesTransferLineAllService {
    private  final Logger  logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MesTransferLineAllMapper mesTransferLineAllMapper;

    /**
     * 查询调拨中间明细单
     *
     * @param id 调拨中间明细单ID
     * @return 调拨中间明细单
     */
    @Override
    public MesTransferLineAll selectMesTransferLineAllById(Long id)
    {
        return mesTransferLineAllMapper.selectMesTransferLineAllById(id);
    }

    /**
     * 查询调拨中间明细单列表
     *
     * @param mesTransferLineAll 调拨中间明细单
     * @return 调拨中间明细单
     */
    @Override
    public List<MesTransferLineAll> selectMesTransferLineAllList(MesTransferLineAll mesTransferLineAll)
    {
        return mesTransferLineAllMapper.selectMesTransferLineAllList(mesTransferLineAll);
    }

    /**
     * 新增调拨中间明细单
     *
     * @param mesTransferLineAll 调拨中间明细单
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int insertMesTransferLineAll(MesTransferLineAll mesTransferLineAll)
    {
        return mesTransferLineAllMapper.insertMesTransferLineAll(mesTransferLineAll);
    }

    /**
     * 修改调拨中间明细单
     *
     * @param mesTransferLineAll 调拨中间明细单
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int updateMesTransferLineAll(MesTransferLineAll mesTransferLineAll)
    {
        return mesTransferLineAllMapper.updateMesTransferLineAll(mesTransferLineAll);
    }

    /**
     * 批量删除调拨中间明细单
     *
     * @param ids 需要删除的调拨中间明细单ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int deleteMesTransferLineAllByIds(Long[] ids)
    {
        return mesTransferLineAllMapper.deleteMesTransferLineAllByIds(ids);
    }

    /**
     * 删除调拨中间明细单信息
     *
     * @param id 调拨中间明细单ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int deleteMesTransferLineAllById(Long id)
    {
        return mesTransferLineAllMapper.deleteMesTransferLineAllById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public Boolean insertAnddistinct(MesTransferLineAll o) {
//      判断唯一性
        MesTransferLineAll info = new MesTransferLineAll();
        info.setTransferId(o.getTransferId());
//        info.setSourceId(o.getSourceId());
        info.setType(o.getType());
        info.setSourceType(o.getSourceType());
        info.setSourceCategory(o.getSourceCategory());
        List<MesTransferLineAll> list = mesTransferLineAllMapper.selectMesTransferLineAllList(info);
        if (list.size()<1){
            mesTransferLineAllMapper.insertMesTransferLineAll(o);
            return true;
        }else {
            logger.error("调拨数据重复：info{"+o.toString()+"}");
            return false;
        }
    }
}
