package dao;

import bean.Product;

import java.util.List;

/**
 * @Auther: 你微笑时很美
 * @Date: 2018/9/20 16:51
 * @Description:
 */
public interface ProductDao {
    /**
     * 按照热门程度查询商品
     * @param hot
     * @return
     */
    List<Product> findProductByHot(String hot);

    /**
     * 将数据分页查询
     * @param cid
     * @param begin
     * @param pageSize
     * @return
     */
    List<Product> pageList(String cid,Integer begin,Integer pageSize);

    /**
     * 获取指定类别商品的条数
     * @param cid
     * @return
     */
    Integer getCouts(String cid);

    /**
     * 通过商品Id获取一个商品的信息
     * @param pid
     * @return
     */
    Product findProductById(String pid);
}
