package sinexcel.utils;

import sinexcel.common.constant.Constants;
import sinexcel.common.core.redis.RedisCache;
import sinexcel.common.utils.StringUtils;
import sinexcel.common.utils.spring.SpringUtils;

import java.util.Collection;


public class PlanBomUtils {
    /**
     * 设置计划行数据缓存
     *
     * @param key 参数键
     * @param workNum 数据列表
     */
    public static void setWorkNumCache(String key, Long workNum)
    {
        SpringUtils.getBean(RedisCache.class).setCacheObject(getCacheKey(key), workNum);
    }

    /**
     * 设置cache key
     *
     * @param configKey 参数键
     * @return 缓存键key
     */
    public static String getCacheKey(String configKey)
    {
        return Constants.SYS_WORK_NUM_KEY + configKey;
    }

    /**
     * 获取缓存
     *
     * @param key 参数键
     * @return 数据列表
     */
    public static Long getWorkNumCache(String key)
    {
        Object cacheObj = SpringUtils.getBean(RedisCache.class).getCacheObject(getCacheKey(key));
        if (StringUtils.isNotNull(cacheObj))
        {
            Long workNmu = StringUtils.cast(cacheObj);
            return workNmu;
        }
        return null;
    }

    /**
     * 清空缓存
     */
    public static void clearWorkOrderNumCache()
    {
        Collection<String> keys = SpringUtils.getBean(RedisCache.class).keys(Constants.SYS_WORK_NUM_KEY + "*");
        SpringUtils.getBean(RedisCache.class).deleteObject(keys);
    }
}
