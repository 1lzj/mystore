package setvlet;

import bean.CartItem;
import bean.Order;
import bean.Orderitem;
import bean.User;
import org.junit.Test;
import service.OderService;
import service.impl.OderServiceImpl;
import utils.PaymentUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

/**
 * @Auther: 你微笑时很美
 * @Date: 2018/9/21 15:02
 * @Description:
 */
@WebServlet("/oderServlet")
public class OderServlet extends BaseServlet {
    private OderService service = new OderServiceImpl();
    public String addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单提交的基本收件人信息
        String oid = request.getParameter("oid");
        String address = request.getParameter("address");
        String name = request.getParameter("name");
        String telephone = request.getParameter("telephone");
        //获取要支付的银行编号
        String pd_frpId = request.getParameter("pd_FrpId");


        //获取提交订单的用户信息
        User user = (User) request.getSession().getAttribute("user");
        //获取当前购物车中的信息
        Map<String, CartItem> cart = (Map<String, CartItem>) request.getSession().getAttribute("cart");
        //待计算的订单总金额
        double total=0d;

        List<Orderitem> list = new ArrayList<>();

        Set<Map.Entry<String, CartItem>> entries = cart.entrySet();
        //分别将购物车中的所有数据，封装为一个订单项，插入数据库中
        for(Map.Entry<String, CartItem> entry:entries){
            String itemid = UUID.randomUUID().toString().replaceAll("-","");
            long count = entry.getValue().getCount();
            double subtotal = entry.getValue().getTotal();
            String pid = entry.getKey();
            String uid = user.getUid();
            Orderitem orderitem = new Orderitem(itemid, count, subtotal, pid, oid);
            list.add(orderitem);
            total+=entry.getValue().getTotal();
        }
        Order order = new Order(oid, new Timestamp(System.currentTimeMillis()), total, 0, address, name, telephone, user.getUid());
        boolean b = service.addOrder(order);
        //将购物车中的所有订单项全部插入数据库
        list.forEach(orderitem->{
            service.addOrderItem(orderitem);
        });



        if(b){
            //下单成功,跳转到成功页面，清除当前session中的购物车
            request.getSession().removeAttribute("cart");
            //TODO 支付操作
            //需要重定向的地址


            String p0_Cmd = "Buy";
            String p1_MerId = "10001126856";// 真实
            String p2_Order = oid;
            String p3_Amt = "0.01";
            String p4_Cur = "CNY";
            String p5_Pid = "";
            String p6_Pcat = "";
            String p7_Pdesc = "";
            String p8_Url = "http://localhost:8080/oderServlet?methodName=callBack";
            String p9_SAF = "";
            String pa_MP = "";
            String pd_FrpId = pd_frpId;
            String pr_NeedResponse = "";

            String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
            String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur,
                    p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId,
                    pr_NeedResponse, keyValue);

            String url = "https://www.yeepay.com/app-merchant-proxy/node?pd_FrpId="+pd_FrpId+
                    "&p0_Cmd="+p0_Cmd+
                    "&p1_MerId="+p1_MerId+
                    "&p2_Order="+p2_Order+
                    "&p3_Amt="+p3_Amt+
                    "&p4_Cur="+p4_Cur+
                    "&p5_Pid="+p5_Pid+
                    "&p6_Pcat="+p6_Pcat+
                    "&p7_Pdesc="+p7_Pdesc+
                    "&p8_Url="+p8_Url+
                    "&p9_SAF="+p9_SAF+
                    "&pa_MP="+pa_MP+
                    "&pr_NeedResponse="+pr_NeedResponse+
                    "&hmac="+hmac;
            //重定向到第三方支付平台
            response.sendRedirect(url);
//            request.setAttribute("mesg","下单成功！<a href=cartServlet?methodName=myCart&uid="+user.getUid() +">查看我的订单</a>");
//            request.getRequestDispatcher("info.jsp").forward(request,response);
//
        }else{
            //下单失败
            request.setAttribute("mesg","嘤嘤嘤，服务器崩溃了");
            request.getRequestDispatcher("info.jsp").forward(request,response);
        }
        return null;
    }

    /**
     * 想要易宝支付的结果
     * @param request
     * @param response
     * @return
     */
    public String callBack(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        // 验证请求来源和数据有效性
        // 阅读支付结果参数说明
        // System.out.println("==============================================");
        String p1_MerId = request.getParameter("p1_MerId");
        String r0_Cmd = request.getParameter("r0_Cmd");
        String r1_Code = request.getParameter("r1_Code");
        String r2_TrxId = request.getParameter("r2_TrxId");
        String r3_Amt = request.getParameter("r3_Amt");
        String r4_Cur = request.getParameter("r4_Cur");
        String r5_Pid = request.getParameter("r5_Pid");
        String r6_Order = request.getParameter("r6_Order");
        String r7_Uid = request.getParameter("r7_Uid");
        String r8_MP = request.getParameter("r8_MP");
        String r9_BType = request.getParameter("r9_BType");
        String rb_BankId = request.getParameter("rb_BankId");
        String ro_BankOrderId = request.getParameter("ro_BankOrderId");
        String rp_PayDate = request.getParameter("rp_PayDate");
        String rq_CardNo = request.getParameter("rq_CardNo");
        String ru_Trxtime = request.getParameter("ru_Trxtime");

        // hmac
        String hmac = request.getParameter("hmac");
        // 利用本地密钥和加密算法 加密数据
        String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
        boolean isValid = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd,
                r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid,
                r8_MP, r9_BType, keyValue);
        if (isValid) {
            // 有效
            if (r9_BType.equals("1")) {
                service.updateStateByOid(r6_Order,1);
                // 浏览器重定向
                request.setAttribute("mesg","支付成功");
                request.getRequestDispatcher("info.jsp").forward(request,response);
            } else if (r9_BType.equals("2")) {
                // 修改订单状态:
                // 服务器点对点，来自于易宝的通知
                System.out.println("收到易宝通知，修改订单状态！");//
                // 回复给易宝success，如果不回复，易宝会一直通知
                response.getWriter().print("success");
            }

        } else {
            request.setAttribute("mesg","小伙子有点东西哦！");
            request.getRequestDispatcher("info.jsp").forward(request,response);
        }
        return null;
    }

    @Test
    public void test(){
        service.updateStateByOid("793e900f795f4fbb9eac0d4ccf8cd44f",1);
    }
}
