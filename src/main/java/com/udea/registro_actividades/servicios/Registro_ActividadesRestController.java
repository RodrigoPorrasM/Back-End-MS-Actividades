/**
 * Esta clase define Los servicios REST para el objeto Registro de actividades
 * @author: Gonzalo Garcia gonchalo620@gmail.com
 * @version: 21/04/2017/
 */
package com.udea.registro_actividades.servicios;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.udea.registro_actividades.dao.Registro_ActividadesDAO;
import com.udea.registro_actividades.modelo.Registro_Actividades;

@Controller
public class Registro_ActividadesRestController {

	final static Logger logger = Logger.getLogger(Registro_ActividadesRestController.class);

	@Autowired
	Registro_ActividadesDAO registroActividadesDAO;

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	/*
	 * @RequestMapping("/find")
	 * 
	 * @ResponseBody public Registro_Actividades getRegistroActividades(Integer
	 * pk_reg_id) { Registro_Actividades registroActividades = new
	 * Registro_Actividades(); registroActividades =
	 * registroActividadesDAO.findOne(pk_reg_id); logger.
	 * info("registro de actividade buscado desde la funcion getRegistroActividades /find. Id: "
	 * + pk_reg_id); return registroActividades;
	 * 
	 * }
	 */

	/**
	 * @author: Gonzalo Garcia gonchalo620@gmail.com
	 * @version: 21/04/2017/
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public List<Registro_Actividades> getAllRegistroActividades() {
		List<Registro_Actividades> registroActividades = new ArrayList<Registro_Actividades>();
		registroActividades = (List<Registro_Actividades>) registroActividadesDAO.findAll();
		logger.info("todos los Registro Actividades buscados desde la funcion getAllRegistroActividades /findAll");
		return registroActividades;

	}

	/**
	 * @author sigialzate
	 * @param entityReg
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	@ResponseBody
	public String setRegistroActividades(@RequestBody Registro_Actividades entityReg) {

		try {
			Registro_Actividades regEntity = getRegistro(entityReg.getPk_reg_id());
			if (regEntity == null) {
				registroActividadesDAO.save(entityReg);
				return "!Done";
			} else {
				System.out.println("Ya existe un registro con ese id");
				return "Ya existe un registro con ese id";
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	/**
	 * @author sigialzate
	 * @param id
	 * @return
	 */
	@RequestMapping("/findBy")
	@ResponseBody
	public Registro_Actividades getRegistro(Integer id) {
		Registro_Actividades registroActividades = registroActividadesDAO.findById(id);
		return registroActividades;
	}

	/**
	 * @author sigialzate
	 * @param PK_reg_id
	 * @param reg_fecha
	 * @param reg_descripcion
	 * @param reg_horasUtilizadas
	 * @param fk_asig_id
	 * @param actividades
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/update")
	@ResponseBody
	public String update(@RequestBody Registro_Actividades entityReg) {
		try {
			Registro_Actividades registroActividades = registroActividadesDAO.findById(entityReg.getPk_reg_id());
			if (registroActividades == null) {
				return ("No existe el registro de la actividad");
			} else {
				if (entityReg.getReg_horasUtilizadas() != null) {
					registroActividades.setReg_horasUtilizadas(entityReg.getReg_horasUtilizadas());
				} else {
					System.out.println("No esta registrando horas al momento de actualizar");
				}
				if (entityReg.getReg_descripcion() != null) {
					registroActividades.setReg_descripcion(entityReg.getReg_descripcion());
				} else {
					System.out.println("No esta registrando descripcion al momento de actualizar");
				}
				if (entityReg.getFk_asig_id() != null) {
					registroActividades.setFk_asig_id(entityReg.getFk_asig_id());
				} else {
					System.out.println("No esta registrando asignación al momento de actualizar");
				}
				if (entityReg.getFk_act_id() != null) {
					registroActividades.setFk_act_id(entityReg.getFk_act_id());
				} else {
					System.out.println("No esta registrando actividad al momento de actualizar");
				}
				if (entityReg.getReg_fecha() != null) {
					registroActividades.setReg_fecha(entityReg.getReg_fecha());
				} else {
					System.out.println("No esta registrando fecha al momento de actualizar");
				}

				registroActividadesDAO.save(registroActividades);
				return "Done!";
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	// /**
	// * @author sigialzate
	// * @param dateInicial
	// * @param dateFinal
	// * @return
	// */
	// @RequestMapping("/findByToDate")
	// @ResponseBody
	// public List<Registro_Actividades> findByToDate (Date dateInicial, Date
	// dateFinal){
	//
	// List<Registro_Actividades> registroList = new
	// ArrayList<Registro_Actividades>();
	//
	// registroList = registroActividadesDAO.findByToDate(dateInicial,
	// dateFinal);
	//
	// return registroList;
	//
	// }

	/*
	 * @RequestMapping (method = RequestMethod.POST, value ="/save")
	 * 
	 * @ResponseBody public String setProduct( @RequestBody Registro_Actividades
	 * product) { productDAO.save(product);
	 * logger.info("producto insertado desde la funcion setProduct /save. id: "
	 * + product.getId() + ", codigo: " +
	 * product.getCode()+", descripcion: "+product.getDescription()); return
	 * "producto con código: " + product.getCode()+ " guardado correctamente";
	 * 
	 * }
	 */
}
