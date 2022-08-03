package sinexcel.lotNums.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import sinexcel.common.annotation.Excel;

/**
 * 订单需求收集对象 sync_orders_demand_list
 *
 * @author Zhang Kai
 * @date 2021-04-23
 */
public class SyncOrdersDemandList
{
    /**  */
    private String organizationCode;

    /** 库存组织 */
    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X")
    private Long organizationId;

    /** 订单号 */
    @Excel(name = "订单号", width = 10)
    private String documentNumber;

    /** 合同号 */
    @Excel(name = "合同号", width = 20)
    private String custPoNumber;

    @Excel(name = "行号", width = 5, cellType = Excel.ColumnType.BigDecimal)
    private Integer documentLineNum;

    /** 成品料号 */
    @Excel(name = "成品料号", width = 15)
    private String planItemNumber;

    @Excel(name = "成品描述", width = 40)
    private String itemDescription;

    /** 类型 */
    @Excel(name = "类型", width = 10)
    private String planItemType;

    /** $column.columnComment */
    private Long inventoryItemId;

    /** 需求数量 */
    @Excel(name = "需求数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal planItemQuantity;

    /** 需求日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "需求日期", width = 15, dateFormat = "yyyy-MM-dd")
    private Date planDate;


    /** 序号 */
    private Long demandId;

    /** 最后更新日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastUpdateDate;

    private String createBy;

    private String planLotNum;

    public String getPlanLotNum() {
        return planLotNum;
    }

    public void setPlanLotNum(String planLotNum) {
        this.planLotNum = planLotNum;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Integer getDocumentLineNum() {
        return documentLineNum;
    }

    public void setDocumentLineNum(Integer documentLineNum) {
        this.documentLineNum = documentLineNum;
    }
    public void setOrganizationCode(String organizationCode)
    {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationCode()
    {
        return organizationCode;
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
    public void setCustPoNumber(String custPoNumber)
    {
        this.custPoNumber = custPoNumber;
    }

    public String getCustPoNumber()
    {
        return custPoNumber;
    }
    public void setDocumentNumber(String documentNumber)
    {
        this.documentNumber = documentNumber;
    }

    public String getDocumentNumber()
    {
        return documentNumber;
    }
    public void setDemandId(Long demandId)
    {
        this.demandId = demandId;
    }

    public Long getDemandId()
    {
        return demandId;
    }
    public void setLastUpdateDate(Date lastUpdateDate)
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastUpdateDate()
    {
        return lastUpdateDate;
    }
}
