
package sinexcel.wsc.soap.ess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>requestDetail complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="requestDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="actualEndTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" form="qualified"/>
 *         &lt;element name="actualStartTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" form="qualified"/>
 *         &lt;element name="cause" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="dispatcherNode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="expirationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" form="qualified"/>
 *         &lt;element name="isCancellable" type="{http://www.w3.org/2001/XMLSchema}boolean" form="qualified"/>
 *         &lt;element name="isHoldable" type="{http://www.w3.org/2001/XMLSchema}boolean" form="qualified"/>
 *         &lt;element name="jobDefinitionId" type="{http://xmlns.oracle.com/scheduler/types}metadataObjectId" minOccurs="0" form="qualified"/>
 *         &lt;element name="parentRequestId" type="{http://www.w3.org/2001/XMLSchema}long" form="qualified"/>
 *         &lt;element name="priority" type="{http://www.w3.org/2001/XMLSchema}int" form="qualified"/>
 *         &lt;element name="processorNode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="requestId" type="{http://www.w3.org/2001/XMLSchema}long" form="qualified"/>
 *         &lt;element name="requestParameters" type="{http://xmlns.oracle.com/scheduler/types}requestParameters" minOccurs="0" form="qualified"/>
 *         &lt;element name="requestedEndTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" form="qualified"/>
 *         &lt;element name="requestedStartTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" form="qualified"/>
 *         &lt;element name="retried" type="{http://www.w3.org/2001/XMLSchema}int" form="qualified"/>
 *         &lt;element name="scheduleId" type="{http://xmlns.oracle.com/scheduler/types}metadataObjectId" minOccurs="0" form="qualified"/>
 *         &lt;element name="scheduledTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" form="qualified"/>
 *         &lt;element name="state" type="{http://xmlns.oracle.com/scheduler/types}state" minOccurs="0" form="qualified"/>
 *         &lt;element name="errorType" type="{http://xmlns.oracle.com/scheduler/types}errorType" minOccurs="0" form="qualified"/>
 *         &lt;element name="stepId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="submissionTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" form="qualified"/>
 *         &lt;element name="submitter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="runAsUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="triggerId" type="{http://xmlns.oracle.com/scheduler/types}metadataObjectId" minOccurs="0" form="qualified"/>
 *         &lt;element name="workAssignmentId" type="{http://xmlns.oracle.com/scheduler/types}metadataObjectId" minOccurs="0" form="qualified"/>
 *         &lt;element name="workshiftId" type="{http://xmlns.oracle.com/scheduler/types}metadataObjectId" minOccurs="0" form="qualified"/>
 *         &lt;element name="requestType" type="{http://xmlns.oracle.com/scheduler/types}requestType" minOccurs="0" form="qualified"/>
 *         &lt;element name="errorWarningMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="errorWarningTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" form="qualified"/>
 *         &lt;element name="errorWarningDetail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="ecid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="processPhase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestDetail", namespace = "http://xmlns.oracle.com/scheduler/types", propOrder = {
    "actualEndTime",
    "actualStartTime",
    "cause",
    "description",
    "dispatcherNode",
    "expirationTime",
    "isCancellable",
    "isHoldable",
    "jobDefinitionId",
    "parentRequestId",
    "priority",
    "processorNode",
    "requestId",
    "requestParameters",
    "requestedEndTime",
    "requestedStartTime",
    "retried",
    "scheduleId",
    "scheduledTime",
    "state",
    "errorType",
    "stepId",
    "submissionTime",
    "submitter",
    "runAsUser",
    "triggerId",
    "workAssignmentId",
    "workshiftId",
    "requestType",
    "errorWarningMessage",
    "errorWarningTime",
    "errorWarningDetail",
    "ecid",
    "processPhase"
})
public class RequestDetail {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar actualEndTime;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar actualStartTime;
    protected String cause;
    protected String description;
    protected String dispatcherNode;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationTime;
    protected boolean isCancellable;
    protected boolean isHoldable;
    protected MetadataObjectId jobDefinitionId;
    protected long parentRequestId;
    protected int priority;
    protected String processorNode;
    protected long requestId;
    protected RequestParameters requestParameters;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar requestedEndTime;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar requestedStartTime;
    protected int retried;
    protected MetadataObjectId scheduleId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar scheduledTime;
    @XmlSchemaType(name = "string")
    protected State state;
    @XmlSchemaType(name = "string")
    protected ErrorType errorType;
    protected String stepId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar submissionTime;
    protected String submitter;
    protected String runAsUser;
    protected MetadataObjectId triggerId;
    protected MetadataObjectId workAssignmentId;
    protected MetadataObjectId workshiftId;
    @XmlSchemaType(name = "string")
    protected RequestType requestType;
    protected String errorWarningMessage;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar errorWarningTime;
    protected String errorWarningDetail;
    protected String ecid;
    protected String processPhase;

