package com.hd.mytools;

import java.awt.*;
import javax.swing.*;
import com.borland.jbcl.layout.*;
import java.awt.event.*;

public class MyLogo extends JWindow {

	private static final long serialVersionUID = 1L;
	Image logoimage;
	JButton close = new JButton();
	XYLayout xYLayout1 = new XYLayout();

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(logoimage, 0, 0, this);
	}

	public MyLogo(String imagename) {
		init(imagename);
	}

	private void init(String imagename) throws HeadlessException {
		logoimage = Toolkit.getDefaultToolkit().getImage(imagename);
		this.setLocation(getToolkit().getScreenSize().width / 2 - 400 / 2,
				getToolkit().getScreenSize().height / 2 - 330 / 2);
		this.setSize(550, 330);
		close.setFont(new Font("ËÎÌå", 0, 12));
		close.setText("È·¶¨");
		this.getContentPane().setLayout(xYLayout1);
		this.getContentPane().add(close, new XYConstraints(430, 231, 86, -1));
		this.getContentPane().setBackground(SystemColor.menu);
		close.addActionListener(new MyLogo_close_actionAdapter(this));
		this.setVisible(true);
	}

	void close_actionPerformed(ActionEvent e) {
		this.dispose();
	}
}

class MyLogo_close_actionAdapter implements java.awt.event.ActionListener {
	MyLogo adaptee;

	MyLogo_close_actionAdapter(MyLogo adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.close_actionPerformed(e);
	}
}
