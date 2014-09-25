package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the variableformulacion database table.
 * 
 */
@Entity
@Table(name="variableformulacion", schema="public")
public class Variableformulacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VARIABLEFORMULACION_IDVALORFORM_GENERATOR", sequenceName="PUBLIC.VARIABLEFORMULACION_ID_VALORFORM_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VARIABLEFORMULACION_IDVALORFORM_GENERATOR")
	@Column(name="id_valorform")
	private long idValorform;

	private String abrevaformulacion;

	private String descvalform;

	private boolean estadovalform;

	@Column(name="id_especificaformula")
	private long idEspecificaformula;

	private String nomvalorform;

	//bi-directional many-to-one association to Registroformulacion
	@OneToMany(mappedBy="variableformulacion")
	private List<Registroformulacion> registroformulacions;

	//bi-directional many-to-many association to Unidade
	@ManyToMany
	@JoinTable(
		name="valorformunid"
		, joinColumns={
			@JoinColumn(name="id_valorform")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_unidad")
			}
		)
	private List<Unidade> unidades;

	//bi-directional many-to-one association to Tipodato
	@ManyToOne
	@JoinColumn(name="id_tipodato")
	private Tipodato tipodato;

	public Variableformulacion() {
	}

	public long getIdValorform() {
		return this.idValorform;
	}

	public void setIdValorform(long idValorform) {
		this.idValorform = idValorform;
	}

	public String getAbrevaformulacion() {
		return this.abrevaformulacion;
	}

	public void setAbrevaformulacion(String abrevaformulacion) {
		this.abrevaformulacion = abrevaformulacion;
	}

	public String getDescvalform() {
		return this.descvalform;
	}

	public void setDescvalform(String descvalform) {
		this.descvalform = descvalform;
	}

	public boolean getEstadovalform() {
		return this.estadovalform;
	}

	public void setEstadovalform(boolean estadovalform) {
		this.estadovalform = estadovalform;
	}

	public long getIdEspecificaformula() {
		return this.idEspecificaformula;
	}

	public void setIdEspecificaformula(long idEspecificaformula) {
		this.idEspecificaformula = idEspecificaformula;
	}

	public String getNomvalorform() {
		return this.nomvalorform;
	}

	public void setNomvalorform(String nomvalorform) {
		this.nomvalorform = nomvalorform;
	}

	public List<Registroformulacion> getRegistroformulacions() {
		return this.registroformulacions;
	}

	public void setRegistroformulacions(List<Registroformulacion> registroformulacions) {
		this.registroformulacions = registroformulacions;
	}

	public List<Unidade> getUnidades() {
		return this.unidades;
	}

	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}

	public Tipodato getTipodato() {
		return this.tipodato;
	}

	public void setTipodato(Tipodato tipodato) {
		this.tipodato = tipodato;
	}

}