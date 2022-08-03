package sinexcel.works.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import sinexcel.common.annotation.Excel;

/**
 * 创建工单数据对象 pes_wie_works_headers_all
 *
 * @author Zhang Kai
 * @date 2021-04-18
 */
public class PesWieWorksHeadersAll
{
    /** $column.columnComment */
    @Excel(name = "序号", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private Long wieWorkId;
    /** 库存组织 */
    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X")
    private Long organizationId;

    /** ERP工单 */
    @Excel(name = "ERP工单", width = 15)
    private String erpWork;

    private Integer erpWorkStatus;

    /** $column.columnComment */
    private Long inventoryItemId;

    /** 物料编码 */
    @Excel(name = "成品编码", width = 15)
    private String itemNumber;

    /** 物料描述 */
    @Excel(name = "成品描述", width = 40)
    private String itemDescription;

    /** 工作定义 */
    @Excel(name = "工作定义", width = 10)
    private String workDefinitionCode;

    /** 计划生产数量 */
    @Excel(name = "计划生产数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal plannedStartQuantity;

    /** 计划生产日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划生产日期", width = 10, dateFormat = "yyyy-MM-dd")
    private Date plannedStartDate;

    /** 计划批次行号 */
    @Excel(name = "计划批次行号", width = 30)
    private String lineNums;

    @Excel(name = "订单号", width = 15)
    private String documentNumbers;
    @Excel(name = "行号", width = 10)
    private String documentLineNums;
    @Excel(name = "合同号", width = 20)
    private String custPoNumbers;

    /** $column.columnComment */
    private Date createDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastUpdateDate;

    private String createBy;

    private String organizationCode;

    private String errorInfor;

    private String remark;

    private Long erpWorkNumberId;
    private BigDecimal splitQuantity;
    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String beginTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String endTime;

    private String customerName;

    private String linesLotsFlag;

    public String getLinesLotsFlag() {
        return linesLotsFlag;
    }

    public void setLinesLotsFlag(String linesLotsFlag) {
        this.linesLotsFlag = linesLotsFlag;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getErpWorkStatus() {
        return erpWorkStatus;
    }

    public void setErpWorkStatus(Integer erpWorkStatus) {
        this.erpWorkStatus = erpWorkStatus;
    }

    public BigDecimal getSplitQuantity() {
        return splitQuantity;
    }

    public void setSplitQuantity(BigDecimal splitQuantity) {
        this.splitQuantity = splitQuantity;
    }

    public Long getErpWorkNumberId() {
        return erpWorkNumberId;
    }

    public void setErpWorkNumberId(Long erpWorkNumberId) {
        this.erpWorkNumberId = erpWorkNumberId;
    }

    public String getDocumentLineNums() {
        return documentLineNums;
    }

    public void setDocumentLineNums(String documentLineNums) {
        this.documentLineNums = documentLineNums;
    }

    public String getDocumentNumbers() {
        return documentNumbers;
    }

    public void setDocumentNumbers(String documentNumbers) {
        this.documentNumbers = documentNumbers;
    }

    public String getCustPoNumbers() {
        return custPoNumbers;
    }

    public void setCustPoNumbers(String custPoNumbers) {
        this.custPoNumbers = custPoNumbers;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getErrorInfor() {
        return errorInfor;
    }

    public void setErrorInfor(String errorInfor) {
        this.errorInfor = errorInfor;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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
    public void setWorkDefinitionCode(String workDefinitionCode)
    {
        this.workDefinitionCode = workDefinitionCode;
    }

    public String getWorkDefinitionCode()
    {
        return workDefinitionCode;
    }
    public void setPlannedStartQuantity(BigDecimal plannedStartQuantity)
    {
        this.plannedStartQuantity = plannedStartQuantity;
    }

    public BigDecimal getPlannedStartQuantity()
    {
        return plannedStartQuantity;
    }
    public void setPlannedStartDate(Date plannedStartDate)
    {
        this.plannedStartDate = plannedStartDate;
    }

    public Date getPlannedStartDate()
    {
        return plannedStartDate;
    }
    public void setLineNums(String lineNums)
    {
        this.lineNums = lineNums;
    }

    public String getLineNums()
    {
        return lineNums;
    }
    public void setErpWork(String erpWork)
    {
        this.erpWork = erpWork;
    }

    public String getErpWork()
    {
        return erpWork;
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
    public void setWieWorkId(Long wieWorkId)
    {
        this.wieWorkId = wieWorkId;
    }

    public Long getWieWorkId()
    {
        return wieWorkId;
    }
}
