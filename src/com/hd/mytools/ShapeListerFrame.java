package com.hd.mytools;

import javax.swing.*;

import java.awt.*;
import java.util.*;
import java.awt.event.*;

import com.borland.jbcl.layout.*;

import javax.swing.event.*;

public class ShapeListerFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	Init init;
	// 初始化各类组件
	BorderLayout borderLayout1 = new BorderLayout();
	JPanel jPanel1 = new JPanel();
	@SuppressWarnings("rawtypes")
	DefaultListModel items = new DefaultListModel();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	JList shapelist = new JList(items);
	JButton upbt = new JButton();
	JButton downbt = new JButton();
	JButton totopbt = new JButton();
	JButton tobottombt = new JButton();
	Image manageicon = Toolkit.getDefaultToolkit().getImage(
			"icons/manageicon.gif");
	JButton deletebt = new JButton();
	XYLayout xYLayout1 = new XYLayout();
	JButton okbt = new JButton();
	JScrollPane jScrollPane1 = new JScrollPane();
	BottonEnableThd btthd = new BottonEnableThd();
	JButton properbt = new JButton();

	public ShapeListerFrame(Init v) {
		init = v;
		try {
			jbInit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	void jbInit() throws Exception {
		// 窗体绘制代码
		this.setLocation(400, 150);
		this.setSize(500, 300);
		this.setIconImage(manageicon);
		this.setResizable(false);
		this.setTitle("图形管理器");
		Container c = this.getContentPane();
		c.setLayout(borderLayout1);
		upbt.setFont(new java.awt.Font("宋体", 0, 13));
		upbt.setText("上移一层");
		upbt.addActionListener(new ShapeLister_upbt_actionAdapter(this));
		downbt.setFont(new java.awt.Font("宋体", 0, 13));
		downbt.setText("下移一层");
		downbt.addActionListener(new ShapeListerFrame_downbt_actionAdapter(this));
		totopbt.setFont(new java.awt.Font("宋体", 0, 13));
		totopbt.setText("至于顶端");
		totopbt.addActionListener(new ShapeListerFrame_totopbt_actionAdapter(
				this));
		tobottombt.setFont(new java.awt.Font("宋体", 0, 13));
		tobottombt.setText("至于底端");
		tobottombt
				.addActionListener(new ShapeListerFrame_tobottombt_actionAdapter(
						this));
		jPanel1.setFont(new java.awt.Font("宋体", 0, 13));
		jPanel1.setBorder(BorderFactory.createRaisedBevelBorder());
		jPanel1.setPreferredSize(new Dimension(120, 0));
		jPanel1.setLayout(xYLayout1);
		shapelist.setBorder(BorderFactory.createLoweredBevelBorder());
		shapelist
				.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		shapelist
				.addListSelectionListener(new ShapeLister_shapelist_listSelectionAdapter(
						this));
		deletebt.setFont(new java.awt.Font("宋体", 0, 13));
		deletebt.setText("删除图形");
		deletebt.addActionListener(new ShapeListerFrame_deletebt_actionAdapter(
				this));
		okbt.setFont(new java.awt.Font("宋体", 0, 13));
		okbt.setText("关闭");
		okbt.addActionListener(new ShapeListerFrame_okbt_actionAdapter(this));
		properbt.setFont(new java.awt.Font("宋体", 0, 13));
		properbt.setText("属性");
		properbt.addActionListener(new ShapeListerFrame_properbt_actionAdapter(
				this));
		jPanel1.add(upbt, new XYConstraints(16, 5, -1, -1));
		jPanel1.add(downbt, new XYConstraints(16, 35, -1, -1));
		jPanel1.add(totopbt, new XYConstraints(16, 65, -1, -1));
		jPanel1.add(tobottombt, new XYConstraints(16, 95, -1, -1));
		jPanel1.add(okbt, new XYConstraints(16, 234, 85, -1));
		jPanel1.add(deletebt, new XYConstraints(17, 127, -1, -1));
		jPanel1.add(properbt, new XYConstraints(17, 159, 85, -1));
		c.add(jScrollPane1, BorderLayout.CENTER);
		jScrollPane1.getViewport().add(shapelist, null);
		c.add(jPanel1, BorderLayout.EAST);
		upbt.setEnabled(false);
		downbt.setEnabled(false);
		totopbt.setEnabled(false);
		tobottombt.setEnabled(false);
		deletebt.setEnabled(false);
		properbt.setEnabled(false);
		// ~窗体绘制代码
		items.removeAllElements();
		shapelist.removeAll();
		ListIterator<BaseShape> it = init.shapeset.getIterator();
		while (it.hasNext()) {
			BaseShape s = (BaseShape) it.next();
			items.add(0, s.name + ":" + s.type);
		}
		// btthd = new BottonEnableThd();
		// btthd.start();
		this.setVisible(true);
	}

	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			// btthd.stop();
			this.dispose();
		}
	}

	void upbt_actionPerformed(ActionEvent e) {

		// 上移一层操作
		init.shapeManOpt.upLayer(e);
	}

	void downbt_actionPerformed(ActionEvent e) {

		// 下移一层操作
		init.shapeManOpt.downLayer(e);
	}

	void totopbt_actionPerformed(ActionEvent e) {

		// 至于顶端操作
		init.shapeManOpt.toTopLayer(e);
	}

	void tobottombt_actionPerformed(ActionEvent e) {

		// 至于底端操作
		init.shapeManOpt.toBottomLayer(e);
	}

	void deletebt_actionPerformed(ActionEvent e) {

		// 删除一个图形操作
		init.shapeDrawOpt.erase(init.shapeDrawOpt.cur_shape);
	}

	void shapelist_valueChanged(ListSelectionEvent e) {

		// 列表选择操作
		upbt.setEnabled(true);
		downbt.setEnabled(true);
		totopbt.setEnabled(true);
		tobottombt.setEnabled(true);
		deletebt.setEnabled(true);
		properbt.setEnabled(true);
		if (shapelist.getSelectedIndex() == items.size() - 1) {
			downbt.setEnabled(false);
			tobottombt.setEnabled(false);
		}
		if (shapelist.getSelectedIndex() == 0) {
			upbt.setEnabled(false);
			totopbt.setEnabled(false);
		}

		init.shapeManOpt.shapelistvalueChanged(e);
	}

	void okbt_actionPerformed(ActionEvent e) {

		// 关闭按钮操作
		// btthd.stop();
		this.dispose();
	}

	class BottonEnableThd extends Thread {

		boolean stopmark = false;

		public void run() {
			while (true) {
				if (stopmark) {
					break;
				}
				if (shapelist.getSelectedIndex() == items.size() - 1) {
					downbt.setEnabled(false);
					tobottombt.setEnabled(false);
					upbt.setEnabled(true);
					totopbt.setEnabled(true);
					continue;
				}
				if (shapelist.getSelectedIndex() == 0) {
					upbt.setEnabled(false);
					totopbt.setEnabled(false);
					tobottombt.setEnabled(true);
					deletebt.setEnabled(true);
					continue;
				}
				upbt.setEnabled(true);
				downbt.setEnabled(true);
				totopbt.setEnabled(true);
				tobottombt.setEnabled(true);
				deletebt.setEnabled(true);
			}

		}
	}

	void properbt_actionPerformed(ActionEvent e) {
		init.shapeManOpt.showpropertiesdialog();
	}

}

