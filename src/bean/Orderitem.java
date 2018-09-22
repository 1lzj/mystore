package bean;


public class Orderitem {

  private String itemid;//������id
  private long counts;//��Ʒ������
  private double subtotal;//��ƷС��
  private String pid;//��Ʒid
  private String oid;//������id ��ʶ�ö����������ĸ�����
  private Product product;//��Ʒ

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
