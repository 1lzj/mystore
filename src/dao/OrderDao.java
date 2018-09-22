package dao;

import bean.Order;
import bean.Orderitem;

import java.util.List;

/**
 * @Auther: ��΢Цʱ����
 * @Date: 2018/9/21 15:27
 * @Description:
 */
public interface OrderDao {
    /**
     * ���һ������
     * @param order
     * @return
     */
   boolean addOrder(Order order);

    /**
     * ��Ӷ�����Ŀ����
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
     * �����û�id��ȡ�û��Ķ�������
      * @param uid
     * @return
     */
   int getCouts(String uid);

    void updateStateById(String r6_order, int i);
}
