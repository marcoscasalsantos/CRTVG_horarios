package com.plexus.crtvgHorarios.dto.horarios;

import java.util.Date;

import com.plexus.crtvgHorarios.dataAccess.pojo.UnidadHorarioPojo;
import com.plexus.crtvgHorarios.dto.common.BaseDto;
import com.plexus.crtvgHorarios.dto.empleados.EmpleadoDto;

public class ExcepcionHorarioDto extends BaseDto implements Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private Long idExcepcionHorario;
		
	private String descripcionExcepcion;
	
	private String idEstado;
	
	private String descripcionEstado;
	
	private EmpleadoDto sustituto;
	
	private String colorExcepcion;
	
	private Integer codigoEstadoContratoSustituto;	
	
	
	
	
	public ExcepcionHorarioDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExcepcionHorarioDto(UnidadHorarioPojo unidadHorarioPojo) {
		super();
		
		this.setIdExcepcionHorario(unidadHorarioPojo.getIdExcepcionHorario());
		this.setDescripcionEstado(unidadHorarioPojo.getDescripcionEstado());
		this.setDescripcionExcepcion(unidadHorarioPojo.getDescripcionExcepcion());
		this.setSustituto(new EmpleadoDto(unidadHorarioPojo.getIdSustituto(), unidadHorarioPojo.getNombreSustituto(), unidadHorarioPojo.getApellido1Sustituto(), unidadHorarioPojo.getApellido2Sustituto()));
		this.setCodigoEstadoContratoSustituto(unidadHorarioPojo.getEstadoContrato());
		this.setColorExcepcion(unidadHorarioPojo.getColorExcepcion());
		
		// TODO Auto-generated constructor stub
	}

	public Long getIdExcepcionHorario() {
		return idExcepcionHorario;
	}

	public void setIdExcepcionHorario(Long idExcepcionHorario) {
		this.idExcepcionHorario = idExcepcionHorario;
	}


	public String getDescripcionEstado() {
		return descripcionEstado;
	}

	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}

	public EmpleadoDto getSustituto() {
		return sustituto;
	}

	public void setSustituto(EmpleadoDto sustituto) {
		this.sustituto = sustituto;
	}

	public Integer getCodigoEstadoContratoSustituto() {
		return codigoEstadoContratoSustituto;
	}

	public void setCodigoEstadoContratoSustituto(Integer codigoEstadoContratoSustituto) {
		this.codigoEstadoContratoSustituto = codigoEstadoContratoSustituto;
	}

	public String getDescripcionExcepcion() {
		return descripcionExcepcion;
	}

	public void setDescripcionExcepcion(String descripcionExcepcion) {
		this.descripcionExcepcion = descripcionExcepcion;
	}				
		
	public String getColorExcepcion() {
		return colorExcepcion;
	}

	public void setColorExcepcion(String colorExcepcion) {
		this.colorExcepcion = colorExcepcion;
	}

	
	
	public String getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}

	@Override
	public ExcepcionHorarioDto clone() {		
		ExcepcionHorarioDto excepcionHorario = new ExcepcionHorarioDto();
		
		excepcionHorario.setCodigoEstadoContratoSustituto(this.getCodigoEstadoContratoSustituto());
		excepcionHorario.setColorExcepcion(this.getColorExcepcion());
		excepcionHorario.setDescripcionEstado(this.getDescripcionEstado());
		excepcionHorario.setDescripcionExcepcion(this.getDescripcionExcepcion());
		excepcionHorario.setIdEstado(this.getIdEstado());
		excepcionHorario.setIdExcepcionHorario(this.getIdExcepcionHorario());
		
		if (this.getSustituto() != null)
			excepcionHorario.setSustituto(this.getSustituto().clone());
			
				
		return excepcionHorario;
	}	
	
}
