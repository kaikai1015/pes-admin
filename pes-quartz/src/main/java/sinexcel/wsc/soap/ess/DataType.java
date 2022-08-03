
package sinexcel.wsc.soap.ess;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>dataType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="dataType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="STRING"/>
 *     &lt;enumeration value="INTEGER"/>
 *     &lt;enumeration value="LONG"/>
 *     &lt;enumeration value="BOOLEAN"/>
 *     &lt;enumeration value="DATETIME"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "dataType", namespace = "http://xmlns.oracle.com/scheduler/types")
@XmlEnum
public enum DataType {

    STRING,
    INTEGER,
    LONG,
    BOOLEAN,
    DATETIME;

    public String value() {
        return name();
    }

    public static DataType fromValue(String v) {
        return valueOf(v);
    }

}
