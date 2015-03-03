package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the "ACUDIENTE" database table.
 * 
 */
@Entity
@Table(name="\"ACUDIENTE\"", schema="\"HISCLINICA\"")
public class Acudiente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACUDIENTE_ACUDID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_ACUD_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACUDIENTE_ACUDID_GENERATOR")
	@Column(name="acud_id")
	private long acudId;

	@Column(name="acud_fechacambio")
	private String acudFechacambio;

	@Column(name="acud_horacambio")
	private String acudHoracambio;

	@Column(name="acud_registradopor")
	private String acudRegistradopor;

//	@Column(name="pers_id")
//	private java.math.BigDecimal persId;
	
	@ManyToOne
	@JoinColumn(name="pers_id")
	private Persona persona;
	

	//bi-directional many-to-one association to Parentesco
	@ManyToOne
	@JoinColumn(name="pare_id")
	private Parentesco parentesco;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="acudiente")
	private List<Servicio> servicios;

	public Acudiente() {
	}

	public long getAcudId() {
		return this.acudId;
	}

	public void setAcudId(long acudId) {
		this.acudId = acudId;
	}

	public String getAcudFechacambio() {
		return this.acudFechacambio;
	}

	public void setAcudFechacambio(String acudFechacambio) {
		this.acudFechacambio = acudFechacambio;
	}

	public String getAcudHoracambio() {
		return this.acudHoracambio;
	}

	public void setAcudHoracambio(String acudHoracambio) {
		this.acudHoracambio = acudHoracambio;
	}

	public String getAcudRegistradopor() {
		return this.acudRegistradopor;
	}

	public void setAcudRegistradopor(String acudRegistradopor) {
		this.acudRegistradopor = acudRegistradopor;
	}

//	public java.math.BigDecimal getPersId() {
//		return this.persId;
//	}
//
//	public void setPersId(java.math.BigDecimal persId) {
//		this.persId = persId;
//	}

	public Parentesco getParentesco() {
		return this.parentesco;
	}

	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.acudRegistradopor=data.get(0);
			this.acudFechacambio=data.get(1);
			this.acudHoracambio=data.get(2);
		}
	}
}