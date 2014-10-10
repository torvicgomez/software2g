package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the variableexamen database table.
 * 
 */
@Entity
@Table(name="variableexamen", schema="public")
public class Variableexamen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VARIABLEEXAMEN_IDVAREXAMEN_GENERATOR", sequenceName="PUBLIC.VARIABLEEXAMEN_ID_VAREXAMEN_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VARIABLEEXAMEN_IDVAREXAMEN_GENERATOR")
	@Column(name="id_varexamen")
	private long idVarexamen;

	@Column(name="abrevaexamen")
	private String abrevaexamen;

	@Column(name="descvarexam")
	private String descvarexam;

	@Column(name="estadovarexam")
	private boolean estadovarexam;

	@Column(name="id_especiexam")
	private long idEspeciexam;

	@Column(name="nomvarexam")
	private String nomvarexam;

	//bi-directional many-to-one association to Registroexamen
	@OneToMany(mappedBy="variableexamen")
	private List<Registroexamen> registroexamens;

	//bi-directional many-to-one association to Tipodato
	@ManyToOne
	@JoinColumn(name="id_tipodato")
	private Tipodato tipodato;

	//bi-directional many-to-many association to Unidade
	@ManyToMany
	@JoinTable(
		name="variableunidad"
		, joinColumns={
			@JoinColumn(name="id_varexamen")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_unidad")
			}
		)
	private List<Unidade> unidades;

	@Column(name="vaex_orden")
	private int vaexorden;
	
	@Transient
	private List<Valorexamen> listValorExamen;
	
	public Variableexamen() {
	}

	public long getIdVarexamen() {
		return this.idVarexamen;
	}

	public void setIdVarexamen(long idVarexamen) {
		this.idVarexamen = idVarexamen;
	}

	public String getAbrevaexamen() {
		return this.abrevaexamen;
	}

	public void setAbrevaexamen(String abrevaexamen) {
		this.abrevaexamen = abrevaexamen;
	}

	public String getDescvarexam() {
		return this.descvarexam;
	}

	public void setDescvarexam(String descvarexam) {
		this.descvarexam = descvarexam;
	}

	public boolean getEstadovarexam() {
		return this.estadovarexam;
	}

	public void setEstadovarexam(boolean estadovarexam) {
		this.estadovarexam = estadovarexam;
	}

	public long getIdEspeciexam() {
		return this.idEspeciexam;
	}

	public void setIdEspeciexam(long idEspeciexam) {
		this.idEspeciexam = idEspeciexam;
	}

	public String getNomvarexam() {
		return this.nomvarexam;
	}

	public void setNomvarexam(String nomvarexam) {
		this.nomvarexam = nomvarexam;
	}

	public List<Registroexamen> getRegistroexamens() {
		return this.registroexamens;
	}

	public void setRegistroexamens(List<Registroexamen> registroexamens) {
		this.registroexamens = registroexamens;
	}

	public Tipodato getTipodato() {
		return this.tipodato;
	}

	public void setTipodato(Tipodato tipodato) {
		this.tipodato = tipodato;
	}

	public List<Unidade> getUnidades() {
		return this.unidades;
	}

	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}

	public int getVaexorden() {
		return vaexorden;
	}

	public void setVaexorden(int vaexorden) {
		this.vaexorden = vaexorden;
	}

	public List<Valorexamen> getListValorExamen() {
		return listValorExamen;
	}

	public void setListValorExamen(List<Valorexamen> listValorExamen) {
		this.listValorExamen = listValorExamen;
	}

}