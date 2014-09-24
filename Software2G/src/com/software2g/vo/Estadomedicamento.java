package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the estadomedicamento database table.
 * 
 */
@Entity
@Table(schema="public", name="estadomedicamento")
public class Estadomedicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESTADOMEDICAMENTO_IDESTMEDICAMENTO_GENERATOR", sequenceName="PUBLIC.ESTADOMEDICAMENTO_ID_ESTMEDICAMENTO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTADOMEDICAMENTO_IDESTMEDICAMENTO_GENERATOR")
	@Column(name="id_estmedicamento")
	private long idEstmedicamento;

	private String abreviaturaestmed;

	private String descestmed;

	private String nombreestmed;

	//bi-directional many-to-one association to Tomasinodroga
	@OneToMany(mappedBy="estadomedicamento")
	private List<Tomasinodroga> tomasinodrogas;

	public Estadomedicamento() {
	}

	public long getIdEstmedicamento() {
		return this.idEstmedicamento;
	}

	public void setIdEstmedicamento(long idEstmedicamento) {
		this.idEstmedicamento = idEstmedicamento;
	}

	public String getAbreviaturaestmed() {
		return this.abreviaturaestmed;
	}

	public void setAbreviaturaestmed(String abreviaturaestmed) {
		this.abreviaturaestmed = abreviaturaestmed;
	}

	public String getDescestmed() {
		return this.descestmed;
	}

	public void setDescestmed(String descestmed) {
		this.descestmed = descestmed;
	}

	public String getNombreestmed() {
		return this.nombreestmed;
	}

	public void setNombreestmed(String nombreestmed) {
		this.nombreestmed = nombreestmed;
	}

	public List<Tomasinodroga> getTomasinodrogas() {
		return this.tomasinodrogas;
	}

	public void setTomasinodrogas(List<Tomasinodroga> tomasinodrogas) {
		this.tomasinodrogas = tomasinodrogas;
	}

}