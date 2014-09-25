package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the convenio database table.
 * 
 */
@Entity
@Table(name="convenio", schema="public")
public class Convenio implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConvenioPK id;

	//bi-directional many-to-one association to Seguridadsocial
	@ManyToOne
	@JoinColumn(name="id_seguridad", insertable=false, updatable=false)
	private Seguridadsocial seguridadsocial;

	public Convenio() {
	}

	public ConvenioPK getId() {
		return this.id;
	}

	public void setId(ConvenioPK id) {
		this.id = id;
	}

	public Seguridadsocial getSeguridadsocial() {
		return this.seguridadsocial;
	}

	public void setSeguridadsocial(Seguridadsocial seguridadsocial) {
		this.seguridadsocial = seguridadsocial;
	}

}