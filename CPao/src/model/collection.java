package model;

class collection {
	int collectid;
	int userid;
	int shopid;
	protected collection() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected collection(int collectid, int userid, int shopid) {
		super();
		this.collectid = collectid;
		this.userid = userid;
		this.shopid = shopid;
	}
	protected int getCollectid() {
		return collectid;
	}
	protected void setCollectid(int collectid) {
		this.collectid = collectid;
	}
	protected int getUserid() {
		return userid;
	}
	protected void setUserid(int userid) {
		this.userid = userid;
	}
	protected int getShopid() {
		return shopid;
	}
	protected void setShopid(int shopid) {
		this.shopid = shopid;
	}

}
