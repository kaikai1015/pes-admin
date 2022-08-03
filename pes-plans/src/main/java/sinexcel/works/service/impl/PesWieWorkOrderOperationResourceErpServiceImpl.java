package sinexcel.works.service.impl;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.*;
import sinexcel.works.domain.PesWieWorkOrderOperationResourceErp;
import sinexcel.works.mapper.PesWieWorkOrderOperationResourceErpMapper;
import sinexcel.works.service.IPesWieWorkOrderOperationResourceErpService;

import java.util.List;


/**
 * PES工单资源工时Service业务层处理
 *
 * @author Zhang Kai
 * @date 2021-12-27
 */
@Service
public class PesWieWorkOrderOperationResourceErpServiceImpl implements IPesWieWorkOrderOperationResourceErpService {


    @Autowired
    private PesWieWorkOrderOperationResourceErpMapper pesWieWorkOrderOperationResourceErpMapper;

    public static final String CONTECT_TYPE = "application/vnd.oracle.adf.resourceitem+json";

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int insertResourcePesWieWorkOrderOperationErpByOperationId(Long pesWorkOrderId, Long pesWorkOrderOperationId)
    {
        PesWieWorkOrderOperationResourceErp pesWieWorkOrderOperationResourceErp = pesWieWorkOrderOperationResourceErpMapper.selectPesWieWorkOrderOperationResourceErpById(pesWorkOrderId);
        if(StringUtils.isNull(pesWieWorkOrderOperationResourceErp)){
            return 1;
        }
        pesWieWorkOrderOperationResourceErp.setCreateBy(SecurityUtils.getUsername());
        pesWieWorkOrderOperationResourceErp.setCreateDate(DateUtils.getNowDate());
        pesWieWorkOrderOperationResourceErp.setPesWorkOrderOperationId(pesWorkOrderOperationId);
        pesWieWorkOrderOperationResourceErp.setWorkOrderId(0L);
        pesWieWorkOrderOperationResourceErp.setWorkOrderOperationId(0L);
        pesWieWorkOrderOperationResourceErp.setWorkOrderOperationResourceId(0L);
        pesWieWorkOrderOperationResourceErp.setUsageRate(pesWieWorkOrderOperationResourceErp.getUsageRateF());
        pesWieWorkOrderOperationResourceErp.setAssignedUnits(pesWieWorkOrderOperationResourceErp.getAssignedUnitsF());
        pesWieWorkOrderOperationResourceErp.setResourceRequenceNumber(10);
        pesWieWorkOrderOperationResourceErp.setResourceCode("ZY001");
        pesWieWorkOrderOperationResourceErp.setResourceName("人工");
        pesWieWorkOrderOperationResourceErpMapper.insertResourcePesWieWorkOrderOperationErpByOperationId(pesWieWorkOrderOperationResourceErp);
        pesWieWorkOrderOperationResourceErp.setUsageRate(pesWieWorkOrderOperationResourceErp.getUsageRateS());
        pesWieWorkOrderOperationResourceErp.setAssignedUnits(pesWieWorkOrderOperationResourceErp.getAssignedUnitsS());
        pesWieWorkOrderOperationResourceErp.setResourceRequenceNumber(20);
        pesWieWorkOrderOperationResourceErp.setResourceCode("ZY002");
        pesWieWorkOrderOperationResourceErp.setResourceName("制费");
        return pesWieWorkOrderOperationResourceErpMapper.insertResourcePesWieWorkOrderOperationErpByOperationId(pesWieWorkOrderOperationResourceErp);
    }

    @Override
    public int handleSubmitErpPesWieWorkOrdersBErpByIdsJob(String endName)
    {
        List<PesWieWorkOrderOperationResourceErp> pesWieWorkOrderOperationResourceErpList = pesWieWorkOrderOperationResourceErpMapper.handleSubmitErpPesWieWorkOrdersBErpByIdsJob();
        if(pesWieWorkOrderOperationResourceErpList.size() > 0){
            pesWieWorkOrderOperationResourceErpList.stream().forEach(pesWieWorkOrderOperationResourceErp ->
                    {
                        handleSubmitErpPesOperationMaterialResourceByIds(pesWieWorkOrderOperationResourceErp.getPesWorkOrderOperationId(),endName);
                    }
            );
        }
        return 1;
    }

