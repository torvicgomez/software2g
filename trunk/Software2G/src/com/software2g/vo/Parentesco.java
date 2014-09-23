package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the parentesco database table.
 * 
 */
@Entity
public class Parentesco implements Serializable {
	private static final long serialVersionUID = 1L;

	private String descparent;

	@Column(name="id_parentesco")
	private long idParentesco;

	private String nomparentesco;

	private String siglaparentesco;

	public Parentesco() {
	}

	public String getDescparent() {
		return this.descparent;
	}

	public void setDescparent(String descparent) {
		this.descparent = descparent;
	}

	public long getIdParentesco() {
		return this.idParentesco;
	}

	public void setIdParentesco(long idParentesco) {
		this.idParentesco = idParentesco;
	}

	public String getNomparentesco() {
		return this.nomparentesco;
	}

	public void setNomparentesco(String nomparentesco) {
		this.nomparentesco = nomparentesco;
	}

	public String getSiglaparentesco() {
		return this.siglaparentesco;
	}

	public void setSiglaparentesco(String siglaparentesco) {
		this.siglaparentesco = siglaparentesco;
	}

}