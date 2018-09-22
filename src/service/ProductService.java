package service;

import bean.PageBean;
import bean.Product;

import java.util.List;

/**
 * @Auther: 你微笑时很美
 * @Date: 2018/9/20 16:49
 * @Description:
 */
public interface ProductService {
    /**
     * 按照热门程度查询
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
     * 通过商品id获取一个商品信息
     * @param pid
     * @return
     */
    Product findProductById(String pid);

    /**
     * 查看我的购物车信息
     * @param uid
     */
    PageBean findMyOrdersByUid(String uid,String pageNo,String pageSize);
}
