package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 工单工序操作信息对象 sync_wie_wo_operations_b
 *
 * @author Zhang Kai
 * @date 2021-02-24
 */
public class SyncWieWoOperationsBEO {

    private Long woOperationId;
    private Long organizationId;
    private Long workOrderId;
    private String operationType;
    private BigDecimal operationSeqNumber;
    private Long standardOperationId;
    private Long workCenterId;
    private String countPointOperationFlag;
    private String autoTransactFlag;
    private BigDecimal readyQuantity;
    private BigDecimal completedQuantity;
    private BigDecimal scrappedQuantity;
    private BigDecimal rejectedQuantity;
    private Date plannedStartDate;
    private Date plannedCompletionDate;
    private Date actualStartDate;
    private Date actualCompletionDate;
    private String serialTrackingFlag;
    private BigDecimal previousCpOpSeqNum;
    private BigDecimal nextCpOpSeqNum;
    private Long wdOperationId;
    private String shippingDocumentsFlag;
    private Long ospItemId;
    private Long supplierId;
    private Long supplierSiteId;
    private String leadTimeUom;
    private BigDecimal fixedLeadTime;
    private BigDecimal variableLeadTime;
    private BigDecimal inProcessQuantity;
    private BigDecimal poRequestedQuantity;
    private BigDecimal poApprovedQuantity;
    private BigDecimal shippedQuantity;
    private BigDecimal receivedQuantity;
    private BigDecimal overReceiptQuantity;
    private BigDecimal cumulativeScrapQuantity;
    private String createdBy;
    private Date creationDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;
    private String lastUpdateLogin;
    private Integer objectVersionNumber;
    private String attributeCategory;
    private String attributeChar1;
    private String attributeChar2;
    private String attributeChar3;
    private String attributeChar4;
    private String attributeChar5;
    private Long requestId;
    private String operationName;
    private String operationDescription;

    public Long getWoOperationId() {
        return woOperationId;
    }

