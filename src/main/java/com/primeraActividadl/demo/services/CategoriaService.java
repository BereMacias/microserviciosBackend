package com.primeraActividadl.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeraActividadl.demo.model.Categoria;
import com.primeraActividadl.demo.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria create (Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public List<Categoria> getAllCategoria (){
		return categoriaRepository.findAll();
	}
	
	public Categoria update(Categoria categoria, Long id) {
		Categoria categoriaprep = this.findById(id).orElse(null);
		
		if (categoriaprep != null) {
			categoriaprep.setNombreCategoria(categoria.getNombreCategoria());
			categoriaprep.setDetalle(categoria.getDetalle());
		}
		
		return categoriaRepository.save(categoriaprep);
	}
	
	public void delete (Categoria categoria) {
		categoriaRepository.delete(categoria);
	}
	
	
	public Optional<Categoria> findById (Long id){
		return categoriaRepository.findById(id);
	}
	
}
