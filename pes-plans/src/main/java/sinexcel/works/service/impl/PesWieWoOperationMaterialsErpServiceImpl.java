package sinexcel.works.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.*;
import sinexcel.quartz.util.WorkMaterialUtils;
import sinexcel.utils.PesWieMaterialsUtils;
import sinexcel.works.domain.PesWieWoOperationMaterialsPriceErp;
import sinexcel.works.mapper.PesWieWoOperationMaterialsErpMapper;
import sinexcel.works.domain.PesWieWoOperationMaterialsErp;
import sinexcel.works.mapper.PesWieWoOperationMaterialsErpPriceMapper;
import sinexcel.works.service.IPesWieWoOperationMaterialsErpService;

/**
 * pes自定义工单单身数据Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-11-26
 */
@Service
public class PesWieWoOperationMaterialsErpServiceImpl implements IPesWieWoOperationMaterialsErpService 
{
    @Autowired
    private PesWieWoOperationMaterialsErpMapper pesWieWoOperationMaterialsErpMapper;

    @Autowired
    private PesWieWoOperationMaterialsErpPriceMapper pesWieWoOperationMaterialsErpPriceMapper;

    Logger logger = LoggerFactory.getLogger(this.getClass());


    public static final String CONTECT_TYPE = "application/vnd.oracle.adf.resourceitem+json";

    public static final String CONTECT_TYPE_BATCH = "application/vnd.oracle.adf.batch+json";

//    private CountDownLatch threadsSignal;

    /**
     * 查询pes自定义工单单身数据
     * 
     * @param pesWorkOrderMaterialId pes自定义工单单身数据ID
     * @return pes自定义工单单身数据
     */
    @Override
    public PesWieWoOperationMaterialsErp selectPesWieWoOperationMaterialsErpById(Long pesWorkOrderMaterialId)
    {
        return pesWieWoOperationMaterialsErpMapper.selectPesWieWoOperationMaterialsErpById(pesWorkOrderMaterialId);
    }

    /**
     * 查询pes自定义工单单身数据列表
     * 
     * @param pesWieWoOperationMaterialsErp pes自定义工单单身数据
     * @return pes自定义工单单身数据
     */
    @Override
    public List<PesWieWoOperationMaterialsErp> selectPesWieWoOperationMaterialsErpList(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp)
    {
        return pesWieWoOperationMaterialsErpMapper.selectPesWieWoOperationMaterialsErpList(pesWieWoOperationMaterialsErp);
    }

    @Override
    public List<PesWieWoOperationMaterialsErp> selectPesWieWoOperationMaterialsErpListByExport(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp)
    {
        return pesWieWoOperationMaterialsErpMapper.selectPesWieWoOperationMaterialsErpListByExport(pesWieWoOperationMaterialsErp);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int insertPesWieWoOperationMaterialsErpAdd(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp)
    {
        if(!(pesWieWoOperationMaterialsErp.getWorkOrderStatusId()==10004||pesWieWoOperationMaterialsErp.getWorkOrderStatusId()==10005||pesWieWoOperationMaterialsErp.getWorkOrderStatusId()==10007)){
            throw new CustomException("当前状态不允许操作");
        }

        PesWieWoOperationMaterialsErp wieWoOperationMaterialsErp= pesWieWoOperationMaterialsErpMapper.getPesWieWoOperationMaterialsErpByItemNumber(pesWieWoOperationMaterialsErp);
        PesWieWoOperationMaterialsErp wieWoOperationMaterialsErpById= pesWieWoOperationMaterialsErpMapper.getPesWieWoOperationMaterialsErpById(pesWieWoOperationMaterialsErp.getPesWorkOrderId());
        if(StringUtils.isNotNull(wieWoOperationMaterialsErp)&&wieWoOperationMaterialsErp.getCountFlag() == 0){
            pesWieWoOperationMaterialsErp.setInventoryItemId(wieWoOperationMaterialsErp.getInventoryItemId());
            pesWieWoOperationMaterialsErp.setItemDescription(wieWoOperationMaterialsErp.getItemDescription());
            pesWieWoOperationMaterialsErp.setItemType(wieWoOperationMaterialsErp.getItemType());
            pesWieWoOperationMaterialsErp.setUomCode(wieWoOperationMaterialsErp.getUomCode());
            pesWieWoOperationMaterialsErp.setSupplyType(wieWoOperationMaterialsErp.getSupplyType());
            pesWieWoOperationMaterialsErp.setMaterialSequenceNumber(wieWoOperationMaterialsErp.getMaxMaterialSequenceNumber());
            pesWieWoOperationMaterialsErp.setTechniquesCode(wieWoOperationMaterialsErp.getTechniquesCode());
            pesWieWoOperationMaterialsErp.setSunHaoQuantity(wieWoOperationMaterialsErp.getSunHaoQuantity());
            pesWieWoOperationMaterialsErp.setCreateBy(SecurityUtils.getUsername());
            pesWieWoOperationMaterialsErp.setCreateDate(DateUtils.getNowDate());
            pesWieWoOperationMaterialsErp.setWorkOrderOperationId(wieWoOperationMaterialsErpById.getWorkOrderOperationId());
            pesWieWoOperationMaterialsErp.setPesWorkOrderOperationId(wieWoOperationMaterialsErpById.getPesWorkOrderOperationId());
            PesWieWoOperationMaterialsErp wieMaterialSupplySubinvtory = pesWieWoOperationMaterialsErpMapper.getWieMaterialSupplySubinvtoryByPesWorkId(pesWieWoOperationMaterialsErp.getPesWorkOrderId());
            if(wieMaterialSupplySubinvtory.getWorkCenterCode() == 1){
                pesWieWoOperationMaterialsErp.setSubinventoryCode("4".equals(pesWieWoOperationMaterialsErp.getTechniquesCode())?"3FCKL001":("9".equals(pesWieWoOperationMaterialsErp.getTechniquesCode())?"3XLXB001":("10".equals(pesWieWoOperationMaterialsErp.getTechniquesCode())?"DLC":"XBC")));
            }
            if(wieMaterialSupplySubinvtory.getWorkCenterCode() == 3){
                pesWieWoOperationMaterialsErp.setSubinventoryCode("3DYXB001");
            }
            if(wieMaterialSupplySubinvtory.getWorkCenterCode() == 2){
                pesWieWoOperationMaterialsErp.setSubinventoryCode(wieMaterialSupplySubinvtory.getSubinventoryCode());
            }
        }else {
            String msg = StringUtils.isNotNull(wieWoOperationMaterialsErp)?"添加单身物料失败，单身物料已经存在！！！":"添加单身物料失败，请检查添加的物料属性('WWBCP','BCP','P','FG')！！！";
            throw new CustomException(msg);
        }
        pesWieWoOperationMaterialsErpMapper.insertPesWieWoOperationMaterialsErp(pesWieWoOperationMaterialsErp);
        pesWieWoOperationMaterialsErp.setRemark("物料添加");
        pesWieWoOperationMaterialsErp.setErpFlag("0");
        pesWieWoOperationMaterialsErp.setErpType(0);
        //回传成功插入回传记录表
        return pesWieWoOperationMaterialsErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWoOperationMaterialsErp);
    }

