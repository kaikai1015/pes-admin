package sinexcel.quartz.domain;

import sinexcel.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class SyncDooHeadersAllEO extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    private Long headerId;

    private String preCreditCheckedFlag;

    private String orderNumber;

    private Integer objectVersionNumber;

    private Long ownerId;

    private Date creationDate;

    private String createdBy;

    private Date lastUpdateDate;

    private String lastUpdatedBy;

    private String lastUpdateLogin;

    private String sourceOrderSystem;

    private String sourceOrderNumber;

    private String sourceOrderId;

    private String sourceDocumentTypeCode;

    private Long sourceRevisionNumber;

    private String origSysDocumentRef;

    private Long sourceOrgId;

    private Long orgId;

    private Long legalEntityId;

    private Long soldToCustomerId;

    private Long soldToContactId;

    private Date orderedDate;

    private String customerPoNumber;

    private String orderTypeCode;

    private String transactionalCurrencyCode;

    private BigDecimal conversionRate;

    private String conversionTypeCode;

    private Date conversionDate;

    private String statusCode;

    private String partialShipAllowedFlag;

    private String openFlag;

    private String onHold;

    private String canceledFlag;

    private Long changeVersionNumber;

    private String isEditable;

    private String cancelReasonCode;

    private Long soldToPartyId;

    private Long soldToPartyContactId;

    private Date requestCancelDate;

    private String comments;

    private String allowCurrencyOverrideFlag;

    private String appliedCurrencyCode;

    private Date pricedOn;

    private String pricingSegmentCode;

    private String pricingSegmentExplanation;

    private String pricingStrategyExplanation;

    private String segmentExplanationMsgName;

    private String strategyExplanationMsgName;

    private Long pricingStrategyId;

    private String freezeTaxFlag;

    private String shipsetFlag;

    private Long fulfillOrgId;

    private Long supplierId;

    private Long supplierSiteId;

    private String demandClassCode;

    private String substituteAllowedFlag;

    private String freightTermsCode;

    private String fobPointCode;

    private String packingInstructions;

    private String shippingInstructions;

    private String shipmentPriorityCode;

    private Date requestShipDate;

    private Date latestAcceptableShipDate;

    private Date earliestAcceptableShipDate;

    private Long carrierId;

    private String shipModeOfTransport;

    private String shipClassOfService;

    private Date requestArrivalDate;

    private Date latestAcceptArrivalDate;

    private Date earliestAcceptArrivalDate;

    private String submittedFlag;

    private Long referenceHeaderId;

    private String freezePriceFlag;

    private String freezeShippingChargeFlag;

    private Long paymentTermId;

    private Long soldToPartyContactPointId;

    private String modifiedFlag;

    private String revisionSourceOrderSystem;

    private Long approvalSequenceNumber;

    private String tradeComplianceResultCode;

    private String createdInRelease;

    private Date submittedDate;

    private String submittedBy;

    private String salesChannelCode;

    private Long salespersonId;

    private Long batchId;

    private String creationMode;

    private String mdoFlag;

    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public String getPreCreditCheckedFlag() {
        return preCreditCheckedFlag;
    }

    public void setPreCreditCheckedFlag(String preCreditCheckedFlag) {
        this.preCreditCheckedFlag = preCreditCheckedFlag;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(Integer objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
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

    public String getSourceOrderSystem() {
        return sourceOrderSystem;
    }

    public void setSourceOrderSystem(String sourceOrderSystem) {
        this.sourceOrderSystem = sourceOrderSystem;
    }

    public String getSourceOrderNumber() {
        return sourceOrderNumber;
    }

    public void setSourceOrderNumber(String sourceOrderNumber) {
        this.sourceOrderNumber = sourceOrderNumber;
    }

    public String getSourceOrderId() {
        return sourceOrderId;
    }

    public void setSourceOrderId(String sourceOrderId) {
        this.sourceOrderId = sourceOrderId;
    }

    public String getSourceDocumentTypeCode() {
        return sourceDocumentTypeCode;
    }

    public void setSourceDocumentTypeCode(String sourceDocumentTypeCode) {
        this.sourceDocumentTypeCode = sourceDocumentTypeCode;
    }

    public Long getSourceRevisionNumber() {
        return sourceRevisionNumber;
    }

    public void setSourceRevisionNumber(Long sourceRevisionNumber) {
        this.sourceRevisionNumber = sourceRevisionNumber;
    }

    public String getOrigSysDocumentRef() {
        return origSysDocumentRef;
    }

    public void setOrigSysDocumentRef(String origSysDocumentRef) {
        this.origSysDocumentRef = origSysDocumentRef;
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

    public Long getLegalEntityId() {
        return legalEntityId;
    }

    public void setLegalEntityId(Long legalEntityId) {
        this.legalEntityId = legalEntityId;
    }

    public Long getSoldToCustomerId() {
        return soldToCustomerId;
    }

    public void setSoldToCustomerId(Long soldToCustomerId) {
        this.soldToCustomerId = soldToCustomerId;
    }

    public Long getSoldToContactId() {
        return soldToContactId;
    }

    public void setSoldToContactId(Long soldToContactId) {
        this.soldToContactId = soldToContactId;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }

    public String getCustomerPoNumber() {
        return customerPoNumber;
    }

    public void setCustomerPoNumber(String customerPoNumber) {
        this.customerPoNumber = customerPoNumber;
    }

    public String getOrderTypeCode() {
        return orderTypeCode;
    }

    public void setOrderTypeCode(String orderTypeCode) {
        this.orderTypeCode = orderTypeCode;
    }

    public String getTransactionalCurrencyCode() {
        return transactionalCurrencyCode;
    }

    public void setTransactionalCurrencyCode(String transactionalCurrencyCode) {
        this.transactionalCurrencyCode = transactionalCurrencyCode;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public String getConversionTypeCode() {
        return conversionTypeCode;
    }

    public void setConversionTypeCode(String conversionTypeCode) {
        this.conversionTypeCode = conversionTypeCode;
    }

    public Date getConversionDate() {
        return conversionDate;
    }

    public void setConversionDate(Date conversionDate) {
        this.conversionDate = conversionDate;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getPartialShipAllowedFlag() {
        return partialShipAllowedFlag;
    }

    public void setPartialShipAllowedFlag(String partialShipAllowedFlag) {
        this.partialShipAllowedFlag = partialShipAllowedFlag;
    }

    public String getOpenFlag() {
        return openFlag;
    }

    public void setOpenFlag(String openFlag) {
        this.openFlag = openFlag;
    }

    public String getOnHold() {
        return onHold;
    }

    public void setOnHold(String onHold) {
        this.onHold = onHold;
    }

    public String getCanceledFlag() {
        return canceledFlag;
    }

    public void setCanceledFlag(String canceledFlag) {
        this.canceledFlag = canceledFlag;
    }

    public Long getChangeVersionNumber() {
        return changeVersionNumber;
    }

    public void setChangeVersionNumber(Long changeVersionNumber) {
        this.changeVersionNumber = changeVersionNumber;
    }

    public String getIsEditable() {
        return isEditable;
    }

    public void setIsEditable(String isEditable) {
        this.isEditable = isEditable;
    }

    public String getCancelReasonCode() {
        return cancelReasonCode;
    }

    public void setCancelReasonCode(String cancelReasonCode) {
        this.cancelReasonCode = cancelReasonCode;
    }

    public Long getSoldToPartyId() {
        return soldToPartyId;
    }

    public void setSoldToPartyId(Long soldToPartyId) {
        this.soldToPartyId = soldToPartyId;
    }

    public Long getSoldToPartyContactId() {
        return soldToPartyContactId;
    }

    public void setSoldToPartyContactId(Long soldToPartyContactId) {
        this.soldToPartyContactId = soldToPartyContactId;
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

    public String getAllowCurrencyOverrideFlag() {
        return allowCurrencyOverrideFlag;
    }

    public void setAllowCurrencyOverrideFlag(String allowCurrencyOverrideFlag) {
        this.allowCurrencyOverrideFlag = allowCurrencyOverrideFlag;
    }

    public String getAppliedCurrencyCode() {
        return appliedCurrencyCode;
    }

    public void setAppliedCurrencyCode(String appliedCurrencyCode) {
        this.appliedCurrencyCode = appliedCurrencyCode;
    }

    public Date getPricedOn() {
        return pricedOn;
    }

    public void setPricedOn(Date pricedOn) {
        this.pricedOn = pricedOn;
    }

    public String getPricingSegmentCode() {
        return pricingSegmentCode;
    }

    public void setPricingSegmentCode(String pricingSegmentCode) {
        this.pricingSegmentCode = pricingSegmentCode;
    }

    public String getPricingSegmentExplanation() {
        return pricingSegmentExplanation;
    }

    public void setPricingSegmentExplanation(String pricingSegmentExplanation) {
        this.pricingSegmentExplanation = pricingSegmentExplanation;
    }

    public String getPricingStrategyExplanation() {
        return pricingStrategyExplanation;
    }

    public void setPricingStrategyExplanation(String pricingStrategyExplanation) {
        this.pricingStrategyExplanation = pricingStrategyExplanation;
    }

    public String getSegmentExplanationMsgName() {
        return segmentExplanationMsgName;
    }

    public void setSegmentExplanationMsgName(String segmentExplanationMsgName) {
        this.segmentExplanationMsgName = segmentExplanationMsgName;
    }

    public String getStrategyExplanationMsgName() {
        return strategyExplanationMsgName;
    }

    public void setStrategyExplanationMsgName(String strategyExplanationMsgName) {
        this.strategyExplanationMsgName = strategyExplanationMsgName;
    }

    public Long getPricingStrategyId() {
        return pricingStrategyId;
    }

    public void setPricingStrategyId(Long pricingStrategyId) {
        this.pricingStrategyId = pricingStrategyId;
    }

    public String getFreezeTaxFlag() {
        return freezeTaxFlag;
    }

    public void setFreezeTaxFlag(String freezeTaxFlag) {
        this.freezeTaxFlag = freezeTaxFlag;
    }

    public String getShipsetFlag() {
        return shipsetFlag;
    }

    public void setShipsetFlag(String shipsetFlag) {
        this.shipsetFlag = shipsetFlag;
    }

    public Long getFulfillOrgId() {
        return fulfillOrgId;
    }

    public void setFulfillOrgId(Long fulfillOrgId) {
        this.fulfillOrgId = fulfillOrgId;
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

    public String getDemandClassCode() {
        return demandClassCode;
    }

    public void setDemandClassCode(String demandClassCode) {
        this.demandClassCode = demandClassCode;
    }

    public String getSubstituteAllowedFlag() {
        return substituteAllowedFlag;
    }

    public void setSubstituteAllowedFlag(String substituteAllowedFlag) {
        this.substituteAllowedFlag = substituteAllowedFlag;
    }

    public String getFreightTermsCode() {
        return freightTermsCode;
    }

    public void setFreightTermsCode(String freightTermsCode) {
        this.freightTermsCode = freightTermsCode;
    }

    public String getFobPointCode() {
        return fobPointCode;
    }

    public void setFobPointCode(String fobPointCode) {
        this.fobPointCode = fobPointCode;
    }

    public String getPackingInstructions() {
        return packingInstructions;
    }

    public void setPackingInstructions(String packingInstructions) {
        this.packingInstructions = packingInstructions;
    }

    public String getShippingInstructions() {
        return shippingInstructions;
    }

    public void setShippingInstructions(String shippingInstructions) {
        this.shippingInstructions = shippingInstructions;
    }

    public String getShipmentPriorityCode() {
        return shipmentPriorityCode;
    }

    public void setShipmentPriorityCode(String shipmentPriorityCode) {
        this.shipmentPriorityCode = shipmentPriorityCode;
    }

    public Date getRequestShipDate() {
        return requestShipDate;
    }

    public void setRequestShipDate(Date requestShipDate) {
        this.requestShipDate = requestShipDate;
    }

    public Date getLatestAcceptableShipDate() {
        return latestAcceptableShipDate;
    }

    public void setLatestAcceptableShipDate(Date latestAcceptableShipDate) {
        this.latestAcceptableShipDate = latestAcceptableShipDate;
    }

    public Date getEarliestAcceptableShipDate() {
        return earliestAcceptableShipDate;
    }

    public void setEarliestAcceptableShipDate(Date earliestAcceptableShipDate) {
        this.earliestAcceptableShipDate = earliestAcceptableShipDate;
    }

    public Long getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Long carrierId) {
        this.carrierId = carrierId;
    }

    public String getShipModeOfTransport() {
        return shipModeOfTransport;
    }

    public void setShipModeOfTransport(String shipModeOfTransport) {
        this.shipModeOfTransport = shipModeOfTransport;
    }

    public String getShipClassOfService() {
        return shipClassOfService;
    }

    public void setShipClassOfService(String shipClassOfService) {
        this.shipClassOfService = shipClassOfService;
    }

    public Date getRequestArrivalDate() {
        return requestArrivalDate;
    }

    public void setRequestArrivalDate(Date requestArrivalDate) {
        this.requestArrivalDate = requestArrivalDate;
    }

    public Date getLatestAcceptArrivalDate() {
        return latestAcceptArrivalDate;
    }

    public void setLatestAcceptArrivalDate(Date latestAcceptArrivalDate) {
        this.latestAcceptArrivalDate = latestAcceptArrivalDate;
    }

    public Date getEarliestAcceptArrivalDate() {
        return earliestAcceptArrivalDate;
    }

    public void setEarliestAcceptArrivalDate(Date earliestAcceptArrivalDate) {
        this.earliestAcceptArrivalDate = earliestAcceptArrivalDate;
    }

    public String getSubmittedFlag() {
        return submittedFlag;
    }

    public void setSubmittedFlag(String submittedFlag) {
        this.submittedFlag = submittedFlag;
    }

    public Long getReferenceHeaderId() {
        return referenceHeaderId;
    }

    public void setReferenceHeaderId(Long referenceHeaderId) {
        this.referenceHeaderId = referenceHeaderId;
    }

    public String getFreezePriceFlag() {
        return freezePriceFlag;
    }

    public void setFreezePriceFlag(String freezePriceFlag) {
        this.freezePriceFlag = freezePriceFlag;
    }

    public String getFreezeShippingChargeFlag() {
        return freezeShippingChargeFlag;
    }

    public void setFreezeShippingChargeFlag(String freezeShippingChargeFlag) {
        this.freezeShippingChargeFlag = freezeShippingChargeFlag;
    }

    public Long getPaymentTermId() {
        return paymentTermId;
    }

    public void setPaymentTermId(Long paymentTermId) {
        this.paymentTermId = paymentTermId;
    }

    public Long getSoldToPartyContactPointId() {
        return soldToPartyContactPointId;
    }

    public void setSoldToPartyContactPointId(Long soldToPartyContactPointId) {
        this.soldToPartyContactPointId = soldToPartyContactPointId;
    }

    public String getModifiedFlag() {
        return modifiedFlag;
    }

    public void setModifiedFlag(String modifiedFlag) {
        this.modifiedFlag = modifiedFlag;
    }

    public String getRevisionSourceOrderSystem() {
        return revisionSourceOrderSystem;
    }

    public void setRevisionSourceOrderSystem(String revisionSourceOrderSystem) {
        this.revisionSourceOrderSystem = revisionSourceOrderSystem;
    }

    public Long getApprovalSequenceNumber() {
        return approvalSequenceNumber;
    }

    public void setApprovalSequenceNumber(Long approvalSequenceNumber) {
        this.approvalSequenceNumber = approvalSequenceNumber;
    }

    public String getTradeComplianceResultCode() {
        return tradeComplianceResultCode;
    }

    public void setTradeComplianceResultCode(String tradeComplianceResultCode) {
        this.tradeComplianceResultCode = tradeComplianceResultCode;
    }

    public String getCreatedInRelease() {
        return createdInRelease;
    }

    public void setCreatedInRelease(String createdInRelease) {
        this.createdInRelease = createdInRelease;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getSalesChannelCode() {
        return salesChannelCode;
    }

    public void setSalesChannelCode(String salesChannelCode) {
        this.salesChannelCode = salesChannelCode;
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

    public String getCreationMode() {
        return creationMode;
    }

    public void setCreationMode(String creationMode) {
        this.creationMode = creationMode;
    }

    public String getMdoFlag() {
        return mdoFlag;
    }

    public void setMdoFlag(String mdoFlag) {
        this.mdoFlag = mdoFlag;
    }
}
