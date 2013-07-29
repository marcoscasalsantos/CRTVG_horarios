package com.plexus.crtvgHorarios.service.horarioService;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.plexus.crtvgHorarios.dto.empleados.EmpleadoDto;
import com.plexus.crtvgHorarios.dto.horarios.DefinicionHorarioDto;
import com.plexus.crtvgHorarios.dto.horarios.HorarioAnualEmpleadoDto;
import com.plexus.crtvgHorarios.dto.horarios.HorarioMesDto;
import com.plexus.crtvgHorarios.dto.horarios.HorarioSemanaEmpleadoDto;
import com.plexus.crtvgHorarios.dto.horarios.HorarioSemanaUbicacionDto;
import com.plexus.crtvgHorarios.dto.horarios.RangoHorarioDto;


public interface HorarioService {
	
	/**
	 *
	 * @param idSeccion
	 * @param semana
	 * @return Lista de horariosSemanasDtos que contiene los horarios para la categoria y semana indicadas
	 */
	public List<HorarioSemanaUbicacionDto> getHorariosSeccionSemana(Long idSeccion, Date semana);
	
	public HorarioAnualEmpleadoDto getHorarioAnualEmpleado(Integer anho, EmpleadoDto empleado);

	
	/**
	 * Insertar el nuevoRangoHorario en el horarioAnual pero NO LO INSERTA EN BD.
	 * @param nuevoRangoHorario
	 * @param horarioAnual
	 * @return El horarioAnual con la nueva definicionHorario actualizada en los meses correspondientes, también se añade la definicion a horarioAnual.denificionesHorario.
	 */
	public HorarioAnualEmpleadoDto actualizarDefinicionHorario(DefinicionHorarioDto definicionHorario, HorarioAnualEmpleadoDto horarioAnual);

	
	public void saveHorarioAnualEmpleado(HorarioAnualEmpleadoDto horarioAnual, String idEmpleado);
	
}