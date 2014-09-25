package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ubicaciondireccion database table.
 * 
 */
@Entity
@Table(name="ubicaciondireccion", schema="public")
public class Ubicaciondireccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UBICACIONDIRECCION_IDUBICACIONDIRECCION_GENERATOR", sequenceName="PUBLIC.UBICACIONDIRECCION_ID_UBICACIONDIRECCION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UBICACIONDIRECCION_IDUBICACIONDIRECCION_GENERATOR")
	@Column(name="id_ubicaciondireccion")
	private long idUbicaciondireccion;

	@Column(name="id_direccion")
	private long idDireccion;

	@Column(name="id_institucion")
	private long idInstitucion;

	@Column(name="id_persona")
	private long idPersona;

	public Ubicaciondireccion() {
	}

	public long getIdUbicaciondireccion() {
		return this.idUbicaciondireccion;
	}

	public void setIdUbicaciondireccion(long idUbicaciondireccion) {
		this.idUbicaciondireccion = idUbicaciondireccion;
	}

	public long getIdDireccion() {
		return this.idDireccion;
	}

	public void setIdDireccion(long idDireccion) {
		this.idDireccion = idDireccion;
	}

	public long getIdInstitucion() {
		return this.idInstitucion;
	}

	public void setIdInstitucion(long idInstitucion) {
		this.idInstitucion = idInstitucion;
	}

	public long getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}

}