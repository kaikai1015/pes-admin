package sinexcel.quartz.domain;

import sinexcel.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class SyncInvSecondaryInventoriesEO  extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    private String secondaryInventoryName;
    private Long organizationId;
    private Date lastUpdateDate;
    private String lastUpdatedBy;
    private String description;
    private Date disableDate;
    private Integer inventoryAtpCode;
    private Integer availabilityType;
    private Integer reservableType;
    private String locatorType;
    private BigDecimal pickingOrder;
    private Integer quantityTracked;
    private Long subinventoryId;
    private Integer assetInventory;
    private String fillKillToLookup;
    private Long locationId;
    private String pickUomCode;
    private Integer depreciableFlag;
    private Long statusId;
    private String subinventoryType;
    private Integer planningLevel;
    private String defaultCountTypeCode;
    private String countMethod;

    public String getSecondaryInventoryName() {
        return secondaryInventoryName;
    }

    public void setSecondaryInventoryName(String secondaryInventoryName) {
        this.secondaryInventoryName = secondaryInventoryName;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDisableDate() {
        return disableDate;
    }

    public void setDisableDate(Date disableDate) {
        this.disableDate = disableDate;
    }

    public Integer getInventoryAtpCode() {
        return inventoryAtpCode;
    }

    public void setInventoryAtpCode(Integer inventoryAtpCode) {
        this.inventoryAtpCode = inventoryAtpCode;
    }

    public Integer getAvailabilityType() {
        return availabilityType;
    }

    public void setAvailabilityType(Integer availabilityType) {
        this.availabilityType = availabilityType;
    }

    public Integer getReservableType() {
        return reservableType;
    }

    public void setReservableType(Integer reservableType) {
        this.reservableType = reservableType;
    }

    public String getLocatorType() {
        return locatorType;
    }

    public void setLocatorType(String locatorType) {
        this.locatorType = locatorType;
    }

    public BigDecimal getPickingOrder() {
        return pickingOrder;
    }

    public void setPickingOrder(BigDecimal pickingOrder) {
        this.pickingOrder = pickingOrder;
    }

    public Integer getQuantityTracked() {
        return quantityTracked;
    }

    public void setQuantityTracked(Integer quantityTracked) {
        this.quantityTracked = quantityTracked;
    }

    public Long getSubinventoryId() {
        return subinventoryId;
    }

    public void setSubinventoryId(Long subinventoryId) {
        this.subinventoryId = subinventoryId;
    }

    public Integer getAssetInventory() {
        return assetInventory;
    }

    public void setAssetInventory(Integer assetInventory) {
        this.assetInventory = assetInventory;
    }

    public String getFillKillToLookup() {
        return fillKillToLookup;
    }

    public void setFillKillToLookup(String fillKillToLookup) {
        this.fillKillToLookup = fillKillToLookup;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getPickUomCode() {
        return pickUomCode;
    }

    public void setPickUomCode(String pickUomCode) {
        this.pickUomCode = pickUomCode;
    }

    public Integer getDepreciableFlag() {
        return depreciableFlag;
    }

    public void setDepreciableFlag(Integer depreciableFlag) {
        this.depreciableFlag = depreciableFlag;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getSubinventoryType() {
        return subinventoryType;
    }

    public void setSubinventoryType(String subinventoryType) {
        this.subinventoryType = subinventoryType;
    }

    public Integer getPlanningLevel() {
        return planningLevel;
    }

    public void setPlanningLevel(Integer planningLevel) {
        this.planningLevel = planningLevel;
    }

    public String getDefaultCountTypeCode() {
        return defaultCountTypeCode;
    }

    public void setDefaultCountTypeCode(String defaultCountTypeCode) {
        this.defaultCountTypeCode = defaultCountTypeCode;
    }

    public String getCountMethod() {
        return countMethod;
    }

    public void setCountMethod(String countMethod) {
        this.countMethod = countMethod;
    }
}
