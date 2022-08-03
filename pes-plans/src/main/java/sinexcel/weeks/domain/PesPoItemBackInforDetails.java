package sinexcel.weeks.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import sinexcel.common.annotation.Excel;

/**
 * 采购回货计划明细对象 pes_po_item_back_infor_details
 * 
 * @author Zhang Kai
 * @date 2021-07-26
 */
public class PesPoItemBackInforDetails
{

    /** 库存组织 */
    @Excel(name = "库存组织", width = 15,readConverterExp = "300000004669869=INV_SH_X,300000004669879=INV_HZ_X,300000014626555=INV_XA,300000019548063=INV_HZSH,300000025806452=INV_US,300000025806791=INV_ZHNY,300000034665946=INV_HZSH_FEE,300000035636056=INV_SHENZHEN_HZ_X",type = Excel.Type.EXPORT)
    private Long organizationId;

    @Excel(name = "库存组织", width = 15,combo = {"INV_SH_X","INV_HZ_X","INV_XA","INV_HZSH","INV_US","INV_ZHNY","INV_HZSH_FEE","INV_SHENZHEN_HZ_X"},type = Excel.Type.IMPORT)
    private String organizationCode;

    /** 物料ID */
    private Long inventoryItemId;

    @Excel(name = "物料编码", width = 15,type = Excel.Type.ALL)
    private String itemNumber;
    @Excel(name = "物料描述", width = 40,type = Excel.Type.EXPORT)
    private String itemDescription;

