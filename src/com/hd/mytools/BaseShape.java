package com.hd.mytools;

import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;


//图元的抽象基类
abstract public class BaseShape implements Serializable {
  
	 /**
	 * 以下定义基础图元类的共有属性
	 */
	 private static final long serialVersionUID = 1L;
	 boolean isLink;
	 protected Long id;
	 public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	protected List<BaseShape>friends;//用于存储与之相连接的图形
	 public List<BaseShape> getFriends() {
		return friends;
	 }

	public void setFriends(List<BaseShape> friends) {
		this.friends = friends;
	 }
//public void drawLink(BaseShape s,Graphics g){
//		int x=s.getCenterPoint().getX();
//		int y=s.getCenterPoint().getX();
//		for(BaseShape friend:this.friends){
//			int c_x=friend.getCenterPoint().getX();
//			int c_y=friend.getCenterPoint().getY();
//			Line l = new Line();
//		    l.s_x=x;
//		    l.s_y=y;
//		    l.e_x=c_x;
//		    l.e_y=c_y;
//		    Operter.paintrect(l.s_x, l.s_y,  g);
//		    Operter.paintrect(l.e_x, l.e_y, g);
//		}    
//	}
	 protected int angle = 0; //旋转角度
	 protected  boolean isturn = false; //是否旋转
	 protected boolean isfill = false; //是否填充
	 protected String name = "Shape";
	 protected String type = "Shapex";
	 protected  int s_x = 0, s_y = 0; //图形的起始坐标
	 protected Color edgecolor = Color.BLACK; //轮廓颜色
	 protected Color fillColor = Color.BLACK; //填充颜色
	 
	
	 
	
	  public BaseShape() {
		  
	  }
	
	  abstract public boolean iscontain(int t_x, int t_y);
	
	  abstract public void draw(Graphics g); //获取画笔，画出图形
	
	  abstract public void move(int m_x, int m_y);//移动图元
	
	  abstract public void tolarge(double a);//放大图元
	  
	  

	public void fill(Color c) { 
		    isfill = true;
		    fillColor = c;
	  }
	
	  public void setedgecolor(Color c) {
		  this.edgecolor = c;
	  }
	
	  public void circumgyrate(int a) { //旋转
	    isturn = true;
	    angle = a; ;
	  }
	  abstract public CenterPoint getCenterPoint();
	  
}

//矩形类
class Rect extends BaseShape {
	private static final long serialVersionUID = 1L;
    int a_x; //x边长度
    int b_y; //y边宽度
    int x, y, a, b; //用于显示坐标数据
    public Rect() {
    	super();
        name = "Rectangle";
        type = "rect";
    }

  public void move(int m_x, int m_y) {
    s_x += m_x;
    s_y += m_y;
    
  }

  public void tolarge(double a) {
    a_x *= a;
    b_y *= a;
  }
  public void draw(Graphics g) {

    //绘制矩形
    Graphics2D g2d = (Graphics2D) g;
    AffineTransform t = null;
    Rectangle rectangle;
    x = s_x;//s_x是起始位置，x,y,a,b显示坐标
    y = s_y;
    a = a_x;//a_x是边长度
    b = b_y;
    if (a_x < 0) {
      x = s_x + a_x;
      a = Math.abs(a_x);
    }
    if (b_y < 0) {
      y = s_y + b_y;
      b = Math.abs(b_y);
    }
    rectangle = new Rectangle(x, y, a, b);
    if (isturn) {
      t = g2d.getTransform();
      g2d.rotate(Math.PI * angle / 180);
    }
    if (isfill) {
      g2d.setColor(fillColor);
      g2d.fill(rectangle);
    }
    g2d.setColor(edgecolor);
    g2d.draw(rectangle);
    if (isturn) {
      g2d.setTransform(t);
    }
  }

