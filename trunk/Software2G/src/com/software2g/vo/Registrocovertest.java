package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the "REGISTROCOVERTEST" database table.
 * 
 */
@Entity
@Table(name="\"REGISTROCOVERTEST\"", schema="\"HISCLINICA\"")
public class Registrocovertest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REGISTROCOVERTEST_RECTID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_RECT_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REGISTROCOVERTEST_RECTID_GENERATOR")
	@Column(name="rect_id")
	private long rectId;

	@Column(name="rect_cerca")
	private String rectCerca;

	@Column(name="rect_fechacambio")
	private String rectFechacambio;

	@Column(name="rect_horacambio")
	private String rectHoracambio;

	@Column(name="rect_lejos")
	private String rectLejos;

	@Column(name="rect_registradopor")
	private String rectRegistradopor;

	//bi-directional many-to-one association to Especificacionpartecuerpo
	@ManyToOne
	@JoinColumn(name="espc_id")
	private Especificacionpartecuerpo especificacionpartecuerpo;

	//bi-directional many-to-one association to Examenoptometria
	@ManyToOne
	@JoinColumn(name="exop_id")
	private Examenoptometria examenoptometria;

	public Registrocovertest() {
	}

	public long getRectId() {
		return this.rectId;
	}

	public void setRectId(long rectId) {
		this.rectId = rectId;
	}

	public String getRectCerca() {
		return this.rectCerca;
	}

	public void setRectCerca(String rectCerca) {
		this.rectCerca = rectCerca;
	}

	public String getRectFechacambio() {
		return this.rectFechacambio;
	}

	public void setRectFechacambio(String rectFechacambio) {
		this.rectFechacambio = rectFechacambio;
	}

	public String getRectHoracambio() {
		return this.rectHoracambio;
	}

	public void setRectHoracambio(String rectHoracambio) {
		this.rectHoracambio = rectHoracambio;
	}

	public String getRectLejos() {
		return this.rectLejos;
	}

	public void setRectLejos(String rectLejos) {
		this.rectLejos = rectLejos;
	}

	public String getRectRegistradopor() {
		return this.rectRegistradopor;
	}

	public void setRectRegistradopor(String rectRegistradopor) {
		this.rectRegistradopor = rectRegistradopor;
	}

	public Especificacionpartecuerpo getEspecificacionpartecuerpo() {
		return this.especificacionpartecuerpo;
	}

	public void setEspecificacionpartecuerpo(Especificacionpartecuerpo especificacionpartecuerpo) {
		this.especificacionpartecuerpo = especificacionpartecuerpo;
	}

	public Examenoptometria getExamenoptometria() {
		return this.examenoptometria;
	}

	public void setExamenoptometria(Examenoptometria examenoptometria) {
		this.examenoptometria = examenoptometria;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.rectRegistradopor=data.get(0);
			this.rectFechacambio=data.get(1);
			this.rectHoracambio=data.get(2);
		}
	}
}