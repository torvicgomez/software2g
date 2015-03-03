package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "ODONTOGRAMA" database table.
 * 
 */
@Entity
@Table(name="\"ODONTOGRAMA\"", schema="\"HISCLINICA\"")
public class Odontograma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ODONTOGRAMA_ODONID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_ODON_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ODONTOGRAMA_ODONID_GENERATOR")
	@Column(name="odon_id")
	private long odonId;

	@Column(name="odon_fechacambio")
	private String odonFechacambio;

	@Column(name="odon_horacambio")
	private String odonHoracambio;

	@Column(name="odon_registradopor")
	private String odonRegistradopor;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="serv_id")
	private Servicio servicio;

	//bi-directional many-to-one association to Registroodontograma
	@OneToMany(mappedBy="odontograma")
	private List<Registroodontograma> registroodontogramas;

	public Odontograma() {
	}

	public long getOdonId() {
		return this.odonId;
	}

	public void setOdonId(long odonId) {
		this.odonId = odonId;
	}

	public String getOdonFechacambio() {
		return this.odonFechacambio;
	}

	public void setOdonFechacambio(String odonFechacambio) {
		this.odonFechacambio = odonFechacambio;
	}

	public String getOdonHoracambio() {
		return this.odonHoracambio;
	}

	public void setOdonHoracambio(String odonHoracambio) {
		this.odonHoracambio = odonHoracambio;
	}

	public String getOdonRegistradopor() {
		return this.odonRegistradopor;
	}

	public void setOdonRegistradopor(String odonRegistradopor) {
		this.odonRegistradopor = odonRegistradopor;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public List<Registroodontograma> getRegistroodontogramas() {
		return this.registroodontogramas;
	}

	public void setRegistroodontogramas(List<Registroodontograma> registroodontogramas) {
		this.registroodontogramas = registroodontogramas;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.odonRegistradopor=data.get(0);
			this.odonFechacambio=data.get(1);
			this.odonHoracambio=data.get(2);
		}
	}
}