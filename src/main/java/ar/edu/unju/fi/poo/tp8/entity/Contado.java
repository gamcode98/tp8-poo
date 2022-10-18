package ar.edu.unju.fi.poo.tp8.entity;




import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import ar.edu.unju.fi.poo.tp8.util.Util;

@Entity
@DiscriminatorValue( value = "Contado" )
public class Contado extends Venta{	

	@Column(name = "descuento")
	private Double descuento;
	
	public Contado(Double importe, Producto producto) {
		super(importe, producto);
	}
	
	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

  @Override
  public List<Cuota> obtenerCuotas() {
    List<Cuota> cuotasGeneradas = new ArrayList<Cuota>();
    setDescuento(Util.DESCUENTO);
    Double importeCuotaMenosDescuento = this.getImporte() - (this.getImporte() * this.getDescuento());
    Cuota cuotaContado = new Cuota(1, importeCuotaMenosDescuento);
    cuotasGeneradas.add(cuotaContado);
    return cuotasGeneradas;
  }

}
