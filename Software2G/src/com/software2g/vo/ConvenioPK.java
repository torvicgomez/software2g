package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the convenio database table.
 * 
 */
@Embeddable
public class ConvenioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_seguridad")
	private Long idSeguridad;

	@Column(name="id_institucion")
	private Long idInstitucion;

	public ConvenioPK() {
	}
	public Long getIdSeguridad() {
		return this.idSeguridad;
	}
	public void setIdSeguridad(Long idSeguridad) {
		this.idSeguridad = idSeguridad;
	}
	public Long getIdInstitucion() {
		return this.idInstitucion;
	}
	public void setIdInstitucion(Long idInstitucion) {
		this.idInstitucion = idInstitucion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ConvenioPK)) {
			return false;
		}
		ConvenioPK castOther = (ConvenioPK)other;
		return 
			this.idSeguridad.equals(castOther.idSeguridad)
			&& this.idInstitucion.equals(castOther.idInstitucion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idSeguridad.hashCode();
		hash = hash * prime + this.idInstitucion.hashCode();
		
		return hash;
	}
}