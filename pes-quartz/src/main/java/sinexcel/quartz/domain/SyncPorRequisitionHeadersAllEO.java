package sinexcel.quartz.domain;

import java.util.Date;

public class SyncPorRequisitionHeadersAllEO {
    private Long requisitionHeaderId;
    private String requisitionNumber;
    private Long reqBuId;
    private String description;
    private String documentStatus;
    private Long prcBuId;
    private Date submissionDate;
    private Date approvedDate;
    private String documentSubType;
    private Long soldtoLeId;
    private String fundsStatus;
    private String processStatus;
    private String createdBy;
    private Date creationDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;

    public Long getRequisitionHeaderId() {
        return requisitionHeaderId;
    }

    public void setRequisitionHeaderId(Long requisitionHeaderId) {
        this.requisitionHeaderId = requisitionHeaderId;
    }

    public String getRequisitionNumber() {
        return requisitionNumber;
    }

    public void setRequisitionNumber(String requisitionNumber) {
        this.requisitionNumber = requisitionNumber;
    }

    public Long getReqBuId() {
        return reqBuId;
    }

    public void setReqBuId(Long reqBuId) {
        this.reqBuId = reqBuId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
    }

    public Long getPrcBuId() {
        return prcBuId;
    }

    public void setPrcBuId(Long prcBuId) {
        this.prcBuId = prcBuId;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getDocumentSubType() {
        return documentSubType;
    }

    public void setDocumentSubType(String documentSubType) {
        this.documentSubType = documentSubType;
    }

    public Long getSoldtoLeId() {
        return soldtoLeId;
    }

    public void setSoldtoLeId(Long soldtoLeId) {
        this.soldtoLeId = soldtoLeId;
    }

    public String getFundsStatus() {
        return fundsStatus;
    }

    public void setFundsStatus(String fundsStatus) {
        this.fundsStatus = fundsStatus;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
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
