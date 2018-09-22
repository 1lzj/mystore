package service;

import bean.Order;
import bean.Orderitem;

/**
 * @Auther: 你微笑时很美
 * @Date: 2018/9/21 15:10
 * @Description:
 */
public interface OderService {
    /**
     * 添加一条订单纪录
     * @param order
     * @return
     */
    boolean addOrder(Order order);

    /**
     * 添加订单条目对象
     * @param orderitem
     */
    void addOrderItem(Orderitem orderitem);

    void updateStateByOid(String r6_order, int i);
}
