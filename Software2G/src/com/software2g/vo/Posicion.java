package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "POSICION" database table.
 * 
 */
@Entity
@Table(name="\"POSICION\"", schema="\"HISCLINICA\"")
public class Posicion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="POSICION_POSIID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_POSI_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POSICION_POSIID_GENERATOR")
	@Column(name="posi_id")
	private long posiId;

	@Column(name="posi_abreviatura")
	private String posiAbreviatura;

	@Column(name="posi_fechacambio")
	private String posiFechacambio;

	@Column(name="posi_horacambio")
	private String posiHoracambio;

	@Column(name="posi_posicion")
	private String posiPosicion;

	@Column(name="posi_registradopor")
	private String posiRegistradopor;

	//bi-directional many-to-one association to Especificacionpartecuerpo
	@OneToMany(mappedBy="posicion")
	private List<Especificacionpartecuerpo> especificacionpartecuerpos;

	public Posicion() {
	}

	public long getPosiId() {
		return this.posiId;
	}

	public void setPosiId(long posiId) {
		this.posiId = posiId;
	}

	public String getPosiAbreviatura() {
		return this.posiAbreviatura;
	}

	public void setPosiAbreviatura(String posiAbreviatura) {
		this.posiAbreviatura = posiAbreviatura;
	}

	public String getPosiFechacambio() {
		return this.posiFechacambio;
	}

	public void setPosiFechacambio(String posiFechacambio) {
		this.posiFechacambio = posiFechacambio;
	}

	public String getPosiHoracambio() {
		return this.posiHoracambio;
	}

	public void setPosiHoracambio(String posiHoracambio) {
		this.posiHoracambio = posiHoracambio;
	}

	public String getPosiPosicion() {
		return this.posiPosicion;
	}

	public void setPosiPosicion(String posiPosicion) {
		this.posiPosicion = posiPosicion;
	}

	public String getPosiRegistradopor() {
		return this.posiRegistradopor;
	}

	public void setPosiRegistradopor(String posiRegistradopor) {
		this.posiRegistradopor = posiRegistradopor;
	}

	public List<Especificacionpartecuerpo> getEspecificacionpartecuerpos() {
		return this.especificacionpartecuerpos;
	}

	public void setEspecificacionpartecuerpos(List<Especificacionpartecuerpo> especificacionpartecuerpos) {
		this.especificacionpartecuerpos = especificacionpartecuerpos;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.posiRegistradopor=data.get(0);
			this.posiFechacambio=data.get(1);
			this.posiHoracambio=data.get(2);
		}
	}
}