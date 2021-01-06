package com.formaciondbi.springboot.app.item.models;

public class Item {
	
	private Producto producto;
	private Integer cantidad;
	
	public Item(Producto producto, Integer cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public double getTotal() {
		return producto.getPrecio()*cantidad.doubleValue();
	}
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
