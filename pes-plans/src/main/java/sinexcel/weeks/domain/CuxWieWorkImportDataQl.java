package sinexcel.weeks.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 排程欠料分析数据对象 cux_wie_work_import_data_ql
 * 
 * @author Zhang Kai
 * @date 2021-11-06
 */
public class CuxWieWorkImportDataQl
{
    /** 库存组织 */
    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X")
    private Long organizationId;

    /** $column.columnComment */
    private Long workOrderId;

    /** 工单号 */
    @Excel(name = "工单号",width = 15)
    private String workOrderNumber;

    /** $column.columnComment */
    private Long pInventoryItemId;

    /** 成品料号 */
    @Excel(name = "成品料号",width = 15)
    private String pItemNumber;

    /** 成品描述 */
    @Excel(name = "成品描述",width = 40)
    private String pDescription;

    /** 计划开工数量 */
    @Excel(name = "计划开工数量", width = 10 , cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal plannedStartQuantity;

    /** 完工数量 */
    @Excel(name = "完工数量", width = 10 , cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal completedQuantity;

    /** 序号 */
    @Excel(name = "序号", width = 10 , cellType = Excel.ColumnType.BigDecimal)
    private Integer lineNum;

    /** 排程顺序 */
    @Excel(name = "排产顺序", width = 10 , cellType = Excel.ColumnType.BigDecimal)
    private Integer num;
    @Excel(name = "排产类型",width = 10,readConverterExp = "0=未排产,1=已排产")
    private String workType;

    /** $column.columnComment */
    private Long inventoryItemId;

    /** 元件编码 */
    @Excel(name = "元件编码",width = 15)
    private String itemNumber;

    /** 元件描述 */
    @Excel(name = "元件描述",width = 40)
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "需求日期", width = 10, dateFormat = "yyyy-MM-dd")
    private Date requiredDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "导入开工日期", width = 15,dateFormat = "yyyy-MM-dd")
    private Date importStartDate;

    public Date getImportStartDate() {
        return importStartDate;
    }

    public void setImportStartDate(Date importStartDate) {
        this.importStartDate = importStartDate;
    }

    /** 需求数量 */
    @Excel(name = "需求数量", width = 10 , cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal requiredQuantity;

    /** 累计需求数量 */
    @Excel(name = "累计需求数量", width = 10 , cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal sumRequiredQuantity;

    /** 当前库存 */
    @Excel(name = "当前库存", width = 10 , cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal onhandQuantity;


    @Excel(name = "已分配数量", width = 10 , cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal sumUntransferedQuantity;

    public BigDecimal getSumUntransferedQuantity() {
        return sumUntransferedQuantity;
    }

    public void setSumUntransferedQuantity(BigDecimal sumUntransferedQuantity) {
        this.sumUntransferedQuantity = sumUntransferedQuantity;
    }

    /** 可用库存 */
    @Excel(name = "可用库存", width = 10 , cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal avaliableOnhandQuantity;

    /** 结存数量 */
    @Excel(name = "结存数量", width = 10 , cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal remainQuantity;

    public BigDecimal getMaxRequiredQuantity() {
        return maxRequiredQuantity;
    }

    public void setMaxRequiredQuantity(BigDecimal maxRequiredQuantity) {
        this.maxRequiredQuantity = maxRequiredQuantity;
    }

    @Excel(name = "欠料合计", width = 10 , cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal maxRequiredQuantity;

    @Excel(name = "工单欠料数量", width = 10 , cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal overRemainQuantity;

    /** 待入库数量 */
    @Excel(name = "待入库数量", width = 10 , cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal receiveQuantity;

    /** 在途数量 */
    @Excel(name = "在途数量", width = 10 , cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal inboundQuantity;
    @Excel(name = "预计结存数量", width = 10 , cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal revRemainQuantity;

    /** 采购员 */
    @Excel(name = "采购员",width = 10)
    private String buyerName;

    /** 产品线 */
    @Excel(name = "产品线",width = 10)
    private String prodLines;

    /** 客户 */
    @Excel(name = "客户",width = 15)
    private String customerName;

    /** 订单号 */
    @Excel(name = "订单号",width = 10)
    private String orderNumber;

    /** 排程编码 */
    @Excel(name = "排程编码",width = 15)
    private Long lotNumber;

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public BigDecimal getRevRemainQuantity() {
        return revRemainQuantity;
    }

    public void setRevRemainQuantity(BigDecimal revRemainQuantity) {
        this.revRemainQuantity = revRemainQuantity;
    }

    public BigDecimal getOverRemainQuantity() {
        return overRemainQuantity;
    }

    public void setOverRemainQuantity(BigDecimal overRemainQuantity) {
        this.overRemainQuantity = overRemainQuantity;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public void setOrganizationId(Long organizationId) 
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() 
    {
        return organizationId;
    }
    public void setWorkOrderId(Long workOrderId) 
    {
        this.workOrderId = workOrderId;
    }

    public Long getWorkOrderId() 
    {
        return workOrderId;
    }
    public void setWorkOrderNumber(String workOrderNumber) 
    {
        this.workOrderNumber = workOrderNumber;
    }

    public String getWorkOrderNumber() 
    {
        return workOrderNumber;
    }
    public void setpInventoryItemId(Long pInventoryItemId) 
    {
        this.pInventoryItemId = pInventoryItemId;
    }

    public Long getpInventoryItemId() 
    {
        return pInventoryItemId;
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
    public void setLineNum(Integer lineNum) 
    {
        this.lineNum = lineNum;
    }

    public Integer getLineNum() 
    {
        return lineNum;
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
    public void setNum(Integer num) 
    {
        this.num = num;
    }

    public Integer getNum() 
    {
        return num;
    }
    public void setSumRequiredQuantity(BigDecimal sumRequiredQuantity) 
    {
        this.sumRequiredQuantity = sumRequiredQuantity;
    }

    public BigDecimal getSumRequiredQuantity() 
    {
        return sumRequiredQuantity;
    }
    public void setOnhandQuantity(BigDecimal onhandQuantity) 
    {
        this.onhandQuantity = onhandQuantity;
    }

    public BigDecimal getOnhandQuantity() 
    {
        return onhandQuantity;
    }
    public void setAvaliableOnhandQuantity(BigDecimal avaliableOnhandQuantity) 
    {
        this.avaliableOnhandQuantity = avaliableOnhandQuantity;
    }

    public BigDecimal getAvaliableOnhandQuantity() 
    {
        return avaliableOnhandQuantity;
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
    public void setBuyerName(String buyerName) 
    {
        this.buyerName = buyerName;
    }

    public String getBuyerName() 
    {
        return buyerName;
    }
    public void setProdLines(String prodLines) 
    {
        this.prodLines = prodLines;
    }

    public String getProdLines() 
    {
        return prodLines;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }
    public void setOrderNumber(String orderNumber) 
    {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() 
    {
        return orderNumber;
    }
    public void setLotNumber(Long lotNumber) 
    {
        this.lotNumber = lotNumber;
    }

    public Long getLotNumber() 
    {
        return lotNumber;
    }
}
