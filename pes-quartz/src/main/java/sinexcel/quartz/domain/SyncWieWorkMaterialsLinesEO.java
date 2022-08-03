package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 工单替代料数据对象 sync_wie_work_materials_lines
 *
 * @author Zhang Kai
 * @date 2021-08-03
 */
public class SyncWieWorkMaterialsLinesEO {

    private Long organizationId;
    private Long workOrderId;
    private Long woOperationId;
    private Long woOperationMaterialId;
    private Integer materialSeqNumber;
    private Long inventoryItemId;
    private Date requiredDate;
    private BigDecimal quantityPerProduct;
    private BigDecimal requiredQuantity;

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

    public Long getWoOperationId() {
        return woOperationId;
    }

    public void setWoOperationId(Long woOperationId) {
        this.woOperationId = woOperationId;
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
}
