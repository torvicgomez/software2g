package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "FINALIDAD" database table.
 * 
 */
@Entity
@Table(name="\"FINALIDAD\"", schema="\"HISCLINICA\"")
public class Finalidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@SequenceGenerator(name="FINALIDAD_FINAID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_FINA_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FINALIDAD_FINAID_GENERATOR")
	@Column(name="fina_id")
	private long finaId;

	@Column(name="fina_codigo")
	private String finaCodigo;

	@Column(name="fina_fechacambio")
	private String finaFechacambio;

	@Column(name="fina_horacambio")
	private String finaHoracambio;

	@Column(name="fina_finalidad") 
	private String finaFinalidad;

	@Column(name="fina_registradopor")
	private String finaRegistradopor;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="finalidad")
	private List<Servicio> servicios;

	public Finalidad() {
	}

	public long getFinaId() {
		return this.finaId;
	}

	public void setFinaId(long finaId) {
		this.finaId = finaId;
	}

	public String getFinaCodigo() {
		return this.finaCodigo;
	}

	public void setFinaCodigo(String finaCodigo) {
		this.finaCodigo = finaCodigo;
	}

	public String getFinaFechacambio() {
		return this.finaFechacambio;
	}

	public void setFinaFechacambio(String finaFechacambio) {
		this.finaFechacambio = finaFechacambio;
	}

	public String getFinaHoracambio() {
		return this.finaHoracambio;
	}

	public void setFinaHoracambio(String finaHoracambio) {
		this.finaHoracambio = finaHoracambio;
	}

	public String getFinaRegistradopor() {
		return this.finaRegistradopor;
	}

	public void setFinaRegistradopor(String finaRegistradopor) {
		this.finaRegistradopor = finaRegistradopor;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public String getFinaFinalidad() {
		return finaFinalidad;
	}

	public void setFinaFinalidad(String finaFinalidad) {
		this.finaFinalidad = finaFinalidad; 
	}
	
	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.finaRegistradopor=data.get(0);
			this.finaFechacambio=data.get(1);
			this.finaHoracambio=data.get(2);
		}
	}
}