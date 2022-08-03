package sinexcel.supplier.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 报价单对象 pes_item_supplier_price_list
 * 
 * @author Zhang Kai
 * @date 2020-12-20
 */
public class PesItemSupplierPriceList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long sourcingItemId;

    /** 币种 */
    private String currencyCode;

    /** 审批状态 */
    private String approvalStatus;

    /** 税率 */
    private String taxCode;

    /** 删除标识 */
    private String statusFlag;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /** 更新人 */
    private String lastUpdateBy;

    /** 更新日期 */
    private Date lastUpdateDate;

    /** 报价单ID */
    private Long itemPriceId;

    public String getStatusFlag() {
        return statusFlag;
    }

    public void setStatusFlag(String statusFlag) {
        this.statusFlag = statusFlag;
    }

    public void setSourcingItemId(Long sourcingItemId) 
    {
        this.sourcingItemId = sourcingItemId;
    }

    public Long getSourcingItemId() 
    {
        return sourcingItemId;
    }
    public void setCurrencyCode(String currencyCode) 
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() 
    {
        return currencyCode;
    }
    public void setApprovalStatus(String approvalStatus) 
    {
        this.approvalStatus = approvalStatus;
    }

    public String getApprovalStatus() 
    {
        return approvalStatus;
    }
    public void setTaxCode(String taxCode) 
    {
        this.taxCode = taxCode;
    }

    public String getTaxCode() 
    {
        return taxCode;
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
    public void setItemPriceId(Long itemPriceId) 
    {
        this.itemPriceId = itemPriceId;
    }

    public Long getItemPriceId() 
    {
        return itemPriceId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sourcingItemId", getSourcingItemId())
            .append("currencyCode", getCurrencyCode())
            .append("approvalStatus", getApprovalStatus())
            .append("taxCode", getTaxCode())
            .append("statusFlag", getStatusFlag())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("lastUpdateBy", getLastUpdateBy())
            .append("lastUpdateDate", getLastUpdateDate())
            .append("itemPriceId", getItemPriceId())
            .toString();
    }
}
