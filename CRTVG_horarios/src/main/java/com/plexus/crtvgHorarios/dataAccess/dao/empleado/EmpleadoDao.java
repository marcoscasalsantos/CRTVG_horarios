package com.plexus.crtvgHorarios.dataAccess.dao.empleado;

import java.util.List;

import com.plexus.crtvgHorarios.dataAccess.pojo.CategoriaPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.EmpleadoPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.ProduccionPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.SeccionPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.UbicacionPojo;


public interface EmpleadoDao  {
	
	public List<CategoriaPojo> getAllCategorias();
	
	public List<SeccionPojo> getAllSecciones();

	public List<EmpleadoPojo> getAllEmpleados();

	public Integer getAnhoIniHorarios(String idEmpleado);

	public Integer getAnhoFinHorarios(String idEmpleado);

	public List<UbicacionPojo> getAllUbicaciones();

	public List<ProduccionPojo> getAllProducciones();

	public List<EmpleadoPojo> getAllEmpleadosByIdCategoria(String idCategoria);

}
