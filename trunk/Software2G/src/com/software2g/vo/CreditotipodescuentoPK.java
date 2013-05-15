package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the creditotipodescuento database table.
 * 
 */
@Embeddable
public class CreditotipodescuentoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cred_id")
	private long credId;

	@Column(name="tide_id")
	private long tideId;

	public CreditotipodescuentoPK() {
	}
	public long getCredId() {
		return this.credId;
	}
	public void setCredId(long credId) {
		this.credId = credId;
	}
	public long getTideId() {
		return this.tideId;
	}
	public void setTideId(long tideId) {
		this.tideId = tideId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CreditotipodescuentoPK)) {
			return false;
		}
		CreditotipodescuentoPK castOther = (CreditotipodescuentoPK)other;
		return 
			(this.credId == castOther.credId)
			&& (this.tideId == castOther.tideId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.credId ^ (this.credId >>> 32)));
		hash = hash * prime + ((int) (this.tideId ^ (this.tideId >>> 32)));
		
		return hash;
	}
}