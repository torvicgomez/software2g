package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the formapago database table.
 * 
 */
@Entity
@Table(name="formapago", schema="niif")
public class Formapago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FORMAPAGO_FOPAID_GENERATOR", sequenceName="NIIF.SEQ_FOPA_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FORMAPAGO_FOPAID_GENERATOR")
	@Column(name="fopa_id")
	private long fopaId;

	@Column(name="fopa_descripcion")
	private String fopaDescripcion;

	@Column(name="fopa_estado")
	private String fopaEstado;

	@Column(name="fopa_fechacambio")
	private String fopaFechacambio;

	@Column(name="fopa_formapago")
	private String fopaFormapago;

	@Column(name="fopa_horacambio")
	private String fopaHoracambio;

	@Column(name="fopa_registradopor")
	private String fopaRegistradopor;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="formapago")
	private List<Pago> pagos;

	public Formapago() {
	}

	public long getFopaId() {
		return this.fopaId;
	}

	public void setFopaId(long fopaId) {
		this.fopaId = fopaId;
	}

	public String getFopaDescripcion() {
		return this.fopaDescripcion;
	}

	public void setFopaDescripcion(String fopaDescripcion) {
		this.fopaDescripcion = fopaDescripcion;
	}

	public String getFopaEstado() {
		return this.fopaEstado;
	}

	public void setFopaEstado(String fopaEstado) {
		this.fopaEstado = fopaEstado;
	}

	public String getFopaFechacambio() {
		return this.fopaFechacambio;
	}

	public void setFopaFechacambio(String fopaFechacambio) {
		this.fopaFechacambio = fopaFechacambio;
	}

	public String getFopaFormapago() {
		return this.fopaFormapago;
	}

	public void setFopaFormapago(String fopaFormapago) {
		this.fopaFormapago = fopaFormapago;
	}

	public String getFopaHoracambio() {
		return this.fopaHoracambio;
	}

	public void setFopaHoracambio(String fopaHoracambio) {
		this.fopaHoracambio = fopaHoracambio;
	}

	public String getFopaRegistradopor() {
		return this.fopaRegistradopor;
	}

	public void setFopaRegistradopor(String fopaRegistradopor) {
		this.fopaRegistradopor = fopaRegistradopor;
	}

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.fopaRegistradopor=data.get(0);
			this.fopaFechacambio=data.get(1);
			this.fopaHoracambio=data.get(2);
		}
	}
}