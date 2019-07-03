package model;

import java.sql.*;

import javax.swing.JOptionPane;

import MyRend.MyRender9;

class shangjia {
	static Connection conn=DataConn.getConnection();
	shop s=new shop();
	oorder o=new oorder();
	food f=new food();
	int sid;
	String spw;
	String sname;
    double sphone;
	String sadd;
	String syouhui;

	
	String o商家回复催单;
	

	
	
	
	protected void login(String shopphone) {//商家登陆√(郭莹)
		String sql="select * from shop where shopphone='"+shopphone+"'";
			try {
				Statement stmt = conn.createStatement();
		    ResultSet rs =stmt.executeQuery(sql);
			if(rs.next())
			{
		   s.setShoppwd(rs.getString("shoppwd"));
		   s.setShopname(rs.getString("shopname"));
		   s.setShopid(rs.getInt("shopid"));
		   s.setShopphone(rs.getDouble("shopphone"));
		   s.setShopaddress(rs.getString("shopaddress"));
		   
		   spw=s.getShoppwd();
		   sname=s.getShopname();
		   sphone=s.getShopphone();
		   sid=s.getShopid();
		   sadd=s.getShopaddress();
			}else {JOptionPane.showMessageDialog(null, "商户未入驻", "注意",JOptionPane.ERROR_MESSAGE);}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	String[] foodn;
	String[] price;
	String[] foodt;
	
	
	
	protected void shangjia(int shopi) {//商家上架商品//将要上架的食物的上架状态更改为已上架
		String sql="select count(foodid) from food where 上架状态='未上架' and shopid='"+shopi+"'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
		 ResultSet rs =stmt.executeQuery(sql);
		 int i=0;
		 if(rs.next()) {
			 i=rs.getInt("count(foodid)");
			 
			 foodn=new String[i];
			 price=new String[i];
			 
			 foodt=new String[i];
			  
		 }
		 String sql1="select foodname,foodprice,foodtype from food where 上架状态='未上架'and shopid='"+shopi+"' ";
		 Statement stmt1;
		 stmt1= conn.createStatement();
		 ResultSet rs1 =stmt1.executeQuery(sql1);
		 for(int b=0;b<i;) {
			  while(rs1.next()) {
				 
				 String foodnn=new String(rs1.getString("foodname"));
				 String pricee=new String(rs1.getString("foodprice"));
				
				 String foodtt=new String(rs1.getString("foodtype"));
				 foodn[b]=foodnn;
				 price[b]=pricee;
				 foodt[b]=foodtt;
				 b++;
			 }
			 }
		 
		 String sql2="update food set 上架状态='已上架' where shopid='"+shopi+"'and foodname='"+foodn+"'"; 
		 Statement stmt2;
		 stmt2 = conn.createStatement();
			boolean rs2 =stmt2.execute(sql2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	protected void xiajia(int shopi) {//商家下架商品//将要下架的食物的上架状态更改为未上架
		String sql="select count(foodid) from food where 上架状态='已上架' and shopid='"+shopi+"'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
		 ResultSet rs =stmt.executeQuery(sql);
		 int i=0;
		 if(rs.next()) {
			 i=rs.getInt("count(foodid)");
			 
			 foodn=new String[i];
			 price=new String[i];
			 
			 foodt=new String[i];
			  
		 }
		 String sql1="select foodname,foodprice,foodtype from food where 上架状态='已上架'and shopid='"+shopi+"' ";
		 Statement stmt1;
		 stmt1= conn.createStatement();
		 ResultSet rs1 =stmt1.executeQuery(sql1);
		 for(int b=0;b<i;) {
			  while(rs1.next()) {
				 
				 String foodnn=new String(rs1.getString("foodname"));
				 String pricee=new String(rs1.getString("foodprice"));
				
				 String foodtt=new String(rs1.getString("foodtype"));
				 foodn[b]=foodnn;
				 price[b]=pricee;
				 foodt[b]=foodtt;
				 b++;
			 }  
			 }
		 String sql2="update food set 上架状态='未上架' where shopid='"+shopi+"'and foodname='"+foodn+"'"; 
		 Statement stmt2;
		 stmt2 = conn.createStatement();
			boolean rs2 =stmt2.execute(sql2);
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	protected void xiajia1(String foodn) {//下架商品
		String sql="update food set 上架状态='未上架' where foodname='"+foodn+"' and shopid='"+sid+"'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			boolean rs =stmt.execute(sql);
			JOptionPane.showMessageDialog(null,"商品已下架");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void shangjia1(String foodn) {//上架商品
		String sql="update food set 上架状态='已上架' where foodname='"+foodn+"' and shopid='"+sid+"'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			boolean rs =stmt.execute(sql);
			JOptionPane.showMessageDialog(null,"商品已上架");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void addfood(String foodn,String foodpr,int foodi) {
		//商家增加美食//信息存入数据库food表中//上架状态默认为未上架//优惠默认为1
		String sql="insert into food(foodtype,foodname,foodprice,优惠,上架状态,shopid) values('吃','"+foodn+"','"+foodpr+"','1','未上架','"+foodi+"')";
		Statement stmt;
		try {
			stmt = conn.createStatement();
		boolean rs =stmt.execute(sql);
		
		//JOptionPane.showMessageDialog(null, "添加成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void addfood1(String foodn,String foodpr,int foodi) {
		//商家增加饮品
		String sql="insert into food(foodtype,foodname,foodprice,优惠,上架状态,shopid) values('喝','"+foodn+"','"+foodpr+"','1','未上架','"+foodi+"')";
		Statement stmt;
		try {
			stmt = conn.createStatement();
		boolean rs =stmt.execute(sql);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void liulaneatfood(int shopid) {
		//浏览该商店吃的食物

	}
	protected void liulandrinkfood(int shopid) {
		//浏览该商店喝的食物

	}
protected void kaidian(int shopi) {//开店//将该商店的商店状态设为 开店
		
    	String sql="update shop set 商店状态='开店' where shopid='"+shopi+"'";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			boolean rs =stmt.execute(sql);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void xiuxi(int shopi) {
		//休息
		//将该商店的商店状态设为 休息
		String sql="update shop set 商店状态='休息' where shopid='"+shopi+"'";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			boolean rs =stmt.execute(sql);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void youhui(int shopi,double 喝优惠) {
		//优惠管理//获取商家想设置的优惠折扣为多少，更改food表中优惠的系数//例如：若商家设置吃的打五折，，则将food表中的吃的所有食物的优惠改成0.5（原本是1）
		String sql="update food set 优惠='"+喝优惠+"' where shopid='"+shopi+"'and foodtype='喝'";
		
    	Statement stmt;
    	Statement stmt1;
		try {
			stmt = conn.createStatement();
			stmt1 = conn.createStatement();
			boolean rs =stmt.execute(sql);
			//JOptionPane.showMessageDialog(null, "优惠设置成功");
			f.set优惠(喝优惠);
			f.优惠=f.get优惠();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void youhui1(int shopi,double 吃优惠) {
		//优惠管理//获取商家想设置的优惠折扣为多少，更改food表中优惠的系数//例如：若商家设置吃的打五折，，则将food表中的吃的所有食物的优惠改成0.5（原本是1）
		String sql="update food set 优惠='"+吃优惠+"' where shopid='"+shopi+"'and foodtype='吃'";
		
		
    	Statement stmt;
    	Statement stmt1;
		try {
			stmt = conn.createStatement();
			stmt1 = conn.createStatement();
			boolean rs =stmt.execute(sql);
			
			
			//JOptionPane.showMessageDialog(null, "优惠设置成功");
			
			f.set优惠(吃优惠);
			f.优惠=f.get优惠();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void budazhe(int shopi) {//不打折
		String sql="update food set 优惠='1' where shopid='"+shopi+"'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			boolean rs =stmt.execute(sql);
			JOptionPane.showMessageDialog(null, "更改成功");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
		
	protected void changeshoprname(int shopi,String shopn) {//商店名修改（商店信息管理）
		
    	String sql="select shopid from shop where shopname='"+shopn+"'";
    	String sql1="update shop set shopname='"+shopn+"' where shopid='"+shopi+"'";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs =stmt.executeQuery(sql);
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "商店名已存在", "注意",JOptionPane.ERROR_MESSAGE);
			}else {
				boolean rs1 =stmt.execute(sql1);
			JOptionPane.showMessageDialog(null, "更改成功");
			s.setShopname(shopn);
			sname=s.getShopname();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

	protected void changeshoppw(String newshoppw,int sid) {
		//密码修改（商店信息管理）
		//需要输入原密码核对
		String sql1="update shop set shoppwd='"+newshoppw+"' where shopid='"+sid+"'";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			boolean rs1 =stmt.execute(sql1);
			JOptionPane.showMessageDialog(null, "更改成功");
			s.setShoppwd(newshoppw);
			spw=s.getShoppwd();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void changeshopadd(int shopi,String shopadd) {//商家地址修改（商店信息管理）
		String sql1="update shop set shopaddress='"+shopadd+"' where shopid='"+shopi+"'";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			boolean rs1 =stmt.execute(sql1);
			JOptionPane.showMessageDialog(null, "更改成功");
			s.setShopaddress(shopadd);
			sadd=s.getShopaddress();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void changeshopphone(int shopi,String shopphone) {//商家电话修改（商店信息管理）//商家表中不可有重复电话号码
		String sql="select shopid from shop where shopphone='"+shopphone+"'";
    	String sql1="update shop set shopphone='"+shopphone+"' where shopid='"+shopi+"'";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs =stmt.executeQuery(sql);
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "手机号已被使用", "注意",JOptionPane.ERROR_MESSAGE);
			}else {
				boolean rs1 =stmt.execute(sql1);
			JOptionPane.showMessageDialog(null, "更改成功");
			Double shopp=new Double(shopphone);
			s.setShopphone(shopp);
			sphone=s.getShopphone();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	int[] orn;
	String[] weijie;
	String[] cuidan;
	protected void weiding(){
		String sql="select count(ordernumber) from oorder where 订单完成状态='未完成' ";
		Statement stmt;
		try {
			stmt = conn.createStatement();
		 ResultSet rs =stmt.executeQuery(sql);
		 int i=0;
		 if(rs.next()) {
			 i=rs.getInt("count(ordernumber)");
			 orn=new int[i];
			 weijie=new String[i];
			 cuidan=new String[i];
		 }
		 String sql1="select ordernumber,订单接单状态,是否催单 from oorder where  订单完成状态='未完成'";
		 Statement stmt1;
		 stmt1= conn.createStatement();
		 ResultSet rs1 =stmt1.executeQuery(sql1);
		 for(int b=0;b<i;) {
			  while(rs1.next()) {
				 int ornn=rs1.getInt("ordernumber");
				 String weijiee=new String(rs1.getString("订单接单状态"));
				 String cuidann=new String(rs1.getString("是否催单"));
				 orn[b]=ornn;
				 weijie[b]=weijiee;
				 cuidan[b]=cuidann;
				 b++;
			  }
			  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
String[] yijie;
	
	protected void yiding(){
		String sql="select count(ordernumber) from oorder where 订单完成状态='已完成' ";
		Statement stmt;
		try {
			stmt = conn.createStatement();
		 ResultSet rs =stmt.executeQuery(sql);
		 int i=0;
		 if(rs.next()) {
			 i=rs.getInt("count(ordernumber)");
			 orn=new int[i];
			 yijie=new String[i];
			 cuidan=new String[i];
		 }
		 String sql1="select ordernumber,订单接单状态,是否催单 from oorder where  订单完成状态='已完成'";
		 Statement stmt1;
		 stmt1= conn.createStatement();
		 ResultSet rs1 =stmt1.executeQuery(sql1);
		 for(int b=0;b<i;) {
			  while(rs1.next()) {
				 int ornn=rs1.getInt("ordernumber");
				 String yijiee=new String(rs1.getString("订单接单状态"));
				 String cuidann=new String(rs1.getString("是否催单"));
				 orn[b]=ornn;
				 yijie[b]=yijiee;
				 cuidan[b]=cuidann;
				 b++;
			  }
			  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	protected void huifucomment(String ordernumber,String 商家回复评论) {//商家回复评论//评论表里的comment不为null才可以回复
//		String sql="insert into comment(ordernumber,商家回复评论) values('"+ordernumber+"','"+商家回复评论+"')";
		String sql="update comment set 商家回复评论='"+商家回复评论+"' where ordernumber='"+ordernumber+"'";
    	Statement stmt;
    	try {
	    stmt = conn.createStatement();
		boolean rs =stmt.execute(sql);
		//JOptionPane.showMessageDialog(null, "回复评论成功");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "您已经回复评论", "注意",JOptionPane.ERROR_MESSAGE);
		}
		
	}
protected void huifuchuidan(String odn,String 商家回复催单) {//商家回复催单//订单表里的 是否催单 为是才可以回复
		
	    String sql="update oorder set 商家回复催单='"+商家回复催单+"' where 是否催单='是'and ordernumber='"+odn+"'";
		Statement stmt;
		try { 
			stmt = conn.createStatement();
		boolean rs =stmt.execute(sql);
		o.set商家回复催单(商家回复催单);
		o商家回复催单=o.get商家回复催单();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
protected void jiedan(String ordern) {//接单
	String sql="update oorder set 订单接单状态='已接单'where ordernumber='"+ordern+"'";
	Statement stmt;
	try {
		stmt = conn.createStatement();
	boolean rs =stmt.execute(sql);
	//JOptionPane.showMessageDialog(null, "接单成功");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
