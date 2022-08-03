package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 周计划工单数据对象 sync_wie_work_orders_b_w
 *
 * @author Zhang Kai
 * @date 2021-03-10
 */
public class SyncWieWorkOrdersBWEO extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private String organizationCode;


    private Long workOrderId;


    private Long organizationId;


    private String workOrderNumber;


    private Long inventoryItemId;


    private BigDecimal plannedStartQuantity;


    private BigDecimal completedQuantity;


    private Date lastUpdateDate;


    private String itemNumber;

    private String description;

    public void setOrganizationCode(String organizationCode)
    {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationCode()
    {
        return organizationCode;
    }
    public void setWorkOrderId(Long workOrderId)
    {
        this.workOrderId = workOrderId;
    }

    public Long getWorkOrderId()
    {
        return workOrderId;
    }
    public void setOrganizationId(Long organizationId)
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId()
    {
        return organizationId;
    }
    public void setWorkOrderNumber(String workOrderNumber)
    {
        this.workOrderNumber = workOrderNumber;
    }

    public String getWorkOrderNumber()
    {
        return workOrderNumber;
    }
    public void setInventoryItemId(Long inventoryItemId)
    {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getInventoryItemId()
    {
        return inventoryItemId;
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
    public void setLastUpdateDate(Date lastUpdateDate)
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastUpdateDate()
    {
        return lastUpdateDate;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("organizationCode", getOrganizationCode())
                .append("workOrderId", getWorkOrderId())
                .append("organizationId", getOrganizationId())
                .append("workOrderNumber", getWorkOrderNumber())
                .append("inventoryItemId", getInventoryItemId())
                .append("plannedStartQuantity", getPlannedStartQuantity())
                .append("completedQuantity", getCompletedQuantity())
                .append("lastUpdateDate", getLastUpdateDate())
                .append("itemNumber", getItemNumber())
                .append("description", getDescription())
                .toString();
    }
}