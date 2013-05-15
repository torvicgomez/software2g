package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the tipopagare database table.
 * 
 */
@Entity
@Table(schema="CONTABLE", name="TIPOPAGARE")
public class Tipopagare implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOPAGARE_TIPAID_GENERATOR", sequenceName="CONTABLE.S_TIPA_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOPAGARE_TIPAID_GENERATOR")
	@Column(name="tipa_id")
	private long tipaId;

	@Column(name="tipa_contenidocentral")
	private String tipaContenidocentral;

	@Column(name="tipa_contenidofinal")
	private String tipaContenidofinal;

	@Column(name="tipa_descripcion")
	private String tipaDescripcion;

	@Column(name="tipa_encabezado")
	private String tipaEncabezado;

	@Column(name="tipa_fechamodificacion")
	private String tipaFechamodificacion;

	@Column(name="tipa_hora")
	private String tipaHora;

	@Column(name="tipa_registradopor")
	private String tipaRegistradopor;

	@Column(name="tipa_titulo")
	private String tipaTitulo;

	//bi-directional many-to-one association to Pagare
	@OneToMany(mappedBy="tipopagare")
	private List<Pagare> pagares;

	public Tipopagare() {
	}

	public long getTipaId() {
		return this.tipaId;
	}

	public void setTipaId(long tipaId) {
		this.tipaId = tipaId;
	}

	public String getTipaContenidocentral() {
		return this.tipaContenidocentral;
	}

	public void setTipaContenidocentral(String tipaContenidocentral) {
		this.tipaContenidocentral = tipaContenidocentral;
	}

	public String getTipaContenidofinal() {
		return this.tipaContenidofinal;
	}

	public void setTipaContenidofinal(String tipaContenidofinal) {
		this.tipaContenidofinal = tipaContenidofinal;
	}

	public String getTipaDescripcion() {
		return this.tipaDescripcion;
	}

	public void setTipaDescripcion(String tipaDescripcion) {
		this.tipaDescripcion = tipaDescripcion;
	}

	public String getTipaEncabezado() {
		return this.tipaEncabezado;
	}

	public void setTipaEncabezado(String tipaEncabezado) {
		this.tipaEncabezado = tipaEncabezado;
	}

	public String getTipaFechamodificacion() {
		return this.tipaFechamodificacion;
	}

	public void setTipaFechamodificacion(String tipaFechamodificacion) {
		this.tipaFechamodificacion = tipaFechamodificacion;
	}

	public String getTipaHora() {
		return this.tipaHora;
	}

	public void setTipaHora(String tipaHora) {
		this.tipaHora = tipaHora;
	}

	public String getTipaRegistradopor() {
		return this.tipaRegistradopor;
	}

	public void setTipaRegistradopor(String tipaRegistradopor) {
		this.tipaRegistradopor = tipaRegistradopor;
	}

	public String getTipaTitulo() {
		return this.tipaTitulo;
	}

	public void setTipaTitulo(String tipaTitulo) {
		this.tipaTitulo = tipaTitulo;
	}

	public List<Pagare> getPagares() {
		return this.pagares;
	}

	public void setPagares(List<Pagare> pagares) {
		this.pagares = pagares;
	}

	
	public Pagare addPagares(Pagare pagares) {
		getPagares().add(pagares);
		pagares.setTipopagare(this);

		return pagares;
	}

	public Pagare removePagares(Pagare pagares) {
		getPagares().remove(pagares);
		pagares.setTipopagare(null);

		return pagares;
	}
}