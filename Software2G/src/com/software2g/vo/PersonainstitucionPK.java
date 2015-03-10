package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the personainstitucion database table.
 * 
 */
@Embeddable
public class PersonainstitucionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_pers")
	private Integer idPers;

	@Column(name="id_inst")
	private Integer idInst;

	public PersonainstitucionPK() {
	}
	public Integer getIdPers() {
		return this.idPers;
	}
	public void setIdPers(Integer idPers) {
		this.idPers = idPers;
	}
	public Integer getIdInst() {
		return this.idInst;
	}
	public void setIdInst(Integer idInst) {
		this.idInst = idInst;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PersonainstitucionPK)) {
			return false;
		}
		PersonainstitucionPK castOther = (PersonainstitucionPK)other;
		return 
			this.idPers.equals(castOther.idPers)
			&& this.idInst.equals(castOther.idInst);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPers.hashCode();
		hash = hash * prime + this.idInst.hashCode();
		
		return hash; 
	} 
}