package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SyncPesWorkOrderUpdateMaterialQuantityEO {

    private Long organizationId;
    private Long inventoryItemId;
    private Long transactionSourceId;
    private BigDecimal sumTransactionQuantity;
    private Date createDate;

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getTransactionSourceId() {
        return transactionSourceId;
    }

    public void setTransactionSourceId(Long transactionSourceId) {
        this.transactionSourceId = transactionSourceId;
    }

    public BigDecimal getSumTransactionQuantity() {
        return sumTransactionQuantity;
    }

    public void setSumTransactionQuantity(BigDecimal sumTransactionQuantity) {
        this.sumTransactionQuantity = sumTransactionQuantity;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
