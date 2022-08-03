package sinexcel.quartz.domain;

import sinexcel.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class SyncDooLinesAllEO  extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    private Long headerId;
    private Long lineId;
    private Integer lineNumber;
    private String statusCode;
    private Long ownerId;
    private Date creationDate;
    private String createdBy;
    private Date lastUpdateDate;
    private String lastUpdatedBy;
    private String lastUpdateLogin;
    private String sourceLineId;
    private String sourceLineNumber;
    private String sourceOrderId;
    private String sourceOrderNumber;
    private String sourceOrderSystem;
    private String sourceScheduleId;
    private String sourceScheduleNumber;
    private Long sourceRevisionNumber;
    private String itemTypeCode;
    private BigDecimal orderedQty;
    private BigDecimal canceledQty;
    private String orderedUom;
    private Long sourceOrgId;
    private Long orgId;
    private Date actualShipDate;
    private Date scheduleShipDate;
    private BigDecimal rmaDeliveredQty;
    private BigDecimal extendedAmount;
    private BigDecimal fulfilledQty;
    private Date fulfillmentDate;
    private String lineTypeCode;
    private Integer objectVersionNumber;
    private String openFlag;
    private String canceledFlag;
    private Long inventoryItemId;
    private String compSeqPath;
    private Long parentLineId;
    private String origSysDocumentRef;
    private String origSysDocumentLineRef;
    private Long rootParentLineId;
    private BigDecimal shippedQty;
    private BigDecimal unitListPrice;
    private BigDecimal unitSellingPrice;
    private Long deltaType;
    private Long referenceLineId;
    private String onHold;
    private Long inventoryOrganizationId;
    private String categoryCode;
    private Long transformFromLineId;
    private String itemSubTypeCode;
    private BigDecimal quantityPerModel;
    private String modifiedFlag;
    private String displayLineNumber;
    private String createdInRelease;
    private Date requestShipDate;

    public Date getRequestShipDate() {
        return requestShipDate;
    }

    public void setRequestShipDate(Date requestShipDate) {
        this.requestShipDate = requestShipDate;
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

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
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

    public Date getActualShipDate() {
        return actualShipDate;
    }

    public void setActualShipDate(Date actualShipDate) {
        this.actualShipDate = actualShipDate;
    }

    public Date getScheduleShipDate() {
        return scheduleShipDate;
    }

    public void setScheduleShipDate(Date scheduleShipDate) {
        this.scheduleShipDate = scheduleShipDate;
    }

    public BigDecimal getRmaDeliveredQty() {
        return rmaDeliveredQty;
    }

    public void setRmaDeliveredQty(BigDecimal rmaDeliveredQty) {
        this.rmaDeliveredQty = rmaDeliveredQty;
    }

    public BigDecimal getExtendedAmount() {
        return extendedAmount;
    }

    public void setExtendedAmount(BigDecimal extendedAmount) {
        this.extendedAmount = extendedAmount;
    }

    public BigDecimal getFulfilledQty() {
        return fulfilledQty;
    }

    public void setFulfilledQty(BigDecimal fulfilledQty) {
        this.fulfilledQty = fulfilledQty;
    }

    public Date getFulfillmentDate() {
        return fulfillmentDate;
    }

    public void setFulfillmentDate(Date fulfillmentDate) {
        this.fulfillmentDate = fulfillmentDate;
    }

    public String getLineTypeCode() {
        return lineTypeCode;
    }

    public void setLineTypeCode(String lineTypeCode) {
        this.lineTypeCode = lineTypeCode;
    }

    public Integer getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(Integer objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
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

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public String getCompSeqPath() {
        return compSeqPath;
    }

    public void setCompSeqPath(String compSeqPath) {
        this.compSeqPath = compSeqPath;
    }

    public Long getParentLineId() {
        return parentLineId;
    }

    public void setParentLineId(Long parentLineId) {
        this.parentLineId = parentLineId;
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

    public Long getRootParentLineId() {
        return rootParentLineId;
    }

    public void setRootParentLineId(Long rootParentLineId) {
        this.rootParentLineId = rootParentLineId;
    }

    public BigDecimal getShippedQty() {
        return shippedQty;
    }

    public void setShippedQty(BigDecimal shippedQty) {
        this.shippedQty = shippedQty;
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

    public Long getDeltaType() {
        return deltaType;
    }

    public void setDeltaType(Long deltaType) {
        this.deltaType = deltaType;
    }

    public Long getReferenceLineId() {
        return referenceLineId;
    }

    public void setReferenceLineId(Long referenceLineId) {
        this.referenceLineId = referenceLineId;
    }

    public String getOnHold() {
        return onHold;
    }

    public void setOnHold(String onHold) {
        this.onHold = onHold;
    }

    public Long getInventoryOrganizationId() {
        return inventoryOrganizationId;
    }

    public void setInventoryOrganizationId(Long inventoryOrganizationId) {
        this.inventoryOrganizationId = inventoryOrganizationId;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Long getTransformFromLineId() {
        return transformFromLineId;
    }

    public void setTransformFromLineId(Long transformFromLineId) {
        this.transformFromLineId = transformFromLineId;
    }

    public String getItemSubTypeCode() {
        return itemSubTypeCode;
    }

    public void setItemSubTypeCode(String itemSubTypeCode) {
        this.itemSubTypeCode = itemSubTypeCode;
    }

    public BigDecimal getQuantityPerModel() {
        return quantityPerModel;
    }

    public void setQuantityPerModel(BigDecimal quantityPerModel) {
        this.quantityPerModel = quantityPerModel;
    }

    public String getModifiedFlag() {
        return modifiedFlag;
    }

    public void setModifiedFlag(String modifiedFlag) {
        this.modifiedFlag = modifiedFlag;
    }

    public String getDisplayLineNumber() {
        return displayLineNumber;
    }

    public void setDisplayLineNumber(String displayLineNumber) {
        this.displayLineNumber = displayLineNumber;
    }

    public String getCreatedInRelease() {
        return createdInRelease;
    }

    public void setCreatedInRelease(String createdInRelease) {
        this.createdInRelease = createdInRelease;
    }
}
