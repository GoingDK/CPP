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

	
	String o�̼һظ��ߵ�;
	

	
	
	
	protected void login(String shopphone) {//�̼ҵ�½��(��Ө)
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
			}else {JOptionPane.showMessageDialog(null, "�̻�δ��פ", "ע��",JOptionPane.ERROR_MESSAGE);}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	String[] foodn;
	String[] price;
	String[] foodt;
	
	
	
	protected void shangjia(int shopi) {//�̼��ϼ���Ʒ//��Ҫ�ϼܵ�ʳ����ϼ�״̬����Ϊ���ϼ�
		String sql="select count(foodid) from food where �ϼ�״̬='δ�ϼ�' and shopid='"+shopi+"'";
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
		 String sql1="select foodname,foodprice,foodtype from food where �ϼ�״̬='δ�ϼ�'and shopid='"+shopi+"' ";
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
		 
		 String sql2="update food set �ϼ�״̬='���ϼ�' where shopid='"+shopi+"'and foodname='"+foodn+"'"; 
		 Statement stmt2;
		 stmt2 = conn.createStatement();
			boolean rs2 =stmt2.execute(sql2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	protected void xiajia(int shopi) {//�̼��¼���Ʒ//��Ҫ�¼ܵ�ʳ����ϼ�״̬����Ϊδ�ϼ�
		String sql="select count(foodid) from food where �ϼ�״̬='���ϼ�' and shopid='"+shopi+"'";
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
		 String sql1="select foodname,foodprice,foodtype from food where �ϼ�״̬='���ϼ�'and shopid='"+shopi+"' ";
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
		 String sql2="update food set �ϼ�״̬='δ�ϼ�' where shopid='"+shopi+"'and foodname='"+foodn+"'"; 
		 Statement stmt2;
		 stmt2 = conn.createStatement();
			boolean rs2 =stmt2.execute(sql2);
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	protected void xiajia1(String foodn) {//�¼���Ʒ
		String sql="update food set �ϼ�״̬='δ�ϼ�' where foodname='"+foodn+"' and shopid='"+sid+"'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			boolean rs =stmt.execute(sql);
			JOptionPane.showMessageDialog(null,"��Ʒ���¼�");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void shangjia1(String foodn) {//�ϼ���Ʒ
		String sql="update food set �ϼ�״̬='���ϼ�' where foodname='"+foodn+"' and shopid='"+sid+"'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			boolean rs =stmt.execute(sql);
			JOptionPane.showMessageDialog(null,"��Ʒ���ϼ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void addfood(String foodn,String foodpr,int foodi) {
		//�̼�������ʳ//��Ϣ�������ݿ�food����//�ϼ�״̬Ĭ��Ϊδ�ϼ�//�Ż�Ĭ��Ϊ1
		String sql="insert into food(foodtype,foodname,foodprice,�Ż�,�ϼ�״̬,shopid) values('��','"+foodn+"','"+foodpr+"','1','δ�ϼ�','"+foodi+"')";
		Statement stmt;
		try {
			stmt = conn.createStatement();
		boolean rs =stmt.execute(sql);
		
		//JOptionPane.showMessageDialog(null, "��ӳɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void addfood1(String foodn,String foodpr,int foodi) {
		//�̼�������Ʒ
		String sql="insert into food(foodtype,foodname,foodprice,�Ż�,�ϼ�״̬,shopid) values('��','"+foodn+"','"+foodpr+"','1','δ�ϼ�','"+foodi+"')";
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
		//������̵�Ե�ʳ��

	}
	protected void liulandrinkfood(int shopid) {
		//������̵�ȵ�ʳ��

	}
protected void kaidian(int shopi) {//����//�����̵���̵�״̬��Ϊ ����
		
    	String sql="update shop set �̵�״̬='����' where shopid='"+shopi+"'";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			boolean rs =stmt.execute(sql);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void xiuxi(int shopi) {
		//��Ϣ
		//�����̵���̵�״̬��Ϊ ��Ϣ
		String sql="update shop set �̵�״̬='��Ϣ' where shopid='"+shopi+"'";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			boolean rs =stmt.execute(sql);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void youhui(int shopi,double ���Ż�) {
		//�Żݹ���//��ȡ�̼������õ��Ż��ۿ�Ϊ���٣�����food�����Żݵ�ϵ��//���磺���̼����óԵĴ����ۣ�����food���еĳԵ�����ʳ����Żݸĳ�0.5��ԭ����1��
		String sql="update food set �Ż�='"+���Ż�+"' where shopid='"+shopi+"'and foodtype='��'";
		
    	Statement stmt;
    	Statement stmt1;
		try {
			stmt = conn.createStatement();
			stmt1 = conn.createStatement();
			boolean rs =stmt.execute(sql);
			//JOptionPane.showMessageDialog(null, "�Ż����óɹ�");
			f.set�Ż�(���Ż�);
			f.�Ż�=f.get�Ż�();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void youhui1(int shopi,double ���Ż�) {
		//�Żݹ���//��ȡ�̼������õ��Ż��ۿ�Ϊ���٣�����food�����Żݵ�ϵ��//���磺���̼����óԵĴ����ۣ�����food���еĳԵ�����ʳ����Żݸĳ�0.5��ԭ����1��
		String sql="update food set �Ż�='"+���Ż�+"' where shopid='"+shopi+"'and foodtype='��'";
		
		
    	Statement stmt;
    	Statement stmt1;
		try {
			stmt = conn.createStatement();
			stmt1 = conn.createStatement();
			boolean rs =stmt.execute(sql);
			
			
			//JOptionPane.showMessageDialog(null, "�Ż����óɹ�");
			
			f.set�Ż�(���Ż�);
			f.�Ż�=f.get�Ż�();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void budazhe(int shopi) {//������
		String sql="update food set �Ż�='1' where shopid='"+shopi+"'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			boolean rs =stmt.execute(sql);
			JOptionPane.showMessageDialog(null, "���ĳɹ�");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
		
	protected void changeshoprname(int shopi,String shopn) {//�̵����޸ģ��̵���Ϣ����
		
    	String sql="select shopid from shop where shopname='"+shopn+"'";
    	String sql1="update shop set shopname='"+shopn+"' where shopid='"+shopi+"'";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs =stmt.executeQuery(sql);
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "�̵����Ѵ���", "ע��",JOptionPane.ERROR_MESSAGE);
			}else {
				boolean rs1 =stmt.execute(sql1);
			JOptionPane.showMessageDialog(null, "���ĳɹ�");
			s.setShopname(shopn);
			sname=s.getShopname();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

	protected void changeshoppw(String newshoppw,int sid) {
		//�����޸ģ��̵���Ϣ����
		//��Ҫ����ԭ����˶�
		String sql1="update shop set shoppwd='"+newshoppw+"' where shopid='"+sid+"'";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			boolean rs1 =stmt.execute(sql1);
			JOptionPane.showMessageDialog(null, "���ĳɹ�");
			s.setShoppwd(newshoppw);
			spw=s.getShoppwd();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void changeshopadd(int shopi,String shopadd) {//�̼ҵ�ַ�޸ģ��̵���Ϣ����
		String sql1="update shop set shopaddress='"+shopadd+"' where shopid='"+shopi+"'";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			boolean rs1 =stmt.execute(sql1);
			JOptionPane.showMessageDialog(null, "���ĳɹ�");
			s.setShopaddress(shopadd);
			sadd=s.getShopaddress();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void changeshopphone(int shopi,String shopphone) {//�̼ҵ绰�޸ģ��̵���Ϣ����//�̼ұ��в������ظ��绰����
		String sql="select shopid from shop where shopphone='"+shopphone+"'";
    	String sql1="update shop set shopphone='"+shopphone+"' where shopid='"+shopi+"'";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs =stmt.executeQuery(sql);
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "�ֻ����ѱ�ʹ��", "ע��",JOptionPane.ERROR_MESSAGE);
			}else {
				boolean rs1 =stmt.execute(sql1);
			JOptionPane.showMessageDialog(null, "���ĳɹ�");
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
		String sql="select count(ordernumber) from oorder where �������״̬='δ���' ";
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
		 String sql1="select ordernumber,�����ӵ�״̬,�Ƿ�ߵ� from oorder where  �������״̬='δ���'";
		 Statement stmt1;
		 stmt1= conn.createStatement();
		 ResultSet rs1 =stmt1.executeQuery(sql1);
		 for(int b=0;b<i;) {
			  while(rs1.next()) {
				 int ornn=rs1.getInt("ordernumber");
				 String weijiee=new String(rs1.getString("�����ӵ�״̬"));
				 String cuidann=new String(rs1.getString("�Ƿ�ߵ�"));
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
		String sql="select count(ordernumber) from oorder where �������״̬='�����' ";
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
		 String sql1="select ordernumber,�����ӵ�״̬,�Ƿ�ߵ� from oorder where  �������״̬='�����'";
		 Statement stmt1;
		 stmt1= conn.createStatement();
		 ResultSet rs1 =stmt1.executeQuery(sql1);
		 for(int b=0;b<i;) {
			  while(rs1.next()) {
				 int ornn=rs1.getInt("ordernumber");
				 String yijiee=new String(rs1.getString("�����ӵ�״̬"));
				 String cuidann=new String(rs1.getString("�Ƿ�ߵ�"));
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
	
	
	protected void huifucomment(String ordernumber,String �̼һظ�����) {//�̼һظ�����//���۱����comment��Ϊnull�ſ��Իظ�
//		String sql="insert into comment(ordernumber,�̼һظ�����) values('"+ordernumber+"','"+�̼һظ�����+"')";
		String sql="update comment set �̼һظ�����='"+�̼һظ�����+"' where ordernumber='"+ordernumber+"'";
    	Statement stmt;
    	try {
	    stmt = conn.createStatement();
		boolean rs =stmt.execute(sql);
		//JOptionPane.showMessageDialog(null, "�ظ����۳ɹ�");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "���Ѿ��ظ�����", "ע��",JOptionPane.ERROR_MESSAGE);
		}
		
	}
protected void huifuchuidan(String odn,String �̼һظ��ߵ�) {//�̼һظ��ߵ�//��������� �Ƿ�ߵ� Ϊ�ǲſ��Իظ�
		
	    String sql="update oorder set �̼һظ��ߵ�='"+�̼һظ��ߵ�+"' where �Ƿ�ߵ�='��'and ordernumber='"+odn+"'";
		Statement stmt;
		try { 
			stmt = conn.createStatement();
		boolean rs =stmt.execute(sql);
		o.set�̼һظ��ߵ�(�̼һظ��ߵ�);
		o�̼һظ��ߵ�=o.get�̼һظ��ߵ�();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
protected void jiedan(String ordern) {//�ӵ�
	String sql="update oorder set �����ӵ�״̬='�ѽӵ�'where ordernumber='"+ordern+"'";
	Statement stmt;
	try {
		stmt = conn.createStatement();
	boolean rs =stmt.execute(sql);
	//JOptionPane.showMessageDialog(null, "�ӵ��ɹ�");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
