package sinexcel.quartz.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigDecimal;
import java.util.Date;

public class SyncRcvShipmentLinesEO {

    private Long shipmentLineId;
    private Date lastUpdateDate;
    private String lastUpdatedBy;
    private Date creationDate;
    private String createdBy;
    private Long shipmentHeaderId;
    private Long lineNum;
    private Long categoryId;
    private BigDecimal quantityShipped;
    private BigDecimal quantityReceived;
    private BigDecimal quantityDelivered;
    private BigDecimal quantityReturned;
    private BigDecimal quantityAccepted;
    private BigDecimal quantityRejected;
    private String uomCode;
    private String itemDescription;
    private Long itemId;
    private String shipmentLineStatusCode;
    private String sourceDocumentCode;
    private Long poHeaderId;
    private Long poLineId;
    private Long poLineLocationId;
    private Long poDistributionId;
    private Long routingHeaderId;
    private String packingSlip;
    private Long fromOrganizationId;
    private Long deliverToPersonId;
    private Long employeeId;
    private String destinationTypeCode;
    private Long toOrganizationId;
    private String toSubinventory;
    private Long locatorId;
    private Long deliverToLocationId;
    private BigDecimal shipmentUnitPrice;
    private BigDecimal transferCost;
    private BigDecimal transportationCost;
    private String comments;
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;
    private String primaryUomCode;
    private Long shipToLocationId;
    private String receiptAdviceLineNumber;
    private String raDocumentLineNumber;
    private String raDooHeaderNumber;
    private String raDooLineNumber;
    private String raDooFulfillmentLineNumber;
    private String raDocScheduleNumber;
    private Date raDocLineCreationDate;
    private Date raDocLineLastUpdateDate;
    private Date raExpectedReceiptDate;
    private BigDecimal raDaysEarlyReceiptAllowed;
    private BigDecimal raDaysLateReceiptAllowed;
    private String raReceiptDaysExceptionCode;
    private String raEnforceShipToLocCode;
    private String raAllowSubstituteReceipt;
    private BigDecimal raQtyRcvTolerance;
    private String raQtyRcvExceptionCode;
    private String raNoteToReceiver;
    private Long receiptAdviceHeaderId;
    private Long receiptAdviceLineId;
    private String raOrigDooHeaderNumber;
    private String raOrigDooLineNumber;
    private String raOrigOcHeaderNumber;
    private String raOrigOcLineNumber;
    private String raOrigDooFulfilLineNum;
    private Long customerId;
    private Long customerSiteId;
    private BigDecimal raQuantityExpected;
    private BigDecimal raSecondaryQuantityExpected;
    private BigDecimal raUnitPrice;
    private BigDecimal spQuantity;
    private String spUomCode;
    private Long spGroupId;
    private String raLastActionCode;
    private BigDecimal raMessageNumber;
    private Long interfaceTransactionId;
    private Long transferOrderHeaderId;
    private Long transferOrderLineId;
    private String consignedFlag;
    private Long firstPtyRegId;
    private Long thirdPtyRegId;
    private String defaultTaxationCountry;
    private String documentFiscalClassification;
    private String trxBusinessCategory;
    private String taxInvoiceNumber;
    private Date taxInvoiceDate;
    private Long shipFromLocationId;
    private String userDefinedFiscClass;
    private String taxClassificationCode;
    private String productType;

    public Long getShipmentLineId() {
        return shipmentLineId;
    }

