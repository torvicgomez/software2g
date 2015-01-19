package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the profesionalsalud database table.
 * 
 */
@Entity
@Table(schema="historiaclinica",name="profesionalsalud")
public class Profesionalsalud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROFESIONALSALUD_PRFSID_GENERATOR", sequenceName="HISTORIACLINICA.SEQ_PRFS_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROFESIONALSALUD_PRFSID_GENERATOR")
	@Column(name="prfs_id")
	private long prfsId;

	@Column(name="id_pers")
	private long idPers;

	@Column(name="prfs_fechacambio")
	private String prfsFechacambio;

	@Column(name="prfs_horacambio")
	private String prfsHoracambio;

	@Column(name="prfs_nrotarjetaprof")
	private String prfsNrotarjetaprof;

	@Column(name="prfs_registradopor")
	private String prfsRegistradopor;

	@Transient
	private Persona persona; 
	
	public Profesionalsalud() {
	}

	public long getPrfsId() {
		return this.prfsId;
	}

	public void setPrfsId(long prfsId) {
		this.prfsId = prfsId;
	}

	public long getIdPers() {
		return this.idPers;
	}

	public void setIdPers(long idPers) {
		this.idPers = idPers;
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

	public String getPrfsRegistradopor() {
		return this.prfsRegistradopor;
	}

	public void setPrfsRegistradopor(String prfsRegistradopor) {
		this.prfsRegistradopor = prfsRegistradopor;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}