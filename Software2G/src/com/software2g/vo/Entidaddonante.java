package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the entidaddonante database table.
 * 
 */
@Entity
@Table(schema="CONTABLE", name="ENTIDADDONANTE")
public class Entidaddonante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENTIDADDONANTE_ENDOID_GENERATOR", sequenceName="CONTABLE.S_ENDO_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENTIDADDONANTE_ENDOID_GENERATOR")
	@Column(name="endo_id")
	private long endoId;

	@Column(name="endo_descripcion")
	private String endoDescripcion;

	@Column(name="endo_fechamodificacion")
	private String endoFechamodificacion;

	@Column(name="endo_hora")
	private String endoHora;

	@Column(name="endo_nit")
	private BigDecimal endoNit;

	@Column(name="endo_razonsocial")
	private String endoRazonsocial;

	@Column(name="endo_registradopor")
	private String endoRegistradopor;

	@Column(name="endo_representantelegal")
	private String endoRepresentantelegal;

	//bi-directional many-to-one association to Donacion
	@OneToMany(mappedBy="entidaddonante")
	private List<Donacion> donacions;

	public Entidaddonante() {
	}

	public long getEndoId() {
		return this.endoId;
	}

	public void setEndoId(long endoId) {
		this.endoId = endoId;
	}

	public String getEndoDescripcion() {
		return this.endoDescripcion;
	}

	public void setEndoDescripcion(String endoDescripcion) {
		this.endoDescripcion = endoDescripcion;
	}

	public String getEndoFechamodificacion() {
		return this.endoFechamodificacion;
	}

	public void setEndoFechamodificacion(String endoFechamodificacion) {
		this.endoFechamodificacion = endoFechamodificacion;
	}

	public String getEndoHora() {
		return this.endoHora;
	}

	public void setEndoHora(String endoHora) {
		this.endoHora = endoHora;
	}

	public BigDecimal getEndoNit() {
		return this.endoNit;
	}

	public void setEndoNit(BigDecimal endoNit) {
		this.endoNit = endoNit;
	}

	public String getEndoRazonsocial() {
		return this.endoRazonsocial;
	}

	public void setEndoRazonsocial(String endoRazonsocial) {
		this.endoRazonsocial = endoRazonsocial;
	}

	public String getEndoRegistradopor() {
		return this.endoRegistradopor;
	}

	public void setEndoRegistradopor(String endoRegistradopor) {
		this.endoRegistradopor = endoRegistradopor;
	}

	public String getEndoRepresentantelegal() {
		return this.endoRepresentantelegal;
	}

	public void setEndoRepresentantelegal(String endoRepresentantelegal) {
		this.endoRepresentantelegal = endoRepresentantelegal;
	}

	public List<Donacion> getDonacions() {
		return this.donacions;
	}

	public void setDonacions(List<Donacion> donacions) {
		this.donacions = donacions;
	}

	
	public Donacion addDonacions(Donacion donacions) {
		getDonacions().add(donacions);
		donacions.setEntidaddonante(this);

		return donacions;
	}

	public Donacion removeDonacions(Donacion donacions) {
		getDonacions().remove(donacions);
		donacions.setEntidaddonante(null);

		return donacions;
	}
}