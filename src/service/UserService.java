package service;

import bean.User;

/**
 * @Auther: 你微笑时很美
 * @Date: 2018/9/19 17:00
 * @Description:
 */
public interface UserService {
    /**
     * 根据用户名，获取一个用户
     * @param userName
     * @return
     */
    User findUserByName (String userName);

    /**
     * 注册一个用户
     * @param user
     * @return
     */
    boolean registerUser(User user);

    /**
     * 用户激活
     * @param code
     * @return
     */
    int active(String code);

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    User login(String userName, String password);
}
