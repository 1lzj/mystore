package service;

import bean.User;

/**
 * @Auther: ��΢Цʱ����
 * @Date: 2018/9/19 17:00
 * @Description:
 */
public interface UserService {
    /**
     * �����û�������ȡһ���û�
     * @param userName
     * @return
     */
    User findUserByName (String userName);

    /**
     * ע��һ���û�
     * @param user
     * @return
     */
    boolean registerUser(User user);

    /**
     * �û�����
     * @param code
     * @return
     */
    int active(String code);

    /**
     * �û���¼
     * @param userName
     * @param password
     * @return
     */
    User login(String userName, String password);
}
