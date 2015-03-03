package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "MOTIVO" database table.
 * 
 */
@Entity
@Table(name="\"MOTIVO\"", schema="\"HISCLINICA\"")
public class Motivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOTIVO_MOTIID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_MOTI_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOTIVO_MOTIID_GENERATOR")
	@Column(name="moti_id")
	private long motiId;

	@Column(name="moti_codigo")
	private String motiCodigo;

	@Column(name="moti_fechacambio")
	private String motiFechacambio;

	@Column(name="moti_horacambio")
	private String motiHoracambio;

	@Column(name="moti_motivo")
	private String motiMotivo;

	@Column(name="moti_registradopor")
	private String motiRegistradopor;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="motivo")
	private List<Servicio> servicios;

	public Motivo() {
	}

	public long getMotiId() {
		return this.motiId;
	}

	public void setMotiId(long motiId) {
		this.motiId = motiId;
	}

	public String getMotiCodigo() {
		return this.motiCodigo;
	}

	public void setMotiCodigo(String motiCodigo) {
		this.motiCodigo = motiCodigo;
	}

	public String getMotiFechacambio() {
		return this.motiFechacambio;
	}

	public void setMotiFechacambio(String motiFechacambio) {
		this.motiFechacambio = motiFechacambio;
	}

	public String getMotiHoracambio() {
		return this.motiHoracambio;
	}

	public void setMotiHoracambio(String motiHoracambio) {
		this.motiHoracambio = motiHoracambio;
	}

	public String getMotiMotivo() {
		return this.motiMotivo;
	}

	public void setMotiMotivo(String motiMotivo) {
		this.motiMotivo = motiMotivo;
	}

	public String getMotiRegistradopor() {
		return this.motiRegistradopor;
	}

	public void setMotiRegistradopor(String motiRegistradopor) {
		this.motiRegistradopor = motiRegistradopor;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.motiRegistradopor=data.get(0);
			this.motiFechacambio=data.get(1);
			this.motiHoracambio=data.get(2);
		}
	}
}