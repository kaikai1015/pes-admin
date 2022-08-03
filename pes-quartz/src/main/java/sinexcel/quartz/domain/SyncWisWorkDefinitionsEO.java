package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SyncWisWorkDefinitionsEO {
    private Long workDefinitionId;
    private String workDefinitionType;
    private Long workMethodId;
    private Long organizationId;
    private Long inventoryItemId;
    private Long transformFromItemId;
    private Long workDefinitionNameId;
    private Long wdMntNameId;
    private String statusCode;
    private Date inactiveDate;
    private String workDefinitionHeaderName;
    private BigDecimal productionPriority;
    private BigDecimal costingPriority;
    private String serialTrackingFlag;
    private Long billSequenceId;
    private BigDecimal quantity;
    private String uomCode;
    private String systemGeneratedFlag;
    private String createdBy;
    private Date creationDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;

    public Long getWorkDefinitionId() {
        return workDefinitionId;
    }

    public void setWorkDefinitionId(Long workDefinitionId) {
        this.workDefinitionId = workDefinitionId;
    }

    public String getWorkDefinitionType() {
        return workDefinitionType;
    }

    public void setWorkDefinitionType(String workDefinitionType) {
        this.workDefinitionType = workDefinitionType;
    }

    public Long getWorkMethodId() {
        return workMethodId;
    }

    public void setWorkMethodId(Long workMethodId) {
        this.workMethodId = workMethodId;
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

    public Long getTransformFromItemId() {
        return transformFromItemId;
    }

    public void setTransformFromItemId(Long transformFromItemId) {
        this.transformFromItemId = transformFromItemId;
    }

    public Long getWorkDefinitionNameId() {
        return workDefinitionNameId;
    }

    public void setWorkDefinitionNameId(Long workDefinitionNameId) {
        this.workDefinitionNameId = workDefinitionNameId;
    }

    public Long getWdMntNameId() {
        return wdMntNameId;
    }

    public void setWdMntNameId(Long wdMntNameId) {
        this.wdMntNameId = wdMntNameId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Date getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(Date inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public String getWorkDefinitionHeaderName() {
        return workDefinitionHeaderName;
    }

    public void setWorkDefinitionHeaderName(String workDefinitionHeaderName) {
        this.workDefinitionHeaderName = workDefinitionHeaderName;
    }

    public BigDecimal getProductionPriority() {
        return productionPriority;
    }

    public void setProductionPriority(BigDecimal productionPriority) {
        this.productionPriority = productionPriority;
    }

    public BigDecimal getCostingPriority() {
        return costingPriority;
    }

    public void setCostingPriority(BigDecimal costingPriority) {
        this.costingPriority = costingPriority;
    }

    public String getSerialTrackingFlag() {
        return serialTrackingFlag;
    }

    public void setSerialTrackingFlag(String serialTrackingFlag) {
        this.serialTrackingFlag = serialTrackingFlag;
    }

    public Long getBillSequenceId() {
        return billSequenceId;
    }

    public void setBillSequenceId(Long billSequenceId) {
        this.billSequenceId = billSequenceId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getUomCode() {
        return uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public String getSystemGeneratedFlag() {
        return systemGeneratedFlag;
    }

    public void setSystemGeneratedFlag(String systemGeneratedFlag) {
        this.systemGeneratedFlag = systemGeneratedFlag;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
