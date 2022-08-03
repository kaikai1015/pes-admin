package sinexcel.supplier.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 寻源规则对象 pes_sourcing_item_supplier
 * 
 * @author Zhang Kai
 * @date 2020-12-18
 */
public class PesSourcingItemSupplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long sourcingItemId;

    /**  */
    private Long supplierId;

    /** 物料编码 */
    private String itemNumber;

    /** 库存组织 */
    private Long organizationId;

    /** $column.columnComment */
    private Long inventoryItemId;

    /** 物料描述 */
    private String itemDescription;

    /** 生效日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date effectiveStartDate;

    /** 失效日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date effectiveEndDate;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /** $column.columnComment */
    private Date lastUpdateDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** 供应商名称 */
    private String supplierName;

    /** 供应商编码 */
    private String supplierNumber;

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierNumber(String supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public Long getSourcingItemId() {
        return sourcingItemId;
    }

    public void setSourcingItemId(Long sourcingItemId) {
        this.sourcingItemId = sourcingItemId;
    }

    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }
    public void setItemNumber(String itemNumber) 
    {
        this.itemNumber = itemNumber;
    }

    public String getItemNumber() 
    {
        return itemNumber;
    }
    public void setOrganizationId(Long organizationId) 
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() 
    {
        return organizationId;
    }
    public void setInventoryItemId(Long inventoryItemId) 
    {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getInventoryItemId() 
    {
        return inventoryItemId;
    }
    public void setItemDescription(String itemDescription) 
    {
        this.itemDescription = itemDescription;
    }

    public String getItemDescription() 
    {
        return itemDescription;
    }
    public void setEffectiveStartDate(Date effectiveStartDate) 
    {
        this.effectiveStartDate = effectiveStartDate;
    }

    public Date getEffectiveStartDate() 
    {
        return effectiveStartDate;
    }
    public void setEffectiveEndDate(Date effectiveEndDate) 
    {
        this.effectiveEndDate = effectiveEndDate;
    }

    public Date getEffectiveEndDate() 
    {
        return effectiveEndDate;
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
            .append("itemNumber", getItemNumber())
            .append("organizationId", getOrganizationId())
            .append("inventoryItemId", getInventoryItemId())
            .append("itemDescription", getItemDescription())
            .append("effectiveStartDate", getEffectiveStartDate())
            .append("effectiveEndDate", getEffectiveEndDate())
            .append("createDate", getCreateDate())
            .append("createBy", getCreateBy())
            .append("lastUpdateDate", getLastUpdateDate())
            .append("lastUpdateBy", getLastUpdateBy())
            .toString();
    }
}
