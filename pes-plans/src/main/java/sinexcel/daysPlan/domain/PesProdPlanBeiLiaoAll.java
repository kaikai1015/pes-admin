package sinexcel.daysPlan.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.BeanProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;
import sun.util.locale.LocaleMatcher;

/**
 * 生产计划备料单对象 pes_prod_plan_bei_liao_all
 * 
 * @author Zhang Kai
 * @date 2021-06-16
 */

public class PesProdPlanBeiLiaoAll extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Excel(name = "备料单号", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private Long beiLiaoId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划日期", width = 10, dateFormat = "yyyy-MM-dd")
    private Date lotNumDate;
    @Excel(name = "计划批号", width = 10)
    private Long lotNum;
    @Excel(name = "计划员", width = 10)
    private String planName;
    @Excel(name = "线别", width = 15)
    private String xianBieFlag;
    private String prodLineFlag;

    @Excel(name = "顺序", width = 10)
    private Long lineId;
    @Excel(name = "客户", width = 30)
    private String partyName;
    @Excel(name = "订单号", width = 10)
    private String orderNumber;
    @Excel(name = "成品编码", width = 15)
    private String pItemNumber;
    @Excel(name = "成品描述", width = 40)
    private String pItemDescription;
    @Excel(name = "工单号", width = 10)
    private String workOrderNumber;
    @Excel(name = "计划生产数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal workPlanQuantity;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划完工日期", width = 10, dateFormat = "yyyy-MM-dd")
    private Date plannedCompletionDate;
    @Excel(name = "元件编码", width = 15)
    private String itemNumber;
    @Excel(name = "元件描述", width = 40)
    private String itemDescription;
    @Excel(name = "工艺属性", width = 10,readConverterExp = "1=贴片,2=插件,3=装配,4=辅料")
    private String itemWorkNameFlag;
    @Excel(name = "需求数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal requiredQuantity;
    @Excel(name = "已领料数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal issuedQuantity;
    @Excel(name = "损耗数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal suoHaoQuantity;
    @Excel(name = "已调拨数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal transferedQuantity;
    @Excel(name = "待调拨数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal untransferQuantity;
    @Excel(name = "库存数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal onhandQuantity;
    @Excel(name = "待检数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal receiveQuantity;
    @Excel(name = "备料数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal beiLiaoQuantity;
    @Excel(name = "欠料数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal qianliaoQuantity;

    @Excel(name = "调拨状态", width = 10,readConverterExp = "Y=是,N=否")
    private String transferedFlag;
    private Long id;
    private String createBy;

    /**-----新增---2021.08.23-----*/
    @Excel(name = "调出数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal diaoChuQuantity;
    @Excel(name = "调入接收数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal diaoRuQuantity;
    @Excel(name = "实际周转数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal turnoverQuantity;
    @Excel(name = "补料数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal supplementQuantity;
    @Excel(name = "调出子库", width = 15)
    private String diaoChuSubinventory;
    @Excel(name = "接收子库", width = 15)
    private String diaoRuSubinventory;
    @Excel(name = "周转子库", width = 15)
    private String turnoverSubinventory;
    @Excel(name = "申请单状态", width = 10,readConverterExp = "0=未发放,1=转入周转中,2=待生产接收,3=已完成")
    private String state;
    /**------新增结束------*/


    public BigDecimal getDiaoChuQuantity() {
        return diaoChuQuantity;
    }

    public void setDiaoChuQuantity(BigDecimal diaoChuQuantity) {
        this.diaoChuQuantity = diaoChuQuantity;
    }

    public BigDecimal getDiaoRuQuantity() {
        return diaoRuQuantity;
    }

    public void setDiaoRuQuantity(BigDecimal diaoRuQuantity) {
        this.diaoRuQuantity = diaoRuQuantity;
    }

    public BigDecimal getTurnoverQuantity() {
        return turnoverQuantity;
    }

    public void setTurnoverQuantity(BigDecimal turnoverQuantity) {
        this.turnoverQuantity = turnoverQuantity;
    }

    public String getDiaoChuSubinventory() {
        return diaoChuSubinventory;
    }

    public void setDiaoChuSubinventory(String diaoChuSubinventory) {
        this.diaoChuSubinventory = diaoChuSubinventory;
    }

    public String getDiaoRuSubinventory() {
        return diaoRuSubinventory;
    }

    public void setDiaoRuSubinventory(String diaoRuSubinventory) {
        this.diaoRuSubinventory = diaoRuSubinventory;
    }

    public String getTurnoverSubinventory() {
        return turnoverSubinventory;
    }

    public void setTurnoverSubinventory(String turnoverSubinventory) {
        this.turnoverSubinventory = turnoverSubinventory;
    }

    public BigDecimal getSupplementQuantity() {
        return supplementQuantity;
    }

    public void setSupplementQuantity(BigDecimal supplementQuantity) {
        this.supplementQuantity = supplementQuantity;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getUntransferQuantity() {
        return untransferQuantity;
    }

    public void setUntransferQuantity(BigDecimal untransferQuantity) {
        this.untransferQuantity = untransferQuantity;
    }

    public BigDecimal getQianliaoQuantity() {
        return qianliaoQuantity;
    }

    public void setQianliaoQuantity(BigDecimal qianliaoQuantity) {
        this.qianliaoQuantity = qianliaoQuantity;
    }


    public String getItemWorkNameFlag() {
        return itemWorkNameFlag;
    }

    public void setItemWorkNameFlag(String itemWorkNameFlag) {
        this.itemWorkNameFlag = itemWorkNameFlag;
    }
    public String getXianBieFlag() {
        return xianBieFlag;
    }

    public void setXianBieFlag(String xianBieFlag) {
        this.xianBieFlag = xianBieFlag;
    }

    public Long getBeiLiaoId() {
        return beiLiaoId;
    }

    public void setBeiLiaoId(Long beiLiaoId) {
        this.beiLiaoId = beiLiaoId;
    }

    public Date getLotNumDate() {
        return lotNumDate;
    }

    public void setLotNumDate(Date lotNumDate) {
        this.lotNumDate = lotNumDate;
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

    public String getProdLineFlag() {
        return prodLineFlag;
    }

    public void setProdLineFlag(String prodLineFlag) {
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

    public BigDecimal getRequiredQuantity() {
        return requiredQuantity;
    }

    public void setRequiredQuantity(BigDecimal requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
    }

    public BigDecimal getIssuedQuantity() {
        return issuedQuantity;
    }

    public void setIssuedQuantity(BigDecimal issuedQuantity) {
        this.issuedQuantity = issuedQuantity;
    }

    public BigDecimal getSuoHaoQuantity() {
        return suoHaoQuantity;
    }

    public void setSuoHaoQuantity(BigDecimal suoHaoQuantity) {
        this.suoHaoQuantity = suoHaoQuantity;
    }

    public BigDecimal getTransferedQuantity() {
        return transferedQuantity;
    }

    public void setTransferedQuantity(BigDecimal transferedQuantity) {
        this.transferedQuantity = transferedQuantity;
    }

    public String getTransferedFlag() {
        return transferedFlag;
    }

    public void setTransferedFlag(String transferedFlag) {
        this.transferedFlag = transferedFlag;
    }

    public BigDecimal getOnhandQuantity() {
        return onhandQuantity;
    }

    public void setOnhandQuantity(BigDecimal onhandQuantity) {
        this.onhandQuantity = onhandQuantity;
    }

    public BigDecimal getReceiveQuantity() {
        return receiveQuantity;
    }

    public void setReceiveQuantity(BigDecimal receiveQuantity) {
        this.receiveQuantity = receiveQuantity;
    }

    public BigDecimal getBeiLiaoQuantity() {
        return beiLiaoQuantity;
    }

    public void setBeiLiaoQuantity(BigDecimal beiLiaoQuantity) {
        this.beiLiaoQuantity = beiLiaoQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
