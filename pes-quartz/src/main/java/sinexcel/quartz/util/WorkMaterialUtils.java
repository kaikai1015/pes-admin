package sinexcel.quartz.util;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class WorkMaterialUtils {
    public static String analysisXML(String xml)throws Exception{
        Document document = null;
        String code = null;
        document = DocumentHelper.parseText(xml);
        Element root = document.getRootElement();
        Element body = root.element("Body");
        Element cr = body.element("createWorkOrderMaterialTransactionsResponse");
        Element result = cr.element("result");
        Element interfaceBatchStatus = result.element("InterfaceBatchStatus");
        String status = interfaceBatchStatus.getTextTrim();
        if(!"COMPLETED".equals(status)){
            code = xml;
        }else {
            code = status;
        }
        return code;
    }
}