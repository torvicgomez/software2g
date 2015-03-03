package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "CODIGOENFERMEDADES" database table.
 * 
 */
@Entity
@Table(name="\"CODIGOENFERMEDADES\"", schema="\"HISCLINICA\"")
public class Codigoenfermedade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CODIGOENFERMEDADES_COENID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_COEN_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CODIGOENFERMEDADES_COENID_GENERATOR")
	@Column(name="coen_id")
	private long coenId;

	@Column(name="coen_codigo")
	private String coenCodigo;

	@Column(name="coen_fechacambio")
	private String coenFechacambio;

	@Column(name="coen_horacambio")
	private String coenHoracambio;

	@Column(name="coen_nombre")
	private String coenNombre;

	@Column(name="coen_registradopor")
	private String coenRegistradopor;

	//bi-directional many-to-one association to Tipoespecialidad
	@ManyToOne
	@JoinColumn(name="ties_id")
	private Tipoespecialidad tipoespecialidad;

	//bi-directional many-to-one association to Diagnostico
	@OneToMany(mappedBy="codigoenfermedade")
	private List<Diagnostico> diagnosticos;

	public Codigoenfermedade() {
	}

	public long getCoenId() {
		return this.coenId;
	}

	public void setCoenId(long coenId) {
		this.coenId = coenId;
	}

	public String getCoenCodigo() {
		return this.coenCodigo;
	}

	public void setCoenCodigo(String coenCodigo) {
		this.coenCodigo = coenCodigo;
	}

	public String getCoenFechacambio() {
		return this.coenFechacambio;
	}

	public void setCoenFechacambio(String coenFechacambio) {
		this.coenFechacambio = coenFechacambio;
	}

	public String getCoenHoracambio() {
		return this.coenHoracambio;
	}

	public void setCoenHoracambio(String coenHoracambio) {
		this.coenHoracambio = coenHoracambio;
	}

	public String getCoenNombre() {
		return this.coenNombre;
	}

	public void setCoenNombre(String coenNombre) {
		this.coenNombre = coenNombre;
	}

	public String getCoenRegistradopor() {
		return this.coenRegistradopor;
	}

	public void setCoenRegistradopor(String coenRegistradopor) {
		this.coenRegistradopor = coenRegistradopor;
	}

	public Tipoespecialidad getTipoespecialidad() {
		return this.tipoespecialidad;
	}

	public void setTipoespecialidad(Tipoespecialidad tipoespecialidad) {
		this.tipoespecialidad = tipoespecialidad;
	}

	public List<Diagnostico> getDiagnosticos() {
		return this.diagnosticos;
	}

	public void setDiagnosticos(List<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.coenRegistradopor=data.get(0);
			this.coenFechacambio=data.get(1);
			this.coenHoracambio=data.get(2);
		}
	}
}