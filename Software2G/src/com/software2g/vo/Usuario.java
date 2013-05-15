package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(schema="portal",name="usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_LOGINUSUA_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_LOGINUSUA_GENERATOR")
	@Column(name="login_usua")
	private String loginUsua;

	@Column(name="estado_usua")
	private String estadoUsua;

	private String fechacambio;

	private String horacambio;

	@Column(name="password_usua")
	private String passwordUsua;

	private String registradopor;

	//bi-directional many-to-one association to Rolusuario
	@OneToMany(mappedBy="usuario")
	private List<Rolusuario> rolusuarios;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_pers")
	private Persona persona;
	
	@Transient
	private String newPassword;
	@Transient
	private String confirmNewPassword;

	public Usuario() {
	}

	public String getLoginUsua() {
		return this.loginUsua;
	}

	public void setLoginUsua(String loginUsua) {
		this.loginUsua = loginUsua;
	}

	public String getEstadoUsua() {
		return this.estadoUsua;
	}

	public void setEstadoUsua(String estadoUsua) {
		this.estadoUsua = estadoUsua;
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

	public String getPasswordUsua() {
		return this.passwordUsua;
	}

	public void setPasswordUsua(String passwordUsua) {
		this.passwordUsua = passwordUsua;
	}

	public String getRegistradopor() {
		return this.registradopor;
	}

	public void setRegistradopor(String registradopor) {
		this.registradopor = registradopor;
	}

	public List<Rolusuario> getRolusuarios() {
		return this.rolusuarios;
	}

	public void setRolusuarios(List<Rolusuario> rolusuarios) {
		this.rolusuarios = rolusuarios;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}

}