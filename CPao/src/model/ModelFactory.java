package model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import MyRend.MyRender8;

public class ModelFactory {
	/*���û���*/
	
	static user u=new user();
	static shop s=new shop();
	static Yonghu y=new Yonghu();
	static shangjia sh=new shangjia();
	public static String upw;
	public static String spw;
	public static String uname;
	public static String sname;
	public static String uppw;
	public static double uphone;
	public static double sphone;
	public static int uid;
	public static int sid;
	public static String odn;
	public static String uadd;
	public static String sadd;
	public static String sprice;

	
	public static void register(String uname,String uphone,String userpw,String useradd) {//�û�ע�Ṧ�ܡ�(��Ө)
		y.register(uname, uphone, userpw, useradd);
	}
	
	public static void loginuser(String userphone) {//�û���½���ܡ�(��Ө)
	    y.login(userphone);
	    upw=y.upw;
	    uname=y.uname;
	    uppw=y.uppw;
	    uphone=y.uphone;
	    uid=y.uid;
	    uadd=y.uadd;
	}
	public static void shopRegister(String shopphone,String shoppwd,String shopname,String shopaddress) {//ʵ���̼���פ���ܡ�(��Ө)
		y.shopRegister(shopphone, shoppwd, shopname, shopaddress);
	}
	
	public static String[] shopname;
	public static void viewshop(){//����̵��(��Ө)
		y.viewshop();
		shopname=y.shopname;
	}
	public static void searchshop(String name){//�����̵��(��Ө)
		y.searchshop(name);
		shopname=y.shopname;
	}
	public static void searchfood(String name){//����ʳƷ��(��Ө)
		y.searchfood(name);
		id=y.id;
		foodn=y.foodn;
		price=y.price;
		youhui=y.youhui;
		shopname=y.shopname;
	}
	public static int[] id;
	public static String[] foodn;
	public static String[] price;
	public static String[] youhui;
	public static void vieweatfood(String shopn){//����Եġ�(��Ө)
		y.vieweatfood(shopn);
		id=y.id;
		foodn=y.foodn;
		price=y.price;
		youhui=y.youhui;
	}
	public static void viewdrinkfood(String shopn){//����ȵġ�(��Ө)
		y.viewdrinkfood(shopn);
		id=y.id;
		foodn=y.foodn;
		price=y.price;
		youhui=y.youhui;
	}

	public static int[] orn;
	public static String[] jiedan;
	public static String[] xiadan;
	public static void viewunfinfsh(){//�û��鿴δ��ɶ�����(��Ө)
		y.viewunfinfsh(uid);
		 orn=y.orn;
		 foodn=y.foodn;
		 price=y.price;
		 shopname=y.shopname;
		 jiedan=y.jiedan;
		 xiadan=y.xiadan;
	}
	public static String[] wancheng;
	public static void viewfinfsh(){//�û��鿴����ɶ�����(��Ө)
		y.viewfinfsh(uid);
		 orn=y.orn;
		 foodn=y.foodn;
		 price=y.price;
		 shopname=y.shopname;
		 wancheng=y.wancheng;
		 xiadan=y.xiadan;
	}
	
