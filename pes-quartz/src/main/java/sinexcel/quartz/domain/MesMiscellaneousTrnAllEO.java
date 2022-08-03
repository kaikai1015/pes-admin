package sinexcel.quartz.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import sinexcel.common.annotation.Excel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 杂入，杂出对象 mes_miscellaneous_trn_all
 *
 * @author Zhang Kai
 * @date 2021-02-02
 */
public class MesMiscellaneousTrnAllEO {
    /** 物料ID */
    private Long inventoryItemId;


    /** 库存组织ID */
    /** 库存组织 */
    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X")
    private Long organizationId;

    /** 物料编码 */
    @Excel(name = "物料编码", width = 15)
    private String itemNumber;

    /** 交易数量（杂入正数，杂出负数） */
    @Excel(name = "交易数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal transactionQuantity;

    @Excel(name = "当前库存", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal onhandQuantity;
    @Excel(name = "差异数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal chayiQuantity;

    /** 单位 */
    private String uomCode;

    /** 交易日期 */
    private Date transactionDate;

    /** 仓库 */
    @Excel(name = "仓库", width = 10)
    private String subinventoryCode;

    /** 账户别名 */
    private String sourceCode;

    /** 账户别名 */
    private Long transactionSourceTypeId;

    /** 是否使用当前成本（Y是，N否） */
    private String useCurrentCost;

    /** 成本 */
    private BigDecimal unitCost;

    /** 成本代码 */
    private String costComponentCode;

    /** 最后同步时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate;

    /** ERP回传标识（0未回写，1回写成功，2回写失败） */
    private String erpFlag;

    /** erp回写时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date erpFlagDate;

    /** 主键ID */
    private Long transactionId;

    @Excel(name = "MES主键", width = 10)
    private String remark;

    /** 最后同步时间 */
    private String startUpdateDate;

    /** 最后同步时间 */
    private String endUpdateDate;

    private Long transactionSourceId;

    /** 杂入，杂出ID（I杂入，O杂出） */
    private Long transactionTypeId;

    private Integer lotControlCode;

    private String contractNumber;
    private String shProject;
    private String shEmployee;
    private String shDepartment;
    private String shWwSupplier;
    private String shProductLine;
    private String shTextContractNum;
    private String errorInfor;
    private String wmsRemarkDescription;

    public String getWmsRemarkDescription() {
        return wmsRemarkDescription;
    }

    public void setWmsRemarkDescription(String wmsRemarkDescription) {
        this.wmsRemarkDescription = wmsRemarkDescription;
    }

    public BigDecimal getChayiQuantity() {
        return chayiQuantity;
    }

    public void setChayiQuantity(BigDecimal chayiQuantity) {
        this.chayiQuantity = chayiQuantity;
    }

    public BigDecimal getOnhandQuantity() {
        return onhandQuantity;
    }

    public void setOnhandQuantity(BigDecimal onhandQuantity) {
        this.onhandQuantity = onhandQuantity;
    }

    public String getErrorInfor() {
        return errorInfor;
    }

    public void setErrorInfor(String errorInfor) {
        this.errorInfor = errorInfor;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getShProject() {
        return shProject;
    }

    public void setShProject(String shProject) {
        this.shProject = shProject;
    }

    public String getShEmployee() {
        return shEmployee;
    }

    public void setShEmployee(String shEmployee) {
        this.shEmployee = shEmployee;
    }

    public String getShDepartment() {
        return shDepartment;
    }

    public void setShDepartment(String shDepartment) {
        this.shDepartment = shDepartment;
    }

    public String getShWwSupplier() {
        return shWwSupplier;
    }

    public void setShWwSupplier(String shWwSupplier) {
        this.shWwSupplier = shWwSupplier;
    }

    public String getShProductLine() {
        return shProductLine;
    }

    public void setShProductLine(String shProductLine) {
        this.shProductLine = shProductLine;
    }

    public String getShTextContractNum() {
        return shTextContractNum;
    }

    public void setShTextContractNum(String shTextContractNum) {
        this.shTextContractNum = shTextContractNum;
    }



    public Integer getLotControlCode() {
        return lotControlCode;
    }

    public void setLotControlCode(Integer lotControlCode) {
        this.lotControlCode = lotControlCode;
    }

    public Long getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public Long getTransactionSourceId() {
        return transactionSourceId;
    }

    public void setTransactionSourceId(Long transactionSourceId) {
        this.transactionSourceId = transactionSourceId;
    }

    public String getStartUpdateDate() {
        return startUpdateDate;
    }

    public void setStartUpdateDate(String startUpdateDate) {
        this.startUpdateDate = startUpdateDate;
    }

    public String getEndUpdateDate() {
        return endUpdateDate;
    }

    public void setEndUpdateDate(String endUpdateDate) {
        this.endUpdateDate = endUpdateDate;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public BigDecimal getTransactionQuantity() {
        return transactionQuantity;
    }

    public void setTransactionQuantity(BigDecimal transactionQuantity) {
        this.transactionQuantity = transactionQuantity;
    }

    public String getUomCode() {
        return uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public Long getTransactionSourceTypeId() {
        return transactionSourceTypeId;
    }

    public void setTransactionSourceTypeId(Long transactionSourceTypeId) {
        this.transactionSourceTypeId = transactionSourceTypeId;
    }

    public String getUseCurrentCost() {
        return useCurrentCost;
    }

    public void setUseCurrentCost(String useCurrentCost) {
        this.useCurrentCost = useCurrentCost;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public String getCostComponentCode() {
        return costComponentCode;
    }

    public void setCostComponentCode(String costComponentCode) {
        this.costComponentCode = costComponentCode;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getErpFlag() {
        return erpFlag;
    }

    public void setErpFlag(String erpFlag) {
        this.erpFlag = erpFlag;
    }

    public Date getErpFlagDate() {
        return erpFlagDate;
    }

    public void setErpFlagDate(Date erpFlagDate) {
        this.erpFlagDate = erpFlagDate;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
