package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="PORTAL", name="MUNICIPIO")
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_mcpo")
	private long mcpoId;

	@Column(name="nommunicipio")
	private String nommunicipio;
	
	@ManyToOne
	@JoinColumn(name="id_dpto")
	private Departamento departamento;
	
	//bi-directional many-to-one association to Abono
	@OneToMany(mappedBy="municipio")
	private List<Persona> personas;
	
	
	public Municipio(){
	}

	public long getMcpoId() {
		return mcpoId;
	}

	public void setMcpoId(long mcpoId) {
		this.mcpoId = mcpoId;
	}

	public String getNommunicipio() {
		return nommunicipio;
	}

	public void setNommunicipio(String nommunicipio) {
		this.nommunicipio = nommunicipio;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

}
