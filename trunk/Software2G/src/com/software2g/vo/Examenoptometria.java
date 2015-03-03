package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "EXAMENOPTOMETRIA" database table.
 * 
 */
@Entity
@Table(name="\"EXAMENOPTOMETRIA\"", schema="\"HISCLINICA\"")
public class Examenoptometria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXAMENOPTOMETRIA_EXOPID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_EXOP_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXAMENOPTOMETRIA_EXOPID_GENERATOR")
	@Column(name="exop_id")
	private long exopId;

	@Column(name="exop_fechacambio")
	private String exopFechacambio;

	@Column(name="exop_horacambio")
	private String exopHoracambio;

	@Column(name="exop_registradopor")
	private String exopRegistradopor;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="serv_id")
	private Servicio servicio;

	//bi-directional many-to-one association to Registroavsc
	@OneToMany(mappedBy="examenoptometria")
	private List<Registroavsc> registroavscs;

	//bi-directional many-to-one association to Registrocovertest
	@OneToMany(mappedBy="examenoptometria")
	private List<Registrocovertest> registrocovertests;

	//bi-directional many-to-one association to Registroexamensimple
	@OneToMany(mappedBy="examenoptometria")
	private List<Registroexamensimple> registroexamensimples;

	//bi-directional many-to-one association to Registrorxuso
	@OneToMany(mappedBy="examenoptometria")
	private List<Registrorxuso> registrorxusos;

	public Examenoptometria() {
	}

	public long getExopId() {
		return this.exopId;
	}

	public void setExopId(long exopId) {
		this.exopId = exopId;
	}

	public String getExopFechacambio() {
		return this.exopFechacambio;
	}

	public void setExopFechacambio(String exopFechacambio) {
		this.exopFechacambio = exopFechacambio;
	}

	public String getExopHoracambio() {
		return this.exopHoracambio;
	}

	public void setExopHoracambio(String exopHoracambio) {
		this.exopHoracambio = exopHoracambio;
	}

	public String getExopRegistradopor() {
		return this.exopRegistradopor;
	}

	public void setExopRegistradopor(String exopRegistradopor) {
		this.exopRegistradopor = exopRegistradopor;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public List<Registroavsc> getRegistroavscs() {
		return this.registroavscs;
	}

	public void setRegistroavscs(List<Registroavsc> registroavscs) {
		this.registroavscs = registroavscs;
	}

	public List<Registrocovertest> getRegistrocovertests() {
		return this.registrocovertests;
	}

	public void setRegistrocovertests(List<Registrocovertest> registrocovertests) {
		this.registrocovertests = registrocovertests;
	}

	public List<Registroexamensimple> getRegistroexamensimples() {
		return this.registroexamensimples;
	}

	public void setRegistroexamensimples(List<Registroexamensimple> registroexamensimples) {
		this.registroexamensimples = registroexamensimples;
	}

	public List<Registrorxuso> getRegistrorxusos() {
		return this.registrorxusos;
	}

	public void setRegistrorxusos(List<Registrorxuso> registrorxusos) {
		this.registrorxusos = registrorxusos;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.exopRegistradopor=data.get(0);
			this.exopFechacambio=data.get(1);
			this.exopHoracambio=data.get(2);
		}
	}
}