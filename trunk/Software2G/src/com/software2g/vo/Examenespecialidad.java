package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the "EXAMENESPECIALIDAD" database table.
 * 
 */
@Entity
@Table(name="\"EXAMENESPECIALIDAD\"", schema="\"HISCLINICA\"")
public class Examenespecialidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXAMENESPECIALIDAD_EXESID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_EXES_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXAMENESPECIALIDAD_EXESID_GENERATOR")
	@Column(name="exes_id")
	private long exesId;

	@Column(name="exes_estado")
	private String exesEstado;

	@Column(name="exes_fechacambio")
	private String exesFechacambio;

	@Column(name="exes_horacambio")
	private String exesHoracambio;

	@Column(name="exes_nombre")
	private String exesNombre;

	@Column(name="exes_paginajsp")
	private String exesPaginajsp;

	@Column(name="exes_registradopor")
	private String exesRegistradopor;

	@Column(name="exes_orden")
	private long exesOrden; 
	
	@ManyToOne
	@JoinColumn(name="ties_id")
	private Tipoespecialidad tipoEspecialidad;
	
	public Examenespecialidad() {
	}

	public long getExesId() {
		return this.exesId;
	}

	public void setExesId(long exesId) {
		this.exesId = exesId;
	}

	public String getExesEstado() {
		return this.exesEstado;
	}

	public void setExesEstado(String exesEstado) {
		this.exesEstado = exesEstado;
	}

	public String getExesFechacambio() {
		return this.exesFechacambio;
	}

	public void setExesFechacambio(String exesFechacambio) {
		this.exesFechacambio = exesFechacambio;
	}

	public String getExesHoracambio() {
		return this.exesHoracambio;
	}

	public void setExesHoracambio(String exesHoracambio) {
		this.exesHoracambio = exesHoracambio;
	}

	public String getExesNombre() {
		return this.exesNombre;
	}

	public void setExesNombre(String exesNombre) {
		this.exesNombre = exesNombre;
	}

	public String getExesPaginajsp() {
		return this.exesPaginajsp;
	}

	public void setExesPaginajsp(String exesPaginajsp) {
		this.exesPaginajsp = exesPaginajsp;
	}

	public String getExesRegistradopor() {
		return this.exesRegistradopor;
	}

	public void setExesRegistradopor(String exesRegistradopor) {
		this.exesRegistradopor = exesRegistradopor;
	}

	public Tipoespecialidad getTipoEspecialidad() {
		return tipoEspecialidad;
	}

	public void setTipoEspecialidad(Tipoespecialidad tipoEspecialidad) {
		this.tipoEspecialidad = tipoEspecialidad;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.exesRegistradopor=data.get(0);
			this.exesFechacambio=data.get(1);
			this.exesHoracambio=data.get(2);
		}
	}

	public long getExesOrden() {
		return exesOrden;
	}

	public void setExesOrden(long exesOrden) {
		this.exesOrden = exesOrden;
	}
	
}