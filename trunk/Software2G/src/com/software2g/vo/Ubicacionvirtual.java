package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ubicacionvirtual database table.
 * 
 */
@Entity
public class Ubicacionvirtual implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UBICACIONVIRTUAL_IDUBICACIONVIRTUAL_GENERATOR", sequenceName="PUBLIC.UBICACIONVIRTUAL_ID_UBICACIONVIRTUAL_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UBICACIONVIRTUAL_IDUBICACIONVIRTUAL_GENERATOR")
	@Column(name="id_ubicacionvirtual")
	private long idUbicacionvirtual;

	@Column(name="id_institucion")
	private long idInstitucion;

	@Column(name="id_persona")
	private long idPersona;

	//bi-directional many-to-one association to Virtuallink
	@ManyToOne
	@JoinColumn(name="id_virtuallink")
	private Virtuallink virtuallink;

	public Ubicacionvirtual() {
	}

	public long getIdUbicacionvirtual() {
		return this.idUbicacionvirtual;
	}

	public void setIdUbicacionvirtual(long idUbicacionvirtual) {
		this.idUbicacionvirtual = idUbicacionvirtual;
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

	public Virtuallink getVirtuallink() {
		return this.virtuallink;
	}

	public void setVirtuallink(Virtuallink virtuallink) {
		this.virtuallink = virtuallink;
	}

}