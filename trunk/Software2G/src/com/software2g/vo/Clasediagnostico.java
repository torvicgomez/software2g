package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the clasediagnostico database table.
 * 
 */
@Entity
public class Clasediagnostico implements Serializable {
	private static final long serialVersionUID = 1L;

	private String abreviaturaclasedx;

	private String descclasedx;

	@Column(name="id_clasediagnostico")
	private long idClasediagnostico;

	private String nombreclasedx;

	public Clasediagnostico() {
	}

	public String getAbreviaturaclasedx() {
		return this.abreviaturaclasedx;
	}

	public void setAbreviaturaclasedx(String abreviaturaclasedx) {
		this.abreviaturaclasedx = abreviaturaclasedx;
	}

	public String getDescclasedx() {
		return this.descclasedx;
	}

	public void setDescclasedx(String descclasedx) {
		this.descclasedx = descclasedx;
	}

	public long getIdClasediagnostico() {
		return this.idClasediagnostico;
	}

	public void setIdClasediagnostico(long idClasediagnostico) {
		this.idClasediagnostico = idClasediagnostico;
	}

	public String getNombreclasedx() {
		return this.nombreclasedx;
	}

	public void setNombreclasedx(String nombreclasedx) {
		this.nombreclasedx = nombreclasedx;
	}

}