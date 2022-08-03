package sinexcel.works.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.ConfigUtils;
import sinexcel.common.utils.RestClient;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.common.utils.StringUtils;
import sinexcel.works.mapper.PesWieWorksHeadersAllMapper;
import sinexcel.works.domain.PesWieWorksHeadersAll;
import sinexcel.works.service.IPesWieWorksHeadersAllService;

/**
 * 创建工单数据Service业务层处理
 *
 * @author Zhang Kai
 * @date 2021-04-18
 */
@Service
public class PesWieWorksHeadersAllServiceImpl implements IPesWieWorksHeadersAllService
{
    @Autowired
    private PesWieWorksHeadersAllMapper pesWieWorksHeadersAllMapper;

    public static final String workOrderStatusCode = "ORA_UNRELEASED";
    public static final String serialTrackingFlag = "false";
    public static final String explosionFlag = "true";
    public static final String firmPlannedFlag = "true";
    public static final String CONTECT_TYPE = "application/vnd.oracle.adf.resourceitem+json";

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 查询创建工单数据
     *
     * @param wieWorkId 创建工单数据ID
     * @return 创建工单数据
     */
    @Override
    public PesWieWorksHeadersAll selectPesWieWorksHeadersAllById(Long wieWorkId)
    {
        return pesWieWorksHeadersAllMapper.selectPesWieWorksHeadersAllById(wieWorkId);
    }

    /**
     * 查询创建工单数据列表
     *
     * @param pesWieWorksHeadersAll 创建工单数据
     * @return 创建工单数据
     */
    @Override
    public List<PesWieWorksHeadersAll> selectPesWieWorksHeadersAllList(PesWieWorksHeadersAll pesWieWorksHeadersAll)
    {
        return pesWieWorksHeadersAllMapper.selectPesWieWorksHeadersAllList(pesWieWorksHeadersAll);
    }

    /**
     * 修改创建工单数据
     *
     * @param pesWieWorksHeadersAll 创建工单数据
     * @return 结果
     */
    @Override
    @Transactional
    public int updatePesWieWorksHeadersAll(PesWieWorksHeadersAll pesWieWorksHeadersAll)
    {
        int up = 0;
        pesWieWorksHeadersAll.setLastUpdateBy(SecurityUtils.getUsername());
        PesWieWorksHeadersAll statusValues = pesWieWorksHeadersAllMapper.selectPesWieWorksHeadersAllById(pesWieWorksHeadersAll.getWieWorkId());
        if(StringUtils.isNull(statusValues.getErpWorkStatus()) || statusValues.getErpWorkStatus() == 10004 || statusValues.getErpWorkStatus() == 10005){
            up = pesWieWorksHeadersAllMapper.updatePesWieWorksHeadersAll(pesWieWorksHeadersAll);
        }else {
            throw new CustomException("不允许修改，请核对工单状态！！！");
        }
        return up;
    }

    /**
     * 创建工单数据
     *
     * @param lineNums 创建工单数据
     * @return 结果
     */
    @Override
    @Transactional
    public int erpWorksLines(Long[] lineNums)
    {
        int i = 0;
        List<PesWieWorksHeadersAll> getErpWorksLines = pesWieWorksHeadersAllMapper.getErpWorksLines(lineNums);
        for(PesWieWorksHeadersAll getErpWorksLine:getErpWorksLines){
            getErpWorksLine.setCreateBy(SecurityUtils.getUsername());
            pesWieWorksHeadersAllMapper.insertPesWieWorksHeadersAll(getErpWorksLine);
            pesWieWorksHeadersAllMapper.updateWorkFlag(getErpWorksLine.getLineNums());
            i++;
        }
        return i;
    }

    /**
     * 合并创建工单数据
     *
     * @param lineNums 创建工单数据
     * @return 结果
     */
    @Override
    @Transactional
    public int erpSumWorksLines(Long[] lineNums)
    {
        List<PesWieWorksHeadersAll> getErpSumWorksLines = pesWieWorksHeadersAllMapper.getErpSumWorksLines(lineNums);
        for(PesWieWorksHeadersAll getErpSumWorksLine:getErpSumWorksLines){
            getErpSumWorksLine.setCreateBy(SecurityUtils.getUsername());
            pesWieWorksHeadersAllMapper.insertPesWieWorksHeadersAll(getErpSumWorksLine);
        }
        int i = pesWieWorksHeadersAllMapper.updateSumWorkFlag(lineNums);
        return i;
    }

