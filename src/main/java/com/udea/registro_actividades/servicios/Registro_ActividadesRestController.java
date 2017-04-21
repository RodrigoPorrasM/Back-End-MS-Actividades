package com.udea.registro_actividades.servicios;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.udea.registro_actividades.dao.Registro_ActividadesDAO;
import com.udea.registro_actividades.modelo.Registro_Actividades;

@Controller
public class Registro_ActividadesRestController {
	
	final static Logger logger = Logger.getLogger(Registro_ActividadesRestController.class);
	
	@Autowired
	Registro_ActividadesDAO registroActividadesDAO;
	
	
	/*
	@RequestMapping("/find")
	@ResponseBody
	public Registro_Actividades getRegistroActividades(Integer pk_reg_id) {
		Registro_Actividades registroActividades = new Registro_Actividades();
		registroActividades = registroActividadesDAO.findOne(pk_reg_id);
		logger.info("registro de actividade buscado desde la funcion getRegistroActividades /find. Id: " + pk_reg_id);
		return registroActividades;
		
	}*/
	
	@RequestMapping("/findAll")
	@ResponseBody
	public List<Registro_Actividades> getAllRegistroActividades() {
		List<Registro_Actividades> registroActividades = new ArrayList<Registro_Actividades>();
		registroActividades = (List<Registro_Actividades>) registroActividadesDAO.findAll();
		logger.info("todos los Registro Actividades buscados desde la funcion getAllRegistroActividades /findAll");
		return registroActividades;
		
	}
	/*
	@RequestMapping (method = RequestMethod.POST, value ="/save")
	@ResponseBody
	public String setProduct( @RequestBody Registro_Actividades product) {
		productDAO.save(product);
		logger.info("producto insertado desde la funcion setProduct /save. id: " + product.getId() + ", codigo: " + product.getCode()+", descripcion: "+product.getDescription());
		return "producto con código: " + product.getCode()+ " guardado correctamente";
	
	}*/
}