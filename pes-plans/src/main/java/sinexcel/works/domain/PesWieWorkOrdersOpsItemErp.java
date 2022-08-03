package sinexcel.works.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 工单外协物料对照对象 pes_wie_work_orders_ops_item_erp
 * 
 * @author Zhang Kai
 * @date 2021-12-13
 */
public class PesWieWorkOrdersOpsItemErp extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X")
    private Long organizationId;

    private Long inventoryItemId;

    @Excel(name = "成品料号",width = 10)
    private String pItemNumber;

    @Excel(name = "成品描述",width = 30)
    private String pItemDescription;

    private Long ospItemId;

    @Excel(name = "费用料号",width = 10)
    private String ospItemNumber;

    @Excel(name = "料号描述",width = 30)
    private String ospItemDescription;

    private Long supplierId;

    @Excel(name = "外协名",width = 10)
    private String supplierNumber;

    @Excel(name = "外协商名",width = 30)
    private String supplierName;

    @Excel(name = "优先级",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private Integer prioryty;
    @Excel(name = "工作中心",width = 10)
    private String workCenterName;

    @Excel(name = "人工工时",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal usageRateF;
    @Excel(name = "制费工时",width = 10,cellType = Excel.ColumnType.BigDecimal)
    private BigDecimal usageRateS;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    private Date lastUpdateDate;

    private String lastUpdateBy;

    /** $column.columnComment */
    private Long wieOpsItemId;

    private Long pesWorkOrderId;
    private Long workCenterId;
    private Integer assignedUnitsF;
    private Integer assignedUnitsS;
    private Integer workCenterCode;
    private String isWwFlag;
    private Long supplierSiteId;



    public String getWorkCenterName() {
        return workCenterName;
    }

    public void setWorkCenterName(String workCenterName) {
        this.workCenterName = workCenterName;
    }
    public Long getSupplierSiteId() {
        return supplierSiteId;
    }

    public void setSupplierSiteId(Long supplierSiteId) {
        this.supplierSiteId = supplierSiteId;
    }


    public Integer getWorkCenterCode() {
        return workCenterCode;
    }

    public void setWorkCenterCode(Integer workCenterCode) {
        this.workCenterCode = workCenterCode;
    }

    public String getIsWwFlag() {
        return isWwFlag;
    }

    public void setIsWwFlag(String isWwFlag) {
        this.isWwFlag = isWwFlag;
    }

    public Integer getPrioryty() {
        return prioryty;
    }

    public void setPrioryty(Integer prioryty) {
        this.prioryty = prioryty;
    }

    public Integer getAssignedUnitsF() {
        return assignedUnitsF;
    }

    public void setAssignedUnitsF(Integer assignedUnitsF) {
        this.assignedUnitsF = assignedUnitsF;
    }

    public Integer getAssignedUnitsS() {
        return assignedUnitsS;
    }

    public void setAssignedUnitsS(Integer assignedUnitsS) {
        this.assignedUnitsS = assignedUnitsS;
    }

    public BigDecimal getUsageRateF() {
        return usageRateF;
    }

    public void setUsageRateF(BigDecimal usageRateF) {
        this.usageRateF = usageRateF;
    }


    public BigDecimal getUsageRateS() {
        return usageRateS;
    }

    public void setUsageRateS(BigDecimal usageRateS) {
        this.usageRateS = usageRateS;
    }


    public Long getWorkCenterId() {
        return workCenterId;
    }

    public void setWorkCenterId(Long workCenterId) {
        this.workCenterId = workCenterId;
    }

    public Long getPesWorkOrderId() {
        return pesWorkOrderId;
    }

    public void setPesWorkOrderId(Long pesWorkOrderId) {
        this.pesWorkOrderId = pesWorkOrderId;
    }

    public void setInventoryItemId(Long inventoryItemId) 
    {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getInventoryItemId() 
    {
        return inventoryItemId;
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
    public void setOspItemId(Long ospItemId) 
    {
        this.ospItemId = ospItemId;
    }

    public Long getOspItemId() 
    {
        return ospItemId;
    }
    public void setOspItemNumber(String ospItemNumber) 
    {
        this.ospItemNumber = ospItemNumber;
    }

    public String getOspItemNumber() 
    {
        return ospItemNumber;
    }
    public void setOspItemDescription(String ospItemDescription) 
    {
        this.ospItemDescription = ospItemDescription;
    }

    public String getOspItemDescription() 
    {
        return ospItemDescription;
    }
    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }
    public void setSupplierNumber(String supplierNumber) 
    {
        this.supplierNumber = supplierNumber;
    }

    public String getSupplierNumber() 
    {
        return supplierNumber;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
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
    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }
    public void setWieOpsItemId(Long wieOpsItemId) 
    {
        this.wieOpsItemId = wieOpsItemId;
    }

    public Long getWieOpsItemId() 
    {
        return wieOpsItemId;
    }
    public void setOrganizationId(Long organizationId) 
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() 
    {
        return organizationId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("inventoryItemId", getInventoryItemId())
            .append("pItemNumber", getpItemNumber())
            .append("pItemDescription", getpItemDescription())
            .append("ospItemId", getOspItemId())
            .append("ospItemNumber", getOspItemNumber())
            .append("ospItemDescription", getOspItemDescription())
            .append("supplierId", getSupplierId())
            .append("supplierNumber", getSupplierNumber())
            .append("supplierName", getSupplierName())
            .append("createDate", getCreateDate())
            .append("createBy", getCreateBy())
            .append("lastUpdateDate", getLastUpdateDate())
            .append("lastUpdateBy", getLastUpdateBy())
            .append("wieOpsItemId", getWieOpsItemId())
            .append("organizationId", getOrganizationId())
            .toString();
    }
}
