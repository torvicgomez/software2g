package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the donacionsucursal database table.
 * 
 */
@Embeddable
public class DonacionsucursalPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="sucu_id")
	private long sucuId;

	@Column(name="dona_id")
	private long donaId;

	public DonacionsucursalPK() {
	}
	public long getSucuId() {
		return this.sucuId;
	}
	public void setSucuId(long sucuId) {
		this.sucuId = sucuId;
	}
	public long getDonaId() {
		return this.donaId;
	}
	public void setDonaId(long donaId) {
		this.donaId = donaId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DonacionsucursalPK)) {
			return false;
		}
		DonacionsucursalPK castOther = (DonacionsucursalPK)other;
		return 
			(this.sucuId == castOther.sucuId)
			&& (this.donaId == castOther.donaId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.sucuId ^ (this.sucuId >>> 32)));
		hash = hash * prime + ((int) (this.donaId ^ (this.donaId >>> 32)));
		
		return hash;
	}
}