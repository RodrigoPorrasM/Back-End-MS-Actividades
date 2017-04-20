package com.udea.registro_actividades.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;


@Entity
//MYSQL
//@Table(name = "product")

//POSTGRES también me funcionó con la de mysql
@Table( name = "Test", catalog = "", schema = "public" )
public class Registro_Actividades {
	
	@Id
	//TAREA: @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="secuence_name")
	
	//product_seq así llamamos la secuencia en la base de datos en postgresql
	@SequenceGenerator( name = "productSeq", sequenceName = "product_seq", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "productSeq" )
	@Column(name="id")
	private long id;
	
	@NotNull
	private String code;
	
	@NotNull
	private String description;
	
	public Registro_Actividades(){
		
	}
	
	
	public Registro_Actividades(long id, String code, String description) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", description=" + description + "]";
	}	

	
}
