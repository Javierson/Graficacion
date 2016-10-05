package Pruebas2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	
	private Listener theListener;
	private int x, y;
	private OptionsWindow optionsWindow;
	
	private Graphics2D g2;
	private BufferedImage image;
	
	// Atributos de las herramientas
	
	private Color toolColor;
	private int toolX, toolY, toolRed, toolGreen, toolBlue, toolWidth, toolHeight;
	private List <Tool> strokes;
	
	public static final int SCALE = 8;
	
	public PaintPanel(OptionsWindow optionsWindow) {
		this.optionsWindow = new OptionsWindow();
		theListener = new Listener();
		this.addMouseListener(theListener);
		this.addMouseMotionListener(theListener);
		//repaint();
		image = new BufferedImage( PaintWindow.WIDTH / SCALE,
				PaintWindow.HEIGHT / SCALE, BufferedImage.TYPE_INT_RGB );
		g2 = (Graphics2D) image.getGraphics();
		strokes = new ArrayList<Tool>();
		draw();
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		
		g.drawImage(image, 0, 0,
				PaintWindow.WIDTH, PaintWindow.HEIGHT, null);
		
		/*
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, PaintWindow.WIDTH, PaintWindow.HEIGHT);
		
		int red = optionsWindow.getRedValue();
		int green = optionsWindow.getGreenValue();
		int blue = optionsWindow.getBlueValue();
		
		toolColor = new Color(red, green, blue);
		g.setColor(toolColor);
		g.fillOval(x, y, 20, 20);
		*/
		
	}
	
	public void draw() {
		drawBackground();
		drawStrokes();
	}
	
	public void drawBackground() {
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, PaintWindow.WIDTH, PaintWindow.HEIGHT);
	}
	
	public void drawStrokes() {
		for(Tool t : strokes) {
			t.setAttributes(g2);
			t.draw(g2);
		}
	}
	
	public void addStroke( MouseEvent e ) {
		toolX = e.getX() / SCALE;
		toolY = e.getY() / SCALE;
		toolWidth = 4;
		toolHeight = 4;
		toolRed = optionsWindow.getRedValue();
		toolGreen = optionsWindow.getGreenValue();
		toolBlue = optionsWindow.getBlueValue();
		toolColor = new Color(toolRed, toolGreen, toolBlue);
		strokes.add( new CircleTool( toolX, toolY, toolWidth, toolHeight, toolColor ) );
		draw(); // Constructor de la imagen
		repaint(); // Hangs the image on the panel
	}
	
	private class Listener implements MouseListener, MouseMotionListener {

		public void mouseClicked(MouseEvent e) {

		}

		public void mouseEntered(MouseEvent e) {

		}

		public void mouseExited(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {
			
			/*
			x = e.getX();
			y = e.getY();
			repaint();
			*/
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}

		public void mouseDragged(MouseEvent e) {
			addStroke(e);
		}

		public void mouseMoved(MouseEvent e) {
			
		}
		
	}

}
