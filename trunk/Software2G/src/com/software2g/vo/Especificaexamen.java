package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the especificaexamen database table.
 * 
 */
@Entity
public class Especificaexamen implements Serializable {
	private static final long serialVersionUID = 1L;

	private String abreviatura;

	private String codespeciexam;

	private String descespeciexam;

	private boolean examenactivo;

	@Column(name="id_especiexam")
	private long idEspeciexam;

	private String nomespeciexam;

	//bi-directional many-to-one association to Tipoespecialidad
	@ManyToOne
	@JoinColumn(name="id_tipoconsulta")
	private Tipoespecialidad tipoespecialidad;

	public Especificaexamen() {
	}

	public String getAbreviatura() {
		return this.abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getCodespeciexam() {
		return this.codespeciexam;
	}

	public void setCodespeciexam(String codespeciexam) {
		this.codespeciexam = codespeciexam;
	}

	public String getDescespeciexam() {
		return this.descespeciexam;
	}

	public void setDescespeciexam(String descespeciexam) {
		this.descespeciexam = descespeciexam;
	}

	public boolean getExamenactivo() {
		return this.examenactivo;
	}

	public void setExamenactivo(boolean examenactivo) {
		this.examenactivo = examenactivo;
	}

	public long getIdEspeciexam() {
		return this.idEspeciexam;
	}

	public void setIdEspeciexam(long idEspeciexam) {
		this.idEspeciexam = idEspeciexam;
	}

	public String getNomespeciexam() {
		return this.nomespeciexam;
	}

	public void setNomespeciexam(String nomespeciexam) {
		this.nomespeciexam = nomespeciexam;
	}

	public Tipoespecialidad getTipoespecialidad() {
		return this.tipoespecialidad;
	}

	public void setTipoespecialidad(Tipoespecialidad tipoespecialidad) {
		this.tipoespecialidad = tipoespecialidad;
	}

}