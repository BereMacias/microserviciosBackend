package com.primeraActividadl.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeraActividadl.demo.model.Producto;
import com.primeraActividadl.demo.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	
	public Producto create (Producto producto) {
		return productoRepository.save(producto);
	}
	
	public List<Producto> getAllProducto (){
		return productoRepository.findAll();
	}
	
	public Producto update(Producto producto, Long id) {
		Producto productoprep = this.findById(id).orElse(null);
		
		if (productoprep != null) {
			productoprep.setNombreProducto(producto.getNombre_producto());
			productoprep.setPrecio(producto.getPrecio());
			productoprep.setNumExistencia(producto.getNumExistencia());
			productoprep.setDescripcion(producto.getDescripcion());
			productoprep.setCategoria(producto.getCategoria());
		}
		
		return productoRepository.save(productoprep);
	}
	
	public void delete (Producto producto) {
		productoRepository.delete(producto);
	}
	
	public Optional<Producto> findById (Long id){
		return productoRepository.findById(id);
	}

}
