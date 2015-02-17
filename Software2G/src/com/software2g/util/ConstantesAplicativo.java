package com.software2g.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	public static final String constanteCrearFileJSEventosAll = "allEventos";
	public static final String constanteCrearFileJSEventosxAgenda = "allEventosxAgenda";
	public static final String constanteEstadoEventoCreado = "CREADO";
	
	public static final List<String> constanteEstadoCivil = new ArrayList<String>(Arrays.asList("CASADO(A)","DIVORCIADO(A)", "SOLTERO(A)", "UNIÓN LIBRE"));
	
	// Acciones a realizar con la cita
	public static final String constanteNoAplica = "NA";
	public static final String constanteAtenderServicio = "AS";
	public static final String constanteCancelarCita = "CC";
}
