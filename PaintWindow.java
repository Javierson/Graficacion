package Pruebas2;

import java.awt.Point;

import javax.swing.JFrame;

public class PaintWindow {

	private static JFrame theWindow;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 700;
	private static PaintPanel thePaintPanel;
	private static OptionsWindow theOptionsWindow;
	
	public static void main(String[] args) {
		
		// En el video doce me quede
		// En el 10 o mas adelante aparecio el segundo options
		theWindow = new JFrame( "Pixel Paint" );
		theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theWindow.setSize(WIDTH, HEIGHT);
		
		theWindow.setLocationRelativeTo(null);
		//OptionsWindow = new OptionsPanel();
		theOptionsWindow = new OptionsWindow();
		thePaintPanel = new PaintPanel( theOptionsWindow );
		
		theWindow.setResizable(false);
		theWindow.add(thePaintPanel);
		theWindow.setVisible(true);
	
	}
	
	public static Point getWindowLocation() {
		return theWindow.getLocation();
	}	
	
}
