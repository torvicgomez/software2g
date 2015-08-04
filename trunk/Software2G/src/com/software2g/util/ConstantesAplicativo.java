package com.software2g.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.software2g.vo.UtilGenerico;

public final class ConstantesAplicativo {
	public static final double MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día
	public static final double DIAS_MES = 30;
	public static final String estadoDonacion="DONACION";
	public static final String estadoPresupuesto="PRESUPUESTO";
	public static final String estadoActivo="1";
	public static final String estadoInactivo="0";
	public static final String estadoAnulado="2";
	public static final String estadoCreditoVigente="VIGENTE";
	public static final String estadoCreditoCancelado="CANCELADO";
	public static final String estadoCreditoAnulado="ANULADO";
	public static final String textomsgCredito="CREDITO";
	
	public static final String urlFuncionalidades=".action?estado=all&funcPosicionado=";
	
	public static final String constanteEstadoAllTipoServicio = "alltiposervicio";
	public static final String constanteEstadoAll = "all";
	public static final String constanteEstadoAdd = "add";
	public static final String constanteEstadoAddSave = "addsave";
	public static final String constanteEstadoQuery = "query";
	public static final String constanteEstadoEdit = "edit";
	public static final String constanteEstadoEditSave = "editsave";
	public static final String constanteEstadoAbstract = "abstract";
	public static final String constanteEstadoSave = "save";
	public static final String constanteEstadoLink = "link";
	public static final String constanteEstadoAddGrid = "addGrid";
	public static final String constanteEstadoDeleteGrid = "delGrid";
	public static final String constanteEstadoSubEdit = "subedit";
	public static final String constanteEstadoSearch = "search";
	public static final String constanteEstadoAssociate = "associate";
	public static final String constanteEstadoOperacionCita = "operacioncita";
	public static final String constanteEstadoAccionRealizar = "accionrealizar";
	public static final String constanteTipoGridMedicamentos = "GridMedicamentos";
	public static final String constanteTipoGridElementos = "GridElementos";
	
	public static final String constanteTipoFileJSFuncRol = "functionrol";
	public static final String constanteTipoFileJSTreeMenu = "treemenu";
	public static final String constanteExtensionFileJS = ".js";
	public static final String constanteTipoFileJSConstantesAgenda = "constantesagenda";
	public static final String constanteTipoFileJSConstantesEventos = "constanteseventos";
	public static final String constanteTipoFileJSConstantesEventosxAgenda = "constanteseventosxagenda";
	public static final String constanteNameFileJSAllAgendaProf = "constantes";
	public static final String constanteNameFileJSAllEventoAgendaProf = "eventos";
	
	public static final String constanteEstadoActivo = "ACTIVO";
	public static final String constanteEstadoInactivo = "INACTIVO";
	
	public static final String constanteSplit = "&&&&";
	public static final String constanteFormatoFechaHora1 = "dd/MM/yyyy HH:mm:ss.SSS";
	public static final String constanteFormatoFechaHora2 = "HH:mm";
	public static final String constanteFormatoFechaHora3 = "h:mm a";
	public static final String constanteFormatoFecha1 = "dd/MM/yyyy";
    public static final String constanteFormatoFecha2 = "dd-MM-yyyy";
    public static final String constanteFormatoFecha3 = "EEE, dd MMM yyyy";
    public static final String constanteFormatoFecha4 = "yyyy-MM-dd";
    public static final String constanteFormatoFecha5 = "yyyyMMdd";
	
	public static final String constanteTipoSearchAutoComplProf = "profesional";
	public static final String constanteTipoSearchAutoComplDiag = "diagnostico";
	
	public static final String constanteCrearFileJSEventosAll = "allEventos";
	public static final String constanteCrearFileJSEventosxAgenda = "allEventosxAgenda";
	public static final String constanteEstadoEventoCreado = "CREADO";
	
	public static final List<String> constanteEstadoCivil = new ArrayList<String>(Arrays.asList("CASADO(A)","DIVORCIADO(A)", "SOLTERO(A)", "UNIÓN LIBRE"));
	public static final String constanteCheckSi = "S"; 
    public static final String constanteCheckNo = "N";
    public static final String constanteChecked = "checked";
	
