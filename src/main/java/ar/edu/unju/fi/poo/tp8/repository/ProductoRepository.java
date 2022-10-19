package ar.edu.unju.fi.poo.tp8.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.poo.tp8.entity.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

  Producto findByCodigo(String codigo);

}
