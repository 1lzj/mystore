package service.impl;

import bean.User;
import dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import service.UserService;

import utils.SqlSessionUtil;

/**
 * @Auther: 你微笑时很美
 * @Date: 2018/9/19 17:01
 * @Description:
 */
public class UserServiceImpl implements UserService {

    @Override
    public User findUserByName(String userName) {

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.findUserByName(userName);
        sqlSession.close();
        return user;
    }

    @Override
    public boolean registerUser(User user) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);
        boolean b = mapper.addUser(user);
        sqlSession.commit();
        sqlSession.close();

        return b;
    }

    /**
     * 激活
     * @param code
     * @return
     */
    @Override
    public int active(String code) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);

        int i = mapper.updateByCode(code);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public User login(String userName, String password) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);

        User user = mapper.findUserByNameAndPaw(userName, password);
        sqlSession.close();
        if(user!=null){
            return user;
        }
        return null;
    }
}
