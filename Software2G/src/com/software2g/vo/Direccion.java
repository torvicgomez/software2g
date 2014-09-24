package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the direccion database table.
 * 
 */
@Entity
@Table(schema="PUBLIC", name="DIRECCION")
public class Direccion implements Serializable {
	private static final long serialVersionUID = 1L;

	private String barrio;

	private String direccion;

	@Id
	@SequenceGenerator(name="DIRECCION_IDDIRECCION_GENERATOR", sequenceName="PUBLIC.direccion_id_direccion_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DIRECCION_IDDIRECCION_GENERATOR")
	@Column(name="id_direccion")
	private long idDireccion;

	@Column(name="id_municipio")
	private long idMunicipio;

	//bi-directional many-to-one association to Tipoubicacion
	@ManyToOne
	@JoinColumn(name="id_tipoubicacion")
	private Tipoubicacion tipoubicacion;

	public Direccion() {
	}

	public String getBarrio() {
		return this.barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public long getIdDireccion() {
		return this.idDireccion;
	}

	public void setIdDireccion(long idDireccion) {
		this.idDireccion = idDireccion;
	}

	public long getIdMunicipio() {
		return this.idMunicipio;
	}

	public void setIdMunicipio(long idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public Tipoubicacion getTipoubicacion() {
		return this.tipoubicacion;
	}

	public void setTipoubicacion(Tipoubicacion tipoubicacion) {
		this.tipoubicacion = tipoubicacion;
	}

}