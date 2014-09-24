package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the diagnostico database table.
 * 
 */
@Entity
@Table(name="diagnostico", schema="public")
public class Diagnostico implements Serializable {
	private static final long serialVersionUID = 1L;

	private String descdiagnos;

	@Column(name="id_clasediagnostico")
	private long idClasediagnostico;

	@Column(name="id_codenfermedad")
	private long idCodenfermedad;

	@Column(name="id_consulta")
	private long idConsulta;

	@Id
	@SequenceGenerator(name="DIAGNOSTICO_IDDIAGNOSTICO_GENERATOR", sequenceName="PUBLIC.diagnostico_id_diagnostico_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DIAGNOSTICO_IDDIAGNOSTICO_GENERATOR")
	@Column(name="id_diagnostico")
	private long idDiagnostico;

	//bi-directional many-to-one association to Tipodiagnostico
	@ManyToOne
	@JoinColumn(name="id_tipodiagnos")
	private Tipodiagnostico tipodiagnostico;

	public Diagnostico() {
	}

	public String getDescdiagnos() {
		return this.descdiagnos;
	}

	public void setDescdiagnos(String descdiagnos) {
		this.descdiagnos = descdiagnos;
	}

	public long getIdClasediagnostico() {
		return this.idClasediagnostico;
	}

	public void setIdClasediagnostico(long idClasediagnostico) {
		this.idClasediagnostico = idClasediagnostico;
	}

	public long getIdCodenfermedad() {
		return this.idCodenfermedad;
	}

	public void setIdCodenfermedad(long idCodenfermedad) {
		this.idCodenfermedad = idCodenfermedad;
	}

	public long getIdConsulta() {
		return this.idConsulta;
	}

	public void setIdConsulta(long idConsulta) {
		this.idConsulta = idConsulta;
	}

	public long getIdDiagnostico() {
		return this.idDiagnostico;
	}

	public void setIdDiagnostico(long idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}

	public Tipodiagnostico getTipodiagnostico() {
		return this.tipodiagnostico;
	}

	public void setTipodiagnostico(Tipodiagnostico tipodiagnostico) {
		this.tipodiagnostico = tipodiagnostico;
	}

}