  public boolean iscontain(int t_x, int t_y) {
    Rectangle2D re = new Rectangle2D.Float(x, y, a, b);
    return re.contains(t_x, t_y);
  }

@Override
public CenterPoint getCenterPoint() {
	int w=x+(int)a/2;
	int z=y+(int)b/2;
	CenterPoint tmpCenterPoint=new CenterPoint();
	
	tmpCenterPoint.setX(w);
	tmpCenterPoint.setY(z);
	
	return tmpCenterPoint;
}

}

//圆类
class Circle extends BaseShape {
	private static final long serialVersionUID = 1L;
	  int  a_x;//长轴长
	  int  b_y; //短轴长
	
	  int x, y, a, b; //用于显示用坐标数据
	  public Circle() {
		 super();
	    name = "Circle";
	    type = "circle";
	  }
	
	  public void move(int m_x, int m_y) {
	    s_x += m_x;//s_x表示原始坐标
	    s_y += m_y;
	  }
	
	  public void tolarge(double a) {
	    a_x *= a;
	    b_y *= a;
	  }
	
	  public void draw(Graphics g) {
	    Ellipse2D ellipse;
	    Graphics2D g2d = (Graphics2D) g;
	
	    x = s_x;
	    y = s_y;
	    a = a_x;
	    b = b_y;
	    if (a_x < 0) {
	      x = s_x + a_x;
	      a = Math.abs(a_x);
	    }
	    if (b_y < 0) {
	      y = s_y + b_y;
	      b = Math.abs(b_y);
	    }
	    ellipse = new Ellipse2D.Float(x, y, a, b);
	    if (isfill) {
	      g2d.setColor(fillColor);
	      g2d.fill(ellipse);
	    }
	    g2d.setColor(edgecolor);
	    g2d.draw(ellipse);
  }

  public boolean iscontain(int t_x, int t_y) {
    Ellipse2D ellipse = new Ellipse2D.Float(x, y, a, b);
    return ellipse.contains(t_x, t_y);
  }

@Override
public CenterPoint getCenterPoint() {
	CenterPoint tmpCenterPoint = new CenterPoint();
	tmpCenterPoint.setX(x+(int)a/2);
	tmpCenterPoint.setY(y+(int)b/2);
	return tmpCenterPoint;
}
}


//直线类
class Line extends BaseShape {
	private static final long serialVersionUID = 1L;
	int e_x, e_y;
	AffineTransform t = null;
	public Line() {
		  super();
		  name = "Line";
		  type = "line";
	 }
	
	  public void draw(Graphics g) { //绘制直线
		    Graphics2D g2d = (Graphics2D) g;
		    Line2D line = new Line2D.Float(s_x, s_y, e_x, e_y);
		    if (isturn) {
		      t = g2d.getTransform();
		      g2d.rotate(Math.PI * angle / 180);
		    }
		    g2d.setColor(edgecolor);
		    g2d.draw(line);
		    if (isturn) {
		      g2d.setTransform(t);
		    }
	  }
	
	  public void tolarge(double a) {
		    s_x *= a;
		    s_y *= a;
		    e_x *= a;
		    e_y *= a;
	  }
	
	  public void move(int m_x, int m_y) {
		    s_x += m_x;
		    s_y += m_y;
		    e_x += m_x;
		    e_y += m_y;
	  }
	
	  public boolean iscontain(int t_x, int t_y) {
		    Line2D.Float l = new Line2D.Float(s_x, s_y, e_x, e_y);
		    if (l.ptLineDist(t_x, t_y) < 4.0) {
		    	return true;
		    }
		    else {
		     	return false;
		    }
   }

	@Override
	public CenterPoint getCenterPoint() {
		CenterPoint tmpCenterPoint = new CenterPoint();
		tmpCenterPoint.setX((int)s_x/2+(int)e_x/2);
		tmpCenterPoint.setY((int)s_y/2+(int)e_y/2);
		return tmpCenterPoint;
	}

}


