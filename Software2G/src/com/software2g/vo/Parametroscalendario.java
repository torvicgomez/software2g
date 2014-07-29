package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the "PARAMETROSCALENDARIO" database table.
 * 
 */
@Entity
@Table(name="\"PARAMETROSCALENDARIO\"", schema="\"HISCLINICA\"")
public class Parametroscalendario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PARAMETROSCALENDARIO_PACAID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_PACA_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARAMETROSCALENDARIO_PACAID_GENERATOR")
	@Column(name="paca_id")
	private long pacaId;

	@Column(name="paca_fechacambio")
	private String pacaFechacambio;

	@Column(name="paca_horacambio")
	private String pacaHoracambio;

	@Column(name="paca_registradopor")
	private String pacaRegistradopor;

	@Column(name="paca_valor")
	private String pacaValor;

	@Column(name="paca_variable")
	private String pacaVariable;

	public Parametroscalendario() {
	}

	public long getPacaId() {
		return this.pacaId;
	}

	public void setPacaId(long pacaId) {
		this.pacaId = pacaId;
	}

	public String getPacaFechacambio() {
		return this.pacaFechacambio;
	}

	public void setPacaFechacambio(String pacaFechacambio) {
		this.pacaFechacambio = pacaFechacambio;
	}

	public String getPacaHoracambio() {
		return this.pacaHoracambio;
	}

	public void setPacaHoracambio(String pacaHoracambio) {
		this.pacaHoracambio = pacaHoracambio;
	}

	public String getPacaRegistradopor() {
		return this.pacaRegistradopor;
	}

	public void setPacaRegistradopor(String pacaRegistradopor) {
		this.pacaRegistradopor = pacaRegistradopor;
	}

	public String getPacaValor() {
		return this.pacaValor;
	}

	public void setPacaValor(String pacaValor) {
		this.pacaValor = pacaValor;
	}

	public String getPacaVariable() {
		return this.pacaVariable;
	}

	public void setPacaVariable(String pacaVariable) {
		this.pacaVariable = pacaVariable;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.pacaRegistradopor=data.get(0);
			this.pacaFechacambio=data.get(1);
			this.pacaHoracambio=data.get(2);
		}
	}
}