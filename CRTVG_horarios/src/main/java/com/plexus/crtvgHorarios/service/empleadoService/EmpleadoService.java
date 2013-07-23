package com.plexus.crtvgHorarios.service.empleadoService;

import java.util.List;

import com.plexus.crtvgHorarios.dto.categorias.CategoriaDto;
import com.plexus.crtvgHorarios.dto.empleados.EmpleadoDto;
import com.plexus.crtvgHorarios.dto.producciones.ProduccionDto;
import com.plexus.crtvgHorarios.dto.secciones.SeccionDto;
import com.plexus.crtvgHorarios.dto.ubicaciones.UbicacionDto;


public interface EmpleadoService {
	
		
	public List<CategoriaDto> getAllCategorias();
	
	public List<SeccionDto> getAllSecciones();

	public List<EmpleadoDto> getAllEmpleados();

	public Integer getAnhoIniHorarios(String idEmpleado);

	public Integer getAnhoFinHorarios(String idEmpleado);

	public List<UbicacionDto> getAllUbicaciones();

	public List<ProduccionDto> getAllProducciones();

	public List<EmpleadoDto> getAllEmpleadosByIdCategoria(String idCategoria);	
	
}