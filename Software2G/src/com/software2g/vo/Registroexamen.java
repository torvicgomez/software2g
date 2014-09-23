package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the registroexamen database table.
 * 
 */
@Entity
public class Registroexamen implements Serializable {
	private static final long serialVersionUID = 1L;

	private String descregistexa;

	@Column(name="id_esppartecuerpo")
	private long idEsppartecuerpo;

	@Column(name="id_examen")
	private long idExamen;

	@Column(name="id_registexa")
	private long idRegistexa;

	private String valorregistexa;

	//bi-directional many-to-one association to Unidade
	@ManyToOne
	@JoinColumn(name="id_unidad")
	private Unidade unidade;

	//bi-directional many-to-one association to Variableexamen
	@ManyToOne
	@JoinColumn(name="id_varexamen")
	private Variableexamen variableexamen;

	public Registroexamen() {
	}

	public String getDescregistexa() {
		return this.descregistexa;
	}

	public void setDescregistexa(String descregistexa) {
		this.descregistexa = descregistexa;
	}

	public long getIdEsppartecuerpo() {
		return this.idEsppartecuerpo;
	}

	public void setIdEsppartecuerpo(long idEsppartecuerpo) {
		this.idEsppartecuerpo = idEsppartecuerpo;
	}

	public long getIdExamen() {
		return this.idExamen;
	}

	public void setIdExamen(long idExamen) {
		this.idExamen = idExamen;
	}

	public long getIdRegistexa() {
		return this.idRegistexa;
	}

	public void setIdRegistexa(long idRegistexa) {
		this.idRegistexa = idRegistexa;
	}

	public String getValorregistexa() {
		return this.valorregistexa;
	}

	public void setValorregistexa(String valorregistexa) {
		this.valorregistexa = valorregistexa;
	}

	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Variableexamen getVariableexamen() {
		return this.variableexamen;
	}

	public void setVariableexamen(Variableexamen variableexamen) {
		this.variableexamen = variableexamen;
	}

}