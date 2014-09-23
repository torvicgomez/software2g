package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipodato database table.
 * 
 */
@Entity
public class Tipodato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPODATO_IDTIPODATO_GENERATOR", sequenceName="PUBLIC.TIPODATO_ID_TIPODATO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPODATO_IDTIPODATO_GENERATOR")
	@Column(name="id_tipodato")
	private long idTipodato;

	private String codigo;

	private String desctd;

	private String nombretdato;

	private String precision;

	private String tamano;

	//bi-directional many-to-one association to Variableexamen
	@OneToMany(mappedBy="tipodato")
	private List<Variableexamen> variableexamens;

	//bi-directional many-to-one association to Variableformulacion
	@OneToMany(mappedBy="tipodato")
	private List<Variableformulacion> variableformulacions;

	public Tipodato() {
	}

	public long getIdTipodato() {
		return this.idTipodato;
	}

	public void setIdTipodato(long idTipodato) {
		this.idTipodato = idTipodato;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDesctd() {
		return this.desctd;
	}

	public void setDesctd(String desctd) {
		this.desctd = desctd;
	}

	public String getNombretdato() {
		return this.nombretdato;
	}

	public void setNombretdato(String nombretdato) {
		this.nombretdato = nombretdato;
	}

	public String getPrecision() {
		return this.precision;
	}

	public void setPrecision(String precision) {
		this.precision = precision;
	}

	public String getTamano() {
		return this.tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public List<Variableexamen> getVariableexamens() {
		return this.variableexamens;
	}

	public void setVariableexamens(List<Variableexamen> variableexamens) {
		this.variableexamens = variableexamens;
	}

	public List<Variableformulacion> getVariableformulacions() {
		return this.variableformulacions;
	}

	public void setVariableformulacions(List<Variableformulacion> variableformulacions) {
		this.variableformulacions = variableformulacions;
	}

}