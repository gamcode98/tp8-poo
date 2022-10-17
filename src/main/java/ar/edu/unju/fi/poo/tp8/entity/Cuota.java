package ar.edu.unju.fi.poo.tp8.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ar.edu.unju.fi.poo.tp8.util.Util;

@Entity
@Table(name = "cuotas")
public class Cuota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "numero_cuota")
	private Integer numeroCuota;
	
	@Column(name = "importe")
	private Double importe;
	
	@Column(name = "estado")
	private String estado;

  public Cuota(Integer numeroCuota, Double importe) {
    super();
    this.numeroCuota = numeroCuota;
    this.importe = importe;
    this.estado = Util.ADEUDADA;
  }  
	
	public Cuota() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumeroCuota() {
		return numeroCuota;
	}

	public void setNumeroCuota(Integer numeroCuota) {
		this.numeroCuota = numeroCuota;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
