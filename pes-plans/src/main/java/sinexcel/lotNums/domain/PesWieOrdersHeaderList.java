package sinexcel.lotNums.domain;

import java.security.SecureRandom;

/**
 * 订单生产计划头对象 pes_wie_orders_header_list
 * 
 * @author Zhang Kai
 * @date 2021-04-25
 */
public class PesWieOrdersHeaderList
{


    private Long planLotNum;


    private String planType;

    /** $column.columnComment */
    private String activeCode;

    private String createBy;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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

}
