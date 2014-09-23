package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sintomacomun database table.
 * 
 */
@Entity
public class Sintomacomun implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SINTOMACOMUN_IDSINTOMACOMUN_GENERATOR", sequenceName="PUBLIC.SINTOMACOMUN_ID_SINTOMACOMUN_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SINTOMACOMUN_IDSINTOMACOMUN_GENERATOR")
	@Column(name="id_sintomacomun")
	private long idSintomacomun;

	private String abreviasintcomun;

	private String descsintcomun;

	private String nomsintcomun;

	//bi-directional many-to-one association to Tipoespecialidad
	@ManyToOne
	@JoinColumn(name="id_tipoconsulta")
	private Tipoespecialidad tipoespecialidad;

	//bi-directional many-to-one association to Sintoma
	@OneToMany(mappedBy="sintomacomun")
	private List<Sintoma> sintomas;

	public Sintomacomun() {
	}

	public long getIdSintomacomun() {
		return this.idSintomacomun;
	}

	public void setIdSintomacomun(long idSintomacomun) {
		this.idSintomacomun = idSintomacomun;
	}

	public String getAbreviasintcomun() {
		return this.abreviasintcomun;
	}

	public void setAbreviasintcomun(String abreviasintcomun) {
		this.abreviasintcomun = abreviasintcomun;
	}

	public String getDescsintcomun() {
		return this.descsintcomun;
	}

	public void setDescsintcomun(String descsintcomun) {
		this.descsintcomun = descsintcomun;
	}

	public String getNomsintcomun() {
		return this.nomsintcomun;
	}

	public void setNomsintcomun(String nomsintcomun) {
		this.nomsintcomun = nomsintcomun;
	}

	public Tipoespecialidad getTipoespecialidad() {
		return this.tipoespecialidad;
	}

	public void setTipoespecialidad(Tipoespecialidad tipoespecialidad) {
		this.tipoespecialidad = tipoespecialidad;
	}

	public List<Sintoma> getSintomas() {
		return this.sintomas;
	}

	public void setSintomas(List<Sintoma> sintomas) {
		this.sintomas = sintomas;
	}

}