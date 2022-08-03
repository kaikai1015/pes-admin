package sinexcel.quartz.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import sinexcel.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 工单行信息对象 sync_wie_wo_demand_v
 *
 * @author Zhang Kai
 * @date 2020-12-17
 */
public class SyncWieWoDemandVEO extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long organizationId;
    private Long workOrderId;
    private Long woOperationMaterialId;
    private String operationName;
    private Integer materialSeqNumber;
    private Long inventoryItemId;
    private Date requiredDate;
    private BigDecimal quantityPerProduct;
    private BigDecimal requiredQuantity;
    private BigDecimal issuedQuantity;
    private String uomCode;
    private BigDecimal transactionQuantity;
    private String subinventoryCode;
    private String basisType;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate;
    private String lastUpdatedBy;
    private Integer workOrderStatusId;

    public Integer getWorkOrderStatusId() {
        return workOrderStatusId;
    }

    public void setWorkOrderStatusId(Integer workOrderStatusId) {
        this.workOrderStatusId = workOrderStatusId;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getBasisType() {
        return basisType;
    }

    public void setBasisType(String basisType) {
        this.basisType = basisType;
    }

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }

    public BigDecimal getTransactionQuantity() {
        return transactionQuantity;
    }

    public void setTransactionQuantity(BigDecimal transactionQuantity) {
        this.transactionQuantity = transactionQuantity;
    }

    public String getUomCode() {
        return uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Long getWoOperationMaterialId() {
        return woOperationMaterialId;
    }

    public void setWoOperationMaterialId(Long woOperationMaterialId) {
        this.woOperationMaterialId = woOperationMaterialId;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public Integer getMaterialSeqNumber() {
        return materialSeqNumber;
    }

    public void setMaterialSeqNumber(Integer materialSeqNumber) {
        this.materialSeqNumber = materialSeqNumber;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public BigDecimal getQuantityPerProduct() {
        return quantityPerProduct;
    }

    public void setQuantityPerProduct(BigDecimal quantityPerProduct) {
        this.quantityPerProduct = quantityPerProduct;
    }

    public BigDecimal getRequiredQuantity() {
        return requiredQuantity;
    }

    public void setRequiredQuantity(BigDecimal requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
    }

    public BigDecimal getIssuedQuantity() {
        return issuedQuantity;
    }

    public void setIssuedQuantity(BigDecimal issuedQuantity) {
        this.issuedQuantity = issuedQuantity;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
