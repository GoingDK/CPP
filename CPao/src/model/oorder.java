package model;

class oorder {
	int ordernumber;
	int foodid;
	double foodprice;
	int userid;
	String �������״̬;
	String �����ӵ�״̬;
	String �Ƿ�ߵ�;
	String �̼һظ��ߵ�;
	String �µ�ʱ��;
	String ���ʱ��;
	protected oorder() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected oorder(int ordernumber, int foodid, double foodprice, int userid, String �������״̬, String �����ӵ�״̬,
			String �Ƿ�ߵ�, String �̼һظ��ߵ�, String �µ�ʱ��, String ���ʱ��) {
		super();
		this.ordernumber = ordernumber;
		this.foodid = foodid;
		this.foodprice = foodprice;
		this.userid = userid;
		this.�������״̬ = �������״̬;
		this.�����ӵ�״̬ = �����ӵ�״̬;
		this.�Ƿ�ߵ� = �Ƿ�ߵ�;
		this.�̼һظ��ߵ� = �̼һظ��ߵ�;
		this.�µ�ʱ�� = �µ�ʱ��;
		this.���ʱ�� = ���ʱ��;
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
	protected String get�������״̬() {
		return �������״̬;
	}
	protected void set�������״̬(String �������״̬) {
		this.�������״̬ = �������״̬;
	}
	protected String get�����ӵ�״̬() {
		return �����ӵ�״̬;
	}
	protected void set�����ӵ�״̬(String �����ӵ�״̬) {
		this.�����ӵ�״̬ = �����ӵ�״̬;
	}
	protected String get�Ƿ�ߵ�() {
		return �Ƿ�ߵ�;
	}
	protected void set�Ƿ�ߵ�(String �Ƿ�ߵ�) {
		this.�Ƿ�ߵ� = �Ƿ�ߵ�;
	}
	protected String get�̼һظ��ߵ�() {
		return �̼һظ��ߵ�;
	}
	protected void set�̼һظ��ߵ�(String �̼һظ��ߵ�) {
		this.�̼һظ��ߵ� = �̼һظ��ߵ�;
	}
	protected String get�µ�ʱ��() {
		return �µ�ʱ��;
	}
	protected void set�µ�ʱ��(String �µ�ʱ��) {
		this.�µ�ʱ�� = �µ�ʱ��;
	}
	protected String get���ʱ��() {
		return ���ʱ��;
	}
	protected void set���ʱ��(String ���ʱ��) {
		this.���ʱ�� = ���ʱ��;
	}

}
