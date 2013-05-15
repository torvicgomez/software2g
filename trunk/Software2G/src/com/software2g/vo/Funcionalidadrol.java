package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the funcionalidadrol database table.
 * 
 */
@Entity
@Table(schema="portal", name="funcionalidadrol")
public class Funcionalidadrol implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FuncionalidadrolPK id;

	private String fechacambio;

	private String horacambio;

	private String registradopor;

	//bi-directional many-to-one association to Funcionalidad
	@ManyToOne
	@JoinColumn(insertable=false,updatable=false,name="id_func")
	private Funcionalidad funcionalidad;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(insertable=false,updatable=false,name="id_rol")
	private Rol rol;

	public Funcionalidadrol() {
	}

	public FuncionalidadrolPK getId() {
		return this.id;
	}

	public void setId(FuncionalidadrolPK id) {
		this.id = id;
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

	public String getRegistradopor() {
		return this.registradopor;
	}

	public void setRegistradopor(String registradopor) {
		this.registradopor = registradopor;
	}

	public Funcionalidad getFuncionalidad() {
		return this.funcionalidad;
	}

	public void setFuncionalidad(Funcionalidad funcionalidad) {
		this.funcionalidad = funcionalidad;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}