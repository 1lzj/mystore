package dao;

import bean.Category;

import java.util.List;

/**
 * @Auther: 你微笑时很美
 * @Date: 2018/9/20 13:12
 * @Description:
 */
public interface CategoryDao {
    /**
     * 查找出所有的分类
     * @return
     */
    List<Category> findAll();
}
