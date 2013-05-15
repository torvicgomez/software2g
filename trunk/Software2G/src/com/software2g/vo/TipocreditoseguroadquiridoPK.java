package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tipocreditoseguroadquirido database table.
 * 
 */
@Embeddable
public class TipocreditoseguroadquiridoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ticr_id")
	private long ticrId;

	@Column(name="segu_id")
	private long seguId;

	public TipocreditoseguroadquiridoPK() {
	}
	public long getTicrId() {
		return this.ticrId;
	}
	public void setTicrId(long ticrId) {
		this.ticrId = ticrId;
	}
	public long getSeguId() {
		return this.seguId;
	}
	public void setSeguId(long seguId) {
		this.seguId = seguId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TipocreditoseguroadquiridoPK)) {
			return false;
		}
		TipocreditoseguroadquiridoPK castOther = (TipocreditoseguroadquiridoPK)other;
		return 
			(this.ticrId == castOther.ticrId)
			&& (this.seguId == castOther.seguId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.ticrId ^ (this.ticrId >>> 32)));
		hash = hash * prime + ((int) (this.seguId ^ (this.seguId >>> 32)));
		
		return hash;
	}
}