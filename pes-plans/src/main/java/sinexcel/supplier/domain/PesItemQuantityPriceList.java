package sinexcel.supplier.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 分量计价对象 pes_item_quantity_price_list
 * 
 * @author Zhang Kai
 * @date 2020-12-24
 */
public class PesItemQuantityPriceList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 报价单号 */
    private Long itemPriceId;

    /** 单价 */
    private BigDecimal priceList;

    /** 数量 */
    private BigDecimal quantity;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /** $column.columnComment */
    private Date lastUpdateDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** 分量计价ID */
    private Long quantityPriceId;

    private Long sourcingItemId;

    public Long getSourcingItemId() {
        return sourcingItemId;
    }

    public void setSourcingItemId(Long sourcingItemId) {
        this.sourcingItemId = sourcingItemId;
    }

    public void setItemPriceId(Long itemPriceId) 
    {
        this.itemPriceId = itemPriceId;
    }

    public Long getItemPriceId() 
    {
        return itemPriceId;
    }
    public void setPriceList(BigDecimal priceList) 
    {
        this.priceList = priceList;
    }

    public BigDecimal getPriceList() 
    {
        return priceList;
    }
    public void setQuantity(BigDecimal quantity) 
    {
        this.quantity = quantity;
    }

    public BigDecimal getQuantity() 
    {
        return quantity;
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
    public void setQuantityPriceId(Long quantityPriceId) 
    {
        this.quantityPriceId = quantityPriceId;
    }

    public Long getQuantityPriceId() 
    {
        return quantityPriceId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("itemPriceId", getItemPriceId())
            .append("priceList", getPriceList())
            .append("quantity", getQuantity())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("lastUpdateDate", getLastUpdateDate())
            .append("lastUpdateBy", getLastUpdateBy())
            .append("quantityPriceId", getQuantityPriceId())
            .toString();
    }
}
