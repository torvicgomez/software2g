package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the funcionalidad database table.
 * 
 */
@Entity
@Table(schema="portal", name="funcionalidad")
public class Funcionalidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FUNCIONALIDAD_IDFUNC_GENERATOR", sequenceName="PORTAL.SEQ_FUNCIONALIDAD")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FUNCIONALIDAD_IDFUNC_GENERATOR")
	@Column(name="id_func")
	private Integer idFunc;

	@Column(name="descripcion_func")
	private String descripcionFunc;

	@Column(name="estado_func")
	private String estadoFunc;

	@Column(name="etiqueta_func")
	private String etiquetaFunc;

	private String fechacambio;

	private String horacambio;

	@Column(name="nombre_func")
	private String nombreFunc;

	private String registradopor;

	@Column(name="url_func")
	private String urlFunc;

	//bi-directional many-to-one association to Aplicacion
	@ManyToOne
	@JoinColumn(name="id_apli")
	private Aplicacion aplicacion;

	//bi-directional many-to-one association to Funcionalidad
	@ManyToOne
	@JoinColumn(name="id_func_padre")
	private Funcionalidad funcionalidad;

	//bi-directional many-to-one association to Funcionalidad
	@OneToMany(mappedBy="funcionalidad")
	private List<Funcionalidad> funcionalidads;

	//bi-directional many-to-one association to Funcionalidadrol
	@OneToMany(mappedBy="funcionalidad")
	private List<Funcionalidadrol> funcionalidadrols;

	public Funcionalidad() {
	}

	public Integer getIdFunc() {
		return this.idFunc;
	}

	public void setIdFunc(Integer idFunc) {
		this.idFunc = idFunc;
	}

	public String getDescripcionFunc() {
		return this.descripcionFunc;
	}

	public void setDescripcionFunc(String descripcionFunc) {
		this.descripcionFunc = descripcionFunc;
	}

	public String getEstadoFunc() {
		return this.estadoFunc;
	}

	public void setEstadoFunc(String estadoFunc) {
		this.estadoFunc = estadoFunc;
	}

	public String getEtiquetaFunc() {
		return this.etiquetaFunc;
	}

	public void setEtiquetaFunc(String etiquetaFunc) {
		this.etiquetaFunc = etiquetaFunc;
	}

	public String getFechacambio() {
		return this.fechacambio;
	}

	public void setFechacambio(String fechacambio) {
		this.fechacambio = fechacambio;
	}

	public String getHoracambio() {
		return this.horacambio;
	}

	public void setHoracambio(String horacambio) {
		this.horacambio = horacambio;
	}

	public String getNombreFunc() {
		return this.nombreFunc;
	}

	public void setNombreFunc(String nombreFunc) {
		this.nombreFunc = nombreFunc;
	}

	public String getRegistradopor() {
		return this.registradopor;
	}

	public void setRegistradopor(String registradopor) {
		this.registradopor = registradopor;
	}

	public String getUrlFunc() {
		return this.urlFunc;
	}

	public void setUrlFunc(String urlFunc) {
		this.urlFunc = urlFunc;
	}

	public Aplicacion getAplicacion() {
		return this.aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	public Funcionalidad getFuncionalidad() {
		return this.funcionalidad;
	}

	public void setFuncionalidad(Funcionalidad funcionalidad) {
		this.funcionalidad = funcionalidad;
	}

	public List<Funcionalidad> getFuncionalidads() {
		return this.funcionalidads;
	}

	public void setFuncionalidads(List<Funcionalidad> funcionalidads) {
		this.funcionalidads = funcionalidads;
	}

	public List<Funcionalidadrol> getFuncionalidadrols() {
		return this.funcionalidadrols;
	}

	public void setFuncionalidadrols(List<Funcionalidadrol> funcionalidadrols) {
		this.funcionalidadrols = funcionalidadrols;
	}

}