	// Acciones a realizar con la cita
	public static final String constanteNoAplica = "NA";
	public static final String constanteAtenderServicio = "AS";
	public static final String constanteCancelarCita = "CC";
	
	public static final List<UtilGenerico> listAVC = new ArrayList<UtilGenerico>(
						Arrays.asList(new UtilGenerico("0.5 M", "0.5 M"), 
										new UtilGenerico("0.75 M", "0.75 M"),
										new UtilGenerico("1 M", "1 M"),
										new UtilGenerico("1.25 M", "1.25 M"),
										new UtilGenerico("1.75 M", "1.75 M"),
										new UtilGenerico("2 M", "2 M"),
										new UtilGenerico("CD 2 M", "CD 2 M"),
										new UtilGenerico("CD 1 M", "CD 1 M"),
										new UtilGenerico("CD 5 M", "CD 5 M"),
										new UtilGenerico("PL", "PL"),
										new UtilGenerico("NPL", "NPL"),
										new UtilGenerico("Ninguno", "Ninguno")));
	
	public static final List<UtilGenerico> listCoverTest = new ArrayList<UtilGenerico>(
			Arrays.asList(new UtilGenerico("Ortoforia", "Ortoforia"), 
							new UtilGenerico("Exoforia", "Exoforia"),
							new UtilGenerico("Endoforia", "Endoforia"),
							new UtilGenerico("Hipoforia", "Hipoforia"),
							new UtilGenerico("Hiperforia", "Hiperforia"),
							new UtilGenerico("Ortotropia", "Ortotropia"),
							new UtilGenerico("Exotropia", "Exotropia"),
							new UtilGenerico("Endotropia", "Endotropia"),
							new UtilGenerico("Hipotropia", "Hipotropia"),
							new UtilGenerico("Hipertropia", "Hipertropia")));
	
	public static final List<UtilGenerico> listOrden = new ArrayList<UtilGenerico>(
			Arrays.asList(new UtilGenerico("1", "1"),new UtilGenerico("2", "2"),
							new UtilGenerico("3", "3"),new UtilGenerico("3", "3"),
							new UtilGenerico("4", "4"),new UtilGenerico("5", "5"),
							new UtilGenerico("6", "6"),new UtilGenerico("7", "7"),
							new UtilGenerico("8", "8"),new UtilGenerico("9", "9")));
	
	public static final List<UtilGenerico> listEstado = new ArrayList<UtilGenerico>(
			Arrays.asList(new UtilGenerico("ACTIVO", "Activo"),new UtilGenerico("INACTIVO", "Inactivo")));
	
	public static final List<UtilGenerico> listEstadoSN = new ArrayList<UtilGenerico>(
			Arrays.asList(new UtilGenerico("S", "Activo"),new UtilGenerico("N", "Inactivo")));
	
	public static final List<UtilGenerico> listEstadoArticulo = new ArrayList<UtilGenerico>(
			Arrays.asList(new UtilGenerico("INEXISTENTES", "Inexistentes"),
					      new UtilGenerico("NORMAL", "Normal"),
					      new UtilGenerico("POCA EXISTENCIA", "Poca Existencia")));
		
	public static final List<UtilGenerico> listRespObligatoria = new ArrayList<UtilGenerico>(
			Arrays.asList(new UtilGenerico("SI", "Si"),new UtilGenerico("NO", "No")));
	
	public static final List<UtilGenerico> listObjetoView = new ArrayList<UtilGenerico>(
			Arrays.asList(new UtilGenerico("textarea", "textarea"),
					new UtilGenerico("textfield", "textfield"),
					new UtilGenerico("checkbox", "checkbox"),
					new UtilGenerico("select", "select"),
					new UtilGenerico("calendar", "calendar")));
	
	public static final List<UtilGenerico> listTipoDato = new ArrayList<UtilGenerico>(
			Arrays.asList(new UtilGenerico("Alfanumerico", "Alfanumérico"),
					new UtilGenerico("Entero", "Entero"),
					new UtilGenerico("Fecha", "Fecha"),
					new UtilGenerico("Numerico", "Numérico")));
	
