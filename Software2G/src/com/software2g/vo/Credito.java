package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import com.software2g.util.ValidaString;

import java.util.List;


/**
 * The persistent class for the credito database table.
 * 
 */
@Entity
@Table(schema="CONTABLE", name="CREDITO")
public class Credito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CREDITO_CREDID_GENERATOR", sequenceName="CONTABLE.S_CRED_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CREDITO_CREDID_GENERATOR")
	@Column(name="cred_id")
	private long credId;

	@Column(name="cred_fechainiciacredito")
	private String credFechainiciacredito;

	@Column(name="cred_fechamodificacion")
	private String credFechamodificacion;

	@Column(name="cred_hora")
	private String credHora;

	@Column(name="cred_interes")
	private double credInteres;

	@Column(name="cred_interesmora")
	private double credInteresmora;

	@Column(name="cred_montocredito")
	private double credMontocredito;

	@Column(name="cred_otroscargos")
	private double credOtroscargos;

	@Column(name="cred_registradopor")
	private String credRegistradopor;

	@Column(name="cred_saldo")
	private double credSaldo;
	
	@Transient
	private String credSaldoView;
	
	@Transient
	private String credMontocreditoView;

	@Column(name="cred_valorseguro")
	private double credValorseguro;
	
	@Column(name="cred_estado")
	private String credEstado;
	
	@Column(name="cred_nrocheque")
	private String credNrocheque;
	
	@Column(name="cred_fechaultimopago")
	private String credFechaultimopago;
	
	@Transient
	private String findPagare;
	
	@Transient
	private String fechaALiquidar;

	//bi-directional many-to-one association to Abono
	@OneToMany(mappedBy="credito")
	private List<Abono> abonos;

	//bi-directional many-to-one association to Pagare
	@ManyToOne
	@JoinColumn(name="paga_id")
	private Pagare pagare;

	//bi-directional many-to-one association to Presupuesto
	@ManyToOne
	@JoinColumn(name="pres_id")
	private Presupuesto presupuesto;

	//bi-directional many-to-one association to Tipocredito
	@ManyToOne
	@JoinColumn(name="ticr_id")
	private Tipocredito tipocredito;

	//bi-directional many-to-one association to Creditotipodescuento
	@OneToMany(mappedBy="credito")
	private List<Creditotipodescuento> creditotipodescuentos;

	public Credito() {
	}


	public String getCredFechainiciacredito() {
		return this.credFechainiciacredito;
	}

	public void setCredFechainiciacredito(String credFechainiciacredito) {
		this.credFechainiciacredito = credFechainiciacredito;
	}

	public String getCredFechamodificacion() {
		return this.credFechamodificacion;
	}

	public void setCredFechamodificacion(String credFechamodificacion) {
		this.credFechamodificacion = credFechamodificacion;
	}

	public String getCredHora() {
		return this.credHora;
	}

	public void setCredHora(String credHora) {
		this.credHora = credHora;
	}

	public double getCredInteres() {
		return this.credInteres;
	}

	public void setCredInteres(double credInteres) {
		this.credInteres = credInteres;
	}

	public double getCredInteresmora() {
		return this.credInteresmora;
	}

	public void setCredInteresmora(double credInteresmora) {
		this.credInteresmora = credInteresmora;
	}

	public double getCredMontocredito() {
		return this.credMontocredito;
	}

	public void setCredMontocredito(double credMontocredito) {
		this.credMontocredito = credMontocredito;
	}

	public double getCredOtroscargos() {
		return this.credOtroscargos;
	}

	public void setCredOtroscargos(double credOtroscargos) {
		this.credOtroscargos = credOtroscargos;
	}

	public String getCredRegistradopor() {
		return this.credRegistradopor;
	}

	public void setCredRegistradopor(String credRegistradopor) {
		this.credRegistradopor = credRegistradopor;
	}

	public double getCredSaldo() {
		return this.credSaldo;
	}

	public void setCredSaldo(double credSaldo) {
		this.credSaldo = credSaldo;
	}

	public double getCredValorseguro() {
		return this.credValorseguro;
	}

	public void setCredValorseguro(double credValorseguro) {
		this.credValorseguro = credValorseguro;
	}

	public List<Abono> getAbonos() {
		return this.abonos;
	}

	public void setAbonos(List<Abono> abonos) {
		this.abonos = abonos;
	}

	
	public Abono addAbonos(Abono abonos) {
		getAbonos().add(abonos);
		abonos.setCredito(this);

		return abonos;
	}

	public Abono removeAbonos(Abono abonos) {
		getAbonos().remove(abonos);
		abonos.setCredito(null);

		return abonos;
	}
	public Pagare getPagare() {
		return this.pagare;
	}

	public void setPagare(Pagare pagare) {
		this.pagare = pagare;
	}

	
	public Presupuesto getPresupuesto() {
		return this.presupuesto;
	}

	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}

	
	public Tipocredito getTipocredito() {
		return this.tipocredito;
	}

	public void setTipocredito(Tipocredito tipocredito) {
		this.tipocredito = tipocredito;
	}

	
	public List<Creditotipodescuento> getCreditotipodescuentos() {
		return this.creditotipodescuentos;
	}

	public void setCreditotipodescuentos(List<Creditotipodescuento> creditotipodescuentos) {
		this.creditotipodescuentos = creditotipodescuentos;
	}

	
	public Creditotipodescuento addCreditotipodescuentos(Creditotipodescuento creditotipodescuentos) {
		getCreditotipodescuentos().add(creditotipodescuentos);
		creditotipodescuentos.setCredito(this);

		return creditotipodescuentos;
	}

	public Creditotipodescuento removeCreditotipodescuentos(Creditotipodescuento creditotipodescuentos) {
		getCreditotipodescuentos().remove(creditotipodescuentos);
		creditotipodescuentos.setCredito(null);

		return creditotipodescuentos;
	}


	public long getCredId() {
		return credId;
	}


	public void setCredId(long credId) {
		this.credId = credId;
	}


	public String getCredEstado() {
		return credEstado;
	}


	public void setCredEstado(String credEstado) {
		this.credEstado = credEstado;
	}


	public String getCredSaldoView() {
		return ValidaString.formatToMoney(String.valueOf(credSaldo));
	}


	public String getCredMontocreditoView() {
		return ValidaString.formatToMoney(String.valueOf(credMontocredito));
	}


	public String getFindPagare() {
		return findPagare;
	}


	public void setFindPagare(String findPagare) {
		this.findPagare = findPagare;
	}


	public String getCredNrocheque() {
		return credNrocheque;
	}


	public void setCredNrocheque(String credNrocheque) {
		this.credNrocheque = credNrocheque;
	}


	public String getCredFechaultimopago() {
		return credFechaultimopago;
	}


	public void setCredFechaultimopago(String credFechaultimopago) {
		this.credFechaultimopago = credFechaultimopago;
	}


	public String getFechaALiquidar() {
		return fechaALiquidar;
	}


	public void setFechaALiquidar(String fechaALiquidar) {
		this.fechaALiquidar = fechaALiquidar;
	}

}