package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the anamnesis database table.
 * 
 */
@Entity
@Table(name="anamnesis", schema="public")
public class Anamnesi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="anamnesis")
	private String anamnesis;

	@Id
	@SequenceGenerator(name="ANAMNESIS_IDANAMNESIS_GENERATOR", sequenceName="PUBLIC.anamnesis_id_anamnesis_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ANAMNESIS_IDANAMNESIS_GENERATOR")
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