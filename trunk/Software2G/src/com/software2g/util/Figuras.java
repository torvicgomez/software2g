package com.software2g.util;

//Demostraci�n de algunas figuras de Java2D.
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;

public class Figuras extends JFrame {

// establecer cadena de barra de t�tulo y dimensiones de la ventana
public Figuras() 
{
   super( "Dibujo de figuras en 2D" );

   setSize( 425, 160 );
   setVisible( true );
}

// dibujar figuras con la API Java2D
public void paint( Graphics g )
{
   super.paint( g );  // llamar al m�todo paint de la superclase

   Graphics2D g2d = ( Graphics2D ) g;  // convertir g a Graphics2D

   // dibujar elipse 2D rellena con un gradiente azul-amarillo
   g2d.setPaint( new GradientPaint( 5, 30, Color.BLUE, 35, 100, 
      Color.YELLOW, true ) );  
   g2d.fill( new Ellipse2D.Double( 5, 30, 65, 100 ) );

   // dibujar rect�ngulo 2D en rojo
   g2d.setPaint( Color.RED );                  
   g2d.setStroke( new BasicStroke( 10.0f ) ); 
   g2d.draw( new Rectangle2D.Double( 80, 30, 65, 100 ) );

   // dibujar rect�ngulo 2D redondeado con fondo tamponado
   BufferedImage buffImage = new BufferedImage( 10, 10, 
      BufferedImage.TYPE_INT_RGB );

   Graphics2D gg = buffImage.createGraphics();
   gg.setColor( Color.YELLOW ); // dibujar en amarillo
   gg.fillRect( 0, 0, 10, 10 ); // dibujar un rect�ngulo relleno
   gg.setColor( Color.BLACK );  // dibujar en negro
   gg.drawRect( 1, 1, 6, 6 );   // dibujar un rect�ngulo
   gg.setColor( Color.BLUE );   // dibujar en azul
   gg.fillRect( 1, 1, 3, 3 );   // dibujar un rect�ngulo relleno
   gg.setColor( Color.RED );    // dibujar en rojo
   gg.fillRect( 4, 4, 3, 3 );   // dibujar un rect�ngulo relleno

   // pintar buffImage en el objeto JFrame
   g2d.setPaint( new TexturePaint( buffImage, 
      new Rectangle( 10, 10 ) ) );
   g2d.fill( new RoundRectangle2D.Double( 155, 30, 75, 100, 50, 50 ) );

   // dibujar arco 2D en forma de pastel, en color blanco
   g2d.setPaint( Color.WHITE );
   g2d.setStroke( new BasicStroke( 6.0f ) ); 
   g2d.draw( new Arc2D.Double( 240, 30, 75, 100, 0, 270, Arc2D.PIE ) );

   // dibujar l�neas 2D en verde y amarillo
   g2d.setPaint( Color.GREEN );
   g2d.draw( new Line2D.Double( 395, 30, 320, 150 ) );

   float guiones[] = { 10 };

   g2d.setPaint( Color.YELLOW );    
   g2d.setStroke( new BasicStroke( 4, BasicStroke.CAP_ROUND,
      BasicStroke.JOIN_ROUND, 10, guiones, 0 ) ); 
   g2d.draw( new Line2D.Double( 320, 30, 395, 150 ) );

} // fin del m�todo paint

// ejecutar la aplicaci�n
public static void main( String args[] )
{
   Figuras aplicacion = new Figuras();
   aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
}

} // fin de la clase Figuras