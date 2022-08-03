package sinexcel.works.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * PES自定义工单回传ERP日志对象 pes_wie_work_submit_erp_infor_list
 * 
 * @author Zhang Kai
 * @date 2021-11-29
 */
public class PesWieWorkSubmitErpInforList
{
    private Long pesWorkOrderId;
    /** PES_ID */
    private Long pesId;

    /** ERP_ID */
    private Long erpId;

    /** 回传时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    /** 类型 */
    private Integer type;

    /** ID */
    private Long submitErpId;

    /** 物料编码 */
    private String itemNumber;

    private String itemDescription;

    /** 序号 */
    private Integer countNumber;

    /** 回传标识 */
    private String erpFlag;
    private String createBy;
    private String remark;
    private Integer workOrderStatusId;
    private BigDecimal quantityPerProduct;
    private BigDecimal quantity;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date wieWorkDate;
    private Integer erpType;

    public Integer getErpType() {
        return erpType;
    }

    public void setErpType(Integer erpType) {
        this.erpType = erpType;
    }

    public Date getWieWorkDate() {
        return wieWorkDate;
    }

    public void setWieWorkDate(Date wieWorkDate) {
        this.wieWorkDate = wieWorkDate;
    }

    public Integer getWorkOrderStatusId() {
        return workOrderStatusId;
    }

    public void setWorkOrderStatusId(Integer workOrderStatusId) {
        this.workOrderStatusId = workOrderStatusId;
    }

    public BigDecimal getQuantityPerProduct() {
        return quantityPerProduct;
    }

    public void setQuantityPerProduct(BigDecimal quantityPerProduct) {
        this.quantityPerProduct = quantityPerProduct;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Long getPesWorkOrderId() {
        return pesWorkOrderId;
    }

    public void setPesWorkOrderId(Long pesWorkOrderId) {
        this.pesWorkOrderId = pesWorkOrderId;
    }

    public void setPesId(Long pesId) 
    {
        this.pesId = pesId;
    }

    public Long getPesId() 
    {
        return pesId;
    }
    public void setErpId(Long erpId) 
    {
        this.erpId = erpId;
    }

    public Long getErpId() 
    {
        return erpId;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }
    public void setSubmitErpId(Long submitErpId) 
    {
        this.submitErpId = submitErpId;
    }

    public Long getSubmitErpId() 
    {
        return submitErpId;
    }
    public void setItemNumber(String itemNumber) 
    {
        this.itemNumber = itemNumber;
    }

    public String getItemNumber() 
    {
        return itemNumber;
    }
    public void setCountNumber(Integer countNumber) 
    {
        this.countNumber = countNumber;
    }

    public Integer getCountNumber() 
    {
        return countNumber;
    }
    public void setErpFlag(String erpFlag) 
    {
        this.erpFlag = erpFlag;
    }

    public String getErpFlag() 
    {
        return erpFlag;
    }
}
