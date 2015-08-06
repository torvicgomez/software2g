package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import com.software2g.util.ValidaString;

import java.util.List;


/**
 * The persistent class for the ordencompra database table.
 * 
 */
@Entity
@Table(name="ordencompra", schema="niif")
public class Ordencompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ORDENCOMPRA_ORCOID_GENERATOR", sequenceName="NIIF.SEQ_ORCO_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORDENCOMPRA_ORCOID_GENERATOR")
	@Column(name="orco_id")
	private long orcoId;

	@Column(name="orco_estado")
	private String orcoEstado;

	@Column(name="orco_fechacambio")
	private String orcoFechacambio;

	@Column(name="orco_fechacompra")
	private String orcoFechacompra;

	@Column(name="orco_fechavence")
	private String orcoFechavence;
	
	@Column(name="orco_horacambio")
	private String orcoHoracambio;

	@Column(name="orco_nrocomprobante")
	private String orcoNrocomprobante;

	@Column(name="orco_registradopor")
	private String orcoRegistradopor;

	@Column(name="orco_totaldescuento")
	private double orcoTotaldescuento;

	@Column(name="orco_totalivaven")
	private double orcoTotalivaven;

	@Column(name="orco_totalpagado")
	private double orcoTotalpagado;

	@Column(name="orco_totalcompra")
	private double orcoTotalcompra;
	
	@Column(name="orco_totalapagar")
	private double orcoTotalapagar;
	
	//bi-directional many-to-one association to Detallecompra
	@OneToMany(mappedBy="ordencompra")
	private List<Detallecompra> detallecompras;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne
	@JoinColumn(name="prov_id")
	private Proveedor proveedor;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="ordencompra")
	private List<Pago> pagos;

	public Ordencompra() {
	}

	public long getOrcoId() {
		return this.orcoId;
	}

	public void setOrcoId(long orcoId) {
		this.orcoId = orcoId;
	}

	public String getOrcoEstado() {
		return this.orcoEstado;
	}

	public void setOrcoEstado(String orcoEstado) {
		this.orcoEstado = orcoEstado;
	}

	public String getOrcoFechacambio() {
		return this.orcoFechacambio;
	}

	public void setOrcoFechacambio(String orcoFechacambio) {
		this.orcoFechacambio = orcoFechacambio;
	}

	public String getOrcoFechacompra() {
		return this.orcoFechacompra;
	}

	public void setOrcoFechacompra(String orcoFechacompra) {
		this.orcoFechacompra = orcoFechacompra;
	}

	public String getOrcoHoracambio() {
		return this.orcoHoracambio;
	}

	public void setOrcoHoracambio(String orcoHoracambio) {
		this.orcoHoracambio = orcoHoracambio;
	}

	public String getOrcoNrocomprobante() {
		return this.orcoNrocomprobante;
	}

	public void setOrcoNrocomprobante(String orcoNrocomprobante) {
		this.orcoNrocomprobante = orcoNrocomprobante;
	}

	public String getOrcoRegistradopor() {
		return this.orcoRegistradopor;
	}

	public void setOrcoRegistradopor(String orcoRegistradopor) {
		this.orcoRegistradopor = orcoRegistradopor;
	}

	public double getOrcoTotaldescuento() {
		return this.orcoTotaldescuento;
	}

	public String getOrcoTotaldescuentoView() {
		return ValidaString.formatToMoney(String.valueOf(orcoTotaldescuento));
	}
	
	public void setOrcoTotaldescuento(double orcoTotaldescuento) {
		this.orcoTotaldescuento = orcoTotaldescuento;
	}

	public double getOrcoTotalivaven() {
		return this.orcoTotalivaven;
	}

	public String getOrcoTotalivavenView() {
		return ValidaString.formatToMoney(String.valueOf(orcoTotalivaven));
	}
	
	public void setOrcoTotalivaven(double orcoTotalivaven) {
		this.orcoTotalivaven = orcoTotalivaven;
	}

	public double getOrcoTotalpagado() {
		return this.orcoTotalpagado;
	}

	public String getOrcoTotalpagadoView() {
		return ValidaString.formatToMoney(String.valueOf(orcoTotalpagado));
	}
	
	public void setOrcoTotalpagado(double orcoTotalpagado) {
		this.orcoTotalpagado = orcoTotalpagado;
	}

	public List<Detallecompra> getDetallecompras() {
		return this.detallecompras;
	}

	public void setDetallecompras(List<Detallecompra> detallecompras) {
		this.detallecompras = detallecompras;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.orcoRegistradopor=data.get(0);
			this.orcoFechacambio=data.get(1);
			this.orcoHoracambio=data.get(2);
		}
	}

	public double getOrcoTotalcompra() {
		return orcoTotalcompra;
	}

	public String getOrcoTotalcompraView() {
		return ValidaString.formatToMoney(String.valueOf(orcoTotalcompra));
	}
	
	public void setOrcoTotalcompra(double orcoTotalcompra) {
		this.orcoTotalcompra = orcoTotalcompra;
	}

	public double getOrcoTotalapagar() {
		return orcoTotalapagar;
	}

	public String getOrcoTotalapagarView() {
		return ValidaString.formatToMoney(String.valueOf(orcoTotalapagar));
	}
	
	public void setOrcoTotalapagar(double orcoTotalapagar) {
		this.orcoTotalapagar = orcoTotalapagar;
	}

	public String getOrcoFechavence() {
		return orcoFechavence;
	}

	public void setOrcoFechavence(String orcoFechavence) {
		this.orcoFechavence = orcoFechavence;
	}

	public String getOrcoSaldoView(){
		return ValidaString.formatToMoney(String.valueOf(this.orcoTotalapagar-this.orcoTotalpagado));
	}
}