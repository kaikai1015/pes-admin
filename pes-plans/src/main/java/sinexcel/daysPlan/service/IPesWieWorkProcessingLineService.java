package sinexcel.daysPlan.service;

import sinexcel.common.core.domain.AjaxResult;
import sinexcel.daysPlan.domain.PesWieWorkProcessingLine;

import java.util.List;

/**
 * 工单生产进度明细Service接口
 * 
 * @author Zhang Kai
 * @date 2021-11-03
 */
public interface IPesWieWorkProcessingLineService 
{
    /**
     * 查询工单生产进度明细
     * 
     * @param workOrderId 工单生产进度明细ID
     * @return 工单生产进度明细
     */
    public PesWieWorkProcessingLine selectPesWieWorkProcessingLineById(Long workOrderId);

    /**
     * 查询工单生产进度明细列表
     * 
     * @param pesWieWorkProcessingLine 工单生产进度明细
     * @return 工单生产进度明细集合
     */
    public List<PesWieWorkProcessingLine> selectPesWieWorkProcessingLineList(PesWieWorkProcessingLine pesWieWorkProcessingLine);

    /**
     * 新增工单生产进度明细
     * 
     * @param pesWieWorkProcessingLine 工单生产进度明细
     * @return 结果
     */
    public int insertPesWieWorkProcessingLine(PesWieWorkProcessingLine pesWieWorkProcessingLine);

    /**
     * 修改工单生产进度明细
     * 
     * @param pesWieWorkProcessingLine 工单生产进度明细
     * @return 结果
     */
    public int updatePesWieWorkProcessingLine(PesWieWorkProcessingLine pesWieWorkProcessingLine);

    /**
     * 批量删除工单生产进度明细
     * 
     * @param workOrderIds 需要删除的工单生产进度明细ID
     * @return 结果
     */
    public int deletePesWieWorkProcessingLineByIds(Long[] workOrderIds);

    /**
     * 删除工单生产进度明细信息
     * 
     * @param workOrderId 工单生产进度明细ID
     * @return 结果
     */
    public int deletePesWieWorkProcessingLineById(Long workOrderId);

    int intiKey();

    AjaxResult insertBatchAndVerify(List<PesWieWorkProcessingLine> infoList);

    void insertHandle(PesWieWorkProcessingLine o);
}
