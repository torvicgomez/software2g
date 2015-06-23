package com.software2g.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class UtilArchivo {

	/** Creates a new instance of UtilArchivo */
    public UtilArchivo() {
    }
    
    
    public static String leerArchivo(String url){
        BufferedReader buffer = null;
        String linea = null;
        String cadena = "";
        try{
            File file = new File(url);
            if(file.exists()){
                buffer = new BufferedReader(new FileReader(file));
                while( (linea = buffer.readLine()) != null ){
                    cadena += linea;
                }
            }else{
                System.out.println("El cadena " + url + " no existe");
            }
            buffer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return cadena;
    }

    public static boolean eliminarArchivo(String url){
        boolean resul = false;
        try{
            File file = new File(url);
            if(file.exists()){
                file.delete();
                resul = true;
            }else{
                System.out.println("El archivo " + url + " no existe");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return resul;
    }
    
    public static List<String> leerArchivoBecas(String url){
        BufferedReader buffer = null;
        String linea = null;
        List<String> cadena = new ArrayList<String>();
        try{
            File file = new File(url);
            System.out.println("file:["+file+"]");
            if(file.exists()){
            	System.out.println("Entra Esta Parte!!!!!!!");
                buffer = new BufferedReader(new FileReader(file));
                System.out.println("buffer:["+buffer+"]");
                while( (linea = buffer.readLine()) != null ){
                	System.out.println("linea:["+linea+"]");
                    cadena.add(linea);
                }
                buffer.close();
            }else{
                System.out.println("El cadena " + url + " no existe");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return cadena;
    }
}
