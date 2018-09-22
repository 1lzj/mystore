package bean;


public class Product {

  private String pid;//商品id，唯一标识符
  private String pname;//商品名称
  private double marketPrice;//市场价格
  private double shopPrice;//商城价格
  private String pimage;//商品图片
  private java.sql.Date pdate;//上架时间
  private long isHot;//是否是热门商品
  private String pdesc;//商品描述
  private long pflag;//商品标志
  private String cid;//商品类别，关连于Category


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
