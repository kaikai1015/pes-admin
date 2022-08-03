package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.SyncRcvShipmentLinesEO;
import sinexcel.quartz.domain.SyncRcvTransactionsEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SyncRcvShipmentLinesMapper;
import sinexcel.quartz.mapper.SyncRcvTransactionsMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;

@Component("syncRcvTransactionsJob")
public class SyncRcvTransactionsJob {
    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private SyncRcvTransactionsMapper syncRcvTransactionsMapper;

    @Autowired
    private SyncRcvShipmentLinesMapper syncRcvShipmentLinesMapper;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncRcvTransactionsJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());


        byte[] data = DataModelCommon.getData("/SYNC_DATA/PesRCVInvTrxData_external.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//RCV_TRANSACTIONS
            NodeList nodeList = root.getElementsByTagName("RCV_TRANSACTIONS");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncRcvTransactionsEO> list = new ArrayList<SyncRcvTransactionsEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncRcvTransactionsEO o = new SyncRcvTransactionsEO();

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
                        case "CREATION_DATE":
                            o.setCreationDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "CREATED_BY":
                            o.setCreatedBy(dataNode.getTextContent());
                            break;
                        case "TRANSACTION_TYPE":
                            o.setTransactionType(dataNode.getTextContent());
                            break;
                        case "TRANSACTION_DATE":
                            o.setTransactionDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "QUANTITY":
                            try{
                                o.setQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "UOM_CODE":
                            o.setUomCode(dataNode.getTextContent());
                            break;
                        case "SHIPMENT_HEADER_ID":
                            o.setShipmentHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SHIPMENT_LINE_ID":
                            o.setShipmentLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "DESTINATION_TYPE_CODE":
                            o.setDestinationTypeCode(dataNode.getTextContent());
                            break;
                        case "PRIMARY_QUANTITY":
                            try{
                                o.setPrimaryQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "PRIMARY_UOM_CODE":
                            o.setPrimaryUomCode(dataNode.getTextContent());
                            break;
                        case "EMPLOYEE_ID":
                            o.setEmployeeId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PARENT_TRANSACTION_ID":
                            o.setParentTransactionId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PO_HEADER_ID":
                            o.setPoHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PO_LINE_ID":
                            o.setPoLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PO_LINE_LOCATION_ID":
                            o.setPoLineLocationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PO_DISTRIBUTION_ID":
                            o.setPoDistributionId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PO_REVISION_NUM":
                            o.setPoRevisionNum(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PO_UNIT_PRICE":
                            try{
                                o.setPoUnitPrice(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CURRENCY_CODE":
                            o.setCurrencyCode(dataNode.getTextContent());
                            break;
                        case "CURRENCY_CONVERSION_TYPE":
                            o.setCurrencyConversionType(dataNode.getTextContent());
                            break;
                        case "CURRENCY_CONVERSION_RATE":
                            try{
                                o.setCurrencyConversionRate(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CURRENCY_CONVERSION_DATE":
                            o.setCurrencyConversionDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "ROUTING_HEADER_ID":
                            o.setRoutingHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "DELIVER_TO_PERSON_ID":
                            o.setDeliverToPersonId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "DELIVER_TO_LOCATION_ID":
                            o.setDeliverToLocationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "VENDOR_ID":
                            o.setVendorId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "VENDOR_SITE_ID":
                            o.setVendorSiteId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SUBINVENTORY":
                            o.setSubinventory(dataNode.getTextContent());
                            break;
                        case "COMMENTS":
                            o.setComments(dataNode.getTextContent());
                            break;
                        case "QUANTITY_BILLED":
                            try{
                                o.setQuantityBilled(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                int batchCount =59;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncRcvTransactionsMapper.deleteSyncRcvTransactionsEO(list.subList(index, (batchLastIndex + 1)));
                        syncRcvTransactionsMapper.batchSyncRcvTransactionsEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncRcvTransactionsMapper.deleteSyncRcvTransactionsEO(list.subList(index, (batchLastIndex + 1)));
                        syncRcvTransactionsMapper.batchSyncRcvTransactionsEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
        if (true) {//RCV_SHIPMENT_LINES
            NodeList nodeList = root.getElementsByTagName("RCV_SHIPMENT_LINES");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncRcvShipmentLinesEO> list = new ArrayList<SyncRcvShipmentLinesEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncRcvShipmentLinesEO o = new SyncRcvShipmentLinesEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "SHIPMENT_LINE_ID":
                            o.setShipmentLineId(Long.parseLong(dataNode.getTextContent()));
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
                        case "SHIPMENT_HEADER_ID":
                            o.setShipmentHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "LINE_NUM":
                            o.setLineNum(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "CATEGORY_ID":
                            o.setCategoryId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "QUANTITY_SHIPPED":
                            try{
                                o.setQuantityShipped(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "QUANTITY_RECEIVED":
                            try{
                                o.setQuantityReceived(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "QUANTITY_DELIVERED":
                            try{
                                o.setQuantityDelivered(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "QUANTITY_RETURNED":
                            try{
                                o.setQuantityReturned(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "QUANTITY_ACCEPTED":
                            try{
                                o.setQuantityAccepted(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "QUANTITY_REJECTED":
                            try{
                                o.setQuantityRejected(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "UOM_CODE":
                            o.setUomCode(dataNode.getTextContent());
                            break;
                        case "ITEM_DESCRIPTION":
                            o.setItemDescription(dataNode.getTextContent());
                            break;
                        case "ITEM_ID":
                            o.setItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SHIPMENT_LINE_STATUS_CODE":
                            o.setShipmentLineStatusCode(dataNode.getTextContent());
                            break;
                        case "SOURCE_DOCUMENT_CODE":
                            o.setSourceDocumentCode(dataNode.getTextContent());
                            break;
                        case "PO_HEADER_ID":
                            o.setPoHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PO_LINE_ID":
                            o.setPoLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PO_LINE_LOCATION_ID":
                            o.setPoLineLocationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PO_DISTRIBUTION_ID":
                            o.setPoDistributionId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ROUTING_HEADER_ID":
                            o.setRoutingHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PACKING_SLIP":
                            o.setPackingSlip(dataNode.getTextContent());
                            break;
                        case "FROM_ORGANIZATION_ID":
                            o.setFromOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "DELIVER_TO_PERSON_ID":
                            o.setDeliverToPersonId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "EMPLOYEE_ID":
                            o.setEmployeeId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "DESTINATION_TYPE_CODE":
                            o.setDestinationTypeCode(dataNode.getTextContent());
                            break;
                        case "TO_ORGANIZATION_ID":
                            o.setToOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TO_SUBINVENTORY":
                            o.setToSubinventory(dataNode.getTextContent());
                            break;
                        case "LOCATOR_ID":
                            o.setLocatorId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "DELIVER_TO_LOCATION_ID":
                            o.setDeliverToLocationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SHIPMENT_UNIT_PRICE":
                            try{
                                o.setShipmentUnitPrice(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "TRANSFER_COST":
                            try{
                                o.setTransferCost(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "TRANSPORTATION_COST":
                            try{
                                o.setTransportationCost(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "COMMENTS":
                            o.setComments(dataNode.getTextContent());
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
                        case "PRIMARY_UOM_CODE":
                            o.setPrimaryUomCode(dataNode.getTextContent());
                            break;
                        case "SHIP_TO_LOCATION_ID":
                            o.setShipToLocationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "RECEIPT_ADVICE_LINE_NUMBER":
                            o.setReceiptAdviceLineNumber(dataNode.getTextContent());
                            break;
                        case "RA_DOCUMENT_LINE_NUMBER":
                            o.setRaDocumentLineNumber(dataNode.getTextContent());
                            break;
                        case "RA_DOO_HEADER_NUMBER":
                            o.setRaDooHeaderNumber(dataNode.getTextContent());
                            break;
                        case "RA_DOO_LINE_NUMBER":
                            o.setRaDooLineNumber(dataNode.getTextContent());
                            break;
                        case "RA_DOO_FULFILLMENT_LINE_NUMBER":
                            o.setRaDooFulfillmentLineNumber(dataNode.getTextContent());
                            break;
                        case "RA_DOC_SCHEDULE_NUMBER":
                            o.setRaDocScheduleNumber(dataNode.getTextContent());
                            break;
                        case "RA_DOC_LINE_CREATION_DATE":
                            o.setRaDocLineCreationDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "RA_DOC_LINE_LAST_UPDATE_DATE":
                            o.setRaDocLineLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "RA_EXPECTED_RECEIPT_DATE":
                            o.setRaExpectedReceiptDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "RA_DAYS_EARLY_RECEIPT_ALLOWED":
                            try{
                                o.setRaDaysEarlyReceiptAllowed(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "RA_DAYS_LATE_RECEIPT_ALLOWED":
                            try{
                                o.setRaDaysLateReceiptAllowed(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "RA_RECEIPT_DAYS_EXCEPTION_CODE":
                            o.setRaReceiptDaysExceptionCode(dataNode.getTextContent());
                            break;
                        case "RA_ENFORCE_SHIP_TO_LOC_CODE":
                            o.setRaEnforceShipToLocCode(dataNode.getTextContent());
                            break;
                        case "RA_ALLOW_SUBSTITUTE_RECEIPT":
                            o.setRaAllowSubstituteReceipt(dataNode.getTextContent());
                            break;
                        case "RA_QTY_RCV_TOLERANCE":
                            try{
                                o.setRaQtyRcvTolerance(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "RA_QTY_RCV_EXCEPTION_CODE":
                            o.setRaQtyRcvExceptionCode(dataNode.getTextContent());
                            break;
                        case "RA_NOTE_TO_RECEIVER":
                            o.setRaNoteToReceiver(dataNode.getTextContent());
                            break;
                        case "RECEIPT_ADVICE_HEADER_ID":
                            o.setReceiptAdviceHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "RECEIPT_ADVICE_LINE_ID":
                            o.setReceiptAdviceLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "RA_ORIG_DOO_HEADER_NUMBER":
                            o.setRaOrigDooHeaderNumber(dataNode.getTextContent());
                            break;
                        case "RA_ORIG_DOO_LINE_NUMBER":
                            o.setRaOrigDooLineNumber(dataNode.getTextContent());
                            break;
                        case "RA_ORIG_OC_HEADER_NUMBER":
                            o.setRaOrigOcHeaderNumber(dataNode.getTextContent());
                            break;
                        case "RA_ORIG_OC_LINE_NUMBER":
                            o.setRaOrigOcLineNumber(dataNode.getTextContent());
                            break;
                        case "RA_ORIG_DOO_FULFIL_LINE_NUM":
                            o.setRaOrigDooFulfilLineNum(dataNode.getTextContent());
                            break;
                        case "CUSTOMER_ID":
                            o.setCustomerId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "CUSTOMER_SITE_ID":
                            o.setCustomerSiteId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "RA_QUANTITY_EXPECTED":
                            try{
                                o.setRaQuantityExpected(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "RA_SECONDARY_QUANTITY_EXPECTED":
                            try{
                                o.setRaSecondaryQuantityExpected(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "RA_UNIT_PRICE":
                            try{
                                o.setRaUnitPrice(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SP_QUANTITY":
                            try{
                                o.setSpQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SP_UOM_CODE":
                            o.setSpUomCode(dataNode.getTextContent());
                            break;
                        case "SP_GROUP_ID":
                            o.setSpGroupId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "RA_LAST_ACTION_CODE":
                            o.setRaLastActionCode(dataNode.getTextContent());
                            break;
                        case "RA_MESSAGE_NUMBER":
                            try{
                                o.setRaMessageNumber(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "INTERFACE_TRANSACTION_ID":
                            o.setInterfaceTransactionId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRANSFER_ORDER_HEADER_ID":
                            o.setTransferOrderHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRANSFER_ORDER_LINE_ID":
                            o.setTransferOrderLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "CONSIGNED_FLAG":
                            o.setConsignedFlag(dataNode.getTextContent());
                            break;
                        case "FIRST_PTY_REG_ID":
                            o.setFirstPtyRegId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "THIRD_PTY_REG_ID":
                            o.setThirdPtyRegId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "DEFAULT_TAXATION_COUNTRY":
                            o.setDefaultTaxationCountry(dataNode.getTextContent());
                            break;
                        case "DOCUMENT_FISCAL_CLASSIFICATION":
                            o.setDocumentFiscalClassification(dataNode.getTextContent());
                            break;
                        case "TRX_BUSINESS_CATEGORY":
                            o.setTrxBusinessCategory(dataNode.getTextContent());
                            break;
                        case "TAX_INVOICE_NUMBER":
                            o.setTaxInvoiceNumber(dataNode.getTextContent());
                            break;
                        case "TAX_INVOICE_DATE":
                            o.setTaxInvoiceDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "SHIP_FROM_LOCATION_ID":
                            o.setShipFromLocationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "USER_DEFINED_FISC_CLASS":
                            o.setUserDefinedFiscClass(dataNode.getTextContent());
                            break;
                        case "TAX_CLASSIFICATION_CODE":
                            o.setTaxClassificationCode(dataNode.getTextContent());
                            break;
                        case "PRODUCT_TYPE":
                            o.setProductType(dataNode.getTextContent());
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                int batchCount =21;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncRcvShipmentLinesMapper.deleteSyncRcvShipmentLinesEO(list.subList(index, (batchLastIndex + 1)));
                        syncRcvShipmentLinesMapper.batchSyncRcvShipmentLinesEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncRcvShipmentLinesMapper.deleteSyncRcvShipmentLinesEO(list.subList(index, (batchLastIndex + 1)));
                        syncRcvShipmentLinesMapper.batchSyncRcvShipmentLinesEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
    }
}
