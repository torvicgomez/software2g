package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.software2g.util.ValidaString;


/**
 * The persistent class for the pagos database table.
 * 
 */
@Entity
@Table(name="pagos", schema="niif")
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PAGOS_PAGOID_GENERATOR", sequenceName="NIIF.SEQ_PAGO_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PAGOS_PAGOID_GENERATOR")
	@Column(name="pago_id")
	private long pagoId;

	@Column(name="pago_comprobante")
	private String pagoComprobante;

	@Column(name="pago_fecha")
	private String pagoFecha;

	@Column(name="pago_fechacambio")
	private String pagoFechacambio;

	@Column(name="pago_hora")
	private String pagoHora;

	@Column(name="pago_horacambio")
	private String pagoHoracambio;

	@Column(name="pago_observacion")
	private String pagoObservacion;

	@Column(name="pago_registradopor")
	private String pagoRegistradopor;

	@Column(name="pago_valor")
	private double pagoValor;

	//bi-directional many-to-one association to Formapago
	@ManyToOne
	@JoinColumn(name="fopa_id")
	private Formapago formapago;

	//bi-directional many-to-one association to Ordencompra
	@ManyToOne
	@JoinColumn(name="orco_id")
	private Ordencompra ordencompra;

	//bi-directional many-to-one association to Venta
	@ManyToOne
	@JoinColumn(name="vent_id")
	private Venta venta;

	@Transient
	private long formaPagoIdHelp;
	
	public Pago() {
	}

	public long getPagoId() {
		return this.pagoId;
	}

	public void setPagoId(long pagoId) {
		this.pagoId = pagoId;
	}

	public String getPagoComprobante() {
		return this.pagoComprobante;
	}

	public void setPagoComprobante(String pagoComprobante) {
		this.pagoComprobante = pagoComprobante;
	}

	public String getPagoFecha() {
		return this.pagoFecha;
	}

	public void setPagoFecha(String pagoFecha) {
		this.pagoFecha = pagoFecha;
	}

	public String getPagoFechacambio() {
		return this.pagoFechacambio;
	}

	public void setPagoFechacambio(String pagoFechacambio) {
		this.pagoFechacambio = pagoFechacambio;
	}

	public String getPagoHora() {
		return this.pagoHora;
	}

	public void setPagoHora(String pagoHora) {
		this.pagoHora = pagoHora;
	}

	public String getPagoHoracambio() {
		return this.pagoHoracambio;
	}

	public void setPagoHoracambio(String pagoHoracambio) {
		this.pagoHoracambio = pagoHoracambio;
	}

	public String getPagoObservacion() {
		return this.pagoObservacion;
	}

	public void setPagoObservacion(String pagoObservacion) {
		this.pagoObservacion = pagoObservacion;
	}

	public String getPagoRegistradopor() {
		return this.pagoRegistradopor;
	}

	public void setPagoRegistradopor(String pagoRegistradopor) {
		this.pagoRegistradopor = pagoRegistradopor;
	}

	public double getPagoValor() {
		return this.pagoValor;
	}

	public String getPagoValorView() {
		return ValidaString.formatToMoney(String.valueOf(pagoValor));
	}
	
	public void setPagoValor(double pagoValor) {
		this.pagoValor = pagoValor;
	}

	public Formapago getFormapago() {
		return this.formapago;
	}

	public void setFormapago(Formapago formapago) {
		this.formapago = formapago;
	}

	public Ordencompra getOrdencompra() {
		return this.ordencompra;
	}

	public void setOrdencompra(Ordencompra ordencompra) {
		this.ordencompra = ordencompra;
	}

	public Venta getVenta() {
		return this.venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.pagoRegistradopor=data.get(0);
			this.pagoFechacambio=data.get(1);
			this.pagoHoracambio=data.get(2);
		}
	}
	
	public void setFormaPagoId(long fopaId){
		if(this.formapago==null)
			this.formapago = new Formapago();
		this.formapago.setFopaId(fopaId);
	}

	public long getFormaPagoIdHelp() {
		return formaPagoIdHelp;
	}

	public void setFormaPagoIdHelp(long formaPagoIdHelp) {
		this.formaPagoIdHelp = formaPagoIdHelp;
	}
	
}