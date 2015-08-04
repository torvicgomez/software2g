package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the condicionpago database table.
 * 
 */
@Entity
@Table(name="condicionpago", schema="niif")
public class Condicionpago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONDICIONPAGO_COPAID_GENERATOR", sequenceName="NIIF.SEQ_COPA_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONDICIONPAGO_COPAID_GENERATOR")
	@Column(name="copa_id")
	private long copaId;

	@Column(name="copa_condicionpago")
	private String copaCondicionpago;

	@Column(name="copa_descripcion")
	private String copaDescripcion;

	@Column(name="copa_estado")
	private String copaEstado;

	@Column(name="copa_fechacambio")
	private String copaFechacambio;

	@Column(name="copa_horacambio")
	private String copaHoracambio;

	@Column(name="copa_registradopor")
	private String copaRegistradopor;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="condicionpago")
	private List<Venta> ventas;

	public Condicionpago() {
	}

	public long getCopaId() {
		return this.copaId;
	}

	public void setCopaId(long copaId) {
		this.copaId = copaId;
	}

	public String getCopaCondicionpago() {
		return this.copaCondicionpago;
	}

	public void setCopaCondicionpago(String copaCondicionpago) {
		this.copaCondicionpago = copaCondicionpago;
	}

	public String getCopaDescripcion() {
		return this.copaDescripcion;
	}

	public void setCopaDescripcion(String copaDescripcion) {
		this.copaDescripcion = copaDescripcion;
	}

	public String getCopaEstado() {
		return this.copaEstado;
	}

	public void setCopaEstado(String copaEstado) {
		this.copaEstado = copaEstado;
	}

	public String getCopaFechacambio() {
		return this.copaFechacambio;
	}

	public void setCopaFechacambio(String copaFechacambio) {
		this.copaFechacambio = copaFechacambio;
	}

	public String getCopaHoracambio() {
		return this.copaHoracambio;
	}

	public void setCopaHoracambio(String copaHoracambio) {
		this.copaHoracambio = copaHoracambio;
	}

	public String getCopaRegistradopor() {
		return this.copaRegistradopor;
	}

	public void setCopaRegistradopor(String copaRegistradopor) {
		this.copaRegistradopor = copaRegistradopor;
	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.copaRegistradopor=data.get(0);
			this.copaFechacambio=data.get(1);
			this.copaHoracambio=data.get(2);
		}
	}
}