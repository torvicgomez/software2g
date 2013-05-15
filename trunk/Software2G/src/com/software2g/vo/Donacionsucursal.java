package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the donacionsucursal database table.
 * 
 */
@Entity
@Table(schema="CONTABLE", name="DONACIONSUCURSAL")
public class Donacionsucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DonacionsucursalPK id;

	@Column(name="dosu_estado")
	private String dosuEstado;

	@Column(name="dosu_fechamodificacion")
	private String dosuFechamodificacion;

	@Column(name="dosu_hora")
	private String dosuHora;

	@Column(name="dosu_registradopor")
	private String dosuRegistradopor;

	//bi-directional many-to-one association to Donacion
	@ManyToOne
	@JoinColumn(name="dona_id", insertable=false, updatable=false)
	private Donacion donacion;

	//bi-directional many-to-one association to Sucursal
	@ManyToOne
	@JoinColumn(name="sucu_id", insertable=false, updatable=false)
	private Sucursal sucursal;

	public Donacionsucursal() {
	}

	public DonacionsucursalPK getId() {
		return this.id;
	}

	public void setId(DonacionsucursalPK id) {
		this.id = id;
	}

	public String getDosuEstado() {
		return this.dosuEstado;
	}

	public void setDosuEstado(String dosuEstado) {
		this.dosuEstado = dosuEstado;
	}

	public String getDosuFechamodificacion() {
		return this.dosuFechamodificacion;
	}

	public void setDosuFechamodificacion(String dosuFechamodificacion) {
		this.dosuFechamodificacion = dosuFechamodificacion;
	}

	public String getDosuHora() {
		return this.dosuHora;
	}

	public void setDosuHora(String dosuHora) {
		this.dosuHora = dosuHora;
	}

	public String getDosuRegistradopor() {
		return this.dosuRegistradopor;
	}

	public void setDosuRegistradopor(String dosuRegistradopor) {
		this.dosuRegistradopor = dosuRegistradopor;
	}

	public Donacion getDonacion() {
		return this.donacion;
	}

	public void setDonacion(Donacion donacion) {
		this.donacion = donacion;
	}

	
	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	
}