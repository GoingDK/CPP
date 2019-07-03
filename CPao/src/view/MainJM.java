/*
 * MainJM.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import gerenxinxi.*;
import model.ModelFactory;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import MyRend.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author  __USER__
 */
public class MainJM extends javax.swing.JFrame {
	static String name;
	static ModelFactory m=new ModelFactory();
	DefaultTableModel model =new DefaultTableModel() ;
	static DefaultTableModel model1 =new DefaultTableModel() ;
	static DefaultTableModel model2 =new DefaultTableModel() ;
	public void showTable() {
		model.setRowCount( 0 );
		model.setColumnIdentifiers(new Object[]{"商店", "          进入店铺"});
		jTable3.getColumnModel().getColumn(0).setPreferredWidth(183);
		jTable3.getColumnModel().getColumn(1).setPreferredWidth(183);
  		m.viewshop();
  		String[] shopn;
  		String one = null;
  		shopn=m.shopname;
  		for(int b=0;b<shopn.length;) {
  			one=shopn[b];
  			b++;
  			model.addRow(new Object[]{one,null}); 
  		}
		jTable3.getColumnModel().getColumn(1).setCellEditor(new MyRender(jTable3));
		jTable3.getColumnModel().getColumn(1).setCellRenderer(new MyRender(jTable3));
	}

	public static void showTable1() {//未完成
		model1.setRowCount( 0 );
		model1.setColumnIdentifiers(new Object[]{"订单id","食品名","价格", "商店名", "接单状态", "下单时间",""});
		jTable2.getColumnModel().getColumn(1).setPreferredWidth(100);
		jTable2.getColumnModel().getColumn(3).setPreferredWidth(100);
		jTable2.getColumnModel().getColumn(5).setPreferredWidth(150);
  		m.viewunfinfsh();;
  		int[] orn;
  		String[] foodn;
  		String[] price;
  		String[] shopname;
  		String[] jiedan;
  		String[] xiadan;
  		int one;
  		String two=null;
  		String three=null;
  		String four=null;
  		String five=null;
  		String six=null;
  		orn=m.orn;
  		foodn=m.foodn;
  		price=m.price;
  		shopname=m.shopname;
  		jiedan=m.jiedan;
  		xiadan=m.xiadan;
  		for(int b=0;b<orn.length;) {
  			one=orn[b];
  			two=foodn[b];
  			three=price[b];
  			four=shopname[b];
  			five=jiedan[b];
  			six=xiadan[b];
  			b++;
  			model1.addRow(new Object[]{one,two,three,four,five,six,null}); 
  		}
		jTable2.getColumnModel().getColumn(6).setCellEditor(new MyRender2(jTable2));
		jTable2.getColumnModel().getColumn(6).setCellRenderer(new MyRender2(jTable2));
	}

	public static void showTable2() {//完成
		model2.setRowCount( 0 );
		model2.setColumnIdentifiers(new Object[]{"订单id","食品名","价格", "商店名", "下单时间", "完成时间","",""});
		jTable4.getColumnModel().getColumn(1).setPreferredWidth(100);
		jTable4.getColumnModel().getColumn(3).setPreferredWidth(100);
		jTable4.getColumnModel().getColumn(4).setPreferredWidth(150);
		jTable4.getColumnModel().getColumn(5).setPreferredWidth(150);
		jTable4.getColumnModel().getColumn(7).setPreferredWidth(150);
  		m.viewfinfsh();
  		int[] orn;
  		String[] foodn;
  		String[] price;
  		String[] shopname;
  		String[] wancheng;
  		String[] xiadan;
  		int one;
  		String two=null;
  		String three=null;
  		String four=null;
  		String five=null;
  		String six=null;
  		orn=m.orn;
  		foodn=m.foodn;
  		price=m.price;
  		shopname=m.shopname;
  		wancheng=m.wancheng;
  		xiadan=m.xiadan;
  		for(int b=0;b<orn.length;) {
  			one=orn[b];
  			two=foodn[b];
  			three=price[b];
  			four=shopname[b];
  			five=wancheng[b];
  			six=xiadan[b];
  			b++;
  			model2.addRow(new Object[]{one,two,three,four,six,five,null,null}); 
  		}
		jTable4.getColumnModel().getColumn(6).setCellEditor(new MyRender3(jTable4));
		jTable4.getColumnModel().getColumn(6).setCellRenderer(new MyRender3(jTable4));
		jTable4.getColumnModel().getColumn(7).setCellEditor(new MyRender10(jTable4));
		jTable4.getColumnModel().getColumn(7).setCellRenderer(new MyRender10(jTable4));
	}

