package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the paciente database table.
 * 
 */
@Entity
@Table(schema="public", name="paciente")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	private int estado;

	@Column(name="id_municipio")
	private long idMunicipio;

	@Id
	@SequenceGenerator(name="PACIENTE_IDPACIENTE_GENERATOR", sequenceName="PUBLIC.paciente_id_paciente_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PACIENTE_IDPACIENTE_GENERATOR")
	@Column(name="id_paciente")
	private long idPaciente;

	@Column(name="id_persona")
	private long idPersona;

	private String ocupacion;

	//bi-directional many-to-one association to Seguridadsocial
	@ManyToOne
	@JoinColumn(name="id_seguridad")
	private Seguridadsocial seguridadsocial;

	public Paciente() {
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public long getIdMunicipio() {
		return this.idMunicipio;
	}

	public void setIdMunicipio(long idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public long getIdPaciente() {
		return this.idPaciente;
	}

	public void setIdPaciente(long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public long getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}

	public String getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public Seguridadsocial getSeguridadsocial() {
		return this.seguridadsocial;
	}

	public void setSeguridadsocial(Seguridadsocial seguridadsocial) {
		this.seguridadsocial = seguridadsocial;
	}

}