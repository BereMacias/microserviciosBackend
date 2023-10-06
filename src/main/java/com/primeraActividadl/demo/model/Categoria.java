package com.primeraActividadl.demo.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="categoria")
public class Categoria {
	
	@Id
	@ApiModelProperty(value = "ID de la categoria")
	private Long id_categoria;
	@ApiModelProperty(value = "Nombre de la categoria del producto")
	private String nombre_categoria;
	@ApiModelProperty(value = "Detalle/descripción de la categoria del producto")
	private String detalle;
	
	public Long getIdCategoria() {
		return id_categoria;
	}
	
	public void setIdCategoria(Long id_categoria) {
		this.id_categoria=id_categoria;
	}
	
	public String getNombreCategoria() {
		return nombre_categoria;
	}
	
	public void setNombreCategoria(String nombre_categoria) {
		this.nombre_categoria=nombre_categoria;
	}
	
	public String getDetalle() {
		return detalle;
	}
	
	public void setDetalle(String detalle) {
		this.detalle=detalle;
	}
	
	

}
