package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the "GAFAS" database table.
 * 
 */
@Entity
@Table(name="\"GAFAS\"", schema="\"HISCLINICA\"")
public class Gafa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GAFAS_GAFAID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_GAFA_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GAFAS_GAFAID_GENERATOR")
	@Column(name="gafa_id")
	private long gafaId;

	@Column(name="gafa_add")
	private String gafaAdd;

	@Column(name="gafa_avl")
	private String gafaAvl;

	@Column(name="gafa_bifocal")
	private String gafaBifocal;

	@Column(name="gafa_cilindro")
	private String gafaCilindro;

	@Column(name="gafa_color")
	private String gafaColor;

	@Column(name="gafa_distanciapupilar")
	private String gafaDistanciapupilar;

	@Column(name="gafa_eje")
	private String gafaEje;

	@Column(name="gafa_esfera")
	private String gafaEsfera;

	@Column(name="gafa_fechacambio")
	private String gafaFechacambio;

	@Column(name="gafa_horacambio")
	private String gafaHoracambio;

	@Column(name="gafa_material")
	private String gafaMaterial;

	@Column(name="gafa_observaciones")
	private String gafaObservaciones;

	@Column(name="gafa_progresivo")
	private String gafaProgresivo;

	@Column(name="gafa_registradopor")
	private String gafaRegistradopor;

	//bi-directional many-to-one association to Especificacionpartecuerpo
	@ManyToOne
	@JoinColumn(name="espc_id")
	private Especificacionpartecuerpo especificacionpartecuerpo;

	//bi-directional many-to-one association to Formulacion
	@ManyToOne
	@JoinColumn(name="form_id")
	private Formulacion formulacion;

	public Gafa() {
	}

	public long getGafaId() {
		return this.gafaId;
	}

	public void setGafaId(long gafaId) {
		this.gafaId = gafaId;
	}

	public String getGafaAdd() {
		return this.gafaAdd;
	}

	public void setGafaAdd(String gafaAdd) {
		this.gafaAdd = gafaAdd;
	}

	public String getGafaAvl() {
		return this.gafaAvl;
	}

	public void setGafaAvl(String gafaAvl) {
		this.gafaAvl = gafaAvl;
	}

	public String getGafaBifocal() {
		return this.gafaBifocal;
	}

	public void setGafaBifocal(String gafaBifocal) {
		this.gafaBifocal = gafaBifocal;
	}

	public String getGafaCilindro() {
		return this.gafaCilindro;
	}

	public void setGafaCilindro(String gafaCilindro) {
		this.gafaCilindro = gafaCilindro;
	}

	public String getGafaColor() {
		return this.gafaColor;
	}

	public void setGafaColor(String gafaColor) {
		this.gafaColor = gafaColor;
	}

	public String getGafaDistanciapupilar() {
		return this.gafaDistanciapupilar;
	}

	public void setGafaDistanciapupilar(String gafaDistanciapupilar) {
		this.gafaDistanciapupilar = gafaDistanciapupilar;
	}

	public String getGafaEje() {
		return this.gafaEje;
	}

	public void setGafaEje(String gafaEje) {
		this.gafaEje = gafaEje;
	}

	public String getGafaEsfera() {
		return this.gafaEsfera;
	}

	public void setGafaEsfera(String gafaEsfera) {
		this.gafaEsfera = gafaEsfera;
	}

	public String getGafaFechacambio() {
		return this.gafaFechacambio;
	}

	public void setGafaFechacambio(String gafaFechacambio) {
		this.gafaFechacambio = gafaFechacambio;
	}

	public String getGafaHoracambio() {
		return this.gafaHoracambio;
	}

	public void setGafaHoracambio(String gafaHoracambio) {
		this.gafaHoracambio = gafaHoracambio;
	}

	public String getGafaMaterial() {
		return this.gafaMaterial;
	}

	public void setGafaMaterial(String gafaMaterial) {
		this.gafaMaterial = gafaMaterial;
	}

	public String getGafaObservaciones() {
		return this.gafaObservaciones;
	}

	public void setGafaObservaciones(String gafaObservaciones) {
		this.gafaObservaciones = gafaObservaciones;
	}

	public String getGafaProgresivo() {
		return this.gafaProgresivo;
	}

	public void setGafaProgresivo(String gafaProgresivo) {
		this.gafaProgresivo = gafaProgresivo;
	}

	public String getGafaRegistradopor() {
		return this.gafaRegistradopor;
	}

	public void setGafaRegistradopor(String gafaRegistradopor) {
		this.gafaRegistradopor = gafaRegistradopor;
	}

	public Especificacionpartecuerpo getEspecificacionpartecuerpo() {
		return this.especificacionpartecuerpo;
	}

	public void setEspecificacionpartecuerpo(Especificacionpartecuerpo especificacionpartecuerpo) {
		this.especificacionpartecuerpo = especificacionpartecuerpo;
	}

	public Formulacion getFormulacion() {
		return this.formulacion;
	}

	public void setFormulacion(Formulacion formulacion) {
		this.formulacion = formulacion;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.gafaRegistradopor=data.get(0);
			this.gafaFechacambio=data.get(1);
			this.gafaHoracambio=data.get(2);
		}
	}
}