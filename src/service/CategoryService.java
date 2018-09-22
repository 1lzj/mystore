package service;

import bean.Category;

import java.util.List;

/**
 * @Auther: 你微笑时很美
 * @Date: 2018/9/20 13:13
 * @Description:
 */
public interface CategoryService {
    /**
     * 获取所有的商品类别
     * @return
     */
    List<Category> findAll();
}