    /**
     * 创建ERP工单数据
     *
     * @param wieWorkIds 创建工单数据
     * @return 结果
     */
    @Override
    public int submitErpWorks(Long[] wieWorkIds)
    {
        int failureNum = 0,successNum = 0;
        String workOrderDescription = null;
        StringBuilder failureMsg = new StringBuilder();
        for(Long wieWorkId:wieWorkIds){
            PesWieWorksHeadersAll getErpSumWorksLines = pesWieWorksHeadersAllMapper.selectPesWieWorksHeadersAllById(wieWorkId);
            //得到客户名称
            PesWieWorksHeadersAll getCustomerName = pesWieWorksHeadersAllMapper.selectCustomerName(getErpSumWorksLines);
            if(StringUtils.isNotNull(getCustomerName)){
                workOrderDescription = getCustomerName.getCustomerName();
            }else {
                workOrderDescription = getErpSumWorksLines.getRemark();
            }
            //得到库存组织
            PesWieWorksHeadersAll orgCode = pesWieWorksHeadersAllMapper.selectOrgnazationCode(getErpSumWorksLines.getOrganizationId());
            //交易时间转换成格林威治时间
            Calendar cal1 = Calendar.getInstance();
            cal1.setTimeInMillis(getErpSumWorksLines.getPlannedStartDate() .getTime());
            //Json头信息
            JSONObject requestJsonObject = new JSONObject();
            requestJsonObject.put("OrganizationCode", orgCode.getOrganizationCode());
            requestJsonObject.put("ItemNumber", getErpSumWorksLines.getItemNumber());
            requestJsonObject.put("WorkOrderStatusCode", workOrderStatusCode);
            requestJsonObject.put("WorkDefinitionCode", getErpSumWorksLines.getWorkDefinitionCode());
            requestJsonObject.put("PlannedStartQuantity", getErpSumWorksLines.getPlannedStartQuantity());
            requestJsonObject.put("SerialTrackingFlag", serialTrackingFlag);
            requestJsonObject.put("PlannedStartDate", sdf.format(cal1.getTime()));
            requestJsonObject.put("ExplosionFlag", explosionFlag);
            requestJsonObject.put("FirmPlannedFlag", firmPlannedFlag);
            requestJsonObject.put("WorkOrderDescription", workOrderDescription);
            requestJsonObject.put("WorkOrderPriority", getErpSumWorksLines.getDocumentNumbers());
            requestJsonObject.put("SourceSystemType", "EXTERNAL");

            //Json转换
            String requestBody = requestJsonObject.toJSONString();

            try {
                //发送POST请求
                String responseBody = RestClient.postData(ConfigUtils.getWieWorksUrl(), requestBody, CONTECT_TYPE, "UTF-8",ConfigUtils.getErpUser(), ConfigUtils.getErpPass());
                //返回值解析
                JSONObject responseJsonObject = JSONObject.parseObject(responseBody);
                Object workNum = responseJsonObject.get("WorkOrderNumber");
                Object workNumId = responseJsonObject.get("WorkOrderId");
                Object WorkOrderStatusId = responseJsonObject.get("WorkOrderStatusId");

                //调用成功
                if (workNum!=null) {
                    getErpSumWorksLines.setErpWork(workNum.toString());
                    getErpSumWorksLines.setErpWorkNumberId((Long) workNumId);
                    getErpSumWorksLines.setErpWorkStatus((Integer) WorkOrderStatusId);
                    getErpSumWorksLines.setLastUpdateBy(SecurityUtils.getUsername());
                    pesWieWorksHeadersAllMapper.updateErpWork(getErpSumWorksLines);
                    successNum++;
                }

            } catch (JSONException ex) {
                getErpSumWorksLines.setErrorInfor(ex.getMessage());
                getErpSumWorksLines.setLastUpdateBy(SecurityUtils.getUsername());
                pesWieWorksHeadersAllMapper.updateErpWork(getErpSumWorksLines);
                failureNum++;
                failureMsg.append("成品料号："+getErpSumWorksLines.getItemNumber()+",工作定义："+getErpSumWorksLines.getWorkDefinitionCode());

            } catch (Exception ex) {
                getErpSumWorksLines.setLastUpdateBy(SecurityUtils.getUsername());
                getErpSumWorksLines.setErrorInfor(ex.getMessage());
                pesWieWorksHeadersAllMapper.updateErpWork(getErpSumWorksLines);
                failureNum++;
                failureMsg.append("成品料号："+getErpSumWorksLines.getItemNumber()+",工作定义："+getErpSumWorksLines.getWorkDefinitionCode());
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，回写ERP失败！共 " + failureNum + " 条数据需要确认，错误如下：");
            throw new CustomException(failureMsg.toString());
        }
        return successNum;
    }

    @Override
    @Transactional
    public int splitsErpWorks(Long wieWorkIds)
    {
        int sp = 0;
        PesWieWorksHeadersAll list = pesWieWorksHeadersAllMapper.selectPesWieWorksHeadersAllById(wieWorkIds);
        list.setCreateBy(SecurityUtils.getUsername());
        pesWieWorksHeadersAllMapper.updateSplitQuantity(wieWorkIds);
        if(StringUtils.isNotNull(list.getSplitQuantity())){
            BigDecimal[] results = list.getPlannedStartQuantity().divideAndRemainder(list.getSplitQuantity());
            int count = Integer.parseInt(results[0].toString());
            for(int x = 0; x < count; x++){
                list.setPlannedStartQuantity(list.getSplitQuantity());
                sp = pesWieWorksHeadersAllMapper.insertPesWieWorksHeadersAll(list);
            }
            if(results[1].compareTo(BigDecimal.ZERO) == 1? true : false){
                list.setPlannedStartQuantity(results[1]);
                sp = pesWieWorksHeadersAllMapper.insertPesWieWorksHeadersAll(list);
            }
        }else {
            throw new CustomException("拆分数量为空，请输入拆分数量后在进行拆分！！！");
        }

        return sp;
    }

    /**
     * 发放ERP工单数据
     */
    @Override
    public int releasedErpWorks(Long[] wieWorkIds)
    {
        return batchsErpWorks(wieWorkIds,"ORA_RELEASED");
    }

//    /**
//     * 完成ERP工单数据
//     */
//    @Override
//    public int completedErpWorks(Long[] wieWorkIds)
//    {
//        return batchsErpWorks(wieWorkIds,"ORA_COMPLETED");
//    }

    /**
     * 关闭ERP工单数据
     */
    @Override
    public int closedErpWorks(Long[] wieWorkIds)
    {
        return batchsErpWorks(wieWorkIds,"ORA_CLOSED");
    }

    /**
     * 取消ERP工单数据
     */
    @Override
    public int canceledErpWorks(Long[] wieWorkIds)
    {
        return batchsErpWorks(wieWorkIds,"ORA_CANCELED");
    }

    /**
     * 变更ERP工单
     */
    @Override
    public int patchErpWorks(Long[] wieWorkIds)
    {
        return batchsErpWorks(wieWorkIds,"ORA_PATCH");
    }

    @Transactional
    public int batchsErpWorks(Long[] wieWorkIds,String erpStatus)
    {
        int batch = 0;
        //Json头信息
        JSONObject requestJsonObject = new JSONObject();
        if(!"ORA_PATCH".equals(erpStatus)){
            requestJsonObject.put("WorkOrderStatusCode", erpStatus);
        }
        List<PesWieWorksHeadersAll> lists = pesWieWorksHeadersAllMapper.selectPesWieWorksHeadersAllByIds(wieWorkIds);
        if(lists.size() > 0){
            for(PesWieWorksHeadersAll list: lists){
                //获取订单状态ID
                int erpStatusId =  erpStatus == "ORA_CANCELED"? 10000 : (erpStatus == "ORA_CLOSED"? 10001:(erpStatus == "ORA_COMPLETED"? 10002 :(erpStatus == "ORA_ON_HOLD"? 10003 :(erpStatus == "ORA_RELEASED"? 10004 : (erpStatus == "ORA_PATCH"? list.getErpWorkStatus():10005)))));
                if(!(list.getErpWorkStatus() == erpStatusId)||"ORA_PATCH".equals(erpStatus)){
                    if(list.getErpWorkStatus() == 10000 || list.getErpWorkStatus() == 10001){
                        throw new CustomException("不允许对当前状态操作！！！");
                    }
                    if("ORA_PATCH".equals(erpStatus)){
                        //交易时间转换成格林威治时间
                        Calendar cal1 = Calendar.getInstance();
                        cal1.setTimeInMillis(list.getPlannedStartDate() .getTime());
                        requestJsonObject.put("PlannedStartQuantity", list.getPlannedStartQuantity());
                        requestJsonObject.put("PlannedStartDate", sdf.format(cal1.getTime()));
                    }
                    if("ORA_CANCELED".equals(erpStatus)){
                        if(StringUtils.isNotNull(list.getRemark())){
                            requestJsonObject.put("CanceledReason", list.getRemark());
                        }else {
                            throw new CustomException("取消工单，必须输入取消原因！！！");
                        }
                    }
                    String requestBodys = requestJsonObject.toJSONString();
                    String getWieWoUrl = ConfigUtils.getEndWieWoUrl().replace("{WorkOrderId}",list.getErpWorkNumberId().toString());
                    //发送PATCH请求
                    try {
                        int sta = RestClient.patchData(getWieWoUrl, requestBodys, CONTECT_TYPE, "UTF-8",ConfigUtils.getErpUser(), ConfigUtils.getErpPass());
                        if(sta == 200 || sta == 201){
                            list.setErpWorkStatus(erpStatusId);
                            list.setLastUpdateBy(SecurityUtils.getUsername());
                            batch = pesWieWorksHeadersAllMapper.updateErpWork(list);
                        }else {
                            list.setErrorInfor("状态改变失败，原始状态："+ erpStatus);
                            list.setLastUpdateBy(SecurityUtils.getUsername());
                            pesWieWorksHeadersAllMapper.updateErpWork(list);
                        }
                    } catch (Exception e) {
                        list.setErrorInfor("连接异常，状态改变失败，原始状态："+ erpStatus);
                        list.setLastUpdateBy(SecurityUtils.getUsername());
                        pesWieWorksHeadersAllMapper.updateErpWork(list);
                    }
                }else {
                    throw new CustomException("不允许重复变更状态！！！");
                }
            }
        }
        return batch;
    }

    @Override
    @Transactional
    public int deleteErpWorks(Long[] wieWorkIds)
    {
        return pesWieWorksHeadersAllMapper.deleteErpWorks(wieWorkIds);
    }

    /**
     * 新增创建工单数据
     *
     * @param pesWieWorksHeadersAll 创建工单数据
     * @return 结果
     */
    @Override
    @Transactional
    public int insertPesWieWorksHeadersAll(PesWieWorksHeadersAll pesWieWorksHeadersAll)
    {
        if("N".equals(pesWieWorksHeadersAll.getLinesLotsFlag())){
            PesWieWorksHeadersAll getItemDescriptions = pesWieWorksHeadersAllMapper.selectItemDescriptions(pesWieWorksHeadersAll);
            if (StringUtils.isNotNull(getItemDescriptions)){
                pesWieWorksHeadersAll.setInventoryItemId(getItemDescriptions.getInventoryItemId());
                pesWieWorksHeadersAll.setItemDescription(getItemDescriptions.getItemDescription());
                pesWieWorksHeadersAll.setWorkDefinitionCode(getItemDescriptions.getWorkDefinitionCode());
                pesWieWorksHeadersAll.setLineNums(sdf1.format(new Date()));
            }else {
                throw new CustomException("输入的料号未查询到数据，请核对："+pesWieWorksHeadersAll.getItemNumber());
            }
        }else {
            PesWieWorksHeadersAll getLinesData = pesWieWorksHeadersAllMapper.selectLinesData(pesWieWorksHeadersAll.getLineNums());
            if (StringUtils.isNotNull(getLinesData)){
                pesWieWorksHeadersAll = getLinesData;
            }else {
                throw new CustomException("输入的计划批次行号未查询到数据，请核对："+pesWieWorksHeadersAll.getLineNums());
            }
        }
        pesWieWorksHeadersAll.setCreateBy(SecurityUtils.getUsername());
        return pesWieWorksHeadersAllMapper.insertPesWieWorksHeadersAll(pesWieWorksHeadersAll);
    }
}