	public static final List<UtilGenerico> listEspecialidadSoportadas = new ArrayList<UtilGenerico>(
			Arrays.asList(new UtilGenerico("MEDICINA GENERAL", "Medicina General"),
					new UtilGenerico("ODONTOLOGIA", "Odontología"),
					new UtilGenerico("OPTOMETRIA", "Optometría")));
	
	public static final List<UtilGenerico> listClaseDiagnostico = new ArrayList<UtilGenerico>(
			Arrays.asList(new UtilGenerico("P", "Principal"),new UtilGenerico("R", "Relacionado")));
	
	public static final String constanteEspecialidadMedicinaGeneral = "3";
	public static final String constanteEspecialidadOdontologia = "1";
	public static final String constanteEspecialidadOptometria = "2";
	public static final String constanteEspecialidadBacteriologia = "4";
	
	
	public static final String constanteTipoDatoAlfanumerico = "Alfanumerico";
	public static final String constanteTipoDatoNumerico = "Numerico";
	public static final String constanteTipoDatoFecha = "Fecha";
	public static final String constanteTipoDatoEntero = "Entero";
	
	public static final String constanteRespObligatoriaSI = "SI";
	public static final String constanteRespObligatoriaNO = "NO";
	
	public static final String constanteTipoPregAbierta = "ABIERTA";
	public static final String constanteTipoPregMultipleMR = "MULTIPLEMR";
	public static final String constanteTipoPregMultipleUR = "MULTIPLEUR";
	public static final String constanteTipoPregFecha = "FECHA";
	
	public static final String constanteTipoObjetoViewTextField = "textfield";
	public static final String constanteTipoObjetoViewCheckBox = "checkbox";
	public static final String constanteTipoObjetoViewTextArea = "textarea";
	public static final String constanteTipoObjetoViewSelect = "select";
	public static final String constanteTipoObjetoViewCalendar = "calendar";
	

	public static final String constanteNombreSeccionDatosPersonales = "Datos Personales";
	public static final String constanteNombreSeccionDatosClinicos = "Datos Clínicos";
	public static final String constanteNombreSeccionExamenesOptometria = "Examenes Optometría";
	public static final String constanteNombreSeccionDiagnostico = "Diagnóstico";
	 
	public static final String constanteNombreExamenOptometriaRXUSO = "Rx en Uso";
	public static final String constanteNombreExamenOptometriaAVSC = "AVSC";
	public static final String constanteNombreExamenOptometriaCoverTest = "Cover Test";
	public static final String constanteNombreExamenOptometriaExamenExterno = "Examen Externo";
	public static final String constanteNombreExamenOptometriaOftalmoscopia = "Oftalmoscopia";
	public static final String constanteNombreExamenOptometriaKeratometria = "Keratometría";
	public static final String constanteNombreExamenOptometriaRetinoscopia = "Retinoscopia";

	public static final String constantePalabraClaveRXUSO = "RXUSO";
	public static final String constantePalabraClaveAVSC = "AVSC";
	public static final String constantePalabraClaveCoverTest = "CVRT";
	public static final String constantePalabraClaveExamenExterno = "EEXT";
	public static final String constantePalabraClaveOftalmoscopia = "OFT";
	public static final String constantePalabraClaveKeratometria = "KER";
	public static final String constantePalabraClaveRetinoscopia = "RET";

	public static final String constanteClaseDiagnosticoPP = "Dx Ppal";
	public static final String constanteClaseDiagnosticoRL = "Dx Rnal";

	public static final String constanteEspParteCuerpoOD = "OD";
	public static final String constanteEspParteCuerpoOI = "OI";
	public static final String constanteEspParteCuerpoODI = "ODI";
	
	public static final long constanteIdTipoFormulacionElem = 1;
	public static final long constanteIdTipoFormulacionMedi = 2;
	
	public static final String constanteCoverTestLejosAbre = "L";
	public static final String constanteCoverTestCercaAbre = "C";
}
