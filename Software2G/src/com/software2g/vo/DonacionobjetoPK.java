package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the donacionobjeto database table.
 * 
 */
@Embeddable
public class DonacionobjetoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="obje_id")
	private long objeId;

	@Column(name="dona_id")
	private long donaId;

	public DonacionobjetoPK() {
	}
	public long getObjeId() {
		return this.objeId;
	}
	public void setObjeId(long objeId) {
		this.objeId = objeId;
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
		if (!(other instanceof DonacionobjetoPK)) {
			return false;
		}
		DonacionobjetoPK castOther = (DonacionobjetoPK)other;
		return 
			(this.objeId == castOther.objeId)
			&& (this.donaId == castOther.donaId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.objeId ^ (this.objeId >>> 32)));
		hash = hash * prime + ((int) (this.donaId ^ (this.donaId >>> 32)));
		
		return hash;
	}
}