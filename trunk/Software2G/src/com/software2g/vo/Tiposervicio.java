package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tiposervicio database table.
 * 
 */
@Entity
public class Tiposervicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOSERVICIO_IDTIPOSERVICIO_GENERATOR", sequenceName="PUBLIC.TIPOSERVICIO_ID_TIPOSERVICIO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOSERVICIO_IDTIPOSERVICIO_GENERATOR")
	@Column(name="id_tiposervicio")
	private long idTiposervicio;

	private String codtiposerv;

	private String desctiposerv;

	private String nomtiposerv;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="tiposervicio")
	private List<Servicio> servicios;

	public Tiposervicio() {
	}

	public long getIdTiposervicio() {
		return this.idTiposervicio;
	}

	public void setIdTiposervicio(long idTiposervicio) {
		this.idTiposervicio = idTiposervicio;
	}

	public String getCodtiposerv() {
		return this.codtiposerv;
	}

	public void setCodtiposerv(String codtiposerv) {
		this.codtiposerv = codtiposerv;
	}

	public String getDesctiposerv() {
		return this.desctiposerv;
	}

	public void setDesctiposerv(String desctiposerv) {
		this.desctiposerv = desctiposerv;
	}

	public String getNomtiposerv() {
		return this.nomtiposerv;
	}

	public void setNomtiposerv(String nomtiposerv) {
		this.nomtiposerv = nomtiposerv;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

}