package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the unidades database table.
 * 
 */
@Entity
@Table(name="unidades", schema="public")
public class Unidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UNIDADES_IDUNIDAD_GENERATOR", sequenceName="PUBLIC.UNIDADES_ID_UNIDAD_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UNIDADES_IDUNIDAD_GENERATOR")
	@Column(name="id_unidad")
	private long idUnidad;

	private String descunidad;

	private String nomunidad;

	private String siglaunidad;

	//bi-directional many-to-one association to Registroexamen
	@OneToMany(mappedBy="unidade")
	private List<Registroexamen> registroexamens;

	//bi-directional many-to-one association to Registroformulacion
	@OneToMany(mappedBy="unidade")
	private List<Registroformulacion> registroformulacions;

	//bi-directional many-to-many association to Variableformulacion
	@ManyToMany(mappedBy="unidades")
	private List<Variableformulacion> variableformulacions;

	//bi-directional many-to-many association to Variableexamen
	@ManyToMany(mappedBy="unidades")
	private List<Variableexamen> variableexamens;

	public Unidade() {
	}

	public long getIdUnidad() {
		return this.idUnidad;
	}

	public void setIdUnidad(long idUnidad) {
		this.idUnidad = idUnidad;
	}

	public String getDescunidad() {
		return this.descunidad;
	}

	public void setDescunidad(String descunidad) {
		this.descunidad = descunidad;
	}

	public String getNomunidad() {
		return this.nomunidad;
	}

	public void setNomunidad(String nomunidad) {
		this.nomunidad = nomunidad;
	}

	public String getSiglaunidad() {
		return this.siglaunidad;
	}

	public void setSiglaunidad(String siglaunidad) {
		this.siglaunidad = siglaunidad;
	}

	public List<Registroexamen> getRegistroexamens() {
		return this.registroexamens;
	}

	public void setRegistroexamens(List<Registroexamen> registroexamens) {
		this.registroexamens = registroexamens;
	}

	public List<Registroformulacion> getRegistroformulacions() {
		return this.registroformulacions;
	}

	public void setRegistroformulacions(List<Registroformulacion> registroformulacions) {
		this.registroformulacions = registroformulacions;
	}

	public List<Variableformulacion> getVariableformulacions() {
		return this.variableformulacions;
	}

	public void setVariableformulacions(List<Variableformulacion> variableformulacions) {
		this.variableformulacions = variableformulacions;
	}

	public List<Variableexamen> getVariableexamens() {
		return this.variableexamens;
	}

	public void setVariableexamens(List<Variableexamen> variableexamens) {
		this.variableexamens = variableexamens;
	}

}