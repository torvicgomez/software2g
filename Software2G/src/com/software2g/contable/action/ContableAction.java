package com.software2g.contable.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.software2g.contable.facade.IGestionFacadeContable;
import com.software2g.util.ConstantesAplicativo;
import com.software2g.util.ValidaString;
import com.software2g.vo.Abono;
import com.software2g.vo.Credito;
import com.software2g.vo.Donacion;
import com.software2g.vo.Donacionobjeto;
import com.software2g.vo.Entidaddonante;
import com.software2g.vo.Objeto;
import com.software2g.vo.Pagare;
import com.software2g.vo.Persona;
import com.software2g.vo.Presupuesto;
import com.software2g.vo.Presupuestodonacion;
import com.software2g.vo.Sucursal;
import com.software2g.vo.Tipocredito;
import com.software2g.vo.Tipocreditoseguroadquirido;
import com.software2g.vo.Tipopagare;
import com.software2g.vo.Usuario;

public class ContableAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	private static final long serialVersionUID = -1570402259118532664L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private IGestionFacadeContable gestionFacadeContable;
	private String estado;
	
	private List<Sucursal> listSucursal;
	private Sucursal sucursalVO;
	private List<Entidaddonante> listEntidades;
	private Entidaddonante entidadVO;
	private List<Objeto> listObjetos;
	private Objeto objetoVO;
	private List<Donacion> listDonaciones;
	private Donacion donacionVO;
	private Donacionobjeto donacionObjetoVO;
	private List<Donacionobjeto> listDonancionObjeto;
	private List<Presupuesto> listPresupuesto;
	private Presupuesto presupuestoVO;
	private Presupuestodonacion presupuestoDonacionVO;
	private List<Presupuestodonacion> listPresupuestoDonaVO;
	private List<Pagare> listPagare;
	private Pagare pagareVO;
	private List<Tipopagare> listTipoPagare;
	private List<Persona> listPersonas;
	private Persona personaVO;
	private List<Tipocredito> listTipoCredito;
	private Tipocredito tipoCreditoVO;
	private List<Credito> listCredito;
	private Credito creditoVO;
	private Abono abonoVO;
	
	public List<Sucursal> getListSucursal() {return listSucursal;}
	public void setListSucursal(List<Sucursal> listSucursal) {this.listSucursal = listSucursal;}
	public Sucursal getSucursalVO() {return sucursalVO;}
	public void setSucursalVO(Sucursal sucursalVO) {this.sucursalVO = sucursalVO;}
	public ContableAction(IGestionFacadeContable gestionFacadeContable) {this.gestionFacadeContable = gestionFacadeContable;}
	public List<Entidaddonante> getListEntidades() {return listEntidades;}
	public void setListEntidades(List<Entidaddonante> listEntidades) {this.listEntidades = listEntidades;}
	public Entidaddonante getEntidadVO() {return entidadVO;}
	public void setEntidadVO(Entidaddonante entidadVO) {this.entidadVO = entidadVO;}
	public List<Objeto> getListObjetos() {return listObjetos;}
	public void setListObjetos(List<Objeto> listObjetos) {this.listObjetos = listObjetos;}
	public Objeto getObjetoVO() {return objetoVO;}
	public void setObjetoVO(Objeto objetoVO) {this.objetoVO = objetoVO;}
	public List<Donacion> getListDonaciones() {return listDonaciones;}
	public void setListDonaciones(List<Donacion> listDonaciones) {this.listDonaciones = listDonaciones;}
	public Donacion getDonacionVO() {return donacionVO;}
	public void setDonacionVO(Donacion donacionVO) {this.donacionVO = donacionVO;}
	public Donacionobjeto getDonacionObjetoVO() {return donacionObjetoVO;}
	public void setDonacionObjetoVO(Donacionobjeto donacionObjetoVO) {this.donacionObjetoVO = donacionObjetoVO;}
	public List<Donacionobjeto> getListDonancionObjeto() {return listDonancionObjeto;}
	public void setListDonancionObjeto(List<Donacionobjeto> listDonancionObjeto) {this.listDonancionObjeto = listDonancionObjeto;}
	public List<Presupuesto> getListPresupuesto() {return listPresupuesto;}
	public void setListPresupuesto(List<Presupuesto> listPresupuesto) {this.listPresupuesto = listPresupuesto;}
	public Presupuesto getPresupuestoVO() {return presupuestoVO;}
	public void setPresupuestoVO(Presupuesto presupuestoVO) {this.presupuestoVO = presupuestoVO;}
	public Presupuestodonacion getPresupuestoDonacionVO() {return presupuestoDonacionVO;}
	public void setPresupuestoDonacionVO(Presupuestodonacion presupuestoDonacionVO) {this.presupuestoDonacionVO = presupuestoDonacionVO;}
	public List<Presupuestodonacion> getListPresupuestoDonaVO() {return listPresupuestoDonaVO;}
	public void setListPresupuestoDonaVO(List<Presupuestodonacion> listPresupuestoDonaVO) {this.listPresupuestoDonaVO = listPresupuestoDonaVO;}
	public List<Pagare> getListPagare() {return listPagare;}
	public void setListPagare(List<Pagare> listPagare) {this.listPagare = listPagare;}
	public Pagare getPagareVO() {return pagareVO;}
	public void setPagareVO(Pagare pagareVO) {this.pagareVO = pagareVO;}
	public List<Tipopagare> getListTipoPagare() {return listTipoPagare;}
	public void setListTipoPagare(List<Tipopagare> listTipoPagare) {this.listTipoPagare = listTipoPagare;}
	public List<Persona> getListPersonas() {return listPersonas;}
	public void setListPersonas(List<Persona> listPersonas) {this.listPersonas = listPersonas;}
	public Persona getPersonaVO() {return personaVO;}
	public void setPersonaVO(Persona personaVO) {this.personaVO = personaVO;}
	public List<Tipocredito> getListTipoCredito() {return listTipoCredito;}
	public void setListTipoCredito(List<Tipocredito> listTipoCredito) {this.listTipoCredito = listTipoCredito;}
	public List<Credito> getListCredito() {return listCredito;}
	public void setListCredito(List<Credito> listCredito) {this.listCredito = listCredito;}
	public Credito getCreditoVO() {return creditoVO;}
	public void setCreditoVO(Credito creditoVO) {this.creditoVO = creditoVO;}
	public Tipocredito getTipoCreditoVO() {return tipoCreditoVO;}
	public void setTipoCreditoVO(Tipocredito tipoCreditoVO) {this.tipoCreditoVO = tipoCreditoVO;}
	public Abono getAbonoVO() {return abonoVO;}
	public void setAbonoVO(Abono abonoVO) {this.abonoVO = abonoVO;}
	
	
	@SkipValidation
    public String execute() {
		String  result = Action.SUCCESS; 
    	try {   
    		String url = request.getParameter("url")==null?"":(String)request.getParameter("url");
    		request.getSession().setAttribute("url", url);
		} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
    }
	
	@SkipValidation
    public String listarSucursales(){
		String  result = Action.SUCCESS; 
    	try { 
    		if(request.getSession().getAttribute("url")==null||((String)request.getSession().getAttribute("url")).equals("")){
    			String url = request.getParameter("url")==null?"":(String)request.getParameter("url");
    			request.getSession().setAttribute("url", url);
    		}else if(request.getParameter("url")!=null){
    			request.getSession().setAttribute("url", (String)request.getParameter("url"));
    		}
    		setListSucursal(gestionFacadeContable.findAllSucursals());
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}

	@SkipValidation
    public String crearSucursal(){
		String  result = Action.SUCCESS; 
    	try { 
    		if(request.getParameter("id")!=null&&Long.parseLong((String)request.getParameter("id"))>0)
    			setSucursalVO(gestionFacadeContable.findSucursalById(Long.parseLong((String)request.getParameter("id"))));
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String saveSucursal(){
		String  result = Action.SUCCESS; 
    	try {
    		if(sucursalVO!=null){
    			if(sucursalVO.getSucuNombre()==null||sucursalVO.getSucuNombre().equals(""))
    				addActionMessage(getText("validacion.requerido","nombreSucursal","Nombre"));
    			//ValidaString.imprimirObject(sucursalVO);
    			if(!hasActionMessages()){
    				sucursalVO.setSucuFechamodificacion(ValidaString.fechaSystem());
    				sucursalVO.setSucuHora(ValidaString.horaSystem());
    				sucursalVO.setSucuRegistradopor(((Usuario)request.getSession().getAttribute("usuarioVO")).getLoginUsua());
    				gestionFacadeContable.persistSucursal(sucursalVO);
    				setListSucursal(gestionFacadeContable.findAllSucursals());
    			}else
    				result=Action.ERROR;
    		}else
    			System.out.println("Esta itentando ingresar ilegalmente!!!!!");
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String listarEntidades(){
		String  result = Action.SUCCESS; 
    	try { 
    		if(request.getSession().getAttribute("url")==null||((String)request.getSession().getAttribute("url")).equals("")){
    			String url = request.getParameter("url")==null?"":(String)request.getParameter("url");
    			request.getSession().setAttribute("url", url);
    		}else if(request.getParameter("url")!=null){
    			request.getSession().setAttribute("url", (String)request.getParameter("url"));
    		}
    		setListEntidades(gestionFacadeContable.findAllEntidaddonantes());
    		estado="listarEntidades";
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String crearEntidad(){
		String  result = Action.SUCCESS; 
    	try {
    		if((String)request.getParameter("id")!=null&&(Integer.parseInt((String)request.getParameter("id")))>0)
    			setEntidadVO(gestionFacadeContable.findEntidaddonanteById(Long.parseLong((String)request.getParameter("id"))));
    		estado="crearEntidad";
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String saveEntidad(){
		String  result = Action.SUCCESS; 
    	try { 
    		if(entidadVO!=null){
    			//ValidaString.imprimirObject(entidadVO);
    			if(entidadVO.getEndoNit()==null||entidadVO.getEndoNit().equals(""))
    				addActionMessage(getText("validacion.requerido","nitEntidad","Identificación Entidad"));
    			if(entidadVO.getEndoRazonsocial()==null||entidadVO.getEndoRazonsocial().equals(""))
    				addActionMessage(getText("validacion.requerido","razonSocialEntidad","Razón Social"));
    			if(!hasActionMessages()){
    				entidadVO.setEndoFechamodificacion(ValidaString.fechaSystem());
    				entidadVO.setEndoHora(ValidaString.horaSystem());
    				entidadVO.setEndoRegistradopor(((Usuario)request.getSession().getAttribute("usuarioVO")).getLoginUsua());
    				gestionFacadeContable.persistEntidaddonante(entidadVO);
    				setListEntidades(gestionFacadeContable.findAllEntidaddonantes());
    				estado="listarEntidades";
    			}else
    				estado="crearEntidad";
    		}else
    			System.out.println("esta intnetando ingresar ilegalmente!!!!!");
    		
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String listarObjetos(){
		String  result = Action.SUCCESS; 
    	try { 
    		if(request.getSession().getAttribute("url")==null||((String)request.getSession().getAttribute("url")).equals("")){
    			String url = request.getParameter("url")==null?"":(String)request.getParameter("url");
    			request.getSession().setAttribute("url", url);
    		}else if(request.getParameter("url")!=null){
    			request.getSession().setAttribute("url", (String)request.getParameter("url"));
    		}
    		setListObjetos(gestionFacadeContable.findAllObjetos());
    		estado="listarObjetos";
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String crearObjeto(){
		String  result = Action.SUCCESS; 
    	try {
    		if((String)request.getParameter("id")!=null&&(Integer.parseInt((String)request.getParameter("id")))>0)
    			setObjetoVO(gestionFacadeContable.findObjetoById(Long.parseLong((String)request.getParameter("id"))));
    		estado="crearObjeto";
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String saveObjeto(){
		String  result = Action.SUCCESS; 
    	try { 
    		if(objetoVO!=null){
    			if(objetoVO.getObjeMotivo() ==null||objetoVO.getObjeMotivo().equals(""))
    				addActionMessage(getText("validacion.requerido","motivoObjeto","Producto"));
    			if(!hasActionMessages()){
    				objetoVO.setObjeFechamodificacion(ValidaString.fechaSystem());
    				objetoVO.setObjeHora(ValidaString.horaSystem());
    				objetoVO.setObjeRegistradopor(((Usuario)request.getSession().getAttribute("usuarioVO")).getLoginUsua());
    				gestionFacadeContable.persistObjeto(objetoVO);
    				setListObjetos(gestionFacadeContable.findAllObjetos());
    				estado="listarObjetos";
    			}else
    				estado="crearObjeto";
    		}else
    			System.out.println("esta intnetando ingresar ilegalmente!!!!!");
    		
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String listDonaciones(){
		String  result = Action.SUCCESS; 
    	try { 
    		if(request.getSession().getAttribute("url")==null||((String)request.getSession().getAttribute("url")).equals("")){
    			String url = request.getParameter("url")==null?"":(String)request.getParameter("url");
    			request.getSession().setAttribute("url", url);
    		}else if(request.getParameter("url")!=null){
    			request.getSession().setAttribute("url", (String)request.getParameter("url"));
    		}
    		setListDonaciones(gestionFacadeContable.findAllDonacions());
    		estado="listarDonanciones";
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String crearDonaciones(){
		String  result = Action.SUCCESS; 
    	try {
    		if((String)request.getParameter("id")!=null&&(Integer.parseInt((String)request.getParameter("id")))>0){
    			setDonacionVO(gestionFacadeContable.findDonacionById(Long.parseLong((String)request.getParameter("id"))));
    			//System.out.println("listDonacionObjeto: ["+donacionVO.getDonacionobjetos()+"]");
    			listDonancionObjeto = gestionFacadeContable.findAllDonacionobjetos(Long.parseLong((String)request.getParameter("id")));
    			request.getSession().setAttribute("listDonacionObj", listDonancionObjeto);
    		}else
    			request.getSession().removeAttribute("listDonacionObj");
    		setListEntidades(gestionFacadeContable.findAllEntidaddonantes());
    		setListObjetos(gestionFacadeContable.findAllObjetos());
    		estado=getDonacionVO()!=null&&getDonacionVO().getDonaEstado()!=null&&getDonacionVO().getDonaEstado().equals(ConstantesAplicativo.estadoPresupuesto)?"verDonacion":"crearDonacion";
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String saveDonaciones(){
		String  result = Action.SUCCESS; 
    	try { 
    		System.out.println("donacionVO: ["+donacionVO+"]");
    		System.out.println("estado:["+estado+"]");
    		System.out.println("fecha: ["+donacionVO.getDonaFecha().toString()+"]");
    		if(donacionVO!=null){
    			
    			listDonancionObjeto = (ArrayList<Donacionobjeto>)request.getSession().getAttribute("listDonacionObj");
    			if(donacionVO.getEntidaddonante()==null||donacionVO.getEntidaddonante().getEndoId()<=0)
    				addActionMessage(getText("validacion.requerido","entidadDonante","Entidad Donante"));
    			if(donacionVO.getDonaFecha()==null||donacionVO.getDonaFecha().equals(""))
    				addActionMessage(getText("validacion.requerido","fechaDonacion","Fecha Donación"));
    			if(donacionVO.getDonaValor()==null||donacionVO.getDonaValor().doubleValue()<=0)
    				addActionMessage(getText("validacion.requerido","valorDonacion","Cantidad Donada"));
    			if(listDonancionObjeto==null||listDonancionObjeto.size()<=0)
    				addActionMessage(getText("validacion.asociarobj","productosasociar",""));
    			if(!hasActionMessages()){
    				//donacionVO.setDonacionobjetos(listDonancionObjeto);
    				donacionVO.setDonaEstado(ConstantesAplicativo.estadoDonacion);
    				donacionVO.setDonaFechamodificacion(ValidaString.fechaSystem());
    				donacionVO.setDonaHora(ValidaString.horaSystem());
    				donacionVO.setDonaRegistradopor(((Usuario)request.getSession().getAttribute("usuarioVO")).getLoginUsua());
    				gestionFacadeContable.persistDonacion(donacionVO);
    				setListDonaciones(gestionFacadeContable.findAllDonacions());
    				if(donacionVO.getDonaId()<=0){
	    				System.out.println("*********************************************");
	    				System.out.println("*********************************************");
	    				Donacion data = gestionFacadeContable.findIdDonacion(donacionVO.getDonaFechamodificacion(), donacionVO.getDonaHora());
	    				for(Donacionobjeto elem:listDonancionObjeto){
	    					elem.getId().setDonaId(data.getDonaId());
	    					gestionFacadeContable.persistDonacionobjeto(elem);
	    				}
	    				//ValidaString.imprimirObject(data);
	    				System.out.println("idDonacion: ["+data.getDonaId()+"]");
	    				System.out.println("*********************************************");
	    				System.out.println("*********************************************");
    				}
    	    		estado="listarDonanciones";
    	    		
    			}else{
    				setListEntidades(gestionFacadeContable.findAllEntidaddonantes());
    				setListObjetos(gestionFacadeContable.findAllObjetos());
    				estado="crearDonacion";
    			}
    		}else
    			System.out.println("esta intentando ingresar ilegalmente!!!!!");
    		
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}

	@SkipValidation
    public String addProdDonacion(){
		String  result = Action.SUCCESS; 
    	try {
    		if(donacionObjetoVO!=null){
    			//ValidaString.imprimirObject(donacionObjetoVO);
    			if(donacionObjetoVO.getId().getObjeId()<=0)
    				addActionMessage(getText("validacion.requerido","asociarProd","Producto"));
    			if(donacionObjetoVO.getObdoEstado()==null||donacionObjetoVO.getObdoEstado().equals("-1"))
    				addActionMessage(getText("validacion.requerido","estadoProdAso","Estado"));
    			if(!hasActionMessages()){
		    		Donacionobjeto data = new Donacionobjeto();
		    		data.setId(donacionObjetoVO.getId());
		    		data.getId().setDonaId(donacionVO.getDonaId());
		    		data.setObdoEstado(donacionObjetoVO.getObdoEstado());
		    		data.setNombreObjeto(donacionObjetoVO.getNombreObjeto());
		    		data.setEstadoText(donacionObjetoVO.getEstadoText());
		    		data.setObdoFechamodificacion(ValidaString.fechaSystem());
		    		data.setObdoHora(ValidaString.horaSystem());
		    		data.setObdoRegistradopor(((Usuario)request.getSession().getAttribute("usuarioVO")).getLoginUsua());
		    		if(request.getSession().getAttribute("listDonacionObj")==null)
		    			listDonancionObjeto = new ArrayList<Donacionobjeto>();
		    		else
		    			listDonancionObjeto = (ArrayList<Donacionobjeto>)request.getSession().getAttribute("listDonacionObj");
		    		if(listDonancionObjeto!=null&&listDonancionObjeto.size()>0){
		    			boolean band=false;
		    			for(Donacionobjeto elem:listDonancionObjeto){
		    				if(elem.getId().getObjeId()==data.getId().getObjeId()){
		    					addActionMessage(getText("validacion.addobjeto","addObjeto",data.getNombreObjeto()));
		    					band=true;
		    					break;
		    				}
		    			}
		    			if(!band)
		    				listDonancionObjeto.add(data);
		    		}else
		    			listDonancionObjeto.add(data);
		    		if(data.getId().getDonaId()>0)
		    			gestionFacadeContable.persistDonacionobjeto(data);
		    		request.getSession().removeAttribute("listDonacionObj");
		    		request.getSession().setAttribute("listDonacionObj", listDonancionObjeto);
		    		donacionObjetoVO=null;
    			}
    			setListEntidades(gestionFacadeContable.findAllEntidaddonantes());
	    		setListObjetos(gestionFacadeContable.findAllObjetos());
	    		estado="crearDonacion";
    		}else
    			System.out.println("Esta intentando ingresar ilegalmente!!!!!!!!!!!");
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String delProdDonacion(){
		String  result = Action.SUCCESS; 
    	try {
    		System.out.println("posicion: ["+request.getParameter("pos")+"]");
    		listDonancionObjeto = (ArrayList<Donacionobjeto>)request.getSession().getAttribute("listDonacionObj");
    		if(((Donacionobjeto)listDonancionObjeto.get(Integer.parseInt(request.getParameter("pos")))).getId().getDonaId()>0
    				&&((Donacionobjeto)listDonancionObjeto.get(Integer.parseInt(request.getParameter("pos")))).getId().getObjeId()>0)
    			gestionFacadeContable.removeDonacionobjeto(((Donacionobjeto)listDonancionObjeto.get(Integer.parseInt(request.getParameter("pos")))));
    		listDonancionObjeto.remove(Integer.parseInt(request.getParameter("pos")));
    		request.getSession().removeAttribute("listDonacionObj");
    		request.getSession().setAttribute("listDonacionObj", listDonancionObjeto);
    		setListEntidades(gestionFacadeContable.findAllEntidaddonantes());
    		setListObjetos(gestionFacadeContable.findAllObjetos());
    		estado="crearDonacion";
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String listPresupuestos(){
		String  result = Action.SUCCESS; 
    	try { 
    		if(request.getSession().getAttribute("url")==null||((String)request.getSession().getAttribute("url")).equals("")){
    			String url = request.getParameter("url")==null?"":(String)request.getParameter("url");
    			request.getSession().setAttribute("url", url);
    		}else if(request.getParameter("url")!=null){
    			request.getSession().setAttribute("url", (String)request.getParameter("url"));
    		}
    		setListPresupuesto(gestionFacadeContable.findAllPresupuestos());
    		estado="listarPresupuesto";
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String crearPresupuesto(){
		String  result = Action.SUCCESS; 
    	try {
    		if((String)request.getParameter("id")!=null&&(Integer.parseInt((String)request.getParameter("id")))>0){
    			setPresupuestoVO(gestionFacadeContable.findPresupuestoById(Long.parseLong((String)request.getParameter("id"))));
    			listPresupuestoDonaVO = gestionFacadeContable.findAllPresupuestodonacions(getPresupuestoVO().getPresId(),0);
    			request.getSession().setAttribute("listPresupuestoDona", listPresupuestoDonaVO);
    		}else
    			request.getSession().removeAttribute("listPresupuestoDona");
    		setListEntidades(gestionFacadeContable.findAllEntidaddonantes());
    		estado="crearPresupuesto";
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String loadDonacionesEntidades(){
		String  result = Action.SUCCESS; 
    	try {
    		if(getDonacionVO().getEntidaddonante().getEndoId()>0)
    			setListDonaciones(gestionFacadeContable.findDonacionIdEntidad(getDonacionVO().getEntidaddonante().getEndoId()));
    		estado="crearPresupuesto";
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String loadValorDonacionesEntidades(){
		String  result = Action.SUCCESS; 
    	try {
    		if(getDonacionVO().getDonaId()>0)
    			setDonacionVO(gestionFacadeContable.findDonacionById(getDonacionVO().getDonaId()));
    		estado="crearPresupuesto";
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String addPresDonacion(){
		String  result = Action.SUCCESS; 
    	try {
    		if(donacionVO!=null){
    			if(donacionVO.getEntidaddonante()==null||donacionVO.getEntidaddonante().getEndoId()<=0)
    				addActionMessage(getText("validacion.requerido","entDonante","Entidad Donante"));
    			if(donacionVO.getDonaId()<=0)
    				addActionMessage(getText("validacion.requerido","donacion","Descripción Donacion"));
    			if(!hasActionMessages()){
    				Presupuestodonacion data = new Presupuestodonacion();
    				data.getId().setPresId(getPresupuestoVO().getPresId());
    				data.getId().setDonaId(getDonacionVO().getDonaId());
    				data.setPrdoMonto(getDonacionVO().getDonaValor().doubleValue());
    				data.setPrdoMontoStrig(ValidaString.formatToMoney(getDonacionVO().getDonaValor().toString()));
    				data.setDonacion(getDonacionVO());
    				data.setPrdoFechamodificacion(ValidaString.fechaSystem());
    				data.setPrdoHora(ValidaString.horaSystem());
    				data.setPrdoRegistradopor(((Usuario)request.getSession().getAttribute("usuarioVO")).getLoginUsua());
    				if(request.getSession().getAttribute("listPresupuestoDona")==null)
		    			listPresupuestoDonaVO = new ArrayList<Presupuestodonacion>();
		    		else
		    			listPresupuestoDonaVO = (ArrayList<Presupuestodonacion>)request.getSession().getAttribute("listPresupuestoDona");
		    		if(listPresupuestoDonaVO!=null&&listPresupuestoDonaVO.size()>0){
		    			boolean band=false;
		    			for(Presupuestodonacion elem:listPresupuestoDonaVO){
		    				if(elem.getId().getDonaId()==data.getId().getDonaId()){
		    					addActionMessage(getText("validacion.addobjeto","addDonacion",data.getDonacion().getDonaDescripcion()));
		    					band=true;
		    					break;
		    				}
		    			}
		    			if(!band){
		    				listPresupuestoDonaVO.add(data);
		    				getPresupuestoVO().setPresValor(getPresupuestoVO().getPresValor()+data.getPrdoMonto());
		    				getPresupuestoVO().setPresValorString(ValidaString.formatToMoney(String.valueOf(getPresupuestoVO().getPresValor())));
		    			}
		    		}else{
		    			listPresupuestoDonaVO.add(data);
		    			getPresupuestoVO().setPresValor(getPresupuestoVO().getPresValor()+data.getPrdoMonto());
		    			getPresupuestoVO().setPresValorString(ValidaString.formatToMoney(String.valueOf(getPresupuestoVO().getPresValor())));
		    		}
		    		if(data.getId().getPresId()>0){
		    			//1. Actualizar presupuesto
		    			getPresupuestoVO().setPresFechamodificacion(ValidaString.fechaSystem());
		    			getPresupuestoVO().setPresHora(ValidaString.horaSystem());
		    			getPresupuestoVO().setPresRegistradopor(((Usuario)request.getSession().getAttribute("usuarioVO")).getLoginUsua());
		    			gestionFacadeContable.persistPresupuesto(getPresupuestoVO());
		    			//2. Actualizar Donacion
		    			data.getDonacion().setDonaEstado(ConstantesAplicativo.estadoPresupuesto);
		    			data.getDonacion().setDonaFechamodificacion(ValidaString.fechaSystem());
		    			data.getDonacion().setDonaHora(ValidaString.horaSystem());
		    			data.getDonacion().setDonaRegistradopor(((Usuario)request.getSession().getAttribute("usuarioVO")).getLoginUsua());
		    			gestionFacadeContable.persistDonacion(data.getDonacion());
		    			//3. insertar presupuesto donacion
		    			gestionFacadeContable.persistPresupuestodonacion(data);
		    		}
		    		request.getSession().removeAttribute("listPresupuestoDona");
		    		request.getSession().setAttribute("listPresupuestoDona", listPresupuestoDonaVO);
		    		donacionVO=null;
    			}
    		}else
    			System.out.println("Esta intentanto ingresar ilegalmente!!!!");
    		setListEntidades(gestionFacadeContable.findAllEntidaddonantes());
    		estado="crearPresupuesto";
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String delPresDonacion(){
		String  result = Action.SUCCESS; 
    	try {
    		System.out.println("posicion: ["+request.getParameter("pos")+"]");
    		listPresupuestoDonaVO = (ArrayList<Presupuestodonacion>)request.getSession().getAttribute("listPresupuestoDona");
    		getPresupuestoVO().setPresValor(getPresupuestoVO().getPresValor()-((Presupuestodonacion)listPresupuestoDonaVO.get(Integer.parseInt(request.getParameter("pos")))).getPrdoMonto());
			getPresupuestoVO().setPresValorString(ValidaString.formatToMoney(String.valueOf(getPresupuestoVO().getPresValor())));
    		if(((Presupuestodonacion)listPresupuestoDonaVO.get(Integer.parseInt(request.getParameter("pos")))).getId().getDonaId()>0
    				&&((Presupuestodonacion)listPresupuestoDonaVO.get(Integer.parseInt(request.getParameter("pos")))).getId().getPresId()>0){
    			//1. Actualizar presupuesto
    			getPresupuestoVO().setPresFechamodificacion(ValidaString.fechaSystem());
    			getPresupuestoVO().setPresHora(ValidaString.horaSystem());
    			getPresupuestoVO().setPresRegistradopor(((Usuario)request.getSession().getAttribute("usuarioVO")).getLoginUsua());
    			gestionFacadeContable.persistPresupuesto(getPresupuestoVO());
    			//2. Actualizar Donacion
    			((Presupuestodonacion)listPresupuestoDonaVO.get(Integer.parseInt(request.getParameter("pos")))).getDonacion().setDonaEstado(ConstantesAplicativo.estadoDonacion);
    			((Presupuestodonacion)listPresupuestoDonaVO.get(Integer.parseInt(request.getParameter("pos")))).getDonacion().setDonaFechamodificacion(ValidaString.fechaSystem());
    			((Presupuestodonacion)listPresupuestoDonaVO.get(Integer.parseInt(request.getParameter("pos")))).getDonacion().setDonaHora(ValidaString.horaSystem());
    			((Presupuestodonacion)listPresupuestoDonaVO.get(Integer.parseInt(request.getParameter("pos")))).getDonacion().setDonaRegistradopor(((Usuario)request.getSession().getAttribute("usuarioVO")).getLoginUsua());
    			gestionFacadeContable.persistDonacion(((Presupuestodonacion)listPresupuestoDonaVO.get(Integer.parseInt(request.getParameter("pos")))).getDonacion());
    			//3. remover presupuesto donacion
    			gestionFacadeContable.removePresupuestodonacion(((Presupuestodonacion)listPresupuestoDonaVO.get(Integer.parseInt(request.getParameter("pos")))));
    		}
    		listPresupuestoDonaVO.remove(Integer.parseInt(request.getParameter("pos")));
    		request.getSession().removeAttribute("listPresupuestoDona");
    		request.getSession().setAttribute("listPresupuestoDona", listPresupuestoDonaVO);
    		setListEntidades(gestionFacadeContable.findAllEntidaddonantes());
    		estado="crearPresupuesto";
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String savePresupuesto(){
		String  result = Action.SUCCESS; 
    	try { 
    		if(presupuestoVO!=null){
    			listPresupuestoDonaVO = (ArrayList<Presupuestodonacion>)request.getSession().getAttribute("listPresupuestoDona");
    			if(presupuestoVO.getPresDescripcion()==null||presupuestoVO.getPresDescripcion().equals(""))
    				addActionMessage(getText("validacion.requerido","nombrePresupuesto","Nombre"));
    			if(presupuestoVO.getPresValor()<=0)
    				addActionMessage(getText("validacion.requerido","presupuesto","Presupusto"));
    			if(listPresupuestoDonaVO==null||listPresupuestoDonaVO.size()<=0)
    				addActionMessage(getText("validacion.asociarobj","presupuestodonaciones",""));
    			if(!hasActionMessages()){
    				if(getPresupuestoVO().getPresId()<=0){
	    				presupuestoVO = gestionFacadeContable.persistPresupuesto(getPresupuestoVO(),((Usuario)request.getSession().getAttribute("usuarioVO")).getLoginUsua());
	    				if(presupuestoVO!=null&&presupuestoVO.getPresId()>0){
	    					for(Presupuestodonacion elem:listPresupuestoDonaVO){
	    						elem.getId().setPresId(presupuestoVO.getPresId());
	    						gestionFacadeContable.persistPresupuestodonacion(elem);
	    						elem.getDonacion().setDonaEstado(ConstantesAplicativo.estadoPresupuesto);
	    						elem.getDonacion().setDonaFechamodificacion(ValidaString.fechaSystem());
	    						elem.getDonacion().setDonaHora(ValidaString.horaSystem());
	    						elem.getDonacion().setDonaRegistradopor(((Usuario)request.getSession().getAttribute("usuarioVO")).getLoginUsua());
	    						gestionFacadeContable.persistDonacion(elem.getDonacion());
	    					}
	    				}
    				}else{
    					getPresupuestoVO().setPresFechamodificacion(ValidaString.fechaSystem());
    	    			getPresupuestoVO().setPresHora(ValidaString.horaSystem());
    	    			getPresupuestoVO().setPresRegistradopor(((Usuario)request.getSession().getAttribute("usuarioVO")).getLoginUsua());
    	    			gestionFacadeContable.persistPresupuesto(getPresupuestoVO());
    				}
    				setListPresupuesto(gestionFacadeContable.findAllPresupuestos());
    	    		estado="listarPresupuesto";
    			}else{
    				setListEntidades(gestionFacadeContable.findAllEntidaddonantes());
    	    		estado="crearPresupuesto";
    			}
    		}else
    			System.out.println("esta intentando ingresar ilegalmente!!!!!");
    		
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String listPagares(){
		String  result = Action.SUCCESS; 
    	try { 
    		if(request.getSession().getAttribute("url")==null||((String)request.getSession().getAttribute("url")).equals("")){
    			String url = request.getParameter("url")==null?"":(String)request.getParameter("url");
    			request.getSession().setAttribute("url", url);
    		}else if(request.getParameter("url")!=null){
    			request.getSession().setAttribute("url", (String)request.getParameter("url"));
    		}
    		setListPagare(gestionFacadeContable.findAllPagares());
    		estado="listarPagares";
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String crearPagare(){
		String  result = Action.SUCCESS; 
    	try {
    		if((String)request.getParameter("id")!=null&&(Integer.parseInt((String)request.getParameter("id")))>0){
    			setPagareVO(gestionFacadeContable.findPagareById(Long.parseLong((String)request.getParameter("id"))));
    			estado="editarPagare";
    		}else{
    			setListTipoPagare(gestionFacadeContable.findAllTipopagares());
    			estado="crearPagare";
    		}
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String loadDeudoresPagare(){
		String  result = Action.SUCCESS; 
    	try {
    		String datoFindDeudor = (String)request.getParameter("datoFind");
    		String tipoFindDeudor = (String)request.getParameter("tipoFindDeudor");
    		if(datoFindDeudor!=null&&tipoFindDeudor!=null)
    			setListPersonas(gestionFacadeContable.findAllPersonas(datoFindDeudor, tipoFindDeudor));
    		estado="crearPagare";
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String loadDeudor(){
		String  result = Action.SUCCESS; 
    	try {
    		String idDeudor = (String)request.getParameter("idPersona");
    		System.out.println("----------------------------------------------");
    		System.out.println("idDeudor: ["+idDeudor+"]");
    		System.out.println("----------------------------------------------");
    		if(idDeudor!=null&&Integer.parseInt(idDeudor)>0){
    			if(getPagareVO()==null)
    				pagareVO = new Pagare();
    			getPagareVO().setPersona(gestionFacadeContable.findPersonaById(Integer.parseInt(idDeudor)));
    			listPersonas = null;
    		}
    		estado="crearPagare";
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String savePagare(){
		String  result = Action.SUCCESS; 
    	try { 
    		if(pagareVO!=null){
    			if(pagareVO.getPersona()==null||pagareVO.getPersona().getIdPers()<=0)
    				addActionMessage(getText("validacion.requerido","deudorPagare","Deudor Pagare"));
    			else{
    				getPagareVO().setPersona(gestionFacadeContable.findPersonaById(pagareVO.getPersona().getIdPers()));
    			}
    			if(pagareVO.getTipopagare()==null||pagareVO.getTipopagare().getTipaId()<=0)
    				addActionMessage(getText("validacion.requerido","tipopagare","Tipo Pagare"));
    			if(!ValidaString.validarFecha(pagareVO.getPagaFechapago()))
    				addActionMessage(getText("validacion.requerido","fechapagopagare","Fecha de Pago"));
    			if(!ValidaString.isNumericDouble(pagareVO.getPagaMonto())) // ==null||pagareVO.getPagaMonto().equals("")/*Long.parseLong(pagareVO.getPagaMonto())<=0*/)
    				addActionMessage(getText("validacion.requerido","montopagare","Monto"));
    			if(!hasActionMessages()){
    				if(pagareVO.getPagaEstado()==null||pagareVO.getPagaEstado().equals(""))
    						pagareVO.setPagaEstado(ConstantesAplicativo.estadoActivo);
    				pagareVO.setPagaFechamodificacion(ValidaString.fechaSystem());
    				pagareVO.setPagaHora(ValidaString.horaSystem());
    				pagareVO.setPagaRegistradopor(((Usuario)request.getSession().getAttribute("usuarioVO")).getLoginUsua());
    				gestionFacadeContable.persistPagare(pagareVO);
    				setListPagare(gestionFacadeContable.findAllPagares());
    	    		estado="listarPagares";
    			}else{
    				setListTipoPagare(gestionFacadeContable.findAllTipopagares());
    	    		estado="crearPagare";
    			}	
    		}else
    			System.out.println("esta intentando ingresar ilegalmente!!!!!");
    		
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String listTipoCredito(){
		String  result = Action.SUCCESS; 
    	try { 
    		if(request.getSession().getAttribute("url")==null||((String)request.getSession().getAttribute("url")).equals("")){
    			String url = request.getParameter("url")==null?"":(String)request.getParameter("url");
    			request.getSession().setAttribute("url", url);
    		}else if(request.getParameter("url")!=null){
    			request.getSession().setAttribute("url", (String)request.getParameter("url"));
    		}
    		setListTipoCredito(gestionFacadeContable.findAllTipocreditos());
    		for(Tipocredito elem:getListTipoCredito())
    			elem.setTipocreditoseguroadquiridos(gestionFacadeContable.findAllTipocreditoseguroadquiridos(elem.getTicrId()));
    		estado="listarTiposCreditos";
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String listCreditoSocios(){
		String  result = Action.SUCCESS; 
    	try { 
    		if(request.getSession().getAttribute("url")==null||((String)request.getSession().getAttribute("url")).equals("")){
    			String url = request.getParameter("url")==null?"":(String)request.getParameter("url");
    			request.getSession().setAttribute("url", url);
    		}else if(request.getParameter("url")!=null){
    			request.getSession().setAttribute("url", (String)request.getParameter("url"));
    		}
    		setListCredito(gestionFacadeContable.findAllCreditos());
    		estado="listarCreditosSocios";
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String crearCreditoSocio(){
		String  result = Action.SUCCESS; 
    	try {
    		if((String)request.getParameter("id")!=null&&(Integer.parseInt((String)request.getParameter("id")))>0){
    			setCreditoVO(gestionFacadeContable.findCreditoById(Long.parseLong((String)request.getParameter("id"))));
    			getCreditoVO().setFechaALiquidar(ValidaString.fechaSystem());
    			setAbonoVO(gestionFacadeContable.liquidacionPagoCredito(getCreditoVO()));
    			estado="pagosCreditos";
    		}else{
    			setListPresupuesto(gestionFacadeContable.findAllPresupuestos());
    			setListTipoCredito(gestionFacadeContable.findAllTipocreditos());
    			estado="crearCreditoSocio";
    		}
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]"); 
    	return result;
	}
	
	@SkipValidation
    public String calcularPago(){
		String  result = Action.SUCCESS; 
    	try {
    		if(getCreditoVO()!=null&&getCreditoVO().getCredId()>0){
    			System.out.println("***************************************************************");
    			System.out.println("***************************************************************");
    			System.out.println("tipo Recalculo: ["+getCreditoVO().getTipoRecalcularPago()+"]");
    			System.out.println("***************************************************************");
    			System.out.println("***************************************************************");
    			
    			String fechaLiquidar = null;
    			boolean band = true;
    			if(creditoVO.getTipoRecalcularPago()==null||creditoVO.getTipoRecalcularPago().equals("")||creditoVO.getTipoRecalcularPago().equals("0")){
    				fechaLiquidar = getCreditoVO().getFechaALiquidar();
    				//Validar que la fecha a liquidar no sea superior a la fecha actual.
    				
    				setCreditoVO(gestionFacadeContable.findCreditoById(getCreditoVO().getCredId()));
    			}else if(creditoVO.getTipoRecalcularPago().equals("1")){
    				setCreditoVO(gestionFacadeContable.findCreditoById(getCreditoVO().getCredId()));
    				fechaLiquidar = gestionFacadeContable.obtenerFechaCorte(getCreditoVO(), getAbonoVO().getValoraPagar());
    				String fechaActual = ValidaString.fechaSystem();
    				Calendar fecha1 = new GregorianCalendar(Integer.parseInt(fechaLiquidar.substring(0, 4)), 
    						Integer.parseInt(fechaLiquidar.substring(5, 7))-1,
    						Integer.parseInt(fechaLiquidar.substring(8, 10)));
    				Calendar fecha2 = new GregorianCalendar(Integer.parseInt(fechaActual.substring(0, 4)),  
    						Integer.parseInt(fechaActual.substring(5, 7))-1,
    						Integer.parseInt(fechaActual.substring(8, 10)));
    				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    				System.out.println("*****************************************");
    				System.out.println("Fecha1: ["+sdf.format(new java.sql.Date(fecha1.getTimeInMillis()))+"]");
    				System.out.println("Fecha2: ["+sdf.format(new java.sql.Date(fecha2.getTimeInMillis()))+"]");
    				System.out.println("*****************************************");
    				if(!ValidaString.esFechaMenor(fecha1, fecha2)){
    					fechaLiquidar = ValidaString.fechaSystem();
    					band = false;
    				}
    			}
    			
    			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
    			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
    			System.out.println("fechaLiquidar: ["+fechaLiquidar+"]");
    			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
    			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
    			
    			
    			if(!ValidaString.validarFecha(fechaLiquidar)){
    				addActionMessage(getText("validacion.requeridofecha","fechaaliquidar","Fecha de Corte"));
    				getCreditoVO().setFechaALiquidar(ValidaString.fechaSystem());
    			}else
    				getCreditoVO().setFechaALiquidar(fechaLiquidar);
    			double valoraPagar = getAbonoVO().getValoraPagar();
    			setAbonoVO(gestionFacadeContable.liquidacionPagoCredito(getCreditoVO()));
    			if(!band){
    				getAbonoVO().setAbonValorcapitaladicional(valoraPagar-getAbonoVO().getAbonValortotal());
    				getAbonoVO().setAbonValortotal(valoraPagar);
    				getAbonoVO().setValoraPagar(valoraPagar);
    			}else
    				getAbonoVO().setValoraPagar(getAbonoVO().getAbonValortotal());
    				
    			estado="pagosCreditos";
    		}else{
    			setListPresupuesto(gestionFacadeContable.findAllPresupuestos());
    			setListTipoCredito(gestionFacadeContable.findAllTipocreditos());
    			estado="crearCreditoSocio";
    		}
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}

	@SkipValidation
    public String loadTitularCredito(){
		String  result = Action.SUCCESS; 
    	try {
    		//Consultar pagare por numero de pagare o por deudor del pagare......
    		String datoFind = (String)request.getParameter("datoFind");
    		String tipoFind = (String)request.getParameter("tipoFind");
    		if(datoFind!=null&&tipoFind!=null)
    			setListPagare(gestionFacadeContable.findAllTitularesCredito(datoFind, tipoFind));
    		estado="crearCreditoSocio";
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String loadTitular(){
		String  result = Action.SUCCESS; 
    	try {
    		String idTitular = (String)request.getParameter("idPagare");
    		if(idTitular!=null&&Integer.parseInt(idTitular)>0){
    			if(getCreditoVO()==null)
    				creditoVO = new Credito();
    			getCreditoVO().setPagare(gestionFacadeContable.findPagareById(Long.parseLong(idTitular)));
    			getCreditoVO().setCredMontocredito(Double.valueOf(getCreditoVO().getPagare().getPagaMonto()));
    			listPagare = null;
    		}
    		estado="crearCreditoSocio";
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String loadDateTipoCredito(){
		String  result = Action.SUCCESS; 
    	try {
    		String idTipoCredito = (String)request.getParameter("id");
    		if(idTipoCredito!=null&&Long.parseLong(idTipoCredito)>0)
    			setTipoCreditoVO(gestionFacadeContable.findTipocreditoById(Long.parseLong(idTipoCredito)));
    		estado="crearCreditoSocio";
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String loadPresupuesto(){
		String  result = Action.SUCCESS; 
    	try {
    		String idPresupuesto = (String)request.getParameter("id");
    		if(idPresupuesto!=null&&Long.parseLong(idPresupuesto)>0)
    			setPresupuestoVO(gestionFacadeContable.findPresupuestoById(Long.parseLong(idPresupuesto)));
    		estado="crearCreditoSocio";
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
    public String saveCreditoSocio(){
		String  result = Action.SUCCESS; 
    	try { 
    		if(creditoVO!=null){
    			if(creditoVO.getPagare()==null||creditoVO.getPagare().getPagaId()<=0)
    				addActionMessage(getText("validacion.requerido","titularcredito","Titular Credito"));
    			else{
    				getCreditoVO().setPagare(gestionFacadeContable.findPagareById(getCreditoVO().getPagare().getPagaId()));
        			getCreditoVO().setCredMontocredito(Double.valueOf(getCreditoVO().getPagare().getPagaMonto()));
    			}
    			if(creditoVO.getTipocredito()==null||creditoVO.getTipocredito().getTicrId()<=0)
    				addActionMessage(getText("validacion.requerido","tipocredito","Tipo Credito"));
    			else{
    				setTipoCreditoVO(gestionFacadeContable.findTipocreditoById(getTipoCreditoVO().getTicrId()));
    			}
    			if(creditoVO.getPresupuesto()==null||creditoVO.getPresupuesto().getPresId()<=0)
    				addActionMessage(getText("validacion.requerido","presupuesto","Presupuesto"));
    			else{
    				setPresupuestoVO(gestionFacadeContable.findPresupuestoById(getPresupuestoVO().getPresId()));
    			}
    			if(!ValidaString.validarFecha( creditoVO.getCredFechainiciacredito()))
    				addActionMessage(getText("validacion.requerido","fechainicredito","Fecha Inicio Credito"));
    			if(creditoVO.getCredMontocredito()<=0) 
    				addActionMessage(getText("validacion.requerido","montocredito","Monto del Credito"));
    			if(creditoVO.getCredNrocheque()==null||creditoVO.getCredNrocheque().equals(""))
    				addActionMessage(getText("validacion.requerido","nrochequedes","Nro Cheque Desembolso"));
    			if(presupuestoVO!=null){
    				if(presupuestoVO.getPresValor()<creditoVO.getCredMontocredito())
    					addActionMessage(getText("validacion.montocredito","validacionmontos",""));
    			}else
    				addActionMessage(getText("validacion.montocredito","validacionmontos",""));
    			if(!hasActionMessages()){
    				creditoVO.setCredSaldo(creditoVO.getCredMontocredito());
    				creditoVO.setCredEstado(ConstantesAplicativo.estadoCreditoVigente);
    				creditoVO.setCredFechaultimopago(creditoVO.getCredFechainiciacredito());
    				creditoVO.setCredFechamodificacion(ValidaString.fechaSystem());
    				creditoVO.setCredHora(ValidaString.horaSystem());
    				creditoVO.setCredRegistradopor(((Usuario)request.getSession().getAttribute("usuarioVO")).getLoginUsua());
    				gestionFacadeContable.persistCredito(creditoVO);
    				if(presupuestoVO!=null&&presupuestoVO.getPresId()>0){
    					presupuestoVO.setPresValor(presupuestoVO.getPresValor()-creditoVO.getCredMontocredito());
    					presupuestoVO.setPresFechamodificacion(ValidaString.fechaSystem());
    					presupuestoVO.setPresHora(ValidaString.horaSystem());
    					presupuestoVO.setPresRegistradopor(((Usuario)request.getSession().getAttribute("usuarioVO")).getLoginUsua());
    					gestionFacadeContable.persistPresupuesto(presupuestoVO);
    				}	
    				setListCredito(gestionFacadeContable.findAllCreditos());
    	    		estado="listarCreditosSocios";
    			}else{
    				setListPresupuesto(gestionFacadeContable.findAllPresupuestos());
        			setListTipoCredito(gestionFacadeContable.findAllTipocreditos());
    	    		estado="crearCreditoSocio";
    			}	
    		}else
    			System.out.println("esta intentando ingresar ilegalmente!!!!!");
    		
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}

	public HttpServletRequest getRequest() {return request;}
	public void setRequest(HttpServletRequest request) {this.request = request;}
	public HttpServletResponse getResponse() {return response;}
	public void setResponse(HttpServletResponse response) {this.response = response;}
	public void setServletResponse(HttpServletResponse response) {this.response = response;}
	public void setServletRequest(HttpServletRequest request) {this.request = request;}
	public String getEstado() {return estado;}
	public void setEstado(String estado) {this.estado = estado;}
	public IGestionFacadeContable getGestionFacadeContable() {return gestionFacadeContable;}
	public void setGestionFacadeContable(IGestionFacadeContable gestionFacadeContable) {this.gestionFacadeContable = gestionFacadeContable;}
	
}
