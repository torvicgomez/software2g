package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the "ARCHIVOSERVICIO" database table.
 * 
 */
@Entity
@Table(name="\"ARCHIVOSERVICIO\"", schema="\"HISCLINICA\"")
public class Archivoservicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ARCHIVOSERVICIO_ARSEID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_ARSE_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ARCHIVOSERVICIO_ARSEID_GENERATOR")
	@Column(name="arse_id")
	private long arseId;

	@Column(name="arse_archivoestado")
	private String arseArchivoestado;

	@Column(name="arse_archivoori")
	private String arseArchivoori;

	@Column(name="arse_archivoruta")
	private String arseArchivoruta;

	@Column(name="arse_archivosave")
	private String arseArchivosave;

	@Column(name="arse_fechacambio")
	private String arseFechacambio;

	@Column(name="arse_horacambio")
	private String arseHoracambio;

	@Column(name="arse_idservicio")
	private String arseIdservicio;

	@Column(name="arse_registradopor")
	private String arseRegistradopor;

	public Archivoservicio() {
	}

	public long getArseId() {
		return this.arseId;
	}

	public void setArseId(long arseId) {
		this.arseId = arseId;
	}

	public String getArseArchivoestado() {
		return this.arseArchivoestado;
	}

	public void setArseArchivoestado(String arseArchivoestado) {
		this.arseArchivoestado = arseArchivoestado;
	}

	public String getArseArchivoori() {
		return this.arseArchivoori;
	}

	public void setArseArchivoori(String arseArchivoori) {
		this.arseArchivoori = arseArchivoori;
	}

	public String getArseArchivoruta() {
		return this.arseArchivoruta;
	}

	public void setArseArchivoruta(String arseArchivoruta) {
		this.arseArchivoruta = arseArchivoruta;
	}

	public String getArseArchivosave() {
		return this.arseArchivosave;
	}

	public void setArseArchivosave(String arseArchivosave) {
		this.arseArchivosave = arseArchivosave;
	}

	public String getArseFechacambio() {
		return this.arseFechacambio;
	}

	public void setArseFechacambio(String arseFechacambio) {
		this.arseFechacambio = arseFechacambio;
	}

	public String getArseHoracambio() {
		return this.arseHoracambio;
	}

	public void setArseHoracambio(String arseHoracambio) {
		this.arseHoracambio = arseHoracambio;
	}

	public String getArseIdservicio() {
		return this.arseIdservicio;
	}

	public void setArseIdservicio(String arseIdservicio) {
		this.arseIdservicio = arseIdservicio;
	}

	public String getArseRegistradopor() {
		return this.arseRegistradopor;
	}

	public void setArseRegistradopor(String arseRegistradopor) {
		this.arseRegistradopor = arseRegistradopor;
	}
	
	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.arseRegistradopor=data.get(0);
			this.arseFechacambio=data.get(1);
			this.arseHoracambio=data.get(2);
		}
	}
}