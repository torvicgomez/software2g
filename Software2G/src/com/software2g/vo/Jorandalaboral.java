package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the "JORANDALABORAL" database table.
 * 
 */
@Entity
@Table(name="\"JORANDALABORAL\"", schema="\"HISCLINICA\"")
public class Jorandalaboral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="JORANDALABORAL_JORAID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_JORA_ID\"")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JORANDALABORAL_JORAID_GENERATOR")
	@Column(name="jora_id")
	private long joraId;

	@Column(name="jora_fechacambio")
	private String joraFechacambio;

	@Column(name="jora_horacambio")
	private String joraHoracambio;

	@Column(name="jora_horaingreso")
	private String joraHoraingreso;

	@Column(name="jora_horasalida")
	private String joraHorasalida;

	@Column(name="jora_nombre")
	private String joraNombre;

	@Column(name="jora_registradopor")
	private String joraRegistradopor;

	//bi-directional many-to-one association to Profesional
	@ManyToOne
	@JoinColumn(name="id_profesional")
	private Profesional profesional;

	public Jorandalaboral() {
	}

	public long getJoraId() {
		return this.joraId;
	}

	public void setJoraId(long joraId) {
		this.joraId = joraId;
	}

	public String getJoraFechacambio() {
		return this.joraFechacambio;
	}

	public void setJoraFechacambio(String joraFechacambio) {
		this.joraFechacambio = joraFechacambio;
	}

	public String getJoraHoracambio() {
		return this.joraHoracambio;
	}

	public void setJoraHoracambio(String joraHoracambio) {
		this.joraHoracambio = joraHoracambio;
	}

	public String getJoraHoraingreso() {
		return this.joraHoraingreso;
	}

	public void setJoraHoraingreso(String joraHoraingreso) {
		this.joraHoraingreso = joraHoraingreso;
	}

	public String getJoraHorasalida() {
		return this.joraHorasalida;
	}

	public void setJoraHorasalida(String joraHorasalida) {
		this.joraHorasalida = joraHorasalida;
	}

	public String getJoraNombre() {
		return this.joraNombre;
	}

	public void setJoraNombre(String joraNombre) {
		this.joraNombre = joraNombre;
	}

	public String getJoraRegistradopor() {
		return this.joraRegistradopor;
	}

	public void setJoraRegistradopor(String joraRegistradopor) {
		this.joraRegistradopor = joraRegistradopor;
	}

	public Profesional getProfesional() {
		return this.profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}
	
	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.joraRegistradopor=data.get(0);
			this.joraFechacambio=data.get(1);
			this.joraHoracambio=data.get(2);
		}
	}
}