    /**
     * 新增pes自定义工单单身数据
     * 
     * @param pesWorkOrderOperationId pes自定义工单单身数据
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int insertPesWieWoOperationMaterialsErp(Long pesWorkOrderOperationId,Integer workCenterCode)
    {
        int i = 0,level = 0;
        PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp = new PesWieWoOperationMaterialsErp();
        //插入O阶次数据
        pesWieWoOperationMaterialsErp.setWorkCenterCode(workCenterCode);
        pesWieWoOperationMaterialsErp.setCreateBy(SecurityUtils.getUsername());
        pesWieWoOperationMaterialsErp.setCreateDate(DateUtils.getNowDate());
        pesWieWoOperationMaterialsErp.setPesWorkOrderOperationId(pesWorkOrderOperationId);
        if(pesWieWoOperationMaterialsErp.getWorkCenterCode() == 1){
            pesWieWoOperationMaterialsErp.setSubinventoryCode("XBC");
        }
        if(pesWieWoOperationMaterialsErp.getWorkCenterCode() == 3){
            pesWieWoOperationMaterialsErp.setSubinventoryCode("3DYXB001");
        }
        if(pesWieWoOperationMaterialsErp.getWorkCenterCode() == 2){
            PesWieWoOperationMaterialsErp pesWieWoOperationMaterialSupplierBySubInventory =  pesWieWoOperationMaterialsErpMapper.selectPesWieWoOperationSupplierById(pesWieWoOperationMaterialsErp);
            pesWieWoOperationMaterialsErp.setSubinventoryCode(pesWieWoOperationMaterialSupplierBySubInventory.getSubinventoryCode());
//            pesWieWoOperationMaterialsErp.setGongSubinventoryCode(pesWieWoOperationMaterialSupplierBySubInventory.getGongSubinventoryCode());
        }

        i = pesWieWoOperationMaterialsErpMapper.insertPesWieWoOperationMaterialsHeaderErp(pesWieWoOperationMaterialsErp);
        while (i > 0)
        {
            //循环插入低阶次数据
            pesWieWoOperationMaterialsErp.setLevel(level);
            i = pesWieWoOperationMaterialsErpMapper.insertPesWieWoOperationMaterialsLinesErp(pesWieWoOperationMaterialsErp);
            level ++ ;
        }
        //删除工序临时表pes_wie_wo_operation_materials_erp_temp
        return pesWieWoOperationMaterialsErpMapper.deletePesWieWoOperationTempErp(pesWorkOrderOperationId);
    }

    @Override
    public int handleSubmitErpPesWieWorkOrdersBErpByIdsJob(String endName)
    {
        List<PesWieWoOperationMaterialsErp> pesWieWoOperationMaterialsErps = pesWieWoOperationMaterialsErpMapper.handleSubmitErpPesWieWorkOrdersBErpByIdsJob();
        if(pesWieWoOperationMaterialsErps.size() > 0){
            Map<Long, List<PesWieWoOperationMaterialsErp>> collect = pesWieWoOperationMaterialsErps.stream().collect(Collectors.groupingBy(PesWieWoOperationMaterialsErp::getPesWorkOrderId));
            for(Long pesWorkOrderId:collect.keySet()){
                forEachPesWieWoOperationMaterialsErps(collect.get(pesWorkOrderId),endName);
            }
        }
        return 1;
    }

    /**
     * 修改pes自定义工单单身数据
     * 
     * @param pesWorkOrderId pes自定义工单单身数据
     * @return 结果
     */
    @Override
    public int handleSubmitErpPesOperationMaterialByIds(Long pesWorkOrderId,String endName)
    {
        List<PesWieWoOperationMaterialsErp> pesWieWoOperationMaterialsErps = pesWieWoOperationMaterialsErpMapper.selectSubmitErpPesOperationMaterialByIds(pesWorkOrderId);
        if(pesWieWoOperationMaterialsErps.size() > 0){
            forEachPesWieWoOperationMaterialsErps(pesWieWoOperationMaterialsErps,endName);
        }
        return 1;
    }


    public void forEachPesWieWoOperationMaterialsErps(List<PesWieWoOperationMaterialsErp> list,String endName)
    {
        int batchCount =50;//每批处理的条数
        int batchLastIndex = batchCount - 1;// 每批最后一个的下标
        for (int index = 0; index < list.size();) {
            if (batchLastIndex > (list.size() - 1)) {
                batchLastIndex = list.size() - 1;
                batchSyncWorkOrderUpdateQuantityEO(list.subList(index, (batchLastIndex + 1)),endName);
                break;// 数据插入完毕,退出循环
            }else {
                batchSyncWorkOrderUpdateQuantityEO(list.subList(index, (batchLastIndex + 1)),endName);
                index = batchLastIndex + 1;// 设置下一批下标
                batchLastIndex = index + (batchCount - 1);
            }
        }
    }

//   public int forEachPesWieWoOperationMaterialsErps(List<PesWieWoOperationMaterialsErp> pesWieWoOperationMaterialsErps,String endName){
//       //先获取API地址
////        String getUpdWorkOperationMaterialUrl = ConfigUtils.getWieWorksOperationMaterialUrl().replace("{WorkOrderId}",String.valueOf(pesWieWoOperationMaterialsErps.get(0).getWorkOrderId())).replace("{WorkOrderOperationId}",String.valueOf(pesWieWoOperationMaterialsErps.get(0).getWorkOrderOperationId()));
////        for(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp:pesWieWoOperationMaterialsErps){
////
////            handleSubmitErpPesOperationMaterial(pesWieWoOperationMaterialsErp,getUpdWorkOperationMaterialUrl,endName);
////        }
//       handleSubmitErpPesOperationMaterial(pesWieWoOperationMaterialsErps,endName);
//       return 1;
//   }

    /**
     * 单身批量回传
     */
    public int batchSyncWorkOrderUpdateQuantityEO(List<PesWieWoOperationMaterialsErp> pesWieWoOperationMaterialsErps,String endName)
    {
//        String postUrl = "https://ehsj-test.fa.ap1.oraclecloud.com/fscmRestApi/resources/11.13.18.05";
        JSONObject requestJsonObject = new JSONObject();
        List parts = new ArrayList<>();
        for(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp:pesWieWoOperationMaterialsErps){
            String part = pesWieWoOperationMaterialsErp.getPesWorkOrderMaterialId().toString();
            String path = "/workOrders/"+pesWieWoOperationMaterialsErp.getWorkOrderId()+"/child/WorkOrderOperation/"+pesWieWoOperationMaterialsErp.getWorkOrderOperationId()+"/child/WorkOrderOperationMaterial";
            //把json串传出来
            JSONObject requestJsonLObject = new JSONObject();
            requestJsonLObject.put("id",part);
            requestJsonLObject.put("path",path);
            requestJsonLObject.put("operation","create");
            //payload
            JSONObject requestJsonLPayload = new JSONObject();
            requestJsonLPayload.put("MaterialSequenceNumber", pesWieWoOperationMaterialsErp.getMaterialSequenceNumber());
            requestJsonLPayload.put("InventoryItemId", pesWieWoOperationMaterialsErp.getInventoryItemId());
            requestJsonLPayload.put("QuantityPERProduct", pesWieWoOperationMaterialsErp.getQuantityPerProduct());
            requestJsonLPayload.put("BasisType", pesWieWoOperationMaterialsErp.getBasisType());
            requestJsonLPayload.put("IncludeInPlanningFlag", pesWieWoOperationMaterialsErp.getItemNumber().contains("F")?false:true);
//            requestJsonLPayload.put("SupplySubinventory",pesWieWoOperationMaterialsErp.getSubinventoryCode());
            requestJsonLObject.put("payload", requestJsonLPayload);

            parts.add(requestJsonLObject);
            //缓存ID和最后更新时间
            PesWieMaterialsUtils.setPesMaterialIdLastUpdateDateCache(part,pesWieWoOperationMaterialsErp.getLastUpdateDate());
        }
        requestJsonObject.put("parts",parts);

        String requestBody = requestJsonObject.toJSONString();

        PesWieWoOperationMaterialsErp insertPesWieWoOperationMaterialsErp = new PesWieWoOperationMaterialsErp();
        //插入回传记录表的0代表新建数据，1变更数据
        insertPesWieWoOperationMaterialsErp.setErpType(0);

        try {
            //发送POST请求
            HttpResponse httpResponse = HttpRequest.post(ConfigUtils.getWieWorksOperationMaterialUrl()).header("Content-Type", CONTECT_TYPE_BATCH)
                    .header("Authorization", "Basic SU5UR19BRE1JTjpAU2luODY1MTE1ODg=")
                    .body(requestBody).execute();
            //解析返回来的状态
            int statusCode = httpResponse.getStatus();
            String responseBody = httpResponse.body();
//            System.out.println(responseBody);
          if(statusCode==200||statusCode==201){
              JSONObject responseJsonObject = JSONObject.parseObject(responseBody);
              JSONArray partsArray = responseJsonObject.getJSONArray("parts");
              for(int i = 0; i < partsArray.size();i++){
                  JSONObject payloadLists = JSONObject.parseObject(partsArray.get(i).toString()).getJSONObject("payload");
                  Object workOrderOperationMaterialId = payloadLists.get("WorkOrderOperationMaterialId");
                  logger.info("workOrderOperationMaterialId："+workOrderOperationMaterialId);
                  Object pesWorkOrderOperationMaterialId = JSONObject.parseObject(partsArray.get(i).toString()).get("id");
                  insertPesWieWoOperationMaterialsErp.setWorkOrderOperationMaterialId(Long.valueOf(String.valueOf(workOrderOperationMaterialId)));
                  insertPesWieWoOperationMaterialsErp.setPesWorkOrderMaterialId(Long.valueOf(String.valueOf(pesWorkOrderOperationMaterialId)));
                  insertPesWieWoOperationMaterialsErp.setCreateDate(DateUtils.getNowDate());
                  insertPesWieWoOperationMaterialsErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                  insertPesWieWoOperationMaterialsErp.setRemark("OK");
                  insertPesWieWoOperationMaterialsErp.setErpFlag("1");

                  insertPesWieWoOperationMaterialsErp.setLastUpdateDate(PesWieMaterialsUtils.getPesMaterialIdLastUpdateDateCache(String.valueOf(pesWorkOrderOperationMaterialId)));

                  pesWieWoOperationMaterialsErpMapper.updatePesWieWorkOrdersBErpByWorkOrderId(insertPesWieWoOperationMaterialsErp);
                  //回传成功插入回传记录表
                pesWieWoOperationMaterialsErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(insertPesWieWoOperationMaterialsErp);

              }
              //删除缓存
              PesWieMaterialsUtils.clearPesMaterialIdLastUpdateDateCache();

          }else {
              pesWieWoOperationMaterialsErps.get(0).setCreateDate(DateUtils.getNowDate());
              pesWieWoOperationMaterialsErps.get(0).setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
              pesWieWoOperationMaterialsErps.get(0).setRemark(StringUtils.substring(responseBody, 0, 4000));
              pesWieWoOperationMaterialsErps.get(0).setErpFlag("2");
              pesWieWoOperationMaterialsErps.get(0).setErpType(0);
//              System.out.println(responseBody);
              pesWieWoOperationMaterialsErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWoOperationMaterialsErps.get(0));
          }

        } catch (JSONException ex) {
            logger.info("JSONException："+ex.getMessage());

        } catch (Exception ex) {
            logger.info("Exception："+ex.getMessage());
        }

