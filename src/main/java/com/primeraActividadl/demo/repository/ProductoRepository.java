package com.primeraActividadl.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.primeraActividadl.demo.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
