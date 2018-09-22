package utils;

import javax.servlet.http.Cookie;

/**
 * @Auther: ƒ„Œ¢–¶ ±∫‹√¿
 * @Date: 2018/9/20 12:46
 * @Description:
 */
public class CooikeUtil {
    public static Cookie getCookie(String name,Cookie[] cookies){
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals(name)){
                    return cookie;
                }
            }
        }
        return null;
    }
}