        return 1;
    }

//    /**
//     * 多线程实现单身回传ERP
//     * @param pesWieWoOperationMaterialsErps
//     * @param endName
//     * @return
//     */
//    public int forEachPesWieWoOperationMaterialsErps(List<PesWieWoOperationMaterialsErp> pesWieWoOperationMaterialsErps,String endName)
//    {
//        ExecutorService execPool = Executors.newFixedThreadPool(4);
//        threadsSignal = new CountDownLatch(pesWieWoOperationMaterialsErps.size());
//        //先获取API地址
//        String getUpdWorkOperationMaterialUrl = ConfigUtils.getWieWorksOperationMaterialUrl().replace("{WorkOrderId}",String.valueOf(pesWieWoOperationMaterialsErps.get(0).getWorkOrderId())).replace("{WorkOrderOperationId}",String.valueOf(pesWieWoOperationMaterialsErps.get(0).getWorkOrderOperationId()));
//        System.out.println("***********PES自定义工单回传ERP开始***********");
//        try {
//            for(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp:pesWieWoOperationMaterialsErps){
//
//                execPool.submit(new submitExepool(pesWieWoOperationMaterialsErp,getUpdWorkOperationMaterialUrl,endName));
//            }
//            threadsSignal.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("***********PES自定义工单回传ERP结束***********");
//        return 1;
//    }
//    /**
//     * 启线程批量回传数据
//     *
//     */
//    class submitExepool extends Thread {
//        PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp;
//        String url,endName;
//
//        public submitExepool(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp,String url,String endName) {
//            this.pesWieWoOperationMaterialsErp = pesWieWoOperationMaterialsErp;
//            this.url = url;
//            this.endName = endName;
//        }
//
//        public void run() {
//            handleSubmitErpPesOperationMaterial(pesWieWoOperationMaterialsErp,url,endName);
//            threadsSignal.countDown();
//        }
//    }

