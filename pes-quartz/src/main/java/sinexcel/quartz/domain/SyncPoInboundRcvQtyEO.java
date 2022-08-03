package sinexcel.quartz.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 周计划计算PO在途肯待入库对象 sync_po_inbound_rcv_qty
 *
 * @author Zhang Kai
 * @date 2021-03-09
 */
public class SyncPoInboundRcvQtyEO extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long itemId;

    private Long shipToOrganizationId;

    private BigDecimal receiveQuantity;

    private BigDecimal inboundQuantity;

    public void setItemId(Long itemId)
    {
        this.itemId = itemId;
    }

    public Long getItemId()
    {
        return itemId;
    }
    public void setShipToOrganizationId(Long shipToOrganizationId)
    {
        this.shipToOrganizationId = shipToOrganizationId;
    }

    public Long getShipToOrganizationId()
    {
        return shipToOrganizationId;
    }
    public void setReceiveQuantity(BigDecimal receiveQuantity)
    {
        this.receiveQuantity = receiveQuantity;
    }

    public BigDecimal getReceiveQuantity()
    {
        return receiveQuantity;
    }
    public void setInboundQuantity(BigDecimal inboundQuantity)
    {
        this.inboundQuantity = inboundQuantity;
    }

    public BigDecimal getInboundQuantity()
    {
        return inboundQuantity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("itemId", getItemId())
                .append("shipToOrganizationId", getShipToOrganizationId())
                .append("receiveQuantity", getReceiveQuantity())
                .append("inboundQuantity", getInboundQuantity())
                .toString();
    }
}