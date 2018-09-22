package setvlet;

import bean.Category;
import com.alibaba.fastjson.JSON;
import service.CategoryService;
import service.impl.CategoryServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Auther: 你微笑时很美
 * @Date: 2018/9/20 13:10
 * @Description:
 */
@WebServlet("/categoryServlet")
public class CategoryServlet extends BaseServlet{
    private CategoryService service = new CategoryServiceImpl();

    /**
     * 获取所有的分类目录
     * @param request
     * @param response
     * @throws IOException
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        List<Category> list = service.findAll();
        String string = JSON.toJSONString(list);

        PrintWriter writer = response.getWriter();
        writer.write(string);
        writer.flush();;
        writer.close();
    }
}
