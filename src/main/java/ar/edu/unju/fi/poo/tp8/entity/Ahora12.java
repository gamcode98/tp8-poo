package ar.edu.unju.fi.poo.tp8.entity;




import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import ar.edu.unju.fi.poo.tp8.util.Util;

@Entity
@DiscriminatorValue( value="Ahora12" )
public class Ahora12 extends Venta{
	
	@Column(name = "interes")
	private Double interes;
	
  public Ahora12(Producto producto) {
    super(producto);
  }
  
  public Ahora12() {		
	}

	public Double getInteres() {
		return interes;
	}

	public void setInteres(Double interes) {
		this.interes = interes;
	}
  
  @Override
  public List<Cuota> obtenerCuotas() {
    List<Cuota> cuotasGeneradas = new ArrayList<Cuota>();
    setInteres(Util.INTERES);
    Double importePorCuotaMasInteres = (this.getImporte() + (this.getImporte() * getInteres())) / 12;
    Integer numeroCuota = 0;
    for (int i = 0; i < 12; i++) {
      numeroCuota++;
      cuotasGeneradas.add(new Cuota(numeroCuota, importePorCuotaMasInteres));
    }
    return cuotasGeneradas;
  }	
	
}
