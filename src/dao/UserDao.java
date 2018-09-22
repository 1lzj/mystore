package dao;

import bean.User;

/**
 * @Auther: ��΢Цʱ����
 * @Date: 2018/9/19 17:02
 * @Description:
 */
public interface UserDao {
    /**
     * ��ȡһ���û�
     * @param userName
     * @return
     */
    User findUserByName(String userName);

    /**
     * �����û�����
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * ���ݼ������û�
     * @param code
     * @return
     */
   int updateByCode(String code);

    /**
     * ���ݣ��û����������ѯһ���û�����
     * @param userName
     * @param password
     * @return
     */
   User findUserByNameAndPaw(String userName, String password);
}
