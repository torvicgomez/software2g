package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estadocivil database table.
 * 
 */
@Entity
@Table(schema="public", name="estadocivil")
public class Estadocivil implements Serializable {
	private static final long serialVersionUID = 1L;

	private String abreviaturaestciv;

	private String descestciv;

	@Id
	@SequenceGenerator(name="ESTADOCIVIL_IDESTADOCIVIL_GENERATOR", sequenceName="PUBLIC.estadocivil_id_estadocivil_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTADOCIVIL_IDESTADOCIVIL_GENERATOR")
	@Column(name="id_estadocivil")
	private long idEstadocivil;

	private String nombreestciv;

	public Estadocivil() {
	}

	public String getAbreviaturaestciv() {
		return this.abreviaturaestciv;
	}

	public void setAbreviaturaestciv(String abreviaturaestciv) {
		this.abreviaturaestciv = abreviaturaestciv;
	}

	public String getDescestciv() {
		return this.descestciv;
	}

	public void setDescestciv(String descestciv) {
		this.descestciv = descestciv;
	}

	public long getIdEstadocivil() {
		return this.idEstadocivil;
	}

	public void setIdEstadocivil(long idEstadocivil) {
		this.idEstadocivil = idEstadocivil;
	}

	public String getNombreestciv() {
		return this.nombreestciv;
	}

	public void setNombreestciv(String nombreestciv) {
		this.nombreestciv = nombreestciv;
	}

}