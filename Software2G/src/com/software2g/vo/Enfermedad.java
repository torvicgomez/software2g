package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the enfermedad database table.
 * 
 */
@Entity
@Table(name="enfermedad", schema="public")
public class Enfermedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENFERMEDAD_IDENFERMEDAD_GENERATOR", sequenceName="PUBLIC.ENFERMEDAD_ID_ENFERMEDAD_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENFERMEDAD_IDENFERMEDAD_GENERATOR")
	@Column(name="id_enfermedad")
	private long idEnfermedad;

	private String abreviaenfermedad;

	private String codigoenfermedad;

	private String descenfermedad;

	private String nomenfermedad;

	public Enfermedad() {
	}

	public long getIdEnfermedad() {
		return this.idEnfermedad;
	}

	public void setIdEnfermedad(long idEnfermedad) {
		this.idEnfermedad = idEnfermedad;
	}

	public String getAbreviaenfermedad() {
		return this.abreviaenfermedad;
	}

	public void setAbreviaenfermedad(String abreviaenfermedad) {
		this.abreviaenfermedad = abreviaenfermedad;
	}

	public String getCodigoenfermedad() {
		return this.codigoenfermedad;
	}

	public void setCodigoenfermedad(String codigoenfermedad) {
		this.codigoenfermedad = codigoenfermedad;
	}

	public String getDescenfermedad() {
		return this.descenfermedad;
	}

	public void setDescenfermedad(String descenfermedad) {
		this.descenfermedad = descenfermedad;
	}

	public String getNomenfermedad() {
		return this.nomenfermedad;
	}

	public void setNomenfermedad(String nomenfermedad) {
		this.nomenfermedad = nomenfermedad;
	}

}