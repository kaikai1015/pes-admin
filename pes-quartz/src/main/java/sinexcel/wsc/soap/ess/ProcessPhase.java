
package sinexcel.wsc.soap.ess;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>processPhase�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="processPhase">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Undefined"/>
 *     &lt;enumeration value="Initial"/>
 *     &lt;enumeration value="JobSetInitial"/>
 *     &lt;enumeration value="PreProcessStart"/>
 *     &lt;enumeration value="PreProcessDelayed"/>
 *     &lt;enumeration value="PreProcessComplete"/>
 *     &lt;enumeration value="ExecuteInitiate"/>
 *     &lt;enumeration value="ExecuteInitiateComplete"/>
 *     &lt;enumeration value="ExecuteAsyncWait"/>
 *     &lt;enumeration value="ExecuteFinalize"/>
 *     &lt;enumeration value="ExecuteFinalizeAsync"/>
 *     &lt;enumeration value="ExecuteFinalizeComplete"/>
 *     &lt;enumeration value="ExecutePaused"/>
 *     &lt;enumeration value="PostProcessStart"/>
 *     &lt;enumeration value="PostProcessDelayed"/>
 *     &lt;enumeration value="PostProcessComplete"/>
 *     &lt;enumeration value="ProcessExecuteComplete"/>
 *     &lt;enumeration value="PostExecuteStart"/>
 *     &lt;enumeration value="PostExecuteWaitForSubreq"/>
 *     &lt;enumeration value="PostExecuteTerminalComplete"/>
 *     &lt;enumeration value="PostExecuteComplete"/>
 *     &lt;enumeration value="Complete"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "processPhase", namespace = "http://xmlns.oracle.com/scheduler/types")
@XmlEnum
public enum ProcessPhase {

    @XmlEnumValue("Undefined")
    UNDEFINED("Undefined"),
    @XmlEnumValue("Initial")
    INITIAL("Initial"),
    @XmlEnumValue("JobSetInitial")
    JOB_SET_INITIAL("JobSetInitial"),
    @XmlEnumValue("PreProcessStart")
    PRE_PROCESS_START("PreProcessStart"),
    @XmlEnumValue("PreProcessDelayed")
    PRE_PROCESS_DELAYED("PreProcessDelayed"),
    @XmlEnumValue("PreProcessComplete")
    PRE_PROCESS_COMPLETE("PreProcessComplete"),
    @XmlEnumValue("ExecuteInitiate")
    EXECUTE_INITIATE("ExecuteInitiate"),
    @XmlEnumValue("ExecuteInitiateComplete")
    EXECUTE_INITIATE_COMPLETE("ExecuteInitiateComplete"),
    @XmlEnumValue("ExecuteAsyncWait")
    EXECUTE_ASYNC_WAIT("ExecuteAsyncWait"),
    @XmlEnumValue("ExecuteFinalize")
    EXECUTE_FINALIZE("ExecuteFinalize"),
    @XmlEnumValue("ExecuteFinalizeAsync")
    EXECUTE_FINALIZE_ASYNC("ExecuteFinalizeAsync"),
    @XmlEnumValue("ExecuteFinalizeComplete")
    EXECUTE_FINALIZE_COMPLETE("ExecuteFinalizeComplete"),
    @XmlEnumValue("ExecutePaused")
    EXECUTE_PAUSED("ExecutePaused"),
    @XmlEnumValue("PostProcessStart")
    POST_PROCESS_START("PostProcessStart"),
    @XmlEnumValue("PostProcessDelayed")
    POST_PROCESS_DELAYED("PostProcessDelayed"),
    @XmlEnumValue("PostProcessComplete")
    POST_PROCESS_COMPLETE("PostProcessComplete"),
    @XmlEnumValue("ProcessExecuteComplete")
    PROCESS_EXECUTE_COMPLETE("ProcessExecuteComplete"),
    @XmlEnumValue("PostExecuteStart")
    POST_EXECUTE_START("PostExecuteStart"),
    @XmlEnumValue("PostExecuteWaitForSubreq")
    POST_EXECUTE_WAIT_FOR_SUBREQ("PostExecuteWaitForSubreq"),
    @XmlEnumValue("PostExecuteTerminalComplete")
    POST_EXECUTE_TERMINAL_COMPLETE("PostExecuteTerminalComplete"),
    @XmlEnumValue("PostExecuteComplete")
    POST_EXECUTE_COMPLETE("PostExecuteComplete"),
    @XmlEnumValue("Complete")
    COMPLETE("Complete");
    private final String value;

    ProcessPhase(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProcessPhase fromValue(String v) {
        for (ProcessPhase c: ProcessPhase.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new java.lang.IllegalArgumentException(v);
    }

}
