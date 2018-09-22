package service.impl;

import bean.Order;
import bean.PageBean;
import bean.Product;
import dao.OrderDao;
import dao.ProductDao;
import org.apache.ibatis.session.SqlSession;
import service.ProductService;
import utils.SqlSessionUtil;

import java.util.List;

/**
 * @Auther: 你微笑时很美
 * @Date: 2018/9/20 16:53
 * @Description:
 */
public class ProductServiceImpl implements ProductService {
    /**
     * 获取热门商品
     * @param hot
     * @return
     */
    @Override
    public List<Product> hostList(String hot) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        ProductDao mapper = sqlSession.getMapper(ProductDao.class);
        List<Product> productList = mapper.findProductByHot(hot);

        sqlSession.close();
        return productList;
    }

    @Override
    public PageBean findByCid(String cid, String pageNo) {

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        ProductDao mapper = sqlSession.getMapper(ProductDao.class);
        //获取该类别商品的总的条数
        Integer counts = mapper.getCouts(cid);
        //构建pageBean
        PageBean<Product> pageBean = new PageBean<>(Integer.parseInt(pageNo), counts, 12);
        //查询出pageSize条数据
        Integer begin = (pageBean.getPageNo()-1)*12;
        List<Product> list = mapper.pageList(cid, begin, 12);
        pageBean.setList(list);
        sqlSession.close();
        return pageBean;
    }

    /**
     * 通过shangpid获取一个商品的信息
     * @param pid
     * @return
     */
    @Override
    public Product findProductById(String pid) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        ProductDao mapper = sqlSession.getMapper(ProductDao.class);
        Product product = mapper.findProductById(pid);
        sqlSession.close();
        return product;
    }

    @Override
    public PageBean<Order> findMyOrdersByUid(String uid,String pageNo,String pageSize) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        OrderDao mapper = sqlSession.getMapper(OrderDao.class);
        //获取我的订单的总数
        int count = mapper.getCouts(uid);
        PageBean<Order> pageBean = new PageBean<>(Integer.parseInt(pageNo), count, Integer.parseInt(pageSize));
        int size = Integer.parseInt(pageSize);

        //页面中的数据
        List<Order> list = mapper.findOrderByMyUid(uid, (pageBean.getPageNo() - 1) * size, size);
        pageBean.setList(list);
        return pageBean;

    }
}
