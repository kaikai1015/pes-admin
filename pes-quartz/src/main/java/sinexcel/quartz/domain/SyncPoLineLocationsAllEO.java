package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SyncPoLineLocationsAllEO {
    private Long lineLocationId;
    private Long prcBuId;
    private String inputTaxClassificationCode;
    private Date lastUpdateDate;
    private String lastUpdatedBy;
    private Long poHeaderId;
    private Long poLineId;
    private Date creationDate;
    private String createdBy;
    private BigDecimal quantity;
    private BigDecimal quantityReceived;
    private BigDecimal quantityAccepted;
    private BigDecimal quantityRejected;
    private BigDecimal quantityBilled;
    private BigDecimal quantityCancelled;
    private String uomCode;
    private Long shipToLocationId;
    private Date needByDate;
    private String cancelFlag;
    private String cancelledBy;
    private Date cancelDate;
    private String cancelReason;
    private String inspectionRequiredFlag;
    private Long shipToOrganizationId;
    private BigDecimal quantityShipped;
    private BigDecimal priceOverride;
    private Long workOrderId;
    private String workOrderNumber;
    private String scheduleStatus;

    public String getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(String scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

    public Long getLineLocationId() {
        return lineLocationId;
    }

    public void setLineLocationId(Long lineLocationId) {
        this.lineLocationId = lineLocationId;
    }

    public Long getPrcBuId() {
        return prcBuId;
    }

    public void setPrcBuId(Long prcBuId) {
        this.prcBuId = prcBuId;
    }

    public String getInputTaxClassificationCode() {
        return inputTaxClassificationCode;
    }

    public void setInputTaxClassificationCode(String inputTaxClassificationCode) {
        this.inputTaxClassificationCode = inputTaxClassificationCode;
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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getQuantityReceived() {
        return quantityReceived;
    }

    public void setQuantityReceived(BigDecimal quantityReceived) {
        this.quantityReceived = quantityReceived;
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

    public BigDecimal getQuantityBilled() {
        return quantityBilled;
    }

    public void setQuantityBilled(BigDecimal quantityBilled) {
        this.quantityBilled = quantityBilled;
    }

    public BigDecimal getQuantityCancelled() {
        return quantityCancelled;
    }

    public void setQuantityCancelled(BigDecimal quantityCancelled) {
        this.quantityCancelled = quantityCancelled;
    }

    public String getUomCode() {
        return uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public Long getShipToLocationId() {
        return shipToLocationId;
    }

    public void setShipToLocationId(Long shipToLocationId) {
        this.shipToLocationId = shipToLocationId;
    }

    public Date getNeedByDate() {
        return needByDate;
    }

    public void setNeedByDate(Date needByDate) {
        this.needByDate = needByDate;
    }

    public String getCancelFlag() {
        return cancelFlag;
    }

    public void setCancelFlag(String cancelFlag) {
        this.cancelFlag = cancelFlag;
    }

    public String getCancelledBy() {
        return cancelledBy;
    }

    public void setCancelledBy(String cancelledBy) {
        this.cancelledBy = cancelledBy;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getInspectionRequiredFlag() {
        return inspectionRequiredFlag;
    }

    public void setInspectionRequiredFlag(String inspectionRequiredFlag) {
        this.inspectionRequiredFlag = inspectionRequiredFlag;
    }

    public Long getShipToOrganizationId() {
        return shipToOrganizationId;
    }

    public void setShipToOrganizationId(Long shipToOrganizationId) {
        this.shipToOrganizationId = shipToOrganizationId;
    }

    public BigDecimal getQuantityShipped() {
        return quantityShipped;
    }

    public void setQuantityShipped(BigDecimal quantityShipped) {
        this.quantityShipped = quantityShipped;
    }

    public BigDecimal getPriceOverride() {
        return priceOverride;
    }

    public void setPriceOverride(BigDecimal priceOverride) {
        this.priceOverride = priceOverride;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }
}
