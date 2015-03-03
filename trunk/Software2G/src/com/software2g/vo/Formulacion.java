package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "FORMULACION" database table.
 * 
 */
@Entity
@Table(name="\"FORMULACION\"", schema="\"HISCLINICA\"")
public class Formulacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FORMULACION_FORMID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_FORM_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FORMULACION_FORMID_GENERATOR")
	@Column(name="form_id")
	private long formId;

	@Column(name="form_fechacambio")
	private String formFechacambio;

	@Column(name="form_horacambio")
	private String formHoracambio;

	@Column(name="form_registradopor")
	private String formRegistradopor;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="serv_id")
	private Servicio servicio;

	//bi-directional many-to-one association to Tipoformulacion
	@ManyToOne
	@JoinColumn(name="tifo_id")
	private Tipoformulacion tipoformulacion;

	//bi-directional many-to-one association to Gafa
	@OneToMany(mappedBy="formulacion")
	private List<Gafa> gafas;

	//bi-directional many-to-one association to Medicamento
	@OneToMany(mappedBy="formulacion")
	private List<Medicamento> medicamentos;

	public Formulacion() {
	}

	public long getFormId() {
		return this.formId;
	}

	public void setFormId(long formId) {
		this.formId = formId;
	}

	public String getFormFechacambio() {
		return this.formFechacambio;
	}

	public void setFormFechacambio(String formFechacambio) {
		this.formFechacambio = formFechacambio;
	}

	public String getFormHoracambio() {
		return this.formHoracambio;
	}

	public void setFormHoracambio(String formHoracambio) {
		this.formHoracambio = formHoracambio;
	}

	public String getFormRegistradopor() {
		return this.formRegistradopor;
	}

	public void setFormRegistradopor(String formRegistradopor) {
		this.formRegistradopor = formRegistradopor;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Tipoformulacion getTipoformulacion() {
		return this.tipoformulacion;
	}

	public void setTipoformulacion(Tipoformulacion tipoformulacion) {
		this.tipoformulacion = tipoformulacion;
	}

	public List<Gafa> getGafas() {
		return this.gafas;
	}

	public void setGafas(List<Gafa> gafas) {
		this.gafas = gafas;
	}

	public List<Medicamento> getMedicamentos() {
		return this.medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.formRegistradopor=data.get(0);
			this.formFechacambio=data.get(1);
			this.formHoracambio=data.get(2);
		}
	}
}