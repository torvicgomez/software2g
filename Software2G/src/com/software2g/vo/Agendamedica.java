package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the agendamedica database table.
 * 
 */
@Entity
public class Agendamedica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AGENDAMEDICA_AGMEID_GENERATOR", sequenceName="HISTORIACLINICA.SEQ_AGME_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AGENDAMEDICA_AGMEID_GENERATOR")
	@Column(name="agme_id")
	private long agmeId;

	@Column(name="agme_fechacambio")
	private String agmeFechacambio;

	@Column(name="agme_horacambio")
	private String agmeHoracambio;

	@Column(name="agme_registradopor")
	private String agmeRegistradopor;

	//bi-directional many-to-one association to Profesionalsalud
	@ManyToOne
	@JoinColumn(name="prfs_id")
	private Profesionalsalud profesionalsalud;

	//bi-directional many-to-one association to Eventosagenda
	@OneToMany(mappedBy="agendamedica")
	private List<Eventosagenda> eventosagendas;

	public Agendamedica() {
	}

	public long getAgmeId() {
		return this.agmeId;
	}

	public void setAgmeId(long agmeId) {
		this.agmeId = agmeId;
	}

	public String getAgmeFechacambio() {
		return this.agmeFechacambio;
	}

	public void setAgmeFechacambio(String agmeFechacambio) {
		this.agmeFechacambio = agmeFechacambio;
	}

	public String getAgmeHoracambio() {
		return this.agmeHoracambio;
	}

	public void setAgmeHoracambio(String agmeHoracambio) {
		this.agmeHoracambio = agmeHoracambio;
	}

	public String getAgmeRegistradopor() {
		return this.agmeRegistradopor;
	}

	public void setAgmeRegistradopor(String agmeRegistradopor) {
		this.agmeRegistradopor = agmeRegistradopor;
	}

	public Profesionalsalud getProfesionalsalud() {
		return this.profesionalsalud;
	}

	public void setProfesionalsalud(Profesionalsalud profesionalsalud) {
		this.profesionalsalud = profesionalsalud;
	}

	public List<Eventosagenda> getEventosagendas() {
		return this.eventosagendas;
	}

	public void setEventosagendas(List<Eventosagenda> eventosagendas) {
		this.eventosagendas = eventosagendas;
	}

}