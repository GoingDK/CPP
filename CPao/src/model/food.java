package model;

class food {
	int foodid;
	String foodtype;
	String foodname;
	double foodprice;
	double 优惠;
	String 上架状态;
	int shopid;
	protected food() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected food(int foodid, String foodtype, String foodname, double foodprice, double 优惠, String 上架状态, int shopid) {
		super();
		this.foodid = foodid;
		this.foodtype = foodtype;
		this.foodname = foodname;
		this.foodprice = foodprice;
		this.优惠 = 优惠;
		this.上架状态 = 上架状态;
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
	protected double get优惠() {
		return 优惠;
	}
	protected void set优惠(double 优惠) {
		this.优惠 = 优惠;
	}
	protected String get上架状态() {
		return 上架状态;
	}
	protected void set上架状态(String 上架状态) {
		this.上架状态 = 上架状态;
	}
	protected int getShopid() {
		return shopid;
	}
	protected void setShopid(int shopid) {
		this.shopid = shopid;
	}

}
