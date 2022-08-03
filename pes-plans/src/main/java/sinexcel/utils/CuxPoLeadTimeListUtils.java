package sinexcel.utils;

import sinexcel.common.constant.Constants;
import sinexcel.common.core.redis.RedisCache;
import sinexcel.common.utils.StringUtils;
import sinexcel.common.utils.spring.SpringUtils;

import java.math.BigDecimal;
import java.util.Collection;

public class CuxPoLeadTimeListUtils {

    /**
     * 设置提前期数据缓存
     *
     * @param key 参数键
     * @param totalDays 数据列表
     */
    public static void setCuxPoLeadTimeListCache(String key, BigDecimal totalDays)
    {
        SpringUtils.getBean(RedisCache.class).setCacheObject(getCacheKey(key), totalDays);
    }

    /**
     * 设置cache key
     *
     * @param configKey 参数键
     * @return 缓存键key
     */
    public static String getCacheKey(String configKey)
    {
        return Constants.SYS_PO_LEAD_KEY + configKey;
    }

    /**
     * 获取缓存
     *
     * @param key 参数键
     * @return 数据列表
     */
    public static BigDecimal getCuxPoLeadTimeListCache(String key)
    {
        Object cacheObj = SpringUtils.getBean(RedisCache.class).getCacheObject(getCacheKey(key));
        if (StringUtils.isNotNull(cacheObj))
        {
            BigDecimal totalDays = StringUtils.cast(cacheObj);
            return totalDays;
        }
        return null;
    }

    /**
     * 清空缓存
     */
    public static void clearCuxPoLeadTimeListCache()
    {
        Collection<String> keys = SpringUtils.getBean(RedisCache.class).keys(Constants.SYS_PO_LEAD_KEY + "*");
        SpringUtils.getBean(RedisCache.class).deleteObject(keys);
    }

}
