package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@Table(schema="portal",name="persona")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERSONA_IDPERS_GENERATOR", sequenceName="PORTAL.SEQ_PERSONA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONA_IDPERS_GENERATOR")
	@Column(name="id_pers")
	private Integer idPers;

	@Column(name="documento_pers")
	private String documentoPers;

	@Column(name="email_pers")
	private String emailPers;

	@Column(name="estadocivil_pers")
	private String estadocivilPers;

	private String fechacambio;

	@Column(name="fechaexpdoc_pers")
	private String fechaexpdocPers;

	@Column(name="fechanacimiento_pers")
	private String fechanacimientoPers;

	private String horacambio;

	@Column(name="papellido_pers")
	private String papellidoPers;

	@Column(name="pnombre_pers")
	private String pnombrePers;

	private String registradopor;

	@Column(name="sapellido_pers")
	private String sapellidoPers;

	@Column(name="sexo_pers")
	private String sexoPers;

	@Column(name="snombre_pers")
	private String snombrePers;

	//bi-directional many-to-one association to Tipodocumento
	@ManyToOne
	@JoinColumn(name="id_tidoc")
	private Tipodocumento tipodocumento;

	//bi-directional many-to-one association to Personainstitucion
	@OneToMany(mappedBy="persona")
	private List<Personainstitucion> personainstitucions;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="persona")
	private List<Usuario> usuarios;

	//bi-directional many-to-one association to Pagare
	@OneToMany(mappedBy="persona")
	private List<Pagare> pagares;
	
	public Persona() {
	}

	public Integer getIdPers() {
		return this.idPers;
	}

	public void setIdPers(Integer idPers) {
		this.idPers = idPers;
	}

	public String getDocumentoPers() {
		return this.documentoPers;
	}

	public void setDocumentoPers(String documentoPers) {
		this.documentoPers = documentoPers;
	}

	public String getEmailPers() {
		return this.emailPers;
	}

	public void setEmailPers(String emailPers) {
		this.emailPers = emailPers;
	}

	public String getEstadocivilPers() {
		return this.estadocivilPers;
	}

	public void setEstadocivilPers(String estadocivilPers) {
		this.estadocivilPers = estadocivilPers;
	}

	public String getFechacambio() {
		return this.fechacambio;
	}

	public void setFechacambio(String fechacambio) {
		this.fechacambio = fechacambio;
	}

	public String getFechaexpdocPers() {
		return this.fechaexpdocPers;
	}

	public void setFechaexpdocPers(String fechaexpdocPers) {
		this.fechaexpdocPers = fechaexpdocPers;
	}

	public String getFechanacimientoPers() {
		return this.fechanacimientoPers;
	}

	public void setFechanacimientoPers(String fechanacimientoPers) {
		this.fechanacimientoPers = fechanacimientoPers;
	}

	public String getHoracambio() {
		return this.horacambio;
	}

	public void setHoracambio(String horacambio) {
		this.horacambio = horacambio;
	}

	public String getPapellidoPers() {
		return this.papellidoPers;
	}

	public void setPapellidoPers(String papellidoPers) {
		this.papellidoPers = papellidoPers;
	}

	public String getPnombrePers() {
		return this.pnombrePers;
	}

	public void setPnombrePers(String pnombrePers) {
		this.pnombrePers = pnombrePers;
	}

	public String getRegistradopor() {
		return this.registradopor;
	}

	public void setRegistradopor(String registradopor) {
		this.registradopor = registradopor;
	}

	public String getSapellidoPers() {
		return this.sapellidoPers;
	}

	public void setSapellidoPers(String sapellidoPers) {
		this.sapellidoPers = sapellidoPers;
	}

	public String getSexoPers() {
		return this.sexoPers;
	}

	public void setSexoPers(String sexoPers) {
		this.sexoPers = sexoPers;
	}

	public String getSnombrePers() {
		return this.snombrePers;
	}

	public void setSnombrePers(String snombrePers) {
		this.snombrePers = snombrePers;
	}

	public Tipodocumento getTipodocumento() {
		return this.tipodocumento;
	}

	public void setTipodocumento(Tipodocumento tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public List<Personainstitucion> getPersonainstitucions() {
		return this.personainstitucions;
	}

	public void setPersonainstitucions(List<Personainstitucion> personainstitucions) {
		this.personainstitucions = personainstitucions;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public String getNombreCompleto(){
		return this.pnombrePers+" "+this.snombrePers+" "+this.papellidoPers+" "+this.sapellidoPers;
	}

	public List<Pagare> getPagares() {
		return pagares;
	}

	public void setPagares(List<Pagare> pagares) {
		this.pagares = pagares;
	}

}