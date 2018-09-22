package service.impl;

import bean.Order;
import bean.Orderitem;
import dao.OrderDao;
import org.apache.ibatis.session.SqlSession;
import service.OderService;
import utils.SqlSessionUtil;

/**
 * @Auther: 你微笑时很美
 * @Date: 2018/9/21 15:11
 * @Description:
 */
public class OderServiceImpl implements OderService {
    /**
     * 实现田间一条订单纪录
     * @param order
     * @return
     */
    @Override
    public boolean addOrder(Order order) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        OrderDao mapper = sqlSession.getMapper(OrderDao.class);
        boolean b = mapper.addOrder(order);
        sqlSession.commit();
        sqlSession.close();
        return b;
    }

    @Override
    public  void addOrderItem(Orderitem orderitem) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        OrderDao mapper = sqlSession.getMapper(OrderDao.class);
        mapper.addOrderItem(orderitem);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateStateByOid(String r6_order, int i) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        OrderDao mapper = sqlSession.getMapper(OrderDao.class);

        mapper.updateStateById(r6_order,i);

        sqlSession.commit();
        sqlSession.close();
    }
}
