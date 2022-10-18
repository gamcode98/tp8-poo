package ar.edu.unju.fi.poo.tp8.service;

import java.util.Optional;

import ar.edu.unju.fi.poo.tp8.entity.Ahora12;

public interface Ahora12Service {

  public void agregarVenta(Ahora12 ahora12);

  public Optional<Ahora12> buscarVenta(Ahora12 ahora12);

  public void eliminarVenta(Ahora12 ahora12);
  
}
