package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the frecuencia database table.
 * 
 */
@Entity
public class Frecuencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FRECUENCIA_IDFRECUENCIA_GENERATOR", sequenceName="PUBLIC.FRECUENCIA_ID_FRECUENCIA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FRECUENCIA_IDFRECUENCIA_GENERATOR")
	@Column(name="id_frecuencia")
	private long idFrecuencia;

	private String descfrec;

	private String nomfrec;

	private String simbolofrec;

	private long tipofre;

	//bi-directional many-to-one association to Sintoma
	@OneToMany(mappedBy="frecuencia")
	private List<Sintoma> sintomas;

	//bi-directional many-to-one association to Tomasinodroga
	@OneToMany(mappedBy="frecuencia")
	private List<Tomasinodroga> tomasinodrogas;

	public Frecuencia() {
	}

	public long getIdFrecuencia() {
		return this.idFrecuencia;
	}

	public void setIdFrecuencia(long idFrecuencia) {
		this.idFrecuencia = idFrecuencia;
	}

	public String getDescfrec() {
		return this.descfrec;
	}

	public void setDescfrec(String descfrec) {
		this.descfrec = descfrec;
	}

	public String getNomfrec() {
		return this.nomfrec;
	}

	public void setNomfrec(String nomfrec) {
		this.nomfrec = nomfrec;
	}

	public String getSimbolofrec() {
		return this.simbolofrec;
	}

	public void setSimbolofrec(String simbolofrec) {
		this.simbolofrec = simbolofrec;
	}

	public long getTipofre() {
		return this.tipofre;
	}

	public void setTipofre(long tipofre) {
		this.tipofre = tipofre;
	}

	public List<Sintoma> getSintomas() {
		return this.sintomas;
	}

	public void setSintomas(List<Sintoma> sintomas) {
		this.sintomas = sintomas;
	}

	public List<Tomasinodroga> getTomasinodrogas() {
		return this.tomasinodrogas;
	}

	public void setTomasinodrogas(List<Tomasinodroga> tomasinodrogas) {
		this.tomasinodrogas = tomasinodrogas;
	}

}