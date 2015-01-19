package com.software2g.util;

import java.beans.Expression;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bsh.ParseException;

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
	    			if(expr!=null){
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
        	res=fmt.format(Double.parseDouble(str));
        }
        return res;
    }
    
    public static boolean validarFecha(String fecha) throws java.text.ParseException {  
    	if (fecha == null)  
    		return false;  
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //año-mes-dia  
    	if (fecha.trim().length() != dateFormat.toPattern().length())  
    		return false;  
    	dateFormat.setLenient(false);  
    	dateFormat.parse(fecha.trim());  
    	return true;  
    }
    
    public static boolean isNumericDouble(String cadena){
    	try {
    		Double.parseDouble(cadena);
    		return true;
    	} catch (NumberFormatException nfe){
    		return false;
    	}
    }
    
    public static String obtenerFechaCorte(int ano, int mes, int dia, int nrodias){
    	SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);
		Calendar cal = new GregorianCalendar(ano, (mes-1), dia);
        cal.add(Calendar.DATE, (int) nrodias);
        return sdf.format(new java.sql.Date(cal.getTimeInMillis()));
    }
    
    public static boolean esFechaMenor(Calendar f1,Calendar f2) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);
        try {
            Date fr1 = sdf.parse(sdf.format(f1.getTime()));
            Date fr2 = sdf.parse(sdf.format(f2.getTime()));
            return fr1.before(fr2);
        } catch (Exception e) {
            return false;
        }
    }

    public static double doublePrecision(BigDecimal valor,int scale, boolean roundUp){
    	int mode = (roundUp) ? BigDecimal.ROUND_UP : BigDecimal.ROUND_DOWN;
    	System.out.println("valor: ["+valor+"]");
    	System.out.println("precision: ["+valor.setScale(scale, mode)+"]");
    	return Double.parseDouble(valor.setScale(scale, mode).toString()); //.doubleValue();
    }
   
    public static double operacionMathAproximacion(double val1, double val2, int operacion){
    	DecimalFormat  df = new DecimalFormat("###########0.00");
		String valor = df.format(operacion==1?val1+val2:operacion==2?val1-val2:0);
		return Double.parseDouble(valor.replace(',','.'));
    }
    
    public static double doublePrecision(double valor){
    	DecimalFormat  df = new DecimalFormat("###########0.00");
		return Double.parseDouble(df.format(valor).replace(',','.'));
    }
}
