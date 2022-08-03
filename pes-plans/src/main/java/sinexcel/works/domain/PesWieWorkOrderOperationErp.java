package sinexcel.works.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * pes自定义工单工序数据对象 pes_wie_work_order_operation_erp
 * 
 * @author Zhang Kai
 * @date 2021-11-26
 */
public class PesWieWorkOrderOperationErp
{

    /** $column.columnComment */
    private Long workOrderId;

    /** 工序 */
    private Integer operationSequenceNumber;

    /** $column.columnComment */
    private Long workOrderOperationId;

    /** 代码 */
    private String standardOperationCode;

    /** $column.columnComment */
    private String operationType;

    /** 名称 */
    private String operationName;

    /** $column.columnComment */
    private Long workCenterId;

    /** $column.columnComment */
    private Long pesWorkOrderId;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastUpdateDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    private Long pesWorkOrderOperationId;
    private String createBy;
    private String remark;
    private String erpFlag;
    private String workOrderTypeId;
    private Long ospItemId;
    private Long supplierId;
    private String ospItemNumber;
    private String supplierName;
    private Integer erpType;
    private String requisitionNumber;
    private Integer workCenterCode;
    private Long organizationId;

    public String getSegment1() {
        return segment1;
    }

    public void setSegment1(String segment1) {
        this.segment1 = segment1;
    }

    private String segment1;

    public Long getSupplierSiteId() {
        return supplierSiteId;
    }

    public void setSupplierSiteId(Long supplierSiteId) {
        this.supplierSiteId = supplierSiteId;
    }

    private Long supplierSiteId;

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getRequisitionNumber() {
        return requisitionNumber;
    }

    public void setRequisitionNumber(String requisitionNumber) {
        this.requisitionNumber = requisitionNumber;
    }

    public Integer getWorkCenterCode() {
        return workCenterCode;
    }

    public void setWorkCenterCode(Integer workCenterCode) {
        this.workCenterCode = workCenterCode;
    }

    public Integer getErpType() {
        return erpType;
    }

    public void setErpType(Integer erpType) {
        this.erpType = erpType;
    }

    public String getOspItemNumber() {
        return ospItemNumber;
    }

    public void setOspItemNumber(String ospItemNumber) {
        this.ospItemNumber = ospItemNumber;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
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

    public String getWorkOrderTypeId() {
        return workOrderTypeId;
    }

    public void setWorkOrderTypeId(String workOrderTypeId) {
        this.workOrderTypeId = workOrderTypeId;
    }

    public String getErpFlag() {
        return erpFlag;
    }

    public void setErpFlag(String erpFlag) {
        this.erpFlag = erpFlag;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setWorkOrderId(Long workOrderId) 
    {
        this.workOrderId = workOrderId;
    }

    public Long getWorkOrderId() 
    {
        return workOrderId;
    }
    public void setOperationSequenceNumber(Integer operationSequenceNumber)
    {
        this.operationSequenceNumber = operationSequenceNumber;
    }

    public Integer getOperationSequenceNumber()
    {
        return operationSequenceNumber;
    }
    public void setWorkOrderOperationId(Long workOrderOperationId) 
    {
        this.workOrderOperationId = workOrderOperationId;
    }

    public Long getWorkOrderOperationId() 
    {
        return workOrderOperationId;
    }
    public void setStandardOperationCode(String standardOperationCode) 
    {
        this.standardOperationCode = standardOperationCode;
    }

    public String getStandardOperationCode() 
    {
        return standardOperationCode;
    }
    public void setOperationType(String operationType) 
    {
        this.operationType = operationType;
    }

    public String getOperationType() 
    {
        return operationType;
    }
    public void setOperationName(String operationName) 
    {
        this.operationName = operationName;
    }

    public String getOperationName() 
    {
        return operationName;
    }
    public void setWorkCenterId(Long workCenterId) 
    {
        this.workCenterId = workCenterId;
    }

    public Long getWorkCenterId() 
    {
        return workCenterId;
    }
    public void setPesWorkOrderId(Long pesWorkOrderId) 
    {
        this.pesWorkOrderId = pesWorkOrderId;
    }

    public Long getPesWorkOrderId() 
    {
        return pesWorkOrderId;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setLastUpdateDate(Date lastUpdateDate) 
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastUpdateDate() 
    {
        return lastUpdateDate;
    }
    public void setLastUpdateBy(String lastUpdateBy) 
    {
        this.lastUpdateBy = lastUpdateBy;
    }

    public String getLastUpdateBy() 
    {
        return lastUpdateBy;
    }
    public void setPesWorkOrderOperationId(Long pesWorkOrderOperationId) 
    {
        this.pesWorkOrderOperationId = pesWorkOrderOperationId;
    }

    public Long getPesWorkOrderOperationId() 
    {
        return pesWorkOrderOperationId;
    }
}
