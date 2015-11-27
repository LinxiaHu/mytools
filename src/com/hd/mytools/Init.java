package com.hd.mytools;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.UIManager;

/**
 * 
 * @author Chunyun 程序的主入口
 */
public class Init {

	ShapeManageOpt shapeManOpt = new ShapeManageOpt(this);
	FileOpt fileOpt = new FileOpt(this);
	ShapeDrawOpt shapeDrawOpt = new ShapeDrawOpt(this);
	ShapeController shapeset = new ShapeController(); // 图形存储管理器
	MainWindow frame = new MainWindow(this); // 主窗口
	ShapeListerFrame shapeman; // 图形管理器窗口
	PropertiesDialog pDialog;// 属性对话框
	LinkedList<BaseShape> linkTempBaseShapes;// 存放要连接的图形

	public void autoLink() {
		// for(BaseShape tmp:shapeset.shapeList){
		// if(tmp.type.equals("arrow")){
		// Arrow tmp1 = (Arrow)tmp;
		// tmp1.setS_x();
		// tmp1.setS_y();
		// tmp1.setE_x();
		// tmp1.setE_y();
		// this.shapeset.deleteshape(tmp);
		// this.shapeset.addLastshape(tmp1);
		// this.frame.map.repaint();
		// }
		// }

		Iterator<BaseShape> iterator = this.shapeset.getIterator();
		BaseShape bs;
		while (iterator.hasNext()) {
			bs = iterator.next();
			if ((bs.type.equals("arrow"))) {
				Arrow tmpArrow = new Arrow();
				tmpArrow = (Arrow) bs;
				tmpArrow.setS_x();
				tmpArrow.setS_y();
				tmpArrow.setE_x();
				tmpArrow.setE_y();
				iterator.remove();
				this.shapeset.addLastshape(tmpArrow);
				this.frame.map.repaint();
			}

		}

		// int n = this.shapeset.shapeList.size();
		// for(int i=n-1;i>=0;i++){
		// BaseShape bShape =this.shapeset.shapeList.get(i);
		// if(bShape.type.equals("arrow")){
		// Arrow tmp1 = (Arrow)bShape;
		// tmp1.setS_x();
		// tmp1.setS_y();
		// tmp1.setE_x();
		// tmp1.setE_y();
		// this.shapeset.shapeList.remove(bShape);
		// this.shapeset.addLastshape(tmp1);
		// this.frame.map.repaint();
		// }
		// }

	}

	public Init() {

		// 初始化
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);

		frame.setVisible(true);
	}

	public static void main(String args[]) {
		// 主函数
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new Init();
	}
}
