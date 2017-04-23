/**
 * Esta clase define el DAO para el objeto Registro de actividades
 * @author: Gonzalo Garcia gonchalo620@gmail.com
 * @version: 21/04/2017/
 */
package com.udea.registro_actividades.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.udea.registro_actividades.modelo.Registro_Actividades;

//con Spring Data JPA una entidad DAO que extienda de CrudRepository 
// obtiene por defecto los siguientes metodos save, delete, deleteAll, findOne y findAll.
@Transactional
public interface Registro_ActividadesDAO extends CrudRepository<Registro_Actividades, Integer> {

	// No es necesario implementar el metodo, spring jpa lo hace siempre y
	// cuando
	// el nombre del parametro coincida con un atributo de product
	// para mas detalles ver:
	// http://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods.query-creation

	// public Registro_Actividades findByPk_reg_id(Integer pk_reg_id);


	public Registro_Actividades findById(Integer id);

//	public void update(Registro_Actividades entity);

//	Connetion conn = new Connetion();
//	public List<Registro_Actividades> findByToDate (Date dateInicial, Date dateFinal){
//		List<Registro_Actividades> registroList = new ArrayList<Registro_Actividades>();
//		try{
//
//			String query = "SELECT * FROM public.TBL_Registro_Actividades tbl"
//					+ " where tbl.reg_fecha BETWEEN '"+ dateInicial + "'" + " and '" + dateFinal + "'";
//
//			Statement st = conn.createStatement();
//			ResultSet rs = st.executeQuery(sql);
//			
//		}catch (Exception ex){
//			System.out.println(ex.getMessage());
//		}
//		
//		return registroList;
//	}

}
