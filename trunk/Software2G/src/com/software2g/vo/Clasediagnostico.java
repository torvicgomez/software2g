package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "CLASEDIAGNOSTICO" database table.
 * 
 */
@Entity
@Table(name="\"CLASEDIAGNOSTICO\"", schema="\"HISCLINICA\"")
public class Clasediagnostico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLASEDIAGNOSTICO_CLDIID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_CLDI_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLASEDIAGNOSTICO_CLDIID_GENERATOR")
	@Column(name="cldi_id")
	private long cldiId;

	@Column(name="cldi_abreviatura")
	private String cldiAbreviatura;

	@Column(name="cldi_fechacambio")
	private String cldiFechacambio;

	@Column(name="cldi_horacambio")
	private String cldiHoracambio;

	@Column(name="cldi_nombre")
	private String cldiNombre;

	@Column(name="cldi_registradopor")
	private String cldiRegistradopor;

	//bi-directional many-to-one association to Diagnostico
	@OneToMany(mappedBy="clasediagnostico")
	private List<Diagnostico> diagnosticos;

	public Clasediagnostico() {
	}

	public long getCldiId() {
		return this.cldiId;
	}

	public void setCldiId(long cldiId) {
		this.cldiId = cldiId;
	}

	public String getCldiAbreviatura() {
		return this.cldiAbreviatura;
	}

	public void setCldiAbreviatura(String cldiAbreviatura) {
		this.cldiAbreviatura = cldiAbreviatura;
	}

	public String getCldiFechacambio() {
		return this.cldiFechacambio;
	}

	public void setCldiFechacambio(String cldiFechacambio) {
		this.cldiFechacambio = cldiFechacambio;
	}

	public String getCldiHoracambio() {
		return this.cldiHoracambio;
	}

	public void setCldiHoracambio(String cldiHoracambio) {
		this.cldiHoracambio = cldiHoracambio;
	}

	public String getCldiNombre() {
		return this.cldiNombre;
	}

	public void setCldiNombre(String cldiNombre) {
		this.cldiNombre = cldiNombre;
	}

	public String getCldiRegistradopor() {
		return this.cldiRegistradopor;
	}

	public void setCldiRegistradopor(String cldiRegistradopor) {
		this.cldiRegistradopor = cldiRegistradopor;
	}

	public List<Diagnostico> getDiagnosticos() {
		return this.diagnosticos;
	}

	public void setDiagnosticos(List<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}
	
	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.cldiRegistradopor=data.get(0);
			this.cldiFechacambio=data.get(1);
			this.cldiHoracambio=data.get(2);
		}
	}
}