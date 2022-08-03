
package sinexcel.wsc.soap.ess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>submitRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="submitRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="jobDefinitionId" type="{http://xmlns.oracle.com/scheduler/types}metadataObjectId" form="qualified"/>
 *         &lt;element name="application" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="requestedStartTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" form="qualified"/>
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
@XmlType(name = "submitRequest", propOrder = {
    "description",
    "jobDefinitionId",
    "application",
    "requestedStartTime",
    "requestParameters"
})
public class SubmitRequest {

    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected MetadataObjectId jobDefinitionId;
    @XmlElement(required = true)
    protected String application;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar requestedStartTime;
    @XmlElement(required = true)
    protected RequestParameters requestParameters;

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
     * 获取application属性的值。
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
     * 设置application属性的值。
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

}
