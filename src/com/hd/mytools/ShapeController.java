package com.hd.mytools;

import java.util.*;

/**
 * 
 * Description: ����ͼ�δ洢����</p>
 * 
 */
// ͼ���б��������
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

	// ͼ�δ洢�б�
	public LinkedList<BaseShape> shapeList = new LinkedList<BaseShape>();

	// ����һ��ͼ�ε��б�β��
	public void addLastshape(BaseShape shape) {
		shapeList.addLast(shape);
	}

	// ����һ��ͼ�ε��б��ײ�
	public void addFirstshape(BaseShape shape) {
		shapeList.addFirst(shape);
	}

	// ɾ��һ��ͼ��
	public boolean deleteshape(BaseShape shape) {
		if (shapeList.remove(shape)) {
			return true;
		} else {
			return false; // ɾ��ʧ��
		}
	}

	// ɾ������ͼ��
	public void removeAll(LinkedList<BaseShape> del) {
		shapeList.removeAll(del);
	}

	// ������һ��ͼ��
	public BaseShape getLastshape() {
		return (BaseShape) shapeList.getLast();
	}

	// ��õ�һ��ͼ��
	public BaseShape getFirstshape() {
		return (BaseShape) shapeList.getFirst();
	}

	// ����ͼ�θ���
	public int getsize() {
		return shapeList.size();
	}

	// ��������ͼ�δ洢λ��
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
			return false; // �����޷����
		}
	}

	// ��ͼ�ζ������ͼ��
	public BaseShape findshape(BaseShape shape) {
		int i = shapeList.indexOf(shape);
		if (i != -1) {
			BaseShape s = (BaseShape) shapeList.get(i);
			return s;
		} else {
			return null; // δ�ҵ�
		}
	}

	// �ñ�Ų���ͼ��
	public BaseShape findshape(int index) {
		if (index < shapeList.size()) {
			BaseShape s = (BaseShape) shapeList.get(index);
			return s;
		} else {
			return null; // δ�ҵ�
		}
	}

	// �ж�������Ƿ���һ��ͼ��֮��
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
		return null; // �����κ�ͼ����
	}

	// ��������ĵ�����
	public ListIterator<BaseShape> getIterator() {
		return shapeList.listIterator();
	}
}
