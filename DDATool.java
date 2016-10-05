
package Pruebas3;

import java.awt.Color;
import java.awt.Graphics2D;

public class DDATool extends Tool{
	
	public DDATool (int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}
	
	public void draw(Graphics2D g) {
		g.fillRect(x, y, width, height);
	}
	
	/*
	void line(int x1, int y1, int x2, int y2){
		  double m = (double)(y2-y1)/(x2-x1);
		  double y = (double)y1;
		  int iy;
		  for (int x = x1 ; x <= x2 ; x++) {
		   iy = (int)Math.round(y);
		   setPixel (x, iy);
		   y+ = m;
		  }
		} 
	*/
	
}
