package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dependencia database table.
 * 
 */
@Entity
public class Dependencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="codigo_depen")
	private String codigoDepen;

	@Column(name="id_dependencia")
	private long idDependencia;

	@Column(name="id_institucion")
	private long idInstitucion;

	private String nombredepen;

	public Dependencia() {
	}

	public String getCodigoDepen() {
		return this.codigoDepen;
	}

	public void setCodigoDepen(String codigoDepen) {
		this.codigoDepen = codigoDepen;
	}

	public long getIdDependencia() {
		return this.idDependencia;
	}

	public void setIdDependencia(long idDependencia) {
		this.idDependencia = idDependencia;
	}

	public long getIdInstitucion() {
		return this.idInstitucion;
	}

	public void setIdInstitucion(long idInstitucion) {
		this.idInstitucion = idInstitucion;
	}

	public String getNombredepen() {
		return this.nombredepen;
	}

	public void setNombredepen(String nombredepen) {
		this.nombredepen = nombredepen;
	}

}