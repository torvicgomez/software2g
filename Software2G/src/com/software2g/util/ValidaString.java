package com.software2g.util;

import java.beans.Expression;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaString {
	private static final String formatoFecha="yyyy-MM-dd";
	private static final String formatoHora="HH:mm:ss";
	public static final String NULLVALUE = "null";
	public static final String EMPTYSTRING = "EMPTYSTR";
	
	public ValidaString(){}
	/**
     * metodo para validar correo electronico
     * @param correo
     * @return
     */
    public static boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;        
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            //System.out.println("[" + mat.group() + "]");
            return true;
        }else{
            return false;
        }        
    }
    
    /**
     * metodo para validar correo electronico pero con el parametro de un dominio especifico
     * @param correo
     * @return
     */
    public static boolean isEmail(String correo, String dominio) {
    	correo = correo.toLowerCase();
    	dominio = dominio.toLowerCase();
        Pattern pat = null;
        Matcher mat = null;        
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            System.out.println("[" + mat.group() + "]");
            if(dominio!=null){
            	String help[] = mat.group().toString().split("@");
            	if(help[1].toString().equals(dominio))
            		return true;
            }
            return false;
        }else{
            return false;
        }        
    }
    
    public static String fechaSystem(){
    	SimpleDateFormat format = new SimpleDateFormat(formatoFecha);
		return format.format(new Date());
    }
    
    public static String fechaSystem(String formato){
    	SimpleDateFormat format = new SimpleDateFormat(formato==null||formato.equals("")?formatoFecha:formato);
		return format.format(new Date());
    }
    
    public static String horaSystem(){
    	SimpleDateFormat format = new SimpleDateFormat(formatoHora);
		return format.format(new Date());
    }
    
    public static String horaSystem(String formato){
    	SimpleDateFormat format = new SimpleDateFormat(formato==null||formato.equals("")?formatoHora:formato);
		return format.format(new Date());
    }
    
    public static String toUpperCase(String cadena){
    	return cadena.toUpperCase();
    }
    
    public static void imprimirObject(Object obj){
    	System.out.println("------------------------------------------------");
    	System.out.println("----------"+obj.getClass().getName()+"----------");
    	try{
	    	for(Method elem:obj.getClass().getMethods()){
	    		if(elem.getName().substring(0, 3).equals("get")){
	    			Expression expr = new Expression(obj, elem.getName(), new Object[0]);
	    			expr.execute();
	    			Object o = expr.getValue();
	    			if (o == null) {
	    	            System.out.println(elem.getName() + " : valor nulo");
	    	        } else {
	    	        	System.out.println(elem.getName());
	    	            System.out.println(elem.getName() + " : ["+o.toString()+"]");
	    	        }
	    		}
	    	}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	System.out.println("------------------------------------------------");
    	System.out.println("------------------------------------------------");
    }
    
    public static String formatoFecha(String fecha){
    	SimpleDateFormat format = new SimpleDateFormat(formatoFecha);
		return format.format(new Date(fecha));
    }
    
    public static boolean isEmptyString(String str){
        if(str.length()==0)return true;
        if(str.equals(EMPTYSTRING))return true;        
        return false;
    }
    public static boolean isNullString(String str){
        if(str==null)return true;
        if(str.equals(NULLVALUE))return true;        
        return false;
    }
     public static boolean isNullOrEmptyString(String str){
        if(ValidaString.isNullString(str)) return true;
        if(ValidaString.isEmptyString(str)) return true;
        return false;        
    }
    
    public static String formatToMoney(String str){
        DecimalFormat fmt = new DecimalFormat("###,###,###,##0.00");
        String res = "0,00";
        if(!ValidaString.isNullOrEmptyString(str)){
        	res=fmt.format(Float.parseFloat(str));
        }
        return res;
    }
}
