package com.hd.mytools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ListIterator;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

/**
 * 
 * @author Chunyun 程序的主界面
 */
public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	// 初始化各类组件
	Color frontcolor = Color.BLACK;
	JTextField command = new JTextField();
	BorderLayout borderLayout1 = new BorderLayout();
	JMenuBar jMenuBar1 = new JMenuBar();
	JPanel jPanel1 = new JPanel();
	JPanel jPanel2 = new JPanel();
	BorderLayout borderLayout3 = new BorderLayout();
	MyCanvas map = new MyCanvas();
	FlowLayout flowLayout1 = new FlowLayout();
	JButton openbt = new JButton();
	JButton newbt = new JButton();
	JButton fillb = new JButton();
	JButton link = new JButton("连接图形");// 实现连线功能的按钮
	JButton selectpointb = new JButton("选择图形");
	JButton paintfloatb = new JButton("");
	JButton paintrectb = new JButton("矩形");
	JMenu filebt = new JMenu();
	JMenuItem openmenu = new JMenuItem();
	ButtonGroup tbg = new ButtonGroup();
	// 定义初始化类
	Init init;
	JMenuItem savemenu = new JMenuItem();
	JMenuItem newmenu = new JMenuItem();
	JMenu picbt = new JMenu();
	JMenu colorbt = new JMenu();
	JMenuItem selectcmenu = new JMenuItem();
	JMenuItem saveasmenu = new JMenuItem();
	JButton rectfillb = new JButton();
	JButton floatfillb = new JButton();
	JButton eraseb = new JButton();
	JButton savebt = new JButton("保存");
	JToolBar jToolBar2 = new JToolBar();
	JMenu editbt = new JMenu();
	JMenuItem deletemenu = new JMenuItem();
	JMenu helpbt = new JMenu();
	JMenuItem aboutmenu = new JMenuItem();
	JPanel jPanel3 = new JPanel();
	BorderLayout borderLayout2 = new BorderLayout();
	colorpanel setcolorpane = new colorpanel();
	// 图形管理器
	JMenuItem managemenu = new JMenuItem();
	JButton deletebt = new JButton("删除");
	JButton movebt = new JButton("移动");
	JButton paintlineb = new JButton("直线");
	JButton paintpolb = new JButton("多边形");
	JButton polfillb = new JButton("填充多边形");
	JButton paintcurveb = new JButton("曲线");
	JMenuItem largemenu = new JMenuItem();
	JMenuItem propertiesmenu = new JMenuItem();
	JMenuItem smallmenu = new JMenuItem();
	MenuEnableThd menuthd = new MenuEnableThd();
	JMenuItem fillmenu = new JMenuItem();

	public MainWindow(Init init) {
		try {
			this.init = init;// 从主程序入口处传入
			jbInit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	void jbInit() throws Exception {
		// 窗口绘制操作
		this.setSize(800, 640);
		this.setTitle("MyTools");
		JPanel c = (JPanel) this.getContentPane();
		command.setBackground(Color.YELLOW);
		c.setLayout(borderLayout1);
		this.setFont(new java.awt.Font("宋体", 0, 18));
		this.setJMenuBar(jMenuBar1);
		jPanel2.setBorder(BorderFactory.createRaisedBevelBorder());
		jPanel2.setPreferredSize(new Dimension(80, 10));
		jPanel2.setLayout(flowLayout1);
		jPanel1.setDebugGraphicsOptions(0);
		jPanel1.setPreferredSize(new Dimension(500, 500));
		jPanel1.setLayout(borderLayout3);
		openbt.setPreferredSize(new Dimension(50, 50));
		openbt.setToolTipText("打开");
		openbt.setText("打开");
		openbt.addActionListener(new MainWindow_openbt_actionAdapter(this));
		newbt.setFont(new java.awt.Font("宋体", 0, 12));
		newbt.setPreferredSize(new Dimension(50, 50));
		newbt.setToolTipText("新建");
		newbt.setText("新建");
		newbt.addActionListener(new MainWindow_newbt_actionAdapter(this));
		fillb.setToolTipText("填充图形");
		fillb.setText("填充");
		fillb.addActionListener(new MainWindow_fillb_actionAdapter(this));
		selectpointb.setToolTipText("选择图形");
		selectpointb.setSelected(true);
		selectpointb.setText("选择");
		selectpointb
				.addActionListener(new MainWindow_selectpointb_actionAdapter(
						this));
		link.setToolTipText("连接图形");
		link.setSelected(true);
		link.setText("连接图形");
		link.addActionListener(new MainWindow_link_actionAdapter(this));

		paintfloatb.setToolTipText("绘制空心圆形");
		paintfloatb.setText("空心圆");
		paintfloatb.addActionListener(new MainWindow_paintfloatb_actionAdapter(
				this));
		flowLayout1.setAlignment(FlowLayout.LEFT);
		flowLayout1.setHgap(5);
		paintrectb.setToolTipText("绘制空心矩形");
		paintrectb.setText("空心矩形");
		paintrectb.addActionListener(new MainWindow_paintrectb_actionAdapter(
				this));
		map.addMouseMotionListener(new MainWindow_map_mouseMotionAdapter(this));
		savemenu.setVerifyInputWhenFocusTarget(true);
		savemenu.setFocusPainted(false);
		savemenu.setText("保存");
		savemenu.addActionListener(new MainWindow_savemenu_actionAdapter(this));
		openmenu.addActionListener(new MainWindow_openmenu_actionAdapter(this));
		newmenu.setText("新建");
		newmenu.addActionListener(new MainWindow_newmenu_actionAdapter(this));
		picbt.setText("图像");
		colorbt.setText("颜色");
		selectcmenu.setText("选择颜色...");
		selectcmenu.addActionListener(new MainWindow_selectcmenu_actionAdapter(
				this));
		saveasmenu.setText("另存为...");
		saveasmenu.addActionListener(new MainWindow_saveasmenu_actionAdapter(
				this));
		jMenuBar1.setDebugGraphicsOptions(0);
		rectfillb.setToolTipText("绘制实心矩形");
		rectfillb.setText("实心矩形");
		rectfillb
				.addActionListener(new MainWindow_rectfillb_actionAdapter(this));
		floatfillb.setToolTipText("绘制实心圆形");
		floatfillb.setFocusPainted(true);
		floatfillb.setText("填充圆形");
		floatfillb.addActionListener(new MainWindow_floatfillb_actionAdapter(
				this));
		eraseb.setToolTipText("删除图形");
		eraseb.setText("删除");
		eraseb.addActionListener(new MainWindow_eraseb_actionAdapter(this));
		savebt.setPreferredSize(new Dimension(50, 50));
		savebt.setToolTipText("保存");
		savebt.setText("保存");
		savebt.addActionListener(new MainWindow_savebt_actionAdapter(this));
		editbt.setText("编辑");
		deletemenu.setText("删除图形");
		deletemenu.addActionListener(new MainWindow_deletemenu_actionAdapter(
				this));
		helpbt.setText("帮助");
		aboutmenu.setText("关于...");
		aboutmenu.addActionListener(new MainWindow_fillb_actionAdapter(this));
		jPanel3.setLayout(borderLayout2);
		map.setBorder(BorderFactory.createLoweredBevelBorder());
		setcolorpane.setBorder(BorderFactory.createRaisedBevelBorder());
		setcolorpane.setPreferredSize(new Dimension(60, 80));
		setcolorpane.addMouseListener(new MainWindow_setcolorpane_mouseAdapter(
				this));
		managemenu.setText("图形管理器...");
		managemenu.addActionListener(new MainWindow_managemenu_actionAdapter(
				this));
		deletebt.addActionListener(new MainWindow_deletebt_actionAdapter(this));
		deletebt.setToolTipText("删除");
		deletebt.setText("删除");
		deletebt.setHorizontalTextPosition(SwingConstants.CENTER);
		movebt.setToolTipText("移动图形");
		movebt.setText("移动图形");
		movebt.addActionListener(new MainWindow_movebt_actionAdapter(this));
		paintlineb.setText("直线");
		paintlineb.setToolTipText("直线");
		paintlineb.addActionListener(new MainWindow_paintlineb_actionAdapter(
				this));
		paintpolb.setText("多边形");
		paintpolb.setToolTipText("多变形");
		paintpolb
				.addActionListener(new MainWindow_paintpolb_actionAdapter(this));
		polfillb.setText("填充多边形");
		polfillb.setToolTipText("填充多边形");
		polfillb.addActionListener(new MainWindow_polfillb_actionAdapter(this));
		paintcurveb.setText("曲线");
		paintcurveb.setToolTipText("曲线");
		paintcurveb.addActionListener(new MainWindow_paintcurveb_actionAdapter(
				this));
		largemenu.setText("放大");
		largemenu
				.addActionListener(new MainWindow_largemenu_actionAdapter(this));
		propertiesmenu.setText("属性...");
		propertiesmenu
				.addActionListener(new MainWindow_propertiesmenu_actionAdapter(
						this));
		smallmenu.setText("缩小");
		smallmenu
				.addActionListener(new MainWindow_smallmenu_actionAdapter(this));
		fillmenu.setText("填充");
		fillmenu.addActionListener(new MainWindow_fillb_actionAdapter(this));
		map.setBackground(Color.white);
		filebt.setText("文件");
		openmenu.setText("打开");
		c.add(jPanel1, BorderLayout.CENTER);
		jPanel1.add(map, BorderLayout.CENTER);
		jPanel1.add(command, BorderLayout.SOUTH);
		map.addMouseListener(new MainWindow_map_mouseAdapter(this));
		jPanel2.add(selectpointb, null);
		jPanel2.add(link, null);
		jPanel2.add(movebt, null);
		jPanel2.add(fillb, null);
		jPanel2.add(eraseb, null);
		jPanel2.add(paintrectb, null);
		jPanel2.add(rectfillb, null);
		jPanel2.add(paintfloatb, null);
		jPanel2.add(floatfillb, null);
		jPanel3.add(setcolorpane, BorderLayout.SOUTH);
		c.add(jToolBar2, BorderLayout.NORTH);
		jToolBar2.add(newbt, null);
		jToolBar2.add(openbt, null);
		jToolBar2.add(savebt, null);
		jToolBar2.add(deletebt, null);
		c.add(jPanel3, BorderLayout.WEST);
		jPanel3.add(jPanel2, BorderLayout.CENTER);
		jMenuBar1.add(filebt);
		jMenuBar1.add(editbt);
		jMenuBar1.add(picbt);
		jMenuBar1.add(colorbt);
		jMenuBar1.add(helpbt);
		filebt.add(newmenu);
		filebt.add(openmenu);
		filebt.add(savemenu);
		filebt.add(saveasmenu);
		colorbt.add(selectcmenu);
		editbt.add(deletemenu);
		helpbt.add(aboutmenu);
		picbt.add(managemenu);
		picbt.add(largemenu);
		picbt.add(smallmenu);
		picbt.add(fillmenu);
		picbt.add(propertiesmenu);
		jPanel2.add(paintpolb, null);
		// ~窗口绘制操作
		// command.getDocument().addDocumentListener(new DocumentListener(){
		//
		// public void changedUpdate(DocumentEvent e) {//这是更改操作的处理
		// String s = command.getText().trim();//trim()方法用于去掉你可能误输入的空格号
		// System.out.println(s);
		//
		// }
		// public void insertUpdate(DocumentEvent e) {//这是插入操作的处理
		// String s = command.getText().trim();
		// System.out.println(s);
		//
		// }
		// public void removeUpdate(DocumentEvent e) {//这是删除操作的处理
		// String s =command.getText().trim();
		// }
		//
		// });

		// 命令行创建图形的监听事件
		command.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					String commandLineString = command.getText().toLowerCase()
							.trim();
					String[] submit = commandLineString.split(" ");
					if (submit[0].equals("create")) {
						switch (submit[1]) {
						case "line":
							createLine(Integer.parseInt(submit[2]),
									Integer.parseInt(submit[3]),
									Integer.parseInt(submit[4]),
									Integer.parseInt(submit[5]));

							break;
						case "rect":
							createRect(Integer.parseInt(submit[2]),
									Integer.parseInt(submit[3]),
									Integer.parseInt(submit[4]),
									Integer.parseInt(submit[5]), submit[6]);
							break;
						case "circle":
							createCircle(Integer.parseInt(submit[2]),
									Integer.parseInt(submit[3]),
									Integer.parseInt(submit[4]),
									Integer.parseInt(submit[5]), submit[6]);
						default:
							break;
						}

					} else if (submit[0].equals("zoom")) {
						double tmp = Double.parseDouble(submit[1]);
						zoom(tmp);
					} else if (submit[0].equals("move")) {
						int m_x = Integer.parseInt(submit[1]);
						int m_y = Integer.parseInt(submit[2]);
						toMove(m_x, m_y);

					}

				}
			}

			private void toMove(int m_x, int m_y) {
				BaseShape bs = init.shapeset.getLastshape();
				if (bs != null) {
					int x, y;
					x = m_x;
					y = m_y;
					if (bs.type.equals("rect") || bs.type.equals("circle")) {
						bs.move(x, y);
					}
					if (bs.type.equals("polygon")) {
						Polygons p = (Polygons) bs;
						p.move(x, y);
					}
					if (bs.type.equals("line")) {
						Line l = (Line) bs;
						l.move(x, y);
					}
					if (bs.type.equals("curve")) {
						Curve c = (Curve) bs;
						c.move(x, y);
					}
				}
				init.frame.map.repaintx();
			}

			private void zoom(double a) {
				BaseShape tmp = init.shapeset.getLastshape();
				init.shapeDrawOpt.cur_shape = tmp;
				init.shapeDrawOpt.cur_shape.tolarge(a);
				map.repaintx();
			}

			private void createCircle(int parseInt, int parseInt2,
					int parseInt3, int parseInt4, String col) {
				Circle f = new Circle();
				f.s_x = parseInt;
				f.s_y = parseInt2;
				f.setedgecolor(frontcolor);
				init.shapeset.addLastshape(f);
				f = (Circle) init.shapeset.getLastshape();
				if (col != null && col.equals("fill")) {
					f.fill(frontcolor);
				}
				f.a_x = parseInt3 - f.s_x;
				f.b_y = parseInt4 - f.s_y;
				init.frame.map.repaint();

			}

			private void createRect(int parseInt, int parseInt2, int parseInt3,
					int parseInt4, String col) {

				Rect r = new Rect();
				r.s_x = parseInt;
				r.s_y = parseInt2;
				r.setedgecolor(frontcolor);
				init.shapeset.addLastshape(r);
				r = (Rect) init.shapeset.getLastshape();
				if (col != null && col.equals("fill")) {
					r.fill(frontcolor);
				}
				r.a_x = parseInt3 - r.s_x;
				r.b_y = parseInt4 - r.s_y;

				init.frame.map.repaint();

			}

			private void createLine(int parseInt, int parseInt2, int parseInt3,
					int parseInt4) {
				Line l = new Line();
				l.s_x = parseInt;
				l.s_y = parseInt2;
				l.setedgecolor(frontcolor);
				init.shapeset.addLastshape(l);

				l = (Line) init.shapeset.getLastshape();
				l.e_x = parseInt2;
				l.e_y = parseInt4;
				init.frame.map.repaint();
			}
		});
		jPanel2.add(polfillb, null);
		jPanel2.add(paintlineb, null);
		jPanel2.add(paintcurveb, null);
		menuthd.start();
	}

	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			menuthd.stopmark = true;
			System.exit(0);
		}
	}

	// 画布类
	class MyCanvas extends JPanel {
		private static final long serialVersionUID = 1L;

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			ListIterator<?> it = init.shapeset.shapeList.listIterator(0);
			while (it.hasNext()) {
				BaseShape s = (BaseShape) it.next();
				s.draw(g);
				if (init.shapeDrawOpt.cur_shape != null) {
					init.shapeDrawOpt.highlight(init.shapeDrawOpt.cur_shape);
				}
			}
		}

		public void repaintx() {
			paintComponent(this.getGraphics());
		}
	}

	// 前景色面板类
	public class colorpanel extends JPanel {
		private static final long serialVersionUID = 1L;

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setFont(new Font("宋体", 0, 13));
			g2d.drawString("前景色:", 12, 30);
			g2d.setColor(init.shapeDrawOpt.frontcolor);
			g2d.fillRect(30, 40, 20, 20);
		}
	}

	class MenuEnableThd extends Thread {
		boolean stopmark = false;

		public void run() {
			while (!stopmark) {
				// 只有选中图形选择按钮后才能进入改变图形的模式
				if (init.shapeDrawOpt.cur_shape != null) {
					largemenu.setEnabled(true);
					smallmenu.setEnabled(true);
					propertiesmenu.setEnabled(true);
					fillmenu.setEnabled(true);
				} else {
					largemenu.setEnabled(false);
					smallmenu.setEnabled(false);
					propertiesmenu.setEnabled(false);
					fillmenu.setEnabled(false);
				}
				if (init.shapeManOpt.copy_shape != null) {
				} else {
				}
			}
		}
	}

	void selectpointb_actionPerformed(ActionEvent e) {
		// 选择按钮事件
		map.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		init.shapeDrawOpt.cur_command = "select";
	}

	void link_actionPerformed(ActionEvent e) {
		// 连线按钮事件
		map.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		init.shapeDrawOpt.cur_command = "link";
		BaseShape tmp;
		tmp = init.shapeDrawOpt.cur_shape;
	}

	void fillb_actionPerformed(ActionEvent e) {
		// 填充按钮事件
		map.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		init.shapeDrawOpt.cur_command = "fill";
	}

	void paintrectb_actionPerformed(ActionEvent e) {
		// 绘制矩形按钮事件
		map.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		init.shapeDrawOpt.cur_command = "paintrect";
	}

	void paintfloatb_actionPerformed(ActionEvent e) {
		// 绘制圆形按钮事件
		map.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		init.shapeDrawOpt.cur_command = "paintfloat";
	}

	void map_mouseClicked(MouseEvent e) {
		// 鼠标单击事件
		init.shapeDrawOpt.mouseclick(e);
	}

	void map_mouseDragged(MouseEvent e) {
		// 鼠标拖动事件
		init.shapeDrawOpt.mousedrag(e);
	}

	void map_mousePressed(MouseEvent e) {
		// 鼠标按下事件
		init.shapeDrawOpt.mousepress(e);
	}

	void openmenu_actionPerformed(ActionEvent e) {
		// 打开目录项事件
		init.fileOpt.openEvent();

	}

	void savemenu_actionPerformed(ActionEvent e) {
		// 保存目录项事件
		init.fileOpt.saveEvent();
	}

	void newmenu_actionPerformed(ActionEvent e) {
		// 新建目录项事件
		init.fileOpt.newpic();
	}

	void selectcmenu_actionPerformed(ActionEvent e) {
		// 选择颜色目录项钮事件
		init.shapeDrawOpt.changecolor();
	}

	void rectfillb_actionPerformed(ActionEvent e) {
		// 填充矩形按钮事件
		map.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		init.shapeDrawOpt.cur_command = "paintfillrect";
	}

	void floatfillb_actionPerformed(ActionEvent e) {
		// 填充圆形按钮事件
		map.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		init.shapeDrawOpt.cur_command = "paintfillfloat";
	}

	void eraseb_actionPerformed(ActionEvent e) {
		// 删除图形按钮事件
		map.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		init.shapeDrawOpt.cur_command = "erase";
	}

	void newbt_actionPerformed(ActionEvent e) {
		// 新建按钮事件
		init.fileOpt.newpic();
	}

	void openbt_actionPerformed(ActionEvent e) {
		// 打开按钮事件
		init.fileOpt.openEvent();
	}

	void savebt_actionPerformed(ActionEvent e) {
		// 保存按钮事件
		init.fileOpt.saveEvent();
	}

	void deletemenu_actionPerformed(ActionEvent e) {
		// 删除图形目录事件
		init.shapeDrawOpt.erase(init.shapeDrawOpt.cur_shape);
	}

	void setcolorpane_mouseClicked(MouseEvent e) {
		// 选择颜色目录项事件
		init.shapeDrawOpt.changecolor();
	}

	void saveasmenu_actionPerformed(ActionEvent e) {
		// 保存目录项事件
		init.fileOpt.saveAs();
	}

	void managemenu_actionPerformed(ActionEvent e) {
		// 图形管理器目录项事件
		init.shapeManOpt.showShapeManage();
	}

	void deletebt_actionPerformed(ActionEvent e) {
		// 删除图形事件
		if (init.shapeDrawOpt.cur_shape != null) {
			init.shapeDrawOpt.erase(init.shapeDrawOpt.cur_shape);
		}
	}

	void movebt_actionPerformed(ActionEvent e) {
		// 移动图形事件
		map.setCursor(new Cursor(Cursor.MOVE_CURSOR));
		init.shapeDrawOpt.cur_command = "move";
	}

	void paintlineb_actionPerformed(ActionEvent e) {
		// 绘制直线事件
		map.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		init.shapeDrawOpt.cur_command = "startline";
	}

	void map_mouseMoved(MouseEvent e) {
		init.shapeDrawOpt.mousemoved(e);
	}

	void paintpolb_actionPerformed(ActionEvent e) {
		map.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		init.shapeDrawOpt.cur_command = "startpolygon";
	}

	void polfillb_actionPerformed(ActionEvent e) {
		map.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		init.shapeDrawOpt.cur_command = "startfillpolygon";
	}

	void paintcurveb_actionPerformed(ActionEvent e) {
		map.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		init.shapeDrawOpt.cur_command = "startcurve";
	}

	void largemenu_actionPerformed(ActionEvent e) {
		init.shapeDrawOpt.cur_shape.tolarge(1.1);
		map.repaintx();
	}

	void smallmenu_actionPerformed(ActionEvent e) {
		init.shapeDrawOpt.cur_shape.tolarge(0.9);
		map.repaintx();
	}

	void propertiesmenu_actionPerformed(ActionEvent e) {
		init.shapeManOpt.showpropertiesdialog();
	}

	void fillmenu_actionPerformed(ActionEvent e) {
		init.shapeDrawOpt.cur_shape.fill(init.shapeDrawOpt.frontcolor);
		map.repaintx();
	}

	void copymenu_actionPerformed(ActionEvent e) {
		init.shapeManOpt.copy_shape = init.shapeDrawOpt.cur_shape;
	}

	void pastemenu_actionPerformed(ActionEvent e) {
		init.shapeManOpt.copyshape();
	}

	// void aboutmenu_actionPerformed(ActionEvent e) {
	// init.shapeDrawOpt.logoshow();
	// }

}

