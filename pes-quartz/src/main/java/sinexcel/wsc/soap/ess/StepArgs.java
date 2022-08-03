
package sinexcel.wsc.soap.ess;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>stepArgs complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="stepArgs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arguments" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="100" minOccurs="0"/>
 *         &lt;element name="NLSOptions" type="{http://xmlns.oracle.com/scheduler/types}nlsOptions" minOccurs="0" form="qualified"/>
 *         &lt;element name="PPActions" type="{http://xmlns.oracle.com/scheduler/types}postProcessAction" maxOccurs="100" minOccurs="0" form="qualified"/>
 *         &lt;element name="stepPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stepArgs", namespace = "http://xmlns.oracle.com/scheduler/types", propOrder = {
    "arguments",
    "nlsOptions",
    "ppActions",
    "stepPath"
})
public class StepArgs {

    @XmlElement(nillable = true)
    protected List<String> arguments;
    @XmlElement(name = "NLSOptions")
    protected NlsOptions nlsOptions;
    @XmlElement(name = "PPActions", nillable = true)
    protected List<PostProcessAction> ppActions;
    protected String stepPath;

    /**
     * Gets the value of the arguments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arguments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArguments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getArguments() {
        if (arguments == null) {
            arguments = new ArrayList<String>();
        }
        return this.arguments;
    }

    /**
     * 获取nlsOptions属性的值。
     * 
     * @return
     *     possible object is
     *     {@link NlsOptions }
     *     
     */
    public NlsOptions getNLSOptions() {
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
    public void setNLSOptions(NlsOptions value) {
        this.nlsOptions = value;
    }

    /**
     * Gets the value of the ppActions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ppActions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPPActions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PostProcessAction }
     * 
     * 
     */
    public List<PostProcessAction> getPPActions() {
        if (ppActions == null) {
            ppActions = new ArrayList<PostProcessAction>();
        }
        return this.ppActions;
    }

    /**
     * 获取stepPath属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStepPath() {
        return stepPath;
    }

    /**
     * 设置stepPath属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStepPath(String value) {
        this.stepPath = value;
    }

}
