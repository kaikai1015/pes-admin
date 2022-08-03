package sinexcel.works.service;

import java.util.List;
import sinexcel.works.domain.PesWieWorkSubmitErpInforList;

/**
 * PES自定义工单回传ERP日志Service接口
 * 
 * @author Zhang Kai
 * @date 2021-11-29
 */
public interface IPesWieWorkSubmitErpInforListService 
{

    /**
     * 查询PES自定义工单回传ERP日志列表
     * 
     * @param pesWieWorkSubmitErpInforList PES自定义工单回传ERP日志
     * @return PES自定义工单回传ERP日志集合
     */
    public List<PesWieWorkSubmitErpInforList> selectPesWieWorkSubmitErpInforListList(PesWieWorkSubmitErpInforList pesWieWorkSubmitErpInforList);

    int deleteSelectPesWieWorkSubmitErpInforListList();
}
