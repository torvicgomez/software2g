package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the presupuestosucursal database table.
 * 
 */
@Entity
@Table(schema="CONTABLE", name="PRESUPUESTOSUCURSAL")
public class Presupuestosucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pres_id")
	private long presId;

	@Column(name="prsu_estado")
	private String prsuEstado;

	@Column(name="prsu_fechamodificacion")
	private String prsuFechamodificacion;

	@Column(name="prsu_hora")
	private String prsuHora;

	@Column(name="prsu_registradopor")
	private String prsuRegistradopor;

	//bi-directional one-to-one association to Presupuesto
	@OneToOne
	@JoinColumn(name="pres_id")
	private Presupuesto presupuesto;

	//bi-directional many-to-one association to Sucursal
	@ManyToOne
	@JoinColumn(name="sucu_id")
	private Sucursal sucursal;

	public Presupuestosucursal() {
	}

	public long getPresId() {
		return this.presId;
	}

	public void setPresId(long presId) {
		this.presId = presId;
	}

	public String getPrsuEstado() {
		return this.prsuEstado;
	}

	public void setPrsuEstado(String prsuEstado) {
		this.prsuEstado = prsuEstado;
	}

	public String getPrsuFechamodificacion() {
		return this.prsuFechamodificacion;
	}

	public void setPrsuFechamodificacion(String prsuFechamodificacion) {
		this.prsuFechamodificacion = prsuFechamodificacion;
	}

	public String getPrsuHora() {
		return this.prsuHora;
	}

	public void setPrsuHora(String prsuHora) {
		this.prsuHora = prsuHora;
	}

	public String getPrsuRegistradopor() {
		return this.prsuRegistradopor;
	}

	public void setPrsuRegistradopor(String prsuRegistradopor) {
		this.prsuRegistradopor = prsuRegistradopor;
	}

	public Presupuesto getPresupuesto() {
		return this.presupuesto;
	}

	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}

	
	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	
}