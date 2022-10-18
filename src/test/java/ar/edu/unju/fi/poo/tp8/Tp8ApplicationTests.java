package ar.edu.unju.fi.poo.tp8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.poo.tp8.entity.Ahora12;
import ar.edu.unju.fi.poo.tp8.entity.Contado;
import ar.edu.unju.fi.poo.tp8.entity.Cuota;
import ar.edu.unju.fi.poo.tp8.entity.Producto;
import ar.edu.unju.fi.poo.tp8.repository.ContadoRepository;
import ar.edu.unju.fi.poo.tp8.service.Ahora12Service;
import ar.edu.unju.fi.poo.tp8.service.ContadoService;
import ar.edu.unju.fi.poo.tp8.util.Util;


@SpringBootTest
class Tp8ApplicationTests {
	
	@Autowired
	ContadoService contadoService;
	
	@Autowired 
  ContadoRepository contadoRepository;

  @Autowired
  Ahora12Service ahora12Service;
	
	static Contado contado1, contado2, contado3;
  
  static Ahora12 ahora12Uno;
  
	static Cuota cuota1, cuota2, cuota3;
	
	static Producto producto1, producto2, producto3;
	
	@BeforeEach
	void setUp() throws Exception {
		producto1 = new Producto("1111-aaaa", "Ruedas 4x4", 23000.0);
		// cuota1 = new Cuota(1, 23000.0);
    // contado1 = new Contado(23000.0, producto1, Util.DESCUENTO);
    ahora12Uno = new Ahora12(50000.0, producto1);

    System.out.println("interes -> "+  ahora12Uno.getInteres());
	}

	@AfterEach
	void tearDown() throws Exception {	
		
	}
	
	@Test
	@DisplayName("Guarda una venta de contado")
	void guardarVentaContado() {
      // contadoService.agregarVenta(contado1);
    
      ahora12Service.agregarVenta(ahora12Uno);
		//contadoRepository.save(contado1);
		
	}
	

}
