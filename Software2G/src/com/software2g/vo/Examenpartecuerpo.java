package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the examenpartecuerpo database table.
 * 
 */
@Entity
@Table(name="examenpartecuerpo", schema="public") 
public class Examenpartecuerpo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_especiexam")
	private long idEspeciexam;

	@Id
	@Column(name="id_partescuerpo")
	private long idPartescuerpo;

	public Examenpartecuerpo() {
	}

	public long getIdEspeciexam() {
		return this.idEspeciexam;
	}

	public void setIdEspeciexam(long idEspeciexam) {
		this.idEspeciexam = idEspeciexam;
	}

	public long getIdPartescuerpo() {
		return this.idPartescuerpo;
	}

	public void setIdPartescuerpo(long idPartescuerpo) {
		this.idPartescuerpo = idPartescuerpo;
	}

}