package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the credito database table.
 * 
 */
@Embeddable
public class CreditoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cred_id")
	private long credId;

	@Column(name="paga_id")
	private long pagaId;

	public CreditoPK() {
	}
	public long getCredId() {
		return this.credId;
	}
	public void setCredId(long credId) {
		this.credId = credId;
	}
	public long getPagaId() {
		return this.pagaId;
	}
	public void setPagaId(long pagaId) {
		this.pagaId = pagaId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CreditoPK)) {
			return false;
		}
		CreditoPK castOther = (CreditoPK)other;
		return 
			(this.credId == castOther.credId)
			&& (this.pagaId == castOther.pagaId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.credId ^ (this.credId >>> 32)));
		hash = hash * prime + ((int) (this.pagaId ^ (this.pagaId >>> 32)));
		
		return hash;
	}
}