package ar.edu.unju.fi.poo.tp8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.poo.tp8.entity.Ahora12;
import ar.edu.unju.fi.poo.tp8.entity.Contado;
import ar.edu.unju.fi.poo.tp8.entity.Producto;
import ar.edu.unju.fi.poo.tp8.service.Ahora12Service;
import ar.edu.unju.fi.poo.tp8.service.ContadoService;
import ar.edu.unju.fi.poo.tp8.service.CuotaService;

@SpringBootTest
public class VentaTests {

  @Autowired
	ContadoService contadoService;

  @Autowired
  Ahora12Service ahora12Service;

  @Autowired
  CuotaService cuotaService;  
	
	static Contado contado;
  
  static Ahora12 ahora12;
  
	static Producto producto1, producto2;
	
	@BeforeEach
	void setUp() throws Exception {
		producto1 = new Producto("1111-aaaa", "Ruedas 4x4", 23000.0);		
		producto2 = new Producto("2222-bbbb", "Ruedas deportivas", 93000.0);		
    ahora12 = new Ahora12(producto1);
    contado = new Contado(producto2);
	}

	@AfterEach
  void tearDown() throws Exception {
    producto1 = null;  
    producto2 = null;
    ahora12 = null;
    contado = null;		
	}
	  
	@Test
	@DisplayName("Guarda una venta de contado")
  void guardarVentaContado() {
    contadoService.agregarVenta(contado);
    Optional<Contado> contadoBuscado = contadoService.buscarVenta(contado);
    assertEquals("2222-bbbb", contadoBuscado.get().getProducto().getCodigo());
    contadoService.eliminarVenta(contado);
    assertTrue(contadoService.buscarVenta(contado).isEmpty());
  }

  @Test
	@DisplayName("Guarda una venta ahora12")
  void guardarVentaAhora12() {
    ahora12Service.agregarVenta(ahora12);
    Optional<Ahora12> ahora12Buscado = ahora12Service.buscarVenta(ahora12);
    assertEquals("1111-aaaa", ahora12Buscado.get().getProducto().getCodigo());
    ahora12Service.eliminarVenta(ahora12);
    assertTrue(ahora12Service.buscarVenta(ahora12).isEmpty());
  }
    
  @Test
  @DisplayName("Pagar una cuota de una venta tipo ahora12")
  void pagarCuotaVentaAhora12() {            
    ahora12Service.agregarVenta(ahora12);            
    cuotaService.pagarCuota(ahora12);
    Optional<Ahora12> ahora12Buscado = ahora12Service.buscarVenta(ahora12);
    assertEquals("1111-aaaa", ahora12Buscado.get().getProducto().getCodigo());
    ahora12Service.eliminarVenta(ahora12);
    assertTrue(ahora12Service.buscarVenta(ahora12).isEmpty()); 
	}
  
}
