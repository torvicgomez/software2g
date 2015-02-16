package com.software2g.agenda.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.software2g.agenda.facade.IGestionFacadeAgenda;
import com.software2g.util.ConstantesAplicativo;
import com.software2g.util.ValidaString;
import com.software2g.vo.Agenda;
import com.software2g.vo.Evento;
import com.software2g.vo.Jorandalaboral;
import com.software2g.vo.Parametroscalendario;
import com.software2g.vo.Participante;
import com.software2g.vo.Persona;
import com.software2g.vo.Procedimiento;
import com.software2g.vo.Profesional;
import com.software2g.vo.Tipodocumento;
import com.software2g.vo.Tipoprocedimiento;
import com.software2g.vo.Usuario;

public class AgendaAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private IGestionFacadeAgenda gestionFacadeAgenda;
	private String estado;
	private String funcPosicionado;
	private String bandEstadoFunc;
	private String id;
	private String constantesAgendaProfesional;
	private String eventoAgendaProfesional;
	private String background;
	
	private String odontograma;

	private List<Parametroscalendario> listParametroCalendrio;
	private Parametroscalendario parametroCalendario;
	private List<Jorandalaboral> listJornadaLaboral;
	private Jorandalaboral jornadaLaboral;
	private Profesional profesional;
	private List<Profesional> listProfesional;
	private List<Persona> listPersona;
	private InputStream strProfesional;
	private Persona persona;
	private InputStream strDatosPersona;
	private List<Agenda> listAgendaMedica;
	private Agenda agendaMedica;
	private InputStream strCrearEvento;
	private Evento evento;
	private Participante participante;
	private Tipoprocedimiento tipoProcedimiento;
	private List<Tipoprocedimiento> listTipoProcedimiento;
	private Procedimiento procedimiento;
	private List<Procedimiento> listProcedimiento;
	private List<Tipodocumento> listTipoDoc;
	
	public List<Parametroscalendario> getListParametroCalendrio() {return listParametroCalendrio;}
	public void setListParametroCalendrio(List<Parametroscalendario> listParametroCalendrio) {this.listParametroCalendrio = listParametroCalendrio;}
	public Parametroscalendario getParametroCalendario() {return parametroCalendario;}
	public void setParametroCalendario(Parametroscalendario parametroCalendario) {this.parametroCalendario = parametroCalendario;}
	public List<Jorandalaboral> getListJornadaLaboral() {return listJornadaLaboral;}
	public void setListJornadaLaboral(List<Jorandalaboral> listJornadaLaboral) {this.listJornadaLaboral = listJornadaLaboral;}
	public Jorandalaboral getJornadaLaboral() {return jornadaLaboral;}
	public void setJornadaLaboral(Jorandalaboral jornadaLaboral) {this.jornadaLaboral = jornadaLaboral;}
	public Profesional getProfesional() {return profesional;}
	public void setProfesional(Profesional profesional) {this.profesional = profesional;}
	public List<Profesional> getListProfesional() {return listProfesional;}
	public void setListProfesional(List<Profesional> listProfesional) {this.listProfesional = listProfesional;}
	public Persona getPersona() {return persona;}
	public void setPersona(Persona persona) {this.persona = persona;}
	public List<Persona> getListPersona() {return listPersona;}
	public void setListPersona(List<Persona> listPersona) {this.listPersona = listPersona;}
	public List<Agenda> getListAgendaMedica() {return listAgendaMedica;}
	public void setListAgendaMedica(List<Agenda> listAgendaMedica) {this.listAgendaMedica = listAgendaMedica;}
	public Agenda getAgendaMedica() {return agendaMedica;}
	public void setAgendaMedica(Agenda agendaMedica) {this.agendaMedica = agendaMedica;}
	public String getConstantesAgendaProfesional() {return constantesAgendaProfesional;}
	public void setConstantesAgendaProfesional(String constantesAgendaProfesional) {this.constantesAgendaProfesional = constantesAgendaProfesional;}
	public String getEventoAgendaProfesional() {return eventoAgendaProfesional;}
	public void setEventoAgendaProfesional(String eventoAgendaProfesional) {this.eventoAgendaProfesional = eventoAgendaProfesional;}
	public Evento getEvento() {return evento;}
	public void setEvento(Evento evento) {this.evento = evento;}
	public Participante getParticipante() {return participante;}
	public void setParticipante(Participante participante) {this.participante = participante;}
	public Tipoprocedimiento getTipoProcedimiento() {return tipoProcedimiento;}
	public void setTipoProcedimiento(Tipoprocedimiento tipoProcedimiento) {this.tipoProcedimiento = tipoProcedimiento;}
	public List<Tipoprocedimiento> getListTipoProcedimiento() {return listTipoProcedimiento;}
	public void setListTipoProcedimiento(List<Tipoprocedimiento> listTipoProcedimiento) {this.listTipoProcedimiento = listTipoProcedimiento;}
	public Procedimiento getProcedimiento() {return procedimiento;}
	public void setProcedimiento(Procedimiento procedimiento) {this.procedimiento = procedimiento;}
	public List<Procedimiento> getListProcedimiento() {return listProcedimiento;}
	public void setListProcedimiento(List<Procedimiento> listProcedimiento) {this.listProcedimiento = listProcedimiento;}
	public List<Tipodocumento> getListTipoDoc() {return listTipoDoc;}
	public void setListTipoDoc(List<Tipodocumento> listTipoDoc) {this.listTipoDoc = listTipoDoc;}
	
	@SkipValidation
	public String calendarioMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>AgendaAction>>>>calendarioMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listProfesional = gestionFacadeAgenda.findAllProfesionalAgenda();
    			constantesAgendaProfesional = ConstantesAplicativo.constanteNameFileJSAllAgendaProf;
    			eventoAgendaProfesional = ConstantesAplicativo.constanteNameFileJSAllEventoAgendaProf;
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)){
    			listProfesional = gestionFacadeAgenda.findAllProfesionalAgenda();
    			if(background==null||(background!=null&&background.equals(""))){
    				constantesAgendaProfesional = ConstantesAplicativo.constanteNameFileJSAllAgendaProf;
        			eventoAgendaProfesional = ConstantesAplicativo.constanteNameFileJSAllEventoAgendaProf;
    			}else{
	    			profesional = gestionFacadeAgenda.findProfesionalBackground(getBackground());
	    			agendaMedica = gestionFacadeAgenda.findIdAgenda(getBackground());
	    			constantesAgendaProfesional = "constantesCalendario/agenda/constanteAgendaProf_"+profesional.getProfId();
	    			eventoAgendaProfesional = "eventosAgenda/eventosagenda_"+agendaMedica.getAgenId();
    			}
    			estado = ConstantesAplicativo.constanteEstadoAll;
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoOperacionCita)){
    			if(evento!=null&&evento.getAccion()!=null&&evento.getAccion().equals(ConstantesAplicativo.constanteNoAplica))
    				addActionError(getText("validacion.requerido","evenAccion","Accion a Realizar"));
    			if(profesional!=null&&profesional.getProfId()>0&&evento!=null&&evento.getEvenId()>0){
    				profesional = gestionFacadeAgenda.findProfesionalById(profesional.getProfId());
    				evento = gestionFacadeAgenda.findEventoById(evento.getEvenId());
    			}else{
    				long idProfesional = Long.parseLong(request.getParameter("idProfesional").toString());
	    			long idEvento = Long.parseLong(request.getParameter("idEvento").toString());
	    			profesional = gestionFacadeAgenda.findProfesionalById(idProfesional);
	    			evento = gestionFacadeAgenda.findEventoById(idEvento);
    			}
    			evento.setParticipantes(gestionFacadeAgenda.findAllParticipantes(evento.getEvenId()));
    			if(evento.getParticipantes()!=null&&evento.getParticipantes().size()>0)
    				participante = (Participante) evento.getParticipantes().get(0);
    			estado = ConstantesAplicativo.constanteEstadoOperacionCita;
    			evento.getEvenStartViewFecha();
    			evento.getEvenStartViewHora();
    		}
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
    	System.out.println("######>>>>>>>AgendaAction>>>>calendarioMethod>>>>estado salida-->>"+estado);
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
	
	private void getBandEstadoFuncion(){
		if(request.getSession().getAttribute("bandEstadoFunc")==null){
			request.getSession().setAttribute("bandEstadoFunc",bandEstadoFunc);
		}else{
			String funcCambio = (String) request.getSession().getAttribute("bandEstadoFunc");
			if(bandEstadoFunc!=null&&!bandEstadoFunc.equals(funcCambio))
				request.getSession().setAttribute("bandEstadoFunc",bandEstadoFunc);
		}
		System.out.println("######>>>>>>>bandEstadoFunc>>>>"+bandEstadoFunc);
	}
	
	@SkipValidation
	public String paramCalendarioMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>AgendaAction>>>>paramCalendarioMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listParametroCalendrio = gestionFacadeAgenda.findAllParametroscalendarios();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(ValidaString.isNullOrEmptyString(parametroCalendario.getPacaVariable()))
    				addActionError(getText("validacion.requerido","pacaVariable","Variable"));
    			if(ValidaString.isNullOrEmptyString(parametroCalendario.getPacaValor()))
    				addActionError(getText("validacion.requerido","pacaValor","Valor"));
    			if(!hasActionErrors()){
    				parametroCalendario.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(parametroCalendario);
    				gestionFacadeAgenda.persistParametroscalendario(parametroCalendario);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			parametroCalendario = gestionFacadeAgenda.findParametroscalendarioById(getIdLong());
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>AgendaAction>>>>paramCalendarioMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String jornadaLaboralMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>AgendaAction>>>>jornadaLaboralMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listJornadaLaboral = gestionFacadeAgenda.findAllJorandalaborals();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoAdd)){
    			String idPersona = request.getParameter("idPersona");
    			System.out.println("idPersona:["+idPersona+"]");
    			if(idPersona!=null&&!idPersona.equals("")){
    				persona = gestionFacadeAgenda.findPersonaById(Long.parseLong(idPersona));
    				if(persona!=null){
    					System.out.println("persona : ["+persona.getNombreCompleto()+"]");
    					persona.setProfesional(gestionFacadeAgenda.findAllProfesionalXIdPersona(persona.getIdPers()));
    					if(persona.getProfesional()!=null&&persona.getProfesional().size()>0){
    						for(Profesional elem:persona.getProfesional()){
    							System.out.println("ProfId:["+elem.getProfId()+"]");
    						}
    					}else
    						System.out.println("Persona no tiene profesiones asociadas");
    				}else
    					System.out.println("Persona Null!!!!!!!!");
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(ValidaString.isNullOrEmptyString(parametroCalendario.getPacaVariable()))
    				addActionError(getText("validacion.requerido","pacaVariable","Variable"));
    			if(ValidaString.isNullOrEmptyString(parametroCalendario.getPacaValor()))
    				addActionError(getText("validacion.requerido","pacaValor","Valor"));
    			if(!hasActionErrors()){
    				parametroCalendario.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(parametroCalendario);
    				gestionFacadeAgenda.persistParametroscalendario(parametroCalendario);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			parametroCalendario = gestionFacadeAgenda.findParametroscalendarioById(getIdLong());
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>AgendaAction>>>>jornadaLaboralMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String profesionalSaludMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>AgendaAction>>>>profesionalSaludMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listProfesional = gestionFacadeAgenda.findAllProfesionals();
    			bandEstadoFunc = ConstantesAplicativo.constanteEstadoAddSave;
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(profesional.getPersona().getIdPers()<=0)
    				addActionError(getText("validacion.requerido","prfsIdPers","Seleccione al Profesional de la Salud"));
    			else
    				profesional.setPersona(gestionFacadeAgenda.findPersonaById(profesional.getPersona().getIdPers()));
    			if(ValidaString.isNullOrEmptyString(profesional.getProfEspecialidad()))
    				addActionError(getText("validacion.requerido","prfsProfesion","Profesión"));
    			if(ValidaString.isNullOrEmptyString(profesional.getProfNrotarjetaprof()))
    				addActionError(getText("validacion.requerido","prfsNroTarjetaProf","Nro Tarjeta Profesional"));
    			if(ValidaString.isNullOrEmptyString(profesional.getProfEstado()))
    				addActionError(getText("validacion.requerido","prfsEstado","Estado"));
    			if(ValidaString.isNullOrEmptyString(profesional.getProfBackgroundcoloragen()))
    				addActionError(getText("validacion.requerido","prfsBackgroundcoloragen","Color Representación Agenda"));
    			else if(!gestionFacadeAgenda.validoBackgroundProf(profesional.getProfBackgroundcoloragen()))
    				addActionError(getText("validacion.requerido","prfsBackgroundcoloragen","Color Representación Agenda ya esta asociado a otro profesional"));
    			if(!hasActionErrors()){
    				profesional.setPersona(gestionFacadeAgenda.findPersonaById(profesional.getPersona().getIdPers()));
    				profesional.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(profesional);
    				gestionFacadeAgenda.persistProfesional(profesional);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    				String nameFile = "eventos";
    				String path = request.getServletContext().getRealPath("/")+"js\\constantesCalendario\\"; 
    				boolean resultFile = gestionFacadeAgenda.crearFile(path, nameFile,   
    							ConstantesAplicativo.constanteExtensionFileJS, 
    							ConstantesAplicativo.constanteTipoFileJSConstantesEventos,
    							ConstantesAplicativo.constanteCrearFileJSEventosAll);
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			profesional = gestionFacadeAgenda.findProfesionalById(getIdLong());
    			bandEstadoFunc = ConstantesAplicativo.constanteEstadoEditSave;
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>AgendaAction>>>>profesionalSaludMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String agendaMedicaMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>AgendaAction>>>>agendaMedicaMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listAgendaMedica  = gestionFacadeAgenda.findAllAgendas();
    			bandEstadoFunc = ConstantesAplicativo.constanteEstadoAddSave;
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			SimpleDateFormat sdf = new SimpleDateFormat(ConstantesAplicativo.constanteFormatoFecha4);
    			if(agendaMedica.getProfesional().getPersona().getIdPers()<=0)
    				addActionError(getText("validacion.requerido","prfsIdPers","Seleccione al Profesional de la Salud"));
    			else
    				agendaMedica.setProfesional(gestionFacadeAgenda.findProfesionalIdPersona(agendaMedica.getProfesional().getPersona().getIdPers()));
    			
    			if(ValidaString.isNullOrEmptyString(agendaMedica.getAgenFechaini()))
    				addActionError(getText("validacion.requerido","agenfechaini","Fecha Apertura Agenda"));
    			
    			if(ValidaString.isNullOrEmptyString(agendaMedica.getAgenFechafin()))
    				addActionError(getText("validacion.requerido","agenfechafin","Fecha Cierre Agenda"));
    			else if(!ValidaString.esFechaMayor(sdf.parse(agendaMedica.getAgenFechafin()), sdf.parse(agendaMedica.getAgenFechaini()), ConstantesAplicativo.constanteFormatoFecha4))
    				addActionError(getText("validacion.requerido","agenfechafin","Fecha Cierre Agenda debe ser mayor a Fecha Apertura Agenda"));
    			
    			if(ValidaString.isNullOrEmptyString(agendaMedica.getAgenMintime()))
    				addActionError(getText("validacion.requerido","agenmintime","Hora Apertura Cita"));
    			
    			if(ValidaString.isNullOrEmptyString(agendaMedica.getAgenMaxtime()))
    				addActionError(getText("validacion.requerido","agenmaxtime","Hora Cierre Cita"));
    			else if(!ValidaString.esHoraMayor(agendaMedica.getAgenMaxtime(), agendaMedica.getAgenMintime()))
    				addActionError(getText("validacion.requerido","agenmaxtime","Hora Cierre Cita debe ser mayor a Hora Apertura Cita"));
    			
    			if(ValidaString.isNullOrEmptyString(agendaMedica.getAgenDuracionevento()))
    				addActionError(getText("validacion.requerido","agendiracionevento","Duración Cita"));
    			if(ValidaString.isNullOrEmptyString(agendaMedica.getAgenScrolltime()))
    				addActionError(getText("validacion.requerido","agenscrolltime","Scroll Time"));
    			if(ValidaString.isNullOrEmptyString(agendaMedica.getAgenAlldayslot()))
    				addActionError(getText("validacion.requerido","agenalldayslot","Evento Todo el Dia"));
    			else if(agendaMedica.getAgenAlldayslot().equals("1") && ValidaString.isNullOrEmptyString(agendaMedica.getAgenAlldaytext()))
    				addActionError(getText("validacion.requerido","agenalldaytext","Etiqueta Evento Todo el Dia"));
    			
    			if(!hasActionErrors()){
    				agendaMedica.setProfesional(gestionFacadeAgenda.findProfesionalIdPersona(agendaMedica.getProfesional().getPersona().getIdPers()));
    				String nameFile = "constanteAgendaProf_"+agendaMedica.getProfesional().getProfId();
    				agendaMedica.setAgenPathconstantes(nameFile);
    				agendaMedica.setAddSegundos();
    				agendaMedica.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(agendaMedica);
    				long idAgenda = gestionFacadeAgenda.persistAgendaId(agendaMedica);
    				if(idAgenda>0){
	    				String path = request.getServletContext().getRealPath("/")+"js\\constantesCalendario\\agenda\\"; 
	    				boolean resultFile = gestionFacadeAgenda.crearFile(path, nameFile,   
	    						ConstantesAplicativo.constanteExtensionFileJS, 
	    						ConstantesAplicativo.constanteTipoFileJSConstantesAgenda,
	    						idAgenda+"");
    				}
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			agendaMedica= gestionFacadeAgenda.findAgendaById(getIdLong());
    			bandEstadoFunc = ConstantesAplicativo.constanteEstadoEditSave;
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>AgendaAction>>>>agendaMedicaMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String odontogramaMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>AgendaAction>>>>odontogramaMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			System.out.println("Construccion!!!!!!!!!!");
    			listProcedimiento = gestionFacadeAgenda.findAllProcedimientos();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			System.out.println("Construccion!!!!!!!!!!");
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			System.out.println("Construccion!!!!!!!!!!");
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>AgendaAction>>>>odontogramaMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String servicioClinicoMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>AgendaAction>>>>servicioClinicoMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listProcedimiento = gestionFacadeAgenda.findAllProcedimientos();
    			long idProfesional = request.getParameter("idProfesional")!=null?Long.parseLong(request.getParameter("idProfesional").toString()):0;
    			profesional = idProfesional>0?gestionFacadeAgenda.findProfesionalById(idProfesional):new Profesional();
    			listTipoDoc = gestionFacadeAgenda.findAllTipodocumentos();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			System.out.println("Construccion!!!!!!!!!!");
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			System.out.println("Construccion!!!!!!!!!!");
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>AgendaAction>>>>servicioClinicoMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String tipoProcedimientoMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>AgendaAction>>>>tipoProcedimientoMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listTipoProcedimiento = gestionFacadeAgenda.findAllTipoprocedimientos();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(ValidaString.isNullOrEmptyString(tipoProcedimiento.getTiprNombre()))
    				addActionError(getText("validacion.requerido","tiprNombre","Especialidad Agrupar Procedimientos"));
    			if(!hasActionErrors()){
    				tipoProcedimiento.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(tipoProcedimiento);
    				gestionFacadeAgenda.persistTipoprocedimiento(tipoProcedimiento);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			tipoProcedimiento = gestionFacadeAgenda.findTipoprocedimientoById(getIdLong());
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>AgendaAction>>>>tipoProcedimientoMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String procedimientoMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>AgendaAction>>>>procedimientoMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listProcedimiento = gestionFacadeAgenda.findAllProcedimientos();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoAdd)){
    			listTipoProcedimiento = gestionFacadeAgenda.findAllTipoprocedimientos();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(procedimiento.getTipoprocedimiento().getTiprId()<=0)
    				addActionError(getText("validacion.requerido","tiprId","Tipo Procedimiento"));
    			if(ValidaString.isNullOrEmptyString(procedimiento.getPrtoCodigo()))
    				addActionError(getText("validacion.requerido","prtoCodigo","Código Procedimiento"));
    			if(ValidaString.isNullOrEmptyString(procedimiento.getPrtoNombre()))
    				addActionError(getText("validacion.requerido","prtoNombre","Nombre Procedimiento"));
    			if(!hasActionErrors()){
    				procedimiento.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(procedimiento);
    				gestionFacadeAgenda.persistProcedimiento(procedimiento);
    				procedimiento.setTipoprocedimiento(gestionFacadeAgenda.findTipoprocedimientoById(procedimiento.getTipoprocedimiento().getTiprId()));
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}else
    				listTipoProcedimiento = gestionFacadeAgenda.findAllTipoprocedimientos();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			procedimiento = gestionFacadeAgenda.findProcedimientoById(getIdLong());
    			listTipoProcedimiento = gestionFacadeAgenda.findAllTipoprocedimientos();
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>AgendaAction>>>>procedimientoMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	
	public AgendaAction(IGestionFacadeAgenda gestionFacadeAgenda) {this.gestionFacadeAgenda = gestionFacadeAgenda;}
	public HttpServletRequest getRequest() {return request;}
	public void setRequest(HttpServletRequest request) {this.request = request;}
	public HttpServletResponse getResponse() {return response;}
	public void setResponse(HttpServletResponse response) {this.response = response;}
	public void setServletResponse(HttpServletResponse response) {this.response = response;}
	public void setServletRequest(HttpServletRequest request) {this.request = request;}
	public String getEstado() {return estado;}
	public void setEstado(String estado) {this.estado = estado;}
	public IGestionFacadeAgenda getGestionFacadeAgenda() {return gestionFacadeAgenda;}
	public void setGestionFacadeAgenda(IGestionFacadeAgenda gestionFacadeAgenda) {this.gestionFacadeAgenda = gestionFacadeAgenda;}
	public String getFuncPosicionado() {return funcPosicionado;}
	public void setFuncPosicionado(String funcPosicionado) {this.funcPosicionado = funcPosicionado;}
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public long getIdLong() {return Long.parseLong(id);}
	public Integer getIdInteger() {return Integer.parseInt(id);}
	public List<String> getDatosAud(){
		return Arrays.asList(((Usuario)request.getSession().getAttribute("usuarioVO")).getLoginUsua(),
				ValidaString.fechaSystem(),
				ValidaString.horaSystem());
	}
	public String getBandEstadoFunc() {return bandEstadoFunc;}
	public void setBandEstadoFunc(String bandEstadoFunc) {this.bandEstadoFunc = bandEstadoFunc;}
	public String getBackground() {return background;}
	public void setBackground(String background) {this.background = background;}
	
	public String getOdontograma() {return odontograma;}
	public void setOdontograma(String odontograma) {this.odontograma = odontograma;}
	
	public InputStream getStrProfesional() {
		try{
			String find = request.getParameter("find");
			String option = "";
			if(find!=null&&!find.equals("")){
				listPersona = gestionFacadeAgenda.findAllPersonasProfesionales(find);
				if(listPersona!=null){
					for(Persona elem:listPersona){
						option += "<div><a class=\"suggest-element\" data=\""+elem.getNombreCompleto()+" - "+elem.getEmailPers()+" - "+elem.getTelefonoPers()+"\" id=\""+elem.getIdPers()+"\">"+elem.getNombreCompleto()+" - "+elem.getEmailPers()+" - "+elem.getTelefonoPers()+"</a></div>";
					}
				}
			}
			this.strProfesional = new ByteArrayInputStream(option.getBytes());
		}catch(Exception e){
			e.printStackTrace();
		}
		return strProfesional;
	}
	
	public InputStream getStrDatosPersona() {
		try{
			String html = "";
			long idPersona = Long.parseLong(request.getParameter("idPersona"));
			Persona persona = gestionFacadeAgenda.findPersonaById(idPersona);
			html = "<s:textfield name=\"dataAutoCompletado\" id=\"search\" size=\"60\" maxlength=\"30\" cssClass=\"inputs\"></s:textfield><br>";
			html += "<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"display\">"+
					"	<tr> " +
					"		<td class=\"leftLabel\">Nombre</td> " +
					"		<td>" + persona.getNombreCompleto() + "</td> " +
					"	</tr> " +
					"	<tr> " +
					"		<td class=\"leftLabel\">Documento Identificación</td> " +
					"		<td>" + persona.getDocumentoPers() + " " + persona.getTipodocumento().getAbreviaturaTidoc() + "</td> " +
					"	</tr> " +
					"	<tr> " +
					"		<td class=\"leftLabel\">Fecha Nacimiento y Edad</td> " +
					"		<td>" + persona.getFechanacimientoPers() + "  /  " + persona.getEdad() + "</td> " +
					"	</tr> " +
					"	<tr> " +
					"		<td class=\"leftLabel\">Sexo</td> " +
					"		<td>" + persona.getSexoPers() + "</td> " +
					"	</tr> " +
					"	<tr> " +
					"		<td class=\"leftLabel\">Estado Civil</td> " +
					"		<td>" + persona.getEstadocivilPers() + "</td> " +
					"	</tr> " +
					"	<tr> " +
					"		<td class=\"leftLabel\">Correo Electrónico</td> " +
					"		<td>" + persona.getEmailPers() + "</td> " +
					"	</tr> " +
					"	<tr> " +
					"		<td class=\"leftLabel\">Teléfonos</td> " +
					"		<td>" + persona.getTelefonoPers() + "</td> " +
					"	</tr> " +
					"	<tr> " +
					"		<td class=\"leftLabel\">Ubicación</td> " +
					"		<td>" + persona.getUbicacionPersona() + " " + persona.getDireccionPers() + "</td> " +
					"	</tr> " +
					"</table>";
			strDatosPersona = new ByteArrayInputStream(html.getBytes(Charset.forName("UTF-8")));
		}catch(Exception e){
			e.printStackTrace();
		}
		return strDatosPersona;
	}
	
	public InputStream getStrCrearEvento() {
		try{
			String html = "";
			String backgroundColor = String.valueOf(request.getParameter("backgroundColor"));
			Evento evento = new Evento();
			evento.setAgenda(gestionFacadeAgenda.findIdAgenda(backgroundColor));
			String title = String.valueOf(request.getParameter("title"));
			String start = String.valueOf(request.getParameter("start"));
			String end = String.valueOf(request.getParameter("end"));
			String url = "calendario.action?estado="+ConstantesAplicativo.constanteEstadoOperacionCita+"&funcPosicionado=Calendario/Informacion Cita&idProfesional="+evento.getAgenda().getProfesional().getProfId()+"&idEvento=";
			evento.setEvenTitle(title);
			evento.setEvenStart(start);
			evento.setEvenEnd(end);
			evento.setEvenUrl(url);
			evento.setEvenBackgroundcolor(backgroundColor);
			evento.setEvenEstado(ConstantesAplicativo.constanteEstadoEventoCreado);
			evento.setDatosAud(getDatosAud());
			ValidaString.imprimirObject(evento);
			long idEvento = gestionFacadeAgenda.persistEventoId(evento);
			if(idEvento>0){
				evento.setEvenId(idEvento);
				Participante participante = new Participante();
				participante.setEvento(evento);
				participante.setPartDocumento(String.valueOf(request.getParameter("nrodocumento")));
				participante.setPartTipodocumento(String.valueOf(request.getParameter("tipodoc")));
				participante.setPartPnombre(String.valueOf(request.getParameter("pnombre")));
				participante.setPartSnombre(String.valueOf(request.getParameter("snombre")));
				participante.setPartPapellido(String.valueOf(request.getParameter("papellido")));
				participante.setPartSapellido(String.valueOf(request.getParameter("sapellido")));
				participante.setPartTelefono(String.valueOf(request.getParameter("telefono")));
				participante.setPartEmail(String.valueOf(request.getParameter("email")));
				participante.setDatosAud(getDatosAud());
				ValidaString.imprimirObject(participante);
				gestionFacadeAgenda.persistParticipante(participante);
			}	
			String nameFile = "eventos";
			String path = request.getServletContext().getRealPath("/")+"js\\constantesCalendario\\"; 
			gestionFacadeAgenda.crearFile(path, nameFile,   
						ConstantesAplicativo.constanteExtensionFileJS, 
						ConstantesAplicativo.constanteTipoFileJSConstantesEventos,
						ConstantesAplicativo.constanteCrearFileJSEventosAll);
			path = request.getServletContext().getRealPath("/")+"js\\constantesCalendario\\eventosAgenda\\";	
			nameFile = "eventosagenda_"+evento.getAgenda().getAgenId();
			gestionFacadeAgenda.crearFile(path, nameFile,   
					ConstantesAplicativo.constanteExtensionFileJS, 
					ConstantesAplicativo.constanteTipoFileJSConstantesEventosxAgenda,
					evento.getAgenda().getAgenId()+"");
			html = "<input type=\"hidden\" id=\"idEventoCreado\" value=\""+idEvento+"\"/>";
			strCrearEvento = new ByteArrayInputStream(html.getBytes(Charset.forName("UTF-8")));
		}catch(Exception e){
			e.printStackTrace();
		}
		return strCrearEvento;
	}
}
