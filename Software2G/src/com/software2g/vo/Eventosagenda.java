package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the eventosagenda database table.
 * 
 */
@Entity
public class Eventosagenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVENTOSAGENDA_EVENID_GENERATOR", sequenceName="HISTORIACLINICA.SEQ_EVEN_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENTOSAGENDA_EVENID_GENERATOR")
	@Column(name="even_id")
	private long evenId;

	@Column(name="even_fechacambio")
	private String evenFechacambio;

	@Column(name="even_horacambio")
	private String evenHoracambio;

	@Column(name="even_registradopor")
	private String evenRegistradopor;

	//bi-directional many-to-one association to Agendamedica
	@ManyToOne
	@JoinColumn(name="agme_id")
	private Agendamedica agendamedica;

	//bi-directional many-to-one association to Participanteagenda
	@OneToMany(mappedBy="eventosagenda")
	private List<Participanteagenda> participanteagendas;

	public Eventosagenda() {
	}

	public long getEvenId() {
		return this.evenId;
	}

	public void setEvenId(long evenId) {
		this.evenId = evenId;
	}

	public String getEvenFechacambio() {
		return this.evenFechacambio;
	}

	public void setEvenFechacambio(String evenFechacambio) {
		this.evenFechacambio = evenFechacambio;
	}

	public String getEvenHoracambio() {
		return this.evenHoracambio;
	}

	public void setEvenHoracambio(String evenHoracambio) {
		this.evenHoracambio = evenHoracambio;
	}

	public String getEvenRegistradopor() {
		return this.evenRegistradopor;
	}

	public void setEvenRegistradopor(String evenRegistradopor) {
		this.evenRegistradopor = evenRegistradopor;
	}

	public Agendamedica getAgendamedica() {
		return this.agendamedica;
	}

	public void setAgendamedica(Agendamedica agendamedica) {
		this.agendamedica = agendamedica;
	}

	public List<Participanteagenda> getParticipanteagendas() {
		return this.participanteagendas;
	}

	public void setParticipanteagendas(List<Participanteagenda> participanteagendas) {
		this.participanteagendas = participanteagendas;
	}

}