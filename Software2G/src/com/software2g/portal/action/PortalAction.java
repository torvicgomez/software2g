package com.software2g.portal.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionMessage;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.software2g.portal.facade.IGestionFacadePortal;
import com.software2g.util.ConstantesAplicativo;
import com.software2g.util.ValidaString;
import com.software2g.vo.Aplicacion;
import com.software2g.vo.Departamento;
import com.software2g.vo.Funcionalidad;
import com.software2g.vo.Funcionalidadrol;
import com.software2g.vo.Institucion;
import com.software2g.vo.Municipio;
import com.software2g.vo.Pais;
import com.software2g.vo.Persona;
import com.software2g.vo.Rol;
import com.software2g.vo.Rolusuario;
import com.software2g.vo.Tipodocumento;
import com.software2g.vo.Usuario;
import com.software2g.vo.UtilGenerico;

public class PortalAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private IGestionFacadePortal gestionFacadePortal;
	private String estado;
	private String url;
	private String funcPosicionado;
	private String id;
	
	private List<Tipodocumento> listTipoDoc;
	private List<UtilGenerico> listSexo;
	private List<UtilGenerico> listEstadoCivil;
	private List<Persona> listPersona;
	private List<Institucion> listInstitucion;
 	private Persona personaVO;
	private Usuario usuarioVO;
	private List<Pais> listPais;
	private List<Departamento> listDepartamento;
	private List<Municipio> listMunicipio;
	private List<Rol> listRol;
	private Rol rol;
	private Funcionalidad funcionalidad; 
	private List<Funcionalidad> listFuncionalidad;
	private List<Aplicacion> listAplicacion;
	private InputStream strFunctionRol; 
	private List<Object> listFuncRol;
	
	public PortalAction(IGestionFacadePortal gestionFacadePortal) {
        this.gestionFacadePortal = gestionFacadePortal;
    }
	
	@SkipValidation
    public String execute() {
		String  result = Action.SUCCESS; 
    	try {   
    		String url = request.getParameter("url")==null?"":(String)request.getParameter("url");
    		request.getSession().setAttribute("url", url);
    		/*estado = (String) request.getParameter("estado");
    		System.out.println("estado: ["+estado+"]");
    		if(estado!=null&&!estado.equals("")){
    			if(estado.equals("crearPersona")){
    				result = formCrearPersona();
    			}else
    				result = Action.SUCCESS;
    		}*/
		} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
    }
	
	private void getFuncionPosicionado(){	
		if(request.getSession().getAttribute("funcPosicionado")==null){
			request.getSession().setAttribute("funcPosicionado",funcPosicionado);
		}else{
			String funcCambio = (String) request.getSession().getAttribute("funcPosicionado");
			if(!funcPosicionado.equals(funcCambio))
				request.getSession().setAttribute("funcPosicionado",funcPosicionado);
		}
		System.out.println("######>>>>>>>funcPosicionado>>>>"+funcPosicionado);
	}
	
	@SkipValidation
	public String formCrearPersonal(){
		String  result = Action.SUCCESS; 
    	try { 
    		listTipoDoc=gestionFacadePortal.findAllTipodocumentos();
    		listSexo = cargarListSexo();
    		listEstadoCivil = cargarListEstadoCivil();
    		listPais = gestionFacadePortal.findAllPaiss();
    		listDepartamento = gestionFacadePortal.findAllDepartamentos();
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			System.out.println("Entra esta parte");
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}

	@SkipValidation
	public String loadMunicipios(){
		String  result = Action.SUCCESS; 
    	try {
    		if(getPersonaVO().getMunicipio().getDepartamento().getDptoId()>0)
    			listMunicipio = gestionFacadePortal.findAllMunicipios(getPersonaVO().getMunicipio().getDepartamento().getDptoId()); 
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			System.out.println("Entra esta parte");
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	
	@SkipValidation
	public List<UtilGenerico> cargarListSexo(){
		ArrayList<UtilGenerico>list = new ArrayList<UtilGenerico>();
		for(int i=0;i<2;i++){
			UtilGenerico dato = new UtilGenerico();
			if(i==0){
				dato.setKey("M");
				dato.setValor("Masculino");
			}else if(i==1){
				dato.setKey("F");
				dato.setValor("Femenino");
			}
			list.add(dato);
		}
		return (List<UtilGenerico>)list;
	}
	
	@SkipValidation
	public List<UtilGenerico> cargarListEstadoCivil(){
		ArrayList<UtilGenerico>list = new ArrayList<UtilGenerico>();
		for(int i=0;i<5;i++){
			UtilGenerico dato = new UtilGenerico();
			switch (i) {
			case 0:
				dato.setKey("CASADO(A)");
				dato.setValor("Casado(A)");
				break;
			case 1:
				dato.setKey("DIVORCIADO(A)");
				dato.setValor("Divorciado(A)");
				break;
			case 2:
				dato.setKey("SOLTERO(A)");
				dato.setValor("Soltero(A)");
				break;
			case 3:
				dato.setKey("UNIÓN LIBRE");
				dato.setValor("Unión Libre");
				break;
			case 4:
				dato.setKey("VIUDO(A)");
				dato.setValor("Viudo(A)");
				break;	
			}
			list.add(dato);
		}
		return (List<UtilGenerico>)list;
	}
	
	
	@SkipValidation
	public String cargarPortalUser(){
		String  result = Action.SUCCESS; 
    	try {   
    		//Aqui se deberia de cargar las funcionalidades de cada uno de los roles que posee
    		//el usuario logiado
    		usuarioVO = gestionFacadePortal.cargarPortalUser(getUsuarioVO(), getText("user.activo"));
    		if(usuarioVO!=null){
    			System.out.println("Cargar Usuario en Session");
    			System.out.println("----------------------------------------------------------");
    			System.out.println("----------------------DATOS USUARIO-----------------------");
    			System.out.println("Nombre:["+usuarioVO.getPersona().getNombreCompleto()+"]");
    			System.out.println("Usuario:["+usuarioVO.getLoginUsua()+"]");
    			System.out.println("----------------------------------------------------------");
    			System.out.println("Roles:::>>>");
    			if(usuarioVO.getRolusuarios()!=null){
	    			int cont=1,cont1=1;
	    			for(Rolusuario elem:usuarioVO.getRolusuarios()){ 
	    				System.out.println(cont+".Rol:["+elem.getRol().getNombreRol()+"]");
	    				for(Funcionalidadrol elem1:elem.getRol().getFuncionalidadrols()){
	    					System.out.println("	"+cont+"."+cont1+".Funcionalidad:["+elem1.getFuncionalidad().getEtiquetaFunc()+"]::Aplicacion:["+elem1.getFuncionalidad().getAplicacion().getNombreApli()+"]");
	    					cont1++;
	    				}
	    				cont++;
	    			}
    			}
    			System.out.println("FIN Roles:::>>>");
    			System.out.println("----------------------------------------------------------");
    			System.out.println("----------------------------------------------------------");
    			request.getSession().setAttribute("usuarioVO", usuarioVO);
    		}else{
    			System.out.println("Error de Validacion");
    			addActionMessage(getText("validacion.usuario"));
    			result=Action.ERROR;
    		}
    		/*String login = getUsuarioVO()!=null?getUsuarioVO().getLoginUsuaIng():"";
    		String password = getUsuarioVO()!=null?getUsuarioVO().getPasswordUsuaIng():"";
    		System.out.println("En Costruccion Autenticacion Usuario!!!");
    		System.out.println("getUsuarioVO(): ["+getUsuarioVO()+"]");
    		if(getUsuarioVO()!=null){
    			System.out.println("getUsuarioVO().getLoginUsua():["+getUsuarioVO().getLoginUsua()+"]");
    			System.out.println("getUsuarioVO().getLoginUsua():["+getUsuarioVO().getPasswordUsua()+"]");
    		}*/
		} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
    	usuarioVO=null;
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
	public String salirAplicacion(){
		String  result = Action.SUCCESS; 
    	try { 
    		request.getSession().removeAttribute("usuarioVO");
    		request.getSession().removeAttribute("url");
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
	public String listarPersonal(){
		String  result = Action.SUCCESS; 
    	try { 
    		if(request.getSession().getAttribute("url")==null||((String)request.getSession().getAttribute("url")).equals("")){
    			String url = request.getParameter("url")==null?"":(String)request.getParameter("url");
    			request.getSession().setAttribute("url", url);
    		}else if(request.getParameter("url")!=null){
    			request.getSession().setAttribute("url", (String)request.getParameter("url"));
    		}
    		setListPersona(gestionFacadePortal.findAllPersonas());
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
	public String savePersona(){
		String  result = Action.SUCCESS; 
    	try { 
    		//Validacion de campos
    		if(personaVO!=null){
    			if(personaVO.getDocumentoPers()==null||personaVO.getDocumentoPers().equals(""))
    				addActionMessage(getText("validacion.requerido","nroDocPer","Número Documento"));
    			if(personaVO.getTipodocumento().getIdTidoc()==null||personaVO.getTipodocumento().getIdTidoc()==-1)
    				addActionMessage(getText("validacion.requerido","tipoDocPer","Número Documento (tipo de documento)"));
    			if(!ValidaString.validarFecha(personaVO.getFechaexpdocPers()))
    				addActionMessage(getText("validacion.requeridofecha","fechaExpPer","Fecha Expedición"));
    			if(personaVO.getPnombrePers()==null||personaVO.getPnombrePers().equals(""))
    				addActionMessage(getText("validacion.requerido","primerNomPer","Primer Nombre"));
    			if(personaVO.getPapellidoPers()==null||personaVO.getPapellidoPers().equals(""))
    				addActionMessage(getText("validacion.requerido","primerApelPer","Primer Apellido"));
    			if(personaVO.getSexoPers()==null||personaVO.getSexoPers().equals("-1"))
    				addActionMessage(getText("validacion.requerido","sexoPer","Sexo"));
    			if(!ValidaString.validarFecha(personaVO.getFechanacimientoPers()))
    				addActionMessage(getText("validacion.requeridofecha","fechaNaciPer","Fecha Nacimiento"));
    			if(personaVO.getEstadocivilPers()==null||personaVO.getEstadocivilPers().equals("-1"))
    				addActionMessage(getText("validacion.requerido","esatdoCivPer","Estado Civil"));
    			if(personaVO.getTelefonoPers()==null||personaVO.getTelefonoPers().equals(""))
    				addActionMessage(getText("validacion.requerido","telefonoPer","Teléfono"));
    			if(personaVO.getEmailPers()==null||personaVO.getEmailPers().equals(""))
    				addActionMessage(getText("validacion.requerido","emailPer","Correo Electrónico"));
    			if(personaVO.getEmailPers()!=null&&!ValidaString.isEmail(personaVO.getEmailPers()))
    				addActionMessage(getText("validacion.formato","emailPerformato","Correo Electrónico"));
    			if(personaVO.getMunicipio().getMcpoId()<=0||personaVO.getMunicipio().getDepartamento().getPais().getPaisId()<=0)
    				addActionMessage(getText("validacion.requerido","ubicaciongeoPer","Ubicación Geográfica"));
    			if(personaVO.getDireccionPers()==null||personaVO.getDireccionPers().equals(""))
    				addActionMessage(getText("validacion.requerido","direccionPer","Dirección"));
    			
    			ValidaString.imprimirObject(personaVO);
    			
    			if(!hasActionMessages()){
    				
    				System.out.println("personaVO.getTipodocumento().getIdTidoc():["+personaVO.getTipodocumento().getIdTidoc()+"]");
    				System.out.println("personaVO.getEstadocivilPers():["+personaVO.getEstadocivilPers()+"]");
    				System.out.println("personaVO.getSexoPers():["+personaVO.getSexoPers()+"]");
    				
    				personaVO.setRegistradopor(((Usuario)request.getSession().getAttribute("usuarioVO")).getLoginUsua());
    				gestionFacadePortal.persistPersona(personaVO);
    				setListPersona(gestionFacadePortal.findAllPersonas());
    			}else{
    				result = Action.INPUT;
    				listTipoDoc=gestionFacadePortal.findAllTipodocumentos();
    	    		listSexo = cargarListSexo();
    	    		listEstadoCivil = cargarListEstadoCivil();
    	    		listPais = gestionFacadePortal.findAllPaiss();
    	    		listDepartamento = gestionFacadePortal.findAllDepartamentos();
    	    		if(personaVO.getMunicipio().getDepartamento().getPais().getPaisId()<=0){
    	    			getPersonaVO().getMunicipio().getDepartamento().setDptoId(-1);
    	    			getPersonaVO().getMunicipio().setMcpoId(-1);
    	    		}if(getPersonaVO().getMunicipio().getDepartamento().getDptoId()>0)
    	    			listMunicipio = gestionFacadePortal.findAllMunicipios(getPersonaVO().getMunicipio().getDepartamento().getDptoId());
    	    		
    			}
    		}else
    			System.out.println("intenta ingresar ilegalmente!!!!");
    		
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
	public String editarPersonal(){
		String  result = Action.SUCCESS; 
    	try { 
    		String idPersona = (String)request.getParameter("id");
    		setPersonaVO(gestionFacadePortal.findPersonaById(Long.parseLong(idPersona)));
    		listTipoDoc=gestionFacadePortal.findAllTipodocumentos();
    		listSexo = cargarListSexo();
    		listEstadoCivil = cargarListEstadoCivil();
    		
    		listPais = gestionFacadePortal.findAllPaiss();
    		listDepartamento = gestionFacadePortal.findAllDepartamentos();
    		if(getPersonaVO().getMunicipio()!=null&&getPersonaVO().getMunicipio().getDepartamento().getDptoId()>0)
    			listMunicipio = gestionFacadePortal.findAllMunicipios(getPersonaVO().getMunicipio().getDepartamento().getDptoId());
    		
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
	public String listarInstitucion(){
		String  result = Action.SUCCESS; 
    	try { 
    		if(request.getSession().getAttribute("url")==null||((String)request.getSession().getAttribute("url")).equals("")){
    			String url = request.getParameter("url")==null?"":(String)request.getParameter("url");
    			request.getSession().setAttribute("url", url);
    		}else if(request.getParameter("url")!=null){
    			request.getSession().setAttribute("url", (String)request.getParameter("url"));
    		}
    		setListInstitucion(gestionFacadePortal.findAllInstitucions());
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}

	@SkipValidation
	public String editarPassword(){
		String  result = Action.SUCCESS; 
    	try { 
    		if(request.getSession().getAttribute("url")==null||((String)request.getSession().getAttribute("url")).equals("")){
    			String url = request.getParameter("url")==null?"":(String)request.getParameter("url");
    			request.getSession().setAttribute("url", url);
    		}else if(request.getParameter("url")!=null){
    			request.getSession().setAttribute("url", (String)request.getParameter("url"));
    		}
    		estado=null;
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
	public String saveCambioPass(){
		String  result = Action.SUCCESS; 
    	try { 
    		System.out.println("En Construcción!!!!!");
    		if(usuarioVO!=null){
    			if(usuarioVO.getPasswordUsua()==null||usuarioVO.getPasswordUsua().equals(""))
    				addActionMessage(getText("validacion.requerido","passActualUsu","Contraseña Actual"));
    			if(usuarioVO.getNewPassword()==null||usuarioVO.getNewPassword().equals(""))
    				addActionMessage(getText("validacion.requerido","newPassUsu","Nueva Contraseña"));
    			if(usuarioVO.getConfirmNewPassword()==null||usuarioVO.getConfirmNewPassword().equals(""))
    				addActionMessage(getText("validacion.requerido","confirmPassUsu","Confirmar Contraseña"));
    			if(!((Usuario)request.getSession().getAttribute("usuarioVO")).getPasswordUsua().equals(usuarioVO.getPasswordUsua()))
    				addActionMessage(getText("validacion.text","nocoincidePassActual","La contraseña actual no coincide con la digitada"));
    			if(usuarioVO.getNewPassword()!=null&&usuarioVO.getConfirmNewPassword()!=null
    					&&!usuarioVO.getNewPassword().equals(usuarioVO.getConfirmNewPassword()))
    				addActionMessage(getText("validacion.text","nocoincideNewConfPass","El campo \"Nueva Contraseña\" no coincide con el campo \"Confirmar Contraseña\""));
    			ValidaString.imprimirObject(usuarioVO);
    			if(!hasActionMessages()){
    				Usuario usuario = (Usuario)request.getSession().getAttribute("usuarioVO");
    				usuario.setFechacambio(ValidaString.fechaSystem());
    				usuario.setHoracambio(ValidaString.horaSystem());
    				usuario.setRegistradopor(usuario.getLoginUsua());
    				usuario.setPasswordUsua(usuarioVO.getNewPassword());
    				gestionFacadePortal.persistUsuario(usuario);
    				request.getSession().removeAttribute("usuarioVO");
    				request.getSession().setAttribute("usuarioVO", usuario);
    				usuarioVO=null;
    				estado="okCambioPass";
    			}
    		}else
    			System.out.println("esta ingresando ilegalmente!!!!!");
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result: ["+result+"]");
    	return result;
	}
	
	@SkipValidation
	public String rolMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>PortalAction>>>>rolMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listRol = gestionFacadePortal.findAllRols();
    			request.getSession().removeAttribute("listFuncRol");
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(ValidaString.isNullOrEmptyString(rol.getNombreRol()))
    				addActionError(getText("validacion.requerido","nombre","Nombre"));
    			if(ValidaString.isNullOrEmptyString(rol.getEtiquetaRol()))
    				addActionError(getText("validacion.requerido","etiqueta","Etiqueta"));
    			if(ValidaString.isNullOrEmptyString(rol.getDescripcionRol()))
    				addActionError(getText("validacion.requerido","descripcion","Descripción"));
    			if(!hasActionErrors()){
    				rol.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(rol);
    				gestionFacadePortal.persistRol(rol);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit) 
    				|| estado.equals(ConstantesAplicativo.constanteEstadoAbstract)
    				|| estado.equals(ConstantesAplicativo.constanteEstadoAssociate)){
    			System.out.println("Entra esta parte!!!!!");
    			System.out.println("Id Rol: ["+getIdInteger()+"]");
    			rol = gestionFacadePortal.findRolById(getIdInteger());
    			if(estado.equals(ConstantesAplicativo.constanteEstadoAssociate)){
    				String nameFile = "rol_"+getIdInteger();
    				String path = request.getServletContext().getRealPath("/")+"file\\configuracionRol\\"; 
    				List<Funcionalidad> listFuncRol = gestionFacadePortal.crearFile(path, nameFile,   
    						ConstantesAplicativo.constanteExtensionFileJS, 
    						ConstantesAplicativo.constanteTipoFileJSFuncRol);
    				request.getSession().setAttribute("nameFileFuncRol", nameFile);
    				request.getSession().setAttribute("listFuncRol", listFuncRol);
    			}
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion1"));
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>PortalAction>>>>rolMethod >>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	
	
	@SkipValidation
	public String funcionalidadMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>PortalAction>>>>funcionalidadMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listFuncionalidad = gestionFacadePortal.findAllFuncionalidads();
    		}if(estado.equals(ConstantesAplicativo.constanteEstadoAdd)){
    			listFuncionalidad = gestionFacadePortal.findAllFuncionalidads();
    			listAplicacion = gestionFacadePortal.findAllAplicacions();
//    			if(funcionalidad==null)
//    				funcionalidad = new Funcionalidad();
//    			funcionalidad.setUrlFunc(ConstantesAplicativo.urlFuncionalidades);
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(ValidaString.isNullOrEmptyString(funcionalidad.getNombreFunc()))
    				addActionError(getText("validacion.requerido","nombre","Nombre"));
    			if(ValidaString.isNullOrEmptyString(funcionalidad.getEtiquetaFunc()))
    				addActionError(getText("validacion.requerido","etiqueta","Etiqueta"));
    			if(ValidaString.isNullOrEmptyString(funcionalidad.getUrlFunc()))
    				addActionError(getText("validacion.requerido","urlFuncion","Acción Funcionalidad"));
    			if(ValidaString.isNullOrEmptyString(funcionalidad.getDescripcionFunc()))
    				addActionError(getText("validacion.requerido","descripcion","Descripción"));
    			if(!hasActionErrors()){
    				System.out.println("Id Aplicacion: ["+funcionalidad.getAplicacion().getIdApli()+"]");
    				System.out.println("Id Funcionalidad Padre: ["+funcionalidad.getFuncionalidad().getIdFunc()+"]");
    				if(funcionalidad.getFuncionalidad().getIdFunc()<=0)
    					funcionalidad.setFuncionalidad(null);
    				funcionalidad.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(funcionalidad);
    				gestionFacadePortal.persistFuncionalidad(funcionalidad);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    				funcionalidad.setAplicacion(gestionFacadePortal.findAplicacionById(funcionalidad.getAplicacion().getIdApli()));
    				System.out.println("funcionalidad padre:["+funcionalidad.getFuncionalidad()+"]");
    				if(funcionalidad.getFuncionalidad()!=null&&funcionalidad.getFuncionalidad().getIdFunc()>0)
    					funcionalidad.setFuncionalidad(gestionFacadePortal.findFuncionalidadById(funcionalidad.getFuncionalidad().getIdFunc()));
    			}else{
    				listFuncionalidad = gestionFacadePortal.findAllFuncionalidads();
    				listFuncionalidad = gestionFacadePortal.findAllFuncionalidads();
    				listAplicacion = gestionFacadePortal.findAllAplicacions();
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit) 
    				|| estado.equals(ConstantesAplicativo.constanteEstadoAbstract)
    				|| estado.equals(ConstantesAplicativo.constanteEstadoAssociate)){
    			funcionalidad = gestionFacadePortal.findFuncionalidadById(getIdInteger());
    			listFuncionalidad = gestionFacadePortal.findAllFuncionalidads(); 
    			listAplicacion = gestionFacadePortal.findAllAplicacions();
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion1"));
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>PortalAction>>>>funcionalidadMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	
	public HttpServletRequest getRequest() {return request;}
	public void setRequest(HttpServletRequest request) {this.request = request;}
	public HttpServletResponse getResponse() {return response;}
	public void setResponse(HttpServletResponse response) {this.response = response;}
	public IGestionFacadePortal getGestionFacadePortal() {return gestionFacadePortal;}
	public void setGestionFacadePortal(IGestionFacadePortal gestionFacadePortal) {this.gestionFacadePortal = gestionFacadePortal;}
	public void setServletResponse(HttpServletResponse response) {this.response = response;}
	public void setServletRequest(HttpServletRequest request) {this.request = request;}
	public String getEstado() {return estado;}
	public void setEstado(String estado) {this.estado = estado;}
	public String getUrl() {return url;}
	public void setUrl(String url) {this.url = url;}
	public void setFuncPosicionado(String funcPosicionado) {this.funcPosicionado = funcPosicionado;}
	public String getFuncPosicionado() {return funcPosicionado;}
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public long getIdLong() {return Long.parseLong(id);}
	public Integer getIdInteger() {return Integer.parseInt(id);}
	public List<String> getDatosAud(){
//		System.out.println("usuario:["+((Usuario)request.getSession().getAttribute("usuarioVO")).getLoginUsua()+"]");
		return Arrays.asList(((Usuario)request.getSession().getAttribute("usuarioVO")).getLoginUsua(),
				ValidaString.fechaSystem(),
				ValidaString.horaSystem());
	}
	//************************************************************************
	// Metodos Get & Set Manejo de Persona
	//************************************************************************
	public List<Tipodocumento> getListTipoDoc() {return listTipoDoc;}
	public void setListTipoDoc(List<Tipodocumento> listTipoDoc) {this.listTipoDoc = listTipoDoc;}
	public List<UtilGenerico> getListSexo() {return listSexo;}
	public void setListSexo(List<UtilGenerico> listSexo) {this.listSexo = listSexo;}
	public List<UtilGenerico> getListEstadoCivil() {return listEstadoCivil;}
	public void setListEstadoCivil(List<UtilGenerico> listEstadoCivil) {this.listEstadoCivil = listEstadoCivil;}
	public Persona getPersonaVO() {return personaVO;}
	public void setPersonaVO(Persona personaVO) {this.personaVO = personaVO;}
	public Usuario getUsuarioVO() {return usuarioVO;}
	public void setUsuarioVO(Usuario usuarioVO) {this.usuarioVO = usuarioVO;}
	public List<Persona> getListPersona() {return listPersona;}
	public void setListPersona(List<Persona> listPersona) {this.listPersona = listPersona;}
	public List<Institucion> getListInstitucion() {return listInstitucion;}
	public void setListInstitucion(List<Institucion> listInstitucion) {this.listInstitucion = listInstitucion;}
	public List<Pais> getListPais() {return listPais;}
	public void setListPais(List<Pais> listPais) {this.listPais = listPais;}
	public List<Departamento> getListDepartamento() {return listDepartamento;}
	public void setListDepartamento(List<Departamento> listDepartamento) {this.listDepartamento = listDepartamento;}
	public List<Municipio> getListMunicipio() {return listMunicipio;}
	public void setListMunicipio(List<Municipio> listMunicipio) {this.listMunicipio = listMunicipio;}
	public List<Rol> getListRol() {return listRol;}
	public void setListRol(List<Rol> listRol) {this.listRol = listRol;}
	public Rol getRol() {return rol;}
	public void setRol(Rol rol) {this.rol = rol;}
	public Funcionalidad getFuncionalidad() {return funcionalidad;}
	public void setFuncionalidad(Funcionalidad funcionalidad) {this.funcionalidad = funcionalidad;}
	public List<Funcionalidad> getListFuncionalidad() {return listFuncionalidad;}
	public void setListFuncionalidad(List<Funcionalidad> listFuncionalidad) {this.listFuncionalidad = listFuncionalidad;}
	public List<Aplicacion> getListAplicacion() {return listAplicacion;}
	public void setListAplicacion(List<Aplicacion> listAplicacion) {this.listAplicacion = listAplicacion;}
	public List<Object> getListFuncRol() {return listFuncRol;}
	public void setListFuncRol(List<Object> listFuncRol) {this.listFuncRol = listFuncRol;}

	public InputStream getStrFunctionRol() {
		String id = request.getParameter("id");
		String pId = request.getParameter("pId");
		String checked = request.getParameter("checked");
		System.out.println("*********************************************************************");
		System.out.println("*********************************************************************");
		System.out.println("*********************************************************************");
		List<Funcionalidad> list = (List<Funcionalidad>)request.getSession().getAttribute("listFuncRol");
		System.out.println("listFuncionalidades: ["+list+"]");
		System.out.println("id: ["+id+"]");
		System.out.println("pId: ["+pId+"]");
		System.out.println("checked: ["+checked+"]");
		try {
			list = gestionFacadePortal.marcarFuncRol(list, Integer.parseInt(id), !pId.equals("null")?Integer.parseInt(pId):null, checked);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("*********************************************************************");
		System.out.println("*********************************************************************");
		System.out.println("*********************************************************************");
		
		
		List<Object[]> listFuncRol = (List<Object[]>)request.getSession().getAttribute("listFuncRol1");
		System.out.println("listFuncRol: ["+listFuncRol+"]");
		if(listFuncRol==null)
			listFuncRol = new ArrayList<Object[]>();
		if(listFuncRol!=null&&listFuncRol.size()>0){
			boolean band=false;
			System.out.println("listFuncRol.size(): ["+listFuncRol.size()+"]");
			for(Object[] elem:listFuncRol){
				System.out.println("elem[0]: ["+elem[0]+"]==["+id+"] : id");
				if(elem[0].toString().equals(id)){
					elem[2] = checked;
					band = true;
					break;
				}
			}
			System.out.println("band: ["+band+"]");
			if(!band){
				Object[] data = {id, pId, checked};
				listFuncRol.add(data);
			}
		}else{
			Object[] data = {id, pId, checked};
			listFuncRol.add(data);
		}
		request.getSession().setAttribute("listFuncRol1",listFuncRol);
		String result = "";
		System.out.println("listFuncRol.size(): ["+listFuncRol.size()+"]");
		for(Object[] elem:listFuncRol){
			result += elem[0]+";"+elem[1]+";"+elem[2]+"<br>";
		}
		//result = id+";"+pId+";"+checked+"<br>";
		System.out.println("**********************************************+");
		System.out.println("**********************************************+");
		System.out.println("result: ["+result+"]");
		System.out.println("**********************************************+");
		System.out.println("**********************************************+");
		strFunctionRol = new ByteArrayInputStream(result.getBytes());
		return strFunctionRol;
	}

}
