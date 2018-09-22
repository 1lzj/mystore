package bean;


import java.sql.Timestamp;
import java.util.List;

public class Order {

  private String oid;//������
  private java.sql.Timestamp ordertime;//�µ�ʱ��
  private double total;//�����ܽ��
  private long state;//����״̬��֧����δ֧����
  private String address;//�ջ���ַ
  private String name;//�ռ�������
  private String telephone;//�ռ�����ϵ��ʽ
  private List<Orderitem> list;//�������б�

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
