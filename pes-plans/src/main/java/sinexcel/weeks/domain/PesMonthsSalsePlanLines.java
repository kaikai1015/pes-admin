package sinexcel.weeks.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import sinexcel.common.annotation.Excel;
import sinexcel.common.annotation.Excel.Type;

/**
 * 月度销售计划行对象 pes_months_salse_plan_lines
 * 
 * @author Zhang Kai
 * @date 2021-04-21
 */
public class PesMonthsSalsePlanLines
{
    /** $column.columnComment */
    @Excel(name = "业务单元",width = 10,readConverterExp = "300000001293113=BU_US,300000004669846=BU_SH_X,300000004669856=BU_HZ_X,300000014712217=BU_XA,300000019548049=BU_HZSH,300000025783989=BU_ZHNY,300000027051999=BU_SZSH",type = Type.EXPORT)
    private Long buId;

    /** $column.columnComment */
    private Long headerId;

    @Excel(name = "批次号",width = 10,type = Type.EXPORT)
    private String lotNum;
    /** 订单号 */
    @Excel(name = "订单号",width = 10,type = Type.ALL)
    private String orderNum;

    /** $column.columnComment */
    private Long lineId;

    /** 行号 */
    @Excel(name = "行号",width = 5,type = Type.ALL)
    private Integer lineNum;

    @Excel(name = "合同号",width = 15,type = Type.EXPORT)
    private String customerPoNumber;
    @Excel(name = "客户编号",width = 10,type = Type.EXPORT)
    private String partyNumber;
    @Excel(name = "客户名称",width = 30,type = Type.EXPORT)
    private String partyName;

    /** $column.columnComment */
    private Long organizationId;

    /** $column.columnComment */
    private Long inventoryItemId;

    /** 物料编码 */
    @Excel(name = "物料编码",width = 15,type = Type.ALL)
    private String itemNumber;

    /** 物料描述 */
    @Excel(name = "物料描述",width = 40,type = Type.EXPORT)
    private String itemDescription;

    /** 出货数量 */
    @Excel(name = "出货数量", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Type.ALL)
    private Long salseQuantity;

    /** 出货日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出货日期", width = 10, dateFormat = "yyyy-MM-dd",type = Type.ALL)
    private Date salseDate;

    @Excel(name = "本月已销货数量", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Type.EXPORT)
    private BigDecimal monthsShippedQty;
    @Excel(name = "当前库存", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Type.EXPORT)
    private BigDecimal onhandQuantity;
    @Excel(name = "预计生产数量", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Type.EXPORT)
    private BigDecimal wieS;
    @Excel(name = "预计请购数量", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Type.EXPORT)
    private BigDecimal prS;
    @Excel(name = "预计采购数量", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Type.EXPORT)
    private BigDecimal pos;
    @Excel(name = "订单数量", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Type.EXPORT)
    private BigDecimal orderedQty;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "需求日期", width = 10, dateFormat = "yyyy-MM-dd",type = Type.EXPORT)
    private Date requestShipDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "订单日期", width = 10, dateFormat = "yyyy-MM-dd",type = Type.EXPORT)
    private Date orderedDate;
    @Excel(name = "本币未税单价", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Type.EXPORT)
    private BigDecimal unitSellingPrice;
    @Excel(name = "本月销货金额", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Type.EXPORT)
    private BigDecimal shippedQtyAmount;
    @Excel(name = "已销货数量", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Type.EXPORT)
    private BigDecimal shippedQty;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "已销货日期", width = 10, dateFormat = "yyyy-MM-dd",type = Type.EXPORT)
    private Date actualShipDate;
    @Excel(name = "已入库数量", width = 10, cellType = Excel.ColumnType.BigDecimal,type = Type.EXPORT)
    private BigDecimal completeQuantity;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "已入库日期", width = 10, dateFormat = "yyyy-MM-dd",type = Type.EXPORT)
    private Date completeDate;

    public BigDecimal getCompleteQuantity() {
        return completeQuantity;
    }

    public void setCompleteQuantity(BigDecimal completeQuantity) {
        this.completeQuantity = completeQuantity;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }

    public Date getActualShipDate() {
        return actualShipDate;
    }

    public void setActualShipDate(Date actualShipDate) {
        this.actualShipDate = actualShipDate;
    }

    public Date getRequestShipDate() {
        return requestShipDate;
    }

    public void setRequestShipDate(Date requestShipDate) {
        this.requestShipDate = requestShipDate;
    }

    public BigDecimal getMonthsShippedQty() {
        return monthsShippedQty;
    }

    public void setMonthsShippedQty(BigDecimal monthsShippedQty) {
        this.monthsShippedQty = monthsShippedQty;
    }

    private Long partyId;

    /** $column.columnComment */
    private Date createDate;

