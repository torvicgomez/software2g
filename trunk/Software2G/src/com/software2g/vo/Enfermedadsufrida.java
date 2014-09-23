package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the enfermedadsufrida database table.
 * 
 */
@Entity
public class Enfermedadsufrida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENFERMEDADSUFRIDA_IDENFERMEDADSUFRIDA_GENERATOR", sequenceName="PUBLIC.ENFERMEDADSUFRIDA_ID_ENFERMEDADSUFRIDA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENFERMEDADSUFRIDA_IDENFERMEDADSUFRIDA_GENERATOR")
	@Column(name="id_enfermedadsufrida")
	private long idEnfermedadsufrida;

	private String abreviaenfersufri;

	private String codigoenfersufri;

	private String descenfersufri;

	@Column(name="id_anamnesis")
	private long idAnamnesis;

	private String nomenfermsufrida;

	public Enfermedadsufrida() {
	}

	public long getIdEnfermedadsufrida() {
		return this.idEnfermedadsufrida;
	}

	public void setIdEnfermedadsufrida(long idEnfermedadsufrida) {
		this.idEnfermedadsufrida = idEnfermedadsufrida;
	}

	public String getAbreviaenfersufri() {
		return this.abreviaenfersufri;
	}

	public void setAbreviaenfersufri(String abreviaenfersufri) {
		this.abreviaenfersufri = abreviaenfersufri;
	}

	public String getCodigoenfersufri() {
		return this.codigoenfersufri;
	}

	public void setCodigoenfersufri(String codigoenfersufri) {
		this.codigoenfersufri = codigoenfersufri;
	}

	public String getDescenfersufri() {
		return this.descenfersufri;
	}

	public void setDescenfersufri(String descenfersufri) {
		this.descenfersufri = descenfersufri;
	}

	public long getIdAnamnesis() {
		return this.idAnamnesis;
	}

	public void setIdAnamnesis(long idAnamnesis) {
		this.idAnamnesis = idAnamnesis;
	}

	public String getNomenfermsufrida() {
		return this.nomenfermsufrida;
	}

	public void setNomenfermsufrida(String nomenfermsufrida) {
		this.nomenfermsufrida = nomenfermsufrida;
	}

}