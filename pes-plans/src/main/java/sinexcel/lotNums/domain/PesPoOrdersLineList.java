package sinexcel.lotNums.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import sinexcel.common.annotation.Excel;

/**
 * 订单采购计划行对象 pes_po_orders_line_list
 * 
 * @author Zhang Kai
 * @date 2021-04-25
 */
public class PesPoOrdersLineList
{

    /** $column.columnComment */
    private Long id;

    /** 计划批次行号 */
    @Excel(name = "计划批次行号", width = 20)
    @JsonSerialize(using= ToStringSerializer.class)
    private Long lineNum;

    /** 阶次 */
    @Excel(name = "阶次", width = 5)
    private Integer level;

    /** 计划类型 */
    @Excel(name = "计划类型", width = 10)
    private String planType;

    /** 本阶树状码 */
    @Excel(name = "本阶树状码", width = 30)
    private String levelTreeCode;

    /** 物料ID */
    private Long inventoryItemId;

    /** 物料编码 */
    @Excel(name = "物料编码", width = 15)
    private String itemNumber;

    /** 物料描述 */
    @Excel(name = "物料描述", width = 40)
    private String itemDescription;

    /** 物料类型 */
    @Excel(name = "物料类型", width = 10)
    private String itemType;

    /** 单品用量 */
    @Excel(name = "单品用量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal componentQuantity;

    /** 单位 */
    @Excel(name = "单位", width = 10)
    private String uom;

    /** 计划采购数量 */
    @Excel(name = "计划采购数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal planPoQuantity;

    /** 计划采购日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划采购日期", width = 10, dateFormat = "yyyy-MM-dd")
    private Date planPoDate;


    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划入库日期", width = 10, dateFormat = "yyyy-MM-dd")
    private Date planRcvtDate;

    /** 毛需求数量 */
    @Excel(name = "毛需求数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal grossQuantity;

    /** 毛需求日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "毛需求日期", width = 10, dateFormat = "yyyy-MM-dd")
    private Date grossDate;

//    @Excel(name = "累计需求", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal sumGrossQuantity;
    @Excel(name = "可用结存", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal avaliableQuantity;

    public BigDecimal getAvaliableQuantity() {
        return avaliableQuantity;
    }

    public void setAvaliableQuantity(BigDecimal avaliableQuantity) {
        this.avaliableQuantity = avaliableQuantity;
    }
    @Excel(name = "当前库存", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal onhandQuantity;
    @Excel(name = "预计生产", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal wieHQuantity;

    @Excel(name = "预计领用", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal wieLQuantity;
    @Excel(name = "预计进货", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal poQuantity;
    @Excel(name = "已请未购", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal prQuantity;
    @Excel(name = "计划采购", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal parentPlanPoQuantity;


    /** 上阶主件ID */
    private Long pInventoryItemId;

    /** 上阶树状码 */
    @Excel(name = "上阶树状码", width = 30)
    private String parentLevelTreeCode;

    /** 上阶主件 */
    @Excel(name = "上阶主件", width = 15)
    private String pItemNumber;

    /** 上阶主件描述 */
    @Excel(name = "上阶主件描述", width = 40)
    private String pItemDescription;

    /** 上阶需求数量 */
    @Excel(name = "上阶需求数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal parentGrossQuantity;

    /** 需求日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上阶需求日期", width = 10, dateFormat = "yyyy-MM-dd")
    private Date parentGrossDate;

    /** 库存组织 */
    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X")
    private Long organizationId;

    /** 来源主计划批号 */
    @Excel(name = "来源主计划批号", width = 15)
    private Long planLotNum;

    /** 主计划行号 */
    @Excel(name = "主计划行号", width = 5)
    private Long planLotLineNum;

    /** 来源树状码 */
    @Excel(name = "来源树状码", width = 10)
    private String planTreeCode;

    /** 来源物料编码 */
    @Excel(name = "来源物料编码", width = 15)
    private String planItemNumber;

    /** 来源物料类别 */
    @Excel(name = "来源物料类别", width = 5)
    private String planItemType;

    /** 主计划数量 */
    @Excel(name = "来源计划数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal planItemQuantity;

    /** 计划日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "来源计划日期", width = 10, dateFormat = "yyyy-MM-dd")
    private Date planDate;

    /** 来源订单号 */
    @Excel(name = "来源订单号", width = 10)
    private String documentNumber;

    @Excel(name = "来源订单行号", width = 10)
    private Integer documentLineNum;

    /** 来源合同号 */
    @Excel(name = "来源合同号", width = 15)
    private String custPoNumber;
    @Excel(name = "来源客户", width = 15)
    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /** $column.columnComment */
    private Date createDate;

    /** $column.columnComment */
    private Date lastUpdateDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    public BigDecimal getWieLQuantity() {
        return wieLQuantity;
    }

    public void setWieLQuantity(BigDecimal wieLQuantity) {
        this.wieLQuantity = wieLQuantity;
    }

    public BigDecimal getParentPlanPoQuantity() {
        return parentPlanPoQuantity;
    }

    public void setParentPlanPoQuantity(BigDecimal parentPlanPoQuantity) {
        this.parentPlanPoQuantity = parentPlanPoQuantity;
    }

    public Integer getDocumentLineNum() {
        return documentLineNum;
    }

    public void setDocumentLineNum(Integer documentLineNum) {
        this.documentLineNum = documentLineNum;
    }

    public BigDecimal getWieHQuantity() {
        return wieHQuantity;
    }

    public void setWieHQuantity(BigDecimal wieHQuantity) {
        this.wieHQuantity = wieHQuantity;
    }

    public BigDecimal getPoQuantity() {
        return poQuantity;
    }

    public void setPoQuantity(BigDecimal poQuantity) {
        this.poQuantity = poQuantity;
    }

    public BigDecimal getPrQuantity() {
        return prQuantity;
    }

    public void setPrQuantity(BigDecimal prQuantity) {
        this.prQuantity = prQuantity;
    }

    public Date getPlanPoDate() {
        return planPoDate;
    }

    public void setPlanPoDate(Date planPoDate) {
        this.planPoDate = planPoDate;
    }

    public Date getPlanRcvtDate() {
        return planRcvtDate;
    }

    public void setPlanRcvtDate(Date planRcvtDate) {
        this.planRcvtDate = planRcvtDate;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getCustPoNumber() {
        return custPoNumber;
    }

    public void setCustPoNumber(String custPoNumber) {
        this.custPoNumber = custPoNumber;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setOrganizationId(Long organizationId) 
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() 
    {
        return organizationId;
    }
    public void setLevel(Integer level) 
    {
        this.level = level;
    }

    public Integer getLevel() 
    {
        return level;
    }
    public void setLineNum(Long lineNum) 
    {
        this.lineNum = lineNum;
    }

    public Long getLineNum() 
    {
        return lineNum;
    }
    public void setPlanType(String planType) 
    {
        this.planType = planType;
    }

    public String getPlanType() 
    {
        return planType;
    }
    public void setLevelTreeCode(String levelTreeCode) 
    {
        this.levelTreeCode = levelTreeCode;
    }

    public String getLevelTreeCode() 
    {
        return levelTreeCode;
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
    public void setComponentQuantity(BigDecimal componentQuantity) 
    {
        this.componentQuantity = componentQuantity;
    }

    public BigDecimal getComponentQuantity() 
    {
        return componentQuantity;
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
    public void setGrossQuantity(BigDecimal grossQuantity) 
    {
        this.grossQuantity = grossQuantity;
    }

    public BigDecimal getGrossQuantity() 
    {
        return grossQuantity;
    }
    public void setGrossDate(Date grossDate) 
    {
        this.grossDate = grossDate;
    }

    public Date getGrossDate() 
    {
        return grossDate;
    }
    public void setOnhandQuantity(BigDecimal onhandQuantity) 
    {
        this.onhandQuantity = onhandQuantity;
    }

    public BigDecimal getOnhandQuantity() 
    {
        return onhandQuantity;
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
    public void setpItemDescription(String pItemDescription) 
    {
        this.pItemDescription = pItemDescription;
    }

    public String getpItemDescription() 
    {
        return pItemDescription;
    }
    public void setParentLevelTreeCode(String parentLevelTreeCode) 
    {
        this.parentLevelTreeCode = parentLevelTreeCode;
    }

    public String getParentLevelTreeCode() 
    {
        return parentLevelTreeCode;
    }
    public void setParentGrossQuantity(BigDecimal parentGrossQuantity) 
    {
        this.parentGrossQuantity = parentGrossQuantity;
    }

    public BigDecimal getParentGrossQuantity() 
    {
        return parentGrossQuantity;
    }
    public void setParentGrossDate(Date parentGrossDate) 
    {
        this.parentGrossDate = parentGrossDate;
    }

    public Date getParentGrossDate() 
    {
        return parentGrossDate;
    }
    public void setPlanLotNum(Long planLotNum) 
    {
        this.planLotNum = planLotNum;
    }

    public Long getPlanLotNum() 
    {
        return planLotNum;
    }
    public void setPlanLotLineNum(Long planLotLineNum) 
    {
        this.planLotLineNum = planLotLineNum;
    }

    public Long getPlanLotLineNum() 
    {
        return planLotLineNum;
    }
    public void setPlanItemNumber(String planItemNumber) 
    {
        this.planItemNumber = planItemNumber;
    }

    public String getPlanItemNumber() 
    {
        return planItemNumber;
    }
    public void setPlanItemType(String planItemType) 
    {
        this.planItemType = planItemType;
    }

    public String getPlanItemType() 
    {
        return planItemType;
    }
    public void setPlanItemQuantity(BigDecimal planItemQuantity) 
    {
        this.planItemQuantity = planItemQuantity;
    }

    public BigDecimal getPlanItemQuantity() 
    {
        return planItemQuantity;
    }
    public void setPlanDate(Date planDate) 
    {
        this.planDate = planDate;
    }

    public Date getPlanDate() 
    {
        return planDate;
    }
    public void setPlanTreeCode(String planTreeCode) 
    {
        this.planTreeCode = planTreeCode;
    }

    public String getPlanTreeCode() 
    {
        return planTreeCode;
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
    public void setSumGrossQuantity(BigDecimal sumGrossQuantity)
    {
        this.sumGrossQuantity = sumGrossQuantity;
    }

    public BigDecimal getSumGrossQuantity()
    {
        return sumGrossQuantity;
    }
}
