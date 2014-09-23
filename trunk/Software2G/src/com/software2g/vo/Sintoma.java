package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sintomas database table.
 * 
 */
@Entity
@Table(name="sintomas")
public class Sintoma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SINTOMAS_IDSINTOMA_GENERATOR", sequenceName="PUBLIC.SINTOMAS_ID_SINTOMA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SINTOMAS_IDSINTOMA_GENERATOR")
	@Column(name="id_sintoma")
	private long idSintoma;

	private String descsintoma;

	@Column(name="id_anamnesis")
	private long idAnamnesis;

	//bi-directional many-to-one association to Frecuencia
	@ManyToOne
	@JoinColumn(name="id_frecuencia")
	private Frecuencia frecuencia;

	//bi-directional many-to-one association to Sintomacomun
	@ManyToOne
	@JoinColumn(name="id_sintomacomun")
	private Sintomacomun sintomacomun;

	public Sintoma() {
	}

	public long getIdSintoma() {
		return this.idSintoma;
	}

	public void setIdSintoma(long idSintoma) {
		this.idSintoma = idSintoma;
	}

	public String getDescsintoma() {
		return this.descsintoma;
	}

	public void setDescsintoma(String descsintoma) {
		this.descsintoma = descsintoma;
	}

	public long getIdAnamnesis() {
		return this.idAnamnesis;
	}

	public void setIdAnamnesis(long idAnamnesis) {
		this.idAnamnesis = idAnamnesis;
	}

	public Frecuencia getFrecuencia() {
		return this.frecuencia;
	}

	public void setFrecuencia(Frecuencia frecuencia) {
		this.frecuencia = frecuencia;
	}

	public Sintomacomun getSintomacomun() {
		return this.sintomacomun;
	}

	public void setSintomacomun(Sintomacomun sintomacomun) {
		this.sintomacomun = sintomacomun;
	}

}