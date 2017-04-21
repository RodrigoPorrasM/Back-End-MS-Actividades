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


// Save Actividades
// FindId Actividades
// Update Actividades
// Delete Actividad 
// FindDate Rango de fechas de Actividades
// Find Asignacion (Semestre, grupo, usuario)
// Find AsignacionDate (Rango de fechas)