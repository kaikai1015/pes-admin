package sinexcel.por.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 管理请购单对象 cux_por_requisition_header_all
 * 
 * @author Zhang Kai
 * @date 2020-12-30
 */
public class CuxPorRequisitionHeaderAll extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** BU */
    private Long requisitioningBuId;

    /** 请购单号 */
    private String requisitioningNumber;

    /** 请购单ID */
    private Long requisitioningId;

    /** 请购员 */
    private String requisitioningBuyer;

    /** 状态 */
    private String status;

    /** 供应商 */
    private Long supplierId;

    /** 请购单描述 */
    private String requisitioningDescription;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /** 最后更新人 */
    private String lastUpdateBy;

    /** 最后更新时间 */
    private Date lastUpdateDate;

    private String supplierNumber;

    private String supplierName;

    private String requisitioningBuName;

    private String statusCode;

    private String currencyCode;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getRequisitioningBuName() {
        return requisitioningBuName;
    }

    public void setRequisitioningBuName(String requisitioningBuName) {
        this.requisitioningBuName = requisitioningBuName;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierNumber(String supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setRequisitioningBuId(Long requisitioningBuId)
    {
        this.requisitioningBuId = requisitioningBuId;
    }

    public Long getRequisitioningBuId() 
    {
        return requisitioningBuId;
    }
    public void setRequisitioningNumber(String requisitioningNumber) 
    {
        this.requisitioningNumber = requisitioningNumber;
    }

    public String getRequisitioningNumber() 
    {
        return requisitioningNumber;
    }
    public void setRequisitioningId(Long requisitioningId) 
    {
        this.requisitioningId = requisitioningId;
    }

    public Long getRequisitioningId() 
    {
        return requisitioningId;
    }
    public void setRequisitioningBuyer(String requisitioningBuyer) 
    {
        this.requisitioningBuyer = requisitioningBuyer;
    }

    public String getRequisitioningBuyer() 
    {
        return requisitioningBuyer;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }
    public void setRequisitioningDescription(String requisitioningDescription) 
    {
        this.requisitioningDescription = requisitioningDescription;
    }

    public String getRequisitioningDescription() 
    {
        return requisitioningDescription;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setLastUpdateBy(String lastUpdateBy) 
    {
        this.lastUpdateBy = lastUpdateBy;
    }

    public String getLastUpdateBy() 
    {
        return lastUpdateBy;
    }
    public void setLastUpdateDate(Date lastUpdateDate) 
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastUpdateDate() 
    {
        return lastUpdateDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("requisitioningBuId", getRequisitioningBuId())
            .append("requisitioningNumber", getRequisitioningNumber())
            .append("requisitioningId", getRequisitioningId())
            .append("requisitioningBuyer", getRequisitioningBuyer())
            .append("status", getStatus())
            .append("supplierId", getSupplierId())
            .append("supplierNumber", getSupplierNumber())
            .append("supplierName", getSupplierName())
            .append("requisitioningDescription", getRequisitioningDescription())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("lastUpdateBy", getLastUpdateBy())
            .append("lastUpdateDate", getLastUpdateDate())
            .toString();
    }
}
