package sinexcel.weeks.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sinexcel.common.annotation.Excel;
import sinexcel.common.core.domain.BaseEntity;

/**
 * 月度销售计划头对象 pes_months_salse_plan_headers
 * 
 * @author Zhang Kai
 * @date 2021-04-21
 */
public class PesMonthsSalsePlanHeaders
{
    private Long id;
    /** 业务单元 */
    private Long buId;

    /** 批次号 */
    private String lotNum;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    private String createBy;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    private Date lastUpdateDate;

    /** 产品线 */
    @Excel(name = "产品线")
    private Integer prodLineFlag;

    private Integer years;
    private Long months;

    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Long getMonths() {
        return months;
    }

    public void setMonths(Long months) {
        this.months = months;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setBuId(Long buId) 
    {
        this.buId = buId;
    }

    public Long getBuId() 
    {
        return buId;
    }
    public void setLotNum(String lotNum)
    {
        this.lotNum = lotNum;
    }

    public String getLotNum()
    {
        return lotNum;
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
    public void setProdLineFlag(Integer prodLineFlag)
    {
        this.prodLineFlag = prodLineFlag;
    }

    public Integer getProdLineFlag()
    {
        return prodLineFlag;
    }
}
