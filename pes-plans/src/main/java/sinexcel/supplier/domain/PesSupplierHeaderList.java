package sinexcel.supplier.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 供应商基础信息对象 pes_supplier_header_list
 * 
 * @author Zhang Kai
 * @date 2020-12-17
 */
public class PesSupplierHeaderList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 供应商ID */
    private Long supplierId;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 供应商编码 */
    @Excel(name = "供应商编码")
    private String supplierNumber;

    /** 商业关系 */
    @Excel(name = "商业关系")
    private String businessRelationship;

    /** 税务类型 */
    @Excel(name = "税务类型")
    private String taxOrganizationType;

    /** 税务国家 */
    @Excel(name = "税务国家")
    private String taxCountry;

    /** 企业税码 */
    @Excel(name = "企业税码")
    private String taxRegistrationNumber;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /** $column.columnComment */
    private Date lastUpdateDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "失效时间")
    private Date inactiveDate;

    @Excel(name = "默认采购员")
    private String buyerName;

    @Excel(name = "供应商类型")
    private String supplierType;

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(String supplierType) {
        this.supplierType = supplierType;
    }

    public Date getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(Date inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }
    public void setSupplierNumber(String supplierNumber) 
    {
        this.supplierNumber = supplierNumber;
    }

    public String getSupplierNumber() 
    {
        return supplierNumber;
    }
    public void setBusinessRelationship(String businessRelationship) 
    {
        this.businessRelationship = businessRelationship;
    }

    public String getBusinessRelationship() 
    {
        return businessRelationship;
    }
    public void setTaxOrganizationType(String taxOrganizationType) 
    {
        this.taxOrganizationType = taxOrganizationType;
    }

    public String getTaxOrganizationType() 
    {
        return taxOrganizationType;
    }
    public void setTaxCountry(String taxCountry) 
    {
        this.taxCountry = taxCountry;
    }

    public String getTaxCountry() 
    {
        return taxCountry;
    }
    public void setTaxRegistrationNumber(String taxRegistrationNumber) 
    {
        this.taxRegistrationNumber = taxRegistrationNumber;
    }

    public String getTaxRegistrationNumber() 
    {
        return taxRegistrationNumber;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("supplierId", getSupplierId())
            .append("supplierName", getSupplierName())
            .append("supplierNumber", getSupplierNumber())
            .append("businessRelationship", getBusinessRelationship())
            .append("taxOrganizationType", getTaxOrganizationType())
            .append("taxCountry", getTaxCountry())
            .append("taxRegistrationNumber", getTaxRegistrationNumber())
            .append("createDate", getCreateDate())
            .append("createBy", getCreateBy())
            .append("lastUpdateDate", getLastUpdateDate())
            .append("lastUpdateBy", getLastUpdateBy())
            .toString();
    }
}
