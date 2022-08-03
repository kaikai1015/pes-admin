
package sinexcel.wsc.soap.ess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>submitInstantRecurringRequest complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="submitInstantRecurringRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="jobDefinitionId" type="{http://xmlns.oracle.com/scheduler/types}metadataObjectId" form="qualified"/>
 *         &lt;element name="iCalSchedule" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="application" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="requestedStartTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" form="qualified"/>
 *         &lt;element name="requestedEndTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" form="qualified"/>
 *         &lt;element name="requestParameters" type="{http://xmlns.oracle.com/scheduler/types}requestParameters" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "submitInstantRecurringRequest", propOrder = {
    "description",
    "jobDefinitionId",
    "iCalSchedule",
    "application",
    "requestedStartTime",
    "requestedEndTime",
    "requestParameters"
})
public class SubmitInstantRecurringRequest {

    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected MetadataObjectId jobDefinitionId;
    @XmlElement(required = true)
    protected String iCalSchedule;
    @XmlElement(required = true)
    protected String application;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar requestedStartTime;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar requestedEndTime;
    @XmlElement(required = true)
    protected RequestParameters requestParameters;

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
     * ��ȡiCalSchedule���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICalSchedule() {
        return iCalSchedule;
    }

    /**
     * ����iCalSchedule���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICalSchedule(String value) {
        this.iCalSchedule = value;
    }

    /**
     * ��ȡapplication���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplication() {
        return application;
    }

    /**
     * ����application���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplication(String value) {
        this.application = value;
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

}
