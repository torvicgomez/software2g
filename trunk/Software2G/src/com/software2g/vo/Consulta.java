package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the consulta database table.
 * 
 */
@Entity
public class Consulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="id_anamnesis")
	private long idAnamnesis;

	@Column(name="id_consulta")
	private long idConsulta;

	@Column(name="id_servicio")
	private long idServicio;

	private String observacion;

	//bi-directional many-to-one association to Tipoespecialidad
	@ManyToOne
	@JoinColumn(name="id_tipoconsulta")
	private Tipoespecialidad tipoespecialidad;

	public Consulta() {
	}

	public long getIdAnamnesis() {
		return this.idAnamnesis;
	}

	public void setIdAnamnesis(long idAnamnesis) {
		this.idAnamnesis = idAnamnesis;
	}

	public long getIdConsulta() {
		return this.idConsulta;
	}

	public void setIdConsulta(long idConsulta) {
		this.idConsulta = idConsulta;
	}

	public long getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Tipoespecialidad getTipoespecialidad() {
		return this.tipoespecialidad;
	}

	public void setTipoespecialidad(Tipoespecialidad tipoespecialidad) {
		this.tipoespecialidad = tipoespecialidad;
	}

}