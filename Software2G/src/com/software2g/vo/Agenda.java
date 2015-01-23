package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "AGENDA" database table.
 * 
 */
@Entity
@Table(name="AGENDA", schema="HISCLINICA") 
public class Agenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AGENDA_AGENID_GENERATOR", sequenceName="HISCLINICA.SEQ_AGEN_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AGENDA_AGENID_GENERATOR")
	@Column(name="agen_id")
	private long agenId;

	@Column(name="agen_fechacambio")
	private String agenFechacambio;

	@Temporal(TemporalType.DATE)
	@Column(name="agen_fechafin")
	private Date agenFechafin;

	@Temporal(TemporalType.DATE)
	@Column(name="agen_fechaini")
	private Date agenFechaini;

	@Column(name="agen_horacambio")
	private String agenHoracambio;

	@Column(name="agen_registradopor")
	private String agenRegistradopor;

	@Column(name="agen_duracionevento")
	private String agenDuracionevento;
	
	@Column(name="agen_scrolltime")
	private String agenScrolltime;
	
	@Column(name="agen_mintime")
	private String agenMintime;
	
	@Column(name="agen_maxtime")
	private String agenMaxtime;
	
	@Column(name="agen_alldayslot")
	private String agenAlldayslot;
	
	@Column(name="agen_alldaytext")
	private String agenAlldaytext;
	
	//bi-directional many-to-one association to Profesional
	@ManyToOne
	@JoinColumn(name="id_profesional")
	private Profesional profesional;

	//bi-directional many-to-one association to Evento
	@OneToMany(mappedBy="agenda")
	private List<Evento> eventos;

	//bi-directional many-to-one association to Tiemponodisponible
	@OneToMany(mappedBy="agenda")
	private List<Tiemponodisponible> tiemponodisponibles;

	public Agenda() {
	}

	public long getAgenId() {
		return this.agenId;
	}

	public void setAgenId(long agenId) {
		this.agenId = agenId;
	}

	public String getAgenFechacambio() {
		return this.agenFechacambio;
	}

	public void setAgenFechacambio(String agenFechacambio) {
		this.agenFechacambio = agenFechacambio;
	}

	public Date getAgenFechafin() {
		return this.agenFechafin;
	}

	public void setAgenFechafin(Date agenFechafin) {
		this.agenFechafin = agenFechafin;
	}

	public Date getAgenFechaini() {
		return this.agenFechaini;
	}

	public void setAgenFechaini(Date agenFechaini) {
		this.agenFechaini = agenFechaini;
	}

	public String getAgenHoracambio() {
		return this.agenHoracambio;
	}

	public void setAgenHoracambio(String agenHoracambio) {
		this.agenHoracambio = agenHoracambio;
	}

	public String getAgenRegistradopor() {
		return this.agenRegistradopor;
	}

	public void setAgenRegistradopor(String agenRegistradopor) {
		this.agenRegistradopor = agenRegistradopor;
	}

	public Profesional getProfesional() {
		return this.profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	public List<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public List<Tiemponodisponible> getTiemponodisponibles() {
		return this.tiemponodisponibles;
	}

	public void setTiemponodisponibles(List<Tiemponodisponible> tiemponodisponibles) {
		this.tiemponodisponibles = tiemponodisponibles;
	}

	public String getAgenDuracionevento() {
		return agenDuracionevento;
	}

	public void setAgenDuracionevento(String agenDuracionevento) {
		this.agenDuracionevento = agenDuracionevento;
	}

	public String getAgenScrolltime() {
		return agenScrolltime;
	}

	public void setAgenScrolltime(String agenScrolltime) {
		this.agenScrolltime = agenScrolltime;
	}

	public String getAgenMintime() {
		return agenMintime;
	}

	public void setAgenMintime(String agenMintime) {
		this.agenMintime = agenMintime;
	}

	public String getAgenMaxtime() {
		return agenMaxtime;
	}

	public void setAgenMaxtime(String agenMaxtime) {
		this.agenMaxtime = agenMaxtime;
	}

	public String getAgenAlldayslot() {
		return agenAlldayslot;
	}

	public void setAgenAlldayslot(String agenAlldayslot) {
		this.agenAlldayslot = agenAlldayslot;
	}

	public String getAgenAlldaytext() {
		return agenAlldaytext;
	}

	public void setAgenAlldaytext(String agenAlldaytext) {
		this.agenAlldaytext = agenAlldaytext;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.agenRegistradopor=data.get(0);
			this.agenFechacambio=data.get(1);
			this.agenHoracambio=data.get(2);
		}
	}
}