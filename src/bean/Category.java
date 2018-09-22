package bean;

/**
 * @Auther: 你微笑时很美
 * @Date: 2018/9/20 13:11
 * @Description:
 */
public class Category {
    private String cid;//商品类别号
    private String cName;//类别名称

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
