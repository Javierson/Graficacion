
package Pruebas3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	
	private Listener Escuchador;
	private int x, y;
	private Opciones ClaseOpciones;
	
	private Graphics2D g2;
	// Cambio para la comprobacion del raster
	//protected BufferedImage image;
	private BufferedImage image;
	
	//private WritableRaster raster;

	// Atributos de las herramientas
	
	private Color toolColor;
	private int toolX, toolY, toolRed, toolGreen, toolBlue, toolWidth, toolHeight;
	private List <Tool> strokes;
	
	public static final int SCALE = 8;
	
	public PaintPanel(Opciones ClaseOpciones) {
		this.ClaseOpciones = new Opciones();
		Escuchador = new Listener();
		this.addMouseListener(Escuchador);
		this.addMouseMotionListener(Escuchador);
		//repaint();
		image = new BufferedImage( PaintFrame.WIDTH / SCALE,
				PaintFrame.HEIGHT / SCALE, BufferedImage.TYPE_INT_RGB );
		g2 = (Graphics2D) image.getGraphics();
		strokes = new ArrayList<Tool>();
		// Llamar un punto
		WritableRaster raster = image.getRaster();
		//image.getRaster(); 
		//
		
		draw();
		repaint();
	}
	
	public WritableRaster getRaster() {
		return null ;//Raster.createWritableRaster(image, 0);
	}
	
	public void paintComponent(Graphics g) {
		
		g.drawImage(image, 0, 0,
				PaintFrame.WIDTH, PaintFrame.HEIGHT, null);
		
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
		g2.fillRect(0, 0, PaintFrame.WIDTH, PaintFrame.HEIGHT);
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
		toolRed = ClaseOpciones.getRedValue();
		toolGreen = ClaseOpciones.getGreenValue();
		toolBlue = ClaseOpciones.getBlueValue();
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

	public static void DDATool(int DDAX1, int DDAY1, int DDAX2, int DDAY2, WritableRaster raster) {

		int DX, DY, STEPS, K, V[] = {0, 0, 0};
		float X, Y, XI, YI;
		DX = DDAX2 - DDAX1;
		DY = DDAY2 - DDAY1;
		if( Math.abs( DX ) > Math.abs( DY ) ){
			STEPS = Math.abs( DX );
		}
		else {
			STEPS = Math.abs( DY );
		}
		XI = DX / STEPS;
		YI = DY / STEPS;
		X = DDAX1;
		Y = DDAY1;
		raster.setPixel(Math.round(X), Math.round(Y), V);
		for(K = 1; K < STEPS; K++) {
			X = X + XI;
			Y = Y + YI;
			raster.setPixel(Math.round(X), Math.round(Y), V);
		
	}

}
}
