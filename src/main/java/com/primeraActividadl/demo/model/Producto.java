package com.primeraActividadl.demo.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="producto")
public class Producto {
	
	@Id
	@ApiModelProperty(value = "ID del producto")
	private Long id_producto;
	@ApiModelProperty(value = "Nombre del producto")
	private String nombre_producto;
	@ApiModelProperty(value = "Precio del producto")
	private double precio;
	@ApiModelProperty(value = "Numero de existencia del producto")
	private int num_existencia;
	@ApiModelProperty(value = "Descripción del producto")
	private String descripcion;
	
	@ManyToOne
	@JoinColumn (name="id_categoria")
	@ApiModelProperty(value = "ID foranea de la categoria a la que pertence el producto")
	private Categoria categoria;
	
	public Long getIdProducto() {
		return id_producto;
	}
	
	public void setIdProducto(Long id_producto) {
		this.id_producto=id_producto;
	}
	
	public String getNombreProducto() {
		return nombre_producto;
	}
	
	public void setNombreProducto(String nombre_producto) {
		this.nombre_producto=nombre_producto;
	}
	
	public double getPrecio(){
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio=precio;
	}
	
	public int getNumExistencia() {
		return num_existencia;
	}
	
	public void setNumExistencia(int num_existencia) {
		this.num_existencia=num_existencia;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}
	
	

}
