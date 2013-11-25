package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.Border;

class DrawCanvas extends JPanel{
	private Canvas canvas;
	
	public DrawCanvas(){
		this.canvas = new Canvas();
		this.add(canvas);
		this.setBackground(Color.white);
		Border border = BorderFactory.createLineBorder(Color.black);
		this.setBorder(border);
	}
	
	public void addRectangle(Rectangle r){
		this.canvas.addRectangle(r);
	}
	public void clearRectangles(){
		this.canvas.clearRectangles();
	}
	public void setRectangles(List<Rectangle> rectangles){
		this.canvas.setRectangles(rectangles);
		this.canvas.repaint();
	}
	
	private class Canvas extends JComponent{
		List<Rectangle> rectangles;
		public Canvas(){
			this.rectangles = new ArrayList<Rectangle>();
		}
		
		public void addRectangle(Rectangle r){
			this.rectangles.add(r);
		}
		public void setRectangles(List<Rectangle> rectangles){
			this.rectangles = rectangles;
		}
		public void clearRectangles(){
			this.rectangles.clear();
		}
		
		public void paintComponent(Graphics g){
			g.setColor(Color.blue);
			for (Rectangle r : this.rectangles){
				g.drawRect(r.x, r.y, r.width, r.height);
			}
		}
		
		public Dimension getPreferredSize(){
			return new Dimension(513, 513);
		}
	}
}


