package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the tipocredito database table.
 * 
 */
@Entity
@Table(schema="CONTABLE", name="TIPOCREDITO")
public class Tipocredito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOCREDITO_TICRID_GENERATOR", sequenceName="CONTABLE.S_TICR_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOCREDITO_TICRID_GENERATOR")
	@Column(name="ticr_id")
	private long ticrId;

	@Column(name="ticr_descripcion")
	private String ticrDescripcion;

	@Column(name="ticr_estado")
	private String ticrEstado;

	@Column(name="ticr_fechamodificacion")
	private String ticrFechamodificacion;

	@Column(name="ticr_hora")
	private String ticrHora;

	@Column(name="ticr_interesefectivoanual")
	private double ticrInteresefectivoanual;

	@Column(name="ticr_interesmoramesven")
	private double ticrInteresmoramesven;

	@Column(name="ticr_registradopor")
	private String ticrRegistradopor;

	@Column(name="ticr_tasainteresvencido")
	private double ticrTasainteresvencido;

	@Column(name="ticr_tiempoano")
	private Integer ticrTiempoano;

	@Column(name="ticr_tiempomes")
	private Integer ticrTiempomes;

	//bi-directional many-to-one association to Credito
	@OneToMany(mappedBy="tipocredito")
	private List<Credito> creditos;

	//bi-directional many-to-one association to Tipocreditoseguroadquirido
	@OneToMany(mappedBy="tipocredito")
	private List<Tipocreditoseguroadquirido> tipocreditoseguroadquiridos;

	public Tipocredito() {
	}

	public long getTicrId() {
		return this.ticrId;
	}

	public void setTicrId(long ticrId) {
		this.ticrId = ticrId;
	}

	public String getTicrDescripcion() {
		return this.ticrDescripcion;
	}

	public void setTicrDescripcion(String ticrDescripcion) {
		this.ticrDescripcion = ticrDescripcion;
	}

	public String getTicrEstado() {
		return this.ticrEstado;
	}

	public void setTicrEstado(String ticrEstado) {
		this.ticrEstado = ticrEstado;
	}

	public String getTicrFechamodificacion() {
		return this.ticrFechamodificacion;
	}

	public void setTicrFechamodificacion(String ticrFechamodificacion) {
		this.ticrFechamodificacion = ticrFechamodificacion;
	}

	public String getTicrHora() {
		return this.ticrHora;
	}

	public void setTicrHora(String ticrHora) {
		this.ticrHora = ticrHora;
	}

	public double getTicrInteresefectivoanual() {
		return this.ticrInteresefectivoanual;
	}

	public void setTicrInteresefectivoanual(double ticrInteresefectivoanual) {
		this.ticrInteresefectivoanual = ticrInteresefectivoanual;
	}

	public double getTicrInteresmoramesven() {
		return this.ticrInteresmoramesven;
	}

	public void setTicrInteresmoramesven(double ticrInteresmoramesven) {
		this.ticrInteresmoramesven = ticrInteresmoramesven;
	}

	public String getTicrRegistradopor() {
		return this.ticrRegistradopor;
	}

	public void setTicrRegistradopor(String ticrRegistradopor) {
		this.ticrRegistradopor = ticrRegistradopor;
	}

	public double getTicrTasainteresvencido() {
		return this.ticrTasainteresvencido;
	}

	public void setTicrTasainteresvencido(double ticrTasainteresvencido) {
		this.ticrTasainteresvencido = ticrTasainteresvencido;
	}

	public Integer getTicrTiempoano() {
		return this.ticrTiempoano;
	}

	public void setTicrTiempoano(Integer ticrTiempoano) {
		this.ticrTiempoano = ticrTiempoano;
	}

	public Integer getTicrTiempomes() {
		return this.ticrTiempomes;
	}

	public void setTicrTiempomes(Integer ticrTiempomes) {
		this.ticrTiempomes = ticrTiempomes;
	}

	public List<Credito> getCreditos() {
		return this.creditos;
	}

	public void setCreditos(List<Credito> creditos) {
		this.creditos = creditos;
	}

	
	public Credito addCreditos(Credito creditos) {
		getCreditos().add(creditos);
		creditos.setTipocredito(this);

		return creditos;
	}

	public Credito removeCreditos(Credito creditos) {
		getCreditos().remove(creditos);
		creditos.setTipocredito(null);

		return creditos;
	}
	public List<Tipocreditoseguroadquirido> getTipocreditoseguroadquiridos() {
		return this.tipocreditoseguroadquiridos;
	}

	public void setTipocreditoseguroadquiridos(List<Tipocreditoseguroadquirido> tipocreditoseguroadquiridos) {
		this.tipocreditoseguroadquiridos = tipocreditoseguroadquiridos;
	}

	
	public Tipocreditoseguroadquirido addTipocreditoseguroadquiridos(Tipocreditoseguroadquirido tipocreditoseguroadquiridos) {
		getTipocreditoseguroadquiridos().add(tipocreditoseguroadquiridos);
		tipocreditoseguroadquiridos.setTipocredito(this);

		return tipocreditoseguroadquiridos;
	}

	public Tipocreditoseguroadquirido removeTipocreditoseguroadquiridos(Tipocreditoseguroadquirido tipocreditoseguroadquiridos) {
		getTipocreditoseguroadquiridos().remove(tipocreditoseguroadquiridos);
		tipocreditoseguroadquiridos.setTipocredito(null);

		return tipocreditoseguroadquiridos;
	}
}