//多边形类
class Polygons extends BaseShape {
	private static final long serialVersionUID = 1L;
	Polygon polygon = new Polygon();
    AffineTransform t = null;
	
   public Polygons() {
	      super();
		  name = "Polygon";
		  type = "polygon";
	}
	
	  public boolean iscontain(int t_x, int t_y) {
		    Polygon p = new Polygon(polygon.xpoints, polygon.ypoints, polygon.npoints);
		    return p.contains(t_x, t_y);
	  }
	
	  public void move(int m_x, int m_y) {
	    int i;
	    for (i = 0; i < polygon.npoints; i++) {
		      polygon.xpoints[i] += m_x;
		      polygon.ypoints[i] += m_y;
	    }
	  }
	
	  public void tolarge(double a) {
	    int i;
	    for (i = 0; i < polygon.npoints; i++) {
		      polygon.xpoints[i] *= a;
		      polygon.ypoints[i] *= a;
	    }
	  }
	
	  public void draw(Graphics g) { //绘制多边形
		    Graphics2D g2d = (Graphics2D) g;
		    if (isturn) {
			      t = g2d.getTransform();
			      g2d.rotate(Math.PI * angle / 180);
		    }
		    if (isfill) {
			      g2d.setColor(fillColor);
			      g2d.fill(polygon);
		    }
		    g2d.setColor(edgecolor);
		    g2d.draw(polygon);
		    if (isturn) {
		      g2d.setTransform(t);
		    }
	  }
	
	  public void addPoint(int x, int y) { //增加一个节点
		  polygon.addPoint(x, y);
	  }
	
	  public void changedLastPoint(int x, int y) {
		    if (polygon.npoints == 0) {
		      return;
	    }
	    else {
		      int l_x = polygon.npoints - 1;
		      int l_y = polygon.npoints - 1;
		      polygon.xpoints[l_x] = x;
		      polygon.ypoints[l_y] = y;
	    }
   }

	@Override
	public CenterPoint getCenterPoint() {
		CenterPoint tmpCenterPoint = new CenterPoint();
		tmpCenterPoint.setX(polygon.xpoints[0]);
		tmpCenterPoint.setY(polygon.ypoints[0]);
		return tmpCenterPoint;
	}
}

//曲线类
class Curve extends BaseShape {
	private static final long serialVersionUID = 1L;
	int e_x, e_y, c_x, c_y;
	AffineTransform t = null;
	public Curve() {
	super();
	name = "Curve";
	type = "curve";
  }

  public boolean iscontain(int t_x, int t_y) {
	    QuadCurve2D.Float qc = new QuadCurve2D.Float(s_x, s_y, c_x, c_y, e_x, e_y);
	    return qc.contains(t_x, t_y);
  }

  public void move(int m_x, int m_y) {
	    s_x += m_x;
	    s_y += m_y;
	    e_x += m_x;
	    e_y += m_y;
	    c_x += m_x;
	    c_y += m_y;
  }

  public void tolarge(double a) {
    s_x *= a;
    s_y *= a;
    e_x *= a;
    e_y *= a;
    c_x *= a;
    c_y *= a;
  }

  public void draw(Graphics g) {
	    Graphics2D g2d = (Graphics2D) g;
	    QuadCurve2D.Float qc = new QuadCurve2D.Float(s_x, s_y, c_x, c_y, e_x, e_y);
	    if (isturn) {
	      t = g2d.getTransform();
	      g2d.rotate(Math.PI * angle / 180);
	    }
	    g2d.setColor(edgecolor);
	    g2d.draw(qc);
	    if (isturn) {
	      g2d.setTransform(t);
	    }
	  }

@Override
public CenterPoint getCenterPoint() {
		CenterPoint tmpCenterPoint = new CenterPoint();
		tmpCenterPoint.setX(s_x);
		tmpCenterPoint.setY(e_y);
		return null;
	}
}
