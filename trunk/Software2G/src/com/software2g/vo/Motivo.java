package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import com.software2g.util.ConstantesAplicativo;


/**
 * The persistent class for the motivo database table.
 * 
 */
@Entity
@Table(schema="public", name="Motivo")
public class Motivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="codmotivo")
	private String codmotivo;

	@Column(name="descmov")
	private String descmov;

	@Id
	@SequenceGenerator(name="MOTIVO_IDMOTIVO_GENERATOR", sequenceName="PUBLIC.motivo_id_motivo_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOTIVO_IDMOTIVO_GENERATOR")
	@Column(name="id_motivo")
	private long idMotivo;

	@Column(name="nommotivo")
	private String nommotivo;

	@Transient
	private String helpView;
	
	public Motivo() {
	}

	public String getCodmotivo() {
		return this.codmotivo;
	}

	public void setCodmotivo(String codmotivo) {
		this.codmotivo = codmotivo;
	}

	public String getDescmov() {
		return this.descmov;
	}

	public void setDescmov(String descmov) {
		this.descmov = descmov;
	}

	public long getIdMotivo() {
		return this.idMotivo;
	}

	public void setIdMotivo(long idMotivo) {
		this.idMotivo = idMotivo;
	}

	public String getNommotivo() {
		return this.nommotivo;
	}

	public void setNommotivo(String nommotivo) {
		this.nommotivo = nommotivo;
	}

	public String getListKey(){
		return this.idMotivo+ConstantesAplicativo.constanteSplit+this.codmotivo+ConstantesAplicativo.constanteSplit+this.nommotivo;
	}

	public String getHelpView() {
		return helpView;
	}

	public void setHelpView(String helpView) {
		this.helpView = helpView;
	}
	
}