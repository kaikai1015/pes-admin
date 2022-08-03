package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.*;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.quartz.service.ISyncInvMaterialTxnsService;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;

@Component("syncInvMaterialTxnsJob")
public class SyncInvMaterialTxnsJob {
    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private ISyncInvMaterialTxnsService syncInvMaterialTxnsService;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncInvMaterialTxnsJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());

        byte[] data = DataModelCommon.getData("/SYNC_DATA/CuxInvMaterialTrxData_external.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//INV_MATERIAL_TXNS
            NodeList nodeList = root.getElementsByTagName("INV_MATERIAL_TXNS");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncInvMaterialTxnsEO> list = new ArrayList<SyncInvMaterialTxnsEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncInvMaterialTxnsEO o = new SyncInvMaterialTxnsEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "TRANSACTION_ID":
                            o.setTransactionId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATE_DATE":
                            o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATED_BY":
                            o.setLastUpdatedBy(dataNode.getTextContent());
                            break;
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SUBINVENTORY_CODE":
                            o.setSubinventoryCode(dataNode.getTextContent());
                            break;
                        case "TRANSACTION_TYPE_ID":
                            o.setTransactionTypeId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRANSACTION_ACTION_ID":
                            o.setTransactionActionId(dataNode.getTextContent());
                            break;
                        case "TRANSACTION_SOURCE_TYPE_ID":
                            o.setTransactionSourceTypeId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRANSACTION_SOURCE_ID":
                            o.setTransactionSourceId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRANSACTION_SOURCE_NAME":
                            o.setTransactionSourceName(dataNode.getTextContent());
                            break;
                        case "TRANSACTION_QUANTITY":
                            try{
                                o.setTransactionQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "TRANSACTION_UOM":
                            o.setTransactionUom(dataNode.getTextContent());
                            break;
                        case "PRIMARY_QUANTITY":
                            try{
                                o.setPrimaryQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "TRANSACTION_DATE":
                            o.setTransactionDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "TRANSACTION_REFERENCE":
                            o.setTransactionReference(dataNode.getTextContent());
                            break;
                        case "DISTRIBUTION_ACCOUNT_ID":
                            o.setDistributionAccountId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "COSTED_FLAG":
                            o.setCostedFlag(dataNode.getTextContent());
                            break;
                        case "CURRENCY_CODE":
                            o.setCurrencyCode(dataNode.getTextContent());
                            break;
                        case "CURRENCY_CONVERSION_RATE":
                            try{
                                o.setCurrencyConversionRate(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CURRENCY_CONVERSION_TYPE":
                            o.setCurrencyConversionType(dataNode.getTextContent());
                            break;
                        case "CURRENCY_CONVERSION_DATE":
                            o.setCurrencyConversionDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "TRX_SOURCE_LINE_ID":
                            o.setTrxSourceLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRX_SOURCE_DELIVERY_ID":
                            o.setTrxSourceDeliveryId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "RMA_LINE_ID":
                            o.setRmaLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRANSFER_TRANSACTION_ID":
                            o.setTransferTransactionId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRANSACTION_SET_ID":
                            o.setTransactionSetId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "RCV_TRANSACTION_ID":
                            o.setRcvTransactionId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SOURCE_CODE":
                            o.setSourceCode(dataNode.getTextContent());
                            break;
                        case "SOURCE_LINE_ID":
                            o.setSourceLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRANSFER_ORGANIZATION_ID":
                            o.setTransferOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRANSFER_SUBINVENTORY":
                            o.setTransferSubinventory(dataNode.getTextContent());
                            break;
                        case "SHIPMENT_NUMBER":
                            o.setShipmentNumber(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE1":
                            o.setAttribute1(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE2":
                            o.setAttribute2(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE3":
                            o.setAttribute3(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE4":
                            o.setAttribute4(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE5":
                            o.setAttribute5(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE6":
                            o.setAttribute6(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE7":
                            o.setAttribute7(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE8":
                            o.setAttribute8(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE9":
                            o.setAttribute9(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE10":
                            o.setAttribute10(dataNode.getTextContent());
                            break;
                        case "OWNING_ORGANIZATION_ID":
                            o.setOwningOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "OWNING_TP_TYPE":
                            o.setOwningTpType(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "XFR_OWNING_ORGANIZATION_ID":
                            o.setXfrOwningOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRANSFER_OWNING_TP_TYPE":
                            o.setTransferOwningTpType(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PLANNING_ORGANIZATION_ID":
                            o.setPlanningOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PLANNING_TP_TYPE":
                            o.setPlanningTpType(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "XFR_PLANNING_ORGANIZATION_ID":
                            o.setXfrPlanningOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRANSFER_PLANNING_TP_TYPE":
                            o.setTransferPlanningTpType(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SHIP_TO_LOCATION_ID":
                            o.setShipToLocationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRANSACTION_MODE":
                            o.setTransactionMode(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRANSACTION_BATCH_ID":
                            o.setTransactionBatchId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORIGINAL_TRANSACTION_TEMP_ID":
                            o.setOriginalTransactionTempId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PRODUCT_TYPE":
                            o.setProductType(dataNode.getTextContent());
                            break;
                        case "TAX_CLASSIFICATION_CODE":
                            o.setTaxClassificationCode(dataNode.getTextContent());
                            break;
                        case "SHIP_FROM_LOCATION_ID":
                            o.setShipFromLocationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PICKING_LINE_ID":
                            o.setPickingLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                syncInvMaterialTxnsService.batchInsertDeleteSyncInvMaterialTxnsEO(list);
            }
        }

        if (true) {//CUX_ORDER_DEMAND_MATERIAL_SUM_QUANTITY_ALL
            NodeList nodeList = root.getElementsByTagName("CUX_ORDER_DEMAND_MATERIAL_SUM_QUANTITY_ALL");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<CuxOrderDemandMaterialSumQuantityAllEO> list = new ArrayList<CuxOrderDemandMaterialSumQuantityAllEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                CuxOrderDemandMaterialSumQuantityAllEO o = new CuxOrderDemandMaterialSumQuantityAllEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRANSACTION_YEAR":
                            o.setTransactionYear(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "JAN_QUANTITY":
                            try{
                                o.setJanQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "FEB_QUANTITY":
                            try{
                                o.setFebQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "MAR_QUANTITY":
                            try{
                                o.setMarQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "APR_QUANTITY":
                            try{
                                o.setAprQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "MAY_QUANTITY":
                            try{
                                o.setMayQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "JUN_QUANTITY":
                            try{
                                o.setJunQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "JUL_QUANTITY":
                            try{
                                o.setJulQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "AUG_QUANTITY":
                            try{
                                o.setAugQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SEP_QUANTITY":
                            try{
                                o.setSepQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "OCT_QUANTITY":
                            try{
                                o.setOctQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "NOV_QUANTITY":
                            try{
                                o.setNovQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "DEC_QUANTITY":
                            try{
                                o.setDecQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                syncInvMaterialTxnsService.batchInsertDeleteOrderDemandSyncInvMaterialTxnsEO(list);
            }
        }

        if (true) {//CUX_WIE_SUPPLY_MATERIAL_SUM_QUANTITY_ALL
            NodeList nodeList = root.getElementsByTagName("CUX_WIE_SUPPLY_MATERIAL_SUM_QUANTITY_ALL");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<CuxWieSupplyMaterialSumQuantityAllEO> list = new ArrayList<CuxWieSupplyMaterialSumQuantityAllEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                CuxWieSupplyMaterialSumQuantityAllEO o = new CuxWieSupplyMaterialSumQuantityAllEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRANSACTION_YEAR":
                            o.setTransactionYear(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "JAN_QUANTITY":
                            try{
                                o.setJanQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "FEB_QUANTITY":
                            try{
                                o.setFebQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "MAR_QUANTITY":
                            try{
                                o.setMarQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "APR_QUANTITY":
                            try{
                                o.setAprQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "MAY_QUANTITY":
                            try{
                                o.setMayQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "JUN_QUANTITY":
                            try{
                                o.setJunQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "JUL_QUANTITY":
                            try{
                                o.setJulQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "AUG_QUANTITY":
                            try{
                                o.setAugQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SEP_QUANTITY":
                            try{
                                o.setSepQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "OCT_QUANTITY":
                            try{
                                o.setOctQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "NOV_QUANTITY":
                            try{
                                o.setNovQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "DEC_QUANTITY":
                            try{
                                o.setDecQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                syncInvMaterialTxnsService.batchInsertDeleteWieSupplySyncInvMaterialTxnsEO(list);
            }
        }

        if (true) {//CUX_WIE_DEMAND_MATERIAL_SUM_QUANTITY_ALL
            NodeList nodeList = root.getElementsByTagName("CUX_WIE_DEMAND_MATERIAL_SUM_QUANTITY_ALL");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<CuxWieDemandMaterialSumQuantityAllEO> list = new ArrayList<CuxWieDemandMaterialSumQuantityAllEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                CuxWieDemandMaterialSumQuantityAllEO o = new CuxWieDemandMaterialSumQuantityAllEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRANSACTION_YEAR":
                            o.setTransactionYear(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "JAN_QUANTITY":
                            try{
                                o.setJanQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "FEB_QUANTITY":
                            try{
                                o.setFebQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "MAR_QUANTITY":
                            try{
                                o.setMarQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "APR_QUANTITY":
                            try{
                                o.setAprQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "MAY_QUANTITY":
                            try{
                                o.setMayQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "JUN_QUANTITY":
                            try{
                                o.setJunQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "JUL_QUANTITY":
                            try{
                                o.setJulQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "AUG_QUANTITY":
                            try{
                                o.setAugQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SEP_QUANTITY":
                            try{
                                o.setSepQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "OCT_QUANTITY":
                            try{
                                o.setOctQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "NOV_QUANTITY":
                            try{
                                o.setNovQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "DEC_QUANTITY":
                            try{
                                o.setDecQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                syncInvMaterialTxnsService.batchInsertDeleteWieDemandSyncInvMaterialTxnsEO(list);
            }
        }

        if (true) {//CUX_PO_SUPPLY_MATERIAL_SUM_QUANTITY_ALL
            NodeList nodeList = root.getElementsByTagName("CUX_PO_SUPPLY_MATERIAL_SUM_QUANTITY_ALL");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<CuxPoSupplyMaterialSumQuantityAllEO> list = new ArrayList<CuxPoSupplyMaterialSumQuantityAllEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                CuxPoSupplyMaterialSumQuantityAllEO o = new CuxPoSupplyMaterialSumQuantityAllEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRANSACTION_YEAR":
                            o.setTransactionYear(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "JAN_QUANTITY":
                            try{
                                o.setJanQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "FEB_QUANTITY":
                            try{
                                o.setFebQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "MAR_QUANTITY":
                            try{
                                o.setMarQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "APR_QUANTITY":
                            try{
                                o.setAprQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "MAY_QUANTITY":
                            try{
                                o.setMayQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "JUN_QUANTITY":
                            try{
                                o.setJunQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "JUL_QUANTITY":
                            try{
                                o.setJulQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "AUG_QUANTITY":
                            try{
                                o.setAugQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SEP_QUANTITY":
                            try{
                                o.setSepQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "OCT_QUANTITY":
                            try{
                                o.setOctQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "NOV_QUANTITY":
                            try{
                                o.setNovQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "DEC_QUANTITY":
                            try{
                                o.setDecQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                syncInvMaterialTxnsService.batchInsertDeletePoSupplySyncInvMaterialTxnsEO(list);
            }
        }

        if (true) {//CUX_OTHER_SUPPLY_MATERIAL_SUM_QUANTITY_ALL
            NodeList nodeList = root.getElementsByTagName("CUX_OTHER_SUPPLY_MATERIAL_SUM_QUANTITY_ALL");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<CuxOtherSupplyMaterialSumQuantityAllEO> list = new ArrayList<CuxOtherSupplyMaterialSumQuantityAllEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                CuxOtherSupplyMaterialSumQuantityAllEO o = new CuxOtherSupplyMaterialSumQuantityAllEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRANSACTION_YEAR":
                            o.setTransactionYear(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "JAN_QUANTITY":
                            try{
                                o.setJanQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "FEB_QUANTITY":
                            try{
                                o.setFebQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "MAR_QUANTITY":
                            try{
                                o.setMarQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "APR_QUANTITY":
                            try{
                                o.setAprQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "MAY_QUANTITY":
                            try{
                                o.setMayQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "JUN_QUANTITY":
                            try{
                                o.setJunQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "JUL_QUANTITY":
                            try{
                                o.setJulQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "AUG_QUANTITY":
                            try{
                                o.setAugQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SEP_QUANTITY":
                            try{
                                o.setSepQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "OCT_QUANTITY":
                            try{
                                o.setOctQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "NOV_QUANTITY":
                            try{
                                o.setNovQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "DEC_QUANTITY":
                            try{
                                o.setDecQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                syncInvMaterialTxnsService.batchInsertDeleteOtherSupplySyncInvMaterialTxnsEO(list);
            }
        }
        if (true) {//INV_ONHAND_MATERIAL_SUM_QUANTITY_SUBINVENTORY_LIST
            NodeList nodeList = root.getElementsByTagName("INV_ONHAND_MATERIAL_SUM_QUANTITY_SUBINVENTORY_LIST");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<invOnhandMaterialSumQuantitySubinventoryList> list = new ArrayList<invOnhandMaterialSumQuantitySubinventoryList>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                invOnhandMaterialSumQuantitySubinventoryList o = new invOnhandMaterialSumQuantitySubinventoryList();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SUBINVENTORY_CODE":
                            o.setSubinventoryCode(dataNode.getTextContent());
                            break;
                    }
                }
                list.add(o);
            }
            if (list.size() > 0) {
                syncInvMaterialTxnsService.weekInsertDeleteSyncInvMaterialTxnsEO(list);
            }
        }
    }
}
