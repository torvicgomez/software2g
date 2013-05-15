package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the funcionalidadrol database table.
 * 
 */
@Embeddable
public class FuncionalidadrolPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_func")
	private Integer idFunc;

	@Column(name="id_rol")
	private Integer idRol;

	public FuncionalidadrolPK() {
	}
	public Integer getIdFunc() {
		return this.idFunc;
	}
	public void setIdFunc(Integer idFunc) {
		this.idFunc = idFunc;
	}
	public Integer getIdRol() {
		return this.idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FuncionalidadrolPK)) {
			return false;
		}
		FuncionalidadrolPK castOther = (FuncionalidadrolPK)other;
		return 
			this.idFunc.equals(castOther.idFunc)
			&& this.idRol.equals(castOther.idRol);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idFunc.hashCode();
		hash = hash * prime + this.idRol.hashCode();
		
		return hash;
	}
}