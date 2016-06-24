package me.test.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EditPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTable dataTable ;
	JButton okBtn;
	JButton exitBtn;
	String[] strItems = { "All", "Bird", "Cat", "Dog", "Rabbit", "Pig" };
	String[] columnNames = {"code","descr","defaultValue","TYPE"};

	Object[][] obj = new Object[2][6]; 
	
	public EditPanel() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		dataTable = createTable();
		okBtn = new JButton("Save");
		exitBtn = new JButton("Back");
		
		JScrollPane scroll = new JScrollPane(dataTable);
		
		okBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		this.add(okBtn);
		this.add(exitBtn);
		this.add(scroll);
	}

	private JTable createTable() {
		// TODO Auto-generated method stub
		for( int i =0; i < 2; i++){
			for(int j =0; j < 4; j++){
				obj[i][j] = "value_"+String.valueOf(i) +"_"+String.valueOf(j);
			}
		}
		JTable table = new JTable(obj, this.columnNames);
		return table;
	}

	private JComboBox<String> createGadgetCombo() {
		// TODO Auto-generated method stub

		JComboBox<String> combo = new JComboBox<String>(strItems);
		combo.setEditable(true);

		return combo;
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == okBtn) {
			if(dataTable.isEditing()){
				dataTable.getCellEditor().stopCellEditing();
			}
			javax.swing.table.TableModel model = dataTable.getModel();
			JOptionPane.showMessageDialog(null, model.getValueAt(1, 1));
		} 
		else if (source == exitBtn) {
			Container parent = this.getParent();
			parent.removeAll();
			parent.add(new MyPanel());
			parent.revalidate();
			parent.repaint();
		}

	}

	private void handleComboEvent(JComboBox combo, ActionEvent e) {
		if (e.getActionCommand().equals("comboBoxEdited")) {
			String filter = (String) combo.getSelectedItem();
			combo.removeAllItems();

			for (String item : this.strItems) {
				if (filter == null || filter.equals("") || item.contains(filter)) {
					combo.insertItemAt(item, combo.getItemCount());
				}
			}
			if (filter != null && !filter.equals("")) {
				combo.setSelectedItem(filter);
			}

			combo.showPopup();
		}
	}

}
