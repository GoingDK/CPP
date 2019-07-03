package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import MyRend.MyRender4;
import MyRend.MyRender5;
import model.ModelFactory;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Searchfood0 extends JFrame {

	private JPanel contentPane;
	JTable table= null;
	DefaultTableModel model =new DefaultTableModel() ;
	public void showTable() {//吃
		model.setRowCount( 0 );
		model.setColumnIdentifiers(new Object[]{"食品id", "食品名称","食品价格","所属商家",""});
		ModelFactory m=new ModelFactory();
  		m.searchfood(MainJMunregistered.name);
  		int[] id;
  		String[] foodn;
  		String[] price;
  		String[] youhui;
  		String[] shopname;
  		int one;
  		String two=null;
  		String three=null;
  		String four=null;
  		double five;
  		String six;
  		id=m.id;
  		foodn=m.foodn;
  		price=m.price;
  		youhui=m.youhui;
  		shopname=m.shopname;
  		for(int b=0;b<id.length;) {
  			one=id[b];
  			two=foodn[b];
  			three=price[b];
  			four=youhui[b];
  			five=Double.parseDouble(three)*Double.parseDouble(four);
  			six=shopname[b];
  			b++;
  			model.addRow(new Object[]{one,two,five,six,null}); 
  		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Searchfood0 frame = new Searchfood0();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Searchfood0() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel label = new JLabel("\u67E5\u8BE2\u98DF\u54C1\u7ED3\u679C");
		label.setFont(new Font("宋体", Font.BOLD, 20));
		
		showTable();
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setCellEditor(new MyRender5(table));
  		table.getColumnModel().getColumn(4).setCellRenderer(new MyRender5(table));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(13)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(44, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(194, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(43))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(button)
					.addContainerGap(51, Short.MAX_VALUE))
		);
		
		contentPane.setLayout(gl_contentPane);
	}

}
