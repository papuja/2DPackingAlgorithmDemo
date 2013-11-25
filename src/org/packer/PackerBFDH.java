package org.packer;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PackerBFDH extends Packer{
	private List<StripLevel> levels;
	private int stripWidth;
	
	public PackerBFDH(int stripWidth){
		this.stripWidth = stripWidth;
		this.levels = new ArrayList<StripLevel>();
	}
	@Override
	public void pack(List<Rectangle> rectangles) {
		int top = 0;
		this.sortRectanglesByHeight(rectangles);
		for (Rectangle r : rectangles){
			StripLevel levelWithSmallestResidual = null;
			for (StripLevel level : this.levels){
				if (level.canFit(r)){
					if (levelWithSmallestResidual != null && levelWithSmallestResidual.availableWidth() > level.availableWidth()){
						levelWithSmallestResidual = level;
					}else if (levelWithSmallestResidual == null){
						levelWithSmallestResidual = level;
					}
				}
			}
			if (levelWithSmallestResidual == null){
				StripLevel level = new StripLevel(stripWidth, top);
				level.fitRectangle(r);
				this.levels.add(level);
				top += r.height;
			}else{
				levelWithSmallestResidual.fitRectangle(r);
			}
			
		}
	}
}
