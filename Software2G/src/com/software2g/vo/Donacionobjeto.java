package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the donacionobjeto database table.
 * 
 */
@Entity
@Table(schema="CONTABLE", name="DONACIONOBJETO")
public class Donacionobjeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DonacionobjetoPK id;

	@Column(name="obdo_estado")
	private String obdoEstado;

	@Column(name="obdo_fechamodificacion")
	private String obdoFechamodificacion;

	@Column(name="obdo_hora")
	private String obdoHora;

	@Column(name="obdo_registradopor")
	private String obdoRegistradopor;

	@Transient
	private String nombreObjeto; 
	@Transient
	private String estadoText;
	
	//bi-directional many-to-one association to Donacion
	@ManyToOne
	@JoinColumn(name="dona_id", insertable=false, updatable=false)
	private Donacion donacion;

	//bi-directional many-to-one association to Objeto
	@ManyToOne
	@JoinColumn(name="obje_id", insertable=false, updatable=false)
	private Objeto objeto;

	public Donacionobjeto() {
	}

	public DonacionobjetoPK getId() {
		return this.id;
	}

	public void setId(DonacionobjetoPK id) {
		this.id = id;
	}

	public String getObdoEstado() {
		return this.obdoEstado;
	}

	public void setObdoEstado(String obdoEstado) {
		this.obdoEstado = obdoEstado;
	}

	public String getObdoFechamodificacion() {
		return this.obdoFechamodificacion;
	}

	public void setObdoFechamodificacion(String obdoFechamodificacion) {
		this.obdoFechamodificacion = obdoFechamodificacion;
	}

	public String getObdoHora() {
		return this.obdoHora;
	}

	public void setObdoHora(String obdoHora) {
		this.obdoHora = obdoHora;
	}

	public String getObdoRegistradopor() {
		return this.obdoRegistradopor;
	}

	public void setObdoRegistradopor(String obdoRegistradopor) {
		this.obdoRegistradopor = obdoRegistradopor;
	}

	public Donacion getDonacion() {
		return this.donacion;
	}

	public void setDonacion(Donacion donacion) {
		this.donacion = donacion;
	}

	
	public Objeto getObjeto() {
		return this.objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	public String getNombreObjeto() {
		return nombreObjeto;
	}

	public void setNombreObjeto(String nombreObjeto) {
		this.nombreObjeto = nombreObjeto;
	}

	public String getEstadoText() {
		return estadoText;
	}

	public void setEstadoText(String estadoText) {
		this.estadoText = estadoText;
	}

}