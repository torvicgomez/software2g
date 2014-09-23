package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipodiagnostico database table.
 * 
 */
@Entity
public class Tipodiagnostico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPODIAGNOSTICO_IDTIPODIAGNOS_GENERATOR", sequenceName="PUBLIC.TIPODIAGNOSTICO_ID_TIPODIAGNOS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPODIAGNOSTICO_IDTIPODIAGNOS_GENERATOR")
	@Column(name="id_tipodiagnos")
	private long idTipodiagnos;

	private String abreviatipodiag;

	private String desctipodiag;

	private String nomtipodiag;

	//bi-directional many-to-one association to Diagnostico
	@OneToMany(mappedBy="tipodiagnostico")
	private List<Diagnostico> diagnosticos;

	public Tipodiagnostico() {
	}

	public long getIdTipodiagnos() {
		return this.idTipodiagnos;
	}

	public void setIdTipodiagnos(long idTipodiagnos) {
		this.idTipodiagnos = idTipodiagnos;
	}

	public String getAbreviatipodiag() {
		return this.abreviatipodiag;
	}

	public void setAbreviatipodiag(String abreviatipodiag) {
		this.abreviatipodiag = abreviatipodiag;
	}

	public String getDesctipodiag() {
		return this.desctipodiag;
	}

	public void setDesctipodiag(String desctipodiag) {
		this.desctipodiag = desctipodiag;
	}

	public String getNomtipodiag() {
		return this.nomtipodiag;
	}

	public void setNomtipodiag(String nomtipodiag) {
		this.nomtipodiag = nomtipodiag;
	}

	public List<Diagnostico> getDiagnosticos() {
		return this.diagnosticos;
	}

	public void setDiagnosticos(List<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}

}