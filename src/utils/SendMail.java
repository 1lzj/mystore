package utils;

/**
 * @Auther: 你微笑时很美
 * @Date: 2018/9/19 22:44
 * @Description:
 */
public class SendMail {

    public static void sendMail(String toUser,String code){
        MailOperation operation = new MailOperation();
        String user = "648183387@qq.com";
        String password = "sujuarpblmfmbffi";
        String host = "smtp.qq.com";
        String from = "648183387@qq.com";
        String to = toUser;// 收件人
        String subject = "来自天虎官方商城的激活邮件!";
        //邮箱内容
        StringBuffer sb = new StringBuffer();
        String yzm = Math.random()+"";
        sb.append("<h1>来自天虎官方商城的激活邮件:请点击下面链接激活!</h1><h3><a href='http://localhost:8080/userServlet?methodName=active&code="+code+"'>" +
                "http://192.168.43.200/userServlet?methodName=active&code="+code+"</a></h3>");
        try {
            String res = operation.sendMail(user, password, host, from, to,
                    subject, sb.toString());
            System.out.println(res);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
