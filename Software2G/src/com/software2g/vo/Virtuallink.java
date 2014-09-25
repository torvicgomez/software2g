package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the virtuallink database table.
 * 
 */
@Entity
@Table(name="virtuallink", schema="public")
public class Virtuallink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VIRTUALLINK_IDVIRTUALLINK_GENERATOR", sequenceName="PUBLIC.VIRTUALLINK_ID_VIRTUALLINK_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VIRTUALLINK_IDVIRTUALLINK_GENERATOR")
	@Column(name="id_virtuallink")
	private long idVirtuallink;

	private String descvirtuallink;

	private String enlace;

	//bi-directional many-to-one association to Ubicacionvirtual
	@OneToMany(mappedBy="virtuallink")
	private List<Ubicacionvirtual> ubicacionvirtuals;

	//bi-directional many-to-one association to Tipovirtuallink
	@ManyToOne
	@JoinColumn(name="id_tipovirtuallink")
	private Tipovirtuallink tipovirtuallink;

	public Virtuallink() {
	}

	public long getIdVirtuallink() {
		return this.idVirtuallink;
	}

	public void setIdVirtuallink(long idVirtuallink) {
		this.idVirtuallink = idVirtuallink;
	}

	public String getDescvirtuallink() {
		return this.descvirtuallink;
	}

	public void setDescvirtuallink(String descvirtuallink) {
		this.descvirtuallink = descvirtuallink;
	}

	public String getEnlace() {
		return this.enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public List<Ubicacionvirtual> getUbicacionvirtuals() {
		return this.ubicacionvirtuals;
	}

	public void setUbicacionvirtuals(List<Ubicacionvirtual> ubicacionvirtuals) {
		this.ubicacionvirtuals = ubicacionvirtuals;
	}

	public Tipovirtuallink getTipovirtuallink() {
		return this.tipovirtuallink;
	}

	public void setTipovirtuallink(Tipovirtuallink tipovirtuallink) {
		this.tipovirtuallink = tipovirtuallink;
	}

}