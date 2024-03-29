package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import com.software2g.util.ConstantesAplicativo;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	@SequenceGenerator(name="PERSONA_IDPERS_GENERATOR", sequenceName="PORTAL.SEQ_PERSONA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONA_IDPERS_GENERATOR")
	@Column(name="id_pers")
	private long idPers;

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

	@Column(name="direccion_pers")
	private String direccionPers;

	@Column(name="telefono_pers")
	private String telefonoPers;
	
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
	
	
	@ManyToOne
	@JoinColumn(name="id_mcpo")
	private Municipio municipio;
	
	//bi-directional many-to-one association to Profesional
	@OneToMany(mappedBy="persona")
	private List<Profesional> profesional;
	
	//bi-directional many-to-one association to Acudiente Servicio
	@OneToMany(mappedBy="persona")
	private List<Acudiente> acudiente;
	
	//bi-directional many-to-one association to Paciente
	@OneToMany(mappedBy="persona")
	private List<Paciente> paciente;
		
	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="persona")
	private List<Cliente> cliente;
	
	//bi-directional many-to-one association to Proveedor
	@OneToMany(mappedBy="persona")
	private List<Proveedor> proveedor;
	
	//bi-directional many-to-one association to Vendedor
	@OneToMany(mappedBy="persona")
	private List<Vendedor> vendedor;
		
	@Transient
	private String existePaciente; 
	
	@Transient
	private String existeCliente;
	
	public Persona() {
	}

	public long getIdPers() {
		return this.idPers;
	}

	public void setIdPers(long idPers) {
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
		return this.pnombrePers.toUpperCase()+" "+this.snombrePers.toUpperCase()+" "+this.papellidoPers.toUpperCase()+" "+this.sapellidoPers.toUpperCase();
	}

	public List<Pagare> getPagares() {
		return pagares;
	}

	public void setPagares(List<Pagare> pagares) {
		this.pagares = pagares;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getDireccionPers() {
		return direccionPers;
	}

	public void setDireccionPers(String direccionPers) {
		this.direccionPers = direccionPers;
	}

	public String getTelefonoPers() {
		return telefonoPers;
	}

	public void setTelefonoPers(String telefonoPers) {
		this.telefonoPers = telefonoPers;
	}

	public String getUbicacionPersona(){
		if(this.municipio!=null&&this.municipio.getDepartamento()!=null&&this.municipio.getDepartamento().getPais()!=null)
			return this.municipio.getDepartamento().getPais().getNompais().toUpperCase()+"-"+this.municipio.getDepartamento().getNomdpto().toUpperCase()+"-"+this.municipio.getNommunicipio().toUpperCase();
		else
			return "-";
	}

	public List<Profesional> getProfesional() {
		return profesional;
	}

	public void setProfesional(List<Profesional> profesional) {
		this.profesional = profesional;
	}

	public String getNroHistoriaClinica(){
		return this.idPers+"-"+this.documentoPers;
	}
	
	public String getEdad()
    {
		SimpleDateFormat sdf = new SimpleDateFormat(ConstantesAplicativo.constanteFormatoFecha1);
		Date date = new Date();
        String fechaSystem = sdf.format(date);
        int edad_ano = 0;
        int edad_mes = 0;
        edad_ano = Integer.parseInt(fechaSystem.substring(6, 10)) - Integer.parseInt(this.fechanacimientoPers.substring(0, 4));
        edad_mes = Integer.parseInt(fechaSystem.substring(3, 5)) - Integer.parseInt(this.fechanacimientoPers.substring(5, 7));
        if(edad_mes < 0){
            edad_mes += 12;
            if(--edad_ano < 0)
                return "Fecha de Nacimiento Incorrecta";
            else//\321
                return edad_ano+" A�OS "+edad_mes+" MESES";
        }else
            return edad_ano+" A�OS "+edad_mes+" MESES";
    }

	public String getExistePaciente() {
		return existePaciente;
	}

	public void setExistePaciente(String existePaciente) {
		this.existePaciente = existePaciente;
	}

	public List<Acudiente> getAcudiente() {
		return acudiente;
	}

	public void setAcudiente(List<Acudiente> acudiente) {
		this.acudiente = acudiente;
	}

	public List<Paciente> getPaciente() {
		return paciente;
	}

	public void setPaciente(List<Paciente> paciente) {
		this.paciente = paciente;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.registradopor=data.get(0);
			this.fechacambio=data.get(1);
			this.horacambio=data.get(2);
		}
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

	public List<Proveedor> getProveedor() {
		return proveedor;
	}

	public void setProveedor(List<Proveedor> proveedor) {
		this.proveedor = proveedor;
	}

	public List<Vendedor> getVendedor() {
		return vendedor;
	}

	public void setVendedor(List<Vendedor> vendedor) {
		this.vendedor = vendedor;
	}

	public String getExisteCliente() {
		return existeCliente;
	}

	public void setExisteCliente(String existeCliente) {
		this.existeCliente = existeCliente;
	}

}