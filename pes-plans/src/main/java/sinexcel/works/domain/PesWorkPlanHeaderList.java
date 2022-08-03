package sinexcel.works.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 生产计划池对象 pes_work_plan_header_list
 * 
 * @author Zhang Kai
 * @date 2021-04-16
 */
public class PesWorkPlanHeaderList
{

    /** $column.columnComment */
    private Integer headerId;
    private Long organizationId;

    /** 批次号 */
    @Excel(name = "批次号")
    private Long planLotNum;

    private String planType;

    private String activeCode;

    private String approvalCode;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /** $column.columnComment */
    private Date lastUpdateDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    private String createBy;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setHeaderId(Integer headerId) 
    {
        this.headerId = headerId;
    }

    public Integer getHeaderId() 
    {
        return headerId;
    }
    public void setOrganizationId(Long organizationId) 
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() 
    {
        return organizationId;
    }
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
    public void setApprovalCode(String approvalCode) 
    {
        this.approvalCode = approvalCode;
    }

    public String getApprovalCode() 
    {
        return approvalCode;
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
}
