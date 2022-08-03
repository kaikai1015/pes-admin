package sinexcel.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ExcelUtils {
    /**
     * 获取未来 第 past 天的日期
     * @param past
     * @return
     */
    public String getFetureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("MM-dd");
        String result = format.format(today);
        return result;
    }
}
