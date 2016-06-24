package me.test.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Toolkit tk = Toolkit.getDefaultToolkit();  
    Dimension d = tk.getScreenSize();  
    JPanel panel;  
    public MyJFrame() {  
        panel = new MyPanel();  
        this.add(panel);  
        this.setSize((int) d.getWidth() / 2, (int) d.getHeight() / 2);  
        this.setLocation((int) (d.getWidth() - this.getWidth()) / 2, (int) (d.getHeight() - this.getHeight()) / 2);  
        this.setResizable(false);  
    } 
    

}