	public static void pay(String foodid,String foodprice,String ppw) {//�µ���(��Ө)
		if(uppw!=null) {
		if(ppw.equals(uppw)) {
			y.pay(foodid, foodprice, uid);
		}else {
			JOptionPane.showMessageDialog(null, "�µ�ʧ�ܣ�֧���������", "ע��",JOptionPane.ERROR_MESSAGE);
		}}else {
			JOptionPane.showMessageDialog(null, "δ����֧�����룬����ȥ����", "ע��",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	public static void cuidan(String ordern) {//�ߵ���(��Ө)
		y.cuidan(ordern);
	}
	public static void quxiao(String ordern) {//ȡ��������(��Ө)
		y.quxiao(ordern);
	}
	public static void finish(String ordern) {//������ɡ�(��Ө)
		y.finish(ordern);
	}
	public static String shopphone;
	public static void lianxi(String shopn) {//��ϵ�̼ҡ�(��Ө)
		y.lianxi(shopn);
		shopphone=y.shopphone;
	}
	public static void shoucang(String shopname){//�ղ��̵��(��Ө)
		y.shoucang(uid, shopname);
	}
	public static void viewshoucang(){//�鿴�ղء�(��Ө)
		y.viewshoucang(uid);
		shopname=y.shopname;
	}
	public static void deleteshoucang(String shopn){//ȡ���ղء�(��Ө)
		y.deleteshoucang(shopn, uid);
	}
    public static void comment(String comment,String ordern) {//�û����ۡ�(��Ө)
		y.comment(comment, ordern);
	}
	
	public static String comment;
	public static String shcom;
	public static void viewcomment(String ordern) {//�鿴�̼һظ����ۡ�(��Ө)
		y.viewcomment(ordern);
		comment=y.comment;
		shcom=y.shcom;
	}
	public static void viewcuidan(String ordern) {//�鿴�̼һظ��ߵ���(��Ө)
		y.viewcuidan(ordern);
		comment=y.comment;
	}
	public static void changename(String username) {//�����û�����(��Ө)
		y.changename(username, uid);
		uname=y.uname;
	}
	public static void changephone(String newphone,String pw,double op) {//�����ֻ��š�(��Ө)
		if(op==uphone&&pw.equals(upw)) {
			y.changephone(newphone, uid);
			uphone=y.uphone;
		}else {
			JOptionPane.showMessageDialog(null, "��½�ֻ������벻��ȷ", "ע��",JOptionPane.ERROR_MESSAGE);
		}
	}
	public static void changeaddress(String address) {//�����ջ���ַ��(��Ө)
		y.changeaddress(address, uid);
		uadd=y.uadd;
	}
	public static void changepw(String newpw,String oldpw) {//���ĵ�½�����(��Ө)
		if(oldpw.equals(upw)) {
			y.changepw(newpw, uid);
			upw=y.upw;
		}else {
			JOptionPane.showMessageDialog(null, "�����벻��ȷ", "ע��",JOptionPane.ERROR_MESSAGE);

		}
	}
	public static void changePpw(String newppw,String oldppw,String pw) {//����֧�������(��Ө)
		if(pw.equals(upw)) {
			if(uppw==null) {
				y.changePpw(newppw, uid);
			    uppw=y.uppw;}
			else if(uppw.equals(oldppw)) {
				y.changePpw(newppw, uid);
				uppw=y.uppw;
			}else {
				JOptionPane.showMessageDialog(null, "֧�����벻��ȷ", "ע��",JOptionPane.ERROR_MESSAGE);
			}
			
		}else {JOptionPane.showMessageDialog(null, "��½���벻��ȷ", "ע��",JOptionPane.ERROR_MESSAGE);}
	}
	
	
	
	/*���̼ҡ�*/
	
	
	public static void loginshop(String shopphone) {//�̼ҵ�½��(��Ө)
		sh.login(shopphone);
		spw=sh.spw;	
	    sname=sh.sname;
	    sphone=sh.sphone;
	    sid=sh.sid;
	    sadd=sh.sadd;
	}
	public static String[] foodt;
	 public static void shangjia() {
			//�̼��ϼ���Ʒ
            sh.shangjia(sid);
            foodn=sh.foodn;
			price=sh.price;
			foodt=sh.foodt;
		}
	 public static void xiajia(){
			//�̼��¼���Ʒ
			sh.xiajia(sid);
			foodn=sh.foodn;
			price=sh.price;
			foodt=sh.foodt;
			
		}
	 
	 public static void xiajia1(String foodn) {//�¼���Ʒ
		 sh.xiajia1(foodn);
	 }
	 public static void shangjia1(String foodn) {//�ϼ���Ʒ
		 sh.shangjia1(foodn);
	 }
	 
	 public static void addfood(String foodn,String foodpr) {
			//�̼�����ʳ��
			sh.addfood( foodn, foodpr,sid);
		}
	 public static void addfood1(String foodn,String foodpr) {
			//�̼�������Ʒ
			sh.addfood1( foodn, foodpr,sid);
		}
	 public static void liulaneatfood1(int shopid) {
			//������̵�Ե�ʳ��
			sh.liulaneatfood(shopid);
		}
	 public static void liulandrinkfood1(int shopid) {
			//������̵�ȵ�ʳ��
			sh.liulandrinkfood(shopid);
		}

	 public static void kaidian(int shopi) {
			//����
			sh.kaidian(sid);
		}
	 public static void xiuxi(int shopi) {
			//��Ϣ
			sh.xiuxi(sid);
		}
	 public static void youhui(double ���Ż�) {
			//�Żݹ���
			sh.youhui(sid,���Ż�);
		}
	 public static void youhui1(double ���Ż�) {
			//�Żݹ���
			sh.youhui1(sid,���Ż�);
		}
	 public static void budazhe(int shopi){
		 sh.budazhe(sid);
	 }
	 public static void changeshoprname(String shopn) {
			//�̵����޸ģ��̵���Ϣ����
           sh.changeshoprname(sid, shopn);
		}
	 public static void changeshoppw(String newshoppw,String oldshoppw) {
			//�����޸ģ��̵���Ϣ����
			if(oldshoppw.equals(spw)) {
				sh.changeshoppw(newshoppw, sid);
				spw=sh.spw;
			}else {
				JOptionPane.showMessageDialog(null, "�����벻��ȷ", "ע��",JOptionPane.ERROR_MESSAGE);

			}
		}
		
	 public static void changeshopadd(String shopadd) {
			//�̼ҵ�ַ�޸ģ��̵���Ϣ����
		     sh.changeshopadd(sid, shopadd);
		     sadd=sh.sadd;
		}
	 public static void changeshopphone(String shopphone) {
			//�̼ҵ绰�޸ģ��̵���Ϣ����
			sh.changeshopphone(sid, shopphone);	
		}
	 
	 public static String[] weijie;
		public static String[] cuidan;
		
	 public static void weiding(){
		 sh.weiding();
		   orn=sh.orn;
		   weijie=sh.weijie;
	  		cuidan=sh.cuidan;
	 }

	 public static String[] yijie;
	 public static void yiding(){
		 sh.yiding();
		   orn=sh.orn;
		   yijie=sh.yijie;
	  		cuidan=sh.cuidan;
	 }

	 
	 public static void huifucomment(String ordernumber,String �̼һظ�) {
			//�̼һظ�����
		    sh.huifucomment(ordernumber, �̼һظ�);
		}
	 public static void huifuchuidan(String ordernumber,String �̼һظ�) {
			//�̼һظ��ߵ�
		    sh.huifuchuidan(ordernumber, �̼һظ�);
		}
	 public static void jiedan(String ordern) {
			//�ӵ�
			sh.jiedan(ordern);
	 
}
}
