package ar.edu.unju.fi.poo.tp8.service.impl;

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
	public void agregarVenta(Contado contado) { contadoRepository.save(contado);}

}
