package model;

class comment {
	int ordernumber;
	String comment;
	String 商家回复评论;
	protected comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected comment(int ordernumber, String comment, String 商家回复评论) {
		super();
		this.ordernumber = ordernumber;
		this.comment = comment;
		this.商家回复评论 = 商家回复评论;
	}
	protected int getOrdernumber() {
		return ordernumber;
	}
	protected void setOrdernumber(int ordernumber) {
		this.ordernumber = ordernumber;
	}
	protected String getComment() {
		return comment;
	}
	protected void setComment(String comment) {
		this.comment = comment;
	}
	protected String get商家回复评论() {
		return 商家回复评论;
	}
	protected void set商家回复评论(String 商家回复评论) {
		this.商家回复评论 = 商家回复评论;
	}

}
