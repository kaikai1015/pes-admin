package sinexcel.quartz.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SyncEgpSystemItemsBEO {

    private Long inventoryItemId;
    private Long organizationId;
    private Date lastUpdateDate;
    private Date creationDate;
    private String lastUpdateLogin;
    private String summaryFlag;
    private String enabledFlag;
    private Date startDateActive;
    private Date endDateActive;
    private Long buyerId;
    private Long accountingRuleId;
    private Long invoicingRuleId;
    private String attributeCategory;
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;
    private String attribute6;
    private String attribute7;
    private String attribute8;
    private String attribute9;
    private String attribute10;
    private String attribute11;
    private String attribute12;
    private String attribute13;
    private String attribute14;
    private String attribute15;
    private String purchasingItemFlag;
    private String shippableItemFlag;
    private String customerOrderFlag;
    private String internalOrderFlag;
    private String inventoryItemFlag;
    private String inventoryAssetFlag;
    private String purchasingEnabledFlag;
    private String customerOrderEnabledFlag;
    private String internalOrderEnabledFlag;
    private String soTransactionsFlag;
    private String mtlTransactionsEnabledFlag;
    private String stockEnabledFlag;
    private String buildInWipFlag;
    private BigDecimal revisionQtyControlCode;
    private Long itemCatalogGroupId;
    private String returnableFlag;
    private Long defaultShippingOrg;
    private String collateralFlag;
    private String taxableFlag;
    private String qtyRcvExceptionCode;
    private String allowItemDescUpdateFlag;
    private BigDecimal marketPrice;
    private Long hazardClassId;
    private String negotiationRequiredFlag;
    private BigDecimal qtyRcvTolerance;
    private BigDecimal listPricePerUnit;
    private Long unNumberId;
    private BigDecimal priceTolerancePercent;
    private BigDecimal roundingFactor;
    private String unitOfIssue;
    private String enforceShipToLocationCode;
    private String allowSubstituteReceiptsFlag;
    private String allowUnorderedReceiptsFlag;
    private String allowExpressDeliveryFlag;
    private BigDecimal daysEarlyReceiptAllowed;
    private BigDecimal daysLateReceiptAllowed;
    private String receiptDaysExceptionCode;
    private Long receivingRoutingId;
    private BigDecimal invoiceCloseTolerance;
    private BigDecimal receiveCloseTolerance;
    private String autoLotAlphaPrefix;
    private String startAutoLotNumber;
    private BigDecimal lotControlCode;
    private BigDecimal shelfLifeCode;
    private BigDecimal shelfLifeDays;
    private BigDecimal serialNumberControlCode;
    private String startAutoSerialNumber;
    private String autoSerialAlphaPrefix;
    private BigDecimal sourceType;
    private Long sourceOrganizationId;
    private String sourceSubinventory;
    private BigDecimal restrictSubinventoriesCode;
    private BigDecimal unitWeight;
    private String weightUomCode;
    private String volumeUomCode;
    private BigDecimal unitVolume;
    private BigDecimal restrictLocatorsCode;
    private BigDecimal locationControlCode;
    private BigDecimal shrinkageRate;
    private BigDecimal acceptableEarlyDays;
    private BigDecimal planningTimeFenceCode;
    private BigDecimal demandTimeFenceCode;
    private BigDecimal leadTimeLotSize;
    private BigDecimal stdLotSize;
    private BigDecimal cumManufacturingLeadTime;
    private BigDecimal overrunPercentage;
    private String mrpCalculateAtpFlag;
    private BigDecimal acceptableRateIncrease;
    private BigDecimal acceptableRateDecrease;
    private BigDecimal cumulativeTotalLeadTime;
    private BigDecimal planningTimeFenceDays;
    private BigDecimal demandTimeFenceDays;
    private String endAssemblyPeggingFlag;
    private String repetitivePlanningFlag;
    private String planningExceptionSet;
    private BigDecimal bomItemType;
    private String pickComponentsFlag;
    private String replenishToOrderFlag;
    private Long baseItemId;
    private String atpComponentsFlag;
    private String atpFlag;
    private BigDecimal fixedLeadTime;
    private BigDecimal variableLeadTime;
    private Long wipSupplyLocatorId;
    private Long wipSupplyType;
    private String wipSupplySubinventory;
    private String primaryUomCode;
    private BigDecimal allowedUnitsLookupCode;
    private String defaultIncludeInRollupFlag;
    private String inventoryItemStatusCode;
    private BigDecimal inventoryPlanningCode;
    private String plannerCode;
    private BigDecimal planningMakeBuyCode;
    private BigDecimal fixedLotMultiplier;
    private BigDecimal roundingControlType;
    private BigDecimal carryingCost;
    private BigDecimal postprocessingLeadTime;
    private BigDecimal preprocessingLeadTime;
    private BigDecimal fullLeadTime;
    private BigDecimal orderCost;
    private BigDecimal mrpSafetyStockPercent;
    private BigDecimal mrpSafetyStockCode;
    private BigDecimal minMinmaxQuantity;
    private BigDecimal maxMinmaxQuantity;
    private BigDecimal minimumOrderQuantity;
    private BigDecimal fixedOrderQuantity;
    private BigDecimal fixedDaysSupply;
    private BigDecimal maximumOrderQuantity;
    private Long atpRuleId;
    private Long pickingRuleId;
    private BigDecimal reservableType;
    private BigDecimal positiveMeasurementError;
    private BigDecimal negativeMeasurementError;
    private Long engineeringItemId;
    private BigDecimal serviceStartingDelay;
    private String serviceableProductFlag;
    private Long paymentTermsId;
    private String materialBillableFlag;
    private Long coverageScheduleId;
    private String serviceDurationPeriodCode;
    private BigDecimal serviceDuration;
    private String invoiceableItemFlag;
    private String taxCode;
    private String invoiceEnabledFlag;
    private String mustUseApprovedVendorFlag;
    private Long requestId;
    private String outsideOperationFlag;
    private String outsideOperationUomType;
    private BigDecimal safetyStockBucketDays;
    private String autoReduceMps;
    private String costingEnabledFlag;
    private String autoCreatedConfigFlag;
    private String cycleCountEnabledFlag;
    private String itemType;
    private String shipModelCompleteFlag;
    private BigDecimal mrpPlanningCode;
    private BigDecimal returnInspectionRequirement;
    private BigDecimal atoForecastControl;
    private BigDecimal releaseTimeFenceCode;
    private BigDecimal releaseTimeFenceDays;
    private String containerItemFlag;
    private String vehicleItemFlag;
    private BigDecimal maximumLoadWeight;
    private BigDecimal minimumFillPercent;
    private String containerTypeCode;
    private BigDecimal internalVolume;
    private Date whUpdateDate;
    private Long productFamilyItemId;
    private String globalAttributeCategory;
    private String purchasingTaxCode;
    private BigDecimal overcompletionToleranceType;
    private BigDecimal overcompletionToleranceValue;
    private BigDecimal effectivityControl;
    private String checkShortagesFlag;
    private BigDecimal overShipmentTolerance;
    private BigDecimal underShipmentTolerance;
    private BigDecimal overReturnTolerance;
    private BigDecimal underReturnTolerance;
    private BigDecimal equipmentType;
    private String recoveredPartDispCode;
    private String defectTrackingOnFlag;
    private String eventFlag;
    private String electronicFlag;
    private String downloadableFlag;
    private String commsNlTrackableFlag;
    private String assetCreationCode;
    private String commsActivationReqdFlag;
    private String orderableOnWebFlag;
    private String backOrderableFlag;
    private String webStatus;
    private String indivisibleFlag;
    private String dimensionUomCode;
    private BigDecimal unitLength;
    private BigDecimal unitWidth;
    private BigDecimal unitHeight;
    private String bulkPickedFlag;
    private String lotStatusEnabled;
    private Long defaultLotStatusId;
    private String serialStatusEnabled;
    private Long defaultSerialStatusId;
    private String lotSplitEnabled;
    private String lotMergeEnabled;
    private BigDecimal inventoryCarryPenalty;
    private BigDecimal operationSlackPenalty;
    private String financingAllowedFlag;
    private BigDecimal eamItemType;
    private String eamActivityTypeCode;
    private String eamActivityCauseCode;
    private String eamActNotificationFlag;
    private String eamActShutdownStatus;
    private BigDecimal dualUomControl;
    private String secondaryUomCode;
    private BigDecimal dualUomDeviationHigh;
    private BigDecimal dualUomDeviationLow;
    private String contractItemTypeCode;
    private String servReqEnabledCode;
    private String servBillingEnabledFlag;
    private String plannedInvPointFlag;
    private String lotTranslateEnabled;
    private String defaultSoSourceType;
    private String createSupplyFlag;
    private BigDecimal substitutionWindowCode;
    private BigDecimal substitutionWindowDays;
    private String ibItemInstanceClass;
    private String configModelType;
    private String lotSubstitutionEnabled;
    private BigDecimal minimumLicenseQuantity;
    private String eamActivitySourceCode;
    private Long currentPhaseId;
    private Integer objectVersionNumber;
    private String trackingQuantityInd;
    private String ontPricingQtySource;
    private String secondaryDefaultInd;
    private BigDecimal optionSpecificSourced;
    private String approvalStatus;
    private BigDecimal vmiMinimumUnits;
    private BigDecimal vmiMinimumDays;
    private BigDecimal vmiMaximumUnits;
    private BigDecimal vmiMaximumDays;
    private BigDecimal vmiFixedOrderQuantity;
    private BigDecimal soAuthorizationFlag;
    private BigDecimal consignedFlag;
    private BigDecimal asnAutoexpireFlag;
    private BigDecimal vmiForecastType;
    private BigDecimal forecastHorizon;
    private BigDecimal excludeFromBudgetFlag;
    private BigDecimal daysTgtInvSupply;
    private BigDecimal daysTgtInvWindow;
    private BigDecimal daysMaxInvSupply;
    private BigDecimal daysMaxInvWindow;
    private BigDecimal drpPlannedFlag;
    private BigDecimal criticalComponentFlag;
    private BigDecimal continousTransfer;
    private BigDecimal convergence;
    private BigDecimal divergence;
    private String configOrgs;
    private String configMatch;
    private String casNumber;
    private String childLotFlag;
    private String childLotPrefix;
    private BigDecimal childLotStartingNumber;
    private String childLotValidationFlag;
    private String copyLotAttributeFlag;
    private String defaultGrade;
    private String expirationActionCode;
    private BigDecimal expirationActionInterval;
    private String gradeControlFlag;
    private String hazardousMaterialFlag;
    private BigDecimal holdDays;
    private String lotDivisibleFlag;
    private BigDecimal maturityDays;
    private String parentChildGenerationFlag;
    private String processCostingEnabledFlag;
    private String processExecutionEnabledFlag;
    private String processQualityEnabledFlag;
    private Long processSupplyLocatorId;
    private String processSupplySubinventory;
    private Long processYieldLocatorId;
    private String processYieldSubinventory;
    private String recipeEnabledFlag;
    private BigDecimal retestInterval;
    private String chargePeriodicityCode;
    private BigDecimal repairLeadtime;
    private BigDecimal repairYield;
    private String prepositionPoint;
    private BigDecimal repairProgram;
    private BigDecimal subcontractingComponent;
    private BigDecimal outsourcedAssembly;
    private String egoMasterItemsDffCtx;
    private String gdsnOutboundEnabledFlag;
    private String tradeItemDescriptor;
    private String assetTrackedFlag;
    private String assetClass;
    private String serviceDurationTypeCode;
    private String serviceStartTypeCode;
    private String startUponMilestoneCode;
    private BigDecimal serviceStartDelay;
    private String allowSuspendFlag;
    private String allowTerminateFlag;
    private String requiresFulfillmentLocFlag;
    private String requiresItmAssociationFlag;
    private Long styleItemId;
    private String styleItemFlag;
    private Long lastSubmittedNirId;
    private String programName;
    private String programAppName;
    private String eligibilityCompatibilityRule;
    private String jobDefinitionName;
    private String jobDefinitionPackage;
    private String acdType;
    private String changeLineId;
    private String versionId;
    private Long masterItemVersionId;
    private Date versionStartDate;
    private Date versionEndDate;
    private Date implementationDate;
    private String templateItemFlag;
    private String qscSalesProductType;
    private Integer matchApprovalLevel;
    private Integer invoiceMatchOption;
    private String defaultTemplateFlag;
    private String inspectionRequiredFlag;
    private String receiptRequiredFlag;
    private Long assetCategoryId;
    private Long expenseAccount;
    private Long salesAccount;
    private String salesProductType;
    private String salesProductSubType;
    private String altItemCode;
    private String changeBitMap;
    private String currentPhaseCode;
    private Long inventoryOrganizationId;
    private String itemNumber;
    private String createdBy;
    private String lastUpdatedBy;
    private String dqSemanticKey;
    private String dqRequiredFlag;
    private Long threadId;
    private BigDecimal attributeNumber1;
    private BigDecimal attributeNumber2;
    private BigDecimal attributeNumber3;
    private BigDecimal attributeNumber4;
    private BigDecimal attributeNumber5;
    private BigDecimal attributeNumber6;
    private BigDecimal attributeNumber7;
    private BigDecimal attributeNumber8;
    private BigDecimal attributeNumber9;
    private BigDecimal attributeNumber10;
    private Date attributeDate1;
    private Date attributeDate2;
    private Date attributeDate3;
    private Date attributeDate4;
    private Date attributeDate5;
    private Date attributeTimestamp1;
    private Date attributeTimestamp2;
    private Date attributeTimestamp3;
    private Date attributeTimestamp4;
    private Date attributeTimestamp5;
    private String backToBackEnabled;
    private String contractManufacturing;
    private String safetyStockPlanningMethod;
    private BigDecimal demandPeriod;
    private BigDecimal daysOfCover;
    private Long masterOrgId;
    private String outsideProcessServiceFlag;
    private String allowMaintenanceAssetFlag;
    private String enableGenealogyTrackingFlag;
    private Integer completenessScore;
    private String cssEnabledFlag;
    private String engineeredItemFlag;
    private String forcePurchaseLeadTimeFlag;
    private String replacementType;
    private String hardPeggingLevel;
    private String comnSupplyPrjDemandFlag;
    private String enableIotFlag;
    private Long expenditureTypeId;
    private String description;

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdateLogin() {
        return lastUpdateLogin;
    }

    public void setLastUpdateLogin(String lastUpdateLogin) {
        this.lastUpdateLogin = lastUpdateLogin;
    }

    public String getSummaryFlag() {
        return summaryFlag;
    }

    public void setSummaryFlag(String summaryFlag) {
        this.summaryFlag = summaryFlag;
    }

    public String getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    public Date getStartDateActive() {
        return startDateActive;
    }

    public void setStartDateActive(Date startDateActive) {
        this.startDateActive = startDateActive;
    }

    public Date getEndDateActive() {
        return endDateActive;
    }

    public void setEndDateActive(Date endDateActive) {
        this.endDateActive = endDateActive;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getAccountingRuleId() {
        return accountingRuleId;
    }

    public void setAccountingRuleId(Long accountingRuleId) {
        this.accountingRuleId = accountingRuleId;
    }

    public Long getInvoicingRuleId() {
        return invoicingRuleId;
    }

    public void setInvoicingRuleId(Long invoicingRuleId) {
        this.invoicingRuleId = invoicingRuleId;
    }

    public String getAttributeCategory() {
        return attributeCategory;
    }

    public void setAttributeCategory(String attributeCategory) {
        this.attributeCategory = attributeCategory;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    public String getAttribute6() {
        return attribute6;
    }

    public void setAttribute6(String attribute6) {
        this.attribute6 = attribute6;
    }

    public String getAttribute7() {
        return attribute7;
    }

    public void setAttribute7(String attribute7) {
        this.attribute7 = attribute7;
    }

    public String getAttribute8() {
        return attribute8;
    }

    public void setAttribute8(String attribute8) {
        this.attribute8 = attribute8;
    }

    public String getAttribute9() {
        return attribute9;
    }

    public void setAttribute9(String attribute9) {
        this.attribute9 = attribute9;
    }

    public String getAttribute10() {
        return attribute10;
    }

    public void setAttribute10(String attribute10) {
        this.attribute10 = attribute10;
    }

    public String getAttribute11() {
        return attribute11;
    }

    public void setAttribute11(String attribute11) {
        this.attribute11 = attribute11;
    }

    public String getAttribute12() {
        return attribute12;
    }

    public void setAttribute12(String attribute12) {
        this.attribute12 = attribute12;
    }

    public String getAttribute13() {
        return attribute13;
    }

    public void setAttribute13(String attribute13) {
        this.attribute13 = attribute13;
    }

    public String getAttribute14() {
        return attribute14;
    }

    public void setAttribute14(String attribute14) {
        this.attribute14 = attribute14;
    }

    public String getAttribute15() {
        return attribute15;
    }

    public void setAttribute15(String attribute15) {
        this.attribute15 = attribute15;
    }

    public String getPurchasingItemFlag() {
        return purchasingItemFlag;
    }

    public void setPurchasingItemFlag(String purchasingItemFlag) {
        this.purchasingItemFlag = purchasingItemFlag;
    }

    public String getShippableItemFlag() {
        return shippableItemFlag;
    }

    public void setShippableItemFlag(String shippableItemFlag) {
        this.shippableItemFlag = shippableItemFlag;
    }

    public String getCustomerOrderFlag() {
        return customerOrderFlag;
    }

    public void setCustomerOrderFlag(String customerOrderFlag) {
        this.customerOrderFlag = customerOrderFlag;
    }

    public String getInternalOrderFlag() {
        return internalOrderFlag;
    }

    public void setInternalOrderFlag(String internalOrderFlag) {
        this.internalOrderFlag = internalOrderFlag;
    }

    public String getInventoryItemFlag() {
        return inventoryItemFlag;
    }

    public void setInventoryItemFlag(String inventoryItemFlag) {
        this.inventoryItemFlag = inventoryItemFlag;
    }

    public String getInventoryAssetFlag() {
        return inventoryAssetFlag;
    }

    public void setInventoryAssetFlag(String inventoryAssetFlag) {
        this.inventoryAssetFlag = inventoryAssetFlag;
    }

    public String getPurchasingEnabledFlag() {
        return purchasingEnabledFlag;
    }

    public void setPurchasingEnabledFlag(String purchasingEnabledFlag) {
        this.purchasingEnabledFlag = purchasingEnabledFlag;
    }

    public String getCustomerOrderEnabledFlag() {
        return customerOrderEnabledFlag;
    }

    public void setCustomerOrderEnabledFlag(String customerOrderEnabledFlag) {
        this.customerOrderEnabledFlag = customerOrderEnabledFlag;
    }

    public String getInternalOrderEnabledFlag() {
        return internalOrderEnabledFlag;
    }

    public void setInternalOrderEnabledFlag(String internalOrderEnabledFlag) {
        this.internalOrderEnabledFlag = internalOrderEnabledFlag;
    }

    public String getSoTransactionsFlag() {
        return soTransactionsFlag;
    }

    public void setSoTransactionsFlag(String soTransactionsFlag) {
        this.soTransactionsFlag = soTransactionsFlag;
    }

    public String getMtlTransactionsEnabledFlag() {
        return mtlTransactionsEnabledFlag;
    }

    public void setMtlTransactionsEnabledFlag(String mtlTransactionsEnabledFlag) {
        this.mtlTransactionsEnabledFlag = mtlTransactionsEnabledFlag;
    }

    public String getStockEnabledFlag() {
        return stockEnabledFlag;
    }

    public void setStockEnabledFlag(String stockEnabledFlag) {
        this.stockEnabledFlag = stockEnabledFlag;
    }

    public String getBuildInWipFlag() {
        return buildInWipFlag;
    }

    public void setBuildInWipFlag(String buildInWipFlag) {
        this.buildInWipFlag = buildInWipFlag;
    }

    public BigDecimal getRevisionQtyControlCode() {
        return revisionQtyControlCode;
    }

    public void setRevisionQtyControlCode(BigDecimal revisionQtyControlCode) {
        this.revisionQtyControlCode = revisionQtyControlCode;
    }

    public Long getItemCatalogGroupId() {
        return itemCatalogGroupId;
    }

    public void setItemCatalogGroupId(Long itemCatalogGroupId) {
        this.itemCatalogGroupId = itemCatalogGroupId;
    }

    public String getReturnableFlag() {
        return returnableFlag;
    }

    public void setReturnableFlag(String returnableFlag) {
        this.returnableFlag = returnableFlag;
    }

    public Long getDefaultShippingOrg() {
        return defaultShippingOrg;
    }

    public void setDefaultShippingOrg(Long defaultShippingOrg) {
        this.defaultShippingOrg = defaultShippingOrg;
    }

    public String getCollateralFlag() {
        return collateralFlag;
    }

    public void setCollateralFlag(String collateralFlag) {
        this.collateralFlag = collateralFlag;
    }

    public String getTaxableFlag() {
        return taxableFlag;
    }

    public void setTaxableFlag(String taxableFlag) {
        this.taxableFlag = taxableFlag;
    }

    public String getQtyRcvExceptionCode() {
        return qtyRcvExceptionCode;
    }

    public void setQtyRcvExceptionCode(String qtyRcvExceptionCode) {
        this.qtyRcvExceptionCode = qtyRcvExceptionCode;
    }

    public String getAllowItemDescUpdateFlag() {
        return allowItemDescUpdateFlag;
    }

    public void setAllowItemDescUpdateFlag(String allowItemDescUpdateFlag) {
        this.allowItemDescUpdateFlag = allowItemDescUpdateFlag;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Long getHazardClassId() {
        return hazardClassId;
    }

    public void setHazardClassId(Long hazardClassId) {
        this.hazardClassId = hazardClassId;
    }

    public String getNegotiationRequiredFlag() {
        return negotiationRequiredFlag;
    }

    public void setNegotiationRequiredFlag(String negotiationRequiredFlag) {
        this.negotiationRequiredFlag = negotiationRequiredFlag;
    }

    public BigDecimal getQtyRcvTolerance() {
        return qtyRcvTolerance;
    }

    public void setQtyRcvTolerance(BigDecimal qtyRcvTolerance) {
        this.qtyRcvTolerance = qtyRcvTolerance;
    }

    public BigDecimal getListPricePerUnit() {
        return listPricePerUnit;
    }

    public void setListPricePerUnit(BigDecimal listPricePerUnit) {
        this.listPricePerUnit = listPricePerUnit;
    }

    public Long getUnNumberId() {
        return unNumberId;
    }

    public void setUnNumberId(Long unNumberId) {
        this.unNumberId = unNumberId;
    }

    public BigDecimal getPriceTolerancePercent() {
        return priceTolerancePercent;
    }

    public void setPriceTolerancePercent(BigDecimal priceTolerancePercent) {
        this.priceTolerancePercent = priceTolerancePercent;
    }

    public BigDecimal getRoundingFactor() {
        return roundingFactor;
    }

    public void setRoundingFactor(BigDecimal roundingFactor) {
        this.roundingFactor = roundingFactor;
    }

    public String getUnitOfIssue() {
        return unitOfIssue;
    }

    public void setUnitOfIssue(String unitOfIssue) {
        this.unitOfIssue = unitOfIssue;
    }

    public String getEnforceShipToLocationCode() {
        return enforceShipToLocationCode;
    }

    public void setEnforceShipToLocationCode(String enforceShipToLocationCode) {
        this.enforceShipToLocationCode = enforceShipToLocationCode;
    }

    public String getAllowSubstituteReceiptsFlag() {
        return allowSubstituteReceiptsFlag;
    }

    public void setAllowSubstituteReceiptsFlag(String allowSubstituteReceiptsFlag) {
        this.allowSubstituteReceiptsFlag = allowSubstituteReceiptsFlag;
    }

    public String getAllowUnorderedReceiptsFlag() {
        return allowUnorderedReceiptsFlag;
    }

    public void setAllowUnorderedReceiptsFlag(String allowUnorderedReceiptsFlag) {
        this.allowUnorderedReceiptsFlag = allowUnorderedReceiptsFlag;
    }

    public String getAllowExpressDeliveryFlag() {
        return allowExpressDeliveryFlag;
    }

    public void setAllowExpressDeliveryFlag(String allowExpressDeliveryFlag) {
        this.allowExpressDeliveryFlag = allowExpressDeliveryFlag;
    }

    public BigDecimal getDaysEarlyReceiptAllowed() {
        return daysEarlyReceiptAllowed;
    }

    public void setDaysEarlyReceiptAllowed(BigDecimal daysEarlyReceiptAllowed) {
        this.daysEarlyReceiptAllowed = daysEarlyReceiptAllowed;
    }

    public BigDecimal getDaysLateReceiptAllowed() {
        return daysLateReceiptAllowed;
    }

    public void setDaysLateReceiptAllowed(BigDecimal daysLateReceiptAllowed) {
        this.daysLateReceiptAllowed = daysLateReceiptAllowed;
    }

    public String getReceiptDaysExceptionCode() {
        return receiptDaysExceptionCode;
    }

    public void setReceiptDaysExceptionCode(String receiptDaysExceptionCode) {
        this.receiptDaysExceptionCode = receiptDaysExceptionCode;
    }

    public Long getReceivingRoutingId() {
        return receivingRoutingId;
    }

    public void setReceivingRoutingId(Long receivingRoutingId) {
        this.receivingRoutingId = receivingRoutingId;
    }

    public BigDecimal getInvoiceCloseTolerance() {
        return invoiceCloseTolerance;
    }

    public void setInvoiceCloseTolerance(BigDecimal invoiceCloseTolerance) {
        this.invoiceCloseTolerance = invoiceCloseTolerance;
    }

    public BigDecimal getReceiveCloseTolerance() {
        return receiveCloseTolerance;
    }

    public void setReceiveCloseTolerance(BigDecimal receiveCloseTolerance) {
        this.receiveCloseTolerance = receiveCloseTolerance;
    }

    public String getAutoLotAlphaPrefix() {
        return autoLotAlphaPrefix;
    }

    public void setAutoLotAlphaPrefix(String autoLotAlphaPrefix) {
        this.autoLotAlphaPrefix = autoLotAlphaPrefix;
    }

    public String getStartAutoLotNumber() {
        return startAutoLotNumber;
    }

    public void setStartAutoLotNumber(String startAutoLotNumber) {
        this.startAutoLotNumber = startAutoLotNumber;
    }

    public BigDecimal getLotControlCode() {
        return lotControlCode;
    }

    public void setLotControlCode(BigDecimal lotControlCode) {
        this.lotControlCode = lotControlCode;
    }

    public BigDecimal getShelfLifeCode() {
        return shelfLifeCode;
    }

    public void setShelfLifeCode(BigDecimal shelfLifeCode) {
        this.shelfLifeCode = shelfLifeCode;
    }

    public BigDecimal getShelfLifeDays() {
        return shelfLifeDays;
    }

    public void setShelfLifeDays(BigDecimal shelfLifeDays) {
        this.shelfLifeDays = shelfLifeDays;
    }

    public BigDecimal getSerialNumberControlCode() {
        return serialNumberControlCode;
    }

    public void setSerialNumberControlCode(BigDecimal serialNumberControlCode) {
        this.serialNumberControlCode = serialNumberControlCode;
    }

    public String getStartAutoSerialNumber() {
        return startAutoSerialNumber;
    }

    public void setStartAutoSerialNumber(String startAutoSerialNumber) {
        this.startAutoSerialNumber = startAutoSerialNumber;
    }

    public String getAutoSerialAlphaPrefix() {
        return autoSerialAlphaPrefix;
    }

    public void setAutoSerialAlphaPrefix(String autoSerialAlphaPrefix) {
        this.autoSerialAlphaPrefix = autoSerialAlphaPrefix;
    }

    public BigDecimal getSourceType() {
        return sourceType;
    }

    public void setSourceType(BigDecimal sourceType) {
        this.sourceType = sourceType;
    }

    public Long getSourceOrganizationId() {
        return sourceOrganizationId;
    }

    public void setSourceOrganizationId(Long sourceOrganizationId) {
        this.sourceOrganizationId = sourceOrganizationId;
    }

    public String getSourceSubinventory() {
        return sourceSubinventory;
    }

    public void setSourceSubinventory(String sourceSubinventory) {
        this.sourceSubinventory = sourceSubinventory;
    }

    public BigDecimal getRestrictSubinventoriesCode() {
        return restrictSubinventoriesCode;
    }

    public void setRestrictSubinventoriesCode(BigDecimal restrictSubinventoriesCode) {
        this.restrictSubinventoriesCode = restrictSubinventoriesCode;
    }

    public BigDecimal getUnitWeight() {
        return unitWeight;
    }

    public void setUnitWeight(BigDecimal unitWeight) {
        this.unitWeight = unitWeight;
    }

    public String getWeightUomCode() {
        return weightUomCode;
    }

    public void setWeightUomCode(String weightUomCode) {
        this.weightUomCode = weightUomCode;
    }

    public String getVolumeUomCode() {
        return volumeUomCode;
    }

    public void setVolumeUomCode(String volumeUomCode) {
        this.volumeUomCode = volumeUomCode;
    }

    public BigDecimal getUnitVolume() {
        return unitVolume;
    }

    public void setUnitVolume(BigDecimal unitVolume) {
        this.unitVolume = unitVolume;
    }

    public BigDecimal getRestrictLocatorsCode() {
        return restrictLocatorsCode;
    }

    public void setRestrictLocatorsCode(BigDecimal restrictLocatorsCode) {
        this.restrictLocatorsCode = restrictLocatorsCode;
    }

    public BigDecimal getLocationControlCode() {
        return locationControlCode;
    }

    public void setLocationControlCode(BigDecimal locationControlCode) {
        this.locationControlCode = locationControlCode;
    }

    public BigDecimal getShrinkageRate() {
        return shrinkageRate;
    }

    public void setShrinkageRate(BigDecimal shrinkageRate) {
        this.shrinkageRate = shrinkageRate;
    }

    public BigDecimal getAcceptableEarlyDays() {
        return acceptableEarlyDays;
    }

    public void setAcceptableEarlyDays(BigDecimal acceptableEarlyDays) {
        this.acceptableEarlyDays = acceptableEarlyDays;
    }

    public BigDecimal getPlanningTimeFenceCode() {
        return planningTimeFenceCode;
    }

    public void setPlanningTimeFenceCode(BigDecimal planningTimeFenceCode) {
        this.planningTimeFenceCode = planningTimeFenceCode;
    }

    public BigDecimal getDemandTimeFenceCode() {
        return demandTimeFenceCode;
    }

    public void setDemandTimeFenceCode(BigDecimal demandTimeFenceCode) {
        this.demandTimeFenceCode = demandTimeFenceCode;
    }

    public BigDecimal getLeadTimeLotSize() {
        return leadTimeLotSize;
    }

    public void setLeadTimeLotSize(BigDecimal leadTimeLotSize) {
        this.leadTimeLotSize = leadTimeLotSize;
    }

    public BigDecimal getStdLotSize() {
        return stdLotSize;
    }

    public void setStdLotSize(BigDecimal stdLotSize) {
        this.stdLotSize = stdLotSize;
    }

    public BigDecimal getCumManufacturingLeadTime() {
        return cumManufacturingLeadTime;
    }

    public void setCumManufacturingLeadTime(BigDecimal cumManufacturingLeadTime) {
        this.cumManufacturingLeadTime = cumManufacturingLeadTime;
    }

    public BigDecimal getOverrunPercentage() {
        return overrunPercentage;
    }

    public void setOverrunPercentage(BigDecimal overrunPercentage) {
        this.overrunPercentage = overrunPercentage;
    }

    public String getMrpCalculateAtpFlag() {
        return mrpCalculateAtpFlag;
    }

    public void setMrpCalculateAtpFlag(String mrpCalculateAtpFlag) {
        this.mrpCalculateAtpFlag = mrpCalculateAtpFlag;
    }

    public BigDecimal getAcceptableRateIncrease() {
        return acceptableRateIncrease;
    }

    public void setAcceptableRateIncrease(BigDecimal acceptableRateIncrease) {
        this.acceptableRateIncrease = acceptableRateIncrease;
    }

    public BigDecimal getAcceptableRateDecrease() {
        return acceptableRateDecrease;
    }

    public void setAcceptableRateDecrease(BigDecimal acceptableRateDecrease) {
        this.acceptableRateDecrease = acceptableRateDecrease;
    }

    public BigDecimal getCumulativeTotalLeadTime() {
        return cumulativeTotalLeadTime;
    }

    public void setCumulativeTotalLeadTime(BigDecimal cumulativeTotalLeadTime) {
        this.cumulativeTotalLeadTime = cumulativeTotalLeadTime;
    }

    public BigDecimal getPlanningTimeFenceDays() {
        return planningTimeFenceDays;
    }

    public void setPlanningTimeFenceDays(BigDecimal planningTimeFenceDays) {
        this.planningTimeFenceDays = planningTimeFenceDays;
    }

    public BigDecimal getDemandTimeFenceDays() {
        return demandTimeFenceDays;
    }

    public void setDemandTimeFenceDays(BigDecimal demandTimeFenceDays) {
        this.demandTimeFenceDays = demandTimeFenceDays;
    }

    public String getEndAssemblyPeggingFlag() {
        return endAssemblyPeggingFlag;
    }

    public void setEndAssemblyPeggingFlag(String endAssemblyPeggingFlag) {
        this.endAssemblyPeggingFlag = endAssemblyPeggingFlag;
    }

    public String getRepetitivePlanningFlag() {
        return repetitivePlanningFlag;
    }

    public void setRepetitivePlanningFlag(String repetitivePlanningFlag) {
        this.repetitivePlanningFlag = repetitivePlanningFlag;
    }

    public String getPlanningExceptionSet() {
        return planningExceptionSet;
    }

    public void setPlanningExceptionSet(String planningExceptionSet) {
        this.planningExceptionSet = planningExceptionSet;
    }

    public BigDecimal getBomItemType() {
        return bomItemType;
    }

    public void setBomItemType(BigDecimal bomItemType) {
        this.bomItemType = bomItemType;
    }

    public String getPickComponentsFlag() {
        return pickComponentsFlag;
    }

    public void setPickComponentsFlag(String pickComponentsFlag) {
        this.pickComponentsFlag = pickComponentsFlag;
    }

    public String getReplenishToOrderFlag() {
        return replenishToOrderFlag;
    }

    public void setReplenishToOrderFlag(String replenishToOrderFlag) {
        this.replenishToOrderFlag = replenishToOrderFlag;
    }

    public Long getBaseItemId() {
        return baseItemId;
    }

    public void setBaseItemId(Long baseItemId) {
        this.baseItemId = baseItemId;
    }

    public String getAtpComponentsFlag() {
        return atpComponentsFlag;
    }

    public void setAtpComponentsFlag(String atpComponentsFlag) {
        this.atpComponentsFlag = atpComponentsFlag;
    }

    public String getAtpFlag() {
        return atpFlag;
    }

    public void setAtpFlag(String atpFlag) {
        this.atpFlag = atpFlag;
    }

    public BigDecimal getFixedLeadTime() {
        return fixedLeadTime;
    }

    public void setFixedLeadTime(BigDecimal fixedLeadTime) {
        this.fixedLeadTime = fixedLeadTime;
    }

    public BigDecimal getVariableLeadTime() {
        return variableLeadTime;
    }

    public void setVariableLeadTime(BigDecimal variableLeadTime) {
        this.variableLeadTime = variableLeadTime;
    }

    public Long getWipSupplyLocatorId() {
        return wipSupplyLocatorId;
    }

    public void setWipSupplyLocatorId(Long wipSupplyLocatorId) {
        this.wipSupplyLocatorId = wipSupplyLocatorId;
    }

    public Long getWipSupplyType() {
        return wipSupplyType;
    }

    public void setWipSupplyType(Long wipSupplyType) {
        this.wipSupplyType = wipSupplyType;
    }

    public String getWipSupplySubinventory() {
        return wipSupplySubinventory;
    }

    public void setWipSupplySubinventory(String wipSupplySubinventory) {
        this.wipSupplySubinventory = wipSupplySubinventory;
    }

    public String getPrimaryUomCode() {
        return primaryUomCode;
    }

    public void setPrimaryUomCode(String primaryUomCode) {
        this.primaryUomCode = primaryUomCode;
    }

    public BigDecimal getAllowedUnitsLookupCode() {
        return allowedUnitsLookupCode;
    }

    public void setAllowedUnitsLookupCode(BigDecimal allowedUnitsLookupCode) {
        this.allowedUnitsLookupCode = allowedUnitsLookupCode;
    }

    public String getDefaultIncludeInRollupFlag() {
        return defaultIncludeInRollupFlag;
    }

    public void setDefaultIncludeInRollupFlag(String defaultIncludeInRollupFlag) {
        this.defaultIncludeInRollupFlag = defaultIncludeInRollupFlag;
    }

    public String getInventoryItemStatusCode() {
        return inventoryItemStatusCode;
    }

    public void setInventoryItemStatusCode(String inventoryItemStatusCode) {
        this.inventoryItemStatusCode = inventoryItemStatusCode;
    }

    public BigDecimal getInventoryPlanningCode() {
        return inventoryPlanningCode;
    }

    public void setInventoryPlanningCode(BigDecimal inventoryPlanningCode) {
        this.inventoryPlanningCode = inventoryPlanningCode;
    }

    public String getPlannerCode() {
        return plannerCode;
    }

    public void setPlannerCode(String plannerCode) {
        this.plannerCode = plannerCode;
    }

    public BigDecimal getPlanningMakeBuyCode() {
        return planningMakeBuyCode;
    }

    public void setPlanningMakeBuyCode(BigDecimal planningMakeBuyCode) {
        this.planningMakeBuyCode = planningMakeBuyCode;
    }

    public BigDecimal getFixedLotMultiplier() {
        return fixedLotMultiplier;
    }

    public void setFixedLotMultiplier(BigDecimal fixedLotMultiplier) {
        this.fixedLotMultiplier = fixedLotMultiplier;
    }

    public BigDecimal getRoundingControlType() {
        return roundingControlType;
    }

    public void setRoundingControlType(BigDecimal roundingControlType) {
        this.roundingControlType = roundingControlType;
    }

    public BigDecimal getCarryingCost() {
        return carryingCost;
    }

    public void setCarryingCost(BigDecimal carryingCost) {
        this.carryingCost = carryingCost;
    }

    public BigDecimal getPostprocessingLeadTime() {
        return postprocessingLeadTime;
    }

    public void setPostprocessingLeadTime(BigDecimal postprocessingLeadTime) {
        this.postprocessingLeadTime = postprocessingLeadTime;
    }

    public BigDecimal getPreprocessingLeadTime() {
        return preprocessingLeadTime;
    }

    public void setPreprocessingLeadTime(BigDecimal preprocessingLeadTime) {
        this.preprocessingLeadTime = preprocessingLeadTime;
    }

    public BigDecimal getFullLeadTime() {
        return fullLeadTime;
    }

    public void setFullLeadTime(BigDecimal fullLeadTime) {
        this.fullLeadTime = fullLeadTime;
    }

    public BigDecimal getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(BigDecimal orderCost) {
        this.orderCost = orderCost;
    }

    public BigDecimal getMrpSafetyStockPercent() {
        return mrpSafetyStockPercent;
    }

    public void setMrpSafetyStockPercent(BigDecimal mrpSafetyStockPercent) {
        this.mrpSafetyStockPercent = mrpSafetyStockPercent;
    }

    public BigDecimal getMrpSafetyStockCode() {
        return mrpSafetyStockCode;
    }

    public void setMrpSafetyStockCode(BigDecimal mrpSafetyStockCode) {
        this.mrpSafetyStockCode = mrpSafetyStockCode;
    }

    public BigDecimal getMinMinmaxQuantity() {
        return minMinmaxQuantity;
    }

    public void setMinMinmaxQuantity(BigDecimal minMinmaxQuantity) {
        this.minMinmaxQuantity = minMinmaxQuantity;
    }

    public BigDecimal getMaxMinmaxQuantity() {
        return maxMinmaxQuantity;
    }

    public void setMaxMinmaxQuantity(BigDecimal maxMinmaxQuantity) {
        this.maxMinmaxQuantity = maxMinmaxQuantity;
    }

    public BigDecimal getMinimumOrderQuantity() {
        return minimumOrderQuantity;
    }

    public void setMinimumOrderQuantity(BigDecimal minimumOrderQuantity) {
        this.minimumOrderQuantity = minimumOrderQuantity;
    }

    public BigDecimal getFixedOrderQuantity() {
        return fixedOrderQuantity;
    }

    public void setFixedOrderQuantity(BigDecimal fixedOrderQuantity) {
        this.fixedOrderQuantity = fixedOrderQuantity;
    }

    public BigDecimal getFixedDaysSupply() {
        return fixedDaysSupply;
    }

    public void setFixedDaysSupply(BigDecimal fixedDaysSupply) {
        this.fixedDaysSupply = fixedDaysSupply;
    }

    public BigDecimal getMaximumOrderQuantity() {
        return maximumOrderQuantity;
    }

    public void setMaximumOrderQuantity(BigDecimal maximumOrderQuantity) {
        this.maximumOrderQuantity = maximumOrderQuantity;
    }

    public Long getAtpRuleId() {
        return atpRuleId;
    }

    public void setAtpRuleId(Long atpRuleId) {
        this.atpRuleId = atpRuleId;
    }

    public Long getPickingRuleId() {
        return pickingRuleId;
    }

    public void setPickingRuleId(Long pickingRuleId) {
        this.pickingRuleId = pickingRuleId;
    }

    public BigDecimal getReservableType() {
        return reservableType;
    }

    public void setReservableType(BigDecimal reservableType) {
        this.reservableType = reservableType;
    }

    public BigDecimal getPositiveMeasurementError() {
        return positiveMeasurementError;
    }

    public void setPositiveMeasurementError(BigDecimal positiveMeasurementError) {
        this.positiveMeasurementError = positiveMeasurementError;
    }

    public BigDecimal getNegativeMeasurementError() {
        return negativeMeasurementError;
    }

    public void setNegativeMeasurementError(BigDecimal negativeMeasurementError) {
        this.negativeMeasurementError = negativeMeasurementError;
    }

    public Long getEngineeringItemId() {
        return engineeringItemId;
    }

    public void setEngineeringItemId(Long engineeringItemId) {
        this.engineeringItemId = engineeringItemId;
    }

    public BigDecimal getServiceStartingDelay() {
        return serviceStartingDelay;
    }

    public void setServiceStartingDelay(BigDecimal serviceStartingDelay) {
        this.serviceStartingDelay = serviceStartingDelay;
    }

    public String getServiceableProductFlag() {
        return serviceableProductFlag;
    }

    public void setServiceableProductFlag(String serviceableProductFlag) {
        this.serviceableProductFlag = serviceableProductFlag;
    }

    public Long getPaymentTermsId() {
        return paymentTermsId;
    }

    public void setPaymentTermsId(Long paymentTermsId) {
        this.paymentTermsId = paymentTermsId;
    }

    public String getMaterialBillableFlag() {
        return materialBillableFlag;
    }

    public void setMaterialBillableFlag(String materialBillableFlag) {
        this.materialBillableFlag = materialBillableFlag;
    }

    public Long getCoverageScheduleId() {
        return coverageScheduleId;
    }

    public void setCoverageScheduleId(Long coverageScheduleId) {
        this.coverageScheduleId = coverageScheduleId;
    }

    public String getServiceDurationPeriodCode() {
        return serviceDurationPeriodCode;
    }

    public void setServiceDurationPeriodCode(String serviceDurationPeriodCode) {
        this.serviceDurationPeriodCode = serviceDurationPeriodCode;
    }

    public BigDecimal getServiceDuration() {
        return serviceDuration;
    }

    public void setServiceDuration(BigDecimal serviceDuration) {
        this.serviceDuration = serviceDuration;
    }

    public String getInvoiceableItemFlag() {
        return invoiceableItemFlag;
    }

    public void setInvoiceableItemFlag(String invoiceableItemFlag) {
        this.invoiceableItemFlag = invoiceableItemFlag;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getInvoiceEnabledFlag() {
        return invoiceEnabledFlag;
    }

    public void setInvoiceEnabledFlag(String invoiceEnabledFlag) {
        this.invoiceEnabledFlag = invoiceEnabledFlag;
    }

    public String getMustUseApprovedVendorFlag() {
        return mustUseApprovedVendorFlag;
    }

    public void setMustUseApprovedVendorFlag(String mustUseApprovedVendorFlag) {
        this.mustUseApprovedVendorFlag = mustUseApprovedVendorFlag;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getOutsideOperationFlag() {
        return outsideOperationFlag;
    }

    public void setOutsideOperationFlag(String outsideOperationFlag) {
        this.outsideOperationFlag = outsideOperationFlag;
    }

    public String getOutsideOperationUomType() {
        return outsideOperationUomType;
    }

    public void setOutsideOperationUomType(String outsideOperationUomType) {
        this.outsideOperationUomType = outsideOperationUomType;
    }

    public BigDecimal getSafetyStockBucketDays() {
        return safetyStockBucketDays;
    }

    public void setSafetyStockBucketDays(BigDecimal safetyStockBucketDays) {
        this.safetyStockBucketDays = safetyStockBucketDays;
    }

    public String getAutoReduceMps() {
        return autoReduceMps;
    }

    public void setAutoReduceMps(String autoReduceMps) {
        this.autoReduceMps = autoReduceMps;
    }

    public String getCostingEnabledFlag() {
        return costingEnabledFlag;
    }

    public void setCostingEnabledFlag(String costingEnabledFlag) {
        this.costingEnabledFlag = costingEnabledFlag;
    }

    public String getAutoCreatedConfigFlag() {
        return autoCreatedConfigFlag;
    }

    public void setAutoCreatedConfigFlag(String autoCreatedConfigFlag) {
        this.autoCreatedConfigFlag = autoCreatedConfigFlag;
    }

    public String getCycleCountEnabledFlag() {
        return cycleCountEnabledFlag;
    }

    public void setCycleCountEnabledFlag(String cycleCountEnabledFlag) {
        this.cycleCountEnabledFlag = cycleCountEnabledFlag;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getShipModelCompleteFlag() {
        return shipModelCompleteFlag;
    }

    public void setShipModelCompleteFlag(String shipModelCompleteFlag) {
        this.shipModelCompleteFlag = shipModelCompleteFlag;
    }

    public BigDecimal getMrpPlanningCode() {
        return mrpPlanningCode;
    }

    public void setMrpPlanningCode(BigDecimal mrpPlanningCode) {
        this.mrpPlanningCode = mrpPlanningCode;
    }

    public BigDecimal getReturnInspectionRequirement() {
        return returnInspectionRequirement;
    }

    public void setReturnInspectionRequirement(BigDecimal returnInspectionRequirement) {
        this.returnInspectionRequirement = returnInspectionRequirement;
    }

    public BigDecimal getAtoForecastControl() {
        return atoForecastControl;
    }

    public void setAtoForecastControl(BigDecimal atoForecastControl) {
        this.atoForecastControl = atoForecastControl;
    }

    public BigDecimal getReleaseTimeFenceCode() {
        return releaseTimeFenceCode;
    }

    public void setReleaseTimeFenceCode(BigDecimal releaseTimeFenceCode) {
        this.releaseTimeFenceCode = releaseTimeFenceCode;
    }

    public BigDecimal getReleaseTimeFenceDays() {
        return releaseTimeFenceDays;
    }

    public void setReleaseTimeFenceDays(BigDecimal releaseTimeFenceDays) {
        this.releaseTimeFenceDays = releaseTimeFenceDays;
    }

    public String getContainerItemFlag() {
        return containerItemFlag;
    }

    public void setContainerItemFlag(String containerItemFlag) {
        this.containerItemFlag = containerItemFlag;
    }

    public String getVehicleItemFlag() {
        return vehicleItemFlag;
    }

    public void setVehicleItemFlag(String vehicleItemFlag) {
        this.vehicleItemFlag = vehicleItemFlag;
    }

    public BigDecimal getMaximumLoadWeight() {
        return maximumLoadWeight;
    }

    public void setMaximumLoadWeight(BigDecimal maximumLoadWeight) {
        this.maximumLoadWeight = maximumLoadWeight;
    }

    public BigDecimal getMinimumFillPercent() {
        return minimumFillPercent;
    }

    public void setMinimumFillPercent(BigDecimal minimumFillPercent) {
        this.minimumFillPercent = minimumFillPercent;
    }

    public String getContainerTypeCode() {
        return containerTypeCode;
    }

    public void setContainerTypeCode(String containerTypeCode) {
        this.containerTypeCode = containerTypeCode;
    }

    public BigDecimal getInternalVolume() {
        return internalVolume;
    }

    public void setInternalVolume(BigDecimal internalVolume) {
        this.internalVolume = internalVolume;
    }

    public Date getWhUpdateDate() {
        return whUpdateDate;
    }

    public void setWhUpdateDate(Date whUpdateDate) {
        this.whUpdateDate = whUpdateDate;
    }

    public Long getProductFamilyItemId() {
        return productFamilyItemId;
    }

    public void setProductFamilyItemId(Long productFamilyItemId) {
        this.productFamilyItemId = productFamilyItemId;
    }

    public String getGlobalAttributeCategory() {
        return globalAttributeCategory;
    }

    public void setGlobalAttributeCategory(String globalAttributeCategory) {
        this.globalAttributeCategory = globalAttributeCategory;
    }

    public String getPurchasingTaxCode() {
        return purchasingTaxCode;
    }

    public void setPurchasingTaxCode(String purchasingTaxCode) {
        this.purchasingTaxCode = purchasingTaxCode;
    }

    public BigDecimal getOvercompletionToleranceType() {
        return overcompletionToleranceType;
    }

    public void setOvercompletionToleranceType(BigDecimal overcompletionToleranceType) {
        this.overcompletionToleranceType = overcompletionToleranceType;
    }

    public BigDecimal getOvercompletionToleranceValue() {
        return overcompletionToleranceValue;
    }

    public void setOvercompletionToleranceValue(BigDecimal overcompletionToleranceValue) {
        this.overcompletionToleranceValue = overcompletionToleranceValue;
    }

    public BigDecimal getEffectivityControl() {
        return effectivityControl;
    }

    public void setEffectivityControl(BigDecimal effectivityControl) {
        this.effectivityControl = effectivityControl;
    }

    public String getCheckShortagesFlag() {
        return checkShortagesFlag;
    }

    public void setCheckShortagesFlag(String checkShortagesFlag) {
        this.checkShortagesFlag = checkShortagesFlag;
    }

    public BigDecimal getOverShipmentTolerance() {
        return overShipmentTolerance;
    }

    public void setOverShipmentTolerance(BigDecimal overShipmentTolerance) {
        this.overShipmentTolerance = overShipmentTolerance;
    }

    public BigDecimal getUnderShipmentTolerance() {
        return underShipmentTolerance;
    }

    public void setUnderShipmentTolerance(BigDecimal underShipmentTolerance) {
        this.underShipmentTolerance = underShipmentTolerance;
    }

    public BigDecimal getOverReturnTolerance() {
        return overReturnTolerance;
    }

    public void setOverReturnTolerance(BigDecimal overReturnTolerance) {
        this.overReturnTolerance = overReturnTolerance;
    }

    public BigDecimal getUnderReturnTolerance() {
        return underReturnTolerance;
    }

    public void setUnderReturnTolerance(BigDecimal underReturnTolerance) {
        this.underReturnTolerance = underReturnTolerance;
    }

    public BigDecimal getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(BigDecimal equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getRecoveredPartDispCode() {
        return recoveredPartDispCode;
    }

    public void setRecoveredPartDispCode(String recoveredPartDispCode) {
        this.recoveredPartDispCode = recoveredPartDispCode;
    }

    public String getDefectTrackingOnFlag() {
        return defectTrackingOnFlag;
    }

    public void setDefectTrackingOnFlag(String defectTrackingOnFlag) {
        this.defectTrackingOnFlag = defectTrackingOnFlag;
    }

    public String getEventFlag() {
        return eventFlag;
    }

    public void setEventFlag(String eventFlag) {
        this.eventFlag = eventFlag;
    }

    public String getElectronicFlag() {
        return electronicFlag;
    }

    public void setElectronicFlag(String electronicFlag) {
        this.electronicFlag = electronicFlag;
    }

    public String getDownloadableFlag() {
        return downloadableFlag;
    }

    public void setDownloadableFlag(String downloadableFlag) {
        this.downloadableFlag = downloadableFlag;
    }

    public String getCommsNlTrackableFlag() {
        return commsNlTrackableFlag;
    }

    public void setCommsNlTrackableFlag(String commsNlTrackableFlag) {
        this.commsNlTrackableFlag = commsNlTrackableFlag;
    }

    public String getAssetCreationCode() {
        return assetCreationCode;
    }

    public void setAssetCreationCode(String assetCreationCode) {
        this.assetCreationCode = assetCreationCode;
    }

    public String getCommsActivationReqdFlag() {
        return commsActivationReqdFlag;
    }

    public void setCommsActivationReqdFlag(String commsActivationReqdFlag) {
        this.commsActivationReqdFlag = commsActivationReqdFlag;
    }

    public String getOrderableOnWebFlag() {
        return orderableOnWebFlag;
    }

    public void setOrderableOnWebFlag(String orderableOnWebFlag) {
        this.orderableOnWebFlag = orderableOnWebFlag;
    }

    public String getBackOrderableFlag() {
        return backOrderableFlag;
    }

    public void setBackOrderableFlag(String backOrderableFlag) {
        this.backOrderableFlag = backOrderableFlag;
    }

    public String getWebStatus() {
        return webStatus;
    }

    public void setWebStatus(String webStatus) {
        this.webStatus = webStatus;
    }

    public String getIndivisibleFlag() {
        return indivisibleFlag;
    }

    public void setIndivisibleFlag(String indivisibleFlag) {
        this.indivisibleFlag = indivisibleFlag;
    }

    public String getDimensionUomCode() {
        return dimensionUomCode;
    }

    public void setDimensionUomCode(String dimensionUomCode) {
        this.dimensionUomCode = dimensionUomCode;
    }

    public BigDecimal getUnitLength() {
        return unitLength;
    }

    public void setUnitLength(BigDecimal unitLength) {
        this.unitLength = unitLength;
    }

    public BigDecimal getUnitWidth() {
        return unitWidth;
    }

    public void setUnitWidth(BigDecimal unitWidth) {
        this.unitWidth = unitWidth;
    }

    public BigDecimal getUnitHeight() {
        return unitHeight;
    }

    public void setUnitHeight(BigDecimal unitHeight) {
        this.unitHeight = unitHeight;
    }

    public String getBulkPickedFlag() {
        return bulkPickedFlag;
    }

    public void setBulkPickedFlag(String bulkPickedFlag) {
        this.bulkPickedFlag = bulkPickedFlag;
    }

    public String getLotStatusEnabled() {
        return lotStatusEnabled;
    }

    public void setLotStatusEnabled(String lotStatusEnabled) {
        this.lotStatusEnabled = lotStatusEnabled;
    }

    public Long getDefaultLotStatusId() {
        return defaultLotStatusId;
    }

    public void setDefaultLotStatusId(Long defaultLotStatusId) {
        this.defaultLotStatusId = defaultLotStatusId;
    }

    public String getSerialStatusEnabled() {
        return serialStatusEnabled;
    }

    public void setSerialStatusEnabled(String serialStatusEnabled) {
        this.serialStatusEnabled = serialStatusEnabled;
    }

    public Long getDefaultSerialStatusId() {
        return defaultSerialStatusId;
    }

    public void setDefaultSerialStatusId(Long defaultSerialStatusId) {
        this.defaultSerialStatusId = defaultSerialStatusId;
    }

    public String getLotSplitEnabled() {
        return lotSplitEnabled;
    }

    public void setLotSplitEnabled(String lotSplitEnabled) {
        this.lotSplitEnabled = lotSplitEnabled;
    }

    public String getLotMergeEnabled() {
        return lotMergeEnabled;
    }

    public void setLotMergeEnabled(String lotMergeEnabled) {
        this.lotMergeEnabled = lotMergeEnabled;
    }

    public BigDecimal getInventoryCarryPenalty() {
        return inventoryCarryPenalty;
    }

    public void setInventoryCarryPenalty(BigDecimal inventoryCarryPenalty) {
        this.inventoryCarryPenalty = inventoryCarryPenalty;
    }

    public BigDecimal getOperationSlackPenalty() {
        return operationSlackPenalty;
    }

    public void setOperationSlackPenalty(BigDecimal operationSlackPenalty) {
        this.operationSlackPenalty = operationSlackPenalty;
    }

    public String getFinancingAllowedFlag() {
        return financingAllowedFlag;
    }

    public void setFinancingAllowedFlag(String financingAllowedFlag) {
        this.financingAllowedFlag = financingAllowedFlag;
    }

    public BigDecimal getEamItemType() {
        return eamItemType;
    }

    public void setEamItemType(BigDecimal eamItemType) {
        this.eamItemType = eamItemType;
    }

    public String getEamActivityTypeCode() {
        return eamActivityTypeCode;
    }

    public void setEamActivityTypeCode(String eamActivityTypeCode) {
        this.eamActivityTypeCode = eamActivityTypeCode;
    }

    public String getEamActivityCauseCode() {
        return eamActivityCauseCode;
    }

    public void setEamActivityCauseCode(String eamActivityCauseCode) {
        this.eamActivityCauseCode = eamActivityCauseCode;
    }

    public String getEamActNotificationFlag() {
        return eamActNotificationFlag;
    }

    public void setEamActNotificationFlag(String eamActNotificationFlag) {
        this.eamActNotificationFlag = eamActNotificationFlag;
    }

    public String getEamActShutdownStatus() {
        return eamActShutdownStatus;
    }

    public void setEamActShutdownStatus(String eamActShutdownStatus) {
        this.eamActShutdownStatus = eamActShutdownStatus;
    }

    public BigDecimal getDualUomControl() {
        return dualUomControl;
    }

    public void setDualUomControl(BigDecimal dualUomControl) {
        this.dualUomControl = dualUomControl;
    }

    public String getSecondaryUomCode() {
        return secondaryUomCode;
    }

    public void setSecondaryUomCode(String secondaryUomCode) {
        this.secondaryUomCode = secondaryUomCode;
    }

    public BigDecimal getDualUomDeviationHigh() {
        return dualUomDeviationHigh;
    }

    public void setDualUomDeviationHigh(BigDecimal dualUomDeviationHigh) {
        this.dualUomDeviationHigh = dualUomDeviationHigh;
    }

    public BigDecimal getDualUomDeviationLow() {
        return dualUomDeviationLow;
    }

    public void setDualUomDeviationLow(BigDecimal dualUomDeviationLow) {
        this.dualUomDeviationLow = dualUomDeviationLow;
    }

    public String getContractItemTypeCode() {
        return contractItemTypeCode;
    }

    public void setContractItemTypeCode(String contractItemTypeCode) {
        this.contractItemTypeCode = contractItemTypeCode;
    }

    public String getServReqEnabledCode() {
        return servReqEnabledCode;
    }

    public void setServReqEnabledCode(String servReqEnabledCode) {
        this.servReqEnabledCode = servReqEnabledCode;
    }

    public String getServBillingEnabledFlag() {
        return servBillingEnabledFlag;
    }

    public void setServBillingEnabledFlag(String servBillingEnabledFlag) {
        this.servBillingEnabledFlag = servBillingEnabledFlag;
    }

    public String getPlannedInvPointFlag() {
        return plannedInvPointFlag;
    }

    public void setPlannedInvPointFlag(String plannedInvPointFlag) {
        this.plannedInvPointFlag = plannedInvPointFlag;
    }

    public String getLotTranslateEnabled() {
        return lotTranslateEnabled;
    }

    public void setLotTranslateEnabled(String lotTranslateEnabled) {
        this.lotTranslateEnabled = lotTranslateEnabled;
    }

    public String getDefaultSoSourceType() {
        return defaultSoSourceType;
    }

    public void setDefaultSoSourceType(String defaultSoSourceType) {
        this.defaultSoSourceType = defaultSoSourceType;
    }

    public String getCreateSupplyFlag() {
        return createSupplyFlag;
    }

    public void setCreateSupplyFlag(String createSupplyFlag) {
        this.createSupplyFlag = createSupplyFlag;
    }

    public BigDecimal getSubstitutionWindowCode() {
        return substitutionWindowCode;
    }

    public void setSubstitutionWindowCode(BigDecimal substitutionWindowCode) {
        this.substitutionWindowCode = substitutionWindowCode;
    }

    public BigDecimal getSubstitutionWindowDays() {
        return substitutionWindowDays;
    }

    public void setSubstitutionWindowDays(BigDecimal substitutionWindowDays) {
        this.substitutionWindowDays = substitutionWindowDays;
    }

    public String getIbItemInstanceClass() {
        return ibItemInstanceClass;
    }

    public void setIbItemInstanceClass(String ibItemInstanceClass) {
        this.ibItemInstanceClass = ibItemInstanceClass;
    }

    public String getConfigModelType() {
        return configModelType;
    }

    public void setConfigModelType(String configModelType) {
        this.configModelType = configModelType;
    }

    public String getLotSubstitutionEnabled() {
        return lotSubstitutionEnabled;
    }

    public void setLotSubstitutionEnabled(String lotSubstitutionEnabled) {
        this.lotSubstitutionEnabled = lotSubstitutionEnabled;
    }

    public BigDecimal getMinimumLicenseQuantity() {
        return minimumLicenseQuantity;
    }

    public void setMinimumLicenseQuantity(BigDecimal minimumLicenseQuantity) {
        this.minimumLicenseQuantity = minimumLicenseQuantity;
    }

    public String getEamActivitySourceCode() {
        return eamActivitySourceCode;
    }

    public void setEamActivitySourceCode(String eamActivitySourceCode) {
        this.eamActivitySourceCode = eamActivitySourceCode;
    }

    public Long getCurrentPhaseId() {
        return currentPhaseId;
    }

    public void setCurrentPhaseId(Long currentPhaseId) {
        this.currentPhaseId = currentPhaseId;
    }

    public Integer getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(Integer objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }

    public String getTrackingQuantityInd() {
        return trackingQuantityInd;
    }

    public void setTrackingQuantityInd(String trackingQuantityInd) {
        this.trackingQuantityInd = trackingQuantityInd;
    }

    public String getOntPricingQtySource() {
        return ontPricingQtySource;
    }

    public void setOntPricingQtySource(String ontPricingQtySource) {
        this.ontPricingQtySource = ontPricingQtySource;
    }

    public String getSecondaryDefaultInd() {
        return secondaryDefaultInd;
    }

    public void setSecondaryDefaultInd(String secondaryDefaultInd) {
        this.secondaryDefaultInd = secondaryDefaultInd;
    }

    public BigDecimal getOptionSpecificSourced() {
        return optionSpecificSourced;
    }

    public void setOptionSpecificSourced(BigDecimal optionSpecificSourced) {
        this.optionSpecificSourced = optionSpecificSourced;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public BigDecimal getVmiMinimumUnits() {
        return vmiMinimumUnits;
    }

    public void setVmiMinimumUnits(BigDecimal vmiMinimumUnits) {
        this.vmiMinimumUnits = vmiMinimumUnits;
    }

    public BigDecimal getVmiMinimumDays() {
        return vmiMinimumDays;
    }

    public void setVmiMinimumDays(BigDecimal vmiMinimumDays) {
        this.vmiMinimumDays = vmiMinimumDays;
    }

    public BigDecimal getVmiMaximumUnits() {
        return vmiMaximumUnits;
    }

    public void setVmiMaximumUnits(BigDecimal vmiMaximumUnits) {
        this.vmiMaximumUnits = vmiMaximumUnits;
    }

    public BigDecimal getVmiMaximumDays() {
        return vmiMaximumDays;
    }

    public void setVmiMaximumDays(BigDecimal vmiMaximumDays) {
        this.vmiMaximumDays = vmiMaximumDays;
    }

    public BigDecimal getVmiFixedOrderQuantity() {
        return vmiFixedOrderQuantity;
    }

    public void setVmiFixedOrderQuantity(BigDecimal vmiFixedOrderQuantity) {
        this.vmiFixedOrderQuantity = vmiFixedOrderQuantity;
    }

    public BigDecimal getSoAuthorizationFlag() {
        return soAuthorizationFlag;
    }

    public void setSoAuthorizationFlag(BigDecimal soAuthorizationFlag) {
        this.soAuthorizationFlag = soAuthorizationFlag;
    }

    public BigDecimal getConsignedFlag() {
        return consignedFlag;
    }

    public void setConsignedFlag(BigDecimal consignedFlag) {
        this.consignedFlag = consignedFlag;
    }

    public BigDecimal getAsnAutoexpireFlag() {
        return asnAutoexpireFlag;
    }

    public void setAsnAutoexpireFlag(BigDecimal asnAutoexpireFlag) {
        this.asnAutoexpireFlag = asnAutoexpireFlag;
    }

    public BigDecimal getVmiForecastType() {
        return vmiForecastType;
    }

    public void setVmiForecastType(BigDecimal vmiForecastType) {
        this.vmiForecastType = vmiForecastType;
    }

    public BigDecimal getForecastHorizon() {
        return forecastHorizon;
    }

    public void setForecastHorizon(BigDecimal forecastHorizon) {
        this.forecastHorizon = forecastHorizon;
    }

    public BigDecimal getExcludeFromBudgetFlag() {
        return excludeFromBudgetFlag;
    }

    public void setExcludeFromBudgetFlag(BigDecimal excludeFromBudgetFlag) {
        this.excludeFromBudgetFlag = excludeFromBudgetFlag;
    }

    public BigDecimal getDaysTgtInvSupply() {
        return daysTgtInvSupply;
    }

    public void setDaysTgtInvSupply(BigDecimal daysTgtInvSupply) {
        this.daysTgtInvSupply = daysTgtInvSupply;
    }

    public BigDecimal getDaysTgtInvWindow() {
        return daysTgtInvWindow;
    }

    public void setDaysTgtInvWindow(BigDecimal daysTgtInvWindow) {
        this.daysTgtInvWindow = daysTgtInvWindow;
    }

    public BigDecimal getDaysMaxInvSupply() {
        return daysMaxInvSupply;
    }

    public void setDaysMaxInvSupply(BigDecimal daysMaxInvSupply) {
        this.daysMaxInvSupply = daysMaxInvSupply;
    }

    public BigDecimal getDaysMaxInvWindow() {
        return daysMaxInvWindow;
    }

    public void setDaysMaxInvWindow(BigDecimal daysMaxInvWindow) {
        this.daysMaxInvWindow = daysMaxInvWindow;
    }

    public BigDecimal getDrpPlannedFlag() {
        return drpPlannedFlag;
    }

    public void setDrpPlannedFlag(BigDecimal drpPlannedFlag) {
        this.drpPlannedFlag = drpPlannedFlag;
    }

    public BigDecimal getCriticalComponentFlag() {
        return criticalComponentFlag;
    }

    public void setCriticalComponentFlag(BigDecimal criticalComponentFlag) {
        this.criticalComponentFlag = criticalComponentFlag;
    }

    public BigDecimal getContinousTransfer() {
        return continousTransfer;
    }

    public void setContinousTransfer(BigDecimal continousTransfer) {
        this.continousTransfer = continousTransfer;
    }

    public BigDecimal getConvergence() {
        return convergence;
    }

    public void setConvergence(BigDecimal convergence) {
        this.convergence = convergence;
    }

    public BigDecimal getDivergence() {
        return divergence;
    }

    public void setDivergence(BigDecimal divergence) {
        this.divergence = divergence;
    }

    public String getConfigOrgs() {
        return configOrgs;
    }

    public void setConfigOrgs(String configOrgs) {
        this.configOrgs = configOrgs;
    }

    public String getConfigMatch() {
        return configMatch;
    }

    public void setConfigMatch(String configMatch) {
        this.configMatch = configMatch;
    }

    public String getCasNumber() {
        return casNumber;
    }

    public void setCasNumber(String casNumber) {
        this.casNumber = casNumber;
    }

    public String getChildLotFlag() {
        return childLotFlag;
    }

    public void setChildLotFlag(String childLotFlag) {
        this.childLotFlag = childLotFlag;
    }

    public String getChildLotPrefix() {
        return childLotPrefix;
    }

    public void setChildLotPrefix(String childLotPrefix) {
        this.childLotPrefix = childLotPrefix;
    }

    public BigDecimal getChildLotStartingNumber() {
        return childLotStartingNumber;
    }

    public void setChildLotStartingNumber(BigDecimal childLotStartingNumber) {
        this.childLotStartingNumber = childLotStartingNumber;
    }

    public String getChildLotValidationFlag() {
        return childLotValidationFlag;
    }

    public void setChildLotValidationFlag(String childLotValidationFlag) {
        this.childLotValidationFlag = childLotValidationFlag;
    }

    public String getCopyLotAttributeFlag() {
        return copyLotAttributeFlag;
    }

    public void setCopyLotAttributeFlag(String copyLotAttributeFlag) {
        this.copyLotAttributeFlag = copyLotAttributeFlag;
    }

    public String getDefaultGrade() {
        return defaultGrade;
    }

    public void setDefaultGrade(String defaultGrade) {
        this.defaultGrade = defaultGrade;
    }

    public String getExpirationActionCode() {
        return expirationActionCode;
    }

    public void setExpirationActionCode(String expirationActionCode) {
        this.expirationActionCode = expirationActionCode;
    }

    public BigDecimal getExpirationActionInterval() {
        return expirationActionInterval;
    }

    public void setExpirationActionInterval(BigDecimal expirationActionInterval) {
        this.expirationActionInterval = expirationActionInterval;
    }

    public String getGradeControlFlag() {
        return gradeControlFlag;
    }

    public void setGradeControlFlag(String gradeControlFlag) {
        this.gradeControlFlag = gradeControlFlag;
    }

    public String getHazardousMaterialFlag() {
        return hazardousMaterialFlag;
    }

    public void setHazardousMaterialFlag(String hazardousMaterialFlag) {
        this.hazardousMaterialFlag = hazardousMaterialFlag;
    }

    public BigDecimal getHoldDays() {
        return holdDays;
    }

    public void setHoldDays(BigDecimal holdDays) {
        this.holdDays = holdDays;
    }

    public String getLotDivisibleFlag() {
        return lotDivisibleFlag;
    }

    public void setLotDivisibleFlag(String lotDivisibleFlag) {
        this.lotDivisibleFlag = lotDivisibleFlag;
    }

    public BigDecimal getMaturityDays() {
        return maturityDays;
    }

    public void setMaturityDays(BigDecimal maturityDays) {
        this.maturityDays = maturityDays;
    }

    public String getParentChildGenerationFlag() {
        return parentChildGenerationFlag;
    }

    public void setParentChildGenerationFlag(String parentChildGenerationFlag) {
        this.parentChildGenerationFlag = parentChildGenerationFlag;
    }

    public String getProcessCostingEnabledFlag() {
        return processCostingEnabledFlag;
    }

    public void setProcessCostingEnabledFlag(String processCostingEnabledFlag) {
        this.processCostingEnabledFlag = processCostingEnabledFlag;
    }

    public String getProcessExecutionEnabledFlag() {
        return processExecutionEnabledFlag;
    }

    public void setProcessExecutionEnabledFlag(String processExecutionEnabledFlag) {
        this.processExecutionEnabledFlag = processExecutionEnabledFlag;
    }

    public String getProcessQualityEnabledFlag() {
        return processQualityEnabledFlag;
    }

    public void setProcessQualityEnabledFlag(String processQualityEnabledFlag) {
        this.processQualityEnabledFlag = processQualityEnabledFlag;
    }

    public Long getProcessSupplyLocatorId() {
        return processSupplyLocatorId;
    }

    public void setProcessSupplyLocatorId(Long processSupplyLocatorId) {
        this.processSupplyLocatorId = processSupplyLocatorId;
    }

    public String getProcessSupplySubinventory() {
        return processSupplySubinventory;
    }

    public void setProcessSupplySubinventory(String processSupplySubinventory) {
        this.processSupplySubinventory = processSupplySubinventory;
    }

    public Long getProcessYieldLocatorId() {
        return processYieldLocatorId;
    }

    public void setProcessYieldLocatorId(Long processYieldLocatorId) {
        this.processYieldLocatorId = processYieldLocatorId;
    }

    public String getProcessYieldSubinventory() {
        return processYieldSubinventory;
    }

    public void setProcessYieldSubinventory(String processYieldSubinventory) {
        this.processYieldSubinventory = processYieldSubinventory;
    }

    public String getRecipeEnabledFlag() {
        return recipeEnabledFlag;
    }

    public void setRecipeEnabledFlag(String recipeEnabledFlag) {
        this.recipeEnabledFlag = recipeEnabledFlag;
    }

    public BigDecimal getRetestInterval() {
        return retestInterval;
    }

    public void setRetestInterval(BigDecimal retestInterval) {
        this.retestInterval = retestInterval;
    }

    public String getChargePeriodicityCode() {
        return chargePeriodicityCode;
    }

    public void setChargePeriodicityCode(String chargePeriodicityCode) {
        this.chargePeriodicityCode = chargePeriodicityCode;
    }

    public BigDecimal getRepairLeadtime() {
        return repairLeadtime;
    }

    public void setRepairLeadtime(BigDecimal repairLeadtime) {
        this.repairLeadtime = repairLeadtime;
    }

    public BigDecimal getRepairYield() {
        return repairYield;
    }

    public void setRepairYield(BigDecimal repairYield) {
        this.repairYield = repairYield;
    }

    public String getPrepositionPoint() {
        return prepositionPoint;
    }

    public void setPrepositionPoint(String prepositionPoint) {
        this.prepositionPoint = prepositionPoint;
    }

    public BigDecimal getRepairProgram() {
        return repairProgram;
    }

    public void setRepairProgram(BigDecimal repairProgram) {
        this.repairProgram = repairProgram;
    }

    public BigDecimal getSubcontractingComponent() {
        return subcontractingComponent;
    }

    public void setSubcontractingComponent(BigDecimal subcontractingComponent) {
        this.subcontractingComponent = subcontractingComponent;
    }

    public BigDecimal getOutsourcedAssembly() {
        return outsourcedAssembly;
    }

    public void setOutsourcedAssembly(BigDecimal outsourcedAssembly) {
        this.outsourcedAssembly = outsourcedAssembly;
    }

    public String getEgoMasterItemsDffCtx() {
        return egoMasterItemsDffCtx;
    }

    public void setEgoMasterItemsDffCtx(String egoMasterItemsDffCtx) {
        this.egoMasterItemsDffCtx = egoMasterItemsDffCtx;
    }

    public String getGdsnOutboundEnabledFlag() {
        return gdsnOutboundEnabledFlag;
    }

    public void setGdsnOutboundEnabledFlag(String gdsnOutboundEnabledFlag) {
        this.gdsnOutboundEnabledFlag = gdsnOutboundEnabledFlag;
    }

    public String getTradeItemDescriptor() {
        return tradeItemDescriptor;
    }

    public void setTradeItemDescriptor(String tradeItemDescriptor) {
        this.tradeItemDescriptor = tradeItemDescriptor;
    }

    public String getAssetTrackedFlag() {
        return assetTrackedFlag;
    }

    public void setAssetTrackedFlag(String assetTrackedFlag) {
        this.assetTrackedFlag = assetTrackedFlag;
    }

    public String getAssetClass() {
        return assetClass;
    }

    public void setAssetClass(String assetClass) {
        this.assetClass = assetClass;
    }

    public String getServiceDurationTypeCode() {
        return serviceDurationTypeCode;
    }

    public void setServiceDurationTypeCode(String serviceDurationTypeCode) {
        this.serviceDurationTypeCode = serviceDurationTypeCode;
    }

    public String getServiceStartTypeCode() {
        return serviceStartTypeCode;
    }

    public void setServiceStartTypeCode(String serviceStartTypeCode) {
        this.serviceStartTypeCode = serviceStartTypeCode;
    }

    public String getStartUponMilestoneCode() {
        return startUponMilestoneCode;
    }

    public void setStartUponMilestoneCode(String startUponMilestoneCode) {
        this.startUponMilestoneCode = startUponMilestoneCode;
    }

    public BigDecimal getServiceStartDelay() {
        return serviceStartDelay;
    }

    public void setServiceStartDelay(BigDecimal serviceStartDelay) {
        this.serviceStartDelay = serviceStartDelay;
    }

    public String getAllowSuspendFlag() {
        return allowSuspendFlag;
    }

    public void setAllowSuspendFlag(String allowSuspendFlag) {
        this.allowSuspendFlag = allowSuspendFlag;
    }

    public String getAllowTerminateFlag() {
        return allowTerminateFlag;
    }

    public void setAllowTerminateFlag(String allowTerminateFlag) {
        this.allowTerminateFlag = allowTerminateFlag;
    }

    public String getRequiresFulfillmentLocFlag() {
        return requiresFulfillmentLocFlag;
    }

    public void setRequiresFulfillmentLocFlag(String requiresFulfillmentLocFlag) {
        this.requiresFulfillmentLocFlag = requiresFulfillmentLocFlag;
    }

    public String getRequiresItmAssociationFlag() {
        return requiresItmAssociationFlag;
    }

    public void setRequiresItmAssociationFlag(String requiresItmAssociationFlag) {
        this.requiresItmAssociationFlag = requiresItmAssociationFlag;
    }

    public Long getStyleItemId() {
        return styleItemId;
    }

    public void setStyleItemId(Long styleItemId) {
        this.styleItemId = styleItemId;
    }

    public String getStyleItemFlag() {
        return styleItemFlag;
    }

    public void setStyleItemFlag(String styleItemFlag) {
        this.styleItemFlag = styleItemFlag;
    }

    public Long getLastSubmittedNirId() {
        return lastSubmittedNirId;
    }

    public void setLastSubmittedNirId(Long lastSubmittedNirId) {
        this.lastSubmittedNirId = lastSubmittedNirId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramAppName() {
        return programAppName;
    }

    public void setProgramAppName(String programAppName) {
        this.programAppName = programAppName;
    }

    public String getEligibilityCompatibilityRule() {
        return eligibilityCompatibilityRule;
    }

    public void setEligibilityCompatibilityRule(String eligibilityCompatibilityRule) {
        this.eligibilityCompatibilityRule = eligibilityCompatibilityRule;
    }

    public String getJobDefinitionName() {
        return jobDefinitionName;
    }

    public void setJobDefinitionName(String jobDefinitionName) {
        this.jobDefinitionName = jobDefinitionName;
    }

    public String getJobDefinitionPackage() {
        return jobDefinitionPackage;
    }

    public void setJobDefinitionPackage(String jobDefinitionPackage) {
        this.jobDefinitionPackage = jobDefinitionPackage;
    }

    public String getAcdType() {
        return acdType;
    }

    public void setAcdType(String acdType) {
        this.acdType = acdType;
    }

    public String getChangeLineId() {
        return changeLineId;
    }

    public void setChangeLineId(String changeLineId) {
        this.changeLineId = changeLineId;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public Long getMasterItemVersionId() {
        return masterItemVersionId;
    }

    public void setMasterItemVersionId(Long masterItemVersionId) {
        this.masterItemVersionId = masterItemVersionId;
    }

    public Date getVersionStartDate() {
        return versionStartDate;
    }

    public void setVersionStartDate(Date versionStartDate) {
        this.versionStartDate = versionStartDate;
    }

    public Date getVersionEndDate() {
        return versionEndDate;
    }

    public void setVersionEndDate(Date versionEndDate) {
        this.versionEndDate = versionEndDate;
    }

    public Date getImplementationDate() {
        return implementationDate;
    }

    public void setImplementationDate(Date implementationDate) {
        this.implementationDate = implementationDate;
    }

    public String getTemplateItemFlag() {
        return templateItemFlag;
    }

    public void setTemplateItemFlag(String templateItemFlag) {
        this.templateItemFlag = templateItemFlag;
    }

    public String getQscSalesProductType() {
        return qscSalesProductType;
    }

    public void setQscSalesProductType(String qscSalesProductType) {
        this.qscSalesProductType = qscSalesProductType;
    }

    public Integer getMatchApprovalLevel() {
        return matchApprovalLevel;
    }

    public void setMatchApprovalLevel(Integer matchApprovalLevel) {
        this.matchApprovalLevel = matchApprovalLevel;
    }

    public Integer getInvoiceMatchOption() {
        return invoiceMatchOption;
    }

    public void setInvoiceMatchOption(Integer invoiceMatchOption) {
        this.invoiceMatchOption = invoiceMatchOption;
    }

    public String getDefaultTemplateFlag() {
        return defaultTemplateFlag;
    }

    public void setDefaultTemplateFlag(String defaultTemplateFlag) {
        this.defaultTemplateFlag = defaultTemplateFlag;
    }

    public String getInspectionRequiredFlag() {
        return inspectionRequiredFlag;
    }

    public void setInspectionRequiredFlag(String inspectionRequiredFlag) {
        this.inspectionRequiredFlag = inspectionRequiredFlag;
    }

    public String getReceiptRequiredFlag() {
        return receiptRequiredFlag;
    }

    public void setReceiptRequiredFlag(String receiptRequiredFlag) {
        this.receiptRequiredFlag = receiptRequiredFlag;
    }

    public Long getAssetCategoryId() {
        return assetCategoryId;
    }

    public void setAssetCategoryId(Long assetCategoryId) {
        this.assetCategoryId = assetCategoryId;
    }

    public Long getExpenseAccount() {
        return expenseAccount;
    }

    public void setExpenseAccount(Long expenseAccount) {
        this.expenseAccount = expenseAccount;
    }

    public Long getSalesAccount() {
        return salesAccount;
    }

    public void setSalesAccount(Long salesAccount) {
        this.salesAccount = salesAccount;
    }

    public String getSalesProductType() {
        return salesProductType;
    }

    public void setSalesProductType(String salesProductType) {
        this.salesProductType = salesProductType;
    }

    public String getSalesProductSubType() {
        return salesProductSubType;
    }

    public void setSalesProductSubType(String salesProductSubType) {
        this.salesProductSubType = salesProductSubType;
    }

    public String getAltItemCode() {
        return altItemCode;
    }

    public void setAltItemCode(String altItemCode) {
        this.altItemCode = altItemCode;
    }

    public String getChangeBitMap() {
        return changeBitMap;
    }

    public void setChangeBitMap(String changeBitMap) {
        this.changeBitMap = changeBitMap;
    }

    public String getCurrentPhaseCode() {
        return currentPhaseCode;
    }

    public void setCurrentPhaseCode(String currentPhaseCode) {
        this.currentPhaseCode = currentPhaseCode;
    }

    public Long getInventoryOrganizationId() {
        return inventoryOrganizationId;
    }

    public void setInventoryOrganizationId(Long inventoryOrganizationId) {
        this.inventoryOrganizationId = inventoryOrganizationId;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getDqSemanticKey() {
        return dqSemanticKey;
    }

    public void setDqSemanticKey(String dqSemanticKey) {
        this.dqSemanticKey = dqSemanticKey;
    }

    public String getDqRequiredFlag() {
        return dqRequiredFlag;
    }

    public void setDqRequiredFlag(String dqRequiredFlag) {
        this.dqRequiredFlag = dqRequiredFlag;
    }

    public Long getThreadId() {
        return threadId;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }

    public BigDecimal getAttributeNumber1() {
        return attributeNumber1;
    }

    public void setAttributeNumber1(BigDecimal attributeNumber1) {
        this.attributeNumber1 = attributeNumber1;
    }

    public BigDecimal getAttributeNumber2() {
        return attributeNumber2;
    }

    public void setAttributeNumber2(BigDecimal attributeNumber2) {
        this.attributeNumber2 = attributeNumber2;
    }

    public BigDecimal getAttributeNumber3() {
        return attributeNumber3;
    }

    public void setAttributeNumber3(BigDecimal attributeNumber3) {
        this.attributeNumber3 = attributeNumber3;
    }

    public BigDecimal getAttributeNumber4() {
        return attributeNumber4;
    }

    public void setAttributeNumber4(BigDecimal attributeNumber4) {
        this.attributeNumber4 = attributeNumber4;
    }

    public BigDecimal getAttributeNumber5() {
        return attributeNumber5;
    }

    public void setAttributeNumber5(BigDecimal attributeNumber5) {
        this.attributeNumber5 = attributeNumber5;
    }

    public BigDecimal getAttributeNumber6() {
        return attributeNumber6;
    }

    public void setAttributeNumber6(BigDecimal attributeNumber6) {
        this.attributeNumber6 = attributeNumber6;
    }

    public BigDecimal getAttributeNumber7() {
        return attributeNumber7;
    }

    public void setAttributeNumber7(BigDecimal attributeNumber7) {
        this.attributeNumber7 = attributeNumber7;
    }

    public BigDecimal getAttributeNumber8() {
        return attributeNumber8;
    }

    public void setAttributeNumber8(BigDecimal attributeNumber8) {
        this.attributeNumber8 = attributeNumber8;
    }

    public BigDecimal getAttributeNumber9() {
        return attributeNumber9;
    }

    public void setAttributeNumber9(BigDecimal attributeNumber9) {
        this.attributeNumber9 = attributeNumber9;
    }

    public BigDecimal getAttributeNumber10() {
        return attributeNumber10;
    }

    public void setAttributeNumber10(BigDecimal attributeNumber10) {
        this.attributeNumber10 = attributeNumber10;
    }

    public Date getAttributeDate1() {
        return attributeDate1;
    }

    public void setAttributeDate1(Date attributeDate1) {
        this.attributeDate1 = attributeDate1;
    }

    public Date getAttributeDate2() {
        return attributeDate2;
    }

    public void setAttributeDate2(Date attributeDate2) {
        this.attributeDate2 = attributeDate2;
    }

    public Date getAttributeDate3() {
        return attributeDate3;
    }

    public void setAttributeDate3(Date attributeDate3) {
        this.attributeDate3 = attributeDate3;
    }

    public Date getAttributeDate4() {
        return attributeDate4;
    }

    public void setAttributeDate4(Date attributeDate4) {
        this.attributeDate4 = attributeDate4;
    }

    public Date getAttributeDate5() {
        return attributeDate5;
    }

    public void setAttributeDate5(Date attributeDate5) {
        this.attributeDate5 = attributeDate5;
    }

    public Date getAttributeTimestamp1() {
        return attributeTimestamp1;
    }

    public void setAttributeTimestamp1(Date attributeTimestamp1) {
        this.attributeTimestamp1 = attributeTimestamp1;
    }

    public Date getAttributeTimestamp2() {
        return attributeTimestamp2;
    }

    public void setAttributeTimestamp2(Date attributeTimestamp2) {
        this.attributeTimestamp2 = attributeTimestamp2;
    }

    public Date getAttributeTimestamp3() {
        return attributeTimestamp3;
    }

    public void setAttributeTimestamp3(Date attributeTimestamp3) {
        this.attributeTimestamp3 = attributeTimestamp3;
    }

    public Date getAttributeTimestamp4() {
        return attributeTimestamp4;
    }

    public void setAttributeTimestamp4(Date attributeTimestamp4) {
        this.attributeTimestamp4 = attributeTimestamp4;
    }

    public Date getAttributeTimestamp5() {
        return attributeTimestamp5;
    }

    public void setAttributeTimestamp5(Date attributeTimestamp5) {
        this.attributeTimestamp5 = attributeTimestamp5;
    }

    public String getBackToBackEnabled() {
        return backToBackEnabled;
    }

    public void setBackToBackEnabled(String backToBackEnabled) {
        this.backToBackEnabled = backToBackEnabled;
    }

    public String getContractManufacturing() {
        return contractManufacturing;
    }

    public void setContractManufacturing(String contractManufacturing) {
        this.contractManufacturing = contractManufacturing;
    }

    public String getSafetyStockPlanningMethod() {
        return safetyStockPlanningMethod;
    }

    public void setSafetyStockPlanningMethod(String safetyStockPlanningMethod) {
        this.safetyStockPlanningMethod = safetyStockPlanningMethod;
    }

    public BigDecimal getDemandPeriod() {
        return demandPeriod;
    }

    public void setDemandPeriod(BigDecimal demandPeriod) {
        this.demandPeriod = demandPeriod;
    }

    public BigDecimal getDaysOfCover() {
        return daysOfCover;
    }

    public void setDaysOfCover(BigDecimal daysOfCover) {
        this.daysOfCover = daysOfCover;
    }

    public Long getMasterOrgId() {
        return masterOrgId;
    }

    public void setMasterOrgId(Long masterOrgId) {
        this.masterOrgId = masterOrgId;
    }

    public String getOutsideProcessServiceFlag() {
        return outsideProcessServiceFlag;
    }

    public void setOutsideProcessServiceFlag(String outsideProcessServiceFlag) {
        this.outsideProcessServiceFlag = outsideProcessServiceFlag;
    }

    public String getAllowMaintenanceAssetFlag() {
        return allowMaintenanceAssetFlag;
    }

    public void setAllowMaintenanceAssetFlag(String allowMaintenanceAssetFlag) {
        this.allowMaintenanceAssetFlag = allowMaintenanceAssetFlag;
    }

    public String getEnableGenealogyTrackingFlag() {
        return enableGenealogyTrackingFlag;
    }

    public void setEnableGenealogyTrackingFlag(String enableGenealogyTrackingFlag) {
        this.enableGenealogyTrackingFlag = enableGenealogyTrackingFlag;
    }

    public Integer getCompletenessScore() {
        return completenessScore;
    }

    public void setCompletenessScore(Integer completenessScore) {
        this.completenessScore = completenessScore;
    }

    public String getCssEnabledFlag() {
        return cssEnabledFlag;
    }

    public void setCssEnabledFlag(String cssEnabledFlag) {
        this.cssEnabledFlag = cssEnabledFlag;
    }

    public String getEngineeredItemFlag() {
        return engineeredItemFlag;
    }

    public void setEngineeredItemFlag(String engineeredItemFlag) {
        this.engineeredItemFlag = engineeredItemFlag;
    }

    public String getForcePurchaseLeadTimeFlag() {
        return forcePurchaseLeadTimeFlag;
    }

    public void setForcePurchaseLeadTimeFlag(String forcePurchaseLeadTimeFlag) {
        this.forcePurchaseLeadTimeFlag = forcePurchaseLeadTimeFlag;
    }

    public String getReplacementType() {
        return replacementType;
    }

    public void setReplacementType(String replacementType) {
        this.replacementType = replacementType;
    }

    public String getHardPeggingLevel() {
        return hardPeggingLevel;
    }

    public void setHardPeggingLevel(String hardPeggingLevel) {
        this.hardPeggingLevel = hardPeggingLevel;
    }

    public String getComnSupplyPrjDemandFlag() {
        return comnSupplyPrjDemandFlag;
    }

    public void setComnSupplyPrjDemandFlag(String comnSupplyPrjDemandFlag) {
        this.comnSupplyPrjDemandFlag = comnSupplyPrjDemandFlag;
    }

    public String getEnableIotFlag() {
        return enableIotFlag;
    }

    public void setEnableIotFlag(String enableIotFlag) {
        this.enableIotFlag = enableIotFlag;
    }

    public Long getExpenditureTypeId() {
        return expenditureTypeId;
    }

    public void setExpenditureTypeId(Long expenditureTypeId) {
        this.expenditureTypeId = expenditureTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
