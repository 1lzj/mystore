package bean;


public class Product {

  private String pid;//��Ʒid��Ψһ��ʶ��
  private String pname;//��Ʒ����
  private double marketPrice;//�г��۸�
  private double shopPrice;//�̳Ǽ۸�
  private String pimage;//��ƷͼƬ
  private java.sql.Date pdate;//�ϼ�ʱ��
  private long isHot;//�Ƿ���������Ʒ
  private String pdesc;//��Ʒ����
  private long pflag;//��Ʒ��־
  private String cid;//��Ʒ��𣬹�����Category


  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }


  public String getPname() {
    return pname;
  }

  public void setPname(String pname) {
    this.pname = pname;
  }


  public double getMarketPrice() {
    return marketPrice;
  }

  public void setMarketPrice(double marketPrice) {
    this.marketPrice = marketPrice;
  }


  public double getShopPrice() {
    return shopPrice;
  }

  public void setShopPrice(double shopPrice) {
    this.shopPrice = shopPrice;
  }


  public String getPimage() {
    return pimage;
  }

  public void setPimage(String pimage) {
    this.pimage = pimage;
  }


  public java.sql.Date getPdate() {
    return pdate;
  }

  public void setPdate(java.sql.Date pdate) {
    this.pdate = pdate;
  }


  public long getIsHot() {
    return isHot;
  }

  public void setIsHot(long isHot) {
    this.isHot = isHot;
  }


  public String getPdesc() {
    return pdesc;
  }

  public void setPdesc(String pdesc) {
    this.pdesc = pdesc;
  }


  public long getPflag() {
    return pflag;
  }

  public void setPflag(long pflag) {
    this.pflag = pflag;
  }


  public String getCid() {
    return cid;
  }

  public void setCid(String cid) {
    this.cid = cid;
  }

}
