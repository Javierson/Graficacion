
package Pruebas3;

import java.awt.Color;
import java.awt.Graphics2D;

public class CircleTool extends Tool{
	
	public CircleTool(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}
	
	public void draw(Graphics2D g) {
		g.fillOval(x, y, width, height);
	}
	
}
