package sinexcel.quartz.domain;

import sinexcel.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * PO头信息对象 sync_po_headers_all
 *
 * @author Zhang Kai
 * @date 2020-12-21
 */
public class SyncPoHeadersAllEO extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long prcBuId;
    private Long poHeaderId;
    private String segment1;
    private String typeLookupCode;
    private String documentStatus;
    private Long vendorId;
    private Long agentId;
    private String comments;
    private Date lastUpdateDate;
    private Long soldtoLeId;
    private Date creationDate;

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getSoldtoLeId() {
        return soldtoLeId;
    }

    public void setSoldtoLeId(Long soldtoLeId) {
        this.soldtoLeId = soldtoLeId;
    }

    public Long getPrcBuId() {
        return prcBuId;
    }

    public void setPrcBuId(Long prcBuId) {
        this.prcBuId = prcBuId;
    }

    public Long getPoHeaderId() {
        return poHeaderId;
    }

    public void setPoHeaderId(Long poHeaderId) {
        this.poHeaderId = poHeaderId;
    }

    public String getSegment1() {
        return segment1;
    }

    public void setSegment1(String segment1) {
        this.segment1 = segment1;
    }

    public String getTypeLookupCode() {
        return typeLookupCode;
    }

    public void setTypeLookupCode(String typeLookupCode) {
        this.typeLookupCode = typeLookupCode;
    }

    public String getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
