package sinexcel.utils;

import sinexcel.common.constant.Constants;
import sinexcel.common.core.redis.RedisCache;
import sinexcel.common.utils.StringUtils;
import sinexcel.common.utils.spring.SpringUtils;

import java.util.Collection;
import java.util.Date;

public class PesWieMaterialsUtils {
    /**
     * 设置计划行数据缓存
     *
     * @param key 参数键
     * @param workNum 数据列表
     */
    public static void setPesMaterialIdLastUpdateDateCache(String key, Date lastUpdateDate)
    {
        SpringUtils.getBean(RedisCache.class).setCacheObject(getCacheKey(key), lastUpdateDate);
    }

    /**
     * 设置cache key
     *
     * @param configKey 参数键
     * @return 缓存键key
     */
    public static String getCacheKey(String configKey)
    {
        return Constants.SYS_PES_WIE_MATERIAL_ID_KEY + configKey;
    }

    public static Date getPesMaterialIdLastUpdateDateCache(String key)
    {
        Object cacheObj = SpringUtils.getBean(RedisCache.class).getCacheObject(getCacheKey(key));
        if (StringUtils.isNotNull(cacheObj))
        {
            Date lastUpdateDate = StringUtils.cast(cacheObj);
            return lastUpdateDate;
        }
        return null;
    }

    /**
     * 清空缓存
     */
    public static void clearPesMaterialIdLastUpdateDateCache()
    {
        Collection<String> keys = SpringUtils.getBean(RedisCache.class).keys(Constants.SYS_PES_WIE_MATERIAL_ID_KEY + "*");
        SpringUtils.getBean(RedisCache.class).deleteObject(keys);
    }


}
