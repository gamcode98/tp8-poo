package ar.edu.unju.fi.poo.tp8.entity;




import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( value = "Contado" )
public class Contado extends Venta{	

	@Column(name = "descuento")
	private Double descuento;
	
	public Contado(Double importe, Producto producto, Double descuento) {
		super(importe, producto);
		this.descuento = descuento;
	}
	
	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

  @Override
  public Boolean isContado() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public Boolean isAhora12() {
    // TODO Auto-generated method stub
    return false;
  }

	
	

}
