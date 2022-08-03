package sinexcel.utils;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class InBomSoapUtil {
    public static String analysisXML(String xml) {
        Document document = null;
        String code = null;
        try {
            document = DocumentHelper.parseText(xml);
            Element root = document.getRootElement();
            Element body = root.element("Body");
            Element cr = body.element("createStructureResponse");
            Element result = cr.element("result");
            Element value = result.element("Value");
            Element BillSequenceIdValue = value.element("BillSequenceId");
            String BillSequenceId = BillSequenceIdValue.getTextTrim();
            code = BillSequenceId;
        } catch (Exception e) {
            code = e.getMessage();
        }
        return code;
    }
}
