package org.packer;

import java.awt.Rectangle;
import java.util.List;

class PackerNFDH extends Packer{
	private StripLevel currentLevel;
	private int maxWidth;
	
	public PackerNFDH(int maxWidth){
		this.maxWidth = maxWidth;
	}

	@Override
	public void pack(List<Rectangle> rectangles) {
		int top = 0;
		for (Rectangle r : rectangles){
			if (currentLevel == null || !currentLevel.fitRectangle(r)){
				currentLevel = new StripLevel(maxWidth, top);
				currentLevel.fitRectangle(r);
				top += r.height;
			}
		}
	}
}
