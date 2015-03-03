package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "TIPOSERVICIO" database table.
 * 
 */
@Entity
@Table(name="\"TIPOSERVICIO\"", schema="\"HISCLINICA\"")
public class Tiposervicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOSERVICIO_TISEID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_TISE_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOSERVICIO_TISEID_GENERATOR")
	@Column(name="tise_id")
	private long tiseId;

	@Column(name="tise_codigo")
	private String tiseCodigo;

	@Column(name="tise_descripcion")
	private String tiseDescripcion;

	@Column(name="tise_fechacambio")
	private String tiseFechacambio;

	@Column(name="tise_horacambio")
	private String tiseHoracambio;

	@Column(name="tise_nombre")
	private String tiseNombre;

	@Column(name="tise_registradopor")
	private String tiseRegistradopor;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="tiposervicio")
	private List<Servicio> servicios;

	public Tiposervicio() {
	}

	public long getTiseId() {
		return this.tiseId;
	}

	public void setTiseId(long tiseId) {
		this.tiseId = tiseId;
	}

	public String getTiseCodigo() {
		return this.tiseCodigo;
	}

	public void setTiseCodigo(String tiseCodigo) {
		this.tiseCodigo = tiseCodigo;
	}

	public String getTiseDescripcion() {
		return this.tiseDescripcion;
	}

	public void setTiseDescripcion(String tiseDescripcion) {
		this.tiseDescripcion = tiseDescripcion;
	}

	public String getTiseFechacambio() {
		return this.tiseFechacambio;
	}

	public void setTiseFechacambio(String tiseFechacambio) {
		this.tiseFechacambio = tiseFechacambio;
	}

	public String getTiseHoracambio() {
		return this.tiseHoracambio;
	}

	public void setTiseHoracambio(String tiseHoracambio) {
		this.tiseHoracambio = tiseHoracambio;
	}

	public String getTiseNombre() {
		return this.tiseNombre;
	}

	public void setTiseNombre(String tiseNombre) {
		this.tiseNombre = tiseNombre;
	}

	public String getTiseRegistradopor() {
		return this.tiseRegistradopor;
	}

	public void setTiseRegistradopor(String tiseRegistradopor) {
		this.tiseRegistradopor = tiseRegistradopor;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.tiseRegistradopor=data.get(0);
			this.tiseFechacambio=data.get(1);
			this.tiseHoracambio=data.get(2);
		}
	}
}