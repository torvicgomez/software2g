package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import com.software2g.util.ValidaString;

import java.util.List;


/**
 * The persistent class for the presupuesto database table.
 * 
 */
@Entity
@Table(schema="CONTABLE", name="PRESUPUESTO")
public class Presupuesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRESUPUESTO_PRESID_GENERATOR", sequenceName="CONTABLE.S_PRES_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRESUPUESTO_PRESID_GENERATOR")
	@Column(name="pres_id")
	private long presId;

	@Column(name="pres_descripcion")
	private String presDescripcion;

	@Column(name="pres_fechamodificacion")
	private String presFechamodificacion;

	@Column(name="pres_hora")
	private String presHora;

	@Column(name="pres_registradopor")
	private String presRegistradopor;

	@Column(name="pres_valor")
	private double presValor;
	
	@Transient
	private String presValorString;

	//bi-directional many-to-one association to Credito
	@OneToMany(mappedBy="presupuesto")
	private List<Credito> creditos;

	//bi-directional many-to-one association to Presupuestodonacion
	@OneToMany(mappedBy="presupuesto")
	private List<Presupuestodonacion> presupuestodonacions;

	//bi-directional one-to-one association to Presupuestosucursal
	@OneToOne(mappedBy="presupuesto")
	private Presupuestosucursal presupuestosucursal;

	public Presupuesto() {
	}

	public long getPresId() {
		return this.presId;
	}

	public void setPresId(long presId) {
		this.presId = presId;
	}

	public String getPresDescripcion() {
		return this.presDescripcion;
	}

	public void setPresDescripcion(String presDescripcion) {
		this.presDescripcion = presDescripcion;
	}

	public String getPresFechamodificacion() {
		return this.presFechamodificacion;
	}

	public void setPresFechamodificacion(String presFechamodificacion) {
		this.presFechamodificacion = presFechamodificacion;
	}

	public String getPresHora() {
		return this.presHora;
	}

	public void setPresHora(String presHora) {
		this.presHora = presHora;
	}

	public String getPresRegistradopor() {
		return this.presRegistradopor;
	}

	public void setPresRegistradopor(String presRegistradopor) {
		this.presRegistradopor = presRegistradopor;
	}

	public double getPresValor() {
		return this.presValor;
	}

	public void setPresValor(double presValor) {
		this.presValor = presValor;
	}

	public List<Credito> getCreditos() {
		return this.creditos;
	}

	public void setCreditos(List<Credito> creditos) {
		this.creditos = creditos;
	}

	
	public Credito addCreditos(Credito creditos) {
		getCreditos().add(creditos);
		creditos.setPresupuesto(this);

		return creditos;
	}

	public Credito removeCreditos(Credito creditos) {
		getCreditos().remove(creditos);
		creditos.setPresupuesto(null);

		return creditos;
	}
	public List<Presupuestodonacion> getPresupuestodonacions() {
		return this.presupuestodonacions;
	}

	public void setPresupuestodonacions(List<Presupuestodonacion> presupuestodonacions) {
		this.presupuestodonacions = presupuestodonacions;
	}

	
	public Presupuestodonacion addPresupuestodonacions(Presupuestodonacion presupuestodonacions) {
		getPresupuestodonacions().add(presupuestodonacions);
		presupuestodonacions.setPresupuesto(this);

		return presupuestodonacions;
	}

	public Presupuestodonacion removePresupuestodonacions(Presupuestodonacion presupuestodonacions) {
		getPresupuestodonacions().remove(presupuestodonacions);
		presupuestodonacions.setPresupuesto(null);

		return presupuestodonacions;
	}
	public Presupuestosucursal getPresupuestosucursal() {
		return this.presupuestosucursal;
	}

	public void setPresupuestosucursal(Presupuestosucursal presupuestosucursal) {
		this.presupuestosucursal = presupuestosucursal;
	}

	public String getPresValorString() {
		presValorString = ValidaString.formatToMoney(String.valueOf(presValor));
		return presValorString;
	}

	public void setPresValorString(String presValorString) {
		this.presValorString = presValorString;
	}

}