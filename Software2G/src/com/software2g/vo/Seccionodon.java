package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "SECCIONODON" database table.
 * 
 */
@Entity
@Table(name="\"SECCIONODON\"", schema="\"HISCLINICA\"")
public class Seccionodon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SECCIONODON_SECCID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_SECC_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECCIONODON_SECCID_GENERATOR")
	@Column(name="secc_id")
	private long seccId;

	@Column(name="secc_abreviatura")
	private String seccAbreviatura;

	@Column(name="secc_fechacambio")
	private String seccFechacambio;

	@Column(name="secc_horacambio")
	private String seccHoracambio;

	@Column(name="secc_nombre")
	private String seccNombre;

	@Column(name="secc_registradopor")
	private String seccRegistradopor;

	//bi-directional many-to-one association to Registroodontograma
	@OneToMany(mappedBy="seccionodon")
	private List<Registroodontograma> registroodontogramas;

	public Seccionodon() {
	}

	public long getSeccId() {
		return this.seccId;
	}

	public void setSeccId(long seccId) {
		this.seccId = seccId;
	}

	public String getSeccAbreviatura() {
		return this.seccAbreviatura;
	}

	public void setSeccAbreviatura(String seccAbreviatura) {
		this.seccAbreviatura = seccAbreviatura;
	}

	public String getSeccFechacambio() {
		return this.seccFechacambio;
	}

	public void setSeccFechacambio(String seccFechacambio) {
		this.seccFechacambio = seccFechacambio;
	}

	public String getSeccHoracambio() {
		return this.seccHoracambio;
	}

	public void setSeccHoracambio(String seccHoracambio) {
		this.seccHoracambio = seccHoracambio;
	}

	public String getSeccNombre() {
		return this.seccNombre;
	}

	public void setSeccNombre(String seccNombre) {
		this.seccNombre = seccNombre;
	}

	public String getSeccRegistradopor() {
		return this.seccRegistradopor;
	}

	public void setSeccRegistradopor(String seccRegistradopor) {
		this.seccRegistradopor = seccRegistradopor;
	}

	public List<Registroodontograma> getRegistroodontogramas() {
		return this.registroodontogramas;
	}

	public void setRegistroodontogramas(List<Registroodontograma> registroodontogramas) {
		this.registroodontogramas = registroodontogramas;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.seccRegistradopor=data.get(0);
			this.seccFechacambio=data.get(1);
			this.seccHoracambio=data.get(2);
		}
	}
}