class MainWindow_link_actionAdapter implements java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_link_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.link_actionPerformed(e);
	}
}

class MainWindow_selectpointb_actionAdapter implements
		java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_selectpointb_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.selectpointb_actionPerformed(e);
	}
}

class MainWindow_fillb_actionAdapter implements java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_fillb_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.fillb_actionPerformed(e);
	}
}

class MainWindow_paintrectb_actionAdapter implements
		java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_paintrectb_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.paintrectb_actionPerformed(e);
	}
}

class MainWindow_paintfloatb_actionAdapter implements
		java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_paintfloatb_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.paintfloatb_actionPerformed(e);
	}
}

class MainWindow_map_mouseAdapter extends MouseAdapter {
	MainWindow adaptee;

	MainWindow_map_mouseAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void mouseClicked(MouseEvent e) {
		adaptee.map_mouseClicked(e);
	}

	public void mousePressed(MouseEvent e) {
		adaptee.map_mousePressed(e);
	}
}

class MainWindow_map_mouseMotionAdapter extends
		java.awt.event.MouseMotionAdapter {
	MainWindow adaptee;

	MainWindow_map_mouseMotionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void mouseDragged(MouseEvent e) {
		adaptee.map_mouseDragged(e);
	}

	public void mouseMoved(MouseEvent e) {
		adaptee.map_mouseMoved(e);
	}
}

