package dao;

import bean.User;

/**
 * @Auther: 你微笑时很美
 * @Date: 2018/9/19 17:02
 * @Description:
 */
public interface UserDao {
    /**
     * 获取一个用户
     * @param userName
     * @return
     */
    User findUserByName(String userName);

    /**
     * 插入用户数据
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 根据激活码用户
     * @param code
     * @return
     */
   int updateByCode(String code);

    /**
     * 根据，用户名和密码查询一个用户数据
     * @param userName
     * @param password
     * @return
     */
   User findUserByNameAndPaw(String userName, String password);
}
