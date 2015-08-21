package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the portafolio database table.
 * 
 */
@Entity
@Table(name="PORTAFOLIO", schema="NIIF") 
public class Portafolio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PORTAFOLIO_PORTID_GENERATOR", sequenceName="NIIF.SEQ_PORT_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PORTAFOLIO_PORTID_GENERATOR")
	@Column(name="port_id")
	private long portId;

	@Column(name="port_descripcion")
	private String portDescripcion;

	@Column(name="port_fechacambio")
	private String portFechacambio;

	@Column(name="port_horacambio")
	private String portHoracambio;

	@Column(name="port_referencia")
	private String portReferencia;

	@Column(name="port_registradopor")
	private String portRegistradopor;

	@Column(name="port_valor")
	private double portValor;

	@Column(name="port_vervalor")
	private String portVervalor;

	//bi-directional many-to-one association to Portafoliocategoria
	@ManyToOne
	@JoinColumn(name="poca_id")
	private Portafoliocategoria portafoliocategoria;

	public Portafolio() {
	}

	public long getPortId() {
		return this.portId;
	}

	public void setPortId(long portId) {
		this.portId = portId;
	}

	public String getPortDescripcion() {
		return this.portDescripcion;
	}

	public void setPortDescripcion(String portDescripcion) {
		this.portDescripcion = portDescripcion;
	}

	public String getPortFechacambio() {
		return this.portFechacambio;
	}

	public void setPortFechacambio(String portFechacambio) {
		this.portFechacambio = portFechacambio;
	}

	public String getPortHoracambio() {
		return this.portHoracambio;
	}

	public void setPortHoracambio(String portHoracambio) {
		this.portHoracambio = portHoracambio;
	}

	public String getPortReferencia() {
		return this.portReferencia;
	}

	public void setPortReferencia(String portReferencia) {
		this.portReferencia = portReferencia;
	}

	public String getPortRegistradopor() {
		return this.portRegistradopor;
	}

	public void setPortRegistradopor(String portRegistradopor) {
		this.portRegistradopor = portRegistradopor;
	}

	public double getPortValor() {
		return this.portValor;
	}

	public void setPortValor(double portValor) {
		this.portValor = portValor;
	}

	public String getPortVervalor() {
		return this.portVervalor;
	}

	public void setPortVervalor(String portVervalor) {
		this.portVervalor = portVervalor;
	}

	public Portafoliocategoria getPortafoliocategoria() {
		return this.portafoliocategoria;
	}

	public void setPortafoliocategoria(Portafoliocategoria portafoliocategoria) {
		this.portafoliocategoria = portafoliocategoria;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.portRegistradopor=data.get(0);
			this.portFechacambio=data.get(1);
			this.portHoracambio=data.get(2);
		}
	}
}