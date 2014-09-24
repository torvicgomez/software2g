package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the listaexamenconsulta database table.
 * 
 */
@Entity
@Table(schema="public", name="listaexamenconsulta")
public class Listaexamenconsulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LISTAEXAMENCONSULTA_IDLISTAEXAMCONS_GENERATOR", sequenceName="PUBLIC.LISTAEXAMENCONSULTA_ID_LISTAEXAMCONS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LISTAEXAMENCONSULTA_IDLISTAEXAMCONS_GENERATOR")
	@Column(name="id_listaexamcons")
	private long idListaexamcons;

	private String abrevialistaexacons;

	private String codlistaexacons;

	private String desclistaexacons;

	@Column(name="id_especiexam")
	private long idEspeciexam;

	private String nomlistaexacons;

	//bi-directional many-to-one association to Tipoespecialidad
	@ManyToOne
	@JoinColumn(name="id_tipoconsulta")
	private Tipoespecialidad tipoespecialidad;

	public Listaexamenconsulta() {
	}

	public long getIdListaexamcons() {
		return this.idListaexamcons;
	}

	public void setIdListaexamcons(long idListaexamcons) {
		this.idListaexamcons = idListaexamcons;
	}

	public String getAbrevialistaexacons() {
		return this.abrevialistaexacons;
	}

	public void setAbrevialistaexacons(String abrevialistaexacons) {
		this.abrevialistaexacons = abrevialistaexacons;
	}

	public String getCodlistaexacons() {
		return this.codlistaexacons;
	}

	public void setCodlistaexacons(String codlistaexacons) {
		this.codlistaexacons = codlistaexacons;
	}

	public String getDesclistaexacons() {
		return this.desclistaexacons;
	}

	public void setDesclistaexacons(String desclistaexacons) {
		this.desclistaexacons = desclistaexacons;
	}

	public long getIdEspeciexam() {
		return this.idEspeciexam;
	}

	public void setIdEspeciexam(long idEspeciexam) {
		this.idEspeciexam = idEspeciexam;
	}

	public String getNomlistaexacons() {
		return this.nomlistaexacons;
	}

	public void setNomlistaexacons(String nomlistaexacons) {
		this.nomlistaexacons = nomlistaexacons;
	}

	public Tipoespecialidad getTipoespecialidad() {
		return this.tipoespecialidad;
	}

	public void setTipoespecialidad(Tipoespecialidad tipoespecialidad) {
		this.tipoespecialidad = tipoespecialidad;
	}

}