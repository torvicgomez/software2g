package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the posicion database table.
 * 
 */
@Entity
public class Posicion implements Serializable {
	private static final long serialVersionUID = 1L;

	private String abreviaturapos;

	private String descposicion;

	@Column(name="id_posicion")
	private long idPosicion;

	private String nombrepos;

	public Posicion() {
	}

	public String getAbreviaturapos() {
		return this.abreviaturapos;
	}

	public void setAbreviaturapos(String abreviaturapos) {
		this.abreviaturapos = abreviaturapos;
	}

	public String getDescposicion() {
		return this.descposicion;
	}

	public void setDescposicion(String descposicion) {
		this.descposicion = descposicion;
	}

	public long getIdPosicion() {
		return this.idPosicion;
	}

	public void setIdPosicion(long idPosicion) {
		this.idPosicion = idPosicion;
	}

	public String getNombrepos() {
		return this.nombrepos;
	}

	public void setNombrepos(String nombrepos) {
		this.nombrepos = nombrepos;
	}

}