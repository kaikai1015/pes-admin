package sinexcel.works.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.sun.xml.rpc.processor.model.soap.SOAPUnorderedStructureType;
import com.sun.xml.wss.impl.misc.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.ConfigUtils;
import sinexcel.common.utils.RestClient;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.common.utils.StringUtils;
import sinexcel.works.mapper.PesWieWorkMaterialsLinesMapper;
import sinexcel.works.domain.PesWieWorkMaterialsLines;
import sinexcel.works.service.IPesWieWorkMaterialsLinesService;

/**
 * 工单替代料数据Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-08-03
 */
@Service
public class PesWieWorkMaterialsLinesServiceImpl implements IPesWieWorkMaterialsLinesService 
{
    @Autowired
    private PesWieWorkMaterialsLinesMapper pesWieWorkMaterialsLinesMapper;

    public static final String CONTECT_TYPE = "application/vnd.oracle.adf.resourceitem+json";

    /**
     * 查询工单替代料数据
     * 
     * @param woOperationMaterialId 工单替代料数据ID
     * @return 工单替代料数据
     */
    @Override
    public PesWieWorkMaterialsLines selectPesWieWorkMaterialsLinesById(Long woOperationMaterialId)
    {
        return pesWieWorkMaterialsLinesMapper.selectPesWieWorkMaterialsLinesById(woOperationMaterialId);
    }

    /**
     * 查询工单替代料数据列表
     * 
     * @param pesWieWorkMaterialsLines 工单替代料数据
     * @return 工单替代料数据
     */
    @Override
    public List<PesWieWorkMaterialsLines> selectPesWieWorkMaterialsLinesList(PesWieWorkMaterialsLines pesWieWorkMaterialsLines)
    {
        return pesWieWorkMaterialsLinesMapper.selectPesWieWorkMaterialsLinesList(pesWieWorkMaterialsLines);
    }

    /**
     * 新增工单替代料数据
     * 
     * @param pesWieWorkMaterialsLines 工单替代料数据
     * @return 结果
     */
    @Override
    @Transactional
    public int insertPesWieWorkMaterialsLines(PesWieWorkMaterialsLines pesWieWorkMaterialsLines)
    {
        return pesWieWorkMaterialsLinesMapper.insertPesWieWorkMaterialsLines(pesWieWorkMaterialsLines);
    }

    /**
     * 修改工单替代料数据
     * 
     * @param pesWieWorkMaterialsLines 工单替代料数据
     * @return 结果
     */
    @Override
    @Transactional
    public int updatePesWieWorkMaterialsLines(PesWieWorkMaterialsLines pesWieWorkMaterialsLines)
    {
        checkUpdateAllowed(pesWieWorkMaterialsLines.getWoOperationMaterialId());
        pesWieWorkMaterialsLines.setTypeFlag("U");
        return pesWieWorkMaterialsLinesMapper.updatePesWieWorkMaterialsLines(pesWieWorkMaterialsLines);
    }

    public void checkUpdateAllowed(Long woOperationMaterialId)
    {
        if (pesWieWorkMaterialsLinesMapper.checkUpdateAllowed(woOperationMaterialId) > 0 ? true : false)
        {
            throw new CustomException("已经删除不允许更新！！！");
        }
    }

