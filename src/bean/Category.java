package bean;

/**
 * @Auther: ��΢Цʱ����
 * @Date: 2018/9/20 13:11
 * @Description:
 */
public class Category {
    private String cid;//��Ʒ����
    private String cName;//�������

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid='" + cid + '\'' +
                ", cName='" + cName + '\'' +
                '}';
    }
}
