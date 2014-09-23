package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the anamnesis database table.
 * 
 */
@Entity
@Table(name="anamnesis")
public class Anamnesi implements Serializable {
	private static final long serialVersionUID = 1L;

	private String anamnesis;

	@Column(name="id_anamnesis")
	private long idAnamnesis;

	public Anamnesi() {
	}

	public String getAnamnesis() {
		return this.anamnesis;
	}

	public void setAnamnesis(String anamnesis) {
		this.anamnesis = anamnesis;
	}

	public long getIdAnamnesis() {
		return this.idAnamnesis;
	}

	public void setIdAnamnesis(long idAnamnesis) {
		this.idAnamnesis = idAnamnesis;
	}

}