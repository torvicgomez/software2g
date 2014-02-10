package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rolusuario database table.
 * 
 */
@Embeddable
public class RolusuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_rol")
	private Integer idRol;

	@Column(name="login_usua")
	private String loginUsua;

	public RolusuarioPK() {
	}
	public Integer getIdRol() {
		return this.idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	public String getLoginUsua() {
		return this.loginUsua;
	}
	public void setLoginUsua(String loginUsua) {
		this.loginUsua = loginUsua;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RolusuarioPK)) {
			return false;
		}
		RolusuarioPK castOther = (RolusuarioPK)other;
		return 
			this.idRol.equals(castOther.idRol)
			&& this.loginUsua.equals(castOther.loginUsua);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idRol.hashCode();
		hash = hash * prime + this.loginUsua.hashCode();
		
		return hash;
	}
}