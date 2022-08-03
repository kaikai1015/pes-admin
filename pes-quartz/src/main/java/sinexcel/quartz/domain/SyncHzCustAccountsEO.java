package sinexcel.quartz.domain;

import sinexcel.common.core.domain.BaseEntity;

import java.util.Date;

public class SyncHzCustAccountsEO extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    private Long custAccountId;
    private Long partyId;
    private String accountNumber;
    private String status;
    private String accountName;
    private Date accountEstablishedDate;
    private Date accountTerminationDate;
    private Date lastUpdateDate;
    private String lastUpdatedBy;

    public Long getCustAccountId() {
        return custAccountId;
    }

    public void setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Date getAccountEstablishedDate() {
        return accountEstablishedDate;
    }

    public void setAccountEstablishedDate(Date accountEstablishedDate) {
        this.accountEstablishedDate = accountEstablishedDate;
    }

    public Date getAccountTerminationDate() {
        return accountTerminationDate;
    }

    public void setAccountTerminationDate(Date accountTerminationDate) {
        this.accountTerminationDate = accountTerminationDate;
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
