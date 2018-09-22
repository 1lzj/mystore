package setvlet;

import bean.CartItem;
import bean.Order;
import bean.PageBean;
import bean.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: ��΢Цʱ����
 * @Date: 2018/9/21 12:27
 * @Description:
 */
@WebServlet("/cartServlet")
public class CartServlet extends BaseServlet {
    private ProductService service = new ProductServiceImpl();
    /**
     * ��ӹ��ﳵ
     * @param request
     * @param response
     * @return
     */
    public String addCart(HttpServletRequest request, HttpServletResponse response){
        Object user = request.getSession().getAttribute("user");

        String pid = request.getParameter("pid");
        String count = request.getParameter("count");
        //��ȡSession�еĹ��ﳵ
        Map<String, CartItem> cart = (Map<String, CartItem>) request.getSession().getAttribute("cart");
        Product product = service.findProductById(pid);
        //�����Ϊ��
        if(cart!=null){
            //�޸���Ʒ������
            if(cart.get(pid)!=null){
                CartItem cartItem = cart.get(pid);
                cartItem.setCount(cartItem.getCount()+Integer.parseInt(count));
                cartItem.setTotal(cartItem.getCount()*cartItem.getProduct().getShopPrice());
            }else{
                CartItem item = new CartItem();
                item.setCount(Integer.parseInt(count));
                item.setProduct(product);
                item.setTotal(item.getCount()*item.getProduct().getShopPrice());
                cart.put(pid,item);
            }

        }else{
            //û�й��ﳵ������һ�����ﳵ
            cart = new HashMap<>();
            CartItem item = new CartItem();
            item.setCount(Integer.parseInt(count));
            item.setProduct(product);
            item.setTotal(item.getCount()*item.getProduct().getShopPrice());
            cart.put(pid,item);
            request.getSession().setAttribute("cart",cart);
        }
        return "cart";
    }

    /**
     * �첽�����޸Ĺ��ﳵ����ƷС�� ���ܽ��
     * @param request
     * @param response
     */
    public void updateCount(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String pid = request.getParameter("pid");
        //�޸ĺ����Ʒ����
        String count = request.getParameter("count");

        Map<String,CartItem> cart = (Map<String, CartItem>) request.getSession().getAttribute("cart");

        //�޸Ĺ��ﳵ�е���Ʒ������С��
        CartItem cartItem = cart.get(pid);
        cartItem.setCount(Integer.parseInt(count));
        cartItem.setTotal(Integer.parseInt(count)*cartItem.getProduct().getShopPrice());

        Double total = cartItem.getTotal();
        Double sum = 0D;
        //�������ﳵ�е���Ʒ���ۼ�ÿһ����Ʒ��С��
        Set<Map.Entry<String, CartItem>> entries = cart.entrySet();
        for(Map.Entry<String, CartItem> entry:entries){
            sum+=entry.getValue().getTotal();
        }
        //ƴ�ӳ�ָ����ʽ���ַ��������͸�ҳ��
        String result = total+"-"+sum;
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();

    }

    /**
     * �鿴�ҵĹ��ﳵ
     * @param request
     * @param response
     * @return
     */
    public String myCart(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");
        String pageNo = request.getParameter("pageNo");
        if(pageNo==null){
            pageNo="1";
        }
        PageBean pageBean = service.findMyOrdersByUid(uid, pageNo,"3");

        request.setAttribute("pageBean",pageBean);
        request.setAttribute("uid",uid);
        request.getRequestDispatcher("order_list.jsp").forward(request,response);
        return null;
    }

    /**
     * ɾ�����ﳵ�е�һ����Ʒ
     * @param request
     * @param response
     * @return
     */
    public String deleteProduct(HttpServletRequest request,HttpServletResponse response){
        String pid = request.getParameter("pid");

        Map<String,CartItem> cart = (Map<String, CartItem>) request.getSession().getAttribute("cart");

        cart.remove(pid);
        return "cart";
    }

    /**
     * ��չ��ﳵ
     * @param request
     * @param response
     * @return
     */
    public String clearCart(HttpServletRequest request,HttpServletResponse response){
        request.getSession().removeAttribute("cart");
        return "cart";
    }
}
