package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the "PACIENTE" database table.
 * 
 */
@Entity
@Table(name="\"PACIENTE\"", schema="\"HISCLINICA\"")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PACIENTE_PACIID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_PACI_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PACIENTE_PACIID_GENERATOR")
	@Column(name="paci_id")
	private long paciId;

	@Column(name="paci_fechacambio")
	private String paciFechacambio;

	@Column(name="paci_horacambio")
	private String paciHoracambio;

	@Column(name="paci_ocupacion")
	private String paciOcupacion;

	@Column(name="paci_registradopor")
	private String paciRegistradopor;

//	@Column(name="pers_id")
//	private java.math.BigDecimal persId;

	@ManyToOne
	@JoinColumn(name="pers_id")
	private Persona persona;
	
	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="paciente")
	private List<Servicio> servicios;

	@Transient
	private String existePaciente;
	
	public Paciente() {
	}

	public long getPaciId() {
		return this.paciId;
	}

	public void setPaciId(long paciId) {
		this.paciId = paciId;
	}

	public String getPaciFechacambio() {
		return this.paciFechacambio;
	}

	public void setPaciFechacambio(String paciFechacambio) {
		this.paciFechacambio = paciFechacambio;
	}

	public String getPaciHoracambio() {
		return this.paciHoracambio;
	}

	public void setPaciHoracambio(String paciHoracambio) {
		this.paciHoracambio = paciHoracambio;
	}

	public String getPaciOcupacion() {
		return this.paciOcupacion;
	}

	public void setPaciOcupacion(String paciOcupacion) {
		this.paciOcupacion = paciOcupacion;
	}

	public String getPaciRegistradopor() {
		return this.paciRegistradopor;
	}

	public void setPaciRegistradopor(String paciRegistradopor) {
		this.paciRegistradopor = paciRegistradopor;
	}

//	public java.math.BigDecimal getPersId() {
//		return this.persId;
//	}
//
//	public void setPersId(java.math.BigDecimal persId) {
//		this.persId = persId;
//	}

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
			this.paciRegistradopor=data.get(0);
			this.paciFechacambio=data.get(1);
			this.paciHoracambio=data.get(2);
		}
	}

	public String getExistePaciente() {
		return existePaciente;
	}

	public void setExistePaciente(String existePaciente) {
		this.existePaciente = existePaciente;
	}
	
}