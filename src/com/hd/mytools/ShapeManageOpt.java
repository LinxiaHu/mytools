package com.hd.mytools;

import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.event.*;
public class ShapeManageOpt {
		private Init init;
	    BaseShape copy_shape=null;

	  public ShapeManageOpt(Init init) {
		  this.init =init;
	  }

	  public void showShapeManage() {

	    //显示图形管理器窗口

	    init.shapeman = new ShapeListerFrame(init);
	  }

	  public void copyshape(){

	  }
	//交换两个图形存储位置

	  public void swapitem(int i1, int i2) {
	    init.shapeset.swapshape(i1, i2);
	    renewlist();
	    init.frame.map.repaintx();
	  }

	  public void showpropertiesdialog() {
	    init.pDialog = new PropertiesDialog(init);
	  }

	  public void renewlist() {

	    //图形列表更新
	    init.shapeman.items.removeAllElements();
	    init.shapeman.shapelist.removeAll();
	    ListIterator<?> it = init.shapeset.getIterator();
	    while (it.hasNext()) {
	      BaseShape s = (BaseShape) it.next();
	      init.shapeman.items.add(0, s.name + ":" + s.type);
	    }
	  }

	  void upLayer(ActionEvent e) {

	    //上移一层操作

	    int size = init.shapeman.items.getSize();
	    int index = init.shapeman.shapelist.getSelectedIndex();
	    swapitem(size - index - 1, size - index);
	    init.shapeman.shapelist.setSelectedIndex(index - 1);
	  }

	  void downLayer(ActionEvent e) {

	    //下移一层操作

	    int size = init.shapeman.items.getSize();
	    int index = init.shapeman.shapelist.getSelectedIndex();
	    swapitem(size - index - 1, size - index - 2);
	    init.shapeman.shapelist.setSelectedIndex(index + 1);
	  }

	  void toTopLayer(ActionEvent e) {

	    //至于顶端操作

	    int size = init.shapeman.items.getSize();
	    int index = init.shapeman.shapelist.getSelectedIndex();
	    BaseShape s = (BaseShape) init.shapeset.shapeList.remove(size - index - 1);
	    init.shapeset.addLastshape(s);
	    renewlist();
	    init.frame.map.repaintx();
	    init.shapeman.shapelist.setSelectedIndex(0);
	  }

	  void toBottomLayer(ActionEvent e) {

	    //至于底端操作

	    int size = init.shapeman.items.getSize();
	    int index = init.shapeman.shapelist.getSelectedIndex();
	    BaseShape s = (BaseShape) init.shapeset.shapeList.remove(size - index - 1);
	    init.shapeset.addFirstshape(s);
	    renewlist();
	    init.frame.map.repaintx();
	    init.shapeman.shapelist.setSelectedIndex(size - 1);

	  }

	  void shapelistvalueChanged(ListSelectionEvent e) {

	    //列表选择操作


	    int index = init.shapeman.shapelist.getSelectedIndex();
	    int size = init.shapeman.items.getSize();
	    BaseShape s = (BaseShape) init.shapeset.findshape(size - index - 1);
	    init.shapeDrawOpt.cur_shape = s;
	    init.frame.map.repaintx();
	  }

}
