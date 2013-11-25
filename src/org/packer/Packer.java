package org.packer;

import java.awt.Rectangle;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

abstract class Packer {
	public abstract void pack(List<Rectangle> rectangles);
	
	protected void sortRectanglesByHeight(List<Rectangle> rectangles){
		Collections.sort(rectangles, new NonIncreasingHeightRectangleComparator());
	}
	
	private class NonIncreasingHeightRectangleComparator implements Comparator<Rectangle>{
		@Override
		public int compare(Rectangle o1, Rectangle o2) {
			return Integer.compare(o2.height, o1.height);
		}		
	}
}
