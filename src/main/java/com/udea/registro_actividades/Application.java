package com.udea.registro_actividades;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
public class Application { 	
	
	// para correc con maven: mvn spring-boot:run
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
}

//se debería utilizar put y no post para actualizaciones
//arreglar formato de fecha en registro de actividades
//arreglar erorr en getRegistroAsignacion() de la clase Registro_ActividadesRestController
//arreglar que cuando se busque por actividades se traiga tambien los registros
//manytomany
//mapear la entidad usuarios y roles


