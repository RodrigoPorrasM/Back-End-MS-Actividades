package com.udea.registro_actividades.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.sql.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;


@Entity
@Table( name = "TBL_Registro_Actividades", catalog = "", schema = "public" )
public class Registro_Actividades {
	
	@Id
	@SequenceGenerator( name = "registroActividadesSeq", sequenceName = "tbl_registro_actividades_seq", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "registroActividadesSeq" )
	@Column(name="PK_reg_id")
	private Integer pk_reg_id;
	
	@Column(name="reg_fecha")
	@NotNull
	private Date reg_fecha;
	
	@Column(name="reg_descripcion")
	@NotNull
	private String reg_descripcion;
	
	@Column(name="reg_horasUtilizadas")
	@NotNull
	private Integer reg_horasUtilizadas;
	
	//Aun no se las foranea como se colocan	
	/*
	@Column(name="FK_act_id")
	@NotNull
	private Integer fk_act_id;
	*/
	@Column(name="FK_asig_id")
	@NotNull
	private Integer fk_asig_id;
	
	//el optional = false es porque este valor no puede ser null, es decir, siempre ha de existir. 
	@ManyToOne(optional=false)
    @JoinColumn(name="FK_act_id")
    private Actividades actividades;
	
	//CONSTRUCTOR 
	public Registro_Actividades(){
		
	}

	public Registro_Actividades(Integer pk_reg_id, Date reg_fecha, String reg_descripcion, Integer reg_horasUtilizadas,
			Integer fk_asig_id, Actividades actividades) {
		super();
		this.pk_reg_id = pk_reg_id;
		this.reg_fecha = reg_fecha;
		this.reg_descripcion = reg_descripcion;
		this.reg_horasUtilizadas = reg_horasUtilizadas;
		this.fk_asig_id = fk_asig_id;
		this.actividades = actividades;
	}

	public Integer getPk_reg_id() {
		return pk_reg_id;
	}

	public void setPk_reg_id(Integer pk_reg_id) {
		this.pk_reg_id = pk_reg_id;
	}

	public Date getReg_fecha() {
		return reg_fecha;
	}

	public void setReg_fecha(Date reg_fecha) {
		this.reg_fecha = reg_fecha;
	}

	public String getReg_descripcion() {
		return reg_descripcion;
	}

	public void setReg_descripcion(String reg_descripcion) {
		this.reg_descripcion = reg_descripcion;
	}

	public Integer getReg_horasUtilizadas() {
		return reg_horasUtilizadas;
	}

	public void setReg_horasUtilizadas(Integer reg_horasUtilizadas) {
		this.reg_horasUtilizadas = reg_horasUtilizadas;
	}

	public Integer getFk_asig_id() {
		return fk_asig_id;
	}

	public void setFk_asig_id(Integer fk_asig_id) {
		this.fk_asig_id = fk_asig_id;
	}

	public Actividades getActividades() {
		return actividades;
	}

	public void setActividades(Actividades actividades) {
		this.actividades = actividades;
	}

	//CONSTRUCTOR CON PARÁMETROS
	
	
	
}