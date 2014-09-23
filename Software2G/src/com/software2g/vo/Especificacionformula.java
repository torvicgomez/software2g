package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the especificacionformula database table.
 * 
 */
@Entity
public class Especificacionformula implements Serializable {
	private static final long serialVersionUID = 1L;

	private String abreviaespeciformu;

	private String desespeciformu;

	private boolean formulacionactivo;

	@Column(name="id_especificaformula")
	private long idEspecificaformula;

	private String nomespeciformu;

	//bi-directional many-to-one association to Tipoespecialidad
	@ManyToOne
	@JoinColumn(name="id_tipoconsulta")
	private Tipoespecialidad tipoespecialidad;

	public Especificacionformula() {
	}

	public String getAbreviaespeciformu() {
		return this.abreviaespeciformu;
	}

	public void setAbreviaespeciformu(String abreviaespeciformu) {
		this.abreviaespeciformu = abreviaespeciformu;
	}

	public String getDesespeciformu() {
		return this.desespeciformu;
	}

	public void setDesespeciformu(String desespeciformu) {
		this.desespeciformu = desespeciformu;
	}

	public boolean getFormulacionactivo() {
		return this.formulacionactivo;
	}

	public void setFormulacionactivo(boolean formulacionactivo) {
		this.formulacionactivo = formulacionactivo;
	}

	public long getIdEspecificaformula() {
		return this.idEspecificaformula;
	}

	public void setIdEspecificaformula(long idEspecificaformula) {
		this.idEspecificaformula = idEspecificaformula;
	}

	public String getNomespeciformu() {
		return this.nomespeciformu;
	}

	public void setNomespeciformu(String nomespeciformu) {
		this.nomespeciformu = nomespeciformu;
	}

	public Tipoespecialidad getTipoespecialidad() {
		return this.tipoespecialidad;
	}

	public void setTipoespecialidad(Tipoespecialidad tipoespecialidad) {
		this.tipoespecialidad = tipoespecialidad;
	}

}