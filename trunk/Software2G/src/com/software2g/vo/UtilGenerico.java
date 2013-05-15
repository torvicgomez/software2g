package com.software2g.vo;

import java.io.Serializable;

public class UtilGenerico implements Serializable {
	private static final long serialVersionUID = 1L;
	private String key;
	private String valor;

	public UtilGenerico(){}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
}
