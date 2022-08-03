package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SyncWshDeliveryDetailsEO {

    private Long deliveryDetailId;


    private Long sourceHeaderId;


    private Long sourceLineId;


    private String sourceHeaderNumber;


    private String custPoNumber;


    private Long soldToContactId;


    private Long inventoryItemId;


    private String itemDescription;


    private Long shipFromLocationId;


    private Long organizationId;


    private Long shipToLocationId;


    private Long shipToContactId;


    private BigDecimal srcRequestedQuantity;


    private String srcRequestedQuantityUom;


    private BigDecimal cancelledQuantity;


    private BigDecimal requestedQuantity;


    private String requestedQuantityUom;


    private BigDecimal shippedQuantity;


    private BigDecimal deliveredQuantity;


    private BigDecimal cycleCountQuantity;


    private Long moveOrderLineId;


    private String subinventory;


    private String revision;


    private String lotNumber;


    private String releasedStatus;


    private String serialNumber;


    private Long locatorId;


    private Date dateRequested;


    private Date dateScheduled;


    private BigDecimal loadSeqNumber;


    private String shipMethodCode;


    private Long carrierId;


    private String freightTermsCode;


    private String shipmentPriorityCode;


    private String fobCode;


    private Long customerItemId;


    private BigDecimal netWeight;


    private String weightUomCode;


    private BigDecimal volume;


    private String volumeUomCode;


    private String shippingInstructions;


    private String packingInstructions;


    private Long parentLpnId;


    private Long orgId;


    private String attributeCategory;


    private String attribute1;


    private String attribute2;


    private String attribute3;


    private String attribute4;


    private String attribute5;


    private String attribute6;


    private String attribute7;


    private String attribute8;


    private String attribute9;


    private String attribute10;


    private Date lastUpdateDate;


    private Date creationDate;


    private String createdBy;


    private String lastUpdatedBy;


    private String lastUpdateLogin;


    private Integer objectVersionNumber;


    private String sourceLineNumber;


    private String sealCode;


    private BigDecimal grossWeight;


    private String preferredGrade;


    private BigDecimal unitPrice;


    private String currencyCode;


    private Long lpnContentId;


    private String inspectionFlag;


    private Long shipToSiteUseId;


    private String originalSubinventory;


    private String pickableFlag;


    private BigDecimal pickedQuantity;


    private Long batchId;


    private Long transactionId;


    private String requestDateTypeCode;


    private Long sourceDocumentTypeId;


    private BigDecimal unitWeight;


    private BigDecimal unitVolume;


    private String wvFrozenFlag;


    private Long shipToPartyId;


    private Long soldToPartyId;


    private Long outsourcerPartyId;


    private Long billToPartyId;


    private Long billToLocationId;


    private Long billToContactId;


    private String shipSetName;


    private String arrivalSetName;


    private Date sourceLineUpdateDate;


    private BigDecimal sellingPrice;


    private Long shipToPartySiteId;


    private Long billToPartySiteId;


    private Long requisitionHeaderId;


    private Long requisitionLineId;


    private BigDecimal convertedQuantity;


    private Long sourceShipmentId;


    private String sourceShipmentNumber;


    private Long sourceSystemId;


    private String salesOrderLineNumber;


    private String salesOrderNumber;


    private String salesOrderShipmentNumber;


    private String conversionType;


    private Date conversionDate;


    private Long conversionRate;


    private BigDecimal spPickedQuantity;


    private String spqUom;


    private Long parentInventoryItemId;


    private Long parentSourceShipmentId;


    private String shipmentAdviceStatus;


    private Date calcWndWddDate;


    private String sourceLineType;


    private Date doNotShipBeforeDate;


    private Date doNotShipAfterDate;


    private String defaultTaxationCountry;


    private Long firstPtyRegId;


    private Long thirdPtyRegId;


    private Long finalDischargeLocationId;


    private String documentSubType;


    private String trxBusinessCategory;


    private String userDefinedFiscClass;


    private String taxInvoiceNumber;


    private Date taxInvoiceDate;


    private String productCategory;


    private BigDecimal intendedUseClassifId;


    private String productType;


    private BigDecimal assessableValue;


    private String taxClassificationCode;


    private String exemptCertificateNumber;


    private String exemptReasonCode;


    private String shipToLocationType;


    private Long categoryId;


    private String wmsInterfacedFlag;


    private String pickedFromSubinventory;

    public Long getDeliveryDetailId() {
        return deliveryDetailId;
    }

    public void setDeliveryDetailId(Long deliveryDetailId) {
        this.deliveryDetailId = deliveryDetailId;
    }

    public Long getSourceHeaderId() {
        return sourceHeaderId;
    }

    public void setSourceHeaderId(Long sourceHeaderId) {
        this.sourceHeaderId = sourceHeaderId;
    }

    public Long getSourceLineId() {
        return sourceLineId;
    }

    public void setSourceLineId(Long sourceLineId) {
        this.sourceLineId = sourceLineId;
    }

    public String getSourceHeaderNumber() {
        return sourceHeaderNumber;
    }

    public void setSourceHeaderNumber(String sourceHeaderNumber) {
        this.sourceHeaderNumber = sourceHeaderNumber;
    }

    public String getCustPoNumber() {
        return custPoNumber;
    }

    public void setCustPoNumber(String custPoNumber) {
        this.custPoNumber = custPoNumber;
    }

    public Long getSoldToContactId() {
        return soldToContactId;
    }

    public void setSoldToContactId(Long soldToContactId) {
        this.soldToContactId = soldToContactId;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Long getShipFromLocationId() {
        return shipFromLocationId;
    }

    public void setShipFromLocationId(Long shipFromLocationId) {
        this.shipFromLocationId = shipFromLocationId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getShipToLocationId() {
        return shipToLocationId;
    }

    public void setShipToLocationId(Long shipToLocationId) {
        this.shipToLocationId = shipToLocationId;
    }

    public Long getShipToContactId() {
        return shipToContactId;
    }

    public void setShipToContactId(Long shipToContactId) {
        this.shipToContactId = shipToContactId;
    }

    public BigDecimal getSrcRequestedQuantity() {
        return srcRequestedQuantity;
    }

    public void setSrcRequestedQuantity(BigDecimal srcRequestedQuantity) {
        this.srcRequestedQuantity = srcRequestedQuantity;
    }

    public String getSrcRequestedQuantityUom() {
        return srcRequestedQuantityUom;
    }

    public void setSrcRequestedQuantityUom(String srcRequestedQuantityUom) {
        this.srcRequestedQuantityUom = srcRequestedQuantityUom;
    }

    public BigDecimal getCancelledQuantity() {
        return cancelledQuantity;
    }

    public void setCancelledQuantity(BigDecimal cancelledQuantity) {
        this.cancelledQuantity = cancelledQuantity;
    }

    public BigDecimal getRequestedQuantity() {
        return requestedQuantity;
    }

    public void setRequestedQuantity(BigDecimal requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
    }

    public String getRequestedQuantityUom() {
        return requestedQuantityUom;
    }

    public void setRequestedQuantityUom(String requestedQuantityUom) {
        this.requestedQuantityUom = requestedQuantityUom;
    }

    public BigDecimal getShippedQuantity() {
        return shippedQuantity;
    }

    public void setShippedQuantity(BigDecimal shippedQuantity) {
        this.shippedQuantity = shippedQuantity;
    }

    public BigDecimal getDeliveredQuantity() {
        return deliveredQuantity;
    }

    public void setDeliveredQuantity(BigDecimal deliveredQuantity) {
        this.deliveredQuantity = deliveredQuantity;
    }

    public BigDecimal getCycleCountQuantity() {
        return cycleCountQuantity;
    }

    public void setCycleCountQuantity(BigDecimal cycleCountQuantity) {
        this.cycleCountQuantity = cycleCountQuantity;
    }

    public Long getMoveOrderLineId() {
        return moveOrderLineId;
    }

    public void setMoveOrderLineId(Long moveOrderLineId) {
        this.moveOrderLineId = moveOrderLineId;
    }

    public String getSubinventory() {
        return subinventory;
    }

    public void setSubinventory(String subinventory) {
        this.subinventory = subinventory;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getReleasedStatus() {
        return releasedStatus;
    }

    public void setReleasedStatus(String releasedStatus) {
        this.releasedStatus = releasedStatus;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getLocatorId() {
        return locatorId;
    }

    public void setLocatorId(Long locatorId) {
        this.locatorId = locatorId;
    }

    public Date getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(Date dateRequested) {
        this.dateRequested = dateRequested;
    }

    public Date getDateScheduled() {
        return dateScheduled;
    }

    public void setDateScheduled(Date dateScheduled) {
        this.dateScheduled = dateScheduled;
    }

    public BigDecimal getLoadSeqNumber() {
        return loadSeqNumber;
    }

    public void setLoadSeqNumber(BigDecimal loadSeqNumber) {
        this.loadSeqNumber = loadSeqNumber;
    }

    public String getShipMethodCode() {
        return shipMethodCode;
    }

    public void setShipMethodCode(String shipMethodCode) {
        this.shipMethodCode = shipMethodCode;
    }

    public Long getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Long carrierId) {
        this.carrierId = carrierId;
    }

    public String getFreightTermsCode() {
        return freightTermsCode;
    }

    public void setFreightTermsCode(String freightTermsCode) {
        this.freightTermsCode = freightTermsCode;
    }

    public String getShipmentPriorityCode() {
        return shipmentPriorityCode;
    }

    public void setShipmentPriorityCode(String shipmentPriorityCode) {
        this.shipmentPriorityCode = shipmentPriorityCode;
    }

    public String getFobCode() {
        return fobCode;
    }

    public void setFobCode(String fobCode) {
        this.fobCode = fobCode;
    }

    public Long getCustomerItemId() {
        return customerItemId;
    }

    public void setCustomerItemId(Long customerItemId) {
        this.customerItemId = customerItemId;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public String getWeightUomCode() {
        return weightUomCode;
    }

    public void setWeightUomCode(String weightUomCode) {
        this.weightUomCode = weightUomCode;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public String getVolumeUomCode() {
        return volumeUomCode;
    }

    public void setVolumeUomCode(String volumeUomCode) {
        this.volumeUomCode = volumeUomCode;
    }

    public String getShippingInstructions() {
        return shippingInstructions;
    }

    public void setShippingInstructions(String shippingInstructions) {
        this.shippingInstructions = shippingInstructions;
    }

    public String getPackingInstructions() {
        return packingInstructions;
    }

    public void setPackingInstructions(String packingInstructions) {
        this.packingInstructions = packingInstructions;
    }

    public Long getParentLpnId() {
        return parentLpnId;
    }

    public void setParentLpnId(Long parentLpnId) {
        this.parentLpnId = parentLpnId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getAttributeCategory() {
        return attributeCategory;
    }

    public void setAttributeCategory(String attributeCategory) {
        this.attributeCategory = attributeCategory;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    public String getAttribute6() {
        return attribute6;
    }

    public void setAttribute6(String attribute6) {
        this.attribute6 = attribute6;
    }

    public String getAttribute7() {
        return attribute7;
    }

    public void setAttribute7(String attribute7) {
        this.attribute7 = attribute7;
    }

    public String getAttribute8() {
        return attribute8;
    }

    public void setAttribute8(String attribute8) {
        this.attribute8 = attribute8;
    }

    public String getAttribute9() {
        return attribute9;
    }

    public void setAttribute9(String attribute9) {
        this.attribute9 = attribute9;
    }

    public String getAttribute10() {
        return attribute10;
    }

    public void setAttribute10(String attribute10) {
        this.attribute10 = attribute10;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
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

    public Integer getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(Integer objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }

    public String getSourceLineNumber() {
        return sourceLineNumber;
    }

    public void setSourceLineNumber(String sourceLineNumber) {
        this.sourceLineNumber = sourceLineNumber;
    }

    public String getSealCode() {
        return sealCode;
    }

    public void setSealCode(String sealCode) {
        this.sealCode = sealCode;
    }

    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getPreferredGrade() {
        return preferredGrade;
    }

    public void setPreferredGrade(String preferredGrade) {
        this.preferredGrade = preferredGrade;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Long getLpnContentId() {
        return lpnContentId;
    }

    public void setLpnContentId(Long lpnContentId) {
        this.lpnContentId = lpnContentId;
    }

    public String getInspectionFlag() {
        return inspectionFlag;
    }

    public void setInspectionFlag(String inspectionFlag) {
        this.inspectionFlag = inspectionFlag;
    }

    public Long getShipToSiteUseId() {
        return shipToSiteUseId;
    }

    public void setShipToSiteUseId(Long shipToSiteUseId) {
        this.shipToSiteUseId = shipToSiteUseId;
    }

    public String getOriginalSubinventory() {
        return originalSubinventory;
    }

    public void setOriginalSubinventory(String originalSubinventory) {
        this.originalSubinventory = originalSubinventory;
    }

    public String getPickableFlag() {
        return pickableFlag;
    }

    public void setPickableFlag(String pickableFlag) {
        this.pickableFlag = pickableFlag;
    }

    public BigDecimal getPickedQuantity() {
        return pickedQuantity;
    }

    public void setPickedQuantity(BigDecimal pickedQuantity) {
        this.pickedQuantity = pickedQuantity;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getRequestDateTypeCode() {
        return requestDateTypeCode;
    }

    public void setRequestDateTypeCode(String requestDateTypeCode) {
        this.requestDateTypeCode = requestDateTypeCode;
    }

    public Long getSourceDocumentTypeId() {
        return sourceDocumentTypeId;
    }

    public void setSourceDocumentTypeId(Long sourceDocumentTypeId) {
        this.sourceDocumentTypeId = sourceDocumentTypeId;
    }

    public BigDecimal getUnitWeight() {
        return unitWeight;
    }

    public void setUnitWeight(BigDecimal unitWeight) {
        this.unitWeight = unitWeight;
    }

    public BigDecimal getUnitVolume() {
        return unitVolume;
    }

    public void setUnitVolume(BigDecimal unitVolume) {
        this.unitVolume = unitVolume;
    }

    public String getWvFrozenFlag() {
        return wvFrozenFlag;
    }

    public void setWvFrozenFlag(String wvFrozenFlag) {
        this.wvFrozenFlag = wvFrozenFlag;
    }

    public Long getShipToPartyId() {
        return shipToPartyId;
    }

    public void setShipToPartyId(Long shipToPartyId) {
        this.shipToPartyId = shipToPartyId;
    }

    public Long getSoldToPartyId() {
        return soldToPartyId;
    }

    public void setSoldToPartyId(Long soldToPartyId) {
        this.soldToPartyId = soldToPartyId;
    }

    public Long getOutsourcerPartyId() {
        return outsourcerPartyId;
    }

    public void setOutsourcerPartyId(Long outsourcerPartyId) {
        this.outsourcerPartyId = outsourcerPartyId;
    }

    public Long getBillToPartyId() {
        return billToPartyId;
    }

    public void setBillToPartyId(Long billToPartyId) {
        this.billToPartyId = billToPartyId;
    }

    public Long getBillToLocationId() {
        return billToLocationId;
    }

    public void setBillToLocationId(Long billToLocationId) {
        this.billToLocationId = billToLocationId;
    }

    public Long getBillToContactId() {
        return billToContactId;
    }

    public void setBillToContactId(Long billToContactId) {
        this.billToContactId = billToContactId;
    }

    public String getShipSetName() {
        return shipSetName;
    }

    public void setShipSetName(String shipSetName) {
        this.shipSetName = shipSetName;
    }

    public String getArrivalSetName() {
        return arrivalSetName;
    }

    public void setArrivalSetName(String arrivalSetName) {
        this.arrivalSetName = arrivalSetName;
    }

    public Date getSourceLineUpdateDate() {
        return sourceLineUpdateDate;
    }

    public void setSourceLineUpdateDate(Date sourceLineUpdateDate) {
        this.sourceLineUpdateDate = sourceLineUpdateDate;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Long getShipToPartySiteId() {
        return shipToPartySiteId;
    }

    public void setShipToPartySiteId(Long shipToPartySiteId) {
        this.shipToPartySiteId = shipToPartySiteId;
    }

    public Long getBillToPartySiteId() {
        return billToPartySiteId;
    }

    public void setBillToPartySiteId(Long billToPartySiteId) {
        this.billToPartySiteId = billToPartySiteId;
    }

    public Long getRequisitionHeaderId() {
        return requisitionHeaderId;
    }

    public void setRequisitionHeaderId(Long requisitionHeaderId) {
        this.requisitionHeaderId = requisitionHeaderId;
    }

    public Long getRequisitionLineId() {
        return requisitionLineId;
    }

    public void setRequisitionLineId(Long requisitionLineId) {
        this.requisitionLineId = requisitionLineId;
    }

    public BigDecimal getConvertedQuantity() {
        return convertedQuantity;
    }

    public void setConvertedQuantity(BigDecimal convertedQuantity) {
        this.convertedQuantity = convertedQuantity;
    }

    public Long getSourceShipmentId() {
        return sourceShipmentId;
    }

    public void setSourceShipmentId(Long sourceShipmentId) {
        this.sourceShipmentId = sourceShipmentId;
    }

    public String getSourceShipmentNumber() {
        return sourceShipmentNumber;
    }

    public void setSourceShipmentNumber(String sourceShipmentNumber) {
        this.sourceShipmentNumber = sourceShipmentNumber;
    }

    public Long getSourceSystemId() {
        return sourceSystemId;
    }

    public void setSourceSystemId(Long sourceSystemId) {
        this.sourceSystemId = sourceSystemId;
    }

    public String getSalesOrderLineNumber() {
        return salesOrderLineNumber;
    }

    public void setSalesOrderLineNumber(String salesOrderLineNumber) {
        this.salesOrderLineNumber = salesOrderLineNumber;
    }

    public String getSalesOrderNumber() {
        return salesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber) {
        this.salesOrderNumber = salesOrderNumber;
    }

    public String getSalesOrderShipmentNumber() {
        return salesOrderShipmentNumber;
    }

    public void setSalesOrderShipmentNumber(String salesOrderShipmentNumber) {
        this.salesOrderShipmentNumber = salesOrderShipmentNumber;
    }

    public String getConversionType() {
        return conversionType;
    }

    public void setConversionType(String conversionType) {
        this.conversionType = conversionType;
    }

    public Date getConversionDate() {
        return conversionDate;
    }

    public void setConversionDate(Date conversionDate) {
        this.conversionDate = conversionDate;
    }

    public Long getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Long conversionRate) {
        this.conversionRate = conversionRate;
    }

    public BigDecimal getSpPickedQuantity() {
        return spPickedQuantity;
    }

    public void setSpPickedQuantity(BigDecimal spPickedQuantity) {
        this.spPickedQuantity = spPickedQuantity;
    }

    public String getSpqUom() {
        return spqUom;
    }

    public void setSpqUom(String spqUom) {
        this.spqUom = spqUom;
    }

    public Long getParentInventoryItemId() {
        return parentInventoryItemId;
    }

    public void setParentInventoryItemId(Long parentInventoryItemId) {
        this.parentInventoryItemId = parentInventoryItemId;
    }

    public Long getParentSourceShipmentId() {
        return parentSourceShipmentId;
    }

    public void setParentSourceShipmentId(Long parentSourceShipmentId) {
        this.parentSourceShipmentId = parentSourceShipmentId;
    }

    public String getShipmentAdviceStatus() {
        return shipmentAdviceStatus;
    }

    public void setShipmentAdviceStatus(String shipmentAdviceStatus) {
        this.shipmentAdviceStatus = shipmentAdviceStatus;
    }

    public Date getCalcWndWddDate() {
        return calcWndWddDate;
    }

    public void setCalcWndWddDate(Date calcWndWddDate) {
        this.calcWndWddDate = calcWndWddDate;
    }

    public String getSourceLineType() {
        return sourceLineType;
    }

    public void setSourceLineType(String sourceLineType) {
        this.sourceLineType = sourceLineType;
    }

    public Date getDoNotShipBeforeDate() {
        return doNotShipBeforeDate;
    }

    public void setDoNotShipBeforeDate(Date doNotShipBeforeDate) {
        this.doNotShipBeforeDate = doNotShipBeforeDate;
    }

    public Date getDoNotShipAfterDate() {
        return doNotShipAfterDate;
    }

    public void setDoNotShipAfterDate(Date doNotShipAfterDate) {
        this.doNotShipAfterDate = doNotShipAfterDate;
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

    public Long getFinalDischargeLocationId() {
        return finalDischargeLocationId;
    }

    public void setFinalDischargeLocationId(Long finalDischargeLocationId) {
        this.finalDischargeLocationId = finalDischargeLocationId;
    }

    public String getDocumentSubType() {
        return documentSubType;
    }

    public void setDocumentSubType(String documentSubType) {
        this.documentSubType = documentSubType;
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

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public BigDecimal getIntendedUseClassifId() {
        return intendedUseClassifId;
    }

    public void setIntendedUseClassifId(BigDecimal intendedUseClassifId) {
        this.intendedUseClassifId = intendedUseClassifId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getAssessableValue() {
        return assessableValue;
    }

    public void setAssessableValue(BigDecimal assessableValue) {
        this.assessableValue = assessableValue;
    }

    public String getTaxClassificationCode() {
        return taxClassificationCode;
    }

    public void setTaxClassificationCode(String taxClassificationCode) {
        this.taxClassificationCode = taxClassificationCode;
    }

    public String getExemptCertificateNumber() {
        return exemptCertificateNumber;
    }

    public void setExemptCertificateNumber(String exemptCertificateNumber) {
        this.exemptCertificateNumber = exemptCertificateNumber;
    }

    public String getExemptReasonCode() {
        return exemptReasonCode;
    }

    public void setExemptReasonCode(String exemptReasonCode) {
        this.exemptReasonCode = exemptReasonCode;
    }

    public String getShipToLocationType() {
        return shipToLocationType;
    }

    public void setShipToLocationType(String shipToLocationType) {
        this.shipToLocationType = shipToLocationType;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getWmsInterfacedFlag() {
        return wmsInterfacedFlag;
    }

    public void setWmsInterfacedFlag(String wmsInterfacedFlag) {
        this.wmsInterfacedFlag = wmsInterfacedFlag;
    }

    public String getPickedFromSubinventory() {
        return pickedFromSubinventory;
    }

    public void setPickedFromSubinventory(String pickedFromSubinventory) {
        this.pickedFromSubinventory = pickedFromSubinventory;
    }
}
