package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the telefono database table.
 * 
 */
@Entity
@Table(name="telefono", schema="public")
public class Telefono implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TELEFONO_IDTELEFONO_GENERATOR", sequenceName="PUBLIC.TELEFONO_ID_TELEFONO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TELEFONO_IDTELEFONO_GENERATOR")
	@Column(name="id_telefono")
	private long idTelefono;

	private String indicativo;

	private String numtelef;

	//bi-directional many-to-one association to Tipoubicacion
	@ManyToOne
	@JoinColumn(name="id_tipoubicacion")
	private Tipoubicacion tipoubicacion;

	//bi-directional many-to-one association to Ubicaciontelefono
	@OneToMany(mappedBy="telefono")
	private List<Ubicaciontelefono> ubicaciontelefonos;

	public Telefono() {
	}

	public long getIdTelefono() {
		return this.idTelefono;
	}

	public void setIdTelefono(long idTelefono) {
		this.idTelefono = idTelefono;
	}

	public String getIndicativo() {
		return this.indicativo;
	}

	public void setIndicativo(String indicativo) {
		this.indicativo = indicativo;
	}

	public String getNumtelef() {
		return this.numtelef;
	}

	public void setNumtelef(String numtelef) {
		this.numtelef = numtelef;
	}

	public Tipoubicacion getTipoubicacion() {
		return this.tipoubicacion;
	}

	public void setTipoubicacion(Tipoubicacion tipoubicacion) {
		this.tipoubicacion = tipoubicacion;
	}

	public List<Ubicaciontelefono> getUbicaciontelefonos() {
		return this.ubicaciontelefonos;
	}

	public void setUbicaciontelefonos(List<Ubicaciontelefono> ubicaciontelefonos) {
		this.ubicaciontelefonos = ubicaciontelefonos;
	}

}