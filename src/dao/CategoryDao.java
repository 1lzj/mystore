package dao;

import bean.Category;

import java.util.List;

/**
 * @Auther: ��΢Цʱ����
 * @Date: 2018/9/20 13:12
 * @Description:
 */
public interface CategoryDao {
    /**
     * ���ҳ����еķ���
     * @return
     */
    List<Category> findAll();
}
