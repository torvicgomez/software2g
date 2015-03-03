package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "PARENTESCO" database table.
 * 
 */
@Entity
@Table(name="\"PARENTESCO\"", schema="\"HISCLINICA\"")
public class Parentesco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PARENTESCO_PAREID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_PARE_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARENTESCO_PAREID_GENERATOR")
	@Column(name="pare_id")
	private long pareId;

	@Column(name="pare_abreviatura")
	private String pareAbreviatura;

	@Column(name="pare_fechacambio")
	private String pareFechacambio;

	@Column(name="pare_horacambio")
	private String pareHoracambio;

	@Column(name="pare_parentesco")
	private String pareParentesco;

	@Column(name="pare_registradopor")
	private String pareRegistradopor;

	//bi-directional many-to-one association to Acudiente
	@OneToMany(mappedBy="parentesco")
	private List<Acudiente> acudientes;

	public Parentesco() {
	}

	public long getPareId() {
		return this.pareId;
	}

	public void setPareId(long pareId) {
		this.pareId = pareId;
	}

	public String getPareAbreviatura() {
		return this.pareAbreviatura;
	}

	public void setPareAbreviatura(String pareAbreviatura) {
		this.pareAbreviatura = pareAbreviatura;
	}

	public String getPareFechacambio() {
		return this.pareFechacambio;
	}

	public void setPareFechacambio(String pareFechacambio) {
		this.pareFechacambio = pareFechacambio;
	}

	public String getPareHoracambio() {
		return this.pareHoracambio;
	}

	public void setPareHoracambio(String pareHoracambio) {
		this.pareHoracambio = pareHoracambio;
	}

	public String getPareParentesco() {
		return this.pareParentesco;
	}

	public void setPareParentesco(String pareParentesco) {
		this.pareParentesco = pareParentesco;
	}

	public String getPareRegistradopor() {
		return this.pareRegistradopor;
	}

	public void setPareRegistradopor(String pareRegistradopor) {
		this.pareRegistradopor = pareRegistradopor;
	}

	public List<Acudiente> getAcudientes() {
		return this.acudientes;
	}

	public void setAcudientes(List<Acudiente> acudientes) {
		this.acudientes = acudientes;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.pareRegistradopor=data.get(0);
			this.pareFechacambio=data.get(1);
			this.pareHoracambio=data.get(2);
		}
	}
}