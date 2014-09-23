package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the formulacion database table.
 * 
 */
@Entity
public class Formulacion implements Serializable {
	private static final long serialVersionUID = 1L;

	private String descformulacion;

	@Column(name="id_consulta")
	private long idConsulta;

	@Column(name="id_especificaformula")
	private long idEspecificaformula;

	@Column(name="id_formulacion")
	private long idFormulacion;

	public Formulacion() {
	}

	public String getDescformulacion() {
		return this.descformulacion;
	}

	public void setDescformulacion(String descformulacion) {
		this.descformulacion = descformulacion;
	}

	public long getIdConsulta() {
		return this.idConsulta;
	}

	public void setIdConsulta(long idConsulta) {
		this.idConsulta = idConsulta;
	}

	public long getIdEspecificaformula() {
		return this.idEspecificaformula;
	}

	public void setIdEspecificaformula(long idEspecificaformula) {
		this.idEspecificaformula = idEspecificaformula;
	}

	public long getIdFormulacion() {
		return this.idFormulacion;
	}

	public void setIdFormulacion(long idFormulacion) {
		this.idFormulacion = idFormulacion;
	}

}