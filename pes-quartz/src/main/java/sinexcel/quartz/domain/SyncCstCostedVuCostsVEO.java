package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SyncCstCostedVuCostsVEO {
    private Long inventoryItemId;
    private Long organizationId;
    private Long costElementId;
    private Date snapshotDate;
    private BigDecimal unitCost;
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

    public Long getCostElementId() {
        return costElementId;
    }

    public void setCostElementId(Long costElementId) {
        this.costElementId = costElementId;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public void setSnapshotDate(Date snapshotDate) {
        this.snapshotDate = snapshotDate;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }
}
