package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the profesionalsalud database table.
 * 
 */
@Entity
@Table(schema="HISTORIACLINICA", name="PROFESIONALSALUD")
public class Profesionalsalud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROFESIONALSALUD_PRFSID_GENERATOR", sequenceName="HISTORIACLINICA.SEQ_PRFS_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROFESIONALSALUD_PRFSID_GENERATOR")
	@Column(name="prfs_id")
	private long prfsId;

//	@Column(name="id_pers")
//	private long idPers;

	@Column(name="prfs_estado")
	private String prfsEstado;

	@Column(name="prfs_fechacambio")
	private String prfsFechacambio;

	@Column(name="prfs_horacambio")
	private String prfsHoracambio;

	@Column(name="prfs_nrotarjetaprof")
	private String prfsNrotarjetaprof;

	@Column(name="prfs_profesion")
	private String prfsProfesion;

	@Column(name="prfs_registradopor")
	private String prfsRegistradopor;

	//bi-directional many-to-one association to Agendamedica
	@OneToMany(mappedBy="profesionalsalud")
	private List<Agendamedica> agendamedicas;

	@ManyToOne
	@JoinColumn(name="id_pers")
	private Persona persona;
	
	public Profesionalsalud() {
	}

	public long getPrfsId() {
		return this.prfsId;
	}

	public void setPrfsId(long prfsId) {
		this.prfsId = prfsId;
	}

//	public long getIdPers() {
//		return this.idPers;
//	}
//
//	public void setIdPers(long idPers) {
//		this.idPers = idPers;
//	}

	public String getPrfsEstado() {
		return this.prfsEstado;
	}

	public void setPrfsEstado(String prfsEstado) {
		this.prfsEstado = prfsEstado;
	}

	public String getPrfsFechacambio() {
		return this.prfsFechacambio;
	}

	public void setPrfsFechacambio(String prfsFechacambio) {
		this.prfsFechacambio = prfsFechacambio;
	}

	public String getPrfsHoracambio() {
		return this.prfsHoracambio;
	}

	public void setPrfsHoracambio(String prfsHoracambio) {
		this.prfsHoracambio = prfsHoracambio;
	}

	public String getPrfsNrotarjetaprof() {
		return this.prfsNrotarjetaprof;
	}

	public void setPrfsNrotarjetaprof(String prfsNrotarjetaprof) {
		this.prfsNrotarjetaprof = prfsNrotarjetaprof;
	}

	public String getPrfsProfesion() {
		return this.prfsProfesion;
	}

	public void setPrfsProfesion(String prfsProfesion) {
		this.prfsProfesion = prfsProfesion;
	}

	public String getPrfsRegistradopor() {
		return this.prfsRegistradopor;
	}

	public void setPrfsRegistradopor(String prfsRegistradopor) {
		this.prfsRegistradopor = prfsRegistradopor;
	}

	public List<Agendamedica> getAgendamedicas() {
		return this.agendamedicas;
	}

	public void setAgendamedicas(List<Agendamedica> agendamedicas) {
		this.agendamedicas = agendamedicas;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.prfsRegistradopor=data.get(0);
			this.prfsFechacambio=data.get(1);
			this.prfsHoracambio=data.get(2);
		}
	}
}