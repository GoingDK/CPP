package Merchantview;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.ModelFactory;

import view.MainJMunregistered;
import view.MyButton;
import view.MyJpanel;

import MyRend.*;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author  __USER__
 */
public class MainJMmc extends javax.swing.JFrame {
	 static int foodi;
	static DefaultTableModel model =new DefaultTableModel() ;
	static DefaultTableModel model2 =new DefaultTableModel() ;
	DefaultTableModel model3 =new DefaultTableModel() ;
	DefaultTableModel model4 =new DefaultTableModel() ;
	public static void showTable() {
		
		model.setRowCount( 0 );//已上架
		model.setColumnIdentifiers(new Object[]{ "商品", "价格", "商品类型","选择"});
				//Object detail[][] = { { "可乐" }, { "薯条" } };
				jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
				jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
				ModelFactory m=new ModelFactory();
				m.xiajia();;
				
				String[] foodn;
				String[] price;
				String [] foodt;
//				
				String one=null;
		  		String two=null;
		  		String three=null;
		  		
		  		foodn=m.foodn;
		  		price=m.price;
		  		foodt=m.foodt;
		  		
		  		
		  		for(int b=0;b<foodn.length;) {
		  			one=foodn[b];
		  			two=price[b];
		  			three=foodt[b];
		  			b++;
		  			model.addRow(new Object[]{one,two,three,null}); 
		  		}
		  		jTable1.getColumnModel().getColumn(3).setCellEditor(new MyRender6(jTable1));
				jTable1.getColumnModel().getColumn(3).setCellRenderer(new MyRender6(jTable1));
				
				
	}

	public static void showTable1() {
		model2.setRowCount( 0 );//未上架
		model2.setColumnIdentifiers(new Object[]{ "商品", "价格", "商品类型","选择"});
				
				jTable2.getColumnModel().getColumn(1).setPreferredWidth(100);
				jTable2.getColumnModel().getColumn(3).setPreferredWidth(100);
				ModelFactory m=new ModelFactory();
				m.shangjia();;
				
				String[] foodn;
				String[] price;
				String [] foodt;
//				
				String one=null;
		  		String two=null;
		  		String three=null;
		  		
		  		foodn=m.foodn;
		  		price=m.price;
		  		foodt=m.foodt;
		  		
		  		
		  		for(int b=0;b<foodn.length;) {
		  			one=foodn[b];
		  			two=price[b];
		  			three=foodt[b];
		  			b++;
		  			model2.addRow(new Object[]{one,two,three,null}); 
		  		}
		  		jTable2.getColumnModel().getColumn(3).setCellEditor(new MyRender7(jTable2));
				jTable2.getColumnModel().getColumn(3).setCellRenderer(new MyRender7(jTable2));
				
				
	}

	public void showTable2() {//未完成
		model3.setRowCount( 0 );
				model3.setColumnIdentifiers(new Object[]{ "订单编号", "接单状态", "催单状态", "选择" });
		
				jTable3.getColumnModel().getColumn(1).setPreferredWidth(100);
				jTable3.getColumnModel().getColumn(3).setPreferredWidth(100);
				ModelFactory m=new ModelFactory();
				m.weiding();;
				
				int[] orn;
				String[] weijie;
				String [] cuidan;
		
				int one;
		  		String two=null;
		  		String three=null;
		  		
		  		orn=m.orn;
		  		weijie=m.weijie;
		  		cuidan=m.cuidan;
		  		
		  		
		  		for(int b=0;b<orn.length;) {
		  			one=orn[b];
		  			two=weijie[b];
		  			three=cuidan[b];
		  			b++;
		  			model3.addRow(new Object[]{one,two,three,null}); 
		  		}
			
		  		jTable3.getColumnModel().getColumn(3).setCellEditor(new MyRender8(jTable3));
				jTable3.getColumnModel().getColumn(3).setCellRenderer(new MyRender8(jTable3));
	}
	public void showTable3() {//已完成
		model4.setRowCount( 0 );
		model4.setColumnIdentifiers(new Object[]{ "订单编号", "接单状态", "催单状态", "选择" });

		jTable4.getColumnModel().getColumn(1).setPreferredWidth(100);
		jTable4.getColumnModel().getColumn(3).setPreferredWidth(100);
		ModelFactory m=new ModelFactory();
		m.yiding();;
		
		int[] orn;
		String[] yijie;
		String [] cuidan;

		int one;
  		String two=null;
  		String three=null;
  		
  		orn=m.orn;
  		yijie=m.yijie;
  		cuidan=m.cuidan;
  		
  		
  		for(int b=0;b<orn.length;) {
  			one=orn[b];
  			two=yijie[b];
  			three=cuidan[b];
  			b++;
  			model4.addRow(new Object[]{one,two,three,null}); 
  		}
	
		this.jTable4.getColumnModel().getColumn(3).setCellEditor(
				new MyRender9(jTable4));
		this.jTable4.getColumnModel().getColumn(3).setCellRenderer(
				new MyRender9(jTable4));
	}

