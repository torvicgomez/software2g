package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import org.zkoss.zhtml.Pre;

import java.util.List;


/**
 * The persistent class for the "TIPOPREGUNTA" database table.
 * 
 */
@Entity
@Table(name="\"TIPOPREGUNTA\"", schema="\"HISCLINICA\"")
public class Tipopregunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOPREGUNTA_TIPRID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_TIPG_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOPREGUNTA_TIPRID_GENERATOR")
	@Column(name="tipr_id")
	private long tiprId;

	@Column(name="tipr_etiqueta")
	private String tiprEtiqueta;

	@Column(name="tipr_fechacambio")
	private String tiprFechacambio;

	@Column(name="tipr_horacambio")
	private String tiprHoracambio;

	@Column(name="tipr_mensajeayuda")
	private String tiprMensajeayuda;

	@Column(name="tipr_nombre")
	private String tiprNombre;

	@Column(name="tipr_registradopor")
	private String tiprRegistradopor;

	//bi-directional many-to-one association to Pregunta
	@OneToMany(mappedBy="tipopregunta")
	private List<Pregunta> preguntas;

	public Tipopregunta() {
	}

	public long getTiprId() {
		return this.tiprId;
	}

	public void setTiprId(long tiprId) {
		this.tiprId = tiprId;
	}

	public String getTiprEtiqueta() {
		return this.tiprEtiqueta;
	}

	public void setTiprEtiqueta(String tiprEtiqueta) {
		this.tiprEtiqueta = tiprEtiqueta;
	}

	public String getTiprFechacambio() {
		return this.tiprFechacambio;
	}

	public void setTiprFechacambio(String tiprFechacambio) {
		this.tiprFechacambio = tiprFechacambio;
	}

	public String getTiprHoracambio() {
		return this.tiprHoracambio;
	}

	public void setTiprHoracambio(String tiprHoracambio) {
		this.tiprHoracambio = tiprHoracambio;
	}

	public String getTiprMensajeayuda() {
		return this.tiprMensajeayuda;
	}

	public void setTiprMensajeayuda(String tiprMensajeayuda) {
		this.tiprMensajeayuda = tiprMensajeayuda;
	}

	public String getTiprNombre() {
		return this.tiprNombre;
	}

	public void setTiprNombre(String tiprNombre) {
		this.tiprNombre = tiprNombre;
	}

	public String getTiprRegistradopor() {
		return this.tiprRegistradopor;
	}

	public void setTiprRegistradopor(String tiprRegistradopor) {
		this.tiprRegistradopor = tiprRegistradopor;
	}

	public List<Pregunta> getPreguntas() {
		return this.preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.tiprRegistradopor=data.get(0);
			this.tiprFechacambio=data.get(1);
			this.tiprHoracambio=data.get(2);
		}
	}
}