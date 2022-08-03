package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SyncSupplyDemandList {

    private Long organizationId;
    private Long inventoryItemId;
    private String type;
    private BigDecimal quantity;
    private Date date;
    private String documentNumber;
    private String uom;

    private BigDecimal wieS;
    private BigDecimal wieD;
    private BigDecimal prS;
    private BigDecimal poS;
    private BigDecimal dooD;

    private Long documentId;
    private Long documentLineId;

    public Long getDocumentLineId() {
        return documentLineId;
    }

    public void setDocumentLineId(Long documentLineId) {
        this.documentLineId = documentLineId;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public BigDecimal getWieS() {
        return wieS;
    }

    public void setWieS(BigDecimal wieS) {
        this.wieS = wieS;
    }

    public BigDecimal getWieD() {
        return wieD;
    }

    public void setWieD(BigDecimal wieD) {
        this.wieD = wieD;
    }

    public BigDecimal getPrS() {
        return prS;
    }

    public void setPrS(BigDecimal prS) {
        this.prS = prS;
    }

    public BigDecimal getPoS() {
        return poS;
    }

    public void setPoS(BigDecimal poS) {
        this.poS = poS;
    }

    public BigDecimal getDooD() {
        return dooD;
    }

    public void setDooD(BigDecimal dooD) {
        this.dooD = dooD;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}