	/** Creates new form MainJMmc */
	public MainJMmc() {
		initComponents();
		showTable();
		showTable1();
		showTable2();
		showTable3();
		this.setTitle("西泡泡外卖系统");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel2 = new MyJpanel("lib//image//2.png");
		
		jLabel1 = new javax.swing.JLabel();
		jButton1 = new MyButton("lib//image//开店.png","lib//image//开店.png","lib//image//开店.png");
		jButton2 = new MyButton("lib//image//休息.png","lib//image//休息.png","lib//image//休息.png");
		jTabbedPane2 = new javax.swing.JTabbedPane();
		jPanel5 = new javax.swing.JPanel();
		

		jTable1 = new JTable(model);
		jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jScrollPane1= new JScrollPane(jTable1);
		
		
		
		jPanel6 = new javax.swing.JPanel();
		
		jTable2= new JTable(model2);
		jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jScrollPane2= new JScrollPane(jTable2);
		
		jButton3 = new MyButton("lib//image//添加商品.png","lib//image//添加商品.png","lib//image//添加商品.png");
		jPanel3 = new MyJpanel("lib//image//2.png");
		jTabbedPane3 = new javax.swing.JTabbedPane();
		jPanel7 = new javax.swing.JPanel();
		
		
		jTable3= new JTable(model3);
		jTable3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jScrollPane3= new JScrollPane(jTable3);
		
		
		jPanel8 = new javax.swing.JPanel();
		
		jTable4= new JTable(model4);
		jTable4.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jScrollPane4= new JScrollPane(jTable4);
		
		jPanel4 = new MyJpanel("lib//image//2.png");
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jTabbedPane1.setFont(new java.awt.Font("方正水云简体_中", 0, 14));

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jLabel1
				.setText("\u5546\u5bb6\uff0c\u6b22\u8fce\u4f60\u4f7f\u7528\u897f\u6ce1\u6ce1\u5916\u5356\u7cfb\u7edf");

		jButton1.setText("\u5f00\u5e97");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("\u4f11\u606f");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});


		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396,
				Short.MAX_VALUE));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel5Layout.createSequentialGroup().addComponent(
						jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
						381, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		jTabbedPane2.addTab("\u5df2\u4e0a\u67b6", jPanel5);


		javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(
				jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 396,
				Short.MAX_VALUE));
		jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 379,
				Short.MAX_VALUE));

		jTabbedPane2.addTab("\u672a\u4e0a\u67b6", jPanel6);

		jButton3.setText("\u6dfb\u52a0\u5546\u54c1");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		
		JButton button = new JButton("\u5237\u65B0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//刷新
				showTable();
				showTable1();
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2Layout.setHorizontalGroup(
			jPanel2Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(jPanel2Layout.createSequentialGroup()
								.addComponent(jLabel1)
								.addGap(18)
								.addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addGap(19))
							.addGroup(jPanel2Layout.createSequentialGroup()
								.addComponent(jTabbedPane2, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(jPanel2Layout.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(204)
							.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		jPanel2Layout.setVerticalGroup(
			jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel1)
						.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jTabbedPane2, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup()
							.addComponent(button)
							.addGap(41))
						.addComponent(jButton3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
		);
		jPanel2.setLayout(jPanel2Layout);

		jTabbedPane1.addTab("\u5546\u54c1", jPanel2);

		

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(
				jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 390,
				Short.MAX_VALUE));
		jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 472,
				Short.MAX_VALUE));

		jTabbedPane3.addTab("\u672a\u5b8c\u6210", jPanel7);

		

		javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(
				jPanel8);
		jPanel8.setLayout(jPanel8Layout);
		jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 390,
				Short.MAX_VALUE));
		jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 472,
				Short.MAX_VALUE));

		jTabbedPane3.addTab("\u5df2\u5b8c\u6210", jPanel8);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel3Layout.createSequentialGroup().addContainerGap()
						.addComponent(jTabbedPane3,
								javax.swing.GroupLayout.DEFAULT_SIZE, 395,
								Short.MAX_VALUE).addContainerGap()));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				jPanel3Layout.createSequentialGroup().addContainerGap()
						.addComponent(jTabbedPane3,
								javax.swing.GroupLayout.DEFAULT_SIZE, 506,
								Short.MAX_VALUE)));

		jTabbedPane1.addTab("\u8ba2\u5355", jPanel3);

		jButton4.setText("\u5546\u5e97\u4fe1\u606f\u7ba1\u7406");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jButton5.setText("\u4f18\u60e0\u7ba1\u7406");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jButton6.setText("\u9000\u51fa\u767b\u5f55");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout
				.setHorizontalGroup(jPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel4Layout
										.createSequentialGroup()
										.addGap(85, 85, 85)
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jButton4,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																251,
																Short.MAX_VALUE)
														.addComponent(
																jButton6,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																251,
																Short.MAX_VALUE)
														.addComponent(
																jButton5,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																251,
																Short.MAX_VALUE))
										.addGap(89, 89, 89)));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel4Layout.createSequentialGroup().addGap(34, 34, 34)
						.addComponent(jButton4,
								javax.swing.GroupLayout.PREFERRED_SIZE, 57,
								javax.swing.GroupLayout.PREFERRED_SIZE).addGap(
								30, 30, 30).addComponent(jButton5,
								javax.swing.GroupLayout.PREFERRED_SIZE, 53,
								javax.swing.GroupLayout.PREFERRED_SIZE).addGap(
								30, 30, 30).addComponent(jButton6,
								javax.swing.GroupLayout.PREFERRED_SIZE, 57,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(261, Short.MAX_VALUE)));

		jTabbedPane1.addTab("\u4fe1\u606f\u7ba1\u7406", jPanel4);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430,
				Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				jPanel1Layout.createSequentialGroup().addComponent(
						jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
						556, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		new Manaprivilege().setVisible(true);

	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		new Manashangdian().setVisible(true);
	}

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		new MainJMunregistered().setVisible(true);
		this.dispose();

	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		new addfood().setVisible(true);

	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		ModelFactory m = new ModelFactory();
		m.xiuxi(m.sid);
		JOptionPane.showMessageDialog(null, "店铺已休息");
	}
 
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		ModelFactory m = new ModelFactory();
		m.kaidian(m.sid);
		;
		JOptionPane.showMessageDialog(null, "店铺已营业");
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainJMmc().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTabbedPane jTabbedPane2;
	private javax.swing.JTabbedPane jTabbedPane3;
	private static javax.swing.JTable jTable1;
	private static javax.swing.JTable jTable2;
	private javax.swing.JTable jTable3;
	private javax.swing.JTable jTable4;
}