package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "ESPECIFICACIONPARTECUERPO" database table.
 * 
 */
@Entity
@Table(name="\"ESPECIFICACIONPARTECUERPO\"", schema="\"HISCLINICA\"")
public class Especificacionpartecuerpo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESPECIFICACIONPARTECUERPO_ESPCID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_ESPC_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESPECIFICACIONPARTECUERPO_ESPCID_GENERATOR")
	@Column(name="espc_id")
	private long espcId;

	@Column(name="espc_etiqueta")
	private String espcEtiqueta;

	@Column(name="espc_fechacambio")
	private String espcFechacambio;

	@Column(name="espc_horacambio")
	private String espcHoracambio;

	@Column(name="espc_nombre")
	private String espcNombre;

	@Column(name="espc_registradopor")
	private String espcRegistradopor;

	//bi-directional many-to-one association to Partecuerpo
	@ManyToOne
	@JoinColumn(name="part_id")
	private Partecuerpo partecuerpo;

	//bi-directional many-to-one association to Posicion
	@ManyToOne
	@JoinColumn(name="posi_id")
	private Posicion posicion;

	//bi-directional many-to-one association to Gafa
	@OneToMany(mappedBy="especificacionpartecuerpo")
	private List<Gafa> gafas;

	//bi-directional many-to-one association to Registroavsc
	@OneToMany(mappedBy="especificacionpartecuerpo")
	private List<Registroavsc> registroavscs;

	//bi-directional many-to-one association to Registrocovertest
	@OneToMany(mappedBy="especificacionpartecuerpo")
	private List<Registrocovertest> registrocovertests;

	//bi-directional many-to-one association to Registroexamensimple
	@OneToMany(mappedBy="especificacionpartecuerpo")
	private List<Registroexamensimple> registroexamensimples;

	//bi-directional many-to-one association to Registroodontograma
	@OneToMany(mappedBy="especificacionpartecuerpo")
	private List<Registroodontograma> registroodontogramas;

	//bi-directional many-to-one association to Registrorxuso
	@OneToMany(mappedBy="especificacionpartecuerpo")
	private List<Registrorxuso> registrorxusos;

	public Especificacionpartecuerpo() {
	}

	public long getEspcId() {
		return this.espcId;
	}

	public void setEspcId(long espcId) {
		this.espcId = espcId;
	}

	public String getEspcEtiqueta() {
		return this.espcEtiqueta;
	}

	public void setEspcEtiqueta(String espcEtiqueta) {
		this.espcEtiqueta = espcEtiqueta;
	}

	public String getEspcFechacambio() {
		return this.espcFechacambio;
	}

	public void setEspcFechacambio(String espcFechacambio) {
		this.espcFechacambio = espcFechacambio;
	}

	public String getEspcHoracambio() {
		return this.espcHoracambio;
	}

	public void setEspcHoracambio(String espcHoracambio) {
		this.espcHoracambio = espcHoracambio;
	}

	public String getEspcNombre() {
		return this.espcNombre;
	}

	public void setEspcNombre(String espcNombre) {
		this.espcNombre = espcNombre;
	}

	public String getEspcRegistradopor() {
		return this.espcRegistradopor;
	}

	public void setEspcRegistradopor(String espcRegistradopor) {
		this.espcRegistradopor = espcRegistradopor;
	}

	public Partecuerpo getPartecuerpo() {
		return this.partecuerpo;
	}

	public void setPartecuerpo(Partecuerpo partecuerpo) {
		this.partecuerpo = partecuerpo;
	}

	public Posicion getPosicion() {
		return this.posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public List<Gafa> getGafas() {
		return this.gafas;
	}

	public void setGafas(List<Gafa> gafas) {
		this.gafas = gafas;
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

	public List<Registroodontograma> getRegistroodontogramas() {
		return this.registroodontogramas;
	}

	public void setRegistroodontogramas(List<Registroodontograma> registroodontogramas) {
		this.registroodontogramas = registroodontogramas;
	}

	public List<Registrorxuso> getRegistrorxusos() {
		return this.registrorxusos;
	}

	public void setRegistrorxusos(List<Registrorxuso> registrorxusos) {
		this.registrorxusos = registrorxusos;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.espcRegistradopor=data.get(0);
			this.espcFechacambio=data.get(1);
			this.espcHoracambio=data.get(2);
		}
	}
}