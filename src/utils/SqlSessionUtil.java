package utils;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;


/**
 * @Auther: ƒ„Œ¢–¶ ±∫‹√¿
 * @Date: 2018/9/16 11:42
 * @Description:
 */
public class SqlSessionUtil {
    public static SqlSession getSqlSession(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatiesConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            return  session;
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;

    }
    @Test
    public void test(){
        System.out.println(getSqlSession());
    }
}
