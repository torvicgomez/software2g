package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="cliente", schema="niif")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLIENTE_CLIEID_GENERATOR", sequenceName="NIIF.SEQ_CLIE_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLIENTE_CLIEID_GENERATOR")
	@Column(name="clie_id")
	private long clieId;

	@Column(name="clie_fechacambio")
	private String clieFechacambio;

	@Column(name="clie_horacambio")
	private String clieHoracambio;

	@Column(name="clie_registradopor")
	private String clieRegistradopor;

//	@Column(name="pers_id")
//	private java.math.BigDecimal persId;
	@ManyToOne
	@JoinColumn(name="pers_id")
	private Persona persona;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="cliente")
	private List<Venta> ventas;

	public Cliente() {
	}

	public long getClieId() {
		return this.clieId;
	}

	public void setClieId(long clieId) {
		this.clieId = clieId;
	}

	public String getClieFechacambio() {
		return this.clieFechacambio;
	}

	public void setClieFechacambio(String clieFechacambio) {
		this.clieFechacambio = clieFechacambio;
	}

	public String getClieHoracambio() {
		return this.clieHoracambio;
	}

	public void setClieHoracambio(String clieHoracambio) {
		this.clieHoracambio = clieHoracambio;
	}

	public String getClieRegistradopor() {
		return this.clieRegistradopor;
	}

	public void setClieRegistradopor(String clieRegistradopor) {
		this.clieRegistradopor = clieRegistradopor;
	}

//	public java.math.BigDecimal getPersId() {
//		return this.persId;
//	}
//
//	public void setPersId(java.math.BigDecimal persId) {
//		this.persId = persId;
//	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.clieRegistradopor=data.get(0);
			this.clieFechacambio=data.get(1);
			this.clieHoracambio=data.get(2);
		}
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}