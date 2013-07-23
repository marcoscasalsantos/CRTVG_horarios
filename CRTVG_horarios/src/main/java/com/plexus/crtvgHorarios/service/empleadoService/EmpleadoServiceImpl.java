package com.plexus.crtvgHorarios.service.empleadoService;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plexus.crtvgHorarios.dataAccess.dao.empleado.EmpleadoDao;
import com.plexus.crtvgHorarios.dataAccess.pojo.CategoriaPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.EmpleadoPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.ProduccionPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.SeccionPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.UbicacionPojo;
import com.plexus.crtvgHorarios.dto.categorias.CategoriaDto;
import com.plexus.crtvgHorarios.dto.empleados.EmpleadoDto;
import com.plexus.crtvgHorarios.dto.producciones.ProduccionDto;
import com.plexus.crtvgHorarios.dto.secciones.SeccionDto;
import com.plexus.crtvgHorarios.dto.ubicaciones.UbicacionDto;



@Service("empleadoService")
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Resource
	private EmpleadoDao empleadoDao;
	
	@Autowired
	private Mapper mapper;

	public List<CategoriaDto> getAllCategorias() {
		
		List<CategoriaPojo> categoriasPojos = empleadoDao.getAllCategorias(); 
		List<CategoriaDto> categoriasDtos = new ArrayList<CategoriaDto>();
		for (CategoriaPojo categoriaPojo: categoriasPojos) {
			categoriasDtos.add(new CategoriaPojo2CategoriaDto(mapper).transform(categoriaPojo));
		}
				
		return categoriasDtos;
	}

	@Override
	public List<UbicacionDto> getAllUbicaciones() {
		List<UbicacionPojo> ubicacionesPojos = empleadoDao.getAllUbicaciones(); 
		List<UbicacionDto> ubicacionesDtos = new ArrayList<UbicacionDto>();
		for (UbicacionPojo ubicacionPojo: ubicacionesPojos) {
			ubicacionesDtos.add(new UbicacionPojo2UbicacionDto(mapper).transform(ubicacionPojo));
		}
				
		return ubicacionesDtos;
	}	
	


	@Override
	public List<EmpleadoDto> getAllEmpleados() {
				
		List<EmpleadoPojo> empleadosPojos = empleadoDao.getAllEmpleados(); 
		List<EmpleadoDto> empleadosDtos = new ArrayList<EmpleadoDto>();
		for (EmpleadoPojo empleadoPojo: empleadosPojos) {
			empleadosDtos.add(new EmpleadoPojo2EmpleadoDto(mapper).transform(empleadoPojo));
		}
				
		return empleadosDtos;
	}



	@Override
	public Integer getAnhoIniHorarios(String idEmpleado) {		
		return empleadoDao.getAnhoIniHorarios(idEmpleado);
	}



	@Override
	public Integer getAnhoFinHorarios(String idEmpleado) {
		return empleadoDao.getAnhoFinHorarios(idEmpleado);
	}

	@Override
	public List<ProduccionDto> getAllProducciones() {
		List<ProduccionPojo> produccionesPojos = empleadoDao.getAllProducciones(); 
		List<ProduccionDto> produccionesDtos = new ArrayList<ProduccionDto>();
		for (ProduccionPojo produccionPojo: produccionesPojos) {
			produccionesDtos.add(new ProduccionPojo2ProduccionDto(mapper).transform(produccionPojo));
		}
				
		return produccionesDtos;
	}

	@Override
	public List<EmpleadoDto> getAllEmpleadosByIdCategoria(String idCategoria) {
		
		List<EmpleadoPojo> empleadosPojos = empleadoDao.getAllEmpleadosByIdCategoria(idCategoria); 
		List<EmpleadoDto> empleadosDtos = new ArrayList<EmpleadoDto>();
		for (EmpleadoPojo empleadoPojo: empleadosPojos) {
			empleadosDtos.add(new EmpleadoPojo2EmpleadoDto(mapper).transform(empleadoPojo));
		}
				
		return empleadosDtos;
	}

	@Override
	public List<SeccionDto> getAllSecciones() {
		
		List<SeccionPojo> seccionesPojos = empleadoDao.getAllSecciones(); 
		List<SeccionDto> seccionesDtos = new ArrayList<SeccionDto>();
		for (SeccionPojo seccionPojo: seccionesPojos) {
			seccionesDtos.add(new SeccionPojo2SeccionDto(mapper).transform(seccionPojo));
		}
				
		return seccionesDtos;
	}





		

}
