package service;

import bean.Category;

import java.util.List;

/**
 * @Auther: ��΢Цʱ����
 * @Date: 2018/9/20 13:13
 * @Description:
 */
public interface CategoryService {
    /**
     * ��ȡ���е���Ʒ���
     * @return
     */
    List<Category> findAll();
}
