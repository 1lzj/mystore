package service.impl;

import bean.Category;
import dao.CategoryDao;
import org.apache.ibatis.session.SqlSession;
import service.CategoryService;
import utils.EhCacheUtil;
import utils.SqlSessionUtil;

import java.util.List;

/**
 * @Auther: ��΢Цʱ����
 * @Date: 2018/9/20 13:13
 * @Description:
 */
public class CategoryServiceImpl implements CategoryService {

    @Override
    public List<Category> findAll() {
        List<Category> list = null;
        //��������������ݣ���ֱ���ڻ����л�ȡ
        if(EhCacheUtil.get("list")!=null){
            Object o = EhCacheUtil.get("list");

            list = (List<Category>) o;
            EhCacheUtil.put("list",list);
            return list;
        }else{
            SqlSession sqlSession = SqlSessionUtil.getSqlSession();

            CategoryDao mapper = sqlSession.getMapper(CategoryDao.class);
            list = mapper.findAll();
            EhCacheUtil.put("list",list);
            sqlSession.close();
        }

        return list;
    }


}
