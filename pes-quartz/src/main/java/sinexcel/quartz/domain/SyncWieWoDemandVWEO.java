package sinexcel.quartz.domain;

import sinexcel.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 工单行信息对象 sync_wie_wo_demand_v
 *
 * @author Zhang Kai
 * @date 2020-12-17
 */
public class SyncWieWoDemandVWEO extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long organizationId;
    private Long workOrderId;
    private Long woOperationMaterialId;
    private Integer materialSeqNumber;
    private Long inventoryItemId;
    private BigDecimal requiredQuantity;
    private BigDecimal issuedQuantity;
    private Date lastUpdateDate;
    private BigDecimal quantityPerProduct;

    public BigDecimal getQuantityPerProduct() {
        return quantityPerProduct;
    }

    public void setQuantityPerProduct(BigDecimal quantityPerProduct) {
        this.quantityPerProduct = quantityPerProduct;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
