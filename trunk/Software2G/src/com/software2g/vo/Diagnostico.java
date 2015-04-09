package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the "DIAGNOSTICO" database table.
 * 
 */
@Entity
@Table(name="\"DIAGNOSTICO\"", schema="\"HISCLINICA\"")
public class Diagnostico implements Serializable, Comparable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DIAGNOSTICO_DIAGID_GENERATOR", sequenceName="\"HISCLINICA\".\"SEQ_DIAG_ID\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DIAGNOSTICO_DIAGID_GENERATOR")
	@Column(name="diag_id")
	private long diagId;

	@Column(name="diag_fechacambio")
	private String diagFechacambio;

	@Column(name="diag_horacambio")
	private String diagHoracambio;

	@Column(name="diag_orden")
	private long diagOrden;

	@Column(name="diag_registradopor")
	private String diagRegistradopor;

	//bi-directional many-to-one association to Clasediagnostico
	@ManyToOne
	@JoinColumn(name="cldi_id")
	private Clasediagnostico clasediagnostico;

	//bi-directional many-to-one association to Codigoenfermedade
	@ManyToOne
	@JoinColumn(name="coen_id")
	private Codigoenfermedade codigoenfermedade;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="serv_id")
	private Servicio servicio;

	//bi-directional many-to-one association to Tipodiagnostico
	@ManyToOne
	@JoinColumn(name="tidi_id")
	private Tipodiagnostico tipodiagnostico;

	public Diagnostico() {
	}

	public long getDiagId() {
		return this.diagId;
	}

	public void setDiagId(long diagId) {
		this.diagId = diagId;
	}

	public String getDiagFechacambio() {
		return this.diagFechacambio;
	}

	public void setDiagFechacambio(String diagFechacambio) {
		this.diagFechacambio = diagFechacambio;
	}

	public String getDiagHoracambio() {
		return this.diagHoracambio;
	}

	public void setDiagHoracambio(String diagHoracambio) {
		this.diagHoracambio = diagHoracambio;
	}

	public long getDiagOrden() {
		return this.diagOrden;
	}

	public void setDiagOrden(long diagOrden) {
		this.diagOrden = diagOrden;
	}

	public String getDiagRegistradopor() {
		return this.diagRegistradopor;
	}

	public void setDiagRegistradopor(String diagRegistradopor) {
		this.diagRegistradopor = diagRegistradopor;
	}

	public Clasediagnostico getClasediagnostico() {
		return this.clasediagnostico;
	}

	public void setClasediagnostico(Clasediagnostico clasediagnostico) {
		this.clasediagnostico = clasediagnostico;
	}

	public Codigoenfermedade getCodigoenfermedade() {
		return this.codigoenfermedade;
	}

	public void setCodigoenfermedade(Codigoenfermedade codigoenfermedade) {
		this.codigoenfermedade = codigoenfermedade;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Tipodiagnostico getTipodiagnostico() {
		return this.tipodiagnostico;
	}

	public void setTipodiagnostico(Tipodiagnostico tipodiagnostico) {
		this.tipodiagnostico = tipodiagnostico;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.diagRegistradopor=data.get(0);
			this.diagFechacambio=data.get(1);
			this.diagHoracambio=data.get(2);
		}
	}

	@Override
	public int compareTo(Object obj) {
		Diagnostico diagnostico = (Diagnostico)obj;
		return (int) (this.diagOrden - diagnostico.getDiagOrden());
	}
}