class MainWindow_openmenu_actionAdapter implements
		java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_openmenu_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.openmenu_actionPerformed(e);
	}
}

class MainWindow_savemenu_actionAdapter implements
		java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_savemenu_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.savemenu_actionPerformed(e);
	}
}

class MainWindow_newmenu_actionAdapter implements java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_newmenu_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.newmenu_actionPerformed(e);
	}
}

class MainWindow_selectcmenu_actionAdapter implements
		java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_selectcmenu_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.selectcmenu_actionPerformed(e);
	}
}

class MainWindow_rectfillb_actionAdapter implements
		java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_rectfillb_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.rectfillb_actionPerformed(e);
	}
}

class MainWindow_floatfillb_actionAdapter implements
		java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_floatfillb_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.floatfillb_actionPerformed(e);
	}
}

class MainWindow_eraseb_actionAdapter implements java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_eraseb_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.eraseb_actionPerformed(e);
	}
}

class MainWindow_newbt_actionAdapter implements java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_newbt_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.newbt_actionPerformed(e);
	}
}

class MainWindow_openbt_actionAdapter implements java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_openbt_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.openbt_actionPerformed(e);
	}
}

class MainWindow_savebt_actionAdapter implements java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_savebt_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.savebt_actionPerformed(e);
	}
}

