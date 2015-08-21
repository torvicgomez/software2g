package com.software2g.niif.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.software2g.vo.Archivotabla;
import com.software2g.niif.dao.impl.PagosDAOImpl;
import com.software2g.niif.facade.IGestionFacadeNIIF;
import com.software2g.util.ConstantesAplicativo;
import com.software2g.util.ValidaString;
import com.software2g.vo.Articulo;
import com.software2g.vo.Categoria;
import com.software2g.vo.Cliente;
import com.software2g.vo.Consecutivo;
import com.software2g.vo.Detallecompra;
import com.software2g.vo.DetallecompraPK;
import com.software2g.vo.Detalleventa;
import com.software2g.vo.DetalleventaPK;
import com.software2g.vo.Ordencompra;
import com.software2g.vo.Portafolio;
import com.software2g.vo.Portafoliocategoria;
import com.software2g.vo.Pago;
import com.software2g.vo.Persona;
import com.software2g.vo.Tipodocumento;
import com.software2g.vo.Usuario;
import com.software2g.vo.UtilGenerico;
import com.software2g.vo.Condicionpago;
import com.software2g.vo.Formapago;
import com.software2g.vo.Vendedor;
import com.software2g.vo.Venta;

public class niifAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private IGestionFacadeNIIF gestionFacadeNIIF;
	private String estado;
	private String funcPosicionado;
	private String bandEstadoFunc;
	private String id;
	
	
	private Categoria categoria;
	private List<Categoria> listCategoria;
	private Articulo articulo;
	private List<Articulo> listArticulo;
	private Ordencompra ordenCompra;
	private List<Ordencompra> listOrdenCompra;
	private Condicionpago condicionpago;
	private List<Condicionpago> listCondicionpago;
	private Formapago formapago;
	private List<Formapago> listFormapago;
	
	private List<Detallecompra> listDetalleCompra;
	private Detallecompra detalleCompra;
	private InputStream strDatosArticulo;
	private InputStream strDatosDetalleCompra;
	private List<Tipodocumento> listTipoDoc;
	private Persona persona;
	private Cliente cliente;
	private List<Detalleventa> listDetalleVenta;
	private Detalleventa detalleVenta;
	private Venta venta;
	private List<Venta> listVenta;
	private Pago pago;
	private List<Pago> listPago;
	private Consecutivo consecutivo;
	private List<Consecutivo> listConsecutivo;
	private Vendedor vendedor;
	private List<Pago> listAbono;
	private Portafolio portafolio;
	private List<Portafolio> listPortafolio;
	private Archivotabla archivotabla;
	private List<Archivotabla> listArchivotabla;
	private Portafoliocategoria portafoliocategoria;
	private List<Portafoliocategoria> listPortafoliocategoria;
	
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	
	
	
	public List<Archivotabla> getListArchivotabla() {return listArchivotabla;}
	public void setListArchivotabla(List<Archivotabla> listArchivotabla) {this.listArchivotabla = listArchivotabla;}
	public List<Portafoliocategoria> getListPortafoliocategoria() {return listPortafoliocategoria;}
	public void setListPortafoliocategoria(List<Portafoliocategoria> listPortafoliocategoria) {this.listPortafoliocategoria = listPortafoliocategoria;}
	public Portafoliocategoria getPortafoliocategoria() {return portafoliocategoria;}
	public void setPortafoliocategoria(Portafoliocategoria portafoliocategoria) {this.portafoliocategoria = portafoliocategoria;}
	public Archivotabla getArchivotabla() {return archivotabla;}
	public void setArchivotabla(Archivotabla archivotabla) {this.archivotabla = archivotabla;}
	
	public File getFileUpload() {return fileUpload;}
	public void setFileUpload(File fileUpload) {this.fileUpload = fileUpload;}
	public String getFileUploadContentType() {return fileUploadContentType;}
	public void setFileUploadContentType(String fileUploadContentType) {this.fileUploadContentType = fileUploadContentType;}
	public String getFileUploadFileName() {return fileUploadFileName;}
	public void setFileUploadFileName(String fileUploadFileName) {this.fileUploadFileName = fileUploadFileName;}
	
	public Portafolio getPortafolio() {return portafolio;}
	public void setPortafolio(Portafolio portafolio) {this.portafolio = portafolio;}
	public List<Portafolio> getListPortafolio() {return listPortafolio;}
	public void setListPortafolio(List<Portafolio> listPortafolio) {this.listPortafolio = listPortafolio;}
	public Categoria getCategoria() {return categoria;}
	public void setCategoria(Categoria categoria) {this.categoria = categoria;}
	public List<Categoria> getListCategoria() {return listCategoria;}
	public void setListCategoria(List<Categoria> listCategoria) {this.listCategoria = listCategoria;}
	public Articulo getArticulo() {return articulo;}
	public void setArticulo(Articulo articulo) {this.articulo = articulo;}
	public List<Articulo> getListArticulo() {return listArticulo;}
	public void setListArticulo(List<Articulo> listArticulo) {this.listArticulo = listArticulo;}
	public Ordencompra getOrdenCompra() {return ordenCompra;}
	public void setOrdenCompra(Ordencompra ordenCompra) {this.ordenCompra = ordenCompra;}
	public List<Ordencompra> getListOrdenCompra() {return listOrdenCompra;}
	public void setListOrdenCompra(List<Ordencompra> listOrdenCompra) {this.listOrdenCompra = listOrdenCompra;}
	public Condicionpago getCondicionpago() {return condicionpago;}
	public void setCondicionpago(Condicionpago condicionpago) {this.condicionpago = condicionpago;}
	public List<Condicionpago> getListCondicionpago() {return listCondicionpago;}
	public void setListCondicionpago(List<Condicionpago> listCondicionpago) {this.listCondicionpago = listCondicionpago;}
	public Formapago getFormapago() {return formapago;}
	public void setFormapago(Formapago formapago) {this.formapago = formapago;}
	public List<Formapago> getListFormapago() {return listFormapago;}
	public void setListFormapago(List<Formapago> listFormapago) {this.listFormapago = listFormapago;}
	public List<Detallecompra> getListDetalleCompra() {return listDetalleCompra;}
	public void setListDetalleCompra(List<Detallecompra> listDetalleCompra) {this.listDetalleCompra = listDetalleCompra;}
	public Detallecompra getDetalleCompra() {return detalleCompra;}
	public void setDetalleCompra(Detallecompra detalleCompra) {this.detalleCompra = detalleCompra;}
	public List<Tipodocumento> getListTipoDoc() {return listTipoDoc;}
	public void setListTipoDoc(List<Tipodocumento> listTipoDoc) {this.listTipoDoc = listTipoDoc;}
	public Persona getPersona() {return persona;}
	public void setPersona(Persona persona) {this.persona = persona;}
	public Cliente getCliente() {return cliente;}
	public void setCliente(Cliente cliente) {this.cliente = cliente;}
	public List<Detalleventa> getListDetalleVenta() {return listDetalleVenta;}
	public void setListDetalleVenta(List<Detalleventa> listDetalleVenta) {this.listDetalleVenta = listDetalleVenta;}
	public Detalleventa getDetalleVenta() {return detalleVenta;}
	public void setDetalleVenta(Detalleventa detalleVenta) {this.detalleVenta = detalleVenta;}
	public Venta getVenta() {return venta;}
	public void setVenta(Venta venta) {this.venta = venta;}
	public List<Venta> getListVenta() {return listVenta;}
	public void setListVenta(List<Venta> listVenta) {this.listVenta = listVenta;}
	public Pago getPago() {return pago;}
	public void setPago(Pago pago) {this.pago = pago;}
	public List<Pago> getListPago() {return listPago;}
	public void setListPago(List<Pago> listPago) {this.listPago = listPago;}
	public Consecutivo getConsecutivo() {return consecutivo;}
	public void setConsecutivo(Consecutivo consecutivo) {this.consecutivo = consecutivo;}
	public List<Consecutivo> getListConsecutivo() {return listConsecutivo;}
	public void setListConsecutivo(List<Consecutivo> listConsecutivo) {this.listConsecutivo = listConsecutivo;}
	public List<Pago> getListAbono() {return listAbono;}
	public void setListAbono(List<Pago> listAbono) {this.listAbono = listAbono;}
	
	
	public List<UtilGenerico> getListEstado() {return ConstantesAplicativo.listEstadoSN;}
	public List<UtilGenerico> getListEstadoArticulo() {return ConstantesAplicativo.listEstadoArticulo;}
	public List<UtilGenerico> getListEstadoOrdenCompra() {return ConstantesAplicativo.listEstadoOrdenCompra;}
	public List<UtilGenerico> getListCondicionPagoSelect() {return ConstantesAplicativo.listCondicionPagoSelect;}
	public List<UtilGenerico> getListFormaPagoSelect() {return ConstantesAplicativo.listFormaPagoSelect;}
	
	
	private void getFuncionPosicionado(){
		if(request.getSession().getAttribute("funcPosicionado")==null){
			request.getSession().setAttribute("funcPosicionado",funcPosicionado);
		}else{
			String funcCambio = (String) request.getSession().getAttribute("funcPosicionado");
			if(!funcPosicionado.equals(funcCambio))
				request.getSession().setAttribute("funcPosicionado",funcPosicionado);
		}
		System.out.println("######>>>>>>>funcPosicionado>>>>"+funcPosicionado);
	}
	
	@SkipValidation
	public String categoriaArticuloMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>niifAction>>>>categoriaArticuloMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listCategoria = gestionFacadeNIIF.findAllCategorias();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(ValidaString.isNullOrEmptyString(categoria.getCateNombre()))
    				addActionError(getText("validacion.requerido","catenombre","Nombre"));
    			if(ValidaString.isNullOrEmptyString(categoria.getCateDescripcion()))
    				addActionError(getText("validacion.requerido","cateDescripcion","Descripcion"));
    			if(!hasActionErrors()){
    				categoria.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(categoria);
    				gestionFacadeNIIF.persistCategoria(categoria);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			categoria = gestionFacadeNIIF.findCategoriaById(getIdLong());
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>niifAction>>>>categoriaArticuloMethod>>>>estado entrada-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String articuloMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>niifAction>>>>articuloMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listArticulo = gestionFacadeNIIF.findAllArticulos();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoAdd)){
    			listCategoria = gestionFacadeNIIF.findAllCategoriasActivas();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(ValidaString.isNullOrEmptyString(articulo.getArtiNombre()))
    				addActionError(getText("validacion.requerido","artinombre","Nombre"));
    			if(categoria==null||categoria.getCateId()<=0)
    				addActionError(getText("validacion.requerido","cateid","Categoria"));
    			if(ValidaString.isNullOrEmptyString(articulo.getArtiReferencia()))
    				addActionError(getText("validacion.requerido","artireferencia","Referencia"));
    			if(ValidaString.isNullOrEmptyString(articulo.getArtiEstado()))
    				addActionError(getText("validacion.requerido","artiestado","Estado"));
    			if(!hasActionErrors()){
    				articulo.setCategoria(gestionFacadeNIIF.findCategoriaById(categoria.getCateId()));
    				articulo.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(articulo);
    				gestionFacadeNIIF.persistArticulo(articulo);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}else
    				listCategoria = gestionFacadeNIIF.findAllCategoriasActivas();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			articulo = gestionFacadeNIIF.findArticuloById(getIdLong());
    			categoria = gestionFacadeNIIF.findCategoriaById(articulo.getCategoria().getCateId());
    			listCategoria = gestionFacadeNIIF.findAllCategoriasActivas();
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>niifAction>>>>articuloMethod>>>>estado entrada-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String ordenCompraMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>niifAction>>>>ordenCompraMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listOrdenCompra = gestionFacadeNIIF.findAllOrdencompras();
    			request.getSession().removeAttribute("listDetalleCompra");
    			request.getSession().removeAttribute("detalleCompra");
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoAdd)){
    			//listCategoria = gestionFacadeNIIF.findAllCategoriasActivas();
    			System.out.println("Construccion!!!!!!");
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			listDetalleCompra = (List<Detallecompra>)request.getSession().getAttribute("listDetalleCompra");
    			if(ValidaString.isNullOrEmptyString(ordenCompra.getOrcoNrocomprobante()))
    				addActionError(getText("validacion.requerido","orconrocomprobante","Nro Comprobante"));
    			if(ValidaString.isNullOrEmptyString(ordenCompra.getOrcoFechacompra()))
    				addActionError(getText("validacion.requerido","orcofechacompra","Fecha de Compra"));
    			if(ValidaString.isNullOrEmptyString(ordenCompra.getOrcoFechavence()))
    				addActionError(getText("validacion.requerido","orcofechavence","Fecha de Vencimiento"));
    			if(listDetalleCompra==null||listDetalleCompra.size()<=0)
    				addActionError(getText("validacion.requeridosec","detallecompra","Detalle de Compra"));
    			//ValidaString.imprimirObject(ordenCompra);
    			if(!hasActionErrors()){
    				ordenCompra.setProveedor(gestionFacadeNIIF.findProveedorById(1));//Construccion Proveedor
    				ordenCompra.setOrcoEstado(ConstantesAplicativo.constanteEstadoOrdenCompraPendiente);
    				ordenCompra.setDatosAud(getDatosAud());
    				long orcoId = gestionFacadeNIIF.persistOrdencompraId(ordenCompra);
    				if(orcoId>0){
    					ordenCompra.setOrcoId(orcoId);
    					for(Detallecompra elem:listDetalleCompra){
    						elem.setOrdencompra(ordenCompra);
    						elem.setId(new DetallecompraPK(elem.getArticulo().getArtiId(), elem.getOrdencompra().getOrcoId()));
    						elem.setDatosAud(getDatosAud());
    						gestionFacadeNIIF.persistDetallecompra(elem);
    					}
    				}
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}else
    				listCategoria = gestionFacadeNIIF.findAllCategoriasActivas();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			ordenCompra = gestionFacadeNIIF.findOrdencompraById(getIdLong());
    			listDetalleCompra = gestionFacadeNIIF.findAllDetallecompras(getIdLong());
    			request.getSession().setAttribute("listDetalleCompra", listDetalleCompra);
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>niifAction>>>>ordenCompraMethod>>>>estado entrada-->>"+estado);
    	return Action.SUCCESS;
	}

	public InputStream getStrDatosArticulo() {
		try{
			String html = "";
			long idArticulo = Long.parseLong(request.getParameter("idArticulo"));
			String bandVenta = request.getParameter("tipo")!=null&&request.getParameter("tipo").equals("venta")?ConstantesAplicativo.constanteCheckSi:ConstantesAplicativo.constanteCheckNo; 
			Articulo articulo = gestionFacadeNIIF.findArticuloById(idArticulo);
			html = "<s:textfield name=\"dataAutoCompletado\" id=\"search\" size=\"60\" maxlength=\"30\" cssClass=\"inputs\"></s:textfield><br>";
			html += "<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"display\">"+
					"	<tr> " +
					"		<td class=\"leftLabel\">Artículo</td> " +
					"		<td>" + articulo.getArtiNombre() + "</td> " +
					"		<td class=\"leftLabel\">Referencia</td> " +
					"		<td>" + articulo.getArtiReferencia() + "</td> " +
					"	</tr> " +
					"	<tr> " +
					"		<td class=\"leftLabel\">Categoria</td> " +
					"		<td>" + articulo.getCategoria().getCateNombre() + "</td> " +
					"		<td class=\"leftLabel\">Marca</td> " +
					"		<td>" + articulo.getArtiMarca() + "</td> " +
					"	</tr> " +
					"	<tr> " +
					"		<td class=\"leftLabel\">Cantidad</td> " +
					"		<td><input type=\"text\" id=\"cantidadArti\" class=\"inputs\" onKeyPress=\"return soloNumeros(event)\" onpaste=\"return false\"/></td> " +
					"		<td class=\"leftLabel\">Valor Unitario</td> ";
			html +=	bandVenta!=null&&bandVenta.equals(ConstantesAplicativo.constanteCheckNo)?
					"		<td><input type=\"text\" id=\"valorUniArti\" class=\"inputs\" onKeyPress=\"return soloNumeros(event)\" onpaste=\"return false\"/></td> ":
					"		<td><input type=\"hidden\" id=\"valorUniArti\" value=\""+articulo.getArtiPrecioventa()+"\"/>" + articulo.getArtiPrecioventaView() + "</td> ";
			html +=	"	</tr> " +
					"</table>";
			if(bandVenta!=null&&bandVenta.equals(ConstantesAplicativo.constanteCheckNo)){
				detalleCompra = new Detallecompra();
				detalleCompra.setArticulo(articulo);
				request.getSession().setAttribute("detalleCompra", detalleCompra);
			}else{
				System.out.println("Entra esta parte!!!!!!!!");
				detalleVenta = new Detalleventa();
				detalleVenta.setArticulo(articulo);
				request.getSession().setAttribute("detalleVenta", detalleVenta);
			}
			strDatosArticulo = new ByteArrayInputStream(html.getBytes(Charset.forName("UTF-8")));
		}catch(Exception e){
			e.printStackTrace();
		}
		return strDatosArticulo;
	}
	
	public InputStream getStrDatosDetalleCompra() {
		try{
			boolean bandAdd = true;
			String html = "";
			String bandVenta = request.getParameter("tipo")!=null&&request.getParameter("tipo").equals("venta")?ConstantesAplicativo.constanteCheckSi:ConstantesAplicativo.constanteCheckNo;
			int posicion = Integer.parseInt(request.getParameter("posicion"));
			int cantidadArti = request.getParameter("cantidadArti")!=null&&!request.getParameter("cantidadArti").toString().equals("")?Integer.parseInt(request.getParameter("cantidadArti")):0;
			double valorUniArti = request.getParameter("valorUniArti")!=null&&!request.getParameter("valorUniArti").toString().equals("")?Double.parseDouble(request.getParameter("valorUniArti")):0;
			double totalDes = Double.parseDouble(request.getParameter("totalDes"));
			double totalIva = Double.parseDouble(request.getParameter("totalIva"));
			if(bandVenta!=null&&bandVenta.equals(ConstantesAplicativo.constanteCheckSi)){
				listDetalleVenta = (List<Detalleventa>)request.getSession().getAttribute("listDetalleVenta");
				if(listDetalleVenta==null)
					listDetalleVenta = new ArrayList<Detalleventa>();
				if(posicion<0){
					if(cantidadArti>0&&valorUniArti>0){
						detalleVenta = (Detalleventa) request.getSession().getAttribute("detalleVenta");
						if(detalleVenta!=null){
							detalleVenta.setDeveCantidad(cantidadArti);
							detalleVenta.setDeveValorartven(valorUniArti);
							detalleVenta.setDeveTotalartven(cantidadArti*valorUniArti);
							//ValidaString.imprimirObject(detalleCompra);
							//ValidaString.imprimirObject(detalleCompra.getArticulo());
							listDetalleVenta.add(detalleVenta);
							request.getSession().removeAttribute("detalleVenta");
						}
					}else
						bandAdd = false;
				}else
					listDetalleVenta.remove(posicion);
			}else{
				listDetalleCompra = (List<Detallecompra>)request.getSession().getAttribute("listDetalleCompra");
				if(listDetalleCompra==null)
					listDetalleCompra = new ArrayList<Detallecompra>();
				if(posicion<0){
					if(cantidadArti>0&&valorUniArti>0){
						detalleCompra = (Detallecompra) request.getSession().getAttribute("detalleCompra");
						if(detalleCompra!=null){
							detalleCompra.setDecoCantidad(cantidadArti);
							detalleCompra.setDecoValorunitario(valorUniArti);
							detalleCompra.setDecoValortotal(cantidadArti*valorUniArti);
							//ValidaString.imprimirObject(detalleCompra);
							//ValidaString.imprimirObject(detalleCompra.getArticulo());
							listDetalleCompra.add(detalleCompra);
							request.getSession().removeAttribute("detalleCompra");
						}
					}else
						bandAdd = false;
				}else
					listDetalleCompra.remove(posicion);
			}
			html = "<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"display\">";
			html += !bandAdd?"<tr><td colspan=\"6\"><font size=\"2\" color=\"#FF0000\"><strong>Cantidad " +
					((bandVenta!=null&&bandVenta.equals(ConstantesAplicativo.constanteCheckSi))?"es requerido":"y Valor Unitario son requeridos") +
					".[E001]</strong></font></td></tr>":"";
			if((listDetalleCompra!=null&&listDetalleCompra.size()>0) || (listDetalleVenta!=null&&listDetalleVenta.size()>0) ){
				html +=	" <tr> " +
						" 	<td class=\"leftLabel\" style=\"width:5%\">#</td> " +
						" 	<td class=\"leftLabel\">Referencia</td> " +
						"	<td class=\"leftLabel\">Artículo</td> " +
						"	<td class=\"leftLabel\">Cantidad</td> " +
						" 	<td class=\"leftLabel\">Vr Unitario</td> " +
						"	<td class=\"leftLabel\">Vr Total</td>" +
						" </tr> ";
				int cont = 0;
				double total = 0;
				if(bandVenta!=null&&bandVenta.equals(ConstantesAplicativo.constanteCheckSi)){
					for(Detalleventa elem:listDetalleVenta){
						double totalArti = elem.getDeveCantidad()*elem.getDeveValorartven();
						html +=	"	<tr> " +
								"		<td align=\"center\"> " +
								" 			<a onclick=\"agregarArticulo('" + cont + "');\">Remover</a> " +
								"		</td>" +
								"		<td>" + elem.getArticulo().getArtiReferencia() + "</td> " +
								"		<td>" + elem.getArticulo().getArtiNombre() + "</td> " +
								"		<td align=\"right\">" + elem.getDeveCantidad() + "</td> " +
								"		<td align=\"right\">" + elem.getDeveValorartvenView()  + "</td> " +
								"		<td align=\"right\">" + ValidaString.formatToMoney(String.valueOf(totalArti)) + "</td> " +
								"	</tr> ";
						total += totalArti;
					}
				}else{
					for(Detallecompra elem:listDetalleCompra){
						double totalArti = elem.getDecoCantidad()*elem.getDecoValorunitario();
						html +=	"	<tr> " +
								"		<td align=\"center\"> " +
								" 			<a onclick=\"agregarArticulo('" + cont + "');\">Remover</a> " +
								"		</td>" +
								"		<td>" + elem.getArticulo().getArtiReferencia() + "</td> " +
								"		<td>" + elem.getArticulo().getArtiNombre() + "</td> " +
								"		<td align=\"right\">" + elem.getDecoCantidad() + "</td> " +
								"		<td align=\"right\">" + elem.getDecoValorunitarioView() + "</td> " +
								"		<td align=\"right\">" + ValidaString.formatToMoney(String.valueOf(totalArti))  + "</td> " +
								"	</tr> ";
						total += totalArti;
					}
				}
				html +=	" <tr> " +
						" 	<td colspan=\"4\"></td> " +
						"	<td align=\"right\" class=\"leftLabel\">Subtotal</td> " +
						"	<td align=\"right\"><input type=\"hidden\" id=\"total\" value=\""+total+"\"/>"+ ValidaString.formatToMoney(String.valueOf(total)) + " </td>" +
						" </tr> ";
				html +=	" <tr> " +
						" 	<td colspan=\"4\"></td> " +
						"	<td align=\"right\" class=\"leftLabel\">Descuento</td> " +
						"	<td align=\"right\"><input type=\"text\" id=\"totalDes\" value=\""+totalDes+"\"  class=\"inputs\"  style=\"text-align:right\" onKeyPress=\"return soloNumeros(event)\" onpaste=\"return false\" onblur=\"javascript:calcularTotalaPagar();\"/></td>" +
						" </tr> ";
				html +=	" <tr> " + 
						" 	<td colspan=\"4\"></td> " +
						"	<td align=\"right\" class=\"leftLabel\">Iva</td> " +
						"	<td align=\"right\"><input type=\"text\" id=\"totalIva\" value=\""+totalIva+"\"  class=\"inputs\"  style=\"text-align:right\" onKeyPress=\"return soloNumeros(event)\" onpaste=\"return false\" onblur=\"javascript:calcularTotalaPagar();\"/></td>" +
						" </tr> ";
				html +=	" <tr> " +
						" 	<td colspan=\"4\"></td> " +
						"	<td align=\"right\" class=\"leftLabel\">Total</td> " +
						"	<td align=\"right\"><input type=\"hidden\" id=\"totalaPagar\" value=\""+((total+totalIva)-totalDes)+"\"/><div id=\"totalaPagarDiv\">"+ValidaString.formatToMoney(String.valueOf(((total+totalIva)-totalDes)))+"</div></td>" +
						" </tr> ";
				
//				if(bandVenta!=null&&bandVenta.equals(ConstantesAplicativo.constanteCheckSi)){
//					if(venta==null)
//						venta = new Venta();
//					venta.setVentTotal(total);
//					venta.setVentTotaldes(totalDes);
//					venta.setVentTotaliva(totalIva);
//					venta.setVentTotalpag(((total+totalIva)-totalDes));
//				}
			}
			html +=	"</table>";
			if(bandVenta!=null&&bandVenta.equals(ConstantesAplicativo.constanteCheckSi)){
				request.getSession().setAttribute("listDetalleVenta",listDetalleVenta);
			}else
				request.getSession().setAttribute("listDetalleCompra",listDetalleCompra);
			strDatosDetalleCompra = new ByteArrayInputStream(html.getBytes(Charset.forName("UTF-8")));
		}catch(Exception e){
			e.printStackTrace();
		}
		return strDatosDetalleCompra;
	}
	
	
	@SkipValidation
	public String condicionPagoMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>niifAction>>>>condicionPagoMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listCondicionpago = gestionFacadeNIIF.findAllCondicionpagos();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(ValidaString.isNullOrEmptyString(condicionpago.getCopaCondicionpago()))
    				addActionError(getText("validacion.requerido","copaCondicionPago","Condicion Pago"));
    			if(ValidaString.isNullOrEmptyString(condicionpago.getCopaDescripcion()))
    				addActionError(getText("validacion.requerido","copaDescripcion","Descripcion"));
    			if(!hasActionErrors()){
    				condicionpago.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(condicionpago);
    				gestionFacadeNIIF.persistCondicionpago(condicionpago);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			condicionpago = gestionFacadeNIIF.findCondicionpagoById(getIdLong());
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>niifAction>>>>condicionPagoMethod>>>>estado entrada-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String formaPagoMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>niifAction>>>>formaPagoMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listFormapago = gestionFacadeNIIF.findAllFormapagos();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(ValidaString.isNullOrEmptyString(formapago.getFopaFormapago()))
    				addActionError(getText("validacion.requerido","fopaFormaPago","Forma Pago"));
    			if(ValidaString.isNullOrEmptyString(formapago.getFopaDescripcion()))
    				addActionError(getText("validacion.requerido","fopaDescripcion","Descripcion"));
    			if(!hasActionErrors()){
    				formapago.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(formapago);
    				gestionFacadeNIIF.persistFormapago(formapago);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			formapago = gestionFacadeNIIF.findFormapagoById(getIdLong());
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>niifAction>>>>formaPagoMethod>>>>estado entrada-->>"+estado);
    	return Action.SUCCESS;
	}
		
	@SkipValidation
	public String portafolioMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>niifAction>>>>portafolioMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listPortafolio = gestionFacadeNIIF.findAllPortafolios();
//    			for(Portafolio elem:listPortafolio){
//    				archivotabla = gestionFacadeNIIF.findArchivotablaByTablaIdRegistro(ConstantesAplicativo.constanteNombreTablaPortafolio, String.valueOf(elem.getPortId()));
//    				if(archivotabla!=null){
//        				String rutaAlterna = "/";
//        				rutaAlterna += archivotabla.getArtaRuta().replace("\\", "/")+"/"+archivotabla.getArtaArchguardado();
//        				archivotabla.setRutaAlterna(rutaAlterna);
//        				System.out.println("//*/*/*/*/*////*/*/*/*/*/*/*/*/*/*/*/*/*/*/");
//        				System.out.println(rutaAlterna);
//        				System.out.println("//*/*/*/*/*////*/*/*/*/*/*/*/*/*/*/*/*/*/*/");
//        			}
//    			}
    			
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(ValidaString.isNullOrEmptyString(portafolio.getPortReferencia()))
    				addActionError(getText("validacion.requerido","portreferencia","Referencia"));
    			if(ValidaString.isNullOrEmptyString(portafolio.getPortDescripcion()))
    				addActionError(getText("validacion.requerido","portdescripcion","Descripción"));
    			if(ValidaString.isNullOrEmptyString((String.valueOf(portafolio.getPortValor()))))
    				addActionError(getText("validacion.requerido","portvalor","Valor $"));
    			if(!hasActionErrors()){
    				portafolio.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(portafolio);
    				gestionFacadeNIIF.persistPortafolio(portafolio);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				boolean uploadFile = false;
    				System.out.println("...........................................................");
    				System.out.println("...........................................................");
    				if(getFileUpload()!=null){
    					uploadFile = utilidadAlmacenarArchivo(ConstantesAplicativo.constanteNombreTablaPortafolio, 
    													portafolio.getPortId()+"", 
    													getFileUploadFileName(), 
    														ConstantesAplicativo.constanteRutaArchivosTablaPortafolio, 
    															getFileUpload(), 
    																ConstantesAplicativo.constanteCheckSi);
    				}
    				System.out.println("entra y sale de uploadfile");
    				if(getFileUpload()!=null && !uploadFile)
    					addActionError(getText("error.aplicacion"));
    				archivotabla = gestionFacadeNIIF.findArchivotablaByTablaIdRegistro(ConstantesAplicativo.constanteNombreTablaPortafolio, portafolio.getPortId()+"");
    				if(archivotabla!=null){
        				String rutaAlterna = "/";
        				rutaAlterna += archivotabla.getArtaRuta().replace("\\", "/")+"/"+archivotabla.getArtaArchguardado();
        				archivotabla.setRutaAlterna(rutaAlterna);
        			}else{
        				archivotabla = new Archivotabla();
        				}
    				addActionMessage(getText("accion.satisfactoria"));
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			portafolio = gestionFacadeNIIF.findPortafolioById(getIdLong());
    			archivotabla = gestionFacadeNIIF.findArchivotablaByTablaIdRegistro(ConstantesAplicativo.constanteNombreTablaPortafolio, portafolio.getPortId()+"");
    			if(archivotabla!=null){
    				String rutaAlterna = "/";
    				rutaAlterna += archivotabla.getArtaRuta().replace("\\", "/")+"/"+archivotabla.getArtaArchguardado();
    				archivotabla.setRutaAlterna(rutaAlterna);
    			}else
    				archivotabla = new Archivotabla();
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>niifAction>>>>portafolioMethod>>>>estado entrada-->>"+estado);
    	return Action.SUCCESS;
	}
	
	/**
	 * Utilidad para subir un archivo y cargarlo en la tabla Archivo Tabla con validacion de eliminacion
	 * @param tabla
	 * @param idRegistro
	 * @param nombreArchivoOri
	 * @param ruta
	 * @param archivo
	 * @param eliminarExistente
	 * @return
	 */
	public boolean utilidadAlmacenarArchivo(String tabla, String idRegistro, String nombreArchivoOri, String ruta, File archivo, String eliminarExistente){
		try{
			String filePath = request.getRealPath(System.getProperty("file.separator"));
			filePath += ruta;
			if(eliminarExistente.equals(ConstantesAplicativo.constanteCheckSi)){
				System.out.println(">>>>>entro a aliminar existente>>>>>");
				archivotabla = gestionFacadeNIIF.findArchivotablaByTablaIdRegistro(tabla, idRegistro);
				if(archivotabla!=null){
					System.out.println("es diferente de null, entra a eliminar archivo y registro");
					File destFile = new File(filePath, archivotabla.getArtaArchguardado());
					destFile.delete();
					gestionFacadeNIIF.removeArchivotabla(archivotabla);
				}
			}
			System.out.println(">>>>>entro a crear archivo>>>>>");
//			usuarioLogin = (UsuarioLogin)request.getSession().getAttribute("UsuarioLogin");
			archivotabla = new Archivotabla();
			archivotabla.setArtaTabla(tabla);
			archivotabla.setArtaIdtabla(idRegistro);
			archivotabla.setArtaArchoriginal(nombreArchivoOri);
			Calendar hora = Calendar.getInstance();
			String [] partesarchivo = nombreArchivoOri.split("\\.");
			String nombreArchivo = "Archivo_"+tabla+"_"+idRegistro+"_"+ hora.get(Calendar.HOUR_OF_DAY) + hora.get(Calendar.MINUTE) + hora.get(Calendar.SECOND) +"."+partesarchivo[partesarchivo.length-1];
			//String nombreArchivo = "Archivo_"+tabla+"_"+idRegistro+"."+partesarchivo[partesarchivo.length-1];
			archivotabla.setArtaArchguardado(nombreArchivo);
			archivotabla.setArtaRuta(ruta);
			archivotabla.setArtaEstado(ConstantesAplicativo.constanteEstadoActivoGlobalLetra);
//			archivotabla.setArtaRegistradopor("123321");
//			archivotabla.setArtaFechacambio("14/08/2015");
			archivotabla.setDatosAud(this.getDatosAud());
			gestionFacadeNIIF.persistArchivotabla(archivotabla);
			
			System.out.println(">>>>>>>>>>>>>>>>>RUTA-->>"+filePath);
			File destFile = new File(filePath, nombreArchivo);
			FileUtils.copyFile(archivo, destFile);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Utilidad para eliminar un archivo en fisico y en tabla ArchivTabla
	 * @param tabla
	 * @param idRegistro
	 * @param ruta
	 * @param idArchivoTabla
	 * @return
	 */
	public boolean utilidadEliminarArchivo(String tabla, String idRegistro, String ruta, long idArchivoTabla){
		try{
			String filePath = request.getRealPath(System.getProperty("file.separator"));
			filePath += ruta;
			
			archivotabla = gestionFacadeNIIF.findArchivotablaById(idArchivoTabla);
			if(archivotabla!=null){
				System.out.println("es diferente de null, entra a eliminar archivo y registro");
				File destFile = new File(filePath, archivotabla.getArtaArchguardado());
				destFile.delete();
				gestionFacadeNIIF.removeArchivotabla(archivotabla);
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@SkipValidation
	public String portafolioCategoriaMethod(){ 
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>niifAction>>>>portafolioCategoriaMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listPortafoliocategoria = gestionFacadeNIIF.findAllPortafoliocategorias();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(ValidaString.isNullOrEmptyString(portafoliocategoria.getPocaReferencia()))
    				addActionError(getText("validacion.requerido","pocareferencia","Referencia"));
    			if(ValidaString.isNullOrEmptyString(portafoliocategoria.getPocaDescripcion()))
    				addActionError(getText("validacion.requerido","pocadescripcion","Descripción"));
    			if(!hasActionErrors()){
    				portafoliocategoria.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(portafoliocategoria);
    				gestionFacadeNIIF.persistPortafoliocategoria(portafoliocategoria);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				boolean uploadFile = false;
    				System.out.println("...........................................................");
    				System.out.println("...........................................................");
    				if(getFileUpload()!=null){
    					uploadFile = utilidadAlmacenarArchivo(ConstantesAplicativo.constanteNombreTablaPortafolioCategoria, 
    													portafoliocategoria.getPocaId()+"", 
    													getFileUploadFileName(), 
    														ConstantesAplicativo.constanteRutaArchivosTablaPortafolio, 
    															getFileUpload(), 
    																ConstantesAplicativo.constanteCheckSi);
    				}
    				System.out.println("entra y sale de uploadfile");
    				if(getFileUpload()!=null && !uploadFile)
    					addActionError(getText("error.aplicacion"));
    				archivotabla = gestionFacadeNIIF.findArchivotablaByTablaIdRegistro(ConstantesAplicativo.constanteNombreTablaPortafolioCategoria, portafoliocategoria.getPocaId()+"");
    				if(archivotabla!=null){
        				String rutaAlterna = "/";
        				rutaAlterna += archivotabla.getArtaRuta().replace("\\", "/")+"/"+archivotabla.getArtaArchguardado();
        				archivotabla.setRutaAlterna(rutaAlterna);
        			}else{
        				archivotabla = new Archivotabla();
        				}
    				addActionMessage(getText("accion.satisfactoria"));
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			portafoliocategoria = gestionFacadeNIIF.findPortafoliocategoriaById(getIdLong());
    			archivotabla = gestionFacadeNIIF.findArchivotablaByTablaIdRegistro(ConstantesAplicativo.constanteNombreTablaPortafolioCategoria, portafoliocategoria.getPocaId()+"");
    			if(archivotabla!=null){
    				String rutaAlterna = "/";
    				rutaAlterna += archivotabla.getArtaRuta().replace("\\", "/")+"/"+archivotabla.getArtaArchguardado();
    				archivotabla.setRutaAlterna(rutaAlterna);
    			}else
    				archivotabla = new Archivotabla();
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>niifAction>>>>portafolioCategoriaMethod>>>>estado entrada-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String ventaMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>niifAction>>>>ventaMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			request.getSession().removeAttribute("listDetalleVenta");
    			request.getSession().removeAttribute("detalleVenta");
    			listFormapago = gestionFacadeNIIF.findAllFormapagos();
    			listTipoDoc = gestionFacadeNIIF.findAllTipodocumentos();
    			listPago = new ArrayList<Pago>();listPago.add(new Pago(1,0.0));
    			//Validar si existe el cliente o no
    			if(!ValidaString.isNullOrEmptyString(persona.getDocumentoPers())&&!ValidaString.isNullOrEmptyString(persona.getTipodocumento().getAbreviaturaTidoc())){
    				Persona personaFind = gestionFacadeNIIF.findPersona(persona.getDocumentoPers(), persona.getTipodocumento().getAbreviaturaTidoc());
    				if(personaFind!=null&&personaFind.getIdPers()>0){
    					cliente = gestionFacadeNIIF.findAllClienteIdPers(personaFind.getIdPers());
    					persona = personaFind;
    					if(cliente!=null&&cliente.getClieId()>0)
    						persona.setExisteCliente(ConstantesAplicativo.constanteCheckSi);
    					else
    						persona.setExisteCliente(ConstantesAplicativo.constanteCheckNo);
    				}else{
    					persona.setExisteCliente(ConstantesAplicativo.constanteCheckNo);
    				}
    			}else{
    				cliente = gestionFacadeNIIF.findAllClienteIdPers(ConstantesAplicativo.constanteIdClienteComodin);
    				persona = cliente.getPersona();
    				persona.setExisteCliente(ConstantesAplicativo.constanteCheckSi);
    			}
//    			venta.setVentFecha(ValidaString.fechaSystem());
//    			venta.setVentHora(ValidaString.horaSystem());
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoAllTipoServicio)){
    			listTipoDoc = gestionFacadeNIIF.findAllTipodocumentos();
    			consecutivo = (Consecutivo)gestionFacadeNIIF.findConsecutivoById(ConstantesAplicativo.constanteIdConsecutivoVenta);
    			if(venta==null)
    				venta = new Venta();
    			venta.setVentFecha(ValidaString.fechaSystem());
    			venta.setVentHora(ValidaString.horaSystem());
    			vendedor = this.getVendedor();
    			request.getSession().removeAttribute("listDetalleVenta");
    			request.getSession().removeAttribute("detalleVenta");
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			listDetalleVenta = (List<Detalleventa>)request.getSession().getAttribute("listDetalleVenta");
    			if(ValidaString.isNullOrEmptyString(persona.getDocumentoPers()))
    				addActionError(getText("validacion.requeridoseccion","documentoPers",new ArrayList<String>(Arrays.asList("Número Documento", ConstantesAplicativo.constanteNombreSeccionDatosCliente))));
    			if(persona.getTipodocumento().getIdTidoc()<=0)
    				addActionError(getText("validacion.requeridoseccion","documentoPers",new ArrayList<String>(Arrays.asList("Tipo Documento", ConstantesAplicativo.constanteNombreSeccionDatosCliente))));
    			if(ValidaString.isNullOrEmptyString(persona.getPnombrePers()))
    				addActionError(getText("validacion.requeridoseccion","pnombrePers",new ArrayList<String>(Arrays.asList("Primer Nombre", ConstantesAplicativo.constanteNombreSeccionDatosCliente))));
    			if(ValidaString.isNullOrEmptyString(persona.getPapellidoPers()))
    				addActionError(getText("validacion.requeridoseccion","papellidoPers",new ArrayList<String>(Arrays.asList("Primer Apellido", ConstantesAplicativo.constanteNombreSeccionDatosCliente))));
    			if(listDetalleVenta==null||listDetalleVenta.size()<=0)
    				addActionError(getText("validacion.requeridosec","detalleventa",ConstantesAplicativo.constanteNombreSeccionDatosProducto));
    			
    			if(listPago!=null&&listPago.size()>0){
    				boolean band = false;
    				double sumaPagos = 0;
    				for(Pago elem:listPago){
    					System.out.println("Pago:["+elem.getFormaPagoIdHelp()+"]-["+elem.getPagoComprobante()+"]-["+elem.getPagoValor()+"]");
    					if(elem.getFormaPagoIdHelp()==1){
    						band = true;
    						if(elem.getPagoValor()<0)
    							addActionError(getText("validacion.requeridoseccion","valor",new ArrayList<String>(Arrays.asList("Valor Efectivo", ConstantesAplicativo.constanteNombreSeccionDatosPagos))));
    					}else if(elem.getFormaPagoIdHelp()==2){
    						band = true;
    						if(ValidaString.isNullOrEmptyString(elem.getPagoComprobante()))
    							addActionError(getText("validacion.requeridoseccion","comprobante",new ArrayList<String>(Arrays.asList("Comprobante Tarjeta", ConstantesAplicativo.constanteNombreSeccionDatosPagos))));
    						if(elem.getPagoValor()<0)
    							addActionError(getText("validacion.requeridoseccion","valor",new ArrayList<String>(Arrays.asList("Valor Tarjeta", ConstantesAplicativo.constanteNombreSeccionDatosPagos))));
    					}else if(elem.getFormaPagoIdHelp()==3){
    						band = true;
    						if(ValidaString.isNullOrEmptyString(elem.getPagoComprobante()))
    							addActionError(getText("validacion.requeridoseccion","comprobante",new ArrayList<String>(Arrays.asList("Comprobante Cheque", ConstantesAplicativo.constanteNombreSeccionDatosPagos))));
    						if(elem.getPagoValor()<0)
    							addActionError(getText("validacion.requeridoseccion","valor",new ArrayList<String>(Arrays.asList("Valor Cheque", ConstantesAplicativo.constanteNombreSeccionDatosPagos))));
    					}
    					if(elem.getFormaPagoIdHelp()>0)
    						sumaPagos += elem.getPagoValor(); 
    				}
    				if(!band)
    					addActionError(getText("validacion.requeridosec","pagos",ConstantesAplicativo.constanteNombreSeccionDatosPagos));
    				else if((venta.getVentTotalpag()-sumaPagos)<0)
    					addActionError(getText("validacion.valormaximopagoseccion","valorsuperior",new ArrayList<String>(Arrays.asList(ValidaString.formatToMoney(String.valueOf(sumaPagos)), venta.getVentTotalpagView(), ConstantesAplicativo.constanteNombreSeccionDatosPagos))));
    			}
    			
    			if(!hasActionErrors()){
    				//-----------------------------------------------------------------------------
    				//1. Validar Si el Cliente ya se ecuentra registrado
    				if(persona.getExisteCliente().equals(ConstantesAplicativo.constanteCheckNo)){
    					persona.setDatosAud(getDatosAud());
    					long persId = gestionFacadeNIIF.persistPersonaId(persona);//Insertar Persona
    					if(persId>0){
    						persona.setIdPers(persId);
    						cliente.setPersona(persona);
    						cliente.setDatosAud(getDatosAud());
    						long clieId = gestionFacadeNIIF.persistClienteId(cliente);//Se registra la Persona Como Cliente
    						if(clieId>0)
    							cliente.setClieId(clieId);
    					}
    				}
    				//-----------------------------------------------------------------------------
    				//2. Registrar Venta
    				if(cliente!=null&&cliente.getClieId()>0){
    					venta.setCliente(cliente);
    					venta.setVendedor(getVendedor());
    					venta.setCondicionpago(getCondicionXPago(venta.getVentTotalpag()));
    					venta.setConsecutivoFechaHora(getConsecutivoVentaFechaHora());
    					venta.setVentEstado(venta.getCondicionpago().getCopaCondicionpago().equals(ConstantesAplicativo.constanteEstadoCondicionPagoContado)
    							?ConstantesAplicativo.constanteEstadoOrdenVentaPagada
    							:ConstantesAplicativo.constanteEstadoOrdenVentaPendiente);
    					venta.setDatosAud(getDatosAud());
    					ValidaString.imprimirObject(venta);
    					long ventId = gestionFacadeNIIF.persistVentaId(venta);
    					System.out.println("ventId:["+ventId+"]");
    					if(ventId>0){
    						venta.setVentId(ventId);
    						for(Detalleventa elem:listDetalleVenta){//2.1 Insertar Detalle de venta
    							elem.setVenta(venta);
    							elem.setId(new DetalleventaPK(elem.getVenta().getVentId(), elem.getArticulo().getArtiId()));
    							elem.setDeveEstadoartven(ConstantesAplicativo.constanteEstadoDetalleVentaPagado);
    							elem.setDatosAud(getDatosAud());
    							gestionFacadeNIIF.persistDetalleventa(elem);
    						}
    						if(listPago!=null&&listPago.size()>0){//2.2 Insertar Pagos
    							for(Pago elem:listPago){
    								if(elem.getFormaPagoIdHelp()>0){
	    								elem.setVenta(venta);
	    								elem.setFormapago(gestionFacadeNIIF.findFormapagoById(elem.getFormaPagoIdHelp()));
	    								elem.setPagoFecha(ValidaString.fechaSystem());
	    								elem.setPagoHora(ValidaString.horaSystem());
	    								elem.setDatosAud(getDatosAud());
	    								gestionFacadeNIIF.persistPago(elem);
    								}
    							}
    						}
    						//-----------------------------------------------------------------------------
    						//3. Avanzar Consecutivo de Factura
    						if(!this.avanzarConsecutivo())
    							addActionMessage(getText("accion.consecutivoventa"));
    						//-----------------------------------------------------------------------------
    						//4. Disminuir stock del articulo vendido
    						// Construccion!!!!!!!!
    						
    					}
    				}
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}else{
    				listTipoDoc = gestionFacadeNIIF.findAllTipodocumentos();
    				listFormapago = gestionFacadeNIIF.findAllFormapagos();
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			formapago = gestionFacadeNIIF.findFormapagoById(getIdLong());
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>niifAction>>>>ventaMethod>>>>estado entrada-->>"+estado);
    	return Action.SUCCESS;
	}

	@SkipValidation
	public String consecutivoMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>niifAction>>>>consecutivoMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listConsecutivo = gestionFacadeNIIF.findAllConsecutivos();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(consecutivo.getConsIniconsecutivo()<=0)
    				addActionError(getText("validacion.requerido","consIniconsecutivo","Consecutivo Inicial"));
    			if(ValidaString.isNullOrEmptyString(consecutivo.getConsVigencia()))
    				addActionError(getText("validacion.requerido","consVigencia","Vigencia Consecutivos"));
    			if(!hasActionErrors()){
    				consecutivo.setDatosAud(this.getDatosAud());
    				consecutivo.setConsConsecutivodis(consecutivo.getConsIniconsecutivo());
    				ValidaString.imprimirObject(consecutivo);
    				gestionFacadeNIIF.persistConsecutivo(consecutivo);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			consecutivo = gestionFacadeNIIF.findConsecutivoById(getIdLong());
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>niifAction>>>>consecutivoMethod>>>>estado entrada-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String pagosMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>niifAction>>>>pagosMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listVenta = gestionFacadeNIIF.findAllVentas();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(listAbono!=null&&listAbono.size()>0){
    				boolean band = false;
    				double sumaPagos = 0;
    				for(Pago elem:listAbono){
    					if(elem.getFormaPagoIdHelp()==1){
    						band = true;
    						if(elem.getPagoValor()<=0)
    							addActionError(getText("validacion.requeridoseccion","valor",new ArrayList<String>(Arrays.asList("Valor Efectivo", ConstantesAplicativo.constanteNombreSeccionDatosPagos))));
    					}else if(elem.getFormaPagoIdHelp()==2){
    						band = true;
    						if(ValidaString.isNullOrEmptyString(elem.getPagoComprobante()))
    							addActionError(getText("validacion.requeridoseccion","comprobante",new ArrayList<String>(Arrays.asList("Comprobante Tarjeta", ConstantesAplicativo.constanteNombreSeccionDatosPagos))));
    						if(elem.getPagoValor()<=0)
    							addActionError(getText("validacion.requeridoseccion","valor",new ArrayList<String>(Arrays.asList("Valor Tarjeta", ConstantesAplicativo.constanteNombreSeccionDatosPagos))));
    					}else if(elem.getFormaPagoIdHelp()==3){
    						band = true;
    						if(ValidaString.isNullOrEmptyString(elem.getPagoComprobante()))
    							addActionError(getText("validacion.requeridoseccion","comprobante",new ArrayList<String>(Arrays.asList("Comprobante Cheque", ConstantesAplicativo.constanteNombreSeccionDatosPagos))));
    						if(elem.getPagoValor()<=0)
    							addActionError(getText("validacion.requeridoseccion","valor",new ArrayList<String>(Arrays.asList("Valor Cheque", ConstantesAplicativo.constanteNombreSeccionDatosPagos))));
    					}
    					if(elem.getFormaPagoIdHelp()>0)
    						sumaPagos += elem.getPagoValor(); 
    				}
    				if(!band)
    					addActionError(getText("validacion.requeridosec","pagos",ConstantesAplicativo.constanteNombreSeccionDatosPagos));
    				else if((venta.getSaldoPendiente()-sumaPagos)<0)
    					addActionError(getText("validacion.valormaximoseccion","valorsuperior",new ArrayList<String>(Arrays.asList(ValidaString.formatToMoney(String.valueOf(sumaPagos)), venta.getSaldoPendienteView(), ConstantesAplicativo.constanteNombreSeccionDatosPagos))));
    			}
    			if(!hasActionErrors()){
    				if(listAbono!=null&&listAbono.size()>0){//Insertar Pagos
    					double sumPagos = 0;
    					String estado = null;
						for(Pago elem:listAbono){
							if(elem.getFormaPagoIdHelp()>0){
								elem.setVenta(venta);
								elem.setFormapago(gestionFacadeNIIF.findFormapagoById(elem.getFormaPagoIdHelp()));
								elem.setPagoFecha(ValidaString.fechaSystem());
								elem.setPagoHora(ValidaString.horaSystem());
								elem.setDatosAud(getDatosAud());
								gestionFacadeNIIF.persistPago(elem);
								sumPagos += elem.getPagoValor();
							}
						}
						listAbono = new ArrayList<Pago>();listAbono.add(new Pago(1,0.0));
						System.out.println("venta.getSaldoPendiente():["+venta.getSaldoPendiente()+"]");
						System.out.println("sumPagos:["+sumPagos+"]");
						System.out.println((venta.getSaldoPendiente()-sumPagos));
						estado = (venta.getSaldoPendiente()-sumPagos)<=0
								?ConstantesAplicativo.constanteEstadoOrdenVentaPagada
		    					:ConstantesAplicativo.constanteEstadoOrdenVentaPendiente;
						venta = gestionFacadeNIIF.findVentaById(venta.getVentId());
						venta.setVentEstado(estado);
						venta.setDatosAud(getDatosAud());
						gestionFacadeNIIF.persistVenta(venta);
					}
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}else
    				venta = gestionFacadeNIIF.findVentaById(venta.getVentId());
				listDetalleVenta = gestionFacadeNIIF.findAllDetalleventas(venta.getVentId());
    			listPago = gestionFacadeNIIF.findAllPagosVenta(venta.getVentId());
    			venta.setSaldoPendiente(this.getSaldoPendiente(listPago, venta.getVentTotalpag()));
    			venta.setSaldoAbonado(this.getSaldoAbonado(listPago)) ;
    			listFormapago = gestionFacadeNIIF.findAllFormapagos();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			venta = gestionFacadeNIIF.findVentaById(getIdLong());
    			listDetalleVenta = gestionFacadeNIIF.findAllDetalleventas(venta.getVentId());
    			listPago = gestionFacadeNIIF.findAllPagosVenta(venta.getVentId());
    			venta.setSaldoPendiente(this.getSaldoPendiente(listPago, venta.getVentTotalpag()));
    			venta.setSaldoAbonado(this.getSaldoAbonado(listPago)) ;
    			listFormapago = gestionFacadeNIIF.findAllFormapagos();
    			listAbono = new ArrayList<Pago>();listAbono.add(new Pago(1,0.0));
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>niifAction>>>>pagosMethod>>>>estado entrada-->>"+estado);
    	return Action.SUCCESS;
	}
	
	
	public niifAction(IGestionFacadeNIIF gestionFacadeNIIF) {
		this.gestionFacadeNIIF = gestionFacadeNIIF;
	}
	public HttpServletRequest getRequest() {return request;}
	public void setRequest(HttpServletRequest request) {this.request = request;}
	public HttpServletResponse getResponse() {return response;}
	public void setResponse(HttpServletResponse response) {this.response = response;}
	public void setServletResponse(HttpServletResponse response) {this.response = response;}
	public void setServletRequest(HttpServletRequest request) {this.request = request;}
	public String getEstado() {return estado;}
	public void setEstado(String estado) {this.estado = estado;}
	public String getFuncPosicionado() {return funcPosicionado;}
	public void setFuncPosicionado(String funcPosicionado) {this.funcPosicionado = funcPosicionado;}
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public long getIdLong() {return Long.parseLong(id);}
	public Integer getIdInteger() {return Integer.parseInt(id);}
	public IGestionFacadeNIIF getGestionFacadeNIIF() {return gestionFacadeNIIF;}
	public void setGestionFacadeNIIF(IGestionFacadeNIIF gestionFacadeNIIF) {this.gestionFacadeNIIF = gestionFacadeNIIF;}
	public String getBandEstadoFunc() {return bandEstadoFunc;}
	public void setBandEstadoFunc(String bandEstadoFunc) {this.bandEstadoFunc = bandEstadoFunc;}
	public List<String> getDatosAud(){
		return Arrays.asList(((Usuario)request.getSession().getAttribute("usuarioVO")).getLoginUsua(),
				ValidaString.fechaSystem(),
				ValidaString.horaSystem());
	}
	public String getFechaHoraServicioSystem(){
		SimpleDateFormat sdf = new SimpleDateFormat(ConstantesAplicativo.constanteFormatoFechaHora1);
		System.out.println("Fecha y Hora Servicio: ["+sdf.format(new Date())+"]");
		return sdf.format(new Date());
	}
	
	public List<String> getConsecutivoVentaFechaHora(){
		try {
			return Arrays.asList(((Consecutivo)gestionFacadeNIIF.findConsecutivoById(ConstantesAplicativo.constanteIdConsecutivoVenta)).getConsConsecutivodis()+"",
					ValidaString.fechaSystem(),
					ValidaString.horaSystem());
		} catch (Exception e) {
			return null;
		}
	}
	public boolean avanzarConsecutivo(){
		boolean band = true;
		try {
			Consecutivo consecutivo = (Consecutivo)gestionFacadeNIIF.findConsecutivoById(ConstantesAplicativo.constanteIdConsecutivoVenta);
			if((consecutivo.getConsConsecutivodis()+1)<=consecutivo.getConsFinconsecutivo()){
				consecutivo.setConsConsecutivodis((consecutivo.getConsConsecutivodis()+1));
				consecutivo.setDatosAud(getDatosAud());
				gestionFacadeNIIF.persistConsecutivo(consecutivo);
			}else
				band = false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return band;
	}
	public Vendedor getVendedor(){
		try {
			Usuario usuario = (Usuario)request.getSession().getAttribute("usuarioVO");
			if(usuario!=null&&usuario.getPersona()!=null)
				return gestionFacadeNIIF.findAllVendedorIdPers(usuario.getPersona().getIdPers());
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public Condicionpago getCondicionXPago(double ventTotalaPagar){
		try {
			double sumPagos = 0;
			if(listPago!=null&&listPago.size()>0){
				for(Pago elem:listPago){
					if(elem.getFormaPagoIdHelp()>0)
						sumPagos +=elem.getPagoValor();
				}
			}
			return  (ventTotalaPagar-sumPagos)>0?
					(Condicionpago)gestionFacadeNIIF.findCondicionpagoById(ConstantesAplicativo.constanteIdCondicionPagoCredito):
					(Condicionpago)gestionFacadeNIIF.findCondicionpagoById(ConstantesAplicativo.constanteIdCondicionPagoContado);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public double getSaldoPendiente(List<Pago> listPago, double totalaPagar){
		try {
			double sumPagos = 0;
			if(listPago!=null&&listPago.size()>0){
				for(Pago elem:listPago){
					sumPagos +=elem.getPagoValor();
				}
			}
			return  (totalaPagar-sumPagos);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public double getSaldoAbonado(List<Pago> listPago){
		try {
			double sumPagos = 0;
			if(listPago!=null&&listPago.size()>0){
				for(Pago elem:listPago){
					sumPagos +=elem.getPagoValor();
				}
			}
			return  sumPagos;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
