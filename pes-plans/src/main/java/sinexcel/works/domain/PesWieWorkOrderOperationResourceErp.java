package sinexcel.works.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * PES工单资源工时对象 pes_wie_work_order_operation_resource_erp
 *
 * @author Zhang Kai
 * @date 2021-12-27
 */
public class PesWieWorkOrderOperationResourceErp
{

    private Long pesWorkOrderId;
    private Long pesWorkOrderOperationId;
    private BigDecimal usageRate;
    private Integer assignedUnits;
    private Date createDate;
    private String createBy;
    private Date lastUpdateDate;
    private String lastUpdateBy;
    private Date erpSubmitDate;
    private Long workOrderOperationResourceId;
    private Integer resourceRequenceNumber;
    private String resourceCode;
    private String resourceName;
    private Long pesWorkOrderOperationResourceId;
    private BigDecimal usageRateF;
    private Integer assignedUnitsF;
    private BigDecimal usageRateS;
    private Integer assignedUnitsS;
    private Long workOrderId;
    private Long workOrderOperationId;
    private Integer erpType;
    private String remark;
    private String erpFlag;
    private String workOrderTypeId;
    private Long workOrderStatusId;

    public String getWorkOrderTypeId() {
        return workOrderTypeId;
    }

    public void setWorkOrderTypeId(String workOrderTypeId) {
        this.workOrderTypeId = workOrderTypeId;
    }

    public Long getWorkOrderStatusId() {
        return workOrderStatusId;
    }

    public void setWorkOrderStatusId(Long workOrderStatusId) {
        this.workOrderStatusId = workOrderStatusId;
    }

    public String getErpFlag() {
        return erpFlag;
    }

    public void setErpFlag(String erpFlag) {
        this.erpFlag = erpFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getErpType() {
        return erpType;
    }

    public void setErpType(Integer erpType) {
        this.erpType = erpType;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Long getWorkOrderOperationId() {
        return workOrderOperationId;
    }

    public void setWorkOrderOperationId(Long workOrderOperationId) {
        this.workOrderOperationId = workOrderOperationId;
    }

    public Long getPesWorkOrderId() {
        return pesWorkOrderId;
    }

    public void setPesWorkOrderId(Long pesWorkOrderId) {
        this.pesWorkOrderId = pesWorkOrderId;
    }

    public Long getPesWorkOrderOperationId() {
        return pesWorkOrderOperationId;
    }

    public void setPesWorkOrderOperationId(Long pesWorkOrderOperationId) {
        this.pesWorkOrderOperationId = pesWorkOrderOperationId;
    }

    public BigDecimal getUsageRate() {
        return usageRate;
    }

    public void setUsageRate(BigDecimal usageRate) {
        this.usageRate = usageRate;
    }

    public Integer getAssignedUnits() {
        return assignedUnits;
    }

    public void setAssignedUnits(Integer assignedUnits) {
        this.assignedUnits = assignedUnits;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getErpSubmitDate() {
        return erpSubmitDate;
    }

    public void setErpSubmitDate(Date erpSubmitDate) {
        this.erpSubmitDate = erpSubmitDate;
    }

    public Long getWorkOrderOperationResourceId() {
        return workOrderOperationResourceId;
    }

    public void setWorkOrderOperationResourceId(Long workOrderOperationResourceId) {
        this.workOrderOperationResourceId = workOrderOperationResourceId;
    }

    public Integer getResourceRequenceNumber() {
        return resourceRequenceNumber;
    }

    public void setResourceRequenceNumber(Integer resourceRequenceNumber) {
        this.resourceRequenceNumber = resourceRequenceNumber;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Long getPesWorkOrderOperationResourceId() {
        return pesWorkOrderOperationResourceId;
    }

    public void setPesWorkOrderOperationResourceId(Long pesWorkOrderOperationResourceId) {
        this.pesWorkOrderOperationResourceId = pesWorkOrderOperationResourceId;
    }

    public BigDecimal getUsageRateF() {
        return usageRateF;
    }

    public void setUsageRateF(BigDecimal usageRateF) {
        this.usageRateF = usageRateF;
    }

    public Integer getAssignedUnitsF() {
        return assignedUnitsF;
    }

    public void setAssignedUnitsF(Integer assignedUnitsF) {
        this.assignedUnitsF = assignedUnitsF;
    }

    public BigDecimal getUsageRateS() {
        return usageRateS;
    }

    public void setUsageRateS(BigDecimal usageRateS) {
        this.usageRateS = usageRateS;
    }

    public Integer getAssignedUnitsS() {
        return assignedUnitsS;
    }

    public void setAssignedUnitsS(Integer assignedUnitsS) {
        this.assignedUnitsS = assignedUnitsS;
    }
}