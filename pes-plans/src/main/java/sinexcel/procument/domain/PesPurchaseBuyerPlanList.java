package sinexcel.procument.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 维护采购计划对象 pes_purchase_buyer_plan_list
 * 
 * @author Zhang Kai
 * @date 2020-12-15
 */
public class PesPurchaseBuyerPlanList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 计划批次行号 */
    private Long lineNum;

    /** 组织ID */
    private Long organizationId;

    /** 物料ID */
    private Long inventoryItemId;

    /** 物料编码 */
    private String itemNumber;

    /** 物料描述 */
    private String itemDescription;

    /** 物料类型 */
    private String itemType;

    /** 采购员 */
    private String buyerName;

    /** 单位 */
    private String uom;

    /** 计划采购数量 */
    private BigDecimal planPoQuantity;

    /** 计划入库日期 */
    private BigDecimal planRcvtDate;

    /** 计划采购日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date planPoDate;

    /** 最小订购量 */
    private BigDecimal minOrderQuantity;

    private String lastUpdateBy;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date grossDate;

    /** 毛需求数量 */
    private BigDecimal grossQuantity;

    private Long supplierId;

    private Long requisitioningId;

    private String taxCode;

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public Long getRequisitioningId() {
        return requisitioningId;
    }

    public void setRequisitioningId(Long requisitioningId) {
        this.requisitioningId = requisitioningId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Date getGrossDate() {
        return grossDate;
    }

    public void setGrossDate(Date grossDate) {
        this.grossDate = grossDate;
    }

    public BigDecimal getGrossQuantity() {
        return grossQuantity;
    }

    public void setGrossQuantity(BigDecimal grossQuantity) {
        this.grossQuantity = grossQuantity;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public void setLineNum(Long lineNum) 
    {
        this.lineNum = lineNum;
    }

    public Long getLineNum() 
    {
        return lineNum;
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
    public void setUom(String uom) 
    {
        this.uom = uom;
    }

    public String getUom() 
    {
        return uom;
    }
    public void setPlanPoQuantity(BigDecimal planPoQuantity) 
    {
        this.planPoQuantity = planPoQuantity;
    }

    public BigDecimal getPlanPoQuantity() 
    {
        return planPoQuantity;
    }
    public void setPlanRcvtDate(BigDecimal planRcvtDate) 
    {
        this.planRcvtDate = planRcvtDate;
    }

    public BigDecimal getPlanRcvtDate() 
    {
        return planRcvtDate;
    }
    public void setPlanPoDate(Date planPoDate) 
    {
        this.planPoDate = planPoDate;
    }

    public Date getPlanPoDate() 
    {
        return planPoDate;
    }
    public void setMinOrderQuantity(BigDecimal minOrderQuantity) 
    {
        this.minOrderQuantity = minOrderQuantity;
    }

    public BigDecimal getMinOrderQuantity() 
    {
        return minOrderQuantity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("lineNum", getLineNum())
            .append("organizationId", getOrganizationId())
            .append("inventoryItemId", getInventoryItemId())
            .append("itemNumber", getItemNumber())
            .append("itemDescription", getItemDescription())
            .append("itemType", getItemType())
            .append("buyerName", getBuyerName())
            .append("uom", getUom())
            .append("planPoQuantity", getPlanPoQuantity())
            .append("planRcvtDate", getPlanRcvtDate())
            .append("planPoDate", getPlanPoDate())
            .append("minOrderQuantity", getMinOrderQuantity())
            .toString();
    }
}
