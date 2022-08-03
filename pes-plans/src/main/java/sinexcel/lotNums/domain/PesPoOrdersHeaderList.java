package sinexcel.lotNums.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 订单采购计划头对象 pes_po_orders_header_list
 * 
 * @author Zhang Kai
 * @date 2021-04-25
 */
public class PesPoOrdersHeaderList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 批次号 */
    @Excel(name = "批次号")
    private Long planLotNum;

    /** 类型 */
    @Excel(name = "类型")
    private String planType;

    /** $column.columnComment */
    private String activeCode;

    public void setPlanLotNum(Long planLotNum) 
    {
        this.planLotNum = planLotNum;
    }

    public Long getPlanLotNum() 
    {
        return planLotNum;
    }
    public void setPlanType(String planType) 
    {
        this.planType = planType;
    }

    public String getPlanType() 
    {
        return planType;
    }
    public void setActiveCode(String activeCode) 
    {
        this.activeCode = activeCode;
    }

    public String getActiveCode() 
    {
        return activeCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("planLotNum", getPlanLotNum())
            .append("planType", getPlanType())
            .append("activeCode", getActiveCode())
            .toString();
    }
}