    /**
     * 批量删除工单替代料数据
     * 
     * @param woOperationMaterialIds 需要删除的工单替代料数据ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deletePesWieWorkMaterialsLinesByIds(Long[] woOperationMaterialIds)
    {
        return pesWieWorkMaterialsLinesMapper.deletePesWieWorkMaterialsLinesByIds(woOperationMaterialIds);
    }

    @Override
    @Transactional
    public int submiPesWieMaterialAll(Long[] woOperationMaterialIds)
    {
        int successNum = 0,failureNum = 0;
        StringBuilder failureMsg = new StringBuilder();
        List<PesWieWorkMaterialsLines> lists = pesWieWorkMaterialsLinesMapper.submiPesWieMaterialAll(woOperationMaterialIds);
        if(lists.size() > 0){
            for(int x = 0; x<lists.size();x++){
//            if("D".equals(lists.get(x).getTypeFlag())){//1.删除操作
//                //先获取ERP删除接口API地址
//                String getDelWorkLineUrl = ConfigUtils.getDelWorkLineUrl().replace("{WorkOrderId}",String.valueOf(lists.get(x).getWorkOrderId())).replace("{WorkOrderOperationId}",String.valueOf(lists.get(x).getWoOperationId())).replace("{WorkOrderOperationMaterialId}",String.valueOf(lists.get(x).getWoOperationMaterialId()));
//                int responseBodySta = RestClient.deleteData(getDelWorkLineUrl, ConfigUtils.getErpUser(),ConfigUtils.getErpPass());
//                if(responseBodySta==204){
//                    successNum++;
//                    pesWieWorkMaterialsLinesMapper.updateErpFlag(lists.get(x).getWoOperationMaterialId());
//                }else {
//                    failureNum++;
//                    failureMsg.append("行ID："+lists.get(x).getWoOperationMaterialId()+"；删除失败！！！");
//                }
//            }
//            if("U".equals(lists.get(x).getTypeFlag())){//2.更新操作
//                BigDecimal quantityPerProduct = lists.get(x).getQuantityPerProduct();
//                int responseBody= updateWorkLinessErp(lists.get(x),quantityPerProduct);
//                if(responseBody==200){
//                    successNum++;
//                    pesWieWorkMaterialsLinesMapper.updateErpFlag(lists.get(x).getWoOperationMaterialId());
//                }else{
//                    failureNum++;
//                    failureMsg.append("行ID："+lists.get(x).getWoOperationMaterialId()+"；更新失败！！！请检查日志数据："+responseBody);
//                }
//            }
//            if((StringUtils.isNull(lists.get(x).getTypeFlag()) || lists.get(x).getTypeFlag().isEmpty())){//3.替代
                //新增替代料
//                PesWieWorkMaterialsLines pesWieWorkMaterialsLines= pesWieWorkMaterialsLinesMapper.selectPesWieWorkMaterialsLinesById(lists.get(x).getWoOperationMaterialId());
//                if(pesWieWorkMaterialsLines.getRemainNewQuantity().compareTo(BigDecimal.ZERO)>-1){
                //先获取ERP更新接口API地址,新增替代之前需要修改原来的料号用量为0
                BigDecimal quantityPerProduct = BigDecimal.ZERO;
                int responseBodySta = updateWorkLinessErp(lists.get(x),quantityPerProduct);
                //拼接字符串
                if(responseBodySta==200){
                    try {
                        //先获取ERP新增接口API地址
                        String responseCreateBody = addWorkLinessErp(lists.get(x));
                        JSONObject responseJObject = JSONObject.parseObject(responseCreateBody);
                        Object ItemNumber = responseJObject.get("ItemNumber");
                        //调用成功
                        if (StringUtils.isNotNull(ItemNumber)) {
                            successNum++;
                            pesWieWorkMaterialsLinesMapper.updateErpFlag(lists.get(x).getTidaiId());
                            lists.get(x).setCreateBy(SecurityUtils.getUsername());
                            pesWieWorkMaterialsLinesMapper.addWorkLinresErp(lists.get(x));
                        }else {
                            failureNum++;
                            failureMsg.append("序号："+lists.get(x).getMaterialSeqNumber()+"替代物料ID："+lists.get(x).getNewInventoryItemId()+"替代比例："+lists.get(x).getNewPercentQuantity()+"；替代回写ERP失败！！！请检查日志数据："+responseCreateBody);
                        }
                    } catch (Exception e) {
                        failureNum++;
                        failureMsg.append("序号："+lists.get(x).getMaterialSeqNumber()+"替代物料ID："+lists.get(x).getNewInventoryItemId()+"替代比例："+lists.get(x).getNewPercentQuantity()+"；替代接口运行失败！！！请检查日志数据："+e.getMessage());
                    }
                }
//                }else {
//                    failureNum++;
//                    failureMsg.append("序号："+pesWieWorkMaterialsLines.getMaterialSeqNumber()+"替代物料ID："+pesWieWorkMaterialsLines.getNewInventoryItemId()+"替代比例："+pesWieWorkMaterialsLines.getNewPercentQuantity()+"；不符合替代条件！！！请检查日志数据：");
//                }
//            }
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，回写ERP失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new CustomException(failureMsg.toString());
        }
        return successNum;
    }

    public int updateWorkLinessErp(PesWieWorkMaterialsLines pesWieWorkMaterialsLines,BigDecimal quantityPerProduct)
    {
        //先获取ERP更新接口API地址
        String getUpdWorkLineUrl = ConfigUtils.getDelWorkLineUrl().replace("{WorkOrderId}",String.valueOf(pesWieWorkMaterialsLines.getWorkOrderId())).replace("{WorkOrderOperationId}",String.valueOf(pesWieWorkMaterialsLines.getWoOperationId())).replace("{WorkOrderOperationMaterialId}",String.valueOf(pesWieWorkMaterialsLines.getWoOperationMaterialId()));
        //拼接字符串
        JSONObject requestJsonObject = new JSONObject();
        requestJsonObject.put("QuantityPERProduct", quantityPerProduct);
        String requestBody = requestJsonObject.toJSONString();
        //连接发送报文
        return RestClient.patchData(getUpdWorkLineUrl, requestBody, CONTECT_TYPE, "UTF-8", ConfigUtils.getErpUser(), ConfigUtils.getErpPass());
    }

    public String addWorkLinessErp(PesWieWorkMaterialsLines pesWieWorkMaterialsLines) throws Exception {
        //先获取ERP新增接口API地址
        String getAddWorkLineUrl = ConfigUtils.getAddWorkLineUrl().replace("{WorkOrderId}",String.valueOf(pesWieWorkMaterialsLines.getWorkOrderId())).replace("{WorkOrderOperationId}",String.valueOf(pesWieWorkMaterialsLines.getWoOperationId()));
        //拼接字符串
        JSONObject requestJObject = new JSONObject();
        requestJObject.put("MaterialSequenceNumber", pesWieWorkMaterialsLines.getNewMaterialSeqNumber());
        requestJObject.put("InventoryItemId", pesWieWorkMaterialsLines.getNewInventoryItemId());
        requestJObject.put("QuantityPERProduct", pesWieWorkMaterialsLines.getNewPercentQuantity());

        //连接发送报文
        String requestCreateBody = requestJObject.toJSONString();

        return RestClient.postData(getAddWorkLineUrl, requestCreateBody, CONTECT_TYPE, "UTF-8", ConfigUtils.getErpUser(), ConfigUtils.getErpPass());
    }
}
