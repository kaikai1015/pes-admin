package sinexcel.utils;

import sinexcel.common.utils.DateUtils;
import sinexcel.common.utils.StringUtils;

public class GetPesWorkNumberUtils {

    public static String  getWorkNumber(){
        String workNumber = null;
        String yyyymmdd = DateUtils.dateTime();
        //设置新的新值，并且缓存新值
        Long pesWorkNumber = PlanBomUtils.getWorkNumCache(yyyymmdd);
        if (StringUtils.isNotNull(pesWorkNumber)){
            workNumber = String.valueOf(pesWorkNumber+1);
            //清除前面的缓存
            PlanBomUtils.clearWorkOrderNumCache();
            //设置新的缓存值
            PlanBomUtils.setWorkNumCache(yyyymmdd,Long.valueOf(workNumber));
        }else {
            workNumber = yyyymmdd+"000";
            //清除前面的缓存
            PlanBomUtils.clearWorkOrderNumCache();
            //设置新的缓存值
            PlanBomUtils.setWorkNumCache(yyyymmdd,Long.valueOf(workNumber));
        }
        return workNumber;
    }
}
