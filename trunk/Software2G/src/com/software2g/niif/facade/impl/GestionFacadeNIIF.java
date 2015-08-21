package com.software2g.niif.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.software2g.vo.Archivotabla;
import com.software2g.vo.Articulo;
import com.software2g.vo.Categoria;
import com.software2g.vo.Cliente;
import com.software2g.vo.Condicionpago;
import com.software2g.vo.Consecutivo;
import com.software2g.vo.Detallecompra;
import com.software2g.vo.Detalleventa;
import com.software2g.vo.Formapago;
import com.software2g.vo.Ordencompra;
import com.software2g.vo.Pago;
import com.software2g.vo.Persona;
import com.software2g.vo.Portafolio;
import com.software2g.vo.Portafoliocategoria;
import com.software2g.vo.Proveedor;
import com.software2g.vo.Tipodocumento;
import com.software2g.vo.Vendedor;
import com.software2g.vo.Venta;
import com.software2g.niif.facade.IGestionFacadeNIIF;
import com.software2g.niif.dao.IArchivoTablaDao;
import com.software2g.niif.dao.IArticuloDao;
import com.software2g.niif.dao.ICategoriaDao;
import com.software2g.niif.dao.IClienteDao;
import com.software2g.niif.dao.ICondicionPagoDao;
import com.software2g.niif.dao.IConsecutivoDao;
import com.software2g.niif.dao.IDetalleCompraDao;
import com.software2g.niif.dao.IDetalleVentaDao;
import com.software2g.niif.dao.IFormaPagoDao;
import com.software2g.niif.dao.IOrdenCompraDao;
import com.software2g.niif.dao.IPagosDao;
import com.software2g.niif.dao.IPortafolioCategoriaDao;
import com.software2g.niif.dao.IPortafolioDao;
import com.software2g.niif.dao.IProveedorDao;
import com.software2g.niif.dao.IVendedorDao;
import com.software2g.niif.dao.IVentaDao;
import com.software2g.portal.dao.IPersonaDao;
import com.software2g.portal.dao.ITipoDocumentoDao;

