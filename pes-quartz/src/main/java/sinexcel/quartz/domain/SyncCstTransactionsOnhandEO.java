package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SyncCstTransactionsOnhandEO {
    private Long inventoryItemId;
    private Long organizationId;
    private Date costDate;
    private BigDecimal quantityOnhand;
    private String subinventoryCode;

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }

    public BigDecimal getQuantityOnhand() {
        return quantityOnhand;
    }

    public void setQuantityOnhand(BigDecimal quantityOnhand) {
        this.quantityOnhand = quantityOnhand;
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

    public Date getCostDate() {
        return costDate;
    }

    public void setCostDate(Date costDate) {
        this.costDate = costDate;
    }
}
