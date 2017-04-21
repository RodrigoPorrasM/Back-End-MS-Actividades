package com.udea.registro_actividades.dao;


import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import com.udea.registro_actividades.modelo.Registro_Actividades;

//con Spring Data JPA una entidad DAO que extienda de CrudRepository 
// obtiene por defecto los siguientes metodos save, delete, deleteAll, findOne y findAll.
@Transactional
public interface Registro_ActividadesDAO extends CrudRepository<Registro_Actividades, Integer> {
	
	// No es necesario implementar el metodo, spring jpa lo hace  siempre y cuando
	// el nombre del parametro coincida con un atributo de product
	// para mas detalles ver:
	// http://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods.query-creation
	
	
	//public Registro_Actividades findByPk_reg_id(Integer pk_reg_id);

}

