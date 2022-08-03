package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SyncPorRequisitionLinesAllEO {

    private Long requisitionLineId;
    private Long requisitionHeaderId;
    private Date needByDate;
    private Long poHeaderId;
    private Long poLineId;
    private String lineStatus;
    private Date lastSubmittedDate;
    private Date lastApprovalDate;
    private String createdBy;
    private Date creationDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;
    private String workOrderProduct;
    private String workOrderNumber;
    private Long workOrderId;
    private Integer workOrderOperationSeq;
    private Long workOrderOperationId;
    private Integer lineNumber;
    private Long lineTypeId;
    private Long categoryId;
    private String itemDescription;
    private String uomCode;
    private BigDecimal unitPrice;
    private BigDecimal quantity;
    private Long itemId;
    private Long vendorId;

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Long getLineTypeId() {
        return lineTypeId;
    }

    public void setLineTypeId(Long lineTypeId) {
        this.lineTypeId = lineTypeId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getUomCode() {
        return uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getRequisitionLineId() {
        return requisitionLineId;
    }

    public void setRequisitionLineId(Long requisitionLineId) {
        this.requisitionLineId = requisitionLineId;
    }

    public Long getRequisitionHeaderId() {
        return requisitionHeaderId;
    }

    public void setRequisitionHeaderId(Long requisitionHeaderId) {
        this.requisitionHeaderId = requisitionHeaderId;
    }

    public Date getNeedByDate() {
        return needByDate;
    }

    public void setNeedByDate(Date needByDate) {
        this.needByDate = needByDate;
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

    public String getLineStatus() {
        return lineStatus;
    }

    public void setLineStatus(String lineStatus) {
        this.lineStatus = lineStatus;
    }

    public Date getLastSubmittedDate() {
        return lastSubmittedDate;
    }

    public void setLastSubmittedDate(Date lastSubmittedDate) {
        this.lastSubmittedDate = lastSubmittedDate;
    }

    public Date getLastApprovalDate() {
        return lastApprovalDate;
    }

    public void setLastApprovalDate(Date lastApprovalDate) {
        this.lastApprovalDate = lastApprovalDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getWorkOrderProduct() {
        return workOrderProduct;
    }

    public void setWorkOrderProduct(String workOrderProduct) {
        this.workOrderProduct = workOrderProduct;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Integer getWorkOrderOperationSeq() {
        return workOrderOperationSeq;
    }

    public void setWorkOrderOperationSeq(Integer workOrderOperationSeq) {
        this.workOrderOperationSeq = workOrderOperationSeq;
    }

    public Long getWorkOrderOperationId() {
        return workOrderOperationId;
    }

    public void setWorkOrderOperationId(Long workOrderOperationId) {
        this.workOrderOperationId = workOrderOperationId;
    }
}
