package sinexcel.items.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import sinexcel.common.annotation.Excel;

import java.math.BigDecimal;
import java.util.Date;

public class CuxInvSupplyDemandMaterialSumQuantityAllEO {

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X")
    private Long organizationId;
    @Excel(name = "物料编码", width = 15)
    private String itemNumber;

    /** 物料描述 */
    @Excel(name = "物料描述", width = 40)
    private String itemDescription;
    @Excel(name = "年份", width = 5,cellType = Excel.ColumnType.BigDecimal)
    private Integer transactionYear;

    @Excel(name = "18年期初", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal augYears;
    @Excel(name = "19年期初", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal segYears;
    @Excel(name = "20年期初", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal zeroYears;
    @Excel(name = "21年期初", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal janYears;
    @Excel(name = "22年期初", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal febYears;

    @Excel(name = "当前库存", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal quantity;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "最近交易时间", width = 15, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date maxTransactionDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "首次入库时间", width = 15, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date minTransactionDate;

    @Excel(name = "一月订单销货", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal janOrderDemandQuantity;
    @Excel(name = "一月工单入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal janWieSupplyQuantity;
    @Excel(name = "一月工单发料", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal janWieDemandQuantity;
    @Excel(name = "一月PO入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal janPoSupplyQuantity;
    @Excel(name = "一月其它出入", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal janOtherQuantity;

    @Excel(name = "二月订单销货", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal febOrderDemandQuantity;
    @Excel(name = "二月工单入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal febWieSupplyQuantity;
    @Excel(name = "二月工单发料", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal febWieDemandQuantity;
    @Excel(name = "二月PO入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal febPoSupplyQuantity;
    @Excel(name = "二月其它出入", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal febOtherQuantity;

    @Excel(name = "三月订单销货", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal marOrderDemandQuantity;
    @Excel(name = "三月工单入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal marWieSupplyQuantity;
    @Excel(name = "三月工单发料", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal marWieDemandQuantity;
    @Excel(name = "三月PO入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal marPoSupplyQuantity;
    @Excel(name = "三月其它出入", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal marOtherQuantity;

    @Excel(name = "四月订单销货", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal aprOrderDemandQuantity;
    @Excel(name = "四月工单入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal aprWieSupplyQuantity;
    @Excel(name = "四月工单发料", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal aprWieDemandQuantity;
    @Excel(name = "四月PO入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal aprPoSupplyQuantity;
    @Excel(name = "四月其它出入", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal aprOtherQuantity;

    @Excel(name = "五月订单销货", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal mayOrderDemandQuantity;
    @Excel(name = "五月工单入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal mayWieSupplyQuantity;
    @Excel(name = "五月工单发料", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal mayWieDemandQuantity;
    @Excel(name = "五月PO入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal mayPoSupplyQuantity;
    @Excel(name = "五月其它出入", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal mayOtherQuantity;

    @Excel(name = "六月订单销货", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal junOrderDemandQuantity;
    @Excel(name = "六月工单入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal junWieSupplyQuantity;
    @Excel(name = "六月工单发料", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal junWieDemandQuantity;
    @Excel(name = "六月PO入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal junPoSupplyQuantity;
    @Excel(name = "六月其它出入", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal junOtherQuantity;

    @Excel(name = "七月订单销货", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal julOrderDemandQuantity;
    @Excel(name = "七月工单入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal julWieSupplyQuantity;
    @Excel(name = "七月工单发料", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal julWieDemandQuantity;
    @Excel(name = "七月PO入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal julPoSupplyQuantity;
    @Excel(name = "七月其它出入", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal julOtherQuantity;

    @Excel(name = "八月订单销货", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal augOrderDemandQuantity;
    @Excel(name = "八月工单入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal augWieSupplyQuantity;
    @Excel(name = "八月工单发料", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal augWieDemandQuantity;
    @Excel(name = "八月PO入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal augPoSupplyQuantity;
    @Excel(name = "八月其它出入", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal augOtherQuantity;

    @Excel(name = "九月订单销货", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal sepOrderDemandQuantity;
    @Excel(name = "九月工单入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal sepWieSupplyQuantity;
    @Excel(name = "九月工单发料", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal sepWieDemandQuantity;
    @Excel(name = "九月PO入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal sepPoSupplyQuantity;
    @Excel(name = "九月其它出入", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal sepOtherQuantity;

    @Excel(name = "十月订单销货", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal octOrderDemandQuantity;
    @Excel(name = "十月工单入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal octWieSupplyQuantity;
    @Excel(name = "十月工单发料", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal octWieDemandQuantity;
    @Excel(name = "十月PO入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal octPoSupplyQuantity;
    @Excel(name = "十月其它出入", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal octOtherQuantity;

    @Excel(name = "十一月订单销货", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal novOrderDemandQuantity;
    @Excel(name = "十一月工单入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal novWieSupplyQuantity;
    @Excel(name = "十一月工单发料", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal novWieDemandQuantity;
    @Excel(name = "十一月PO入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal novPoSupplyQuantity;
    @Excel(name = "十一月其它出入", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal novOtherQuantity;

    @Excel(name = "十二月订单销货", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal decOrderDemandQuantity;
    @Excel(name = "十二月工单入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal decWieSupplyQuantity;
    @Excel(name = "十二月工单发料", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal decWieDemandQuantity;
    @Excel(name = "十二月PO入库", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal decPoSupplyQuantity;
    @Excel(name = "十二月其它出入", width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal decOtherQuantity;


    public Date getMaxTransactionDate() {
        return maxTransactionDate;
    }

    public void setMaxTransactionDate(Date maxTransactionDate) {
        this.maxTransactionDate = maxTransactionDate;
    }

    public Date getMinTransactionDate() {
        return minTransactionDate;
    }

    public void setMinTransactionDate(Date minTransactionDate) {
        this.minTransactionDate = minTransactionDate;
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

    public Integer getTransactionYear() {
        return transactionYear;
    }

    public void setTransactionYear(Integer transactionYear) {
        this.transactionYear = transactionYear;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAugYears() {
        return augYears;
    }

    public void setAugYears(BigDecimal augYears) {
        this.augYears = augYears;
    }

    public BigDecimal getSegYears() {
        return segYears;
    }

    public void setSegYears(BigDecimal segYears) {
        this.segYears = segYears;
    }

    public BigDecimal getZeroYears() {
        return zeroYears;
    }

    public void setZeroYears(BigDecimal zeroYears) {
        this.zeroYears = zeroYears;
    }

    public BigDecimal getJanYears() {
        return janYears;
    }

    public void setJanYears(BigDecimal janYears) {
        this.janYears = janYears;
    }

    public BigDecimal getFebYears() {
        return febYears;
    }

    public void setFebYears(BigDecimal febYears) {
        this.febYears = febYears;
    }

    public BigDecimal getJanOrderDemandQuantity() {
        return janOrderDemandQuantity;
    }

    public void setJanOrderDemandQuantity(BigDecimal janOrderDemandQuantity) {
        this.janOrderDemandQuantity = janOrderDemandQuantity;
    }

    public BigDecimal getFebOrderDemandQuantity() {
        return febOrderDemandQuantity;
    }

    public void setFebOrderDemandQuantity(BigDecimal febOrderDemandQuantity) {
        this.febOrderDemandQuantity = febOrderDemandQuantity;
    }

    public BigDecimal getMarOrderDemandQuantity() {
        return marOrderDemandQuantity;
    }

    public void setMarOrderDemandQuantity(BigDecimal marOrderDemandQuantity) {
        this.marOrderDemandQuantity = marOrderDemandQuantity;
    }

    public BigDecimal getAprOrderDemandQuantity() {
        return aprOrderDemandQuantity;
    }

    public void setAprOrderDemandQuantity(BigDecimal aprOrderDemandQuantity) {
        this.aprOrderDemandQuantity = aprOrderDemandQuantity;
    }

    public BigDecimal getMayOrderDemandQuantity() {
        return mayOrderDemandQuantity;
    }

    public void setMayOrderDemandQuantity(BigDecimal mayOrderDemandQuantity) {
        this.mayOrderDemandQuantity = mayOrderDemandQuantity;
    }

    public BigDecimal getJunOrderDemandQuantity() {
        return junOrderDemandQuantity;
    }

    public void setJunOrderDemandQuantity(BigDecimal junOrderDemandQuantity) {
        this.junOrderDemandQuantity = junOrderDemandQuantity;
    }

    public BigDecimal getJulOrderDemandQuantity() {
        return julOrderDemandQuantity;
    }

    public void setJulOrderDemandQuantity(BigDecimal julOrderDemandQuantity) {
        this.julOrderDemandQuantity = julOrderDemandQuantity;
    }

    public BigDecimal getAugOrderDemandQuantity() {
        return augOrderDemandQuantity;
    }

    public void setAugOrderDemandQuantity(BigDecimal augOrderDemandQuantity) {
        this.augOrderDemandQuantity = augOrderDemandQuantity;
    }

    public BigDecimal getSepOrderDemandQuantity() {
        return sepOrderDemandQuantity;
    }

    public void setSepOrderDemandQuantity(BigDecimal sepOrderDemandQuantity) {
        this.sepOrderDemandQuantity = sepOrderDemandQuantity;
    }

    public BigDecimal getOctOrderDemandQuantity() {
        return octOrderDemandQuantity;
    }

    public void setOctOrderDemandQuantity(BigDecimal octOrderDemandQuantity) {
        this.octOrderDemandQuantity = octOrderDemandQuantity;
    }

    public BigDecimal getNovOrderDemandQuantity() {
        return novOrderDemandQuantity;
    }

    public void setNovOrderDemandQuantity(BigDecimal novOrderDemandQuantity) {
        this.novOrderDemandQuantity = novOrderDemandQuantity;
    }

    public BigDecimal getDecOrderDemandQuantity() {
        return decOrderDemandQuantity;
    }

    public void setDecOrderDemandQuantity(BigDecimal decOrderDemandQuantity) {
        this.decOrderDemandQuantity = decOrderDemandQuantity;
    }

    public BigDecimal getJanWieSupplyQuantity() {
        return janWieSupplyQuantity;
    }

    public void setJanWieSupplyQuantity(BigDecimal janWieSupplyQuantity) {
        this.janWieSupplyQuantity = janWieSupplyQuantity;
    }

    public BigDecimal getFebWieSupplyQuantity() {
        return febWieSupplyQuantity;
    }

    public void setFebWieSupplyQuantity(BigDecimal febWieSupplyQuantity) {
        this.febWieSupplyQuantity = febWieSupplyQuantity;
    }

    public BigDecimal getMarWieSupplyQuantity() {
        return marWieSupplyQuantity;
    }

    public void setMarWieSupplyQuantity(BigDecimal marWieSupplyQuantity) {
        this.marWieSupplyQuantity = marWieSupplyQuantity;
    }

    public BigDecimal getAprWieSupplyQuantity() {
        return aprWieSupplyQuantity;
    }

    public void setAprWieSupplyQuantity(BigDecimal aprWieSupplyQuantity) {
        this.aprWieSupplyQuantity = aprWieSupplyQuantity;
    }

    public BigDecimal getMayWieSupplyQuantity() {
        return mayWieSupplyQuantity;
    }

    public void setMayWieSupplyQuantity(BigDecimal mayWieSupplyQuantity) {
        this.mayWieSupplyQuantity = mayWieSupplyQuantity;
    }

    public BigDecimal getJunWieSupplyQuantity() {
        return junWieSupplyQuantity;
    }

    public void setJunWieSupplyQuantity(BigDecimal junWieSupplyQuantity) {
        this.junWieSupplyQuantity = junWieSupplyQuantity;
    }

    public BigDecimal getJulWieSupplyQuantity() {
        return julWieSupplyQuantity;
    }

    public void setJulWieSupplyQuantity(BigDecimal julWieSupplyQuantity) {
        this.julWieSupplyQuantity = julWieSupplyQuantity;
    }

    public BigDecimal getAugWieSupplyQuantity() {
        return augWieSupplyQuantity;
    }

    public void setAugWieSupplyQuantity(BigDecimal augWieSupplyQuantity) {
        this.augWieSupplyQuantity = augWieSupplyQuantity;
    }

    public BigDecimal getSepWieSupplyQuantity() {
        return sepWieSupplyQuantity;
    }

    public void setSepWieSupplyQuantity(BigDecimal sepWieSupplyQuantity) {
        this.sepWieSupplyQuantity = sepWieSupplyQuantity;
    }

    public BigDecimal getOctWieSupplyQuantity() {
        return octWieSupplyQuantity;
    }

    public void setOctWieSupplyQuantity(BigDecimal octWieSupplyQuantity) {
        this.octWieSupplyQuantity = octWieSupplyQuantity;
    }

    public BigDecimal getNovWieSupplyQuantity() {
        return novWieSupplyQuantity;
    }

    public void setNovWieSupplyQuantity(BigDecimal novWieSupplyQuantity) {
        this.novWieSupplyQuantity = novWieSupplyQuantity;
    }

    public BigDecimal getDecWieSupplyQuantity() {
        return decWieSupplyQuantity;
    }

    public void setDecWieSupplyQuantity(BigDecimal decWieSupplyQuantity) {
        this.decWieSupplyQuantity = decWieSupplyQuantity;
    }

    public BigDecimal getJanWieDemandQuantity() {
        return janWieDemandQuantity;
    }

    public void setJanWieDemandQuantity(BigDecimal janWieDemandQuantity) {
        this.janWieDemandQuantity = janWieDemandQuantity;
    }

    public BigDecimal getFebWieDemandQuantity() {
        return febWieDemandQuantity;
    }

    public void setFebWieDemandQuantity(BigDecimal febWieDemandQuantity) {
        this.febWieDemandQuantity = febWieDemandQuantity;
    }

    public BigDecimal getMarWieDemandQuantity() {
        return marWieDemandQuantity;
    }

    public void setMarWieDemandQuantity(BigDecimal marWieDemandQuantity) {
        this.marWieDemandQuantity = marWieDemandQuantity;
    }

    public BigDecimal getAprWieDemandQuantity() {
        return aprWieDemandQuantity;
    }

    public void setAprWieDemandQuantity(BigDecimal aprWieDemandQuantity) {
        this.aprWieDemandQuantity = aprWieDemandQuantity;
    }

    public BigDecimal getMayWieDemandQuantity() {
        return mayWieDemandQuantity;
    }

    public void setMayWieDemandQuantity(BigDecimal mayWieDemandQuantity) {
        this.mayWieDemandQuantity = mayWieDemandQuantity;
    }

    public BigDecimal getJunWieDemandQuantity() {
        return junWieDemandQuantity;
    }

    public void setJunWieDemandQuantity(BigDecimal junWieDemandQuantity) {
        this.junWieDemandQuantity = junWieDemandQuantity;
    }

    public BigDecimal getJulWieDemandQuantity() {
        return julWieDemandQuantity;
    }

    public void setJulWieDemandQuantity(BigDecimal julWieDemandQuantity) {
        this.julWieDemandQuantity = julWieDemandQuantity;
    }

    public BigDecimal getAugWieDemandQuantity() {
        return augWieDemandQuantity;
    }

    public void setAugWieDemandQuantity(BigDecimal augWieDemandQuantity) {
        this.augWieDemandQuantity = augWieDemandQuantity;
    }

    public BigDecimal getSepWieDemandQuantity() {
        return sepWieDemandQuantity;
    }

    public void setSepWieDemandQuantity(BigDecimal sepWieDemandQuantity) {
        this.sepWieDemandQuantity = sepWieDemandQuantity;
    }

    public BigDecimal getOctWieDemandQuantity() {
        return octWieDemandQuantity;
    }

    public void setOctWieDemandQuantity(BigDecimal octWieDemandQuantity) {
        this.octWieDemandQuantity = octWieDemandQuantity;
    }

    public BigDecimal getNovWieDemandQuantity() {
        return novWieDemandQuantity;
    }

    public void setNovWieDemandQuantity(BigDecimal novWieDemandQuantity) {
        this.novWieDemandQuantity = novWieDemandQuantity;
    }

    public BigDecimal getDecWieDemandQuantity() {
        return decWieDemandQuantity;
    }

    public void setDecWieDemandQuantity(BigDecimal decWieDemandQuantity) {
        this.decWieDemandQuantity = decWieDemandQuantity;
    }

    public BigDecimal getJanPoSupplyQuantity() {
        return janPoSupplyQuantity;
    }

    public void setJanPoSupplyQuantity(BigDecimal janPoSupplyQuantity) {
        this.janPoSupplyQuantity = janPoSupplyQuantity;
    }

    public BigDecimal getFebPoSupplyQuantity() {
        return febPoSupplyQuantity;
    }

    public void setFebPoSupplyQuantity(BigDecimal febPoSupplyQuantity) {
        this.febPoSupplyQuantity = febPoSupplyQuantity;
    }

    public BigDecimal getMarPoSupplyQuantity() {
        return marPoSupplyQuantity;
    }

    public void setMarPoSupplyQuantity(BigDecimal marPoSupplyQuantity) {
        this.marPoSupplyQuantity = marPoSupplyQuantity;
    }

    public BigDecimal getAprPoSupplyQuantity() {
        return aprPoSupplyQuantity;
    }

    public void setAprPoSupplyQuantity(BigDecimal aprPoSupplyQuantity) {
        this.aprPoSupplyQuantity = aprPoSupplyQuantity;
    }

    public BigDecimal getMayPoSupplyQuantity() {
        return mayPoSupplyQuantity;
    }

    public void setMayPoSupplyQuantity(BigDecimal mayPoSupplyQuantity) {
        this.mayPoSupplyQuantity = mayPoSupplyQuantity;
    }

    public BigDecimal getJunPoSupplyQuantity() {
        return junPoSupplyQuantity;
    }

    public void setJunPoSupplyQuantity(BigDecimal junPoSupplyQuantity) {
        this.junPoSupplyQuantity = junPoSupplyQuantity;
    }

    public BigDecimal getJulPoSupplyQuantity() {
        return julPoSupplyQuantity;
    }

    public void setJulPoSupplyQuantity(BigDecimal julPoSupplyQuantity) {
        this.julPoSupplyQuantity = julPoSupplyQuantity;
    }

    public BigDecimal getAugPoSupplyQuantity() {
        return augPoSupplyQuantity;
    }

    public void setAugPoSupplyQuantity(BigDecimal augPoSupplyQuantity) {
        this.augPoSupplyQuantity = augPoSupplyQuantity;
    }

    public BigDecimal getSepPoSupplyQuantity() {
        return sepPoSupplyQuantity;
    }

    public void setSepPoSupplyQuantity(BigDecimal sepPoSupplyQuantity) {
        this.sepPoSupplyQuantity = sepPoSupplyQuantity;
    }

    public BigDecimal getOctPoSupplyQuantity() {
        return octPoSupplyQuantity;
    }

    public void setOctPoSupplyQuantity(BigDecimal octPoSupplyQuantity) {
        this.octPoSupplyQuantity = octPoSupplyQuantity;
    }

    public BigDecimal getNovPoSupplyQuantity() {
        return novPoSupplyQuantity;
    }

    public void setNovPoSupplyQuantity(BigDecimal novPoSupplyQuantity) {
        this.novPoSupplyQuantity = novPoSupplyQuantity;
    }

    public BigDecimal getDecPoSupplyQuantity() {
        return decPoSupplyQuantity;
    }

    public void setDecPoSupplyQuantity(BigDecimal decPoSupplyQuantity) {
        this.decPoSupplyQuantity = decPoSupplyQuantity;
    }

    public BigDecimal getJanOtherQuantity() {
        return janOtherQuantity;
    }

    public void setJanOtherQuantity(BigDecimal janOtherQuantity) {
        this.janOtherQuantity = janOtherQuantity;
    }

    public BigDecimal getFebOtherQuantity() {
        return febOtherQuantity;
    }

    public void setFebOtherQuantity(BigDecimal febOtherQuantity) {
        this.febOtherQuantity = febOtherQuantity;
    }

    public BigDecimal getMarOtherQuantity() {
        return marOtherQuantity;
    }

    public void setMarOtherQuantity(BigDecimal marOtherQuantity) {
        this.marOtherQuantity = marOtherQuantity;
    }

    public BigDecimal getAprOtherQuantity() {
        return aprOtherQuantity;
    }

    public void setAprOtherQuantity(BigDecimal aprOtherQuantity) {
        this.aprOtherQuantity = aprOtherQuantity;
    }

    public BigDecimal getMayOtherQuantity() {
        return mayOtherQuantity;
    }

    public void setMayOtherQuantity(BigDecimal mayOtherQuantity) {
        this.mayOtherQuantity = mayOtherQuantity;
    }

    public BigDecimal getJunOtherQuantity() {
        return junOtherQuantity;
    }

    public void setJunOtherQuantity(BigDecimal junOtherQuantity) {
        this.junOtherQuantity = junOtherQuantity;
    }

    public BigDecimal getJulOtherQuantity() {
        return julOtherQuantity;
    }

    public void setJulOtherQuantity(BigDecimal julOtherQuantity) {
        this.julOtherQuantity = julOtherQuantity;
    }

    public BigDecimal getAugOtherQuantity() {
        return augOtherQuantity;
    }

    public void setAugOtherQuantity(BigDecimal augOtherQuantity) {
        this.augOtherQuantity = augOtherQuantity;
    }

    public BigDecimal getSepOtherQuantity() {
        return sepOtherQuantity;
    }

    public void setSepOtherQuantity(BigDecimal sepOtherQuantity) {
        this.sepOtherQuantity = sepOtherQuantity;
    }

    public BigDecimal getOctOtherQuantity() {
        return octOtherQuantity;
    }

    public void setOctOtherQuantity(BigDecimal octOtherQuantity) {
        this.octOtherQuantity = octOtherQuantity;
    }

    public BigDecimal getNovOtherQuantity() {
        return novOtherQuantity;
    }

    public void setNovOtherQuantity(BigDecimal novOtherQuantity) {
        this.novOtherQuantity = novOtherQuantity;
    }

    public BigDecimal getDecOtherQuantity() {
        return decOtherQuantity;
    }

    public void setDecOtherQuantity(BigDecimal decOtherQuantity) {
        this.decOtherQuantity = decOtherQuantity;
    }
}
