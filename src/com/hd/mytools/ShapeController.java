package com.hd.mytools;

import java.util.*;

/**
 * 
 * Description: 控制图形存储操作</p>
 * 
 */
// 图形列表管理器类
public class ShapeController {
	public ShapeController() {
	}

	private LinkedList<BaseShape> linkTmp;

	public LinkedList<BaseShape> getLinkTmp() {
		return linkTmp;
	}

	public void setLinkTmp(LinkedList<BaseShape> linkTmp) {
		this.linkTmp = linkTmp;
	}

	public LinkedList<BaseShape> getShapeList() {
		return shapeList;
	}

	public void setShapeList(LinkedList<BaseShape> shapeList) {
		this.shapeList = shapeList;
	}

	// 图形存储列表
	public LinkedList<BaseShape> shapeList = new LinkedList<BaseShape>();

	// 增加一个图形到列表尾部
	public void addLastshape(BaseShape shape) {
		shapeList.addLast(shape);
	}

	// 增加一个图形到列表首部
	public void addFirstshape(BaseShape shape) {
		shapeList.addFirst(shape);
	}

	// 删除一个图形
	public boolean deleteshape(BaseShape shape) {
		if (shapeList.remove(shape)) {
			return true;
		} else {
			return false; // 删除失败
		}
	}

	// 删除所有图形
	public void removeAll(LinkedList<BaseShape> del) {
		shapeList.removeAll(del);
	}

	// 获得最后一个图形
	public BaseShape getLastshape() {
		return (BaseShape) shapeList.getLast();
	}

	// 获得第一个图形
	public BaseShape getFirstshape() {
		return (BaseShape) shapeList.getFirst();
	}

	// 返回图形个数
	public int getsize() {
		return shapeList.size();
	}

	// 交换两个图形存储位置
	public boolean swapshape(int i1, int i2) {
		if (i1 < shapeList.size() && i2 < shapeList.size() && i1 != i2) {
			BaseShape s1, s2;
			if (i1 < i2) {
				int t = i1;
				i1 = i2;
				i2 = t;
			}
			s1 = (BaseShape) shapeList.remove(i1);
			s2 = (BaseShape) shapeList.remove(i2);
			shapeList.add(i2, s1);
			shapeList.add(i1, s2);
			return true;
		} else {
			return false; // 交换无法完成
		}
	}

	// 用图形对象查找图形
	public BaseShape findshape(BaseShape shape) {
		int i = shapeList.indexOf(shape);
		if (i != -1) {
			BaseShape s = (BaseShape) shapeList.get(i);
			return s;
		} else {
			return null; // 未找到
		}
	}

	// 用编号查找图形
	public BaseShape findshape(int index) {
		if (index < shapeList.size()) {
			BaseShape s = (BaseShape) shapeList.get(index);
			return s;
		} else {
			return null; // 未找到
		}
	}

	// 判断坐标点是否在一个图形之中
	public BaseShape findshape(int x, int y) {
		int i;
		BaseShape s = null;
		// ListIterator<BaseShape> it = shapeList.listIterator();
		for (i = shapeList.size() - 1; i >= 0; i--) {
			s = (BaseShape) shapeList.get(i);
			if (s.iscontain(x, y)) {
				return s;
			} else
				continue;
		}
		return null; // 不在任何图形中
	}

	// 返回链表的迭代器
	public ListIterator<BaseShape> getIterator() {
		return shapeList.listIterator();
	}
}
