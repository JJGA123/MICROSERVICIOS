package com.formaciondbi.springboot.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formaciondbi.springboot.app.productos.models.entity.Producto;
import com.formaciondbi.springboot.app.productos.models.service.IProductoService;

@RestController
public class ProductoController {

	@Autowired
	private Environment env;
	
	@Value("${server.port}")
	private Integer port;
	
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productoService.findAll().stream().map(p ->{
			// Con feign -- p.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			p.setPort(port);
			return p;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto p = productoService.findById(id);
		// Con feign -- p.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		p.setPort(port);
		return p;
	}
}
