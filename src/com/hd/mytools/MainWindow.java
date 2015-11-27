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
 * @author Chunyun �����������
 */
public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	// ��ʼ���������
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
	JButton link = new JButton("����ͼ��");// ʵ�����߹��ܵİ�ť
	JButton selectpointb = new JButton("ѡ��ͼ��");
	JButton paintfloatb = new JButton("");
	JButton paintrectb = new JButton("����");
	JMenu filebt = new JMenu();
	JMenuItem openmenu = new JMenuItem();
	ButtonGroup tbg = new ButtonGroup();
	// �����ʼ����
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
	JButton savebt = new JButton("����");
	JToolBar jToolBar2 = new JToolBar();
	JMenu editbt = new JMenu();
	JMenuItem deletemenu = new JMenuItem();
	JMenu helpbt = new JMenu();
	JMenuItem aboutmenu = new JMenuItem();
	JPanel jPanel3 = new JPanel();
	BorderLayout borderLayout2 = new BorderLayout();
	colorpanel setcolorpane = new colorpanel();
	// ͼ�ι�����
	JMenuItem managemenu = new JMenuItem();
	JButton deletebt = new JButton("ɾ��");
	JButton movebt = new JButton("�ƶ�");
	JButton paintlineb = new JButton("ֱ��");
	JButton paintpolb = new JButton("�����");
	JButton polfillb = new JButton("�������");
	JButton paintcurveb = new JButton("����");
	JMenuItem largemenu = new JMenuItem();
	JMenuItem propertiesmenu = new JMenuItem();
	JMenuItem smallmenu = new JMenuItem();
	MenuEnableThd menuthd = new MenuEnableThd();
	JMenuItem fillmenu = new JMenuItem();

	public MainWindow(Init init) {
		try {
			this.init = init;// ����������ڴ�����
			jbInit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	void jbInit() throws Exception {
		// ���ڻ��Ʋ���
		this.setSize(800, 640);
		this.setTitle("MyTools");
		JPanel c = (JPanel) this.getContentPane();
		command.setBackground(Color.YELLOW);
		c.setLayout(borderLayout1);
		this.setFont(new java.awt.Font("����", 0, 18));
		this.setJMenuBar(jMenuBar1);
		jPanel2.setBorder(BorderFactory.createRaisedBevelBorder());
		jPanel2.setPreferredSize(new Dimension(80, 10));
		jPanel2.setLayout(flowLayout1);
		jPanel1.setDebugGraphicsOptions(0);
		jPanel1.setPreferredSize(new Dimension(500, 500));
		jPanel1.setLayout(borderLayout3);
		openbt.setPreferredSize(new Dimension(50, 50));
		openbt.setToolTipText("��");
		openbt.setText("��");
		openbt.addActionListener(new MainWindow_openbt_actionAdapter(this));
		newbt.setFont(new java.awt.Font("����", 0, 12));
		newbt.setPreferredSize(new Dimension(50, 50));
		newbt.setToolTipText("�½�");
		newbt.setText("�½�");
		newbt.addActionListener(new MainWindow_newbt_actionAdapter(this));
		fillb.setToolTipText("���ͼ��");
		fillb.setText("���");
		fillb.addActionListener(new MainWindow_fillb_actionAdapter(this));
		selectpointb.setToolTipText("ѡ��ͼ��");
		selectpointb.setSelected(true);
		selectpointb.setText("ѡ��");
		selectpointb
				.addActionListener(new MainWindow_selectpointb_actionAdapter(
						this));
		link.setToolTipText("����ͼ��");
		link.setSelected(true);
		link.setText("����ͼ��");
		link.addActionListener(new MainWindow_link_actionAdapter(this));

		paintfloatb.setToolTipText("���ƿ���Բ��");
		paintfloatb.setText("����Բ");
		paintfloatb.addActionListener(new MainWindow_paintfloatb_actionAdapter(
				this));
		flowLayout1.setAlignment(FlowLayout.LEFT);
		flowLayout1.setHgap(5);
		paintrectb.setToolTipText("���ƿ��ľ���");
		paintrectb.setText("���ľ���");
		paintrectb.addActionListener(new MainWindow_paintrectb_actionAdapter(
				this));
		map.addMouseMotionListener(new MainWindow_map_mouseMotionAdapter(this));
		savemenu.setVerifyInputWhenFocusTarget(true);
		savemenu.setFocusPainted(false);
		savemenu.setText("����");
		savemenu.addActionListener(new MainWindow_savemenu_actionAdapter(this));
		openmenu.addActionListener(new MainWindow_openmenu_actionAdapter(this));
		newmenu.setText("�½�");
		newmenu.addActionListener(new MainWindow_newmenu_actionAdapter(this));
		picbt.setText("ͼ��");
		colorbt.setText("��ɫ");
		selectcmenu.setText("ѡ����ɫ...");
		selectcmenu.addActionListener(new MainWindow_selectcmenu_actionAdapter(
				this));
		saveasmenu.setText("���Ϊ...");
		saveasmenu.addActionListener(new MainWindow_saveasmenu_actionAdapter(
				this));
		jMenuBar1.setDebugGraphicsOptions(0);
		rectfillb.setToolTipText("����ʵ�ľ���");
		rectfillb.setText("ʵ�ľ���");
		rectfillb
				.addActionListener(new MainWindow_rectfillb_actionAdapter(this));
		floatfillb.setToolTipText("����ʵ��Բ��");
		floatfillb.setFocusPainted(true);
		floatfillb.setText("���Բ��");
		floatfillb.addActionListener(new MainWindow_floatfillb_actionAdapter(
				this));
		eraseb.setToolTipText("ɾ��ͼ��");
		eraseb.setText("ɾ��");
		eraseb.addActionListener(new MainWindow_eraseb_actionAdapter(this));
		savebt.setPreferredSize(new Dimension(50, 50));
		savebt.setToolTipText("����");
		savebt.setText("����");
		savebt.addActionListener(new MainWindow_savebt_actionAdapter(this));
		editbt.setText("�༭");
		deletemenu.setText("ɾ��ͼ��");
		deletemenu.addActionListener(new MainWindow_deletemenu_actionAdapter(
				this));
		helpbt.setText("����");
		aboutmenu.setText("����...");
		aboutmenu.addActionListener(new MainWindow_fillb_actionAdapter(this));
		jPanel3.setLayout(borderLayout2);
		map.setBorder(BorderFactory.createLoweredBevelBorder());
		setcolorpane.setBorder(BorderFactory.createRaisedBevelBorder());
		setcolorpane.setPreferredSize(new Dimension(60, 80));
		setcolorpane.addMouseListener(new MainWindow_setcolorpane_mouseAdapter(
				this));
		managemenu.setText("ͼ�ι�����...");
		managemenu.addActionListener(new MainWindow_managemenu_actionAdapter(
				this));
		deletebt.addActionListener(new MainWindow_deletebt_actionAdapter(this));
		deletebt.setToolTipText("ɾ��");
		deletebt.setText("ɾ��");
		deletebt.setHorizontalTextPosition(SwingConstants.CENTER);
		movebt.setToolTipText("�ƶ�ͼ��");
		movebt.setText("�ƶ�ͼ��");
		movebt.addActionListener(new MainWindow_movebt_actionAdapter(this));
		paintlineb.setText("ֱ��");
		paintlineb.setToolTipText("ֱ��");
		paintlineb.addActionListener(new MainWindow_paintlineb_actionAdapter(
				this));
		paintpolb.setText("�����");
		paintpolb.setToolTipText("�����");
		paintpolb
				.addActionListener(new MainWindow_paintpolb_actionAdapter(this));
		polfillb.setText("�������");
		polfillb.setToolTipText("�������");
		polfillb.addActionListener(new MainWindow_polfillb_actionAdapter(this));
		paintcurveb.setText("����");
		paintcurveb.setToolTipText("����");
		paintcurveb.addActionListener(new MainWindow_paintcurveb_actionAdapter(
				this));
		largemenu.setText("�Ŵ�");
		largemenu
				.addActionListener(new MainWindow_largemenu_actionAdapter(this));
		propertiesmenu.setText("����...");
		propertiesmenu
				.addActionListener(new MainWindow_propertiesmenu_actionAdapter(
						this));
		smallmenu.setText("��С");
		smallmenu
				.addActionListener(new MainWindow_smallmenu_actionAdapter(this));
		fillmenu.setText("���");
		fillmenu.addActionListener(new MainWindow_fillb_actionAdapter(this));
		map.setBackground(Color.white);
		filebt.setText("�ļ�");
		openmenu.setText("��");
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
		// ~���ڻ��Ʋ���
		// command.getDocument().addDocumentListener(new DocumentListener(){
		//
		// public void changedUpdate(DocumentEvent e) {//���Ǹ��Ĳ����Ĵ���
		// String s = command.getText().trim();//trim()��������ȥ�������������Ŀո��
		// System.out.println(s);
		//
		// }
		// public void insertUpdate(DocumentEvent e) {//���ǲ�������Ĵ���
		// String s = command.getText().trim();
		// System.out.println(s);
		//
		// }
		// public void removeUpdate(DocumentEvent e) {//����ɾ�������Ĵ���
		// String s =command.getText().trim();
		// }
		//
		// });

		// �����д���ͼ�εļ����¼�
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

	// ������
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

	// ǰ��ɫ�����
	public class colorpanel extends JPanel {
		private static final long serialVersionUID = 1L;

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setFont(new Font("����", 0, 13));
			g2d.drawString("ǰ��ɫ:", 12, 30);
			g2d.setColor(init.shapeDrawOpt.frontcolor);
			g2d.fillRect(30, 40, 20, 20);
		}
	}

	class MenuEnableThd extends Thread {
		boolean stopmark = false;

		public void run() {
			while (!stopmark) {
				// ֻ��ѡ��ͼ��ѡ��ť����ܽ���ı�ͼ�ε�ģʽ
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
		// ѡ��ť�¼�
		map.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		init.shapeDrawOpt.cur_command = "select";
	}

	void link_actionPerformed(ActionEvent e) {
		// ���߰�ť�¼�
		map.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		init.shapeDrawOpt.cur_command = "link";
		BaseShape tmp;
		tmp = init.shapeDrawOpt.cur_shape;
	}

	void fillb_actionPerformed(ActionEvent e) {
		// ��䰴ť�¼�
		map.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		init.shapeDrawOpt.cur_command = "fill";
	}

	void paintrectb_actionPerformed(ActionEvent e) {
		// ���ƾ��ΰ�ť�¼�
		map.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		init.shapeDrawOpt.cur_command = "paintrect";
	}

	void paintfloatb_actionPerformed(ActionEvent e) {
		// ����Բ�ΰ�ť�¼�
		map.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		init.shapeDrawOpt.cur_command = "paintfloat";
	}

	void map_mouseClicked(MouseEvent e) {
		// ��굥���¼�
		init.shapeDrawOpt.mouseclick(e);
	}

	void map_mouseDragged(MouseEvent e) {
		// ����϶��¼�
		init.shapeDrawOpt.mousedrag(e);
	}

	void map_mousePressed(MouseEvent e) {
		// ��갴���¼�
		init.shapeDrawOpt.mousepress(e);
	}

	void openmenu_actionPerformed(ActionEvent e) {
		// ��Ŀ¼���¼�
		init.fileOpt.openEvent();

	}

	void savemenu_actionPerformed(ActionEvent e) {
		// ����Ŀ¼���¼�
		init.fileOpt.saveEvent();
	}

	void newmenu_actionPerformed(ActionEvent e) {
		// �½�Ŀ¼���¼�
		init.fileOpt.newpic();
	}

	void selectcmenu_actionPerformed(ActionEvent e) {
		// ѡ����ɫĿ¼��ť�¼�
		init.shapeDrawOpt.changecolor();
	}

	void rectfillb_actionPerformed(ActionEvent e) {
		// �����ΰ�ť�¼�
		map.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		init.shapeDrawOpt.cur_command = "paintfillrect";
	}

	void floatfillb_actionPerformed(ActionEvent e) {
		// ���Բ�ΰ�ť�¼�
		map.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		init.shapeDrawOpt.cur_command = "paintfillfloat";
	}

	void eraseb_actionPerformed(ActionEvent e) {
		// ɾ��ͼ�ΰ�ť�¼�
		map.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		init.shapeDrawOpt.cur_command = "erase";
	}

	void newbt_actionPerformed(ActionEvent e) {
		// �½���ť�¼�
		init.fileOpt.newpic();
	}

	void openbt_actionPerformed(ActionEvent e) {
		// �򿪰�ť�¼�
		init.fileOpt.openEvent();
	}

	void savebt_actionPerformed(ActionEvent e) {
		// ���水ť�¼�
		init.fileOpt.saveEvent();
	}

	void deletemenu_actionPerformed(ActionEvent e) {
		// ɾ��ͼ��Ŀ¼�¼�
		init.shapeDrawOpt.erase(init.shapeDrawOpt.cur_shape);
	}

	void setcolorpane_mouseClicked(MouseEvent e) {
		// ѡ����ɫĿ¼���¼�
		init.shapeDrawOpt.changecolor();
	}

	void saveasmenu_actionPerformed(ActionEvent e) {
		// ����Ŀ¼���¼�
		init.fileOpt.saveAs();
	}

	void managemenu_actionPerformed(ActionEvent e) {
		// ͼ�ι�����Ŀ¼���¼�
		init.shapeManOpt.showShapeManage();
	}

	void deletebt_actionPerformed(ActionEvent e) {
		// ɾ��ͼ���¼�
		if (init.shapeDrawOpt.cur_shape != null) {
			init.shapeDrawOpt.erase(init.shapeDrawOpt.cur_shape);
		}
	}

	void movebt_actionPerformed(ActionEvent e) {
		// �ƶ�ͼ���¼�
		map.setCursor(new Cursor(Cursor.MOVE_CURSOR));
		init.shapeDrawOpt.cur_command = "move";
	}

	void paintlineb_actionPerformed(ActionEvent e) {
		// ����ֱ���¼�
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
