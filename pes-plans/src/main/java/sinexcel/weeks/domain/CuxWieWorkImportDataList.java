package sinexcel.weeks.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 排程欠料导入数据对象 cux_wie_work_import_data_list
 * 
 * @author Zhang Kai
 * @date 2021-11-05
 */
public class CuxWieWorkImportDataList
{

    /** 库存组织 */
//    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X")
private Long organizationId;

    @Excel(name = "库存组织", width = 15,combo = {"INV_SH_X","INV_HZ_X","INV_XA","INV_HZSH","INV_US","INV_ZHNY","INV_HZSH_FEE","INV_SHENZHEN_HZ_X"})
    private String organizationCode;

    /** $column.columnComment */
    private Long workOrderId;

    /** 工单号 */
    @Excel(name = "工单号", width = 15)
    private String workOrderNumber;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "导入开工日期", width = 15, prompt="日期格式：yyyy-MM-dd（2021-01-01）",dateFormat = "yyyy-MM-dd")
    private Date importStartDate;


    /** 产品线 */
    @Excel(name = "产品线",width = 15)
    private String prodLines;

    /** 订单号 */
    private String orderNumber;

    /** 客户 */
    private String customerName;

    /** 排产顺序 */
    @Excel(name = "排产顺序",width = 15)
    private Integer num;

    private String workType;

    /** 计划开工日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date plannedStartDate;

    public Date getImportStartDate() {
        return importStartDate;
    }

    public void setImportStartDate(Date importStartDate) {
        this.importStartDate = importStartDate;
    }

    /** $column.columnComment */
    private Long pInventoryItemId;

    /** 成品料号 */
    private String pItemNumber;

    /** 成品描述 */
    private String pDescription;

    /** 计划开工数量 */
    private BigDecimal plannedStartQuantity;

    /** 完工数量 */
    private BigDecimal completedQuantity;

    /** 批次号 */
    private Long lotNumber;

    /** $column.columnComment */
    private Date createDate;

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
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

    private String createBy;

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
    public void setWorkOrderNumber(String workOrderNumber) 
    {
        this.workOrderNumber = workOrderNumber;
    }

    public String getWorkOrderNumber() 
    {
        return workOrderNumber;
    }
    public void setProdLines(String prodLines) 
    {
        this.prodLines = prodLines;
    }

    public String getProdLines() 
    {
        return prodLines;
    }
    public void setOrderNumber(String orderNumber) 
    {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() 
    {
        return orderNumber;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }
    public void setNum(Integer num) 
    {
        this.num = num;
    }

    public Integer getNum() 
    {
        return num;
    }
    public void setPlannedStartDate(Date plannedStartDate) 
    {
        this.plannedStartDate = plannedStartDate;
    }

    public Date getPlannedStartDate() 
    {
        return plannedStartDate;
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
    public void setpDescription(String pDescription) 
    {
        this.pDescription = pDescription;
    }

    public String getpDescription() 
    {
        return pDescription;
    }
    public void setPlannedStartQuantity(BigDecimal plannedStartQuantity) 
    {
        this.plannedStartQuantity = plannedStartQuantity;
    }

    public BigDecimal getPlannedStartQuantity() 
    {
        return plannedStartQuantity;
    }
    public void setCompletedQuantity(BigDecimal completedQuantity) 
    {
        this.completedQuantity = completedQuantity;
    }

    public BigDecimal getCompletedQuantity() 
    {
        return completedQuantity;
    }
    public void setLotNumber(Long lotNumber) 
    {
        this.lotNumber = lotNumber;
    }

    public Long getLotNumber() 
    {
        return lotNumber;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }

}
