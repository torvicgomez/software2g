package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "PROFESIONAL" database table.
 * 
 */
@Entity
@Table(name="PROFESIONAL", schema="HISCLINICA")
public class Profesional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROFESIONAL_PROFID_GENERATOR", sequenceName="HISCLINICA.SEQ_PROF_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROFESIONAL_PROFID_GENERATOR")
	@Column(name="prof_id")
	private long profId;

	@Id
	@SequenceGenerator(name="PROFESIONAL_PERSID_GENERATOR", sequenceName="HISCLINICA.SEQ_PROF_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROFESIONAL_PERSID_GENERATOR")
	@Column(name="pers_id", insertable=false)
	private long persId;

	@Column(name="prof_fechacambio")
	private String profFechacambio;

	@Column(name="prof_horacambio")
	private String profHoracambio;

	@Column(name="prof_registradopor")
	private String profRegistradopor;

	//bi-directional many-to-one association to Agenda
	@OneToMany(mappedBy="profesional")
	private List<Agenda> agendas;

	//bi-directional many-to-one association to Jorandalaboral
	@OneToMany(mappedBy="profesional")
	private List<Jorandalaboral> jorandalaborals;

	public Profesional() {
	}

	public long getProfId() {
		return this.profId;
	}

	public void setProfId(long profId) {
		this.profId = profId;
	}

	public long getPersId() {
		return this.persId;
	}

	public void setPersId(long persId) {
		this.persId = persId;
	}

	public String getProfFechacambio() {
		return this.profFechacambio;
	}

	public void setProfFechacambio(String profFechacambio) {
		this.profFechacambio = profFechacambio;
	}

	public String getProfHoracambio() {
		return this.profHoracambio;
	}

	public void setProfHoracambio(String profHoracambio) {
		this.profHoracambio = profHoracambio;
	}

	public String getProfRegistradopor() {
		return this.profRegistradopor;
	}

	public void setProfRegistradopor(String profRegistradopor) {
		this.profRegistradopor = profRegistradopor;
	}

	public List<Agenda> getAgendas() {
		return this.agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}

	public List<Jorandalaboral> getJorandalaborals() {
		return this.jorandalaborals;
	}

	public void setJorandalaborals(List<Jorandalaboral> jorandalaborals) {
		this.jorandalaborals = jorandalaborals;
	}

}