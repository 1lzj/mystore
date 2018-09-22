package utils;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @Auther: ƒ„Œ¢–¶ ±∫‹√¿
 * @Date: 2018/9/19 21:36
 * @Description:
 */
public class MailAuthenticator extends Authenticator {
    public static String USERNAME = "";
    public static String PASSWORD = "";

    public MailAuthenticator() {
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(USERNAME, PASSWORD);
    }
}
