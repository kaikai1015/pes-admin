package sinexcel.quartz.domain;

import java.math.BigDecimal;

public class CuxUpdateItemDataEO {

    private Long inventoryItemId;
    private Long organizationId;
    private String wipSupplySubinventory;
    private String startUpdateDate;
    private String endUpdateDate;
    private String buyerName;
    private BigDecimal usageRateF;
    private BigDecimal usageRateS;
    private String itemNumber;
    private String itemType;

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public BigDecimal getUsageRateF() {
        return usageRateF;
    }

    public void setUsageRateF(BigDecimal usageRateF) {
        this.usageRateF = usageRateF;
    }

    public BigDecimal getUsageRateS() {
        return usageRateS;
    }

    public void setUsageRateS(BigDecimal usageRateS) {
        this.usageRateS = usageRateS;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }


    public String getStartUpdateDate() {
        return startUpdateDate;
    }

    public void setStartUpdateDate(String startUpdateDate) {
        this.startUpdateDate = startUpdateDate;
    }

    public String getEndUpdateDate() {
        return endUpdateDate;
    }

    public void setEndUpdateDate(String endUpdateDate) {
        this.endUpdateDate = endUpdateDate;
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

    public String getWipSupplySubinventory() {
        return wipSupplySubinventory;
    }

    public void setWipSupplySubinventory(String wipSupplySubinventory) {
        this.wipSupplySubinventory = wipSupplySubinventory;
    }
}
