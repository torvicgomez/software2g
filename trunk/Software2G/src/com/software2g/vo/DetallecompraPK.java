package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detallecompra database table.
 * 
 */
@Embeddable
public class DetallecompraPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="arti_id")
	private long artiId;

	@Column(name="orco_id")
	private long orcoId;

	public DetallecompraPK() {
	}
	public long getArtiId() {
		return this.artiId;
	}
	public void setArtiId(long artiId) {
		this.artiId = artiId;
	}
	public long getOrcoId() {
		return this.orcoId;
	}
	public void setOrcoId(long orcoId) {
		this.orcoId = orcoId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetallecompraPK)) {
			return false;
		}
		DetallecompraPK castOther = (DetallecompraPK)other;
		return 
			(this.artiId == castOther.artiId)
			&& (this.orcoId == castOther.orcoId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.artiId ^ (this.artiId >>> 32)));
		hash = hash * prime + ((int) (this.orcoId ^ (this.orcoId >>> 32)));
		
		return hash;
	}
}