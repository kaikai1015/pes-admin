package sinexcel.quartz.domain;

import java.util.Date;

public class SyncWisWorkDefinionNameBEO {
    private Long workDefinitionNameId;
    private String workDefinitionCode;
    private String workDefinitionType;
    private String seededFlag;
    private String usedInPlanningFlag;
    private Date effectiveFromDate;
    private Date effectiveToDate;
    private Date lastUpdateDate;
    private String lastUpdatedBy;
    private Date creationDate;
    private String createdBy;
    private String workDefName;
    private String workDefNameDescription;

    public Long getWorkDefinitionNameId() {
        return workDefinitionNameId;
    }

    public void setWorkDefinitionNameId(Long workDefinitionNameId) {
        this.workDefinitionNameId = workDefinitionNameId;
    }

    public String getWorkDefinitionCode() {
        return workDefinitionCode;
    }

    public void setWorkDefinitionCode(String workDefinitionCode) {
        this.workDefinitionCode = workDefinitionCode;
    }

    public String getWorkDefinitionType() {
        return workDefinitionType;
    }

    public void setWorkDefinitionType(String workDefinitionType) {
        this.workDefinitionType = workDefinitionType;
    }

    public String getSeededFlag() {
        return seededFlag;
    }

    public void setSeededFlag(String seededFlag) {
        this.seededFlag = seededFlag;
    }

    public String getUsedInPlanningFlag() {
        return usedInPlanningFlag;
    }

    public void setUsedInPlanningFlag(String usedInPlanningFlag) {
        this.usedInPlanningFlag = usedInPlanningFlag;
    }

    public Date getEffectiveFromDate() {
        return effectiveFromDate;
    }

    public void setEffectiveFromDate(Date effectiveFromDate) {
        this.effectiveFromDate = effectiveFromDate;
    }

    public Date getEffectiveToDate() {
        return effectiveToDate;
    }

    public void setEffectiveToDate(Date effectiveToDate) {
        this.effectiveToDate = effectiveToDate;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getWorkDefName() {
        return workDefName;
    }

    public void setWorkDefName(String workDefName) {
        this.workDefName = workDefName;
    }

    public String getWorkDefNameDescription() {
        return workDefNameDescription;
    }

    public void setWorkDefNameDescription(String workDefNameDescription) {
        this.workDefNameDescription = workDefNameDescription;
    }
}
