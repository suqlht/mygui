package me.test.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JComboBox<String> gadgetCombo;
	JButton okBtn;
	JButton exitBtn;
	JButton nextStepBtn;
	String[] strItems = { "All", "Bird", "Cat", "Dog", "Rabbit", "Pig" };
	JFileChooser chooser = new JFileChooser();

	public MyPanel() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		okBtn = new JButton("OK");
		exitBtn = new JButton("Exit");
		nextStepBtn = new JButton("Next");
		gadgetCombo = createGadgetCombo();
		nextStepBtn.addActionListener(this);
		okBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		gadgetCombo.addActionListener(this);
		this.add(okBtn);
		this.add(exitBtn);
		this.add(nextStepBtn);
		this.add(gadgetCombo);
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
			JOptionPane.showMessageDialog(null, (String) gadgetCombo.getSelectedItem());
		} else if (source == gadgetCombo) {
			handleComboEvent(gadgetCombo, e);
		}

		else if (source == exitBtn) {
			JOptionPane.showMessageDialog(null, "You click the Exit Button.");
			System.exit(0);
		}
		else if(source == nextStepBtn){
			Container parent = this.getParent();
			parent.removeAll();
			parent.add(new EditPanel());
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
