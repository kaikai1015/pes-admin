package sinexcel.quartz.util;

import sinexcel.common.utils.ConfigUtils;
import sinexcel.wsc.soap.ess.*;

import javax.xml.ws.BindingProvider;
import java.util.List;

public class ESSWebServiceUtils {

    public static final String sfMetadataName = "WshPerformShippingTxnJob";
    public static final String sfPackageName = "/oracle/apps/ess/scm/shipping/shipConfirm/deliveries";
    public static final String sfMetadataObjectType = "JOB_DEFINITION";
    public static final String sfDataType = "STRING";

    //创建链接，用户校验
    public static ESSWebService getESSWebService() {
        ESSWebService_Service oiss = new ESSWebService_Service();
        ESSWebService ois = oiss.getSchedulerServiceImplPort();

        ((BindingProvider) ois).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, ConfigUtils.getErpUser());
        ((BindingProvider) ois).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, ConfigUtils.getErpPass());

        return ois;
    }
    //提交ESS
    public static long submitRequestGeneration(ESSWebService ess,String shipmentName) throws Exception {
        long requestid = -1;
        ObjectFactory essObf = new ObjectFactory();

        MetadataObjectId metadataObjectId = essObf.createMetadataObjectId();
        metadataObjectId.setName(sfMetadataName);
        metadataObjectId.setPackageName(sfPackageName);
        metadataObjectId.setType(MetadataObjectType.fromValue(sfMetadataObjectType));

        RequestParameters requestParameters = essObf.createRequestParameters();
        List<RequestParameter> list = requestParameters.getParameter();

        for (int i = 0; i < 2; i++) {
            RequestParameter requestParameter = essObf.createRequestParameter();
            requestParameter.setDataType(DataType.fromValue(sfDataType));
            requestParameter.setName("submit.argument" + String.valueOf(i + 1));
            if (i == 0) {
                requestParameter.setValue(shipmentName);
            } else if (i == 1) {
                requestParameter.setValue(null);
            }
            list.add(requestParameter);
        }
        requestid = ess.submitRequest(null, metadataObjectId, "FscmEss", null, requestParameters);

        return requestid;
    }
    //获取ESS进程状态getRequestState
    public static State getEssRequestState(ESSWebService ess,long requestId) throws Exception {

        State statusEss = ess.getRequestState(requestId);

        return statusEss;
    }
}
