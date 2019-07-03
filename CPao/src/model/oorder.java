package model;

class oorder {
	int ordernumber;
	int foodid;
	double foodprice;
	int userid;
	String 订单完成状态;
	String 订单接单状态;
	String 是否催单;
	String 商家回复催单;
	String 下单时间;
	String 完成时间;
	protected oorder() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected oorder(int ordernumber, int foodid, double foodprice, int userid, String 订单完成状态, String 订单接单状态,
			String 是否催单, String 商家回复催单, String 下单时间, String 完成时间) {
		super();
		this.ordernumber = ordernumber;
		this.foodid = foodid;
		this.foodprice = foodprice;
		this.userid = userid;
		this.订单完成状态 = 订单完成状态;
		this.订单接单状态 = 订单接单状态;
		this.是否催单 = 是否催单;
		this.商家回复催单 = 商家回复催单;
		this.下单时间 = 下单时间;
		this.完成时间 = 完成时间;
	}
	protected int getOrdernumber() {
		return ordernumber;
	}
	protected void setOrdernumber(int ordernumber) {
		this.ordernumber = ordernumber;
	}
	protected int getFoodid() {
		return foodid;
	}
	protected void setFoodid(int foodid) {
		this.foodid = foodid;
	}
	protected double getFoodprice() {
		return foodprice;
	}
	protected void setFoodprice(double foodprice) {
		this.foodprice = foodprice;
	}
	protected int getUserid() {
		return userid;
	}
	protected void setUserid(int userid) {
		this.userid = userid;
	}
	protected String get订单完成状态() {
		return 订单完成状态;
	}
	protected void set订单完成状态(String 订单完成状态) {
		this.订单完成状态 = 订单完成状态;
	}
	protected String get订单接单状态() {
		return 订单接单状态;
	}
	protected void set订单接单状态(String 订单接单状态) {
		this.订单接单状态 = 订单接单状态;
	}
	protected String get是否催单() {
		return 是否催单;
	}
	protected void set是否催单(String 是否催单) {
		this.是否催单 = 是否催单;
	}
	protected String get商家回复催单() {
		return 商家回复催单;
	}
	protected void set商家回复催单(String 商家回复催单) {
		this.商家回复催单 = 商家回复催单;
	}
	protected String get下单时间() {
		return 下单时间;
	}
	protected void set下单时间(String 下单时间) {
		this.下单时间 = 下单时间;
	}
	protected String get完成时间() {
		return 完成时间;
	}
	protected void set完成时间(String 完成时间) {
		this.完成时间 = 完成时间;
	}

}
