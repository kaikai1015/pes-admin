package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SyncWorkOrderUpdateQuantityEO {
    private Long organizationId;
    private Long inventoryItemId;
    private Long transactionSourceId;
    private String subinventoryCode;
    private BigDecimal sumTransactionQuantity;
    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

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

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }

    public BigDecimal getSumTransactionQuantity() {
        return sumTransactionQuantity;
    }

    public void setSumTransactionQuantity(BigDecimal sumTransactionQuantity) {
        this.sumTransactionQuantity = sumTransactionQuantity;
    }
}
