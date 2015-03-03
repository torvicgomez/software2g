package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "SEGMENTOANAMNESIS" database table.
 * 
 */
@Entity
@Table(name="\"SEGMENTOANAMNESIS\"", schema="\"HISCLINICA\"")
public class Segmentoanamnesi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEGMENTOANAMNESIS_SEANID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_SEAN_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEGMENTOANAMNESIS_SEANID_GENERATOR")
	@Column(name="sean_id")
	private long seanId;

	@Column(name="sean_etiqueta")
	private String seanEtiqueta;

	@Column(name="sean_fechacambio")
	private String seanFechacambio;

	@Column(name="sean_horacambio")
	private String seanHoracambio;

	@Column(name="sean_mensajeayuda")
	private String seanMensajeayuda;

	@Column(name="sean_nombre")
	private String seanNombre;

	@Column(name="sean_registradopor")
	private String seanRegistradopor;

	//bi-directional many-to-one association to Pregunta
	@OneToMany(mappedBy="segmentoanamnesi")
	private List<Pregunta> preguntas;

	//bi-directional many-to-one association to Tipoespecialidad
	@ManyToOne
	@JoinColumn(name="ties_id")
	private Tipoespecialidad tipoespecialidad;

	//bi-directional many-to-one association to Tiposegmento
	@ManyToOne
	@JoinColumn(name="tisa_id")
	private Tiposegmento tiposegmento;

	public Segmentoanamnesi() {
	}

	public long getSeanId() {
		return this.seanId;
	}

	public void setSeanId(long seanId) {
		this.seanId = seanId;
	}

	public String getSeanEtiqueta() {
		return this.seanEtiqueta;
	}

	public void setSeanEtiqueta(String seanEtiqueta) {
		this.seanEtiqueta = seanEtiqueta;
	}

	public String getSeanFechacambio() {
		return this.seanFechacambio;
	}

	public void setSeanFechacambio(String seanFechacambio) {
		this.seanFechacambio = seanFechacambio;
	}

	public String getSeanHoracambio() {
		return this.seanHoracambio;
	}

	public void setSeanHoracambio(String seanHoracambio) {
		this.seanHoracambio = seanHoracambio;
	}

	public String getSeanMensajeayuda() {
		return this.seanMensajeayuda;
	}

	public void setSeanMensajeayuda(String seanMensajeayuda) {
		this.seanMensajeayuda = seanMensajeayuda;
	}

	public String getSeanNombre() {
		return this.seanNombre;
	}

	public void setSeanNombre(String seanNombre) {
		this.seanNombre = seanNombre;
	}

	public String getSeanRegistradopor() {
		return this.seanRegistradopor;
	}

	public void setSeanRegistradopor(String seanRegistradopor) {
		this.seanRegistradopor = seanRegistradopor;
	}

	public List<Pregunta> getPreguntas() {
		return this.preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public Tipoespecialidad getTipoespecialidad() {
		return this.tipoespecialidad;
	}

	public void setTipoespecialidad(Tipoespecialidad tipoespecialidad) {
		this.tipoespecialidad = tipoespecialidad;
	}

	public Tiposegmento getTiposegmento() {
		return this.tiposegmento;
	}

	public void setTiposegmento(Tiposegmento tiposegmento) {
		this.tiposegmento = tiposegmento;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.seanRegistradopor=data.get(0);
			this.seanFechacambio=data.get(1);
			this.seanHoracambio=data.get(2);
		}
	}
}