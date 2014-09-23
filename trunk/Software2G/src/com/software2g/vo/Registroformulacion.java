package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the registroformulacion database table.
 * 
 */
@Entity
public class Registroformulacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REGISTROFORMULACION_IDREGISTROFORM_GENERATOR", sequenceName="PUBLIC.REGISTROFORMULACION_ID_REGISTROFORM_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REGISTROFORMULACION_IDREGISTROFORM_GENERATOR")
	@Column(name="id_registroform")
	private long idRegistroform;

	private String descregisform;

	@Column(name="id_esppartecuerpo")
	private long idEsppartecuerpo;

	@Column(name="id_formulacion")
	private long idFormulacion;

	private String valorregisform;

	//bi-directional many-to-one association to Unidade
	@ManyToOne
	@JoinColumn(name="id_unidad")
	private Unidade unidade;

	//bi-directional many-to-one association to Variableformulacion
	@ManyToOne
	@JoinColumn(name="id_valorform")
	private Variableformulacion variableformulacion;

	public Registroformulacion() {
	}

	public long getIdRegistroform() {
		return this.idRegistroform;
	}

	public void setIdRegistroform(long idRegistroform) {
		this.idRegistroform = idRegistroform;
	}

	public String getDescregisform() {
		return this.descregisform;
	}

	public void setDescregisform(String descregisform) {
		this.descregisform = descregisform;
	}

	public long getIdEsppartecuerpo() {
		return this.idEsppartecuerpo;
	}

	public void setIdEsppartecuerpo(long idEsppartecuerpo) {
		this.idEsppartecuerpo = idEsppartecuerpo;
	}

	public long getIdFormulacion() {
		return this.idFormulacion;
	}

	public void setIdFormulacion(long idFormulacion) {
		this.idFormulacion = idFormulacion;
	}

	public String getValorregisform() {
		return this.valorregisform;
	}

	public void setValorregisform(String valorregisform) {
		this.valorregisform = valorregisform;
	}

	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Variableformulacion getVariableformulacion() {
		return this.variableformulacion;
	}

	public void setVariableformulacion(Variableformulacion variableformulacion) {
		this.variableformulacion = variableformulacion;
	}

}