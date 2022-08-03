package sinexcel.utils;

/**
 * @Author mingshen.wang
 * @Date 2021/8/26 15:59
 * @Version 1.0
 * @Description TODO
 **/
public class CommonStatic {

    //出入类型-入库
    public static final String INV_TYPE_IN = "IN";
    //出入类型-线边仓
    public static final String INV_CODE_XBC = "XBC";
    //出入类型-出库
    public static final String INV_TYPE_OUT = "OUT";
    //出入库种类-厂内工单发料调拨
    public static final String INV_SOURCE_CATEGORY_ISSUE = "ISSUE";
    //出入库种类-库存调拨
    public static final String INV_SOURCE_TYPE_INV = "INV";
    //出入库种类-厂内工单发料调拨
    public static final String INV_SOURCE_TYPE_ISSUE = "ISSUE";
    //出入库种类-委外工单发料调拨
    public static final String INV_SOURCE_TYPE_OUTSIDE = "OUTSIDE";
    //出入库种类-采购入库
    public static final String INV_SOURCE_TYPE_PURCHASE_IN = "PURCHASE_IN";
    //出入库种类-委外工单发料调拨
    public static final String INV_SOURCE_CATEGORY_OUTSIDE = "OUTSIDE";
    //出入库种类-厂内工单退料调拨
    public static final String INV_SOURCE_TYPE_ISSUE_BACK = "ISSUE_BACK";
    //出入库种类-委外工单退料调拨
    public static final String INV_SOURCE_TYPE_OUTSIDE_BACK = "OUTSIDE_BACK";
    //出入库种类-厂内工单超领调拨
    public static final String INV_SOURCE_TYPE_ISSUE_EXCEED = "ISSUE_EXCEED";
    //出入库种类-委外工单超领调拨
    public static final String INV_SOURCE_TYPE_OUTSIDE_EXCEED = "OUTSIDE_EXCEED";
    //出入库种类/类型-工单扣料
    public static final String INV_SOURCE_TYPE_WIP_BACKFLUSH = "WIP Backflush";
    //出入库种类/类型-工单扣料 委外
    public static final String INV_SOURCE_CATEGORY__OUTSIDE_WIP_BACKFLUSH = "OUTSIDE WIP Backflush";
    //出入库种类/类型-厂内工单
    public static final String  INV_SOURCE_TYPE_ISSUE_WORK = "ISSUE_WORK";
    //出入库种类/类型-委外工单
    public static final String  INV_SOURCE_TYPE_OUTSIDE_WORK = "OUTSIDE_WORK";
    //出入库种类/类型-工单扣料
    public static final String INV_SOURCE_CATEGORY_WIP_BACKFLUSH = "WIP Backflush";
    //出入库类型-工单超领扣料
    public static final String INV_SOURCE_TYPE_WIP_BACKFLUSH_XCEED = "WIP Backflush EXCEED";
    //出入库种类-采购入库
    public static final String INV_SOURCE_CATEGORY_PURCHASE_IN = "PURCHASE_IN";
    //出入库种类-采购退货
    public static final String INV_SOURCE_CATEGORY_PURCHASE_BACK = "PURCHASE_BACK";
    //出入库种类-采购退货
    public static final String INV_SOURCE_TYPE_PURCHASE_BACK = "PURCHASE_BACK";
    //出入库种类-备料调拨
    public static final String INV_SOURCE_CATEGORY_BEI_LIAO_OUT = "BEI_LIAO_OUT";
    //出入库种类-工单入库
    public static final String INV_SOURCE_CATEGORY_WORK_IN = "WORK_IN";
    //出入库种类-调拨接收
    public static final String INV_SOURCE_CATEGORY_TRANSFER_IN = "TRANSFER_IN";
    //出入库种类-退料调拨
    public static final String INV_SOURCE_CATEGORY_BACK_OUT = "BACK_OUT";
    //出入库种类-超领调拨
    public static final String INV_SOURCE_CATEGORY_EXCEED_OUT = "EXCEED_OUT";
    //出入库种类-销售出库
    public static final String INV_SOURCE_CATEGORY_SALE_OUT = "SALE_OUT";
    //出入库种类-销售出库
    public static final String INV_SOURCE_TYPE_SALE_OUT = "SALE_OUT";
    //出入库种类-销售退货
    public static final String INV_SOURCE_CATEGORY_SALE_BACK = "SALE_BACK";
    //出入库种类-销售退货
    public static final String INV_SOURCE_TYPE_SALE_BACK = "SALE_BACK";
    //出入库种类-库存调拨出库
    public static final String INV_SOURCE_CATEGORY_INV_OUT = "INV_OUT";
    //出入库种类-库存调拨入库
    public static final String INV_SOURCE_CATEGORY_INV_IN = "INV_IN";
    //出入库种类-杂出
    public static final String INV_SOURCE_CATEGORY_INV_SUNDRY_OUT = "INV_SUNDRY_OUT";
    //出入库种类-杂出
    public static final String INV_SOURCE_TYPE_INV_SUNDRY_OUT = "INV_SUNDRY_OUT";
    //出入库种类-杂入
    public static final String INV_SOURCE_CATEGORY_INV_SUNDRY_IN = "INV_SUNDRY_IN";
    //出入库种类-杂入
    public static final String INV_SOURCE_TYPE_INV_SUNDRY_IN = "INV_SUNDRY_IN";
//    //出入库种类-工单入库
//    public static final String INV_SOURCE_CATEGORY_INV_OUT = "INV_OUT";
    //出入库类型-备料调拨
    public static final String INV_SOURCE_TYPE_BEI_LIAO_OUT = "BEI_LIAO_OUT";
    //出入库类型-调拨接收
    public static final String INV_SOURCE_TYPE_TRANSFER_IN = "TRANSFER_IN";
    //来源对象代码-工单
    public static final String INV_SOURCE_CODE_WORK_ORDER = "WORK_ORDER";

    //调拨类别-备料调拨
    public static final String TRANSFER_TYPE_BEI_LIAO = "BEI_LIAO";
    //生产进度-类型：COMPLETE-完工入库（产品入库）；AGEING-老化开始；AGEING_END-老化结束；TEST-测试开始；TEST_END-测试结束；PACKING-包装采集开始；PACKING_END-包装采集结束；FEEDING-投料(组装开始)；ASSEMBLING_COMPLETE:装配（组装完成）；COLLECTION：组装采集；REPAIR-维修；
    public static final String WORK_PROCESS_COMPLETE = "COMPLETE";
    public static final String WORK_PROCESS_AGEING = "AGEING";
    public static final String WORK_PROCESS_AGEING_END = "AGEING_END";
    public static final String WORK_PROCESS_TEST = "TEST";
    public static final String WORK_PROCESS_PACKING = "PACKING";
    public static final String WORK_PROCESS_FEEDING = "FEEDING";
    public static final String WORK_PROCESS_ASSEMBLING_COMPLETE = "ASSEMBLING_COMPLETE";
    public static final String WORK_PROCESS_TEST_END = "TEST_END";
    public static final String WORK_PROCESS_PACKING_END = "PACKING_END";
    public static final String WORK_PROCESS_COLLECTION = "COLLECTION";
    public static final String WORK_PROCESS_REPAIR = "REPAIR";


}
