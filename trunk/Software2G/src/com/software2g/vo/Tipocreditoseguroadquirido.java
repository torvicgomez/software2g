package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipocreditoseguroadquirido database table.
 * 
 */
@Entity
@Table(schema="CONTABLE", name="TIPOCREDITOSEGUROADQUIRIDO")
public class Tipocreditoseguroadquirido implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TipocreditoseguroadquiridoPK id;

	@Column(name="tcrs_estado")
	private String tcrsEstado;

	@Column(name="tcrs_fechamodificacion")
	private String tcrsFechamodificacion;

	@Column(name="tcrs_hora")
	private String tcrsHora;

	@Column(name="tcrs_registradopor")
	private String tcrsRegistradopor;

	//bi-directional many-to-one association to Seguro
	@ManyToOne
	@JoinColumn(name="segu_id", insertable=false, updatable=false)
	private Seguro seguro;

	//bi-directional many-to-one association to Tipocredito
	@ManyToOne
	@JoinColumn(name="ticr_id", insertable=false, updatable=false)
	private Tipocredito tipocredito;

	public Tipocreditoseguroadquirido() {
	}

	public TipocreditoseguroadquiridoPK getId() {
		return this.id;
	}

	public void setId(TipocreditoseguroadquiridoPK id) {
		this.id = id;
	}

	public String getTcrsEstado() {
		return this.tcrsEstado;
	}

	public void setTcrsEstado(String tcrsEstado) {
		this.tcrsEstado = tcrsEstado;
	}

	public String getTcrsFechamodificacion() {
		return this.tcrsFechamodificacion;
	}

	public void setTcrsFechamodificacion(String tcrsFechamodificacion) {
		this.tcrsFechamodificacion = tcrsFechamodificacion;
	}

	public String getTcrsHora() {
		return this.tcrsHora;
	}

	public void setTcrsHora(String tcrsHora) {
		this.tcrsHora = tcrsHora;
	}

	public String getTcrsRegistradopor() {
		return this.tcrsRegistradopor;
	}

	public void setTcrsRegistradopor(String tcrsRegistradopor) {
		this.tcrsRegistradopor = tcrsRegistradopor;
	}

	public Seguro getSeguro() {
		return this.seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	
	public Tipocredito getTipocredito() {
		return this.tipocredito;
	}

	public void setTipocredito(Tipocredito tipocredito) {
		this.tipocredito = tipocredito;
	}

	
}