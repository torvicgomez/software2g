package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipodocumento database table.
 * 
 */
@Entity
@Table(schema="portal",name="tipodocumento")
public class Tipodocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPODOCUMENTO_IDTIDOC_GENERATOR", sequenceName="PORTAL.SEQ_TIPODOCUMENTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPODOCUMENTO_IDTIDOC_GENERATOR")
	@Column(name="id_tidoc")
	private Integer idTidoc;

	@Column(name="abreviatura_tidoc")
	private String abreviaturaTidoc;

	@Column(name="descripcion_tidoc")
	private String descripcionTidoc;

	@Column(name="estado_tidoc")
	private String estadoTidoc;

	private String fechacambio;

	private String horacambio;

	@Column(name="nombre_tidoc")
	private String nombreTidoc;

	private String registradopor;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="tipodocumento")
	private List<Persona> personas;

	public Tipodocumento() {
	}

	public Integer getIdTidoc() {
		return this.idTidoc;
	}

	public void setIdTidoc(Integer idTidoc) {
		this.idTidoc = idTidoc;
	}

	public String getAbreviaturaTidoc() {
		return this.abreviaturaTidoc;
	}

	public void setAbreviaturaTidoc(String abreviaturaTidoc) {
		this.abreviaturaTidoc = abreviaturaTidoc;
	}

	public String getDescripcionTidoc() {
		return this.descripcionTidoc;
	}

	public void setDescripcionTidoc(String descripcionTidoc) {
		this.descripcionTidoc = descripcionTidoc;
	}

	public String getEstadoTidoc() {
		return this.estadoTidoc;
	}

	public void setEstadoTidoc(String estadoTidoc) {
		this.estadoTidoc = estadoTidoc;
	}

	public String getFechacambio() {
		return this.fechacambio;
	}

	public void setFechacambio(String fechacambio) {
		this.fechacambio = fechacambio;
	}

	public String getHoracambio() {
		return this.horacambio;
	}

	public void setHoracambio(String horacambio) {
		this.horacambio = horacambio;
	}

	public String getNombreTidoc() {
		return this.nombreTidoc;
	}

	public void setNombreTidoc(String nombreTidoc) {
		this.nombreTidoc = nombreTidoc;
	}

	public String getRegistradopor() {
		return this.registradopor;
	}

	public void setRegistradopor(String registradopor) {
		this.registradopor = registradopor;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

}