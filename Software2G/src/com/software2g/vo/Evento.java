package com.software2g.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.software2g.util.ConstantesAplicativo;
import com.software2g.util.ValidaString;


/**
 * The persistent class for the "EVENTOS" database table.
 * 
 */
@Entity
@Table(name="\"EVENTOS\"", schema="\"HISCLINICA\"")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVENTOS_EVENID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_EVEN_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENTOS_EVENID_GENERATOR")
	@Column(name="even_id")
	private long evenId;

	@Column(name="even_allday")
	private String evenAllday;

	@Column(name="even_backgroundcolor")
	private String evenBackgroundcolor;

	@Column(name="even_bordercolor")
	private String evenBordercolor;

	@Column(name="even_classname")
	private String evenClassname;

	@Column(name="even_color")
	private String evenColor;

	@Column(name="even_durationeditable")
	private String evenDurationeditable;

	@Column(name="even_editable")
	private String evenEditable;

	@Column(name="even_end")
	private String evenEnd;

	@Column(name="even_estado")
	private String evenEstado;

	@Column(name="even_fechacambio")
	private String evenFechacambio;

	@Column(name="even_horacambio")
	private String evenHoracambio;

	@Column(name="even_registradopor")
	private String evenRegistradopor;

	@Column(name="even_source")
	private String evenSource;

	@Column(name="even_start")
	private String evenStart;

	@Column(name="even_starteditable")
	private String evenStarteditable;

	@Column(name="even_textcolor")
	private String evenTextcolor;

	@Column(name="even_title")
	private String evenTitle;

	@Column(name="even_url")
	private String evenUrl;

	//bi-directional many-to-one association to Agenda
	@ManyToOne
	@JoinColumn(name="agen_id")
	private Agenda agenda;

	//bi-directional many-to-one association to Participante
	@OneToMany(mappedBy="evento")
	private List<Participante> participantes;
	
	public Evento() {
	}

	public long getEvenId() {
		return this.evenId;
	}

	public void setEvenId(long evenId) {
		this.evenId = evenId;
	}

	public String getEvenAllday() {
		return this.evenAllday;
	}

	public void setEvenAllday(String evenAllday) {
		this.evenAllday = evenAllday;
	}

	public String getEvenBackgroundcolor() {
		return this.evenBackgroundcolor;
	}

	public void setEvenBackgroundcolor(String evenBackgroundcolor) {
		this.evenBackgroundcolor = evenBackgroundcolor;
	}

	public String getEvenBordercolor() {
		return this.evenBordercolor;
	}

	public void setEvenBordercolor(String evenBordercolor) {
		this.evenBordercolor = evenBordercolor;
	}

	public String getEvenClassname() {
		return this.evenClassname;
	}

	public void setEvenClassname(String evenClassname) {
		this.evenClassname = evenClassname;
	}

	public String getEvenColor() {
		return this.evenColor;
	}

	public void setEvenColor(String evenColor) {
		this.evenColor = evenColor;
	}

	public String getEvenDurationeditable() {
		return this.evenDurationeditable;
	}

	public void setEvenDurationeditable(String evenDurationeditable) {
		this.evenDurationeditable = evenDurationeditable;
	}

	public String getEvenEditable() {
		return this.evenEditable;
	}

	public void setEvenEditable(String evenEditable) {
		this.evenEditable = evenEditable;
	}

	public String getEvenEnd() {
		return this.evenEnd;
	}

	public void setEvenEnd(String evenEnd) {
		this.evenEnd = evenEnd;
	}

	public String getEvenEstado() {
		return this.evenEstado;
	}

	public void setEvenEstado(String evenEstado) {
		this.evenEstado = evenEstado;
	}

	public String getEvenFechacambio() {
		return this.evenFechacambio;
	}

	public void setEvenFechacambio(String evenFechacambio) {
		this.evenFechacambio = evenFechacambio;
	}

	public String getEvenHoracambio() {
		return this.evenHoracambio;
	}

	public void setEvenHoracambio(String evenHoracambio) {
		this.evenHoracambio = evenHoracambio;
	}

	public String getEvenRegistradopor() {
		return this.evenRegistradopor;
	}

	public void setEvenRegistradopor(String evenRegistradopor) {
		this.evenRegistradopor = evenRegistradopor;
	}

	public String getEvenSource() {
		return this.evenSource;
	}

	public void setEvenSource(String evenSource) {
		this.evenSource = evenSource;
	}

	public String getEvenStart() {
		return this.evenStart;
	}

	public void setEvenStart(String evenStart) {
		this.evenStart = evenStart;
	}

	public String getEvenStarteditable() {
		return this.evenStarteditable;
	}

	public void setEvenStarteditable(String evenStarteditable) {
		this.evenStarteditable = evenStarteditable;
	}

	public String getEvenTextcolor() {
		return this.evenTextcolor;
	}

	public void setEvenTextcolor(String evenTextcolor) {
		this.evenTextcolor = evenTextcolor;
	}

	public String getEvenTitle() {
		return this.evenTitle;
	}

	public void setEvenTitle(String evenTitle) {
		this.evenTitle = evenTitle;
	}

	public String getEvenUrl() {
		return this.evenUrl;
	}

	public void setEvenUrl(String evenUrl) {
		this.evenUrl = evenUrl;
	}

	public Agenda getAgenda() {
		return this.agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.evenRegistradopor=data.get(0);
			this.evenFechacambio=data.get(1);
			this.evenHoracambio=data.get(2);
		}
	}

	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public String getEvenStartViewFecha(){
		Date date = new Date(this.evenStart);
		SimpleDateFormat format = new SimpleDateFormat(ConstantesAplicativo.constanteFormatoFecha3);
		return  format.format(date);
	}
	
	public String getEvenStartViewHora(){
		Date date = new Date(this.evenStart);
		SimpleDateFormat format = new SimpleDateFormat(ConstantesAplicativo.constanteFormatoFechaHora2);
		return  format.format(date);
	}
}