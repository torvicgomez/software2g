package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the "REGISTRORXUSO" database table.
 * 
 */
@Entity
@Table(name="\"REGISTRORXUSO\"", schema="\"HISCLINICA\"")
public class Registrorxuso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REGISTRORXUSO_RERUID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_RERU_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REGISTRORXUSO_RERUID_GENERATOR")
	@Column(name="reru_id")
	private long reruId;

	@Column(name="reru_add")
	private String reruAdd;

	@Column(name="reru_avc")
	private String reruAvc;

	@Column(name="reru_avl")
	private String reruAvl;

	@Column(name="reru_cilindro")
	private String reruCilindro;

	@Column(name="reru_eje")
	private String reruEje;

	@Column(name="reru_esfera")
	private String reruEsfera;

	@Column(name="reru_fechacambio")
	private String reruFechacambio;

	@Column(name="reru_horacambio")
	private String reruHoracambio;

	@Column(name="reru_registradopor")
	private String reruRegistradopor;

	//bi-directional many-to-one association to Especificacionpartecuerpo
	@ManyToOne
	@JoinColumn(name="espc_id")
	private Especificacionpartecuerpo especificacionpartecuerpo;

	//bi-directional many-to-one association to Examenoptometria
	@ManyToOne
	@JoinColumn(name="exop_id")
	private Examenoptometria examenoptometria;

	public Registrorxuso() {
	}

	public long getReruId() {
		return this.reruId;
	}

	public void setReruId(long reruId) {
		this.reruId = reruId;
	}

	public String getReruAdd() {
		return this.reruAdd;
	}

	public void setReruAdd(String reruAdd) {
		this.reruAdd = reruAdd;
	}

	public String getReruAvc() {
		return this.reruAvc;
	}

	public void setReruAvc(String reruAvc) {
		this.reruAvc = reruAvc;
	}

	public String getReruAvl() {
		return this.reruAvl;
	}

	public void setReruAvl(String reruAvl) {
		this.reruAvl = reruAvl;
	}

	public String getReruCilindro() {
		return this.reruCilindro;
	}

	public void setReruCilindro(String reruCilindro) {
		this.reruCilindro = reruCilindro;
	}

	public String getReruEje() {
		return this.reruEje;
	}

	public void setReruEje(String reruEje) {
		this.reruEje = reruEje;
	}

	public String getReruEsfera() {
		return this.reruEsfera;
	}

	public void setReruEsfera(String reruEsfera) {
		this.reruEsfera = reruEsfera;
	}

	public String getReruFechacambio() {
		return this.reruFechacambio;
	}

	public void setReruFechacambio(String reruFechacambio) {
		this.reruFechacambio = reruFechacambio;
	}

	public String getReruHoracambio() {
		return this.reruHoracambio;
	}

	public void setReruHoracambio(String reruHoracambio) {
		this.reruHoracambio = reruHoracambio;
	}

	public String getReruRegistradopor() {
		return this.reruRegistradopor;
	}

	public void setReruRegistradopor(String reruRegistradopor) {
		this.reruRegistradopor = reruRegistradopor;
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
			this.reruRegistradopor=data.get(0);
			this.reruFechacambio=data.get(1);
			this.reruHoracambio=data.get(2);
		}
	}
}