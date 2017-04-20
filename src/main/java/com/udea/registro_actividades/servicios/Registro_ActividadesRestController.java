package com.udea.registro_actividades.servicios;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.udea.registro_actividades.dao.Registro_ActividadesDAO;
import com.udea.registro_actividades.modelo.Registro_Actividades;

@Controller
public class Registro_ActividadesRestController {
	
	final static Logger logger = Logger.getLogger(Registro_ActividadesRestController.class);
	
	@Autowired
	Registro_ActividadesDAO productDAO;
	
	@RequestMapping("/find")
	@ResponseBody
	public Registro_Actividades getProduct( String code) {
		Registro_Actividades product = new Registro_Actividades();
		product = productDAO.findByCode(code);
		logger.info("producto buscado desde la funcion getProducto /find. codigo: " + code);
		return product;
		
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public List<Registro_Actividades> getAllProduct() {
		List<Registro_Actividades> product = new ArrayList<Registro_Actividades>();
		product = (List<Registro_Actividades>) productDAO.findAll();
		logger.info("todos los productos buscados desde la funcion getAllProducto /findAll");
		return product;
		
	}
	
	@RequestMapping (method = RequestMethod.POST, value ="/save")
	@ResponseBody
	public String setProduct( @RequestBody Registro_Actividades product) {
		productDAO.save(product);
		logger.info("producto insertado desde la funcion setProduct /save. id: " + product.getId() + ", codigo: " + product.getCode()+", descripcion: "+product.getDescription());
		return "producto con código: " + product.getCode()+ " guardado correctamente";
	
	}
}