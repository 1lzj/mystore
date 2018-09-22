package dao;

import bean.Order;
import bean.Orderitem;

import java.util.List;

/**
 * @Auther: 你微笑时很美
 * @Date: 2018/9/21 15:27
 * @Description:
 */
public interface OrderDao {
    /**
     * 添加一个订单
     * @param order
     * @return
     */
   boolean addOrder(Order order);

    /**
     * 添加订单条目对象
     * @param orderitem
     */
   void addOrderItem(Orderitem orderitem);

    /**
     *
     * @param uid
     * @return
     */
   List<Order> findOrderByMyUid(String uid,int pageNo,int pageSize);

    /**
     * 按照用户id获取用户的订单总数
      * @param uid
     * @return
     */
   int getCouts(String uid);

    void updateStateById(String r6_order, int i);
}
