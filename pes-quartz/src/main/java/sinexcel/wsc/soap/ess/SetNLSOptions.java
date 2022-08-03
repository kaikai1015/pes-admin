
package sinexcel.wsc.soap.ess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>setNLSOptions complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="setNLSOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestParameters" type="{http://xmlns.oracle.com/scheduler/types}requestParameters" form="qualified"/>
 *         &lt;element name="nlsOptions" type="{http://xmlns.oracle.com/scheduler/types}nlsOptions" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setNLSOptions", propOrder = {
    "requestParameters",
    "nlsOptions"
})
public class SetNLSOptions {

    @XmlElement(required = true)
    protected RequestParameters requestParameters;
    @XmlElement(required = true)
    protected NlsOptions nlsOptions;

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
     * 获取nlsOptions属性的值。
     * 
     * @return
     *     possible object is
     *     {@link NlsOptions }
     *     
     */
    public NlsOptions getNlsOptions() {
        return nlsOptions;
    }

    /**
     * 设置nlsOptions属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link NlsOptions }
     *     
     */
    public void setNlsOptions(NlsOptions value) {
        this.nlsOptions = value;
    }

}
