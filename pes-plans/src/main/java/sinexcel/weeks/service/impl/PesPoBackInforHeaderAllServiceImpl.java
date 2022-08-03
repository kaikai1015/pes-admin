package sinexcel.weeks.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.utils.DateUtils;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.weeks.mapper.PesPoBackInforHeaderAllMapper;
import sinexcel.weeks.domain.PesPoBackInforHeaderAll;
import sinexcel.weeks.service.IPesPoBackInforHeaderAllService;

/**
 *  采购回货计划Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-07-26
 */
@Service
public class PesPoBackInforHeaderAllServiceImpl implements IPesPoBackInforHeaderAllService 
{
    @Autowired
    private PesPoBackInforHeaderAllMapper pesPoBackInforHeaderAllMapper;

    /**
     * 查询 采购回货计划列表
     * 
     * @param pesPoBackInforHeaderAll  采购回货计划
     * @return  采购回货计划
     */
    @Override
    public List<PesPoBackInforHeaderAll> selectPesPoBackInforHeaderAllList(PesPoBackInforHeaderAll pesPoBackInforHeaderAll)
    {
        return pesPoBackInforHeaderAllMapper.selectPesPoBackInforHeaderAllList(pesPoBackInforHeaderAll);
    }

    /**
     * 新增 采购回货计划
     * 
     * @param pesPoBackInforHeaderAll  采购回货计划
     * @return 结果
     */
    @Override
    @Transactional
    public int insertPesPoBackInforHeaderAll(PesPoBackInforHeaderAll pesPoBackInforHeaderAll)
    {
        pesPoBackInforHeaderAll.setCreateBy(SecurityUtils.getUsername());
        pesPoBackInforHeaderAll.setActiveCode("Y");
        return pesPoBackInforHeaderAllMapper.insertPesPoBackInforHeaderAll(pesPoBackInforHeaderAll);
    }

    /**
     * 删除 采购回货计划信息
     * 
     * @param headerId  采购回货计划ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deletePesPoBackInforHeaderAllById(Long headerId)
    {
        return pesPoBackInforHeaderAllMapper.deletePesPoBackInforHeaderAllById(headerId);
    }

    /**
     * 查询 采购回货计划
     *
     * @param headerId  采购回货计划ID
     * @return  采购回货计划
     */
    @Override
    public String [] selectPesPoBackInforHeaderAllById(Long headerId)
    {
        int x = 0;
        String [] createDate = new String[19];
        PesPoBackInforHeaderAll cDate= pesPoBackInforHeaderAllMapper.selectPesPoBackInforHeaderAllById(headerId);
        for(int i = 0; i < createDate.length; i ++){
            if(i < 14){
                createDate[i] = DateUtils.getNextDay(cDate.getCreateDate(),i+1);
            }else {
                x++;
                createDate[i] = DateUtils.getNextDay(cDate.getCreateDate(),(i+7*x)-(x-1));
            }
        }

        return createDate;
    }

    /**
     * 修改 采购回货计划
     *
     * @param pesPoBackInforHeaderAll  采购回货计划
     * @return 结果
     */
    @Override
    @Transactional
    public int updatePesPoBackInforHeaderAll(PesPoBackInforHeaderAll pesPoBackInforHeaderAll)
    {
        pesPoBackInforHeaderAll.setCreateBy(SecurityUtils.getUsername());
        return pesPoBackInforHeaderAllMapper.updatePesPoBackInforHeaderAll(pesPoBackInforHeaderAll);
    }
}
