
package sinexcel.wsc.soap.ess;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>setStepsArgs complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="setStepsArgs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestParameters" type="{http://xmlns.oracle.com/scheduler/types}requestParameters" form="qualified"/>
 *         &lt;element name="stepArgsList" type="{http://xmlns.oracle.com/scheduler/types}stepArgs" maxOccurs="100" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setStepsArgs", propOrder = {
    "requestParameters",
    "stepArgsList"
})
public class SetStepsArgs {

    @XmlElement(required = true)
    protected RequestParameters requestParameters;
    protected List<StepArgs> stepArgsList;

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
     * Gets the value of the stepArgsList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stepArgsList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStepArgsList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StepArgs }
     * 
     * 
     */
    public List<StepArgs> getStepArgsList() {
        if (stepArgsList == null) {
            stepArgsList = new ArrayList<StepArgs>();
        }
        return this.stepArgsList;
    }

}
