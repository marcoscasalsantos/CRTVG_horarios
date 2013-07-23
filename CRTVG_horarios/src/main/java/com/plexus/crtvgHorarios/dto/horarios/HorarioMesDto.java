package com.plexus.crtvgHorarios.dto.horarios;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.plexus.crtvgHorarios.dto.common.BaseDto;

public class HorarioMesDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	
	private List<HorarioSemanaEmpleadoDto> semanas;


	public HorarioMesDto(List<HorarioSemanaEmpleadoDto> semanas) {
		super();
		this.semanas = semanas;
	}


	public List<HorarioSemanaEmpleadoDto> getSemanas() {
		return semanas;
	}


	public void setSemanas(List<HorarioSemanaEmpleadoDto> semanas) {
		this.semanas = semanas;
	}
	
		
	
}
