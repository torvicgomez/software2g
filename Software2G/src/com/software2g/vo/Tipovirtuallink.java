package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the tipovirtuallink database table.
 * 
 */
@Entity
@Table(name="tipovirtuallink", schema="public")
public class Tipovirtuallink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOVIRTUALLINK_IDTIPOVIRTUALLINK_GENERATOR", sequenceName="PUBLIC.TIPOVIRTUALLINK_ID_TIPOVIRTUALLINK_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOVIRTUALLINK_IDTIPOVIRTUALLINK_GENERATOR")
	@Column(name="id_tipovirtuallink")
	private long idTipovirtuallink;

	private String abreviavirtual;

	private String descvirlink;

	private String nomtipovirtual;

	//bi-directional many-to-one association to Virtuallink
	@OneToMany(mappedBy="tipovirtuallink")
	private List<Virtuallink> virtuallinks;

	public Tipovirtuallink() {
	}

	public long getIdTipovirtuallink() {
		return this.idTipovirtuallink;
	}

	public void setIdTipovirtuallink(long idTipovirtuallink) {
		this.idTipovirtuallink = idTipovirtuallink;
	}

	public String getAbreviavirtual() {
		return this.abreviavirtual;
	}

	public void setAbreviavirtual(String abreviavirtual) {
		this.abreviavirtual = abreviavirtual;
	}

	public String getDescvirlink() {
		return this.descvirlink;
	}

	public void setDescvirlink(String descvirlink) {
		this.descvirlink = descvirlink;
	}

	public String getNomtipovirtual() {
		return this.nomtipovirtual;
	}

	public void setNomtipovirtual(String nomtipovirtual) {
		this.nomtipovirtual = nomtipovirtual;
	}

	public List<Virtuallink> getVirtuallinks() {
		return this.virtuallinks;
	}

	public void setVirtuallinks(List<Virtuallink> virtuallinks) {
		this.virtuallinks = virtuallinks;
	}

}