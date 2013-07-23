package com.plexus.crtvgHorarios.service.horarioService;


import com.plexus.crtvgHorarios.dataAccess.pojo.UnidadHorarioPojo;
import com.plexus.crtvgHorarios.dto.horarios.HorasDiaDto;

public class HorasDiaDto2UnidadHorarioPojo  {
    	
	private HorasDiaDto horasDiaDto;
	
	public HorasDiaDto2UnidadHorarioPojo(HorasDiaDto horasDiaDto) {
		super();
		this.horasDiaDto = horasDiaDto;
	}


	public UnidadHorarioPojo getUnidadHorarioPojo() {
			
		UnidadHorarioPojo unidadHorarioPojo = new UnidadHorarioPojo();
				
		unidadHorarioPojo.setIdHorasDia(horasDiaDto.getIdHorasDia());
		unidadHorarioPojo.setFechaDia(horasDiaDto.getFechaDia());
		
		if (horasDiaDto.getUbicacion() != null)
			unidadHorarioPojo.setIdUbicacion(horasDiaDto.getUbicacion().getIdUbicacion());
		
		unidadHorarioPojo.setIdEmpleado(horasDiaDto.getEmpleado().getIdEmpleado());
		
		if (horasDiaDto.getProduccion() != null)
		unidadHorarioPojo.setIdProduccion(horasDiaDto.getProduccion().getIdProduccion());
		
		unidadHorarioPojo.setHoraDesde(horasDiaDto.getHoraDesde());
		unidadHorarioPojo.setHoraHasta(horasDiaDto.getHoraHasta());
		
		if (horasDiaDto.getEmpleadoSustituto() != null)
			unidadHorarioPojo.setIdSustituto(horasDiaDto.getEmpleadoSustituto().getIdEmpleado());
		
		return unidadHorarioPojo;
	}


	

	
	
	
	
	
    

}
