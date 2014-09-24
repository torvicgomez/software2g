package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the antecesentesflia database table.
 * 
 */
@Entity
@Table(schema="PUBLIC", name="antecesentesflia")
public class Antecesentesflia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ANTECESENTESFLIA_IDANTECEDENTES_GENERATOR", sequenceName="PUBLIC.ANTECESENTESFLIA_ID_ANTECEDENTES_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ANTECESENTESFLIA_IDANTECEDENTES_GENERATOR")
	@Column(name="id_antecedentes")
	private long idAntecedentes;

	private String descantecedente;

	private String enfermedadantec;

	@Column(name="id_anamnesis")
	private long idAnamnesis;

	@Column(name="id_parentesco")
	private long idParentesco;

	public Antecesentesflia() {
	}

	public long getIdAntecedentes() {
		return this.idAntecedentes;
	}

	public void setIdAntecedentes(long idAntecedentes) {
		this.idAntecedentes = idAntecedentes;
	}

	public String getDescantecedente() {
		return this.descantecedente;
	}

	public void setDescantecedente(String descantecedente) {
		this.descantecedente = descantecedente;
	}

	public String getEnfermedadantec() {
		return this.enfermedadantec;
	}

	public void setEnfermedadantec(String enfermedadantec) {
		this.enfermedadantec = enfermedadantec;
	}

	public long getIdAnamnesis() {
		return this.idAnamnesis;
	}

	public void setIdAnamnesis(long idAnamnesis) {
		this.idAnamnesis = idAnamnesis;
	}

	public long getIdParentesco() {
		return this.idParentesco;
	}

	public void setIdParentesco(long idParentesco) {
		this.idParentesco = idParentesco;
	}

}