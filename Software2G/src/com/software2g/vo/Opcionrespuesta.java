package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the "OPCIONRESPUESTA" database table.
 * 
 */
@Entity
@Table(name="\"OPCIONRESPUESTA\"", schema="\"HISCLINICA\"")
public class Opcionrespuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OPCIONRESPUESTA_OPREID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_OPRE_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OPCIONRESPUESTA_OPREID_GENERATOR")
	@Column(name="opre_id")
	private long opreId;

	@Column(name="opre_etiqueta")
	private String opreEtiqueta;

	@Column(name="opre_fechacambio")
	private String opreFechacambio;

	@Column(name="opre_horacambio")
	private String opreHoracambio;

	@Column(name="opre_orden")
	private long opreOrden;

	@Column(name="opre_registradopor")
	private String opreRegistradopor;

	@Column(name="opre_valor")
	private String opreValor;

	//bi-directional many-to-one association to Pregunta
	@ManyToOne
	@JoinColumn(name="preg_id")
	private Pregunta pregunta;

	public Opcionrespuesta() {
	}

	public long getOpreId() {
		return this.opreId;
	}

	public void setOpreId(long opreId) {
		this.opreId = opreId;
	}

	public String getOpreEtiqueta() {
		return this.opreEtiqueta;
	}

	public void setOpreEtiqueta(String opreEtiqueta) {
		this.opreEtiqueta = opreEtiqueta;
	}

	public String getOpreFechacambio() {
		return this.opreFechacambio;
	}

	public void setOpreFechacambio(String opreFechacambio) {
		this.opreFechacambio = opreFechacambio;
	}

	public String getOpreHoracambio() {
		return this.opreHoracambio;
	}

	public void setOpreHoracambio(String opreHoracambio) {
		this.opreHoracambio = opreHoracambio;
	}

	public long getOpreOrden() {
		return this.opreOrden;
	}

	public void setOpreOrden(long opreOrden) {
		this.opreOrden = opreOrden;
	}

	public String getOpreRegistradopor() {
		return this.opreRegistradopor;
	}

	public void setOpreRegistradopor(String opreRegistradopor) {
		this.opreRegistradopor = opreRegistradopor;
	}

	public String getOpreValor() {
		return this.opreValor;
	}

	public void setOpreValor(String opreValor) {
		this.opreValor = opreValor;
	}

	public Pregunta getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.opreRegistradopor=data.get(0);
			this.opreFechacambio=data.get(1);
			this.opreHoracambio=data.get(2);
		}
	}
}