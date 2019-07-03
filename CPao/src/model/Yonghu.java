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
	
	protected void register(String uname,String uphone,String userpw,String useradd) {//用户注册功能√(郭莹)
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
				  JOptionPane.showMessageDialog(null, "该手机号已注册","注意",JOptionPane.ERROR_MESSAGE);
			  }else if(rs2.next()) {
				  JOptionPane.showMessageDialog(null, "该用户名已注册","注意",JOptionPane.ERROR_MESSAGE);
			  }
			  else {
				  boolean rs =stmt.execute(sql);
				  JOptionPane.showMessageDialog(null, "注册成功");
			  }
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "注册失败，请填写正确的信息！","注意",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
	}
	

	protected void login(String userphone) {//用户登陆功能√(郭莹)
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
			}else {JOptionPane.showMessageDialog(null, "用户未注册", "注意",JOptionPane.ERROR_MESSAGE);}
			} catch (SQLException e) {
				e.printStackTrace();
			}
    }
	
	protected void shopRegister(String shopphone,String shoppwd,String shopname,String shopaddress) {//实现商家入驻功能√(郭莹)
		String sql=
				"insert into shop(shopname,shopaddress,shopphone,shoppwd,商店状态) values('"+shopname+"','"+shopaddress+"','"+shopphone+"','"+shoppwd+"','休息')";
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
				  JOptionPane.showMessageDialog(null, "该手机号已注册","注意",JOptionPane.ERROR_MESSAGE);
			  }else if(rs2.next()) {
				  JOptionPane.showMessageDialog(null, "该商店名已注册","注意",JOptionPane.ERROR_MESSAGE);
			  }
			  else {
				  boolean rs =stmt.execute(sql);
				  JOptionPane.showMessageDialog(null, "入驻成功");
			  }
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "入驻失败，请填写正确的信息！","注意",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
	}

	String[] shopname;
	protected void viewshop(){//浏览商店√(郭莹)
		String sql="select count(shopid) from shop where 商店状态='开店'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
		 ResultSet rs =stmt.executeQuery(sql);
		 int i=0;
		 if(rs.next()) {
			 i=rs.getInt("count(shopid)");
			 shopname=new String[i];
		 }
		 
		 String sql1="select shopname from shop where 商店状态='开店'";
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
	
	protected void searchshop(String name){//查找商店√(郭莹)
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
	protected void searchfood(String name){//查找食品√(郭莹)
		String sql="select count(foodid) from food where 上架状态='已上架' and foodname LIKE '%"+name+"%'";
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
		 
		 String sql1="select foodid,foodname,foodprice,优惠,shopname from food,shop "
		 		+ "where 上架状态='已上架' and food.shopid=shop.shopid and foodname LIKE '%"+name+"%'";
		 Statement stmt1;
		 stmt1= conn.createStatement();
		 ResultSet rs1 =stmt1.executeQuery(sql1);
		 for(int b=0;b<i;) {
		  while(rs1.next()) {
			 String shopnamee=new String(rs1.getString("shopname"));
			 int idd=rs1.getInt("foodid");
			 String foodnn=new String(rs1.getString("foodname"));
			 String pricee=new String(rs1.getString("foodprice"));
			 String youhuii=new String(rs1.getString("优惠"));
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
	protected void vieweatfood(String shopn){//浏览吃的√(郭莹)
		String sql="select count(foodid) from food,shop where 上架状态='已上架' and foodtype='吃' and shop.shopid=food.shopid and shop.shopname='"+shopn+"'";
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
		 
		 String sql1="select foodid,foodname,foodprice,优惠 from food,shop where 上架状态='已上架' and foodtype='吃' and shop.shopid=food.shopid and shop.shopname='"+shopn+"'";
		 Statement stmt1;
		 stmt1= conn.createStatement();
		 ResultSet rs1 =stmt1.executeQuery(sql1);
		 for(int b=0;b<i;) {
		  while(rs1.next()) {
			  int idd=rs1.getInt("foodid");
			 String foodnn=new String(rs1.getString("foodname"));
			 String pricee=new String(rs1.getString("foodprice"));
			 String youhuii=new String(rs1.getString("优惠"));
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
	protected void viewdrinkfood(String shopn){//浏览喝的√(郭莹)
		String sql="select count(foodid) from food,shop where 上架状态='已上架' and foodtype='喝' and shop.shopid=food.shopid and shop.shopname='"+shopn+"'";
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

		 String sql1="select foodid,foodname,foodprice,优惠 from food,shop where 上架状态='已上架' and foodtype='喝' and shop.shopid=food.shopid and shop.shopname='"+shopn+"'";
		 Statement stmt1;
		 stmt1= conn.createStatement();
		 ResultSet rs1 =stmt1.executeQuery(sql1);
		 for(int b=0;b<i;) {
		  while(rs1.next()) {
			  int idd=rs1.getInt("foodid");
			 String foodnn=new String(rs1.getString("foodname"));
			 String pricee=new String(rs1.getString("foodprice"));
			 String youhuii=new String(rs1.getString("优惠"));
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
	protected void viewunfinfsh(int userid){//用户查看未完成订单√(郭莹)
		String sql="select count(ordernumber) from oorder where 订单完成状态='未完成' and userid='"+userid+"'";
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
		 String sql1="select ordernumber,foodname,oorder.foodprice,shopname,订单接单状态,下单时间 from oorder,food,shop "
		 		+ "where 订单完成状态='未完成' and oorder.foodid=food.foodid and shop.shopid=food.shopid and userid='"+userid+"'";
		 Statement stmt1;
		 stmt1= conn.createStatement();
		 ResultSet rs1 =stmt1.executeQuery(sql1);
		 for(int b=0;b<i;) {
		  while(rs1.next()) {
			 int ornn=rs1.getInt("ordernumber");
			 String foodnn=new String(rs1.getString("foodname"));
			 String pricee=new String(rs1.getString("oorder.foodprice"));
			 String shopnamee=new String(rs1.getString("shopname"));
			 String jiedann=new String(rs1.getString("订单接单状态"));
			 String xiadann=new String(rs1.getString("下单时间"));
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
	protected void viewfinfsh(int userid){//用户查看已完成订单√(郭莹)
		String sql="select count(ordernumber) from oorder where 订单完成状态='已完成' and userid='"+userid+"'";
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
		 String sql1="select ordernumber,foodname,oorder.foodprice,shopname,下单时间,完成时间 from oorder,food,shop "
		 		+ "where 订单完成状态='已完成' and oorder.foodid=food.foodid and shop.shopid=food.shopid and userid='"+userid+"'";
		 Statement stmt1;
		 stmt1= conn.createStatement();
		 ResultSet rs1 =stmt1.executeQuery(sql1);
		 for(int b=0;b<i;) {
		  while(rs1.next()) {
			 int ornn=rs1.getInt("ordernumber");
			 String foodnn=new String(rs1.getString("foodname"));
			 String pricee=new String(rs1.getString("oorder.foodprice"));
			 String shopnamee=new String(rs1.getString("shopname"));
			 String wanchengg=new String(rs1.getString("完成时间"));
			 String xiadann=new String(rs1.getString("下单时间"));
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
	
	protected void pay(String foodid,String foodprice,int userid) {//下单√(郭莹)
		String sql="insert into oorder(foodid,foodprice,userid,订单完成状态,订单接单状态,是否催单,下单时间) values('"+foodid+"','"+foodprice+"','"+userid+"','未完成','未接单','否',now())";
		Statement stmt;
		try {
			stmt = conn.createStatement();
		boolean rs =stmt.execute(sql);
		JOptionPane.showMessageDialog(null, "下单成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void cuidan(String ordern) {//催单√(郭莹)
		String sql="update oorder set 是否催单='是' where ordernumber='"+ordern+"'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
		boolean rs =stmt.execute(sql);
		JOptionPane.showMessageDialog(null, "催单成功，等待商家回复");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void quxiao(String ordern) {//取消订单√(郭莹)
		String sql="delete from oorder where ordernumber='"+ordern+"'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
		boolean rs =stmt.execute(sql);
		JOptionPane.showMessageDialog(null, "成功取消订单");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void finish(String ordern) {//订单完成√(郭莹)
		String sql="update oorder set 订单完成状态='已完成',完成时间=now() where 订单接单状态='已接单' and ordernumber='"+ordern+"'";
		String sql1="select ordernumber from oorder where 订单接单状态='已接单' and ordernumber='"+ordern+"'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs1 =stmt.executeQuery(sql1);
			if(rs1.next()) {
				boolean rs =stmt.execute(sql);
				JOptionPane.showMessageDialog(null, "订单完成");
			}else {JOptionPane.showMessageDialog(null, "商家未接单", "注意",JOptionPane.ERROR_MESSAGE);}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	String shopphone;
	protected void lianxi(String shopn) {//联系商家√(郭莹)
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
    protected void shoucang(int userid,String shopname){//收藏商店√(郭莹)
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
				JOptionPane.showMessageDialog(null, "该商店已收藏", "注意",JOptionPane.ERROR_MESSAGE);
			}else {
				String sql="insert into collection(userid,shopid) values('"+userid+"','"+shopid+"')";
				boolean rs =stmt.execute(sql);
				JOptionPane.showMessageDialog(null, "已加入我的收藏");
			}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
    protected void viewshoucang(int userid){//查看收藏√(郭莹)
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
    protected void deleteshoucang(String shopn,int userid){//取消收藏√(郭莹)
    	String sql="select shopid from shop where shopname='"+shopn+"'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
		ResultSet rs =stmt.executeQuery(sql);
		if(rs.next()) {
			int shopid=rs.getInt("shopid");
			String sql1="DELETE FROM collection WHERE shopid='"+shopid+"' and userid='"+userid+"'";
			boolean rs1 =stmt.execute(sql1);
			JOptionPane.showMessageDialog(null, "已取消收藏");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    protected void comment(String comment,String ordern) {//用户评价√(郭莹)
    	String sql="insert into comment(ordernumber,comment) values('"+ordern+"','"+comment+"')";
    	Statement stmt;
    	try {
	    stmt = conn.createStatement();
		boolean rs =stmt.execute(sql);
		JOptionPane.showMessageDialog(null, "评论成功");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "您已经评论", "注意",JOptionPane.ERROR_MESSAGE);
		}
    }

    String comment;
    String shcom;
    protected void viewcomment(String ordern) {//查看商家回复评论√(郭莹)
    	String sql="select * from comment where ordernumber='"+ordern+"'";
    	Statement stmt;
    	try {
			stmt = conn.createStatement();
		ResultSet rs =stmt.executeQuery(sql);
		if(rs.next()) {
			comment=new String(rs.getString("comment"));
			shcom=new String(rs.getString("商家回复评论"));
		}else {
			JOptionPane.showMessageDialog(null, "您还没评论", "注意",JOptionPane.ERROR_MESSAGE);
			comment="";shcom="";
		 }
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception ee) {
			shcom="";
			JOptionPane.showMessageDialog(null, "商家未回复", "注意",JOptionPane.ERROR_MESSAGE);
		}
    }
    protected void viewcuidan(String ordern) {//查看商家回复催单√(郭莹)
    	String sql="select 商家回复催单 from oorder where 是否催单='是' and ordernumber='"+ordern+"'";
    	Statement stmt;
    	try {
			stmt = conn.createStatement();
		ResultSet rs =stmt.executeQuery(sql);
		if(rs.next()) {
			comment=new String(rs.getString("商家回复催单"));
		}else {
			JOptionPane.showMessageDialog(null, "您还未催单", "注意",JOptionPane.ERROR_MESSAGE);
			comment="";
		 }
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception ee) {
			comment="";
			JOptionPane.showMessageDialog(null, "商家未回复", "注意",JOptionPane.ERROR_MESSAGE);
		}
    }
    
    protected void changename(String username,int userid) {//更改用户名√(郭莹)
    	String sql="select userid from user where username='"+username+"'";
    	String sql1="update user set username='"+username+"' where userid='"+userid+"'";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs =stmt.executeQuery(sql);
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "用户名已存在", "注意",JOptionPane.ERROR_MESSAGE);
			}else {
				boolean rs1 =stmt.execute(sql1);
			JOptionPane.showMessageDialog(null, "更改成功");
			u.setUsername(username);
			uname=u.getUsername();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    protected void changephone(String newphone,int userid) {//更改手机号√(郭莹)
    	String sql="select userid from user where userphone='"+newphone+"'";
    	String sql1="update user set userphone='"+newphone+"' where userid='"+userid+"'";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs =stmt.executeQuery(sql);
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "手机号已被使用", "注意",JOptionPane.ERROR_MESSAGE);
			}else {
				boolean rs1 =stmt.execute(sql1);
			JOptionPane.showMessageDialog(null, "更改成功");
			Double userp=new Double(newphone);
			u.setUserphone(userp);
			uphone=u.getUserphone();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    protected void changeaddress(String address,int userid) {//更改收货地址√(郭莹)
    	String sql1="update user set useraddress='"+address+"' where userid='"+userid+"'";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			boolean rs1 =stmt.execute(sql1);
			JOptionPane.showMessageDialog(null, "更改成功");
			u.setUseraddress(address);
			uadd=u.getUseraddress();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    protected void changepw(String newpw,int userid) {//更改登陆密码√(郭莹)
    	String sql1="update user set userpwd='"+newpw+"' where userid='"+userid+"'";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			boolean rs1 =stmt.execute(sql1);
			JOptionPane.showMessageDialog(null, "更改成功");
			u.setUserpwd(newpw);
			upw=u.getUserpwd();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    protected void changePpw(String newppw,int userid) {//更改支付密码√(郭莹)
    	String sql1="update user set userpaypwd='"+newppw+"' where userid='"+userid+"'";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			boolean rs1 =stmt.execute(sql1);
			JOptionPane.showMessageDialog(null, "更改成功");
			u.setUserpaypwd(newppw);
			uppw=u.getUserpaypwd();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
}
