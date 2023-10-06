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

import com.primeraActividadl.demo.model.Categoria;
import com.primeraActividadl.demo.services.CategoriaService;

import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping ("categoria")
public class CategoriaREST {
	
	@Autowired 
	private CategoriaService categoriaService;
	
	@ApiOperation (value = "Crea todas las categorias", notes = "Devuelve un listado con todas las categorias"
			+ "que se crearon")
	@PostMapping
	private ResponseEntity<Categoria> guardar (@RequestBody Categoria categoria){
		
		Categoria temporal = categoriaService.create(categoria);
		
		try {
			
			return ResponseEntity.created(new URI("/categoria"+temporal.getIdCategoria())).body(temporal);
			
		}catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@ApiOperation(value = "Busca todas los categorias", notes = "Devuelve un listado con todas las categorias"
			+ "existentes en base de datos")
	@GetMapping
	private ResponseEntity<List<Categoria>> listarTodosLosProductos(){
		
		return ResponseEntity.ok(categoriaService.getAllCategoria());
		
	}
	
	@ApiOperation (value = "Busca todas las categorias por id", notes = "Devuelve una categoria dependiendo"
			+ "del Id ingresado")
	@GetMapping(value = "{id}")
	private ResponseEntity<Optional<Categoria>> listarCategorias (@PathVariable("id") Long id){
		
		return ResponseEntity.ok(categoriaService.findById(id));
	}
	
	@ApiOperation (value = "Actualiza categorias dependiendo del id ingresado", notes = "Actualiza una "
			+ "categoria en especifico")
	@PutMapping(value = "{id}")
	private ResponseEntity<Categoria> actualizarCategoria (@RequestBody Categoria categoria, @PathVariable("id") Long id){
		Categoria temporal = categoriaService.update(categoria, id);
		
		try {
			
			return ResponseEntity.created(new URI("/categoria"+temporal.getIdCategoria())).body(temporal);
			
		}catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	@ApiOperation (value = "Elimina todas las categorias", notes = "Elimina las categorias"
			+ "existentes en base de datos")
	@DeleteMapping
	private ResponseEntity<Void> eliminarCategoria (@RequestBody Categoria categoria){
		
		categoriaService.delete(categoria);
		return ResponseEntity.ok().build();
		
	}
	
	
}
