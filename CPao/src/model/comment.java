package model;

class comment {
	int ordernumber;
	String comment;
	String �̼һظ�����;
	protected comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected comment(int ordernumber, String comment, String �̼һظ�����) {
		super();
		this.ordernumber = ordernumber;
		this.comment = comment;
		this.�̼һظ����� = �̼һظ�����;
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
	protected String get�̼һظ�����() {
		return �̼һظ�����;
	}
	protected void set�̼һظ�����(String �̼һظ�����) {
		this.�̼һظ����� = �̼һظ�����;
	}

}
