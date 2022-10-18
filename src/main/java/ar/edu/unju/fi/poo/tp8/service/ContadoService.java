package ar.edu.unju.fi.poo.tp8.service;

import java.util.Optional;

import ar.edu.unju.fi.poo.tp8.entity.Contado;

public interface ContadoService {
	
  public void agregarVenta(Contado contado);

  public Optional<Contado> buscarVenta(Contado contado);

  public void eliminarVenta(Contado contado);
	
}