	/** Creates new form MainJM */
	public MainJM() {
		initComponents();
		showTable();
		showTable1();
		showTable2();
		this.setTitle("西泡泡外卖系统");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel7 = new javax.swing.JPanel();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel2 = new javax.swing.JPanel();
		jPanel1 = new MyJpanel("lib//image//4.png");
		jTextField1 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		
		jTable3 = new JTable(model);
		jTable3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jScrollPane1= new JScrollPane(jTable3);
		
		jLabel1 = new javax.swing.JLabel();
		jPanel3 = new MyJpanel("lib//image//4.png");
		jTabbedPane2 = new javax.swing.JTabbedPane();
		jPanel5 = new javax.swing.JPanel();
		
		jTable2 = new JTable(model1);
		jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jScrollPane3= new JScrollPane(jTable2);
		
		jPanel6 = new javax.swing.JPanel();
		
		jTable4 = new JTable(model2);
		jTable4.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jScrollPane4= new JScrollPane(jTable4);
		
		jPanel4 = new MyJpanel("lib//image//4.png");
		jButton4 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();


		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jTabbedPane1.setFont(new java.awt.Font("方正水云简体_中", 0, 14));
		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jButton1.setText("\u786e\u8ba4");

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		
		jLabel1.setText(ModelFactory.uname+"\uff0c\u6b22\u8fce\u4f60\u4f7f\u7528\u897f\u6ce1\u6ce1\u5916\u5356\u7cfb\u7edf");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5546\u5BB6", "\u98DF\u54C1"}));
		jButton1.addActionListener(new ActionListener() {//确认
			public void actionPerformed(ActionEvent e) {
				int c=comboBox.getSelectedIndex();
				if(c==0) {//商店
					name=new String(jTextField1.getText());
					Searchshop1 frame = new Searchshop1();
					frame.setVisible(true);
				}else {
					name=new String(jTextField1.getText());
					Searchfood1 frame = new Searchfood1();
					frame.setVisible(true);
				}
			}
		});
		
		button = new JButton("\u5237\u65B0");
		button.addActionListener(new ActionListener() {//刷新
			public void actionPerformed(ActionEvent e) {
		jLabel1.setText(ModelFactory.uname+"\uff0c\u6b22\u8fce\u4f60\u4f7f\u7528\u897f\u6ce1\u6ce1\u5916\u5356\u7cfb\u7edf");
		showTable();
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
								.addGroup(jPanel1Layout.createSequentialGroup()
									.addComponent(jLabel1)
									.addGap(70))
								.addGroup(jPanel1Layout.createSequentialGroup()
									.addComponent(comboBox, 0, 62, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel1)
						.addComponent(button))
					.addGap(18)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
		);
		jPanel1.setLayout(jPanel1Layout);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		jTabbedPane1.addTab("\u5916\u5356", jPanel2);

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel5Layout.createSequentialGroup().addComponent(
						jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE,
						375, Short.MAX_VALUE).addContainerGap()));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 202,
				Short.MAX_VALUE));

		jTabbedPane2.addTab("\u672a\u5b8c\u6210", jPanel5);

		javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(
				jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 387,
				Short.MAX_VALUE));
		jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE));

		jTabbedPane2.addTab("\u5df2\u5b8c\u6210", jPanel6);
		
		button_1 = new JButton("\u5237\u65B0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTable1();
				showTable2();
			}
		});

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3Layout.setHorizontalGroup(
			jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(jPanel3Layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, jPanel3Layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jTabbedPane2, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		jPanel3Layout.setVerticalGroup(
			jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jTabbedPane2, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(button_1)
					.addContainerGap(265, Short.MAX_VALUE))
		);
		jPanel3.setLayout(jPanel3Layout);

		jTabbedPane1.addTab("\u8ba2\u5355", jPanel3);

		jButton4.setText("\u7528\u6237\u540d\u66f4\u6539");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jButton6.setText("\u767b\u5f55\u5bc6\u7801\u66f4\u6539");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		jButton7.setText("\u652f\u4ed8\u5bc6\u7801\u66f4\u6539");
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

		jButton8.setText("\u6536\u8d27\u5730\u5740\u66f4\u6539");
		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
		});

		jButton2.setText("\u5546\u5bb6\u5165\u9a7b");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setText("\u6211\u7684\u6536\u85cf");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton5.setText("\u9000\u51fa\u767b\u5f55");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});
		
		button_2 = new JButton("\u624B\u673A\u53F7\u7801\u66F4\u6539");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Changephone frame = new Changephone();
				frame.setVisible(true);
			}
		});

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4Layout.setHorizontalGroup(
			jPanel4Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
					.addGroup(jPanel4Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, jPanel4Layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jButton5, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, jPanel4Layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jButton6, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, jPanel4Layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jButton7, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, jPanel4Layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jButton3, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, jPanel4Layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jButton4, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, jPanel4Layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jButton2, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, jPanel4Layout.createSequentialGroup()
							.addContainerGap()
							.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(button_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
								.addComponent(jButton8, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))))
					.addGap(29))
		);
		jPanel4Layout.setVerticalGroup(
			jPanel4Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(71, Short.MAX_VALUE))
		);
		jPanel4.setLayout(jPanel4Layout);

		jTabbedPane1.addTab("\u4e2a\u4eba\u4fe1\u606f", jPanel4);

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(
				jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane1));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		new MainJMunregistered().setVisible(true);
		this.dispose();
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		new MyFavorite().setVisible(true);
	}

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		new UpdatePaypw().setVisible(true);
	}

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//登陆密码
		// TODO add your handling code here:
		new Updateloginpw().setVisible(true);
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//用户名
		// TODO add your handling code here:
		new Updatename().setVisible(true);
	}

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		new UpdateAdress().setVisible(true);
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		new AddMerchant().setVisible(true);
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
				new MainJM().setVisible(true);
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
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTabbedPane jTabbedPane2;
	private static javax.swing.JTable jTable2;
	private javax.swing.JTable jTable3;
	private static javax.swing.JTable jTable4;
	private javax.swing.JTextField jTextField1;
	private JComboBox comboBox;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	// End of variables declaration//GEN-END:variables

}