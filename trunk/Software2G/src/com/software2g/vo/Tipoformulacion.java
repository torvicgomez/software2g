package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "TIPOFORMULACION" database table.
 * 
 */
@Entity
@Table(name="\"TIPOFORMULACION\"", schema="\"HISCLINICA\"")
public class Tipoformulacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOFORMULACION_TIFOID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_TIFO_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOFORMULACION_TIFOID_GENERATOR")
	@Column(name="tifo_id")
	private long tifoId;

	@Column(name="tifo_estado")
	private String tifoEstado;

	@Column(name="tifo_fechacambio")
	private String tifoFechacambio;

	@Column(name="tifo_horacambio")
	private String tifoHoracambio;

	@Column(name="tifo_nombre")
	private String tifoNombre;

	@Column(name="tifo_registradopor")
	private String tifoRegistradopor;

	//bi-directional many-to-one association to Formulacion
	@OneToMany(mappedBy="tipoformulacion")
	private List<Formulacion> formulacions;

	public Tipoformulacion() {
	}

	public long getTifoId() {
		return this.tifoId;
	}

	public void setTifoId(long tifoId) {
		this.tifoId = tifoId;
	}

	public String getTifoEstado() {
		return this.tifoEstado;
	}

	public void setTifoEstado(String tifoEstado) {
		this.tifoEstado = tifoEstado;
	}

	public String getTifoFechacambio() {
		return this.tifoFechacambio;
	}

	public void setTifoFechacambio(String tifoFechacambio) {
		this.tifoFechacambio = tifoFechacambio;
	}

	public String getTifoHoracambio() {
		return this.tifoHoracambio;
	}

	public void setTifoHoracambio(String tifoHoracambio) {
		this.tifoHoracambio = tifoHoracambio;
	}

	public String getTifoNombre() {
		return this.tifoNombre;
	}

	public void setTifoNombre(String tifoNombre) {
		this.tifoNombre = tifoNombre;
	}

	public String getTifoRegistradopor() {
		return this.tifoRegistradopor;
	}

	public void setTifoRegistradopor(String tifoRegistradopor) {
		this.tifoRegistradopor = tifoRegistradopor;
	}

	public List<Formulacion> getFormulacions() {
		return this.formulacions;
	}

	public void setFormulacions(List<Formulacion> formulacions) {
		this.formulacions = formulacions;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.tifoRegistradopor=data.get(0);
			this.tifoFechacambio=data.get(1);
			this.tifoHoracambio=data.get(2);
		}
	}
}