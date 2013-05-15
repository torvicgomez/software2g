package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the seguro database table.
 * 
 */
@Entity
@Table(schema="CONTABLE", name="SEGURO")
public class Seguro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEGURO_SEGUID_GENERATOR", sequenceName="CONTABLE.S_SEGU_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEGURO_SEGUID_GENERATOR")
	@Column(name="segu_id")
	private long seguId;

	@Column(name="segu_descripcion")
	private String seguDescripcion;

	@Column(name="segu_estado")
	private String seguEstado;

	@Column(name="segu_fechamodificacion")
	private String seguFechamodificacion;

	@Column(name="segu_hora")
	private String seguHora;

	@Column(name="segu_registradopor")
	private String seguRegistradopor;

	@Column(name="segu_tiempo")
	private Integer seguTiempo;

	@Column(name="segu_valor")
	private double seguValor;

	//bi-directional many-to-one association to Tipocreditoseguroadquirido
	@OneToMany(mappedBy="seguro")
	private List<Tipocreditoseguroadquirido> tipocreditoseguroadquiridos;

	public Seguro() {
	}

	public long getSeguId() {
		return this.seguId;
	}

	public void setSeguId(long seguId) {
		this.seguId = seguId;
	}

	public String getSeguDescripcion() {
		return this.seguDescripcion;
	}

	public void setSeguDescripcion(String seguDescripcion) {
		this.seguDescripcion = seguDescripcion;
	}

	public String getSeguEstado() {
		return this.seguEstado;
	}

	public void setSeguEstado(String seguEstado) {
		this.seguEstado = seguEstado;
	}

	public String getSeguFechamodificacion() {
		return this.seguFechamodificacion;
	}

	public void setSeguFechamodificacion(String seguFechamodificacion) {
		this.seguFechamodificacion = seguFechamodificacion;
	}

	public String getSeguHora() {
		return this.seguHora;
	}

	public void setSeguHora(String seguHora) {
		this.seguHora = seguHora;
	}

	public String getSeguRegistradopor() {
		return this.seguRegistradopor;
	}

	public void setSeguRegistradopor(String seguRegistradopor) {
		this.seguRegistradopor = seguRegistradopor;
	}

	public Integer getSeguTiempo() {
		return this.seguTiempo;
	}

	public void setSeguTiempo(Integer seguTiempo) {
		this.seguTiempo = seguTiempo;
	}

	public double getSeguValor() {
		return this.seguValor;
	}

	public void setSeguValor(double seguValor) {
		this.seguValor = seguValor;
	}

	public List<Tipocreditoseguroadquirido> getTipocreditoseguroadquiridos() {
		return this.tipocreditoseguroadquiridos;
	}

	public void setTipocreditoseguroadquiridos(List<Tipocreditoseguroadquirido> tipocreditoseguroadquiridos) {
		this.tipocreditoseguroadquiridos = tipocreditoseguroadquiridos;
	}

	
	public Tipocreditoseguroadquirido addTipocreditoseguroadquiridos(Tipocreditoseguroadquirido tipocreditoseguroadquiridos) {
		getTipocreditoseguroadquiridos().add(tipocreditoseguroadquiridos);
		tipocreditoseguroadquiridos.setSeguro(this);

		return tipocreditoseguroadquiridos;
	}

	public Tipocreditoseguroadquirido removeTipocreditoseguroadquiridos(Tipocreditoseguroadquirido tipocreditoseguroadquiridos) {
		getTipocreditoseguroadquiridos().remove(tipocreditoseguroadquiridos);
		tipocreditoseguroadquiridos.setSeguro(null);

		return tipocreditoseguroadquiridos;
	}
}