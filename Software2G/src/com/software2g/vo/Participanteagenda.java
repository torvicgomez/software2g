package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the participanteagenda database table.
 * 
 */
@Entity
public class Participanteagenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PARTICIPANTEAGENDA_PARTID_GENERATOR", sequenceName="HISTORIACLINICA.SEQ_PART_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARTICIPANTEAGENDA_PARTID_GENERATOR")
	@Column(name="part_id")
	private long partId;

	@Column(name="part_fechacambio")
	private String partFechacambio;

	@Column(name="part_horacambio")
	private String partHoracambio;

	@Column(name="part_registradopor")
	private String partRegistradopor;

	//bi-directional many-to-one association to Eventosagenda
	@ManyToOne
	@JoinColumn(name="even_id")
	private Eventosagenda eventosagenda;

	public Participanteagenda() {
	}

	public long getPartId() {
		return this.partId;
	}

	public void setPartId(long partId) {
		this.partId = partId;
	}

	public String getPartFechacambio() {
		return this.partFechacambio;
	}

	public void setPartFechacambio(String partFechacambio) {
		this.partFechacambio = partFechacambio;
	}

	public String getPartHoracambio() {
		return this.partHoracambio;
	}

	public void setPartHoracambio(String partHoracambio) {
		this.partHoracambio = partHoracambio;
	}

	public String getPartRegistradopor() {
		return this.partRegistradopor;
	}

	public void setPartRegistradopor(String partRegistradopor) {
		this.partRegistradopor = partRegistradopor;
	}

	public Eventosagenda getEventosagenda() {
		return this.eventosagenda;
	}

	public void setEventosagenda(Eventosagenda eventosagenda) {
		this.eventosagenda = eventosagenda;
	}

}