package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the codigoenfermedades database table.
 * 
 */
@Entity
@Table(name="codigoenfermedades")
public class Codigoenfermedade implements Serializable {
	private static final long serialVersionUID = 1L;

	private String abreviacodenfermedad;

	private String codenfermedad;

	private String desccodenfermedad;

	@Column(name="id_codenfermedad")
	private long idCodenfermedad;

	private String nomcodenfermedad;

	//bi-directional many-to-one association to Tipoespecialidad
	@ManyToOne
	@JoinColumn(name="id_tipoconsulta")
	private Tipoespecialidad tipoespecialidad;

	public Codigoenfermedade() {
	}

	public String getAbreviacodenfermedad() {
		return this.abreviacodenfermedad;
	}

	public void setAbreviacodenfermedad(String abreviacodenfermedad) {
		this.abreviacodenfermedad = abreviacodenfermedad;
	}

	public String getCodenfermedad() {
		return this.codenfermedad;
	}

	public void setCodenfermedad(String codenfermedad) {
		this.codenfermedad = codenfermedad;
	}

	public String getDesccodenfermedad() {
		return this.desccodenfermedad;
	}

	public void setDesccodenfermedad(String desccodenfermedad) {
		this.desccodenfermedad = desccodenfermedad;
	}

	public long getIdCodenfermedad() {
		return this.idCodenfermedad;
	}

	public void setIdCodenfermedad(long idCodenfermedad) {
		this.idCodenfermedad = idCodenfermedad;
	}

	public String getNomcodenfermedad() {
		return this.nomcodenfermedad;
	}

	public void setNomcodenfermedad(String nomcodenfermedad) {
		this.nomcodenfermedad = nomcodenfermedad;
	}

	public Tipoespecialidad getTipoespecialidad() {
		return this.tipoespecialidad;
	}

	public void setTipoespecialidad(Tipoespecialidad tipoespecialidad) {
		this.tipoespecialidad = tipoespecialidad;
	}

}