// 事件监视器类

class ShapeLister_upbt_actionAdapter implements java.awt.event.ActionListener {
	ShapeListerFrame adaptee;

	ShapeLister_upbt_actionAdapter(ShapeListerFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.upbt_actionPerformed(e);
	}
}

class ShapeLister_shapelist_listSelectionAdapter implements
		javax.swing.event.ListSelectionListener {
	ShapeListerFrame adaptee;

	ShapeLister_shapelist_listSelectionAdapter(ShapeListerFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void valueChanged(ListSelectionEvent e) {
		adaptee.shapelist_valueChanged(e);
	}
}

class ShapeListerFrame_downbt_actionAdapter implements
		java.awt.event.ActionListener {
	ShapeListerFrame adaptee;

	ShapeListerFrame_downbt_actionAdapter(ShapeListerFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.downbt_actionPerformed(e);
	}
}

class ShapeListerFrame_totopbt_actionAdapter implements
		java.awt.event.ActionListener {
	ShapeListerFrame adaptee;

	ShapeListerFrame_totopbt_actionAdapter(ShapeListerFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.totopbt_actionPerformed(e);
	}
}

class ShapeListerFrame_tobottombt_actionAdapter implements
		java.awt.event.ActionListener {
	ShapeListerFrame adaptee;

	ShapeListerFrame_tobottombt_actionAdapter(ShapeListerFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.tobottombt_actionPerformed(e);
	}
}

class ShapeListerFrame_deletebt_actionAdapter implements
		java.awt.event.ActionListener {
	ShapeListerFrame adaptee;

	ShapeListerFrame_deletebt_actionAdapter(ShapeListerFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.deletebt_actionPerformed(e);
	}
}

class ShapeListerFrame_okbt_actionAdapter implements
		java.awt.event.ActionListener {
	ShapeListerFrame adaptee;

	ShapeListerFrame_okbt_actionAdapter(ShapeListerFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.okbt_actionPerformed(e);
	}
}

// ~事件监视器类=============================================

class ShapeListerFrame_properbt_actionAdapter implements
		java.awt.event.ActionListener {
	ShapeListerFrame adaptee;

	ShapeListerFrame_properbt_actionAdapter(ShapeListerFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.properbt_actionPerformed(e);
	}
}
