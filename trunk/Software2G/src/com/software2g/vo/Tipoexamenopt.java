package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "TIPOEXAMENOPT" database table.
 * 
 */
@Entity
@Table(name="\"TIPOEXAMENOPT\"", schema="\"HISCLINICA\"")
public class Tipoexamenopt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOEXAMENOPT_TIEXID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_TIEX_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOEXAMENOPT_TIEXID_GENERATOR")
	@Column(name="tiex_id")
	private long tiexId;

	@Column(name="tiex_abreviatura")
	private String tiexAbreviatura;

	@Column(name="tiex_fechacambio")
	private String tiexFechacambio;

	@Column(name="tiex_horacambio")
	private String tiexHoracambio;

	@Column(name="tiex_nombre")
	private String tiexNombre;

	@Column(name="tiex_registradopor")
	private String tiexRegistradopor;

	//bi-directional many-to-one association to Registroexamensimple
	@OneToMany(mappedBy="tipoexamenopt")
	private List<Registroexamensimple> registroexamensimples;

	public Tipoexamenopt() {
	}

	public long getTiexId() {
		return this.tiexId;
	}

	public void setTiexId(long tiexId) {
		this.tiexId = tiexId;
	}

	public String getTiexAbreviatura() {
		return this.tiexAbreviatura;
	}

	public void setTiexAbreviatura(String tiexAbreviatura) {
		this.tiexAbreviatura = tiexAbreviatura;
	}

	public String getTiexFechacambio() {
		return this.tiexFechacambio;
	}

	public void setTiexFechacambio(String tiexFechacambio) {
		this.tiexFechacambio = tiexFechacambio;
	}

	public String getTiexHoracambio() {
		return this.tiexHoracambio;
	}

	public void setTiexHoracambio(String tiexHoracambio) {
		this.tiexHoracambio = tiexHoracambio;
	}

	public String getTiexNombre() {
		return this.tiexNombre;
	}

	public void setTiexNombre(String tiexNombre) {
		this.tiexNombre = tiexNombre;
	}

	public String getTiexRegistradopor() {
		return this.tiexRegistradopor;
	}

	public void setTiexRegistradopor(String tiexRegistradopor) {
		this.tiexRegistradopor = tiexRegistradopor;
	}

	public List<Registroexamensimple> getRegistroexamensimples() {
		return this.registroexamensimples;
	}

	public void setRegistroexamensimples(List<Registroexamensimple> registroexamensimples) {
		this.registroexamensimples = registroexamensimples;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.tiexRegistradopor=data.get(0);
			this.tiexFechacambio=data.get(1);
			this.tiexHoracambio=data.get(2);
		}
	}
}