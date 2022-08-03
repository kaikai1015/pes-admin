package sinexcel.purchase.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 管理采购单对象 cux_po_purchase_header_all
 * 
 * @author Zhang Kai
 * @date 2021-01-22
 */
public class CuxPoPurchaseHeaderAll extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 请购业务单元 */
    private Long requisitioningBuId;

    /** 采购业务单元 */
    private Long poBuId;

    /** 法人实体 */
    private Long legalEntityId;

    /** 采购员 */
    private String buyerName;

    /** 供应商 */
    private Long supplierId;

    /** 采购编号 */
    private String poNumber;

    /** 描述 */
    private String poDescription;

    /** 单据状态 */
    private String poStatus;

    /** 收单地点 */
    private String toLocationCode;

    /** 交易币种 */
    private String currencyCode;

    /** 折换率类型 */
    private String currencyType;

    /** 折换日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date currencyDate;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    private Date lastUpdateDate;

    /** $column.columnComment */
    private Long poHeaderId;

    private String supplierNumber;
    private String supplierName;

    public String getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierNumber(String supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setRequisitioningBuId(Long requisitioningBuId) 
    {
        this.requisitioningBuId = requisitioningBuId;
    }

    public Long getRequisitioningBuId() 
    {
        return requisitioningBuId;
    }
    public void setPoBuId(Long poBuId) 
    {
        this.poBuId = poBuId;
    }

    public Long getPoBuId() 
    {
        return poBuId;
    }
    public void setLegalEntityId(Long legalEntityId) 
    {
        this.legalEntityId = legalEntityId;
    }

    public Long getLegalEntityId() 
    {
        return legalEntityId;
    }
    public void setBuyerName(String buyerName) 
    {
        this.buyerName = buyerName;
    }

    public String getBuyerName() 
    {
        return buyerName;
    }
    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }
    public void setPoNumber(String poNumber) 
    {
        this.poNumber = poNumber;
    }

    public String getPoNumber() 
    {
        return poNumber;
    }
    public void setPoDescription(String poDescription) 
    {
        this.poDescription = poDescription;
    }

    public String getPoDescription() 
    {
        return poDescription;
    }
    public void setPoStatus(String poStatus) 
    {
        this.poStatus = poStatus;
    }

    public String getPoStatus() 
    {
        return poStatus;
    }
    public void setToLocationCode(String toLocationCode) 
    {
        this.toLocationCode = toLocationCode;
    }

    public String getToLocationCode() 
    {
        return toLocationCode;
    }
    public void setCurrencyCode(String currencyCode) 
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() 
    {
        return currencyCode;
    }
    public void setCurrencyType(String currencyType) 
    {
        this.currencyType = currencyType;
    }

    public String getCurrencyType() 
    {
        return currencyType;
    }
    public void setCurrencyDate(Date currencyDate) 
    {
        this.currencyDate = currencyDate;
    }

    public Date getCurrencyDate() 
    {
        return currencyDate;
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
    public void setPoHeaderId(Long poHeaderId) 
    {
        this.poHeaderId = poHeaderId;
    }

    public Long getPoHeaderId() 
    {
        return poHeaderId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("requisitioningBuId", getRequisitioningBuId())
            .append("poBuId", getPoBuId())
            .append("legalEntityId", getLegalEntityId())
            .append("buyerName", getBuyerName())
            .append("supplierId", getSupplierId())
            .append("poNumber", getPoNumber())
            .append("poDescription", getPoDescription())
            .append("poStatus", getPoStatus())
            .append("toLocationCode", getToLocationCode())
            .append("currencyCode", getCurrencyCode())
            .append("currencyType", getCurrencyType())
            .append("currencyDate", getCurrencyDate())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("lastUpdateBy", getLastUpdateBy())
            .append("lastUpdateDate", getLastUpdateDate())
            .append("poHeaderId", getPoHeaderId())
            .toString();
    }
}
