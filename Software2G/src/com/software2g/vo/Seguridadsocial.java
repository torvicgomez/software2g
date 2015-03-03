package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "SEGURIDADSOCIAL" database table.
 * 
 */
@Entity
@Table(name="\"SEGURIDADSOCIAL\"", schema="\"HISCLINICA\"")
public class Seguridadsocial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEGURIDADSOCIAL_SEGUID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_SEGU_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEGURIDADSOCIAL_SEGUID_GENERATOR")
	@Column(name="segu_id")
	private long seguId;

	@Column(name="segu_abreviatura")
	private String seguAbreviatura;

	@Column(name="segu_fechacambio")
	private String seguFechacambio;

	@Column(name="segu_horacambio")
	private String seguHoracambio;

	@Column(name="segu_nombre")
	private String seguNombre;

	@Column(name="segu_registradopor")
	private String seguRegistradopor;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="seguridadsocial")
	private List<Servicio> servicios;

	public Seguridadsocial() {
	}

	public long getSeguId() {
		return this.seguId;
	}

	public void setSeguId(long seguId) {
		this.seguId = seguId;
	}

	public String getSeguAbreviatura() {
		return this.seguAbreviatura;
	}

	public void setSeguAbreviatura(String seguAbreviatura) {
		this.seguAbreviatura = seguAbreviatura;
	}

	public String getSeguFechacambio() {
		return this.seguFechacambio;
	}

	public void setSeguFechacambio(String seguFechacambio) {
		this.seguFechacambio = seguFechacambio;
	}

	public String getSeguHoracambio() {
		return this.seguHoracambio;
	}

	public void setSeguHoracambio(String seguHoracambio) {
		this.seguHoracambio = seguHoracambio;
	}

	public String getSeguNombre() {
		return this.seguNombre;
	}

	public void setSeguNombre(String seguNombre) {
		this.seguNombre = seguNombre;
	}

	public String getSeguRegistradopor() {
		return this.seguRegistradopor;
	}

	public void setSeguRegistradopor(String seguRegistradopor) {
		this.seguRegistradopor = seguRegistradopor;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.seguRegistradopor=data.get(0);
			this.seguFechacambio=data.get(1);
			this.seguHoracambio=data.get(2);
		}
	}
}