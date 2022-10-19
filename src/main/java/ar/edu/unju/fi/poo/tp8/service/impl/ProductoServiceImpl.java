package ar.edu.unju.fi.poo.tp8.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.poo.tp8.entity.Producto;
import ar.edu.unju.fi.poo.tp8.repository.ProductoRepository;
import ar.edu.unju.fi.poo.tp8.service.ProductoService;

@Service("productoServiceImpl")
public class ProductoServiceImpl implements ProductoService {

	private static final Logger logger = Logger.getLogger(ProductoServiceImpl.class);
  
  @Autowired
  private ProductoRepository productoRepository;

  @Override
  public void agregarProducto(Producto producto) {
    logger.info("Se ha agregado un producto: " + producto);
    productoRepository.save(producto);
  }
  
  @Override
  public Producto buscarProducto(Producto producto) {
    logger.info("Se ha buscado el producto: " + producto);
    return productoRepository.findByCodigo(producto.getCodigo());
  }
  
  @Override
  public void modificarProducto(Producto producto) {
    logger.info("Se ha modificado el producto: " + producto);
    productoRepository.save(producto);        
  }
  
  @Override
  public void eliminarProducto(Producto producto) {
    logger.info("Se ha eliminado el producto: " + producto);
    Producto productoBuscado = new Producto();
    productoBuscado = buscarProducto(producto);
    productoRepository.delete(productoBuscado);
  }
   
}
