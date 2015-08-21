package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the portafoliocategoria database table.
 * 
 */
@Entity
@Table(name="PORTAFOLIOCATEGORIA", schema="NIIF") 
public class Portafoliocategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PORTAFOLIOCATEGORIA_POCAID_GENERATOR", sequenceName="NIIF.SEQ_POCA_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PORTAFOLIOCATEGORIA_POCAID_GENERATOR")
	@Column(name="poca_id")
	private long pocaId;

	@Column(name="poca_descripcion")
	private String pocaDescripcion;

	@Column(name="poca_fechacambio")
	private String pocaFechacambio;

	@Column(name="poca_horacambio")
	private String pocaHoracambio;

	@Column(name="poca_referencia")
	private String pocaReferencia;

	@Column(name="poca_registradopor")
	private String pocaRegistradopor;
	
	@Column(name="poca_backgroundcolor")
	private String pocaBackgroundcolor;

	//bi-directional many-to-one association to Portafolio
	@OneToMany(mappedBy="portafoliocategoria")
	private List<Portafolio> portafolios;

	@Transient 
	private Archivotabla archivo;
	
	public Portafoliocategoria() {
	}

	public long getPocaId() {
		return this.pocaId;
	}

	public void setPocaId(long pocaId) {
		this.pocaId = pocaId;
	}

	public String getPocaDescripcion() {
		return this.pocaDescripcion;
	}

	public void setPocaDescripcion(String pocaDescripcion) {
		this.pocaDescripcion = pocaDescripcion;
	}

	public String getPocaFechacambio() {
		return this.pocaFechacambio;
	}

	public void setPocaFechacambio(String pocaFechacambio) {
		this.pocaFechacambio = pocaFechacambio;
	}

	public String getPocaHoracambio() {
		return this.pocaHoracambio;
	}

	public void setPocaHoracambio(String pocaHoracambio) {
		this.pocaHoracambio = pocaHoracambio;
	}

	public String getPocaReferencia() {
		return this.pocaReferencia;
	}

	public void setPocaReferencia(String pocaReferencia) {
		this.pocaReferencia = pocaReferencia;
	}

	public String getPocaRegistradopor() {
		return this.pocaRegistradopor;
	}

	public void setPocaRegistradopor(String pocaRegistradopor) {
		this.pocaRegistradopor = pocaRegistradopor;
	}

	public List<Portafolio> getPortafolios() {
		return this.portafolios;
	}

	public void setPortafolios(List<Portafolio> portafolios) {
		this.portafolios = portafolios;
	}

	public Portafolio addPortafolio(Portafolio portafolio) {
		getPortafolios().add(portafolio);
		portafolio.setPortafoliocategoria(this);

		return portafolio;
	}

	public Portafolio removePortafolio(Portafolio portafolio) {
		getPortafolios().remove(portafolio);
		portafolio.setPortafoliocategoria(null);
		return portafolio;
	}
	
	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.pocaRegistradopor=data.get(0);
			this.pocaFechacambio=data.get(1);
			this.pocaHoracambio=data.get(2);
		}
	}

	public String getPocaBackgroundcolor() {
		return pocaBackgroundcolor;
	}

	public void setPocaBackgroundcolor(String pocaBackgroundcolor) {
		this.pocaBackgroundcolor = pocaBackgroundcolor;
	}

	public Archivotabla getArchivo() {
		return archivo;
	}

	public void setArchivo(Archivotabla archivo) {
		this.archivo = archivo;
	}

}