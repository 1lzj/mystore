package bean;


public class Orderitem {

  private String itemid;//订单项id
  private long counts;//商品的数量
  private double subtotal;//商品小计
  private String pid;//商品id
  private String oid;//订单的id 标识该订单项属于哪个订单
  private Product product;//商品

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public long getCounts() {
    return counts;
  }

  public void setCounts(long counts) {
    this.counts = counts;
  }

  public Orderitem(String itemid, long counts, double subtotal, String pid, String oid) {
    this.itemid = itemid;
    this.counts = counts;
    this.subtotal = subtotal;
    this.pid = pid;
    this.oid = oid;
  }

  public Orderitem() {
  }

  public String getItemid() {
    return itemid;
  }

  public void setItemid(String itemid) {
    this.itemid = itemid;
  }


  public long getCount() {
    return counts;
  }

  public void setCount(long count) {
    this.counts = count;
  }


  public double getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(double subtotal) {
    this.subtotal = subtotal;
  }


  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }


  public String getOid() {
    return oid;
  }

  public void setOid(String oid) {
    this.oid = oid;
  }

}
