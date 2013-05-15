package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the tipodescuento database table.
 * 
 */
@Entity
@Table(schema="CONTABLE", name="TIPODESCUENTO")
public class Tipodescuento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPODESCUENTO_TIDEID_GENERATOR", sequenceName="CONTABLE.S_TIDE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPODESCUENTO_TIDEID_GENERATOR")
	@Column(name="tide_id")
	private long tideId;

	@Column(name="tide_descripcion")
	private String tideDescripcion;

	@Column(name="tide_estado")
	private String tideEstado;

	@Column(name="tide_fechafin")
	private String tideFechafin;

	@Column(name="tide_fechainicio")
	private String tideFechainicio;

	@Column(name="tide_fechamodificacion")
	private String tideFechamodificacion;

	@Column(name="tide_hora")
	private String tideHora;

	@Column(name="tide_porcentaje")
	private double tidePorcentaje;

	@Column(name="tide_registradopor")
	private String tideRegistradopor;

	@Column(name="tide_valor")
	private double tideValor;

	//bi-directional many-to-one association to Creditotipodescuento
	@OneToMany(mappedBy="tipodescuento")
	private List<Creditotipodescuento> creditotipodescuentos;

	public Tipodescuento() {
	}

	public long getTideId() {
		return this.tideId;
	}

	public void setTideId(long tideId) {
		this.tideId = tideId;
	}

	public String getTideDescripcion() {
		return this.tideDescripcion;
	}

	public void setTideDescripcion(String tideDescripcion) {
		this.tideDescripcion = tideDescripcion;
	}

	public String getTideEstado() {
		return this.tideEstado;
	}

	public void setTideEstado(String tideEstado) {
		this.tideEstado = tideEstado;
	}

	public String getTideFechafin() {
		return this.tideFechafin;
	}

	public void setTideFechafin(String tideFechafin) {
		this.tideFechafin = tideFechafin;
	}

	public String getTideFechainicio() {
		return this.tideFechainicio;
	}

	public void setTideFechainicio(String tideFechainicio) {
		this.tideFechainicio = tideFechainicio;
	}

	public String getTideFechamodificacion() {
		return this.tideFechamodificacion;
	}

	public void setTideFechamodificacion(String tideFechamodificacion) {
		this.tideFechamodificacion = tideFechamodificacion;
	}

	public String getTideHora() {
		return this.tideHora;
	}

	public void setTideHora(String tideHora) {
		this.tideHora = tideHora;
	}

	public double getTidePorcentaje() {
		return this.tidePorcentaje;
	}

	public void setTidePorcentaje(double tidePorcentaje) {
		this.tidePorcentaje = tidePorcentaje;
	}

	public String getTideRegistradopor() {
		return this.tideRegistradopor;
	}

	public void setTideRegistradopor(String tideRegistradopor) {
		this.tideRegistradopor = tideRegistradopor;
	}

	public double getTideValor() {
		return this.tideValor;
	}

	public void setTideValor(double tideValor) {
		this.tideValor = tideValor;
	}

	public List<Creditotipodescuento> getCreditotipodescuentos() {
		return this.creditotipodescuentos;
	}

	public void setCreditotipodescuentos(List<Creditotipodescuento> creditotipodescuentos) {
		this.creditotipodescuentos = creditotipodescuentos;
	}

	
	public Creditotipodescuento addCreditotipodescuentos(Creditotipodescuento creditotipodescuentos) {
		getCreditotipodescuentos().add(creditotipodescuentos);
		creditotipodescuentos.setTipodescuento(this);

		return creditotipodescuentos;
	}

	public Creditotipodescuento removeCreditotipodescuentos(Creditotipodescuento creditotipodescuentos) {
		getCreditotipodescuentos().remove(creditotipodescuentos);
		creditotipodescuentos.setTipodescuento(null);

		return creditotipodescuentos;
	}
}