package bean;

/**
 * @Auther: ��΢Цʱ����
 * @Date: 2018/9/21 10:03
 * @Description:
 */
public class CartItem {
    private Product product;//��Ʒ
    private Integer count;//����
    private Double total;//С��

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
