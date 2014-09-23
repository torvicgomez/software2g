package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the partescuerpo database table.
 * 
 */
@Entity
public class Partescuerpo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String descparcuerpo;

	private String especie;

	@Column(name="id_partescuerpo")
	private long idPartescuerpo;

	private String nombreparcuerpo;

	public Partescuerpo() {
	}

	public String getDescparcuerpo() {
		return this.descparcuerpo;
	}

	public void setDescparcuerpo(String descparcuerpo) {
		this.descparcuerpo = descparcuerpo;
	}

	public String getEspecie() {
		return this.especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public long getIdPartescuerpo() {
		return this.idPartescuerpo;
	}

	public void setIdPartescuerpo(long idPartescuerpo) {
		this.idPartescuerpo = idPartescuerpo;
	}

	public String getNombreparcuerpo() {
		return this.nombreparcuerpo;
	}

	public void setNombreparcuerpo(String nombreparcuerpo) {
		this.nombreparcuerpo = nombreparcuerpo;
	}

}