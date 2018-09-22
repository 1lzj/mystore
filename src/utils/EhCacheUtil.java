package utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

import net.sf.ehcache.Element;
import org.junit.Test;


/**
 * @Auther: ��΢Цʱ����
 * @Date: 2018/9/20 13:25
 * @Description:
 */
public class EhCacheUtil {
    private static Cache cache = null;
    /**
     * �򻺴��з���Ԫ��
     * @param key
     * @param obj
     */
    static{
        CacheManager cacheManager = CacheManager.create(EhCacheUtil.class.getClassLoader().getResourceAsStream("ehcache.xml"));
        cache = cacheManager.getCache("defaultCache");
    }
    public static void put(String key, Object obj) {
        //����һ��Ԫ��
        Element element = new Element(key, obj);
        //��Ԫ�ط��뵽������
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
