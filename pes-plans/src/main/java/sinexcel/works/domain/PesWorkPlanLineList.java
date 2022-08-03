package sinexcel.works.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import sinexcel.common.annotation.Excel;

/**
 * 生产计划池行信息对象 pes_work_plan_line_list
 * 
 * @author Zhang Kai
 * @date 2021-04-16
 */
public class PesWorkPlanLineList
{
    /** 库存组织 */
    private Long organizationId;

    /** 计划批次行号 */
    @JsonSerialize(using= ToStringSerializer.class)
    @Excel(name = "计划批次行号", width = 20)
    private String lineNum;

    /** $column.columnComment */
    private Long inventoryItemId;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Excel(name = "阶次", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private Integer level;

    /** 成品编码 */
    @Excel(name = "成品编码", width = 15)
    private String itemNumber;

    /** 成品描述 */
    @Excel(name = "成品描述", width = 40)
    private String itemDescription;

    /** 类型 */
    @Excel(name = "类型", width = 10)
    private String itemType;

    /** 单位 */
    @Excel(name = "单位", width = 10)
    private String uom;

    /** 计划生产数量 */
    @Excel(name = "计划生产数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private Long planWieQuantity;

    /** 计划开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划开始时间", width = 10, dateFormat = "yyyy-MM-dd")
    private Date planStartDate;

    /** 计划完工时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划完工时间", width = 10, dateFormat = "yyyy-MM-dd")
    private Date planEndDate;

    /** 需求数量 */
    @Excel(name = "需求数量", width = 10, cellType = Excel.ColumnType.BigDecimal)
    private Long grossQuantity;

    /** 需求日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "需求日期", width = 10, dateFormat = "yyyy-MM-dd")
    private Date grossDate;

    /** 本阶树状码 */
    @Excel(name = "本阶树状码", width = 30)
    private String levelTreeCode;

    /** 计划批号 */
    @Excel(name = "计划批号", width = 15)
    private Long planLotNum;
    private String documentNumber;
    private String custPoNumber;
    private Integer documentLineNum;
    private String deleteFlag;
    private Long workCenterId;
    private String supplierName;

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Long getWorkCenterId() {
        return workCenterId;
    }

    public void setWorkCenterId(Long workCenterId) {
        this.workCenterId = workCenterId;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getDocumentLineNum() {
        return documentLineNum;
    }

    public void setDocumentLineNum(Integer documentLineNum) {
        this.documentLineNum = documentLineNum;
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

    /** $column.columnComment */
    private Date createDate;

    /** $column.columnComment */
    private Date lastUpdateDate;

    /** $column.columnComment */
    private String lastUpdateBy;
    private String wieFlag;
    private String workFlag;

    public String getWorkFlag() {
        return workFlag;
    }

    public void setWorkFlag(String workFlag) {
        this.workFlag = workFlag;
    }

    public String getWieFlag() {
        return wieFlag;
    }

    public void setWieFlag(String wieFlag) {
        this.wieFlag = wieFlag;
    }

    public void setOrganizationId(Long organizationId) 
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() 
    {
        return organizationId;
    }
    public void setLineNum(String lineNum)
    {
        this.lineNum = lineNum;
    }

    public String getLineNum()
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
    public void setUom(String uom) 
    {
        this.uom = uom;
    }

    public String getUom() 
    {
        return uom;
    }
    public void setPlanWieQuantity(Long planWieQuantity) 
    {
        this.planWieQuantity = planWieQuantity;
    }

    public Long getPlanWieQuantity() 
    {
        return planWieQuantity;
    }
    public void setPlanStartDate(Date planStartDate) 
    {
        this.planStartDate = planStartDate;
    }

    public Date getPlanStartDate() 
    {
        return planStartDate;
    }
    public void setPlanEndDate(Date planEndDate) 
    {
        this.planEndDate = planEndDate;
    }

    public Date getPlanEndDate() 
    {
        return planEndDate;
    }
    public void setGrossQuantity(Long grossQuantity) 
    {
        this.grossQuantity = grossQuantity;
    }

    public Long getGrossQuantity() 
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
    public void setLevelTreeCode(String levelTreeCode) 
    {
        this.levelTreeCode = levelTreeCode;
    }

    public String getLevelTreeCode() 
    {
        return levelTreeCode;
    }
    public void setPlanLotNum(Long planLotNum) 
    {
        this.planLotNum = planLotNum;
    }

    public Long getPlanLotNum() 
    {
        return planLotNum;
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
}
