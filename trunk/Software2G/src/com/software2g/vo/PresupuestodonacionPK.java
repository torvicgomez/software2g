package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the presupuestodonacion database table.
 * 
 */
@Embeddable
public class PresupuestodonacionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pres_id")
	private long presId;

	@Column(name="dona_id")
	private long donaId;

	public PresupuestodonacionPK() {
	}
	public long getPresId() {
		return this.presId;
	}
	public void setPresId(long presId) {
		this.presId = presId;
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
		if (!(other instanceof PresupuestodonacionPK)) {
			return false;
		}
		PresupuestodonacionPK castOther = (PresupuestodonacionPK)other;
		return 
			(this.presId == castOther.presId)
			&& (this.donaId == castOther.donaId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.presId ^ (this.presId >>> 32)));
		hash = hash * prime + ((int) (this.donaId ^ (this.donaId >>> 32)));
		
		return hash;
	}
}