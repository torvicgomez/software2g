package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import com.software2g.util.ValidaString;


/**
 * The persistent class for the presupuestodonacion database table.
 * 
 */
@Entity
@Table(schema="CONTABLE", name="PRESUPUESTODONACION")
public class Presupuestodonacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PresupuestodonacionPK id;

	@Column(name="prdo_fechamodificacion")
	private String prdoFechamodificacion;

	@Column(name="prdo_hora")
	private String prdoHora;

	@Column(name="prdo_monto")
	private double prdoMonto;

	@Transient
	private String prdoMontoStrig;
	
	@Column(name="prdo_registradopor")
	private String prdoRegistradopor;

	//bi-directional many-to-one association to Donacion
	@ManyToOne
	@JoinColumn(name="dona_id", insertable=false, updatable=false)
	private Donacion donacion;

	//bi-directional many-to-one association to Presupuesto
	@ManyToOne
	@JoinColumn(name="pres_id", insertable=false, updatable=false)
	private Presupuesto presupuesto;

	public Presupuestodonacion() {
		this.id = new PresupuestodonacionPK();
	}

	public PresupuestodonacionPK getId() {
		return this.id;
	}

	public void setId(PresupuestodonacionPK id) {
		this.id = id;
	}

	public String getPrdoFechamodificacion() {
		return this.prdoFechamodificacion;
	}

	public void setPrdoFechamodificacion(String prdoFechamodificacion) {
		this.prdoFechamodificacion = prdoFechamodificacion;
	}

	public String getPrdoHora() {
		return this.prdoHora;
	}

	public void setPrdoHora(String prdoHora) {
		this.prdoHora = prdoHora;
	}

	public double getPrdoMonto() {
		return this.prdoMonto;
	}

	public void setPrdoMonto(double prdoMonto) {
		this.prdoMonto = prdoMonto;
	}

	public String getPrdoRegistradopor() {
		return this.prdoRegistradopor;
	}

	public void setPrdoRegistradopor(String prdoRegistradopor) {
		this.prdoRegistradopor = prdoRegistradopor;
	}

	public Donacion getDonacion() {
		return this.donacion;
	}

	public void setDonacion(Donacion donacion) {
		this.donacion = donacion;
	}

	
	public Presupuesto getPresupuesto() {
		return this.presupuesto;
	}

	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}

	public String getPrdoMontoStrig() {
		prdoMontoStrig = ValidaString.formatToMoney(String.valueOf(prdoMonto));
		return prdoMontoStrig;
	}

	public void setPrdoMontoStrig(String prdoMontoStrig) {
		this.prdoMontoStrig = prdoMontoStrig;
	}

}