package com.software2g.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import com.software2g.util.ValidaString;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the donacion database table.
 * 
 */
@Entity
@Table(schema="CONTABLE", name="DONACION")
public class Donacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DONACION_DONAID_GENERATOR", sequenceName="CONTABLE.S_DONA_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DONACION_DONAID_GENERATOR")
	@Column(name="dona_id")
	private long donaId;

	@Column(name="dona_descripcion")
	private String donaDescripcion;

	//@Temporal(TemporalType.DATE)
	@Column(name="dona_fecha")
	private String donaFecha;

	@Column(name="dona_fechamodificacion")
	private String donaFechamodificacion;

	@Column(name="dona_hora")
	private String donaHora;

	@Column(name="dona_registradopor")
	private String donaRegistradopor;

	@Column(name="dona_valor")
	private BigDecimal donaValor;
	
	@Transient
	private String donaValorString;

	@Column(name="dona_estado")
	private String donaEstado;
	
	//bi-directional many-to-one association to Entidaddonante
	@ManyToOne
	@JoinColumn(name="endo_id")
	private Entidaddonante entidaddonante;

	//bi-directional many-to-one association to Donacionobjeto
	@OneToMany(mappedBy="donacion")
	private List<Donacionobjeto> donacionobjetos;

	//bi-directional many-to-one association to Donacionsucursal
	@OneToMany(mappedBy="donacion")
	private List<Donacionsucursal> donacionsucursals;

	//bi-directional many-to-one association to Presupuestodonacion
	@OneToMany(mappedBy="donacion")
	private List<Presupuestodonacion> presupuestodonacions;

	public Donacion() {
	}

	public long getDonaId() {
		return this.donaId;
	}

	public void setDonaId(long donaId) {
		this.donaId = donaId;
	}

	public String getDonaDescripcion() {
		return this.donaDescripcion;
	}

	public void setDonaDescripcion(String donaDescripcion) {
		this.donaDescripcion = donaDescripcion;
	}

	public String getDonaFecha() {
		return this.donaFecha;
	}

	public void setDonaFecha(String donaFecha) {
		this.donaFecha = donaFecha;
	}

	public String getDonaFechamodificacion() {
		return this.donaFechamodificacion;
	}

	public void setDonaFechamodificacion(String donaFechamodificacion) {
		this.donaFechamodificacion = donaFechamodificacion;
	}

	public String getDonaHora() {
		return this.donaHora;
	}

	public void setDonaHora(String donaHora) {
		this.donaHora = donaHora;
	}

	public String getDonaRegistradopor() {
		return this.donaRegistradopor;
	}

	public void setDonaRegistradopor(String donaRegistradopor) {
		this.donaRegistradopor = donaRegistradopor;
	}

	public BigDecimal getDonaValor() {
		return this.donaValor;
	}

	public void setDonaValor(BigDecimal donaValor) {
		this.donaValor = donaValor;
	}

	public Entidaddonante getEntidaddonante() {
		return this.entidaddonante;
	}

	public void setEntidaddonante(Entidaddonante entidaddonante) {
		this.entidaddonante = entidaddonante;
	}

	
	public List<Donacionobjeto> getDonacionobjetos() {
		return this.donacionobjetos;
	}

	public void setDonacionobjetos(List<Donacionobjeto> donacionobjetos) {
		this.donacionobjetos = donacionobjetos;
	}

	
	public Donacionobjeto addDonacionobjetos(Donacionobjeto donacionobjetos) {
		getDonacionobjetos().add(donacionobjetos);
		donacionobjetos.setDonacion(this);

		return donacionobjetos;
	}

	public Donacionobjeto removeDonacionobjetos(Donacionobjeto donacionobjetos) {
		getDonacionobjetos().remove(donacionobjetos);
		donacionobjetos.setDonacion(null);

		return donacionobjetos;
	}
	public List<Donacionsucursal> getDonacionsucursals() {
		return this.donacionsucursals;
	}

	public void setDonacionsucursals(List<Donacionsucursal> donacionsucursals) {
		this.donacionsucursals = donacionsucursals;
	}

	
	public Donacionsucursal addDonacionsucursals(Donacionsucursal donacionsucursals) {
		getDonacionsucursals().add(donacionsucursals);
		donacionsucursals.setDonacion(this);

		return donacionsucursals;
	}

	public Donacionsucursal removeDonacionsucursals(Donacionsucursal donacionsucursals) {
		getDonacionsucursals().remove(donacionsucursals);
		donacionsucursals.setDonacion(null);

		return donacionsucursals;
	}
	public List<Presupuestodonacion> getPresupuestodonacions() {
		return this.presupuestodonacions;
	}

	public void setPresupuestodonacions(List<Presupuestodonacion> presupuestodonacions) {
		this.presupuestodonacions = presupuestodonacions;
	}

	
	public Presupuestodonacion addPresupuestodonacions(Presupuestodonacion presupuestodonacions) {
		getPresupuestodonacions().add(presupuestodonacions);
		presupuestodonacions.setDonacion(this);

		return presupuestodonacions;
	}

	public Presupuestodonacion removePresupuestodonacions(Presupuestodonacion presupuestodonacions) {
		getPresupuestodonacions().remove(presupuestodonacions);
		presupuestodonacions.setDonacion(null);

		return presupuestodonacions;
	}

	public String getDonaEstado() {
		return donaEstado;
	}

	public void setDonaEstado(String donaEstado) {
		this.donaEstado = donaEstado;
	}

	public String getDonaValorString() {
		donaValorString = ValidaString.formatToMoney(donaValor.toString());
		return donaValorString;
	}

	public void setDonaValorString(String donaValorString) {
		this.donaValorString = donaValorString;
	}

	
}