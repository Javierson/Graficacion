
package Pruebas2;

import java.awt.Color;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OptionsWindow {
	
	// Campos
	
	// Ventana
	
	private JFrame theWindow;
	
	// Panel
	
	private JPanel thePanel;
	
	// Deslizadores
	
	private JSlider redSlider, greenSlider, blueSlider;
	
	// Escuchador
	
	private OptionsListener theOptionsListener;
	
	public static final int WIDTH = 220;
	
	public OptionsWindow() {
		initializeFields();
		setAttributes();
		addStuffToPanel();
		createWindow();
	}
	
	public void initializeFields() {
		theWindow = new JFrame( "Options" );
		thePanel = new JPanel();
		redSlider = new JSlider(0, 255);
		greenSlider = new JSlider(0, 255);
		blueSlider = new JSlider(0, 255);
		theOptionsListener = new OptionsListener();
	}
	
	public void setAttributes() {

		redSlider.setBorder(BorderFactory.createTitledBorder( "Rojo" ));
		redSlider.setMajorTickSpacing( 127 );
		redSlider.setValue( 127 );
		redSlider.setPaintLabels( true );
		redSlider.addChangeListener( theOptionsListener );
		
		greenSlider.setBorder(BorderFactory.createTitledBorder( "Verde" ));
		greenSlider.setMajorTickSpacing( 127 );		
		greenSlider.setValue( 127 );
		greenSlider.setPaintLabels( true );
		greenSlider.addChangeListener( theOptionsListener );
		
		blueSlider.setBorder(BorderFactory.createTitledBorder( "Azul" ));
		blueSlider.setMajorTickSpacing( 127 );
		blueSlider.setValue( 127 );
		blueSlider.setPaintLabels( true );
		blueSlider.addChangeListener( theOptionsListener );
	
	}
	
	public void addStuffToPanel() {
		thePanel.add( redSlider );
		thePanel.add( greenSlider );
		thePanel.add( blueSlider );
	}
	
	public void createWindow() {
		theWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		theWindow.setResizable( false );
		theWindow.setSize( WIDTH, PaintWindow.HEIGHT );
		
		Point locationPoint = PaintWindow.getWindowLocation();
		locationPoint.setLocation( locationPoint.getX() - WIDTH, locationPoint.getY() );
		theWindow.setLocation( locationPoint );
		theWindow.add( thePanel );
		theWindow.setVisible( true );
	}
	
	public int getRedValue() {
		return redSlider.getValue();
	}
	
	public int getGreenValue() {
		return greenSlider.getValue();
	}
	
	public int getBlueValue() {
		return blueSlider.getValue();
	}
	
	private class OptionsListener implements ChangeListener {
	
		public void stateChanged(ChangeEvent e) {
			
			int red = redSlider.getValue();
			int green = greenSlider.getValue();
			int blue = blueSlider.getValue();
			Color c = new Color( red, green, blue);
			thePanel.setBackground(c);
			
		}
		
	}

}
