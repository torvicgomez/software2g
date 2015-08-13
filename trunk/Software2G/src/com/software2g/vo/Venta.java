package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import com.software2g.util.ValidaString;

import java.util.List;


/**
 * The persistent class for the venta database table.
 * 
 */
@Entity
@Table(name="venta", schema="niif")
public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VENTA_VENTID_GENERATOR", sequenceName="NIIF.SEQ_VENT_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VENTA_VENTID_GENERATOR")
	@Column(name="vent_id")
	private long ventId;

	@Column(name="vent_consecutivo")
	private String ventConsecutivo;

	@Column(name="vent_estado")
	private String ventEstado;

	@Column(name="vent_fecha")
	private String ventFecha;

	@Column(name="vent_fechacambio")
	private String ventFechacambio;

	@Column(name="vent_hora")
	private String ventHora;

	@Column(name="vent_horacambio")
	private String ventHoracambio;

	@Column(name="vent_registradopor")
	private String ventRegistradopor;

	@Column(name="vent_total")
	private double ventTotal;

	@Column(name="vent_totaldes")
	private double ventTotaldes;

	@Column(name="vent_totaliva")
	private double ventTotaliva;

	@Column(name="vent_totalpag")
	private double ventTotalpag;

	//bi-directional many-to-one association to Detalleventa
	@OneToMany(mappedBy="venta")
	private List<Detalleventa> detalleventas;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="venta")
	private List<Pago> pagos;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="clie_id")
	private Cliente cliente;

	//bi-directional many-to-one association to Condicionpago
	@ManyToOne
	@JoinColumn(name="copa_id")
	private Condicionpago condicionpago;

	//bi-directional many-to-one association to Vendedor
	@ManyToOne
	@JoinColumn(name="vend_id")
	private Vendedor vendedor;

	public Venta() {
	}

	public long getVentId() {
		return this.ventId;
	}

	public void setVentId(long ventId) {
		this.ventId = ventId;
	}

	public String getVentConsecutivo() {
		return this.ventConsecutivo;
	}

	public void setVentConsecutivo(String ventConsecutivo) {
		this.ventConsecutivo = ventConsecutivo;
	}

	public String getVentEstado() {
		return this.ventEstado;
	}

	public void setVentEstado(String ventEstado) {
		this.ventEstado = ventEstado;
	}

	public String getVentFecha() {
		return this.ventFecha;
	}

	public void setVentFecha(String ventFecha) {
		this.ventFecha = ventFecha;
	}

	public String getVentFechacambio() {
		return this.ventFechacambio;
	}

	public void setVentFechacambio(String ventFechacambio) {
		this.ventFechacambio = ventFechacambio;
	}

	public String getVentHora() {
		return this.ventHora;
	}

	public void setVentHora(String ventHora) {
		this.ventHora = ventHora;
	}

	public String getVentHoracambio() {
		return this.ventHoracambio;
	}

	public void setVentHoracambio(String ventHoracambio) {
		this.ventHoracambio = ventHoracambio;
	}

	public String getVentRegistradopor() {
		return this.ventRegistradopor;
	}

	public void setVentRegistradopor(String ventRegistradopor) {
		this.ventRegistradopor = ventRegistradopor;
	}

	public double getVentTotal() {
		return this.ventTotal;
	}

	public String getVentTotalView() {
		return ValidaString.formatToMoney(String.valueOf(ventTotal));
	}
	
	public void setVentTotal(double ventTotal) {
		this.ventTotal = ventTotal;
	}

	public double getVentTotaldes() {
		return this.ventTotaldes;
	}

	public String getVentTotaldesView() {
		return ValidaString.formatToMoney(String.valueOf(ventTotaldes));
	}
	
	public void setVentTotaldes(double ventTotaldes) {
		this.ventTotaldes = ventTotaldes;
	}

	public double getVentTotaliva() {
		return this.ventTotaliva;
	}

	public String getVentTotalivaView() {
		return ValidaString.formatToMoney(String.valueOf(ventTotaliva));
	}
	
	public void setVentTotaliva(double ventTotaliva) {
		this.ventTotaliva = ventTotaliva;
	}

	public double getVentTotalpag() {
		return this.ventTotalpag;
	}

	public String getVentTotalpagView() {
		return ValidaString.formatToMoney(String.valueOf(ventTotalpag));
	}
	
	public void setVentTotalpag(double ventTotalpag) {
		this.ventTotalpag = ventTotalpag;
	}

	public List<Detalleventa> getDetalleventas() {
		return this.detalleventas;
	}

	public void setDetalleventas(List<Detalleventa> detalleventas) {
		this.detalleventas = detalleventas;
	}

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Condicionpago getCondicionpago() {
		return this.condicionpago;
	}

	public void setCondicionpago(Condicionpago condicionpago) {
		this.condicionpago = condicionpago;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.ventRegistradopor=data.get(0);
			this.ventFechacambio=data.get(1);
			this.ventHoracambio=data.get(2);
		}
	}
}