package MyRend;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import view.*;

public class MyRender2 implements TableCellEditor,TableCellRenderer,ActionListener{
	private JTable td;
	JButton btn;
	public MyRender2(JTable td){
		this.td=td;
		btn= new JButton("∂©µ•π‹¿Ì");
		btn.addActionListener(this);
	}
	

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return btn;
	}

	@Override
	public void addCellEditorListener(CellEditorListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelCellEditing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return btn;
	}

	@Override
	public boolean isCellEditable(EventObject anEvent) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void removeCellEditorListener(CellEditorListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean shouldSelectCell(EventObject anEvent) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean stopCellEditing() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		// TODO Auto-generated method stub
		return btn;
	}

	public static String ordern;
	public static String shopn;
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int n=this.td.getSelectedRow();
		ordern=this.td.getValueAt(n, 0).toString();
		shopn=this.td.getValueAt(n, 3).toString();
		new unfinished().setVisible(true);
		
	}

}
