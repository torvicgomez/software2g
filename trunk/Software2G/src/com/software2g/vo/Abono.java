package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import com.software2g.util.ValidaString;


/**
 * The persistent class for the abono database table.
 * 
 */
@Entity
@Table(schema="CONTABLE", name="ABONO")
public class Abono implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ABONO_ABONID_GENERATOR", sequenceName="CONTABLE.S_ABON_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ABONO_ABONID_GENERATOR")
	@Column(name="abon_id")
	private long abonId;

	@Column(name="abon_fecha")
	private String abonFecha;

	@Column(name="abon_fechamodificacion")
	private String abonFechamodificacion;

	@Column(name="abon_hora")
	private String abonHora;

	@Column(name="abon_otrocargo")
	private double abonOtrocargo;
	
	@Transient
	private String abonOtrocargoView;

	@Column(name="abon_registradopor")
	private String abonRegistradopor;

	@Column(name="abon_valorcapital")
	private double abonValorcapital;
	
	@Transient
	private String abonValorcapitalView;

	@Column(name="abon_valorinteres")
	private double abonValorinteres;
	
	@Transient
	private String abonValorinteresView;

	@Column(name="abon_valorinteresmora")
	private double abonValorinteresmora;
	
	@Transient
	private String abonValorinteresmoraView;

	@Column(name="abon_valorseguro")
	private double abonValorseguro;
	
	@Transient
	private String abonValorseguroView;

	@Column(name="abon_valortotal")
	private double abonValortotal;
	
	@Transient
	private String abonValortotalView;
	
	@Transient
	private double valoraPagar;

	@Column(name="abon_nrocomprobante")
	private String abonNrocomprobante;
	
	@Column(name="abon_diasliq")
	private double diasLiquidados;
	
	@Column(name="abon_diamora") 
	private double diasMora;
	
	@Column(name="abon_valorcapitaladicional")
	private double abonValorcapitaladicional;
	
	@Transient
	private String abonValorcapitaladicionalView;
	
	//bi-directional many-to-one association to Credito    
	@ManyToOne
	@JoinColumn(name="cred_id")
	private Credito credito;

	@Column(name="abon_periodoliquidado")
	private String abonPeriodoliquidado;  
	
	@Column(name="abon_saldo")
	private double abonSaldo;  
	
	@Transient
	private String abonSaldoView;
	
	  
	public Abono() {
	}

	public long getAbonId() {
		return this.abonId;
	}

	public void setAbonId(long abonId) {
		this.abonId = abonId;
	}

	public String getAbonFecha() {
		return this.abonFecha;
	}

	public void setAbonFecha(String abonFecha) {
		this.abonFecha = abonFecha;
	}

	public String getAbonFechamodificacion() {
		return this.abonFechamodificacion;
	}

	public void setAbonFechamodificacion(String abonFechamodificacion) {
		this.abonFechamodificacion = abonFechamodificacion;
	}

	public String getAbonHora() {
		return this.abonHora;
	}

	public void setAbonHora(String abonHora) {
		this.abonHora = abonHora;
	}

	public double getAbonOtrocargo() {
		return this.abonOtrocargo;
	}

	public void setAbonOtrocargo(double abonOtrocargo) {
		this.abonOtrocargo = abonOtrocargo;
	}

	public String getAbonRegistradopor() {
		return this.abonRegistradopor;
	}

	public void setAbonRegistradopor(String abonRegistradopor) {
		this.abonRegistradopor = abonRegistradopor;
	}

	public double getAbonValorcapital() {
		return this.abonValorcapital;
	}

	public void setAbonValorcapital(double abonValorcapital) {
		this.abonValorcapital = abonValorcapital;
	}

	public double getAbonValorinteres() {
		return this.abonValorinteres;
	}

	public void setAbonValorinteres(double abonValorinteres) {
		this.abonValorinteres = abonValorinteres;
	}

	public double getAbonValorinteresmora() {
		return this.abonValorinteresmora;
	}

	public void setAbonValorinteresmora(double abonValorinteresmora) {
		this.abonValorinteresmora = abonValorinteresmora;
	}

	public double getAbonValorseguro() {
		return this.abonValorseguro;
	}

	public void setAbonValorseguro(double abonValorseguro) {
		this.abonValorseguro = abonValorseguro;
	}

	public double getAbonValortotal() {
		return this.abonValortotal;
	}

	public void setAbonValortotal(double abonValortotal) {
		this.abonValortotal = abonValortotal;
	}

	public Credito getCredito() {
		return this.credito;
	}

	public void setCredito(Credito credito) {
		this.credito = credito;
	}

	public String getAbonNrocomprobante() {
		return abonNrocomprobante;
	}

	public void setAbonNrocomprobante(String abonNrocomprobante) {
		this.abonNrocomprobante = abonNrocomprobante;
	}

	public String getAbonValorcapitalView() {
		abonValorcapitalView = ValidaString.formatToMoney(String.valueOf(abonValorcapital));
		return abonValorcapitalView;
	}

	public String getAbonValorinteresView() {
		abonValorinteresView = ValidaString.formatToMoney(String.valueOf(abonValorinteres));
		return abonValorinteresView;
	}

	public String getAbonValorinteresmoraView() {
		abonValorinteresmoraView = ValidaString.formatToMoney(String.valueOf(abonValorinteresmora));
		return abonValorinteresmoraView;
	}

	public String getAbonValorseguroView() {
		abonValorseguroView = ValidaString.formatToMoney(String.valueOf(abonValorseguro));
		return abonValorseguroView; 
	}

	public String getAbonValortotalView() {
		abonValortotalView = ValidaString.formatToMoney(String.valueOf(abonValortotal));
		return abonValortotalView;
	}

	public String getAbonOtrocargoView() {
		abonOtrocargoView = ValidaString.formatToMoney(String.valueOf(abonOtrocargo));
		return abonOtrocargoView;
	}

	public double getDiasLiquidados() {
		return diasLiquidados;
	}

	public void setDiasLiquidados(double diasLiquidados) {
		this.diasLiquidados = diasLiquidados;
	}

	public double getDiasMora() {
		return diasMora;
	}

	public void setDiasMora(double diasMora) {
		this.diasMora = diasMora;
	}

	public double getAbonValorcapitaladicional() {
		return abonValorcapitaladicional;
	}

	public void setAbonValorcapitaladicional(double abonValorcapitaladicional) {
		this.abonValorcapitaladicional = abonValorcapitaladicional;
	}

	public double getValoraPagar() {
		return valoraPagar;
	}

	public void setValoraPagar(double valoraPagar) {
		this.valoraPagar = valoraPagar;
	}

	public String getAbonValorcapitaladicionalView() {
		abonValorcapitaladicionalView = ValidaString.formatToMoney(String.valueOf(abonValorcapitaladicional));
		return abonValorcapitaladicionalView;
	}

	public String getAbonPeriodoliquidado() {
		return abonPeriodoliquidado;
	}

	public void setAbonPeriodoliquidado(String abonPeriodoliquidado) {
		this.abonPeriodoliquidado = abonPeriodoliquidado;
	}

	public double getAbonSaldo() {
		return abonSaldo;
		
	}

	public void setAbonSaldo(double abonSaldo) {
		this.abonSaldo = abonSaldo;
	}

	public String getAbonSaldoView() {
		abonSaldoView = ValidaString.formatToMoney(String.valueOf(abonSaldo));
		return abonSaldoView;
	}

	public String getAbonFechaUltimoPago() {
		return this.abonPeriodoliquidado.split("/")[0];
	}
	
	public String getAbonFechaCorteAbono() {
		return this.abonPeriodoliquidado.split("/")[1];
	}
	
	public String getAbonSaldoFechaCorteView(){
		return ValidaString.formatToMoney(String.valueOf(ValidaString.operacionMathAproximacion(abonSaldo, ValidaString.operacionMathAproximacion(abonValorcapital,abonValorcapitaladicional,1), 2)));
	}
}