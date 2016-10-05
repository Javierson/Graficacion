
package Pruebas3;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Tool {
	
	protected int x, y, width, height;
	protected Color color;
	
	public Tool(int x, int y, int width, int height, Color color) {
		this.x = x - width / 2;
		this.y = y - width / 2;
		this.width = width;
		this.height = height;
		// Agrega el cursor de pintado al panel de bibujo
		this.color = color;
	}
	
	public void setAttributes(Graphics2D g) {
		g.setColor(color);
	}
	
	public abstract void draw(Graphics2D g);
	
}
