package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the proveedor database table.
 * 
 */
@Entity
@Table(name="proveedor", schema="niif")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROVEEDOR_PROVID_GENERATOR", sequenceName="NIIF.SEQ_PROV_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROVEEDOR_PROVID_GENERATOR")
	@Column(name="prov_id")
	private long provId;

//	@Column(name="pers_id")
//	private java.math.BigDecimal persId;
	@ManyToOne
	@JoinColumn(name="pers_id")
	private Persona persona;

	@Column(name="prov_fechacambio")
	private String provFechacambio;

	@Column(name="prov_horacambio")
	private String provHoracambio;

	@Column(name="prov_razonsocial")
	private String provRazonsocial;

	@Column(name="prov_registradopor")
	private String provRegistradopor;

	//bi-directional many-to-one association to Ordencompra
	@OneToMany(mappedBy="proveedor")
	private List<Ordencompra> ordencompras;

	public Proveedor() {
	}

	public long getProvId() {
		return this.provId;
	}

	public void setProvId(long provId) {
		this.provId = provId;
	}

//	public java.math.BigDecimal getPersId() {
//		return this.persId;
//	}
//
//	public void setPersId(java.math.BigDecimal persId) {
//		this.persId = persId;
//	}

	public String getProvFechacambio() {
		return this.provFechacambio;
	}

	public void setProvFechacambio(String provFechacambio) {
		this.provFechacambio = provFechacambio;
	}

	public String getProvHoracambio() {
		return this.provHoracambio;
	}

	public void setProvHoracambio(String provHoracambio) {
		this.provHoracambio = provHoracambio;
	}

	public String getProvRazonsocial() {
		return this.provRazonsocial;
	}

	public void setProvRazonsocial(String provRazonsocial) {
		this.provRazonsocial = provRazonsocial;
	}

	public String getProvRegistradopor() {
		return this.provRegistradopor;
	}

	public void setProvRegistradopor(String provRegistradopor) {
		this.provRegistradopor = provRegistradopor;
	}

	public List<Ordencompra> getOrdencompras() {
		return this.ordencompras;
	}

	public void setOrdencompras(List<Ordencompra> ordencompras) {
		this.ordencompras = ordencompras;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.provRegistradopor=data.get(0);
			this.provFechacambio=data.get(1);
			this.provHoracambio=data.get(2);
		}
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}