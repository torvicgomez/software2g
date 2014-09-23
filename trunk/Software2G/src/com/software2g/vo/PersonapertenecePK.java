package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the personapertenece database table.
 * 
 */
@Embeddable
public class PersonapertenecePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_persona")
	private Long idPersona;

	@Column(name="id_institucion")
	private Long idInstitucion;

	public PersonapertenecePK() {
	}
	public Long getIdPersona() {
		return this.idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
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
		if (!(other instanceof PersonapertenecePK)) {
			return false;
		}
		PersonapertenecePK castOther = (PersonapertenecePK)other;
		return 
			this.idPersona.equals(castOther.idPersona)
			&& this.idInstitucion.equals(castOther.idInstitucion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPersona.hashCode();
		hash = hash * prime + this.idInstitucion.hashCode();
		
		return hash;
	}
}