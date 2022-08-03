
package sinexcel.wsc.soap.ess;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>postProcessAction complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡactionName���Ե�ֵ��
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
     * ����actionName���Ե�ֵ��
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
     * ��ȡactionOrder���Ե�ֵ��
     * 
     */
    public int getActionOrder() {
        return actionOrder;
    }

    /**
     * ����actionOrder���Ե�ֵ��
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
     * ��ȡfileMgmtGroup���Ե�ֵ��
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
     * ����fileMgmtGroup���Ե�ֵ��
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
     * ��ȡonError���Ե�ֵ��
     * 
     */
    public boolean isOnError() {
        return onError;
    }

    /**
     * ����onError���Ե�ֵ��
     * 
     */
    public void setOnError(boolean value) {
        this.onError = value;
    }

    /**
     * ��ȡonSuccess���Ե�ֵ��
     * 
     */
    public boolean isOnSuccess() {
        return onSuccess;
    }

    /**
     * ����onSuccess���Ե�ֵ��
     * 
     */
    public void setOnSuccess(boolean value) {
        this.onSuccess = value;
    }

    /**
     * ��ȡonWarning���Ե�ֵ��
     * 
     */
    public boolean isOnWarning() {
        return onWarning;
    }

    /**
     * ����onWarning���Ե�ֵ��
     * 
     */
    public void setOnWarning(boolean value) {
        this.onWarning = value;
    }

}
