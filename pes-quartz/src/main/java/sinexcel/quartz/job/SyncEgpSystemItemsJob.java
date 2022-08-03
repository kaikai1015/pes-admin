package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.SyncEgpSystemItemsBEO;
import sinexcel.quartz.domain.SyncEgpSystemItemsWEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SyncEgpSystemItemsBMapper;
import sinexcel.quartz.mapper.SyncEgpSystemItemsBWMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;


@Component("syncEgpSystemItemsJob")
public class SyncEgpSystemItemsJob {

    @Autowired
    private SyncEgpSystemItemsBMapper syncEgpSystemItemsBMapper;

    @Autowired
    private SyncEgpSystemItemsBWMapper syncEgpSystemItemsBWMapper;

    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncEgpSystemItemsJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());

        byte[] data = DataModelCommon.getData("/SYNC_DATA/CuxItemsData_externalPes.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();


        if (true) {//EGP_SYSTEM_ITEMS_B
            NodeList nodeList = root.getElementsByTagName("EGP_SYSTEM_ITEMS_B");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据

            List<SyncEgpSystemItemsBEO> list = new ArrayList<SyncEgpSystemItemsBEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncEgpSystemItemsBEO o = new SyncEgpSystemItemsBEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATE_DATE":
                            o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "CREATION_DATE":
                            o.setCreationDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATE_LOGIN":
                            o.setLastUpdateLogin(dataNode.getTextContent());
                            break;
                        case "SUMMARY_FLAG":
                            o.setSummaryFlag(dataNode.getTextContent());
                            break;
                        case "ENABLED_FLAG":
                            o.setEnabledFlag(dataNode.getTextContent());
                            break;
                        case "START_DATE_ACTIVE":
                            o.setStartDateActive(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "END_DATE_ACTIVE":
                            o.setEndDateActive(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "BUYER_ID":
                            o.setBuyerId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ACCOUNTING_RULE_ID":
                            o.setAccountingRuleId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "INVOICING_RULE_ID":
                            o.setInvoicingRuleId(Long.parseLong(dataNode.getTextContent()));
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
                        case "ATTRIBUTE11":
                            o.setAttribute11(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE12":
                            o.setAttribute12(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE13":
                            o.setAttribute13(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE14":
                            o.setAttribute14(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE15":
                            o.setAttribute15(dataNode.getTextContent());
                            break;
                        case "PURCHASING_ITEM_FLAG":
                            o.setPurchasingItemFlag(dataNode.getTextContent());
                            break;
                        case "SHIPPABLE_ITEM_FLAG":
                            o.setShippableItemFlag(dataNode.getTextContent());
                            break;
                        case "CUSTOMER_ORDER_FLAG":
                            o.setCustomerOrderFlag(dataNode.getTextContent());
                            break;
                        case "INTERNAL_ORDER_FLAG":
                            o.setInternalOrderFlag(dataNode.getTextContent());
                            break;
                        case "INVENTORY_ITEM_FLAG":
                            o.setInventoryItemFlag(dataNode.getTextContent());
                            break;
                        case "INVENTORY_ASSET_FLAG":
                            o.setInventoryAssetFlag(dataNode.getTextContent());
                            break;
                        case "PURCHASING_ENABLED_FLAG":
                            o.setPurchasingEnabledFlag(dataNode.getTextContent());
                            break;
                        case "CUSTOMER_ORDER_ENABLED_FLAG":
                            o.setCustomerOrderEnabledFlag(dataNode.getTextContent());
                            break;
                        case "INTERNAL_ORDER_ENABLED_FLAG":
                            o.setInternalOrderEnabledFlag(dataNode.getTextContent());
                            break;
                        case "SO_TRANSACTIONS_FLAG":
                            o.setSoTransactionsFlag(dataNode.getTextContent());
                            break;
                        case "MTL_TRANSACTIONS_ENABLED_FLAG":
                            o.setMtlTransactionsEnabledFlag(dataNode.getTextContent());
                            break;
                        case "STOCK_ENABLED_FLAG":
                            o.setStockEnabledFlag(dataNode.getTextContent());
                            break;
                        case "BUILD_IN_WIP_FLAG":
                            o.setBuildInWipFlag(dataNode.getTextContent());
                            break;
                        case "REVISION_QTY_CONTROL_CODE":
                            try{
                                o.setRevisionQtyControlCode(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ITEM_CATALOG_GROUP_ID":
                            o.setItemCatalogGroupId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "RETURNABLE_FLAG":
                            o.setReturnableFlag(dataNode.getTextContent());
                            break;
                        case "DEFAULT_SHIPPING_ORG":
                            o.setDefaultShippingOrg(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "COLLATERAL_FLAG":
                            o.setCollateralFlag(dataNode.getTextContent());
                            break;
                        case "TAXABLE_FLAG":
                            o.setTaxableFlag(dataNode.getTextContent());
                            break;
                        case "QTY_RCV_EXCEPTION_CODE":
                            o.setQtyRcvExceptionCode(dataNode.getTextContent());
                            break;
                        case "ALLOW_ITEM_DESC_UPDATE_FLAG":
                            o.setAllowItemDescUpdateFlag(dataNode.getTextContent());
                            break;
                        case "MARKET_PRICE":
                            try{
                                o.setMarketPrice(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "HAZARD_CLASS_ID":
                            o.setHazardClassId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "NEGOTIATION_REQUIRED_FLAG":
                            o.setNegotiationRequiredFlag(dataNode.getTextContent());
                            break;
                        case "QTY_RCV_TOLERANCE":
                            try{
                                o.setQtyRcvTolerance(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "LIST_PRICE_PER_UNIT":
                            try{
                                o.setListPricePerUnit(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "UN_NUMBER_ID":
                            o.setUnNumberId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PRICE_TOLERANCE_PERCENT":
                            try{
                                o.setPriceTolerancePercent(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ROUNDING_FACTOR":
                            try{
                                o.setRoundingFactor(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "UNIT_OF_ISSUE":
                            o.setUnitOfIssue(dataNode.getTextContent());
                            break;
                        case "ENFORCE_SHIP_TO_LOCATION_CODE":
                            o.setEnforceShipToLocationCode(dataNode.getTextContent());
                            break;
                        case "ALLOW_SUBSTITUTE_RECEIPTS_FLAG":
                            o.setAllowSubstituteReceiptsFlag(dataNode.getTextContent());
                            break;
                        case "ALLOW_UNORDERED_RECEIPTS_FLAG":
                            o.setAllowUnorderedReceiptsFlag(dataNode.getTextContent());
                            break;
                        case "ALLOW_EXPRESS_DELIVERY_FLAG":
                            o.setAllowExpressDeliveryFlag(dataNode.getTextContent());
                            break;
                        case "DAYS_EARLY_RECEIPT_ALLOWED":
                            try{
                                o.setDaysEarlyReceiptAllowed(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "DAYS_LATE_RECEIPT_ALLOWED":
                            try{
                                o.setDaysLateReceiptAllowed(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "RECEIPT_DAYS_EXCEPTION_CODE":
                            o.setReceiptDaysExceptionCode(dataNode.getTextContent());
                            break;
                        case "RECEIVING_ROUTING_ID":
                            o.setReceivingRoutingId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "INVOICE_CLOSE_TOLERANCE":
                            try{
                                o.setInvoiceCloseTolerance(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "RECEIVE_CLOSE_TOLERANCE":
                            try{
                                o.setReceiveCloseTolerance(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "AUTO_LOT_ALPHA_PREFIX":
                            o.setAutoLotAlphaPrefix(dataNode.getTextContent());
                            break;
                        case "START_AUTO_LOT_NUMBER":
                            o.setStartAutoLotNumber(dataNode.getTextContent());
                            break;
                        case "LOT_CONTROL_CODE":
                            try{
                                o.setLotControlCode(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SHELF_LIFE_CODE":
                            try{
                                o.setShelfLifeCode(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SHELF_LIFE_DAYS":
                            try{
                                o.setShelfLifeDays(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SERIAL_NUMBER_CONTROL_CODE":
                            try{
                                o.setSerialNumberControlCode(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "START_AUTO_SERIAL_NUMBER":
                            o.setStartAutoSerialNumber(dataNode.getTextContent());
                            break;
                        case "AUTO_SERIAL_ALPHA_PREFIX":
                            o.setAutoSerialAlphaPrefix(dataNode.getTextContent());
                            break;
                        case "SOURCE_TYPE":
                            try{
                                o.setSourceType(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SOURCE_ORGANIZATION_ID":
                            o.setSourceOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SOURCE_SUBINVENTORY":
                            o.setSourceSubinventory(dataNode.getTextContent());
                            break;
                        case "RESTRICT_SUBINVENTORIES_CODE":
                            try{
                                o.setRestrictSubinventoriesCode(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "UNIT_WEIGHT":
                            try{
                                o.setUnitWeight(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "WEIGHT_UOM_CODE":
                            o.setWeightUomCode(dataNode.getTextContent());
                            break;
                        case "VOLUME_UOM_CODE":
                            o.setVolumeUomCode(dataNode.getTextContent());
                            break;
                        case "UNIT_VOLUME":
                            try{
                                o.setUnitVolume(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "RESTRICT_LOCATORS_CODE":
                            try{
                                o.setRestrictLocatorsCode(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "LOCATION_CONTROL_CODE":
                            try{
                                o.setLocationControlCode(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SHRINKAGE_RATE":
                            try{
                                o.setShrinkageRate(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ACCEPTABLE_EARLY_DAYS":
                            try{
                                o.setAcceptableEarlyDays(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "PLANNING_TIME_FENCE_CODE":
                            try{
                                o.setPlanningTimeFenceCode(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "DEMAND_TIME_FENCE_CODE":
                            try{
                                o.setDemandTimeFenceCode(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "LEAD_TIME_LOT_SIZE":
                            try{
                                o.setLeadTimeLotSize(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "STD_LOT_SIZE":
                            try{
                                o.setStdLotSize(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CUM_MANUFACTURING_LEAD_TIME":
                            try{
                                o.setCumManufacturingLeadTime(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "OVERRUN_PERCENTAGE":
                            try{
                                o.setOverrunPercentage(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "MRP_CALCULATE_ATP_FLAG":
                            o.setMrpCalculateAtpFlag(dataNode.getTextContent());
                            break;
                        case "ACCEPTABLE_RATE_INCREASE":
                            try{
                                o.setAcceptableRateIncrease(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ACCEPTABLE_RATE_DECREASE":
                            try{
                                o.setAcceptableRateDecrease(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CUMULATIVE_TOTAL_LEAD_TIME":
                            try{
                                o.setCumulativeTotalLeadTime(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "PLANNING_TIME_FENCE_DAYS":
                            try{
                                o.setPlanningTimeFenceDays(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "DEMAND_TIME_FENCE_DAYS":
                            try{
                                o.setDemandTimeFenceDays(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "END_ASSEMBLY_PEGGING_FLAG":
                            o.setEndAssemblyPeggingFlag(dataNode.getTextContent());
                            break;
                        case "REPETITIVE_PLANNING_FLAG":
                            o.setRepetitivePlanningFlag(dataNode.getTextContent());
                            break;
                        case "PLANNING_EXCEPTION_SET":
                            o.setPlanningExceptionSet(dataNode.getTextContent());
                            break;
                        case "BOM_ITEM_TYPE":
                            try{
                                o.setBomItemType(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "PICK_COMPONENTS_FLAG":
                            o.setPickComponentsFlag(dataNode.getTextContent());
                            break;
                        case "REPLENISH_TO_ORDER_FLAG":
                            o.setReplenishToOrderFlag(dataNode.getTextContent());
                            break;
                        case "BASE_ITEM_ID":
                            o.setBaseItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ATP_COMPONENTS_FLAG":
                            o.setAtpComponentsFlag(dataNode.getTextContent());
                            break;
                        case "ATP_FLAG":
                            o.setAtpFlag(dataNode.getTextContent());
                            break;
                        case "FIXED_LEAD_TIME":
                            try{
                                o.setFixedLeadTime(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "VARIABLE_LEAD_TIME":
                            try{
                                o.setVariableLeadTime(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "WIP_SUPPLY_LOCATOR_ID":
                            o.setWipSupplyLocatorId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "WIP_SUPPLY_TYPE":
                            o.setWipSupplyType(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "WIP_SUPPLY_SUBINVENTORY":
                            o.setWipSupplySubinventory(dataNode.getTextContent());
                            break;
                        case "PRIMARY_UOM_CODE":
                            o.setPrimaryUomCode(dataNode.getTextContent());
                            break;
                        case "ALLOWED_UNITS_LOOKUP_CODE":
                            try{
                                o.setAllowedUnitsLookupCode(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "DEFAULT_INCLUDE_IN_ROLLUP_FLAG":
                            o.setDefaultIncludeInRollupFlag(dataNode.getTextContent());
                            break;
                        case "INVENTORY_ITEM_STATUS_CODE":
                            o.setInventoryItemStatusCode(dataNode.getTextContent());
                            break;
                        case "INVENTORY_PLANNING_CODE":
                            try{
                                o.setInventoryPlanningCode(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "PLANNER_CODE":
                            o.setPlannerCode(dataNode.getTextContent());
                            break;
                        case "PLANNING_MAKE_BUY_CODE":
                            try{
                                o.setPlanningMakeBuyCode(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "FIXED_LOT_MULTIPLIER":
                            try{
                                o.setFixedLotMultiplier(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ROUNDING_CONTROL_TYPE":
                            try{
                                o.setRoundingControlType(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CARRYING_COST":
                            try{
                                o.setCarryingCost(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "POSTPROCESSING_LEAD_TIME":
                            try{
                                o.setPostprocessingLeadTime(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "PREPROCESSING_LEAD_TIME":
                            try{
                                o.setPreprocessingLeadTime(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "FULL_LEAD_TIME":
                            try{
                                o.setFullLeadTime(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ORDER_COST":
                            try{
                                o.setOrderCost(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "MRP_SAFETY_STOCK_PERCENT":
                            try{
                                o.setMrpSafetyStockPercent(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "MRP_SAFETY_STOCK_CODE":
                            try{
                                o.setMrpSafetyStockCode(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "MIN_MINMAX_QUANTITY":
                            try{
                                o.setMinMinmaxQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "MAX_MINMAX_QUANTITY":
                            try{
                                o.setMaxMinmaxQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "MINIMUM_ORDER_QUANTITY":
                            try{
                                o.setMinimumOrderQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "FIXED_ORDER_QUANTITY":
                            try{
                                o.setFixedOrderQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "FIXED_DAYS_SUPPLY":
                            try{
                                o.setFixedDaysSupply(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "MAXIMUM_ORDER_QUANTITY":
                            try{
                                o.setMaximumOrderQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ATP_RULE_ID":
                            o.setAtpRuleId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PICKING_RULE_ID":
                            o.setPickingRuleId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "RESERVABLE_TYPE":
                            try{
                                o.setReservableType(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "POSITIVE_MEASUREMENT_ERROR":
                            try{
                                o.setPositiveMeasurementError(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "NEGATIVE_MEASUREMENT_ERROR":
                            try{
                                o.setNegativeMeasurementError(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ENGINEERING_ITEM_ID":
                            o.setEngineeringItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SERVICE_STARTING_DELAY":
                            try{
                                o.setServiceStartingDelay(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SERVICEABLE_PRODUCT_FLAG":
                            o.setServiceableProductFlag(dataNode.getTextContent());
                            break;
                        case "PAYMENT_TERMS_ID":
                            o.setPaymentTermsId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "MATERIAL_BILLABLE_FLAG":
                            o.setMaterialBillableFlag(dataNode.getTextContent());
                            break;
                        case "COVERAGE_SCHEDULE_ID":
                            o.setCoverageScheduleId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SERVICE_DURATION_PERIOD_CODE":
                            o.setServiceDurationPeriodCode(dataNode.getTextContent());
                            break;
                        case "SERVICE_DURATION":
                            try{
                                o.setServiceDuration(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "INVOICEABLE_ITEM_FLAG":
                            o.setInvoiceableItemFlag(dataNode.getTextContent());
                            break;
                        case "TAX_CODE":
                            o.setTaxCode(dataNode.getTextContent());
                            break;
                        case "INVOICE_ENABLED_FLAG":
                            o.setInvoiceEnabledFlag(dataNode.getTextContent());
                            break;
                        case "MUST_USE_APPROVED_VENDOR_FLAG":
                            o.setMustUseApprovedVendorFlag(dataNode.getTextContent());
                            break;
                        case "REQUEST_ID":
                            o.setRequestId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "OUTSIDE_OPERATION_FLAG":
                            o.setOutsideOperationFlag(dataNode.getTextContent());
                            break;
                        case "OUTSIDE_OPERATION_UOM_TYPE":
                            o.setOutsideOperationUomType(dataNode.getTextContent());
                            break;
                        case "SAFETY_STOCK_BUCKET_DAYS":
                            try{
                                o.setSafetyStockBucketDays(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "AUTO_REDUCE_MPS":
                            o.setAutoReduceMps(dataNode.getTextContent());
                            break;
                        case "COSTING_ENABLED_FLAG":
                            o.setCostingEnabledFlag(dataNode.getTextContent());
                            break;
                        case "AUTO_CREATED_CONFIG_FLAG":
                            o.setAutoCreatedConfigFlag(dataNode.getTextContent());
                            break;
                        case "CYCLE_COUNT_ENABLED_FLAG":
                            o.setCycleCountEnabledFlag(dataNode.getTextContent());
                            break;
                        case "ITEM_TYPE":
                            o.setItemType(dataNode.getTextContent());
                            break;
                        case "SHIP_MODEL_COMPLETE_FLAG":
                            o.setShipModelCompleteFlag(dataNode.getTextContent());
                            break;
                        case "MRP_PLANNING_CODE":
                            try{
                                o.setMrpPlanningCode(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "RETURN_INSPECTION_REQUIREMENT":
                            try{
                                o.setReturnInspectionRequirement(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ATO_FORECAST_CONTROL":
                            try{
                                o.setAtoForecastControl(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "RELEASE_TIME_FENCE_CODE":
                            try{
                                o.setReleaseTimeFenceCode(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "RELEASE_TIME_FENCE_DAYS":
                            try{
                                o.setReleaseTimeFenceDays(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CONTAINER_ITEM_FLAG":
                            o.setContainerItemFlag(dataNode.getTextContent());
                            break;
                        case "VEHICLE_ITEM_FLAG":
                            o.setVehicleItemFlag(dataNode.getTextContent());
                            break;
                        case "MAXIMUM_LOAD_WEIGHT":
                            try{
                                o.setMaximumLoadWeight(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "MINIMUM_FILL_PERCENT":
                            try{
                                o.setMinimumFillPercent(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CONTAINER_TYPE_CODE":
                            o.setContainerTypeCode(dataNode.getTextContent());
                            break;
                        case "INTERNAL_VOLUME":
                            try{
                                o.setInternalVolume(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "WH_UPDATE_DATE":
                            o.setWhUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "PRODUCT_FAMILY_ITEM_ID":
                            o.setProductFamilyItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "GLOBAL_ATTRIBUTE_CATEGORY":
                            o.setGlobalAttributeCategory(dataNode.getTextContent());
                            break;
                        case "PURCHASING_TAX_CODE":
                            o.setPurchasingTaxCode(dataNode.getTextContent());
                            break;
                        case "OVERCOMPLETION_TOLERANCE_TYPE":
                            try{
                                o.setOvercompletionToleranceType(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "OVERCOMPLETION_TOLERANCE_VALUE":
                            try{
                                o.setOvercompletionToleranceValue(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "EFFECTIVITY_CONTROL":
                            try{
                                o.setEffectivityControl(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CHECK_SHORTAGES_FLAG":
                            o.setCheckShortagesFlag(dataNode.getTextContent());
                            break;
                        case "OVER_SHIPMENT_TOLERANCE":
                            try{
                                o.setOverShipmentTolerance(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "UNDER_SHIPMENT_TOLERANCE":
                            try{
                                o.setUnderShipmentTolerance(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "OVER_RETURN_TOLERANCE":
                            try{
                                o.setOverReturnTolerance(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "UNDER_RETURN_TOLERANCE":
                            try{
                                o.setUnderReturnTolerance(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "EQUIPMENT_TYPE":
                            try{
                                o.setEquipmentType(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "RECOVERED_PART_DISP_CODE":
                            o.setRecoveredPartDispCode(dataNode.getTextContent());
                            break;
                        case "DEFECT_TRACKING_ON_FLAG":
                            o.setDefectTrackingOnFlag(dataNode.getTextContent());
                            break;
                        case "EVENT_FLAG":
                            o.setEventFlag(dataNode.getTextContent());
                            break;
                        case "ELECTRONIC_FLAG":
                            o.setElectronicFlag(dataNode.getTextContent());
                            break;
                        case "DOWNLOADABLE_FLAG":
                            o.setDownloadableFlag(dataNode.getTextContent());
                            break;
                        case "COMMS_NL_TRACKABLE_FLAG":
                            o.setCommsNlTrackableFlag(dataNode.getTextContent());
                            break;
                        case "ASSET_CREATION_CODE":
                            o.setAssetCreationCode(dataNode.getTextContent());
                            break;
                        case "COMMS_ACTIVATION_REQD_FLAG":
                            o.setCommsActivationReqdFlag(dataNode.getTextContent());
                            break;
                        case "ORDERABLE_ON_WEB_FLAG":
                            o.setOrderableOnWebFlag(dataNode.getTextContent());
                            break;
                        case "BACK_ORDERABLE_FLAG":
                            o.setBackOrderableFlag(dataNode.getTextContent());
                            break;
                        case "WEB_STATUS":
                            o.setWebStatus(dataNode.getTextContent());
                            break;
                        case "INDIVISIBLE_FLAG":
                            o.setIndivisibleFlag(dataNode.getTextContent());
                            break;
                        case "DIMENSION_UOM_CODE":
                            o.setDimensionUomCode(dataNode.getTextContent());
                            break;
                        case "UNIT_LENGTH":
                            try{
                                o.setUnitLength(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "UNIT_WIDTH":
                            try{
                                o.setUnitWidth(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "UNIT_HEIGHT":
                            try{
                                o.setUnitHeight(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "BULK_PICKED_FLAG":
                            o.setBulkPickedFlag(dataNode.getTextContent());
                            break;
                        case "LOT_STATUS_ENABLED":
                            o.setLotStatusEnabled(dataNode.getTextContent());
                            break;
                        case "DEFAULT_LOT_STATUS_ID":
                            o.setDefaultLotStatusId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SERIAL_STATUS_ENABLED":
                            o.setSerialStatusEnabled(dataNode.getTextContent());
                            break;
                        case "DEFAULT_SERIAL_STATUS_ID":
                            o.setDefaultSerialStatusId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "LOT_SPLIT_ENABLED":
                            o.setLotSplitEnabled(dataNode.getTextContent());
                            break;
                        case "LOT_MERGE_ENABLED":
                            o.setLotMergeEnabled(dataNode.getTextContent());
                            break;
                        case "INVENTORY_CARRY_PENALTY":
                            try{
                                o.setInventoryCarryPenalty(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "OPERATION_SLACK_PENALTY":
                            try{
                                o.setOperationSlackPenalty(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "FINANCING_ALLOWED_FLAG":
                            o.setFinancingAllowedFlag(dataNode.getTextContent());
                            break;
                        case "EAM_ITEM_TYPE":
                            try{
                                o.setEamItemType(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "EAM_ACTIVITY_TYPE_CODE":
                            o.setEamActivityTypeCode(dataNode.getTextContent());
                            break;
                        case "EAM_ACTIVITY_CAUSE_CODE":
                            o.setEamActivityCauseCode(dataNode.getTextContent());
                            break;
                        case "EAM_ACT_NOTIFICATION_FLAG":
                            o.setEamActNotificationFlag(dataNode.getTextContent());
                            break;
                        case "EAM_ACT_SHUTDOWN_STATUS":
                            o.setEamActShutdownStatus(dataNode.getTextContent());
                            break;
                        case "DUAL_UOM_CONTROL":
                            try{
                                o.setDualUomControl(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SECONDARY_UOM_CODE":
                            o.setSecondaryUomCode(dataNode.getTextContent());
                            break;
                        case "DUAL_UOM_DEVIATION_HIGH":
                            try{
                                o.setDualUomDeviationHigh(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "DUAL_UOM_DEVIATION_LOW":
                            try{
                                o.setDualUomDeviationLow(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CONTRACT_ITEM_TYPE_CODE":
                            o.setContractItemTypeCode(dataNode.getTextContent());
                            break;
                        case "SERV_REQ_ENABLED_CODE":
                            o.setServReqEnabledCode(dataNode.getTextContent());
                            break;
                        case "SERV_BILLING_ENABLED_FLAG":
                            o.setServBillingEnabledFlag(dataNode.getTextContent());
                            break;
                        case "PLANNED_INV_POINT_FLAG":
                            o.setPlannedInvPointFlag(dataNode.getTextContent());
                            break;
                        case "LOT_TRANSLATE_ENABLED":
                            o.setLotTranslateEnabled(dataNode.getTextContent());
                            break;
                        case "DEFAULT_SO_SOURCE_TYPE":
                            o.setDefaultSoSourceType(dataNode.getTextContent());
                            break;
                        case "CREATE_SUPPLY_FLAG":
                            o.setCreateSupplyFlag(dataNode.getTextContent());
                            break;
                        case "SUBSTITUTION_WINDOW_CODE":
                            try{
                                o.setSubstitutionWindowCode(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SUBSTITUTION_WINDOW_DAYS":
                            try{
                                o.setSubstitutionWindowDays(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "IB_ITEM_INSTANCE_CLASS":
                            o.setIbItemInstanceClass(dataNode.getTextContent());
                            break;
                        case "CONFIG_MODEL_TYPE":
                            o.setConfigModelType(dataNode.getTextContent());
                            break;
                        case "LOT_SUBSTITUTION_ENABLED":
                            o.setLotSubstitutionEnabled(dataNode.getTextContent());
                            break;
                        case "MINIMUM_LICENSE_QUANTITY":
                            try{
                                o.setMinimumLicenseQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "EAM_ACTIVITY_SOURCE_CODE":
                            o.setEamActivitySourceCode(dataNode.getTextContent());
                            break;
                        case "CURRENT_PHASE_ID":
                            o.setCurrentPhaseId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "OBJECT_VERSION_NUMBER":
                            o.setObjectVersionNumber(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "TRACKING_QUANTITY_IND":
                            o.setTrackingQuantityInd(dataNode.getTextContent());
                            break;
                        case "ONT_PRICING_QTY_SOURCE":
                            o.setOntPricingQtySource(dataNode.getTextContent());
                            break;
                        case "SECONDARY_DEFAULT_IND":
                            o.setSecondaryDefaultInd(dataNode.getTextContent());
                            break;
                        case "OPTION_SPECIFIC_SOURCED":
                            try{
                                o.setOptionSpecificSourced(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "APPROVAL_STATUS":
                            o.setApprovalStatus(dataNode.getTextContent());
                            break;
                        case "VMI_MINIMUM_UNITS":
                            try{
                                o.setVmiMinimumUnits(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "VMI_MINIMUM_DAYS":
                            try{
                                o.setVmiMinimumDays(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "VMI_MAXIMUM_UNITS":
                            try{
                                o.setVmiMaximumUnits(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "VMI_MAXIMUM_DAYS":
                            try{
                                o.setVmiMaximumDays(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "VMI_FIXED_ORDER_QUANTITY":
                            try{
                                o.setVmiFixedOrderQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SO_AUTHORIZATION_FLAG":
                            try{
                                o.setSoAuthorizationFlag(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CONSIGNED_FLAG":
                            try{
                                o.setConsignedFlag(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ASN_AUTOEXPIRE_FLAG":
                            try{
                                o.setAsnAutoexpireFlag(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "VMI_FORECAST_TYPE":
                            try{
                                o.setVmiForecastType(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "FORECAST_HORIZON":
                            try{
                                o.setForecastHorizon(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "EXCLUDE_FROM_BUDGET_FLAG":
                            try{
                                o.setExcludeFromBudgetFlag(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "DAYS_TGT_INV_SUPPLY":
                            try{
                                o.setDaysTgtInvSupply(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "DAYS_TGT_INV_WINDOW":
                            try{
                                o.setDaysTgtInvWindow(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "DAYS_MAX_INV_SUPPLY":
                            try{
                                o.setDaysMaxInvSupply(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "DAYS_MAX_INV_WINDOW":
                            try{
                                o.setDaysMaxInvWindow(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "DRP_PLANNED_FLAG":
                            try{
                                o.setDrpPlannedFlag(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CRITICAL_COMPONENT_FLAG":
                            try{
                                o.setCriticalComponentFlag(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CONTINOUS_TRANSFER":
                            try{
                                o.setContinousTransfer(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CONVERGENCE":
                            try{
                                o.setConvergence(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "DIVERGENCE":
                            try{
                                o.setDivergence(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CONFIG_ORGS":
                            o.setConfigOrgs(dataNode.getTextContent());
                            break;
                        case "CONFIG_MATCH":
                            o.setConfigMatch(dataNode.getTextContent());
                            break;
                        case "CAS_NUMBER":
                            o.setCasNumber(dataNode.getTextContent());
                            break;
                        case "CHILD_LOT_FLAG":
                            o.setChildLotFlag(dataNode.getTextContent());
                            break;
                        case "CHILD_LOT_PREFIX":
                            o.setChildLotPrefix(dataNode.getTextContent());
                            break;
                        case "CHILD_LOT_STARTING_NUMBER":
                            try{
                                o.setChildLotStartingNumber(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CHILD_LOT_VALIDATION_FLAG":
                            o.setChildLotValidationFlag(dataNode.getTextContent());
                            break;
                        case "COPY_LOT_ATTRIBUTE_FLAG":
                            o.setCopyLotAttributeFlag(dataNode.getTextContent());
                            break;
                        case "DEFAULT_GRADE":
                            o.setDefaultGrade(dataNode.getTextContent());
                            break;
                        case "EXPIRATION_ACTION_CODE":
                            o.setExpirationActionCode(dataNode.getTextContent());
                            break;
                        case "EXPIRATION_ACTION_INTERVAL":
                            try{
                                o.setExpirationActionInterval(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "GRADE_CONTROL_FLAG":
                            o.setGradeControlFlag(dataNode.getTextContent());
                            break;
                        case "HAZARDOUS_MATERIAL_FLAG":
                            o.setHazardousMaterialFlag(dataNode.getTextContent());
                            break;
                        case "HOLD_DAYS":
                            try{
                                o.setHoldDays(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "LOT_DIVISIBLE_FLAG":
                            o.setLotDivisibleFlag(dataNode.getTextContent());
                            break;
                        case "MATURITY_DAYS":
                            try{
                                o.setMaturityDays(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "PARENT_CHILD_GENERATION_FLAG":
                            o.setParentChildGenerationFlag(dataNode.getTextContent());
                            break;
                        case "PROCESS_COSTING_ENABLED_FLAG":
                            o.setProcessCostingEnabledFlag(dataNode.getTextContent());
                            break;
                        case "PROCESS_EXECUTION_ENABLED_FLAG":
                            o.setProcessExecutionEnabledFlag(dataNode.getTextContent());
                            break;
                        case "PROCESS_QUALITY_ENABLED_FLAG":
                            o.setProcessQualityEnabledFlag(dataNode.getTextContent());
                            break;
                        case "PROCESS_SUPPLY_LOCATOR_ID":
                            o.setProcessSupplyLocatorId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PROCESS_SUPPLY_SUBINVENTORY":
                            o.setProcessSupplySubinventory(dataNode.getTextContent());
                            break;
                        case "PROCESS_YIELD_LOCATOR_ID":
                            o.setProcessYieldLocatorId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PROCESS_YIELD_SUBINVENTORY":
                            o.setProcessYieldSubinventory(dataNode.getTextContent());
                            break;
                        case "RECIPE_ENABLED_FLAG":
                            o.setRecipeEnabledFlag(dataNode.getTextContent());
                            break;
                        case "RETEST_INTERVAL":
                            try{
                                o.setRetestInterval(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CHARGE_PERIODICITY_CODE":
                            o.setChargePeriodicityCode(dataNode.getTextContent());
                            break;
                        case "REPAIR_LEADTIME":
                            try{
                                o.setRepairLeadtime(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "REPAIR_YIELD":
                            try{
                                o.setRepairYield(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "PREPOSITION_POINT":
                            o.setPrepositionPoint(dataNode.getTextContent());
                            break;
                        case "REPAIR_PROGRAM":
                            try{
                                o.setRepairProgram(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SUBCONTRACTING_COMPONENT":
                            try{
                                o.setSubcontractingComponent(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "OUTSOURCED_ASSEMBLY":
                            try{
                                o.setOutsourcedAssembly(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "EGO_MASTER_ITEMS_DFF_CTX":
                            o.setEgoMasterItemsDffCtx(dataNode.getTextContent());
                            break;
                        case "GDSN_OUTBOUND_ENABLED_FLAG":
                            o.setGdsnOutboundEnabledFlag(dataNode.getTextContent());
                            break;
                        case "TRADE_ITEM_DESCRIPTOR":
                            o.setTradeItemDescriptor(dataNode.getTextContent());
                            break;
                        case "ASSET_TRACKED_FLAG":
                            o.setAssetTrackedFlag(dataNode.getTextContent());
                            break;
                        case "ASSET_CLASS":
                            o.setAssetClass(dataNode.getTextContent());
                            break;
                        case "SERVICE_DURATION_TYPE_CODE":
                            o.setServiceDurationTypeCode(dataNode.getTextContent());
                            break;
                        case "SERVICE_START_TYPE_CODE":
                            o.setServiceStartTypeCode(dataNode.getTextContent());
                            break;
                        case "START_UPON_MILESTONE_CODE":
                            o.setStartUponMilestoneCode(dataNode.getTextContent());
                            break;
                        case "SERVICE_START_DELAY":
                            try{
                                o.setServiceStartDelay(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ALLOW_SUSPEND_FLAG":
                            o.setAllowSuspendFlag(dataNode.getTextContent());
                            break;
                        case "ALLOW_TERMINATE_FLAG":
                            o.setAllowTerminateFlag(dataNode.getTextContent());
                            break;
                        case "REQUIRES_FULFILLMENT_LOC_FLAG":
                            o.setRequiresFulfillmentLocFlag(dataNode.getTextContent());
                            break;
                        case "REQUIRES_ITM_ASSOCIATION_FLAG":
                            o.setRequiresItmAssociationFlag(dataNode.getTextContent());
                            break;
                        case "STYLE_ITEM_ID":
                            o.setStyleItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "STYLE_ITEM_FLAG":
                            o.setStyleItemFlag(dataNode.getTextContent());
                            break;
                        case "LAST_SUBMITTED_NIR_ID":
                            o.setLastSubmittedNirId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PROGRAM_NAME":
                            o.setProgramName(dataNode.getTextContent());
                            break;
                        case "PROGRAM_APP_NAME":
                            o.setProgramAppName(dataNode.getTextContent());
                            break;
                        case "ELIGIBILITY_COMPATIBILITY_RULE":
                            o.setEligibilityCompatibilityRule(dataNode.getTextContent());
                            break;
                        case "JOB_DEFINITION_NAME":
                            o.setJobDefinitionName(dataNode.getTextContent());
                            break;
                        case "JOB_DEFINITION_PACKAGE":
                            o.setJobDefinitionPackage(dataNode.getTextContent());
                            break;
                        case "ACD_TYPE":
                            o.setAcdType(dataNode.getTextContent());
                            break;
                        case "CHANGE_LINE_ID":
                            o.setChangeLineId(dataNode.getTextContent());
                            break;
                        case "VERSION_ID":
                            o.setVersionId(dataNode.getTextContent());
                            break;
                        case "MASTER_ITEM_VERSION_ID":
                            o.setMasterItemVersionId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "VERSION_START_DATE":
                            o.setVersionStartDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "VERSION_END_DATE":
                            o.setVersionEndDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "IMPLEMENTATION_DATE":
                            o.setImplementationDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "TEMPLATE_ITEM_FLAG":
                            o.setTemplateItemFlag(dataNode.getTextContent());
                            break;
                        case "QSC_SALES_PRODUCT_TYPE":
                            o.setQscSalesProductType(dataNode.getTextContent());
                            break;
                        case "MATCH_APPROVAL_LEVEL":
                            o.setMatchApprovalLevel(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "INVOICE_MATCH_OPTION":
                            o.setInvoiceMatchOption(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "DEFAULT_TEMPLATE_FLAG":
                            o.setDefaultTemplateFlag(dataNode.getTextContent());
                            break;
                        case "INSPECTION_REQUIRED_FLAG":
                            o.setInspectionRequiredFlag(dataNode.getTextContent());
                            break;
                        case "RECEIPT_REQUIRED_FLAG":
                            o.setReceiptRequiredFlag(dataNode.getTextContent());
                            break;
                        case "ASSET_CATEGORY_ID":
                            o.setAssetCategoryId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "EXPENSE_ACCOUNT":
                            o.setExpenseAccount(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SALES_ACCOUNT":
                            o.setSalesAccount(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SALES_PRODUCT_TYPE":
                            o.setSalesProductType(dataNode.getTextContent());
                            break;
                        case "SALES_PRODUCT_SUB_TYPE":
                            o.setSalesProductSubType(dataNode.getTextContent());
                            break;
                        case "ALT_ITEM_CODE":
                            o.setAltItemCode(dataNode.getTextContent());
                            break;
                        case "CHANGE_BIT_MAP":
                            o.setChangeBitMap(dataNode.getTextContent());
                            break;
                        case "CURRENT_PHASE_CODE":
                            o.setCurrentPhaseCode(dataNode.getTextContent());
                            break;
                        case "INVENTORY_ORGANIZATION_ID":
                            o.setInventoryOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ITEM_NUMBER":
                            o.setItemNumber(dataNode.getTextContent());
                            break;
                        case "CREATED_BY":
                            o.setCreatedBy(dataNode.getTextContent());
                            break;
                        case "LAST_UPDATED_BY":
                            o.setLastUpdatedBy(dataNode.getTextContent());
                            break;
                        case "DQ_SEMANTIC_KEY":
                            o.setDqSemanticKey(dataNode.getTextContent());
                            break;
                        case "DQ_REQUIRED_FLAG":
                            o.setDqRequiredFlag(dataNode.getTextContent());
                            break;
                        case "THREAD_ID":
                            o.setThreadId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ATTRIBUTE_NUMBER1":
                            try{
                                o.setAttributeNumber1(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ATTRIBUTE_NUMBER2":
                            try{
                                o.setAttributeNumber2(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ATTRIBUTE_NUMBER3":
                            try{
                                o.setAttributeNumber3(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ATTRIBUTE_NUMBER4":
                            try{
                                o.setAttributeNumber4(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ATTRIBUTE_NUMBER5":
                            try{
                                o.setAttributeNumber5(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ATTRIBUTE_NUMBER6":
                            try{
                                o.setAttributeNumber6(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ATTRIBUTE_NUMBER7":
                            try{
                                o.setAttributeNumber7(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ATTRIBUTE_NUMBER8":
                            try{
                                o.setAttributeNumber8(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ATTRIBUTE_NUMBER9":
                            try{
                                o.setAttributeNumber9(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ATTRIBUTE_NUMBER10":
                            try{
                                o.setAttributeNumber10(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ATTRIBUTE_DATE1":
                            o.setAttributeDate1(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "ATTRIBUTE_DATE2":
                            o.setAttributeDate2(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "ATTRIBUTE_DATE3":
                            o.setAttributeDate3(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "ATTRIBUTE_DATE4":
                            o.setAttributeDate4(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "ATTRIBUTE_DATE5":
                            o.setAttributeDate5(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "ATTRIBUTE_TIMESTAMP1":
                            o.setAttributeTimestamp1(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "ATTRIBUTE_TIMESTAMP2":
                            o.setAttributeTimestamp2(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "ATTRIBUTE_TIMESTAMP3":
                            o.setAttributeTimestamp3(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "ATTRIBUTE_TIMESTAMP4":
                            o.setAttributeTimestamp4(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "ATTRIBUTE_TIMESTAMP5":
                            o.setAttributeTimestamp5(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "BACK_TO_BACK_ENABLED":
                            o.setBackToBackEnabled(dataNode.getTextContent());
                            break;
                        case "CONTRACT_MANUFACTURING":
                            o.setContractManufacturing(dataNode.getTextContent());
                            break;
                        case "SAFETY_STOCK_PLANNING_METHOD":
                            o.setSafetyStockPlanningMethod(dataNode.getTextContent());
                            break;
                        case "DEMAND_PERIOD":
                            try{
                                o.setDemandPeriod(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "DAYS_OF_COVER":
                            try{
                                o.setDaysOfCover(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "MASTER_ORG_ID":
                            o.setMasterOrgId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "OUTSIDE_PROCESS_SERVICE_FLAG":
                            o.setOutsideProcessServiceFlag(dataNode.getTextContent());
                            break;
                        case "ALLOW_MAINTENANCE_ASSET_FLAG":
                            o.setAllowMaintenanceAssetFlag(dataNode.getTextContent());
                            break;
                        case "ENABLE_GENEALOGY_TRACKING_FLAG":
                            o.setEnableGenealogyTrackingFlag(dataNode.getTextContent());
                            break;
                        case "COMPLETENESS_SCORE":
                            o.setCompletenessScore(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "CSS_ENABLED_FLAG":
                            o.setCssEnabledFlag(dataNode.getTextContent());
                            break;
                        case "ENGINEERED_ITEM_FLAG":
                            o.setEngineeredItemFlag(dataNode.getTextContent());
                            break;
                        case "FORCE_PURCHASE_LEAD_TIME_FLAG":
                            o.setForcePurchaseLeadTimeFlag(dataNode.getTextContent());
                            break;
                        case "REPLACEMENT_TYPE":
                            o.setReplacementType(dataNode.getTextContent());
                            break;
                        case "HARD_PEGGING_LEVEL":
                            o.setHardPeggingLevel(dataNode.getTextContent());
                            break;
                        case "COMN_SUPPLY_PRJ_DEMAND_FLAG":
                            o.setComnSupplyPrjDemandFlag(dataNode.getTextContent());
                            break;
                        case "ENABLE_IOT_FLAG":
                            o.setEnableIotFlag(dataNode.getTextContent());
                            break;
                        case "EXPENDITURE_TYPE_ID":
                            o.setExpenditureTypeId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "DESCRIPTION":
                            o.setDescription(dataNode.getTextContent());
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                int batchCount =5;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncEgpSystemItemsBMapper.deletebatchSyncEgpSystemItemsB(list.subList(index, (batchLastIndex + 1)));
                        syncEgpSystemItemsBMapper.batchSyncEgpSystemItemsB(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncEgpSystemItemsBMapper.deletebatchSyncEgpSystemItemsB(list.subList(index, (batchLastIndex + 1)));
                        syncEgpSystemItemsBMapper.batchSyncEgpSystemItemsB(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
        if (true) {//EGP_SYSTEM_ITEMS_B_W
            NodeList nodeList = root.getElementsByTagName("EGP_SYSTEM_ITEMS_B_W");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据

            List<SyncEgpSystemItemsWEO> list = new ArrayList<SyncEgpSystemItemsWEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息

                SyncEgpSystemItemsWEO o = new SyncEgpSystemItemsWEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATE_DATE":
                            o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATED_BY":
                            o.setLastUpdatedBy(dataNode.getTextContent());
                            break;
                        case "DESCRIPTION":
                            o.setDescription(dataNode.getTextContent());
                            break;
                        case "ITEM_NUMBER":
                            o.setItemNumber(dataNode.getTextContent());
                            break;
                        case "BUYER_NAME":
                            o.setBuyerName(dataNode.getTextContent());
                            break;
                        case "MINIMUM_ORDER_QUANTITY":
                            try{
                                o.setMinimumOrderQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                int batchCount =261;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncEgpSystemItemsBWMapper.deletebatchSyncEgpSystemItemsWEO(list.subList(index, (batchLastIndex + 1)));
                        syncEgpSystemItemsBWMapper.batchSyncEgpSystemItemsWEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncEgpSystemItemsBWMapper.deletebatchSyncEgpSystemItemsWEO(list.subList(index, (batchLastIndex + 1)));
                        syncEgpSystemItemsBWMapper.batchSyncEgpSystemItemsWEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
    }
}