    /**
     * 获取actualEndTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActualEndTime() {
        return actualEndTime;
    }

    /**
     * 设置actualEndTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActualEndTime(XMLGregorianCalendar value) {
        this.actualEndTime = value;
    }

    /**
     * 获取actualStartTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActualStartTime() {
        return actualStartTime;
    }

    /**
     * 设置actualStartTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActualStartTime(XMLGregorianCalendar value) {
        this.actualStartTime = value;
    }

    /**
     * 获取cause属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCause() {
        return cause;
    }

    /**
     * 设置cause属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCause(String value) {
        this.cause = value;
    }

    /**
     * 获取description属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置description属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * 获取dispatcherNode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDispatcherNode() {
        return dispatcherNode;
    }

    /**
     * 设置dispatcherNode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDispatcherNode(String value) {
        this.dispatcherNode = value;
    }

    /**
     * 获取expirationTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpirationTime() {
        return expirationTime;
    }

    /**
     * 设置expirationTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpirationTime(XMLGregorianCalendar value) {
        this.expirationTime = value;
    }

    /**
     * 获取isCancellable属性的值。
     * 
     */
    public boolean isIsCancellable() {
        return isCancellable;
    }

    /**
     * 设置isCancellable属性的值。
     * 
     */
    public void setIsCancellable(boolean value) {
        this.isCancellable = value;
    }

    /**
     * 获取isHoldable属性的值。
     * 
     */
    public boolean isIsHoldable() {
        return isHoldable;
    }

    /**
     * 设置isHoldable属性的值。
     * 
     */
    public void setIsHoldable(boolean value) {
        this.isHoldable = value;
    }

    /**
     * 获取jobDefinitionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MetadataObjectId }
     *     
     */
    public MetadataObjectId getJobDefinitionId() {
        return jobDefinitionId;
    }

    /**
     * 设置jobDefinitionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MetadataObjectId }
     *     
     */
    public void setJobDefinitionId(MetadataObjectId value) {
        this.jobDefinitionId = value;
    }

    /**
     * 获取parentRequestId属性的值。
     * 
     */
    public long getParentRequestId() {
        return parentRequestId;
    }

    /**
     * 设置parentRequestId属性的值。
     * 
     */
    public void setParentRequestId(long value) {
        this.parentRequestId = value;
    }

    /**
     * 获取priority属性的值。
     * 
     */
    public int getPriority() {
        return priority;
    }

    /**
     * 设置priority属性的值。
     * 
     */
    public void setPriority(int value) {
        this.priority = value;
    }

    /**
     * 获取processorNode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessorNode() {
        return processorNode;
    }

    /**
     * 设置processorNode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessorNode(String value) {
        this.processorNode = value;
    }

    /**
     * 获取requestId属性的值。
     * 
     */
    public long getRequestId() {
        return requestId;
    }

    /**
     * 设置requestId属性的值。
     * 
     */
    public void setRequestId(long value) {
        this.requestId = value;
    }

    /**
     * 获取requestParameters属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RequestParameters }
     *     
     */
    public RequestParameters getRequestParameters() {
        return requestParameters;
    }

    /**
     * 设置requestParameters属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RequestParameters }
     *     
     */
    public void setRequestParameters(RequestParameters value) {
        this.requestParameters = value;
    }

    /**
     * 获取requestedEndTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRequestedEndTime() {
        return requestedEndTime;
    }

    /**
     * 设置requestedEndTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRequestedEndTime(XMLGregorianCalendar value) {
        this.requestedEndTime = value;
    }

    /**
     * 获取requestedStartTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRequestedStartTime() {
        return requestedStartTime;
    }

    /**
     * 设置requestedStartTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRequestedStartTime(XMLGregorianCalendar value) {
        this.requestedStartTime = value;
    }

    /**
     * 获取retried属性的值。
     * 
     */
    public int getRetried() {
        return retried;
    }

