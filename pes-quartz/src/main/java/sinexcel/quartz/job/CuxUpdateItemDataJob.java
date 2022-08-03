package sinexcel.quartz.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sinexcel.common.utils.ConfigUtils;
import sinexcel.common.utils.InSoapUtil;
import sinexcel.quartz.domain.CuxUpdateItemDataEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.CuxUpdateItemDataEOMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;

import java.text.SimpleDateFormat;
import java.util.*;


@Component("cuxUpdateItemDataJob")
public class CuxUpdateItemDataJob{

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private CuxUpdateItemDataEOMapper cuxUpdateItemDataEOMapper;

    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void report() {

        SysJobLog log = new SysJobLog();
        log.setJobName("CuxUpdateItemDataJob");
        log.setStopTime(new Date());
        //系统时间转换成格林威治时间
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(log.getStopTime() .getTime());
        cal.add(Calendar.HOUR, -8);

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        List<CuxUpdateItemDataEO> cuxUpdateItemDatas = cuxUpdateItemDataEOMapper.selectUpdateItemDataList();

        //采购入库接口
        CuxUpdateItemDataEO rcvPurchaseEO = new CuxUpdateItemDataEO();
        rcvPurchaseEO.setStartUpdateDate(sdf.format(log.getStartTime()));
        rcvPurchaseEO.setEndUpdateDate(sdf.format(log.getStopTime()));


        List<CuxUpdateItemDataEO> cuxUpdateItemBuyerDatas = cuxUpdateItemDataEOMapper.selectUpdateItemDataBuyerList(rcvPurchaseEO);


        List<CuxUpdateItemDataEO> cuxUpdateItemAttributeDatas = cuxUpdateItemDataEOMapper.selectUpdateItemDataAttributeList(rcvPurchaseEO);

//        List<CuxUpdateItemDataEO> cuxUpdateItemStatusDatas = cuxUpdateItemDataEOMapper.selectUpdateItemDataStatusList();


        sysJobLogMapper.updateLatUpdateDate(log);

        if(cuxUpdateItemDatas.size() > 0){
            for(CuxUpdateItemDataEO cuxUpdateItemData : cuxUpdateItemDatas){
                //头信息
                String xmlStr = "<soapenv:Envelope\n" +
                        "    xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                        "    xmlns:typ=\"http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/types/\"\n" +
                        "    xmlns:item=\"http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/\">\n" +
                        "    <soapenv:Header/>\n" +
                        "    <soapenv:Body>\n" +
                        "        <typ:updateItem>\n" +
                        "            <typ:item>\n" +
                        "                <item:ItemId>"+cuxUpdateItemData.getInventoryItemId()+"</item:ItemId>\n" +
                        "                <item:OrganizationId>"+cuxUpdateItemData.getOrganizationId()+"</item:OrganizationId>\n" +
                        "                <item:ItemClass>Root Item Class</item:ItemClass>\n" +
                        "                <item:VersionId>-1</item:VersionId>\n" +
                        "                <item:WIPSupplySubinventoryValue>XBC</item:WIPSupplySubinventoryValue>\n" +
                        "            </typ:item>\n" +
                        "        </typ:updateItem>\n" +
                        "    </soapenv:Body>\n" +
                        "</soapenv:Envelope>";

                String returnStr = null;
                try {
                    returnStr = InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getUpdateItemUrl(),ConfigUtils.getUpdateItemName(),ConfigUtils.getUpdateItemMethodName());

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        if(cuxUpdateItemBuyerDatas.size() > 0){
            for(CuxUpdateItemDataEO cuxUpdateItemBuyerData : cuxUpdateItemBuyerDatas){
                //头信息
                String xmlStr = "<soapenv:Envelope\n" +
                        "    xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                        "    xmlns:typ=\"http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/types/\"\n" +
                        "    xmlns:item=\"http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/\">\n" +
                        "    <soapenv:Header/>\n" +
                        "    <soapenv:Body>\n" +
                        "        <typ:updateItem>\n" +
                        "            <typ:item>\n" +
                        "                <item:ItemId>"+cuxUpdateItemBuyerData.getInventoryItemId()+"</item:ItemId>\n" +
                        "                <item:OrganizationId>"+cuxUpdateItemBuyerData.getOrganizationId()+"</item:OrganizationId>\n" +
                        "                <item:ItemClass>Root Item Class</item:ItemClass>\n" +
                        "                <item:VersionId>-1</item:VersionId>\n" +
                        "                <item:DefaultBuyerValue>"+cuxUpdateItemBuyerData.getBuyerName()+"</item:DefaultBuyerValue>\n" +
                        "            </typ:item>\n" +
                        "        </typ:updateItem>\n" +
                        "    </soapenv:Body>\n" +
                        "</soapenv:Envelope>";

                String returnStr = null;
                try {
                    returnStr = InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getUpdateItemUrl(),ConfigUtils.getUpdateItemName(),ConfigUtils.getUpdateItemMethodName());

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        if(cuxUpdateItemAttributeDatas.size() > 0){
            for(CuxUpdateItemDataEO cuxUpdateItemAttributeData : cuxUpdateItemAttributeDatas){
                //头信息
                String xmlStr = "<soapenv:Envelope\n" +
                        "    xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                        "    xmlns:typ=\"http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/types/\"\n" +
                        "    xmlns:item=\"http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/\"\n" +
                        "    xmlns:item2=\"http://xmlns.oracle.com/apps/scm/productModel/items/flex/item/\">\n" +
                        "    <soapenv:Header/>\n" +
                        "    <soapenv:Body>\n" +
                        "        <typ:updateItem>\n" +
                        "            <typ:item>\n" +
                        "                <item:ItemId>"+cuxUpdateItemAttributeData.getInventoryItemId()+"</item:ItemId>\n" +
                        "                <item:OrganizationId>"+cuxUpdateItemAttributeData.getOrganizationId()+"</item:OrganizationId>\n" +
                        "                <item:ItemClass>Root Item Class</item:ItemClass>\n" +
                        "                <item:VersionId>-1</item:VersionId>\n" +
                        "                <item:ItemDFF>\n" +
                        "                    <item2:InventoryItemId>"+cuxUpdateItemAttributeData.getInventoryItemId()+"</item2:InventoryItemId>\n" +
                        "                    <item2:OrganizationId>"+cuxUpdateItemAttributeData.getOrganizationId()+"</item2:OrganizationId>\n" +
                        "                    <item2:usageratef>"+cuxUpdateItemAttributeData.getUsageRateF()+"</item2:usageratef>\n" +
                        "                    <item2:usagerates>"+cuxUpdateItemAttributeData.getUsageRateS()+"</item2:usagerates>\n" +
                        "                </item:ItemDFF>\n" +
                        "            </typ:item>\n" +
                        "        </typ:updateItem>\n" +
                        "    </soapenv:Body>\n" +
                        "</soapenv:Envelope>";

                String returnStr = null;
                try {
                    logger.info("成品俩料号："+cuxUpdateItemAttributeData.getItemNumber()+"，工时："+cuxUpdateItemAttributeData.getUsageRateF());
                    returnStr = InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getUpdateItemUrl(),ConfigUtils.getUpdateItemName(),ConfigUtils.getUpdateItemMethodName());

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        //更新物料状态
//        if(cuxUpdateItemStatusDatas.size() > 0){
//            for(CuxUpdateItemDataEO cuxUpdateItemStatusData : cuxUpdateItemStatusDatas){
//                //头信息
//                String xmlStr = "<soapenv:Envelope\n" +
//                        "    xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
//                        "    xmlns:typ=\"http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/types/\"\n" +
//                        "    xmlns:item=\"http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/\">\n" +
//                        "    <soapenv:Header/>\n" +
//                        "    <soapenv:Body>\n" +
//                        "        <typ:updateItem>\n" +
//                        "            <typ:item>\n" +
//                        "                <item:ItemNumber>"+cuxUpdateItemStatusData.getItemNumber()+"</item:ItemNumber>\n" +
//                        "                <item:OrganizationId>300000001811006</item:OrganizationId>\n" +
//                        "                <item:ItemClass>Root Item Class</item:ItemClass>\n" +
//                        "                <item:VersionId>-1</item:VersionId>\n" +
//                        "                <item:Template>"+cuxUpdateItemStatusData.getItemType()+"</item:Template>\n" +
//                        "            </typ:item>\n" +
//                        "        </typ:updateItem>\n" +
//                        "    </soapenv:Body>\n" +
//                        "</soapenv:Envelope>";
//
//                String returnStr = null;
//                try {
//                    System.out.println("ItemNumber："+cuxUpdateItemStatusData.getItemNumber());
//                    returnStr = InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getUpdateItemUrl(),ConfigUtils.getUpdateItemName(),ConfigUtils.getUpdateItemMethodName());
//
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//            }
//        }

    }
}
