package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the servicio database table.
 * 
 */
@Entity
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SERVICIO_IDSERVICIO_GENERATOR", sequenceName="PUBLIC.SERVICIO_ID_SERVICIO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SERVICIO_IDSERVICIO_GENERATOR")
	@Column(name="id_servicio")
	private long idServicio;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Time horafinal;

	private Time horainicio;

	@Column(name="id_dependencia")
	private long idDependencia;

	@Column(name="id_finalidad")
	private long idFinalidad;

	@Column(name="id_motivo")
	private long idMotivo;

	@Column(name="id_paciente")
	private long idPaciente;

	private double valor;

	//bi-directional many-to-many association to Profesional
	@ManyToMany
	@JoinTable(
		name="profesionalservicio"
		, joinColumns={
			@JoinColumn(name="id_servicio")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_profesional")
			}
		)
	private List<Profesional> profesionals;

	//bi-directional many-to-one association to Acudiente
	@ManyToOne
	@JoinColumn(name="id_acudiente")
	private Acudiente acudiente;

	//bi-directional many-to-one association to Seguridadsocial
	@ManyToOne
	@JoinColumn(name="id_seguridad")
	private Seguridadsocial seguridadsocial;

	//bi-directional many-to-one association to Tiposervicio
	@ManyToOne
	@JoinColumn(name="id_tiposervicio")
	private Tiposervicio tiposervicio;

	public Servicio() {
	}

	public long getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHorafinal() {
		return this.horafinal;
	}

	public void setHorafinal(Time horafinal) {
		this.horafinal = horafinal;
	}

	public Time getHorainicio() {
		return this.horainicio;
	}

	public void setHorainicio(Time horainicio) {
		this.horainicio = horainicio;
	}

	public long getIdDependencia() {
		return this.idDependencia;
	}

	public void setIdDependencia(long idDependencia) {
		this.idDependencia = idDependencia;
	}

	public long getIdFinalidad() {
		return this.idFinalidad;
	}

	public void setIdFinalidad(long idFinalidad) {
		this.idFinalidad = idFinalidad;
	}

	public long getIdMotivo() {
		return this.idMotivo;
	}

	public void setIdMotivo(long idMotivo) {
		this.idMotivo = idMotivo;
	}

	public long getIdPaciente() {
		return this.idPaciente;
	}

	public void setIdPaciente(long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Profesional> getProfesionals() {
		return this.profesionals;
	}

	public void setProfesionals(List<Profesional> profesionals) {
		this.profesionals = profesionals;
	}

	public Acudiente getAcudiente() {
		return this.acudiente;
	}

	public void setAcudiente(Acudiente acudiente) {
		this.acudiente = acudiente;
	}

	public Seguridadsocial getSeguridadsocial() {
		return this.seguridadsocial;
	}

	public void setSeguridadsocial(Seguridadsocial seguridadsocial) {
		this.seguridadsocial = seguridadsocial;
	}

	public Tiposervicio getTiposervicio() {
		return this.tiposervicio;
	}

	public void setTiposervicio(Tiposervicio tiposervicio) {
		this.tiposervicio = tiposervicio;
	}

}