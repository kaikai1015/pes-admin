package sinexcel.weeks.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 *  采购回货计划对象 pes_po_back_infor_header_all
 * 
 * @author Zhang Kai
 * @date 2021-07-26
 */
public class PesPoBackInforHeaderAll
{

    /** 回货计划批号 */
    @JsonSerialize(using= ToStringSerializer.class)
    private Long lotNum;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    private Date lastUpdateDate;

    /** 序号 */
    private Long headerId;
    private String remark;
    private String createBy;
    private String activeCode;

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

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

    public void setLotNum(Long lotNum)
    {
        this.lotNum = lotNum;
    }

    public Long getLotNum() 
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
    public void setHeaderId(Long headerId) 
    {
        this.headerId = headerId;
    }

    public Long getHeaderId() 
    {
        return headerId;
    }
}
