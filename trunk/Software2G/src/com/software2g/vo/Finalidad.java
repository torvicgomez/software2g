package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import com.software2g.util.ConstantesAplicativo;


/**
 * The persistent class for the finalidad database table.
 * 
 */
@Entity
@Table(schema="public", name="finalidad")
public class Finalidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="codfinalidad")
	private String codfinalidad;

	@Column(name="descfinalidad")
	private String descfinalidad;

	@Id
	@SequenceGenerator(name="FINALIDAD_IDFINALIDAD_GENERATOR", sequenceName="PUBLIC.finalidad_id_finalidad_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FINALIDAD_IDFINALIDAD_GENERATOR")
	@Column(name="id_finalidad")
	private long idFinalidad;

	@Column(name="nomfinalidad")
	private String nomfinalidad;

	@Transient
	private String helpView;
	
	public Finalidad() {
	}

	public String getCodfinalidad() {
		return this.codfinalidad;
	}

	public void setCodfinalidad(String codfinalidad) {
		this.codfinalidad = codfinalidad;
	}

	public String getDescfinalidad() {
		return this.descfinalidad;
	}

	public void setDescfinalidad(String descfinalidad) {
		this.descfinalidad = descfinalidad;
	}

	public long getIdFinalidad() {
		return this.idFinalidad;
	}

	public void setIdFinalidad(long idFinalidad) {
		this.idFinalidad = idFinalidad;
	}

	public String getNomfinalidad() {
		return this.nomfinalidad;
	}

	public void setNomfinalidad(String nomfinalidad) {
		this.nomfinalidad = nomfinalidad;
	}

	public String getListKey(){
		return this.idFinalidad+ConstantesAplicativo.constanteSplit+this.codfinalidad+ConstantesAplicativo.constanteSplit+this.nomfinalidad;
	}

	public String getHelpView() {
		return helpView;
	}

	public void setHelpView(String helpView) {
		this.helpView = helpView;
	}

	
}