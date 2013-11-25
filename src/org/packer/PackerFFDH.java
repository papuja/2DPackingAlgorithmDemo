package org.packer;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

class PackerFFDH extends PackingAlgorithm{
	private List<StripLevel> levels = new ArrayList<StripLevel>(1);
	private int maxWidth;
	int top = 0;
	
	public PackerFFDH(int maxWidth){
		this.maxWidth = maxWidth;
	}
	@Override
	public void pack(List<Rectangle> rectangles) {
		this.sortRectanglesByHeight(rectangles);
		for (Rectangle r : rectangles){
			boolean fitsOnALevel = false;
			for (StripLevel level : levels){
				fitsOnALevel = level.fitRectangle(r);
				if (fitsOnALevel) break;
			}
			if (!fitsOnALevel){
				StripLevel level = new StripLevel(maxWidth, top);
				level.fitRectangle(r);
				levels.add(level);
				top += r.height;
			}
		}
	}
	
	private class StripLevel{
		private int width, availableWidth, top;
		
		public StripLevel(int width, int top){
			this.width = width;
			this.availableWidth = width;
			this.top = top;
		}
		
		public boolean fitRectangle(Rectangle r){
			int leftOver = availableWidth - r.width;
			if (leftOver >= 0){
				r.setLocation(width - availableWidth, top);
				this.availableWidth = leftOver;
				return true;
			}
			return false;
		}
	}
}
