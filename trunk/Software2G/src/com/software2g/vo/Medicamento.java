package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the "MEDICAMENTO" database table.
 * 
 */
@Entity
@Table(name="\"MEDICAMENTO\"", schema="\"HISCLINICA\"")
public class Medicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MEDICAMENTO_MEDIID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_MEDI_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEDICAMENTO_MEDIID_GENERATOR")
	@Column(name="medi_id")
	private long mediId;

	@Column(name="medi_cantidad")
	private String mediCantidad;

	@Column(name="medi_dosis")
	private String mediDosis;

	@Column(name="medi_fechacambio")
	private String mediFechacambio;

	@Column(name="medi_horacambio")
	private String mediHoracambio;

	@Column(name="medi_intervalo")
	private String mediIntervalo;

	@Column(name="medi_medicamento")
	private String mediMedicamento;

	@Column(name="medi_presentacion")
	private String mediPresentacion;

	@Column(name="medi_registradopor")
	private String mediRegistradopor;

	//bi-directional many-to-one association to Formulacion
	@ManyToOne
	@JoinColumn(name="form_id")
	private Formulacion formulacion;

	public Medicamento() {
	}

	public long getMediId() {
		return this.mediId;
	}

	public void setMediId(long mediId) {
		this.mediId = mediId;
	}

	public String getMediCantidad() {
		return this.mediCantidad;
	}

	public void setMediCantidad(String mediCantidad) {
		this.mediCantidad = mediCantidad;
	}

	public String getMediDosis() {
		return this.mediDosis;
	}

	public void setMediDosis(String mediDosis) {
		this.mediDosis = mediDosis;
	}

	public String getMediFechacambio() {
		return this.mediFechacambio;
	}

	public void setMediFechacambio(String mediFechacambio) {
		this.mediFechacambio = mediFechacambio;
	}

	public String getMediHoracambio() {
		return this.mediHoracambio;
	}

	public void setMediHoracambio(String mediHoracambio) {
		this.mediHoracambio = mediHoracambio;
	}

	public String getMediIntervalo() {
		return this.mediIntervalo;
	}

	public void setMediIntervalo(String mediIntervalo) {
		this.mediIntervalo = mediIntervalo;
	}

	public String getMediMedicamento() {
		return this.mediMedicamento;
	}

	public void setMediMedicamento(String mediMedicamento) {
		this.mediMedicamento = mediMedicamento;
	}

	public String getMediPresentacion() {
		return this.mediPresentacion;
	}

	public void setMediPresentacion(String mediPresentacion) {
		this.mediPresentacion = mediPresentacion;
	}

	public String getMediRegistradopor() {
		return this.mediRegistradopor;
	}

	public void setMediRegistradopor(String mediRegistradopor) {
		this.mediRegistradopor = mediRegistradopor;
	}

	public Formulacion getFormulacion() {
		return this.formulacion;
	}

	public void setFormulacion(Formulacion formulacion) {
		this.formulacion = formulacion;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.mediRegistradopor=data.get(0);
			this.mediFechacambio=data.get(1);
			this.mediHoracambio=data.get(2);
		}
	}
}