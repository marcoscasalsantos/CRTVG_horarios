package com.plexus.crtvgHorarios.dto.profesiones;

import java.io.Serializable;

import com.plexus.crtvgHorarios.dto.common.BaseDto;

public class ProfesionDto extends BaseDto implements Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idProfesion;
	private String nombreProfesion;
	
	
	public Long getIdProfesion() {
		return idProfesion;
	}
	public void setIdProfesion(Long idProfesion) {
		this.idProfesion = idProfesion;
	}
	public String getNombreProfesion() {
		return nombreProfesion;
	}
	public void setNombreProfesion(String nombreProfesion) {
		this.nombreProfesion = nombreProfesion;
	}
	
	@Override
	public ProfesionDto clone(){
		
		ProfesionDto profesion = new ProfesionDto();
		
		profesion.setIdProfesion(this.getIdProfesion());
		profesion.setNombreProfesion(this.getNombreProfesion());
		
		return profesion;
		
	}
	
}
