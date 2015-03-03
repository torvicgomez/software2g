package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "PARTECUERPO" database table.
 * 
 */
@Entity
@Table(name="\"PARTECUERPO\"", schema="\"HISCLINICA\"")
public class Partecuerpo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PARTECUERPO_PARTID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_PARC_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARTECUERPO_PARTID_GENERATOR")
	@Column(name="part_id")
	private long partId;

	@Column(name="part_especie")
	private String partEspecie;

	@Column(name="part_fechacambio")
	private String partFechacambio;

	@Column(name="part_horacambio")
	private String partHoracambio;

	@Column(name="part_partecuerpo")
	private String partPartecuerpo;

	@Column(name="part_registradopor")
	private String partRegistradopor;

	//bi-directional many-to-one association to Especificacionpartecuerpo
	@OneToMany(mappedBy="partecuerpo")
	private List<Especificacionpartecuerpo> especificacionpartecuerpos;

	public Partecuerpo() {
	}

	public long getPartId() {
		return this.partId;
	}

	public void setPartId(long partId) {
		this.partId = partId;
	}

	public String getPartEspecie() {
		return this.partEspecie;
	}

	public void setPartEspecie(String partEspecie) {
		this.partEspecie = partEspecie;
	}

	public String getPartFechacambio() {
		return this.partFechacambio;
	}

	public void setPartFechacambio(String partFechacambio) {
		this.partFechacambio = partFechacambio;
	}

	public String getPartHoracambio() {
		return this.partHoracambio;
	}

	public void setPartHoracambio(String partHoracambio) {
		this.partHoracambio = partHoracambio;
	}

	public String getPartPartecuerpo() {
		return this.partPartecuerpo;
	}

	public void setPartPartecuerpo(String partPartecuerpo) {
		this.partPartecuerpo = partPartecuerpo;
	}

	public String getPartRegistradopor() {
		return this.partRegistradopor;
	}

	public void setPartRegistradopor(String partRegistradopor) {
		this.partRegistradopor = partRegistradopor;
	}

	public List<Especificacionpartecuerpo> getEspecificacionpartecuerpos() {
		return this.especificacionpartecuerpos;
	}

	public void setEspecificacionpartecuerpos(List<Especificacionpartecuerpo> especificacionpartecuerpos) {
		this.especificacionpartecuerpos = especificacionpartecuerpos;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.partRegistradopor=data.get(0);
			this.partFechacambio=data.get(1);
			this.partHoracambio=data.get(2);
		}
	}
}