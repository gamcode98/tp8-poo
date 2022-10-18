package ar.edu.unju.fi.poo.tp8.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ar.edu.unju.fi.poo.tp8.entity.Cuota;
import ar.edu.unju.fi.poo.tp8.entity.Venta;
import ar.edu.unju.fi.poo.tp8.repository.CuotaRepository;
import ar.edu.unju.fi.poo.tp8.service.CuotaService;
import ar.edu.unju.fi.poo.tp8.util.Util;

@Service("cuotaServiceImpl")
public class CuotaServiceImpl implements CuotaService {
  
  @Autowired
  private CuotaRepository cuotaRepository;

  @Override
  public void pagarCuota(Venta venta) {

    List<Cuota> cuotas = new ArrayList<Cuota>();    

    cuotas = cuotaRepository.findByVenta(venta.getId());
    
    for (int i = 0; i < cuotas.size(); i++) {    
      Cuota cuota = cuotas.get(i);
      if (cuota.getEstado() != Util.PAGADA) {        
        cuotas.get(i).setEstado(Util.PAGADA);
        break;
      }
    }
    
    cuotaRepository.saveAll(cuotas);
  }
  
}
