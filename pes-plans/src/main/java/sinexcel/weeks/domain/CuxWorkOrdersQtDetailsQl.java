package sinexcel.weeks.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 欠料查询对象 cux_work_orders_qt_details_ql
 * 
 * @author Zhang Kai
 * @date 2021-03-11
 */
public class CuxWorkOrdersQtDetailsQl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long qtId;

    /** 库存组织 */
    @Excel(name = "库存组织", width = 10)
    private String organizationCode;

    /** 工单号 */
    @Excel(name = "工单号", width = 15)
    private String workOrderNumber;

    /** 成品料号 */
    @Excel(name = "成品料号", width = 15)
    private String pItemNumber;

    /** 规格描述 */
    @Excel(name = "规格描述", width = 30)
    private String pDescription;

    /** 生产数量 */
    @Excel(name = "生产数量", width = 10 , cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal plannedStartQuantity;

    /** 已入库数量 */
    @Excel(name = "已入库数量" , width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal completedQuantity;

    /** 序号 */
    @Excel(name = "序号" , width = 10, cellType = Excel.ColumnType.BigDecimal)
    private Long materialSeqNumber;

    /** 元件编码 */
    @Excel(name = "元件编码", width = 15)
    private String itemNumber;

    /** 元件规格 */
    @Excel(name = "元件规格", width = 40)
    private String description;

    /** 需求日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "需求日期", width = 10, dateFormat = "yyyy-MM-dd")
    private Date plannedStartDate;

    /** 需求数量 */
    @Excel(name = "需求数量" , width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal requiredQuantity;

    /** 累计需求数量 */
    @Excel(name = "累计需求数量", width = 10 , cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal sumRequiredQuantity;

    /** 库存数量 */
    @Excel(name = "库存数量" , width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal quantity;

    /** 结存数量 */
    @Excel(name = "结存数量" , width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal remainQuantity;

    @Excel(name = "非累计结存数量" , width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal overRemainQuantity;

    /** 待入库数量 */
    @Excel(name = "待入库数量" , width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal receiveQuantity;

    /** 在途数量 */
    @Excel(name = "在途数量", width = 10 , cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal inboundQuantity;

    /** 预计结存数量 */
    @Excel(name = "预计结存数量" , width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal revRemainQuantity;

    /** 采购员 */
    @Excel(name = "采购员", width = 10)
    private String buyerName;

    /** 产品线 */
    @Excel(name = "产品线", width = 10)
    private String prodLine;

    /** 客户 */
    @Excel(name = "客户", width = 10)
    private String customerName;

    /** 订单号 */
    @Excel(name = "订单号", width = 10)
    private String orderNum;

    /** 批次 */
    @Excel(name = "批次", width = 15)
    private String lotNum;

    /** $column.columnComment */
    private Date createDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    private Date lastUpdateDate;

    public BigDecimal getOverRemainQuantity() {
        return overRemainQuantity;
    }

    public void setOverRemainQuantity(BigDecimal overRemainQuantity) {
        this.overRemainQuantity = overRemainQuantity;
    }

    public void setQtId(Long qtId) 
    {
        this.qtId = qtId;
    }

    public Long getQtId() 
    {
        return qtId;
    }
    public void setOrganizationCode(String organizationCode) 
    {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationCode() 
    {
        return organizationCode;
    }
    public void setWorkOrderNumber(String workOrderNumber) 
    {
        this.workOrderNumber = workOrderNumber;
    }

    public String getWorkOrderNumber() 
    {
        return workOrderNumber;
    }
    public void setPlannedStartDate(Date plannedStartDate) 
    {
        this.plannedStartDate = plannedStartDate;
    }

    public Date getPlannedStartDate() 
    {
        return plannedStartDate;
    }
    public void setpItemNumber(String pItemNumber) 
    {
        this.pItemNumber = pItemNumber;
    }

    public String getpItemNumber() 
    {
        return pItemNumber;
    }
    public void setpDescription(String pDescription) 
    {
        this.pDescription = pDescription;
    }

    public String getpDescription() 
    {
        return pDescription;
    }
    public void setPlannedStartQuantity(BigDecimal plannedStartQuantity) 
    {
        this.plannedStartQuantity = plannedStartQuantity;
    }

    public BigDecimal getPlannedStartQuantity() 
    {
        return plannedStartQuantity;
    }
    public void setCompletedQuantity(BigDecimal completedQuantity) 
    {
        this.completedQuantity = completedQuantity;
    }

    public BigDecimal getCompletedQuantity() 
    {
        return completedQuantity;
    }
    public void setMaterialSeqNumber(Long materialSeqNumber) 
    {
        this.materialSeqNumber = materialSeqNumber;
    }

    public Long getMaterialSeqNumber() 
    {
        return materialSeqNumber;
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
    public void setRequiredQuantity(BigDecimal requiredQuantity) 
    {
        this.requiredQuantity = requiredQuantity;
    }

    public BigDecimal getRequiredQuantity() 
    {
        return requiredQuantity;
    }
    public void setSumRequiredQuantity(BigDecimal sumRequiredQuantity) 
    {
        this.sumRequiredQuantity = sumRequiredQuantity;
    }

    public BigDecimal getSumRequiredQuantity() 
    {
        return sumRequiredQuantity;
    }
    public void setQuantity(BigDecimal quantity) 
    {
        this.quantity = quantity;
    }

    public BigDecimal getQuantity() 
    {
        return quantity;
    }
    public void setRemainQuantity(BigDecimal remainQuantity) 
    {
        this.remainQuantity = remainQuantity;
    }

    public BigDecimal getRemainQuantity() 
    {
        return remainQuantity;
    }
    public void setReceiveQuantity(BigDecimal receiveQuantity) 
    {
        this.receiveQuantity = receiveQuantity;
    }

    public BigDecimal getReceiveQuantity() 
    {
        return receiveQuantity;
    }
    public void setInboundQuantity(BigDecimal inboundQuantity) 
    {
        this.inboundQuantity = inboundQuantity;
    }

    public BigDecimal getInboundQuantity() 
    {
        return inboundQuantity;
    }
    public void setRevRemainQuantity(BigDecimal revRemainQuantity) 
    {
        this.revRemainQuantity = revRemainQuantity;
    }

    public BigDecimal getRevRemainQuantity() 
    {
        return revRemainQuantity;
    }
    public void setBuyerName(String buyerName) 
    {
        this.buyerName = buyerName;
    }

    public String getBuyerName() 
    {
        return buyerName;
    }
    public void setProdLine(String prodLine) 
    {
        this.prodLine = prodLine;
    }

    public String getProdLine() 
    {
        return prodLine;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }
    public void setOrderNum(String orderNum) 
    {
        this.orderNum = orderNum;
    }

    public String getOrderNum() 
    {
        return orderNum;
    }
    public void setLotNum(String lotNum) 
    {
        this.lotNum = lotNum;
    }

    public String getLotNum() 
    {
        return lotNum;
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
            .append("qtId", getQtId())
            .append("organizationCode", getOrganizationCode())
            .append("workOrderNumber", getWorkOrderNumber())
            .append("plannedStartDate", getPlannedStartDate())
            .append("pItemNumber", getpItemNumber())
            .append("pDescription", getpDescription())
            .append("plannedStartQuantity", getPlannedStartQuantity())
            .append("completedQuantity", getCompletedQuantity())
            .append("materialSeqNumber", getMaterialSeqNumber())
            .append("itemNumber", getItemNumber())
            .append("description", getDescription())
            .append("requiredQuantity", getRequiredQuantity())
            .append("sumRequiredQuantity", getSumRequiredQuantity())
            .append("quantity", getQuantity())
            .append("remainQuantity", getRemainQuantity())
            .append("receiveQuantity", getReceiveQuantity())
            .append("inboundQuantity", getInboundQuantity())
            .append("revRemainQuantity", getRevRemainQuantity())
            .append("buyerName", getBuyerName())
            .append("prodLine", getProdLine())
            .append("customerName", getCustomerName())
            .append("orderNum", getOrderNum())
            .append("lotNum", getLotNum())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("lastUpdateBy", getLastUpdateBy())
            .append("lastUpdateDate", getLastUpdateDate())
            .toString();
    }
}
