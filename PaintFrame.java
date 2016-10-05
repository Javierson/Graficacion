package Pruebas3;

import java.awt.Point;
import javax.swing.JFrame;

public class PaintFrame {

	private static JFrame Ventana;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 700;
	private static PaintPanel paintPanel;
	private static Opciones Formato;
	
	public static void main(String[] args) {
		
		// En el video doce me quede
		// En el 10 o mas adelante aparecio el segundo options
		Ventana = new JFrame( "Paint" );
		Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Ventana.setSize(WIDTH, HEIGHT);
		
		Ventana.setLocationRelativeTo(null);
		//OptionsWindow = new OptionsPanel();
		
		// La linea de abajo fue el error
		//theOptionsWindow = new OptionsWindow();
		
		paintPanel = new PaintPanel( Formato );
		
		Ventana.setResizable(false);
		Ventana.add(paintPanel);
		Ventana.setVisible(true);
	
	}
	
	public static Point getWindowLocation() {
		return Ventana.getLocation();
	}	
	
}
