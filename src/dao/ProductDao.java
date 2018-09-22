package dao;

import bean.Product;

import java.util.List;

/**
 * @Auther: ��΢Цʱ����
 * @Date: 2018/9/20 16:51
 * @Description:
 */
public interface ProductDao {
    /**
     * �������ų̶Ȳ�ѯ��Ʒ
     * @param hot
     * @return
     */
    List<Product> findProductByHot(String hot);

    /**
     * �����ݷ�ҳ��ѯ
     * @param cid
     * @param begin
     * @param pageSize
     * @return
     */
    List<Product> pageList(String cid,Integer begin,Integer pageSize);

    /**
     * ��ȡָ�������Ʒ������
     * @param cid
     * @return
     */
    Integer getCouts(String cid);

    /**
     * ͨ����ƷId��ȡһ����Ʒ����Ϣ
     * @param pid
     * @return
     */
    Product findProductById(String pid);
}
