package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "TIPODIAGNOSTICO" database table.
 * 
 */
@Entity
@Table(name="\"TIPODIAGNOSTICO\"", schema="\"HISCLINICA\"")
public class Tipodiagnostico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPODIAGNOSTICO_TIDIID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_TIDI_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPODIAGNOSTICO_TIDIID_GENERATOR")
	@Column(name="tidi_id")
	private long tidiId;

	@Column(name="tidi_abreviatura")
	private String tidiAbreviatura;

	@Column(name="tidi_fechacambio")
	private String tidiFechacambio;

	@Column(name="tidi_horacambio")
	private String tidiHoracambio;

	@Column(name="tidi_nombre")
	private String tidiNombre;

	@Column(name="tidi_registradopor")
	private String tidiRegistradopor;

	//bi-directional many-to-one association to Diagnostico
	@OneToMany(mappedBy="tipodiagnostico")
	private List<Diagnostico> diagnosticos;

	public Tipodiagnostico() {
	}

	public long getTidiId() {
		return this.tidiId;
	}

	public void setTidiId(long tidiId) {
		this.tidiId = tidiId;
	}

	public String getTidiAbreviatura() {
		return this.tidiAbreviatura;
	}

	public void setTidiAbreviatura(String tidiAbreviatura) {
		this.tidiAbreviatura = tidiAbreviatura;
	}

	public String getTidiFechacambio() {
		return this.tidiFechacambio;
	}

	public void setTidiFechacambio(String tidiFechacambio) {
		this.tidiFechacambio = tidiFechacambio;
	}

	public String getTidiHoracambio() {
		return this.tidiHoracambio;
	}

	public void setTidiHoracambio(String tidiHoracambio) {
		this.tidiHoracambio = tidiHoracambio;
	}

	public String getTidiNombre() {
		return this.tidiNombre;
	}

	public void setTidiNombre(String tidiNombre) {
		this.tidiNombre = tidiNombre;
	}

	public String getTidiRegistradopor() {
		return this.tidiRegistradopor;
	}

	public void setTidiRegistradopor(String tidiRegistradopor) {
		this.tidiRegistradopor = tidiRegistradopor;
	}

	public List<Diagnostico> getDiagnosticos() {
		return this.diagnosticos;
	}

	public void setDiagnosticos(List<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.tidiRegistradopor=data.get(0);
			this.tidiFechacambio=data.get(1);
			this.tidiHoracambio=data.get(2);
		}
	}
}