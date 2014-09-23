package com.software2g.util;

//Dibujo de arcos.
 import java.awt.*;
 import javax.swing.*;
 
 public class DibujarArcos extends JFrame {
 
    // establecer cadena de barra de título y dimensiones de la ventana
    public DibujarArcos()
    {
       super( "Dibujo de arcos" );
 
       setSize( 300, 170 );
       setVisible( true );
    }
 
    // dibujar rectángulos y arcos
    public void paint( Graphics g )
    {
       super.paint( g );  // llamar al método paint de la superclase
 
       // empezar en 0 y extenderse hasta 360 grados
       g.setColor( Color.YELLOW );
       g.drawRect( 15, 35, 80, 80 );
       g.setColor( Color.RED );
       g.drawArc( 15, 35, 80, 80, 0, 360 );
 
       // empezar en 0 y extenderse hasta 110 grados
       g.setColor( Color.YELLOW );
       g.drawRect( 100, 35, 80, 80 );
       g.setColor( Color.RED );
       g.drawArc( 100, 35, 80, 80, 0, 110 );
 
       // empezar en 0 y extenderse hasta -270 grados
       g.setColor( Color.YELLOW );
       g.drawRect( 185, 35, 80, 80 );
       g.setColor( Color.RED );
       g.drawArc( 185, 35, 80, 80, 0, -270 );
 
       // empezar en 0 y extenderse hasta 360 grados
       g.fillArc( 15, 120, 80, 40, 0, 360 );
 
       // empezar en 0 y extenderse hasta -90 grados
       g.fillArc( 100, 120, 80, 40, 270, -90 );
                  
       // empezar en 0 y extenderse hasta -270 grados
       g.fillArc( 185, 120, 80, 40, 0, -270 );
 
    } // fin del método paint
 
    // ejecutar la aplicación
    public static void main( String args[] )
    {
       DibujarArcos aplicacion = new DibujarArcos();
       aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
 
 } // fin de la clase DibujarArcos