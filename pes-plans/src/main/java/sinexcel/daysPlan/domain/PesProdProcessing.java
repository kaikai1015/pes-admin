package sinexcel.daysPlan.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 发料进度对象 pes_prod_processing
 *
 * @author Zhang Kai
 * @date 2021-09-08
 */
public class PesProdProcessing extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Excel(name = "计划批号", width = 10)
    private Long lotNum;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划日期", width = 10, dateFormat = "yyyy-MM-dd")
    private Date lotNumDate;

    @Override
    public String getCreateBy() {
        return createBy;
    }

    @Override
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Excel(name = "日计划创建人", width = 10)
    private String createBy;
    @Excel(name = "计划员", width = 10)
    private String planName;
    @Excel(name = "线别/供应商", width = 20)
    private String prodLineValue;
    private String xianBieFlag;
    @Excel(name = "顺序", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private Long lineId;
    @Excel(name = "客户", width = 20)
    private String partyName;
    @Excel(name = "订单号", width = 10)
    private String orderNumber;
    @Excel(name = "成品编码", width = 15)
    private String pItemNumber;
    @Excel(name = "成品描述", width = 30)
    private String pItemDescription;
    @Excel(name = "工单号", width = 10)
    private String workOrderNumber;
    @Excel(name = "工单状态",width = 10,readConverterExp="10000=已取消,10001=已关闭,10002=已完成,10003=暂挂,10004=已发放,10005=未发放,10006=已删除,10007=未生效",type = Excel.Type.EXPORT)
    private Integer workOrderStatusId;
    @Excel(name = "计划生产数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal workPlanQuantity;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划完工日期", width = 10, dateFormat = "yyyy-MM-dd")
    private Date plannedCompletionDate;
    @Excel(name = "元件编码", width = 15)
    private String itemNumber;
    @Excel(name = "元件描述", width = 40)
    private String itemDescription;
    @Excel(name = "工艺属性", width = 10,readConverterExp = "1=贴片,2=插件,3=装配,4=辅料,5=SMT,6=DIP,7=发料,8=备品,9=线材,10=机柜")
    private String itemWorkNameFlag;
    @Excel(name = "需求数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal requiredQuantity;
    /** 已调拨数量(根据出入库 记录累计) */
    @Excel(name = "已调拨数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal transferedQuantity;
    /** 待调拨数量 */
    @Excel(name = "待调拨数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal untransferQuantity;

    /** 线边仓库存数量（已调拨数量+超领调拨数量-已扣账数量-超领扣 */
    @Excel(name = "线边仓库存数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal onhandQuantity;
    /** 已扣账数量(根据出入库 记录累计) */
    @Excel(name = "已扣账数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal issuedQuantity;

    @Excel(name = "待扣账数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal daiKouQuantity;
    @Excel(name = "累计待扣账数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal sumRequiredQuantity;
    @Excel(name = "结存数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal remainQuantity;
    @Excel(name = "工单欠料数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal overRemainQuantity;
    @Excel(name = "当前库存", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal invOnhandQuantity;

    public String getProdLineValue() {
        return prodLineValue;
    }

    public void setProdLineValue(String prodLineValue) {
        this.prodLineValue = prodLineValue;
    }


    public Integer getWorkOrderStatusId() {
        return workOrderStatusId;
    }

    public void setWorkOrderStatusId(Integer workOrderStatusId) {
        this.workOrderStatusId = workOrderStatusId;
    }



    public BigDecimal getInvOnhandQuantity() {
        return invOnhandQuantity;
    }

    public void setInvOnhandQuantity(BigDecimal invOnhandQuantity) {
        this.invOnhandQuantity = invOnhandQuantity;
    }

    public BigDecimal getDaiKouQuantity() {
        return daiKouQuantity;
    }

    public void setDaiKouQuantity(BigDecimal daiKouQuantity) {
        this.daiKouQuantity = daiKouQuantity;
    }

    public BigDecimal getSumRequiredQuantity() {
        return sumRequiredQuantity;
    }

    public void setSumRequiredQuantity(BigDecimal sumRequiredQuantity) {
        this.sumRequiredQuantity = sumRequiredQuantity;
    }

    public BigDecimal getRemainQuantity() {
        return remainQuantity;
    }

    public void setRemainQuantity(BigDecimal remainQuantity) {
        this.remainQuantity = remainQuantity;
    }

    public BigDecimal getOverRemainQuantity() {
        return overRemainQuantity;
    }

    public void setOverRemainQuantity(BigDecimal overRemainQuantity) {
        this.overRemainQuantity = overRemainQuantity;
    }

    /** 损耗数量  A1205&A1306开头的编码，此处显示30， */
    @Excel(name = "损耗数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal suoHaoQuantity;
    /** 超领数量(根据出入库 记录累计) */
//    @Excel(name = "超领数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal overReceiveQuantity;

    /** 工单行超领扣账数量(根据出入库 记录累计) */
//    @Excel(name = "超领扣账数", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal overIssueQuantity;

    /** 库存组织 */
    private Long organizationId;

    /** 工单id */
    private Long workOrderId;

    /** 子件id */
    private Long inventoryItemId;



    /** 待检数量 */
    private BigDecimal receiveQuantity;

    /** 备料数量 */
    private BigDecimal beiLiaoQuantity;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastUpdateDate;


    /** 退料数量(根据出入库 记录累计) */
    private BigDecimal backLiaoQuantity;

    /** 补料数量(根据出入库 记录累计) */
    private BigDecimal supplementQuantity;

    /** pes计划批次号 */
    private String planLotsId;

    private String isWwFlag;


    private String customerPoNumber;

    /** 工单行id */
    private Long workOrderLineId;

    /** 计划id */
    private Long planId;


    private Integer prodLineFlag;




    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String beginTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String endTime;
    /** 请求时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String requiredDate;

    private String subinventoryCode;


    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date requiredQuantityDate;

    private String workOrderStatusIdAll;

    public String getWorkOrderStatusIdAll() {
        return workOrderStatusIdAll;
    }

    public void setWorkOrderStatusIdAll(String workOrderStatusIdAll) {
        this.workOrderStatusIdAll = workOrderStatusIdAll;
    }

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }

    public String getCustomerPoNumber() {
        return customerPoNumber;
    }

    public void setCustomerPoNumber(String customerPoNumber) {
        this.customerPoNumber = customerPoNumber;
    }

    public String getIsWwFlag() {
        return isWwFlag;
    }

    public void setIsWwFlag(String isWwFlag) {
        this.isWwFlag = isWwFlag;
    }

    public Date getLotNumDate() {
        return lotNumDate;
    }

    public void setLotNumDate(Date lotNumDate) {
        this.lotNumDate = lotNumDate;
    }

    public String getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(String requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Long getLotNum() {
        return lotNum;
    }

    public void setLotNum(Long lotNum) {
        this.lotNum = lotNum;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getXianBieFlag() {
        return xianBieFlag;
    }

    @Override
    public String getBeginTime() {
        return beginTime;
    }

    @Override
    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    @Override
    public String getEndTime() {
        return endTime;
    }

    @Override
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setXianBieFlag(String xianBieFlag) {
        this.xianBieFlag = xianBieFlag;
    }

    public Integer getProdLineFlag() {
        return prodLineFlag;
    }

    public void setProdLineFlag(Integer prodLineFlag) {
        this.prodLineFlag = prodLineFlag;
    }

    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getpItemNumber() {
        return pItemNumber;
    }

    public void setpItemNumber(String pItemNumber) {
        this.pItemNumber = pItemNumber;
    }

    public String getpItemDescription() {
        return pItemDescription;
    }

    public void setpItemDescription(String pItemDescription) {
        this.pItemDescription = pItemDescription;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public BigDecimal getWorkPlanQuantity() {
        return workPlanQuantity;
    }

    public void setWorkPlanQuantity(BigDecimal workPlanQuantity) {
        this.workPlanQuantity = workPlanQuantity;
    }

    public Date getPlannedCompletionDate() {
        return plannedCompletionDate;
    }

    public void setPlannedCompletionDate(Date plannedCompletionDate) {
        this.plannedCompletionDate = plannedCompletionDate;
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

    public String getItemWorkNameFlag() {
        return itemWorkNameFlag;
    }

    public void setItemWorkNameFlag(String itemWorkNameFlag) {
        this.itemWorkNameFlag = itemWorkNameFlag;
    }

    public BigDecimal getRequiredQuantity() {
        return requiredQuantity;
    }

    public void setRequiredQuantity(BigDecimal requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
    }

    public Date getRequiredQuantityDate() {
        return requiredQuantityDate;
    }

    public void setRequiredQuantityDate(Date requiredQuantityDate) {
        this.requiredQuantityDate = requiredQuantityDate;
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
    public void setInventoryItemId(Long inventoryItemId)
    {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getInventoryItemId()
    {
        return inventoryItemId;
    }
    public void setIssuedQuantity(BigDecimal issuedQuantity)
    {
        this.issuedQuantity = issuedQuantity;
    }

    public BigDecimal getIssuedQuantity()
    {
        return issuedQuantity;
    }
    public void setSuoHaoQuantity(BigDecimal suoHaoQuantity)
    {
        this.suoHaoQuantity = suoHaoQuantity;
    }

    public BigDecimal getSuoHaoQuantity()
    {
        return suoHaoQuantity;
    }
    public void setTransferedQuantity(BigDecimal transferedQuantity)
    {
        this.transferedQuantity = transferedQuantity;
    }

    public BigDecimal getTransferedQuantity()
    {
        return transferedQuantity;
    }
    public void setOnhandQuantity(BigDecimal onhandQuantity)
    {
        this.onhandQuantity = onhandQuantity;
    }

    public BigDecimal getOnhandQuantity()
    {
        return onhandQuantity;
    }
    public void setReceiveQuantity(BigDecimal receiveQuantity)
    {
        this.receiveQuantity = receiveQuantity;
    }

    public BigDecimal getReceiveQuantity()
    {
        return receiveQuantity;
    }
    public void setBeiLiaoQuantity(BigDecimal beiLiaoQuantity)
    {
        this.beiLiaoQuantity = beiLiaoQuantity;
    }

    public BigDecimal getBeiLiaoQuantity()
    {
        return beiLiaoQuantity;
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
    public void setUntransferQuantity(BigDecimal untransferQuantity)
    {
        this.untransferQuantity = untransferQuantity;
    }

    public BigDecimal getUntransferQuantity()
    {
        return untransferQuantity;
    }
    public void setOverReceiveQuantity(BigDecimal overReceiveQuantity)
    {
        this.overReceiveQuantity = overReceiveQuantity;
    }

    public BigDecimal getOverReceiveQuantity()
    {
        return overReceiveQuantity;
    }
    public void setOverIssueQuantity(BigDecimal overIssueQuantity)
    {
        this.overIssueQuantity = overIssueQuantity;
    }

    public BigDecimal getOverIssueQuantity()
    {
        return overIssueQuantity;
    }
    public void setBackLiaoQuantity(BigDecimal backLiaoQuantity)
    {
        this.backLiaoQuantity = backLiaoQuantity;
    }

    public BigDecimal getBackLiaoQuantity()
    {
        return backLiaoQuantity;
    }
    public void setSupplementQuantity(BigDecimal supplementQuantity)
    {
        this.supplementQuantity = supplementQuantity;
    }

    public BigDecimal getSupplementQuantity()
    {
        return supplementQuantity;
    }
    public void setPlanLotsId(String planLotsId)
    {
        this.planLotsId = planLotsId;
    }

    public String getPlanLotsId()
    {
        return planLotsId;
    }
    public void setWorkOrderLineId(Long workOrderLineId)
    {
        this.workOrderLineId = workOrderLineId;
    }

    public Long getWorkOrderLineId()
    {
        return workOrderLineId;
    }
    public void setPlanId(Long planId)
    {
        this.planId = planId;
    }

    public Long getPlanId()
    {
        return planId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("organizationId", getOrganizationId())
                .append("workOrderId", getWorkOrderId())
                .append("inventoryItemId", getInventoryItemId())
                .append("issuedQuantity", getIssuedQuantity())
                .append("suoHaoQuantity", getSuoHaoQuantity())
                .append("transferedQuantity", getTransferedQuantity())
                .append("onhandQuantity", getOnhandQuantity())
                .append("receiveQuantity", getReceiveQuantity())
                .append("beiLiaoQuantity", getBeiLiaoQuantity())
                .append("createBy", getCreateBy())
                .append("createDate", getCreateDate())
                .append("lastUpdateBy", getLastUpdateBy())
                .append("lastUpdateDate", getLastUpdateDate())
                .append("untransferQuantity", getUntransferQuantity())
                .append("overReceiveQuantity", getOverReceiveQuantity())
                .append("overIssueQuantity", getOverIssueQuantity())
                .append("backLiaoQuantity", getBackLiaoQuantity())
                .append("supplementQuantity", getSupplementQuantity())
                .append("planLotsId", getPlanLotsId())
                .append("workOrderLineId", getWorkOrderLineId())
                .append("planId", getPlanId())
                .toString();
    }
}
