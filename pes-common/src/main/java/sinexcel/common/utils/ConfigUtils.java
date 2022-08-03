package sinexcel.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigUtils {


	public static String getBiServer(){
		return getProperty("biServer");
	}
	public static String getErpUser(){
		return getProperty("erpUser");
	}
	public static String getErpPass(){
		return getProperty("erpPass");
	}

	//BOM选配
	public static String getItemBomUrl(){ return getProperty("itemBomUrl");}
	public static String getItemBomName(){ return getProperty("itemBomName");}
	public static String getItemBomMethodName(){ return getProperty("itemBomMethodName");}

	//mes采购入库,mes采购退货
	public static String getRcvPurchasUrl(){ return getProperty("rcvPurchasUrl");}
	public static String getRcvPurchasName(){ return getProperty("rcvPurchasName");}
	public static String getRcvPurchasMethodName(){ return getProperty("rcvPurchasMethodName");}

	//mes调拨，子库存转移
	public static String getSubinvTrnUrl(){ return getProperty("subinvTrnUrl");}

	//创建工单
	public static String getWieWorksUrl(){ return getProperty("wieWorksUrl");}
	//创建工单工序
	public static String getWieWorksOperationUrl(){ return getProperty("wieWorksOperationUrl");}
	//变更工单工序
	public static String getUpdateWieWorksOperationUrl(){ return getProperty("updateWieWorksOperationUrl");}
	//创建单身物料明细
	public static String getWieWorksOperationMaterialUrl(){ return getProperty("wieWorksOperationMaterialUrl");}

	//创建工单工序资源
	public static String getWieWorksOperationResourceUrl(){ return getProperty("wieWorksOperationResourceUrl");}
	//变更工单工序资源
	public static String getUpdateWieWorksOperationResourceUrl(){ return getProperty("UpdateWieWorksOperationResourceUrl");}

	//mes工单完工报工
	public static String getWieWoCompleteUrl(){ return getProperty("wieWoCompleteUrl");}

	//工单超耗
	public static String getWorkMaterialUrl(){ return getProperty("workMaterialUrl");}
	public static String getWorkMaterialName(){ return getProperty("workMaterialName");}
	public static String getWorkMaterialMethodName(){ return getProperty("workMaterialMethodName");}

	//杂入，杂出
	public static String getMiscellaneousUrl(){ return getProperty("miscellaneousUrl");}
	public static String getMiscellaneousName(){ return getProperty("miscellaneousName");}
	public static String getMiscellaneousMethodName(){ return getProperty("miscellaneousMethodName");}

	//PO接收方式修改
	public static String getPurchasUrl(){ return getProperty("purchasUrl");}
	public static String getPurchasName(){ return getProperty("purchasName");}
	public static String getPurchasMethodName(){ return getProperty("purchasMethodName");}

	//销售发运
	public static String getOrderConfirmShipUrl(){ return getProperty("orderConfirmShipUrl");}
	public static String getOrderConfirmShipName(){ return getProperty("orderConfirmShipName");}
	public static String getOrderConfirmShipMethodName(){ return getProperty("orderConfirmShipMethodName");}

	//月结批量工单操作
	public static String getEndWieWoUrl(){ return getProperty("endWieWoUrl");}

	//工单单身变更
	public static String getDelWorkLineUrl(){ return getProperty("delWorkLineUrl");}
	public static String getAddWorkLineUrl(){ return getProperty("addWorkLineUrl");}

	//物料属性更新
	public static String getUpdateItemUrl(){ return getProperty("updateItemUrl");}
	public static String getProdUpdateItemUrl(){ return getProperty("prodUpdateItemUrl");}
	public static String getUpdateItemName(){ return getProperty("updateItemName");}
	public static String getUpdateItemMethodName(){ return getProperty("updateItemMethodName");}

	//提交ESS
//	public static String getSubmitRequestUrl(){ return getProperty("submitRequestUrl");}
//	public static String getSubmitRequestName(){ return getProperty("submitRequestName");}
//	public static String getSubmitRequestMethodName(){ return getProperty("submitRequestMethodName");}

	private static String getProperty(String key){
		return props.getProperty(key);
	}

	static Properties props = new Properties();
	static{
		try {
			InputStream in = ConfigUtils.class.getResourceAsStream("/method.properties");
			props.load(in);
		} catch (IOException e) {
			System.out.println("e.getMessage() = " + e.getMessage());
		}
	}
}
