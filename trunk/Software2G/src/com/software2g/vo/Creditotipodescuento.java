package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the creditotipodescuento database table.
 * 
 */
@Entity
@Table(schema="CONTABLE", name="CREDITOTIPODESCUENTO")
public class Creditotipodescuento implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CreditotipodescuentoPK id;

	@Column(name="ctde_estado")
	private String ctdeEstado;

	@Column(name="ctde_fechamodificacion")
	private String ctdeFechamodificacion;

	@Column(name="ctde_hora")
	private String ctdeHora;

	@Column(name="ctde_registradopor")
	private String ctdeRegistradopor;

	//bi-directional many-to-one association to Credito
	@ManyToOne
	@JoinColumn(name="cred_id", insertable=false, updatable=false)
	private Credito credito;

	//bi-directional many-to-one association to Tipodescuento
	@ManyToOne
	@JoinColumn(name="tide_id", insertable=false, updatable=false)
	private Tipodescuento tipodescuento;

	public Creditotipodescuento() {
	}

	public CreditotipodescuentoPK getId() {
		return this.id;
	}

	public void setId(CreditotipodescuentoPK id) {
		this.id = id;
	}

	public String getCtdeEstado() {
		return this.ctdeEstado;
	}

	public void setCtdeEstado(String ctdeEstado) {
		this.ctdeEstado = ctdeEstado;
	}

	public String getCtdeFechamodificacion() {
		return this.ctdeFechamodificacion;
	}

	public void setCtdeFechamodificacion(String ctdeFechamodificacion) {
		this.ctdeFechamodificacion = ctdeFechamodificacion;
	}

	public String getCtdeHora() {
		return this.ctdeHora;
	}

	public void setCtdeHora(String ctdeHora) {
		this.ctdeHora = ctdeHora;
	}

	public String getCtdeRegistradopor() {
		return this.ctdeRegistradopor;
	}

	public void setCtdeRegistradopor(String ctdeRegistradopor) {
		this.ctdeRegistradopor = ctdeRegistradopor;
	}

	public Credito getCredito() {
		return this.credito;
	}

	public void setCredito(Credito credito) {
		this.credito = credito;
	}

	
	public Tipodescuento getTipodescuento() {
		return this.tipodescuento;
	}

	public void setTipodescuento(Tipodescuento tipodescuento) {
		this.tipodescuento = tipodescuento;
	}

	
}