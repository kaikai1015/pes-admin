package sinexcel.por.domain;

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
 * 管理请购行信息对象 cux_por_requisition_line_all
 * 
 * @author Zhang Kai
 * @date 2021-01-15
 */
public class CuxPorRequisitionLineAll extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long requisitioningId;

    /** 行号 */
    private Integer lineNumber;

    /** 物料编码 */
    private Long inventoryItemId;

    /** 行类型 */
    private Integer lineTypeId;

    /** 库存组织 */
    private Long organizationId;

    /** 类别名称 */
    private Long categoryId;

    /** 单位 */
    private String uomCode;

    /** 单价 */
    private BigDecimal unitPrice;

    /** 请购数量 */
    private BigDecimal quantity;

    /** 需求日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date needByDate;

    /** $column.columnComment */
    private Long poHeaderId;

    /** $column.columnComment */
    private Long poLineId;

    /** 分量计价ID */
    private Long quantityPriceId;

    /** $column.columnComment */
    private Date createDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    private Date lastUpdateDate;

    /** $column.columnComment */
    private Long requisitioningLineId;

    @JsonSerialize(using= ToStringSerializer.class)
    private Long lineNum;
    private String itemType;
    private String buyerName;
    private BigDecimal minOrderQuantity;
    private String itemNumber;
    private String itemDescription;
    private String taxCode;

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }


    public Long getLineNum() {
        return lineNum;
    }

    public void setLineNum(Long lineNum) {
        this.lineNum = lineNum;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public BigDecimal getMinOrderQuantity() {
        return minOrderQuantity;
    }

    public void setMinOrderQuantity(BigDecimal minOrderQuantity) {
        this.minOrderQuantity = minOrderQuantity;
    }

    public void setRequisitioningId(Long requisitioningId) 
    {
        this.requisitioningId = requisitioningId;
    }

    public Long getRequisitioningId() 
    {
        return requisitioningId;
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
    public void setPoLineId(Long poLineId) 
    {
        this.poLineId = poLineId;
    }

    public Long getPoLineId() 
    {
        return poLineId;
    }
    public void setQuantityPriceId(Long quantityPriceId) 
    {
        this.quantityPriceId = quantityPriceId;
    }

    public Long getQuantityPriceId() 
    {
        return quantityPriceId;
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
    public void setRequisitioningLineId(Long requisitioningLineId) 
    {
        this.requisitioningLineId = requisitioningLineId;
    }

    public Long getRequisitioningLineId() 
    {
        return requisitioningLineId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("requisitioningId", getRequisitioningId())
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
            .append("poLineId", getPoLineId())
            .append("quantityPriceId", getQuantityPriceId())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("lastUpdateBy", getLastUpdateBy())
            .append("lastUpdateDate", getLastUpdateDate())
            .append("requisitioningLineId", getRequisitioningLineId())
            .toString();
    }
}
