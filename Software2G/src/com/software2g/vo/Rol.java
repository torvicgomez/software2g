package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@Table(schema="portal", name="rol")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROL_IDROL_GENERATOR", sequenceName="PORTAL.SEQ_ROL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROL_IDROL_GENERATOR")
	@Column(name="id_rol")
	private Integer idRol;

	@Column(name="descripcion_rol")
	private String descripcionRol;

	private String fechacambio;

	private String horacambio;

	@Column(name="nombre_rol")
	private String nombreRol;

	private String registradopor;

	//bi-directional many-to-one association to Funcionalidadrol
	@OneToMany(mappedBy="rol")
	private List<Funcionalidadrol> funcionalidadrols;

	//bi-directional many-to-one association to Rolusuario
	@OneToMany(mappedBy="rol")
	private List<Rolusuario> rolusuarios;

	public Rol() {
	}

	public Integer getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getDescripcionRol() {
		return this.descripcionRol;
	}

	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
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

	public String getNombreRol() {
		return this.nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public String getRegistradopor() {
		return this.registradopor;
	}

	public void setRegistradopor(String registradopor) {
		this.registradopor = registradopor;
	}

	public List<Funcionalidadrol> getFuncionalidadrols() {
		return this.funcionalidadrols;
	}

	public void setFuncionalidadrols(List<Funcionalidadrol> funcionalidadrols) {
		this.funcionalidadrols = funcionalidadrols;
	}

	public List<Rolusuario> getRolusuarios() {
		return this.rolusuarios;
	}

	public void setRolusuarios(List<Rolusuario> rolusuarios) {
		this.rolusuarios = rolusuarios;
	}

}