    /** 回货总数 */
    @Excel(name = "回货总数",width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal backSumQty;

    /** 星期一 */
    @Excel(name = "第一天",width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal monday;

    /** 星期二 */
    @Excel(name = "第二天",width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal tuesday;

    /** 星期三 */
    @Excel(name = "第三天",width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal wednesday;

    /** 星期四 */
    @Excel(name = "第四天",width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal thursday;

    /** 星期五 */
    @Excel(name = "第五天",width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal friday;

    /** 星期六 */
    @Excel(name = "第六天",width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal saturday;

    /** 星期日 */
    @Excel(name = "第七天",width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal sunday;

    /** 星期一(二周) */
    @Excel(name = "第八天",width = 15, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal nextMonday;

    /** 星期二(二周) */
    @Excel(name = "第九天",width = 15, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal nextTuesday;

    /** 星期三(二周) */
    @Excel(name = "第十天",width = 15, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal nextWednesday;

    /** 星期四(二周) */
    @Excel(name = "第十一天",width = 15, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal nextThursday;

    /** 星期五(二周) */
    @Excel(name = "第十二天",width = 15, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal nextFriday;

    /** 星期六(二周) */
    @Excel(name = "第十三天",width = 15, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal nextSaturday;

    /** 星期日(二周) */
    @Excel(name = "第十四天",width = 15, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal nextSunday;

    /** 第三周 */
    @Excel(name = "第三周",width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal thirdWeek;

    /** 第四周 */
    @Excel(name = "第四周",width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal fourWeek;

    /** 第三周 */
    @Excel(name = "第五周",width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal fiveWeek;

    /** 第四周 */
    @Excel(name = "第六周",width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal sixWeek;

    /** 其它日期 */
    @Excel(name = "其它日期",width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.ALL)
    private BigDecimal othersWeek;

    /** $column.columnComment */
    private Long itemBackId;

    /** $column.columnComment */
    private Long headerId;

    /** $column.columnComment */
    private Date createDate;

    /** $column.columnComment */
    private String lastUpdateBy;

    /** $column.columnComment */
    private Date lastUpdateDate;

    private String createBy;

    @Excel(name = "采购单号", width = 10,type = Excel.Type.EXPORT)
    private String documentNumber;
    @Excel(name = "行号",width = 5, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private Integer lineNum;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "PO创建日期", width = 10, dateFormat = "yyyy-MM-dd",type = Excel.Type.EXPORT)
    private Date creationDate;
    @Excel(name = "采购员", width = 10,type = Excel.Type.EXPORT)
    private String displayName;
    @Excel(name = "PO数量",width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal poQuantity;
    @Excel(name = "PO在途",width = 10, cellType = Excel.ColumnType.BigDecimal,type = Excel.Type.EXPORT)
    private BigDecimal quantity;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "供需日期", width = 10, dateFormat = "yyyy-MM-dd",type = Excel.Type.EXPORT)
    private Date date;
    @Excel(name = "供应商", width = 10,type = Excel.Type.EXPORT)
    private String segment1;
    @Excel(name = "供应商名称", width = 30,type = Excel.Type.EXPORT)
    private String partyName;


    private Long editMonday;
    private Long editTuesday;
    private Long editWednesday;
    private Long editThursday;
    private Long editFriday;
    private Long editSaturday;
    private Long editSunday;
    private Long editNextMonday;
    private Long editNextTuesday;
    private Long editNextWednesday;
    private Long editNextThursday;
    private Long editNextFriday;
    private Long editNextSaturday;
    private Long editNextSunday;
    private Long editThirdWeek;
    private Long editFourWeek;
    private Long editFiveWeek;
    private Long editSixWeek;
    private Long editOthersWeek;
    private String editRemark;
    public Long getEditMonday() {
        return editMonday;
    }

    public void setEditMonday(Long editMonday) {
        this.editMonday = editMonday;
    }

    public Long getEditTuesday() {
        return editTuesday;
    }

    public void setEditTuesday(Long editTuesday) {
        this.editTuesday = editTuesday;
    }

    public Long getEditWednesday() {
        return editWednesday;
    }

    public void setEditWednesday(Long editWednesday) {
        this.editWednesday = editWednesday;
    }

    public Long getEditThursday() {
        return editThursday;
    }

    public void setEditThursday(Long editThursday) {
        this.editThursday = editThursday;
    }

    public Long getEditFriday() {
        return editFriday;
    }

    public void setEditFriday(Long editFriday) {
        this.editFriday = editFriday;
    }

    public Long getEditSaturday() {
        return editSaturday;
    }

    public void setEditSaturday(Long editSaturday) {
        this.editSaturday = editSaturday;
    }

    public Long getEditSunday() {
        return editSunday;
    }

    public void setEditSunday(Long editSunday) {
        this.editSunday = editSunday;
    }

    public Long getEditNextMonday() {
        return editNextMonday;
    }

    public void setEditNextMonday(Long editNextMonday) {
        this.editNextMonday = editNextMonday;
    }

    public Long getEditNextTuesday() {
        return editNextTuesday;
    }

    public void setEditNextTuesday(Long editNextTuesday) {
        this.editNextTuesday = editNextTuesday;
    }

    public Long getEditNextWednesday() {
        return editNextWednesday;
    }

    public void setEditNextWednesday(Long editNextWednesday) {
        this.editNextWednesday = editNextWednesday;
    }

    public Long getEditNextThursday() {
        return editNextThursday;
    }

    public void setEditNextThursday(Long editNextThursday) {
        this.editNextThursday = editNextThursday;
    }

    public Long getEditNextFriday() {
        return editNextFriday;
    }

    public void setEditNextFriday(Long editNextFriday) {
        this.editNextFriday = editNextFriday;
    }

    public Long getEditNextSaturday() {
        return editNextSaturday;
    }

    public void setEditNextSaturday(Long editNextSaturday) {
        this.editNextSaturday = editNextSaturday;
    }

    public Long getEditNextSunday() {
        return editNextSunday;
    }

    public void setEditNextSunday(Long editNextSunday) {
        this.editNextSunday = editNextSunday;
    }

    public Long getEditThirdWeek() {
        return editThirdWeek;
    }

    public void setEditThirdWeek(Long editThirdWeek) {
        this.editThirdWeek = editThirdWeek;
    }

    public Long getEditFourWeek() {
        return editFourWeek;
    }

    public void setEditFourWeek(Long editFourWeek) {
        this.editFourWeek = editFourWeek;
    }

    public Long getEditFiveWeek() {
        return editFiveWeek;
    }

    public void setEditFiveWeek(Long editFiveWeek) {
        this.editFiveWeek = editFiveWeek;
    }

    public Long getEditSixWeek() {
        return editSixWeek;
    }

    public void setEditSixWeek(Long editSixWeek) {
        this.editSixWeek = editSixWeek;
    }

    public Long getEditOthersWeek() {
        return editOthersWeek;
    }

    public void setEditOthersWeek(Long editOthersWeek) {
        this.editOthersWeek = editOthersWeek;
    }

    public String getEditRemark() {
        return editRemark;
    }

    public void setEditRemark(String editRemark) {
        this.editRemark = editRemark;
    }






    public BigDecimal getFiveWeek() {
        return fiveWeek;
    }

    public void setFiveWeek(BigDecimal fiveWeek) {
        this.fiveWeek = fiveWeek;
    }

    public BigDecimal getSixWeek() {
        return sixWeek;
    }

    public void setSixWeek(BigDecimal sixWeek) {
        this.sixWeek = sixWeek;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Integer getLineNum() {
        return lineNum;
    }

    public void setLineNum(Integer lineNum) {
        this.lineNum = lineNum;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public BigDecimal getPoQuantity() {
        return poQuantity;
    }

    public void setPoQuantity(BigDecimal poQuantity) {
        this.poQuantity = poQuantity;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSegment1() {
        return segment1;
    }

    public void setSegment1(String segment1) {
        this.segment1 = segment1;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setOrganizationId(Long organizationId) 
    {
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() 
    {
        return organizationId;
    }
    public void setInventoryItemId(Long inventoryItemId) 
    {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getInventoryItemId() 
    {
        return inventoryItemId;
    }
    public void setBackSumQty(BigDecimal backSumQty) 
    {
        this.backSumQty = backSumQty;
    }

    public BigDecimal getBackSumQty() 
    {
        return backSumQty;
    }
    public void setMonday(BigDecimal monday) 
    {
        this.monday = monday;
    }

    public BigDecimal getMonday() 
    {
        return monday;
    }
    public void setTuesday(BigDecimal tuesday) 
    {
        this.tuesday = tuesday;
    }

    public BigDecimal getTuesday() 
    {
        return tuesday;
    }
    public void setWednesday(BigDecimal wednesday) 
    {
        this.wednesday = wednesday;
    }

    public BigDecimal getWednesday() 
    {
        return wednesday;
    }
    public void setThursday(BigDecimal thursday) 
    {
        this.thursday = thursday;
    }

    public BigDecimal getThursday() 
    {
        return thursday;
    }
    public void setFriday(BigDecimal friday) 
    {
        this.friday = friday;
    }

    public BigDecimal getFriday() 
    {
        return friday;
    }
    public void setSaturday(BigDecimal saturday) 
    {
        this.saturday = saturday;
    }

    public BigDecimal getSaturday() 
    {
        return saturday;
    }
    public void setSunday(BigDecimal sunday) 
    {
        this.sunday = sunday;
    }

    public BigDecimal getSunday() 
    {
        return sunday;
    }
    public void setNextMonday(BigDecimal nextMonday) 
    {
        this.nextMonday = nextMonday;
    }

    public BigDecimal getNextMonday() 
    {
        return nextMonday;
    }
    public void setNextTuesday(BigDecimal nextTuesday) 
    {
        this.nextTuesday = nextTuesday;
    }

    public BigDecimal getNextTuesday() 
    {
        return nextTuesday;
    }
    public void setNextWednesday(BigDecimal nextWednesday) 
    {
        this.nextWednesday = nextWednesday;
    }

    public BigDecimal getNextWednesday() 
    {
        return nextWednesday;
    }
    public void setNextThursday(BigDecimal nextThursday) 
    {
        this.nextThursday = nextThursday;
    }

    public BigDecimal getNextThursday() 
    {
        return nextThursday;
    }
    public void setNextFriday(BigDecimal nextFriday) 
    {
        this.nextFriday = nextFriday;
    }

    public BigDecimal getNextFriday() 
    {
        return nextFriday;
    }
    public void setNextSaturday(BigDecimal nextSaturday) 
    {
        this.nextSaturday = nextSaturday;
    }

    public BigDecimal getNextSaturday() 
    {
        return nextSaturday;
    }
    public void setNextSunday(BigDecimal nextSunday) 
    {
        this.nextSunday = nextSunday;
    }

    public BigDecimal getNextSunday() 
    {
        return nextSunday;
    }
    public void setThirdWeek(BigDecimal thirdWeek) 
    {
        this.thirdWeek = thirdWeek;
    }

    public BigDecimal getThirdWeek() 
    {
        return thirdWeek;
    }
    public void setFourWeek(BigDecimal fourWeek) 
    {
        this.fourWeek = fourWeek;
    }

    public BigDecimal getFourWeek() 
    {
        return fourWeek;
    }
    public void setOthersWeek(BigDecimal othersWeek) 
    {
        this.othersWeek = othersWeek;
    }

    public BigDecimal getOthersWeek() 
    {
        return othersWeek;
    }
    public void setItemBackId(Long itemBackId) 
    {
        this.itemBackId = itemBackId;
    }

    public Long getItemBackId() 
    {
        return itemBackId;
    }
    public void setHeaderId(Long headerId) 
    {
        this.headerId = headerId;
    }

    public Long getHeaderId() 
    {
        return headerId;
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
}
