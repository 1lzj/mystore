package setvlet;

import bean.PageBean;
import bean.Product;
import com.alibaba.fastjson.JSON;
import service.ProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Auther: 你微笑时很美
 * @Date: 2018/9/20 16:21
 * @Description:
 */
@WebServlet("/productServlet")
public class ProductServlet extends BaseServlet{
    private ProductService service = new ProductServiceImpl();
    /**
     * 展示热门商品
     * @param request
     * @param response
     * @return
     */
    public void hostList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Product> list = service.hostList(1+"");

        String jsonString = JSON.toJSONString(list);
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonString);
        writer.flush();
        writer.close();

    }

    /**
     * 按分类查找商品
     * @param request
     * @param response
     * @return
     */
    public String findByCid(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String cid = request.getParameter("cid");
        String pageNo = request.getParameter("pageNo");

        if(pageNo==null){
            pageNo="1";
        }
        PageBean pageBean = service.findByCid(cid, pageNo);
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("cid",cid);
        request.getRequestDispatcher("product_list.jsp").forward(request,response);
        return null;
    }

    /**
     * 显示一条商品数据，通过商品Id去查询
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String findProductById(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String pid = request.getParameter("pid");

        Product product = service.findProductById(pid);
        request.setAttribute("product",product);
        request.getRequestDispatcher("product_info.jsp").forward(request,response);
        return null;
    }
}
