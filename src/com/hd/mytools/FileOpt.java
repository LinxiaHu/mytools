package com.hd.mytools;

import java.io.*;
import java.util.*;

import javax.swing.*;

public class FileOpt {
	Init init;
	JFileChooser filechooser = new JFileChooser();
	String cur_filename = null; // 当前文件名
	DataInputStream din = null;
	FileInputStream fin;
	ObjectInputStream oin;
	FileOutputStream fout;
	DataOutputStream dout;
	ObjectOutputStream oout;

	public FileOpt(Init init) {
		this.init = init;
	}

	public void openEvent() {

		// 打开文件
		if (init.shapeset.shapeList.size() != 0) {
			int re = askifsave();
			if (re == JOptionPane.CANCEL_OPTION) {
				return;
			}
			if (re == JOptionPane.YES_OPTION) {
				saveEvent();
			}
		}
		newpic();
		int i = filechooser.showOpenDialog(new JFrame());
		if (i == JFileChooser.APPROVE_OPTION) {
			String filename = filechooser.getSelectedFile().toString();
			openFile(filename);
		}
	}

	public void saveEvent() {

		// 保存文件
		if (cur_filename != null) {
			saveFile(cur_filename);
		} else {
			saveAs();
		}
	}

	public void saveAs() {

		// 另存为...

		int i = filechooser.showSaveDialog(new JFrame());
		if (i == JFileChooser.APPROVE_OPTION) {
			String filename = filechooser.getSelectedFile().toString();
			cur_filename = filename;
			saveFile(filename);
		}
	}

	public void newpic() {

		// 新建一个空白画布
		init.shapeset.removeAll(init.shapeset.getShapeList());
		init.frame.map.repaint();
		if (init.shapeman != null) {
			init.shapeManOpt.renewlist();
		}
		init.shapeDrawOpt.cur_shape = null;
		cur_filename = null;
	}

	@SuppressWarnings("deprecation")
	public void openFile(String filename) {
		// 打开文件并读取其中的矢量图信息
		String temp = null;
		BaseShape x = null;
		try {
			fin = new FileInputStream(filename);
			din = new DataInputStream(fin);
			oin = new ObjectInputStream(fin);
			temp = din.readLine();
			System.out.print(temp);
			if (!temp.equals("MyinitPic file") || temp == null) {
				JOptionPane.showMessageDialog(new JFrame(), "无法打开指定文件");
				return;
			}
			while (true) {
				temp = din.readLine();
				if (temp == null) {
					break;
				}
				if (temp.equals("rect")) {
					x = (Rect) oin.readObject();
				}
				if (temp.equals("circle")) {
					x = (Circle) oin.readObject();
				}
				if (temp.equals("line")) {
					x = (Line) oin.readObject();
				}
				if (temp.equals("polygon")) {
					x = (Polygons) oin.readObject();
				}
				if (temp.equals("curve")) {
					x = (Curve) oin.readObject();
				}
				init.shapeset.addLastshape(x);
				x.draw(init.frame.map.getGraphics());
			}
			cur_filename = filename;
			fin.close();
			din.close();
			oin.close();
		} catch (Exception ex) {
		}
	}

	public void saveFile(String filename) {

		// 保存图形为矢量图文件格式
		if (!filename.endsWith(".vp")) {
			filename += ".vp";
		}
		try {
			fout = new FileOutputStream(filename);
			oout = new ObjectOutputStream(fout);
			ListIterator<?> it = init.shapeset.getIterator();
			fout.write(new String("MyinitPic file\n").getBytes());
			while (it.hasNext()) {
				BaseShape s = (BaseShape) it.next();
				saveTheShape(fout, oout, s);
			}
			oout.close();
			fout.close();
		} catch (Exception ex3) {
		}
	}

	private void saveTheShape(FileOutputStream fout, ObjectOutputStream oout,
			BaseShape s) {
		try {
			fout.write((s.type + "\n").getBytes());
			oout.writeObject(s);
		} catch (IOException ex) {
		}
	}

	public int askifsave() {

		// 询问是否保存文件

		int re = JOptionPane.showConfirmDialog(new JFrame(), "图形未保存,要保存吗?",
				"保存", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE);
		return re;

	}

}
