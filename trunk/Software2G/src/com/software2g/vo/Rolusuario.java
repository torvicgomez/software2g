package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rolusuario database table.
 * 
 */
@Entity
@Table(schema="portal", name="rolusuario")
public class Rolusuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RolusuarioPK id;

	private String fechacambio;

	private String horacambio;

	private String registradopor;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(insertable=false,updatable=false,name="id_rol")
	private Rol rol;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(insertable=false,updatable=false,name="login_usua")
	private Usuario usuario;

	public Rolusuario() {
	}

	public RolusuarioPK getId() {
		return this.id;
	}

	public void setId(RolusuarioPK id) {
		this.id = id;
	}

	public String getFechacambio() {
		return this.fechacambio;
	}

	public void setFechacambio(String fechacambio) {
		this.fechacambio = fechacambio;
	}

	public String getHoracambio() {
		return this.horacambio;
	}

	public void setHoracambio(String horacambio) {
		this.horacambio = horacambio;
	}

	public String getRegistradopor() {
		return this.registradopor;
	}

	public void setRegistradopor(String registradopor) {
		this.registradopor = registradopor;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}