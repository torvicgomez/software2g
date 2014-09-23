package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the acudiente database table.
 * 
 */
@Entity
public class Acudiente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACUDIENTE_IDACUDIENTE_GENERATOR", sequenceName="PUBLIC.ACUDIENTE_ID_ACUDIENTE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACUDIENTE_IDACUDIENTE_GENERATOR")
	@Column(name="id_acudiente")
	private long idAcudiente;

	@Column(name="id_parentesco")
	private long idParentesco;

	@Column(name="id_persona")
	private long idPersona;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="acudiente")
	private List<Servicio> servicios;

	public Acudiente() {
	}

	public long getIdAcudiente() {
		return this.idAcudiente;
	}

	public void setIdAcudiente(long idAcudiente) {
		this.idAcudiente = idAcudiente;
	}

	public long getIdParentesco() {
		return this.idParentesco;
	}

	public void setIdParentesco(long idParentesco) {
		this.idParentesco = idParentesco;
	}

	public long getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

}