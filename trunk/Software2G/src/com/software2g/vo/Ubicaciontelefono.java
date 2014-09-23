package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ubicaciontelefono database table.
 * 
 */
@Entity
public class Ubicaciontelefono implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UBICACIONTELEFONO_IDUBICACIONTEL_GENERATOR", sequenceName="PUBLIC.UBICACIONTELEFONO_ID_UBICACIONTEL_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UBICACIONTELEFONO_IDUBICACIONTEL_GENERATOR")
	@Column(name="id_ubicaciontel")
	private long idUbicaciontel;

	@Column(name="id_institucion")
	private long idInstitucion;

	@Column(name="id_persona")
	private long idPersona;

	//bi-directional many-to-one association to Telefono
	@ManyToOne
	@JoinColumn(name="id_telefono")
	private Telefono telefono;

	public Ubicaciontelefono() {
	}

	public long getIdUbicaciontel() {
		return this.idUbicaciontel;
	}

	public void setIdUbicaciontel(long idUbicaciontel) {
		this.idUbicaciontel = idUbicaciontel;
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

	public Telefono getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}

}