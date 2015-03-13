package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "PREGUNTA" database table.
 * 
 */
@Entity
@Table(name="\"PREGUNTA\"", schema="\"HISCLINICA\"")
public class Pregunta implements Serializable, Comparable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PREGUNTA_PREGID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_PREG_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PREGUNTA_PREGID_GENERATOR")
	@Column(name="preg_id")
	private long pregId;

	@Column(name="preg_fechacambio")
	private String pregFechacambio;

	@Column(name="preg_horacambio")
	private String pregHoracambio;

	@Column(name="preg_mensajeayuda")
	private String pregMensajeayuda;

	@Column(name="preg_orden")
	private long pregOrden;

	@Column(name="preg_pregunta")
	private String pregPregunta;

	@Column(name="preg_registradopor")
	private String pregRegistradopor;

	@Column(name="preg_tipodato")
	private String pregTipodato;

	@Column(name="preg_objetoview")
	private String pregObjetoview;
	
	@Column(name="preg_estado")
	private String pregEstado;
	
	//bi-directional many-to-one association to Opcionrespuesta
	@OneToMany(mappedBy="pregunta")
	private List<Opcionrespuesta> opcionrespuestas;

	//bi-directional many-to-one association to Segmentoanamnesi
	@ManyToOne
	@JoinColumn(name="sean_id")
	private Segmentoanamnesi segmentoanamnesi;

	//bi-directional many-to-one association to Tipopregunta
	@ManyToOne(targetEntity=Tipopregunta.class)
	@JoinColumn(name="tipr_id")
	private Tipopregunta tipopregunta;

	//bi-directional many-to-one association to Respuesta
	@OneToMany(mappedBy="pregunta")
	private List<Respuesta> respuestas;

	public Pregunta() {
	}

	@Override
	public int compareTo(Object obj) {
		Pregunta pregunta = (Pregunta)obj;
		return (int) (this.pregOrden - pregunta.getPregOrden());
	}
	
	public long getPregId() {
		return this.pregId;
	}

	public void setPregId(long pregId) {
		this.pregId = pregId;
	}

	public String getPregFechacambio() {
		return this.pregFechacambio;
	}

	public void setPregFechacambio(String pregFechacambio) {
		this.pregFechacambio = pregFechacambio;
	}

	public String getPregHoracambio() {
		return this.pregHoracambio;
	}

	public void setPregHoracambio(String pregHoracambio) {
		this.pregHoracambio = pregHoracambio;
	}

	public String getPregMensajeayuda() {
		return this.pregMensajeayuda;
	}

	public void setPregMensajeayuda(String pregMensajeayuda) {
		this.pregMensajeayuda = pregMensajeayuda;
	}

	public long getPregOrden() {
		return this.pregOrden;
	}

	public void setPregOrden(long pregOrden) {
		this.pregOrden = pregOrden;
	}

	public String getPregPregunta() {
		return this.pregPregunta;
	}

	public void setPregPregunta(String pregPregunta) {
		this.pregPregunta = pregPregunta;
	}

	public String getPregRegistradopor() {
		return this.pregRegistradopor;
	}

	public void setPregRegistradopor(String pregRegistradopor) {
		this.pregRegistradopor = pregRegistradopor;
	}

	public String getPregTipodato() {
		return this.pregTipodato;
	}

	public void setPregTipodato(String pregTipodato) {
		this.pregTipodato = pregTipodato;
	}

	public List<Opcionrespuesta> getOpcionrespuestas() {
		return this.opcionrespuestas;
	}

	public void setOpcionrespuestas(List<Opcionrespuesta> opcionrespuestas) {
		this.opcionrespuestas = opcionrespuestas;
	}

	public Segmentoanamnesi getSegmentoanamnesi() {
		return this.segmentoanamnesi;
	}

	public void setSegmentoanamnesi(Segmentoanamnesi segmentoanamnesi) {
		this.segmentoanamnesi = segmentoanamnesi;
	}

	public Tipopregunta getTipopregunta() {
		return this.tipopregunta;
	}

	public void setTipopregunta(Tipopregunta tipopregunta) {
		this.tipopregunta = tipopregunta;
	}

	public List<Respuesta> getRespuestas() {
		return this.respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.pregRegistradopor=data.get(0);
			this.pregFechacambio=data.get(1);
			this.pregHoracambio=data.get(2);
		}
	}

	public String getPregObjetoview() {
		return pregObjetoview;
	}

	public void setPregObjetoview(String pregObjetoview) {
		this.pregObjetoview = pregObjetoview;
	}

	public String getPregEstado() {
		return pregEstado;
	}

	public void setPregEstado(String pregEstado) {
		this.pregEstado = pregEstado;
	}

}