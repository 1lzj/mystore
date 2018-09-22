package utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

import net.sf.ehcache.Element;
import org.junit.Test;


/**
 * @Auther: 你微笑时很美
 * @Date: 2018/9/20 13:25
 * @Description:
 */
public class EhCacheUtil {
    private static Cache cache = null;
    /**
     * 向缓存中放入元素
     * @param key
     * @param obj
     */
    static{
        CacheManager cacheManager = CacheManager.create(EhCacheUtil.class.getClassLoader().getResourceAsStream("ehcache.xml"));
        cache = cacheManager.getCache("defaultCache");
    }
    public static void put(String key, Object obj) {
        //创建一个元素
        Element element = new Element(key, obj);
        //将元素放入到缓存中
        cache.put(element);
    }

    public static Object get(String key) {
        Element element = cache.get(key);
        if(element!=null){
            Object objectValue = element.getObjectValue();
            return objectValue;
        }

        return  null;
    }

    @Test
    public void test(){
        put("1","2");
        Object o = get("1");
        System.out.println(o);
    }
}
