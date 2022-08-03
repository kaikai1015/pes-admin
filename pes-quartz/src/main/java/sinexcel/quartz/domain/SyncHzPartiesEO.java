package sinexcel.quartz.domain;

import sinexcel.common.core.domain.BaseEntity;

import java.util.Date;

public class SyncHzPartiesEO extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    private Long partyId;
    private String partyNumber;
    private String partyName;
    private String partyType;
    private String partyUniqueName;
    private String lastUpdatedBy;
    private Date lastUpdateDate;
    private String comments;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public String getPartyNumber() {
        return partyNumber;
    }

    public void setPartyNumber(String partyNumber) {
        this.partyNumber = partyNumber;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getPartyType() {
        return partyType;
    }

    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

    public String getPartyUniqueName() {
        return partyUniqueName;
    }

    public void setPartyUniqueName(String partyUniqueName) {
        this.partyUniqueName = partyUniqueName;
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
