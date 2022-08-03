package sinexcel.daysPlan.service;

import sinexcel.daysPlan.domain.PesInvMaterialTxns;
import sinexcel.daysPlan.domain.PesProdProcessing;

import java.util.List;

/**
 * 发料进度Service接口
 * 
 * @author Zhang Kai
 * @date 2021-09-08
 */
public interface IPesProdProcessingService 
{
    /**
     * 查询发料进度
     * 
     * @param organizationId 发料进度ID
     * @return 发料进度
     */
    public PesProdProcessing selectPesProdProcessingById(Long organizationId);

    /**
     * 查询发料进度列表
     * 
     * @param pesProdProcessing 发料进度
     * @return 发料进度集合
     */
    public List<PesProdProcessing> selectPesProdProcessingList(PesProdProcessing pesProdProcessing);

    /**
     * 新增发料进度
     * 
     * @param pesProdProcessing 发料进度
     * @return 结果
     */
    public int insertPesProdProcessing(PesProdProcessing pesProdProcessing);

    /**
     * 修改发料进度
     * 
     * @param pesProdProcessing 发料进度
     * @return 结果
     */
    public int updatePesProdProcessing(PesProdProcessing pesProdProcessing);

    /**
     * 批量删除发料进度
     * 
     * @param organizationIds 需要删除的发料进度ID
     * @return 结果
     */
    public int deletePesProdProcessingByIds(Long[] organizationIds);

    /**
     * 删除发料进度信息
     * 
     * @param organizationId 发料进度ID
     * @return 结果
     */
    public int deletePesProdProcessingById(Long organizationId);

    /**
     * @Author mingshen.wang
     * @Description 生成发料进度基础数据
     * @Date 16:49 2021/9/9
     * @Param [id]
     * @return void
     **/
    void insertInit(Long pId,String isWw);

    /**
     * @Author mingshen.wang
     * @Description 根据出入库记录计算汇总
     * @Date 14:43 2021/9/14
     * @Param [pesInvMaterialTxns]
     * @return void
     **/
    void sumByInv(PesInvMaterialTxns pesInvMaterialTxns);

    List<PesProdProcessing> selectPesProdProcessingListWw(PesProdProcessing pesProdProcessing);
}
