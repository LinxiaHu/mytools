package com.hd.mytools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Arrow extends BaseShape {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int s_x;
	private int s_y;
	private int e_x;
	private int e_y;
	private BaseShape bs1;
	private BaseShape bs2;
	protected Color edgecolor = Color.BLACK;

	public BaseShape getBs1() {
		return bs1;
	}

	public void setBs1(BaseShape bs1) {
		this.bs1 = bs1;
	}

	public BaseShape getBs2() {
		return bs2;
	}

	public void setBs2(BaseShape bs2) {
		this.bs2 = bs2;
	}

	public int getS_x() {
		return this.s_x;
	}

	public void setS_x() {
		this.s_x = this.bs1.getCenterPoint().getX();
	}

	public int getS_y() {
		return s_y;
	}

	public void setS_y() {
		this.s_y = this.bs1.getCenterPoint().getY();
	}

	public int getE_x() {
		return e_x;
	}

	public void setE_x() {
		this.e_x = this.bs2.getCenterPoint().getX();
	}

	public int getE_y() {
		return e_y;
	}

	public void setE_y() {
		this.e_y = this.bs2.getCenterPoint().getY();
	}

	public Arrow() {
		name = "arrow";
		type = "arrow";
	}

	public void draw(Graphics g) { // ªÊ÷∆÷±œﬂ
		Graphics2D g2d = (Graphics2D) g;
		Line2D line = new Line2D.Float(this.s_x, this.s_y, this.e_x, this.e_y);
		g2d.setColor(edgecolor);
		g2d.draw(line);
	}

	@Override
	public boolean iscontain(int t_x, int t_y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void move(int m_x, int m_y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tolarge(double a) {
		// TODO Auto-generated method stub

	}

	@Override
	public CenterPoint getCenterPoint() {
		// TODO Auto-generated method stub
		return null;
	}

}
