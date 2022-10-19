package ar.edu.unju.fi.poo.tp8.service;

import ar.edu.unju.fi.poo.tp8.entity.Producto;

public interface ProductoService {

  public void agregarProducto(Producto producto);

  public Producto buscarProducto(Producto producto);

  public void modificarProducto(Producto producto);

  public void eliminarProducto(Producto producto);
  
}
