package sinexcel.quartz.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 周计划库存现有量对象 sync_inv_onhand_quantity_new
 *
 * @author Zhang Kai
 * @date 2021-03-09
 */
public class SyncInvOnhandQuantityNewEO extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long inventoryItemId;

    private Long organizationId;

    private BigDecimal quantity;

    public void setInventoryItemId(Long inventoryItemId)
    {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getInventoryItemId()
    {
        return inventoryItemId;
    }
    public void setOrganizationId(Long organizationId)
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId()
    {
        return organizationId;
    }
    public void setQuantity(BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    public BigDecimal getQuantity()
    {
        return quantity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("inventoryItemId", getInventoryItemId())
                .append("organizationId", getOrganizationId())
                .append("quantity", getQuantity())
                .toString();
    }
}