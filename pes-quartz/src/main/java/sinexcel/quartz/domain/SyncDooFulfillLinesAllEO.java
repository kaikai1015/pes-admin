package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SyncDooFulfillLinesAllEO {
    private Long fulfillLineId;
    private Date serviceCancelDate;
    private Long agreementHeaderId;
    private Long agreementLineId;
    private Long agreementVersionNumber;
    private Long receivablesOrgId;
    private Integer objectVersionNumber;
    private Long headerId;
    private Long lineId;
    private Integer fulfillLineNumber;
    private Long inventoryItemId;
    private String itemTypeCode;
    private BigDecimal orderedQty;
    private String statusCode;
    private String sourceLineId;
    private String sourceLineNumber;
    private String sourceOrderId;
    private String sourceOrderNumber;
    private String sourceOrderSystem;
    private String sourceScheduleId;
    private String sourceScheduleNumber;
    private Long sourceRevisionNumber;
    private String compSeqPath;
    private Long ownerId;
    private Date creationDate;
    private String createdBy;
    private Date lastUpdateDate;
    private String lastUpdatedBy;
    private String lastUpdateLogin;
    private Long fulfillOrgId;
    private BigDecimal canceledQty;
    private String orderedUom;
    private String purchasingUom;
    private String shippedUom;
    private BigDecimal rmaDeliveredQty;
    private BigDecimal fulfilledQty;
    private BigDecimal shippedQty;
    private BigDecimal reservedQty;
    private String reservableFlag;
    private String shippableFlag;
    private String invoiceableItemFlag;
    private String invoiceEnabledFlag;
    private String returnableFlag;
    private String invoiceInterfacedFlag;
    private Long billToContactId;
    private Long billToCustomerId;
    private Long billToSiteUseId;
    private Long sourceOrgId;
    private Long orgId;
    private Date requestArrivalDate;
    private Date requestShipDate;
    private Date scheduleArrivalDate;
    private Date scheduleShipDate;
    private Date promiseArrivalDate;
    private Date promiseShipDate;
    private Date actualShipDate;
    private Date fulfillmentDate;
    private Long customerItemId;
    private String customerPoLineNumber;
    private String customerPoNumber;
    private String demandClassCode;
    private BigDecimal extendedAmount;
    private String fobPointCode;
    private Long carrierId;
    private Long invoicingRuleId;
    private String exemptionCertificateNumber;
    private Long accountingRuleId;
    private String lineTypeCode;
    private String categoryCode;
    private String openFlag;
    private String canceledFlag;
    private String overrideScheduleDateFlag;
    private Long originalInventoryItemId;
    private String gopReferenceId;
    private String packingInstructions;
    private Long parentFulfillLineId;
    private Long paymentTermId;
    private String requestType;
    private String returnReasonCode;
    private String origSysDocumentRef;
    private String origSysDocumentLineRef;
    private Long rootParentFulfillLineId;
    private String shipClassOfService;
    private String shipModeOfTransport;
    private Long shipToContactId;
    private Long shipToCustomerId;
    private Long shipToSiteUseId;
    private BigDecimal fulfillToleranceAbove;
    private BigDecimal fulfillToleranceBelow;
    private String shipmentPriorityCode;
    private String shippingInstructions;
    private String shipSetName;
    private Long splitFromFlineId;
    private String partialShipAllowedFlag;
    private String substituteAllowedFlag;
    private String substituteReasonCode;
    private String taxExemptFlag;
    private String taxClassificationCode;
    private Long deltaType;
    private String taxExemptionReasonCode;
    private BigDecimal unitListPrice;
    private BigDecimal unitSellingPrice;
    private Long referenceFlineId;
    private Date latestAcceptableShipDate;
    private Date latestAcceptableArrivalDate;
    private Date earliestAcceptableShipDate;
    private String onHold;
    private Long reservationId;
    private Date actualCompletionDate;
    private Long inventoryOrganizationId;
    private Long fulfillInstanceId;
    private Long statusRulesetId;
    private String remnantFlag;
    private Long fulfillmentSplitRefId;
    private BigDecimal estimateMargin;
    private BigDecimal estimateFulfillmentCost;
    private String freightTermsCode;
    private String cancelReasonCode;
    private Long latestExtFulfillLineNumber;
    private String gopRequestRegion;
    private String schedulingReasonCode;
    private String subinventory;
    private Long supplierId;
    private Long supplierSiteId;
    private Long shipToPartyId;
    private Long shipToPartySiteId;
    private Long shipToPartyContactId;
    private String configItemReference;
    private String itemSubTypeCode;
    private Long requisitionInventoryOrgId;
    private Long requisitionBuId;
    private String fulfillmentMode;
    private String poStatusCode;
    private Long buyerId;
    private Date requestCancelDate;
    private String comments;
    private String defaultTaxationCountry;
    private Long firstPtyRegId;
    private Long thirdPtyRegId;
    private String documentSubType;
    private String taxInvoiceNumber;
    private Date taxInvoiceDate;
    private Long finalDischargeLocationId;
    private Long prodFcCategId;
    private String productType;
    private String productCategory;
    private String trxBusinessCategory;
    private String userDefinedFiscClass;
    private Long intendedUseClassifId;
    private Long destinationLocationId;
    private Long destinationOrgId;
    private BigDecimal quantityPerModel;
    private Long configInventoryItemId;
    private String purchasingEnabledFlag;
    private String customerPoScheduleNumber;
    private String supplyStatusCode;
    private Long shipToContactPointId;
    private Long prefOverriddenBitset;
    private Long appliedPriceListId;
    private Date pricedOn;
    private Date requiredFulfillmentDate;
    private String componentIdPath;
    private String validConfigurationFlag;
    private String configuratorPath;
    private Long configHeaderId;
    private Long configRevisionNumber;
    private Integer showInSales;
    private String changeEligibleFlag;
    private String modifiedFlag;
    private String unreferencedReturnFlag;
    private Long billToContactPointId;
    private BigDecimal unitQuantity;
    private Date configCreationDate;
    private Date contractStartDate;
    private Date contractEndDate;
    private BigDecimal totalContractQuantity;
    private BigDecimal totalContractAmount;
    private Long processInstanceId;
    private String processNumber;
    private String creditChkAuthNum;
    private Date creditChkAuthExpDate;
    private String tradeComplianceResultCode;
    private Date tradeComplianceDate;
    private String transportationPlannedFlag;
    private String createdInRelease;
    private String configTradeComplResultCode;
    private Long billingTrxTypeId;
    private BigDecimal serviceDuration;
    private String serviceDurationPeriodCode;
    private String salesProductTypeCode;
    private String actionTypeCode;
    private String assetTrackedFlag;
    private String assetGroupNumber;
    private String processSet;
    private Long salespersonId;
    private Long batchId;
    private Long processId;
    private String prjRecIndicator;

    public Long getFulfillLineId() {
        return fulfillLineId;
    }

    public void setFulfillLineId(Long fulfillLineId) {
        this.fulfillLineId = fulfillLineId;
    }

    public Date getServiceCancelDate() {
        return serviceCancelDate;
    }

    public void setServiceCancelDate(Date serviceCancelDate) {
        this.serviceCancelDate = serviceCancelDate;
    }

    public Long getAgreementHeaderId() {
        return agreementHeaderId;
    }

    public void setAgreementHeaderId(Long agreementHeaderId) {
        this.agreementHeaderId = agreementHeaderId;
    }

    public Long getAgreementLineId() {
        return agreementLineId;
    }

    public void setAgreementLineId(Long agreementLineId) {
        this.agreementLineId = agreementLineId;
    }

    public Long getAgreementVersionNumber() {
        return agreementVersionNumber;
    }

    public void setAgreementVersionNumber(Long agreementVersionNumber) {
        this.agreementVersionNumber = agreementVersionNumber;
    }

    public Long getReceivablesOrgId() {
        return receivablesOrgId;
    }

    public void setReceivablesOrgId(Long receivablesOrgId) {
        this.receivablesOrgId = receivablesOrgId;
    }

    public Integer getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(Integer objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }

    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    public Integer getFulfillLineNumber() {
        return fulfillLineNumber;
    }

    public void setFulfillLineNumber(Integer fulfillLineNumber) {
        this.fulfillLineNumber = fulfillLineNumber;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public String getItemTypeCode() {
        return itemTypeCode;
    }

    public void setItemTypeCode(String itemTypeCode) {
        this.itemTypeCode = itemTypeCode;
    }

    public BigDecimal getOrderedQty() {
        return orderedQty;
    }

    public void setOrderedQty(BigDecimal orderedQty) {
        this.orderedQty = orderedQty;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getSourceLineId() {
        return sourceLineId;
    }

    public void setSourceLineId(String sourceLineId) {
        this.sourceLineId = sourceLineId;
    }

    public String getSourceLineNumber() {
        return sourceLineNumber;
    }

    public void setSourceLineNumber(String sourceLineNumber) {
        this.sourceLineNumber = sourceLineNumber;
    }

    public String getSourceOrderId() {
        return sourceOrderId;
    }

    public void setSourceOrderId(String sourceOrderId) {
        this.sourceOrderId = sourceOrderId;
    }

    public String getSourceOrderNumber() {
        return sourceOrderNumber;
    }

    public void setSourceOrderNumber(String sourceOrderNumber) {
        this.sourceOrderNumber = sourceOrderNumber;
    }

    public String getSourceOrderSystem() {
        return sourceOrderSystem;
    }

    public void setSourceOrderSystem(String sourceOrderSystem) {
        this.sourceOrderSystem = sourceOrderSystem;
    }

    public String getSourceScheduleId() {
        return sourceScheduleId;
    }

    public void setSourceScheduleId(String sourceScheduleId) {
        this.sourceScheduleId = sourceScheduleId;
    }

    public String getSourceScheduleNumber() {
        return sourceScheduleNumber;
    }

    public void setSourceScheduleNumber(String sourceScheduleNumber) {
        this.sourceScheduleNumber = sourceScheduleNumber;
    }

    public Long getSourceRevisionNumber() {
        return sourceRevisionNumber;
    }

    public void setSourceRevisionNumber(Long sourceRevisionNumber) {
        this.sourceRevisionNumber = sourceRevisionNumber;
    }

    public String getCompSeqPath() {
        return compSeqPath;
    }

    public void setCompSeqPath(String compSeqPath) {
        this.compSeqPath = compSeqPath;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdateLogin() {
        return lastUpdateLogin;
    }

    public void setLastUpdateLogin(String lastUpdateLogin) {
        this.lastUpdateLogin = lastUpdateLogin;
    }

    public Long getFulfillOrgId() {
        return fulfillOrgId;
    }

    public void setFulfillOrgId(Long fulfillOrgId) {
        this.fulfillOrgId = fulfillOrgId;
    }

    public BigDecimal getCanceledQty() {
        return canceledQty;
    }

    public void setCanceledQty(BigDecimal canceledQty) {
        this.canceledQty = canceledQty;
    }

    public String getOrderedUom() {
        return orderedUom;
    }

    public void setOrderedUom(String orderedUom) {
        this.orderedUom = orderedUom;
    }

    public String getPurchasingUom() {
        return purchasingUom;
    }

    public void setPurchasingUom(String purchasingUom) {
        this.purchasingUom = purchasingUom;
    }

    public String getShippedUom() {
        return shippedUom;
    }

    public void setShippedUom(String shippedUom) {
        this.shippedUom = shippedUom;
    }

    public BigDecimal getRmaDeliveredQty() {
        return rmaDeliveredQty;
    }

    public void setRmaDeliveredQty(BigDecimal rmaDeliveredQty) {
        this.rmaDeliveredQty = rmaDeliveredQty;
    }

    public BigDecimal getFulfilledQty() {
        return fulfilledQty;
    }

    public void setFulfilledQty(BigDecimal fulfilledQty) {
        this.fulfilledQty = fulfilledQty;
    }

    public BigDecimal getShippedQty() {
        return shippedQty;
    }

    public void setShippedQty(BigDecimal shippedQty) {
        this.shippedQty = shippedQty;
    }

    public BigDecimal getReservedQty() {
        return reservedQty;
    }

    public void setReservedQty(BigDecimal reservedQty) {
        this.reservedQty = reservedQty;
    }

    public String getReservableFlag() {
        return reservableFlag;
    }

    public void setReservableFlag(String reservableFlag) {
        this.reservableFlag = reservableFlag;
    }

    public String getShippableFlag() {
        return shippableFlag;
    }

    public void setShippableFlag(String shippableFlag) {
        this.shippableFlag = shippableFlag;
    }

    public String getInvoiceableItemFlag() {
        return invoiceableItemFlag;
    }

    public void setInvoiceableItemFlag(String invoiceableItemFlag) {
        this.invoiceableItemFlag = invoiceableItemFlag;
    }

    public String getInvoiceEnabledFlag() {
        return invoiceEnabledFlag;
    }

    public void setInvoiceEnabledFlag(String invoiceEnabledFlag) {
        this.invoiceEnabledFlag = invoiceEnabledFlag;
    }

    public String getReturnableFlag() {
        return returnableFlag;
    }

    public void setReturnableFlag(String returnableFlag) {
        this.returnableFlag = returnableFlag;
    }

    public String getInvoiceInterfacedFlag() {
        return invoiceInterfacedFlag;
    }

    public void setInvoiceInterfacedFlag(String invoiceInterfacedFlag) {
        this.invoiceInterfacedFlag = invoiceInterfacedFlag;
    }

    public Long getBillToContactId() {
        return billToContactId;
    }

    public void setBillToContactId(Long billToContactId) {
        this.billToContactId = billToContactId;
    }

    public Long getBillToCustomerId() {
        return billToCustomerId;
    }

    public void setBillToCustomerId(Long billToCustomerId) {
        this.billToCustomerId = billToCustomerId;
    }

    public Long getBillToSiteUseId() {
        return billToSiteUseId;
    }

    public void setBillToSiteUseId(Long billToSiteUseId) {
        this.billToSiteUseId = billToSiteUseId;
    }

    public Long getSourceOrgId() {
        return sourceOrgId;
    }

    public void setSourceOrgId(Long sourceOrgId) {
        this.sourceOrgId = sourceOrgId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Date getRequestArrivalDate() {
        return requestArrivalDate;
    }

    public void setRequestArrivalDate(Date requestArrivalDate) {
        this.requestArrivalDate = requestArrivalDate;
    }

    public Date getRequestShipDate() {
        return requestShipDate;
    }

    public void setRequestShipDate(Date requestShipDate) {
        this.requestShipDate = requestShipDate;
    }

    public Date getScheduleArrivalDate() {
        return scheduleArrivalDate;
    }

    public void setScheduleArrivalDate(Date scheduleArrivalDate) {
        this.scheduleArrivalDate = scheduleArrivalDate;
    }

    public Date getScheduleShipDate() {
        return scheduleShipDate;
    }

    public void setScheduleShipDate(Date scheduleShipDate) {
        this.scheduleShipDate = scheduleShipDate;
    }

    public Date getPromiseArrivalDate() {
        return promiseArrivalDate;
    }

    public void setPromiseArrivalDate(Date promiseArrivalDate) {
        this.promiseArrivalDate = promiseArrivalDate;
    }

    public Date getPromiseShipDate() {
        return promiseShipDate;
    }

    public void setPromiseShipDate(Date promiseShipDate) {
        this.promiseShipDate = promiseShipDate;
    }

    public Date getActualShipDate() {
        return actualShipDate;
    }

    public void setActualShipDate(Date actualShipDate) {
        this.actualShipDate = actualShipDate;
    }

    public Date getFulfillmentDate() {
        return fulfillmentDate;
    }

    public void setFulfillmentDate(Date fulfillmentDate) {
        this.fulfillmentDate = fulfillmentDate;
    }

    public Long getCustomerItemId() {
        return customerItemId;
    }

    public void setCustomerItemId(Long customerItemId) {
        this.customerItemId = customerItemId;
    }

    public String getCustomerPoLineNumber() {
        return customerPoLineNumber;
    }

    public void setCustomerPoLineNumber(String customerPoLineNumber) {
        this.customerPoLineNumber = customerPoLineNumber;
    }

    public String getCustomerPoNumber() {
        return customerPoNumber;
    }

    public void setCustomerPoNumber(String customerPoNumber) {
        this.customerPoNumber = customerPoNumber;
    }

    public String getDemandClassCode() {
        return demandClassCode;
    }

    public void setDemandClassCode(String demandClassCode) {
        this.demandClassCode = demandClassCode;
    }

    public BigDecimal getExtendedAmount() {
        return extendedAmount;
    }

    public void setExtendedAmount(BigDecimal extendedAmount) {
        this.extendedAmount = extendedAmount;
    }

    public String getFobPointCode() {
        return fobPointCode;
    }

    public void setFobPointCode(String fobPointCode) {
        this.fobPointCode = fobPointCode;
    }

    public Long getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Long carrierId) {
        this.carrierId = carrierId;
    }

    public Long getInvoicingRuleId() {
        return invoicingRuleId;
    }

    public void setInvoicingRuleId(Long invoicingRuleId) {
        this.invoicingRuleId = invoicingRuleId;
    }

    public String getExemptionCertificateNumber() {
        return exemptionCertificateNumber;
    }

    public void setExemptionCertificateNumber(String exemptionCertificateNumber) {
        this.exemptionCertificateNumber = exemptionCertificateNumber;
    }

    public Long getAccountingRuleId() {
        return accountingRuleId;
    }

    public void setAccountingRuleId(Long accountingRuleId) {
        this.accountingRuleId = accountingRuleId;
    }

    public String getLineTypeCode() {
        return lineTypeCode;
    }

    public void setLineTypeCode(String lineTypeCode) {
        this.lineTypeCode = lineTypeCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOpenFlag() {
        return openFlag;
    }

    public void setOpenFlag(String openFlag) {
        this.openFlag = openFlag;
    }

    public String getCanceledFlag() {
        return canceledFlag;
    }

    public void setCanceledFlag(String canceledFlag) {
        this.canceledFlag = canceledFlag;
    }

    public String getOverrideScheduleDateFlag() {
        return overrideScheduleDateFlag;
    }

    public void setOverrideScheduleDateFlag(String overrideScheduleDateFlag) {
        this.overrideScheduleDateFlag = overrideScheduleDateFlag;
    }

    public Long getOriginalInventoryItemId() {
        return originalInventoryItemId;
    }

    public void setOriginalInventoryItemId(Long originalInventoryItemId) {
        this.originalInventoryItemId = originalInventoryItemId;
    }

    public String getGopReferenceId() {
        return gopReferenceId;
    }

    public void setGopReferenceId(String gopReferenceId) {
        this.gopReferenceId = gopReferenceId;
    }

    public String getPackingInstructions() {
        return packingInstructions;
    }

    public void setPackingInstructions(String packingInstructions) {
        this.packingInstructions = packingInstructions;
    }

    public Long getParentFulfillLineId() {
        return parentFulfillLineId;
    }

    public void setParentFulfillLineId(Long parentFulfillLineId) {
        this.parentFulfillLineId = parentFulfillLineId;
    }

    public Long getPaymentTermId() {
        return paymentTermId;
    }

    public void setPaymentTermId(Long paymentTermId) {
        this.paymentTermId = paymentTermId;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getReturnReasonCode() {
        return returnReasonCode;
    }

    public void setReturnReasonCode(String returnReasonCode) {
        this.returnReasonCode = returnReasonCode;
    }

    public String getOrigSysDocumentRef() {
        return origSysDocumentRef;
    }

    public void setOrigSysDocumentRef(String origSysDocumentRef) {
        this.origSysDocumentRef = origSysDocumentRef;
    }

    public String getOrigSysDocumentLineRef() {
        return origSysDocumentLineRef;
    }

    public void setOrigSysDocumentLineRef(String origSysDocumentLineRef) {
        this.origSysDocumentLineRef = origSysDocumentLineRef;
    }

    public Long getRootParentFulfillLineId() {
        return rootParentFulfillLineId;
    }

    public void setRootParentFulfillLineId(Long rootParentFulfillLineId) {
        this.rootParentFulfillLineId = rootParentFulfillLineId;
    }

    public String getShipClassOfService() {
        return shipClassOfService;
    }

    public void setShipClassOfService(String shipClassOfService) {
        this.shipClassOfService = shipClassOfService;
    }

    public String getShipModeOfTransport() {
        return shipModeOfTransport;
    }

    public void setShipModeOfTransport(String shipModeOfTransport) {
        this.shipModeOfTransport = shipModeOfTransport;
    }

    public Long getShipToContactId() {
        return shipToContactId;
    }

    public void setShipToContactId(Long shipToContactId) {
        this.shipToContactId = shipToContactId;
    }

    public Long getShipToCustomerId() {
        return shipToCustomerId;
    }

    public void setShipToCustomerId(Long shipToCustomerId) {
        this.shipToCustomerId = shipToCustomerId;
    }

    public Long getShipToSiteUseId() {
        return shipToSiteUseId;
    }

    public void setShipToSiteUseId(Long shipToSiteUseId) {
        this.shipToSiteUseId = shipToSiteUseId;
    }

    public BigDecimal getFulfillToleranceAbove() {
        return fulfillToleranceAbove;
    }

    public void setFulfillToleranceAbove(BigDecimal fulfillToleranceAbove) {
        this.fulfillToleranceAbove = fulfillToleranceAbove;
    }

    public BigDecimal getFulfillToleranceBelow() {
        return fulfillToleranceBelow;
    }

    public void setFulfillToleranceBelow(BigDecimal fulfillToleranceBelow) {
        this.fulfillToleranceBelow = fulfillToleranceBelow;
    }

    public String getShipmentPriorityCode() {
        return shipmentPriorityCode;
    }

    public void setShipmentPriorityCode(String shipmentPriorityCode) {
        this.shipmentPriorityCode = shipmentPriorityCode;
    }

    public String getShippingInstructions() {
        return shippingInstructions;
    }

    public void setShippingInstructions(String shippingInstructions) {
        this.shippingInstructions = shippingInstructions;
    }

    public String getShipSetName() {
        return shipSetName;
    }

    public void setShipSetName(String shipSetName) {
        this.shipSetName = shipSetName;
    }

    public Long getSplitFromFlineId() {
        return splitFromFlineId;
    }

    public void setSplitFromFlineId(Long splitFromFlineId) {
        this.splitFromFlineId = splitFromFlineId;
    }

    public String getPartialShipAllowedFlag() {
        return partialShipAllowedFlag;
    }

    public void setPartialShipAllowedFlag(String partialShipAllowedFlag) {
        this.partialShipAllowedFlag = partialShipAllowedFlag;
    }

    public String getSubstituteAllowedFlag() {
        return substituteAllowedFlag;
    }

    public void setSubstituteAllowedFlag(String substituteAllowedFlag) {
        this.substituteAllowedFlag = substituteAllowedFlag;
    }

    public String getSubstituteReasonCode() {
        return substituteReasonCode;
    }

    public void setSubstituteReasonCode(String substituteReasonCode) {
        this.substituteReasonCode = substituteReasonCode;
    }

    public String getTaxExemptFlag() {
        return taxExemptFlag;
    }

    public void setTaxExemptFlag(String taxExemptFlag) {
        this.taxExemptFlag = taxExemptFlag;
    }

    public String getTaxClassificationCode() {
        return taxClassificationCode;
    }

    public void setTaxClassificationCode(String taxClassificationCode) {
        this.taxClassificationCode = taxClassificationCode;
    }

    public Long getDeltaType() {
        return deltaType;
    }

    public void setDeltaType(Long deltaType) {
        this.deltaType = deltaType;
    }

    public String getTaxExemptionReasonCode() {
        return taxExemptionReasonCode;
    }

    public void setTaxExemptionReasonCode(String taxExemptionReasonCode) {
        this.taxExemptionReasonCode = taxExemptionReasonCode;
    }

    public BigDecimal getUnitListPrice() {
        return unitListPrice;
    }

    public void setUnitListPrice(BigDecimal unitListPrice) {
        this.unitListPrice = unitListPrice;
    }

    public BigDecimal getUnitSellingPrice() {
        return unitSellingPrice;
    }

    public void setUnitSellingPrice(BigDecimal unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    public Long getReferenceFlineId() {
        return referenceFlineId;
    }

    public void setReferenceFlineId(Long referenceFlineId) {
        this.referenceFlineId = referenceFlineId;
    }

    public Date getLatestAcceptableShipDate() {
        return latestAcceptableShipDate;
    }

    public void setLatestAcceptableShipDate(Date latestAcceptableShipDate) {
        this.latestAcceptableShipDate = latestAcceptableShipDate;
    }

    public Date getLatestAcceptableArrivalDate() {
        return latestAcceptableArrivalDate;
    }

    public void setLatestAcceptableArrivalDate(Date latestAcceptableArrivalDate) {
        this.latestAcceptableArrivalDate = latestAcceptableArrivalDate;
    }

    public Date getEarliestAcceptableShipDate() {
        return earliestAcceptableShipDate;
    }

    public void setEarliestAcceptableShipDate(Date earliestAcceptableShipDate) {
        this.earliestAcceptableShipDate = earliestAcceptableShipDate;
    }

    public String getOnHold() {
        return onHold;
    }

    public void setOnHold(String onHold) {
        this.onHold = onHold;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Date getActualCompletionDate() {
        return actualCompletionDate;
    }

    public void setActualCompletionDate(Date actualCompletionDate) {
        this.actualCompletionDate = actualCompletionDate;
    }

    public Long getInventoryOrganizationId() {
        return inventoryOrganizationId;
    }

    public void setInventoryOrganizationId(Long inventoryOrganizationId) {
        this.inventoryOrganizationId = inventoryOrganizationId;
    }

    public Long getFulfillInstanceId() {
        return fulfillInstanceId;
    }

    public void setFulfillInstanceId(Long fulfillInstanceId) {
        this.fulfillInstanceId = fulfillInstanceId;
    }

    public Long getStatusRulesetId() {
        return statusRulesetId;
    }

    public void setStatusRulesetId(Long statusRulesetId) {
        this.statusRulesetId = statusRulesetId;
    }

    public String getRemnantFlag() {
        return remnantFlag;
    }

    public void setRemnantFlag(String remnantFlag) {
        this.remnantFlag = remnantFlag;
    }

    public Long getFulfillmentSplitRefId() {
        return fulfillmentSplitRefId;
    }

    public void setFulfillmentSplitRefId(Long fulfillmentSplitRefId) {
        this.fulfillmentSplitRefId = fulfillmentSplitRefId;
    }

    public BigDecimal getEstimateMargin() {
        return estimateMargin;
    }

    public void setEstimateMargin(BigDecimal estimateMargin) {
        this.estimateMargin = estimateMargin;
    }

    public BigDecimal getEstimateFulfillmentCost() {
        return estimateFulfillmentCost;
    }

    public void setEstimateFulfillmentCost(BigDecimal estimateFulfillmentCost) {
        this.estimateFulfillmentCost = estimateFulfillmentCost;
    }

    public String getFreightTermsCode() {
        return freightTermsCode;
    }

    public void setFreightTermsCode(String freightTermsCode) {
        this.freightTermsCode = freightTermsCode;
    }

    public String getCancelReasonCode() {
        return cancelReasonCode;
    }

    public void setCancelReasonCode(String cancelReasonCode) {
        this.cancelReasonCode = cancelReasonCode;
    }

    public Long getLatestExtFulfillLineNumber() {
        return latestExtFulfillLineNumber;
    }

    public void setLatestExtFulfillLineNumber(Long latestExtFulfillLineNumber) {
        this.latestExtFulfillLineNumber = latestExtFulfillLineNumber;
    }

    public String getGopRequestRegion() {
        return gopRequestRegion;
    }

    public void setGopRequestRegion(String gopRequestRegion) {
        this.gopRequestRegion = gopRequestRegion;
    }

    public String getSchedulingReasonCode() {
        return schedulingReasonCode;
    }

    public void setSchedulingReasonCode(String schedulingReasonCode) {
        this.schedulingReasonCode = schedulingReasonCode;
    }

    public String getSubinventory() {
        return subinventory;
    }

    public void setSubinventory(String subinventory) {
        this.subinventory = subinventory;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getSupplierSiteId() {
        return supplierSiteId;
    }

    public void setSupplierSiteId(Long supplierSiteId) {
        this.supplierSiteId = supplierSiteId;
    }

    public Long getShipToPartyId() {
        return shipToPartyId;
    }

    public void setShipToPartyId(Long shipToPartyId) {
        this.shipToPartyId = shipToPartyId;
    }

    public Long getShipToPartySiteId() {
        return shipToPartySiteId;
    }

    public void setShipToPartySiteId(Long shipToPartySiteId) {
        this.shipToPartySiteId = shipToPartySiteId;
    }

    public Long getShipToPartyContactId() {
        return shipToPartyContactId;
    }

    public void setShipToPartyContactId(Long shipToPartyContactId) {
        this.shipToPartyContactId = shipToPartyContactId;
    }

    public String getConfigItemReference() {
        return configItemReference;
    }

    public void setConfigItemReference(String configItemReference) {
        this.configItemReference = configItemReference;
    }

    public String getItemSubTypeCode() {
        return itemSubTypeCode;
    }

    public void setItemSubTypeCode(String itemSubTypeCode) {
        this.itemSubTypeCode = itemSubTypeCode;
    }

    public Long getRequisitionInventoryOrgId() {
        return requisitionInventoryOrgId;
    }

    public void setRequisitionInventoryOrgId(Long requisitionInventoryOrgId) {
        this.requisitionInventoryOrgId = requisitionInventoryOrgId;
    }

    public Long getRequisitionBuId() {
        return requisitionBuId;
    }

    public void setRequisitionBuId(Long requisitionBuId) {
        this.requisitionBuId = requisitionBuId;
    }

    public String getFulfillmentMode() {
        return fulfillmentMode;
    }

    public void setFulfillmentMode(String fulfillmentMode) {
        this.fulfillmentMode = fulfillmentMode;
    }

    public String getPoStatusCode() {
        return poStatusCode;
    }

    public void setPoStatusCode(String poStatusCode) {
        this.poStatusCode = poStatusCode;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Date getRequestCancelDate() {
        return requestCancelDate;
    }

    public void setRequestCancelDate(Date requestCancelDate) {
        this.requestCancelDate = requestCancelDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDefaultTaxationCountry() {
        return defaultTaxationCountry;
    }

    public void setDefaultTaxationCountry(String defaultTaxationCountry) {
        this.defaultTaxationCountry = defaultTaxationCountry;
    }

    public Long getFirstPtyRegId() {
        return firstPtyRegId;
    }

    public void setFirstPtyRegId(Long firstPtyRegId) {
        this.firstPtyRegId = firstPtyRegId;
    }

    public Long getThirdPtyRegId() {
        return thirdPtyRegId;
    }

    public void setThirdPtyRegId(Long thirdPtyRegId) {
        this.thirdPtyRegId = thirdPtyRegId;
    }

    public String getDocumentSubType() {
        return documentSubType;
    }

    public void setDocumentSubType(String documentSubType) {
        this.documentSubType = documentSubType;
    }

    public String getTaxInvoiceNumber() {
        return taxInvoiceNumber;
    }

    public void setTaxInvoiceNumber(String taxInvoiceNumber) {
        this.taxInvoiceNumber = taxInvoiceNumber;
    }

    public Date getTaxInvoiceDate() {
        return taxInvoiceDate;
    }

    public void setTaxInvoiceDate(Date taxInvoiceDate) {
        this.taxInvoiceDate = taxInvoiceDate;
    }

    public Long getFinalDischargeLocationId() {
        return finalDischargeLocationId;
    }

    public void setFinalDischargeLocationId(Long finalDischargeLocationId) {
        this.finalDischargeLocationId = finalDischargeLocationId;
    }

    public Long getProdFcCategId() {
        return prodFcCategId;
    }

    public void setProdFcCategId(Long prodFcCategId) {
        this.prodFcCategId = prodFcCategId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getTrxBusinessCategory() {
        return trxBusinessCategory;
    }

    public void setTrxBusinessCategory(String trxBusinessCategory) {
        this.trxBusinessCategory = trxBusinessCategory;
    }

    public String getUserDefinedFiscClass() {
        return userDefinedFiscClass;
    }

    public void setUserDefinedFiscClass(String userDefinedFiscClass) {
        this.userDefinedFiscClass = userDefinedFiscClass;
    }

    public Long getIntendedUseClassifId() {
        return intendedUseClassifId;
    }

    public void setIntendedUseClassifId(Long intendedUseClassifId) {
        this.intendedUseClassifId = intendedUseClassifId;
    }

    public Long getDestinationLocationId() {
        return destinationLocationId;
    }

    public void setDestinationLocationId(Long destinationLocationId) {
        this.destinationLocationId = destinationLocationId;
    }

    public Long getDestinationOrgId() {
        return destinationOrgId;
    }

    public void setDestinationOrgId(Long destinationOrgId) {
        this.destinationOrgId = destinationOrgId;
    }

    public BigDecimal getQuantityPerModel() {
        return quantityPerModel;
    }

    public void setQuantityPerModel(BigDecimal quantityPerModel) {
        this.quantityPerModel = quantityPerModel;
    }

    public Long getConfigInventoryItemId() {
        return configInventoryItemId;
    }

    public void setConfigInventoryItemId(Long configInventoryItemId) {
        this.configInventoryItemId = configInventoryItemId;
    }

    public String getPurchasingEnabledFlag() {
        return purchasingEnabledFlag;
    }

    public void setPurchasingEnabledFlag(String purchasingEnabledFlag) {
        this.purchasingEnabledFlag = purchasingEnabledFlag;
    }

    public String getCustomerPoScheduleNumber() {
        return customerPoScheduleNumber;
    }

    public void setCustomerPoScheduleNumber(String customerPoScheduleNumber) {
        this.customerPoScheduleNumber = customerPoScheduleNumber;
    }

    public String getSupplyStatusCode() {
        return supplyStatusCode;
    }

    public void setSupplyStatusCode(String supplyStatusCode) {
        this.supplyStatusCode = supplyStatusCode;
    }

    public Long getShipToContactPointId() {
        return shipToContactPointId;
    }

    public void setShipToContactPointId(Long shipToContactPointId) {
        this.shipToContactPointId = shipToContactPointId;
    }

    public Long getPrefOverriddenBitset() {
        return prefOverriddenBitset;
    }

    public void setPrefOverriddenBitset(Long prefOverriddenBitset) {
        this.prefOverriddenBitset = prefOverriddenBitset;
    }

    public Long getAppliedPriceListId() {
        return appliedPriceListId;
    }

    public void setAppliedPriceListId(Long appliedPriceListId) {
        this.appliedPriceListId = appliedPriceListId;
    }

    public Date getPricedOn() {
        return pricedOn;
    }

    public void setPricedOn(Date pricedOn) {
        this.pricedOn = pricedOn;
    }

    public Date getRequiredFulfillmentDate() {
        return requiredFulfillmentDate;
    }

    public void setRequiredFulfillmentDate(Date requiredFulfillmentDate) {
        this.requiredFulfillmentDate = requiredFulfillmentDate;
    }

    public String getComponentIdPath() {
        return componentIdPath;
    }

    public void setComponentIdPath(String componentIdPath) {
        this.componentIdPath = componentIdPath;
    }

    public String getValidConfigurationFlag() {
        return validConfigurationFlag;
    }

    public void setValidConfigurationFlag(String validConfigurationFlag) {
        this.validConfigurationFlag = validConfigurationFlag;
    }

    public String getConfiguratorPath() {
        return configuratorPath;
    }

    public void setConfiguratorPath(String configuratorPath) {
        this.configuratorPath = configuratorPath;
    }

    public Long getConfigHeaderId() {
        return configHeaderId;
    }

    public void setConfigHeaderId(Long configHeaderId) {
        this.configHeaderId = configHeaderId;
    }

    public Long getConfigRevisionNumber() {
        return configRevisionNumber;
    }

    public void setConfigRevisionNumber(Long configRevisionNumber) {
        this.configRevisionNumber = configRevisionNumber;
    }

    public Integer getShowInSales() {
        return showInSales;
    }

    public void setShowInSales(Integer showInSales) {
        this.showInSales = showInSales;
    }

    public String getChangeEligibleFlag() {
        return changeEligibleFlag;
    }

    public void setChangeEligibleFlag(String changeEligibleFlag) {
        this.changeEligibleFlag = changeEligibleFlag;
    }

    public String getModifiedFlag() {
        return modifiedFlag;
    }

    public void setModifiedFlag(String modifiedFlag) {
        this.modifiedFlag = modifiedFlag;
    }

    public String getUnreferencedReturnFlag() {
        return unreferencedReturnFlag;
    }

    public void setUnreferencedReturnFlag(String unreferencedReturnFlag) {
        this.unreferencedReturnFlag = unreferencedReturnFlag;
    }

    public Long getBillToContactPointId() {
        return billToContactPointId;
    }

    public void setBillToContactPointId(Long billToContactPointId) {
        this.billToContactPointId = billToContactPointId;
    }

    public BigDecimal getUnitQuantity() {
        return unitQuantity;
    }

    public void setUnitQuantity(BigDecimal unitQuantity) {
        this.unitQuantity = unitQuantity;
    }

    public Date getConfigCreationDate() {
        return configCreationDate;
    }

    public void setConfigCreationDate(Date configCreationDate) {
        this.configCreationDate = configCreationDate;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public BigDecimal getTotalContractQuantity() {
        return totalContractQuantity;
    }

    public void setTotalContractQuantity(BigDecimal totalContractQuantity) {
        this.totalContractQuantity = totalContractQuantity;
    }

    public BigDecimal getTotalContractAmount() {
        return totalContractAmount;
    }

    public void setTotalContractAmount(BigDecimal totalContractAmount) {
        this.totalContractAmount = totalContractAmount;
    }

    public Long getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(Long processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessNumber() {
        return processNumber;
    }

    public void setProcessNumber(String processNumber) {
        this.processNumber = processNumber;
    }

    public String getCreditChkAuthNum() {
        return creditChkAuthNum;
    }

    public void setCreditChkAuthNum(String creditChkAuthNum) {
        this.creditChkAuthNum = creditChkAuthNum;
    }

    public Date getCreditChkAuthExpDate() {
        return creditChkAuthExpDate;
    }

    public void setCreditChkAuthExpDate(Date creditChkAuthExpDate) {
        this.creditChkAuthExpDate = creditChkAuthExpDate;
    }

    public String getTradeComplianceResultCode() {
        return tradeComplianceResultCode;
    }

    public void setTradeComplianceResultCode(String tradeComplianceResultCode) {
        this.tradeComplianceResultCode = tradeComplianceResultCode;
    }

    public Date getTradeComplianceDate() {
        return tradeComplianceDate;
    }

    public void setTradeComplianceDate(Date tradeComplianceDate) {
        this.tradeComplianceDate = tradeComplianceDate;
    }

    public String getTransportationPlannedFlag() {
        return transportationPlannedFlag;
    }

    public void setTransportationPlannedFlag(String transportationPlannedFlag) {
        this.transportationPlannedFlag = transportationPlannedFlag;
    }

    public String getCreatedInRelease() {
        return createdInRelease;
    }

    public void setCreatedInRelease(String createdInRelease) {
        this.createdInRelease = createdInRelease;
    }

    public String getConfigTradeComplResultCode() {
        return configTradeComplResultCode;
    }

    public void setConfigTradeComplResultCode(String configTradeComplResultCode) {
        this.configTradeComplResultCode = configTradeComplResultCode;
    }

    public Long getBillingTrxTypeId() {
        return billingTrxTypeId;
    }

    public void setBillingTrxTypeId(Long billingTrxTypeId) {
        this.billingTrxTypeId = billingTrxTypeId;
    }

    public BigDecimal getServiceDuration() {
        return serviceDuration;
    }

    public void setServiceDuration(BigDecimal serviceDuration) {
        this.serviceDuration = serviceDuration;
    }

    public String getServiceDurationPeriodCode() {
        return serviceDurationPeriodCode;
    }

    public void setServiceDurationPeriodCode(String serviceDurationPeriodCode) {
        this.serviceDurationPeriodCode = serviceDurationPeriodCode;
    }

    public String getSalesProductTypeCode() {
        return salesProductTypeCode;
    }

    public void setSalesProductTypeCode(String salesProductTypeCode) {
        this.salesProductTypeCode = salesProductTypeCode;
    }

    public String getActionTypeCode() {
        return actionTypeCode;
    }

    public void setActionTypeCode(String actionTypeCode) {
        this.actionTypeCode = actionTypeCode;
    }

    public String getAssetTrackedFlag() {
        return assetTrackedFlag;
    }

    public void setAssetTrackedFlag(String assetTrackedFlag) {
        this.assetTrackedFlag = assetTrackedFlag;
    }

    public String getAssetGroupNumber() {
        return assetGroupNumber;
    }

    public void setAssetGroupNumber(String assetGroupNumber) {
        this.assetGroupNumber = assetGroupNumber;
    }

    public String getProcessSet() {
        return processSet;
    }

    public void setProcessSet(String processSet) {
        this.processSet = processSet;
    }

    public Long getSalespersonId() {
        return salespersonId;
    }

    public void setSalespersonId(Long salespersonId) {
        this.salespersonId = salespersonId;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public String getPrjRecIndicator() {
        return prjRecIndicator;
    }

    public void setPrjRecIndicator(String prjRecIndicator) {
        this.prjRecIndicator = prjRecIndicator;
    }
}
