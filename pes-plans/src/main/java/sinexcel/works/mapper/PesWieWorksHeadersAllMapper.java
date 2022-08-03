package sinexcel.works.mapper;

import java.util.List;
import sinexcel.works.domain.PesWieWorksHeadersAll;

/**
 * 创建工单数据Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-04-18
 */
public interface PesWieWorksHeadersAllMapper 
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
     * 新增创建工单数据
     * 
     * @param pesWieWorksHeadersAll 创建工单数据
     * @return 结果
     */
    public int insertPesWieWorksHeadersAll(PesWieWorksHeadersAll pesWieWorksHeadersAll);

    /**
     * 修改创建工单数据
     * 
     * @param pesWieWorksHeadersAll 创建工单数据
     * @return 结果
     */
    public int updatePesWieWorksHeadersAll(PesWieWorksHeadersAll pesWieWorksHeadersAll);


    public List<PesWieWorksHeadersAll> getErpWorksLines(Long[] lineNums);

    public List<PesWieWorksHeadersAll> getErpSumWorksLines(Long[] lineNums);

    public int updateWorkFlag(String lineNums);

    public int updateSumWorkFlag(Long[] lineNums);

    public PesWieWorksHeadersAll selectOrgnazationCode(Long organizationId);

    public int updateErpWork(PesWieWorksHeadersAll getErpSumWorksLines);

    public int updateSplitQuantity(Long wieWorkId);

    public List<PesWieWorksHeadersAll> selectPesWieWorksHeadersAllByIds(Long[] wieWorkId);

    public int deleteErpWorks(Long[] wieWorkIds);

    public PesWieWorksHeadersAll selectItemDescriptions(PesWieWorksHeadersAll pesWieWorksHeadersAll);

    public PesWieWorksHeadersAll selectCustomerName(PesWieWorksHeadersAll getErpSumWorksLines);

    public PesWieWorksHeadersAll selectLinesData(String lineNums);
}
