package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the "PROCEDIMIENTOS" database table.
 * 
 */
@Entity
@Table(name="\"PROCEDIMIENTOS\"", schema="\"HISCLINICA\"")
public class Procedimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROCEDIMIENTOS_PRTOID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_PRTO_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROCEDIMIENTOS_PRTOID_GENERATOR")
	@Column(name="prto_id")
	private long prtoId;

	@Column(name="prto_codigo")
	private String prtoCodigo;

	@Column(name="prto_color")
	private String prtoColor;

	@Column(name="prto_descripcion")
	private String prtoDescripcion;

	@Column(name="prto_fechacambio")
	private String prtoFechacambio;

	@Column(name="prto_horacambio")
	private String prtoHoracambio;

	@Column(name="prto_nombre")
	private String prtoNombre;

	@Column(name="prto_pathimagen")
	private String prtoPathimagen;

	@Column(name="prto_registradopor")
	private String prtoRegistradopor;

	//bi-directional many-to-one association to Tipoprocedimiento
	@ManyToOne
	@JoinColumn(name="tipr_id")
	private Tipoprocedimiento tipoprocedimiento;

	public Procedimiento() {
	}

	public long getPrtoId() {
		return this.prtoId;
	}

	public void setPrtoId(long prtoId) {
		this.prtoId = prtoId;
	}

	public String getPrtoCodigo() {
		return this.prtoCodigo;
	}

	public void setPrtoCodigo(String prtoCodigo) {
		this.prtoCodigo = prtoCodigo;
	}

	public String getPrtoColor() {
		return this.prtoColor;
	}

	public void setPrtoColor(String prtoColor) {
		this.prtoColor = prtoColor;
	}

	public String getPrtoDescripcion() {
		return this.prtoDescripcion;
	}

	public void setPrtoDescripcion(String prtoDescripcion) {
		this.prtoDescripcion = prtoDescripcion;
	}

	public String getPrtoFechacambio() {
		return this.prtoFechacambio;
	}

	public void setPrtoFechacambio(String prtoFechacambio) {
		this.prtoFechacambio = prtoFechacambio;
	}

	public String getPrtoHoracambio() {
		return this.prtoHoracambio;
	}

	public void setPrtoHoracambio(String prtoHoracambio) {
		this.prtoHoracambio = prtoHoracambio;
	}

	public String getPrtoNombre() {
		return this.prtoNombre;
	}

	public void setPrtoNombre(String prtoNombre) {
		this.prtoNombre = prtoNombre;
	}

	public String getPrtoPathimagen() {
		return this.prtoPathimagen;
	}

	public void setPrtoPathimagen(String prtoPathimagen) {
		this.prtoPathimagen = prtoPathimagen;
	}

	public String getPrtoRegistradopor() {
		return this.prtoRegistradopor;
	}

	public void setPrtoRegistradopor(String prtoRegistradopor) {
		this.prtoRegistradopor = prtoRegistradopor;
	}

	public Tipoprocedimiento getTipoprocedimiento() {
		return this.tipoprocedimiento;
	}

	public void setTipoprocedimiento(Tipoprocedimiento tipoprocedimiento) {
		this.tipoprocedimiento = tipoprocedimiento;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.prtoRegistradopor=data.get(0);
			this.prtoFechacambio=data.get(1);
			this.prtoHoracambio=data.get(2);
		}
	}
}