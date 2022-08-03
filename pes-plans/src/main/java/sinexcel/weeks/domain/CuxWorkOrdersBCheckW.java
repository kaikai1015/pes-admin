package sinexcel.weeks.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 周计划导入对象 cux_work_orders_b_check_w
 * 
 * @author Zhang Kai
 * @date 2021-03-11
 */
public class CuxWorkOrdersBCheckW extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long ckId;

    /** 库存组织 */
    @Excel(name = "库存组织")
    private String organizationCode;

    /** 工单号 */
    @Excel(name = "工单号")
    private String workOrderNumber;

    /** 产品线 */
    @Excel(name = "产品线")
    private String prodLine;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderNum;

    /** 客户 */
    @Excel(name = "客户")
    private String customerName;

    /** 计划开工日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划开工日期", width = 15, dateFormat = "yyyy-MM-dd")
    private Date plannedStartDate;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String itemNumber;

    /** 物料描述 */
    @Excel(name = "物料描述")
    private String description;

    /** 计划开工数量 */
    @Excel(name = "生产数量")
    private BigDecimal plannedStartQuantity;

    /** 已完成数量 */
    @Excel(name = "已入库数量")
    private BigDecimal completedQuantity;

    /** 工作定义 */
    @Excel(name = "工作定义")
    private String workDef;

    /** 优先级 */
    @Excel(name = "优先级")
    private String prop;

    /** 工单描述 */
    @Excel(name = "说明")
    private String des;

    /** 批次 */
    private String lotNum;

    /** $column.columnComment */
    private Date createDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    private Date lastUpdateDate;

    /** 标识 */
    private String flag;

    public void setCkId(Long ckId) 
    {
        this.ckId = ckId;
    }

    public Long getCkId() 
    {
        return ckId;
    }
    public void setOrganizationCode(String organizationCode) 
    {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationCode() 
    {
        return organizationCode;
    }
    public void setWorkOrderNumber(String workOrderNumber) 
    {
        this.workOrderNumber = workOrderNumber;
    }

    public String getWorkOrderNumber() 
    {
        return workOrderNumber;
    }
    public void setPlannedStartDate(Date plannedStartDate) 
    {
        this.plannedStartDate = plannedStartDate;
    }

    public Date getPlannedStartDate() 
    {
        return plannedStartDate;
    }
    public void setItemNumber(String itemNumber) 
    {
        this.itemNumber = itemNumber;
    }

    public String getItemNumber() 
    {
        return itemNumber;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
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
    public void setOrderNum(String orderNum) 
    {
        this.orderNum = orderNum;
    }

    public String getOrderNum() 
    {
        return orderNum;
    }
    public void setProdLine(String prodLine) 
    {
        this.prodLine = prodLine;
    }

    public String getProdLine() 
    {
        return prodLine;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }
    public void setLastUpdateDate(Date lastUpdateDate) 
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastUpdateDate() 
    {
        return lastUpdateDate;
    }
    public void setWorkDef(String workDef) 
    {
        this.workDef = workDef;
    }

    public String getWorkDef() 
    {
        return workDef;
    }
    public void setDes(String des) 
    {
        this.des = des;
    }

    public String getDes() 
    {
        return des;
    }
    public void setProp(String prop) 
    {
        this.prop = prop;
    }

    public String getProp() 
    {
        return prop;
    }
    public void setLotNum(String lotNum) 
    {
        this.lotNum = lotNum;
    }

    public String getLotNum() 
    {
        return lotNum;
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
    public void setFlag(String flag) 
    {
        this.flag = flag;
    }

    public String getFlag() 
    {
        return flag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ckId", getCkId())
            .append("organizationCode", getOrganizationCode())
            .append("workOrderNumber", getWorkOrderNumber())
            .append("plannedStartDate", getPlannedStartDate())
            .append("itemNumber", getItemNumber())
            .append("description", getDescription())
            .append("plannedStartQuantity", getPlannedStartQuantity())
            .append("completedQuantity", getCompletedQuantity())
            .append("orderNum", getOrderNum())
            .append("prodLine", getProdLine())
            .append("customerName", getCustomerName())
            .append("lastUpdateDate", getLastUpdateDate())
            .append("workDef", getWorkDef())
            .append("des", getDes())
            .append("prop", getProp())
            .append("lotNum", getLotNum())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("lastUpdateBy", getLastUpdateBy())
            .append("flag", getFlag())
            .toString();
    }
}
