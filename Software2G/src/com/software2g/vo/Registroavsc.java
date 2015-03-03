package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the "REGISTROAVSC" database table.
 * 
 */
@Entity
@Table(name="\"REGISTROAVSC\"", schema="\"HISCLINICA\"")
public class Registroavsc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REGISTROAVSC_AVSCID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_AVSC_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REGISTROAVSC_AVSCID_GENERATOR")
	@Column(name="avsc_id")
	private long avscId;

	@Column(name="avsc_avc")
	private String avscAvc;

	@Column(name="avsc_avl")
	private String avscAvl;

	@Column(name="avsc_fechacambio")
	private String avscFechacambio;

	@Column(name="avsc_horacambio")
	private String avscHoracambio;

	@Column(name="avsc_registradopor")
	private String avscRegistradopor;

	//bi-directional many-to-one association to Especificacionpartecuerpo
	@ManyToOne
	@JoinColumn(name="espc_id")
	private Especificacionpartecuerpo especificacionpartecuerpo;

	//bi-directional many-to-one association to Examenoptometria
	@ManyToOne
	@JoinColumn(name="exop_id")
	private Examenoptometria examenoptometria;

	public Registroavsc() {
	}

	public long getAvscId() {
		return this.avscId;
	}

	public void setAvscId(long avscId) {
		this.avscId = avscId;
	}

	public String getAvscAvc() {
		return this.avscAvc;
	}

	public void setAvscAvc(String avscAvc) {
		this.avscAvc = avscAvc;
	}

	public String getAvscAvl() {
		return this.avscAvl;
	}

	public void setAvscAvl(String avscAvl) {
		this.avscAvl = avscAvl;
	}

	public String getAvscFechacambio() {
		return this.avscFechacambio;
	}

	public void setAvscFechacambio(String avscFechacambio) {
		this.avscFechacambio = avscFechacambio;
	}

	public String getAvscHoracambio() {
		return this.avscHoracambio;
	}

	public void setAvscHoracambio(String avscHoracambio) {
		this.avscHoracambio = avscHoracambio;
	}

	public String getAvscRegistradopor() {
		return this.avscRegistradopor;
	}

	public void setAvscRegistradopor(String avscRegistradopor) {
		this.avscRegistradopor = avscRegistradopor;
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
			this.avscRegistradopor=data.get(0);
			this.avscFechacambio=data.get(1);
			this.avscHoracambio=data.get(2);
		}
	}
}