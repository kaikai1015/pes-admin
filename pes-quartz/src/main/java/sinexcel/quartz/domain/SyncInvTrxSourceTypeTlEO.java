package sinexcel.quartz.domain;

import java.util.Date;

public class SyncInvTrxSourceTypeTlEO {

	private Long transactionSourceTypeId;
	private String language;
	private String sourceLang;
	private Date lastUpdateDate;
	private String lastUpdatedBy;
	private Date creationDate;
	private String createdBy;
	private String transactionSourceTypeName;
	private String description;

	public Long getTransactionSourceTypeId() {
		return transactionSourceTypeId;
	}

	public void setTransactionSourceTypeId(Long transactionSourceTypeId) {
		this.transactionSourceTypeId = transactionSourceTypeId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSourceLang() {
		return sourceLang;
	}

	public void setSourceLang(String sourceLang) {
		this.sourceLang = sourceLang;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}


	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getTransactionSourceTypeName() {
		return transactionSourceTypeName;
	}

	public void setTransactionSourceTypeName(String transactionSourceTypeName) {
		this.transactionSourceTypeName = transactionSourceTypeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
