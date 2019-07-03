package model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import MyRend.MyRender8;

public class ModelFactory {
	/*↓用户↓*/
	
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

	
	public static void register(String uname,String uphone,String userpw,String useradd) {//用户注册功能√(郭莹)
		y.register(uname, uphone, userpw, useradd);
	}
	
	public static void loginuser(String userphone) {//用户登陆功能√(郭莹)
	    y.login(userphone);
	    upw=y.upw;
	    uname=y.uname;
	    uppw=y.uppw;
	    uphone=y.uphone;
	    uid=y.uid;
	    uadd=y.uadd;
	}
	public static void shopRegister(String shopphone,String shoppwd,String shopname,String shopaddress) {//实现商家入驻功能√(郭莹)
		y.shopRegister(shopphone, shoppwd, shopname, shopaddress);
	}
	
	public static String[] shopname;
	public static void viewshop(){//浏览商店√(郭莹)
		y.viewshop();
		shopname=y.shopname;
	}
	public static void searchshop(String name){//查找商店√(郭莹)
		y.searchshop(name);
		shopname=y.shopname;
	}
	public static void searchfood(String name){//查找食品√(郭莹)
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
	public static void vieweatfood(String shopn){//浏览吃的√(郭莹)
		y.vieweatfood(shopn);
		id=y.id;
		foodn=y.foodn;
		price=y.price;
		youhui=y.youhui;
	}
	public static void viewdrinkfood(String shopn){//浏览喝的√(郭莹)
		y.viewdrinkfood(shopn);
		id=y.id;
		foodn=y.foodn;
		price=y.price;
		youhui=y.youhui;
	}

	public static int[] orn;
	public static String[] jiedan;
	public static String[] xiadan;
	public static void viewunfinfsh(){//用户查看未完成订单√(郭莹)
		y.viewunfinfsh(uid);
		 orn=y.orn;
		 foodn=y.foodn;
		 price=y.price;
		 shopname=y.shopname;
		 jiedan=y.jiedan;
		 xiadan=y.xiadan;
	}
	public static String[] wancheng;
	public static void viewfinfsh(){//用户查看已完成订单√(郭莹)
		y.viewfinfsh(uid);
		 orn=y.orn;
		 foodn=y.foodn;
		 price=y.price;
		 shopname=y.shopname;
		 wancheng=y.wancheng;
		 xiadan=y.xiadan;
	}
	
	public static void pay(String foodid,String foodprice,String ppw) {//下单√(郭莹)
		if(uppw!=null) {
		if(ppw.equals(uppw)) {
			y.pay(foodid, foodprice, uid);
		}else {
			JOptionPane.showMessageDialog(null, "下单失败，支付密码错误", "注意",JOptionPane.ERROR_MESSAGE);
		}}else {
			JOptionPane.showMessageDialog(null, "未设置支付密码，请先去设置", "注意",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	public static void cuidan(String ordern) {//催单√(郭莹)
		y.cuidan(ordern);
	}
	public static void quxiao(String ordern) {//取消订单√(郭莹)
		y.quxiao(ordern);
	}
	public static void finish(String ordern) {//订单完成√(郭莹)
		y.finish(ordern);
	}
	public static String shopphone;
	public static void lianxi(String shopn) {//联系商家√(郭莹)
		y.lianxi(shopn);
		shopphone=y.shopphone;
	}
	public static void shoucang(String shopname){//收藏商店√(郭莹)
		y.shoucang(uid, shopname);
	}
	public static void viewshoucang(){//查看收藏√(郭莹)
		y.viewshoucang(uid);
		shopname=y.shopname;
	}
	public static void deleteshoucang(String shopn){//取消收藏√(郭莹)
		y.deleteshoucang(shopn, uid);
	}
    public static void comment(String comment,String ordern) {//用户评价√(郭莹)
		y.comment(comment, ordern);
	}
	
	public static String comment;
	public static String shcom;
	public static void viewcomment(String ordern) {//查看商家回复评论√(郭莹)
		y.viewcomment(ordern);
		comment=y.comment;
		shcom=y.shcom;
	}
	public static void viewcuidan(String ordern) {//查看商家回复催单√(郭莹)
		y.viewcuidan(ordern);
		comment=y.comment;
	}
	public static void changename(String username) {//更改用户名√(郭莹)
		y.changename(username, uid);
		uname=y.uname;
	}
	public static void changephone(String newphone,String pw,double op) {//更改手机号√(郭莹)
		if(op==uphone&&pw.equals(upw)) {
			y.changephone(newphone, uid);
			uphone=y.uphone;
		}else {
			JOptionPane.showMessageDialog(null, "登陆手机号密码不正确", "注意",JOptionPane.ERROR_MESSAGE);
		}
	}
	public static void changeaddress(String address) {//更改收货地址√(郭莹)
		y.changeaddress(address, uid);
		uadd=y.uadd;
	}
	public static void changepw(String newpw,String oldpw) {//更改登陆密码√(郭莹)
		if(oldpw.equals(upw)) {
			y.changepw(newpw, uid);
			upw=y.upw;
		}else {
			JOptionPane.showMessageDialog(null, "旧密码不正确", "注意",JOptionPane.ERROR_MESSAGE);

		}
	}
	public static void changePpw(String newppw,String oldppw,String pw) {//更改支付密码√(郭莹)
		if(pw.equals(upw)) {
			if(uppw==null) {
				y.changePpw(newppw, uid);
			    uppw=y.uppw;}
			else if(uppw.equals(oldppw)) {
				y.changePpw(newppw, uid);
				uppw=y.uppw;
			}else {
				JOptionPane.showMessageDialog(null, "支付密码不正确", "注意",JOptionPane.ERROR_MESSAGE);
			}
			
		}else {JOptionPane.showMessageDialog(null, "登陆密码不正确", "注意",JOptionPane.ERROR_MESSAGE);}
	}
	
	
	
	/*↓商家↓*/
	
	
	public static void loginshop(String shopphone) {//商家登陆√(郭莹)
		sh.login(shopphone);
		spw=sh.spw;	
	    sname=sh.sname;
	    sphone=sh.sphone;
	    sid=sh.sid;
	    sadd=sh.sadd;
	}
	public static String[] foodt;
	 public static void shangjia() {
			//商家上架商品
            sh.shangjia(sid);
            foodn=sh.foodn;
			price=sh.price;
			foodt=sh.foodt;
		}
	 public static void xiajia(){
			//商家下架商品
			sh.xiajia(sid);
			foodn=sh.foodn;
			price=sh.price;
			foodt=sh.foodt;
			
		}
	 
	 public static void xiajia1(String foodn) {//下架商品
		 sh.xiajia1(foodn);
	 }
	 public static void shangjia1(String foodn) {//上架商品
		 sh.shangjia1(foodn);
	 }
	 
	 public static void addfood(String foodn,String foodpr) {
			//商家增加食物
			sh.addfood( foodn, foodpr,sid);
		}
	 public static void addfood1(String foodn,String foodpr) {
			//商家增加饮品
			sh.addfood1( foodn, foodpr,sid);
		}
	 public static void liulaneatfood1(int shopid) {
			//浏览该商店吃的食物
			sh.liulaneatfood(shopid);
		}
	 public static void liulandrinkfood1(int shopid) {
			//浏览该商店喝的食物
			sh.liulandrinkfood(shopid);
		}

	 public static void kaidian(int shopi) {
			//开店
			sh.kaidian(sid);
		}
	 public static void xiuxi(int shopi) {
			//休息
			sh.xiuxi(sid);
		}
	 public static void youhui(double 喝优惠) {
			//优惠管理
			sh.youhui(sid,喝优惠);
		}
	 public static void youhui1(double 吃优惠) {
			//优惠管理
			sh.youhui1(sid,吃优惠);
		}
	 public static void budazhe(int shopi){
		 sh.budazhe(sid);
	 }
	 public static void changeshoprname(String shopn) {
			//商店名修改（商店信息管理）
           sh.changeshoprname(sid, shopn);
		}
	 public static void changeshoppw(String newshoppw,String oldshoppw) {
			//密码修改（商店信息管理）
			if(oldshoppw.equals(spw)) {
				sh.changeshoppw(newshoppw, sid);
				spw=sh.spw;
			}else {
				JOptionPane.showMessageDialog(null, "旧密码不正确", "注意",JOptionPane.ERROR_MESSAGE);

			}
		}
		
	 public static void changeshopadd(String shopadd) {
			//商家地址修改（商店信息管理）
		     sh.changeshopadd(sid, shopadd);
		     sadd=sh.sadd;
		}
	 public static void changeshopphone(String shopphone) {
			//商家电话修改（商店信息管理）
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

	 
	 public static void huifucomment(String ordernumber,String 商家回复) {
			//商家回复评论
		    sh.huifucomment(ordernumber, 商家回复);
		}
	 public static void huifuchuidan(String ordernumber,String 商家回复) {
			//商家回复催单
		    sh.huifuchuidan(ordernumber, 商家回复);
		}
	 public static void jiedan(String ordern) {
			//接单
			sh.jiedan(ordern);
	 
}
}
