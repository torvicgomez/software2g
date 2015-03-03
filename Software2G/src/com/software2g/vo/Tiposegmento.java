package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "TIPOSEGMENTO" database table.
 * 
 */
@Entity
@Table(name="\"TIPOSEGMENTO\"", schema="\"HISCLINICA\"")
public class Tiposegmento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOSEGMENTO_TISAID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_TISA_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOSEGMENTO_TISAID_GENERATOR")
	@Column(name="tisa_id")
	private long tisaId;

	@Column(name="tisa_abreviatura")
	private String tisaAbreviatura;

	@Column(name="tisa_fechacambio")
	private String tisaFechacambio;

	@Column(name="tisa_horacambio")
	private String tisaHoracambio;

	@Column(name="tisa_nombre")
	private String tisaNombre;

	@Column(name="tisa_registradopor")
	private String tisaRegistradopor;

	//bi-directional many-to-one association to Segmentoanamnesi
	@OneToMany(mappedBy="tiposegmento")
	private List<Segmentoanamnesi> segmentoanamnesis;

	public Tiposegmento() {
	}

	public long getTisaId() {
		return this.tisaId;
	}

	public void setTisaId(long tisaId) {
		this.tisaId = tisaId;
	}

	public String getTisaAbreviatura() {
		return this.tisaAbreviatura;
	}

	public void setTisaAbreviatura(String tisaAbreviatura) {
		this.tisaAbreviatura = tisaAbreviatura;
	}

	public String getTisaFechacambio() {
		return this.tisaFechacambio;
	}

	public void setTisaFechacambio(String tisaFechacambio) {
		this.tisaFechacambio = tisaFechacambio;
	}

	public String getTisaHoracambio() {
		return this.tisaHoracambio;
	}

	public void setTisaHoracambio(String tisaHoracambio) {
		this.tisaHoracambio = tisaHoracambio;
	}

	public String getTisaNombre() {
		return this.tisaNombre;
	}

	public void setTisaNombre(String tisaNombre) {
		this.tisaNombre = tisaNombre;
	}

	public String getTisaRegistradopor() {
		return this.tisaRegistradopor;
	}

	public void setTisaRegistradopor(String tisaRegistradopor) {
		this.tisaRegistradopor = tisaRegistradopor;
	}

	public List<Segmentoanamnesi> getSegmentoanamnesis() {
		return this.segmentoanamnesis;
	}

	public void setSegmentoanamnesis(List<Segmentoanamnesi> segmentoanamnesis) {
		this.segmentoanamnesis = segmentoanamnesis;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.tisaRegistradopor=data.get(0);
			this.tisaFechacambio=data.get(1);
			this.tisaHoracambio=data.get(2);
		}
	}
}