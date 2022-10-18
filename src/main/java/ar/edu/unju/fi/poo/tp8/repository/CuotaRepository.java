package ar.edu.unju.fi.poo.tp8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.poo.tp8.entity.Cuota;

@Repository
public interface CuotaRepository extends CrudRepository<Cuota, Long> {
  
String QUERY = "SELECT c FROM Venta v JOIN v.cuotas c WHERE v.id = :ventaId";

@Query(QUERY)
public List<Cuota> findByVenta(@Param("ventaId") Long ventaId);

}
