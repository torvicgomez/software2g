package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipoespecialidad database table.
 * 
 */
@Entity
public class Tipoespecialidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOESPECIALIDAD_IDTIPOCONSULTA_GENERATOR", sequenceName="PUBLIC.TIPOESPECIALIDAD_ID_TIPOCONSULTA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOESPECIALIDAD_IDTIPOCONSULTA_GENERATOR")
	@Column(name="id_tipoconsulta")
	private long idTipoconsulta;

	private String abreviatipocons;

	private String desctipocons;

	private String nomtipocons;

	//bi-directional many-to-one association to Codigoenfermedade
	@OneToMany(mappedBy="tipoespecialidad")
	private List<Codigoenfermedade> codigoenfermedades;

	//bi-directional many-to-one association to Consulta
	@OneToMany(mappedBy="tipoespecialidad")
	private List<Consulta> consultas;

	//bi-directional many-to-one association to Especificacionformula
	@OneToMany(mappedBy="tipoespecialidad")
	private List<Especificacionformula> especificacionformulas;

	//bi-directional many-to-one association to Especificaexamen
	@OneToMany(mappedBy="tipoespecialidad")
	private List<Especificaexamen> especificaexamens;

	//bi-directional many-to-one association to Listaexamenconsulta
	@OneToMany(mappedBy="tipoespecialidad")
	private List<Listaexamenconsulta> listaexamenconsultas;

	//bi-directional many-to-many association to Profesional
	@ManyToMany
	@JoinTable(
		name="profetipoespecialidad"
		, joinColumns={
			@JoinColumn(name="id_tipoconsulta")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_profesional")
			}
		)
	private List<Profesional> profesionals;

	//bi-directional many-to-one association to Sintomacomun
	@OneToMany(mappedBy="tipoespecialidad")
	private List<Sintomacomun> sintomacomuns;

	public Tipoespecialidad() {
	}

	public long getIdTipoconsulta() {
		return this.idTipoconsulta;
	}

	public void setIdTipoconsulta(long idTipoconsulta) {
		this.idTipoconsulta = idTipoconsulta;
	}

	public String getAbreviatipocons() {
		return this.abreviatipocons;
	}

	public void setAbreviatipocons(String abreviatipocons) {
		this.abreviatipocons = abreviatipocons;
	}

	public String getDesctipocons() {
		return this.desctipocons;
	}

	public void setDesctipocons(String desctipocons) {
		this.desctipocons = desctipocons;
	}

	public String getNomtipocons() {
		return this.nomtipocons;
	}

	public void setNomtipocons(String nomtipocons) {
		this.nomtipocons = nomtipocons;
	}

	public List<Codigoenfermedade> getCodigoenfermedades() {
		return this.codigoenfermedades;
	}

	public void setCodigoenfermedades(List<Codigoenfermedade> codigoenfermedades) {
		this.codigoenfermedades = codigoenfermedades;
	}

	public List<Consulta> getConsultas() {
		return this.consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public List<Especificacionformula> getEspecificacionformulas() {
		return this.especificacionformulas;
	}

	public void setEspecificacionformulas(List<Especificacionformula> especificacionformulas) {
		this.especificacionformulas = especificacionformulas;
	}

	public List<Especificaexamen> getEspecificaexamens() {
		return this.especificaexamens;
	}

	public void setEspecificaexamens(List<Especificaexamen> especificaexamens) {
		this.especificaexamens = especificaexamens;
	}

	public List<Listaexamenconsulta> getListaexamenconsultas() {
		return this.listaexamenconsultas;
	}

	public void setListaexamenconsultas(List<Listaexamenconsulta> listaexamenconsultas) {
		this.listaexamenconsultas = listaexamenconsultas;
	}

	public List<Profesional> getProfesionals() {
		return this.profesionals;
	}

	public void setProfesionals(List<Profesional> profesionals) {
		this.profesionals = profesionals;
	}

	public List<Sintomacomun> getSintomacomuns() {
		return this.sintomacomuns;
	}

	public void setSintomacomuns(List<Sintomacomun> sintomacomuns) {
		this.sintomacomuns = sintomacomuns;
	}

}