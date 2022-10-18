package ar.edu.unju.fi.poo.tp8.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.poo.tp8.entity.Contado;
import ar.edu.unju.fi.poo.tp8.repository.ContadoRepository;
import ar.edu.unju.fi.poo.tp8.service.ContadoService;

@Service("contadoServiceImpl")
public class ContadoServiceImpl implements ContadoService{
	
	@Autowired
  private ContadoRepository contadoRepository;

	@Override
	public void agregarVenta(Contado contado) { contadoRepository.save(contado); }

  @Override
  public Optional<Contado> buscarVenta(Contado contado) { return contadoRepository.findById(contado.getId()); }

  @Override
  public void eliminarVenta(Contado contado) { contadoRepository.deleteById(contado.getId()); }

}
