package com.hd.mytools;

import java.awt.*;

/**
 * 
 * Description: ����Ļ�����������</p>
 * 
 */

public class Operter {
	public Operter() {
	}

	public static boolean isin(int x, int a, int b) {

		if ((x > a && x < b) || (x > b && x < a)) {
			return true;
		} else {
			return false;
		}
	}

	// ����һ�����ڸ�����ʾ�õĺ�ɫ����
	public static void paintrect(int x, int y, Graphics g) {
		Rect r = new Rect();
		r.s_x = x - 4;
		r.s_y = y - 4;
		r.a_x = 8;
		r.b_y = 8;
		r.fill(Color.BLACK);
		r.draw(g);
	}
}
