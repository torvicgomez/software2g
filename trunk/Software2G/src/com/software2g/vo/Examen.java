package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the examen database table.
 * 
 */
@Entity
public class Examen implements Serializable {
	private static final long serialVersionUID = 1L;

	private String descexamen;

	@Column(name="id_especiexam")
	private long idEspeciexam;

	@Column(name="id_examen")
	private long idExamen;

	@Column(name="id_servicio")
	private long idServicio;

	public Examen() {
	}

	public String getDescexamen() {
		return this.descexamen;
	}

	public void setDescexamen(String descexamen) {
		this.descexamen = descexamen;
	}

	public long getIdEspeciexam() {
		return this.idEspeciexam;
	}

	public void setIdEspeciexam(long idEspeciexam) {
		this.idEspeciexam = idEspeciexam;
	}

	public long getIdExamen() {
		return this.idExamen;
	}

	public void setIdExamen(long idExamen) {
		this.idExamen = idExamen;
	}

	public long getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}

}