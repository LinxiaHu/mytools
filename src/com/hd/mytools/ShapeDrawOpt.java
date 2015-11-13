package com.hd.mytools;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ListIterator;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ShapeDrawOpt {

	Init init;

	JColorChooser colorchooser = new JColorChooser();
	Color frontcolor = Color.BLACK; // ǰ��ɫ
	BaseShape cur_shape = null; // ��ǰѡ���ͼ��
	String cur_command = "select"; // ��ǰ����
	int temp_x, temp_y;
	@SuppressWarnings("unused")
	private MyLogo logo;

	public ShapeDrawOpt(Init init) {
		this.init = init;
	}

	// ������ʾ
	public void highlight(BaseShape s) {
		ListIterator<?> it = init.shapeset.getIterator();
		while (it.hasNext()) {
			BaseShape shape = (BaseShape) it.next();
			shape.draw(init.frame.map.getGraphics());
		}
		if (s.type.equals("rect")) {
			Rect r = (Rect) s;
			Operter.paintrect(r.x, r.y, init.frame.map.getGraphics());
			Operter.paintrect(r.x, r.y + r.b, init.frame.map.getGraphics());
			Operter.paintrect(r.x + r.a, r.y, init.frame.map.getGraphics());
			Operter.paintrect(r.x + r.a, r.y + r.b,
					init.frame.map.getGraphics());
		}
		if (s.type.equals("circle")) {
			Circle r = (Circle) s;
			Operter.paintrect(r.x, r.y, init.frame.map.getGraphics());
			Operter.paintrect(r.x, r.y + r.b, init.frame.map.getGraphics());
			Operter.paintrect(r.x + r.a, r.y, init.frame.map.getGraphics());
			Operter.paintrect(r.x + r.a, r.y + r.b,
					init.frame.map.getGraphics());
		}
		if (s.type.equals("line")) {
			Line l = (Line) s;
			Operter.paintrect(l.s_x, l.s_y, init.frame.map.getGraphics());
			Operter.paintrect(l.e_x, l.e_y, init.frame.map.getGraphics());
		}
		if (s.type.equals("polygon")) {
			int i;
			Polygons p = (Polygons) s;
			for (i = 0; i < p.polygon.npoints; i++) {
				Operter.paintrect(p.polygon.xpoints[i], p.polygon.ypoints[i],
						init.frame.map.getGraphics());
			}
		}
		if (s.type.equals("curve")) {
			Curve cu = (Curve) s;
			Operter.paintrect(cu.s_x, cu.s_y, init.frame.map.getGraphics());
			Operter.paintrect(cu.e_x, cu.e_y, init.frame.map.getGraphics());
		}
	}

	public void mouseclick(MouseEvent e) {
		// ��굥���¼�������ѡ�к���Խ���༭ģʽ
		if (cur_command.equals("select")) {
			// ��ʼ����ѡ�����
			BaseShape s = init.shapeset.findshape(e.getX(), e.getY());
			if (s != null) {
				cur_shape = s;
				init.frame.map.repaintx();
			} else {
				cur_shape = null;
				init.frame.map.repaint();
			}
			return;
		}
		if (cur_command.equals("link")) {
			BaseShape s1 = init.shapeset.findshape(e.getX(), e.getY());
			if (s1 != null) {
				cur_shape = s1;
				Arrow arrow = new Arrow();
				arrow.setBs1(s1);
				init.shapeset.addLastshape(arrow);
				init.frame.map.repaintx();

			} else {
				cur_shape = null;
				init.frame.map.repaint();
			}
			// int s_x=cur_shape.getCenterPoint().getX();
			// int s_y=cur_shape.getCenterPoint().getY();

			// Line l = new Line();
			// l.s_x = s_x;
			// l.s_y = s_y;
			// l.setedgecolor(frontcolor);

			cur_command = "lastlink";
			// l = (Line) init.shapeset.getLastshape();
			// l.e_x = e.getX();
			// l.e_y = e.getY();
			// init.frame.map.repaint();
			// cur_command = "link";

			return;
		}
		if (cur_command.equals("lastlink")) {
			// ����ֱ����ֹ��
			BaseShape s1 = init.shapeset.findshape(e.getX(), e.getY());
			Arrow arrow = (Arrow) init.shapeset.getLastshape();
			arrow.setedgecolor(frontcolor);
			arrow.setBs2(s1);
			arrow.setS_x();
			arrow.setS_y();
			arrow.setE_x();
			arrow.setE_y();
			init.shapeset.addLastshape(arrow);
			init.frame.map.repaint();

			// int e_x=s1.getCenterPoint().getX();
			// int e_y=s1.getCenterPoint().getY();
			// Line l = (Line) init.shapeset.getLastshape();
			// l.e_x = e_x;
			// l.e_y = e_y;
			// init.frame.map.repaint();
			cur_command = "link";
			return;
		}

		if (cur_command.equals("startline")) {
			// ��ʼ����ֱ����ʼ��
			Line l = new Line();
			l.s_x = e.getX();
			l.s_y = e.getY();
			l.setedgecolor(frontcolor);
			init.shapeset.addLastshape(l);
			cur_command = "paintline";
			return;
		}
		if (cur_command.equals("paintline")) {
			// ����ֱ����ֹ��
			Line l = (Line) init.shapeset.getLastshape();
			l.e_x = e.getX();
			l.e_y = e.getY();
			init.frame.map.repaint();
			cur_command = "startline";
			return;
		}
		if (cur_command.equals("startpolygon")
				|| cur_command.equals("startfillpolygon")) {
			// ���ƶ������ʼ��
			Polygons p = new Polygons();
			p.edgecolor = frontcolor;
			if (cur_command.equals("startfillpolygon")) {
				p.fill(frontcolor);
				cur_command = "paintfillpolygon";
			} else {
				cur_command = "paintpolygon";
			}
			p.addPoint(e.getX(), e.getY());
			p.addPoint(e.getX(), e.getY());
			init.shapeset.addLastshape(p);
			return;
		}
		if (cur_command.equals("paintpolygon")
				|| cur_command.equals("paintfillpolygon")) {
			// ��ʼ���ƶ������ֹ��
			if (e.getClickCount() == 1) {
				Polygons p = (Polygons) init.shapeset.getLastshape();
				p.changedLastPoint(e.getX(), e.getY());
				p.addPoint(e.getX(), e.getY());
				init.frame.map.repaint();
			}
			if (e.getClickCount() == 2) {
				Polygons p = (Polygons) init.shapeset.getLastshape();
				p.polygon.npoints--;
				if (cur_command.equals("paintfillpolygon")) {
					cur_command = "startfillpolygon";
				} else {
					cur_command = "startpolygon";
				}
				return;
			}
		}
		if (cur_command.equals("startcurve")) {
			Curve cu = new Curve();
			cu.s_x = e.getX();
			cu.s_y = e.getY();
			cu.setedgecolor(frontcolor);
			init.shapeset.addLastshape(cu);
			cur_command = "endcurve";
			return;
		}
		if (cur_command.equals("endcurve")) {
			Curve cu = (Curve) init.shapeset.getLastshape();
			cu.e_x = cu.c_x = e.getX();
			cu.e_y = cu.c_y = e.getY();
			init.frame.map.repaint();
			cur_command = "controllcurve";
			return;
		}
		if (cur_command.equals("controllcurve")) {
			Curve cu = (Curve) init.shapeset.getLastshape();
			cu.c_x = e.getX();
			cu.c_y = e.getY();
			init.frame.map.repaint();
			cur_command = "startcurve";
			return;
		}
		if (cur_command.equals("erase")) {
			// ɾ������
			BaseShape s = init.shapeset.findshape(e.getX(), e.getY());
			erase(s);
			return;
		}
		if (cur_command.equals("fill")) {
			// ��ʼ������
			BaseShape s = init.shapeset.findshape(e.getX(), e.getY());
			if (s != null) {
				s.fill(frontcolor);
				init.frame.map.repaint();
			}
			return;
		}
	}

	public void mousemoved(MouseEvent e) {
		if (cur_command.equals("paintline")) {
			Line l = (Line) init.shapeset.getLastshape();
			l.e_x = e.getX();
			l.e_y = e.getY();
			init.frame.map.repaint();
			return;
		}
		if (cur_command.equals("paintpolygon")
				|| cur_command.equals("paintfillpolygon")) {
			Polygons p = (Polygons) init.shapeset.getLastshape();
			p.changedLastPoint(e.getX(), e.getY());
			init.frame.map.repaint();
			return;
		}
		if (cur_command.equals("endcurve")
				|| cur_command.equals("controllcurve")) {
			Curve cu = (Curve) init.shapeset.getLastshape();
			if (cur_command.equals("endcurve")) {
				cu.e_x = cu.c_x = e.getX();
				cu.e_y = cu.c_y = e.getY();
			} else {
				cu.c_x = e.getX();
				cu.c_y = e.getY();
			}
			init.frame.map.repaint();
			return;
		}
	}

	public void mousedrag(MouseEvent e) {

		// ����϶�����

		if (cur_command.equals("paintrect")
				|| cur_command.equals("paintfillrect")) {
			// ���ƾ��λ�������
			Rect r = (Rect) init.shapeset.getLastshape();
			if (cur_command.equals("paintfillrect")) {
				r.fill(frontcolor);
			}
			r.a_x = e.getX() - r.s_x;
			r.b_y = e.getY() - r.s_y;
			init.frame.map.repaint(r.x - 15, r.y - 15, r.a + 30, r.b + 30);
			return;
		}
		if (cur_command.equals("paintfloat")
				|| cur_command.equals("paintfillfloat")) {
			// ����Բ�λ����ͼ��
			Circle f = (Circle) init.shapeset.getLastshape();
			if (cur_command.equals("paintfillfloat")) {
				f.fill(frontcolor);
			}
			f.a_x = e.getX() - f.s_x;
			f.b_y = e.getY() - f.s_y;
			init.frame.map.repaint(f.x - 15, f.y - 15, f.a + 30, f.b + 30);
			return;
		}
		if (cur_command.equals("move")) {
			// �϶�ͼ�β���
			if (cur_shape != null) {
				int x, y;
				x = e.getX() - temp_x;
				y = e.getY() - temp_y;
				temp_x = e.getX();
				temp_y = e.getY();
				if (cur_shape.type.equals("rect")
						|| cur_shape.type.equals("circle")) {
					cur_shape.move(x, y);
					init.autoLink();
				}
				if (cur_shape.type.equals("polygon")) {
					Polygons p = (Polygons) cur_shape;
					p.move(x, y);
					init.autoLink();
				}
				if (cur_shape.type.equals("line")) {
					Line l = (Line) cur_shape;
					l.move(x, y);
					init.autoLink();
				}
				if (cur_shape.type.equals("curve")) {
					Curve c = (Curve) cur_shape;
					c.move(x, y);
					init.autoLink();
				}
			}
			init.frame.map.repaintx();
			return;
		}
	}

	public void mousepress(MouseEvent e) {

		// ��갴�²���

		init.frame.map.repaint();
		cur_shape = null;
		if (cur_command.equals("paintrect")
				|| cur_command.equals("paintfillrect")) {
			// ������һ������
			Rect r = new Rect();
			r.s_x = e.getX();
			r.s_y = e.getY();
			r.setedgecolor(frontcolor);
			init.shapeset.addLastshape(r);
			return;
		}
		if (cur_command.equals("paintfloat")
				|| cur_command.equals("paintfillfloat")) {
			// ������һ��Բ��
			Circle f = new Circle();
			f.s_x = e.getX();
			f.s_y = e.getY();
			f.setedgecolor(frontcolor);
			init.shapeset.addLastshape(f);
			return;
		}
		if (cur_command.equals("move")) {
			// ��¼�϶���ʼλ��
			cur_shape = init.shapeset.findshape(e.getX(), e.getY());
			temp_x = e.getX();
			temp_y = e.getY();
			return;
		}
		if (init.shapeman != null) {
			init.shapeManOpt.renewlist();
		}
	}

	// ɾ��ͼ�β���
	public void erase(BaseShape s) {

		if (s != null) {
			highlight(s);
			int re = JOptionPane.showConfirmDialog(new JFrame(), "Ҫɾ�����ͼ����?",
					"ȷ��ɾ��", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE);
			if (re == JOptionPane.YES_OPTION) {
				init.shapeset.deleteshape(s);
				if (cur_shape == s) {
					cur_shape = null;
				}
				if (init.shapeman != null) {
					init.shapeManOpt.renewlist();
				}
				init.frame.map.repaint();
			}

		}
	}

	public void changecolor() {

		// �仯ǰ��ɫ����

		Color c;
		if ((c = JColorChooser.showDialog(new JFrame(), "color", null)) != null) {
			frontcolor = c;
		}
		init.frame.setcolorpane.repaint();
	}

	// public void logoshow()
	// {
	// logo = new MyLogo("icons/logo.jpg");
	//
	// }
}
