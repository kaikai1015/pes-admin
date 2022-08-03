package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SyncSWieWoOperaMaterialEO {
    private Long woOperationMaterialId;
    private Long organizationId;
    private Long workOrderId;
    private Integer materialSeqNumber;
    private Long inventoryItemId;
    private BigDecimal quantity;
    private Date requiredDate;
    private BigDecimal issuedQuantity;
    private Long woOperationId;
    private String materialType;
    private BigDecimal quantityPerProduct;
    private String basisType;
    private String uomCode;
    private String includeInPlanningFlag;
    private String supplyType;
    private String supplySubinventory;

    public Long getWoOperationId() {
        return woOperationId;
    }

    public void setWoOperationId(Long woOperationId) {
        this.woOperationId = woOperationId;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public BigDecimal getQuantityPerProduct() {
        return quantityPerProduct;
    }

    public void setQuantityPerProduct(BigDecimal quantityPerProduct) {
        this.quantityPerProduct = quantityPerProduct;
    }

    public String getBasisType() {
        return basisType;
    }

    public void setBasisType(String basisType) {
        this.basisType = basisType;
    }

    public String getUomCode() {
        return uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public String getIncludeInPlanningFlag() {
        return includeInPlanningFlag;
    }

    public void setIncludeInPlanningFlag(String includeInPlanningFlag) {
        this.includeInPlanningFlag = includeInPlanningFlag;
    }

    public String getSupplyType() {
        return supplyType;
    }

    public void setSupplyType(String supplyType) {
        this.supplyType = supplyType;
    }

    public String getSupplySubinventory() {
        return supplySubinventory;
    }

    public void setSupplySubinventory(String supplySubinventory) {
        this.supplySubinventory = supplySubinventory;
    }

    public Long getWoOperationMaterialId() {
        return woOperationMaterialId;
    }

    public void setWoOperationMaterialId(Long woOperationMaterialId) {
        this.woOperationMaterialId = woOperationMaterialId;
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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public BigDecimal getIssuedQuantity() {
        return issuedQuantity;
    }

    public void setIssuedQuantity(BigDecimal issuedQuantity) {
        this.issuedQuantity = issuedQuantity;
    }
}
