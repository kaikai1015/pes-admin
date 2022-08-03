package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SyncInvOnhandQuantityNewCodeEO {

    private Long inventoryItemId;

    private Long organizationId;

    private BigDecimal quantity;

    private String subinventoryCode;
    private Long statusId;
    private Date minDateReceived;

    public Date getMinDateReceived() {
        return minDateReceived;
    }

    public void setMinDateReceived(Date minDateReceived) {
        this.minDateReceived = minDateReceived;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }
}
