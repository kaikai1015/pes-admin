package sinexcel.daysPlan.domain;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 生产计划调拨单对象 pes_prod_plan_transfer_all
 * 
 * @author Zhang Kai
 * @date 2021-07-01
 */
public class PesProdPlanTransferAll extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    /** 行号 */
    @Excel(name = "调拨单号", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private Long planTransferId;
    /** 库存组织 */
    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X")
    private Long organizationId;
    /** 物料编码 */
    @Excel(name = "子件编码", width = 15)
    private String itemNumber;

    /** 物料描述 */
    @Excel(name = "子件描述", width = 40)
    private String itemDescription;
    @Excel(name = "备料单号", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private Long beiLiaoId;
    @Excel(name = "工艺属性", width = 10,readConverterExp = "1=贴片,2=插件,3=装配,4=辅料")
    private String itemWorkNameFlag;
    @Excel(name = "损耗数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal suoHaoQuantity;
    /** 需求数量 */
    @Excel(name = "需求数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal requiredQuantity;

    /** 备料数量 */
    @Excel(name = "备料数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal beiLiaoQuantity;

    /** 调出数量 */
    @Excel(name = "调出数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal diaoChuQuantity;

    /** 调出子库 */
    @Excel(name = "调出子库", width = 10)
    private String diaoChuSubinventory;

    /** 调入数量 */
    @Excel(name = "调入数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal diaoRuQuantity;

    /** 调入子库 */
    @Excel(name = "调入子库", width = 10)
    private String diaoRuSubinventory;

    /** 调拨状态 */
    @Excel(name = "调拨状态", width = 10,readConverterExp = "0=0,1=成功,2=失败")
    private String transferFlag;

    @Excel(name = "计划批号", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private Long lotNum;
    @Excel(name = "工单号", width = 10)
    private String workOrderNumber;

    /** -----新增---2021.08.23-----**/
    //出入库种类(ISSUE:厂内工单发料调拨/OUTSIDE:委外工单领料调拨)
    @Excel(name = "出入库种类", width = 10)
    private String sourceType;
    //出入类型 0：周转仓调拨，1：调拨接收
    @Excel(name = "出入类型", width = 10)
    private String type;

    @Excel(name = "来源Id", width = 10)
    private Long sourceId;
    @Excel(name = "周转仓", width = 10)
    private String turnoverSubinventory;
    //出入库类别(BEI_LIAO:备料;SUPPLEMENT_LIAO:补料;SUPERCOLLAR:超领；BACK_LIAO:退料)
    @Excel(name = "出入库类别", width = 10)
    private String sourceCategory;
//    来源对象名称(例如 工单号)
    @Excel(name = "来源对象名称", width = 10)
    private String sourceName;
//    来源对象代码(工单：WORK_ORDER)
    @Excel(name = "来源对象代码", width = 10)
    private String sourceCode;
//    对象id(例如 工单行id)
    @Excel(name = "对象id", width = 10)
    private Long sourceReferenceId;
    /**-------新增结束-----------**/

    private Long id;
    private Long workOrderId;
    private Long inventoryItemId;
    private String createBy;
    /** $column.columnComment */
    private Date createDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    private Date lastUpdateDate;

    private String maxSubinventoryCode;

    private String maxSubcode;
    private BigDecimal maxQuantity;

    private String isWwFlag;


    public String getSourceCategory() {
        return sourceCategory;
    }

    public void setSourceCategory(String sourceCategory) {
        this.sourceCategory = sourceCategory;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public Long getSourceReferenceId() {
        return sourceReferenceId;
    }

    public void setSourceReferenceId(Long sourceReferenceId) {
        this.sourceReferenceId = sourceReferenceId;
    }

    public String getIsWwFlag() {
        return isWwFlag;
    }

    public void setIsWwFlag(String isWwFlag) {
        this.isWwFlag = isWwFlag;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public String getTurnoverSubinventory() {
        return turnoverSubinventory;
    }

    public void setTurnoverSubinventory(String turnoverSubinventory) {
        this.turnoverSubinventory = turnoverSubinventory;
    }

    public Long getLotNum() {
        return lotNum;
    }

    public void setLotNum(Long lotNum) {
        this.lotNum = lotNum;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getItemWorkNameFlag() {
        return itemWorkNameFlag;
    }

    public void setItemWorkNameFlag(String itemWorkNameFlag) {
        this.itemWorkNameFlag = itemWorkNameFlag;
    }

    public BigDecimal getSuoHaoQuantity() {
        return suoHaoQuantity;
    }

    public void setSuoHaoQuantity(BigDecimal suoHaoQuantity) {
        this.suoHaoQuantity = suoHaoQuantity;
    }

    public String getMaxSubcode() {
        return maxSubcode;
    }

    public void setMaxSubcode(String maxSubcode) {
        this.maxSubcode = maxSubcode;
    }

    public BigDecimal getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(BigDecimal maxQuantity) {
        this.maxQuantity = maxQuantity;
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

    public String getMaxSubinventoryCode() {
        return maxSubinventoryCode;
    }

    public void setMaxSubinventoryCode(String maxSubinventoryCode) {
        this.maxSubinventoryCode = maxSubinventoryCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getCreateBy() {
        return createBy;
    }

    @Override
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    public void setBeiLiaoId(Long beiLiaoId) 
    {
        this.beiLiaoId = beiLiaoId;
    }

    public Long getBeiLiaoId() 
    {
        return beiLiaoId;
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
    public void setRequiredQuantity(BigDecimal requiredQuantity) 
    {
        this.requiredQuantity = requiredQuantity;
    }

    public BigDecimal getRequiredQuantity() 
    {
        return requiredQuantity;
    }
    public void setBeiLiaoQuantity(BigDecimal beiLiaoQuantity) 
    {
        this.beiLiaoQuantity = beiLiaoQuantity;
    }

    public BigDecimal getBeiLiaoQuantity() 
    {
        return beiLiaoQuantity;
    }
    public void setDiaoChuQuantity(BigDecimal diaoChuQuantity) 
    {
        this.diaoChuQuantity = diaoChuQuantity;
    }

    public BigDecimal getDiaoChuQuantity() 
    {
        return diaoChuQuantity;
    }
    public void setDiaoChuSubinventory(String diaoChuSubinventory) 
    {
        this.diaoChuSubinventory = diaoChuSubinventory;
    }

    public String getDiaoChuSubinventory() 
    {
        return diaoChuSubinventory;
    }
    public void setDiaoRuQuantity(BigDecimal diaoRuQuantity) 
    {
        this.diaoRuQuantity = diaoRuQuantity;
    }

    public BigDecimal getDiaoRuQuantity() 
    {
        return diaoRuQuantity;
    }
    public void setDiaoRuSubinventory(String diaoRuSubinventory) 
    {
        this.diaoRuSubinventory = diaoRuSubinventory;
    }

    public String getDiaoRuSubinventory() 
    {
        return diaoRuSubinventory;
    }
    public void setTransferFlag(String transferFlag) 
    {
        this.transferFlag = transferFlag;
    }

    public String getTransferFlag() 
    {
        return transferFlag;
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
    public void setPlanTransferId(Long planTransferId) 
    {
        this.planTransferId = planTransferId;
    }

    public Long getPlanTransferId() 
    {
        return planTransferId;
    }

}
