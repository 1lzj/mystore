package bean;

import java.util.List;

/**
 * @Auther: 你微笑时很美
 * @Date: 2018/9/20 17:48
 * @Description:
 */
public class PageBean<T> {
    private List<T> list;//页面要展示的数据列表
    private Integer pageNo;//当前页码
    private Integer total;//总共的页码数
    private Integer counts;//要展示的数据在数据库中总条数
    private Integer pageSize;//每一个页面显示的数据的条数

    public PageBean(Integer pageNo, Integer counts, Integer pageSize) {
        this.counts = counts;
        this.pageSize = pageSize;
        //如果可以整除
        if(counts%pageSize==0){
            total = counts/pageSize;
        }else {
            total = counts/pageSize+1;
        }
        //控制页码
        if(pageNo<=1){
            pageNo=1;
        }else if(pageNo>=total){
            pageNo=total;
        }
        this.pageNo = pageNo;

    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
