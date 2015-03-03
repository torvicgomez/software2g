package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "TIPOESPECIALIDAD" database table.
 * 
 */
@Entity
@Table(name="\"TIPOESPECIALIDAD\"", schema="\"HISCLINICA\"")
public class Tipoespecialidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOESPECIALIDAD_TIESID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_TIES_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOESPECIALIDAD_TIESID_GENERATOR")
	@Column(name="ties_id")
	private long tiesId;

	@Column(name="ties_especialidad")
	private String tiesEspecialidad;

	@Column(name="ties_fechacambio")
	private String tiesFechacambio;

	@Column(name="ties_horacambio")
	private String tiesHoracambio;

	@Column(name="ties_registradopor")
	private String tiesRegistradopor;

	//bi-directional many-to-one association to Codigoenfermedade
	@OneToMany(mappedBy="tipoespecialidad")
	private List<Codigoenfermedade> codigoenfermedades;

	//bi-directional many-to-one association to Segmentoanamnesi
	@OneToMany(mappedBy="tipoespecialidad")
	private List<Segmentoanamnesi> segmentoanamnesis;

	public Tipoespecialidad() {
	}

	public long getTiesId() {
		return this.tiesId;
	}

	public void setTiesId(long tiesId) {
		this.tiesId = tiesId;
	}

	public String getTiesEspecialidad() {
		return this.tiesEspecialidad;
	}

	public void setTiesEspecialidad(String tiesEspecialidad) {
		this.tiesEspecialidad = tiesEspecialidad;
	}

	public String getTiesFechacambio() {
		return this.tiesFechacambio;
	}

	public void setTiesFechacambio(String tiesFechacambio) {
		this.tiesFechacambio = tiesFechacambio;
	}

	public String getTiesHoracambio() {
		return this.tiesHoracambio;
	}

	public void setTiesHoracambio(String tiesHoracambio) {
		this.tiesHoracambio = tiesHoracambio;
	}

	public String getTiesRegistradopor() {
		return this.tiesRegistradopor;
	}

	public void setTiesRegistradopor(String tiesRegistradopor) {
		this.tiesRegistradopor = tiesRegistradopor;
	}

	public List<Codigoenfermedade> getCodigoenfermedades() {
		return this.codigoenfermedades;
	}

	public void setCodigoenfermedades(List<Codigoenfermedade> codigoenfermedades) {
		this.codigoenfermedades = codigoenfermedades;
	}

	public List<Segmentoanamnesi> getSegmentoanamnesis() {
		return this.segmentoanamnesis;
	}

	public void setSegmentoanamnesis(List<Segmentoanamnesi> segmentoanamnesis) {
		this.segmentoanamnesis = segmentoanamnesis;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.tiesRegistradopor=data.get(0);
			this.tiesFechacambio=data.get(1);
			this.tiesHoracambio=data.get(2);
		}
	}
}