package bean;

import java.util.List;

/**
 * @Auther: ��΢Цʱ����
 * @Date: 2018/9/20 17:48
 * @Description:
 */
public class PageBean<T> {
    private List<T> list;//ҳ��Ҫչʾ�������б�
    private Integer pageNo;//��ǰҳ��
    private Integer total;//�ܹ���ҳ����
    private Integer counts;//Ҫչʾ�����������ݿ���������
    private Integer pageSize;//ÿһ��ҳ����ʾ�����ݵ�����

    public PageBean(Integer pageNo, Integer counts, Integer pageSize) {
        this.counts = counts;
        this.pageSize = pageSize;
        //�����������
        if(counts%pageSize==0){
            total = counts/pageSize;
        }else {
            total = counts/pageSize+1;
        }
        //����ҳ��
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
