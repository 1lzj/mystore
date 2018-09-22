package bean;


import java.sql.Timestamp;
import java.util.List;

public class Order {

  private String oid;//订单号
  private java.sql.Timestamp ordertime;//下单时间
  private double total;//订单总金额
  private long state;//订单状态（支付和未支付）
  private String address;//收货地址
  private String name;//收件人名称
  private String telephone;//收件人联系方式
  private List<Orderitem> list;//订单项列表

  public List<Orderitem> getList() {
    return list;
  }

  public void setList(List<Orderitem> list) {
    this.list = list;
  }

  public Order() {
  }

  public Order(String oid, Timestamp ordertime, double total, long state, String address, String name, String telephone, String uid) {
    this.oid = oid;
    this.ordertime = ordertime;
    this.total = total;
    this.state = state;
    this.address = address;
    this.name = name;
    this.telephone = telephone;
    this.uid = uid;
  }

  private String uid;


  public String getOid() {
    return oid;
  }

  public void setOid(String oid) {
    this.oid = oid;
  }


  public java.sql.Timestamp getOrdertime() {
    return ordertime;
  }

  public void setOrdertime(java.sql.Timestamp ordertime) {
    this.ordertime = ordertime;
  }


  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }


  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

}
