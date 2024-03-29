/*
 * pay.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import MyRend.MyRender1;
import model.ModelFactory;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import java.awt.Font;

/**
 *
 * @author  __USER__
 */
public class pay extends javax.swing.JFrame {

	/** Creates new form pay */
	public pay() {
		initComponents();
		this.setTitle("支付界面");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new MyJpanel("lib//image//04.png");
		jLabel1 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jPasswordField1 = new javax.swing.JPasswordField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("方正水云简体_中", 0, 14));
		jLabel1.setText("\u652f\u4ed8\u5bc6\u7801");

		jButton1.setText("\u786e\u8ba4\u652f\u4ed8");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("\u53d6\u6d88");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		
		JLabel label = new JLabel();
		label.setText("\u98DF\u54C1\uFF1A"+MyRender1.foodname);
		label.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		JLabel label_1 = new JLabel();
		label_1.setText("\u4EF7\u683C\uFF1A"+MyRender1.foodprice);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 14));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(jPanel1Layout.createSequentialGroup()
								.addGap(44)
								.addComponent(jButton1)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
							.addGroup(jPanel1Layout.createSequentialGroup()
								.addGap(22)
								.addComponent(jLabel1)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)))
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addGap(18)
							.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(label_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))))
					.addContainerGap(83, Short.MAX_VALUE))
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addGap(18)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addGap(4)
							.addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(jLabel1))
					.addGap(18)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jButton1)
						.addComponent(jButton2))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		jPanel1.setLayout(jPanel1Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
		);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		if (jPasswordField1.getPassword().length== 0) {
			JOptionPane.showMessageDialog(null, "支付密码不允许为空", "注意",JOptionPane.ERROR_MESSAGE);
		} else {
			String ppw=new String(jPasswordField1.getPassword());
			ModelFactory.pay(MyRender1.foodid, MyRender1.foodprice, ppw);
			MainJM.showTable1();
			this.dispose();
		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		this.dispose();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new pay().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPasswordField jPasswordField1;
}