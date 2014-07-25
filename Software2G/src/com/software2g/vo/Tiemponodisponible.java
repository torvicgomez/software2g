package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "TIEMPONODISPONIBLE" database table.
 * 
 */
@Entity
@Table(name="TIEMPONODISPONIBLE", schema="HISCLINICA")
public class Tiemponodisponible implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIEMPONODISPONIBLE_TINDID_GENERATOR", sequenceName="HISCLINICA.SEQ_TIND_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIEMPONODISPONIBLE_TINDID_GENERATOR")
	@Column(name="tind_id")
	private long tindId;

	@Temporal(TemporalType.DATE)
	@Column(name="tind_fecha")
	private Date tindFecha;

	@Column(name="tind_fechacambio")
	private String tindFechacambio;

	@Column(name="tind_horacambio")
	private String tindHoracambio;

	@Column(name="tind_horafin")
	private String tindHorafin;

	@Column(name="tind_horaini")
	private String tindHoraini;

	@Column(name="tind_registradopor")
	private String tindRegistradopor;

	//bi-directional many-to-one association to Agenda
	@ManyToOne
	@JoinColumn(name="agen_id")
	private Agenda agenda;

	public Tiemponodisponible() {
	}

	public long getTindId() {
		return this.tindId;
	}

	public void setTindId(long tindId) {
		this.tindId = tindId;
	}

	public Date getTindFecha() {
		return this.tindFecha;
	}

	public void setTindFecha(Date tindFecha) {
		this.tindFecha = tindFecha;
	}

	public String getTindFechacambio() {
		return this.tindFechacambio;
	}

	public void setTindFechacambio(String tindFechacambio) {
		this.tindFechacambio = tindFechacambio;
	}

	public String getTindHoracambio() {
		return this.tindHoracambio;
	}

	public void setTindHoracambio(String tindHoracambio) {
		this.tindHoracambio = tindHoracambio;
	}

	public String getTindHorafin() {
		return this.tindHorafin;
	}

	public void setTindHorafin(String tindHorafin) {
		this.tindHorafin = tindHorafin;
	}

	public String getTindHoraini() {
		return this.tindHoraini;
	}

	public void setTindHoraini(String tindHoraini) {
		this.tindHoraini = tindHoraini;
	}

	public String getTindRegistradopor() {
		return this.tindRegistradopor;
	}

	public void setTindRegistradopor(String tindRegistradopor) {
		this.tindRegistradopor = tindRegistradopor;
	}

	public Agenda getAgenda() {
		return this.agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

}