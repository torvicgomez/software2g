package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the tipodocumentoinst database table.
 * 
 */
@Entity
@Table(name="tipodocumentoinst", schema="public")
public class Tipodocumentoinst implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPODOCUMENTOINST_IDTIPODOCINST_GENERATOR", sequenceName="PUBLIC.TIPODOCUMENTOINST_ID_TIPODOCINST_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPODOCUMENTOINST_IDTIPODOCINST_GENERATOR")
	@Column(name="id_tipodocinst")
	private long idTipodocinst;

	private String abreviaturatipinst;

	private String desctipinst;

	private String nombretipinst;

	//bi-directional many-to-one association to Institucion
	@OneToMany(mappedBy="tipodocumentoinst")
	private List<Institucion> institucions;

	public Tipodocumentoinst() {
	}

	public long getIdTipodocinst() {
		return this.idTipodocinst;
	}

	public void setIdTipodocinst(long idTipodocinst) {
		this.idTipodocinst = idTipodocinst;
	}

	public String getAbreviaturatipinst() {
		return this.abreviaturatipinst;
	}

	public void setAbreviaturatipinst(String abreviaturatipinst) {
		this.abreviaturatipinst = abreviaturatipinst;
	}

	public String getDesctipinst() {
		return this.desctipinst;
	}

	public void setDesctipinst(String desctipinst) {
		this.desctipinst = desctipinst;
	}

	public String getNombretipinst() {
		return this.nombretipinst;
	}

	public void setNombretipinst(String nombretipinst) {
		this.nombretipinst = nombretipinst;
	}

	public List<Institucion> getInstitucions() {
		return this.institucions;
	}

	public void setInstitucions(List<Institucion> institucions) {
		this.institucions = institucions;
	}

}