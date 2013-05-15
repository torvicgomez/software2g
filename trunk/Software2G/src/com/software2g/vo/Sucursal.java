package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the sucursal database table.
 * 
 */
@Entity
@Table(schema="CONTABLE", name="SUCURSAL")
public class Sucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SUCURSAL_SUCUID_GENERATOR", sequenceName="CONTABLE.S_SUCU_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SUCURSAL_SUCUID_GENERATOR")
	@Column(name="sucu_id")
	private long sucuId;

	@Column(name="sucu_descripcion")
	private String sucuDescripcion;

	@Column(name="sucu_fechamodificacion")
	private String sucuFechamodificacion;

	@Column(name="sucu_hora")
	private String sucuHora;

	@Column(name="sucu_nombre")
	private String sucuNombre;

	@Column(name="sucu_registradopor")
	private String sucuRegistradopor;

	@Column(name="sucu_ubicacion")
	private BigDecimal sucuUbicacion;

	//bi-directional many-to-one association to Donacionsucursal
	@OneToMany(mappedBy="sucursal")
	private List<Donacionsucursal> donacionsucursals;

	//bi-directional many-to-one association to Presupuestosucursal
	@OneToMany(mappedBy="sucursal")
	private List<Presupuestosucursal> presupuestosucursals;

	public Sucursal() {
	}

	public long getSucuId() {
		return this.sucuId;
	}

	public void setSucuId(long sucuId) {
		this.sucuId = sucuId;
	}

	public String getSucuDescripcion() {
		return this.sucuDescripcion;
	}

	public void setSucuDescripcion(String sucuDescripcion) {
		this.sucuDescripcion = sucuDescripcion;
	}

	public String getSucuFechamodificacion() {
		return this.sucuFechamodificacion;
	}

	public void setSucuFechamodificacion(String sucuFechamodificacion) {
		this.sucuFechamodificacion = sucuFechamodificacion;
	}

	public String getSucuHora() {
		return this.sucuHora;
	}

	public void setSucuHora(String sucuHora) {
		this.sucuHora = sucuHora;
	}

	public String getSucuNombre() {
		return this.sucuNombre;
	}

	public void setSucuNombre(String sucuNombre) {
		this.sucuNombre = sucuNombre;
	}

	public String getSucuRegistradopor() {
		return this.sucuRegistradopor;
	}

	public void setSucuRegistradopor(String sucuRegistradopor) {
		this.sucuRegistradopor = sucuRegistradopor;
	}

	public BigDecimal getSucuUbicacion() {
		return this.sucuUbicacion;
	}

	public void setSucuUbicacion(BigDecimal sucuUbicacion) {
		this.sucuUbicacion = sucuUbicacion;
	}

	public List<Donacionsucursal> getDonacionsucursals() {
		return this.donacionsucursals;
	}

	public void setDonacionsucursals(List<Donacionsucursal> donacionsucursals) {
		this.donacionsucursals = donacionsucursals;
	}

	
	public Donacionsucursal addDonacionsucursals(Donacionsucursal donacionsucursals) {
		getDonacionsucursals().add(donacionsucursals);
		donacionsucursals.setSucursal(this);

		return donacionsucursals;
	}

	public Donacionsucursal removeDonacionsucursals(Donacionsucursal donacionsucursals) {
		getDonacionsucursals().remove(donacionsucursals);
		donacionsucursals.setSucursal(null);

		return donacionsucursals;
	}
	public List<Presupuestosucursal> getPresupuestosucursals() {
		return this.presupuestosucursals;
	}

	public void setPresupuestosucursals(List<Presupuestosucursal> presupuestosucursals) {
		this.presupuestosucursals = presupuestosucursals;
	}

	
	public Presupuestosucursal addPresupuestosucursals(Presupuestosucursal presupuestosucursals) {
		getPresupuestosucursals().add(presupuestosucursals);
		presupuestosucursals.setSucursal(this);

		return presupuestosucursals;
	}

	public Presupuestosucursal removePresupuestosucursals(Presupuestosucursal presupuestosucursals) {
		getPresupuestosucursals().remove(presupuestosucursals);
		presupuestosucursals.setSucursal(null);

		return presupuestosucursals;
	}
}