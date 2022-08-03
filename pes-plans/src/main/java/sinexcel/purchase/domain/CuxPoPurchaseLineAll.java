package sinexcel.purchase.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 采购行信息对象 cux_po_purchase_line_all
 * 
 * @author Zhang Kai
 * @date 2021-01-25
 */
public class CuxPoPurchaseLineAll extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long poLineId;

    /** 行号 */
    @Excel(name = "行号")
    private Integer lineNumber;

    /** $column.columnComment */
    private Long inventoryItemId;

    /** $column.columnComment */
    private Integer lineTypeId;

    /** 库存组织 */
    @Excel(name = "库存组织")
    private Long organizationId;

    /** 物料类别 */
    @Excel(name = "物料类别")
    private Long categoryId;

    /** 单位 */
    @Excel(name = "单位")
    private String uomCode;

    /** 单位价格 */
    @Excel(name = "单位价格")
    private BigDecimal unitPrice;

    /** 采购数量 */
    @Excel(name = "采购数量")
    private BigDecimal quantity;

    /** 需求日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "需求日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date needByDate;

    /** $column.columnComment */
    private Long poHeaderId;

    /** 计划批次行号 */
    @Excel(name = "计划批次行号")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long lineNum;

    /** 物料类别 */
    @Excel(name = "物料类别")
    private String itemType;

    /** 采购员 */
    @Excel(name = "采购员")
    private String buyerName;

    /** 最小订购量 */
    @Excel(name = "最小订购量")
    private BigDecimal minOrderQuantity;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String itemNumber;

    /** 物料描述 */
    @Excel(name = "物料描述")
    private String itemDescription;

    /** 税分类代码 */
    @Excel(name = "税分类代码")
    private BigDecimal taxCode;

    /** $column.columnComment */
    private Date createDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    private Date lastUpdateDate;

    public void setPoLineId(Long poLineId) 
    {
        this.poLineId = poLineId;
    }

    public Long getPoLineId() 
    {
        return poLineId;
    }
    public void setLineNumber(Integer lineNumber) 
    {
        this.lineNumber = lineNumber;
    }

    public Integer getLineNumber() 
    {
        return lineNumber;
    }
    public void setInventoryItemId(Long inventoryItemId) 
    {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getInventoryItemId() 
    {
        return inventoryItemId;
    }
    public void setLineTypeId(Integer lineTypeId) 
    {
        this.lineTypeId = lineTypeId;
    }

    public Integer getLineTypeId() 
    {
        return lineTypeId;
    }
    public void setOrganizationId(Long organizationId) 
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() 
    {
        return organizationId;
    }
    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }
    public void setUomCode(String uomCode) 
    {
        this.uomCode = uomCode;
    }

    public String getUomCode() 
    {
        return uomCode;
    }
    public void setUnitPrice(BigDecimal unitPrice) 
    {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() 
    {
        return unitPrice;
    }
    public void setQuantity(BigDecimal quantity) 
    {
        this.quantity = quantity;
    }

    public BigDecimal getQuantity() 
    {
        return quantity;
    }
    public void setNeedByDate(Date needByDate) 
    {
        this.needByDate = needByDate;
    }

    public Date getNeedByDate() 
    {
        return needByDate;
    }
    public void setPoHeaderId(Long poHeaderId) 
    {
        this.poHeaderId = poHeaderId;
    }

    public Long getPoHeaderId() 
    {
        return poHeaderId;
    }
    public void setLineNum(Long lineNum) 
    {
        this.lineNum = lineNum;
    }

    public Long getLineNum() 
    {
        return lineNum;
    }
    public void setItemType(String itemType) 
    {
        this.itemType = itemType;
    }

    public String getItemType() 
    {
        return itemType;
    }
    public void setBuyerName(String buyerName) 
    {
        this.buyerName = buyerName;
    }

    public String getBuyerName() 
    {
        return buyerName;
    }
    public void setMinOrderQuantity(BigDecimal minOrderQuantity) 
    {
        this.minOrderQuantity = minOrderQuantity;
    }

    public BigDecimal getMinOrderQuantity() 
    {
        return minOrderQuantity;
    }
    public void setItemNumber(String itemNumber) 
    {
        this.itemNumber = itemNumber;
    }

    public String getItemNumber() 
    {
        return itemNumber;
    }
    public void setItemDescription(String itemDescription) 
    {
        this.itemDescription = itemDescription;
    }

    public String getItemDescription() 
    {
        return itemDescription;
    }
    public void setTaxCode(BigDecimal taxCode) 
    {
        this.taxCode = taxCode;
    }

    public BigDecimal getTaxCode() 
    {
        return taxCode;
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
            .append("poLineId", getPoLineId())
            .append("lineNumber", getLineNumber())
            .append("inventoryItemId", getInventoryItemId())
            .append("lineTypeId", getLineTypeId())
            .append("organizationId", getOrganizationId())
            .append("categoryId", getCategoryId())
            .append("uomCode", getUomCode())
            .append("unitPrice", getUnitPrice())
            .append("quantity", getQuantity())
            .append("needByDate", getNeedByDate())
            .append("poHeaderId", getPoHeaderId())
            .append("lineNum", getLineNum())
            .append("itemType", getItemType())
            .append("buyerName", getBuyerName())
            .append("minOrderQuantity", getMinOrderQuantity())
            .append("itemNumber", getItemNumber())
            .append("itemDescription", getItemDescription())
            .append("taxCode", getTaxCode())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("lastUpdateBy", getLastUpdateBy())
            .append("lastUpdateDate", getLastUpdateDate())
            .toString();
    }
}
