package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the especificacionpartecuerpo database table.
 * 
 */
@Entity
@Table(schema="public", name="especificacionpartecuerpo")
public class Especificacionpartecuerpo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String abreviaturaparcuer;

	private String descpartecuerpo;

	@Id
	@SequenceGenerator(name="ESPECIFICACIONPARTECUERPO_IDESPECIFICACIONPARTECUERPO_GENERATOR", sequenceName="PUBLIC.especificacionpartecuerpo_id_esppartecuerpo_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESPECIFICACIONPARTECUERPO_IDESPECIFICACIONPARTECUERPO_GENERATOR")
	@Column(name="id_esppartecuerpo")
	private long idEsppartecuerpo;

	@Column(name="id_partescuerpo")
	private long idPartescuerpo;

	@Column(name="id_posicion")
	private long idPosicion;

	private String nombrepartecuerpo;

	public Especificacionpartecuerpo() {
	}

	public String getAbreviaturaparcuer() {
		return this.abreviaturaparcuer;
	}

	public void setAbreviaturaparcuer(String abreviaturaparcuer) {
		this.abreviaturaparcuer = abreviaturaparcuer;
	}

	public String getDescpartecuerpo() {
		return this.descpartecuerpo;
	}

	public void setDescpartecuerpo(String descpartecuerpo) {
		this.descpartecuerpo = descpartecuerpo;
	}

	public long getIdEsppartecuerpo() {
		return this.idEsppartecuerpo;
	}

	public void setIdEsppartecuerpo(long idEsppartecuerpo) {
		this.idEsppartecuerpo = idEsppartecuerpo;
	}

	public long getIdPartescuerpo() {
		return this.idPartescuerpo;
	}

	public void setIdPartescuerpo(long idPartescuerpo) {
		this.idPartescuerpo = idPartescuerpo;
	}

	public long getIdPosicion() {
		return this.idPosicion;
	}

	public void setIdPosicion(long idPosicion) {
		this.idPosicion = idPosicion;
	}

	public String getNombrepartecuerpo() {
		return this.nombrepartecuerpo;
	}

	public void setNombrepartecuerpo(String nombrepartecuerpo) {
		this.nombrepartecuerpo = nombrepartecuerpo;
	}

}