    public void setShipmentLineId(Long shipmentLineId) {
        this.shipmentLineId = shipmentLineId;
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

    public Long getShipmentHeaderId() {
        return shipmentHeaderId;
    }

    public void setShipmentHeaderId(Long shipmentHeaderId) {
        this.shipmentHeaderId = shipmentHeaderId;
    }

    public Long getLineNum() {
        return lineNum;
    }

    public void setLineNum(Long lineNum) {
        this.lineNum = lineNum;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getQuantityShipped() {
        return quantityShipped;
    }

    public void setQuantityShipped(BigDecimal quantityShipped) {
        this.quantityShipped = quantityShipped;
    }

    public BigDecimal getQuantityReceived() {
        return quantityReceived;
    }

    public void setQuantityReceived(BigDecimal quantityReceived) {
        this.quantityReceived = quantityReceived;
    }

    public BigDecimal getQuantityDelivered() {
        return quantityDelivered;
    }

    public void setQuantityDelivered(BigDecimal quantityDelivered) {
        this.quantityDelivered = quantityDelivered;
    }

    public BigDecimal getQuantityReturned() {
        return quantityReturned;
    }

    public void setQuantityReturned(BigDecimal quantityReturned) {
        this.quantityReturned = quantityReturned;
    }

    public BigDecimal getQuantityAccepted() {
        return quantityAccepted;
    }

    public void setQuantityAccepted(BigDecimal quantityAccepted) {
        this.quantityAccepted = quantityAccepted;
    }

    public BigDecimal getQuantityRejected() {
        return quantityRejected;
    }

    public void setQuantityRejected(BigDecimal quantityRejected) {
        this.quantityRejected = quantityRejected;
    }

    public String getUomCode() {
        return uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getShipmentLineStatusCode() {
        return shipmentLineStatusCode;
    }

    public void setShipmentLineStatusCode(String shipmentLineStatusCode) {
        this.shipmentLineStatusCode = shipmentLineStatusCode;
    }

    public String getSourceDocumentCode() {
        return sourceDocumentCode;
    }

    public void setSourceDocumentCode(String sourceDocumentCode) {
        this.sourceDocumentCode = sourceDocumentCode;
    }

    public Long getPoHeaderId() {
        return poHeaderId;
    }

    public void setPoHeaderId(Long poHeaderId) {
        this.poHeaderId = poHeaderId;
    }

    public Long getPoLineId() {
        return poLineId;
    }

    public void setPoLineId(Long poLineId) {
        this.poLineId = poLineId;
    }

    public Long getPoLineLocationId() {
        return poLineLocationId;
    }

    public void setPoLineLocationId(Long poLineLocationId) {
        this.poLineLocationId = poLineLocationId;
    }

    public Long getPoDistributionId() {
        return poDistributionId;
    }

    public void setPoDistributionId(Long poDistributionId) {
        this.poDistributionId = poDistributionId;
    }

    public Long getRoutingHeaderId() {
        return routingHeaderId;
    }

    public void setRoutingHeaderId(Long routingHeaderId) {
        this.routingHeaderId = routingHeaderId;
    }

    public String getPackingSlip() {
        return packingSlip;
    }

    public void setPackingSlip(String packingSlip) {
        this.packingSlip = packingSlip;
    }

    public Long getFromOrganizationId() {
        return fromOrganizationId;
    }

    public void setFromOrganizationId(Long fromOrganizationId) {
        this.fromOrganizationId = fromOrganizationId;
    }

    public Long getDeliverToPersonId() {
        return deliverToPersonId;
    }

    public void setDeliverToPersonId(Long deliverToPersonId) {
        this.deliverToPersonId = deliverToPersonId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getDestinationTypeCode() {
        return destinationTypeCode;
    }

    public void setDestinationTypeCode(String destinationTypeCode) {
        this.destinationTypeCode = destinationTypeCode;
    }

    public Long getToOrganizationId() {
        return toOrganizationId;
    }

    public void setToOrganizationId(Long toOrganizationId) {
        this.toOrganizationId = toOrganizationId;
    }

    public String getToSubinventory() {
        return toSubinventory;
    }

    public void setToSubinventory(String toSubinventory) {
        this.toSubinventory = toSubinventory;
    }

    public Long getLocatorId() {
        return locatorId;
    }

    public void setLocatorId(Long locatorId) {
        this.locatorId = locatorId;
    }

    public Long getDeliverToLocationId() {
        return deliverToLocationId;
    }

    public void setDeliverToLocationId(Long deliverToLocationId) {
        this.deliverToLocationId = deliverToLocationId;
    }

    public BigDecimal getShipmentUnitPrice() {
        return shipmentUnitPrice;
    }

    public void setShipmentUnitPrice(BigDecimal shipmentUnitPrice) {
        this.shipmentUnitPrice = shipmentUnitPrice;
    }

    public BigDecimal getTransferCost() {
        return transferCost;
    }

    public void setTransferCost(BigDecimal transferCost) {
        this.transferCost = transferCost;
    }

    public BigDecimal getTransportationCost() {
        return transportationCost;
    }

    public void setTransportationCost(BigDecimal transportationCost) {
        this.transportationCost = transportationCost;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public String getPrimaryUomCode() {
        return primaryUomCode;
    }

    public void setPrimaryUomCode(String primaryUomCode) {
        this.primaryUomCode = primaryUomCode;
    }

    public Long getShipToLocationId() {
        return shipToLocationId;
    }

    public void setShipToLocationId(Long shipToLocationId) {
        this.shipToLocationId = shipToLocationId;
    }

    public String getReceiptAdviceLineNumber() {
        return receiptAdviceLineNumber;
    }

    public void setReceiptAdviceLineNumber(String receiptAdviceLineNumber) {
        this.receiptAdviceLineNumber = receiptAdviceLineNumber;
    }

    public String getRaDocumentLineNumber() {
        return raDocumentLineNumber;
    }

    public void setRaDocumentLineNumber(String raDocumentLineNumber) {
        this.raDocumentLineNumber = raDocumentLineNumber;
    }

    public String getRaDooHeaderNumber() {
        return raDooHeaderNumber;
    }

    public void setRaDooHeaderNumber(String raDooHeaderNumber) {
        this.raDooHeaderNumber = raDooHeaderNumber;
    }

    public String getRaDooLineNumber() {
        return raDooLineNumber;
    }

    public void setRaDooLineNumber(String raDooLineNumber) {
        this.raDooLineNumber = raDooLineNumber;
    }

    public String getRaDooFulfillmentLineNumber() {
        return raDooFulfillmentLineNumber;
    }

    public void setRaDooFulfillmentLineNumber(String raDooFulfillmentLineNumber) {
        this.raDooFulfillmentLineNumber = raDooFulfillmentLineNumber;
    }

    public String getRaDocScheduleNumber() {
        return raDocScheduleNumber;
    }

    public void setRaDocScheduleNumber(String raDocScheduleNumber) {
        this.raDocScheduleNumber = raDocScheduleNumber;
    }

    public Date getRaDocLineCreationDate() {
        return raDocLineCreationDate;
    }

    public void setRaDocLineCreationDate(Date raDocLineCreationDate) {
        this.raDocLineCreationDate = raDocLineCreationDate;
    }

    public Date getRaDocLineLastUpdateDate() {
        return raDocLineLastUpdateDate;
    }

    public void setRaDocLineLastUpdateDate(Date raDocLineLastUpdateDate) {
        this.raDocLineLastUpdateDate = raDocLineLastUpdateDate;
    }

    public Date getRaExpectedReceiptDate() {
        return raExpectedReceiptDate;
    }

    public void setRaExpectedReceiptDate(Date raExpectedReceiptDate) {
        this.raExpectedReceiptDate = raExpectedReceiptDate;
    }

    public BigDecimal getRaDaysEarlyReceiptAllowed() {
        return raDaysEarlyReceiptAllowed;
    }

    public void setRaDaysEarlyReceiptAllowed(BigDecimal raDaysEarlyReceiptAllowed) {
        this.raDaysEarlyReceiptAllowed = raDaysEarlyReceiptAllowed;
    }

    public BigDecimal getRaDaysLateReceiptAllowed() {
        return raDaysLateReceiptAllowed;
    }

    public void setRaDaysLateReceiptAllowed(BigDecimal raDaysLateReceiptAllowed) {
        this.raDaysLateReceiptAllowed = raDaysLateReceiptAllowed;
    }

    public String getRaReceiptDaysExceptionCode() {
        return raReceiptDaysExceptionCode;
    }

    public void setRaReceiptDaysExceptionCode(String raReceiptDaysExceptionCode) {
        this.raReceiptDaysExceptionCode = raReceiptDaysExceptionCode;
    }

    public String getRaEnforceShipToLocCode() {
        return raEnforceShipToLocCode;
    }

    public void setRaEnforceShipToLocCode(String raEnforceShipToLocCode) {
        this.raEnforceShipToLocCode = raEnforceShipToLocCode;
    }

    public String getRaAllowSubstituteReceipt() {
        return raAllowSubstituteReceipt;
    }

    public void setRaAllowSubstituteReceipt(String raAllowSubstituteReceipt) {
        this.raAllowSubstituteReceipt = raAllowSubstituteReceipt;
    }

    public BigDecimal getRaQtyRcvTolerance() {
        return raQtyRcvTolerance;
    }

    public void setRaQtyRcvTolerance(BigDecimal raQtyRcvTolerance) {
        this.raQtyRcvTolerance = raQtyRcvTolerance;
    }

    public String getRaQtyRcvExceptionCode() {
        return raQtyRcvExceptionCode;
    }

    public void setRaQtyRcvExceptionCode(String raQtyRcvExceptionCode) {
        this.raQtyRcvExceptionCode = raQtyRcvExceptionCode;
    }

    public String getRaNoteToReceiver() {
        return raNoteToReceiver;
    }

    public void setRaNoteToReceiver(String raNoteToReceiver) {
        this.raNoteToReceiver = raNoteToReceiver;
    }

    public Long getReceiptAdviceHeaderId() {
        return receiptAdviceHeaderId;
    }

    public void setReceiptAdviceHeaderId(Long receiptAdviceHeaderId) {
        this.receiptAdviceHeaderId = receiptAdviceHeaderId;
    }

    public Long getReceiptAdviceLineId() {
        return receiptAdviceLineId;
    }

    public void setReceiptAdviceLineId(Long receiptAdviceLineId) {
        this.receiptAdviceLineId = receiptAdviceLineId;
    }

    public String getRaOrigDooHeaderNumber() {
        return raOrigDooHeaderNumber;
    }

    public void setRaOrigDooHeaderNumber(String raOrigDooHeaderNumber) {
        this.raOrigDooHeaderNumber = raOrigDooHeaderNumber;
    }

    public String getRaOrigDooLineNumber() {
        return raOrigDooLineNumber;
    }

    public void setRaOrigDooLineNumber(String raOrigDooLineNumber) {
        this.raOrigDooLineNumber = raOrigDooLineNumber;
    }

    public String getRaOrigOcHeaderNumber() {
        return raOrigOcHeaderNumber;
    }

    public void setRaOrigOcHeaderNumber(String raOrigOcHeaderNumber) {
        this.raOrigOcHeaderNumber = raOrigOcHeaderNumber;
    }

    public String getRaOrigOcLineNumber() {
        return raOrigOcLineNumber;
    }

    public void setRaOrigOcLineNumber(String raOrigOcLineNumber) {
        this.raOrigOcLineNumber = raOrigOcLineNumber;
    }

    public String getRaOrigDooFulfilLineNum() {
        return raOrigDooFulfilLineNum;
    }

    public void setRaOrigDooFulfilLineNum(String raOrigDooFulfilLineNum) {
        this.raOrigDooFulfilLineNum = raOrigDooFulfilLineNum;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerSiteId() {
        return customerSiteId;
    }

    public void setCustomerSiteId(Long customerSiteId) {
        this.customerSiteId = customerSiteId;
    }

    public BigDecimal getRaQuantityExpected() {
        return raQuantityExpected;
    }

    public void setRaQuantityExpected(BigDecimal raQuantityExpected) {
        this.raQuantityExpected = raQuantityExpected;
    }

    public BigDecimal getRaSecondaryQuantityExpected() {
        return raSecondaryQuantityExpected;
    }

    public void setRaSecondaryQuantityExpected(BigDecimal raSecondaryQuantityExpected) {
        this.raSecondaryQuantityExpected = raSecondaryQuantityExpected;
    }

    public BigDecimal getRaUnitPrice() {
        return raUnitPrice;
    }

    public void setRaUnitPrice(BigDecimal raUnitPrice) {
        this.raUnitPrice = raUnitPrice;
    }

    public BigDecimal getSpQuantity() {
        return spQuantity;
    }

    public void setSpQuantity(BigDecimal spQuantity) {
        this.spQuantity = spQuantity;
    }

    public String getSpUomCode() {
        return spUomCode;
    }

    public void setSpUomCode(String spUomCode) {
        this.spUomCode = spUomCode;
    }

    public Long getSpGroupId() {
        return spGroupId;
    }

    public void setSpGroupId(Long spGroupId) {
        this.spGroupId = spGroupId;
    }

    public String getRaLastActionCode() {
        return raLastActionCode;
    }

    public void setRaLastActionCode(String raLastActionCode) {
        this.raLastActionCode = raLastActionCode;
    }

    public BigDecimal getRaMessageNumber() {
        return raMessageNumber;
    }

    public void setRaMessageNumber(BigDecimal raMessageNumber) {
        this.raMessageNumber = raMessageNumber;
    }

    public Long getInterfaceTransactionId() {
        return interfaceTransactionId;
    }

    public void setInterfaceTransactionId(Long interfaceTransactionId) {
        this.interfaceTransactionId = interfaceTransactionId;
    }

    public Long getTransferOrderHeaderId() {
        return transferOrderHeaderId;
    }

    public void setTransferOrderHeaderId(Long transferOrderHeaderId) {
        this.transferOrderHeaderId = transferOrderHeaderId;
    }

    public Long getTransferOrderLineId() {
        return transferOrderLineId;
    }

    public void setTransferOrderLineId(Long transferOrderLineId) {
        this.transferOrderLineId = transferOrderLineId;
    }

    public String getConsignedFlag() {
        return consignedFlag;
    }

    public void setConsignedFlag(String consignedFlag) {
        this.consignedFlag = consignedFlag;
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

    public String getDefaultTaxationCountry() {
        return defaultTaxationCountry;
    }

    public void setDefaultTaxationCountry(String defaultTaxationCountry) {
        this.defaultTaxationCountry = defaultTaxationCountry;
    }

    public String getDocumentFiscalClassification() {
        return documentFiscalClassification;
    }

    public void setDocumentFiscalClassification(String documentFiscalClassification) {
        this.documentFiscalClassification = documentFiscalClassification;
    }

    public String getTrxBusinessCategory() {
        return trxBusinessCategory;
    }

    public void setTrxBusinessCategory(String trxBusinessCategory) {
        this.trxBusinessCategory = trxBusinessCategory;
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

    public Long getShipFromLocationId() {
        return shipFromLocationId;
    }

    public void setShipFromLocationId(Long shipFromLocationId) {
        this.shipFromLocationId = shipFromLocationId;
    }

    public String getUserDefinedFiscClass() {
        return userDefinedFiscClass;
    }

    public void setUserDefinedFiscClass(String userDefinedFiscClass) {
        this.userDefinedFiscClass = userDefinedFiscClass;
    }

    public String getTaxClassificationCode() {
        return taxClassificationCode;
    }

    public void setTaxClassificationCode(String taxClassificationCode) {
        this.taxClassificationCode = taxClassificationCode;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
