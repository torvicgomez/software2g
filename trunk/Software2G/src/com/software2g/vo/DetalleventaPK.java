package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detalleventa database table.
 * 
 */
@Embeddable
public class DetalleventaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="vent_id")
	private long ventId;

	@Column(name="arti_id")
	private long artiId;

	public DetalleventaPK() {
	}
	public DetalleventaPK(long ventId, long artiId) {
		this.ventId = ventId;
		this.artiId = artiId;
	}
	public long getVentId() {
		return this.ventId;
	}
	public void setVentId(long ventId) {
		this.ventId = ventId;
	}
	public long getArtiId() {
		return this.artiId;
	}
	public void setArtiId(long artiId) {
		this.artiId = artiId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetalleventaPK)) {
			return false;
		}
		DetalleventaPK castOther = (DetalleventaPK)other;
		return 
			(this.ventId == castOther.ventId)
			&& (this.artiId == castOther.artiId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.ventId ^ (this.ventId >>> 32)));
		hash = hash * prime + ((int) (this.artiId ^ (this.artiId >>> 32)));
		
		return hash;
	}
}