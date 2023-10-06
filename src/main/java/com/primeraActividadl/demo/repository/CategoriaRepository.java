package com.primeraActividadl.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.primeraActividadl.demo.model.Categoria;

public interface CategoriaRepository extends  JpaRepository<Categoria, Long>
{

}
