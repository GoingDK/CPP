package model;

class shop {
	int shopid;
	String shopname;
	String shopaddress;
	Double shopphone;
	String shoppwd;
	String �̵�״̬;
	protected shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected shop(int shopid, String shopname, String shopaddress, double shopphone, String shoppwd, String �̵�״̬) {
		super();
		this.shopid = shopid;
		this.shopname = shopname;
		this.shopaddress = shopaddress;
		this.shopphone = shopphone;
		this.shoppwd = shoppwd;
		this.�̵�״̬ = �̵�״̬;
	}
	protected int getShopid() {
		return shopid;
	}
	protected void setShopid(int shopid) {
		this.shopid = shopid;
	}
	protected String getShopname() {
		return shopname;
	}
	protected void setShopname(String shopname) {
		this.shopname = shopname;
	}
	protected String getShopaddress() {
		return shopaddress;
	}
	protected void setShopaddress(String shopaddress) {
		this.shopaddress = shopaddress;
	}
	protected double getShopphone() {
		return shopphone;
	}
	protected void setShopphone(double shopphone) {
		this.shopphone = shopphone;
	}
	protected String getShoppwd() {
		return shoppwd;
	}
	protected void setShoppwd(String shoppwd) {
		this.shoppwd = shoppwd;
	}
	protected String get�̵�״̬() {
		return �̵�״̬;
	}
	protected void set�̵�״̬(String �̵�״̬) {
		this.�̵�״̬ = �̵�״̬;
	}

}
