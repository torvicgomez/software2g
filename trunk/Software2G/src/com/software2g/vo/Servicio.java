package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "SERVICIO" database table.
 * 
 */
@Entity
@Table(name="\"SERVICIO\"", schema="\"HISCLINICA\"")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SERVICIO_SERVID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_SERV_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SERVICIO_SERVID_GENERATOR")
	@Column(name="serv_id")
	private long servId;

	//bi-directional many-to-one association to Profesional
	@ManyToOne
	@JoinColumn(name="prof_id")
	private Profesional profesional;
	
	@Column(name="serv_fechacambio")
	private String servFechacambio;

	@Column(name="serv_fechahoraingreso")
	private String servFechahoraingreso;

	@Column(name="serv_fechahorasalida")
	private String servFechahorasalida;

	@Column(name="serv_horacambio")
	private String servHoracambio;

	@Column(name="serv_registradopor")
	private String servRegistradopor;

	//bi-directional many-to-one association to Diagnostico
	@OneToMany(mappedBy="servicio")
	private List<Diagnostico> diagnosticos;

	//bi-directional many-to-one association to Examenoptometria
	@OneToMany(mappedBy="servicio")
	private List<Examenoptometria> examenoptometrias;

	//bi-directional many-to-one association to Formulacion
	@OneToMany(mappedBy="servicio")
	private List<Formulacion> formulacions;

	//bi-directional many-to-one association to Odontograma
	@OneToMany(mappedBy="servicio")
	private List<Odontograma> odontogramas;

	//bi-directional many-to-one association to Respuesta
	@OneToMany(mappedBy="servicio")
	private List<Respuesta> respuestas;

	//bi-directional many-to-one association to Acudiente
	@ManyToOne
	@JoinColumn(name="acud_id")
	private Acudiente acudiente;

	//bi-directional many-to-one association to Finalidad
	@ManyToOne
	@JoinColumn(name="fina_id")
	private Finalidad finalidad;

	//bi-directional many-to-one association to Motivo
	@ManyToOne
	@JoinColumn(name="moti_id")
	private Motivo motivo;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="paci_id")
	private Paciente paciente;

	//bi-directional many-to-one association to Seguridadsocial
	@ManyToOne
	@JoinColumn(name="segu_id")
	private Seguridadsocial seguridadsocial;

	//bi-directional many-to-one association to Tiposervicio
	@ManyToOne
	@JoinColumn(name="tise_id")
	private Tiposervicio tiposervicio;

	public Servicio() {
	}

	public long getServId() {
		return this.servId;
	}

	public void setServId(long servId) {
		this.servId = servId;
	}

	public String getServFechacambio() {
		return this.servFechacambio;
	}

	public void setServFechacambio(String servFechacambio) {
		this.servFechacambio = servFechacambio;
	}

	public String getServFechahoraingreso() {
		return this.servFechahoraingreso;
	}

	public void setServFechahoraingreso(String servFechahoraingreso) {
		this.servFechahoraingreso = servFechahoraingreso;
	}

	public String getServFechahorasalida() {
		return this.servFechahorasalida;
	}

	public void setServFechahorasalida(String servFechahorasalida) {
		this.servFechahorasalida = servFechahorasalida;
	}

	public String getServHoracambio() {
		return this.servHoracambio;
	}

	public void setServHoracambio(String servHoracambio) {
		this.servHoracambio = servHoracambio;
	}

	public String getServRegistradopor() {
		return this.servRegistradopor;
	}

	public void setServRegistradopor(String servRegistradopor) {
		this.servRegistradopor = servRegistradopor;
	}

	public List<Diagnostico> getDiagnosticos() {
		return this.diagnosticos;
	}

	public void setDiagnosticos(List<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}

	public List<Examenoptometria> getExamenoptometrias() {
		return this.examenoptometrias;
	}

	public void setExamenoptometrias(List<Examenoptometria> examenoptometrias) {
		this.examenoptometrias = examenoptometrias;
	}

	public List<Formulacion> getFormulacions() {
		return this.formulacions;
	}

	public void setFormulacions(List<Formulacion> formulacions) {
		this.formulacions = formulacions;
	}

	public List<Odontograma> getOdontogramas() {
		return this.odontogramas;
	}

	public void setOdontogramas(List<Odontograma> odontogramas) {
		this.odontogramas = odontogramas;
	}

	public List<Respuesta> getRespuestas() {
		return this.respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public Acudiente getAcudiente() {
		return this.acudiente;
	}

	public void setAcudiente(Acudiente acudiente) {
		this.acudiente = acudiente;
	}

	public Finalidad getFinalidad() {
		return this.finalidad;
	}

	public void setFinalidad(Finalidad finalidad) {
		this.finalidad = finalidad;
	}

	public Motivo getMotivo() {
		return this.motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
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

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.servRegistradopor=data.get(0);
			this.servFechacambio=data.get(1);
			this.servHoracambio=data.get(2);
		}
	}

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}
	
}