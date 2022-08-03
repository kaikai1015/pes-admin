package sinexcel.works.service.impl;

import java.util.List;

import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.DateUtils;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.common.utils.StringUtils;
import sinexcel.works.mapper.PesWieWorkOrdersOpsItemErpMapper;
import sinexcel.works.domain.PesWieWorkOrdersOpsItemErp;
import sinexcel.works.service.IPesWieWorkOrdersOpsItemErpService;


/**
 * 工单外协物料对照Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-12-13
 */
@Service
public class PesWieWorkOrdersOpsItemErpServiceImpl implements IPesWieWorkOrdersOpsItemErpService 
{
    @Autowired
    private PesWieWorkOrdersOpsItemErpMapper pesWieWorkOrdersOpsItemErpMapper;


    /**
     * 查询工单外协物料对照列表
     * 
     * @param pesWorkOrderId 工单外协物料对照
     * @return 工单外协物料对照
     */
    @Override
    public List<PesWieWorkOrdersOpsItemErp> selectPesWieWorkOrdersOpsItemErpList(Long pesWorkOrderId)
    {
        return pesWieWorkOrdersOpsItemErpMapper.selectPesWieWorkOrdersOpsItemErpList(pesWorkOrderId);
    }

    @Override
    public List<PesWieWorkOrdersOpsItemErp> selectPesWieWorkOrdersOpsItemErpListExport()
    {
        return pesWieWorkOrdersOpsItemErpMapper.selectPesWieWorkOrdersOpsItemErpListExport();
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int addPesWieWorkOrdersOpsItemErpById(Long wieOpsItemId,Long pesWorkOrderId)
    {
        PesWieWorkOrdersOpsItemErp pesWieWorkOrdersOpsItemErp = pesWieWorkOrdersOpsItemErpMapper.selectPesWieWorkOrdersOpsItemErpById(wieOpsItemId);
        pesWieWorkOrdersOpsItemErp.setPesWorkOrderId(pesWorkOrderId);
        pesWieWorkOrdersOpsItemErp.setCreateBy(SecurityUtils.getUsername());
        pesWieWorkOrdersOpsItemErp.setCreateDate(DateUtils.getNowDate());
        pesWieWorkOrdersOpsItemErpMapper.updatePesWieWorkOrderOperationErp(pesWieWorkOrdersOpsItemErp);
        //插入日志
        pesWieWorkOrdersOpsItemErp.setRemark("费用物料添加");
        pesWieWorkOrdersOpsItemErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrdersOpsItemErp);
        pesWieWorkOrdersOpsItemErp.setOspItemNumber(pesWieWorkOrdersOpsItemErp.getSupplierNumber()+'/'+pesWieWorkOrdersOpsItemErp.getOspItemNumber());
        pesWieWorkOrdersOpsItemErp.setOspItemDescription(pesWieWorkOrdersOpsItemErp.getSupplierName());
        pesWieWorkOrdersOpsItemErp.setRemark("外协供应商添加");
        return pesWieWorkOrdersOpsItemErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrdersOpsItemErp);
    }

    @Override
    public List<PesWieWorkOrdersOpsItemErp> getSelectPesWieWorkOrdersOpsItemErpList(PesWieWorkOrdersOpsItemErp pesWieWorkOrdersOpsItemErp)
    {
        return pesWieWorkOrdersOpsItemErpMapper.getSelectPesWieWorkOrdersOpsItemErpList(pesWieWorkOrdersOpsItemErp);
    }

    /**
     * 查询工单外协物料对照
     *
     * @param wieOpsItemId 工单外协物料对照ID
     * @return 工单外协物料对照
     */
    @Override
    public PesWieWorkOrdersOpsItemErp selectPesWieWorkOrdersOpsItemErpById(Long wieOpsItemId)
    {
        return pesWieWorkOrdersOpsItemErpMapper.selectPesWieWorkOrdersOpsItemErpById(wieOpsItemId);
    }

    /**
     * 修改工单外协物料对照
     *
     * @param pesWieWorkOrdersOpsItemErp 工单外协物料对照
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int updatePesWieWorkOrdersOpsItemErp(PesWieWorkOrdersOpsItemErp pesWieWorkOrdersOpsItemErp)
    {
        if(pesWieWorkOrdersOpsItemErpMapper.selectPesWieWorkByIds(pesWieWorkOrdersOpsItemErp.getPesWorkOrderId()) > 0){
            throw new CustomException("当前工单状态不允许变更供应商信息！！！");
        }
        if(StringUtils.isNull(pesWieWorkOrdersOpsItemErp.getWieOpsItemId())){
            //工序修改供应商
            PesWieWorkOrdersOpsItemErp getOspSupplierList = pesWieWorkOrdersOpsItemErpMapper.selectGetOspSupplierList(pesWieWorkOrdersOpsItemErp.getSupplierId());
            pesWieWorkOrdersOpsItemErp.setSupplierId(getOspSupplierList.getSupplierId());
            pesWieWorkOrdersOpsItemErp.setSupplierNumber(getOspSupplierList.getSupplierNumber());
            pesWieWorkOrdersOpsItemErp.setSupplierName(getOspSupplierList.getSupplierName());
            pesWieWorkOrdersOpsItemErp.setSupplierSiteId(getOspSupplierList.getSupplierSiteId());
            pesWieWorkOrdersOpsItemErp.setOrganizationId(pesWieWorkOrdersOpsItemErpMapper.selectOrganizationIdByPesWorkOrderIds(pesWieWorkOrdersOpsItemErp.getPesWorkOrderId()).getOrganizationId());
            PesWieWorkOrdersOpsItemErp getOspItemDescriptionList = pesWieWorkOrdersOpsItemErpMapper.selectGetOspItemDescriptionList(pesWieWorkOrdersOpsItemErp);
            if(StringUtils.isNull(getOspItemDescriptionList)){
                throw new CustomException("输入的料号："+pesWieWorkOrdersOpsItemErp.getOspItemNumber()+"不是费用料号！！！");
            }
            pesWieWorkOrdersOpsItemErp.setOspItemId(getOspItemDescriptionList.getOspItemId());
            pesWieWorkOrdersOpsItemErp.setOspItemNumber(getOspItemDescriptionList.getOspItemNumber());
            pesWieWorkOrdersOpsItemErp.setOspItemDescription(getOspItemDescriptionList.getOspItemDescription());
            pesWieWorkOrdersOpsItemErp.setCreateBy(SecurityUtils.getUsername());
            pesWieWorkOrdersOpsItemErp.setCreateDate(DateUtils.getNowDate());
            pesWieWorkOrdersOpsItemErpMapper.updatePesWieWorkOrderOperationErp(pesWieWorkOrdersOpsItemErp);

            //插入日志
            pesWieWorkOrdersOpsItemErp.setRemark("费用物料修改");
            pesWieWorkOrdersOpsItemErp.setWieOpsItemId(pesWieWorkOrdersOpsItemErp.getPesWorkOrderId());
            pesWieWorkOrdersOpsItemErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrdersOpsItemErp);
            pesWieWorkOrdersOpsItemErp.setOspItemNumber(pesWieWorkOrdersOpsItemErp.getSupplierNumber()+'/'+pesWieWorkOrdersOpsItemErp.getOspItemNumber());
            pesWieWorkOrdersOpsItemErp.setOspItemDescription(pesWieWorkOrdersOpsItemErp.getSupplierName());
            pesWieWorkOrdersOpsItemErp.setRemark("外协供应商修改");
            return pesWieWorkOrdersOpsItemErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrdersOpsItemErp);

        }else {
            if(pesWieWorkOrdersOpsItemErpMapper.updatePesWieWorkOrdersOpsItemErpById(pesWieWorkOrdersOpsItemErp) > 0){
                throw new CustomException("优先级已经存在！！！");
            }
            pesWieWorkOrdersOpsItemErp.setCreateBy(SecurityUtils.getUsername());
            pesWieWorkOrdersOpsItemErp.setCreateDate(DateUtils.getNowDate());

            return pesWieWorkOrdersOpsItemErpMapper.updatePesWieWorkOrdersOpsItemErp(pesWieWorkOrdersOpsItemErp);
        }
    }


    /**
     * 新增工单外协物料对照
     *
     * @param pesWieWorkOrdersOpsItemErp 工单外协物料对照
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int insertPesWieWorkOrdersOpsItemErp(PesWieWorkOrdersOpsItemErp pesWieWorkOrdersOpsItemErp)
    {
//        Long wx = 300000004927942L;
        if(pesWieWorkOrdersOpsItemErpMapper.updatePesWieWorkOrdersOpsItemErpById(pesWieWorkOrdersOpsItemErp) > 0){
            throw new CustomException("优先级已经存在！！！");
        }
        PesWieWorkOrdersOpsItemErp wieWorkCenterId = pesWieWorkOrdersOpsItemErpMapper.selectWieWorkCenterId(pesWieWorkOrdersOpsItemErp);
        pesWieWorkOrdersOpsItemErp.setWorkCenterId(wieWorkCenterId.getWorkCenterId());
        PesWieWorkOrdersOpsItemErp getPItemDescriptionList = pesWieWorkOrdersOpsItemErpMapper.selectGetPItemDescriptionList(pesWieWorkOrdersOpsItemErp);
        pesWieWorkOrdersOpsItemErp.setpItemNumber(getPItemDescriptionList.getpItemNumber());
        pesWieWorkOrdersOpsItemErp.setpItemDescription(getPItemDescriptionList.getpItemDescription());
        if("Y".equals(wieWorkCenterId.getIsWwFlag())){
            PesWieWorkOrdersOpsItemErp getOspSupplierList = pesWieWorkOrdersOpsItemErpMapper.selectGetOspSupplierList(pesWieWorkOrdersOpsItemErp.getSupplierId());
            pesWieWorkOrdersOpsItemErp.setSupplierId(getOspSupplierList.getSupplierId());
            pesWieWorkOrdersOpsItemErp.setSupplierNumber(getOspSupplierList.getSupplierNumber());
            pesWieWorkOrdersOpsItemErp.setSupplierName(getOspSupplierList.getSupplierName());
            pesWieWorkOrdersOpsItemErp.setSupplierSiteId(getOspSupplierList.getSupplierSiteId());
            PesWieWorkOrdersOpsItemErp getOspItemDescriptionList = pesWieWorkOrdersOpsItemErpMapper.selectGetOspItemDescriptionList(pesWieWorkOrdersOpsItemErp);
            if(StringUtils.isNull(getOspItemDescriptionList)){
                throw new CustomException("输入的料号："+pesWieWorkOrdersOpsItemErp.getOspItemNumber()+"不是费用料号！！");
            }
            if(!getOspItemDescriptionList.getOspItemDescription().contains(pesWieWorkOrdersOpsItemErp.getpItemNumber())){
                throw new CustomException("费用料号不一致，费用料号不一致");
            }
            pesWieWorkOrdersOpsItemErp.setOspItemId(getOspItemDescriptionList.getOspItemId());
            pesWieWorkOrdersOpsItemErp.setOspItemNumber(getOspItemDescriptionList.getOspItemNumber());
            pesWieWorkOrdersOpsItemErp.setOspItemDescription(getOspItemDescriptionList.getOspItemDescription());
        }
        pesWieWorkOrdersOpsItemErp.setCreateBy(SecurityUtils.getUsername());
        pesWieWorkOrdersOpsItemErp.setCreateDate(DateUtils.getNowDate());
        return pesWieWorkOrdersOpsItemErpMapper.insertPesWieWorkOrdersOpsItemErp(pesWieWorkOrdersOpsItemErp);
    }

    /**
     * 删除工单外协物料对照信息
     *
     * @param wieOpsItemId 工单外协物料对照ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int deletePesWieWorkOrdersOpsItemErpById(Long wieOpsItemId)
    {
        return pesWieWorkOrdersOpsItemErpMapper.deletePesWieWorkOrdersOpsItemErpById(wieOpsItemId);
    }

}