/**
 * The service class for the Articulo entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class GestionFacadeNIIF implements IGestionFacadeNIIF {
	
	@Autowired
	IArticuloDao articuloDao; 
	@Autowired
	ICategoriaDao categoriaDao;
	@Autowired
	IClienteDao clienteDao;
	@Autowired
	ICondicionPagoDao condicionPagoDao;
	@Autowired
	IDetalleCompraDao detalleCompraDao;
	@Autowired
	IDetalleVentaDao detalleVentaDao;
	@Autowired
	IFormaPagoDao formaPagoDao;
	@Autowired
	IOrdenCompraDao ordenCompraDao;
	@Autowired
	IPagosDao pagosDao;
	@Autowired
	IProveedorDao proveedorDao;
	@Autowired
	IVendedorDao vendedorDao;
	@Autowired
	IVentaDao ventaDao;
	@Autowired
	IPortafolioDao portafolioDao;
	@Autowired
	IArchivoTablaDao archivoTablaDao;
	@Autowired
	IPortafolioCategoriaDao portafolioCategoriaDao;
	@Autowired
	ITipoDocumentoDao tipoDocumentoDao;
	@Autowired
	IPersonaDao personaDao;
	@Autowired
	IConsecutivoDao consecutivoDao;
	
	
	public IPortafolioCategoriaDao getPortafolioCategoriaDao() {return portafolioCategoriaDao;}
	public void setPortafolioCategoriaDao(IPortafolioCategoriaDao portafolioCategoriaDao) {this.portafolioCategoriaDao = portafolioCategoriaDao;}
	public IPortafolioDao getPortafolioDao() {return portafolioDao;}
	public void setPortafolioDao(IPortafolioDao portafolioDao) {this.portafolioDao = portafolioDao;}
	public IArchivoTablaDao getArchivoTablaDao() {return archivoTablaDao;}
	public void setArchivoTablaDao(IArchivoTablaDao archivoTablaDao) {this.archivoTablaDao = archivoTablaDao;}
	public IArticuloDao getArticuloDao() {return articuloDao;}
	public void setArticuloDao(IArticuloDao articuloDao) {this.articuloDao = articuloDao;}
	public ICategoriaDao getCategoriaDao() {return categoriaDao;}
	public void setCategoriaDao(ICategoriaDao categoriaDao) {this.categoriaDao = categoriaDao;}
	public IClienteDao getClienteDao() {return clienteDao;}
	public void setClienteDao(IClienteDao clienteDao) {this.clienteDao = clienteDao;}
	public ICondicionPagoDao getCondicionPagoDao() {return condicionPagoDao;}
	public void setCondicionPagoDao(ICondicionPagoDao condicionPagoDao) {this.condicionPagoDao = condicionPagoDao;}
	public IDetalleCompraDao getDetalleCompraDao() {return detalleCompraDao;}
	public void setDetalleCompraDao(IDetalleCompraDao detalleCompraDao) {this.detalleCompraDao = detalleCompraDao;}
	public IDetalleVentaDao getDetalleVentaDao() {return detalleVentaDao;}
	public void setDetalleVentaDao(IDetalleVentaDao detalleVentaDao) {this.detalleVentaDao = detalleVentaDao;}
	public IFormaPagoDao getFormaPagoDao() {return formaPagoDao;}
	public void setFormaPagoDao(IFormaPagoDao formaPagoDao) {this.formaPagoDao = formaPagoDao;}
	public IOrdenCompraDao getOrdenCompraDao() {return ordenCompraDao;}
	public void setOrdenCompraDao(IOrdenCompraDao ordenCompraDao) {this.ordenCompraDao = ordenCompraDao;}
	public IPagosDao getPagosDao() {return pagosDao;}
	public void setPagosDao(IPagosDao pagosDao) {this.pagosDao = pagosDao;}
	public IProveedorDao getProveedorDao() {return proveedorDao;}
	public void setProveedorDao(IProveedorDao proveedorDao) {this.proveedorDao = proveedorDao;}
	public IVendedorDao getVendedorDao() {return vendedorDao;}
	public void setVendedorDao(IVendedorDao vendedorDao) {this.vendedorDao = vendedorDao;}
	public IVentaDao getVentaDao() {return ventaDao;}
	public void setVentaDao(IVentaDao ventaDao) {this.ventaDao = ventaDao;}
	public ITipoDocumentoDao getTipoDocumentoDao() {return tipoDocumentoDao;}
	public void setTipoDocumentoDao(ITipoDocumentoDao tipoDocumentoDao) {this.tipoDocumentoDao = tipoDocumentoDao;}
	public IPersonaDao getPersonaDao() {return personaDao;}
	public void setPersonaDao(IPersonaDao personaDao) {this.personaDao = personaDao;}
	public IConsecutivoDao getConsecutivoDao() {return consecutivoDao;}
	public void setConsecutivoDao(IConsecutivoDao consecutivoDao) {this.consecutivoDao = consecutivoDao;}
	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Articulo findArticuloById(long id) throws Exception {
		try {
			return getArticuloDao().findArticuloById(id);
		} catch (RuntimeException e) {
			throw new Exception("findArticuloById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Articulo</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Articulo> findAllArticulos() throws Exception {
		try {
			return getArticuloDao().findAllArticulos();
		} catch (RuntimeException e) {
			throw new Exception("findAllArticulos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	@Transactional
	public void persistArticulo(Articulo articulo) throws Exception {
		try {
			getArticuloDao().persistArticulo(articulo);
		} catch (RuntimeException e) {
			throw new Exception("persistArticulo failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeArticulo(Articulo articulo) throws Exception {
		try {
			getArticuloDao().removeArticulo(articulo);
		} catch (RuntimeException e) {
			throw new Exception("removeArticulo failed: " + e.getMessage());
		}
	}
	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Categoria findCategoriaById(long id) throws Exception {
		try {
			return getCategoriaDao().findCategoriaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findCategoriaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Categoria</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Categoria> findAllCategorias() throws Exception {
		try {
			return getCategoriaDao().findAllCategorias();
		} catch (RuntimeException e) {
			throw new Exception("findAllCategorias failed: " + e.getMessage());
		}
	}

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Categoria> findAllCategoriasActivas() throws Exception {
		try {
			return getCategoriaDao().findAllCategoriasActivas();
		} catch (RuntimeException e) {
			throw new Exception("findAllCategoriasActivas failed: " + e.getMessage());
		}
	}
	
	/**
	 * Make the given instance managed and persistent.
	 */
	@Transactional
	public void persistCategoria(Categoria categoria) throws Exception {
		try {
			getCategoriaDao().persistCategoria(categoria);
		} catch (RuntimeException e) {
			throw new Exception("persistCategoria failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeCategoria(Categoria categoria) throws Exception {
		try {
			getCategoriaDao().removeCategoria(categoria);
		} catch (RuntimeException e) {
			throw new Exception("removeCategoria failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Cliente findClienteById(long id) throws Exception {
		try {
			return getClienteDao().findClienteById(id);
		} catch (RuntimeException e) {
			throw new Exception("findClienteById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Cliente</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Cliente> findAllClientes() throws Exception {
		try {
			return getClienteDao().findAllClientes();
		} catch (RuntimeException e) {
			throw new Exception("findAllClientes failed: " + e.getMessage());
		}
	}

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Cliente findAllClienteIdPers(long idPers) throws Exception {
		try {
			return getClienteDao().findAllClienteIdPers(idPers);
		} catch (RuntimeException e) {
			//throw new Exception("findAllClienteIdPers failed: " + e.getMessage());
			return null;
		}
	}
	
	/**
	 * Make the given instance managed and persistent.
	 */
	@Transactional
	public void persistCliente(Cliente cliente) throws Exception {
		try {
			getClienteDao().persistCliente(cliente);
		} catch (RuntimeException e) {
			throw new Exception("persistCliente failed: " + e.getMessage());
		}
	}
	
	@Transactional
	public long persistClienteId(Cliente cliente) throws Exception {
		try {
			return getClienteDao().persistClienteId(cliente);
		} catch (RuntimeException e) {
			throw new Exception("persistClienteId failed: " + e.getMessage());
		}
	}
	
	/**
	 * Remove the given persistent instance.
	 */
	public void removeCliente(Cliente cliente) throws Exception {
		try {
			getClienteDao().removeCliente(cliente);
		} catch (RuntimeException e) {
			throw new Exception("removeCliente failed: " + e.getMessage());
		}
	}
	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Condicionpago findCondicionpagoById(long id) throws Exception {
		try {
			return getCondicionPagoDao().findCondicionpagoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findCondicionpagoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Condicionpago</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Condicionpago> findAllCondicionpagos() throws Exception {
		try {
			return getCondicionPagoDao().findAllCondicionpagos();
		} catch (RuntimeException e) {
			throw new Exception("findAllCondicionpagos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistCondicionpago(Condicionpago condicionpago) throws Exception {
		try {
			getCondicionPagoDao().persistCondicionpago(condicionpago);
		} catch (RuntimeException e) {
			throw new Exception("persistCondicionpago failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeCondicionpago(Condicionpago condicionpago) throws Exception {
		try {
			getCondicionPagoDao().removeCondicionpago(condicionpago);
		} catch (RuntimeException e) {
			throw new Exception("removeCondicionpago failed: " + e.getMessage());
		}
	}
	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Detallecompra findDetallecompraById(com.software2g.vo.DetallecompraPK id) throws Exception {
		try {
			return getDetalleCompraDao().findDetallecompraById(id);
		} catch (RuntimeException e) {
			throw new Exception("findDetallecompraById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Detallecompra</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Detallecompra> findAllDetallecompras() throws Exception {
		try {
			return getDetalleCompraDao().findAllDetallecompras();
		} catch (RuntimeException e) {
			throw new Exception("findAllDetallecompras failed: " + e.getMessage());
		}
	}

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Detallecompra> findAllDetallecompras(long orcoId) throws Exception {
		try {
			return getDetalleCompraDao().findAllDetallecompras(orcoId);
		} catch (RuntimeException e) {
			throw new Exception("findAllDetallecompras failed: " + e.getMessage());
		}
	}
	
	/**
	 * Make the given instance managed and persistent.
	 */
	@Transactional
	public void persistDetallecompra(Detallecompra detallecompra) throws Exception {
		try {
			getDetalleCompraDao().persistDetallecompra(detallecompra);
		} catch (RuntimeException e) {
			throw new Exception("persistDetallecompra failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDetallecompra(Detallecompra detallecompra) throws Exception {
		try {
			getDetalleCompraDao().removeDetallecompra(detallecompra);
		} catch (RuntimeException e) {
			throw new Exception("removeDetallecompra failed: " + e.getMessage());
		}
	}
	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Detalleventa findDetalleventaById(com.software2g.vo.DetalleventaPK id) throws Exception {
		try {
			return getDetalleVentaDao().findDetalleventaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findDetalleventaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Detalleventa</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Detalleventa> findAllDetalleventas() throws Exception {
		try {
			return getDetalleVentaDao().findAllDetalleventas();
		} catch (RuntimeException e) {
			throw new Exception("findAllDetalleventas failed: " + e.getMessage());
		}
	}

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Detalleventa> findAllDetalleventas(long ventId) throws Exception {
		try {
			return getDetalleVentaDao().findAllDetalleventas(ventId);
		} catch (RuntimeException e) {
			throw new Exception("findAllDetalleventas failed: " + e.getMessage());
		}
	}
	
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistDetalleventa(Detalleventa detalleventa) throws Exception {
		try {
			getDetalleVentaDao().persistDetalleventa(detalleventa);
		} catch (RuntimeException e) {
			throw new Exception("persistDetalleventa failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDetalleventa(Detalleventa detalleventa) throws Exception {
		try {
			getDetalleVentaDao().removeDetalleventa(detalleventa);
		} catch (RuntimeException e) {
			throw new Exception("removeDetalleventa failed: " + e.getMessage());
		}
	}
	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Formapago findFormapagoById(long id) throws Exception {
		try {
			return getFormaPagoDao().findFormapagoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findFormapagoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Formapago</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Formapago> findAllFormapagos() throws Exception {
		try {
			return getFormaPagoDao().findAllFormapagos();
		} catch (RuntimeException e) {
			throw new Exception("findAllFormapagos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFormapago(Formapago formapago) throws Exception {
		try {
			getFormaPagoDao().persistFormapago(formapago);
		} catch (RuntimeException e) {
			throw new Exception("persistFormapago failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFormapago(Formapago formapago) throws Exception {
		try {
			getFormaPagoDao().removeFormapago(formapago);
		} catch (RuntimeException e) {
			throw new Exception("removeFormapago failed: " + e.getMessage());
		}
	}
	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Ordencompra findOrdencompraById(long id) throws Exception {
		try {
			return getOrdenCompraDao().findOrdencompraById(id);
		} catch (RuntimeException e) {
			throw new Exception("findOrdencompraById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Ordencompra</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Ordencompra> findAllOrdencompras() throws Exception {
		try {
			return getOrdenCompraDao().findAllOrdencompras();
		} catch (RuntimeException e) {
			throw new Exception("findAllOrdencompras failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	@Transactional
	public void persistOrdencompra(Ordencompra ordencompra) throws Exception {
		try {
			getOrdenCompraDao().persistOrdencompra(ordencompra);
		} catch (RuntimeException e) {
			throw new Exception("persistOrdencompra failed: " + e.getMessage());
		}
	}
	
	@Transactional
	public long persistOrdencompraId(Ordencompra ordencompra) throws Exception {
		try {
			return getOrdenCompraDao().persistOrdencompraId(ordencompra);
		} catch (RuntimeException e) {
			throw new Exception("persistOrdencompraId failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeOrdencompra(Ordencompra ordencompra) throws Exception {
		try {
			getOrdenCompraDao().removeOrdencompra(ordencompra);
		} catch (RuntimeException e) {
			throw new Exception("removeOrdencompra failed: " + e.getMessage());
		}
	}
	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Pago findPagoById(long id) throws Exception {
		try {
			return getPagosDao().findPagoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPagoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Pago</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Pago> findAllPagos() throws Exception {
		try {
			return getPagosDao().findAllPagos();
		} catch (RuntimeException e) {
			throw new Exception("findAllPagos failed: " + e.getMessage());
		}
	}

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Pago> findAllPagosVenta(long ventId) throws Exception {
		try {
			return getPagosDao().findAllPagosVenta(ventId);
		} catch (RuntimeException e) {
			throw new Exception("findAllPagosVenta failed: " + e.getMessage());
		}
	}
	
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPago(Pago pago) throws Exception {
		try {
			getPagosDao().persistPago(pago);
		} catch (RuntimeException e) {
			throw new Exception("persistPago failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removePago(Pago pago) throws Exception {
		try {
			getPagosDao().removePago(pago);
		} catch (RuntimeException e) {
			throw new Exception("removePago failed: " + e.getMessage());
		}
	}
	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Proveedor findProveedorById(long id) throws Exception {
		try {
			return getProveedorDao().findProveedorById(id);
		} catch (RuntimeException e) {
			throw new Exception("findProveedorById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Proveedor</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Proveedor> findAllProveedors() throws Exception {
		try {
			return getProveedorDao().findAllProveedors();
		} catch (RuntimeException e) {
			throw new Exception("findAllProveedors failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistProveedor(Proveedor proveedor) throws Exception {
		try {
			getProveedorDao().persistProveedor(proveedor);
		} catch (RuntimeException e) {
			throw new Exception("persistProveedor failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeProveedor(Proveedor proveedor) throws Exception {
		try {
			getProveedorDao().removeProveedor(proveedor);
		} catch (RuntimeException e) {
			throw new Exception("removeProveedor failed: " + e.getMessage());
		}
	}
	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Vendedor findVendedorById(long id) throws Exception {
		try {
			return getVendedorDao().findVendedorById(id);
		} catch (RuntimeException e) {
			throw new Exception("findVendedorById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Vendedor</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Vendedor> findAllVendedors() throws Exception {
		try {
			return getVendedorDao().findAllVendedors();
		} catch (RuntimeException e) {
			throw new Exception("findAllVendedors failed: " + e.getMessage());
		}
	}

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Vendedor findAllVendedorIdPers(long persId) throws Exception {
		try {
			return getVendedorDao().findAllVendedorIdPers(persId);
		} catch (RuntimeException e) {
			//throw new Exception("findAllVendedorIdPers failed: " + e.getMessage());
			return null;
		}
	}
	
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistVendedor(Vendedor vendedor) throws Exception {
		try {
			getVendedorDao().persistVendedor(vendedor);
		} catch (RuntimeException e) {
			throw new Exception("persistVendedor failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeVendedor(Vendedor vendedor) throws Exception {
		try {
			getVendedorDao().removeVendedor(vendedor);
		} catch (RuntimeException e) {
			throw new Exception("removeVendedor failed: " + e.getMessage());
		}
	}
	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Venta findVentaById(long id) throws Exception {
		try {
			return getVentaDao().findVentaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findVentaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Venta</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Venta> findAllVentas() throws Exception {
		try {
			return getVentaDao().findAllVentas();
		} catch (RuntimeException e) {
			throw new Exception("findAllVentas failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistVenta(Venta venta) throws Exception {
		try {
			getVentaDao().persistVenta(venta);
		} catch (RuntimeException e) {
			throw new Exception("persistVenta failed: " + e.getMessage());
		}
	}
	
	@Transactional
	public long persistVentaId(Venta venta) throws Exception {
		try {
			return getVentaDao().persistVentaId(venta);
		} catch (RuntimeException e) {
			throw new Exception("persistVentaId failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeVenta(Venta venta) throws Exception {
		try {
			getVentaDao().removeVenta(venta);
		} catch (RuntimeException e) {
			throw new Exception("removeVenta failed: " + e.getMessage());
		}
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Archivotabla findArchivotablaById(long id) throws Exception {
		try {
			return getArchivoTablaDao().findArchivotablaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findArchivotablaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Archivotabla</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Archivotabla> findAllArchivotablas() throws Exception {
		try {
			return getArchivoTablaDao().findAllArchivotablas();
		} catch (RuntimeException e) {
			throw new Exception("findAllArchivotablas failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistArchivotabla(Archivotabla archivotabla) throws Exception {
		try {
			getArchivoTablaDao().persistArchivotabla(archivotabla);
		} catch (RuntimeException e) {
			throw new Exception("persistArchivotabla failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeArchivotabla(Archivotabla archivotabla) throws Exception {
		try {
			getArchivoTablaDao().removeArchivotabla(archivotabla);
		} catch (RuntimeException e) {
			throw new Exception("removeArchivotabla failed: " + e.getMessage());
		}
	}
	/**
	 * Consulta el ultimo registro de archivo tabla por desc tabla y idregistro
	 */
	public Archivotabla findArchivotablaByTablaIdRegistro(String tabla, String idRegistro) throws Exception{
		try {
			return getArchivoTablaDao().findArchivotablaByTablaIdRegistro(tabla, idRegistro);
		} catch (RuntimeException e) {
			throw new Exception("findArchivotablaByTablaIdRegistro failed: " + e.getMessage());
		}
	}
	
	/**
	 * Consulta todos los archivos de tabla por desc tabla y idregistro
	 */
	public List<Archivotabla> findAllArchivotablasByTablaIdRegistro(String tabla, String idRegistro) throws Exception{
		try {
			return getArchivoTablaDao().findAllArchivotablasByTablaIdRegistro(tabla, idRegistro);
		} catch (RuntimeException e) {
			throw new Exception("findAllArchivotablasByTablaIdRegistro failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Portafolio findPortafolioById(long id) throws Exception {
		try {
			return getPortafolioDao().findPortafolioById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPortafolioById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Portafolio</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Portafolio> findAllPortafolios() throws Exception {
		try {
			return getPortafolioDao().findAllPortafolios();
		} catch (RuntimeException e) {
			throw new Exception("findAllPortafolios failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPortafolio(Portafolio portafolio) throws Exception {
		try {
			getPortafolioDao().persistPortafolio(portafolio);
		} catch (RuntimeException e) {
			throw new Exception("persistPortafolio failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removePortafolio(Portafolio portafolio) throws Exception {
		try {
			getPortafolioDao().removePortafolio(portafolio);
		} catch (RuntimeException e) {
			throw new Exception("removePortafolio failed: " + e.getMessage());
		}
	}
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Portafoliocategoria findPortafoliocategoriaById(long id) throws Exception {
		try {
			return getPortafolioCategoriaDao().findPortafoliocategoriaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPortafoliocategoriaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Portafoliocategoria</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Portafoliocategoria> findAllPortafoliocategorias() throws Exception {
		try {
			return getPortafolioCategoriaDao().findAllPortafoliocategorias();
		} catch (RuntimeException e) {
			throw new Exception("findAllPortafoliocategorias failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPortafoliocategoria(Portafoliocategoria portafoliocategoria) throws Exception {
		try {
			getPortafolioCategoriaDao().persistPortafoliocategoria(portafoliocategoria);
		} catch (RuntimeException e) {
			throw new Exception("persistPortafoliocategoria failed: " + e.getMessage());
		}
	}
	
	public long persistPortafoliocategoriaId(Portafoliocategoria portafoliocategoria) throws Exception {
		try {
			return getPortafolioCategoriaDao().persistPortafoliocategoriaId(portafoliocategoria);
		} catch (RuntimeException e) {
			throw new Exception("persistPortafoliocategoriaId failed: " + e.getMessage());
		}
	}
	
	/**
	 * Remove the given persistent instance.
	 */
	public void removePortafoliocategoria(Portafoliocategoria portafoliocategoria) throws Exception {
		try {
			getPortafolioCategoriaDao().removePortafoliocategoria(portafoliocategoria);
		} catch (RuntimeException e) {
			throw new Exception("removePortafoliocategoria failed: " + e.getMessage());
		}
	}
	

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipodocumento findTipodocumentoById(java.lang.Integer id) throws Exception {
		try {
			return getTipoDocumentoDao().findTipodocumentoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipodocumentoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipodocumento</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipodocumento> findAllTipodocumentos() throws Exception {
		try {
//			System.out.println("Entra esta parte de implementacion del mentodo: [List<Tipodocumento> findAllTipodocumentos()]!!!!!!!!!!!");
			List<Tipodocumento> lista = getTipoDocumentoDao().findAllTipodocumentos();
			return lista;
		} catch (Exception ee){
			System.out.println("metod de la GestionFacadePortalSpringService !!!!!!!!!!!!!");
			ee.printStackTrace();
		}/* catch (RuntimeException e) {
			throw new Exception("findAllTipodocumentos failed: " + e.getMessage());
		}*/
		return null;
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipodocumento(Tipodocumento tipodocumento) throws Exception {
		try {
			getTipoDocumentoDao().persistTipodocumento(tipodocumento);
		} catch (RuntimeException e) {
			throw new Exception("persistTipodocumento failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipodocumento(Tipodocumento tipodocumento) throws Exception {
		try {
			getTipoDocumentoDao().removeTipodocumento(tipodocumento);
		} catch (RuntimeException e) {
			throw new Exception("removeTipodocumento failed: " + e.getMessage());
		}
	}
	
	//-----------------------------------------------------------------------
	// Persona
	//-----------------------------------------------------------------------
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Persona> findAllPersonasProfesionales(String datoFind) throws Exception {
		try {
			return getPersonaDao().findAllPersonasProfesionales(datoFind);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
			//throw new Exception("findAllPersonasProfesionales failed: " + e.getMessage());
		}
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Persona findPersonaById(java.lang.Long id) throws Exception {
		try {
			return getPersonaDao().findPersonaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPersonaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Persona findPersona(String documento, String abrevTidoc) throws Exception {
		try {
			return getPersonaDao().findPersona(documento, abrevTidoc);
		} catch (RuntimeException e) {
			//throw new Exception("findPersona failed with the documento " + documento + " abrevTidoc " + abrevTidoc + " : " + e.getMessage());
			return null;
		}
	}
	
	/**
	 * Return all persistent instances of the <code>Persona</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Persona> findAllPersonas() throws Exception {
		try {
			return getPersonaDao().findAllPersonas();
		} catch (RuntimeException e) {
			throw new Exception("findAllPersonas failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPersona(Persona persona) throws Exception {
		try {
			getPersonaDao().persistPersona(persona);
		} catch (RuntimeException e) {
			throw new Exception("persistPersona failed: " + e.getMessage());
		}
	}
	
	public long persistPersonaId(Persona persona) throws Exception {
		try {
			return getPersonaDao().persistPersonaId(persona);
		} catch (RuntimeException e) {
			throw new Exception("persistPersonaId failed: " + e.getMessage());
		}
	}
	
	/**
	 * Remove the given persistent instance.
	 */
	public void removePersona(Persona persona) throws Exception {
		try {
			getPersonaDao().removePersona(persona);
		} catch (RuntimeException e) {
			throw new Exception("removePersona failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------------------
	// FIN Persona
	//-----------------------------------------------------------------------
	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Consecutivo findConsecutivoById(long id) throws Exception {
		try {
			return getConsecutivoDao().findConsecutivoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findConsecutivoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Consecutivo</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Consecutivo> findAllConsecutivos() throws Exception {
		try {
			return getConsecutivoDao().findAllConsecutivos();
		} catch (RuntimeException e) {
			throw new Exception("findAllConsecutivos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	@Transactional
	public void persistConsecutivo(Consecutivo consecutivo) throws Exception {
		try {
			getConsecutivoDao().persistConsecutivo(consecutivo);
		} catch (RuntimeException e) {
			throw new Exception("persistConsecutivo failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeConsecutivo(Consecutivo consecutivo) throws Exception {
		try {
			getConsecutivoDao().removeConsecutivo(consecutivo);
		} catch (RuntimeException e) {
			throw new Exception("removeConsecutivo failed: " + e.getMessage());
		}
	}
}