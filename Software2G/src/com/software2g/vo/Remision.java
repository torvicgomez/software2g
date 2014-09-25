package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the remision database table.
 * 
 */
@Entity
@Table(schema="public", name="remision")
public class Remision implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REMISION_IDREMISION_GENERATOR", sequenceName="PUBLIC.REMISION_ID_REMISION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REMISION_IDREMISION_GENERATOR")
	@Column(name="id_remision")
	private long idRemision;

	@Temporal(TemporalType.DATE)
	private Date fecharemision;

	private Time horaremision;

	@Column(name="id_consulta")
	private long idConsulta;

	private String institucionrecptora;

	private String motivoremision;

	private String tipoatencion;

	private String tiposervicio;

	public Remision() {
	}

	public long getIdRemision() {
		return this.idRemision;
	}

	public void setIdRemision(long idRemision) {
		this.idRemision = idRemision;
	}

	public Date getFecharemision() {
		return this.fecharemision;
	}

	public void setFecharemision(Date fecharemision) {
		this.fecharemision = fecharemision;
	}

	public Time getHoraremision() {
		return this.horaremision;
	}

	public void setHoraremision(Time horaremision) {
		this.horaremision = horaremision;
	}

	public long getIdConsulta() {
		return this.idConsulta;
	}

	public void setIdConsulta(long idConsulta) {
		this.idConsulta = idConsulta;
	}

	public String getInstitucionrecptora() {
		return this.institucionrecptora;
	}

	public void setInstitucionrecptora(String institucionrecptora) {
		this.institucionrecptora = institucionrecptora;
	}

	public String getMotivoremision() {
		return this.motivoremision;
	}

	public void setMotivoremision(String motivoremision) {
		this.motivoremision = motivoremision;
	}

	public String getTipoatencion() {
		return this.tipoatencion;
	}

	public void setTipoatencion(String tipoatencion) {
		this.tipoatencion = tipoatencion;
	}

	public String getTiposervicio() {
		return this.tiposervicio;
	}

	public void setTiposervicio(String tiposervicio) {
		this.tiposervicio = tiposervicio;
	}

}