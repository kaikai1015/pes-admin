
package sinexcel.wsc.soap.ess;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>postProcessAction complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="postProcessAction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="actionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="actionOrder" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="arguments" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="100" minOccurs="0"/>
 *         &lt;element name="fileMgmtGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="onError" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="onSuccess" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="onWarning" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "postProcessAction", namespace = "http://xmlns.oracle.com/scheduler/types", propOrder = {
    "actionName",
    "actionOrder",
    "arguments",
    "fileMgmtGroup",
    "description",
    "onError",
    "onSuccess",
    "onWarning"
})
public class PostProcessAction {

    protected String actionName;
    protected int actionOrder;
    @XmlElement(nillable = true)
    protected List<String> arguments;
    protected String fileMgmtGroup;
    protected String description;
    protected boolean onError;
    protected boolean onSuccess;
    protected boolean onWarning;

    /**
     * 获取actionName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionName() {
        return actionName;
    }

    /**
     * 设置actionName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionName(String value) {
        this.actionName = value;
    }

    /**
     * 获取actionOrder属性的值。
     * 
     */
    public int getActionOrder() {
        return actionOrder;
    }

    /**
     * 设置actionOrder属性的值。
     * 
     */
    public void setActionOrder(int value) {
        this.actionOrder = value;
    }

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
     * 获取fileMgmtGroup属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileMgmtGroup() {
        return fileMgmtGroup;
    }

    /**
     * 设置fileMgmtGroup属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileMgmtGroup(String value) {
        this.fileMgmtGroup = value;
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
     * 获取onError属性的值。
     * 
     */
    public boolean isOnError() {
        return onError;
    }

    /**
     * 设置onError属性的值。
     * 
     */
    public void setOnError(boolean value) {
        this.onError = value;
    }

    /**
     * 获取onSuccess属性的值。
     * 
     */
    public boolean isOnSuccess() {
        return onSuccess;
    }

    /**
     * 设置onSuccess属性的值。
     * 
     */
    public void setOnSuccess(boolean value) {
        this.onSuccess = value;
    }

    /**
     * 获取onWarning属性的值。
     * 
     */
    public boolean isOnWarning() {
        return onWarning;
    }

    /**
     * 设置onWarning属性的值。
     * 
     */
    public void setOnWarning(boolean value) {
        this.onWarning = value;
    }

}
