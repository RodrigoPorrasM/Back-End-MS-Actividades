/**
 * Esta clase define Los servicios REST para el objeto Registro de actividades
 * @author: Gonzalo Garcia gonchalo620@gmail.com
 * @version: 21/04/2017/
 */
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

import com.udea.registro_actividades.dao.ActividadesDAO;
import com.udea.registro_actividades.modelo.Actividades;


@Controller
public class ActividadesRestController {

	final static Logger logger = Logger.getLogger(ActividadesRestController.class);

	@Autowired
	ActividadesDAO actividadesDAO;

	

	/**
	 * @author: Gonzalo Garcia gonchalo620@gmail.com
	 * @version: 21/04/2017/
	 */
	@RequestMapping("/actividades/findAll")
	@ResponseBody
	public List<Actividades> getAllActividades() {
		List<Actividades> actividades = new ArrayList<Actividades>();
		actividades = (List<Actividades>) actividadesDAO.findAll();
		logger.info("todos las Actividades buscadas desde la funcion getAllActividades /Actividades/findAll");
		return actividades;

	}
	
	
	
	@RequestMapping("/actividades/findBy")
	@ResponseBody
	public Actividades getActividad(Integer id) {
		Actividades actividades = actividadesDAO.findById(id);
		return actividades;
	}
	
	
}