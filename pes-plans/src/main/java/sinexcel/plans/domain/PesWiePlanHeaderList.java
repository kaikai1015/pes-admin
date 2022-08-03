package sinexcel.plans.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 生产计划头对象 pes_wie_plan_header_list
 * 
 * @author Zhang Kai
 * @date 2020-11-25
 */
public class PesWiePlanHeaderList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer id;

    /** 组织ID */
    private Long organizationId;

    /** 库存组织 */
    @Excel(name = "库存组织")
    private String organizationCode;

    /** 计划批次号 */
    @Excel(name = "计划批次号")
    private Long planLotNum;

    /** 计划类型 */
    @Excel(name = "计划类型")
    private String planType;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 更新时间 */
    private Date lastUpdateDate;

    /** 更新人 */
    private String lastUpdateBy;

    /** 有效码 */
    @Excel(name = "有效码")
    private String activeCode;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setOrganizationId(Long organizationId) 
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() 
    {
        return organizationId;
    }
    public void setOrganizationCode(String organizationCode) 
    {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationCode() 
    {
        return organizationCode;
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
            .append("id", getId())
            .append("organizationId", getOrganizationId())
            .append("organizationCode", getOrganizationCode())
            .append("planLotNum", getPlanLotNum())
            .append("planType", getPlanType())
            .append("createDate", getCreateDate())
            .append("createBy", getCreateBy())
            .append("lastUpdateDate", getLastUpdateDate())
            .append("lastUpdateBy", getLastUpdateBy())
            .append("activeCode", getActiveCode())
            .toString();
    }
}
