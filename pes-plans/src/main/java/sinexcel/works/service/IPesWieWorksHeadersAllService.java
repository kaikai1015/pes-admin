package sinexcel.works.service;

import java.util.List;
import sinexcel.works.domain.PesWieWorksHeadersAll;

/**
 * 创建工单数据Service接口
 * 
 * @author Zhang Kai
 * @date 2021-04-18
 */
public interface IPesWieWorksHeadersAllService 
{
    /**
     * 查询创建工单数据
     * 
     * @param wieWorkId 创建工单数据ID
     * @return 创建工单数据
     */
    public PesWieWorksHeadersAll selectPesWieWorksHeadersAllById(Long wieWorkId);

    /**
     * 查询创建工单数据列表
     * 
     * @param pesWieWorksHeadersAll 创建工单数据
     * @return 创建工单数据集合
     */
    public List<PesWieWorksHeadersAll> selectPesWieWorksHeadersAllList(PesWieWorksHeadersAll pesWieWorksHeadersAll);


    /**
     * 修改创建工单数据
     * 
     * @param pesWieWorksHeadersAll 创建工单数据
     * @return 结果
     */
    public int updatePesWieWorksHeadersAll(PesWieWorksHeadersAll pesWieWorksHeadersAll);

    /**
     * 创建工单数据
     * 
     * @param lineNums 创建工单数据
     * @return 结果
     */
    public int erpWorksLines(Long[] lineNums);

    /**
     * 合并创建工单数据
     * 
     * @param lineNums 合并创建工单数据
     * @return 结果
     */
    public int erpSumWorksLines(Long[] lineNums);

    public int submitErpWorks(Long[] wieWorkIds);

    public int splitsErpWorks(Long wieWorkIds);

    public int releasedErpWorks(Long[] wieWorkIds);

    public int closedErpWorks(Long[] wieWorkIds);

    public int canceledErpWorks(Long[] wieWorkIds);

    public int patchErpWorks(Long[] wieWorkIds);

    public int deleteErpWorks(Long[] wieWorkIds);

    /**
     * 新增创建工单数据
     *
     * @param pesWieWorksHeadersAll 创建工单数据
     * @return 结果
     */
    public int insertPesWieWorksHeadersAll(PesWieWorksHeadersAll pesWieWorksHeadersAll);
}
