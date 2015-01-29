package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the "PARTICIPANTE" database table.
 * 
 */
@Entity
@Table(name="\"PARTICIPANTE\"", schema="\"HISCLINICA\"")
public class Participante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PARTICIPANTE_PARTID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_PART_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARTICIPANTE_PARTID_GENERATOR")
	@Column(name="part_id")
	private long partId;

//	@Column(name="even_id")
//	private java.math.BigDecimal evenId;

	//bi-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name="even_id")
	private Evento evento;
	
	@Column(name="part_documento")
	private String partDocumento;

	@Column(name="part_email")
	private String partEmail;

	@Column(name="part_fechacambio")
	private String partFechacambio;

	@Column(name="part_horacambio")
	private String partHoracambio;

	@Column(name="part_papellido")
	private String partPapellido;

	@Column(name="part_pnombre")
	private String partPnombre;

	@Column(name="part_registradopor")
	private String partRegistradopor;

	@Column(name="part_sapellido")
	private String partSapellido;

	@Column(name="part_snombre")
	private String partSnombre;

	@Column(name="part_telefono")
	private String partTelefono;

	@Column(name="part_tipodocumento")
	private String partTipodocumento;

	public Participante() {
	}

	public long getPartId() {
		return this.partId;
	}

	public void setPartId(long partId) {
		this.partId = partId;
	}

//	public java.math.BigDecimal getEvenId() {
//		return this.evenId;
//	}
//
//	public void setEvenId(java.math.BigDecimal evenId) {
//		this.evenId = evenId;
//	}

	public String getPartDocumento() {
		return this.partDocumento;
	}

	public void setPartDocumento(String partDocumento) {
		this.partDocumento = partDocumento;
	}

	public String getPartEmail() {
		return this.partEmail;
	}

	public void setPartEmail(String partEmail) {
		this.partEmail = partEmail;
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

	public String getPartPapellido() {
		return this.partPapellido;
	}

	public void setPartPapellido(String partPapellido) {
		this.partPapellido = partPapellido;
	}

	public String getPartPnombre() {
		return this.partPnombre;
	}

	public void setPartPnombre(String partPnombre) {
		this.partPnombre = partPnombre;
	}

	public String getPartRegistradopor() {
		return this.partRegistradopor;
	}

	public void setPartRegistradopor(String partRegistradopor) {
		this.partRegistradopor = partRegistradopor;
	}

	public String getPartSapellido() {
		return this.partSapellido;
	}

	public void setPartSapellido(String partSapellido) {
		this.partSapellido = partSapellido;
	}

	public String getPartSnombre() {
		return this.partSnombre;
	}

	public void setPartSnombre(String partSnombre) {
		this.partSnombre = partSnombre;
	}

	public String getPartTelefono() {
		return this.partTelefono;
	}

	public void setPartTelefono(String partTelefono) {
		this.partTelefono = partTelefono;
	}

	public String getPartTipodocumento() {
		return this.partTipodocumento;
	}

	public void setPartTipodocumento(String partTipodocumento) {
		this.partTipodocumento = partTipodocumento;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.partRegistradopor=data.get(0);
			this.partFechacambio=data.get(1);
			this.partHoracambio=data.get(2);
		}
	}
	
	public String getNombreCompleto(){
		return this.partPnombre+" "+this.partSnombre+" "+this.partSapellido+" "+this.partPapellido;
	}
}