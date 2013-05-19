package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="PORTAL", name="PAIS")
public class Pais implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_pais")
	private long paisId;

	@Column(name="nompais")
	private String nompais;
	
	//bi-directional many-to-one association to Abono
	@OneToMany(mappedBy="pais")
	private List<Departamento> departamentos;
	
	public Pais(){
		
	}

	public long getPaisId() {
		return paisId;
	}

	public void setPaisId(long paisId) {
		this.paisId = paisId;
	}

	public String getNompais() {
		return nompais;
	}

	public void setNompais(String nompais) {
		this.nompais = nompais;
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

}
