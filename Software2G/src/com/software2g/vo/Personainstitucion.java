package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the personainstitucion database table.
 * 
 */
@Entity
@Table(schema="PORTAL", name="PERSONAINSTITUCION")
public class Personainstitucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonainstitucionPK id;

	@Column(name="estado_pein")
	private String estadoPein;

	private String fechacambio;

	private String horacambio;

	private String registradopor;

	//bi-directional many-to-one association to Institucion
	@ManyToOne
	@JoinColumn(insertable=false,updatable=false,name="id_inst")
	private Institucion institucion;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(insertable=false,updatable=false,name="id_pers")
	private Persona persona;

	public Personainstitucion() {
	}

	public PersonainstitucionPK getId() {
		return this.id;
	}

	public void setId(PersonainstitucionPK id) {
		this.id = id;
	}

	public String getEstadoPein() {
		return this.estadoPein;
	}

	public void setEstadoPein(String estadoPein) {
		this.estadoPein = estadoPein;
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

	public Institucion getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}