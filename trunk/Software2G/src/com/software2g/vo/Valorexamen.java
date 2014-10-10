package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the valorexamen database table.
 * 
 */
@Entity
@Table(name="valorexamen", schema="public")
public class Valorexamen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_varexamen")
	private Long idVarexamen;

	@Column(name="vaex_id")
	private long vaexId;

	private String valorexamen;

	@Column(name="valx_orden")
	private int valxOrden;

	public Valorexamen() { 
	}

	public Long getIdVarexamen() {
		return this.idVarexamen;
	}

	public void setIdVarexamen(Long idVarexamen) {
		this.idVarexamen = idVarexamen;
	}

	public long getVaexId() {
		return this.vaexId;
	}

	public void setVaexId(long vaexId) {
		this.vaexId = vaexId;
	}

	public String getValorexamen() {
		return this.valorexamen;
	}

	public void setValorexamen(String valorexamen) {
		this.valorexamen = valorexamen;
	}

	public int getValxOrden() {
		return this.valxOrden;
	}

	public void setValxOrden(int valxOrden) {
		this.valxOrden = valxOrden;
	}

}