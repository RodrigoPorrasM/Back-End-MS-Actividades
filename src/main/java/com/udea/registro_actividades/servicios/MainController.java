package com.udea.registro_actividades.servicios;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	

  @RequestMapping("/index")
  @ResponseBody
  public String index() {
    return "Microservicios de Registro Actividades ";
  }
  
  @RequestMapping("/saludos")
  public @ResponseBody String saludos(){
      return "Hola";
  }

}