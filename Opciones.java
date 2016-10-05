
package Pruebas3;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Opciones {
	
	// Campos
	
	// Ventana
	
	private JFrame VentanaFrame;
	
	// Panel
	
	private JPanel Panel;
	
	// Deslizadores
	
	private JSlider redSlider, greenSlider, blueSlider;
	
	// Botones
	
	private JButton DDAToolBTN, BresenhamToolBTN;
	
	// Cuadros de texto
	
	private JTextField DDAX1, DDAY1, DDAX2, DDAY2, Xc, Yc, r;
	
	// Escuchador
	
	private OptionsListener Escuchador;
	
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
		DDAX1 = new JTextField( 2 );
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
		DDAX1.addActionListener(Escuchador);
		DDAY1.addActionListener(Escuchador);
		DDAX2.addActionListener(Escuchador);
		DDAY2.addActionListener(Escuchador);
			
	}
	
	public void Componentes() {
		
		Panel.add( redSlider );
		Panel.add( greenSlider );
		Panel.add( blueSlider );

		
		// Creando y agregando un label
		// por cada coordenada
		
		JLabel LabelX1 = new JLabel( "X1" );
		//thePanel.add(LabelX1);
		//thePanel.add( DDAX1 );
		
		JLabel LabelY1 = new JLabel( "Y1" );
		Panel.add(LabelY1);
		Panel.add( DDAY1 );
		
		
		JLabel LabelX2 = new JLabel( "X2" );
		Panel.add(LabelX2);
		Panel.add( DDAX2 );
		
		
		JLabel LabelY2 = new JLabel( "Y2" );
		Panel.add(LabelY2);
		Panel.add( DDAY2 );
		
		// Agregando los botones
		// al panel de dibujo
		
		Panel.add( DDAToolBTN );
		
		
		/* Creacion de un segundo panel para el dda
		
		JPanel PanelLinea = new JPanel();
		
		theWindow.add( PanelLinea );
		PanelLinea.setBorder( BorderFactory.createTitledBorder( "Seleccione:" ) );
		PanelLinea.add( LabelX1 );
		PanelLinea.add( DDAX1 );
		*/
		
		JLabel LabelXc = new JLabel( "Xc" );
		Panel.add( LabelXc );
		Panel.add( Xc );
		
		JLabel LabelYc = new JLabel( "Xc" );
		Panel.add( LabelYc );
		Panel.add( Yc );
		
		JLabel Labelr = new JLabel( "r" );
		Panel.add( Labelr );
		Panel.add( r );
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
			
		}
		
	}

}
