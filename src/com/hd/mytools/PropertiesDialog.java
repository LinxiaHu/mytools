package com.hd.mytools;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.borland.jbcl.layout.*;

public class PropertiesDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	Init init;
	JPanel panel1 = new JPanel();
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JTextField shapenametf = new JTextField();
	FlowLayout flowLayout1 = new FlowLayout();
	JLabel jLabel3 = new JLabel();
	JSpinner changesizesp = new JSpinner();
	JPanel jPanel1 = new JPanel();
	XYLayout xYLayout1 = new XYLayout();
	JButton okbt = new JButton();
	JButton cancelbt = new JButton();
	SpinnerNumberModel nummodel = new SpinnerNumberModel();

	public PropertiesDialog(Init v) {
		super(new Frame(), "属性", false);
		init = v;
		try {
			jbInit();
			pack();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void jbInit() throws Exception {
		panel1.setLayout(flowLayout1);
		jLabel1.setFont(new java.awt.Font("宋体", 0, 13));
		jLabel1.setText("图形名称");
		panel1.setMaximumSize(new Dimension(2147483647, 2147483647));
		panel1.setPreferredSize(new Dimension(300, 250));
		jLabel2.setFont(new java.awt.Font("宋体", 0, 13));
		jLabel2.setText("图形类型");
		this.setResizable(false);
		shapetypetf.setPreferredSize(new Dimension(200, 25));
		shapetypetf.setEditable(false);
		shapetypetf.setText("");
		shapenametf.setPreferredSize(new Dimension(200, 25));
		shapenametf.setText("");
		flowLayout1.setHgap(20);
		flowLayout1.setVgap(20);
		jLabel3.setFont(new java.awt.Font("宋体", 0, 13));
		jLabel3.setText("缩    放");
		changesizesp.setMinimumSize(new Dimension(25, 15));
		changesizesp.setPreferredSize(new Dimension(60, 25));
		jPanel1.setPreferredSize(new Dimension(300, 150));
		jPanel1.setRequestFocusEnabled(true);
		jPanel1.setLayout(xYLayout1);
		okbt.setFont(new java.awt.Font("宋体", 0, 12));
		okbt.setText("确定");
		okbt.addActionListener(new PropertiesDialog_okbt_actionAdapter(this));
		cancelbt.setFont(new java.awt.Font("宋体", 0, 12));
		cancelbt.setText("取消");
		cancelbt.addActionListener(new PropertiesDialog_cancelbt_actionAdapter(
				this));
		getContentPane().add(panel1);
		panel1.add(jLabel2, null);
		panel1.add(shapetypetf, null);
		panel1.add(jLabel1, null);
		panel1.add(shapenametf, null);
		panel1.add(jPanel1, null);
		jPanel1.add(okbt, new XYConstraints(19, 77, 92, 26));
		jPanel1.add(cancelbt, new XYConstraints(170, 78, 92, 26));
		jPanel1.add(jLabel3, new XYConstraints(13, 3, -1, -1));
		jPanel1.add(changesizesp, new XYConstraints(86, 1, -1, -1));
		this.setSize(new Dimension(300, 250));
		this.setLocation(400, 150);
		if (init.shapeDrawOpt.cur_shape != null) {
			this.shapetypetf.setText(init.shapeDrawOpt.cur_shape.type);
			this.shapenametf.setText(init.shapeDrawOpt.cur_shape.name);
		}
		nummodel.setMaximum(new Double(10.0));
		nummodel.setMinimum(new Double(0.1));
		nummodel.setStepSize(new Double(0.1));
		nummodel.setValue(new Double(1.0));
		changesizesp.setModel(nummodel);
		this.setVisible(true);
	}

	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			this.dispose();
		}
	}

	void okbt_actionPerformed(ActionEvent e) {
		if (shapenametf.getText().equals("")) {
			JOptionPane.showMessageDialog(new JFrame(), "图形名称不能为空", "警告",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		init.shapeDrawOpt.cur_shape.name = shapenametf.getText();
		init.shapeDrawOpt.cur_shape.tolarge(((Double) nummodel.getNumber())
				.doubleValue());
		init.frame.map.repaintx();
		if (init.shapeman != null) {
			init.shapeManOpt.renewlist();
		}
		this.dispose();
	}

	void cancelbt_actionPerformed(ActionEvent e) {
		this.dispose();
	}

}

class PropertiesDialog_okbt_actionAdapter implements
		java.awt.event.ActionListener {
	PropertiesDialog adaptee;

	PropertiesDialog_okbt_actionAdapter(PropertiesDialog adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.okbt_actionPerformed(e);
	}
}

class PropertiesDialog_cancelbt_actionAdapter implements
		java.awt.event.ActionListener {
	PropertiesDialog adaptee;

	PropertiesDialog_cancelbt_actionAdapter(PropertiesDialog adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.cancelbt_actionPerformed(e);
	}
}
