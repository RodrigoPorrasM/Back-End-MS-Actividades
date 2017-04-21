/**
 * Esta clase define Los servicios REST para el objeto Registro de actividades
 * @author: Gonzalo Garcia gonchalo620@gmail.com
 * @version: 21/04/2017/
 */
package com.udea.registro_actividades.servicios;

import java.sql.Date;
import java.util.ArrayList;
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
import com.udea.registro_actividades.modelo.Actividades;
import com.udea.registro_actividades.modelo.Registro_Actividades;

@Controller
public class Registro_ActividadesRestController {

	final static Logger logger = Logger.getLogger(Registro_ActividadesRestController.class);

	@Autowired
	Registro_ActividadesDAO registroActividadesDAO;

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
	 * @param reg_fecha
	 * @param reg_descripcion
	 * @param reg_horasUtilizadas
	 * @param fk_asig_id
	 * @param actividades
	 * @return 
	 */
	@RequestMapping (method = RequestMethod.POST, value ="/save")
	@ResponseBody
	public String saveRegistroActividades(@RequestBody Date reg_fecha, String reg_descripcion,
			Integer reg_horasUtilizadas, Integer fk_asig_id, Actividades actividades) {
		
		Registro_Actividades entityRegAct = new Registro_Actividades();
		
		try {
			if (reg_horasUtilizadas != null) {
				entityRegAct.setReg_horasUtilizadas(reg_horasUtilizadas);
			} else {
				entityRegAct.setReg_horasUtilizadas(0);
			}
			if (reg_descripcion != null) {
				entityRegAct.setReg_descripcion(reg_descripcion);
			} else {
				entityRegAct.setReg_descripcion("El docente esta " + actividades.
						getAct_descripcion());
			}
			entityRegAct.setFk_asig_id(fk_asig_id);
			entityRegAct.setActividades(actividades);
			entityRegAct.setReg_fecha(reg_fecha);
			
			registroActividadesDAO.save(entityRegAct);
			return "Done!";

		} catch (Exception ex) {
			ex.getMessage();
			return null;
		}
	}
	
	/**
	 * @author sigialzate
	 * @param PK_reg_id
	 * @return
	 */
	@RequestMapping("/findBy")
	@ResponseBody
	public Registro_Actividades getRegistro(Integer PK_reg_id){
		Registro_Actividades registroActividades = registroActividadesDAO.findById(PK_reg_id);
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
	@RequestMapping (method = RequestMethod.POST, value ="/update")
	@ResponseBody
	public String update (@RequestBody Integer PK_reg_id, Date reg_fecha, String reg_descripcion,
			Integer reg_horasUtilizadas, Integer fk_asig_id, Actividades actividades){
		try {
			Registro_Actividades registroActividades = registroActividadesDAO.findById(PK_reg_id);
			if (reg_horasUtilizadas != null) {
				registroActividades.setReg_horasUtilizadas(reg_horasUtilizadas);
			} else {
				registroActividades.setReg_horasUtilizadas(registroActividades.getReg_horasUtilizadas());
			}
			if (reg_descripcion != null) {
				registroActividades.setReg_descripcion(reg_descripcion);
			} else {
				registroActividades.setReg_descripcion(registroActividades.getReg_descripcion());
			}
			if (fk_asig_id != null){
				registroActividades.setFk_asig_id(fk_asig_id);
			} else {
				registroActividades.setFk_asig_id(registroActividades.getFk_asig_id());
			}
			if (actividades != null){
				registroActividades.setActividades(actividades);
			} else {
				registroActividades.setActividades(registroActividades.getActividades());
			}
			if (reg_fecha != null){
				registroActividades.setReg_fecha(reg_fecha);
			} else {
				registroActividades.setReg_fecha(registroActividades.getReg_fecha());
			}
			
			registroActividadesDAO.update(registroActividades);
			return "Done!";
		} catch(Exception ex) {
			ex.getMessage();
			return null;
		}
	}
	
	
	
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
