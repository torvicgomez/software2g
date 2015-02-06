package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "TIPOPROCEDIMIENTO" database table.
 * 
 */
@Entity
@Table(name="\"TIPOPROCEDIMIENTO\"", schema="\"HISCLINICA\"")
public class Tipoprocedimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOPROCEDIMIENTO_TIPRID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_TIPR_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOPROCEDIMIENTO_TIPRID_GENERATOR")
	@Column(name="tipr_id")
	private long tiprId;

	@Column(name="tipr_descripcion")
	private String tiprDescripcion;

	@Column(name="tipr_fechacambio")
	private String tiprFechacambio;

	@Column(name="tipr_horacambio")
	private String tiprHoracambio;

	@Column(name="tipr_nombre")
	private String tiprNombre;

	@Column(name="tipr_registradopor")
	private String tiprRegistradopor;

	//bi-directional many-to-one association to Procedimiento
	@OneToMany(mappedBy="tipoprocedimiento")
	private List<Procedimiento> procedimientos;

	public Tipoprocedimiento() {
	}

	public long getTiprId() {
		return this.tiprId;
	}

	public void setTiprId(long tiprId) {
		this.tiprId = tiprId;
	}

	public String getTiprDescripcion() {
		return this.tiprDescripcion;
	}

	public void setTiprDescripcion(String tiprDescripcion) {
		this.tiprDescripcion = tiprDescripcion;
	}

	public String getTiprFechacambio() {
		return this.tiprFechacambio;
	}

	public void setTiprFechacambio(String tiprFechacambio) {
		this.tiprFechacambio = tiprFechacambio;
	}

	public String getTiprHoracambio() {
		return this.tiprHoracambio;
	}

	public void setTiprHoracambio(String tiprHoracambio) {
		this.tiprHoracambio = tiprHoracambio;
	}

	public String getTiprNombre() {
		return this.tiprNombre;
	}

	public void setTiprNombre(String tiprNombre) {
		this.tiprNombre = tiprNombre;
	}

	public String getTiprRegistradopor() {
		return this.tiprRegistradopor;
	}

	public void setTiprRegistradopor(String tiprRegistradopor) {
		this.tiprRegistradopor = tiprRegistradopor;
	}

	public List<Procedimiento> getProcedimientos() {
		return this.procedimientos;
	}

	public void setProcedimientos(List<Procedimiento> procedimientos) {
		this.procedimientos = procedimientos;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.tiprRegistradopor=data.get(0);
			this.tiprFechacambio=data.get(1);
			this.tiprHoracambio=data.get(2);
		}
	}
}