package com.software2g.niif.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.software2g.niif.facade.IGestionFacadeNIIF;
import com.software2g.util.ConstantesAplicativo;
import com.software2g.util.ValidaString;
import com.software2g.vo.Articulo;
import com.software2g.vo.Categoria;
import com.software2g.vo.Detallecompra;
import com.software2g.vo.Ordencompra;
import com.software2g.vo.Persona;
import com.software2g.vo.Usuario;
import com.software2g.vo.UtilGenerico;
import com.software2g.vo.Condicionpago;
import com.software2g.vo.Formapago;

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
	
	
	public List<UtilGenerico> getListEstado() {return ConstantesAplicativo.listEstadoSN;}
	public List<UtilGenerico> getListEstadoArticulo() {return ConstantesAplicativo.listEstadoArticulo;}
	public List<UtilGenerico> getListEstadoOrdenCompra() {return ConstantesAplicativo.listEstadoOrdenCompra;}
	
	
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
    			ordenCompra = gestionFacadeNIIF.findOrdencompraById(getIdLong());
    			categoria = gestionFacadeNIIF.findCategoriaById(articulo.getCategoria().getCateId());
    			listCategoria = gestionFacadeNIIF.findAllCategoriasActivas();
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
					"		<td class=\"leftLabel\">Valor Unitario</td> " +
					"		<td><input type=\"text\" id=\"valorUniArti\" class=\"inputs\" onKeyPress=\"return soloNumeros(event)\" onpaste=\"return false\"/></td> " +
					"	</tr> " +
					"</table>";
			detalleCompra = new Detallecompra();
			detalleCompra.setArticulo(articulo);
			request.getSession().setAttribute("detalleCompra", detalleCompra);
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
			int posicion = Integer.parseInt(request.getParameter("posicion"));
			int cantidadArti = request.getParameter("cantidadArti")!=null?Integer.parseInt(request.getParameter("cantidadArti")):0;
			double valorUniArti = request.getParameter("valorUniArti")!=null?Double.parseDouble(request.getParameter("valorUniArti")):0;
			
			listDetalleCompra = (List<Detallecompra>)request.getSession().getAttribute("listDetalleCompra");
			if(listDetalleCompra==null)
				listDetalleCompra = new ArrayList<Detallecompra>();
			if(posicion<0){
				if(cantidadArti>0&&valorUniArti>0){
					detalleCompra = (Detallecompra) request.getSession().getAttribute("detalleCompra");
					detalleCompra.setDecoCantidad(cantidadArti);
					detalleCompra.setDecoValorunitario(valorUniArti);
					//ValidaString.imprimirObject(detalleCompra);
					//ValidaString.imprimirObject(detalleCompra.getArticulo());
					listDetalleCompra.add(detalleCompra);
				}else
					bandAdd = false;
			}else
				listDetalleCompra.remove(posicion);
			html = "<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"display\">";
			html += !bandAdd?"<tr><td colspan=\"6\"><font size=\"2\" color=\"#FF0000\"><strong>Cantidad y Valor Unitario son requeridos.[E001]</strong></font></td></tr>":"";
			if(listDetalleCompra!=null&&listDetalleCompra.size()>0){
				html +=	" <tr> " +
						" 	<td class=\"leftLabel\">#</td> " +
						" 	<td class=\"leftLabel\">Referencia</td> " +
						"	<td class=\"leftLabel\">Artículo</td> " +
						"	<td class=\"leftLabel\">Cantidad</td> " +
						" 	<td class=\"leftLabel\">Vr Unitario</td> " +
						"	<td class=\"leftLabel\">Total</td>" +
						" </tr> ";
				int cont = 0;
				double total = 0;
				for(Detallecompra elem:listDetalleCompra){
					double totalArti = elem.getDecoCantidad()*elem.getDecoValorunitario();
					html +=	"	<tr> " +
							"		<td align=\"center\"> " +
							" 			<a onclick=\"agregarArticulo('" + cont + "');\">Remover</a> " +
							"		</td>" +
							"		<td>" + elem.getArticulo().getArtiReferencia() + "</td> " +
							"		<td>" + elem.getArticulo().getArtiNombre() + "</td> " +
							"		<td align=\"right\">" + elem.getDecoCantidad() + "</td> " +
							"		<td align=\"right\">" + elem.getDecoValorunitario() + "</td> " +
							"		<td align=\"right\">" + totalArti + "</td> " +
							"	</tr> ";
					total += totalArti;
				}
				html +=	" <tr> " +
						" 	<td colspan=\"4\"></td> " +
						"	<td align=\"right\" class=\"leftLabel\">Total</td> " +
						"	<td align=\"right\"> " + total + " </td>" +
						" </tr> ";
				html +=	" <tr> " +
						" 	<td colspan=\"4\"></td> " +
						"	<td align=\"right\" class=\"leftLabel\">Total Descuento</td> " +
						"	<td align=\"right\"><input type=\"text\"/></td>" +
						" </tr> ";
				html +=	" <tr> " +
						" 	<td colspan=\"4\"></td> " +
						"	<td align=\"right\" class=\"leftLabel\">Total Iva</td> " +
						"	<td align=\"right\"><input type=\"text\"/></td>" +
						" </tr> ";
				html +=	" <tr> " +
						" 	<td colspan=\"4\"></td> " +
						"	<td align=\"right\" class=\"leftLabel\">Total a Pagar</td> " +
						"	<td align=\"right\"><input type=\"text\"/></td>" +
						" </tr> ";
			}
			html +=	"</table>";
			request.getSession().setAttribute("listDetalleCompra",listDetalleCompra);
			request.getSession().removeAttribute("detalleCompra");
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
}