    /**
     * 设置retried属性的值。
     * 
     */
    public void setRetried(int value) {
        this.retried = value;
    }

    /**
     * 获取scheduleId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MetadataObjectId }
     *     
     */
    public MetadataObjectId getScheduleId() {
        return scheduleId;
    }

    /**
     * 设置scheduleId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MetadataObjectId }
     *     
     */
    public void setScheduleId(MetadataObjectId value) {
        this.scheduleId = value;
    }

    /**
     * 获取scheduledTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getScheduledTime() {
        return scheduledTime;
    }

    /**
     * 设置scheduledTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setScheduledTime(XMLGregorianCalendar value) {
        this.scheduledTime = value;
    }

    /**
     * 获取state属性的值。
     * 
     * @return
     *     possible object is
     *     {@link State }
     *     
     */
    public State getState() {
        return state;
    }

    /**
     * 设置state属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link State }
     *     
     */
    public void setState(State value) {
        this.state = value;
    }

    /**
     * 获取errorType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ErrorType }
     *     
     */
    public ErrorType getErrorType() {
        return errorType;
    }

    /**
     * 设置errorType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorType }
     *     
     */
    public void setErrorType(ErrorType value) {
        this.errorType = value;
    }

    /**
     * 获取stepId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStepId() {
        return stepId;
    }

    /**
     * 设置stepId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStepId(String value) {
        this.stepId = value;
    }

    /**
     * 获取submissionTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSubmissionTime() {
        return submissionTime;
    }

    /**
     * 设置submissionTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSubmissionTime(XMLGregorianCalendar value) {
        this.submissionTime = value;
    }

    /**
     * 获取submitter属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmitter() {
        return submitter;
    }

    /**
     * 设置submitter属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmitter(String value) {
        this.submitter = value;
    }

    /**
     * 获取runAsUser属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRunAsUser() {
        return runAsUser;
    }

    /**
     * 设置runAsUser属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRunAsUser(String value) {
        this.runAsUser = value;
    }

    /**
     * 获取triggerId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MetadataObjectId }
     *     
     */
    public MetadataObjectId getTriggerId() {
        return triggerId;
    }

    /**
     * 设置triggerId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MetadataObjectId }
     *     
     */
    public void setTriggerId(MetadataObjectId value) {
        this.triggerId = value;
    }

    /**
     * 获取workAssignmentId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MetadataObjectId }
     *     
     */
    public MetadataObjectId getWorkAssignmentId() {
        return workAssignmentId;
    }

    /**
     * 设置workAssignmentId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MetadataObjectId }
     *     
     */
    public void setWorkAssignmentId(MetadataObjectId value) {
        this.workAssignmentId = value;
    }

    /**
     * 获取workshiftId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MetadataObjectId }
     *     
     */
    public MetadataObjectId getWorkshiftId() {
        return workshiftId;
    }

    /**
     * 设置workshiftId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MetadataObjectId }
     *     
     */
    public void setWorkshiftId(MetadataObjectId value) {
        this.workshiftId = value;
    }

    /**
     * 获取requestType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RequestType }
     *     
     */
    public RequestType getRequestType() {
        return requestType;
    }

    /**
     * 设置requestType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RequestType }
     *     
     */
    public void setRequestType(RequestType value) {
        this.requestType = value;
    }

    /**
     * 获取errorWarningMessage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorWarningMessage() {
        return errorWarningMessage;
    }

    /**
     * 设置errorWarningMessage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorWarningMessage(String value) {
        this.errorWarningMessage = value;
    }

    /**
     * 获取errorWarningTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getErrorWarningTime() {
        return errorWarningTime;
    }

    /**
     * 设置errorWarningTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setErrorWarningTime(XMLGregorianCalendar value) {
        this.errorWarningTime = value;
    }

    /**
     * 获取errorWarningDetail属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorWarningDetail() {
        return errorWarningDetail;
    }

    /**
     * 设置errorWarningDetail属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorWarningDetail(String value) {
        this.errorWarningDetail = value;
    }

    /**
     * 获取ecid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEcid() {
        return ecid;
    }

    /**
     * 设置ecid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEcid(String value) {
        this.ecid = value;
    }

    /**
     * 获取processPhase属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessPhase() {
        return processPhase;
    }

    /**
     * 设置processPhase属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessPhase(String value) {
        this.processPhase = value;
    }

}
