package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the vendedor database table.
 * 
 */
@Entity
@Table(name="vendedor", schema="niif")
public class Vendedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VENDEDOR_VENDID_GENERATOR", sequenceName="NIIF.SEQ_VEND_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VENDEDOR_VENDID_GENERATOR")
	@Column(name="vend_id")
	private long vendId;

//	@Column(name="pers_id")
//	private java.math.BigDecimal persId;
	@ManyToOne
	@JoinColumn(name="pers_id")
	private Persona persona;

	@Column(name="vend_codigo")
	private String vendCodigo;

	@Column(name="vend_fechacambio")
	private String vendFechacambio;

	@Column(name="vend_horacambio")
	private String vendHoracambio;

	@Column(name="vend_registradopor")
	private String vendRegistradopor;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="vendedor")
	private List<Venta> ventas;

	public Vendedor() {
	}

	public long getVendId() {
		return this.vendId;
	}

	public void setVendId(long vendId) {
		this.vendId = vendId;
	}

//	public java.math.BigDecimal getPersId() {
//		return this.persId;
//	}
//
//	public void setPersId(java.math.BigDecimal persId) {
//		this.persId = persId;
//	}

	public String getVendCodigo() {
		return this.vendCodigo;
	}

	public void setVendCodigo(String vendCodigo) {
		this.vendCodigo = vendCodigo;
	}

	public String getVendFechacambio() {
		return this.vendFechacambio;
	}

	public void setVendFechacambio(String vendFechacambio) {
		this.vendFechacambio = vendFechacambio;
	}

	public String getVendHoracambio() {
		return this.vendHoracambio;
	}

	public void setVendHoracambio(String vendHoracambio) {
		this.vendHoracambio = vendHoracambio;
	}

	public String getVendRegistradopor() {
		return this.vendRegistradopor;
	}

	public void setVendRegistradopor(String vendRegistradopor) {
		this.vendRegistradopor = vendRegistradopor;
	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.vendRegistradopor=data.get(0);
			this.vendFechacambio=data.get(1);
			this.vendHoracambio=data.get(2);
		}
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}