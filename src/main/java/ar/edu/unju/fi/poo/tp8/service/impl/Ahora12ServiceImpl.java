package ar.edu.unju.fi.poo.tp8.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.poo.tp8.entity.Ahora12;
import ar.edu.unju.fi.poo.tp8.repository.Ahora12Repository;
import ar.edu.unju.fi.poo.tp8.service.Ahora12Service;

@Service("ahora12ServiceImpl")
public class Ahora12ServiceImpl implements Ahora12Service {
  
  @Autowired
  private Ahora12Repository ahora12Repository;

  @Override
  public void agregarVenta(Ahora12 ahora12) { ahora12Repository.save(ahora12); }

  @Override
  public Optional<Ahora12> buscarVenta(Ahora12 ahora12) { return ahora12Repository.findById(ahora12.getId()); }

  @Override
  public void eliminarVenta(Ahora12 ahora12) { ahora12Repository.deleteById(ahora12.getId()); }
  
}
