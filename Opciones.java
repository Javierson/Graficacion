
package Pruebas3;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.WritableRaster;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Opciones{
	
	// Campos
	
	// Ventana
	
	private JFrame VentanaFrame;
	
	// Panel
	
	private JPanel Panel;
	
	// Declarando privado el raster como comprobacion
	
	// private WritableRaster raster  =  image.getRaster();
	
	// Deslizadores
	
	private JSlider redSlider, greenSlider, blueSlider;
	
	// Botones
	
	private JButton DDAToolBTN, BresenhamToolBTN;
	
	// Cuadros de texto
	
	private JTextField DDAX1, DDAY1, DDAX2, DDAY2, Xc, Yc, r;
	
	// Escuchador
	
	private OptionsListener Escuchador;
	
	// Agregado como comprobacion
	
	public WritableRaster raster;
	
	public static final int WIDTH = 220;
	
	public Opciones() {
		CamposInicializados();
		Atributos();
		Componentes();
		Ventana();
	}
	
	public void CamposInicializados() {
		VentanaFrame = new JFrame( "Opciones" );
		Panel = new JPanel();
		redSlider = new JSlider(0, 255);
		greenSlider = new JSlider(0, 255);
		blueSlider = new JSlider(0, 255);
		Escuchador = new OptionsListener();
		// Creando los botones
		// de la linea y el circulo
		DDAToolBTN = new JButton( "Linea" );
		BresenhamToolBTN = new JButton( "Circulo" );
		// Atributos del dda recopilado del prog0111
		//JLabel LabelX1 = new JLabel( "X1" );
		DDAX1 = new JTextField ( 2 );
		DDAY1 = new JTextField( 2 );
		DDAX2 = new JTextField( 2 );
		DDAY2 = new JTextField( 2 );
		Xc = new JTextField( 2 );
		Yc = new JTextField( 2 );
		r = new JTextField( 2 );
		//ButtonGroup Agrupacion = new ButtonGroup();
	}
	
	public void Atributos() {

		redSlider.setBorder(BorderFactory.createTitledBorder( "Rojo" ));
		redSlider.setMajorTickSpacing( 127 );
		redSlider.setValue( 127 );
		redSlider.setPaintLabels( true );
		redSlider.addChangeListener( Escuchador );
		
		greenSlider.setBorder(BorderFactory.createTitledBorder( "Verde" ));
		greenSlider.setMajorTickSpacing( 127 );		
		greenSlider.setValue( 127 );
		greenSlider.setPaintLabels( true );
		greenSlider.addChangeListener( Escuchador );
		
		blueSlider.setBorder(BorderFactory.createTitledBorder( "Azul" ));
		blueSlider.setMajorTickSpacing( 127 );
		blueSlider.setValue( 127 );
		blueSlider.setPaintLabels( true );
		blueSlider.addChangeListener( Escuchador );
		
		// Escuchadores
		
		DDAToolBTN.addActionListener( Escuchador );
		BresenhamToolBTN.addActionListener( Escuchador );
		//DDAX1.addActionListener(Escuchador);
		//DDAY1.addActionListener(Escuchador);
		//DDAX2.addActionListener(Escuchador);
		//DDAY2.addActionListener(Escuchador);
			
	}
	
	public void Componentes() {
		
		Panel.add( redSlider );
		Panel.add( greenSlider );
		Panel.add( blueSlider );
		
		// Creando y agregando un label
		// por cada coordenada
		

		
		// Agregando los botones
		// al panel de dibujo
		
		
		
		// Creacion de un segundo panel para el dda
		
		JPanel PanelLinea = new JPanel();
		
		Panel.add( PanelLinea );
		PanelLinea.setBorder( BorderFactory.createTitledBorder( "DDA" ) );
		//PanelLinea.add( LabelX1 );
		//PanelLinea.add( DDAX1 );
		
		JLabel LabelX1 = new JLabel( "X1" );
		PanelLinea.add(LabelX1);
		PanelLinea.add( DDAX1 );
		
		JLabel LabelY1 = new JLabel( "Y1" );
		PanelLinea.add(LabelY1);
		PanelLinea.add( DDAY1 );
		
		
		JLabel LabelX2 = new JLabel( "X2" );
		PanelLinea.add(LabelX2);
		PanelLinea.add( DDAX2 );
		
		
		JLabel LabelY2 = new JLabel( "Y2" );
		PanelLinea.add(LabelY2);
		PanelLinea.add( DDAY2 );
		
		JPanel PanelCirculo = new JPanel();
		Panel.add( PanelCirculo );
		PanelCirculo.setBorder( BorderFactory.createTitledBorder( "Bresenham" ) );
		
		JLabel LabelXc = new JLabel( "Xc" );
		PanelCirculo.add( LabelXc );
		PanelCirculo.add( Xc );
		
		JLabel LabelYc = new JLabel( "Xc" );
		PanelCirculo.add( LabelYc );
		PanelCirculo.add( Yc );
		
		JLabel Labelr = new JLabel( "r" );
		PanelCirculo.add( Labelr );
		PanelCirculo.add( r );
		
		Panel.add( DDAToolBTN );
		Panel.add( BresenhamToolBTN );
		
	}
	
	public void Ventana() {
		VentanaFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		VentanaFrame.setResizable( false );
		VentanaFrame.setSize( WIDTH, PaintFrame.HEIGHT );
		Point locationPoint = PaintFrame.getWindowLocation();
		locationPoint.setLocation( locationPoint.getX() - WIDTH, locationPoint.getY() );
		VentanaFrame.setLocation( locationPoint );
		VentanaFrame.add( Panel );	
		VentanaFrame.setVisible( true );
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
	
	private class OptionsListener implements ChangeListener, ActionListener {
	
		public void stateChanged(ChangeEvent e) {
			
			int red = redSlider.getValue();
			int green = greenSlider.getValue();
			int blue = blueSlider.getValue();
			Color c = new Color( red, green, blue);
			Panel.setBackground(c);
			
		}

		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == DDAToolBTN) {					
				PaintPanel.DDATool(Integer.parseInt(DDAX1.getText()), Integer.parseInt(DDAY1.getText()), Integer.parseInt(DDAX2.getText()), Integer.parseInt(DDAY2.getText()), raster);
			}
			
			if(e.getSource() == BresenhamToolBTN) {
				
			}
		}
		/*
		private void DDATool(int DDAX1, int DDAY1, int DDAX2, int DDAY2, WritableRaster raster) {
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
		*/
	}

}
