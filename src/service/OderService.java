package service;

import bean.Order;
import bean.Orderitem;

/**
 * @Auther: ��΢Цʱ����
 * @Date: 2018/9/21 15:10
 * @Description:
 */
public interface OderService {
    /**
     * ���һ��������¼
     * @param order
     * @return
     */
    boolean addOrder(Order order);

    /**
     * ��Ӷ�����Ŀ����
     * @param orderitem
     */
    void addOrderItem(Orderitem orderitem);

    void updateStateByOid(String r6_order, int i);
}
