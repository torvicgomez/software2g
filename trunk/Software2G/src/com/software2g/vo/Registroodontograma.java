package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the "REGISTROODONTOGRAMA" database table.
 * 
 */
@Entity
@Table(name="\"REGISTROODONTOGRAMA\"", schema="\"HISCLINICA\"")
public class Registroodontograma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REGISTROODONTOGRAMA_REODID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_REOD_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REGISTROODONTOGRAMA_REODID_GENERATOR")
	@Column(name="reod_id")
	private long reodId;

	@Column(name="prto_id")
	private java.math.BigDecimal prtoId;

	@Column(name="reod_estado")
	private String reodEstado;

	@Column(name="reod_fechacambio")
	private String reodFechacambio;

	@Column(name="reod_horacambio")
	private String reodHoracambio;

	@Column(name="reod_observacion")
	private String reodObservacion;

	@Column(name="reod_realizacionprod")
	private String reodRealizacionprod;

	@Column(name="reod_registradopor")
	private String reodRegistradopor;

	@Column(name="reod_reporteprod")
	private String reodReporteprod;

	//bi-directional many-to-one association to Especificacionpartecuerpo
	@ManyToOne
	@JoinColumn(name="espc_id")
	private Especificacionpartecuerpo especificacionpartecuerpo;

	//bi-directional many-to-one association to Odontograma
	@ManyToOne
	@JoinColumn(name="odon_id")
	private Odontograma odontograma;

	//bi-directional many-to-one association to Seccionodon
	@ManyToOne
	@JoinColumn(name="secc_id")
	private Seccionodon seccionodon;

	public Registroodontograma() {
	}

	public long getReodId() {
		return this.reodId;
	}

	public void setReodId(long reodId) {
		this.reodId = reodId;
	}

	public java.math.BigDecimal getPrtoId() {
		return this.prtoId;
	}

	public void setPrtoId(java.math.BigDecimal prtoId) {
		this.prtoId = prtoId;
	}

	public String getReodEstado() {
		return this.reodEstado;
	}

	public void setReodEstado(String reodEstado) {
		this.reodEstado = reodEstado;
	}

	public String getReodFechacambio() {
		return this.reodFechacambio;
	}

	public void setReodFechacambio(String reodFechacambio) {
		this.reodFechacambio = reodFechacambio;
	}

	public String getReodHoracambio() {
		return this.reodHoracambio;
	}

	public void setReodHoracambio(String reodHoracambio) {
		this.reodHoracambio = reodHoracambio;
	}

	public String getReodObservacion() {
		return this.reodObservacion;
	}

	public void setReodObservacion(String reodObservacion) {
		this.reodObservacion = reodObservacion;
	}

	public String getReodRealizacionprod() {
		return this.reodRealizacionprod;
	}

	public void setReodRealizacionprod(String reodRealizacionprod) {
		this.reodRealizacionprod = reodRealizacionprod;
	}

	public String getReodRegistradopor() {
		return this.reodRegistradopor;
	}

	public void setReodRegistradopor(String reodRegistradopor) {
		this.reodRegistradopor = reodRegistradopor;
	}

	public String getReodReporteprod() {
		return this.reodReporteprod;
	}

	public void setReodReporteprod(String reodReporteprod) {
		this.reodReporteprod = reodReporteprod;
	}

	public Especificacionpartecuerpo getEspecificacionpartecuerpo() {
		return this.especificacionpartecuerpo;
	}

	public void setEspecificacionpartecuerpo(Especificacionpartecuerpo especificacionpartecuerpo) {
		this.especificacionpartecuerpo = especificacionpartecuerpo;
	}

	public Odontograma getOdontograma() {
		return this.odontograma;
	}

	public void setOdontograma(Odontograma odontograma) {
		this.odontograma = odontograma;
	}

	public Seccionodon getSeccionodon() {
		return this.seccionodon;
	}

	public void setSeccionodon(Seccionodon seccionodon) {
		this.seccionodon = seccionodon;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.reodRegistradopor=data.get(0);
			this.reodFechacambio=data.get(1);
			this.reodHoracambio=data.get(2);
		}
	}
}