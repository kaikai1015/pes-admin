package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.SyncWshDeliveryDetailsEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SyncWshDeliveryDetailsMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;

@Component("syncWSHDeliverDataJob")
public class SyncWSHDeliverDataJob {
    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private SyncWshDeliveryDetailsMapper syncWshDeliveryDetailsMapper;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncWSHDeliverDataJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());


        byte[] data = DataModelCommon.getData("/SYNC_DATA/CuxWSHDeliverData_external.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//WSH_DELIVERY_DETAILS
            NodeList nodeList = root.getElementsByTagName("WSH_DELIVERY_DETAILS");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncWshDeliveryDetailsEO> list = new ArrayList<SyncWshDeliveryDetailsEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncWshDeliveryDetailsEO o = new SyncWshDeliveryDetailsEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "DELIVERY_DETAIL_ID":
                            o.setDeliveryDetailId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SOURCE_HEADER_ID":
                            o.setSourceHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SOURCE_LINE_ID":
                            o.setSourceLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SOURCE_HEADER_NUMBER":
                            o.setSourceHeaderNumber(dataNode.getTextContent());
                            break;
                        case "CUST_PO_NUMBER":
                            o.setCustPoNumber(dataNode.getTextContent());
                            break;
                        case "SOLD_TO_CONTACT_ID":
                            o.setSoldToContactId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ITEM_DESCRIPTION":
                            o.setItemDescription(dataNode.getTextContent());
                            break;
                        case "SHIP_FROM_LOCATION_ID":
                            o.setShipFromLocationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SHIP_TO_LOCATION_ID":
                            o.setShipToLocationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SHIP_TO_CONTACT_ID":
                            o.setShipToContactId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SRC_REQUESTED_QUANTITY":
                            try{
                                o.setSrcRequestedQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SRC_REQUESTED_QUANTITY_UOM":
                            o.setSrcRequestedQuantityUom(dataNode.getTextContent());
                            break;
                        case "CANCELLED_QUANTITY":
                            try{
                                o.setCancelledQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "REQUESTED_QUANTITY":
                            try{
                                o.setRequestedQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "REQUESTED_QUANTITY_UOM":
                            o.setRequestedQuantityUom(dataNode.getTextContent());
                            break;
                        case "SHIPPED_QUANTITY":
                            try{
                                o.setShippedQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "DELIVERED_QUANTITY":
                            try{
                                o.setDeliveredQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CYCLE_COUNT_QUANTITY":
                            try{
                                o.setCycleCountQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "MOVE_ORDER_LINE_ID":
                            o.setMoveOrderLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SUBINVENTORY":
                            o.setSubinventory(dataNode.getTextContent());
                            break;
                        case "REVISION":
                            o.setRevision(dataNode.getTextContent());
                            break;
                        case "LOT_NUMBER":
                            o.setLotNumber(dataNode.getTextContent());
                            break;
                        case "RELEASED_STATUS":
                            o.setReleasedStatus(dataNode.getTextContent());
                            break;
                        case "SERIAL_NUMBER":
                            o.setSerialNumber(dataNode.getTextContent());
                            break;
                        case "LOCATOR_ID":
                            o.setLocatorId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "DATE_REQUESTED":
                            o.setDateRequested(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "DATE_SCHEDULED":
                            o.setDateScheduled(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LOAD_SEQ_NUMBER":
                            try{
                                o.setLoadSeqNumber(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SHIP_METHOD_CODE":
                            o.setShipMethodCode(dataNode.getTextContent());
                            break;
                        case "CARRIER_ID":
                            o.setCarrierId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "FREIGHT_TERMS_CODE":
                            o.setFreightTermsCode(dataNode.getTextContent());
                            break;
                        case "SHIPMENT_PRIORITY_CODE":
                            o.setShipmentPriorityCode(dataNode.getTextContent());
                            break;
                        case "FOB_CODE":
                            o.setFobCode(dataNode.getTextContent());
                            break;
                        case "CUSTOMER_ITEM_ID":
                            o.setCustomerItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "NET_WEIGHT":
                            try{
                                o.setNetWeight(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "WEIGHT_UOM_CODE":
                            o.setWeightUomCode(dataNode.getTextContent());
                            break;
                        case "VOLUME":
                            try{
                                o.setVolume(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "VOLUME_UOM_CODE":
                            o.setVolumeUomCode(dataNode.getTextContent());
                            break;
                        case "SHIPPING_INSTRUCTIONS":
                            o.setShippingInstructions(dataNode.getTextContent());
                            break;
                        case "PACKING_INSTRUCTIONS":
                            o.setPackingInstructions(dataNode.getTextContent());
                            break;
                        case "PARENT_LPN_ID":
                            o.setParentLpnId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORG_ID":
                            o.setOrgId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ATTRIBUTE_CATEGORY":
                            o.setAttributeCategory(dataNode.getTextContent());
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
                        case "LAST_UPDATE_DATE":
                            o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATED_BY":
                            o.setLastUpdatedBy(dataNode.getTextContent());
                            break;
                        case "CREATION_DATE":
                            o.setCreationDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "CREATED_BY":
                            o.setCreatedBy(dataNode.getTextContent());
                            break;
                        case "LAST_UPDATE_LOGIN":
                            o.setLastUpdateLogin(dataNode.getTextContent());
                            break;
                        case "OBJECT_VERSION_NUMBER":
                            o.setObjectVersionNumber(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "SOURCE_LINE_NUMBER":
                            o.setSourceLineNumber(dataNode.getTextContent());
                            break;
                        case "SEAL_CODE":
                            o.setSealCode(dataNode.getTextContent());
                            break;
                        case "GROSS_WEIGHT":
                            try{
                                o.setGrossWeight(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "PREFERRED_GRADE":
                            o.setPreferredGrade(dataNode.getTextContent());
                            break;
                        case "UNIT_PRICE":
                            try{
                                o.setUnitPrice(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CURRENCY_CODE":
                            o.setCurrencyCode(dataNode.getTextContent());
                            break;
                        case "LPN_CONTENT_ID":
                            o.setLpnContentId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "INSPECTION_FLAG":
                            o.setInspectionFlag(dataNode.getTextContent());
                            break;
                        case "SHIP_TO_SITE_USE_ID":
                            o.setShipToSiteUseId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORIGINAL_SUBINVENTORY":
                            o.setOriginalSubinventory(dataNode.getTextContent());
                            break;
                        case "PICKABLE_FLAG":
                            o.setPickableFlag(dataNode.getTextContent());
                            break;
                        case "PICKED_QUANTITY":
                            try{
                                o.setPickedQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "BATCH_ID":
                            o.setBatchId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRANSACTION_ID":
                            o.setTransactionId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "REQUEST_DATE_TYPE_CODE":
                            o.setRequestDateTypeCode(dataNode.getTextContent());
                            break;
                        case "UNIT_WEIGHT":
                            try{
                                o.setUnitWeight(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "UNIT_VOLUME":
                            try{
                                o.setUnitVolume(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "WV_FROZEN_FLAG":
                            o.setWvFrozenFlag(dataNode.getTextContent());
                            break;
                        case "SHIP_TO_PARTY_ID":
                            o.setShipToPartyId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SOLD_TO_PARTY_ID":
                            o.setSoldToPartyId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "OUTSOURCER_PARTY_ID":
                            o.setOutsourcerPartyId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "BILL_TO_PARTY_ID":
                            o.setBillToPartyId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "BILL_TO_LOCATION_ID":
                            o.setBillToLocationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "BILL_TO_CONTACT_ID":
                            o.setBillToContactId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SHIP_SET_NAME":
                            o.setShipSetName(dataNode.getTextContent());
                            break;
                        case "ARRIVAL_SET_NAME":
                            o.setArrivalSetName(dataNode.getTextContent());
                            break;
                        case "SOURCE_SHIPMENT_NUMBER":
                            o.setSourceShipmentNumber(dataNode.getTextContent());
                            break;
                        case "SALES_ORDER_LINE_NUMBER":
                            o.setSalesOrderLineNumber(dataNode.getTextContent());
                            break;
                        case "SALES_ORDER_NUMBER":
                            o.setSalesOrderNumber(dataNode.getTextContent());
                            break;
                        case "SALES_ORDER_SHIPMENT_NUMBER":
                            o.setSalesOrderShipmentNumber(dataNode.getTextContent());
                            break;
                        case "CONVERSION_TYPE":
                            o.setConversionType(dataNode.getTextContent());
                            break;
                        case "SPQ_UOM":
                            o.setSpqUom(dataNode.getTextContent());
                            break;
                        case "SHIPMENT_ADVICE_STATUS":
                            o.setShipmentAdviceStatus(dataNode.getTextContent());
                            break;
                        case "SOURCE_LINE_TYPE":
                            o.setSourceLineType(dataNode.getTextContent());
                            break;
                        case "DEFAULT_TAXATION_COUNTRY":
                            o.setDefaultTaxationCountry(dataNode.getTextContent());
                            break;
                        case "DOCUMENT_SUB_TYPE":
                            o.setDocumentSubType(dataNode.getTextContent());
                            break;
                        case "TRX_BUSINESS_CATEGORY":
                            o.setTrxBusinessCategory(dataNode.getTextContent());
                            break;
                        case "USER_DEFINED_FISC_CLASS":
                            o.setUserDefinedFiscClass(dataNode.getTextContent());
                            break;
                        case "TAX_INVOICE_NUMBER":
                            o.setTaxInvoiceNumber(dataNode.getTextContent());
                            break;
                        case "PRODUCT_CATEGORY":
                            o.setProductCategory(dataNode.getTextContent());
                            break;
                        case "PRODUCT_TYPE":
                            o.setProductType(dataNode.getTextContent());
                            break;
                        case "TAX_CLASSIFICATION_CODE":
                            o.setTaxClassificationCode(dataNode.getTextContent());
                            break;
                        case "EXEMPT_CERTIFICATE_NUMBER":
                            o.setExemptCertificateNumber(dataNode.getTextContent());
                            break;
                        case "EXEMPT_REASON_CODE":
                            o.setExemptReasonCode(dataNode.getTextContent());
                            break;
                        case "SHIP_TO_LOCATION_TYPE":
                            o.setShipToLocationType(dataNode.getTextContent());
                            break;
                        case "WMS_INTERFACED_FLAG":
                            o.setWmsInterfacedFlag(dataNode.getTextContent());
                            break;
                        case "PICKED_FROM_SUBINVENTORY":
                            o.setPickedFromSubinventory(dataNode.getTextContent());
                            break;
                        case "SHIP_TO_PARTY_SITE_ID":
                            o.setShipToPartySiteId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "BILL_TO_PARTY_SITE_ID":
                            o.setBillToPartySiteId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "REQUISITION_HEADER_ID":
                            o.setRequisitionHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "REQUISITION_LINE_ID":
                            o.setRequisitionLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SOURCE_SHIPMENT_ID":
                            o.setSourceShipmentId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SOURCE_SYSTEM_ID":
                            o.setSourceSystemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "CONVERSION_RATE":
                            o.setConversionRate(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PARENT_INVENTORY_ITEM_ID":
                            o.setParentInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PARENT_SOURCE_SHIPMENT_ID":
                            o.setParentSourceShipmentId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "CATEGORY_ID":
                            o.setCategoryId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "FIRST_PTY_REG_ID":
                            o.setFirstPtyRegId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "THIRD_PTY_REG_ID":
                            o.setThirdPtyRegId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "FINAL_DISCHARGE_LOCATION_ID":
                            o.setFinalDischargeLocationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SOURCE_LINE_UPDATE_DATE":
                            o.setSourceLineUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "CONVERSION_DATE":
                            o.setConversionDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "CALC_WND_WDD_DATE":
                            o.setCalcWndWddDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "DO_NOT_SHIP_BEFORE_DATE":
                            o.setDoNotShipBeforeDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "DO_NOT_SHIP_AFTER_DATE":
                            o.setDoNotShipAfterDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "TAX_INVOICE_DATE":
                            o.setTaxInvoiceDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "INTENDED_USE_CLASSIF_ID":
                            try{
                                o.setIntendedUseClassifId(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ASSESSABLE_VALUE":
                            try{
                                o.setAssessableValue(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SELLING_PRICE":
                            try{
                                o.setSellingPrice(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CONVERTED_QUANTITY":
                            try{
                                o.setConvertedQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SP_PICKED_QUANTITY":
                            try{
                                o.setSpPickedQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                int batchCount =15;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncWshDeliveryDetailsMapper.deleteSyncWshDeliveryDetailsEO(list.subList(index, (batchLastIndex + 1)));
                        syncWshDeliveryDetailsMapper.batchSyncWshDeliveryDetailsEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncWshDeliveryDetailsMapper.deleteSyncWshDeliveryDetailsEO(list.subList(index, (batchLastIndex + 1)));
                        syncWshDeliveryDetailsMapper.batchSyncWshDeliveryDetailsEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
    }
}
