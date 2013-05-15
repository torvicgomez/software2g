package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the aplicacion database table.
 * 
 */
@Entity
@Table(schema="portal", name="aplicacion")
public class Aplicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="APLICACION_IDAPLI_GENERATOR", sequenceName="PORTAL.SEQ_APLICACION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APLICACION_IDAPLI_GENERATOR")
	@Column(name="id_apli")
	private Integer idApli;

	@Column(name="descripcion_apli")
	private String descripcionApli;

	private String fechacambio;

	private String horacambio;

	@Column(name="nombre_apli")
	private String nombreApli;

	@Column(name="nombrelib_apli")
	private String nombrelibApli;

	private String registradopor;

	//bi-directional many-to-one association to Funcionalidad
	@OneToMany(mappedBy="aplicacion")
	private List<Funcionalidad> funcionalidads;

	public Aplicacion() {
	}

	public Integer getIdApli() {
		return this.idApli;
	}

	public void setIdApli(Integer idApli) {
		this.idApli = idApli;
	}

	public String getDescripcionApli() {
		return this.descripcionApli;
	}

	public void setDescripcionApli(String descripcionApli) {
		this.descripcionApli = descripcionApli;
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

	public String getNombreApli() {
		return this.nombreApli;
	}

	public void setNombreApli(String nombreApli) {
		this.nombreApli = nombreApli;
	}

	public String getNombrelibApli() {
		return this.nombrelibApli;
	}

	public void setNombrelibApli(String nombrelibApli) {
		this.nombrelibApli = nombrelibApli;
	}

	public String getRegistradopor() {
		return this.registradopor;
	}

	public void setRegistradopor(String registradopor) {
		this.registradopor = registradopor;
	}

	public List<Funcionalidad> getFuncionalidads() {
		return this.funcionalidads;
	}

	public void setFuncionalidads(List<Funcionalidad> funcionalidads) {
		this.funcionalidads = funcionalidads;
	}

}