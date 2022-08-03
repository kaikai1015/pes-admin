package sinexcel.utils;

import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * @Author mingshen.wang
 * @Date 2021/11/11 15:57
 * @Version 1.0
 * @Description TODO
 **/
public class BloomFilterUtils {

    private volatile static RedissonClient  redisson = null;


    public static RedissonClient getRedisson() {
        if (redisson == null){
            synchronized (BloomFilterUtils.class){
                if (redisson == null){
                    System.out.println("初始化redisson");
                    Config config = new Config();
                    config.useSingleServer().setAddress("redis://127.0.0.1:6379");
                    //构造Redisson
                    redisson = Redisson.create(config);
                }
            }
        }
        return redisson;
    }
    public static RBloomFilter<String> getBloomFilter(String name){
        RedissonClient myRedisson = getRedisson();
        return myRedisson.getBloomFilter(name);
    }
    public static void main(String[] args) {
        RedissonClient myRedisson = getRedisson();
//        RBloomFilter<String> bloomFilter = myRedisson.getBloomFilter("phoneList");
        //初始化布隆过滤器：预计元素为100000000L,误差率为1%
//        bloomFilter.tryInit(100000000L,0.01);
        //将号码10086插入到布隆过滤器中
//        bloomFilter.add("100861");
//        bloomFilter.delete();
        //判断下面号码是否在布隆过滤器中
//        System.out.println(bloomFilter.contains("hjhnsl10086"));//false
//        System.out.println(bloomFilter.contains("10086"));//true
//        return;
    }


}
