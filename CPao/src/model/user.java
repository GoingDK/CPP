package model;

class user {
	int userid;
	String username;
	Double userphone;
	String userpwd;
	String userpaypwd;
	String useraddress;
	protected user() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected user(int userid, String username, Double userphone, String userpwd, String userpaypwd,
			String useraddress) {
		super();
		this.userid = userid;
		this.username = username;
		this.userphone = userphone;
		this.userpwd = userpwd;
		this.userpaypwd = userpaypwd;
		this.useraddress = useraddress;
	}
	protected int getUserid() {
		return userid;
	}
	protected void setUserid(int userid) {
		this.userid = userid;
	}
	protected String getUsername() {
		return username;
	}
	protected void setUsername(String username) {
		this.username = username;
	}
	protected Double getUserphone() {
		return userphone;
	}
	protected void setUserphone(Double userphone) {
		this.userphone = userphone;
	}
	protected String getUserpwd() {
		return userpwd;
	}
	protected void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	protected String getUserpaypwd() {
		return userpaypwd;
	}
	protected void setUserpaypwd(String userpaypwd) {
		this.userpaypwd = userpaypwd;
	}
	protected String getUseraddress() {
		return useraddress;
	}
	protected void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

}