//    public void handleSubmitErpPesOperationMaterial(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp,String getUpdWorkOperationMaterialUrl,String endName)
//    {
//        //Json头信息
//        JSONObject requestJsonObject = new JSONObject();
//        requestJsonObject.put("MaterialSequenceNumber", pesWieWoOperationMaterialsErp.getMaterialSequenceNumber());
//        requestJsonObject.put("InventoryItemId", pesWieWoOperationMaterialsErp.getInventoryItemId());
//        requestJsonObject.put("QuantityPERProduct", pesWieWoOperationMaterialsErp.getQuantityPerProduct());
//        requestJsonObject.put("BasisType", pesWieWoOperationMaterialsErp.getBasisType());
//        requestJsonObject.put("IncludeInPlanningFlag", "true");
//
//        //Json转换
//        String requestBody = requestJsonObject.toJSONString();
//        //插入回传记录表的0代表新建数据，1变更数据
//        pesWieWoOperationMaterialsErp.setErpType(0);
//        try {
//            //发送POST请求
//            String responseBody = RestClient.postData(getUpdWorkOperationMaterialUrl, requestBody, CONTECT_TYPE, "UTF-8",ConfigUtils.getErpUser(), ConfigUtils.getErpPass());
//            //返回值解析
//            JSONObject responseJsonObject = JSONObject.parseObject(responseBody);
//            Object workOrderOperationMaterialId = responseJsonObject.get("WorkOrderOperationMaterialId");
//
//            //调用成功
//            if (StringUtils.isNotNull(workOrderOperationMaterialId)) {
//                pesWieWoOperationMaterialsErp.setWorkOrderOperationMaterialId(Long.valueOf(String.valueOf(workOrderOperationMaterialId)));
//                pesWieWoOperationMaterialsErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
//                pesWieWoOperationMaterialsErp.setCreateDate(DateUtils.getNowDate());
//                pesWieWoOperationMaterialsErp.setRemark("OK");
//                pesWieWoOperationMaterialsErp.setErpFlag("1");
//                pesWieWoOperationMaterialsErpMapper.updatePesWieWorkOrdersBErpByWorkOrderId(pesWieWoOperationMaterialsErp);
//                //回传成功插入回传记录表
//                pesWieWoOperationMaterialsErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWoOperationMaterialsErp);
//                System.out.println("元件序号："+pesWieWoOperationMaterialsErp.getMaterialSequenceNumber()+"，元件编码："+pesWieWoOperationMaterialsErp.getItemNumber());
//            }
//
//        } catch (JSONException ex) {
//            pesWieWoOperationMaterialsErp.setWorkOrderOperationMaterialId(0L);
//            pesWieWoOperationMaterialsErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
//            pesWieWoOperationMaterialsErp.setCreateDate(DateUtils.getNowDate());
//            pesWieWoOperationMaterialsErp.setRemark(ex.getMessage());
//            pesWieWoOperationMaterialsErp.setErpFlag("2");
//            //回传成功插入回传记录表
//            pesWieWoOperationMaterialsErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWoOperationMaterialsErp);
//
//        } catch (Exception ex) {
//            pesWieWoOperationMaterialsErp.setWorkOrderOperationMaterialId(0L);
//            pesWieWoOperationMaterialsErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
//            pesWieWoOperationMaterialsErp.setCreateDate(DateUtils.getNowDate());
//            pesWieWoOperationMaterialsErp.setErpFlag("2");
//            pesWieWoOperationMaterialsErp.setRemark(ex.getMessage());
//            //回传成功插入回传记录表
//            pesWieWoOperationMaterialsErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWoOperationMaterialsErp);
//        }
//    }

    /**
     * 修改pes自定义工单单身数据
     *
     * @param pesWieWoOperationMaterialsErp pes自定义工单单身数据
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int updatePesWieWoOperationMaterialsErp(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp)
    {

        if(!(pesWieWoOperationMaterialsErp.getWorkOrderStatusId()==10004||pesWieWoOperationMaterialsErp.getWorkOrderStatusId()==10005||pesWieWoOperationMaterialsErp.getWorkOrderStatusId()==10002)){
            throw new CustomException("当前状态不允许操作");
        }
        if("I".equals(pesWieWoOperationMaterialsErp.getActiveCode())){
            throw new CustomException("当前数据已经删除，不能操作！！！");
        }
        pesWieWoOperationMaterialsErp.setCreateBy(SecurityUtils.getUsername());
        pesWieWoOperationMaterialsErp.setCreateDate(DateUtils.getNowDate());
        pesWieWoOperationMaterialsErp.setErpType(1);
        pesWieWoOperationMaterialsErp.setErpFlag("0");
        pesWieWoOperationMaterialsErp.setRemark(StringUtils.isEmpty(pesWieWoOperationMaterialsErp.getRemark())?"变更记录":pesWieWoOperationMaterialsErp.getRemark());
        //变更数据插入回传记录表
        pesWieWoOperationMaterialsErpMapper.updatePesWieWoOperationMaterialsErp(pesWieWoOperationMaterialsErp);
        //变更数据修改
        return pesWieWoOperationMaterialsErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWoOperationMaterialsErp);
    }

    //接口变更
    @Override
    public int updateSubmitErpPesWieWorkOrdersBErpByIdsJob(String endName)
    {
        List<PesWieWoOperationMaterialsErp> lists = pesWieWoOperationMaterialsErpMapper.updateSubmitErpPesWieWorkOrdersBErpByIdsJob();
        return sedUpdateSubmitErpPesOperationMaterials(lists,endName);
    }

    @Override
    public int handleMaterialUpdateSubmitErp(Long pesWorkOrderId)
    {
        List<PesWieWoOperationMaterialsErp> lists = pesWieWoOperationMaterialsErpMapper.selectUpdateSubmitErpPesOperationMaterialByIds(pesWorkOrderId);
        return sedUpdateSubmitErpPesOperationMaterials(lists,"userName");
    }

    public int sedUpdateSubmitErpPesOperationMaterials(List<PesWieWoOperationMaterialsErp> list,String endName)
    {
        if(list.size() > 0){
        int batchCount =50;//每批处理的条数
        int batchLastIndex = batchCount - 1;// 每批最后一个的下标
        for (int index = 0; index < list.size();) {
            if (batchLastIndex > (list.size() - 1)) {
                batchLastIndex = list.size() - 1;
                autoUpdateSubmitErpPesOperationMaterials(list.subList(index, (batchLastIndex + 1)),endName);
                break;// 数据插入完毕,退出循环
            }else {
                autoUpdateSubmitErpPesOperationMaterials(list.subList(index, (batchLastIndex + 1)),endName);
                index = batchLastIndex + 1;// 设置下一批下标
                batchLastIndex = index + (batchCount - 1);
            }
        }
        }
        return 1;
    }

    public int autoUpdateSubmitErpPesOperationMaterials(List<PesWieWoOperationMaterialsErp> getUpdateSubmitErpPesOperationMaterials,String endName)
    {
        JSONObject requestJsonObject = new JSONObject();
        List parts = new ArrayList<>();
        for(PesWieWoOperationMaterialsErp updateSubmitErpPesOperationMaterials:getUpdateSubmitErpPesOperationMaterials){
            String part = updateSubmitErpPesOperationMaterials.getPesWorkOrderMaterialId().toString();
            String path = "/workOrders/"+updateSubmitErpPesOperationMaterials.getWorkOrderId()+"/child/WorkOrderOperation/"+updateSubmitErpPesOperationMaterials.getWorkOrderOperationId()+"/child/WorkOrderOperationMaterial/"+updateSubmitErpPesOperationMaterials.getWorkOrderOperationMaterialId();
            //把json串传出来
            JSONObject requestJsonLObject = new JSONObject();
            requestJsonLObject.put("id",part);
            requestJsonLObject.put("path",path);
            requestJsonLObject.put("operation","update");
            //payload
            JSONObject requestJsonLPayload = new JSONObject();
            requestJsonLPayload.put("QuantityPERProduct", updateSubmitErpPesOperationMaterials.getQuantityPerProduct());
            requestJsonLPayload.put("BasisType", updateSubmitErpPesOperationMaterials.getBasisType());
            requestJsonLObject.put("payload", requestJsonLPayload);

            parts.add(requestJsonLObject);
        }
        requestJsonObject.put("parts",parts);

        String requestBody = requestJsonObject.toJSONString();
        PesWieWoOperationMaterialsErp insertPesWieWoOperationMaterialsErp = new PesWieWoOperationMaterialsErp();
        //插入回传记录表的0代表新建数据，1变更数据
        insertPesWieWoOperationMaterialsErp.setErpType(1);

        try {
            //发送POST请求
            HttpResponse httpResponse = HttpRequest.post(ConfigUtils.getWieWorksOperationMaterialUrl()).header("Content-Type", CONTECT_TYPE_BATCH)
                    .header("Authorization", "Basic SU5UR19BRE1JTjpAU2luODY1MTE1ODg=")
                    .body(requestBody).execute();
            //解析返回来的状态
            int statusCode = httpResponse.getStatus();
            String responseBody = httpResponse.body();
            if(statusCode==200){
                getUpdateSubmitErpPesOperationMaterials.forEach(getUpdateSubmitErpPesOperationMaterial ->{
                    insertPesWieWoOperationMaterialsErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                    insertPesWieWoOperationMaterialsErp.setCreateDate(DateUtils.getNowDate());
                    insertPesWieWoOperationMaterialsErp.setRemark("OK");
                    insertPesWieWoOperationMaterialsErp.setErpFlag("1");
                    insertPesWieWoOperationMaterialsErp.setWorkOrderOperationMaterialId(getUpdateSubmitErpPesOperationMaterial.getWorkOrderOperationMaterialId());
                    insertPesWieWoOperationMaterialsErp.setPesWorkOrderMaterialId(getUpdateSubmitErpPesOperationMaterial.getPesWorkOrderMaterialId());
                    insertPesWieWoOperationMaterialsErp.setLastUpdateDate(getUpdateSubmitErpPesOperationMaterial.getLastUpdateDate());
                    //回传成功插入回传记录表
                    pesWieWoOperationMaterialsErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(insertPesWieWoOperationMaterialsErp);
                    //回传成功更新erp_submit_date
                    pesWieWoOperationMaterialsErpMapper.updatePesWieWorkOrdersBErpByWorkOrderId(insertPesWieWoOperationMaterialsErp);
                    logger.info("元件序号："+getUpdateSubmitErpPesOperationMaterial.getMaterialSequenceNumber()+"，元件编码："+getUpdateSubmitErpPesOperationMaterial.getItemNumber()+"，基准："+getUpdateSubmitErpPesOperationMaterial.getBasisType()+"，比例："+getUpdateSubmitErpPesOperationMaterial.getQuantityPerProduct());
                });
            }else {
                insertPesWieWoOperationMaterialsErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                insertPesWieWoOperationMaterialsErp.setCreateDate(DateUtils.getNowDate());
                insertPesWieWoOperationMaterialsErp.setRemark(StringUtils.substring("报文："+requestBody+"，异常信息："+responseBody, 0, 4000));
                insertPesWieWoOperationMaterialsErp.setErpFlag("2");
                insertPesWieWoOperationMaterialsErp.setPesWorkOrderMaterialId(getUpdateSubmitErpPesOperationMaterials.get(0).getPesWorkOrderMaterialId());
                //回传成功插入回传记录表
                pesWieWoOperationMaterialsErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(insertPesWieWoOperationMaterialsErp);
            }

        } catch (JSONException ex) {
            logger.info("JSONException："+ex.getMessage());

        } catch (Exception ex) {
            logger.info("Exception："+ex.getMessage());
        }

//            for(PesWieWoOperationMaterialsErp updateSubmitErpPesOperationMaterials:getUpdateSubmitErpPesOperationMaterials){
//                //先获取ERP更新接口API地址
//                String getUpdWorkLineUrl = ConfigUtils.getDelWorkLineUrl().replace("{WorkOrderId}",String.valueOf(updateSubmitErpPesOperationMaterials.getWorkOrderId())).replace("{WorkOrderOperationId}",String.valueOf(updateSubmitErpPesOperationMaterials.getWorkOrderOperationId())).replace("{WorkOrderOperationMaterialId}",String.valueOf(updateSubmitErpPesOperationMaterials.getWorkOrderOperationMaterialId()));
//
//                //拼接字符串
//                JSONObject requestJsonObject = new JSONObject();
//                requestJsonObject.put("BasisType", updateSubmitErpPesOperationMaterials.getBasisType());
//                requestJsonObject.put("QuantityPERProduct", updateSubmitErpPesOperationMaterials.getQuantityPerProduct());
//                String requestBody = requestJsonObject.toJSONString();
//                //插入回传记录表的0代表新建数据，1变更数据
//                updateSubmitErpPesOperationMaterials.setErpType(1);
//                try {
//                    //连接发送报文
//                    int responseBodySta = RestClient.patchData(getUpdWorkLineUrl, requestBody, CONTECT_TYPE, "UTF-8", ConfigUtils.getErpUser(), ConfigUtils.getErpPass());
//
//                    //调用成功
//                    if (responseBodySta==200) {
//                        updateSubmitErpPesOperationMaterials.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
//                        updateSubmitErpPesOperationMaterials.setCreateDate(DateUtils.getNowDate());
//                        updateSubmitErpPesOperationMaterials.setRemark("OK");
//                        updateSubmitErpPesOperationMaterials.setErpFlag("1");
//                        //回传成功插入回传记录表
//                        pesWieWoOperationMaterialsErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(updateSubmitErpPesOperationMaterials);
//                        //回传成功更新erp_submit_date
//                        pesWieWoOperationMaterialsErpMapper.updatePesWieWorkOrdersBErpByWorkOrderId(updateSubmitErpPesOperationMaterials);
//                        logger.info("元件序号："+updateSubmitErpPesOperationMaterials.getMaterialSequenceNumber()+"，元件编码："+updateSubmitErpPesOperationMaterials.getItemNumber()+"，基准："+updateSubmitErpPesOperationMaterials.getBasisType()+"，比例："+updateSubmitErpPesOperationMaterials.getQuantityPerProduct());
//                    }else {
//                        updateSubmitErpPesOperationMaterials.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
//                        updateSubmitErpPesOperationMaterials.setCreateDate(DateUtils.getNowDate());
//                        updateSubmitErpPesOperationMaterials.setRemark(StringUtils.substring("报文："+requestBody+"，异常信息："+responseBodySta, 0, 4000));
//                        updateSubmitErpPesOperationMaterials.setErpFlag("2");
//                        //回传成功插入回传记录表
//                        pesWieWoOperationMaterialsErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(updateSubmitErpPesOperationMaterials);
//                    }
//
//                } catch (JSONException ex) {
//                    updateSubmitErpPesOperationMaterials.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
//                    updateSubmitErpPesOperationMaterials.setCreateDate(DateUtils.getNowDate());
//                    updateSubmitErpPesOperationMaterials.setRemark(ex.getMessage());
//                    updateSubmitErpPesOperationMaterials.setErpFlag("2");
//                    //回传成功插入回传记录表
//                    pesWieWoOperationMaterialsErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(updateSubmitErpPesOperationMaterials);
//
//                } catch (Exception ex) {
//                    updateSubmitErpPesOperationMaterials.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
//                    updateSubmitErpPesOperationMaterials.setRemark(ex.getMessage());
//                    updateSubmitErpPesOperationMaterials.setCreateDate(DateUtils.getNowDate());
//                    updateSubmitErpPesOperationMaterials.setErpFlag("2");
//                    //回传成功插入回传记录表
//                    pesWieWoOperationMaterialsErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(updateSubmitErpPesOperationMaterials);
//                }
//            }
//        else {
//            throw new CustomException("单身变更：请在回传信息查看！！！");
//        }
        return 1;
    }

    /**
     * 批量删除pes自定义工单单身数据
     *
     * @param pesWorkOrderIds 需要删除的pes自定义工单单身数据ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int deletePesWieWoOperationMaterialsErpByIds(Long workOrderStatusIds,Long pesWorkOrderIds)
    {
        PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp = pesWieWoOperationMaterialsErpMapper.selectPesWieWoOperationMaterialsErpByIds(pesWorkOrderIds);
        if(workOrderStatusIds == 10005|| workOrderStatusIds== 10007){
        pesWieWoOperationMaterialsErp.setCreateBy(SecurityUtils.getUsername());
        pesWieWoOperationMaterialsErp.setCreateDate(DateUtils.getNowDate());
        pesWieWoOperationMaterialsErp.setPesWorkOrderId(pesWorkOrderIds);

            //統計單身數量
            int count = pesWieWoOperationMaterialsErpMapper.deletePesWieWoOperationMaterialsErpByIds(pesWieWoOperationMaterialsErp);
            int i = 0;
            //添加最新的BOM结构
            insertPesWieWoOperationMaterialsErp(pesWieWoOperationMaterialsErp.getPesWorkOrderOperationId(),pesWieWoOperationMaterialsErp.getWorkCenterCode());
            //如果已经回传ERP了，需要跟新最新的ERP_ID
//            pesWieWoOperationMaterialsErp.setMaterialSequenceNumber(10*i);
            //查询最新添加的BOM单身数据,三个日期相等，并且这个里面的日期小于后面插入的日期
        List<PesWieWoOperationMaterialsErp> newLists = pesWieWoOperationMaterialsErpMapper.selectNewPesWieWoOperationMaterialsErpList(pesWieWoOperationMaterialsErp);
        if(newLists.size() > 0){
            for(PesWieWoOperationMaterialsErp newList:newLists){
                //先跟新后删除,即更新成功说明原来存在单身明细，然后删除新增的单身明细
//                System.out.println(newList.getInventoryItemId());
//                System.out.println(newList.getQuantityPerProduct());
                if(pesWieWoOperationMaterialsErpMapper.updatePesWieWoOperationMaterialsErpByIds(newList) > 0){
                    pesWieWoOperationMaterialsErpMapper.deleteUpdatePesWieWoOperationMaterialsErpByIds(newList.getPesWorkOrderMaterialId());
                }else {
                    //跟新失败，即没有，需要更新序号
                    newList.setMaterialSequenceNumber((count+i)*10);
                    newList.setWorkOrderId(pesWieWoOperationMaterialsErp.getWorkOrderId());
                    newList.setWorkOrderOperationId(pesWieWoOperationMaterialsErp.getWorkOrderOperationId());
                    pesWieWoOperationMaterialsErpMapper.updatePesWieWoOperationMaterialsErpByMaterialNum(newList);
                    i++;
                }
            }
            //失效餘的單身數據
            pesWieWoOperationMaterialsErpMapper.deleteOthersPesWieWoOperationMaterialsErpByIds(pesWieWoOperationMaterialsErp);
        }

        pesWieWoOperationMaterialsErp.setWorkOrderOperationMaterialId(0L);
        pesWieWoOperationMaterialsErp.setMaterialSequenceNumber(0);
        pesWieWoOperationMaterialsErp.setRequiredDate(pesWieWoOperationMaterialsErp.getCreateDate());
        pesWieWoOperationMaterialsErp.setBasisType("200");
        pesWieWoOperationMaterialsErp.setQuantityPerProduct(BigDecimal.ZERO);
        pesWieWoOperationMaterialsErp.setRequiredQuantity(BigDecimal.ZERO);
        pesWieWoOperationMaterialsErp.setErpType(1);
        pesWieWoOperationMaterialsErp.setErpFlag("0");
        pesWieWoOperationMaterialsErp.setRemark("单身BOM数据刷新");
        }else {
            throw new CustomException("此状态不允许刷新BOM！！！");
        }
        //插入日志
        return pesWieWoOperationMaterialsErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWoOperationMaterialsErp);
    }

    /**
     * 导入数据
     *
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public String importData(List<PesWieWoOperationMaterialsErp> materialLists,String operName,Long pesWorkOrderId,Integer workOrderStatusId)
    {
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        if(!(workOrderStatusId==10004||workOrderStatusId==10005||workOrderStatusId==10007)){
            throw new CustomException("当前状态不允许操作");
        }

        List<PesWieWoOperationMaterialsErp> counts = pesWieWoOperationMaterialsErpMapper.getWieOperationMaterialListById(pesWorkOrderId);

        if (counts.size() > 1)
        {
            throw new CustomException("工单明细已经存在，不允许导入！");
        }
        if (StringUtils.isNull(materialLists) || materialLists.size() == 0)
        {
            throw new CustomException("导入数据不能为空！");
        }
        for (PesWieWoOperationMaterialsErp materialList : materialLists)
        {
            try
            {
                materialList.setOrganizationId(counts.get(0).getOrganizationId());
                materialList.setPesWorkOrderId(pesWorkOrderId);
                // 验证是否存这条数据
                PesWieWoOperationMaterialsErp wieWoOperationMaterialsErp= pesWieWoOperationMaterialsErpMapper.getPesWieWoOperationMaterialsErpByItemNumber(materialList);
                if (StringUtils.isNotNull(wieWoOperationMaterialsErp)&&wieWoOperationMaterialsErp.getCountFlag() == 0)
                {
                        successNum++;
                        materialList.setInventoryItemId(wieWoOperationMaterialsErp.getInventoryItemId());
                        materialList.setItemDescription(wieWoOperationMaterialsErp.getItemDescription());
                        materialList.setItemType(wieWoOperationMaterialsErp.getItemType());
                        materialList.setUomCode(wieWoOperationMaterialsErp.getUomCode());
                        materialList.setSupplyType(wieWoOperationMaterialsErp.getSupplyType());
                        materialList.setTechniquesCode(wieWoOperationMaterialsErp.getTechniquesCode());
                        materialList.setSunHaoQuantity(wieWoOperationMaterialsErp.getSunHaoQuantity());
                        materialList.setMaterialSequenceNumber(successNum*10);
                        materialList.setCreateBy(operName);
                        materialList.setCreateDate(DateUtils.getNowDate());
                        materialList.setWorkOrderOperationMaterialId(0L);
                        materialList.setWorkOrderId(counts.get(0).getWorkOrderId());
                        materialList.setOrganizationId(counts.get(0).getOrganizationId());
                        materialList.setRequiredDate(counts.get(0).getRequiredDate());
                        materialList.setWorkOrderOperationId(counts.get(0).getWorkOrderOperationId());
                        materialList.setPesWorkOrderOperationId(counts.get(0).getPesWorkOrderOperationId());
                        materialList.setBasisType("1");
                        materialList.setRequiredQuantity(materialList.getQuantityPerProduct().multiply(counts.get(0).getRequiredQuantity()));
                    PesWieWoOperationMaterialsErp wieMaterialSupplySubinvtory = pesWieWoOperationMaterialsErpMapper.getWieMaterialSupplySubinvtoryByPesWorkId(pesWorkOrderId);
                    if(wieMaterialSupplySubinvtory.getWorkCenterCode() == 1){
//                        materialList.setSubinventoryCode("4".equals(materialList.getTechniquesCode())?"3FCKL001":("9".equals(materialList.getTechniquesCode())?"2XL001":"XBC"));
                        materialList.setSubinventoryCode("4".equals(materialList.getTechniquesCode())?"3FCKL001":("9".equals(materialList.getTechniquesCode())?"3XLXB001":("10".equals(materialList.getTechniquesCode())?"DLC":"XBC")));
                    }
                    if(wieMaterialSupplySubinvtory.getWorkCenterCode() == 3){
//                        materialList.setSubinventoryCode("4".equals(materialList.getTechniquesCode())?"2GG001":"3DYXB001");
                        materialList.setSubinventoryCode("3DYXB001");
                    }
                    if(wieMaterialSupplySubinvtory.getWorkCenterCode() == 2){
//                        materialList.setSubinventoryCode("9".equals(materialList.getTechniquesCode())?wieMaterialSupplySubinvtory.getGongSubinventoryCode():("10".equals(materialList.getTechniquesCode())?"DLC":wieMaterialSupplySubinvtory.getSubinventoryCode()));
                        materialList.setSubinventoryCode(wieMaterialSupplySubinvtory.getSubinventoryCode());
                    }
                        pesWieWoOperationMaterialsErpMapper.insertPesWieWoOperationMaterialsErp(materialList);
                }
                else
                {
                    failureNum++;
                    String msg = StringUtils.isNotNull(wieWoOperationMaterialsErp)?"【单身物料"+materialList.getItemNumber()+"】已经存在！！！":"添加单身物料"+materialList.getItemNumber()+"失败，请检查添加的物料属性('WWBCP','BCP','P','FG')！！！";
                    failureMsg.append(msg);
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、元件编码 " + materialList.getItemNumber() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }

        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！有 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new CustomException(failureMsg.toString()+"请检查导入数据无误后重新导入！！！");
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条");
        }

        return successMsg.toString();
    }

    @Override
    public List<PesWieWoOperationMaterialsErp> selectPesWiegetSubNewItemList(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp)
    {
        return pesWieWoOperationMaterialsErpMapper.selectPesWiegetSubNewItemList(pesWieWoOperationMaterialsErp);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int addPesWieWoOperationMaterialsErpByIds(Long workSubId,Long pInventoryItemId,Long organizationId,Long pesWorkOrderId,String subItemFlag)
    {
        PesWieWoOperationMaterialsErp subWieWoOperationMaterialsErp = null;
        PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp = pesWieWoOperationMaterialsErpMapper.getWieOperationMaterialListById(pesWorkOrderId).get(0);
        pesWieWoOperationMaterialsErp.setWorkSubId(workSubId);
        pesWieWoOperationMaterialsErp.setpInventoryItemId(pInventoryItemId);
        pesWieWoOperationMaterialsErp.setItemNumber(null);
        pesWieWoOperationMaterialsErp.setNewItemNumber(null);
        if("Y".equals(subItemFlag)){
            subWieWoOperationMaterialsErp = pesWieWoOperationMaterialsErpMapper.selectPesWiegetSubNewItemList(pesWieWoOperationMaterialsErp).get(0);
        }else {
            subWieWoOperationMaterialsErp = pesWieWoOperationMaterialsErpMapper.selectPesWiegetSubNewItemListReturn(pesWieWoOperationMaterialsErp);
        }
        pesWieWoOperationMaterialsErp.setCreateBy(SecurityUtils.getUsername());
        pesWieWoOperationMaterialsErp.setCreateDate(DateUtils.getNowDate());
        pesWieWoOperationMaterialsErp.setOrganizationId(subWieWoOperationMaterialsErp.getOrganizationId());
        pesWieWoOperationMaterialsErp.setNewItemNumber(subWieWoOperationMaterialsErp.getNewItemNumber());
        pesWieWoOperationMaterialsErp.setNewInventoryItemId(subWieWoOperationMaterialsErp.getNewInventoryItemId());
        pesWieWoOperationMaterialsErp.setPesWorkOrderId(pesWieWoOperationMaterialsErp.getPesWorkOrderId());
        PesWieWoOperationMaterialsErp getNewItenmNumberList= pesWieWoOperationMaterialsErpMapper.getPesWieWoOperationMaterialsErpByNewItemNumber(pesWieWoOperationMaterialsErp);
        if(StringUtils.isNotNull(getNewItenmNumberList)){
            //说明原本工单存在替代信息，只需要更新比例和数量即可
            pesWieWoOperationMaterialsErp.setQuantityPerProduct(subWieWoOperationMaterialsErp.getNewPercentQuantity().multiply(subWieWoOperationMaterialsErp.getQuantityPerProduct()));
            pesWieWoOperationMaterialsErp.setRequiredQuantity(subWieWoOperationMaterialsErp.getNewPercentQuantity().multiply(subWieWoOperationMaterialsErp.getRequiredQuantity()));
            pesWieWoOperationMaterialsErp.setNewInventoryItemId(subWieWoOperationMaterialsErp.getInventoryItemId());
            pesWieWoOperationMaterialsErp.setNewItemNumber(subWieWoOperationMaterialsErp.getItemNumber());
            pesWieWoOperationMaterialsErp.setPesWorkOrderMaterialId(getNewItenmNumberList.getPesWorkOrderMaterialId());
            //更新操作
            pesWieWoOperationMaterialsErpMapper.updateSubWieWoOperationMaterialsErp(pesWieWoOperationMaterialsErp);

            //回传记录表
            pesWieWoOperationMaterialsErp.setWorkOrderOperationMaterialId(getNewItenmNumberList.getWorkOrderOperationMaterialId());
            pesWieWoOperationMaterialsErp.setMaterialSequenceNumber(getNewItenmNumberList.getMaterialSequenceNumber());
            pesWieWoOperationMaterialsErp.setItemNumber(getNewItenmNumberList.getItemNumber());
            pesWieWoOperationMaterialsErp.setItemDescription(getNewItenmNumberList.getItemDescription());
            pesWieWoOperationMaterialsErp.setRequiredDate(getNewItenmNumberList.getRequiredDate());
            pesWieWoOperationMaterialsErp.setBasisType(getNewItenmNumberList.getBasisType());
            pesWieWoOperationMaterialsErp.setRemark("替代料已存在修改存在物料用量");
            pesWieWoOperationMaterialsErp.setErpFlag("0");
            pesWieWoOperationMaterialsErp.setErpType(2);
            pesWieWoOperationMaterialsErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWoOperationMaterialsErp);
        }else {
            pesWieWoOperationMaterialsErp.setQuantityPerProduct(subWieWoOperationMaterialsErp.getQuantityPerProduct().multiply(subWieWoOperationMaterialsErp.getNewPercentQuantity()));
            pesWieWoOperationMaterialsErp.setRequiredQuantity(subWieWoOperationMaterialsErp.getRequiredQuantity().multiply(subWieWoOperationMaterialsErp.getNewPercentQuantity()));
            pesWieWoOperationMaterialsErp.setItemNumber(subWieWoOperationMaterialsErp.getNewItemNumber());
            pesWieWoOperationMaterialsErp.setInventoryItemId(subWieWoOperationMaterialsErp.getNewInventoryItemId());
            pesWieWoOperationMaterialsErp.setItemDescription(subWieWoOperationMaterialsErp.getNewItemDescription());
            pesWieWoOperationMaterialsErp.setNewInventoryItemId(subWieWoOperationMaterialsErp.getInventoryItemId());
            pesWieWoOperationMaterialsErp.setNewItemNumber(subWieWoOperationMaterialsErp.getItemNumber());
            pesWieWoOperationMaterialsErp.setWorkOrderOperationMaterialId(0L);
            pesWieWoOperationMaterialsErp.setPesWorkOrderOperationId(subWieWoOperationMaterialsErp.getPesWorkOrderOperationId());
            pesWieWoOperationMaterialsErp.setWorkOrderId(subWieWoOperationMaterialsErp.getWorkOrderId());
            pesWieWoOperationMaterialsErp.setRequiredDate(subWieWoOperationMaterialsErp.getRequiredDate());
            pesWieWoOperationMaterialsErp.setItemType(subWieWoOperationMaterialsErp.getItemType());
            pesWieWoOperationMaterialsErp.setSupplyType(subWieWoOperationMaterialsErp.getSupplyType());
            pesWieWoOperationMaterialsErp.setBasisType("1");
            pesWieWoOperationMaterialsErp.setWorkOrderOperationId(subWieWoOperationMaterialsErp.getWorkOrderOperationId());
            pesWieWoOperationMaterialsErp.setUomCode(subWieWoOperationMaterialsErp.getUomCode());
            pesWieWoOperationMaterialsErp.setMaterialSequenceNumber(subWieWoOperationMaterialsErp.getMaxMaterialSequenceNumber());
            pesWieWoOperationMaterialsErp.setIssuedQuantity(BigDecimal.ZERO);
            pesWieWoOperationMaterialsErp.setSunHaoQuantity(BigDecimal.ZERO);
            pesWieWoOperationMaterialsErp.setSunHaoQuantity(subWieWoOperationMaterialsErp.getSunHaoQuantity());
            pesWieWoOperationMaterialsErp.setTechniquesCode(subWieWoOperationMaterialsErp.getTechniquesCode());
            //插入替代后的物料
            PesWieWoOperationMaterialsErp wieMaterialSupplySubinvtory = pesWieWoOperationMaterialsErpMapper.getWieMaterialSupplySubinvtoryByPesWorkId(pesWieWoOperationMaterialsErp.getPesWorkOrderId());
            if(wieMaterialSupplySubinvtory.getWorkCenterCode() == 1){
//                pesWieWoOperationMaterialsErp.setSubinventoryCode("4".equals(pesWieWoOperationMaterialsErp.getTechniquesCode())?"3FCKL001":("9".equals(pesWieWoOperationMaterialsErp.getTechniquesCode())?"2XL001":"XBC"));
                pesWieWoOperationMaterialsErp.setSubinventoryCode("4".equals(pesWieWoOperationMaterialsErp.getTechniquesCode())?"3FCKL001":("9".equals(pesWieWoOperationMaterialsErp.getTechniquesCode())?"3XLXB001":("10".equals(pesWieWoOperationMaterialsErp.getTechniquesCode())?"DLC":"XBC")));
            }
            if(wieMaterialSupplySubinvtory.getWorkCenterCode() == 3){
//                pesWieWoOperationMaterialsErp.setSubinventoryCode("4".equals(pesWieWoOperationMaterialsErp.getTechniquesCode())?"2GG001":"3DYXB001");
                pesWieWoOperationMaterialsErp.setSubinventoryCode("3DYXB001");
            }
            if(wieMaterialSupplySubinvtory.getWorkCenterCode() == 2){
//                pesWieWoOperationMaterialsErp.setSubinventoryCode("9".equals(pesWieWoOperationMaterialsErp.getTechniquesCode())?wieMaterialSupplySubinvtory.getGongSubinventoryCode():("10".equals(pesWieWoOperationMaterialsErp.getTechniquesCode())?"DLC":wieMaterialSupplySubinvtory.getSubinventoryCode()));
                pesWieWoOperationMaterialsErp.setSubinventoryCode(wieMaterialSupplySubinvtory.getSubinventoryCode());
            }
            pesWieWoOperationMaterialsErpMapper.insertPesWieWoOperationMaterialsErp(pesWieWoOperationMaterialsErp);

            pesWieWoOperationMaterialsErp.setRemark("新增替代料");
            //回传记录表
            pesWieWoOperationMaterialsErp.setErpFlag("0");
            pesWieWoOperationMaterialsErp.setErpType(2);
            pesWieWoOperationMaterialsErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWoOperationMaterialsErp);

            pesWieWoOperationMaterialsErp.setNewInventoryItemId(subWieWoOperationMaterialsErp.getInventoryItemId());
            pesWieWoOperationMaterialsErp.setNewItemNumber(subWieWoOperationMaterialsErp.getItemNumber());
        }
        //修改之前的物料用量未0
        pesWieWoOperationMaterialsErp.setQuantityPerProduct(BigDecimal.ZERO);
        pesWieWoOperationMaterialsErp.setRequiredQuantity(BigDecimal.ZERO);
        pesWieWoOperationMaterialsErp.setNewInventoryItemId(subWieWoOperationMaterialsErp.getNewInventoryItemId());
        pesWieWoOperationMaterialsErp.setNewItemNumber(subWieWoOperationMaterialsErp.getNewItemNumber());
        pesWieWoOperationMaterialsErp.setPesWorkOrderMaterialId(subWieWoOperationMaterialsErp.getPesWorkOrderMaterialId());
        pesWieWoOperationMaterialsErpMapper.updateInsertPesWieWoOperationMaterialsErp(pesWieWoOperationMaterialsErp);

        //回传记录表
        pesWieWoOperationMaterialsErp.setPesWorkOrderMaterialId(subWieWoOperationMaterialsErp.getPesWorkOrderMaterialId());
        pesWieWoOperationMaterialsErp.setWorkOrderOperationMaterialId(subWieWoOperationMaterialsErp.getWorkOrderOperationMaterialId());
        pesWieWoOperationMaterialsErp.setMaterialSequenceNumber(subWieWoOperationMaterialsErp.getMaterialSequenceNumber());
        pesWieWoOperationMaterialsErp.setItemNumber(subWieWoOperationMaterialsErp.getItemNumber());
        pesWieWoOperationMaterialsErp.setItemDescription(subWieWoOperationMaterialsErp.getItemDescription());
        pesWieWoOperationMaterialsErp.setRequiredDate(subWieWoOperationMaterialsErp.getRequiredDate());
        pesWieWoOperationMaterialsErp.setRemark("替代料修改原物料用量为0");
        pesWieWoOperationMaterialsErp.setErpFlag("0");
        pesWieWoOperationMaterialsErp.setErpType(2);

        return pesWieWoOperationMaterialsErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWoOperationMaterialsErp);
    }

    @Override
    public List<PesWieWoOperationMaterialsErp> selectPesWieWoOperationMaterialsErpListByImport(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp)
    {
        return pesWieWoOperationMaterialsErpMapper.selectPesWieWoOperationMaterialsErpListByImport(pesWieWoOperationMaterialsErp);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int handleMaterialUpdateSubmitErpId(Long pesWorkOrderIds){
        PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp= pesWieWoOperationMaterialsErpMapper.getPesWieWoOperationMaterialsErpById(pesWorkOrderIds);
        pesWieWoOperationMaterialsErpMapper.handleMaterialUpdateSubmitErpId(pesWieWoOperationMaterialsErp);
        return 1;
    }

    @Override
//    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int handleSubmitErpFcl(Long[] pesWorkOrderMaterialIds,String materialType){
        List<PesWieWoOperationMaterialsErp> pesWieWoOperationMaterialsErps= "MATERIAL_ISSUE".equals(materialType)?pesWieWoOperationMaterialsErpMapper.handleSubmitErpFcl(pesWorkOrderMaterialIds):pesWieWoOperationMaterialsErpMapper.handleSubmitReturnErpFcl(pesWorkOrderMaterialIds);
        if(pesWieWoOperationMaterialsErps.size() > 0){
            handleSubmitErpFclAotu(pesWieWoOperationMaterialsErps,materialType);
        }
        return 1;
    }


    public synchronized int handleSubmitErpFclAotu(List<PesWieWoOperationMaterialsErp> pesWieWoOperationMaterialsErps,String materialType){
        Integer successNum = 0;
        Integer failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        String lotNumber = null;
        if(pesWieWoOperationMaterialsErps.size() > 0){
            for(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp:pesWieWoOperationMaterialsErps){
                BigDecimal trnQuantity = "MATERIAL_ISSUE".equals(materialType)?pesWieWoOperationMaterialsErp.getRequiredQuantity().add(pesWieWoOperationMaterialsErp.getSunHaoQuantity()).add(pesWieWoOperationMaterialsErp.getOverQuantity()).subtract(pesWieWoOperationMaterialsErp.getIssuedQuantity()):(pesWieWoOperationMaterialsErp.getIssuedQuantity().subtract(pesWieWoOperationMaterialsErp.getRequiredQuantity().add(pesWieWoOperationMaterialsErp.getSunHaoQuantity()).add(pesWieWoOperationMaterialsErp.getOverQuantity())));
                PesWieWoOperationMaterialsErp itemNumberLotControalById= pesWieWoOperationMaterialsErpMapper.getItemNumberLotControalById(pesWieWoOperationMaterialsErp);
                //判断是否启用批次控制
                //SYNC_EGP_SYSTEM_ITEMS_B.LOT_CONTROL_CODE: 2 启用； 1 不启用
                //有批次行信息不需要subinventoryCode信息，在批次中体现subinventoryCode信息
                if(itemNumberLotControalById.getLotControlCode()==2){
                    lotNumber = "QC201810";
                }else{
                    lotNumber = "NULL";
                }
                String xmlStr = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns1=\"http://xmlns.oracle.com/apps/scm/commonWorkExecution/workOrderMaterialTransactions/materialTransactionsService/types/\" xmlns:ns2=\"http://xmlns.oracle.com/apps/scm/commonWorkExecution/workOrderMaterialTransactions/materialTransactionsService/\">\n" +
                        "<soap:Body>\n" +
                        "<ns1:createWorkOrderMaterialTransactions>\n" +
                        "<ns1:batchInput>\n" +
                        "<ns2:MaterialTransactionInput>\n" +
                        "<ns2:HeaderNumber>HN_001</ns2:HeaderNumber>\n" +
                        "<ns2:WorkOrderNumber>" + pesWieWoOperationMaterialsErp.getWorkOrderNumber() + "</ns2:WorkOrderNumber>\n" +
                        "<ns2:OperationSequence>10</ns2:OperationSequence>\n" +
                        "<ns2:TransactionType>"+materialType+"</ns2:TransactionType>\n" +
                        "<ns2:InventoryItemNumber>" + pesWieWoOperationMaterialsErp.getItemNumber() + "</ns2:InventoryItemNumber>\n" +
                        "<ns2:Organization>" + itemNumberLotControalById.getOrganizationCode() + "</ns2:Organization>\n" +
                        "<ns2:TransactionQuantity unitCode=\"" + pesWieWoOperationMaterialsErp.getUomCode() + "\">" + trnQuantity + "</ns2:TransactionQuantity>\n" +
                        "<ns2:Subinventory>" + pesWieWoOperationMaterialsErp.getSubinventoryCode() + "</ns2:Subinventory>\n" +
                        "<ns2:SourceHeaderReference>" + pesWieWoOperationMaterialsErp.getWorkOrderNumber() + "</ns2:SourceHeaderReference>\n" +
                        "<ns2:TransactionLotInput>\n" +
                        "<ns2:LotNumber>" + lotNumber + "</ns2:LotNumber>\n" +
                        "<ns2:TransactionQuantity>" + trnQuantity + "</ns2:TransactionQuantity>\n" +
                        "</ns2:TransactionLotInput>\n" +
                        "</ns2:MaterialTransactionInput>\n" +
                        "</ns1:batchInput>\n" +
                        "</ns1:createWorkOrderMaterialTransactions>\n" +
                        "</soap:Body>\n" +
                        "</soap:Envelope>";
                String scode = null;
                try {
                    scode = WorkMaterialUtils.analysisXML(InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getWorkMaterialUrl(),ConfigUtils.getWorkMaterialName(),ConfigUtils.getWorkMaterialMethodName()));

                if("COMPLETED".equals(scode)){
                    pesWieWoOperationMaterialsErp.setIssuedQuantity("MATERIAL_ISSUE".equals(materialType)?pesWieWoOperationMaterialsErp.getIssuedQuantity().add(trnQuantity):pesWieWoOperationMaterialsErp.getIssuedQuantity().subtract(trnQuantity));
                    int count = "MATERIAL_ISSUE".equals(materialType)?pesWieWoOperationMaterialsErpMapper.updatePesWieWorkOrdersBErpByPesMaterialId(pesWieWoOperationMaterialsErp):pesWieWoOperationMaterialsErpMapper.updatePesWieWorkOrdersBErpByPesMaterialIdReturn(pesWieWoOperationMaterialsErp);
                    successNum++;
                    logger.info("扣/退账数据：工单号："+pesWieWoOperationMaterialsErp.getWorkOrderNumber()+"，元件编码："+pesWieWoOperationMaterialsErp.getItemNumber());
                }else {
                    failureNum++;
                    failureMsg.append("工单号："+pesWieWoOperationMaterialsErp.getWorkOrderNumber()+"，序号："+pesWieWoOperationMaterialsErp.getMaterialSequenceNumber()+"，元件编码："+pesWieWoOperationMaterialsErp.getItemNumber());
                }
                } catch (Exception e) {
                    failureNum++;
                    failureMsg.append("错误日志："+e.getMessage());
                }
            }
        }
//        if (failureNum > 0)
//        {
//            failureMsg.insert(0, "很抱歉，扣/退账失败！共 " + failureNum + " 条数据不正确，错误如下：");
//            throw new CustomException(failureMsg.toString());
//        }
//        else
//        {
//            successMsg.insert(0, "恭喜您，扣/退账成功！共 " + successNum + " 条");
//        }
        return successNum + failureNum;
    }

    @Override
    public int handleSubmitErpPesWieWorkOrdersBErpByIdsFCLJob(String materialIssue)
    {
        List<PesWieWoOperationMaterialsErp> pesWieWoOperationMaterialsErps = pesWieWoOperationMaterialsErpMapper.handleSubmitErpPesWieWorkOrdersBErpByIdsFCLJob();
        if(pesWieWoOperationMaterialsErps.size() > 0){
            handleSubmitErpFclAotu(pesWieWoOperationMaterialsErps,materialIssue);
        }
        return 1;
    }


    @Override
    public int handleSubmitErpPesWieWorkOrdersBErpByIdsIssuedJob(String materialIssue)
    {
        List<PesWieWoOperationMaterialsErp> pesWieWoOperationMaterialsErps = pesWieWoOperationMaterialsErpMapper.handleSubmitErpPesWieWorkOrdersBErpByIdsIssuedJob();
        if(pesWieWoOperationMaterialsErps.size() > 0){
            handleSubmitErpFclAotu(pesWieWoOperationMaterialsErps,materialIssue);
        }
        return 1;
    }

    @Override
    public int handleSubmitErpPesWieWorkOrdersBErpByIdsDLCJob(String materialIssue)
    {
        //先更新未DLC
        pesWieWoOperationMaterialsErpMapper.updateDLCWorkMaterils();
        List<PesWieWoOperationMaterialsErp> pesWieWoOperationMaterialsErps = pesWieWoOperationMaterialsErpMapper.handleSubmitErpPesWieWorkOrdersBErpByIdsDLCJob();
        if(pesWieWoOperationMaterialsErps.size() > 0){
            handleSubmitErpFclAotu(pesWieWoOperationMaterialsErps,materialIssue);
        }
        return 1;
    }

    @Override
    public List<PesWieWoOperationMaterialsPriceErp> selectPesWieWoOperationMaterialsErpListByPriceImport(PesWieWoOperationMaterialsPriceErp pesWieWoOperationMaterialsErp)
    {
        return pesWieWoOperationMaterialsErpPriceMapper.selectPesWieWoOperationMaterialsErpListByPriceImport(pesWieWoOperationMaterialsErp);
    }
}
