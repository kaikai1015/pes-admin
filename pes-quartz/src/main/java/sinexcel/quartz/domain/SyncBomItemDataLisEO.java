package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SyncBomItemDataLisEO {
    private Long organizationId;
    private Long inventoryItemId;
    private Long pInventoryItemId;
    private BigDecimal component_quantity;
    private Long componentSequenceId;
    private Date disableDate;
    private Date implementationDate;

    public Date getDisableDate() {
        return disableDate;
    }

    public void setDisableDate(Date disableDate) {
        this.disableDate = disableDate;
    }

    public Date getImplementationDate() {
        return implementationDate;
    }

    public void setImplementationDate(Date implementationDate) {
        this.implementationDate = implementationDate;
    }

    public Long getComponentSequenceId() {
        return componentSequenceId;
    }

    public void setComponentSequenceId(Long componentSequenceId) {
        this.componentSequenceId = componentSequenceId;
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

    public Long getpInventoryItemId() {
        return pInventoryItemId;
    }

    public void setpInventoryItemId(Long pInventoryItemId) {
        this.pInventoryItemId = pInventoryItemId;
    }

    public BigDecimal getComponent_quantity() {
        return component_quantity;
    }

    public void setComponent_quantity(BigDecimal component_quantity) {
        this.component_quantity = component_quantity;
    }
}
