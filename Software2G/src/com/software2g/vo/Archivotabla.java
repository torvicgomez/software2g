package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the archivotabla database table.
 * 
 */
@Entity
@Table(name="ARCHIVOTABLA", schema="NIIF") 
public class Archivotabla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ARCHIVOTABLA_ARTAID_GENERATOR", sequenceName="NIIF.SEQ_ARTA_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ARCHIVOTABLA_ARTAID_GENERATOR")
	@Column(name="arta_id")
	private long artaId;

	@Column(name="arta_archguardado")
	private String artaArchguardado;

	@Column(name="arta_archoriginal")
	private String artaArchoriginal;

	@Column(name="arta_estado")
	private String artaEstado;

	@Column(name="arta_fechacambio")
	private String artaFechacambio;

	@Column(name="arta_horacambio")
	private String artaHoracambio;

	@Column(name="arta_idtabla")
	private String artaIdtabla;

	@Column(name="arta_registradopor")
	private String artaRegistradopor;

	@Column(name="arta_ruta")
	private String artaRuta;

	@Column(name="arta_tabla")
	private String artaTabla;

	@Transient
	private String rutaAlterna;
	
	public Archivotabla() {
	}

	public long getArtaId() {
		return this.artaId;
	}

	public void setArtaId(long artaId) {
		this.artaId = artaId;
	}

	public String getArtaArchguardado() {
		return this.artaArchguardado;
	}

	public void setArtaArchguardado(String artaArchguardado) {
		this.artaArchguardado = artaArchguardado;
	}

	public String getArtaArchoriginal() {
		return this.artaArchoriginal;
	}

	public void setArtaArchoriginal(String artaArchoriginal) {
		this.artaArchoriginal = artaArchoriginal;
	}

	public String getArtaEstado() {
		return this.artaEstado;
	}

	public void setArtaEstado(String artaEstado) {
		this.artaEstado = artaEstado;
	}

	public String getArtaFechacambio() {
		return this.artaFechacambio;
	}

	public void setArtaFechacambio(String artaFechacambio) {
		this.artaFechacambio = artaFechacambio;
	}

	public String getArtaHoracambio() {
		return this.artaHoracambio;
	}

	public void setArtaHoracambio(String artaHoracambio) {
		this.artaHoracambio = artaHoracambio;
	}

	public String getArtaIdtabla() {
		return this.artaIdtabla;
	}

	public void setArtaIdtabla(String artaIdtabla) {
		this.artaIdtabla = artaIdtabla;
	}

	public String getArtaRegistradopor() {
		return this.artaRegistradopor;
	}

	public void setArtaRegistradopor(String artaRegistradopor) {
		this.artaRegistradopor = artaRegistradopor;
	}

	public String getArtaRuta() {
		return this.artaRuta;
	}

	public void setArtaRuta(String artaRuta) {
		this.artaRuta = artaRuta;
	}

	public String getArtaTabla() {
		return this.artaTabla;
	}

	public void setArtaTabla(String artaTabla) {
		this.artaTabla = artaTabla;
	}
	
	
	public String getRutaAlterna() {
		return rutaAlterna;
	}

	public void setRutaAlterna(String rutaAlterna) {
		this.rutaAlterna = rutaAlterna;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.artaRegistradopor=data.get(0);
			this.artaFechacambio=data.get(1);
			this.artaHoracambio=data.get(2);
		}
	}
	
}