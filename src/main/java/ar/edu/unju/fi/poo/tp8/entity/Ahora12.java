package ar.edu.unju.fi.poo.tp8.entity;




import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( value="Ahora12" )
public class Ahora12 extends Venta{
	
	@Column(name = "interes")
	private Double interes;
	
	public Ahora12(Double importe, Producto producto, Double interes) {
		super(importe, producto);
		this.interes = interes;
	}

	public Double getInteres() {
		return interes;
	}

	public void setInteres(Double interes) {
		this.interes = interes;
	}

  @Override
  public Boolean isContado() {return false;}

  @Override
  public Boolean isAhora12() {return true;}	
	
}
