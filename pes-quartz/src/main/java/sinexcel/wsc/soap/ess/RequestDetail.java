
package sinexcel.wsc.soap.ess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>requestDetail complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡactualEndTime���Ե�ֵ��
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
     * ����actualEndTime���Ե�ֵ��
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
     * ��ȡactualStartTime���Ե�ֵ��
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
     * ����actualStartTime���Ե�ֵ��
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
     * ��ȡcause���Ե�ֵ��
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
     * ����cause���Ե�ֵ��
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
     * ��ȡdescription���Ե�ֵ��
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
     * ����description���Ե�ֵ��
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
     * ��ȡdispatcherNode���Ե�ֵ��
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
     * ����dispatcherNode���Ե�ֵ��
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
     * ��ȡexpirationTime���Ե�ֵ��
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
     * ����expirationTime���Ե�ֵ��
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
     * ��ȡisCancellable���Ե�ֵ��
     * 
     */
    public boolean isIsCancellable() {
        return isCancellable;
    }

    /**
     * ����isCancellable���Ե�ֵ��
     * 
     */
    public void setIsCancellable(boolean value) {
        this.isCancellable = value;
    }

    /**
     * ��ȡisHoldable���Ե�ֵ��
     * 
     */
    public boolean isIsHoldable() {
        return isHoldable;
    }

    /**
     * ����isHoldable���Ե�ֵ��
     * 
     */
    public void setIsHoldable(boolean value) {
        this.isHoldable = value;
    }

    /**
     * ��ȡjobDefinitionId���Ե�ֵ��
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
     * ����jobDefinitionId���Ե�ֵ��
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
     * ��ȡparentRequestId���Ե�ֵ��
     * 
     */
    public long getParentRequestId() {
        return parentRequestId;
    }

    /**
     * ����parentRequestId���Ե�ֵ��
     * 
     */
    public void setParentRequestId(long value) {
        this.parentRequestId = value;
    }

    /**
     * ��ȡpriority���Ե�ֵ��
     * 
     */
    public int getPriority() {
        return priority;
    }

    /**
     * ����priority���Ե�ֵ��
     * 
     */
    public void setPriority(int value) {
        this.priority = value;
    }

    /**
     * ��ȡprocessorNode���Ե�ֵ��
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
     * ����processorNode���Ե�ֵ��
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
     * ��ȡrequestId���Ե�ֵ��
     * 
     */
    public long getRequestId() {
        return requestId;
    }

    /**
     * ����requestId���Ե�ֵ��
     * 
     */
    public void setRequestId(long value) {
        this.requestId = value;
    }

    /**
     * ��ȡrequestParameters���Ե�ֵ��
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
     * ����requestParameters���Ե�ֵ��
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
     * ��ȡrequestedEndTime���Ե�ֵ��
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
     * ����requestedEndTime���Ե�ֵ��
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
     * ��ȡrequestedStartTime���Ե�ֵ��
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
     * ����requestedStartTime���Ե�ֵ��
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
     * ��ȡretried���Ե�ֵ��
     * 
     */
    public int getRetried() {
        return retried;
    }

    /**
     * ����retried���Ե�ֵ��
     * 
     */
    public void setRetried(int value) {
        this.retried = value;
    }

    /**
     * ��ȡscheduleId���Ե�ֵ��
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
     * ����scheduleId���Ե�ֵ��
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
     * ��ȡscheduledTime���Ե�ֵ��
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
     * ����scheduledTime���Ե�ֵ��
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
     * ��ȡstate���Ե�ֵ��
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
     * ����state���Ե�ֵ��
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
     * ��ȡerrorType���Ե�ֵ��
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
     * ����errorType���Ե�ֵ��
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
     * ��ȡstepId���Ե�ֵ��
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
     * ����stepId���Ե�ֵ��
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
     * ��ȡsubmissionTime���Ե�ֵ��
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
     * ����submissionTime���Ե�ֵ��
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
     * ��ȡsubmitter���Ե�ֵ��
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
     * ����submitter���Ե�ֵ��
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
     * ��ȡrunAsUser���Ե�ֵ��
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
     * ����runAsUser���Ե�ֵ��
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
     * ��ȡtriggerId���Ե�ֵ��
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
     * ����triggerId���Ե�ֵ��
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
     * ��ȡworkAssignmentId���Ե�ֵ��
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
     * ����workAssignmentId���Ե�ֵ��
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
     * ��ȡworkshiftId���Ե�ֵ��
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
     * ����workshiftId���Ե�ֵ��
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
     * ��ȡrequestType���Ե�ֵ��
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
     * ����requestType���Ե�ֵ��
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
     * ��ȡerrorWarningMessage���Ե�ֵ��
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
     * ����errorWarningMessage���Ե�ֵ��
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
     * ��ȡerrorWarningTime���Ե�ֵ��
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
     * ����errorWarningTime���Ե�ֵ��
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
     * ��ȡerrorWarningDetail���Ե�ֵ��
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
     * ����errorWarningDetail���Ե�ֵ��
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
     * ��ȡecid���Ե�ֵ��
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
     * ����ecid���Ե�ֵ��
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
     * ��ȡprocessPhase���Ե�ֵ��
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
     * ����processPhase���Ե�ֵ��
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
