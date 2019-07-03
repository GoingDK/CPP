package model;

import java.sql.*;

import javax.swing.JOptionPane;


class Yonghu {
	static Connection conn=DataConn.getConnection();
	user u=new user();
	String upw;
	String uname;
	String uppw;
	double uphone;
	int uid;
	String uadd;
	
	protected void register(String uname,String uphone,String userpw,String useradd) {//�û�ע�Ṧ�ܡ�(��Ө)
		String sql=
				"insert into user(username,userphone,userpwd,useraddress) values('"+uname+"','"+uphone+"','"+userpw+"','"+useradd+"')";
		String sql1="select userid from user where userphone='"+uphone+"'";
		String sql2="select userid from user where username='"+uname+"'";
			Statement stmt;
			Statement stmt2;
			try {
				stmt = conn.createStatement();
				stmt2 = conn.createStatement();
			  ResultSet rs1 =stmt.executeQuery(sql1);
			  ResultSet rs2 =stmt2.executeQuery(sql2);
			  if(rs1.next()) {
				  JOptionPane.showMessageDialog(null, "���ֻ�����ע��","ע��",JOptionPane.ERROR_MESSAGE);
			  }else if(rs2.next()) {
				  JOptionPane.showMessageDialog(null, "���û�����ע��","ע��",JOptionPane.ERROR_MESSAGE);
			  }
			  else {
				  boolean rs =stmt.execute(sql);
				  JOptionPane.showMessageDialog(null, "ע��ɹ�");
			  }
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "ע��ʧ�ܣ�����д��ȷ����Ϣ��","ע��",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
	}
	

	protected void login(String userphone) {//�û���½���ܡ�(��Ө)
		String sql="select * from user where userphone='"+userphone+"'";
			try {
				Statement stmt = conn.createStatement();
		    ResultSet rs =stmt.executeQuery(sql);
			if(rs.next())
			{
		   u.setUserpwd(rs.getString("userpwd"));
		   u.setUsername(rs.getString("username"));
		   u.setUserid(rs.getInt("userid"));
		   u.setUserpaypwd(rs.getString("userpaypwd"));
		   u.setUserphone(rs.getDouble("userphone"));
		   u.setUseraddress(rs.getString("useraddress"));
		   
		   upw=u.getUserpwd();
		   uname=u.getUsername();
		   uppw=u.getUserpaypwd();
		   uphone=u.getUserphone();
		   uid=u.getUserid();
		   uadd=u.getUseraddress();
			}else {JOptionPane.showMessageDialog(null, "�û�δע��", "ע��",JOptionPane.ERROR_MESSAGE);}
			} catch (SQLException e) {
				e.printStackTrace();
			}
    }
	
	protected void shopRegister(String shopphone,String shoppwd,String shopname,String shopaddress) {//ʵ���̼���פ���ܡ�(��Ө)
		String sql=
				"insert into shop(shopname,shopaddress,shopphone,shoppwd,�̵�״̬) values('"+shopname+"','"+shopaddress+"','"+shopphone+"','"+shoppwd+"','��Ϣ')";
		String sql1="select shopid from shop where shopphone='"+shopphone+"'";
		String sql2="select shopid from shop where shopname='"+shopname+"'";
			Statement stmt;
			Statement stmt2;
			try {
				stmt = conn.createStatement();
				stmt2 = conn.createStatement();
			  ResultSet rs1 =stmt.executeQuery(sql1);
			  ResultSet rs2 =stmt2.executeQuery(sql2);
			  if(rs1.next()) {
				  JOptionPane.showMessageDialog(null, "���ֻ�����ע��","ע��",JOptionPane.ERROR_MESSAGE);
			  }else if(rs2.next()) {
				  JOptionPane.showMessageDialog(null, "���̵�����ע��","ע��",JOptionPane.ERROR_MESSAGE);
			  }
			  else {
				  boolean rs =stmt.execute(sql);
				  JOptionPane.showMessageDialog(null, "��פ�ɹ�");
			  }
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "��פʧ�ܣ�����д��ȷ����Ϣ��","ע��",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
	}

	String[] shopname;
	protected void viewshop(){//����̵��(��Ө)
		String sql="select count(shopid) from shop where �̵�״̬='����'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
		 ResultSet rs =stmt.executeQuery(sql);
		 int i=0;
		 if(rs.next()) {
			 i=rs.getInt("count(shopid)");
			 shopname=new String[i];
		 }
		 
		 String sql1="select shopname from shop where �̵�״̬='����'";
		 Statement stmt1;
		 stmt1= conn.createStatement();
		 ResultSet rs1 =stmt1.executeQuery(sql1);
		 for(int b=0;b<i;) {
		  while(rs1.next()) {
			 String shopnamee=new String(rs1.getString("shopname"));
			 shopname[b]=shopnamee;
			 b++;
		 }
		 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void searchshop(String name){//�����̵��(��Ө)
		String sql="select count(shopid) from shop where shopname LIKE '%"+name+"%'";
		Statement stmt;
			try {
				stmt = conn.createStatement();
		 ResultSet rs =stmt.executeQuery(sql);
		 int i=0;
		 if(rs.next()) {
			 i=rs.getInt("count(shopid)");
			 shopname=new String[i];
		 }
		 
		 String sql1="select shopname from shop where shopname LIKE '%"+name+"%'";
		 Statement stmt1;
		 stmt1= conn.createStatement();
		 ResultSet rs1 =stmt1.executeQuery(sql1);
		 for(int b=0;b<i;) {
		  while(rs1.next()) {
			 String shopnamee=new String(rs1.getString("shopname"));
			 shopname[b]=shopnamee;
			 b++;
		 }
		 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	protected void searchfood(String name){//����ʳƷ��(��Ө)
		String sql="select count(foodid) from food where �ϼ�״̬='���ϼ�' and foodname LIKE '%"+name+"%'";
		Statement stmt;
			try {
				stmt = conn.createStatement();
		 ResultSet rs =stmt.executeQuery(sql);
		 int i=0;
		 if(rs.next()) {
			 i=rs.getInt("count(foodid)");
			 id=new int[i];
			 foodn=new String[i];
			 price=new String[i];
			 youhui=new String[i];
			 shopname=new String[i];
		 }
		 
		 String sql1="select foodid,foodname,foodprice,�Ż�,shopname from food,shop "
		 		+ "where �ϼ�״̬='���ϼ�' and food.shopid=shop.shopid and foodname LIKE '%"+name+"%'";
		 Statement stmt1;
		 stmt1= conn.createStatement();
		 ResultSet rs1 =stmt1.executeQuery(sql1);
		 for(int b=0;b<i;) {
		  while(rs1.next()) {
			 String shopnamee=new String(rs1.getString("shopname"));
			 int idd=rs1.getInt("foodid");
			 String foodnn=new String(rs1.getString("foodname"));
			 String pricee=new String(rs1.getString("foodprice"));
			 String youhuii=new String(rs1.getString("�Ż�"));
			 id[b]=idd;
			 foodn[b]=foodnn;
			 price[b]=pricee;
			 youhui[b]=youhuii;
			 shopname[b]=shopnamee;
			 b++;
		 }
		 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	int[] id;
	String[] foodn;
	String[] price;
	String[] youhui;
	protected void vieweatfood(String shopn){//����Եġ�(��Ө)
		String sql="select count(foodid) from food,shop where �ϼ�״̬='���ϼ�' and foodtype='��' and shop.shopid=food.shopid and shop.shopname='"+shopn+"'";
		Statement stmt;
			try {
				stmt = conn.createStatement();
		 ResultSet rs =stmt.executeQuery(sql);
		 int i=0;
		 if(rs.next()) {
			 i=rs.getInt("count(foodid)");
			 id=new int[i];
			 foodn=new String[i];
			 price=new String[i];
			 youhui=new String[i];
		 }
		 
		 String sql1="select foodid,foodname,foodprice,�Ż� from food,shop where �ϼ�״̬='���ϼ�' and foodtype='��' and shop.shopid=food.shopid and shop.shopname='"+shopn+"'";
		 Statement stmt1;
		 stmt1= conn.createStatement();
		 ResultSet rs1 =stmt1.executeQuery(sql1);
		 for(int b=0;b<i;) {
		  while(rs1.next()) {
			  int idd=rs1.getInt("foodid");
			 String foodnn=new String(rs1.getString("foodname"));
			 String pricee=new String(rs1.getString("foodprice"));
			 String youhuii=new String(rs1.getString("�Ż�"));
			 id[b]=idd;
			 foodn[b]=foodnn;
			 price[b]=pricee;
			 youhui[b]=youhuii;
			 b++;
		 }
		   }		 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	protected void viewdrinkfood(String shopn){//����ȵġ�(��Ө)
		String sql="select count(foodid) from food,shop where �ϼ�״̬='���ϼ�' and foodtype='��' and shop.shopid=food.shopid and shop.shopname='"+shopn+"'";
		Statement stmt;
			try {
				stmt = conn.createStatement();
		 ResultSet rs =stmt.executeQuery(sql);
		 int i=0;
		 if(rs.next()) {
			 i=rs.getInt("count(foodid)");
			 id=new int[i];
			 foodn=new String[i];
			 price=new String[i];
			 youhui=new String[i];
		 }

		 String sql1="select foodid,foodname,foodprice,�Ż� from food,shop where �ϼ�״̬='���ϼ�' and foodtype='��' and shop.shopid=food.shopid and shop.shopname='"+shopn+"'";
		 Statement stmt1;
		 stmt1= conn.createStatement();
		 ResultSet rs1 =stmt1.executeQuery(sql1);
		 for(int b=0;b<i;) {
		  while(rs1.next()) {
			  int idd=rs1.getInt("foodid");
			 String foodnn=new String(rs1.getString("foodname"));
			 String pricee=new String(rs1.getString("foodprice"));
			 String youhuii=new String(rs1.getString("�Ż�"));
			 id[b]=idd;
			 foodn[b]=foodnn;
			 price[b]=pricee;
			 youhui[b]=youhuii;
			 b++;
		 }
		   }		 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	int[] orn;
	String[] jiedan;
	String[] xiadan;
	String[] wancheng;
	protected void viewunfinfsh(int userid){//�û��鿴δ��ɶ�����(��Ө)
		String sql="select count(ordernumber) from oorder where �������״̬='δ���' and userid='"+userid+"'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
		 ResultSet rs =stmt.executeQuery(sql);
		 int i=0;
		 if(rs.next()) {
			 i=rs.getInt("count(ordernumber)");
			 orn=new int[i];
			 foodn=new String[i];
			 price=new String[i];
			 shopname=new String[i];
			 jiedan=new String[i];
			 xiadan=new String[i]; 
		 }
		 String sql1="select ordernumber,foodname,oorder.foodprice,shopname,�����ӵ�״̬,�µ�ʱ�� from oorder,food,shop "
		 		+ "where �������״̬='δ���' and oorder.foodid=food.foodid and shop.shopid=food.shopid and userid='"+userid+"'";
		 Statement stmt1;
		 stmt1= conn.createStatement();
		 ResultSet rs1 =stmt1.executeQuery(sql1);
		 for(int b=0;b<i;) {
		  while(rs1.next()) {
			 int ornn=rs1.getInt("ordernumber");
			 String foodnn=new String(rs1.getString("foodname"));
			 String pricee=new String(rs1.getString("oorder.foodprice"));
			 String shopnamee=new String(rs1.getString("shopname"));
			 String jiedann=new String(rs1.getString("�����ӵ�״̬"));
			 String xiadann=new String(rs1.getString("�µ�ʱ��"));
			 orn[b]=ornn;
			 foodn[b]=foodnn;
			 price[b]=pricee;
			 shopname[b]=shopnamee;
			 jiedan[b]=jiedann;
			 xiadan[b]=xiadann;
			 b++;
		 }
		 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void viewfinfsh(int userid){//�û��鿴����ɶ�����(��Ө)
		String sql="select count(ordernumber) from oorder where �������״̬='�����' and userid='"+userid+"'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
		 ResultSet rs =stmt.executeQuery(sql);
		 int i=0;
		 if(rs.next()) {
			 i=rs.getInt("count(ordernumber)");
			 orn=new int[i];
			 foodn=new String[i];
			 price=new String[i];
			 shopname=new String[i];
			 wancheng=new String[i];
			 xiadan=new String[i]; 
		 }
		 String sql1="select ordernumber,foodname,oorder.foodprice,shopname,�µ�ʱ��,���ʱ�� from oorder,food,shop "
		 		+ "where �������״̬='�����' and oorder.foodid=food.foodid and shop.shopid=food.shopid and userid='"+userid+"'";
		 Statement stmt1;
		 stmt1= conn.createStatement();
		 ResultSet rs1 =stmt1.executeQuery(sql1);
		 for(int b=0;b<i;) {
		  while(rs1.next()) {
			 int ornn=rs1.getInt("ordernumber");
			 String foodnn=new String(rs1.getString("foodname"));
			 String pricee=new String(rs1.getString("oorder.foodprice"));
			 String shopnamee=new String(rs1.getString("shopname"));
			 String wanchengg=new String(rs1.getString("���ʱ��"));
			 String xiadann=new String(rs1.getString("�µ�ʱ��"));
			 orn[b]=ornn;
			 foodn[b]=foodnn;
			 price[b]=pricee;
			 shopname[b]=shopnamee;
			 wancheng[b]=wanchengg;
			 xiadan[b]=xiadann;
			 b++;
		 }
		 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void pay(String foodid,String foodprice,int userid) {//�µ���(��Ө)
		String sql="insert into oorder(foodid,foodprice,userid,�������״̬,�����ӵ�״̬,�Ƿ�ߵ�,�µ�ʱ��) values('"+foodid+"','"+foodprice+"','"+userid+"','δ���','δ�ӵ�','��',now())";
		Statement stmt;
		try {
			stmt = conn.createStatement();
		boolean rs =stmt.execute(sql);
		JOptionPane.showMessageDialog(null, "�µ��ɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void cuidan(String ordern) {//�ߵ���(��Ө)
		String sql="update oorder set �Ƿ�ߵ�='��' where ordernumber='"+ordern+"'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
		boolean rs =stmt.execute(sql);
		JOptionPane.showMessageDialog(null, "�ߵ��ɹ����ȴ��̼һظ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void quxiao(String ordern) {//ȡ��������(��Ө)
		String sql="delete from oorder where ordernumber='"+ordern+"'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
		boolean rs =stmt.execute(sql);
		JOptionPane.showMessageDialog(null, "�ɹ�ȡ������");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void finish(String ordern) {//������ɡ�(��Ө)
		String sql="update oorder set �������״̬='�����',���ʱ��=now() where �����ӵ�״̬='�ѽӵ�' and ordernumber='"+ordern+"'";
		String sql1="select ordernumber from oorder where �����ӵ�״̬='�ѽӵ�' and ordernumber='"+ordern+"'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs1 =stmt.executeQuery(sql1);
			if(rs1.next()) {
				boolean rs =stmt.execute(sql);
				JOptionPane.showMessageDialog(null, "�������");
			}else {JOptionPane.showMessageDialog(null, "�̼�δ�ӵ�", "ע��",JOptionPane.ERROR_MESSAGE);}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	String shopphone;
	protected void lianxi(String shopn) {//��ϵ�̼ҡ�(��Ө)
		String sql="select shopphone from shop where shopname='"+shopn+"'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
		ResultSet rs =stmt.executeQuery(sql);
		if(rs.next()) {
			shopphone=new String(rs.getString("shopphone"));
		   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    protected void shoucang(int userid,String shopname){//�ղ��̵��(��Ө)
		String sql1="select shopid from shop where shopname='"+shopname+"'";
		Statement stmt;
		Statement stmt1;
		try {
			stmt = conn.createStatement();
		ResultSet rs1 =stmt.executeQuery(sql1);
		if(rs1.next()) {
			int shopid=rs1.getInt("shopid");
			String sql2="select collectid from collection where userid='"+userid+"' and shopid='"+shopid+"'";
			stmt1 = conn.createStatement();
			ResultSet rs2 =stmt1.executeQuery(sql2);
			if(rs2.next()) {
				JOptionPane.showMessageDialog(null, "���̵����ղ�", "ע��",JOptionPane.ERROR_MESSAGE);
			}else {
				String sql="insert into collection(userid,shopid) values('"+userid+"','"+shopid+"')";
				boolean rs =stmt.execute(sql);
				JOptionPane.showMessageDialog(null, "�Ѽ����ҵ��ղ�");
			}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
    protected void viewshoucang(int userid){//�鿴�ղء�(��Ө)
    	String sql="select count(collectid) from collection where userid='"+userid+"'";
    	Statement stmt;
			try {
				stmt = conn.createStatement();
	            ResultSet rs =stmt.executeQuery(sql);
	            int i=0;
	          if(rs.next()) {
		            i=rs.getInt("count(collectid)");
		            shopname=new String[i];
	              }
	 String sql1="select shopname from collection,shop where collection.shopid=shop.shopid and userid='"+userid+"'";
	  Statement stmt1;
	   stmt1= conn.createStatement();
	    ResultSet rs1 =stmt1.executeQuery(sql1);
	   for(int b=0;b<i;) {
	      while(rs1.next()) {
		     String shopnamee=new String(rs1.getString("shopname"));
		     System.out.println("b:"+b);
		     System.out.println("shopnamee:"+shopnamee);
		     shopname[b]=shopnamee;
		 b++;
	 }
	 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    protected void deleteshoucang(String shopn,int userid){//ȡ���ղء�(��Ө)
    	String sql="select shopid from shop where shopname='"+shopn+"'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
		ResultSet rs =stmt.executeQuery(sql);
		if(rs.next()) {
			int shopid=rs.getInt("shopid");
			String sql1="DELETE FROM collection WHERE shopid='"+shopid+"' and userid='"+userid+"'";
			boolean rs1 =stmt.execute(sql1);
			JOptionPane.showMessageDialog(null, "��ȡ���ղ�");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    protected void comment(String comment,String ordern) {//�û����ۡ�(��Ө)
    	String sql="insert into comment(ordernumber,comment) values('"+ordern+"','"+comment+"')";
    	Statement stmt;
    	try {
	    stmt = conn.createStatement();
		boolean rs =stmt.execute(sql);
		JOptionPane.showMessageDialog(null, "���۳ɹ�");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "���Ѿ�����", "ע��",JOptionPane.ERROR_MESSAGE);
		}
    }

    String comment;
    String shcom;
    protected void viewcomment(String ordern) {//�鿴�̼һظ����ۡ�(��Ө)
    	String sql="select * from comment where ordernumber='"+ordern+"'";
    	Statement stmt;
    	try {
			stmt = conn.createStatement();
		ResultSet rs =stmt.executeQuery(sql);
		if(rs.next()) {
			comment=new String(rs.getString("comment"));
			shcom=new String(rs.getString("�̼һظ�����"));
		}else {
			JOptionPane.showMessageDialog(null, "����û����", "ע��",JOptionPane.ERROR_MESSAGE);
			comment="";shcom="";
		 }
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception ee) {
			shcom="";
			JOptionPane.showMessageDialog(null, "�̼�δ�ظ�", "ע��",JOptionPane.ERROR_MESSAGE);
		}
    }
    protected void viewcuidan(String ordern) {//�鿴�̼һظ��ߵ���(��Ө)
    	String sql="select �̼һظ��ߵ� from oorder where �Ƿ�ߵ�='��' and ordernumber='"+ordern+"'";
    	Statement stmt;
    	try {
			stmt = conn.createStatement();
		ResultSet rs =stmt.executeQuery(sql);
		if(rs.next()) {
			comment=new String(rs.getString("�̼һظ��ߵ�"));
		}else {
			JOptionPane.showMessageDialog(null, "����δ�ߵ�", "ע��",JOptionPane.ERROR_MESSAGE);
			comment="";
		 }
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception ee) {
			comment="";
			JOptionPane.showMessageDialog(null, "�̼�δ�ظ�", "ע��",JOptionPane.ERROR_MESSAGE);
		}
    }
    
    protected void changename(String username,int userid) {//�����û�����(��Ө)
    	String sql="select userid from user where username='"+username+"'";
    	String sql1="update user set username='"+username+"' where userid='"+userid+"'";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs =stmt.executeQuery(sql);
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "�û����Ѵ���", "ע��",JOptionPane.ERROR_MESSAGE);
			}else {
				boolean rs1 =stmt.execute(sql1);
			JOptionPane.showMessageDialog(null, "���ĳɹ�");
			u.setUsername(username);
			uname=u.getUsername();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    protected void changephone(String newphone,int userid) {//�����ֻ��š�(��Ө)
    	String sql="select userid from user where userphone='"+newphone+"'";
    	String sql1="update user set userphone='"+newphone+"' where userid='"+userid+"'";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs =stmt.executeQuery(sql);
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "�ֻ����ѱ�ʹ��", "ע��",JOptionPane.ERROR_MESSAGE);
			}else {
				boolean rs1 =stmt.execute(sql1);
			JOptionPane.showMessageDialog(null, "���ĳɹ�");
			Double userp=new Double(newphone);
			u.setUserphone(userp);
			uphone=u.getUserphone();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    protected void changeaddress(String address,int userid) {//�����ջ���ַ��(��Ө)
    	String sql1="update user set useraddress='"+address+"' where userid='"+userid+"'";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			boolean rs1 =stmt.execute(sql1);
			JOptionPane.showMessageDialog(null, "���ĳɹ�");
			u.setUseraddress(address);
			uadd=u.getUseraddress();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    protected void changepw(String newpw,int userid) {//���ĵ�½�����(��Ө)
    	String sql1="update user set userpwd='"+newpw+"' where userid='"+userid+"'";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			boolean rs1 =stmt.execute(sql1);
			JOptionPane.showMessageDialog(null, "���ĳɹ�");
			u.setUserpwd(newpw);
			upw=u.getUserpwd();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    protected void changePpw(String newppw,int userid) {//����֧�������(��Ө)
    	String sql1="update user set userpaypwd='"+newppw+"' where userid='"+userid+"'";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			boolean rs1 =stmt.execute(sql1);
			JOptionPane.showMessageDialog(null, "���ĳɹ�");
			u.setUserpaypwd(newppw);
			uppw=u.getUserpaypwd();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
}
