package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the consecutivo database table.
 * 
 */
@Entity
@Table(name="consecutivo", schema="niif") 
public class Consecutivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONSECUTIVO_CONSID_GENERATOR", sequenceName="NIIF.SEQ_CONS_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONSECUTIVO_CONSID_GENERATOR")
	@Column(name="cons_id")
	private long consId;

	@Column(name="cons_consecutivodis")
	private int consConsecutivodis;

	@Column(name="cons_fechacambio")
	private String consFechacambio;

	@Column(name="cons_finconsecutivo")
	private int consFinconsecutivo;

	@Column(name="cons_horacambio")
	private String consHoracambio;

	@Column(name="cons_iniconsecutivo")
	private int consIniconsecutivo;

	@Column(name="cons_registradopor")
	private String consRegistradopor;

	@Column(name="cons_vigencia")
	private String consVigencia;

	public Consecutivo() {
	}

	public long getConsId() {
		return this.consId;
	}

	public void setConsId(long consId) {
		this.consId = consId;
	}

	public int getConsConsecutivodis() {
		return this.consConsecutivodis;
	}

	public void setConsConsecutivodis(int consConsecutivodis) {
		this.consConsecutivodis = consConsecutivodis;
	}

	public String getConsFechacambio() {
		return this.consFechacambio;
	}

	public void setConsFechacambio(String consFechacambio) {
		this.consFechacambio = consFechacambio;
	}

	public int getConsFinconsecutivo() {
		return this.consFinconsecutivo;
	}

	public void setConsFinconsecutivo(int consFinconsecutivo) {
		this.consFinconsecutivo = consFinconsecutivo;
	}

	public String getConsHoracambio() {
		return this.consHoracambio;
	}

	public void setConsHoracambio(String consHoracambio) {
		this.consHoracambio = consHoracambio;
	}

	public int getConsIniconsecutivo() {
		return this.consIniconsecutivo;
	}

	public void setConsIniconsecutivo(int consIniconsecutivo) {
		this.consIniconsecutivo = consIniconsecutivo;
	}

	public String getConsRegistradopor() {
		return this.consRegistradopor;
	}

	public void setConsRegistradopor(String consRegistradopor) {
		this.consRegistradopor = consRegistradopor;
	}

	public String getConsVigencia() {
		return this.consVigencia;
	}

	public void setConsVigencia(String consVigencia) {
		this.consVigencia = consVigencia;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.consRegistradopor=data.get(0);
			this.consFechacambio=data.get(1);
			this.consHoracambio=data.get(2);
		}
	}
}