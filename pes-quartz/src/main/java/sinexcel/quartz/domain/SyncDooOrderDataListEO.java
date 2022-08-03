package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * MRP计算计划员查看订单信息对象 sync_doo_order_data_list
 *
 * @author Zhang Kai
 * @date 2021-12-26
 */
public class SyncDooOrderDataListEO extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 业务实体 */
    @Excel(name = "业务实体",width = 10)
    private String buName;

    /** 客户名称 */
    @Excel(name = "客户名称",width = 30)
    private String partyName;

    /** 客户对应销售员 */
    @Excel(name = "客户对应销售员",width = 15)
    private String salsesName;

    /** 客户对应销售员助理 */
    @Excel(name = "客户对应销售员助理",width = 15)
    private String agentSale;

    /** 订单销售员 */
    @Excel(name = "订单销售员",width = 15)
    private String orderSalsesName;

    /** 订单销售助理 */
    @Excel(name = "订单销售助理",width = 15)
    private String orderSalsesNameAgent;

    /** 创建人 */
    @Excel(name = "创建人",width = 10)
    private String createdBy;

    /** 客户编号 */
    @Excel(name = "客户编号",width = 10)
    private String accountNumber;

    /** 合同号 */
    @Excel(name = "合同号",width = 15)
    private String customerPoNumber;

    /** 销售订单号 */
    @Excel(name = "销售订单号",width = 10)
    private String orderNumber;

    /** 销售订单类型 */
    @Excel(name = "销售订单类型",width = 15)
    private String orderType;

    /** 产品线 */
    @Excel(name = "产品线",width = 15)
    private String prodLines;

    /** 订单变更分类 */
    @Excel(name = "订单变更分类",width = 15)
    private String orderChangType;

    /** 订单变更原因 */
    @Excel(name = "订单变更原因",width = 15)
    private String orderChangReason;

    /** 协议编号 */
    @Excel(name = "协议编号",width = 15)
    private String xieYiNumber;

    /** 销售订单行号 */
    @Excel(name = "销售订单行号",width = 10)
    private Integer lineNumber;

    /** 来源订单号 */
    @Excel(name = "来源订单号",width = 10)
    private String sourceOrderNumber;

    /** 来源订单行号 */
    @Excel(name = "来源订单行号",width = 10)
    private String sourceLineNumber;

    /** display订单行号 */
    @Excel(name = "display订单行号",width = 10)
    private String displayLineNumber;

    /** 物料编码 */
    @Excel(name = "物料编码",width = 15)
    private String itemNumber;

    /** 物料描述 */
    @Excel(name = "物料描述",width = 40)
    private String description;

    /** 物料类别 */
    @Excel(name = "物料类别",width = 20)
    private String erpCategory;

    /** 产品类别 */
    @Excel(name = "产品类别",width = 20)
    private String prodCategory;

    /** 订单数量 */
    @Excel(name = "订单数量",width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal orderedQty;

    /** 未销货数量 */
    @Excel(name = "未销货数量",width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal diffQuantity;

    /** 币种 */
    @Excel(name = "币种",width = 10)
    private String transactionalCurrencyCode;

    /** 含税单价 */
    @Excel(name = "含税单价",width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal unitListPrice;
    @Excel(name = "总金额",width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal extendedAmount;
    /** 税分类 */
    @Excel(name = "税分类",width = 15)
    private String taxClassificationCode;
    @Excel(name = "税率",width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal taxCode;

    /** 汇率 */
    @Excel(name = "汇率",width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal conversionRate;

    @Excel(name = "不含税单价",width = 15, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal untaxUnitListPrice;
    @Excel(name = "不含税金额",width = 15, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal untaxExtendedAmount;
    @Excel(name = "税额",width = 15, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal taxAmount;
    @Excel(name = "未销货原币金额(不含税)",width = 15, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal untaxDiffQuantityAmount;
    @Excel(name = "未销货本币金额(不含税)",width = 15, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal untaxDiffQuantityAmountCny;

    /** 状态码 */
    @Excel(name = "状态码",width = 10)
    private String statusCode;

    /** 订单创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "订单创建日期", width = 20, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date orderCreationDate;

    /** 订单行创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "订单行创建日期", width = 20, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date lineCreationDate;

    /** 原始提交日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "原始提交日期", width = 20, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date submittedDate;

    /** 最新提交日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "最新提交日期", width = 20, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date newSubmittedDate;

    /** 预计发货日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "预计发货日期", width = 20, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date scheduleShipDate;

    /** 最近更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "最近更新时间", width = 20, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate;

    /** 最近操作人员 */
    @Excel(name = "最近操作人员", width = 15)
    private String lastUpdatedBy;

    /** 销售订单头状态 */
    @Excel(name = "销售订单头状态", width = 10)
    private String orderStatusCode;

    private BigDecimal fulfilledQty;

    public BigDecimal getFulfilledQty() {
        return fulfilledQty;
    }

    public void setFulfilledQty(BigDecimal fulfilledQty) {
        this.fulfilledQty = fulfilledQty;
    }

    public BigDecimal getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(BigDecimal taxCode) {
        this.taxCode = taxCode;
    }

    public BigDecimal getExtendedAmount() {
        return extendedAmount;
    }

    public void setExtendedAmount(BigDecimal extendedAmount) {
        this.extendedAmount = extendedAmount;
    }

    public BigDecimal getDiffQuantity() {
        return diffQuantity;
    }

    public void setDiffQuantity(BigDecimal diffQuantity) {
        this.diffQuantity = diffQuantity;
    }

    public BigDecimal getUntaxUnitListPrice() {
        return untaxUnitListPrice;
    }

    public void setUntaxUnitListPrice(BigDecimal untaxUnitListPrice) {
        this.untaxUnitListPrice = untaxUnitListPrice;
    }

    public BigDecimal getUntaxExtendedAmount() {
        return untaxExtendedAmount;
    }

    public void setUntaxExtendedAmount(BigDecimal untaxExtendedAmount) {
        this.untaxExtendedAmount = untaxExtendedAmount;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getUntaxDiffQuantityAmount() {
        return untaxDiffQuantityAmount;
    }

    public void setUntaxDiffQuantityAmount(BigDecimal untaxDiffQuantityAmount) {
        this.untaxDiffQuantityAmount = untaxDiffQuantityAmount;
    }

    public BigDecimal getUntaxDiffQuantityAmountCny() {
        return untaxDiffQuantityAmountCny;
    }

    public void setUntaxDiffQuantityAmountCny(BigDecimal untaxDiffQuantityAmountCny) {
        this.untaxDiffQuantityAmountCny = untaxDiffQuantityAmountCny;
    }


    public void setBuName(String buName)
    {
        this.buName = buName;
    }

    public String getBuName()
    {
        return buName;
    }
    public void setPartyName(String partyName)
    {
        this.partyName = partyName;
    }

    public String getPartyName()
    {
        return partyName;
    }
    public void setSalsesName(String salsesName)
    {
        this.salsesName = salsesName;
    }

    public String getSalsesName()
    {
        return salsesName;
    }
    public void setAgentSale(String agentSale)
    {
        this.agentSale = agentSale;
    }

    public String getAgentSale()
    {
        return agentSale;
    }
    public void setOrderSalsesName(String orderSalsesName)
    {
        this.orderSalsesName = orderSalsesName;
    }

    public String getOrderSalsesName()
    {
        return orderSalsesName;
    }
    public void setOrderSalsesNameAgent(String orderSalsesNameAgent)
    {
        this.orderSalsesNameAgent = orderSalsesNameAgent;
    }

    public String getOrderSalsesNameAgent()
    {
        return orderSalsesNameAgent;
    }
    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }
    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }
    public void setCustomerPoNumber(String customerPoNumber)
    {
        this.customerPoNumber = customerPoNumber;
    }

    public String getCustomerPoNumber()
    {
        return customerPoNumber;
    }
    public void setOrderNumber(String orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber()
    {
        return orderNumber;
    }
    public void setOrderType(String orderType)
    {
        this.orderType = orderType;
    }

    public String getOrderType()
    {
        return orderType;
    }
    public void setProdLines(String prodLines)
    {
        this.prodLines = prodLines;
    }

    public String getProdLines()
    {
        return prodLines;
    }
    public void setOrderChangType(String orderChangType)
    {
        this.orderChangType = orderChangType;
    }

    public String getOrderChangType()
    {
        return orderChangType;
    }
    public void setOrderChangReason(String orderChangReason)
    {
        this.orderChangReason = orderChangReason;
    }

    public String getOrderChangReason()
    {
        return orderChangReason;
    }
    public void setXieYiNumber(String xieYiNumber)
    {
        this.xieYiNumber = xieYiNumber;
    }

    public String getXieYiNumber()
    {
        return xieYiNumber;
    }
    public void setLineNumber(Integer lineNumber)
    {
        this.lineNumber = lineNumber;
    }

    public Integer getLineNumber()
    {
        return lineNumber;
    }
    public void setSourceOrderNumber(String sourceOrderNumber)
    {
        this.sourceOrderNumber = sourceOrderNumber;
    }

    public String getSourceOrderNumber()
    {
        return sourceOrderNumber;
    }
    public void setSourceLineNumber(String sourceLineNumber)
    {
        this.sourceLineNumber = sourceLineNumber;
    }

    public String getSourceLineNumber()
    {
        return sourceLineNumber;
    }
    public void setDisplayLineNumber(String displayLineNumber)
    {
        this.displayLineNumber = displayLineNumber;
    }

    public String getDisplayLineNumber()
    {
        return displayLineNumber;
    }
    public void setItemNumber(String itemNumber)
    {
        this.itemNumber = itemNumber;
    }

    public String getItemNumber()
    {
        return itemNumber;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setErpCategory(String erpCategory)
    {
        this.erpCategory = erpCategory;
    }

    public String getErpCategory()
    {
        return erpCategory;
    }
    public void setProdCategory(String prodCategory)
    {
        this.prodCategory = prodCategory;
    }

    public String getProdCategory()
    {
        return prodCategory;
    }
    public void setOrderedQty(BigDecimal orderedQty)
    {
        this.orderedQty = orderedQty;
    }

    public BigDecimal getOrderedQty()
    {
        return orderedQty;
    }
    public void setTransactionalCurrencyCode(String transactionalCurrencyCode)
    {
        this.transactionalCurrencyCode = transactionalCurrencyCode;
    }

    public String getTransactionalCurrencyCode()
    {
        return transactionalCurrencyCode;
    }
    public void setUnitListPrice(BigDecimal unitListPrice)
    {
        this.unitListPrice = unitListPrice;
    }

    public BigDecimal getUnitListPrice()
    {
        return unitListPrice;
    }
    public void setTaxClassificationCode(String taxClassificationCode)
    {
        this.taxClassificationCode = taxClassificationCode;
    }

    public String getTaxClassificationCode()
    {
        return taxClassificationCode;
    }
    public void setConversionRate(BigDecimal conversionRate)
    {
        this.conversionRate = conversionRate;
    }

    public BigDecimal getConversionRate()
    {
        return conversionRate;
    }
    public void setStatusCode(String statusCode)
    {
        this.statusCode = statusCode;
    }

    public String getStatusCode()
    {
        return statusCode;
    }
    public void setOrderCreationDate(Date orderCreationDate)
    {
        this.orderCreationDate = orderCreationDate;
    }

    public Date getOrderCreationDate()
    {
        return orderCreationDate;
    }
    public void setLineCreationDate(Date lineCreationDate)
    {
        this.lineCreationDate = lineCreationDate;
    }

    public Date getLineCreationDate()
    {
        return lineCreationDate;
    }
    public void setSubmittedDate(Date submittedDate)
    {
        this.submittedDate = submittedDate;
    }

    public Date getSubmittedDate()
    {
        return submittedDate;
    }
    public void setNewSubmittedDate(Date newSubmittedDate)
    {
        this.newSubmittedDate = newSubmittedDate;
    }

    public Date getNewSubmittedDate()
    {
        return newSubmittedDate;
    }
    public void setScheduleShipDate(Date scheduleShipDate)
    {
        this.scheduleShipDate = scheduleShipDate;
    }

    public Date getScheduleShipDate()
    {
        return scheduleShipDate;
    }
    public void setLastUpdateDate(Date lastUpdateDate)
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastUpdateDate()
    {
        return lastUpdateDate;
    }
    public void setLastUpdatedBy(String lastUpdatedBy)
    {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdatedBy()
    {
        return lastUpdatedBy;
    }
    public void setOrderStatusCode(String orderStatusCode)
    {
        this.orderStatusCode = orderStatusCode;
    }

    public String getOrderStatusCode()
    {
        return orderStatusCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("buName", getBuName())
                .append("partyName", getPartyName())
                .append("salsesName", getSalsesName())
                .append("agentSale", getAgentSale())
                .append("orderSalsesName", getOrderSalsesName())
                .append("orderSalsesNameAgent", getOrderSalsesNameAgent())
                .append("createdBy", getCreatedBy())
                .append("accountNumber", getAccountNumber())
                .append("customerPoNumber", getCustomerPoNumber())
                .append("orderNumber", getOrderNumber())
                .append("orderType", getOrderType())
                .append("prodLines", getProdLines())
                .append("orderChangType", getOrderChangType())
                .append("orderChangReason", getOrderChangReason())
                .append("xieYiNumber", getXieYiNumber())
                .append("lineNumber", getLineNumber())
                .append("sourceOrderNumber", getSourceOrderNumber())
                .append("sourceLineNumber", getSourceLineNumber())
                .append("displayLineNumber", getDisplayLineNumber())
                .append("itemNumber", getItemNumber())
                .append("description", getDescription())
                .append("erpCategory", getErpCategory())
                .append("prodCategory", getProdCategory())
                .append("orderedQty", getOrderedQty())
                .append("diffQuantity", getDiffQuantity())
                .append("transactionalCurrencyCode", getTransactionalCurrencyCode())
                .append("unitListPrice", getUnitListPrice())
                .append("taxClassificationCode", getTaxClassificationCode())
                .append("conversionRate", getConversionRate())
                .append("statusCode", getStatusCode())
                .append("orderCreationDate", getOrderCreationDate())
                .append("lineCreationDate", getLineCreationDate())
                .append("submittedDate", getSubmittedDate())
                .append("newSubmittedDate", getNewSubmittedDate())
                .append("scheduleShipDate", getScheduleShipDate())
                .append("lastUpdateDate", getLastUpdateDate())
                .append("lastUpdatedBy", getLastUpdatedBy())
                .append("orderStatusCode", getOrderStatusCode())
                .toString();
    }
}