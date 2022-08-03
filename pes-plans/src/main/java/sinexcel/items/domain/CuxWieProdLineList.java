package sinexcel.items.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.xml.wss.jaxws.impl.PolicyResolverImpl;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 生产线管理对象 cux_wie_prod_line_list
 * 
 * @author Zhang Kai
 * @date 2021-05-18
 */
public class CuxWieProdLineList
{

    /** 工作中心代码 */
    private String workCenterCode;

    /** 中作中心名称 */
    private String workCenter;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date workDate;

    /** 产能（分） */
    private BigDecimal workProductivityQty;

    private String createBy;

    private String remark;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    private Date lastUpdateDate;

    /** $column.columnComment */
    private Long wieProdLineId;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setWorkCenterCode(String workCenterCode) 
    {
        this.workCenterCode = workCenterCode;
    }

    public String getWorkCenterCode() 
    {
        return workCenterCode;
    }
    public void setWorkCenter(String workCenter) 
    {
        this.workCenter = workCenter;
    }

    public String getWorkCenter() 
    {
        return workCenter;
    }
    public void setWorkDate(Date workDate) 
    {
        this.workDate = workDate;
    }

    public Date getWorkDate() 
    {
        return workDate;
    }
    public void setWorkProductivityQty(BigDecimal workProductivityQty) 
    {
        this.workProductivityQty = workProductivityQty;
    }

    public BigDecimal getWorkProductivityQty() 
    {
        return workProductivityQty;
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
    public void setWieProdLineId(Long wieProdLineId) 
    {
        this.wieProdLineId = wieProdLineId;
    }

    public Long getWieProdLineId() 
    {
        return wieProdLineId;
    }

}
