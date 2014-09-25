package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tomasinodroga database table.
 * 
 */
@Entity
@Table(name="tomasinodroga", schema="public")
public class Tomasinodroga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TOMASINODROGA_IDTOMASINO_GENERATOR", sequenceName="PUBLIC.TOMASINODROGA_ID_TOMASINO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TOMASINODROGA_IDTOMASINO_GENERATOR")
	@Column(name="id_tomasino")
	private long idTomasino;

	private String destomasino;

	@Column(name="id_anamnesis")
	private long idAnamnesis;

	private String nomtomadogra;

	//bi-directional many-to-one association to Estadomedicamento
	@ManyToOne
	@JoinColumn(name="id_estmedicamento")
	private Estadomedicamento estadomedicamento;

	//bi-directional many-to-one association to Frecuencia
	@ManyToOne
	@JoinColumn(name="id_frecuencia")
	private Frecuencia frecuencia;

	public Tomasinodroga() {
	}

	public long getIdTomasino() {
		return this.idTomasino;
	}

	public void setIdTomasino(long idTomasino) {
		this.idTomasino = idTomasino;
	}

	public String getDestomasino() {
		return this.destomasino;
	}

	public void setDestomasino(String destomasino) {
		this.destomasino = destomasino;
	}

	public long getIdAnamnesis() {
		return this.idAnamnesis;
	}

	public void setIdAnamnesis(long idAnamnesis) {
		this.idAnamnesis = idAnamnesis;
	}

	public String getNomtomadogra() {
		return this.nomtomadogra;
	}

	public void setNomtomadogra(String nomtomadogra) {
		this.nomtomadogra = nomtomadogra;
	}

	public Estadomedicamento getEstadomedicamento() {
		return this.estadomedicamento;
	}

	public void setEstadomedicamento(Estadomedicamento estadomedicamento) {
		this.estadomedicamento = estadomedicamento;
	}

	public Frecuencia getFrecuencia() {
		return this.frecuencia;
	}

	public void setFrecuencia(Frecuencia frecuencia) {
		this.frecuencia = frecuencia;
	}

}