package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the motivo database table.
 * 
 */
@Entity
@Table(schema="public", name="Motivo")
public class Motivo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codmotivo;

	private String descmov;

	@Id
	@SequenceGenerator(name="MOTIVO_IDMOTIVO_GENERATOR", sequenceName="PUBLIC.motivo_id_motivo_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOTIVO_IDMOTIVO_GENERATOR")
	@Column(name="id_motivo")
	private long idMotivo;

	private String nommotivo;

	public Motivo() {
	}

	public String getCodmotivo() {
		return this.codmotivo;
	}

	public void setCodmotivo(String codmotivo) {
		this.codmotivo = codmotivo;
	}

	public String getDescmov() {
		return this.descmov;
	}

	public void setDescmov(String descmov) {
		this.descmov = descmov;
	}

	public long getIdMotivo() {
		return this.idMotivo;
	}

	public void setIdMotivo(long idMotivo) {
		this.idMotivo = idMotivo;
	}

	public String getNommotivo() {
		return this.nommotivo;
	}

	public void setNommotivo(String nommotivo) {
		this.nommotivo = nommotivo;
	}

}