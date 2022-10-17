package ar.edu.unju.fi.poo.tp8.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ventas")
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name="type" )
public abstract class Venta{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "fecha")
	private LocalDate fecha;
	
	@Column(name = "importe")
	private Double importe;
	
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name="venta_id")
	private List<Cuota> cuotas;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "producto_id", referencedColumnName = "id")
	private Producto producto;

  public Venta(Double importe, Producto producto) {
    super();
    this.fecha = LocalDate.now();
    this.importe = importe;
    this.producto = producto;
    this.cuotas = obtenerCuotas(isAhora12(),isContado());
  }
  
  public List<Cuota> obtenerCuotas(Boolean ahora12, Boolean contado) {
    List<Cuota> cuotasGeneradas = new ArrayList<Cuota>();

    if (ahora12) { generar12Cuotas(cuotasGeneradas); }

    if (contado) {
      Cuota cuotaContado = new Cuota(1, this.getImporte());
      cuotasGeneradas.add(cuotaContado);
    }

    return cuotasGeneradas;
  }
  
  public void generar12Cuotas(List<Cuota> cuotas) {
    Double importePorCuota = this.getImporte() / 12;
    Integer numeroCuota = 0;
    for (int i = 0; i < 12; i++) {
      numeroCuota++;
      cuotas.add(new Cuota(numeroCuota, importePorCuota));
     }
  }
  
  public abstract Boolean isContado();

  public abstract Boolean isAhora12();

	public Venta(Double importe2, Producto producto2, Boolean boolean1) {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public List<Cuota> getCuotas() {
		return cuotas;
	}

	public void setCuotas(List<Cuota> cuotas) {
		this.cuotas = cuotas;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
	
	
}
