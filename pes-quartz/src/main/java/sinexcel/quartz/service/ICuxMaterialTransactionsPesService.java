package sinexcel.quartz.service;

import sinexcel.quartz.domain.CuxMaterialTransactionsPesEO;

import java.util.List;

public interface ICuxMaterialTransactionsPesService {

    /**
     * 查询工单发料列表
     *
     * @param cuxMaterialTransactionsPes 工单发料
     * @return 工单发料集合
     */
    public List<CuxMaterialTransactionsPesEO> selectCuxMaterialTransactionsPesList(CuxMaterialTransactionsPesEO cuxMaterialTransactionsPes);

    public CuxMaterialTransactionsPesEO selectCuxMaterialTransactionsByPesId(Integer id);

    /**
     * 修改工单发料
     *
     * @param cuxMaterialTransactionsPes 工单发料
     * @return 结果
     */
    public int updateCuxMaterialTransactionsPes(CuxMaterialTransactionsPesEO cuxMaterialTransactionsPes);

    public int selectSubmitWieToErp(CuxMaterialTransactionsPesEO cuxMaterialTransactionsPes) throws Exception;


}