    /** $column.columnComment */
    private Date lastUpdateDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    private Long id;

    private String createBy;


    private Integer years;
    private Long months;
    private String flag;

    public String getLotNum() {
        return lotNum;
    }

    public void setLotNum(String lotNum) {
        this.lotNum = lotNum;
    }

    public BigDecimal getShippedQtyAmount() {
        return shippedQtyAmount;
    }

    public void setShippedQtyAmount(BigDecimal shippedQtyAmount) {
        this.shippedQtyAmount = shippedQtyAmount;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Long getMonths() {
        return months;
    }

    public void setMonths(Long months) {
        this.months = months;
    }

    public String getPartyNumber() {
        return partyNumber;
    }

    public void setPartyNumber(String partyNumber) {
        this.partyNumber = partyNumber;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public BigDecimal getOnhandQuantity() {
        return onhandQuantity;
    }

    public void setOnhandQuantity(BigDecimal onhandQuantity) {
        this.onhandQuantity = onhandQuantity;
    }

    public BigDecimal getWieS() {
        return wieS;
    }

    public void setWieS(BigDecimal wieS) {
        this.wieS = wieS;
    }

    public BigDecimal getPrS() {
        return prS;
    }

    public void setPrS(BigDecimal prS) {
        this.prS = prS;
    }

    public BigDecimal getPos() {
        return pos;
    }

    public void setPos(BigDecimal pos) {
        this.pos = pos;
    }

    public BigDecimal getOrderedQty() {
        return orderedQty;
    }

    public void setOrderedQty(BigDecimal orderedQty) {
        this.orderedQty = orderedQty;
    }

    public BigDecimal getShippedQty() {
        return shippedQty;
    }

    public void setShippedQty(BigDecimal shippedQty) {
        this.shippedQty = shippedQty;
    }

    public BigDecimal getUnitSellingPrice() {
        return unitSellingPrice;
    }

    public void setUnitSellingPrice(BigDecimal unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public String getCustomerPoNumber() {
        return customerPoNumber;
    }

    public void setCustomerPoNumber(String customerPoNumber) {
        this.customerPoNumber = customerPoNumber;
    }
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setBuId(Long buId) 
    {
        this.buId = buId;
    }

    public Long getBuId() 
    {
        return buId;
    }
    public void setHeaderId(Long headerId) 
    {
        this.headerId = headerId;
    }

    public Long getHeaderId() 
    {
        return headerId;
    }
    public void setOrderNum(String orderNum) 
    {
        this.orderNum = orderNum;
    }

    public String getOrderNum() 
    {
        return orderNum;
    }
    public void setLineId(Long lineId) 
    {
        this.lineId = lineId;
    }

    public Long getLineId() 
    {
        return lineId;
    }
    public void setLineNum(Integer lineNum)
    {
        this.lineNum = lineNum;
    }

    public Integer getLineNum()
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
    public void setSalseQuantity(Long salseQuantity) 
    {
        this.salseQuantity = salseQuantity;
    }

    public Long getSalseQuantity() 
    {
        return salseQuantity;
    }
    public void setSalseDate(Date salseDate) 
    {
        this.salseDate = salseDate;
    }

    public Date getSalseDate() 
    {
        return salseDate;
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
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
}
