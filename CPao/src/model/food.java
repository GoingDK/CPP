package model;

class food {
	int foodid;
	String foodtype;
	String foodname;
	double foodprice;
	double �Ż�;
	String �ϼ�״̬;
	int shopid;
	protected food() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected food(int foodid, String foodtype, String foodname, double foodprice, double �Ż�, String �ϼ�״̬, int shopid) {
		super();
		this.foodid = foodid;
		this.foodtype = foodtype;
		this.foodname = foodname;
		this.foodprice = foodprice;
		this.�Ż� = �Ż�;
		this.�ϼ�״̬ = �ϼ�״̬;
		this.shopid = shopid;
	}
	protected int getFoodid() {
		return foodid;
	}
	protected void setFoodid(int foodid) {
		this.foodid = foodid;
	}
	protected String getFoodtype() {
		return foodtype;
	}
	protected void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}
	protected String getFoodname() {
		return foodname;
	}
	protected void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	protected double getFoodprice() {
		return foodprice;
	}
	protected void setFoodprice(double foodprice) {
		this.foodprice = foodprice;
	}
	protected double get�Ż�() {
		return �Ż�;
	}
	protected void set�Ż�(double �Ż�) {
		this.�Ż� = �Ż�;
	}
	protected String get�ϼ�״̬() {
		return �ϼ�״̬;
	}
	protected void set�ϼ�״̬(String �ϼ�״̬) {
		this.�ϼ�״̬ = �ϼ�״̬;
	}
	protected int getShopid() {
		return shopid;
	}
	protected void setShopid(int shopid) {
		this.shopid = shopid;
	}

}
