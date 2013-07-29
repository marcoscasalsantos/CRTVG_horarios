package com.plexus.crtvgHorarios.dataAccess.pojo;

import java.util.Date;

import com.plexus.crtvgHorarios.dataAccess.pojo.common.BasePojo;
import com.plexus.crtvgHorarios.dto.empleados.EmpleadoDto;

public class ExcepcionHorarioPojo extends BasePojo {
	
	/**
	 * Cada objeto ExcepcionHorarioPojo contiene la definición de una excepcion del horario  
	 * 	 
	 */
	private static final long serialVersionUID = 1L;
			
	
	private Long idExcepcionHorario;
	
	private String descripcionExcepcion;
	
	private String idEstado;
	
	private String  idSustituto;
	
	private String colorExcepcion;
	
	private Integer codigoEstadoContratoSustituto;

	public Long getIdExcepcionHorario() {
		return idExcepcionHorario;
	}

	public void setIdExcepcionHorario(Long idExcepcionHorario) {
		this.idExcepcionHorario = idExcepcionHorario;
	}

	public String getDescripcionExcepcion() {
		return descripcionExcepcion;
	}

	public void setDescripcionExcepcion(String descripcionExcepcion) {
		this.descripcionExcepcion = descripcionExcepcion;
	}



	public String getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}

	public String getIdSustituto() {
		return idSustituto;
	}

	public void setIdSustituto(String idSustituto) {
		this.idSustituto = idSustituto;
	}

	public String getColorExcepcion() {
		return colorExcepcion;
	}

	public void setColorExcepcion(String colorExcepcion) {
		this.colorExcepcion = colorExcepcion;
	}

	public Integer getCodigoEstadoContratoSustituto() {
		return codigoEstadoContratoSustituto;
	}

	public void setCodigoEstadoContratoSustituto(Integer codigoEstadoContratoSustituto) {
		this.codigoEstadoContratoSustituto = codigoEstadoContratoSustituto;
	}	

	
	
	
}
