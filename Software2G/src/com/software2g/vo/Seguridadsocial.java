package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the seguridadsocial database table.
 * 
 */
@Entity
@Table(schema="public", name="seguridadsocial")
public class Seguridadsocial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEGURIDADSOCIAL_IDSEGURIDAD_GENERATOR", sequenceName="PUBLIC.SEGURIDADSOCIAL_ID_SEGURIDAD_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEGURIDADSOCIAL_IDSEGURIDAD_GENERATOR")
	@Column(name="id_seguridad")
	private long idSeguridad;

	@Column(name="descsegu")
	private String descsegu;

	@Column(name="nivelsegu")
	private String nivelsegu;

	@Column(name="nomsegur")
	private String nomsegur;

	@Column(name="siglasegu")
	private String siglasegu;

	//bi-directional many-to-one association to Convenio
	@OneToMany(mappedBy="seguridadsocial")
	private List<Convenio> convenios;

	//bi-directional many-to-one association to Paciente
	@OneToMany(mappedBy="seguridadsocial")
	private List<Paciente> pacientes;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="seguridadsocial")
	private List<Servicio> servicios;

	public Seguridadsocial() {
	}

	public long getIdSeguridad() {
		return this.idSeguridad;
	}

	public void setIdSeguridad(long idSeguridad) {
		this.idSeguridad = idSeguridad;
	}

	public String getDescsegu() {
		return this.descsegu;
	}

	public void setDescsegu(String descsegu) {
		this.descsegu = descsegu;
	}

	public String getNivelsegu() {
		return this.nivelsegu;
	}

	public void setNivelsegu(String nivelsegu) {
		this.nivelsegu = nivelsegu;
	}

	public String getNomsegur() {
		return this.nomsegur;
	}

	public void setNomsegur(String nomsegur) {
		this.nomsegur = nomsegur;
	}

	public String getSiglasegu() {
		return this.siglasegu;
	}

	public void setSiglasegu(String siglasegu) {
		this.siglasegu = siglasegu;
	}

	public List<Convenio> getConvenios() {
		return this.convenios;
	}

	public void setConvenios(List<Convenio> convenios) {
		this.convenios = convenios;
	}

	public List<Paciente> getPacientes() {
		return this.pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

}