    @Override
    public int handleSubmitErpPesOperationMaterialResourceByIds(Long pesWorkOrderOperationId, String endName)
    {
        List<PesWieWorkOrderOperationResourceErp> pesWieWorkOrderOperationResourceErps = pesWieWorkOrderOperationResourceErpMapper.getHandleSubmitErpPesOperationMaterialResourceByIds(pesWorkOrderOperationId);
        if(pesWieWorkOrderOperationResourceErps.size() > 0){
            for (PesWieWorkOrderOperationResourceErp pesWieWorkOrderOperationResourceErp:pesWieWorkOrderOperationResourceErps){
                if(pesWieWorkOrderOperationResourceErp.getWorkOrderOperationId().longValue() > 0){
                    //先获取API地址
                    String getWieWorksOperationResourceUrl = ConfigUtils.getWieWorksOperationResourceUrl().replace("{WorkOrderId}",String.valueOf(pesWieWorkOrderOperationResourceErp.getWorkOrderId())).replace("{WorkOrderOperationId}",String.valueOf(pesWieWorkOrderOperationResourceErp.getWorkOrderOperationId()));
                    //Json头信息
                    JSONObject requestJsonObject = new JSONObject();
                    requestJsonObject.put("ResourceSequenceNumber", pesWieWorkOrderOperationResourceErp.getResourceRequenceNumber());
                    requestJsonObject.put("ResourceCode", pesWieWorkOrderOperationResourceErp.getResourceCode());
                    requestJsonObject.put("PrincipalFlag", false);
                    requestJsonObject.put("UsageRate", pesWieWorkOrderOperationResourceErp.getUsageRate());
//                    requestJsonObject.put("AssignedUnits", pesWieWorkOrderOperationResourceErp.getAssignedUnits());
                    requestJsonObject.put("BasisType", "1");
                    requestJsonObject.put("ChargeType", "AUTOMATIC");

                    //Json转换
                    String requestBody = requestJsonObject.toJSONString();
                    try {
                        //发送POST请求
                        String responseBody = RestClient.postData(getWieWorksOperationResourceUrl, requestBody, CONTECT_TYPE, "UTF-8",ConfigUtils.getErpUser(), ConfigUtils.getErpPass());
                        //返回值解析
                        JSONObject responseJsonObject = JSONObject.parseObject(responseBody);
                        Object workOrderOperationResourceId = responseJsonObject.get("WorkOrderOperationResourceId");

                        pesWieWorkOrderOperationResourceErp.setErpType(0);
                        //调用成功
                        if (StringUtils.isNotNull(workOrderOperationResourceId)) {
                            pesWieWorkOrderOperationResourceErp.setWorkOrderOperationResourceId(Long.valueOf(String.valueOf(workOrderOperationResourceId)));
                            pesWieWorkOrderOperationResourceErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                            pesWieWorkOrderOperationResourceErp.setCreateDate(DateUtils.getNowDate());
                            pesWieWorkOrderOperationResourceErp.setRemark("OK");
                            pesWieWorkOrderOperationResourceErp.setErpFlag("1");
                            pesWieWorkOrderOperationResourceErpMapper.updatePesWieWorkOrdersResourceErpByWorkOrderId(pesWieWorkOrderOperationResourceErp);
                            //回传成功插入回传记录表
                            pesWieWorkOrderOperationResourceErpMapper.insertPesWieWorkOrdersResourceErpByWorkOrderId(pesWieWorkOrderOperationResourceErp);
                            System.out.println("资源："+pesWieWorkOrderOperationResourceErp.getResourceName());
                        }else {
                            pesWieWorkOrderOperationResourceErp.setWorkOrderOperationResourceId(0L);
                            pesWieWorkOrderOperationResourceErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                            pesWieWorkOrderOperationResourceErp.setCreateDate(DateUtils.getNowDate());
                            pesWieWorkOrderOperationResourceErp.setRemark(StringUtils.substring("报文："+requestBody+"，异常信息："+responseBody, 0, 4000));
                            pesWieWorkOrderOperationResourceErp.setErpFlag("2");
                            pesWieWorkOrderOperationResourceErpMapper.insertPesWieWorkOrdersResourceErpByWorkOrderId(pesWieWorkOrderOperationResourceErp);
                        }

                    } catch (JSONException ex) {
                        pesWieWorkOrderOperationResourceErp.setWorkOrderOperationResourceId(0L);
                        pesWieWorkOrderOperationResourceErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                        pesWieWorkOrderOperationResourceErp.setCreateDate(DateUtils.getNowDate());
                        pesWieWorkOrderOperationResourceErp.setRemark(ex.getMessage());
                        pesWieWorkOrderOperationResourceErp.setErpFlag("2");
                        pesWieWorkOrderOperationResourceErpMapper.insertPesWieWorkOrdersResourceErpByWorkOrderId(pesWieWorkOrderOperationResourceErp);

                    } catch (Exception ex) {
                        pesWieWorkOrderOperationResourceErp.setWorkOrderOperationResourceId(0L);
                        pesWieWorkOrderOperationResourceErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                        pesWieWorkOrderOperationResourceErp.setErpFlag("2");
                        pesWieWorkOrderOperationResourceErp.setCreateDate(DateUtils.getNowDate());
                        pesWieWorkOrderOperationResourceErp.setRemark(ex.getMessage());
                        pesWieWorkOrderOperationResourceErpMapper.insertPesWieWorkOrdersResourceErpByWorkOrderId(pesWieWorkOrderOperationResourceErp);
                    }
                }
            }
        }

        return 1;
    }
    @Override
    public int updateSubmitErpPesWieWorkOrdersBErpByIdsJob(String endName)
    {
        List<PesWieWorkOrderOperationResourceErp> pesWieWorkOrderOperationResourceErps = pesWieWorkOrderOperationResourceErpMapper.updateSubmitErpPesWieWorkOrdersBErpByIdsJob();

        if(pesWieWorkOrderOperationResourceErps.size() > 0){
            for (PesWieWorkOrderOperationResourceErp pesWieWorkOrderOperationResourceErp:pesWieWorkOrderOperationResourceErps){
                //先获取API地址
                String updateWieWorksOperationResourceUrl = ConfigUtils.getUpdateWieWorksOperationResourceUrl().replace("{WorkOrderId}",String.valueOf(pesWieWorkOrderOperationResourceErp.getWorkOrderId())).replace("{WorkOrderOperationId}",String.valueOf(pesWieWorkOrderOperationResourceErp.getWorkOrderOperationId())).replace("{WorkOrderOperationResourceId}",String.valueOf(pesWieWorkOrderOperationResourceErp.getWorkOrderOperationResourceId()));
                //拼接字符串
                JSONObject requestJsonObject = new JSONObject();
                requestJsonObject.put("AssignedUnits", pesWieWorkOrderOperationResourceErp.getAssignedUnits());
                requestJsonObject.put("UsageRate", pesWieWorkOrderOperationResourceErp.getUsageRate());
                String requestBody = requestJsonObject.toJSONString();
                //插入回传记录表的0代表新建数据，1变更数据
                pesWieWorkOrderOperationResourceErp.setErpType(1);
                try {
                    //连接发送报文
                    int responseBodySta = RestClient.patchData(updateWieWorksOperationResourceUrl, requestBody, CONTECT_TYPE, "UTF-8", ConfigUtils.getErpUser(), ConfigUtils.getErpPass());

                    //调用成功
                    if (responseBodySta==200) {
                        pesWieWorkOrderOperationResourceErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                        pesWieWorkOrderOperationResourceErp.setCreateDate(DateUtils.getNowDate());
                        pesWieWorkOrderOperationResourceErp.setRemark("OK");
                        pesWieWorkOrderOperationResourceErp.setErpFlag("1");
                        //回传成功插入回传记录表
                        pesWieWorkOrderOperationResourceErpMapper.updatePesWieWorkOrdersResourceErpByWorkOrderId(pesWieWorkOrderOperationResourceErp);
                        //回传成功更新erp_submit_date
                        pesWieWorkOrderOperationResourceErpMapper.insertPesWieWorkOrdersResourceErpByWorkOrderId(pesWieWorkOrderOperationResourceErp);
                        System.out.println("资源代码："+pesWieWorkOrderOperationResourceErp.getResourceCode()+"，资源名称："+pesWieWorkOrderOperationResourceErp.getResourceName());
                    }else {
                        pesWieWorkOrderOperationResourceErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                        pesWieWorkOrderOperationResourceErp.setCreateDate(DateUtils.getNowDate());
                        pesWieWorkOrderOperationResourceErp.setRemark(StringUtils.substring("报文："+requestBody+"，异常信息："+responseBodySta, 0, 4000));
                        pesWieWorkOrderOperationResourceErp.setErpFlag("2");
                        //回传成功插入回传记录表
                        pesWieWorkOrderOperationResourceErpMapper.insertPesWieWorkOrdersResourceErpByWorkOrderId(pesWieWorkOrderOperationResourceErp);
                    }

                } catch (JSONException ex) {
                    pesWieWorkOrderOperationResourceErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                    pesWieWorkOrderOperationResourceErp.setCreateDate(DateUtils.getNowDate());
                    pesWieWorkOrderOperationResourceErp.setRemark(ex.getMessage());
                    pesWieWorkOrderOperationResourceErp.setErpFlag("2");
                    //回传成功插入回传记录表
                    pesWieWorkOrderOperationResourceErpMapper.insertPesWieWorkOrdersResourceErpByWorkOrderId(pesWieWorkOrderOperationResourceErp);

                } catch (Exception ex) {
                    pesWieWorkOrderOperationResourceErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                    pesWieWorkOrderOperationResourceErp.setRemark(ex.getMessage());
                    pesWieWorkOrderOperationResourceErp.setCreateDate(DateUtils.getNowDate());
                    pesWieWorkOrderOperationResourceErp.setErpFlag("2");
                    //回传成功插入回传记录表
                    pesWieWorkOrderOperationResourceErpMapper.insertPesWieWorkOrdersResourceErpByWorkOrderId(pesWieWorkOrderOperationResourceErp);
                }

            }
        }

        return 1;
    }

