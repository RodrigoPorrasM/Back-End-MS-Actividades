/**
 * Esta clase define Los servicios REST para el objeto Registro de actividades
 * @author: Gonzalo Garcia gonchalo620@gmail.com
 * @version: 21/04/2017/
 */
package com.udea.registro_actividades.servicios;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.udea.registro_actividades.dao.AsignacionesDAO;
import com.udea.registro_actividades.dao.Registro_ActividadesDAO;
import com.udea.registro_actividades.modelo.Asignaciones;
import com.udea.registro_actividades.modelo.Registro_Actividades;

@Controller
public class Registro_ActividadesRestController {

	final static Logger logger = Logger.getLogger(Registro_ActividadesRestController.class);

	@Autowired
	Registro_ActividadesDAO registroActividadesDAO;
	AsignacionesDAO asignacionesDAO;

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	
	/**
	 * @author: Gonzalo Garcia gonchalo620@gmail.com
	 * @version: 03/05/2017/
	 */
	 @RequestMapping("/")
	  @ResponseBody
	  public String index() {
	    return "servicios para registro actividades: /findAll, /findBy?id=, /save, /update ";
	  }
	 
	
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
	 * @param id
	 * @return
	 */
	@RequestMapping("/findBy")
	@ResponseBody
	public Registro_Actividades getRegistroId(Integer id) {
		Registro_Actividades registroActividades = registroActividadesDAO.findById(id);
		logger.info("Registro de Actividad buscado desde la funcion getRegistroId /findBy");
		return registroActividades;
	}
	
	//en proceso, aún no funciona correctamente
	@RequestMapping("/findByAsig")
	@ResponseBody
	public List<Registro_Actividades> getRegistroAsignacion(Integer idAsig) {		
		List<Registro_Actividades> registroActividades = new ArrayList<Registro_Actividades>();
		try{
			//
			Asignaciones asignaciones = new Asignaciones();
			asignaciones = asignacionesDAO.findById(idAsig);
			System.out.println("la asignacion es: "+asignaciones);
			if (asignaciones == null) {
				throw new Exception("no se pudo consultar una asignacion con ese id o no existe");
			}
			
			registroActividades = (List<Registro_Actividades>) registroActividadesDAO.findByAsignaciones(asignaciones);
			logger.info("Registro de Actividades buscados desde la funcion getRegistroAsignacion /findByAsig");
			return registroActividades;

		}catch(Exception ex){
				logger.error("ocurrió una excepción, no se pudo recuperar los registros de actividades buscado por el idAsig, el ERROR ES: " + ex.getMessage());
				return registroActividades;
		}
		
		
		
	
	}

	
	/**
	 * @author: Gonzalo Garcia gonchalo620@gmail.com
	 * @version: 03/05/2017/
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRegistro(Integer id) {
        
        Registro_Actividades registroActividades = registroActividadesDAO.findById(id);
        try{
        	      
        if (registroActividades == null) {
        	//throw new Exception("el registro de actividad que quiere eliminar no existe en la base de datos");
            return new ResponseEntity(new Exception("Unable to delete. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        registroActividadesDAO.delete(registroActividades);
        return new ResponseEntity<Registro_Actividades>(HttpStatus.NO_CONTENT);
        }catch(Exception ex)
        {
        	logger.error("ocurrió una excepción, no se pudo actualizar el registro de actividad, el ERROR ES: " + ex.getMessage());
        	return new ResponseEntity(registroActividades,HttpStatus.NO_CONTENT);
        }
		
    }
	
	/**
	 * @author sigialzate
	 * @param entityReg
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	@ResponseBody
	public String setRegistroActividades(@RequestBody Registro_Actividades entityReg) {

		try{
			registroActividadesDAO.save(entityReg);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			logger.error("ocurrió una excepción ejecutando registroActividadesDAO.save(entityReg) en /save, el registro enviado no se pudo grabar en la base de datos "+ex.getMessage());
			return "ocurrió una excepción ejecutando registroActividadesDAO.save(entityReg) en /save, el registro enviado no se pudo grabar en la base de datos ";
		}
		logger.info("registro de actividad guardado");
		return "!Done";
	}

	

	/**
	 * @author sigialzate
	 * @param entityReg
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
			return "error";
		}
	}

	
}
