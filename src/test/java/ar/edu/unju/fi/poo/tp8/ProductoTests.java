package ar.edu.unju.fi.poo.tp8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.poo.tp8.entity.Producto;
import ar.edu.unju.fi.poo.tp8.service.ProductoService;

@SpringBootTest
public class ProductoTests {

  private static final Logger logger = Logger.getLogger(ProductoTests.class);

  @Autowired
  ProductoService productoService;

	static Producto producto1, producto2;

  @BeforeEach
	void setUp() throws Exception {
		producto1 = new Producto("1111-aaaa", "Ruedas 4x4", 23000.0);		
		producto2 = new Producto("2222-bbbb", "Ruedas deportivas", 93000.0);		    
	}

	@AfterEach
  void tearDown() throws Exception {
    producto1 = null;
    producto2 = null;
  }
  
  @Test
	@DisplayName("Guarda un producto")
  void guardarProducto() {
		logger.debug("Iniciando prueba de guardar producto");
    productoService.agregarProducto(producto1);     
    assertEquals("1111-aaaa", productoService.buscarProducto(producto1).getCodigo());
    productoService.eliminarProducto(producto1);
    assertTrue(productoService.buscarProducto(producto1) == null);
  }
  
  @Test
  @DisplayName("Modifica un producto")
  void modificarProducto() {
    logger.debug("Iniciando prueba de modificar producto");
    productoService.agregarProducto(producto2);
    Producto productoBuscado = new Producto();
    productoBuscado = productoService.buscarProducto(producto2);
    assertEquals("2222-bbbb", productoBuscado.getCodigo());
    productoBuscado.setPrecio(240000.0);
    productoService.modificarProducto(productoBuscado);
    assertEquals(240000.0, productoService.buscarProducto(producto2).getPrecio());
    productoService.eliminarProducto(producto2);
    assertTrue(productoService.buscarProducto(producto2) == null);
  }
  
  @Test
  @DisplayName("Elimina un producto")
  void eliminarProducto() {
    logger.debug("Iniciando prueba de eliminar producto");
    productoService.agregarProducto(producto1);
    assertEquals("1111-aaaa", productoService.buscarProducto(producto1).getCodigo());
    productoService.eliminarProducto(producto1);
    assertTrue(productoService.buscarProducto(producto1) == null);
  }
  
}
