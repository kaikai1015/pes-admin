package sinexcel.wsc;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.xml.ws.BindingProvider;

import sinexcel.common.utils.ConfigUtils;
import sinexcel.wsc.soap.report.ArrayOfParamNameValue;
import sinexcel.wsc.soap.report.ArrayOfString;
import sinexcel.wsc.soap.report.ObjectFactory;
import sinexcel.wsc.soap.report.ParamNameValue;
import sinexcel.wsc.soap.report.ParamNameValues;
import sinexcel.wsc.soap.report.ReportRequest;
import sinexcel.wsc.soap.report.ReportResponse;
import sinexcel.wsc.soap.report.ReportService;
import sinexcel.wsc.soap.report.ReportService_Service;

public class DataModelCommon {
//	public static void main(String[] args) throws  Exception{
//		String path = "/SYNC_DATA/PesPOInforData_external.xdm";
//		Map<String,Object> params = new HashMap<String,Object>();
//		params.put("FromDate","2022-06-13 11:00:00");
//		params.put("ToDate","2022-06-13 11:05:00");
//
//		byte[] data = DataModelCommon.getData(path,params);
//		String resultStr = new String(data,"UTF-8");
//		System.out.print(resultStr);
//	}

	public static byte[] getData(String path,Map<String,Object> params) throws Exception {
		ReportService_Service reportService_Service = new ReportService_Service();
		
		ReportService reportService=reportService_Service.getPort(ReportService.class);
		
		BindingProvider wsbp = (BindingProvider) reportService;
		wsbp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, ConfigUtils.getErpUser());
		wsbp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY,ConfigUtils.getErpPass());
		
		ObjectFactory obf=new ObjectFactory();
		ReportRequest reportRequest=obf.createReportRequest();
		reportRequest.setReportAbsolutePath(path);
		reportRequest.setSizeOfDataChunkDownload(-1);
		reportRequest.setByPassCache(true);

		ParamNameValues paramNameValues = obf.createParamNameValues();
		ArrayOfParamNameValue arrayOfParamNameValue = obf.createArrayOfParamNameValue();

		SimpleDateFormat DATE_TIME=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		if(params!=null){
			
			if( (params.get("ToDate")!=null) && (params.get("FromDate")==null) ){
				params.put("FromDate", new Date(0));
			}
			
			Set<String> paramNames=params.keySet();
			for(String paramName:paramNames){
				Object paramValue=params.get(paramName);
				if(paramValue==null){
					continue;
				}
				
				String paramValueStr=null;
				
				if(paramValue instanceof String){
					paramValueStr=(String)paramValue;
				}else if(paramValue instanceof Integer){
					paramValueStr=((Integer)paramValue)+"";
				}else if(paramValue instanceof Long){
					paramValueStr=((Long)paramValue)+"";
				}else if(paramValue instanceof BigDecimal){
					paramValueStr=((BigDecimal)paramValue)+"";
				}else if(paramValue instanceof Date){
					paramValueStr=DATE_TIME.format((Date)paramValue);
				}

				if(paramValueStr==null||paramValueStr.equals("")){
					continue;
				}
				
				ParamNameValue paramNameValue = obf.createParamNameValue();
				ArrayOfString arrayOfString = obf.createArrayOfString();
				paramNameValue.setName(paramName);
				arrayOfString.getItem().add(paramValueStr);
				paramNameValue.setValues(arrayOfString);
				arrayOfParamNameValue.getItem().add(paramNameValue);

			}
		}

		paramNameValues.setListOfParamNameValues(arrayOfParamNameValue);
		reportRequest.setParameterNameValues(paramNameValues);

		ReportResponse reportResponse = reportService.runDataModel(reportRequest, ConfigUtils.getErpUser(), ConfigUtils.getErpPass());
		byte[] data=reportResponse.getReportBytes();
		return data;
	}
}
