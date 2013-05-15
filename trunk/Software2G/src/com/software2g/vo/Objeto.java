package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the objeto database table.
 * 
 */
@Entity
@Table(schema="CONTABLE", name="OBJETO")
public class Objeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OBJETO_OBJEID_GENERATOR", sequenceName="CONTABLE.S_OBJE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OBJETO_OBJEID_GENERATOR")
	@Column(name="obje_id")
	private long objeId;

	@Column(name="obje_descripcion")
	private String objeDescripcion;

	@Column(name="obje_fechamodificacion")
	private String objeFechamodificacion;

	@Column(name="obje_hora")
	private String objeHora;

	@Column(name="obje_motivo")
	private String objeMotivo;

	@Column(name="obje_registradopor")
	private String objeRegistradopor;

	//bi-directional many-to-one association to Donacionobjeto
	@OneToMany(mappedBy="objeto")
	private List<Donacionobjeto> donacionobjetos;

	public Objeto() {
	}

	public long getObjeId() {
		return this.objeId;
	}

	public void setObjeId(long objeId) {
		this.objeId = objeId;
	}

	public String getObjeDescripcion() {
		return this.objeDescripcion;
	}

	public void setObjeDescripcion(String objeDescripcion) {
		this.objeDescripcion = objeDescripcion;
	}

	public String getObjeFechamodificacion() {
		return this.objeFechamodificacion;
	}

	public void setObjeFechamodificacion(String objeFechamodificacion) {
		this.objeFechamodificacion = objeFechamodificacion;
	}

	public String getObjeHora() {
		return this.objeHora;
	}

	public void setObjeHora(String objeHora) {
		this.objeHora = objeHora;
	}

	public String getObjeMotivo() {
		return this.objeMotivo;
	}

	public void setObjeMotivo(String objeMotivo) {
		this.objeMotivo = objeMotivo;
	}

	public String getObjeRegistradopor() {
		return this.objeRegistradopor;
	}

	public void setObjeRegistradopor(String objeRegistradopor) {
		this.objeRegistradopor = objeRegistradopor;
	}

	public List<Donacionobjeto> getDonacionobjetos() {
		return this.donacionobjetos;
	}

	public void setDonacionobjetos(List<Donacionobjeto> donacionobjetos) {
		this.donacionobjetos = donacionobjetos;
	}

	
	public Donacionobjeto addDonacionobjetos(Donacionobjeto donacionobjetos) {
		getDonacionobjetos().add(donacionobjetos);
		donacionobjetos.setObjeto(this);

		return donacionobjetos;
	}

	public Donacionobjeto removeDonacionobjetos(Donacionobjeto donacionobjetos) {
		getDonacionobjetos().remove(donacionobjetos);
		donacionobjetos.setObjeto(null);

		return donacionobjetos;
	}
}