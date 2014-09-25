package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the tipoubicacion database table.
 * 
 */
@Entity
@Table(name="tipoubicacion", schema="public")
public class Tipoubicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOUBICACION_IDTIPOUBICACION_GENERATOR", sequenceName="PUBLIC.TIPOUBICACION_ID_TIPOUBICACION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOUBICACION_IDTIPOUBICACION_GENERATOR")
	@Column(name="id_tipoubicacion")
	private long idTipoubicacion;

	private int asociaubica;

	private String desctipubi;

	private String logotipubi;

	private String nombretipubi;

	//bi-directional many-to-one association to Direccion
	@OneToMany(mappedBy="tipoubicacion")
	private List<Direccion> direccions;

	//bi-directional many-to-one association to Telefono
	@OneToMany(mappedBy="tipoubicacion")
	private List<Telefono> telefonos;

	public Tipoubicacion() {
	}

	public long getIdTipoubicacion() {
		return this.idTipoubicacion;
	}

	public void setIdTipoubicacion(long idTipoubicacion) {
		this.idTipoubicacion = idTipoubicacion;
	}

	public int getAsociaubica() {
		return this.asociaubica;
	}

	public void setAsociaubica(int asociaubica) {
		this.asociaubica = asociaubica;
	}

	public String getDesctipubi() {
		return this.desctipubi;
	}

	public void setDesctipubi(String desctipubi) {
		this.desctipubi = desctipubi;
	}

	public String getLogotipubi() {
		return this.logotipubi;
	}

	public void setLogotipubi(String logotipubi) {
		this.logotipubi = logotipubi;
	}

	public String getNombretipubi() {
		return this.nombretipubi;
	}

	public void setNombretipubi(String nombretipubi) {
		this.nombretipubi = nombretipubi;
	}

	public List<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(List<Direccion> direccions) {
		this.direccions = direccions;
	}

	public List<Telefono> getTelefonos() {
		return this.telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

}