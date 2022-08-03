package sinexcel.works.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.works.mapper.PesWieWorkSubmitErpInforListMapper;
import sinexcel.works.domain.PesWieWorkSubmitErpInforList;
import sinexcel.works.service.IPesWieWorkSubmitErpInforListService;

/**
 * PES自定义工单回传ERP日志Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-11-29
 */
@Service
public class PesWieWorkSubmitErpInforListServiceImpl implements IPesWieWorkSubmitErpInforListService 
{
    @Autowired
    private PesWieWorkSubmitErpInforListMapper pesWieWorkSubmitErpInforListMapper;

    /**
     * 查询PES自定义工单回传ERP日志列表
     * 
     * @param pesWieWorkSubmitErpInforList PES自定义工单回传ERP日志
     * @return PES自定义工单回传ERP日志
     */
    @Override
    public List<PesWieWorkSubmitErpInforList> selectPesWieWorkSubmitErpInforListList(PesWieWorkSubmitErpInforList pesWieWorkSubmitErpInforList)
    {
        return pesWieWorkSubmitErpInforListMapper.selectPesWieWorkSubmitErpInforListList(pesWieWorkSubmitErpInforList);
    }

    @Override
    public int deleteSelectPesWieWorkSubmitErpInforListList()
    {
        return pesWieWorkSubmitErpInforListMapper.deleteSelectPesWieWorkSubmitErpInforListList();
    }

}
