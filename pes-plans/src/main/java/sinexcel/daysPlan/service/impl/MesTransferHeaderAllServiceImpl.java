package sinexcel.daysPlan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.annotation.DataSource;
import sinexcel.common.enums.DataSourceType;
import sinexcel.daysPlan.domain.MesTransferHeaderAll;
import sinexcel.daysPlan.domain.MesTransferLineAll;
import sinexcel.daysPlan.mapper.MesTransferHeaderAllMapper;
import sinexcel.daysPlan.service.MesTransferHeaderAllService;
import sinexcel.daysPlan.service.MesTransferLineAllService;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 生产日计划调拨明细单 服务实现类
 * </p>
 *
 * @author mingshen.wang
 * @since 2021-08-27
 */
@Service
public class MesTransferHeaderAllServiceImpl implements MesTransferHeaderAllService {
    @Autowired
    private MesTransferHeaderAllMapper mesTransferHeaderAllMapper;
    @Autowired
    private MesTransferLineAllService lineAllService;

    /**
     * 查询生产日计划调拨明细单
     *
     * @param id 生产日计划调拨明细单ID
     * @return 生产日计划调拨明细单
     */
    @Override
    public MesTransferHeaderAll selectMesTransferHeaderAllById(Long id)
    {
        return mesTransferHeaderAllMapper.selectMesTransferHeaderAllById(id);
    }

    /**
     * 查询生产日计划调拨明细单列表
     *
     * @param mesTransferHeaderAll 生产日计划调拨明细单
     * @return 生产日计划调拨明细单
     */
    @Override
    public List<MesTransferHeaderAll> selectMesTransferHeaderAllList(MesTransferHeaderAll mesTransferHeaderAll)
    {
        return mesTransferHeaderAllMapper.selectMesTransferHeaderAllList(mesTransferHeaderAll);
    }

    /**
     * 新增生产日计划调拨明细单
     *
     * @param mesTransferHeaderAll 生产日计划调拨明细单
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int insertMesTransferHeaderAll(MesTransferHeaderAll mesTransferHeaderAll)
    {
        return mesTransferHeaderAllMapper.insertMesTransferHeaderAll(mesTransferHeaderAll);
    }

    /**
     * 修改生产日计划调拨明细单
     *
     * @param mesTransferHeaderAll 生产日计划调拨明细单
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int updateMesTransferHeaderAll(MesTransferHeaderAll mesTransferHeaderAll)
    {
        return mesTransferHeaderAllMapper.updateMesTransferHeaderAll(mesTransferHeaderAll);
    }

    /**
     * 批量删除生产日计划调拨明细单
     *
     * @param ids 需要删除的生产日计划调拨明细单ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int deleteMesTransferHeaderAllByIds(Long[] ids)
    {
        return mesTransferHeaderAllMapper.deleteMesTransferHeaderAllByIds(ids);
    }

    /**
     * 删除生产日计划调拨明细单信息
     *
     * @param id 生产日计划调拨明细单ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int deleteMesTransferHeaderAllById(Long id)
    {
        return mesTransferHeaderAllMapper.deleteMesTransferHeaderAllById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ )
    public List<MesTransferHeaderAll> insertAndLine(List<MesTransferLineAll> lineAlls) {
        List<MesTransferHeaderAll> headerList = new ArrayList<>();
        //统计出同一个 出入子仓的记录
        Map<String,List<MesTransferLineAll>> infoMap = new HashMap<>();
        lineAlls.forEach(o->{
            String key = o.getDiaoChuSubinventory() + o.getDiaoRuSubinventory();
            if (infoMap.containsKey(key)){
                List<MesTransferLineAll> mapLines = infoMap.get(key);
                mapLines.add(o);
            }else {
                List<MesTransferLineAll> mapLines = new ArrayList<>();
                mapLines.add(o);
                infoMap.put(key,mapLines);
            }
        });

        infoMap.forEach((k,v)->{
            MesTransferHeaderAll headerAll = new MesTransferHeaderAll();
            AtomicInteger insertNum = new AtomicInteger(0);
            v.forEach(o->{
                if (headerAll.getOrganizationId()==null){
                    headerAll.setMesTransferHeaderAll(o.getOrganizationId(),o.getDiaoChuSubinventory(),
                            o.getDiaoRuSubinventory(),o.getType(),o.getSourceCategory(),o.getSourceType(),
                            o.getSourceCode(),o.getSourceName(),
                            null,o.getCreateBy(),new Date(),o.getCreateBy(),new Date());
                    mesTransferHeaderAllMapper.insertMesTransferHeaderAll(headerAll);
                }
                o.setHeaderId(headerAll.getId());
                Boolean f = lineAllService.insertAnddistinct(o);
                if (f){
                    insertNum.getAndIncrement();
                    headerAll.addLineAllList(o);
                }
            });
            if (insertNum.get()==0){
                //行未新增 删除头
                mesTransferHeaderAllMapper.deleteMesTransferHeaderAllById(headerAll.getId());
            }else {
                headerList.add(headerAll);
            }
        });
        return headerList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @DataSource(DataSourceType.MASTER)
    public void updateState(List<Long> ids, String state) {
        mesTransferHeaderAllMapper.updateState(ids, state);
    }
}
