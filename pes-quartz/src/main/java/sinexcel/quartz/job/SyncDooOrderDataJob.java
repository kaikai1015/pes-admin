package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.*;
import sinexcel.quartz.mapper.*;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;


@Component("syncDooOrderDataJob")
public class SyncDooOrderDataJob{

    @Autowired
    private SyncDooHeadersAllMapper syncDooHeadersAllMapper;

    @Autowired
    private SyncDooFulfillLinesAllMapper syncDooFulfillLinesAllMapper;

    @Autowired
    private SyncDooLinesAllEOMapper syncDooLinesAllEOMapper;

    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private DooHeadersEffBMapper DooHeadersEffBMapper;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncDooOrderDataJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());


        byte[] data = DataModelCommon.getData("/SYNC_DATA/PesCuxDooOrderData_external.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//DOO_HEADERS_ALL
            NodeList nodeList = root.getElementsByTagName("DOO_HEADERS_ALL");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据

            List<SyncDooHeadersAllEO> list = new ArrayList<SyncDooHeadersAllEO>();

            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncDooHeadersAllEO o = new SyncDooHeadersAllEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "HEADER_ID":
                            o.setHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PRE_CREDIT_CHECKED_FLAG":
                            o.setPreCreditCheckedFlag(dataNode.getTextContent());
                            break;
                        case "ORDER_NUMBER":
                            o.setOrderNumber(dataNode.getTextContent());
                            break;
                        case "OBJECT_VERSION_NUMBER":
                            o.setObjectVersionNumber(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "OWNER_ID":
                            o.setOwnerId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "CREATION_DATE":
                            o.setCreationDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "CREATED_BY":
                            o.setCreatedBy(dataNode.getTextContent());
                            break;
                        case "LAST_UPDATE_DATE":
                            o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATED_BY":
                            o.setLastUpdatedBy(dataNode.getTextContent());
                            break;
                        case "LAST_UPDATE_LOGIN":
                            o.setLastUpdateLogin(dataNode.getTextContent());
                            break;
                        case "SOURCE_ORDER_SYSTEM":
                            o.setSourceOrderSystem(dataNode.getTextContent());
                            break;
                        case "SOURCE_ORDER_NUMBER":
                            o.setSourceOrderNumber(dataNode.getTextContent());
                            break;
                        case "SOURCE_ORDER_ID":
                            o.setSourceOrderId(dataNode.getTextContent());
                            break;
                        case "SOURCE_DOCUMENT_TYPE_CODE":
                            o.setSourceDocumentTypeCode(dataNode.getTextContent());
                            break;
                        case "SOURCE_REVISION_NUMBER":
                            o.setSourceRevisionNumber(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORIG_SYS_DOCUMENT_REF":
                            o.setOrigSysDocumentRef(dataNode.getTextContent());
                            break;
                        case "SOURCE_ORG_ID":
                            o.setSourceOrgId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORG_ID":
                            o.setOrgId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "LEGAL_ENTITY_ID":
                            o.setLegalEntityId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SOLD_TO_CUSTOMER_ID":
                            o.setSoldToCustomerId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SOLD_TO_CONTACT_ID":
                            o.setSoldToContactId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORDERED_DATE":
                            o.setOrderedDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "CUSTOMER_PO_NUMBER":
                            o.setCustomerPoNumber(dataNode.getTextContent());
                            break;
                        case "ORDER_TYPE_CODE":
                            o.setOrderTypeCode(dataNode.getTextContent());
                            break;
                        case "TRANSACTIONAL_CURRENCY_CODE":
                            o.setTransactionalCurrencyCode(dataNode.getTextContent());
                            break;
                        case "CONVERSION_RATE":
                            try{
                                o.setConversionRate(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CONVERSION_TYPE_CODE":
                            o.setConversionTypeCode(dataNode.getTextContent());
                            break;
                        case "CONVERSION_DATE":
                            o.setConversionDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "STATUS_CODE":
                            o.setStatusCode(dataNode.getTextContent());
                            break;
                        case "PARTIAL_SHIP_ALLOWED_FLAG":
                            o.setPartialShipAllowedFlag(dataNode.getTextContent());
                            break;
                        case "OPEN_FLAG":
                            o.setOpenFlag(dataNode.getTextContent());
                            break;
                        case "ON_HOLD":
                            o.setOnHold(dataNode.getTextContent());
                            break;
                        case "CANCELED_FLAG":
                            o.setCanceledFlag(dataNode.getTextContent());
                            break;
                        case "CHANGE_VERSION_NUMBER":
                            o.setChangeVersionNumber(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "IS_EDITABLE":
                            o.setIsEditable(dataNode.getTextContent());
                            break;
                        case "CANCEL_REASON_CODE":
                            o.setCancelReasonCode(dataNode.getTextContent());
                            break;
                        case "SOLD_TO_PARTY_ID":
                            o.setSoldToPartyId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SOLD_TO_PARTY_CONTACT_ID":
                            o.setSoldToPartyContactId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "REQUEST_CANCEL_DATE":
                            o.setRequestCancelDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "COMMENTS":
                            o.setComments(dataNode.getTextContent());
                            break;
                        case "ALLOW_CURRENCY_OVERRIDE_FLAG":
                            o.setAllowCurrencyOverrideFlag(dataNode.getTextContent());
                            break;
                        case "APPLIED_CURRENCY_CODE":
                            o.setAppliedCurrencyCode(dataNode.getTextContent());
                            break;
                        case "PRICED_ON":
                            o.setPricedOn(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "PRICING_SEGMENT_CODE":
                            o.setPricingSegmentCode(dataNode.getTextContent());
                            break;
                        case "PRICING_SEGMENT_EXPLANATION":
                            o.setPricingSegmentExplanation(dataNode.getTextContent());
                            break;
                        case "PRICING_STRATEGY_EXPLANATION":
                            o.setPricingStrategyExplanation(dataNode.getTextContent());
                            break;
                        case "SEGMENT_EXPLANATION_MSG_NAME":
                            o.setSegmentExplanationMsgName(dataNode.getTextContent());
                            break;
                        case "STRATEGY_EXPLANATION_MSG_NAME":
                            o.setStrategyExplanationMsgName(dataNode.getTextContent());
                            break;
                        case "PRICING_STRATEGY_ID":
                            o.setPricingStrategyId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "FREEZE_TAX_FLAG":
                            o.setFreezeTaxFlag(dataNode.getTextContent());
                            break;
                        case "SHIPSET_FLAG":
                            o.setShipsetFlag(dataNode.getTextContent());
                            break;
                        case "FULFILL_ORG_ID":
                            o.setFulfillOrgId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SUPPLIER_ID":
                            o.setSupplierId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SUPPLIER_SITE_ID":
                            o.setSupplierSiteId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "DEMAND_CLASS_CODE":
                            o.setDemandClassCode(dataNode.getTextContent());
                            break;
                        case "SUBSTITUTE_ALLOWED_FLAG":
                            o.setSubstituteAllowedFlag(dataNode.getTextContent());
                            break;
                        case "FREIGHT_TERMS_CODE":
                            o.setFreightTermsCode(dataNode.getTextContent());
                            break;
                        case "FOB_POINT_CODE":
                            o.setFobPointCode(dataNode.getTextContent());
                            break;
                        case "PACKING_INSTRUCTIONS":
                            o.setPackingInstructions(dataNode.getTextContent());
                            break;
                        case "SHIPPING_INSTRUCTIONS":
                            o.setShippingInstructions(dataNode.getTextContent());
                            break;
                        case "SHIPMENT_PRIORITY_CODE":
                            o.setShipmentPriorityCode(dataNode.getTextContent());
                            break;
                        case "REQUEST_SHIP_DATE":
                            o.setRequestShipDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LATEST_ACCEPTABLE_SHIP_DATE":
                            o.setLatestAcceptableShipDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "EARLIEST_ACCEPTABLE_SHIP_DATE":
                            o.setEarliestAcceptableShipDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "CARRIER_ID":
                            o.setCarrierId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SHIP_MODE_OF_TRANSPORT":
                            o.setShipModeOfTransport(dataNode.getTextContent());
                            break;
                        case "SHIP_CLASS_OF_SERVICE":
                            o.setShipClassOfService(dataNode.getTextContent());
                            break;
                        case "REQUEST_ARRIVAL_DATE":
                            o.setRequestArrivalDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LATEST_ACCEPT_ARRIVAL_DATE":
                            o.setLatestAcceptArrivalDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "EARLIEST_ACCEPT_ARRIVAL_DATE":
                            o.setEarliestAcceptArrivalDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "SUBMITTED_FLAG":
                            o.setSubmittedFlag(dataNode.getTextContent());
                            break;
                        case "REFERENCE_HEADER_ID":
                            o.setReferenceHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "FREEZE_PRICE_FLAG":
                            o.setFreezePriceFlag(dataNode.getTextContent());
                            break;
                        case "FREEZE_SHIPPING_CHARGE_FLAG":
                            o.setFreezeShippingChargeFlag(dataNode.getTextContent());
                            break;
                        case "PAYMENT_TERM_ID":
                            o.setPaymentTermId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SOLD_TO_PARTY_CONTACT_POINT_ID":
                            o.setSoldToPartyContactPointId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "MODIFIED_FLAG":
                            o.setModifiedFlag(dataNode.getTextContent());
                            break;
                        case "REVISION_SOURCE_ORDER_SYSTEM":
                            o.setRevisionSourceOrderSystem(dataNode.getTextContent());
                            break;
                        case "APPROVAL_SEQUENCE_NUMBER":
                            o.setApprovalSequenceNumber(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRADE_COMPLIANCE_RESULT_CODE":
                            o.setTradeComplianceResultCode(dataNode.getTextContent());
                            break;
                        case "CREATED_IN_RELEASE":
                            o.setCreatedInRelease(dataNode.getTextContent());
                            break;
                        case "SUBMITTED_DATE":
                            o.setSubmittedDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "SUBMITTED_BY":
                            o.setSubmittedBy(dataNode.getTextContent());
                            break;
                        case "SALES_CHANNEL_CODE":
                            o.setSalesChannelCode(dataNode.getTextContent());
                            break;
                        case "SALESPERSON_ID":
                            o.setSalespersonId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "BATCH_ID":
                            o.setBatchId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "CREATION_MODE":
                            o.setCreationMode(dataNode.getTextContent());
                            break;
                        case "MDO_FLAG":
                            o.setMdoFlag(dataNode.getTextContent());
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                int batchCount =23;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncDooHeadersAllMapper.deleteSyncDooHeadersAllEO(list.subList(index, (batchLastIndex + 1)));
                        syncDooHeadersAllMapper.batchSyncDooHeadersAllEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncDooHeadersAllMapper.deleteSyncDooHeadersAllEO(list.subList(index, (batchLastIndex + 1)));
                        syncDooHeadersAllMapper.batchSyncDooHeadersAllEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
        if (true) {//DOO_FULFILL_LINES_ALL
            NodeList nodeList = root.getElementsByTagName("DOO_FULFILL_LINES_ALL");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据

            List<SyncDooFulfillLinesAllEO> list = new ArrayList<SyncDooFulfillLinesAllEO>();

            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncDooFulfillLinesAllEO o = new SyncDooFulfillLinesAllEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "FULFILL_LINE_ID":
                            o.setFulfillLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SERVICE_CANCEL_DATE":
                            o.setServiceCancelDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "AGREEMENT_HEADER_ID":
                            o.setAgreementHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "AGREEMENT_LINE_ID":
                            o.setAgreementLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "AGREEMENT_VERSION_NUMBER":
                            o.setAgreementVersionNumber(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "RECEIVABLES_ORG_ID":
                            o.setReceivablesOrgId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "OBJECT_VERSION_NUMBER":
                            o.setObjectVersionNumber(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "HEADER_ID":
                            o.setHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "LINE_ID":
                            o.setLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "FULFILL_LINE_NUMBER":
                            o.setFulfillLineNumber(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ITEM_TYPE_CODE":
                            o.setItemTypeCode(dataNode.getTextContent());
                            break;
                        case "ORDERED_QTY":
                            try{
                                o.setOrderedQty(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "STATUS_CODE":
                            o.setStatusCode(dataNode.getTextContent());
                            break;
                        case "SOURCE_LINE_ID":
                            o.setSourceLineId(dataNode.getTextContent());
                            break;
                        case "SOURCE_LINE_NUMBER":
                            o.setSourceLineNumber(dataNode.getTextContent());
                            break;
                        case "SOURCE_ORDER_ID":
                            o.setSourceOrderId(dataNode.getTextContent());
                            break;
                        case "SOURCE_ORDER_NUMBER":
                            o.setSourceOrderNumber(dataNode.getTextContent());
                            break;
                        case "SOURCE_ORDER_SYSTEM":
                            o.setSourceOrderSystem(dataNode.getTextContent());
                            break;
                        case "SOURCE_SCHEDULE_ID":
                            o.setSourceScheduleId(dataNode.getTextContent());
                            break;
                        case "SOURCE_SCHEDULE_NUMBER":
                            o.setSourceScheduleNumber(dataNode.getTextContent());
                            break;
                        case "SOURCE_REVISION_NUMBER":
                            o.setSourceRevisionNumber(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "COMP_SEQ_PATH":
                            o.setCompSeqPath(dataNode.getTextContent());
                            break;
                        case "OWNER_ID":
                            o.setOwnerId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "CREATION_DATE":
                            o.setCreationDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "CREATED_BY":
                            o.setCreatedBy(dataNode.getTextContent());
                            break;
                        case "LAST_UPDATE_DATE":
                            o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATED_BY":
                            o.setLastUpdatedBy(dataNode.getTextContent());
                            break;
                        case "LAST_UPDATE_LOGIN":
                            o.setLastUpdateLogin(dataNode.getTextContent());
                            break;
                        case "FULFILL_ORG_ID":
                            o.setFulfillOrgId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "CANCELED_QTY":
                            try{
                                o.setCanceledQty(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ORDERED_UOM":
                            o.setOrderedUom(dataNode.getTextContent());
                            break;
                        case "PURCHASING_UOM":
                            o.setPurchasingUom(dataNode.getTextContent());
                            break;
                        case "SHIPPED_UOM":
                            o.setShippedUom(dataNode.getTextContent());
                            break;
                        case "RMA_DELIVERED_QTY":
                            try{
                                o.setRmaDeliveredQty(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "FULFILLED_QTY":
                            try{
                                o.setFulfilledQty(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SHIPPED_QTY":
                            try{
                                o.setShippedQty(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "RESERVED_QTY":
                            try{
                                o.setReservedQty(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "RESERVABLE_FLAG":
                            o.setReservableFlag(dataNode.getTextContent());
                            break;
                        case "SHIPPABLE_FLAG":
                            o.setShippableFlag(dataNode.getTextContent());
                            break;
                        case "INVOICEABLE_ITEM_FLAG":
                            o.setInvoiceableItemFlag(dataNode.getTextContent());
                            break;
                        case "INVOICE_ENABLED_FLAG":
                            o.setInvoiceEnabledFlag(dataNode.getTextContent());
                            break;
                        case "RETURNABLE_FLAG":
                            o.setReturnableFlag(dataNode.getTextContent());
                            break;
                        case "INVOICE_INTERFACED_FLAG":
                            o.setInvoiceInterfacedFlag(dataNode.getTextContent());
                            break;
                        case "BILL_TO_CONTACT_ID":
                            o.setBillToContactId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "BILL_TO_CUSTOMER_ID":
                            o.setBillToCustomerId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "BILL_TO_SITE_USE_ID":
                            o.setBillToSiteUseId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SOURCE_ORG_ID":
                            o.setSourceOrgId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORG_ID":
                            o.setOrgId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "REQUEST_ARRIVAL_DATE":
                            o.setRequestArrivalDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "REQUEST_SHIP_DATE":
                            o.setRequestShipDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "SCHEDULE_ARRIVAL_DATE":
                            o.setScheduleArrivalDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "SCHEDULE_SHIP_DATE":
                            o.setScheduleShipDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "PROMISE_ARRIVAL_DATE":
                            o.setPromiseArrivalDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "PROMISE_SHIP_DATE":
                            o.setPromiseShipDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "ACTUAL_SHIP_DATE":
                            o.setActualShipDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "FULFILLMENT_DATE":
                            o.setFulfillmentDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "CUSTOMER_ITEM_ID":
                            o.setCustomerItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "CUSTOMER_PO_LINE_NUMBER":
                            o.setCustomerPoLineNumber(dataNode.getTextContent());
                            break;
                        case "CUSTOMER_PO_NUMBER":
                            o.setCustomerPoNumber(dataNode.getTextContent());
                            break;
                        case "DEMAND_CLASS_CODE":
                            o.setDemandClassCode(dataNode.getTextContent());
                            break;
                        case "EXTENDED_AMOUNT":
                            try{
                                o.setExtendedAmount(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "FOB_POINT_CODE":
                            o.setFobPointCode(dataNode.getTextContent());
                            break;
                        case "CARRIER_ID":
                            o.setCarrierId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "INVOICING_RULE_ID":
                            o.setInvoicingRuleId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "EXEMPTION_CERTIFICATE_NUMBER":
                            o.setExemptionCertificateNumber(dataNode.getTextContent());
                            break;
                        case "ACCOUNTING_RULE_ID":
                            o.setAccountingRuleId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "LINE_TYPE_CODE":
                            o.setLineTypeCode(dataNode.getTextContent());
                            break;
                        case "CATEGORY_CODE":
                            o.setCategoryCode(dataNode.getTextContent());
                            break;
                        case "OPEN_FLAG":
                            o.setOpenFlag(dataNode.getTextContent());
                            break;
                        case "CANCELED_FLAG":
                            o.setCanceledFlag(dataNode.getTextContent());
                            break;
                        case "OVERRIDE_SCHEDULE_DATE_FLAG":
                            o.setOverrideScheduleDateFlag(dataNode.getTextContent());
                            break;
                        case "ORIGINAL_INVENTORY_ITEM_ID":
                            o.setOriginalInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "GOP_REFERENCE_ID":
                            o.setGopReferenceId(dataNode.getTextContent());
                            break;
                        case "PACKING_INSTRUCTIONS":
                            o.setPackingInstructions(dataNode.getTextContent());
                            break;
                        case "PARENT_FULFILL_LINE_ID":
                            o.setParentFulfillLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PAYMENT_TERM_ID":
                            o.setPaymentTermId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "REQUEST_TYPE":
                            o.setRequestType(dataNode.getTextContent());
                            break;
                        case "RETURN_REASON_CODE":
                            o.setReturnReasonCode(dataNode.getTextContent());
                            break;
                        case "ORIG_SYS_DOCUMENT_REF":
                            o.setOrigSysDocumentRef(dataNode.getTextContent());
                            break;
                        case "ORIG_SYS_DOCUMENT_LINE_REF":
                            o.setOrigSysDocumentLineRef(dataNode.getTextContent());
                            break;
                        case "ROOT_PARENT_FULFILL_LINE_ID":
                            o.setRootParentFulfillLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SHIP_CLASS_OF_SERVICE":
                            o.setShipClassOfService(dataNode.getTextContent());
                            break;
                        case "SHIP_MODE_OF_TRANSPORT":
                            o.setShipModeOfTransport(dataNode.getTextContent());
                            break;
                        case "SHIP_TO_CONTACT_ID":
                            o.setShipToContactId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SHIP_TO_CUSTOMER_ID":
                            o.setShipToCustomerId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SHIP_TO_SITE_USE_ID":
                            o.setShipToSiteUseId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "FULFILL_TOLERANCE_ABOVE":
                            try{
                                o.setFulfillToleranceAbove(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "FULFILL_TOLERANCE_BELOW":
                            try{
                                o.setFulfillToleranceBelow(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SHIPMENT_PRIORITY_CODE":
                            o.setShipmentPriorityCode(dataNode.getTextContent());
                            break;
                        case "SHIPPING_INSTRUCTIONS":
                            o.setShippingInstructions(dataNode.getTextContent());
                            break;
                        case "SHIP_SET_NAME":
                            o.setShipSetName(dataNode.getTextContent());
                            break;
                        case "SPLIT_FROM_FLINE_ID":
                            o.setSplitFromFlineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PARTIAL_SHIP_ALLOWED_FLAG":
                            o.setPartialShipAllowedFlag(dataNode.getTextContent());
                            break;
                        case "SUBSTITUTE_ALLOWED_FLAG":
                            o.setSubstituteAllowedFlag(dataNode.getTextContent());
                            break;
                        case "SUBSTITUTE_REASON_CODE":
                            o.setSubstituteReasonCode(dataNode.getTextContent());
                            break;
                        case "TAX_EXEMPT_FLAG":
                            o.setTaxExemptFlag(dataNode.getTextContent());
                            break;
                        case "TAX_CLASSIFICATION_CODE":
                            o.setTaxClassificationCode(dataNode.getTextContent());
                            break;
                        case "DELTA_TYPE":
                            o.setDeltaType(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TAX_EXEMPTION_REASON_CODE":
                            o.setTaxExemptionReasonCode(dataNode.getTextContent());
                            break;
                        case "UNIT_LIST_PRICE":
                            try{
                                o.setUnitListPrice(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "UNIT_SELLING_PRICE":
                            try{
                                o.setUnitSellingPrice(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "REFERENCE_FLINE_ID":
                            o.setReferenceFlineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "LATEST_ACCEPTABLE_SHIP_DATE":
                            o.setLatestAcceptableShipDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LATEST_ACCEPTABLE_ARRIVAL_DATE":
                            o.setLatestAcceptableArrivalDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "EARLIEST_ACCEPTABLE_SHIP_DATE":
                            o.setEarliestAcceptableShipDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "ON_HOLD":
                            o.setOnHold(dataNode.getTextContent());
                            break;
                        case "RESERVATION_ID":
                            o.setReservationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ACTUAL_COMPLETION_DATE":
                            o.setActualCompletionDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "INVENTORY_ORGANIZATION_ID":
                            o.setInventoryOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "FULFILL_INSTANCE_ID":
                            o.setFulfillInstanceId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "STATUS_RULESET_ID":
                            o.setStatusRulesetId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "REMNANT_FLAG":
                            o.setRemnantFlag(dataNode.getTextContent());
                            break;
                        case "FULFILLMENT_SPLIT_REF_ID":
                            o.setFulfillmentSplitRefId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ESTIMATE_MARGIN":
                            try{
                                o.setEstimateMargin(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ESTIMATE_FULFILLMENT_COST":
                            try{
                                o.setEstimateFulfillmentCost(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "FREIGHT_TERMS_CODE":
                            o.setFreightTermsCode(dataNode.getTextContent());
                            break;
                        case "CANCEL_REASON_CODE":
                            o.setCancelReasonCode(dataNode.getTextContent());
                            break;
                        case "LATEST_EXT_FULFILL_LINE_NUMBER":
                            o.setLatestExtFulfillLineNumber(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "GOP_REQUEST_REGION":
                            o.setGopRequestRegion(dataNode.getTextContent());
                            break;
                        case "SCHEDULING_REASON_CODE":
                            o.setSchedulingReasonCode(dataNode.getTextContent());
                            break;
                        case "SUBINVENTORY":
                            o.setSubinventory(dataNode.getTextContent());
                            break;
                        case "SUPPLIER_ID":
                            o.setSupplierId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SUPPLIER_SITE_ID":
                            o.setSupplierSiteId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SHIP_TO_PARTY_ID":
                            o.setShipToPartyId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SHIP_TO_PARTY_SITE_ID":
                            o.setShipToPartySiteId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SHIP_TO_PARTY_CONTACT_ID":
                            o.setShipToPartyContactId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "CONFIG_ITEM_REFERENCE":
                            o.setConfigItemReference(dataNode.getTextContent());
                            break;
                        case "ITEM_SUB_TYPE_CODE":
                            o.setItemSubTypeCode(dataNode.getTextContent());
                            break;
                        case "REQUISITION_INVENTORY_ORG_ID":
                            o.setRequisitionInventoryOrgId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "REQUISITION_BU_ID":
                            o.setRequisitionBuId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "FULFILLMENT_MODE":
                            o.setFulfillmentMode(dataNode.getTextContent());
                            break;
                        case "PO_STATUS_CODE":
                            o.setPoStatusCode(dataNode.getTextContent());
                            break;
                        case "BUYER_ID":
                            o.setBuyerId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "REQUEST_CANCEL_DATE":
                            o.setRequestCancelDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "COMMENTS":
                            o.setComments(dataNode.getTextContent());
                            break;
                        case "DEFAULT_TAXATION_COUNTRY":
                            o.setDefaultTaxationCountry(dataNode.getTextContent());
                            break;
                        case "FIRST_PTY_REG_ID":
                            o.setFirstPtyRegId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "THIRD_PTY_REG_ID":
                            o.setThirdPtyRegId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "DOCUMENT_SUB_TYPE":
                            o.setDocumentSubType(dataNode.getTextContent());
                            break;
                        case "TAX_INVOICE_NUMBER":
                            o.setTaxInvoiceNumber(dataNode.getTextContent());
                            break;
                        case "TAX_INVOICE_DATE":
                            o.setTaxInvoiceDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "FINAL_DISCHARGE_LOCATION_ID":
                            o.setFinalDischargeLocationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PROD_FC_CATEG_ID":
                            o.setProdFcCategId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PRODUCT_TYPE":
                            o.setProductType(dataNode.getTextContent());
                            break;
                        case "PRODUCT_CATEGORY":
                            o.setProductCategory(dataNode.getTextContent());
                            break;
                        case "TRX_BUSINESS_CATEGORY":
                            o.setTrxBusinessCategory(dataNode.getTextContent());
                            break;
                        case "USER_DEFINED_FISC_CLASS":
                            o.setUserDefinedFiscClass(dataNode.getTextContent());
                            break;
                        case "INTENDED_USE_CLASSIF_ID":
                            o.setIntendedUseClassifId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "DESTINATION_LOCATION_ID":
                            o.setDestinationLocationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "DESTINATION_ORG_ID":
                            o.setDestinationOrgId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "QUANTITY_PER_MODEL":
                            try{
                                o.setQuantityPerModel(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CONFIG_INVENTORY_ITEM_ID":
                            o.setConfigInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PURCHASING_ENABLED_FLAG":
                            o.setPurchasingEnabledFlag(dataNode.getTextContent());
                            break;
                        case "CUSTOMER_PO_SCHEDULE_NUMBER":
                            o.setCustomerPoScheduleNumber(dataNode.getTextContent());
                            break;
                        case "SUPPLY_STATUS_CODE":
                            o.setSupplyStatusCode(dataNode.getTextContent());
                            break;
                        case "SHIP_TO_CONTACT_POINT_ID":
                            o.setShipToContactPointId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PREF_OVERRIDDEN_BITSET":
                            o.setPrefOverriddenBitset(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "APPLIED_PRICE_LIST_ID":
                            o.setAppliedPriceListId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PRICED_ON":
                            o.setPricedOn(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "REQUIRED_FULFILLMENT_DATE":
                            o.setRequiredFulfillmentDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "COMPONENT_ID_PATH":
                            o.setComponentIdPath(dataNode.getTextContent());
                            break;
                        case "VALID_CONFIGURATION_FLAG":
                            o.setValidConfigurationFlag(dataNode.getTextContent());
                            break;
                        case "CONFIGURATOR_PATH":
                            o.setConfiguratorPath(dataNode.getTextContent());
                            break;
                        case "CONFIG_HEADER_ID":
                            o.setConfigHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "CONFIG_REVISION_NUMBER":
                            o.setConfigRevisionNumber(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SHOW_IN_SALES":
                            o.setShowInSales(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "CHANGE_ELIGIBLE_FLAG":
                            o.setChangeEligibleFlag(dataNode.getTextContent());
                            break;
                        case "MODIFIED_FLAG":
                            o.setModifiedFlag(dataNode.getTextContent());
                            break;
                        case "UNREFERENCED_RETURN_FLAG":
                            o.setUnreferencedReturnFlag(dataNode.getTextContent());
                            break;
                        case "BILL_TO_CONTACT_POINT_ID":
                            o.setBillToContactPointId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "UNIT_QUANTITY":
                            try{
                                o.setUnitQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CONFIG_CREATION_DATE":
                            o.setConfigCreationDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "CONTRACT_START_DATE":
                            o.setContractStartDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "CONTRACT_END_DATE":
                            o.setContractEndDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "TOTAL_CONTRACT_QUANTITY":
                            try{
                                o.setTotalContractQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "TOTAL_CONTRACT_AMOUNT":
                            try{
                                o.setTotalContractAmount(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "PROCESS_INSTANCE_ID":
                            o.setProcessInstanceId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PROCESS_NUMBER":
                            o.setProcessNumber(dataNode.getTextContent());
                            break;
                        case "CREDIT_CHK_AUTH_NUM":
                            o.setCreditChkAuthNum(dataNode.getTextContent());
                            break;
                        case "CREDIT_CHK_AUTH_EXP_DATE":
                            o.setCreditChkAuthExpDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "TRADE_COMPLIANCE_RESULT_CODE":
                            o.setTradeComplianceResultCode(dataNode.getTextContent());
                            break;
                        case "TRADE_COMPLIANCE_DATE":
                            o.setTradeComplianceDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "TRANSPORTATION_PLANNED_FLAG":
                            o.setTransportationPlannedFlag(dataNode.getTextContent());
                            break;
                        case "CREATED_IN_RELEASE":
                            o.setCreatedInRelease(dataNode.getTextContent());
                            break;
                        case "CONFIG_TRADE_COMPL_RESULT_CODE":
                            o.setConfigTradeComplResultCode(dataNode.getTextContent());
                            break;
                        case "BILLING_TRX_TYPE_ID":
                            o.setBillingTrxTypeId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SERVICE_DURATION":
                            try{
                                o.setServiceDuration(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SERVICE_DURATION_PERIOD_CODE":
                            o.setServiceDurationPeriodCode(dataNode.getTextContent());
                            break;
                        case "SALES_PRODUCT_TYPE_CODE":
                            o.setSalesProductTypeCode(dataNode.getTextContent());
                            break;
                        case "ACTION_TYPE_CODE":
                            o.setActionTypeCode(dataNode.getTextContent());
                            break;
                        case "ASSET_TRACKED_FLAG":
                            o.setAssetTrackedFlag(dataNode.getTextContent());
                            break;
                        case "ASSET_GROUP_NUMBER":
                            o.setAssetGroupNumber(dataNode.getTextContent());
                            break;
                        case "PROCESS_SET":
                            o.setProcessSet(dataNode.getTextContent());
                            break;
                        case "SALESPERSON_ID":
                            o.setSalespersonId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "BATCH_ID":
                            o.setBatchId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PROCESS_ID":
                            o.setProcessId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PRJ_REC_INDICATOR":
                            o.setPrjRecIndicator(dataNode.getTextContent());
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                int batchCount =10;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncDooFulfillLinesAllMapper.deleteSyncDooFulfillLinesAllEO(list.subList(index, (batchLastIndex + 1)));
                        syncDooFulfillLinesAllMapper.batchSyncDooFulfillLinesAllEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncDooFulfillLinesAllMapper.deleteSyncDooFulfillLinesAllEO(list.subList(index, (batchLastIndex + 1)));
                        syncDooFulfillLinesAllMapper.batchSyncDooFulfillLinesAllEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }

        if (true) {//DOO_LINES_ALL
            NodeList nodeList = root.getElementsByTagName("DOO_LINES_ALL");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据

            List<SyncDooLinesAllEO> list = new ArrayList<SyncDooLinesAllEO>();

            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncDooLinesAllEO o = new SyncDooLinesAllEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "HEADER_ID":
                            o.setHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "LINE_ID":
                            o.setLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "LINE_NUMBER":
                            o.setLineNumber(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "STATUS_CODE":
                            o.setStatusCode(dataNode.getTextContent());
                            break;
                        case "OWNER_ID":
                            o.setOwnerId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "CREATION_DATE":
                            o.setCreationDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "CREATED_BY":
                            o.setCreatedBy(dataNode.getTextContent());
                            break;
                        case "LAST_UPDATE_DATE":
                            o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATED_BY":
                            o.setLastUpdatedBy(dataNode.getTextContent());
                            break;
                        case "LAST_UPDATE_LOGIN":
                            o.setLastUpdateLogin(dataNode.getTextContent());
                            break;
                        case "SOURCE_LINE_ID":
                            o.setSourceLineId(dataNode.getTextContent());
                            break;
                        case "SOURCE_LINE_NUMBER":
                            o.setSourceLineNumber(dataNode.getTextContent());
                            break;
                        case "SOURCE_ORDER_ID":
                            o.setSourceOrderId(dataNode.getTextContent());
                            break;
                        case "SOURCE_ORDER_NUMBER":
                            o.setSourceOrderNumber(dataNode.getTextContent());
                            break;
                        case "SOURCE_ORDER_SYSTEM":
                            o.setSourceOrderSystem(dataNode.getTextContent());
                            break;
                        case "SOURCE_SCHEDULE_ID":
                            o.setSourceScheduleId(dataNode.getTextContent());
                            break;
                        case "SOURCE_SCHEDULE_NUMBER":
                            o.setSourceScheduleNumber(dataNode.getTextContent());
                            break;
                        case "SOURCE_REVISION_NUMBER":
                            o.setSourceRevisionNumber(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ITEM_TYPE_CODE":
                            o.setItemTypeCode(dataNode.getTextContent());
                            break;
                        case "ORDERED_QTY":
                            try{
                                o.setOrderedQty(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CANCELED_QTY":
                            try{
                                o.setCanceledQty(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ORDERED_UOM":
                            o.setOrderedUom(dataNode.getTextContent());
                            break;
                        case "SOURCE_ORG_ID":
                            o.setSourceOrgId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORG_ID":
                            o.setOrgId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ACTUAL_SHIP_DATE":
                            o.setActualShipDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "SCHEDULE_SHIP_DATE":
                            o.setScheduleShipDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "RMA_DELIVERED_QTY":
                            try{
                                o.setRmaDeliveredQty(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "EXTENDED_AMOUNT":
                            try{
                                o.setExtendedAmount(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "FULFILLED_QTY":
                            try{
                                o.setFulfilledQty(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "FULFILLMENT_DATE":
                            o.setFulfillmentDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LINE_TYPE_CODE":
                            o.setLineTypeCode(dataNode.getTextContent());
                            break;
                        case "OBJECT_VERSION_NUMBER":
                            o.setObjectVersionNumber(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "OPEN_FLAG":
                            o.setOpenFlag(dataNode.getTextContent());
                            break;
                        case "CANCELED_FLAG":
                            o.setCanceledFlag(dataNode.getTextContent());
                            break;
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "COMP_SEQ_PATH":
                            o.setCompSeqPath(dataNode.getTextContent());
                            break;
                        case "PARENT_LINE_ID":
                            o.setParentLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORIG_SYS_DOCUMENT_REF":
                            o.setOrigSysDocumentRef(dataNode.getTextContent());
                            break;
                        case "ORIG_SYS_DOCUMENT_LINE_REF":
                            o.setOrigSysDocumentLineRef(dataNode.getTextContent());
                            break;
                        case "ROOT_PARENT_LINE_ID":
                            o.setRootParentLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SHIPPED_QTY":
                            try{
                                o.setShippedQty(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "UNIT_LIST_PRICE":
                            try{
                                o.setUnitListPrice(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "UNIT_SELLING_PRICE":
                            try{
                                o.setUnitSellingPrice(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "DELTA_TYPE":
                            o.setDeltaType(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "REFERENCE_LINE_ID":
                            o.setReferenceLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ON_HOLD":
                            o.setOnHold(dataNode.getTextContent());
                            break;
                        case "INVENTORY_ORGANIZATION_ID":
                            o.setInventoryOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "CATEGORY_CODE":
                            o.setCategoryCode(dataNode.getTextContent());
                            break;
                        case "TRANSFORM_FROM_LINE_ID":
                            o.setTransformFromLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ITEM_SUB_TYPE_CODE":
                            o.setItemSubTypeCode(dataNode.getTextContent());
                            break;
                        case "QUANTITY_PER_MODEL":
                            try{
                                o.setQuantityPerModel(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "MODIFIED_FLAG":
                            o.setModifiedFlag(dataNode.getTextContent());
                            break;
                        case "DISPLAY_LINE_NUMBER":
                            o.setDisplayLineNumber(dataNode.getTextContent());
                            break;
                        case "CREATED_IN_RELEASE":
                            o.setCreatedInRelease(dataNode.getTextContent());
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                int batchCount =38;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncDooLinesAllEOMapper.deleteSyncDooLinesAllEO(list.subList(index, (batchLastIndex + 1)));
                        syncDooLinesAllEOMapper.batchSyncDooLinesAllEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncDooLinesAllEOMapper.deleteSyncDooLinesAllEO(list.subList(index, (batchLastIndex + 1)));
                        syncDooLinesAllEOMapper.batchSyncDooLinesAllEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }

        if (true) {//DOO_HEADERS_EFF_B
            NodeList nodeList = root.getElementsByTagName("DOO_HEADERS_EFF_B");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据

            List<DooHeadersEffBEO> list = new ArrayList<DooHeadersEffBEO>();

            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                DooHeadersEffBEO o = new DooHeadersEffBEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "HEADER_ID":
                            o.setHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORDER_NUMBER":
                            o.setOrderNumber(dataNode.getTextContent());
                            break;
                        case "CHAN_PING_XIAN":
                            o.setChanPingXian(dataNode.getTextContent());
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                int batchCount =690;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        DooHeadersEffBMapper.deleteDooHeadersEffBEO(list.subList(index, (batchLastIndex + 1)));
                        DooHeadersEffBMapper.batchDooHeadersEffBEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        DooHeadersEffBMapper.deleteDooHeadersEffBEO(list.subList(index, (batchLastIndex + 1)));
                        DooHeadersEffBMapper.batchDooHeadersEffBEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
    }
}
