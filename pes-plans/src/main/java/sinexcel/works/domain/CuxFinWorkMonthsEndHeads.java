package sinexcel.works.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 月结工单操作对象 cux_fin_work_months_end_heads
 * 
 * @author Zhang Kai
 * @date 2021-05-07
 */
public class CuxFinWorkMonthsEndHeads
{

    /** 月结批次号 */
    private Long lotNum;

    /** 操作说明 */
    private String monthsFlag;

    /** 月结年份 */
    private Integer years;

    /** 月结月份 */
    private Integer months;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    private Date lastUpdateDate;

    private String createBy;

    private String monthsFlagStstus;

    public String getMonthsFlagStstus() {
        return monthsFlagStstus;
    }

    public void setMonthsFlagStstus(String monthsFlagStstus) {
        this.monthsFlagStstus = monthsFlagStstus;
    }

    public void setLotNum(Long lotNum) 
    {
        this.lotNum = lotNum;
    }

    public Long getLotNum() 
    {
        return lotNum;
    }
    public void setMonthsFlag(String monthsFlag) 
    {
        this.monthsFlag = monthsFlag;
    }

    public String getMonthsFlag() 
    {
        return monthsFlag;
    }
    public void setYears(Integer years) 
    {
        this.years = years;
    }

    public Integer getYears() 
    {
        return years;
    }
    public void setMonths(Integer months) 
    {
        this.months = months;
    }

    public Integer getMonths() 
    {
        return months;
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
