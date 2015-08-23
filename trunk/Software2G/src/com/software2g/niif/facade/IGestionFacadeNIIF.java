package com.software2g.niif.facade;

import java.util.List;

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
import com.software2g.vo.Participante;
import com.software2g.vo.Portafolio;
import com.software2g.vo.Portafoliocategoria;
import com.software2g.vo.Persona;
import com.software2g.vo.Proveedor;
import com.software2g.vo.Tipodocumento;
import com.software2g.vo.Vendedor;
import com.software2g.vo.Venta;

/**
 * The service interface for the Articulo entity.
 */
public interface IGestionFacadeNIIF {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Articulo findArticuloById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Articulo</code> entity.
	 */
	public List<Articulo> findAllArticulos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistArticulo(Articulo articulo) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeArticulo(Articulo articulo) throws Exception;
	/**
	 * Service method for named queries
	 */
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Categoria findCategoriaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Categoria</code> entity.
	 */
	public List<Categoria> findAllCategorias() throws Exception;
	public List<Categoria> findAllCategoriasActivas() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistCategoria(Categoria categoria) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeCategoria(Categoria categoria) throws Exception;
	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Cliente findClienteById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Cliente</code> entity.
	 */
	public List<Cliente> findAllClientes() throws Exception;
	public Cliente findAllClienteIdPers(long idPers) throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistCliente(Cliente cliente) throws Exception;
	public long persistClienteId(Cliente cliente) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeCliente(Cliente cliente) throws Exception;

	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Condicionpago findCondicionpagoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Condicionpago</code> entity.
	 */
	public List<Condicionpago> findAllCondicionpagos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistCondicionpago(Condicionpago condicionpago) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeCondicionpago(Condicionpago condicionpago) throws Exception;
	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Detallecompra findDetallecompraById(com.software2g.vo.DetallecompraPK id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Detallecompra</code> entity.
	 */
	public List<Detallecompra> findAllDetallecompras() throws Exception;
	public List<Detallecompra> findAllDetallecompras(long orcoId) throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistDetallecompra(Detallecompra detallecompra) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDetallecompra(Detallecompra detallecompra) throws Exception;
	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Detalleventa findDetalleventaById(com.software2g.vo.DetalleventaPK id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Detalleventa</code> entity.
	 */
	public List<Detalleventa> findAllDetalleventas() throws Exception;
	public List<Detalleventa> findAllDetalleventas(long ventId) throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistDetalleventa(Detalleventa detalleventa) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDetalleventa(Detalleventa detalleventa) throws Exception;
	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Formapago findFormapagoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Formapago</code> entity.
	 */
	public List<Formapago> findAllFormapagos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFormapago(Formapago formapago) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFormapago(Formapago formapago) throws Exception;
	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Ordencompra findOrdencompraById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Ordencompra</code> entity.
	 */
	public List<Ordencompra> findAllOrdencompras() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistOrdencompra(Ordencompra ordencompra) throws Exception;
	public long persistOrdencompraId(Ordencompra ordencompra) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeOrdencompra(Ordencompra ordencompra) throws Exception;
	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Pago findPagoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Pago</code> entity.
	 */
	public List<Pago> findAllPagos() throws Exception;
	public List<Pago> findAllPagosVenta(long ventId) throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPago(Pago pago) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removePago(Pago pago) throws Exception;
	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Proveedor findProveedorById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Proveedor</code> entity.
	 */
	public List<Proveedor> findAllProveedors() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistProveedor(Proveedor proveedor) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeProveedor(Proveedor proveedor) throws Exception;
	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Vendedor findVendedorById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Vendedor</code> entity.
	 */
	public List<Vendedor> findAllVendedors() throws Exception;
	public Vendedor findAllVendedorIdPers(long persId) throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistVendedor(Vendedor vendedor) throws Exception;
	
	/**
	 * Remove the given persistent instance.
	 */
	public void removeVendedor(Vendedor vendedor) throws Exception;
	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Venta findVentaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Venta</code> entity.
	 */
	public List<Venta> findAllVentas() throws Exception;
	public List<Venta> findAllVentasReport() throws Exception;
	public List<Venta> findAllVentas(String fechaMesVenta) throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistVenta(Venta venta) throws Exception;
	public long persistVentaId(Venta venta) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeVenta(Venta venta) throws Exception;
	
	public Tipodocumento findTipodocumentoById(java.lang.Integer id) throws Exception;
	public List<Tipodocumento> findAllTipodocumentos() throws Exception;
	public void persistTipodocumento(Tipodocumento tipodocumento) throws Exception;
	public void removeTipodocumento(Tipodocumento tipodocumento) throws Exception;

	//-----------------------------------------------------------------------
	// Persona
	//-----------------------------------------------------------------------
	public List<Persona> findAllPersonasProfesionales(String datoFind) throws Exception;
	public Persona findPersonaById(java.lang.Long id) throws Exception;
	public Persona findPersona(String documento, String abrevTidoc) throws Exception;
	public List<Persona> findAllPersonas() throws Exception;
	public void persistPersona(Persona persona) throws Exception;
	public long persistPersonaId(Persona persona) throws Exception;
	public void removePersona(Persona persona) throws Exception;
	//-----------------------------------------------------------------------
	// FIN Persona
	//-----------------------------------------------------------------------	

	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Consecutivo findConsecutivoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Consecutivo</code> entity.
	 */
	public List<Consecutivo> findAllConsecutivos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistConsecutivo(Consecutivo consecutivo) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeConsecutivo(Consecutivo consecutivo) throws Exception;
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Archivotabla findArchivotablaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Archivotabla</code> entity.
	 */
	public List<Archivotabla> findAllArchivotablas() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistArchivotabla(Archivotabla archivotabla) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeArchivotabla(Archivotabla archivotabla) throws Exception;
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Portafolio findPortafolioById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Portafolio</code> entity.
	 */
	public List<Portafolio> findAllPortafolios() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPortafolio(Portafolio portafolio) throws Exception;
	public long persistPortafolioId(Portafolio portafolio) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removePortafolio(Portafolio portafolio) throws Exception;
	/**
	 * Consulta el ultimo registro de archivo tabla por desc tabla y idregistro
	 * @param tabla
	 * @param idRegistro
	 * @return
	 * @throws Exception
	 */
	public Archivotabla findArchivotablaByTablaIdRegistro(String tabla, String idRegistro) throws Exception;
	
	/**
	 * Consulta todos los archivos de tabla por desc tabla y idregistro
	 * @param tabla
	 * @param idRegistro
	 * @return
	 * @throws Exception
	 */
	public List<Archivotabla> findAllArchivotablasByTablaIdRegistro(String tabla, String idRegistro) throws Exception;

	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Portafoliocategoria findPortafoliocategoriaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Portafoliocategoria</code> entity.
	 */
	public List<Portafoliocategoria> findAllPortafoliocategorias() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPortafoliocategoria(Portafoliocategoria portafoliocategoria) throws Exception;
	public long persistPortafoliocategoriaId(Portafoliocategoria portafoliocategoria) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removePortafoliocategoria(Portafoliocategoria portafoliocategoria) throws Exception;
	public Portafoliocategoria findCategoriaBackground(String background) throws Exception;
	public List<Portafolio> findAllPortafolioByCatalogoIdRegistro(long idRegistro) throws Exception;
	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Participante findParticipanteById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Participante</code> entity.
	 */
	public List<Participante> findAllParticipantes() throws Exception;
	public List<Participante> findAllParticipantes(long idEvento) throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistParticipante(Participante participante) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeParticipante(Participante participante) throws Exception;
}