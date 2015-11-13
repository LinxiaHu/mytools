package com.hd.mytools;

import java.awt.*;

/**
 * 
 * Description: 程序的基本公共操作</p>
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

	// 绘制一个用于高亮显示用的黑色矩形
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
