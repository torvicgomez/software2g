package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pais database table.
 * 
 */
@Entity
@Table(name="pais")
public class Pai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="id_pais")
	private long idPais;

	private String nompais;

	public Pai() {
	}

	public long getIdPais() {
		return this.idPais;
	}

	public void setIdPais(long idPais) {
		this.idPais = idPais;
	}

	public String getNompais() {
		return this.nompais;
	}

	public void setNompais(String nompais) {
		this.nompais = nompais;
	}

}