    public void setWoOperationId(Long woOperationId) {
        this.woOperationId = woOperationId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public BigDecimal getOperationSeqNumber() {
        return operationSeqNumber;
    }

    public void setOperationSeqNumber(BigDecimal operationSeqNumber) {
        this.operationSeqNumber = operationSeqNumber;
    }

    public Long getStandardOperationId() {
        return standardOperationId;
    }

    public void setStandardOperationId(Long standardOperationId) {
        this.standardOperationId = standardOperationId;
    }

    public Long getWorkCenterId() {
        return workCenterId;
    }

    public void setWorkCenterId(Long workCenterId) {
        this.workCenterId = workCenterId;
    }

    public String getCountPointOperationFlag() {
        return countPointOperationFlag;
    }

    public void setCountPointOperationFlag(String countPointOperationFlag) {
        this.countPointOperationFlag = countPointOperationFlag;
    }

    public String getAutoTransactFlag() {
        return autoTransactFlag;
    }

    public void setAutoTransactFlag(String autoTransactFlag) {
        this.autoTransactFlag = autoTransactFlag;
    }

    public BigDecimal getReadyQuantity() {
        return readyQuantity;
    }

    public void setReadyQuantity(BigDecimal readyQuantity) {
        this.readyQuantity = readyQuantity;
    }

    public BigDecimal getCompletedQuantity() {
        return completedQuantity;
    }

    public void setCompletedQuantity(BigDecimal completedQuantity) {
        this.completedQuantity = completedQuantity;
    }

    public BigDecimal getScrappedQuantity() {
        return scrappedQuantity;
    }

    public void setScrappedQuantity(BigDecimal scrappedQuantity) {
        this.scrappedQuantity = scrappedQuantity;
    }

    public BigDecimal getRejectedQuantity() {
        return rejectedQuantity;
    }

    public void setRejectedQuantity(BigDecimal rejectedQuantity) {
        this.rejectedQuantity = rejectedQuantity;
    }

    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public Date getPlannedCompletionDate() {
        return plannedCompletionDate;
    }

    public void setPlannedCompletionDate(Date plannedCompletionDate) {
        this.plannedCompletionDate = plannedCompletionDate;
    }

    public Date getActualStartDate() {
        return actualStartDate;
    }

    public void setActualStartDate(Date actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public Date getActualCompletionDate() {
        return actualCompletionDate;
    }

    public void setActualCompletionDate(Date actualCompletionDate) {
        this.actualCompletionDate = actualCompletionDate;
    }

    public String getSerialTrackingFlag() {
        return serialTrackingFlag;
    }

    public void setSerialTrackingFlag(String serialTrackingFlag) {
        this.serialTrackingFlag = serialTrackingFlag;
    }

    public BigDecimal getPreviousCpOpSeqNum() {
        return previousCpOpSeqNum;
    }

    public void setPreviousCpOpSeqNum(BigDecimal previousCpOpSeqNum) {
        this.previousCpOpSeqNum = previousCpOpSeqNum;
    }

    public BigDecimal getNextCpOpSeqNum() {
        return nextCpOpSeqNum;
    }

    public void setNextCpOpSeqNum(BigDecimal nextCpOpSeqNum) {
        this.nextCpOpSeqNum = nextCpOpSeqNum;
    }

    public Long getWdOperationId() {
        return wdOperationId;
    }

    public void setWdOperationId(Long wdOperationId) {
        this.wdOperationId = wdOperationId;
    }

    public String getShippingDocumentsFlag() {
        return shippingDocumentsFlag;
    }

    public void setShippingDocumentsFlag(String shippingDocumentsFlag) {
        this.shippingDocumentsFlag = shippingDocumentsFlag;
    }

    public Long getOspItemId() {
        return ospItemId;
    }

    public void setOspItemId(Long ospItemId) {
        this.ospItemId = ospItemId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getSupplierSiteId() {
        return supplierSiteId;
    }

    public void setSupplierSiteId(Long supplierSiteId) {
        this.supplierSiteId = supplierSiteId;
    }

    public String getLeadTimeUom() {
        return leadTimeUom;
    }

    public void setLeadTimeUom(String leadTimeUom) {
        this.leadTimeUom = leadTimeUom;
    }

    public BigDecimal getFixedLeadTime() {
        return fixedLeadTime;
    }

    public void setFixedLeadTime(BigDecimal fixedLeadTime) {
        this.fixedLeadTime = fixedLeadTime;
    }

    public BigDecimal getVariableLeadTime() {
        return variableLeadTime;
    }

    public void setVariableLeadTime(BigDecimal variableLeadTime) {
        this.variableLeadTime = variableLeadTime;
    }

    public BigDecimal getInProcessQuantity() {
        return inProcessQuantity;
    }

    public void setInProcessQuantity(BigDecimal inProcessQuantity) {
        this.inProcessQuantity = inProcessQuantity;
    }

    public BigDecimal getPoRequestedQuantity() {
        return poRequestedQuantity;
    }

    public void setPoRequestedQuantity(BigDecimal poRequestedQuantity) {
        this.poRequestedQuantity = poRequestedQuantity;
    }

    public BigDecimal getPoApprovedQuantity() {
        return poApprovedQuantity;
    }

    public void setPoApprovedQuantity(BigDecimal poApprovedQuantity) {
        this.poApprovedQuantity = poApprovedQuantity;
    }

    public BigDecimal getShippedQuantity() {
        return shippedQuantity;
    }

    public void setShippedQuantity(BigDecimal shippedQuantity) {
        this.shippedQuantity = shippedQuantity;
    }

    public BigDecimal getReceivedQuantity() {
        return receivedQuantity;
    }

    public void setReceivedQuantity(BigDecimal receivedQuantity) {
        this.receivedQuantity = receivedQuantity;
    }

    public BigDecimal getOverReceiptQuantity() {
        return overReceiptQuantity;
    }

    public void setOverReceiptQuantity(BigDecimal overReceiptQuantity) {
        this.overReceiptQuantity = overReceiptQuantity;
    }

    public BigDecimal getCumulativeScrapQuantity() {
        return cumulativeScrapQuantity;
    }

    public void setCumulativeScrapQuantity(BigDecimal cumulativeScrapQuantity) {
        this.cumulativeScrapQuantity = cumulativeScrapQuantity;
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

    public String getLastUpdateLogin() {
        return lastUpdateLogin;
    }

    public void setLastUpdateLogin(String lastUpdateLogin) {
        this.lastUpdateLogin = lastUpdateLogin;
    }

    public Integer getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(Integer objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }

    public String getAttributeCategory() {
        return attributeCategory;
    }

    public void setAttributeCategory(String attributeCategory) {
        this.attributeCategory = attributeCategory;
    }

    public String getAttributeChar1() {
        return attributeChar1;
    }

    public void setAttributeChar1(String attributeChar1) {
        this.attributeChar1 = attributeChar1;
    }

    public String getAttributeChar2() {
        return attributeChar2;
    }

    public void setAttributeChar2(String attributeChar2) {
        this.attributeChar2 = attributeChar2;
    }

    public String getAttributeChar3() {
        return attributeChar3;
    }

    public void setAttributeChar3(String attributeChar3) {
        this.attributeChar3 = attributeChar3;
    }

    public String getAttributeChar4() {
        return attributeChar4;
    }

    public void setAttributeChar4(String attributeChar4) {
        this.attributeChar4 = attributeChar4;
    }

    public String getAttributeChar5() {
        return attributeChar5;
    }

    public void setAttributeChar5(String attributeChar5) {
        this.attributeChar5 = attributeChar5;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationDescription() {
        return operationDescription;
    }

    public void setOperationDescription(String operationDescription) {
        this.operationDescription = operationDescription;
    }
}
