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
@Table(schema="PORTAL", name="DEPARTAMENTO")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_dpto")
	private long dptoId;

	@Column(name="nomdpto")
	private String nomdpto;
	
	@ManyToOne
	@JoinColumn(name="id_pais")
	private Pais pais; 
	
	//bi-directional many-to-one association to Abono
	@OneToMany(mappedBy="departamento")
	private List<Municipio> municipios;
	
	public Departamento(){
	}

	public long getDptoId() {
		return dptoId;
	}

	public void setDptoId(long dptoId) {
		this.dptoId = dptoId;
	}

	public String getNomdpto() {
		return nomdpto;
	}

	public void setNomdpto(String nomdpto) {
		this.nomdpto = nomdpto;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
}
