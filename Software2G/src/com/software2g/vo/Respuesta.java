package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the "RESPUESTA" database table.
 * 
 */
@Entity
@Table(name="\"RESPUESTA\"", schema="\"HISCLINICA\"")
public class Respuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RESPUESTA_RESPID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_RESP_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESPUESTA_RESPID_GENERATOR")
	@Column(name="resp_id")
	private long respId;

	@Column(name="resp_fechacambio")
	private String respFechacambio;

	@Column(name="resp_horacambio")
	private String respHoracambio;

	@Column(name="resp_registradopor")
	private String respRegistradopor;

	@Column(name="resp_respuesta")
	private String respRespuesta;

	//bi-directional many-to-one association to Pregunta
	@ManyToOne
	@JoinColumn(name="preg_id")
	private Pregunta pregunta;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="serv_id")
	private Servicio servicio;

	public Respuesta() {
	}

	public long getRespId() {
		return this.respId;
	}

	public void setRespId(long respId) {
		this.respId = respId;
	}

	public String getRespFechacambio() {
		return this.respFechacambio;
	}

	public void setRespFechacambio(String respFechacambio) {
		this.respFechacambio = respFechacambio;
	}

	public String getRespHoracambio() {
		return this.respHoracambio;
	}

	public void setRespHoracambio(String respHoracambio) {
		this.respHoracambio = respHoracambio;
	}

	public String getRespRegistradopor() {
		return this.respRegistradopor;
	}

	public void setRespRegistradopor(String respRegistradopor) {
		this.respRegistradopor = respRegistradopor;
	}

	public String getRespRespuesta() {
		return this.respRespuesta;
	}

	public void setRespRespuesta(String respRespuesta) {
		this.respRespuesta = respRespuesta;
	}

	public Pregunta getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.respRegistradopor=data.get(0);
			this.respFechacambio=data.get(1);
			this.respHoracambio=data.get(2);
		}
	}
}