package sinexcel.quartz.domain;

import sinexcel.common.core.domain.BaseEntity;

import java.util.Date;

public class SyncPozSuppliersEO extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    private Long vendorId;
    private String segment1;
    private Long partyId;
    private String enabledFlag;
    private String summaryFlag;
    private String vendorTypeLookupCode;
    private Date startDateActive;
    private Date endDateActive;
    private Date lastUpdateDate;
    private String lastUpdatedBy;
    private String partyName;

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getSegment1() {
        return segment1;
    }

    public void setSegment1(String segment1) {
        this.segment1 = segment1;
    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public String getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    public String getSummaryFlag() {
        return summaryFlag;
    }

    public void setSummaryFlag(String summaryFlag) {
        this.summaryFlag = summaryFlag;
    }

    public String getVendorTypeLookupCode() {
        return vendorTypeLookupCode;
    }

    public void setVendorTypeLookupCode(String vendorTypeLookupCode) {
        this.vendorTypeLookupCode = vendorTypeLookupCode;
    }

    public Date getStartDateActive() {
        return startDateActive;
    }

    public void setStartDateActive(Date startDateActive) {
        this.startDateActive = startDateActive;
    }

    public Date getEndDateActive() {
        return endDateActive;
    }

    public void setEndDateActive(Date endDateActive) {
        this.endDateActive = endDateActive;
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
