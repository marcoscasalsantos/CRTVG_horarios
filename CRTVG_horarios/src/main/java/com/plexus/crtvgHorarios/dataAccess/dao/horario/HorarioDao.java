package com.plexus.crtvgHorarios.dataAccess.dao.horario;

import java.util.Date;
import java.util.List;

import com.plexus.crtvgHorarios.dataAccess.pojo.DefinicionHorarioPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.UnidadHorarioPojo;
import com.plexus.crtvgHorarios.dto.empleados.EmpleadoDto;
import com.plexus.crtvgHorarios.dto.horarios.DefinicionHorarioDto;


public interface HorarioDao  {
	
	/**
	 * 
	 * @param idSeccion
	 * @param semana
	 * @return la lista de unidadesHorarios para la sección y semana indicada ordenada por ubicación, fecha y hora_desde.
	 */
	public List<UnidadHorarioPojo> getUnidadesHorariosBySeccionSemana(Long idSeccion, Date semana);

	
	/**
	 * 
	 * 
	 * @param mesAnho
	 * @param idEmpleado
	 * @return Todos los dias del mes indicado con los datos (si los hay) de horarios del empleado indicado
	 */
	public List<UnidadHorarioPojo> getUnidadesHorariosByMesAnhoEmpleado(Date mesAnho, String idEmpleado);
	
		
	public void deleteAllUnidadesHorariosAnho(String idEmpleado, Integer anho);
	
	public void insertUnidadesHorarios(List<UnidadHorarioPojo> unidadesHorarias);
	
	
	public void deleteAllDefinicionesHorariosAnho(String idEmpleado, Integer anho);


	public void insertDefinicionesHorarios(List<DefinicionHorarioPojo> definicionesHorarios);


	public List<DefinicionHorarioPojo> getDefinicionesHorarios(String idEmpleado, Integer anho);
		
	
}
