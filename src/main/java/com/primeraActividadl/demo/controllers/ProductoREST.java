package com.primeraActividadl.demo.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.primeraActividadl.demo.model.Producto;
import com.primeraActividadl.demo.services.ProductoService;

import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping ("producto")
public class ProductoREST{
	
	@Autowired 
	private ProductoService productoService;
	
	@ApiOperation (value = "Crea todos los productos", notes = "Devuelve un listado con todos los productos "
			+ "que se crearon")
	@PostMapping
	private ResponseEntity<Producto> guardar (@RequestBody Producto producto){
		
		Producto temporal = productoService.create(producto);
		
		try {
			
			return ResponseEntity.created(new URI("/producto"+temporal.getIdProducto())).body(temporal);
			
		}catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@ApiOperation(value = "Busca todos los productos", notes = "Devuelve un listado con todos los productos"
			+ "existentes en la base de datos")
	@GetMapping
	private ResponseEntity<List<Producto>> listarTodosLosProductos(){
		
		return ResponseEntity.ok(productoService.getAllProducto());
		
	}
	
	@ApiOperation (value = "Busca todos los productos por id", notes = "Devuelve un producto dependiendo del"
			+ "Id ingresado")
	@GetMapping(value = "{id}")
	private ResponseEntity<Optional<Producto>> listarProductos (@PathVariable("id") Long id){
		
		return ResponseEntity.ok(productoService.findById(id));
	}
	
	@ApiOperation (value = "Actualiza el produco dependiendo del id ingresado", notes = "Actualiza un producto"
			+ "especifico dependiendo del id ingresado")
	@PutMapping(value = "{id}")
	private ResponseEntity<Producto> actualizarProducto (@RequestBody Producto producto, @PathVariable("id") Long id){
		Producto temporal = productoService.update(producto, id);
		
		try {
			
			return ResponseEntity.created(new URI("/producto"+temporal.getIdProducto())).body(temporal);
			
		}catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	@ApiOperation (value = "Elimina todos los productos", notes = "Elimina los productos existentes en la "
			+ "base de datos")
	@DeleteMapping
	private ResponseEntity<Void> eliminarProducto (@RequestBody Producto producto){
		productoService.delete(producto);
		return ResponseEntity.ok().build();
	}

}