class MainWindow_deletemenu_actionAdapter implements
		java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_deletemenu_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.deletemenu_actionPerformed(e);
	}
}

class MainWindow_setcolorpane_mouseAdapter extends java.awt.event.MouseAdapter {
	MainWindow adaptee;

	MainWindow_setcolorpane_mouseAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void mouseClicked(MouseEvent e) {
		adaptee.setcolorpane_mouseClicked(e);
	}
}

class MainWindow_saveasmenu_actionAdapter implements
		java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_saveasmenu_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.saveasmenu_actionPerformed(e);
	}
}

class MainWindow_managemenu_actionAdapter implements
		java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_managemenu_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.managemenu_actionPerformed(e);
	}
}

class MainWindow_deletebt_actionAdapter implements
		java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_deletebt_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.deletebt_actionPerformed(e);
	}
}

class MainWindow_movebt_actionAdapter implements java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_movebt_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.movebt_actionPerformed(e);
	}
}

class MainWindow_paintlineb_actionAdapter implements
		java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_paintlineb_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.paintlineb_actionPerformed(e);
	}
}

class MainWindow_paintpolb_actionAdapter implements
		java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_paintpolb_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.paintpolb_actionPerformed(e);
	}
}

class MainWindow_polfillb_actionAdapter implements
		java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_polfillb_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.polfillb_actionPerformed(e);
	}
}

class MainWindow_paintcurveb_actionAdapter implements
		java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_paintcurveb_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.paintcurveb_actionPerformed(e);
	}
}

class MainWindow_largemenu_actionAdapter implements
		java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_largemenu_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.largemenu_actionPerformed(e);
	}
}

class MainWindow_smallmenu_actionAdapter implements
		java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_smallmenu_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.smallmenu_actionPerformed(e);
	}
}

class MainWindow_propertiesmenu_actionAdapter implements
		java.awt.event.ActionListener {
	MainWindow adaptee;

	MainWindow_propertiesmenu_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.propertiesmenu_actionPerformed(e);
	}
}

class MainWindow_fillmenu_actionAdapter implements
		java.awt.event.ActionListener {
	MainWindow adaptee;

	public MainWindow_fillmenu_actionAdapter(MainWindow adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.fillmenu_actionPerformed(e);
	}
}
