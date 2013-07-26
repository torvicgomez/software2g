package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import com.software2g.util.ValidaString;

import java.util.List;


/**
 * The persistent class for the pagare database table.
 * 
 */
@Entity
@Table(schema="CONTABLE", name="PAGARE")
public class Pagare implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PAGARE_PAGAID_GENERATOR", sequenceName="CONTABLE.S_PAGA_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PAGARE_PAGAID_GENERATOR")
	@Column(name="paga_id")
	private long pagaId;

	@Column(name="paga_codeudor")
	private String pagaCodeudor;

	@Column(name="paga_estado")
	private String pagaEstado;

	@Transient
	private String pagaEstadoView;
	
	@Column(name="paga_fechacreapagare")
	private String pagaFechacreapagare;

	@Column(name="paga_fechamodificacion")
	private String pagaFechamodificacion;

	@Column(name="paga_hora")
	private String pagaHora;

	@Column(name="paga_registradopor")
	private String pagaRegistradopor;
	
	@Column(name="paga_dircodeudor")
	private String pagaDircodeudor;
	
	@Column(name="paga_telcodeudor")
	private String pagaTelcodeudor;

	@Column(name="paga_monto")
	private String pagaMonto;
	
	@Transient 
	private String pagaMontoView;
	
	@Column(name="paga_fechapago")
	private String pagaFechapago;
	
	@Transient
	private String findDeudor;
	@Transient
	private String isAnulable;
	
	//bi-directional many-to-one association to Credito
	@OneToMany(mappedBy="pagare")
	private List<Credito> creditos;

	//bi-directional many-to-one association to Tipopagare
	@ManyToOne
	@JoinColumn(name="tipa_id")
	private Tipopagare tipopagare;

	
	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_pers")
	private Persona persona;
	
	public Pagare() {
	}

	public long getPagaId() {
		return this.pagaId;
	}

	public void setPagaId(long pagaId) {
		this.pagaId = pagaId;
	}

	public String getPagaCodeudor() {
		return this.pagaCodeudor;
	}

	public void setPagaCodeudor(String pagaCodeudor) {
		this.pagaCodeudor = pagaCodeudor;
	}

	public String getPagaEstado() {
		return this.pagaEstado;
	}

	public void setPagaEstado(String pagaEstado) {
		this.pagaEstado = pagaEstado;
	}

	public String getPagaFechacreapagare() {
		return this.pagaFechacreapagare;
	}

	public void setPagaFechacreapagare(String pagaFechacreapagare) {
		this.pagaFechacreapagare = pagaFechacreapagare;
	}

	public String getPagaFechamodificacion() {
		return this.pagaFechamodificacion;
	}

	public void setPagaFechamodificacion(String pagaFechamodificacion) {
		this.pagaFechamodificacion = pagaFechamodificacion;
	}

	public String getPagaHora() {
		return this.pagaHora;
	}

	public void setPagaHora(String pagaHora) {
		this.pagaHora = pagaHora;
	}

	public String getPagaRegistradopor() {
		return this.pagaRegistradopor;
	}

	public void setPagaRegistradopor(String pagaRegistradopor) {
		this.pagaRegistradopor = pagaRegistradopor;
	}

	public List<Credito> getCreditos() {
		return this.creditos;
	}

	public void setCreditos(List<Credito> creditos) {
		this.creditos = creditos;
	}

	
	public Credito addCreditos(Credito creditos) {
		getCreditos().add(creditos);
		creditos.setPagare(this);

		return creditos;
	}

	public Credito removeCreditos(Credito creditos) {
		getCreditos().remove(creditos);
		creditos.setPagare(null);

		return creditos;
	}
	public Tipopagare getTipopagare() {
		return this.tipopagare;
	}

	public void setTipopagare(Tipopagare tipopagare) {
		this.tipopagare = tipopagare;
	}

	public String getPagaDircodeudor() {
		return pagaDircodeudor;
	}

	public void setPagaDircodeudor(String pagaDircodeudor) {
		this.pagaDircodeudor = pagaDircodeudor;
	}

	public String getPagaTelcodeudor() {
		return pagaTelcodeudor;
	}

	public void setPagaTelcodeudor(String pagaTelcodeudor) {
		this.pagaTelcodeudor = pagaTelcodeudor;
	}

	public String getPagaMonto() {
		return pagaMonto;
	}

	public void setPagaMonto(String pagaMonto) {
		this.pagaMonto = pagaMonto;
	}

	public String getPagaFechapago() {
		return pagaFechapago;
	}

	public void setPagaFechapago(String pagaFechapago) {
		this.pagaFechapago = pagaFechapago;
	}

	public String getFindDeudor() {
		return findDeudor;
	}

	public void setFindDeudor(String findDeudor) {
		this.findDeudor = findDeudor;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getPagaMontoView() {
		return ValidaString.formatToMoney(pagaMonto);
	}

	public String getIsAnulable() {
		return isAnulable;
	}

	public void setIsAnulable(String isAnulable) {
		this.isAnulable = isAnulable;
	}

	public String getPagaEstadoView() {
		if(this.pagaEstado!=null){
			if(this.pagaEstado.equals("1"))
				pagaEstadoView = "ACTIVO";
			else if(this.pagaEstado.equals("0"))
				pagaEstadoView = "INACTIVO";
			else if(this.pagaEstado.equals("2"))
				pagaEstadoView = "ANULAR";
		}else
			pagaEstadoView = "ACTIVO";
		return pagaEstadoView;
	}

	
}