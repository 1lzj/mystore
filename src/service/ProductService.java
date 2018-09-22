package service;

import bean.PageBean;
import bean.Product;

import java.util.List;

/**
 * @Auther: ��΢Цʱ����
 * @Date: 2018/9/20 16:49
 * @Description:
 */
public interface ProductService {
    /**
     * �������ų̶Ȳ�ѯ
     * @param hot
     * @return
     */
    List<Product> hostList(String hot);

    /**
     *
     * @param cid
     * @param pageNo
     * @return
     */
    PageBean findByCid(String cid, String pageNo);

    /**
     * ͨ����Ʒid��ȡһ����Ʒ��Ϣ
     * @param pid
     * @return
     */
    Product findProductById(String pid);

    /**
     * �鿴�ҵĹ��ﳵ��Ϣ
     * @param uid
     */
    PageBean findMyOrdersByUid(String uid,String pageNo,String pageSize);
}