    @Override
    public List<PesWieWorkOrderOperationResourceErp> selectPesWieWorkOrderOperationResourceErpById(Long pesWorkOrderOperationId)
    {
        return pesWieWorkOrderOperationResourceErpMapper.handleSubmitErpPesOperationMaterialResourceByIds(pesWorkOrderOperationId);
    }

    @Override
    public PesWieWorkOrderOperationResourceErp selectPesWieWorkOrderOperationResourceErpByIds(Long pesWorkOrderOperationResourceId)
    {
        return pesWieWorkOrderOperationResourceErpMapper.selectPesWieWorkOrderOperationResourceErpByIds(pesWorkOrderOperationResourceId);
    }

    /**
     * 修改PES工单资源工时
     *
     * @param pesWieWorkOrderOperationResourceErp PES工单资源工时
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int updatePesWieWorkOrderOperationResourceErp(PesWieWorkOrderOperationResourceErp pesWieWorkOrderOperationResourceErp)
    {
        //关闭取消等状态不允许修改已取消，已关闭，已删除
        PesWieWorkOrderOperationResourceErp getPesWieWorkOrderStatusIdByIds = pesWieWorkOrderOperationResourceErpMapper.selectPesWieWorkOrderStatusIdByIds(pesWieWorkOrderOperationResourceErp.getPesWorkOrderId());
        if("Y".equals(getPesWieWorkOrderStatusIdByIds.getWorkOrderTypeId())&&(getPesWieWorkOrderStatusIdByIds.getWorkOrderStatusId()==10002||getPesWieWorkOrderStatusIdByIds.getWorkOrderStatusId()==10003||getPesWieWorkOrderStatusIdByIds.getWorkOrderStatusId()==10004||getPesWieWorkOrderStatusIdByIds.getWorkOrderStatusId()==10005||getPesWieWorkOrderStatusIdByIds.getWorkOrderStatusId()==10007)){
            pesWieWorkOrderOperationResourceErp.setCreateBy(SecurityUtils.getUsername());
            pesWieWorkOrderOperationResourceErp.setCreateDate(DateUtils.getNowDate());
            pesWieWorkOrderOperationResourceErpMapper.updatePesWieWorkOrderOperationResourceErp(pesWieWorkOrderOperationResourceErp);
            //回传成功插入回传记录表
            pesWieWorkOrderOperationResourceErp.setRemark("OK");
            pesWieWorkOrderOperationResourceErp.setErpFlag("0");
            pesWieWorkOrderOperationResourceErp.setErpType(1);
        }else {
            throw new CustomException("此工单不允许操作！！！");
        }
        return pesWieWorkOrderOperationResourceErpMapper.insertPesWieWorkOrdersResourceErpByWorkOrderId(pesWieWorkOrderOperationResourceErp);
    }

    /**
     * 新增PES工单资源工时
     *
     * @param pesWieWorkOrderOperationResourceErp PES工单资源工时
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int insertPesWieWorkOrderOperationResourceErp(PesWieWorkOrderOperationResourceErp pesWieWorkOrderOperationResourceErp)
    {
        pesWieWorkOrderOperationResourceErp.setCreateBy(SecurityUtils.getUsername());
        pesWieWorkOrderOperationResourceErp.setCreateDate(DateUtils.getNowDate());
        PesWieWorkOrderOperationResourceErp getResourcePesWieWorkIds = pesWieWorkOrderOperationResourceErpMapper.selectResourcePesWieWorkOrderOperationErpByOperationId(pesWieWorkOrderOperationResourceErp.getPesWorkOrderOperationId());
        pesWieWorkOrderOperationResourceErp.setPesWorkOrderId(getResourcePesWieWorkIds.getPesWorkOrderId());
        //关闭取消等状态不允许修改已取消，已关闭，已删除
        PesWieWorkOrderOperationResourceErp getPesWieWorkOrderStatusIdByIds = pesWieWorkOrderOperationResourceErpMapper.selectPesWieWorkOrderStatusIdByIds(pesWieWorkOrderOperationResourceErp.getPesWorkOrderId());
        if("Y".equals(getPesWieWorkOrderStatusIdByIds.getWorkOrderTypeId())&&(getPesWieWorkOrderStatusIdByIds.getWorkOrderStatusId()==10002||getPesWieWorkOrderStatusIdByIds.getWorkOrderStatusId()==10003||getPesWieWorkOrderStatusIdByIds.getWorkOrderStatusId()==10004||getPesWieWorkOrderStatusIdByIds.getWorkOrderStatusId()==10005||getPesWieWorkOrderStatusIdByIds.getWorkOrderStatusId()==10007)){
            pesWieWorkOrderOperationResourceErp.setWorkOrderId(getResourcePesWieWorkIds.getWorkOrderId());
            pesWieWorkOrderOperationResourceErp.setWorkOrderOperationId(getResourcePesWieWorkIds.getWorkOrderOperationId());
            pesWieWorkOrderOperationResourceErp.setPesWorkOrderOperationId(getResourcePesWieWorkIds.getPesWorkOrderOperationId());
            pesWieWorkOrderOperationResourceErp.setWorkOrderOperationResourceId(0L);
            pesWieWorkOrderOperationResourceErp.setResourceCode(pesWieWorkOrderOperationResourceErp.getResourceRequenceNumber() == 10?"ZY001":"ZY002");
            pesWieWorkOrderOperationResourceErp.setResourceName(pesWieWorkOrderOperationResourceErp.getResourceRequenceNumber() == 10?"人工":"制费");
            pesWieWorkOrderOperationResourceErpMapper.insertResourcePesWieWorkOrderOperationErpByOperationId(pesWieWorkOrderOperationResourceErp);
        }else {
            throw new CustomException("此工单不允许操作！！！");
        }
        //回传成功插入回传记录表
        pesWieWorkOrderOperationResourceErp.setErpType(1);
        pesWieWorkOrderOperationResourceErp.setRemark("工时信息变更");
        pesWieWorkOrderOperationResourceErp.setErpFlag("0");
        return pesWieWorkOrderOperationResourceErpMapper.insertPesWieWorkOrdersResourceErpByWorkOrderId(pesWieWorkOrderOperationResourceErp);
    }
}
