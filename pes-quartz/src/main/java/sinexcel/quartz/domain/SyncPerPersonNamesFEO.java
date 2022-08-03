package sinexcel.quartz.domain;

import sinexcel.common.core.domain.BaseEntity;

import java.util.Date;

public class SyncPerPersonNamesFEO extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long personNameId;
    private Date effectiveStartDate;
    private Date effectiveEndDate;
    private Long personId;
    private String displayName;
    private Date lastUpdateDate;
    private String lastUpdatedBy;

    public Long getPersonNameId() {
        return personNameId;
    }

    public void setPersonNameId(Long personNameId) {
        this.personNameId = personNameId;
    }

    public Date getEffectiveStartDate() {
        return effectiveStartDate;
    }

    public void setEffectiveStartDate(Date effectiveStartDate) {
        this.effectiveStartDate = effectiveStartDate;
    }

    public Date getEffectiveEndDate() {
        return effectiveEndDate;
    }

    public void setEffectiveEndDate(Date effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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
}
