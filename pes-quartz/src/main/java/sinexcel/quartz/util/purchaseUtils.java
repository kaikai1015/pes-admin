package sinexcel.quartz.util;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
public class purchaseUtils {
    public static String analysisXML(String xml)throws Exception{
        Document document = null;
        String code = null;
        document = DocumentHelper.parseText(xml);
        Element root = document.getRootElement();
        Element body = root.element("Body");
        Element cr = body.element("changePurchaseOrderResponse");
        Element result = cr.element("result");
        Element statusValue = result.element("RequestStatus");
        String status = statusValue.getTextTrim();
        if(!"SUCCESS".equals(status)){
            code = xml;
        }else {
            code = status;
        }
        return code;
    }
}
