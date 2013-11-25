package org.packer;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;



public class Packer {

	public static void packRectangles(List<Rectangle> rectangles, PackingAlgorithm algorithm, int maxWidth){
		switch(algorithm){
			case FIRST_FIT_DECREASING_HEIGHT:
				PackerFFDH packer = new PackerFFDH(maxWidth);
				packer.pack(rectangles);
		}
	}
	
	public enum PackingAlgorithm{
		FIRST_FIT_DECREASING_HEIGHT
	}
}
