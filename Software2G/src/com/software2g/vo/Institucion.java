package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the institucion database table.
 * 
 */
@Entity
@Table(schema="PORTAL", name="INSTITUCION")
public class Institucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INSTITUCION_IDINST_GENERATOR", sequenceName="PORTAL.SEQ_INSTITUCION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INSTITUCION_IDINST_GENERATOR")
	@Column(name="id_inst")
	private Integer idInst;

	@Column(name="estado_inst")
	private String estadoInst;

	private String fechacambio;

	private String horacambio;

	@Column(name="nombre_inst")
	private String nombreInst;

	@Column(name="razonsocial_inst")
	private String razonsocialInst;

	private String registradopor;

	//bi-directional many-to-one association to Personainstitucion
	@OneToMany(mappedBy="institucion")
	private List<Personainstitucion> personainstitucions;

	//bi-directional many-to-one association to Tipopagare
	@ManyToOne
	@JoinColumn(name="id_tipoinst")
	private Tipodocumentoinst tipodocumentoinst;
	
	public Institucion() {
	}

	public Integer getIdInst() {
		return this.idInst;
	}

	public void setIdInst(Integer idInst) {
		this.idInst = idInst;
	}

	public String getEstadoInst() {
		return this.estadoInst;
	}

	public void setEstadoInst(String estadoInst) {
		this.estadoInst = estadoInst;
	}

	public String getFechacambio() {
		return this.fechacambio;
	}

	public void setFechacambio(String fechacambio) {
		this.fechacambio = fechacambio;
	}

	public String getHoracambio() {
		return this.horacambio;
	}

	public void setHoracambio(String horacambio) {
		this.horacambio = horacambio;
	}

	public String getNombreInst() {
		return this.nombreInst;
	}

	public void setNombreInst(String nombreInst) {
		this.nombreInst = nombreInst;
	}

	public String getRazonsocialInst() {
		return this.razonsocialInst;
	}

	public void setRazonsocialInst(String razonsocialInst) {
		this.razonsocialInst = razonsocialInst;
	}

	public String getRegistradopor() {
		return this.registradopor;
	}

	public void setRegistradopor(String registradopor) {
		this.registradopor = registradopor;
	}

	public List<Personainstitucion> getPersonainstitucions() {
		return this.personainstitucions;
	}

	public void setPersonainstitucions(List<Personainstitucion> personainstitucions) {
		this.personainstitucions = personainstitucions;
	}

	public Tipodocumentoinst getTipodocumentoinst() {
		return tipodocumentoinst;
	}

	public void setTipodocumentoinst(Tipodocumentoinst tipodocumentoinst) {
		this.tipodocumentoinst = tipodocumentoinst;
	}

}