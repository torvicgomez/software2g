package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the "REGISTROEXAMENSIMPLE" database table.
 * 
 */
@Entity
@Table(name="\"REGISTROEXAMENSIMPLE\"", schema="\"HISCLINICA\"")
public class Registroexamensimple implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REGISTROEXAMENSIMPLE_REESID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_REES_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REGISTROEXAMENSIMPLE_REESID_GENERATOR")
	@Column(name="rees_id")
	private long reesId;

	@Column(name="rees_fechacambio")
	private String reesFechacambio;

	@Column(name="rees_horacambio")
	private String reesHoracambio;

	@Column(name="rees_registradopor")
	private String reesRegistradopor;

	@Column(name="rees_valor")
	private String reesValor;

	//bi-directional many-to-one association to Especificacionpartecuerpo
	@ManyToOne
	@JoinColumn(name="espc_id")
	private Especificacionpartecuerpo especificacionpartecuerpo;

	//bi-directional many-to-one association to Examenoptometria
	@ManyToOne
	@JoinColumn(name="exop_id")
	private Examenoptometria examenoptometria;

	//bi-directional many-to-one association to Tipoexamenopt
	@ManyToOne
	@JoinColumn(name="tiex_id")
	private Tipoexamenopt tipoexamenopt;

	public Registroexamensimple() {
	}

	public long getReesId() {
		return this.reesId;
	}

	public void setReesId(long reesId) {
		this.reesId = reesId;
	}

	public String getReesFechacambio() {
		return this.reesFechacambio;
	}

	public void setReesFechacambio(String reesFechacambio) {
		this.reesFechacambio = reesFechacambio;
	}

	public String getReesHoracambio() {
		return this.reesHoracambio;
	}

	public void setReesHoracambio(String reesHoracambio) {
		this.reesHoracambio = reesHoracambio;
	}

	public String getReesRegistradopor() {
		return this.reesRegistradopor;
	}

	public void setReesRegistradopor(String reesRegistradopor) {
		this.reesRegistradopor = reesRegistradopor;
	}

	public String getReesValor() {
		return this.reesValor;
	}

	public void setReesValor(String reesValor) {
		this.reesValor = reesValor;
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

	public Tipoexamenopt getTipoexamenopt() {
		return this.tipoexamenopt;
	}

	public void setTipoexamenopt(Tipoexamenopt tipoexamenopt) {
		this.tipoexamenopt = tipoexamenopt;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.reesRegistradopor=data.get(0);
			this.reesFechacambio=data.get(1);
			this.reesHoracambio=data.get(2);
		}
	}
}